package com.pmt.service.imp;

import com.google.common.base.Preconditions;
import com.pmt.dto.UserDto;
import com.pmt.exception.PmtServiceException;
import com.pmt.service.AuthService;
import com.pmt.service.UserService;
import com.pmt.util.JWTUtil;
import com.zhimo.erp.framework.utils.Transformer;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImp implements AuthService {
    private static final Logger LOGGER = LoggerFactory.getLogger(AuthServiceImp.class);

    @Autowired
    private UserService userService;

    @Override
    public UserDto login(String username, String password) {
        Preconditions.checkArgument(username != null, "用户名不能为空");
        Preconditions.checkArgument(password != null, "密码不能为空");
        UserDto userDto = login(new UsernamePasswordToken(username, password));
        userDto.setPassword(null);
        return userDto;

//        AuthDto authDto = new AuthDto();
//        authDto.setToken(JWTUtil.sign(userDto.getUsername(), userDto.getPassword()));
//        return authDto;
    }

    @Override
    public void logout() {
        SecurityUtils.getSubject().logout();
    }

    @Override
    public UserDto getCurrentUser() {
        return (UserDto) SecurityUtils.getSubject().getPrincipal();

//        Preconditions.checkArgument(token != null, "cannot find user by token null");
//        String username = JWTUtil.getUsername(token);
//        UserDto userDto = userService.obtainByUsername(username);
//
//        if (!JWTUtil.verify(token, username, userDto.getPassword())) {
//            throw new IllegalArgumentException("token 校验失败");
//        }
//        return Transformer.transform(userDto, UserInfoDto.class);
    }

    public UserDto login(AuthenticationToken token) {
        try {
            SecurityUtils.getSubject().login(token);
        }catch (UnknownAccountException e) {
            LOGGER.error("账号不存在: {}", token);
            throw new PmtServiceException(401, "账号不存在");
        }catch (IncorrectCredentialsException e) {
            LOGGER.error("账号或密码错误: {}", token);
            throw new PmtServiceException(401, "账号或密码错误");
        }catch (AuthenticationException e) {
            LOGGER.error("账号认证失败: {}", token);
            throw new PmtServiceException(401, "账号认证失败");
        }

        Subject subject = SecurityUtils.getSubject();
        return (UserDto) SecurityUtils.getSubject().getPrincipal();
    }

    public UserDto ping() {
        Subject subject = SecurityUtils.getSubject();
        UserDto prin = (UserDto) SecurityUtils.getSubject().getPrincipal();
        return prin;
    }
}

