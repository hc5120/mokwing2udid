package com.udid.sign.service.dto;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @date 2019-10-10
 */
@Data
public class AppDTO implements Serializable {

    private Long id;

    private String name;

    private String appUrl;

    private Boolean enabled;

    private int fileSize;

    private Long uploadPersonId;

    private String uploadPersonName;

    private Timestamp createTime;

    private Timestamp updateTime;
}
