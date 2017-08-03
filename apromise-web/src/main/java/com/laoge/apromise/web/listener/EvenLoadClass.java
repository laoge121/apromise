package com.laoge.apromise.web.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * Created by yuhou on 2017/5/11.
 */
@Component
@Profile("dev")//指定特别的环境 进行加载
public class EvenLoadClass {

    private static final Logger logger = LoggerFactory.getLogger(EvenLoadClass.class);

    public EvenLoadClass() {
        logger.info("指定的环境加载!!!!====《》《》");
    }
}
