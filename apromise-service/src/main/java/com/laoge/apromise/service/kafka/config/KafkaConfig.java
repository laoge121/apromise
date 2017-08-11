package com.laoge.apromise.service.kafka.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.Map;

/**
 * Created by yuhou on 2017/8/10.
 */
@Configuration
@EnableConfigurationProperties(KafkaProperties.class)
public class KafkaConfig {

    @Autowired
    private KafkaProperties kafkaProperties;

    @Bean
    public Map<String, Object> producerCofigs() {
        return kafkaProperties.buildConsumerProperties();
    }

    @Bean
    public ProducerFactory<Integer, String> producerFactory() {

        return new DefaultKafkaProducerFactory<Integer, String>(producerCofigs());
    }

    @Bean
    public KafkaTemplate<Integer, String> kfkaTemplate() {
        return new KafkaTemplate<Integer, String>(producerFactory());
    }
}
