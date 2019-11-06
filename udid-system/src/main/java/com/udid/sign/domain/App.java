package com.udid.sign.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @date 2019-10-10
 */
@Entity
@Getter
@Setter
@Table(name = "tb_app")
public class App implements Serializable {

    /**
     * ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /**
     * 名称
     */
    @Column(name = "name", nullable = false)
    @NotBlank
    private String name;


    private String appUrl;

    /**
     * 状态
     */
    @Column(name = "enabled", nullable = false)
    @NotNull
    private Boolean enabled;

    private int fileSize;

    private Long uploadPersonId;

    private String uploadPersonName;

    /**
     * 创建日期
     */
    @Column(name = "create_time")
    @CreationTimestamp
    private Timestamp createTime;

    private Timestamp updateTime;

    public @interface Update {
    }
}
