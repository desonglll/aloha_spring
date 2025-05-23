package com.sd.aloha_spring.service;

import com.sd.aloha_spring.model.dto.role.PatchRoleRequest;
import com.sd.aloha_spring.model.dto.role.PostRoleRequest;
import com.sd.aloha_spring.model.dto.role.RoleResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface RoleService {
    RoleResponse createRole(PostRoleRequest postRoleRequest);

    List<RoleResponse> getAllRoles();

    RoleResponse getRoleById(UUID id);

    RoleResponse updateRole(UUID id, PatchRoleRequest patchRoleRequest);

    RoleResponse deleteRoleById(UUID id);
}
