package com.zhukai.cloud.module.user.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.zhukai.cloud.module.user.model.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
