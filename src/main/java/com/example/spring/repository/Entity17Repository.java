package com.example.spring.repository;

import com.example.spring.entity.Entity17;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface Entity17Repository extends JpaRepository<Entity17, Integer> {
    @Query(value = """
            SELECT *
            FROM employee
            WHERE birth_date BETWEEN :start AND :end
            """, nativeQuery = true)
    List<Entity17> query1(LocalDate start, LocalDate end);

    @Query(value = """
            SELECT *
            FROM employee
            WHERE first_name LIKE :keyword 
               OR last_name LIKE :keyword
            """, nativeQuery = true)
    List<Entity17> query2(String keyword);

    @Query("""
            SELECT e
            FROM Entity17 e
            WHERE e.firstName LIKE :keyword
               OR e.lastName LIKE :keyword
            """)
    List<Entity17> query3(String keyword);

    List<Entity17> findByBirthDateBetween(LocalDate start, LocalDate end);
}