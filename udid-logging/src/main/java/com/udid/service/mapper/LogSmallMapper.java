package com.udid.service.mapper;

import com.udid.common.mapper.EntityMapper;
import com.udid.service.dto.LogSmallDTO;
import com.udid.domain.Log;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @author yangwei
 * @date 2019-5-22
 */
@Mapper(componentModel = "spring", uses = {}, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface LogSmallMapper extends EntityMapper<LogSmallDTO, Log> {

}
