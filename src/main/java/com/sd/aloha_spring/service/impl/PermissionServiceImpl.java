package com.sd.aloha_spring.service.impl;

import com.sd.aloha_spring.model.dto.permission.PatchPermissionRequest;
import com.sd.aloha_spring.model.dto.permission.PermissionResponse;
import com.sd.aloha_spring.model.dto.permission.PostPermissionRequest;
import com.sd.aloha_spring.model.entity.Permission;
import com.sd.aloha_spring.model.mapper.PermissionMapper;
import com.sd.aloha_spring.repository.PermissionRepository;
import com.sd.aloha_spring.service.PermissionService;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.stream.Collectors;


@Service
@Log
public class PermissionServiceImpl implements PermissionService {

    private final PermissionRepository permissionRepository;
    private final PermissionMapper permissionMapper;

    public PermissionServiceImpl(PermissionRepository permissionRepository, PermissionMapper permissionMapper) {
        this.permissionRepository = permissionRepository;
        this.permissionMapper = permissionMapper;
    }

    @Override
    public PermissionResponse createPermission(PostPermissionRequest postPermissionRequest) {
        Permission permission = permissionMapper.postRequestToEntity(postPermissionRequest);
        permissionRepository.save(permission);
        return permissionMapper.entityToResponse(permission);
    }

    @Override
    public List<PermissionResponse> getAllPermissions() {
        return permissionRepository.findAll().stream().map(permissionMapper::entityToResponse).collect(Collectors.toList());
    }

    @Override
    public PermissionResponse getPermissionById(UUID id) {
        return permissionMapper.entityToResponse(permissionRepository.findById(id).orElseThrow());
    }


    @Override
    public PermissionResponse updatePermission(UUID id, PatchPermissionRequest patchPermissionRequest) {
        Permission permission = permissionRepository.findById(id).orElseThrow();
        Permission patchPermissionRequestToPermission = permissionMapper.patchRequestToEntity(patchPermissionRequest, permission);
        permissionRepository.save(permission);
        return permissionMapper.entityToResponse(patchPermissionRequestToPermission);
    }

    /**
     * @param id
     * @return
     */
    @Override
    public PermissionResponse deletePermissionById(UUID id) {
        return permissionRepository.findById(id).map(permission -> {
            permissionRepository.deleteById(id);
            return permissionMapper.entityToResponse(permission);
        }).orElseThrow(() -> new NoSuchElementException("Permission with id " + id + " not found"));
    }
}
