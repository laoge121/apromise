package com.laoge.apromise.service.redis.impl;

import com.laoge.apromise.api.entity.AddressEntity;
import com.laoge.apromise.api.entity.UserEntity;
import com.laoge.apromise.service.redis.RedisService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * Created by yuhou on 2017/5/8.
 */
@Service
public class RedisServiceImpl implements RedisService {

    @Cacheable(value = "userCache", keyGenerator = "wiselyKeyGenerator")
    @Override
    public UserEntity findUser(Long id, String firstName, String lastName) {
        System.out.println("findUser不走缓存");
        return new UserEntity(id, firstName, lastName);
    }

    @Cacheable(value = "addreddCache", key = "wiselyKeyGenerator")
    @Override
    public AddressEntity findAddress(Long id, String provice, String city) {
        System.out.println("findAddress不走缓存");

        return new AddressEntity(id, provice, city);
    }
}
