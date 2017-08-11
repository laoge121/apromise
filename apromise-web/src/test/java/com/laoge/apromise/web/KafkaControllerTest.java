package com.laoge.apromise.web;

import com.laoge.apromise.SpringBootStartApplication;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Created by yuhou on 2017/8/11.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringApplicationConfiguration(classes = SpringBootStartApplication.class)
public class KafkaControllerTest {
}
