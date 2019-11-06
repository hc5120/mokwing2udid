package com.udid.sign.repository;

import com.udid.sign.domain.App;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * @author yangwei
 * @date 2019-10-17
 */
public interface AppRepository extends JpaRepository<App, Long>, JpaSpecificationExecutor {
    //查询我的应用
    List<App> findAllByUploadPersonId(Long uploadPersonId);

}
