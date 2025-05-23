// UserRoleResponse.java
package com.sd.aloha_spring.model.dto.user_role;

import lombok.*;

import java.time.OffsetDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRoleResponse {
    private UUID userId;
    private UUID roleId;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;
}
