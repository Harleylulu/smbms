package com.harley.service;

import com.harley.dao.user.UserDao;
import com.harley.dao.user.UserDaoImpl;
import com.harley.pojo.User;

public class UserServiceImpl implements UserService{

    private UserDao userDao;

    public UserServiceImpl() {
        userDao = new UserDaoImpl();
    }


    public User login(String userCode, String passWord) {
        User user = userDao.getLoginUser(userCode);
        if (user != null && passWord.equals(user.getUserPassword())){
            return user;
        }
        return null;
    }

    public boolean UpdateUserPwd(String userCode, String newPassword) {
        return userDao.UpdateUserPwd(userCode, newPassword) > 0;
    }
}
