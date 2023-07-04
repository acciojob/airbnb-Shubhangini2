package com.driver.model;

public class User {

    private int aadharCardNo; //This is the unique key that determines a unique user
    private String name;
    private int age;

    public User(int aadharCardNo, String name, int age) {
        this.aadharCardNo = aadharCardNo;
        this.name = name;
        this.age = age;
    }

    public int getAadharCardNo() {
        return aadharCardNo;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
