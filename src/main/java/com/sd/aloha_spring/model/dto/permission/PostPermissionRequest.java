package com.sd.aloha_spring.model.dto.permission;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class PostPermissionRequest {
    @NotNull
    private String permissionName;
    private String description;
}
