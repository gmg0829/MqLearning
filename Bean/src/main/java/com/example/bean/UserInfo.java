package com.example.bean;

import java.io.Serializable;

/**
 * @author gmg
 * @title: UserInfo
 * @projectName MqLearning
 * @description: TODO
 * @date 2019/9/9 11:08
 */
public class UserInfo implements Serializable {
    int userId;
    String name;
    int age;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
