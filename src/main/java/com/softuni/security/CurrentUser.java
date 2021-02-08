package com.softuni.security;

import com.softuni.model.entity.Role;
import com.softuni.model.entity.RoleEnumName;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class CurrentUser {

    private Long id;
    private String username;
    private RoleEnumName roleEnumName;


    public CurrentUser() {
    }

    public Long getId() {
        return id;
    }

    public CurrentUser setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public CurrentUser setUsername(String username) {
        this.username = username;
        return this;
    }

    public boolean isAnonymous() {
        return this.username == null;
    }

    public RoleEnumName getRoleEnumName() {
        return roleEnumName;
    }

    public CurrentUser setRoleEnumName(RoleEnumName roleEnumName) {
        this.roleEnumName = roleEnumName;
        return this;
    }

    public boolean isAdmin() {
        return this.roleEnumName == RoleEnumName.ADMIN;
    }


}
