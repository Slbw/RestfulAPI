package com.ifxme.api.model;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Created by abcca on 2016/8/22 0022.
 */
public class User implements Serializable{

    private int id;
    private String name;
    private String phone;
    private String role;
    private int sex;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }




    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }
}
