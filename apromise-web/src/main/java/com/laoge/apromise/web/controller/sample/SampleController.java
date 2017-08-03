package com.laoge.apromise.web.controller.sample;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by yuhou on 2017/5/8.
 */
@Controller
@EnableAutoConfiguration
public class SampleController {

    private static Logger logger = LoggerFactory.getLogger(SampleController.class);

    @RequestMapping("/")
    @ResponseBody
    String home() {

        logger.info("查询测试日志:{}");

        return "Hello World!";
    }
}
