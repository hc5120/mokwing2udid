package com.udid.service.dto;

import com.udid.common.annotation.Query;
import lombok.Data;

/**
 * 日志查询类
 * @author yangwei
 * @date 2019-6-4 09:23:07
 */
@Data
public class LogQueryCriteria {

    // 多字段模糊
    @Query(blurry = "username,description,address,requestIp,method,params")
    private String blurry;

    @Query
    private String logType;
}
