package com.sd.aloha_spring.controller;

import com.sd.aloha_spring.model.dto.user.PatchRequest;
import com.sd.aloha_spring.model.dto.user.PostRequest;
import com.sd.aloha_spring.model.dto.user.Response;
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
    public Response createUser(@RequestBody PostRequest postRequest) {
        return (userService.createUser(postRequest));
    }

    @GetMapping
    public List<Response> getAllUsers() {
        return (userService.getAllUsers());
    }

    @GetMapping("{id}")
    public Response getUserById(@PathVariable UUID id) {
        return (userService.getUserById(id));
    }

    @PatchMapping("{id}")
    public Response updateUser(@PathVariable UUID id, @RequestBody PatchRequest patchRequest) {
        return (userService.updateUser(id, patchRequest));
    }

    @DeleteMapping("{id}")
    public Response deleteUserById(@PathVariable UUID id) {
        return (userService.deleteUserById(id));
    }

}
