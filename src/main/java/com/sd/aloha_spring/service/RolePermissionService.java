package com.sd.aloha_spring.service;

import com.sd.aloha_spring.model.dto.role_permission.PostRolePermissionRequest;
import com.sd.aloha_spring.model.dto.role_permission.RolePermissionResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface RolePermissionService {
    RolePermissionResponse createRolePermission(PostRolePermissionRequest request);

    List<RolePermissionResponse> getAllRolePermissions();

    RolePermissionResponse getRolePermission(UUID userId, UUID roleId);

    RolePermissionResponse deleteRolePermission(UUID userId, UUID roleId);
}
