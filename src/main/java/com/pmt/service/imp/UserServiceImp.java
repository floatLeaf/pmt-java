package com.pmt.service.imp;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.pmt.dto.UserDto;
import com.pmt.entity.User;
import com.pmt.repository.UserRepository;
import com.pmt.service.UserService;
import com.zhimo.erp.framework.utils.Transformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    @Cacheable(cacheNames = "obtainByUsername", key = "#root.methodName+'['+#id+']'")
    public UserDto obtainByUsername(String username) {
        List<String> usernames = Lists.newArrayList(username);
        return obtainByUsernameIn(usernames).getOrDefault(username, null);
    }

    @Override
    public Map<String, UserDto> obtainByUsernameIn(Collection<String> usernames) {
        List<User> userList = userRepository.findByUsernameIn(usernames);
        Preconditions.checkArgument(!userList.isEmpty(), "cannot find user by usernames: " + usernames.toString());
        return userList.stream().map(item -> Transformer.transform(item, UserDto.class))
                .collect(Collectors.toMap(UserDto::getUsername, Function.identity()));
    }
}
