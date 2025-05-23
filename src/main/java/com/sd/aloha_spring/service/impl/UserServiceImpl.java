package com.sd.aloha_spring.service.impl;

import com.sd.aloha_spring.model.dto.user.PatchUserRequest;
import com.sd.aloha_spring.model.dto.user.PostUserRequest;
import com.sd.aloha_spring.model.dto.user.UserResponse;
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
    public UserResponse createUser(PostUserRequest postUserRequest) {
        User user = userMapper.postRequestToEntity(postUserRequest);
        userRepository.save(user);
        return userMapper.entityToResponse(user);
    }

    @Override
    public List<UserResponse> getAllUsers() {
        return userRepository.findAll().stream().map(userMapper::entityToResponse).collect(Collectors.toList());
    }

    @Override
    public UserResponse getUserById(UUID id) {
        return userMapper.entityToResponse(userRepository.findById(id).orElseThrow(() -> new NoSuchElementException("User with id " + id + " not found")));
    }

    @Override
    public UserResponse updateUser(UUID id, PatchUserRequest patchUserRequest) {
        User user = userRepository.findById(id).orElseThrow(() -> new NoSuchElementException("User with id " + id + " not found"));
        System.out.println(patchUserRequest.toString());
        System.out.println(user.toString());
        User patchedUserRequestToUser = userMapper.patchRequestToEntity(patchUserRequest, user);
        System.out.println(patchedUserRequestToUser.toString());
        userRepository.save(user);
        return userMapper.entityToResponse(patchedUserRequestToUser);
    }

    @Override
    public UserResponse deleteUserById(UUID id) {
        User user = userRepository.findById(id).orElseThrow(() -> new NoSuchElementException("User with id " + id + " not found"));
        userRepository.delete(user);
        return userMapper.entityToResponse(user);
    }
}
