package com.sd.aloha_spring.controller;

import com.sd.aloha_spring.model.dto.role_permission.PostRequest;
import com.sd.aloha_spring.model.dto.role_permission.Response;
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
    public Response create(@Valid @RequestBody PostRequest request) {
        return rolePermissionService.createRolePermission(request);
    }

    @GetMapping
    public List<Response> getAll() {
        return rolePermissionService.getAllRolePermissions();
    }

    @GetMapping("/{roleId}/{permissionId}")
    public Response get(@PathVariable UUID roleId, @PathVariable UUID permissionId) {
        return rolePermissionService.getRolePermission(roleId, permissionId);
    }

    @DeleteMapping("/{roleId}/{permissionId}")
    public Response delete(@PathVariable UUID roleId, @PathVariable UUID permissionId) {
        return rolePermissionService.deleteRolePermission(roleId, permissionId);
    }
}