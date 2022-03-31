package com.harley.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class Provider {
    private Integer id;     //��Ӧ��id

    private String proCode; //��Ӧ�̱���

    private String proName; //��Ӧ������

    private String proDesc; //��Ӧ������

    private String proContact;//��Ӧ����ϵ��

    private String proPhone;    //��Ӧ�̵绰

    private String proAddress;  //��Ӧ�̵�ַ

    private String proFax;      //��Ӧ�̴���

    private Integer createBy;   //������

    private Date creationDate;  //����ʱ��

    private Date modifyDate; //����ʱ��

    private Integer modifyBy;  //������
}
