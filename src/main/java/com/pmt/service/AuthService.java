package com.pmt.service;

import com.pmt.dto.AuthDto;
import com.pmt.dto.UserDto;
import com.pmt.dto.UserInfoDto;

public interface AuthService {
    AuthDto login(String username, String password);

    void logout();

    UserInfoDto getCurrentUser(String token);

    UserDto ping();
}
