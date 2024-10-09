package com.nxhawk.blogapi.service;

import com.nxhawk.blogapi.payload.LoginDto;
import com.nxhawk.blogapi.payload.RegisterDto;

public interface AuthService {
    String login(LoginDto loginDto);
    String register(RegisterDto registerDto);
}
