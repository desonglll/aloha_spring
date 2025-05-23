package com.sd.aloha_spring.service;

import com.sd.aloha_spring.model.dto.permission.PatchPermissionRequest;
import com.sd.aloha_spring.model.dto.permission.PermissionResponse;
import com.sd.aloha_spring.model.dto.permission.PostPermissionRequest;
import com.sd.aloha_spring.model.entity.Permission;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface PermissionService {
    PermissionResponse createPermission(PostPermissionRequest postPermissionRequest);

    List<PermissionResponse> getAllPermissions();

    PermissionResponse getPermissionById(UUID id);

    PermissionResponse updatePermission(UUID id, PatchPermissionRequest patchPermissionRequest);

    PermissionResponse deletePermissionById(UUID id);
}
