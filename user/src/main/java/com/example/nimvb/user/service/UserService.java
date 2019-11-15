package com.example.nimvb.user.service;

import com.example.nimvb.user.model.dto.UserDto;
import com.example.nimvb.user.model.dto.UserRegistrationDto;

import java.util.List;

public interface UserService {

    List<UserDto> getUsers();
    UserDto getUser(String username);
    void create(UserRegistrationDto dto);
    void updateEmail(String username,String email);
    void delete(String username);
}
