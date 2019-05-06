package com.pmt.service;

import com.pmt.dto.UserDto;
import org.springframework.cache.annotation.Cacheable;

import java.util.Collection;
import java.util.Map;

public interface UserService {

    UserDto obtainByUsername(String username);

    Map<String,UserDto> obtainByUsernameIn(Collection<String> usernames);
}
