package com.laoge.apromise.web;

import com.laoge.apromise.SpringBootStartApplication;
import org.apache.kafka.clients.producer.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Properties;

/**
 * Created by yuhou on 2017/8/11.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = SpringBootStartApplication.class)
public class KafkaProducerTest {

    @Test
    public void kafkaProducer() {
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("acks", "all");//判断是否发生成功
        props.put("retries", 0);//重试的次数(可能造成重复数据)
        props.put("batch.size", 16384);//一批的大小
        props.put("linger.ms", 1);//请求等待的时间 毫秒
        props.put("buffer.memory", 33554432);//生产者缓存总大小
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        Producer<String, String> producer = new KafkaProducer<>(props);

        for (int i = 0; i < 10; i++) {

            producer.send(new ProducerRecord<String, String>("my-topic-1", Integer.toString(i), Integer.toString(i)), new Callback() {
                @Override
                public void onCompletion(RecordMetadata recordMetadata, Exception e) {
                    if (null != e) {
                        e.printStackTrace();
                    }
                    System.out.print("the offset of the record we just sent is :" + recordMetadata.offset());
                }
            });
        }

        producer.close();
    }
}