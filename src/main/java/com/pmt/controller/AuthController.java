package com.pmt.controller;

import com.pmt.dto.AuthDto;
import com.pmt.dto.LoginRequestDto;
import com.pmt.dto.UserDto;
import com.pmt.service.AuthService;
import com.pmt.util.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @RequestMapping(value = "/login", method = {RequestMethod.POST, RequestMethod.GET})
    public ResponseEntity<?> login(@RequestBody LoginRequestDto request) {
        if (Objects.isNull(request.getUsername()) || Objects.isNull(request.getPassword())) {
            return ResponseEntity.success("thi is login page");
        }
        UserDto userDto = authService.login(request.getUsername(), request.getPassword());
        return ResponseEntity.success(userDto);
    }

    @RequestMapping(value = "success", method = {RequestMethod.POST, RequestMethod.GET})
    public String loginSuccess() {
        return "success";
    }

    @RequestMapping(value = "/getCurrentUser", method = {RequestMethod.GET, RequestMethod.POST})
    public ResponseEntity<UserDto> getCurrentUser() {
        UserDto userDto = authService.getCurrentUser();
        return ResponseEntity.success(userDto);
    }
}
