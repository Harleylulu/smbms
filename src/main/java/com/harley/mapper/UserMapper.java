package com.harley.mapper;

import com.harley.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    List<User> getAllUser();        //获取全部用户

    User getUserByUserCode(@Param("userCode") String userCode);

}
