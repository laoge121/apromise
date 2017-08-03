package com.laoge.apromise.web.controller.error;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yuhou on 2017/5/10.
 */
@RestController
@RequestMapping("/errorT")
public class ErrorTestController {
    
    @Value("${my.uuid}")
    private String uuid;

    @Value("${my.pid}")
    private String pid;

    @RequestMapping("/test")
    public ResponseEntity<?> testError() {

        throw new RuntimeException("你猜猜@" + uuid + ";;;;" + pid);
    }
}
