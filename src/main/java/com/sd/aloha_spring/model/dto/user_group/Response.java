package com.sd.aloha_spring.model.dto.user_group;

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

    private String groupName;

    private OffsetDateTime createdAt;

    private OffsetDateTime updatedAt;
}
