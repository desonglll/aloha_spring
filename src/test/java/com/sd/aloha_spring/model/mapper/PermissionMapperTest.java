package com.sd.aloha_spring.model.mapper;

import com.sd.aloha_spring.model.dto.PermissionResponse;
import com.sd.aloha_spring.model.entity.Permission;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class PermissionMapperTest {

    private final PermissionMapper permissionMapper;

    public PermissionMapperTest(PermissionMapper permissionMapper) {
        this.permissionMapper = permissionMapper;
    }


    @Test
    void permissionToPermissionDto() {
        Permission permission = new Permission();
        permission.setId(UUID.randomUUID());
        permission.setPermissionKey("Read");
        permission.setDescription("Read permission");
        PermissionResponse permissionResponse = this.permissionMapper.permissionToPermissionResponse(permission);
        assertThat(permissionResponse).isNotNull();
        assertThat(permissionResponse.getId()).isEqualTo(permission.getId());
        assertThat(permissionResponse.getPermissionName()).isEqualTo(permission.getPermissionKey());
        assertThat(permissionResponse.getDescription()).isEqualTo(permission.getDescription());
    }
    @Test
    void testMapperInjection() {
        assertNotNull(permissionMapper);
    }
}