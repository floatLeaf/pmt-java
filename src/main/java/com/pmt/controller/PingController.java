package com.pmt.controller;

import com.pmt.dto.UserDto;
import com.pmt.service.AuthService;
import com.pmt.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/ping")
public class PingController {
    @Autowired
    private RedisCacheManager redisCacheManager;

    @Autowired
    private UserService userService;

    @Autowired
    private AuthService authService;

    @RequestMapping("/test")
    public String test() {
        InetAddress inetAddress;
        try {
            inetAddress = InetAddress.getLocalHost();
            String hostName = inetAddress.getHostName();
            String hostAddress = inetAddress.getHostAddress();
        }catch (UnknownHostException e) {
            e.printStackTrace();
        }

        return "sss";

    }

    @RequestMapping("/ping")
    public UserDto ping() {
        Subject subject = SecurityUtils.getSubject();
        UserDto prin = (UserDto) SecurityUtils.getSubject().getPrincipal();
        return prin;
//        return authService.ping();
    }
}
