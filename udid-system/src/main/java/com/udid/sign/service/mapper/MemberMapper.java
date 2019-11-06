package com.udid.sign.service.mapper;

import com.udid.common.mapper.EntityMapper;
import com.udid.sign.domain.Member;
import com.udid.sign.service.dto.MemberDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @author yangwei
 * @date 2018-11-23
 */
@Mapper(componentModel = "spring", uses = {MemberTypeMapper.class}, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MemberMapper extends EntityMapper<MemberDTO, Member> {

}
