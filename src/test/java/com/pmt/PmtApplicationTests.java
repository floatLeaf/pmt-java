package com.pmt;

import com.google.common.collect.Maps;
import com.pmt.dto.AuthDto;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PmtApplicationTests {
    @Autowired
    private RedisTemplate<Object, Object> template;

    @Test
    public void contextLoads() {
    }

    @Test
    public void redisTest() {

        template.delete(Lists.newArrayList("list", "ldt", "name", "map"));
        List<AuthDto> list = Lists.newArrayList();
        list.add(new AuthDto("你是一个好人1"));
        list.add(new AuthDto("你是一个好人2"));
        template.opsForList().leftPush("list", list);
        List<AuthDto> result = (List<AuthDto>) template.opsForList().leftPop("list");

        List<LocalDateTime> ldtList = Lists.newArrayList();
        ldtList.add(LocalDateTime.now());
        ldtList.add(LocalDateTime.MIN);
        template.opsForList().leftPush("ldt", ldtList);
        List<LocalDateTime> ldt = (List<LocalDateTime>) template.opsForList().leftPop("ldt");

        template.opsForValue().set("name", "xu");
        String name = (String) template.opsForValue().get("name");

        Map<String, String> map = Maps.newHashMap();
        map.put("name", "lucy");
        map.put("friend", "liu");
        template.opsForHash().putAll("map", map);
        Map<Object, Object> mapResult = (Map<Object, Object>) template.opsForHash().entries("map");

        System.out.println("result>>>>>>>>>>>>>>>>>>>>>>>>>>>" + mapResult);

    }

}
