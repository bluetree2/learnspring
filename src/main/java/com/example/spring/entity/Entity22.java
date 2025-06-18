package com.example.spring.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "my_table22", schema = "jpa")
public class Entity22 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "address", length = 20)
    private String address;

    @Column(name = "coiuntry", length = 20)
    private String coiuntry;

}