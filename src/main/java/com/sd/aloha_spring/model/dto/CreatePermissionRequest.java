package com.sd.aloha_spring.model.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreatePermissionRequest {
    @NotNull
    private String permissionName;
    private String description;
}
