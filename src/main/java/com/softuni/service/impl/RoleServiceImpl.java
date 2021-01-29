package com.softuni.service.impl;

import com.softuni.model.entity.Role;
import com.softuni.model.entity.RoleEnumName;
import com.softuni.repository.RoleRepository;
import com.softuni.service.RoleService;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void initRoles() {
        if (roleRepository.count() == 0){
            Role admin = new Role(RoleEnumName.ADMIN);
            Role user = new Role(RoleEnumName.USER);

            roleRepository.save(admin);
            roleRepository.save(user);
        }

    }

    @Override
    public Role findRole(RoleEnumName roleEnumName) {
        return roleRepository.findByName(roleEnumName).orElse(null);
    }

}
