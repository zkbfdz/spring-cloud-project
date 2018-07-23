package com.zhukai.cloud.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping
public class ConfigClientApp {

    @Value("${info.profile}")
    private String profile;

    public static void main(String[] args) {
        new SpringApplicationBuilder(ConfigClientApp.class).web(true).run(args);
    }

    @RequestMapping("info")
    public String getProfile() {
        return this.profile;
    }

}
