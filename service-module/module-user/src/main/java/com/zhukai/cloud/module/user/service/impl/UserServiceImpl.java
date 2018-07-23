package com.zhukai.cloud.module.user.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.zhukai.cloud.module.user.mapper.UserMapper;
import com.zhukai.cloud.module.user.model.UserCondition;
import com.zhukai.cloud.module.user.model.entity.User;
import com.zhukai.cloud.module.user.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {


    @Override
    public List<User> list(UserCondition condition) {
        EntityWrapper<User> entityWrapper = buildWrapper(condition);
        return selectPage(
                new Page<User>(condition.getCurrentPage(), condition.getPageSize()),
                entityWrapper
        ).getRecords();
    }

    private EntityWrapper<User> buildWrapper(UserCondition condition) {
        EntityWrapper<User> entityWrapper = new EntityWrapper<>();
        if (null != condition.getName()) {
            entityWrapper.like("name", condition.getName());
        }
        if (null != condition.getAge()) {
            entityWrapper.eq("age", condition.getAge());
        }
        if (null != condition.getGeCreateTime()) {
            entityWrapper.ge("createtime", condition.getGeCreateTime());
        }
        if (null != condition.getLeCreateTime()) {
            entityWrapper.le("createtime", condition.getLeCreateTime());
        }
        return entityWrapper;
    }
}
