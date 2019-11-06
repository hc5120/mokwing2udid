package com.udid.system.service.mapper;

import com.udid.common.mapper.EntityMapper;
import com.udid.system.domain.User;
import com.udid.system.service.dto.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @author yangwei
 * @date 2018-11-23
 */
@Mapper(componentModel = "spring", uses = {RoleMapper.class}, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper extends EntityMapper<UserDTO, User> {

    /*@Mapping(source = "user.userAvatar.realName",target = "avatar")
    UserDTO toDto(User user);*/
}
