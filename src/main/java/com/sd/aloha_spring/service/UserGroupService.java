package com.sd.aloha_spring.service;

import com.sd.aloha_spring.model.dto.user_group.PatchRequest;
import com.sd.aloha_spring.model.dto.user_group.PostRequest;
import com.sd.aloha_spring.model.dto.user_group.Response;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface UserGroupService {
    Response createUserGroup(PostRequest postRequest);
    List<Response> getAllUserGroups();
    Response getUserGroupById(UUID id);
    Response deleteUserGroupById(UUID id);
    Response updateUserGroup(UUID id, PatchRequest patchRequest);
}
