package com.sd.aloha_spring.service;

import com.sd.aloha_spring.model.dto.role_permission.PostRequest;
import com.sd.aloha_spring.model.dto.role_permission.Response;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface RolePermissionService {
    Response createRolePermission(PostRequest request);

    List<Response> getAllRolePermissions();

    Response getRolePermission(UUID userId, UUID roleId);

    Response deleteRolePermission(UUID userId, UUID roleId);
}
