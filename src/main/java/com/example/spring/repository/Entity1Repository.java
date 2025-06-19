package com.example.spring.repository;

import com.example.spring.entity.Entity1;
import com.example.spring.entity.Entity39;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Entity1Repository extends JpaRepository<Entity1, Integer> {
    interface Entity39Repository extends JpaRepository<Entity39, Integer> {
    }
}
