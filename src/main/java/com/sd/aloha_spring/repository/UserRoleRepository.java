package com.sd.aloha_spring.repository;

import com.sd.aloha_spring.model.entity.UserRole;
import com.sd.aloha_spring.model.key.UserRoleId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, UserRoleId> {
}