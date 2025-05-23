package com.sd.aloha_spring.model.dto.permission;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class PostRequest {
    @NotNull
    private String permissionName;
    private String description;
}
