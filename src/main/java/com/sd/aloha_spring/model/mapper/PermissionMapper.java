package com.sd.aloha_spring.model.mapper;

import com.sd.aloha_spring.model.dto.permission.PatchRequest;
import com.sd.aloha_spring.model.dto.permission.Response;
import com.sd.aloha_spring.model.dto.permission.PostRequest;
import com.sd.aloha_spring.model.entity.Permission;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface PermissionMapper {

    @Mapping(source = "permissionKey", target = "permissionName")
    Response entityToResponse(Permission permission);

    @Mapping(source = "permissionName", target = "permissionKey")
    @Mapping(target = "id", expression = "java(java.util.UUID.randomUUID())")
    @Mapping(target = "createdAt", expression = "java(java.time.OffsetDateTime.now())")
    @Mapping(target = "updatedAt", expression = "java(java.time.OffsetDateTime.now())")
    Permission postRequestToEntity(PostRequest postRequest);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "permissionName", target = "permissionKey")
    @Mapping(target = "updatedAt", expression = "java(java.time.OffsetDateTime.now())")
    Permission patchRequestToEntity(PatchRequest patchRequest, @MappingTarget Permission permission);
}
