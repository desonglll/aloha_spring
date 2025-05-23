package com.sd.aloha_spring.service.impl;

import com.sd.aloha_spring.model.dto.role.PatchRoleRequest;
import com.sd.aloha_spring.model.dto.role.PostRoleRequest;
import com.sd.aloha_spring.model.dto.role.RoleResponse;
import com.sd.aloha_spring.model.entity.Role;
import com.sd.aloha_spring.model.mapper.RoleMapper;
import com.sd.aloha_spring.repository.RoleRepository;
import com.sd.aloha_spring.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;

    public RoleServiceImpl(RoleRepository roleRepository, RoleMapper roleMapper) {
        this.roleRepository = roleRepository;
        this.roleMapper = roleMapper;
    }


    @Override
    public RoleResponse createRole(PostRoleRequest postRoleRequest) {
        Role role = roleMapper.postRequestToEntity(postRoleRequest);
        roleRepository.save(role);
        return roleMapper.entityToResponse(role);
    }

    @Override
    public List<RoleResponse> getAllRoles() {
        return roleRepository.findAll().stream().map(roleMapper::entityToResponse).collect(Collectors.toList());
    }

    @Override
    public RoleResponse getRoleById(UUID id) {
        return roleMapper.entityToResponse(roleRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Role with id " + id + " not found")));
    }

    @Override
    public RoleResponse updateRole(UUID id, PatchRoleRequest patchRoleRequest) {
        Role role = roleRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Role with id " + id + " not found"));
        Role patchedRoleRequestToRole = roleMapper.patchRequestToEntity(patchRoleRequest, role);
        roleRepository.save(role);
        return roleMapper.entityToResponse(patchedRoleRequestToRole);
    }

    @Override
    public RoleResponse deleteRoleById(UUID id) {
        Role role = roleRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Role with id " + id + " not found"));
        roleRepository.delete(role);
        return roleMapper.entityToResponse(role);
    }
}
