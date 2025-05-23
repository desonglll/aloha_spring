package com.sd.aloha_spring.controller;

import com.sd.aloha_spring.model.dto.user_group.PatchRequest;
import com.sd.aloha_spring.model.dto.user_group.PostRequest;
import com.sd.aloha_spring.model.dto.user_group.Response;
import com.sd.aloha_spring.service.UserGroupService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/user-groups")
public class UserGroupController {
    private final UserGroupService userGroupService;

    public UserGroupController(UserGroupService userGroupService) {
        this.userGroupService = userGroupService;
    }

    @PostMapping
    public Response createUserGroup(@RequestBody PostRequest postRequest) {
        return (userGroupService.createUserGroup(postRequest));
    }

    @GetMapping
    public List<Response> getAllUserGroups() {
        return (userGroupService.getAllUserGroups());
    }

    @GetMapping("{id}")
    public Response getUserGroupById(@PathVariable UUID id) {
        return (userGroupService.getUserGroupById(id));
    }

    @PatchMapping("{id}")
    public Response updateUserGroup(@PathVariable UUID id, @RequestBody PatchRequest patchRequest) {
        return (userGroupService.updateUserGroup(id, patchRequest));
    }

    @DeleteMapping("{id}")
    public Response deleteUserGroupById(@PathVariable UUID id) {
        return (userGroupService.deleteUserGroupById(id));
    }

}
