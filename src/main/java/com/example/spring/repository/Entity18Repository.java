package com.example.spring.repository;

import com.example.spring.entity.Entity18;
import com.example.spring.entity.Entity19;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Entity18Repository extends JpaRepository<Entity18, Integer> {
    // findById
    // save
    // deleteById

    // SQL
    // JPQL

    // 메소드 이름으로 쿼리만들기

    /*
    SELECT * FROM supplier WHERE country = :country
     */
    List<Entity18> findByCountry(String uk);

    // 연습
  /*
  SELECT * FROM supplier WHERE city = :city
   */
    List<Entity18> findByCity(String city);

    /*
    SELECT * FROM supplier WHERE supplier_name LIKE :keyword
     */
    // keyword 에 %(wildcard) 붙여서 호출
    List<Entity18> findBySuppliernameLike(String keyword);

    // keyword 에 % 안 붙여서 호출
    List<Entity18> findBySupplierNameContains(String keyword);

    /*
    SELECT * FROM supplier WHERE county IN (?, ?, ?)
     */
    List<Entity18> findByCountryIn(List<String> country);

    // 연습
    // SELECT * FROM supplier WHERE county IN (?, ?, ?) ORDER BY supplier_name
    List<Entity19> findByCountryInOrderBySupplierName(List<String> country);

    //    SELECT * FROM supplier WHERE supplier_name LIKE :keyword ORDER BY supplier_name DESC
    List<Entity19> findbySupplierNameContainerOrderBySupplierName(String supplierName);

    void deleteByCountry(String country);

    @Modifying // update, delete, insert에 붙이는 어노테이션
    @Query("""
            DELETE FROM Entity16 e
            WHERE e.country = :country
            """)
    void blukDeleteByCountry(String country);
    // query method 만들기



}