package com.sd.alohaspring.repository;

import com.sd.alohaspring.model.permission.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PermissionRepository extends JpaRepository<Permission, UUID> {
}
