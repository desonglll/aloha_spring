// UserRoleMapper.java
package com.sd.aloha_spring.model.mapper;

import com.sd.aloha_spring.model.dto.user_role.*;
import com.sd.aloha_spring.model.entity.UserRole;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserRoleMapper {
    @Mapping(target = "id", expression = "java(new com.sd.aloha_spring.model.key.UserRoleId(request.getUserId(), request.getRoleId()))")
    @Mapping(target = "createdAt", expression = "java(java.time.OffsetDateTime.now())")
    @Mapping(target = "updatedAt", expression = "java(java.time.OffsetDateTime.now())")
    UserRole postRequestToEntity(PostUserRoleRequest request);
    @Mapping(target = "userId", source = "id.userId")
    @Mapping(target = "roleId", source = "id.roleId")
    @Mapping(target = "createdAt", source = "createdAt")
    @Mapping(target = "updatedAt", source = "updatedAt")
    UserRoleResponse entityToResponse(UserRole entity);
}
