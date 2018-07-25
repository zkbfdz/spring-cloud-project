package com.zhukai.cloud.module.user.config;

import com.google.common.collect.Maps;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
public class ShiroConfig {

    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(SecurityManager securityManager){

        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

        //设置SecurityManager
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        //setLoginUrl 如果不设置值,默认会自动寻找web工程下的"/login.jsp"页面或"/login"映射
        shiroFilterFactoryBean.setLoginUrl("/notLogin");

        //设置无权限是跳转的Url
        shiroFilterFactoryBean.setUnauthorizedUrl("/notRole");


        //设置拦截器
        Map<String, String> filterChainDefinitionMap = Maps.newLinkedHashMap();
        //游客,开发权限
        filterChainDefinitionMap.put("/guest/**", "anon");
        //用户,需要角色权限user
        filterChainDefinitionMap.put("/user/**", "roles[user]");
        //管理员,需要角色权限admin
        filterChainDefinitionMap.put("/admin/**", "roles[admin]");
        //开放登录接口
        filterChainDefinitionMap.put("/login", "anon");
        //其余接口一律拦截
        //主要这行代码必须放在所有权限设置的最后,不谈会导致所有url都会被拦截
        filterChainDefinitionMap.put("/**", "authc");


        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        System.out.println("Shiro拦截器注入成功!");
        return shiroFilterFactoryBean;
    }

    /**
     * 自定义身份认证realm
     *
     * 必须写这个类,并加上@Bean注解,目的是注入CustomRealm,
     * 否则会影响CustomRealm类中其他类的依赖注入
     */
    @Bean
    public CustomRealm customRealm() {
        return new CustomRealm();
    }

    /**
     * 注入securityManager
     */
    @Bean
    public SecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //设置realm
        securityManager.setRealm(customRealm());
        return securityManager;
    }

}
