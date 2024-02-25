package com.example.restapidemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
//@AllArgsConstructor
public class Customer {
    private int id;
    private String name;
    private int age;
    private String mobile_no;

    public Customer() {
    }

    public Customer(int id, String name, int age, String mobile_no) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.mobile_no = mobile_no;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getMobile_no() {
        return mobile_no;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setMobile_no(String mobile_no) {
        this.mobile_no = mobile_no;
    }
}
