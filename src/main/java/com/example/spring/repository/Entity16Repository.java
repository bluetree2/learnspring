package com.example.spring.repository;

import com.example.spring.entity.Entity16;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Entity16Repository extends JpaRepository<Entity16, Integer> {
    // findById
    // save
    // deleteById


    // 직접 만드는 쿼리
    @Query(value = """
            SELECT *
            FROM customer
            WHERE country = :country
            """, nativeQuery = true)
    List<Entity16> query1(String country);

    @Query(value = """
            SELECT *
            FROM customer
            WHERE city = :city
            """, nativeQuery = true)
    List<Entity16> query2(String city);

    @Query(value = """
            SELECT *
            FROM customer
            WHERE city = :city1 
               OR city = :city2
            """, nativeQuery = true)
    List<Entity16> query3(String city1, String city2);

    @Query(value = """
            SELECT *
            FROM customer
            WHERE customer_name LIKE :keyword
            """, nativeQuery = true)
    List<Entity16> query4(String keyword);

    /*
    SQL
    @Query(value = """
            SELECT *
            FROM customer
            WHERE country = :country
            """, nativeQuery = true)
     */

    // JPQL
    @Query("""
            SELECT e
            FROM Entity16 e
            WHERE e.country = :country
            """)
    List<Entity16> query5(String country);

    // 연습
    // 도시이름으로 고객 조회하는 쿼리 JPQL로 작성
    // service, controller
    @Query("""
            SELECT a
            FROM Entity16 a
            WHERE a.city = :city
            """)
    List<Entity16> query6(String city);

    // SQL
//    @Query(value = """
//            SELECT *
//            FROM customer
//            WHERE customer_name LIKE :keyword
//            """, nativeQuery = true)
    // JPQL
    @Query("""
            SELECT c
            FROM Entity16 c
            WHERE c.customerName LIKE :keyword
            """)
    List<Entity16> query7(String keyword);


    /* JPQL
    @Query("""
            SELECT e
            FROM Entity16 e
            WHERE e.country = :country
            """)
     */
    List<Entity16> findByCountry(String country);

    Page<Entity16> findByCountry(String country, PageRequest id);
    // sql, jpql 안써도 됨
    // SELECT * FROM customer WHERE city = :city
    List<Entity16> findByCity(String city);


    List<Entity16> findByCustomerNameContainingOrContactNameContaining(String keyword, String keyword1);

    Page<Entity16> findByCustomerNameContainingOrContactNameContaining(String keyword, String keyword1, Pageable pageable);

    void deleteByCountry(String country);

    @Modifying // update, delete, insert에 붙이는 어노테이션
    @Query("""
            DELETE FROM Entity16 e
            WHERE e.country = :country
            """)
    void blukDeleteByCountry(String country);

}