package com.sd.aloha_spring.controller;

import com.sd.aloha_spring.model.dto.role.PatchRequest;
import com.sd.aloha_spring.model.dto.role.PostRequest;
import com.sd.aloha_spring.model.dto.role.Response;
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
    public Response createRole(@RequestBody PostRequest postRequest) {
        return (roleService.createRole(postRequest));
    }

    @GetMapping
    public List<Response> getAllRoles() {
        return (roleService.getAllRoles());
    }

    @GetMapping("{id}")
    public Response getRoleById(@PathVariable UUID id) {
        return (roleService.getRoleById(id));
    }

    @PatchMapping("{id}")
    public Response updateRole(@PathVariable UUID id, @RequestBody PatchRequest patchRequest) {
        return (roleService.updateRole(id, patchRequest));
    }

    @DeleteMapping("{id}")
    public Response deleteRoleById(@PathVariable UUID id) {
        return (roleService.deleteRoleById(id));
    }

}
