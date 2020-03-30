package cn.yykjc.redis_demo.redis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class RedisUserApi {

    @Autowired
    RedisTemplate redisTemplate;

    @GetMapping("/setValue")
    public Object setValue(String str) {

        redisTemplate.opsForValue().set("str",str);
        return "Redis取回的数据为:" + redisTemplate.opsForValue().get("str");
    }

    @GetMapping("/setHash")
    public Object setHash() {
        redisTemplate.opsForHash().put("hashKey","key","log");
        return redisTemplate.opsForHash().get("hashKey","key");
    }
}