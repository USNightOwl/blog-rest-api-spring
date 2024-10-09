package com.nxhawk.blogapi.payload;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginDto {
    @NotNull(message = "Username or Email is required")
    @Size(min = 4, message = "Username or Email must have at least 4 characters")
    private String usernameOrEmail;

    @NotNull(message = "Password is required")
    @Size(min = 5, message = "Password must have at least 5 characters")
    private String password;
}
