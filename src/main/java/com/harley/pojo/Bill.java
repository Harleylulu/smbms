package com.harley.pojo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class Bill {
    private Integer id;     // �˵�id

    private String billCode;    // �˵�����

    private String productName; // ��Ʒ����

    private String productDesc; // ��Ʒ����

    private String productUnit; // ��Ʒ��λ

    private BigDecimal productCount;    // ��Ʒ����

    private BigDecimal totalPrice;  // �ܽ��

    private Integer isPayment;      // �Ƿ�֧��

    private Integer createdBy;      // ������

    private Date creationDate;      // ����ʱ��

    private Integer modifyBy;       // ������

    private Date modifyDate;        // ����ʱ��

    private Integer providerId;     // ��Ӧ��id
}
