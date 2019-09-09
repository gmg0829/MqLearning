package com.example.bean;

import java.io.Serializable;

/**
 * @author gmg
 * @title: User
 * @projectName MqLearning
 * @description: TODO
 * @date 2019/9/9 11:06
 */
public class User implements Serializable {
    int id;
    String name;
    int age;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
