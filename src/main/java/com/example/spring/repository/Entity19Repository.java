package com.example.spring.repository;

import com.example.spring.entity.Entity19;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Entity19Repository extends JpaRepository<Entity19, Integer> {

    // 연습
    // select * fromk product where category_id : categoryId
    List<Entity19> findByCategoryId(Integer id);

    // select * fromk product where supplier_id : supplierId
    List<Entity19> findBySupplierId(Integer id);

    // select * fromk product where price between : p1 and p2
    List<Entity19> findByPriceBetween(Double lower, Double higher);
    List<Entity19> findByPriceGreaterThanEqualAndPriceLessThanEqual(Double lower, Double higher);

    // select * fromk product where price >= :price
    List<Entity19> findByPriceGreaterThanEqual(double v);

    // select * fromk product where category_id  in (?, ?...?)
    List<Entity19> findByCategoryIdIn(List<Integer> integers);
    // select * fromk product where product_name LIKE :keyword
    // with wildcard
    List<Entity19> findByProductNameLike(String s);
    // withoiut wildcard
    List<Entity19> findByProductNameContaining(String an);

    /*
    select *
    from product
    wherer category_id = :id
    order by price desc
    */
    @Query(value = """
            SELECT *
            FROM product
            WHERE category_id = :id
            ORDER BY price DESC
            """, nativeQuery = true)
    List<Entity19> query1(Integer id);

    @Query("""
            SELECT p
            FROM Entity19 p
            WHERE p.categoryId = :id
            ORDER BY p.price DESC
            """)
    List<Entity19> query2(Integer id);

    List<Entity19> findByCategoryIdOrderByPrice(Integer id);
    List<Entity19> findByCategoryIdOrderByPriceAsc(Integer id);
    List<Entity19> findByCategoryIdOrderByPriceDesc(Integer id);


}