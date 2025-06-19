package com.example.spring.repository;

import com.example.spring.dto.OrderInfo;
import com.example.spring.entity.Entity41;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Entity41Repository extends JpaRepository<Entity41, Integer> {
    @Query(value = """
    select o.order_date, p.name product_name, p.price, o.quantity, c.name category_name
    from my_table39 p
        join my_table40 c
            on p.category_id = c.id
        join my_table41 o
            on o.product_id = o.id
    """,nativeQuery = true)
    List<OrderInfo> query1();
}
