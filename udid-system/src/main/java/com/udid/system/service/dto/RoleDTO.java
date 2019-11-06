package com.udid.system.service.dto;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

/**
 * @author yangwei
 * @date 2018-11-23
 */
@Data
public class RoleDTO implements Serializable {

    private Long id;

    private String name;

    private Integer level;

    private String memo;

    private Set<PermissionDTO> permissions;

    private Set<MenuDTO> menus;

    private Timestamp createTime;
}
