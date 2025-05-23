// PostRolePermissionRequest.java
package com.sd.aloha_spring.model.dto.role_permission;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostRolePermissionRequest {
    @NotNull
    private UUID roleId;
    @NotNull
    private UUID permissionId;
}
