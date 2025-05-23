package com.sd.aloha_spring.controller;

import com.sd.aloha_spring.model.dto.role.PatchRoleRequest;
import com.sd.aloha_spring.model.dto.role.PostRoleRequest;
import com.sd.aloha_spring.model.dto.role.RoleResponse;
import com.sd.aloha_spring.service.RoleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/roles")
public class RoleController {
    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping
    public RoleResponse createRole(@RequestBody PostRoleRequest postRoleRequest) {
        return (roleService.createRole(postRoleRequest));
    }

    @GetMapping
    public List<RoleResponse> getAllRoles() {
        return (roleService.getAllRoles());
    }

    @GetMapping("{id}")
    public RoleResponse getRoleById(@PathVariable UUID id) {
        return (roleService.getRoleById(id));
    }

    @PatchMapping("{id}")
    public RoleResponse updateRole(@PathVariable UUID id, @RequestBody PatchRoleRequest patchRoleRequest) {
        return (roleService.updateRole(id, patchRoleRequest));
    }

    @DeleteMapping("{id}")
    public RoleResponse deleteRoleById(@PathVariable UUID id) {
        return (roleService.deleteRoleById(id));
    }

}
