package com.laoge.apromise.web.controller.redis;

import com.laoge.apromise.service.redis.RedisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by yuhou on 2017/4/25.
 */
@RestController
@RequestMapping("/redis")
public class RedisController {

    private static final Logger logger = LoggerFactory.getLogger(RedisController.class);

    @Resource
    private RedisService redisService;

    @Autowired
    StringRedisTemplate stringRedisTemplate;


    @Resource(name = "stringRedisTemplate")
    ValueOperations<String, String> valueOperations;

    @RequestMapping("/set")
    public String setKeyAndValue(String key, String data) {

        logger.info("添加数据{}:{}", key, data);
        valueOperations.set(key, data);
        return "ok";
    }

    @RequestMapping("/get")
    public String getKey(String key) {
        return valueOperations.get(key);
    }

    @RequestMapping("/keyTest")
    public String test() {
        redisService.findUser(1L, "aa", "vvv");
        return "pl";
    }
}
