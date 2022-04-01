package com.harley.mapper;

import com.harley.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    public List<User> getAllUser();        //��ȡȫ���û�

    //��ȡ�û�
    public User getUserByUserCode(@Param("userCode") String userCode);

    //�޸��û�����
    public int UpdateUserPwd(@Param("userCode") String userCode,@Param("newPassWord") String newPassword);


}
