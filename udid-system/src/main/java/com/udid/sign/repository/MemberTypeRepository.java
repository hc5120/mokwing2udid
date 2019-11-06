package com.udid.sign.repository;

import com.udid.sign.domain.MemberType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author yangwei
 * @date 2019-10-17
 */
public interface MemberTypeRepository extends JpaRepository<MemberType, Long>, JpaSpecificationExecutor {

    /**
     * findByName
     * @param name
     * @return
     */
    MemberType findByName(String name);

}
