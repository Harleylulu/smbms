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

    public int getUserCount(@Param("userName") String userName,@Param("userRole") Integer userRole);

    public List<User> getUserByNameAndRole(@Param("userName") String userName,
                                           @Param("userRole") Integer userRole,
                                           @Param("offset") Integer offset,
                                           @Param("pageSize") Integer pageSize);

    public int isUserRoleCodeExist(@Param("userCode") String userCode);

    public int addUser(User user);


}
