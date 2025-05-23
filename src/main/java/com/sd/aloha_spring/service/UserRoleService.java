package com.sd.aloha_spring.service;

import com.sd.aloha_spring.model.dto.user_role.PostRequest;
import com.sd.aloha_spring.model.dto.user_role.Response;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface UserRoleService {
    Response createUserRole(PostRequest request);

    List<Response> getAllUserRoles();

    Response getUserRole(UUID userId, UUID roleId);

    Response deleteUserRole(UUID userId, UUID roleId);
}
