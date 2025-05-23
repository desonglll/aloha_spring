package com.sd.aloha_spring.model.dto.role;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class PatchRequest {
    private String roleName;
    private String description;
}
