package com.sd.aloha_spring.model.mapper;

import com.sd.aloha_spring.model.dto.user.PatchUserRequest;
import com.sd.aloha_spring.model.dto.user.PostUserRequest;
import com.sd.aloha_spring.model.dto.user.UserResponse;
import com.sd.aloha_spring.model.entity.User;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserResponse entityToResponse(User user);

    @Mapping(target = "id", expression = "java(java.util.UUID.randomUUID())")
    @Mapping(target = "createdAt", expression = "java(java.time.OffsetDateTime.now())")
    @Mapping(target = "updatedAt", expression = "java(java.time.OffsetDateTime.now())")
    @Mapping(target = "enabled", expression = "java(false)")
    User postRequestToEntity(PostUserRequest postUserRequest);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "updatedAt", expression = "java(java.time.OffsetDateTime.now())")
    User patchRequestToEntity(PatchUserRequest patchUserRequest, @MappingTarget User user);
}
