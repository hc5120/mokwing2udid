package com.udid.sign.service;

import com.udid.sign.domain.App;
import com.udid.sign.service.dto.AppDTO;
import com.udid.system.service.dto.CommonQueryCriteria;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;

/**
 * @author yangwei
 * @date 2018-11-23
 */
@CacheConfig(cacheNames = "app")
public interface AppService {

    /**
     * get
     *
     * @param id
     * @return
     */
    @Cacheable(key = "#p0")
    AppDTO findById(long id);

    /**
     * create
     *
     * @param resources
     * @return
     */
    @CacheEvict(allEntries = true)
    AppDTO create(App resources);

    /**
     * delete
     *
     * @param id
     */
    @CacheEvict(allEntries = true)
    void delete(Long id);


    @Cacheable
    Object queryAll(CommonQueryCriteria criteria, Pageable pageable);

}
