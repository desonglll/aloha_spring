package com.sd.aloha_spring.repository;

import com.sd.aloha_spring.model.entity.RolePermission;
import com.sd.aloha_spring.model.key.RolePermissionId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolePermissionRepository extends JpaRepository<RolePermission, RolePermissionId> {
}