package com.sd.aloha_spring.model.mapper;

import com.sd.aloha_spring.model.dto.CreatePermissionRequest;
import com.sd.aloha_spring.model.dto.PermissionResponse;
import com.sd.aloha_spring.model.entity.Permission;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PermissionMapper {

    @Mapping(source = "permissionKey", target = "permissionName")
    PermissionResponse permissionToPermissionResponse(Permission permission);

    @Mapping(source = "permissionName", target = "permissionKey")
    Permission createPermissionRequestToPermission(CreatePermissionRequest createPermissionRequest);
}
