package com.harley.mapper;

import com.harley.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    public List<User> getAllUser();        //获取全部用户

    //获取用户
    public User getUserByUserCode(@Param("userCode") String userCode);

    //修改用户密码
    public int UpdateUserPwd(@Param("userCode") String userCode,@Param("newPassWord") String newPassword);


}
