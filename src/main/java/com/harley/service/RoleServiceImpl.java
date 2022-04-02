package com.harley.service;

import com.harley.dao.role.RoleDao;
import com.harley.dao.role.RoleDaoImpl;
import com.harley.pojo.Role;

import java.util.List;

public class RoleServiceImpl implements RoleService{
    private RoleDao roleDao;

    public RoleServiceImpl() {
        this.roleDao = new RoleDaoImpl();
    }

    public List<Role> getAllRole() {
        return roleDao.getAllRole();
    }
}
