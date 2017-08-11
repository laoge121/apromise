package com.laoge.apromise.web;

import com.google.common.collect.Lists;
import com.laoge.apromise.SpringBootStartApplication;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.consumer.OffsetAndMetadata;
import org.apache.kafka.common.TopicPartition;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

/**
 * Created by yuhou on 2017/8/11.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = SpringBootStartApplication.class)
public class KafkaConsumerTest {

    /**
     * 测试自动提交 客户端请求
     */
    @Test
    public void testAutoConsumer() {

        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");//指定broker 最好全部指定
        props.put("group.id", "test");//订阅组id
        props.put("enable.auto.commit", "true");//是否自动提交
        props.put("auto.commit.interval.ms", "1000");//提交频率单位毫秒
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
        consumer.subscribe(Arrays.asList("my-topic-1"));//添加关注的组
        try {
            while (true) {
                ConsumerRecords<String, String> records = consumer.poll(100);
                for (ConsumerRecord<String, String> record : records)
                    System.out.printf("offset = %d, key = %s, value = %s%n", record.offset(), record.key(), record.value());
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            consumer.close();
        }
    }

    /**
     * 测试手动提交 客户端请求
     */
    @Test
    public void testManualConsumer() {


        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");//指定broker 最好全部指定
        props.put("group.id", "test");//订阅组id
        props.put("enable.auto.commit", "false");//是否自动提交
        props.put("auto.commit.interval.ms", "1000");//提交频率单位毫秒
        props.put("session.timeout.ms", "30000");//设置心跳超时时间
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

        KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(props);

        consumer.subscribe(Arrays.asList("my-topic-1"));

        int minBatchSize = 200;

        List<ConsumerRecord<String, String>> recordList = Lists.newArrayList();

        try {

            while (true) {
                ConsumerRecords<String, String> records = consumer.poll(100);

                for (ConsumerRecord<String, String> record : records)
                    recordList.add(record);

                if (recordList.size() >= minBatchSize) {
                    //输出
                    System.out.println(recordList);


                    consumer.commitSync();
                    recordList.clear();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            consumer.close();
        }
    }


    /**
     * 测试手动提交指定的分区 客户端请求
     */
    @Test
    public void testManualSpecialConsumer() {


        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");//指定broker 最好全部指定
        props.put("group.id", "test");//订阅组id
        props.put("enable.auto.commit", "false");//是否自动提交
        props.put("auto.commit.interval.ms", "1000");//提交频率单位毫秒
        props.put("session.timeout.ms", "30000");//设置心跳超时时间
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

        KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(props);

        consumer.subscribe(Arrays.asList("my-topic-1"));

        try {

            while (true) {
                ConsumerRecords<String, String> records = consumer.poll(Long.MAX_VALUE);

                for (TopicPartition topicPartition : records.partitions()) {
                    List<ConsumerRecord<String, String>> partitionRecords = records.records(topicPartition);
                    for (ConsumerRecord<String, String> record : partitionRecords) {
                        System.out.println(record.offset() + ";;;" + record.value());
                    }
                    long lastOffset = partitionRecords.get(partitionRecords.size() - 1).offset();
                    consumer.commitSync(Collections.singletonMap(topicPartition, new OffsetAndMetadata(lastOffset + 1)));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            consumer.close();
        }
    }
}
