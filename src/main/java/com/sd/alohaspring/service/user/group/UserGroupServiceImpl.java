package com.sd.alohaspring.service.user.group;

import com.sd.alohaspring.exception.repository.EntityDuplicatedException;
import com.sd.alohaspring.exception.repository.EntityNotFoundException;
import com.sd.alohaspring.exception.repository.SaveEntityException;
import com.sd.alohaspring.model.user.group.UserGroup;
import com.sd.alohaspring.model.user.group.UserGroupDTO;
import com.sd.alohaspring.repository.UserGroupRepository;
import org.springframework.dao.DataIntegrityViolationException;
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
        try {
            UserGroup savedUserGroup = userGroupRepository.save(userGroup);
            return convertToDTO(savedUserGroup);
        } catch (DataIntegrityViolationException e) {
            if (e.getCause() instanceof org.hibernate.exception.ConstraintViolationException) {
                org.hibernate.exception.ConstraintViolationException cve =
                        (org.hibernate.exception.ConstraintViolationException) e.getCause();
                throw new EntityDuplicatedException(cve.getSQLException().getMessage());

            }
            throw new SaveEntityException(e.getMessage());
        }
    }


    @Override
    public UserGroupDTO updateUserGroup(UUID id, UserGroupDTO userGroupDTO) {
        UserGroup userGroup = userGroupRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("UserGroup", id));

        if (userGroupDTO.groupName() != null) {
            userGroup.setGroupName(userGroupDTO.groupName());
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
        userGroup.setId(userGroupDTO.id());
        userGroup.setGroupName(userGroupDTO.groupName());
        userGroup.setCreatedAt(userGroupDTO.createdAt());
        userGroup.setUpdatedAt(userGroupDTO.updatedAt());
        return userGroup;
    }
}
