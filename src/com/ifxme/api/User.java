package com.ifxme.api;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by abcca on 2016/8/22 0022.
 */
public class User {

    private int id;
    private String username;
    private int age;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


}
