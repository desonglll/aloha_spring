package com.sd.aloha_spring.controller;

import com.sd.aloha_spring.model.dto.user_role.PostRequest;
import com.sd.aloha_spring.model.dto.user_role.Response;
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
    public Response create(@Valid @RequestBody PostRequest request) {
        return userRoleService.createUserRole(request);
    }

    @GetMapping
    public List<Response> getAll() {
        return userRoleService.getAllUserRoles();
    }

    @GetMapping("/{userId}/{roleId}")
    public Response get(@PathVariable UUID userId, @PathVariable UUID roleId) {
        return userRoleService.getUserRole(userId, roleId);
    }

    @DeleteMapping("/{userId}/{roleId}")
    public Response delete(@PathVariable UUID userId, @PathVariable UUID roleId) {
        return userRoleService.deleteUserRole(userId, roleId);
    }
}