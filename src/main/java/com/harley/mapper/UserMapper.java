package com.harley.mapper;

import com.harley.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    List<User> getAllUser();        //��ȡȫ���û�

    User getUserByUserCode(@Param("userCode") String userCode);

}
