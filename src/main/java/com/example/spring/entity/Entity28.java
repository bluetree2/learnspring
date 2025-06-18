package com.example.spring.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "my_table28")
public class Entity28 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String productName;
    private Integer price;
    private String unit;

// category_id
//    @OneToOne(cascade = CascadeType.ALL)
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Entity27 category;
}
