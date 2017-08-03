package com.laoge.apromise.dao.mapper;

import com.laoge.apromise.dao.entity.UserInfoPojo;

import java.util.List;

/**
 * Created by yuhou on 2017/5/9.
 */
public interface UserInfoMapper {

    List<UserInfoPojo> queryUserInfo(UserInfoPojo userInfoPojo);
}
