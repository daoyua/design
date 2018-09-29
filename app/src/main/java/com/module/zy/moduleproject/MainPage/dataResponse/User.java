package com.module.zy.moduleproject.MainPage.dataResponse;

import java.io.Serializable;

public class User implements Serializable {
    String name;
    String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "MainResponse{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
