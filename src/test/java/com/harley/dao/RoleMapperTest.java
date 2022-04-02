package com.harley.dao;

import com.harley.mapper.RoleMapper;
import com.harley.pojo.Role;
import com.harley.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class RoleMapperTest {
    @Test
    public void test(){
        SqlSession session = MybatisUtils.getSqlSession();
        RoleMapper mapper = session.getMapper(RoleMapper.class);
        List<Role> list = mapper.getAllRole();
        for (Role role : list) {
            System.out.println(role);
        }
        session.close();
    }
}
