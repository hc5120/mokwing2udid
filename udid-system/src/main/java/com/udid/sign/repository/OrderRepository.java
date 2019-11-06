package com.udid.sign.repository;

import com.udid.sign.domain.Member;
import com.udid.sign.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * @author yangwei
 * @date 2019-10-17
 */
public interface OrderRepository extends JpaRepository<Order, Long>, JpaSpecificationExecutor {

}
