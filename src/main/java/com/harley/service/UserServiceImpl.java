package com.harley.service;

import com.harley.dao.user.UserDao;
import com.harley.dao.user.UserDaoImpl;
import com.harley.pojo.User;

import java.util.Date;
import java.util.List;

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

    public int getUserCount(String userName, Integer userRole) {
        return userDao.getUserCount(userName, userRole);
    }

    /**
     * 1  5   -->   01234   -->   0  5
     * 2  5   -->   56789   -->   5  5
     * 3  5   -->   10...   -->   10 5
     * ....
     * currentPage pageSize-->(currentPage-1)*pageSize pageSize
     */
    public List<User> getUserByNameAndRole(String userName, Integer userRole, Integer currentPage, Integer pageSize) {
       return userDao.getUserByNameAndRole(userName, userRole,(currentPage-1) * pageSize,pageSize);
    }

    public boolean isUserRoleCodeExist(String userCode) {
        return userDao.isUserRoleCodeExist(userCode) != 0;
    }

    public int addUser(User user) {
        user.setCreationDate(new Date());
        return userDao.addUser(user);
    }

    public int delUserById(Integer uid) {
        return userDao.delUserById(uid);
    }

    public User getUserById(Integer uid) {
        return userDao.getUserById(uid);
    }
}
