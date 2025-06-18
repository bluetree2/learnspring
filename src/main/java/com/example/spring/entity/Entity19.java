package com.example.spring.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "product", schema = "jpa")
public class Entity19 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "supplier_id")
    private Integer supplierId;

    @Column(name = "category_id")
    private Integer categoryId;

    @Column(name = "unit")
    private String unit;

    @Column(name = "price", precision = 10, scale = 2)
    private BigDecimal price;

}