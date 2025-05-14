package com.sd.alohaspring.repository;

import com.sd.alohaspring.model.user.group.UserGroup;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserGroupRepository extends JpaRepository<UserGroup, UUID> {
}
