package com.harley.dao.user;

import com.harley.pojo.User;

import java.util.List;

public interface UserDao {
    //�õ���ǰ�û�
    public User getLoginUser(String userCode);

    //�޸��û�����
    public int UpdateUserPwd(String userCode, String newPassword);

}
