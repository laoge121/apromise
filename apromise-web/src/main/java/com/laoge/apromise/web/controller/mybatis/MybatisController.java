package com.laoge.apromise.web.controller.mybatis;

import com.laoge.apromise.dao.entity.UserInfoPojo;
import com.laoge.apromise.service.mybatis.MybatisService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by yuhou on 2017/5/9.
 */
@RestController
@RequestMapping("/mybatis")
public class MybatisController {

    @Resource
    private MybatisService mybatisService;


    @RequestMapping("/queryData")
    public Object queryUserInfo(Long id) {
        UserInfoPojo userInfoPojo = new UserInfoPojo();
        userInfoPojo.setId(id);
        return mybatisService.queryUserInfo(userInfoPojo);
    }

}
