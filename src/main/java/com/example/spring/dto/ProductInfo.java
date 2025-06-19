package com.example.spring.dto;

public interface ProductInfo {
//    select p.id, p.name product_name, p.price, c.name category_name
    Integer getId();
    String getproductName();
    Integer getPrice();
    String getCategoryName();
}
