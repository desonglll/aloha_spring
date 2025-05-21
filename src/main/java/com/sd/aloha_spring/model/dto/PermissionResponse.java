package com.sd.aloha_spring.model.dto;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PermissionResponse {
    private UUID id;
    @NotNull
    private String permissionName;
    private String description;
}
