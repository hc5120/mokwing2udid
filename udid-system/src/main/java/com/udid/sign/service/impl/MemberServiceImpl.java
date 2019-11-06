package com.udid.sign.service.impl;

import com.udid.common.exception.EntityExistException;
import com.udid.common.utils.PageUtil;
import com.udid.common.utils.QueryHelp;
import com.udid.common.utils.ValidationUtil;
import com.udid.monitor.service.RedisService;
import com.udid.sign.domain.Member;
import com.udid.sign.repository.MemberRepository;
import com.udid.sign.service.MemberService;
import com.udid.sign.service.dto.MemberDTO;
import com.udid.sign.service.dto.MemberQueryCriteria;
import com.udid.sign.service.dto.MemberTypeDTO;
import com.udid.sign.service.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Optional;

/**
 * @author yangwei
 * @create 2019/10/30
 */
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private MemberMapper memberMapper;

    @Autowired
    private RedisService redisService;

    @Override
    public MemberTypeDTO findById(long id) {
        Optional<Member> member = memberRepository.findById(id);
        ValidationUtil.isNull(member, "Member", "id", id);
        return memberMapper.toDto(member.get());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public MemberDTO create(Member resources) {

        if (memberRepository.findByUsername(resources.getUsername()) != null) {
            throw new EntityExistException(Member.class, "username", resources.getUsername());
        }

        // 默认密码 123456，此密码是加密后的字符
        resources.setPassword("e10adc3949ba59abbe56e057f20f883e");
        return memberMapper.toDto(memberRepository.save(resources));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(Member resources) {
        Optional<Member> memberOptional = memberRepository.findById(resources.getId());
        ValidationUtil.isNull(memberOptional, "Member", "id", resources.getId());

        Member member = memberOptional.get();

        Member member1 = memberRepository.findByUsername(member.getUsername());

        if (member1 != null && !member.getId().equals(member1.getId())) {
            throw new EntityExistException(Member.class, "username", resources.getUsername());
        }

        member.setUsername(resources.getUsername());
        member.setEmail(resources.getEmail());
        member.setEnabled(resources.getEnabled());
        member.setPhone(resources.getPhone());
        memberRepository.save(member);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id) {
        memberRepository.deleteById(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updatePass(String username, String pass) {
        memberRepository.updatePass(username, pass, new Date());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateEmail(String username, String email) {
        memberRepository.updateEmail(username, email);
    }

    @Override
    public Object queryAll(MemberQueryCriteria criteria, Pageable pageable) {
        Page<Member> page = memberRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root, criteria, criteriaBuilder), pageable);
        return PageUtil.toPage(page.map(memberMapper::toDto));
    }
}
