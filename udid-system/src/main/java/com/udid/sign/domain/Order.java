package com.udid.sign.domain;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @author yangwei
 * @create 2019/10/29
 */
@Data
@Entity
@Table(name = "tb_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String orderCode;

    private Long appId;

    private String appName;

    private Long memberId;

    private String memberName;

    private String payType;

    private int status;

    @CreationTimestamp
    @Column(name = "create_time")
    private Timestamp createTime;
}
