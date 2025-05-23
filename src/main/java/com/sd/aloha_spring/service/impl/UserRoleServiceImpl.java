package com.sd.aloha_spring.service.impl;

import com.sd.aloha_spring.model.dto.user_role.PostRequest;
import com.sd.aloha_spring.model.dto.user_role.Response;
import com.sd.aloha_spring.model.entity.UserRole;
import com.sd.aloha_spring.model.key.UserRoleId;
import com.sd.aloha_spring.model.mapper.UserRoleMapper;
import com.sd.aloha_spring.repository.UserRoleRepository;
import com.sd.aloha_spring.service.UserRoleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserRoleServiceImpl implements UserRoleService {

    private final UserRoleMapper userRoleMapper;
    private final UserRoleRepository userRoleRepository;

    public UserRoleServiceImpl(UserRoleMapper userRoleMapper, UserRoleRepository userRoleRepository) {
        this.userRoleMapper = userRoleMapper;
        this.userRoleRepository = userRoleRepository;
    }

    /**
     * @param request
     * @return
     */
    @Override
    public Response createUserRole(PostRequest request) {
        System.out.println(request.toString());
        UserRole userRole = userRoleMapper.postRequestToEntity(request);
        System.out.println(userRole.toString());
        userRoleRepository.save(userRole);
        return userRoleMapper.entityToResponse(userRole);
    }

    /**
     * @return
     */
    @Override
    public List<Response> getAllUserRoles() {
        return userRoleRepository.findAll().stream().map(userRoleMapper::entityToResponse).collect(Collectors.toList());
    }

    /**
     * @param userId
     * @param roleId
     * @return
     */
    @Override
    public Response getUserRole(UUID userId, UUID roleId) {
        UserRoleId id = new UserRoleId(userId, roleId);
        UserRole entity = userRoleRepository.findById(id).orElseThrow(() -> new NoSuchElementException("UserRole not found"));
        return userRoleMapper.entityToResponse(entity);
    }

    /**
     * @param userId
     * @param roleId
     * @return
     */
    @Override
    public Response deleteUserRole(UUID userId, UUID roleId) {
        UserRoleId id = new UserRoleId(userId, roleId);
        UserRole entity = userRoleRepository.findById(id).orElseThrow(() -> new NoSuchElementException("UserRole not found"));
        userRoleRepository.delete(entity);
        return userRoleMapper.entityToResponse(entity);
    }
}
