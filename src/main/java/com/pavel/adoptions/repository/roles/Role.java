package com.pavel.adoptions.repository.roles;

import com.pavel.adoptions.model.roles.RolesEnum;

import javax.persistence.*;

@Entity
public class Role
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Enumerated(EnumType.STRING)
    private RolesEnum role;

    public Integer getId()
    {
        return id;
    }

    public Role setId(Integer id)
    {
        this.id = id;
        return this;
    }

    public RolesEnum getRole()
    {
        return role;
    }

    public Role setRole(RolesEnum role)
    {
        this.role = role;
        return this;
    }
}
