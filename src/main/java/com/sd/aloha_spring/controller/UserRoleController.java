package com.sd.aloha_spring.controller;

import com.sd.aloha_spring.model.dto.user_role.PostUserRoleRequest;
import com.sd.aloha_spring.model.dto.user_role.UserRoleResponse;
import com.sd.aloha_spring.service.UserRoleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/user-roles")
@RequiredArgsConstructor
public class UserRoleController {

    private final UserRoleService userRoleService;

    @PostMapping
    public UserRoleResponse create(@Valid @RequestBody PostUserRoleRequest request) {
        return userRoleService.createUserRole(request);
    }

    @GetMapping
    public List<UserRoleResponse> getAll() {
        return userRoleService.getAllUserRoles();
    }

    @GetMapping("/{userId}/{roleId}")
    public UserRoleResponse get(@PathVariable UUID userId, @PathVariable UUID roleId) {
        return userRoleService.getUserRole(userId, roleId);
    }

    @DeleteMapping("/{userId}/{roleId}")
    public UserRoleResponse delete(@PathVariable UUID userId, @PathVariable UUID roleId) {
        return userRoleService.deleteUserRole(userId, roleId);
    }
}