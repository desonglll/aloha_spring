package com.sd.aloha_spring.model.mapper;

import com.sd.aloha_spring.model.dto.user_group.PatchRequest;
import com.sd.aloha_spring.model.dto.user_group.PostRequest;
import com.sd.aloha_spring.model.dto.user_group.Response;
import com.sd.aloha_spring.model.entity.UserGroup;
import org.mapstruct.*;

@Mapper
public interface UserGroupMapper {
    Response entityToResponse(UserGroup userGroup);
    @Mapping(target = "id", expression = "java(java.util.UUID.randomUUID())")
    @Mapping(target = "createdAt", expression = "java(java.time.OffsetDateTime.now())")
    @Mapping(target = "updatedAt", expression = "java(java.time.OffsetDateTime.now())")
    UserGroup postRequestToEntity(PostRequest postRequest);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "updatedAt", expression = "java(java.time.OffsetDateTime.now())")
    UserGroup patchRequestToEntity(PatchRequest patchRequest, @MappingTarget UserGroup userGroup);
}
