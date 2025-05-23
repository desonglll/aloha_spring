package com.sd.aloha_spring.controller;

import com.sd.aloha_spring.model.dto.role_permission.PostRolePermissionRequest;
import com.sd.aloha_spring.model.dto.role_permission.RolePermissionResponse;
import com.sd.aloha_spring.service.RolePermissionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/role-permissions")
@RequiredArgsConstructor
public class RolePermissionController {

    private final RolePermissionService rolePermissionService;

    @PostMapping
    public RolePermissionResponse create(@Valid @RequestBody PostRolePermissionRequest request) {
        return rolePermissionService.createRolePermission(request);
    }

    @GetMapping
    public List<RolePermissionResponse> getAll() {
        return rolePermissionService.getAllRolePermissions();
    }

    @GetMapping("/{roleId}/{permissionId}")
    public RolePermissionResponse get(@PathVariable UUID roleId, @PathVariable UUID permissionId) {
        return rolePermissionService.getRolePermission(roleId, permissionId);
    }

    @DeleteMapping("/{roleId}/{permissionId}")
    public RolePermissionResponse delete(@PathVariable UUID roleId, @PathVariable UUID permissionId) {
        return rolePermissionService.deleteRolePermission(roleId, permissionId);
    }
}