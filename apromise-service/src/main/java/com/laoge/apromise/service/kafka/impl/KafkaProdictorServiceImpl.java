package com.laoge.apromise.service.kafka.impl;

import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.kafka.support.SendResult;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.util.Map;
import java.util.concurrent.ExecutionException;

/**
 * kafka生产者
 * Created by yuhou on 2017/8/10.
 */
public class KafkaProdictorServiceImpl {

    private static final Logger logger = LoggerFactory.getLogger(KafkaProdictorServiceImpl.class);

    @Autowired
    private KafkaTemplate kafkaTemplate;

    public void test() throws ExecutionException, InterruptedException {

        kafkaTemplate.send(new Message<String>() {

            @Override
            public String getPayload() {
                return "aaaaaaaaaa";
            }

            @Override
            public MessageHeaders getHeaders() {
                Map<String, Object> heads = Maps.newHashMap();
                heads.put(KafkaHeaders.TOPIC, "test");
                heads.put(KafkaHeaders.PARTITION_ID, "1");
                heads.put(KafkaHeaders.MESSAGE_KEY, "aa");
                MessageHeaders message = new MessageHeaders(heads);
                return message;
            }
        }).addCallback(new ListenableFutureCallback<SendResult<Integer, String>>() {
            @Override
            public void onSuccess(SendResult<Integer, String> result) {

                logger.info("send message infomation success!");
            }

            @Override
            public void onFailure(Throwable ex) {
                logger.info("send message infomation error{}!", ex);
            }
        });
    }
}
