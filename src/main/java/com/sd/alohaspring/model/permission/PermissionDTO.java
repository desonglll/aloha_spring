package com.sd.alohaspring.model.permission;

import java.util.UUID;

public record PermissionDTO(UUID id, String permissionKey, String description) {
}