package com.sd.aloha_spring.model.mapper;

import com.sd.aloha_spring.model.dto.permission.PatchPermissionRequest;
import com.sd.aloha_spring.model.dto.permission.PermissionResponse;
import com.sd.aloha_spring.model.dto.permission.PostPermissionRequest;
import com.sd.aloha_spring.model.entity.Permission;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface PermissionMapper {

    @Mapping(source = "permissionKey", target = "permissionName")
    PermissionResponse entityToResponse(Permission permission);

    @Mapping(source = "permissionName", target = "permissionKey")
    @Mapping(target = "id", expression = "java(java.util.UUID.randomUUID())")
    @Mapping(target = "createdAt", expression = "java(java.time.OffsetDateTime.now())")
    @Mapping(target = "updatedAt", expression = "java(java.time.OffsetDateTime.now())")
    Permission postRequestToEntity(PostPermissionRequest postPermissionRequest);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "permissionName", target = "permissionKey")
    @Mapping(target = "updatedAt", expression = "java(java.time.OffsetDateTime.now())")
    Permission patchRequestToEntity(PatchPermissionRequest patchPermissionRequest, @MappingTarget Permission permission);
}
