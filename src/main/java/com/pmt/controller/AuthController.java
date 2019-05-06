package com.pmt.controller;

import com.pmt.dto.AuthDto;
import com.pmt.service.AuthService;
import com.pmt.util.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @RequestMapping(value = "/login", method = {RequestMethod.POST, RequestMethod.GET})
    public ResponseEntity<?> login(@RequestParam(name = "username") String username, @RequestParam(name = "password") String password) {
        AuthDto authDto = authService.login(username, password);
        return ResponseEntity.success(authDto);
    }
}
