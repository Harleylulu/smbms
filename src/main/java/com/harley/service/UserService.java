package com.harley.service;

import com.harley.pojo.User;

import java.util.List;

public interface UserService {
    //ÓÃ»§µÇÂ½
    public User login(String userCode, String passWord);

    //ĞŞ¸ÄÃÜÂë
    public boolean UpdateUserPwd(String userCode, String newPassword);

    public int getUserCount(String userName, Integer userRole);

    public List<User> getUserByNameAndRole(String userName, Integer userRole, Integer currentPage, Integer pageSize);

    public boolean isUserRoleCodeExist(String userCode);

    public int addUser(User user);

    public int delUserById(Integer uid);

    public User getUserById(Integer uid);
}
