package com.sd.alohaspring.controller;

import com.sd.alohaspring.model.permission.PermissionDTO;
import com.sd.alohaspring.service.permission.PermissionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/permission")
public class PermissionController {
    private final PermissionService permissionService;

    public PermissionController(PermissionService permissionService) {
        this.permissionService = permissionService;
    }

    @GetMapping
    public List<PermissionDTO> findAllPermissions() {
        return permissionService.getAllPermissions();
    }

    @GetMapping("{id}")
    public Optional<PermissionDTO> getPermissionById(@PathVariable UUID id) {
        return permissionService.getPermissionById(id);
    }

    @PostMapping
    public PermissionDTO savePermission(@RequestBody PermissionDTO permissionDTO) {
        return permissionService.savePermission(permissionDTO);
    }

    @PatchMapping("{id}")
    public PermissionDTO updatePermission(@PathVariable UUID id, @RequestBody PermissionDTO permissionDTO) {
        return permissionService.updatePermission(id, permissionDTO);
    }

    @DeleteMapping("{id}")
    public PermissionDTO deletePermission(@PathVariable UUID id) {
        return permissionService.deletePermission(id);
    }
}
