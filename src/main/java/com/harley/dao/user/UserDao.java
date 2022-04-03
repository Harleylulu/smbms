package com.harley.dao.user;

import com.harley.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface UserDao {
    //�õ���ǰ�û�
    public User getLoginUser(String userCode);

    //�޸��û�����
    public int UpdateUserPwd(String userCode, String newPassword);

    public int getUserCount(String userName, Integer userRole);

    public List<User> getUserByNameAndRole(String userName, Integer userRole,Integer offset,Integer pageSize);

    public int isUserRoleCodeExist(String userCode);

    public int addUser(User user);

    public int delUserById(Integer uid);

    public User getUserById(Integer uid);

    public int modifyUser(Integer id, String userName, Integer gender, Date birthday, String phone, String address, Integer userRole);
}
