package com.example.spring.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "my_table7", schema = "jpa")
public class Entity7 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", length = 3)
    private String name;

    @Column(name = "weight")
    private Double weight;

    @Column(name = "height")
    private Long height;

    @Column(name = "inserted_at")
    private LocalDateTime insertedAt;

}