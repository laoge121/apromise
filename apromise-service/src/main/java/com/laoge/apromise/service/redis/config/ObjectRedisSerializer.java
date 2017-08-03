package com.laoge.apromise.service.redis.config;

import org.springframework.core.convert.converter.Converter;
import org.springframework.core.serializer.support.DeserializingConverter;
import org.springframework.core.serializer.support.SerializingConverter;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

/**
 * Created by yuhou on 2017/5/8.
 */

public class ObjectRedisSerializer implements RedisSerializer<Object> {

    private Converter<byte[], Object> deSerializer = new DeserializingConverter();

    private Converter<Object, byte[]> serializer = new SerializingConverter();

    @Override
    public byte[] serialize(Object o) throws SerializationException {

        if (null == o) {
            return new byte[0];
        }

        return serializer.convert(o);

    }

    @Override
    public Object deserialize(byte[] bytes) throws SerializationException {
        if (null == bytes || bytes.length < 1) {
            return null;
        }

        return deSerializer.convert(bytes);

    }
}
