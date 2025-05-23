package com.sd.aloha_spring.service.impl;

import com.sd.aloha_spring.model.dto.user_group.PatchRequest;
import com.sd.aloha_spring.model.dto.user_group.PostRequest;
import com.sd.aloha_spring.model.dto.user_group.Response;
import com.sd.aloha_spring.model.entity.UserGroup;
import com.sd.aloha_spring.model.mapper.UserGroupMapper;
import com.sd.aloha_spring.repository.UserGroupRepository;
import com.sd.aloha_spring.service.UserGroupService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserGroupServiceImpl implements UserGroupService {

    private final UserGroupRepository userGroupRepository;
    private final UserGroupMapper userGroupMapper;

    public UserGroupServiceImpl(UserGroupRepository userGroupRepository, UserGroupMapper userGroupMapper) {
        this.userGroupRepository = userGroupRepository;
        this.userGroupMapper = userGroupMapper;
    }

    @Override
    public Response createUserGroup(PostRequest postRequest) {
        UserGroup userGroup = userGroupMapper.postRequestToEntity(postRequest);
        userGroupRepository.save(userGroup);
        return userGroupMapper.entityToResponse(userGroup);
    }

    @Override
    public List<Response> getAllUserGroups() {
        return userGroupRepository.findAll().stream().map(userGroupMapper::entityToResponse).collect(Collectors.toList());
    }

    @Override
    public Response getUserGroupById(UUID id) {
        return userGroupRepository.findById(id).map(userGroupMapper::entityToResponse).orElse(null);
    }

    @Override
    public Response deleteUserGroupById(UUID id) {
        UserGroup userGroup = userGroupRepository.findById(id).orElseThrow(() -> new NoSuchElementException("UserGroup not found"));
        userGroupRepository.delete(userGroup);
        return userGroupMapper.entityToResponse(userGroup);
    }

    @Override
    public Response updateUserGroup(UUID id, PatchRequest patchRequest) {
        UserGroup userGroup = userGroupRepository.findById(id).orElseThrow(() -> new NoSuchElementException("UserGroup not found"));
        UserGroup newUserGroup = userGroupMapper.patchRequestToEntity(patchRequest, userGroup);
        userGroupRepository.save(userGroup);
        return userGroupMapper.entityToResponse(newUserGroup);
    }

}
