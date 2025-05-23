package com.sd.aloha_spring.service.impl;

import com.sd.aloha_spring.model.dto.user.PatchRequest;
import com.sd.aloha_spring.model.dto.user.PostRequest;
import com.sd.aloha_spring.model.dto.user.Response;
import com.sd.aloha_spring.model.entity.User;
import com.sd.aloha_spring.model.mapper.UserMapper;
import com.sd.aloha_spring.repository.UserRepository;
import com.sd.aloha_spring.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }


    @Override
    public Response createUser(PostRequest postRequest) {
        User user = userMapper.postRequestToEntity(postRequest);
        userRepository.save(user);
        return userMapper.entityToResponse(user);
    }

    @Override
    public List<Response> getAllUsers() {
        return userRepository.findAll().stream().map(userMapper::entityToResponse).collect(Collectors.toList());
    }

    @Override
    public Response getUserById(UUID id) {
        return userMapper.entityToResponse(userRepository.findById(id).orElseThrow(() -> new NoSuchElementException("User with id " + id + " not found")));
    }

    @Override
    public Response updateUser(UUID id, PatchRequest patchRequest) {
        User user = userRepository.findById(id).orElseThrow(() -> new NoSuchElementException("User with id " + id + " not found"));
        System.out.println(patchRequest.toString());
        System.out.println(user.toString());
        User patchedUserRequestToUser = userMapper.patchRequestToEntity(patchRequest, user);
        System.out.println(patchedUserRequestToUser.toString());
        userRepository.save(user);
        return userMapper.entityToResponse(patchedUserRequestToUser);
    }

    @Override
    public Response deleteUserById(UUID id) {
        User user = userRepository.findById(id).orElseThrow(() -> new NoSuchElementException("User with id " + id + " not found"));
        userRepository.delete(user);
        return userMapper.entityToResponse(user);
    }
}
