// PostUserRoleRequest.java
package com.sd.aloha_spring.model.dto.user_role;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostRequest {
    @NotNull
    private UUID userId;
    @NotNull
    private UUID roleId;
}
