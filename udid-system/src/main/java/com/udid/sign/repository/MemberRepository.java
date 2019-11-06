package com.udid.sign.repository;

import com.udid.sign.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;

/**
 * @author yangwei
 * @date 2019-10-17
 */
public interface MemberRepository extends JpaRepository<Member, Long>, JpaSpecificationExecutor {

    /**
     * findByName
     * @param username
     * @return
     */
    Member findByUsername(String username);

    @Modifying
    @Query(value = "update member set password = ?2 , last_password_reset_time = ?3 where username = ?1",nativeQuery = true)
    void updatePass(String username, String pass, Date date);

    @Modifying
    @Query(value = "update member set email = ?2 where username = ?1",nativeQuery = true)
    void updateEmail(String username, String email);
}
