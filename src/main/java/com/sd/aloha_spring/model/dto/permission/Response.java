package com.sd.aloha_spring.model.dto.permission;
import lombok.*;

import java.time.OffsetDateTime;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Response {
    private UUID id;
    private String permissionName;
    private String description;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;
}
