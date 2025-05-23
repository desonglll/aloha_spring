package com.sd.aloha_spring.model.mapper;

import com.sd.aloha_spring.model.dto.permission.Response;
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
        Response response = this.permissionMapper.entityToResponse(permission);
        assertThat(response).isNotNull();
        assertThat(response.getId()).isEqualTo(permission.getId());
        assertThat(response.getPermissionName()).isEqualTo(permission.getPermissionKey());
        assertThat(response.getDescription()).isEqualTo(permission.getDescription());
    }
    @Test
    void testMapperInjection() {
        assertNotNull(permissionMapper);
    }
}