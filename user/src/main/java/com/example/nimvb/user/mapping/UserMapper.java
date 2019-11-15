package com.example.nimvb.user.mapping;

import com.example.nimvb.user.model.User;
import com.example.nimvb.user.model.dto.UserDto;
import com.example.nimvb.user.model.dto.UserRegistrationDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDto toUserDto(User user);

    List<UserDto> toUsersDto(List<User> users);

    User toUser(UserDto dto);

    List<User> toUsers(List<UserDto> dto);

    User toUser(UserRegistrationDto dto);

    List<User> registrationsToUsers(List<UserRegistrationDto> dto);
}
