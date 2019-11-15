package com.example.nimvb.user.service;

import com.example.nimvb.user.exception.EmailAlreadyRegisteredException;
import com.example.nimvb.user.exception.UserAlreadyExistException;
import com.example.nimvb.user.exception.UserNotFoundException;
import com.example.nimvb.user.mapping.UserMapper;
import com.example.nimvb.user.model.User;
import com.example.nimvb.user.model.dto.UserDto;
import com.example.nimvb.user.model.dto.UserRegistrationDto;
import com.example.nimvb.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository repository;

    @Autowired
    ProfileService profileService;

    @Override
    public List<UserDto> getUsers() {
        return UserMapper.INSTANCE.toUsersDto(repository.findAll());
    }

    @Override
    public UserDto getUser(String username) {
        User user = repository.findByUsername(username).orElseThrow(UserNotFoundException::new);
        return UserMapper.INSTANCE.toUserDto(user);
    }

    @Override
    public void create(UserRegistrationDto dto) {
        User user = UserMapper.INSTANCE.toUser(dto);
        try {
            repository.save(user);
        } catch (DataIntegrityViolationException ex) {
            throw new UserAlreadyExistException();
        }
    }

    @Override
    public void updateEmail(String username, String email) {
        if (!profileService.isEmailExists(email)) {
            User user = repository.findByUsername(username).orElseThrow(UserNotFoundException::new);
            user.setEmail(email);
            repository.save(user);
            return;
        }

        throw new EmailAlreadyRegisteredException();

    }

    @Override
    public void delete(String username) {
        User user = repository.findByUsername(username).orElseThrow(UserNotFoundException::new);
        repository.delete(user);
    }
}
