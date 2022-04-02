package com.harley.service;

import com.harley.pojo.User;

import java.util.List;

public interface UserService {
    //�û���½
    public User login(String userCode, String passWord);

    //�޸�����
    public boolean UpdateUserPwd(String userCode, String newPassword);

    public int getUserCount(String userName, Integer userRole);

    public List<User> getUserByNameAndRole(String userName, Integer userRole, Integer currentPage, Integer pageSize);
}
