package com.example.spring.dto;

import java.time.LocalDate;

public interface OrderInfo {

    LocalDate getorderDate();
    String getProductName();
    Integer getQuantity();
    Integer getPrice();
    String getCategoryName();
}
