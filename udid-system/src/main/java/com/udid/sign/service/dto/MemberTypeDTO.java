package com.udid.sign.service.dto;

import lombok.Data;

import java.sql.Timestamp;

/**
 * @author yangwei
 * @create 2019/10/30
 */
@Data
public class MemberTypeDTO {

    private Long id;

    private String name;

    private int appSpace;//应用空间

    private int storageTime;//存放时间

    private double discount;//折扣

    private String memo;

    private Timestamp createTime;

}
