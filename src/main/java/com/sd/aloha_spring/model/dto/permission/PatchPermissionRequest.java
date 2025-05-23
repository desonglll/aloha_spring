package com.sd.aloha_spring.model.dto.permission;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PatchPermissionRequest {
    private String permissionName;
    private String description;
}
