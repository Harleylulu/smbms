package com.harley.dao.user;

import com.harley.pojo.User;

import java.util.List;

public interface UserDao {
    //得到当前用户
    public User getLoginUser(String userCode);

    //修改用户密码
    public int UpdateUserPwd(String userCode, String newPassword);

}
