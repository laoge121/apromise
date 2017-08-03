package com.laoge.apromise.web.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.stereotype.Component;

/**
 * 系统启动后回调相关接口,
 * Created by yuhou on 2017/5/11.
 */
@Component
public class AppStartStopListener implements CommandLineRunner, ApplicationRunner, DisposableBean,ExitCodeGenerator {

    private static final Logger logger = LoggerFactory.getLogger(AppStartStopListener.class);

    @Override
    public void run(String... args) throws Exception {

        logger.info("AppStartStopListener.CommandLineRunner.run-《》《》CommandLineRunner《》《》-启动");

    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        logger.info("AppStartStopListener.ApplicationRunner.run-《》《》ApplicationRunner《》《》-启动");

        logger.info(args.toString());
    }


    @Override
    public void destroy() throws Exception {
        logger.info("AppStartStopListener.destory.run-《》《》destroy《》《》-结束");
    }

    @Override
    public int getExitCode() {
        return 101;
    }
}
