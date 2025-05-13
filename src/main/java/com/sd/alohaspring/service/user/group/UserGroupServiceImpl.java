package com.sd.alohaspring.service.user.group;

import com.sd.alohaspring.model.user.group.UserGroup;
import com.sd.alohaspring.model.user.group.UserGroupDTO;
import com.sd.alohaspring.repository.UserGroupRepository;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserGroupServiceImpl implements UserGroupService {
    private final UserGroupRepository userGroupRepository;

    public UserGroupServiceImpl(UserGroupRepository userGroupRepository) {
        this.userGroupRepository = userGroupRepository;
    }

    @Override
    public List<UserGroupDTO> getAllUserGroups() {
        return userGroupRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public Optional<UserGroupDTO> getUserGroupById(UUID id) {
        return userGroupRepository.findById(id).map(this::convertToDTO);
    }

    @Override
    public UserGroupDTO saveUserGroup(UserGroupDTO userGroupDTO) {
        UserGroup userGroup = convertToEntity(userGroupDTO);
        UserGroup savedUserGroup = userGroupRepository.save(userGroup);
        return convertToDTO(savedUserGroup);
    }

    @Override
    public UserGroupDTO updateUserGroup(UUID id, UserGroupDTO userGroupDTO) {
        UserGroup userGroup = userGroupRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("UserGroup not found"));

        if (userGroupDTO.getGroupName() != null) {
            userGroup.setGroupName(userGroupDTO.getGroupName());
        }

        userGroup.setUpdatedAt(OffsetDateTime.now());

        UserGroup updated = userGroupRepository.save(userGroup);
        return convertToDTO(updated);
    }


    @Override
    public UserGroupDTO deleteUserGroupById(UUID id) {
        UserGroup userGroup = userGroupRepository.findById(id).orElseThrow();
        userGroupRepository.deleteById(id);
        return convertToDTO(userGroup);
    }


    private UserGroupDTO convertToDTO(UserGroup userGroup) {
        return new UserGroupDTO(userGroup.getId(), userGroup.getGroupName(), userGroup.getCreatedAt(), userGroup.getUpdatedAt());
    }

    private UserGroup convertToEntity(UserGroupDTO userGroupDTO) {
        UserGroup userGroup = new UserGroup();
        userGroup.setId(userGroupDTO.getId());
        userGroup.setGroupName(userGroupDTO.getGroupName());
        userGroup.setCreatedAt(userGroupDTO.getCreatedAt());
        return userGroup;
    }
}
