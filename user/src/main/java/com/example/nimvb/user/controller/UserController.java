package com.example.nimvb.user.controller;

import com.example.nimvb.user.model.dto.UserDto;
import com.example.nimvb.user.model.dto.UserRegistrationDto;
import com.example.nimvb.user.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/users")
@Api(tags = "Users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public ResponseEntity getAllUsers() {
        return ResponseEntity.ok(userService.getUsers());
    }

    @GetMapping("{username}")
    public ResponseEntity getUser(@PathVariable("username") String username) {
        return ResponseEntity.ok(userService.getUser(username));
    }

    @PostMapping
    public ResponseEntity create(@Valid @RequestBody UserRegistrationDto dto, UriComponentsBuilder uriComponentsBuilder) {
        userService.create(dto);
        UriComponents uri = uriComponentsBuilder.path("/v1/users/{username}").buildAndExpand(dto.getUsername());
        return ResponseEntity.created(uri.toUri()).build();
    }

    @PutMapping
    public ResponseEntity update(@Valid @RequestBody UserDto dto) {
        userService.updateEmail(dto.getUsername(), dto.getEmail());
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{username}")
    public ResponseEntity delete(@PathVariable("username") String username) {
        userService.delete(username);
        return ResponseEntity.noContent().build();
    }

}
