package com.harley.dao;

import com.harley.mapper.UserMapper;
import com.harley.pojo.User;
import com.harley.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Date;
import java.util.List;

public class UserMapperTest {
    @Test
    public void testGetAllUser(){
        SqlSession session = MybatisUtils.getSqlSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        List<User> userList = mapper.getAllUser();
        for (User user : userList) {
            System.out.println(user);
        }
        session.close();
    }

    @Test
    public void testGetUserByUserCode(){
        SqlSession session = MybatisUtils.getSqlSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = mapper.getUserByUserCode("wen");
        System.out.println("============================");
        System.out.println(user);
        System.out.println("============================");
        session.close();
    }

    @Test
    public void testUpdatePassword(){
        SqlSession session = MybatisUtils.getSqlSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        int wen = mapper.UpdateUserPwd("wen", "123456");
        System.out.println("更新返回值为："+wen);
        session.commit();
        session.close();
    }

    @Test
    public void testGetUserCount(){
        SqlSession session = MybatisUtils.getSqlSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        int number = mapper.getUserCount(null, null);
        System.out.println(number);
        session.close();
    }

    @Test
    public void testGetUserByNameAndRole(){
        SqlSession session = MybatisUtils.getSqlSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        List<User> userList = mapper.getUserByNameAndRole(null, 0,0,5);
        for (User user : userList) {
            System.out.println(user);
        }
        session.close();
    }

    @Test
    public void testIsUserRoleCodeExist(){
        SqlSession session = MybatisUtils.getSqlSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        int wen = mapper.isUserRoleCodeExist("we1n");
        System.out.println(wen);
        session.close();
    }

    @Test
    public void testGetUserById(){
        SqlSession session = MybatisUtils.getSqlSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = mapper.getUserById(1);
        System.out.println(user);
        session.close();
    }

    @Test
    public void testModifyUser(){
        SqlSession session = MybatisUtils.getSqlSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        int i = mapper.modifyUser(7, "路路", 1, new Date(), "12345678910", "ddd", 1);
        System.out.println(i);
        session.close();
    }
}