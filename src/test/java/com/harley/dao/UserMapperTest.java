package com.harley.dao;

import com.harley.pojo.User;
import com.harley.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

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
}
