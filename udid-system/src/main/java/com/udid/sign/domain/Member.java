package com.udid.sign.domain;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.sql.Timestamp;
import java.util.Date;

/**
 * @author yangwei
 * @create 2019/10/30
 */
@Entity
@Data
@Table(name = "tb_member")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(length = 20)
    private String username;

    @NotBlank
    @Column(length = 50)
    @Pattern(regexp = "([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}", message = "格式错误")
    private String email;

    @NotBlank
    @Column(length = 20)
    private String phone;

    @NotNull
    @Column(length = 20)
    private Boolean enabled;

    @Column(length = 20)
    private String password;

    private String promotionLinks;//推广链接

    private String diyUrl;//自定义域名

    private Double rebate;//返利

    @CreationTimestamp
    @Column(name = "create_time", length = 50)
    private Timestamp createTime;

    @Column(name = "last_password_reset_time", length = 50)
    private Date lastPasswordResetTime;

    @ManyToOne
    @JoinColumn(name = "member_type_id")
    private MemberType memberType;
}
