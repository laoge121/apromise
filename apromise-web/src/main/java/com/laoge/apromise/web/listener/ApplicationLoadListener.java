package com.laoge.apromise.web.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * Created by yuhou on 2017/5/10.
 */
@Component
public class ApplicationLoadListener implements ApplicationListener<ApplicationEvent> {

    private static final Logger logger = LoggerFactory.getLogger(ApplicationLoadListener.class);

    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
         
        if (applicationEvent instanceof ApplicationReadyEvent) {
            logger.info("系统环境初始ok!");
        }
    }
}
