package com.pmt.service;

import com.pmt.dto.UserDto;

public interface AuthService {
    UserDto login(String username, String password);

    void logout();

    UserDto getCurrentUser();
//    UserDto getCurrentUser(String token);

    UserDto ping();
}
