package com.pmt;

import com.pmt.dto.AuthDto;
import com.pmt.service.AuthService;
import com.zhimo.erp.framework.junit.MockData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest(classes = {PmtApplication.class, MockData.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class AuthServiceTest {

    @Autowired
    private AuthService authService;

    @Test
    public void login(){
        String username = "root";
        String password = "14e1b600b1fd579f47433b88e8d85291";
        AuthDto result = authService.login(username, password);
        System.out.println("result >>>>>>>" + result.toString());
    }

}
