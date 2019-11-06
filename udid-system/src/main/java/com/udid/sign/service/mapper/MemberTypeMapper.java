package com.udid.sign.service.mapper;

import com.udid.common.mapper.EntityMapper;
import com.udid.sign.domain.MemberType;
import com.udid.sign.service.dto.MemberTypeDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @author yangwei
 * @date 2018-11-23
 */
@Mapper(componentModel = "spring", uses = {}, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MemberTypeMapper extends EntityMapper<MemberTypeDTO, MemberType> {

}
