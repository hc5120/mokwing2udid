package com.udid.sign.service;

import com.udid.sign.domain.MemberType;
import com.udid.sign.service.dto.MemberQueryCriteria;
import com.udid.sign.service.dto.MemberTypeDTO;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;

/**
 * @author yangwei
 * @date 2018-11-23
 */
@CacheConfig(cacheNames = "membertype")
public interface MemberTypeService {

    /**
     * get
     *
     * @param id
     * @return
     */
    @Cacheable(key = "#p0")
    MemberTypeDTO findById(long id);

    /**
     * create
     *
     * @param resources
     * @return
     */
    @CacheEvict(allEntries = true)
    MemberTypeDTO create(MemberType resources);

    /**
     * update
     *
     * @param resources
     */
    @CacheEvict(allEntries = true)
    void update(MemberType resources);

    /**
     * delete
     *
     * @param id
     */
    @CacheEvict(allEntries = true)
    void delete(Long id);

    @Cacheable
    Object queryAll(MemberQueryCriteria criteria, Pageable pageable);
}
