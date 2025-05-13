package com.sd.alohaspring.controller;

import com.sd.alohaspring.model.user.group.UserGroupDTO;
import com.sd.alohaspring.service.user.group.UserGroupService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/user_groups")
public class UserGroupController {
    private final UserGroupService userGroupService;

    public UserGroupController(UserGroupService userGroupService) {
        this.userGroupService = userGroupService;
    }

    @GetMapping
    public List<UserGroupDTO> findAllUserGroups() {
        return userGroupService.getAllUserGroups();
    }

    @GetMapping("{id}")
    public Optional<UserGroupDTO> findUserGroupById(@PathVariable UUID id) {
        return userGroupService.getUserGroupById(id);
    }

    @PostMapping
    public UserGroupDTO saveUserGroup(@Valid @RequestBody UserGroupDTO userGroupDTO) {
        return userGroupService.saveUserGroup(userGroupDTO);
    }

    @PatchMapping("{id}")
    public UserGroupDTO updateUserGroup(@PathVariable UUID id, @Valid @RequestBody UserGroupDTO userGroupDTO) {
        return userGroupService.updateUserGroup(id, userGroupDTO);
    }

    @DeleteMapping("{id}")
    public UserGroupDTO deleteUserGroup(@PathVariable UUID id) {
        return userGroupService.deleteUserGroupById(id);
    }

}
