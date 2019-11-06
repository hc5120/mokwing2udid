package com.udid.system.domain.vo;

import lombok.Data;

/**
 * 修改密码的 Vo 类
 * @author yangwei
 * @date 2019-07-11
 */
@Data
public class UserPassVo {

    private String oldPass;

    private String newPass;
}
