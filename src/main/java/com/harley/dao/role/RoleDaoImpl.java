package com.harley.dao.role;

import com.harley.mapper.RoleMapper;
import com.harley.pojo.Role;
import com.harley.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class RoleDaoImpl implements RoleDao{
    public List<Role> getAllRole() {
        SqlSession session = MybatisUtils.getSqlSession();
        try {
            return session.getMapper(RoleMapper.class).getAllRole();
        } finally {
            session.close();
        }
    }
}
