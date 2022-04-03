package com.harley.dao.user;

import com.harley.mapper.UserMapper;
import com.harley.pojo.User;
import com.harley.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.Date;
import java.util.List;

public class UserDaoImpl implements UserDao{

    public User getLoginUser(String userCode) {
        SqlSession session = MybatisUtils.getSqlSession();
        try{
            return session.getMapper(UserMapper.class).getUserByUserCode(userCode);
        } finally {
            session.close();
        }
    }

    public int UpdateUserPwd(String userCode, String newPassword) {
        SqlSession session = MybatisUtils.getSqlSession();
        try {
            return session.getMapper(UserMapper.class).UpdateUserPwd(userCode, newPassword);
        } finally {
            session.commit();
            session.close();
        }
    }

    public int getUserCount(String userName, Integer userRole) {
        SqlSession session = MybatisUtils.getSqlSession();
        try {
            return session.getMapper(UserMapper.class).getUserCount(userName, userRole);
        } finally {
            session.close();
        }
    }

    public List<User> getUserByNameAndRole(String userName, Integer userRole, Integer offset, Integer pageSize) {
        SqlSession session = MybatisUtils.getSqlSession();
        try {
            return session.getMapper(UserMapper.class).getUserByNameAndRole(userName, userRole, offset, pageSize);
        } finally {
            session.close();
        }
    }

    public int isUserRoleCodeExist(String userCode) {
        SqlSession session = MybatisUtils.getSqlSession();
        try {
            return session.getMapper(UserMapper.class).isUserRoleCodeExist(userCode);
        } finally {
            session.close();
        }
    }

    public int addUser(User user) {
        SqlSession session = MybatisUtils.getSqlSession();
        try {
            return session.getMapper(UserMapper.class).addUser(user);
        } finally {
            session.commit();
            session.close();
        }
    }

    public int delUserById(Integer uid) {
        SqlSession session = MybatisUtils.getSqlSession();
        try {
            return session.getMapper(UserMapper.class).deleteUserById(uid);
        } finally {
            session.commit();
            session.close();
        }
    }

    public User getUserById(Integer uid) {
        SqlSession session = MybatisUtils.getSqlSession();
        try {
            return session.getMapper(UserMapper.class).getUserById(uid);
        } finally {
            session.close();
        }
    }

    public int modifyUser(Integer id, String userName, Integer gender, Date birthday, String phone, String address, Integer userRole) {
        SqlSession session = MybatisUtils.getSqlSession();
        try {
            return session.getMapper(UserMapper.class).modifyUser(id, userName, gender, birthday, phone, address, userRole);
        } finally {
            session.commit();
            session.close();
        }
    }
}
