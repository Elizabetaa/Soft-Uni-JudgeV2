package com.softuni.service;


import com.softuni.model.entity.RoleEnumName;
import com.softuni.model.entity.User;
import com.softuni.model.service.UserServiceModel;

import java.util.List;

public interface UserService {
    void registerUser(UserServiceModel userServiceModel);

    UserServiceModel findUserByUsernameAndPassword(String username, String password);

    void login(UserServiceModel user);

    void logout();

    List<String> getAllUsersNames();

    void changeRole(String username, RoleEnumName valueOf);

    UserServiceModel findByUsername(String username);

    User findById(Long id);
}
