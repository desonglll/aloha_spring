// RolePermissionResponse.java
package com.sd.aloha_spring.model.dto.role_permission;

import lombok.*;

import java.time.OffsetDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RolePermissionResponse {
    private UUID roleId;
    private UUID permissionId;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;
}
