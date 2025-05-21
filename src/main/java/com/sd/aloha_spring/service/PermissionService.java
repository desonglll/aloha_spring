package com.sd.aloha_spring.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sd.aloha_spring.model.dto.CreatePermissionRequest;
import com.sd.aloha_spring.model.dto.PermissionResponse;
import com.sd.aloha_spring.model.entity.Permission;
import org.springframework.stereotype.Service;

@Service
public interface PermissionService extends IService<Permission> {

    PermissionResponse createPermission(CreatePermissionRequest createPermissionRequest);
}
