package com.example.spring.dto;

import lombok.Value;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link com.example.spring.entity.Entity41}
 */
@Value
public class Entity41Dto implements Serializable {
    Integer id;
    LocalDate orderDate;
    Integer productId;
    String productName;
    String productUnit;
    Integer productPrice;
    Integer quantity;
}