package com.udid.sign.service.dto;

import com.udid.common.annotation.Query;
import lombok.Data;

import java.io.Serializable;

/**
 * @author yangwei
 * @date 2018-11-23
 */
@Data
public class MemberQueryCriteria implements Serializable {

    @Query
    private Long id;

    // 多字段模糊
    @Query(blurry = "email,username")
    private String blurry;

    @Query
    private Boolean enabled;

}
