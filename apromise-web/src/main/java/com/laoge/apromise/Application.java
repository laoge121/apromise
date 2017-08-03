package com.laoge.apromise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * Created by yuhou on 2017/5/8.
 */
@SpringBootApplication
@ServletComponentScan("com.laoge.apromise")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
}
