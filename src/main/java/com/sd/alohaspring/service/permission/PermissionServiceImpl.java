package com.sd.alohaspring.service.permission;

import com.sd.alohaspring.model.permission.Permission;
import com.sd.alohaspring.model.permission.PermissionDTO;
import com.sd.alohaspring.repository.PermissionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PermissionServiceImpl implements PermissionService {

    private final PermissionRepository permissionRepository;

    public PermissionServiceImpl(PermissionRepository permissionRepository) {
        this.permissionRepository = permissionRepository;
    }

    @Override
    public List<PermissionDTO> getAllPermissions() {
        return permissionRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public Optional<PermissionDTO> getPermissionById(UUID id) {
        return permissionRepository.findById(id).map(this::convertToDTO);
    }

    @Override
    public PermissionDTO savePermission(PermissionDTO permissionDTO) {
        Permission permission = convertToEntity(permissionDTO);
        permissionRepository.save(permission);
        return convertToDTO(permission);
    }

    @Override
    public PermissionDTO updatePermission(UUID id, PermissionDTO permissionDTO) {
        Permission permission = permissionRepository.findById(id).orElseThrow();
        if (permissionDTO.getPermissionKey() != null) {
            permission.setPermissionKey(permissionDTO.getPermissionKey());
        }
        if (permissionDTO.getDescription() != null) {
            permission.setDescription(permissionDTO.getDescription());
        }
        return convertToDTO(permissionRepository.save(permission));
    }

    @Override
    public PermissionDTO deletePermission(UUID id) {
        Permission permission = permissionRepository.findById(id).orElseThrow();
        permissionRepository.deleteById(id);
        return convertToDTO(permission);
    }

    private PermissionDTO convertToDTO(Permission permission) {
        PermissionDTO permissionDTO = new PermissionDTO();
        permissionDTO.setId(permission.getId());
        permissionDTO.setPermissionKey(permission.getPermissionKey());
        permissionDTO.setDescription(permission.getDescription());
        return permissionDTO;
    }

    private Permission convertToEntity(PermissionDTO permissionDTO) {
        Permission permission = new Permission();
        permission.setId(permissionDTO.getId());
        permission.setPermissionKey(permissionDTO.getPermissionKey());
        permission.setDescription(permissionDTO.getDescription());
        return permission;
    }
}
