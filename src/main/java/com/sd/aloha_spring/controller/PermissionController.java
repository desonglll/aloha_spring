package com.sd.aloha_spring.controller;

import com.sd.aloha_spring.model.dto.permission.PatchRequest;
import com.sd.aloha_spring.model.dto.permission.Response;
import com.sd.aloha_spring.model.dto.permission.PostRequest;
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
    public Response createPermission(@RequestBody PostRequest postRequest) {
        return (permissionService.createPermission(postRequest));
    }

    @GetMapping
    public List<Response> getAllPermissions() {
        return (permissionService.getAllPermissions());
    }

    @GetMapping("{id}")
    public Response getPermissionById(@PathVariable UUID id) {
        return (permissionService.getPermissionById(id));
    }

    @PatchMapping("{id}")
    public Response updatePermission(@PathVariable UUID id, @RequestBody PatchRequest patchRequest) {
        return (permissionService.updatePermission(id, patchRequest));
    }

    @DeleteMapping("{id}")
    public Response deletePermission(@PathVariable UUID id) {
        return (permissionService.deletePermissionById(id));
    }

    @PutMapping("{id}")
    public Response putPermissionById(@PathVariable UUID id, PatchRequest patchRequest) {
        return (permissionService.updatePermission(id, patchRequest));
    }
}
