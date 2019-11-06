package com.udid.sign.service.dto;

import lombok.Data;

import java.sql.Timestamp;

/**
 * @author yangwei
 * @create 2019/10/29
 */
@Data
public class OrderDTO {

    private Long id;

    private String orderCode;

    private Long appId;

    private String appName;

    private Long memberId;

    private String memberName;

    private String payType;

    private int status;

    private Timestamp createTime;
}
