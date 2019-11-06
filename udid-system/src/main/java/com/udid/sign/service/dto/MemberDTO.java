package com.udid.sign.service.dto;

import com.udid.sign.domain.MemberType;
import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;

/**
 * @author yangwei
 * @create 2019/10/30
 */
@Data
public class MemberDTO {
    private Long id;

    private String username;

    private String email;

    private String phone;

    private Boolean enabled;

    private String password;

    private String promotionLinks;//推广链接

    private String diyUrl;//自定义域名

    private Double rebate;//返利

    private Timestamp createTime;

    private Date lastPasswordResetTime;

    private MemberType memberType;
}
