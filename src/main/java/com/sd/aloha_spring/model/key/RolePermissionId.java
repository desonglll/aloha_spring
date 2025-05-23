package com.sd.aloha_spring.model.key;

import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;
import java.util.UUID;

@Embeddable
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class RolePermissionId implements Serializable {
    UUID roleId;
    UUID permissionId;
}
