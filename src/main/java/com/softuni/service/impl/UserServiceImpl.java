package com.softuni.service.impl;

import com.softuni.model.entity.RoleEnumName;
import com.softuni.model.entity.User;
import com.softuni.model.service.UserServiceModel;
import com.softuni.repository.UserRepository;
import com.softuni.security.CurrentUser;
import com.softuni.service.RoleService;
import com.softuni.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

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
}
