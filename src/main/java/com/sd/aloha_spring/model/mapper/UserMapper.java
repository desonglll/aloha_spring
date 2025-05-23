package com.sd.aloha_spring.model.mapper;

import com.sd.aloha_spring.model.dto.user.PatchRequest;
import com.sd.aloha_spring.model.dto.user.PostRequest;
import com.sd.aloha_spring.model.dto.user.Response;
import com.sd.aloha_spring.model.entity.User;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface UserMapper {
    Response entityToResponse(User user);

    @Mapping(target = "id", expression = "java(java.util.UUID.randomUUID())")
    @Mapping(target = "createdAt", expression = "java(java.time.OffsetDateTime.now())")
    @Mapping(target = "updatedAt", expression = "java(java.time.OffsetDateTime.now())")
    @Mapping(target = "enabled", expression = "java(false)")
    User postRequestToEntity(PostRequest postRequest);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "updatedAt", expression = "java(java.time.OffsetDateTime.now())")
    User patchRequestToEntity(PatchRequest patchRequest, @MappingTarget User user);
}
