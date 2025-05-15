package com.sd.alohaspring.model.user.group;


import java.time.OffsetDateTime;
import java.util.UUID;


public record UserGroupDTO(
        UUID id,
        String groupName,
        OffsetDateTime createdAt,
        OffsetDateTime updatedAt
) {
}