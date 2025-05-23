package com.sd.aloha_spring.model.mapper;

import com.sd.aloha_spring.model.dto.role.PatchRoleRequest;
import com.sd.aloha_spring.model.dto.role.PostRoleRequest;
import com.sd.aloha_spring.model.dto.role.RoleResponse;
import com.sd.aloha_spring.model.entity.Role;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    @Mapping(source = "roleName", target = "roleName")
    RoleResponse entityToResponse(Role role);

    @Mapping(source = "roleName", target = "roleName")
    @Mapping(target = "id", expression = "java(java.util.UUID.randomUUID())")
    @Mapping(target = "createdAt", expression = "java(java.time.OffsetDateTime.now())")
    @Mapping(target = "updatedAt", expression = "java(java.time.OffsetDateTime.now())")
    Role postRequestToEntity(PostRoleRequest postRoleRequest);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "updatedAt", expression = "java(java.time.OffsetDateTime.now())")
    Role patchRequestToEntity(PatchRoleRequest patchRoleRequest, @MappingTarget Role role);
}
