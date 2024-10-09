package com.nxhawk.blogapi.service;

import com.nxhawk.blogapi.payload.RegisterDto;

public interface AuthService {
    String register(RegisterDto registerDto);
}
