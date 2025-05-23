package com.sd.aloha_spring.service;

import com.sd.aloha_spring.model.dto.user.PatchUserRequest;
import com.sd.aloha_spring.model.dto.user.PostUserRequest;
import com.sd.aloha_spring.model.dto.user.UserResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface UserService {
    UserResponse createUser(PostUserRequest postUserRequest);

    List<UserResponse> getAllUsers();

    UserResponse getUserById(UUID id);

    UserResponse updateUser(UUID id, PatchUserRequest patchUserRequest);

    UserResponse deleteUserById(UUID id);
}
