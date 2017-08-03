package com.laoge.apromise.service.mybatis;

import com.laoge.apromise.dao.entity.UserInfoPojo;

import java.util.List;

/**
 * Created by yuhou on 2017/5/9.
 */
public interface MybatisService {

    /**
     * 查询
     *
     * @param userInfoPojo
     * @return
     */
    List<UserInfoPojo> queryUserInfo(UserInfoPojo userInfoPojo);
}
