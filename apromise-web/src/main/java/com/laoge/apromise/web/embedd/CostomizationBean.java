package com.laoge.apromise.web.embedd;

import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.stereotype.Component;

/**
 * 定制化嵌入容量控制 --一般不使用 直接通过application.properties 进行设置
 * Created by yuhou on 2017/5/11.
 */
//@Component
public class CostomizationBean implements EmbeddedServletContainerCustomizer {
    @Override
    public void customize(ConfigurableEmbeddedServletContainer container) {
        container.setPort(9000);
    }
}
