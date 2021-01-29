package com.softuni.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class Role extends BaseEntity{

    private RoleEnumName name;

    public Role() {
    }

    public Role(RoleEnumName name) {
        this.name = name;
    }

    @Enumerated(value = EnumType.STRING)
    public RoleEnumName getName() {
        return name;
    }

    public Role setName(RoleEnumName name) {
        this.name = name;
        return this;
    }
}
