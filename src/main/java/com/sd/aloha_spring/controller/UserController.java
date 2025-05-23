package com.sd.aloha_spring.controller;

import com.sd.aloha_spring.model.dto.user.PatchUserRequest;
import com.sd.aloha_spring.model.dto.user.PostUserRequest;
import com.sd.aloha_spring.model.dto.user.UserResponse;
import com.sd.aloha_spring.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public UserResponse createUser(@RequestBody PostUserRequest postUserRequest) {
        return (userService.createUser(postUserRequest));
    }

    @GetMapping
    public List<UserResponse> getAllUsers() {
        return (userService.getAllUsers());
    }

    @GetMapping("{id}")
    public UserResponse getUserById(@PathVariable UUID id) {
        return (userService.getUserById(id));
    }

    @PatchMapping("{id}")
    public UserResponse updateUser(@PathVariable UUID id, @RequestBody PatchUserRequest patchUserRequest) {
        return (userService.updateUser(id, patchUserRequest));
    }

    @DeleteMapping("{id}")
    public UserResponse deleteUserById(@PathVariable UUID id) {
        return (userService.deleteUserById(id));
    }

}
