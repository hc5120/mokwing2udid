package com.udid.system.service.dto;

import com.udid.common.annotation.Query;
import lombok.Data;

/**
 * @author yangwei
 * @create 2019/10/30
 */
@Data
public class CommonQueryCriteria {
    @Query
    private Long id;

    @Query(type = Query.Type.INNER_LIKE)
    private String name;
}
