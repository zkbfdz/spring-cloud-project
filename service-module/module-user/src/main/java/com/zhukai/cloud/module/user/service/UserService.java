package com.zhukai.cloud.module.user.service;

import com.baomidou.mybatisplus.service.IService;
import com.zhukai.cloud.module.user.model.UserCondition;
import com.zhukai.cloud.module.user.model.entity.User;

import java.util.List;

public interface UserService extends IService<User> {

    List<User> list(UserCondition condition);
}
