package com.sd.aloha_spring.service;

import com.sd.aloha_spring.model.dto.role.PatchRequest;
import com.sd.aloha_spring.model.dto.role.PostRequest;
import com.sd.aloha_spring.model.dto.role.Response;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface RoleService {
    Response createRole(PostRequest postRequest);

    List<Response> getAllRoles();

    Response getRoleById(UUID id);

    Response updateRole(UUID id, PatchRequest patchRequest);

    Response deleteRoleById(UUID id);
}
