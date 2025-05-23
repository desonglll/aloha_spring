// RolePermissionMapper.java
package com.sd.aloha_spring.model.mapper;

import com.sd.aloha_spring.model.dto.role_permission.PostRolePermissionRequest;
import com.sd.aloha_spring.model.dto.role_permission.RolePermissionResponse;
import com.sd.aloha_spring.model.dto.user_role.*;
import com.sd.aloha_spring.model.entity.RolePermission;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RolePermissionMapper {
    @Mapping(target = "id", expression = "java(new com.sd.aloha_spring.model.key.RolePermissionId(request.getRoleId(), request.getPermissionId()))")
    @Mapping(target = "createdAt", expression = "java(java.time.OffsetDateTime.now())")
    @Mapping(target = "updatedAt", expression = "java(java.time.OffsetDateTime.now())")
    RolePermission postRequestToEntity(PostRolePermissionRequest request);
    @Mapping(target = "roleId", source = "id.roleId")
    @Mapping(target = "permissionId", source = "id.permissionId")
    @Mapping(target = "createdAt", source = "createdAt")
    @Mapping(target = "updatedAt", source = "updatedAt")
    RolePermissionResponse entityToResponse(RolePermission entity);
}
