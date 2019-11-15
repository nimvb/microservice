package com.example.nimvb.user.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
public class UserDto {
    @NotNull(message = "Username shouldn't be null")
    @Size(min = 3,max = 50,message = "Username should be at least 3 character.")
    private String username;
    @NotNull(message = "Email address shouldn't be null")
    @Email(message = "Invalid email address.")
    private String email;
}
