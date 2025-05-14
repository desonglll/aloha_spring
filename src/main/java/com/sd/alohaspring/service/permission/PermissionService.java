package com.sd.alohaspring.service.permission;

import com.sd.alohaspring.model.permission.Permission;
import com.sd.alohaspring.model.permission.PermissionDTO;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PermissionService {
    List<PermissionDTO> getAllPermissions();

    Optional<PermissionDTO> getPermissionById(UUID id);

    PermissionDTO savePermission(PermissionDTO permissionDTO);

    PermissionDTO updatePermission(UUID id, PermissionDTO permissionDTO);

    PermissionDTO deletePermission(UUID id);

}
