package com.pmt;

import com.pmt.dto.UserDto;
import com.pmt.entity.User;
import com.pmt.service.UserService;
import com.zhimo.erp.framework.junit.MockData;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

@SpringBootTest(classes = {PmtApplication.class, MockData.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class UserServiceTest {
    @Autowired
    private MockData mockData;

    @Autowired
    private UserService userService;

    @Test
    public void obtainByUsername() {
        Set<User> users = mockData.getRandomDatas("user", User.class);
        Map<String, User> nameUserMap = users.stream().collect(Collectors.toMap(User::getUsername, Function.identity()));
        Set<String> usernames = users.stream().map(item -> item.getUsername()).collect(Collectors.toSet());
        Map<String, UserDto> userDtoMap = userService.obtainByUsernameIn(usernames);

        for (Map.Entry<String, UserDto> entry : userDtoMap.entrySet()) {
            String key = entry.getKey();
            Assert.assertEquals(entry.getValue().getId(), nameUserMap.get(key).getId());
        }
    }

}
