package com.udid.quartz.service.dto;

import com.udid.common.annotation.Query;
import lombok.Data;

/**
 * @author yangwei
 * @date 2019-6-4
 */
@Data
public class JobQueryCriteria {

    @Query(type = Query.Type.INNER_LIKE)
    private String jobName;

    @Query
    private Boolean isSuccess;
}
