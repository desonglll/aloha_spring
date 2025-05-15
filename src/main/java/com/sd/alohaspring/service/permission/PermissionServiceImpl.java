package com.sd.alohaspring.service.permission;

import com.sd.alohaspring.exception.repository.EntityDuplicatedException;
import com.sd.alohaspring.exception.repository.EntityNotFoundException;
import com.sd.alohaspring.exception.repository.SaveEntityException;
import com.sd.alohaspring.model.permission.Permission;
import com.sd.alohaspring.model.permission.PermissionDTO;
import com.sd.alohaspring.repository.PermissionRepository;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
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
        try {
            permissionRepository.save(permission);
            return convertToDTO(permission);
        } catch (DataIntegrityViolationException e) {
            log.error(e.getCause().getMessage());
            if (e.getCause() instanceof org.hibernate.exception.ConstraintViolationException) {
                ConstraintViolationException cve = (ConstraintViolationException) e.getCause();
                throw new EntityDuplicatedException(cve.getSQLException().getMessage());
            }
            throw new SaveEntityException(e.getMessage());
        }
    }

    @Override
    public PermissionDTO updatePermission(UUID id, PermissionDTO permissionDTO) {
        Permission permission = permissionRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Permission", id));
        if (permissionDTO.permissionKey() != null) {
            permission.setPermissionKey(permissionDTO.permissionKey());
        }
        if (permissionDTO.description() != null) {
            permission.setDescription(permissionDTO.description());
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
        return new PermissionDTO(permission.getId(), permission.getPermissionKey(), permission.getDescription());
    }

    private Permission convertToEntity(PermissionDTO permissionDTO) {
        Permission permission = new Permission();
        permission.setId(permissionDTO.id());
        permission.setPermissionKey(permissionDTO.permissionKey());
        permission.setDescription(permissionDTO.description());
        return permission;
    }
}
