package com.example.spring.dto;

public class MyBean039 {
    private String name;
    private String address;
    private Integer age;
    // 연습
    // property 들 만들기
    // name(읽기,쓰기), home(읽기,쓰기), age(읽기,쓰기)

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String gethome() {
        return address;
    }

    public void sethome(String home) {
        this.address = home;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

}
