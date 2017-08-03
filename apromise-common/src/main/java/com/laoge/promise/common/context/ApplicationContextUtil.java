package com.laoge.promise.common.context;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

/**
 * Created by yuhou on 2017/5/11.
 */
@Component
public class ApplicationContextUtil implements ApplicationContextInitializer {

    private static ConfigurableApplicationContext applicationContext;

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {

        this.applicationContext = applicationContext;
    }

    public static Object getBean(String name) {
        return applicationContext.getBean(name);
    }


    public ConfigurableApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public void setApplicationContext(ConfigurableApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }
}
