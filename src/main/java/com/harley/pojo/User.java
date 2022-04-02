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
    private Integer id;      // �û�id

    private String userCode;     // �û�����

    private String userName;    // �û���

    private String userPassword;   // �û�����

    private Integer gender;            // �Ա�

    private Date birthday;         // ��������

    private String phone;    // �绰

    private String address;     // ��ַ

    private Integer userRole;       // �û���ɫ

    private Integer createdBy;     // ������

    private Date creationDate;  // ����ʱ��

    private Integer modifyBy;       // ������

    private Date modifyDate;    // ����ʱ��

    /* Dynamically computed data */
    private Integer age;        // ����

    private String userRoleName; // �û���ɫ����

    public Integer getAge(){
        return age=(new Date().getYear()-birthday.getYear());
    }
}
