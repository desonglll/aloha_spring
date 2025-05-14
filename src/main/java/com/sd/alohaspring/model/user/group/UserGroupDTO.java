package com.sd.alohaspring.model.user.group;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserGroupDTO {
    private UUID id;
    private String groupName;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;
}