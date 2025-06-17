package com.example.spring.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "my_table3")
@Getter
@Setter
@ToString
public class Entity3 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    //    @Column(name = "email")
    // 클래스의 field명과 table의 컬럼명이 같으면 @Column 생략 가능
    private String email;
    //    @Column(name = "info")
    private String info;
    //    @Column(name = "nick")
    private String nick;
    private String country;

    // java 변수명 관습 lowerCamelCase
//    @Column(name = "home_address")
    private String homeAddress; // x

    //연습
    //work_address 테이블컬럼에 매핑되는
    // java field 작성하기
    private String workAddress;
}
