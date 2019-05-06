package com.pmt.auth;

import com.pmt.dto.UserDto;
import com.pmt.dto.UserInfoDto;
import com.pmt.service.UserService;
import net.bytebuddy.implementation.bytecode.Throw;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.PasswordService;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Objects;

public class MyRealm extends AuthorizingRealm {

    @Autowired
    PasswordService passwordService;

    @Autowired
    private UserService userService;

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof UsernamePasswordToken;
    }

    /**
     * 在做权限判断的时候会调用
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
//        UserInfoDtoprincipals.getPrimaryPrincipal();
        return new SimpleAuthorizationInfo();
    }

    /**
     * 用户登录的时候，会调用此方法验证
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String) token.getPrincipal();
        String password =  new String((char[]) token.getCredentials());

        UserDto userDto = userService.obtainByUsername(username);
        if (userDto == null) {
            throw new UnknownAccountException();
        }

//        if (!passwordService.passwordsMatch(userDto.getPassword(), password)) {
//            throw new IncorrectCredentialsException("用户名或密码错误");
//        }

        return new SimpleAuthenticationInfo(userDto, password, getName());
    }
}
