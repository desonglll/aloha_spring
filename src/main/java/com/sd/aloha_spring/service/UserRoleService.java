package com.sd.aloha_spring.service;

import com.sd.aloha_spring.model.dto.user_role.PostUserRoleRequest;
import com.sd.aloha_spring.model.dto.user_role.UserRoleResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface UserRoleService {
    UserRoleResponse createUserRole(PostUserRoleRequest request);

    List<UserRoleResponse> getAllUserRoles();

    UserRoleResponse getUserRole(UUID userId, UUID roleId);

    UserRoleResponse deleteUserRole(UUID userId, UUID roleId);
}
