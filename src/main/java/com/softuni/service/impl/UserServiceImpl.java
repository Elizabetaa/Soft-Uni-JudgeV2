package com.softuni.service.impl;

import com.softuni.model.entity.Role;
import com.softuni.model.entity.RoleEnumName;
import com.softuni.model.entity.User;
import com.softuni.model.service.UserServiceModel;
import com.softuni.repository.UserRepository;
import com.softuni.security.CurrentUser;
import com.softuni.service.RoleService;
import com.softuni.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final CurrentUser currentUser;
    private final ModelMapper modelMapper;
    private final RoleService roleService;

    public UserServiceImpl(UserRepository userRepository, CurrentUser currentUser, ModelMapper modelMapper, RoleService roleService) {
        this.userRepository = userRepository;
        this.currentUser = currentUser;
        this.modelMapper = modelMapper;
        this.roleService = roleService;

    }

    @Override
    public void registerUser(UserServiceModel userServiceModel) {
        User user = modelMapper.map(userServiceModel, User.class);
        user.setRole(roleService.findRole(RoleEnumName.USER));

        this.userRepository.save(user);
    }

    @Override
    public UserServiceModel findUserByUsernameAndPassword(String username, String password) {
        User user = this.userRepository.findByUsernameAndPassword(username, password).orElse(null);
        if (user == null) {
            return null;
        }
        UserServiceModel userServiceModel = this.modelMapper.map(user, UserServiceModel.class);

        return userServiceModel;
    }

    @Override
    public void login(UserServiceModel user) {
        currentUser.setId(user.getId())
                .setUsername(user.getUsername())
                .setRoleEnumName(user.getRole().getName());

    }

    @Override
    public void logout() {
        this.currentUser.setId(null).setUsername(null).setRoleEnumName(null);
    }

    @Override
    public List<String> getAllUsersNames() {
        return this.userRepository.getAllUsernames();
    }

    @Override
    public void changeRole(String username, RoleEnumName role) {
        User user = this.userRepository.findByUsername(username);
        if (user.getRole().getName() != role){
            user.setRole(roleService.findRole(role));
            this.userRepository.save(user);
        }
    }

    @Override
    public UserServiceModel findByUsername(String username) {
        User user =this.userRepository.findByUsername(username);

        return this.modelMapper.map(user,UserServiceModel.class);
    }

    @Override
    public User findById(Long id) {
        return this.userRepository.findById(id).orElse(null);
    }
}
