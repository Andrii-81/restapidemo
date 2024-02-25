package com.example.restapidemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
//@AllArgsConstructor
public class CustomerFileName {
    private int id;
    private String name;
    private int age;
    private String mobile_no;
    private String fileName;

    public CustomerFileName() {
    }
    public CustomerFileName(int id, String name, int age, String mobile_no, String fileName) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.mobile_no = mobile_no;
        this.fileName = fileName;
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

    public String getFileName() {
        return fileName;
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

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
