package com.sd.aloha_spring.model.mapper;

import com.sd.aloha_spring.model.dto.role.PatchRequest;
import com.sd.aloha_spring.model.dto.role.PostRequest;
import com.sd.aloha_spring.model.dto.role.Response;
import com.sd.aloha_spring.model.entity.Role;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    @Mapping(source = "roleName", target = "roleName")
    Response entityToResponse(Role role);

    @Mapping(source = "roleName", target = "roleName")
    @Mapping(target = "id", expression = "java(java.util.UUID.randomUUID())")
    @Mapping(target = "createdAt", expression = "java(java.time.OffsetDateTime.now())")
    @Mapping(target = "updatedAt", expression = "java(java.time.OffsetDateTime.now())")
    Role postRequestToEntity(PostRequest postRequest);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "updatedAt", expression = "java(java.time.OffsetDateTime.now())")
    Role patchRequestToEntity(PatchRequest patchRequest, @MappingTarget Role role);
}
