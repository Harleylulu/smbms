package com.harley.service;

import com.harley.pojo.User;

public interface UserService {
    //ÓÃ»§µÇÂ½
    public User login(String userCode, String passWord);

    //ĞŞ¸ÄÃÜÂë
    public boolean UpdateUserPwd(String userCode, String newPassword);
}
