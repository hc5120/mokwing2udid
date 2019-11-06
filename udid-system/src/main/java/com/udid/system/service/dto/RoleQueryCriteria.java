package com.udid.system.service.dto;

import com.udid.common.annotation.Query;
import lombok.Data;

/**
 * 公共查询类
 */
@Data
public class RoleQueryCriteria {

    // 多字段模糊
    @Query(blurry = "name,memo")
    private String blurry;
}
