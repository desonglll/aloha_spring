package com.sd.aloha_spring.controller;

import com.sd.aloha_spring.model.dto.CreatePermissionRequest;
import com.sd.aloha_spring.model.dto.PermissionResponse;
import com.sd.aloha_spring.model.entity.Permission;
import com.sd.aloha_spring.model.mapper.PermissionMapper;
import com.sd.aloha_spring.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/permissions")
public class PermissionController {

    private final PermissionService permissionService;

    public PermissionController(PermissionService permissionService ) {
        this.permissionService = permissionService;
    }


    @PostMapping
    public PermissionResponse createPermission(@RequestBody CreatePermissionRequest createPermissionRequest) {

        return permissionService.createPermission(createPermissionRequest);
    }

    @GetMapping
    public List<PermissionResponse> getAllPermissions() {
        List<Permission> permissionList= permissionService.list();
        return null;
    }
}
