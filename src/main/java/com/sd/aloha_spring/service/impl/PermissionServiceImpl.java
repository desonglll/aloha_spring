package com.sd.aloha_spring.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sd.aloha_spring.model.dto.CreatePermissionRequest;
import com.sd.aloha_spring.model.dto.PermissionResponse;
import com.sd.aloha_spring.model.entity.Permission;
import com.sd.aloha_spring.model.mapper.PermissionMapper;
import com.sd.aloha_spring.repository.PermissionMyBatisMapper;
import com.sd.aloha_spring.service.PermissionService;
import org.springframework.stereotype.Service;


@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMyBatisMapper, Permission> implements PermissionService {


    @Override
    public PermissionResponse createPermission(CreatePermissionRequest createPermissionRequest) {
        return null;
    }
}
