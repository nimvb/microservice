package com.example.nimvb.user.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
public class UserRegistrationDto extends UserDto {

    @NotNull(message = "Password is empty")
    @Size(min = 6,message = "Password length should be at least 6 character")
    private String password;
}
