package com.laoge.apromise.service.mybatis.impl;

import com.laoge.apromise.dao.entity.UserInfoPojo;
import com.laoge.apromise.dao.mapper.UserInfoMapper;
import com.laoge.apromise.service.mybatis.MybatisService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by yuhou on 2017/5/9.
 */
@Service
public class MybatisServiceImpl implements MybatisService {

    @Resource
    private UserInfoMapper userInfoMapper;

    @Override
    public List<UserInfoPojo> queryUserInfo(UserInfoPojo userInfoPojo) {
        return userInfoMapper.queryUserInfo(userInfoPojo);
    }
}
