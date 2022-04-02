package com.harley.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    /* Data in the database */
    private Integer id;      // 用户id

    private String userCode;     // 用户编码

    private String userName;    // 用户名

    private String userPassword;   // 用户密码

    private Integer gender;            // 性别

    private Date birthday;         // 出生日期

    private String phone;    // 电话

    private String address;     // 地址

    private Integer userRole;       // 用户角色

    private Integer createdBy;     // 创建者

    private Date creationDate;  // 创建时间

    private Integer modifyBy;       // 更新者

    private Date modifyDate;    // 更新时间

    /* Dynamically computed data */
    private Integer age;        // 年龄

    private String userRoleName; // 用户角色名称

    public Integer getAge(){
        return age=(new Date().getYear()-birthday.getYear());
    }
}
