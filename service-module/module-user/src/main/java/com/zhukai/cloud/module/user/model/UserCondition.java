package com.zhukai.cloud.module.user.model;

import com.zhukai.cloud.common.model.CommonCondition;

public class UserCondition extends CommonCondition {

    private String name;

    private Integer age;

    private Long geCreateTime;

    private Long leCreateTime;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Long getGeCreateTime() {
        return geCreateTime;
    }

    public void setGeCreateTime(Long geCreateTime) {
        this.geCreateTime = geCreateTime;
    }

    public Long getLeCreateTime() {
        return leCreateTime;
    }

    public void setLeCreateTime(Long leCreateTime) {
        this.leCreateTime = leCreateTime;
    }
}
