package com.sd.aloha_spring.service;

import com.sd.aloha_spring.model.dto.user.PatchRequest;
import com.sd.aloha_spring.model.dto.user.PostRequest;
import com.sd.aloha_spring.model.dto.user.Response;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface UserService {
    Response createUser(PostRequest postRequest);

    List<Response> getAllUsers();

    Response getUserById(UUID id);

    Response updateUser(UUID id, PatchRequest patchRequest);

    Response deleteUserById(UUID id);
}
