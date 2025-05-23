package com.sd.aloha_spring.service;

import com.sd.aloha_spring.model.dto.permission.PatchRequest;
import com.sd.aloha_spring.model.dto.permission.Response;
import com.sd.aloha_spring.model.dto.permission.PostRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface PermissionService {
    Response createPermission(PostRequest postRequest);

    List<Response> getAllPermissions();

    Response getPermissionById(UUID id);

    Response updatePermission(UUID id, PatchRequest patchRequest);

    Response deletePermissionById(UUID id);
}
