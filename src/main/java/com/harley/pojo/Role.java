package com.harley.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class Role {
    private Integer id;     //��ɫid

    private String roleCode;    //��ɫ����

    private String roleName;    //��ɫ����

    private Integer createdBy;  //������

    private Date creationDate;  //����ʱ��

    private Integer modifyBy;   //������

    private Date modifyDate;    //����ʱ��
}
