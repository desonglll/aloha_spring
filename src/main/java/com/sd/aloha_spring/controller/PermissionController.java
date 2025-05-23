package com.sd.aloha_spring.controller;

import com.sd.aloha_spring.model.dto.permission.PatchPermissionRequest;
import com.sd.aloha_spring.model.dto.permission.PermissionResponse;
import com.sd.aloha_spring.model.dto.permission.PostPermissionRequest;
import com.sd.aloha_spring.service.PermissionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/permissions")
public class PermissionController {

    private final PermissionService permissionService;

    public PermissionController(PermissionService permissionService) {
        this.permissionService = permissionService;
    }


    @PostMapping
    public PermissionResponse createPermission(@RequestBody PostPermissionRequest postPermissionRequest) {
        return (permissionService.createPermission(postPermissionRequest));
    }

    @GetMapping
    public List<PermissionResponse> getAllPermissions() {
        return (permissionService.getAllPermissions());
    }

    @GetMapping("{id}")
    public PermissionResponse getPermissionById(@PathVariable UUID id) {
        return (permissionService.getPermissionById(id));
    }

    @PatchMapping("{id}")
    public PermissionResponse updatePermission(@PathVariable UUID id, @RequestBody PatchPermissionRequest patchPermissionRequest) {
        return (permissionService.updatePermission(id, patchPermissionRequest));
    }

    @DeleteMapping("{id}")
    public PermissionResponse deletePermission(@PathVariable UUID id) {
        return (permissionService.deletePermissionById(id));
    }

    @PutMapping("{id}")
    public PermissionResponse putPermissionById(@PathVariable UUID id, PatchPermissionRequest patchPermissionRequest) {
        return (permissionService.updatePermission(id, patchPermissionRequest));
    }
}
