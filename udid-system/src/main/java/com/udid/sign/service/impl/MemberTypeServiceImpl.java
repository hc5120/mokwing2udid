package com.udid.sign.service.impl;

import com.udid.common.exception.EntityExistException;
import com.udid.common.utils.PageUtil;
import com.udid.common.utils.QueryHelp;
import com.udid.common.utils.ValidationUtil;
import com.udid.monitor.service.RedisService;
import com.udid.sign.domain.MemberType;
import com.udid.sign.repository.MemberTypeRepository;
import com.udid.sign.service.MemberTypeService;
import com.udid.sign.service.dto.MemberQueryCriteria;
import com.udid.sign.service.dto.MemberTypeDTO;
import com.udid.sign.service.mapper.MemberTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * @author yangwei
 * @create 2019/10/30
 */
public class MemberTypeServiceImpl implements MemberTypeService {

    @Autowired
    private MemberTypeRepository memberTypeRepository;

    @Autowired
    private MemberTypeMapper memberTypeMapper;

    @Autowired
    private RedisService redisService;

    @Override
    public MemberTypeDTO findById(long id) {
        Optional<MemberType> memberType = memberTypeRepository.findById(id);
        ValidationUtil.isNull(memberType, "MemberType", "id", id);
        return memberTypeMapper.toDto(memberType.get());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public MemberTypeDTO create(MemberType resources) {

        return memberTypeMapper.toDto(memberTypeRepository.save(resources));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(MemberType resources) {
        Optional<MemberType> memberOptional = memberTypeRepository.findById(resources.getId());
        ValidationUtil.isNull(memberOptional, "MemberType", "id", resources.getId());

        MemberType memberType = memberOptional.get();

        MemberType member1 = memberTypeRepository.findByName(memberType.getName());

        if (member1 != null && !memberType.getId().equals(member1.getId())) {
            throw new EntityExistException(MemberType.class, "name", resources.getName());
        }

        memberTypeRepository.save(memberType);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id) {
        memberTypeRepository.deleteById(id);
    }


    @Override
    public Object queryAll(MemberQueryCriteria criteria, Pageable pageable) {
        Page<MemberType> page = memberTypeRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root, criteria, criteriaBuilder), pageable);
        return PageUtil.toPage(page.map(memberTypeMapper::toDto));
    }
}
