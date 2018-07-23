package com.zhukai.cloud.module.user.controller;

import com.zhukai.cloud.module.user.model.UserCondition;
import com.zhukai.cloud.module.user.model.entity.User;
import com.zhukai.cloud.module.user.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;

    @Value("${info.profile}")
    private String profile;


    @ApiOperation(value = "用户列表")
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public List<User> list(@ModelAttribute UserCondition condition) {
        return userService.list(condition);
    }

    @RequestMapping("/profile")
    public String getProfile() {
        return this.profile;
    }

}
