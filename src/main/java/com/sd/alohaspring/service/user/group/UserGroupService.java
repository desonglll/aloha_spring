package com.sd.alohaspring.service.user.group;

import com.sd.alohaspring.model.user.group.UserGroupDTO;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserGroupService {
    List<UserGroupDTO> getAllUserGroups();

    Optional<UserGroupDTO> getUserGroupById(UUID id);

    UserGroupDTO saveUserGroup(UserGroupDTO userGroupDTO);

    UserGroupDTO updateUserGroup(UUID id, UserGroupDTO userGroupDTO);

    UserGroupDTO deleteUserGroupById(UUID id);
}
