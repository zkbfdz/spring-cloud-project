package com.zhukai.cloud.module.user.config;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.zhukai.cloud.module.user.model.entity.User;
import com.zhukai.cloud.module.user.service.UserService;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

public class CustomRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;


    /**
     * 获取身份信息
     * shiro中,最终是通过 Realm 来获取应用程序中的用户,角色及权限信息的.
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("-----权限认证-----");
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();

        //获得该用户角色


        return null;
    }


    /**
     * 获取身份信息
     * shiro中,最终是通过 Realm 来获取应用程序中的用户,角色及权限信息的.
     *
     * @param authenticationToken 用户身份信息token
     * @return 返回风险黄了用户信息的 AuthenticationInfo 实例
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("-----身份验证方法-----");
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;

        // 从数据库中获取对应用户名密码的用户
        String password = userService.selectOne(new EntityWrapper<User>().eq("name", token.getUsername())).getPassword();

        if (StringUtils.isEmpty(password)) {
            throw new AccountException("用户名不正确");
        } else if (password.equals(new String((char[]) token.getCredentials()))) {
            throw new AccountException("密码不正确");
        }
        return new SimpleAuthenticationInfo(token.getPrincipal(), password, getName());
    }
}
