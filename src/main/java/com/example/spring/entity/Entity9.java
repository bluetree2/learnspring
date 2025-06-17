package com.example.spring.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "my_table9")
public class Entity9 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String city;
    private String country;
    private Double latitude;
    private Double longitude;
    private LocalDateTime createdAt;
}
