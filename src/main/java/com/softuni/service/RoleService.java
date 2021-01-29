package com.softuni.service;

import com.softuni.model.entity.Role;
import com.softuni.model.entity.RoleEnumName;

public interface RoleService {
    void initRoles();

    Role findRole(RoleEnumName roleEnumName);

}
