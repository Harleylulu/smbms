package com.harley.dao.user;

import com.harley.pojo.User;

import java.util.List;

public interface UserDao {
    public User getLoginUser(String userCode);
}
