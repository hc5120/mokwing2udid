package com.udid.sign.domain;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.sql.Timestamp;

/**
 * @author yangwei
 * @create 2019/10/30
 */
@Entity
@Data
@Table(name = "tb_member_type")
public class MemberType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false, length = 50)
    private String name;

    private int appSpace;//应用空间

    private int storageTime;//存放时间

    private double discount;//折扣

    @Column
    private String memo;

    @CreationTimestamp
    @Column(name = "create_time")
    private Timestamp createTime;

}
