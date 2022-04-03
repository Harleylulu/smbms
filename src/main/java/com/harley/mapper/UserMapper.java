package com.harley.mapper;

import com.harley.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {

    public List<User> getAllUser();        //获取全部用户

    //获取用户
    public User getUserByUserCode(@Param("userCode") String userCode);

    //修改用户密码
    public int UpdateUserPwd(@Param("userCode") String userCode,@Param("newPassWord") String newPassword);

    public int getUserCount(@Param("userName") String userName,@Param("userRole") Integer userRole);

    public List<User> getUserByNameAndRole(@Param("userName") String userName,
                                           @Param("userRole") Integer userRole,
                                           @Param("offset") Integer offset,
                                           @Param("pageSize") Integer pageSize);

    public int isUserRoleCodeExist(@Param("userCode") String userCode);

    public int addUser(User user);

    public int deleteUserById(@Param("uid") Integer userId);

    @Select("select u.*,r.roleName AS userRoleName from smbms.smbms_user AS u,smbms.smbms_role AS r where u.id = #{uid} AND u.userRole=r.id")
    public User getUserById(@Param("uid") Integer userId);
}
