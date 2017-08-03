package com.laoge.apromise.service.redis;

import com.laoge.apromise.api.entity.AddressEntity;
import com.laoge.apromise.api.entity.UserEntity;

/**
 * Created by yuhou on 2017/5/8.
 */
public interface RedisService {

    UserEntity findUser(Long id, String firstName, String lastName);

    AddressEntity findAddress(Long id, String provice, String city);
}
