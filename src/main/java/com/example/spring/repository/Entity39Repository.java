package com.example.spring.repository;

import com.example.spring.dto.ProductDto;
import com.example.spring.dto.ProductInfo;
import com.example.spring.entity.Entity39;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Entity39Repository extends JpaRepository<Entity39, Integer> {
    @Query(value = """
            select p.id, p.name product_name, p.price, c.name category_name
             from my_table39 p join my_table40 c 
             on p.category_id = c.id
            """,nativeQuery = true)
    List<ProductInfo> query1();
}