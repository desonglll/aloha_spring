package com.sd.aloha_spring.service.impl;

import com.sd.aloha_spring.model.dto.role_permission.PostRolePermissionRequest;
import com.sd.aloha_spring.model.dto.role_permission.RolePermissionResponse;
import com.sd.aloha_spring.model.entity.RolePermission;
import com.sd.aloha_spring.model.key.RolePermissionId;
import com.sd.aloha_spring.model.mapper.RolePermissionMapper;
import com.sd.aloha_spring.repository.RolePermissionRepository;
import com.sd.aloha_spring.service.RolePermissionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class RolePermissionServiceImpl implements RolePermissionService {

    private final RolePermissionMapper rolePermissionMapper;
    private final RolePermissionRepository rolePermissionRepository;

    public RolePermissionServiceImpl(RolePermissionMapper rolePermissionMapper, RolePermissionRepository rolePermissionRepository) {
        this.rolePermissionMapper = rolePermissionMapper;
        this.rolePermissionRepository = rolePermissionRepository;
    }

    /**
     * @param request
     * @return
     */
    @Override
    public RolePermissionResponse createRolePermission(PostRolePermissionRequest request) {
        System.out.println(request.toString());
        RolePermission rolePermission = rolePermissionMapper.postRequestToEntity(request);
        System.out.println(rolePermission.toString());
        rolePermissionRepository.save(rolePermission);
        return rolePermissionMapper.entityToResponse(rolePermission);
    }

    /**
     * @return
     */
    @Override
    public List<RolePermissionResponse> getAllRolePermissions() {
        return rolePermissionRepository.findAll().stream().map(rolePermissionMapper::entityToResponse).collect(Collectors.toList());
    }

    /**
     * @param roleId
     * @param roleId
     * @return
     */
    @Override
    public RolePermissionResponse getRolePermission(UUID roleId, UUID permissionId) {
        RolePermissionId id = new RolePermissionId(roleId, permissionId);
        RolePermission entity = rolePermissionRepository.findById(id).orElseThrow(() -> new NoSuchElementException("RolePermission not found"));
        return rolePermissionMapper.entityToResponse(entity);
    }

    /**
     * @param roleId
     * @param permissionId
     * @return
     */
    @Override
    public RolePermissionResponse deleteRolePermission(UUID roleId, UUID permissionId) {
        RolePermissionId id = new RolePermissionId(roleId, permissionId);
        RolePermission entity = rolePermissionRepository.findById(id).orElseThrow(() -> new NoSuchElementException("RolePermission not found"));
        rolePermissionRepository.delete(entity);
        return rolePermissionMapper.entityToResponse(entity);
    }
}
