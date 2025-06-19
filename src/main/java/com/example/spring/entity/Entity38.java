package com.example.spring.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "my_table38", schema = "jpa")
public class Entity38 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "title", nullable = false, length = 30)
    private String title;

    @Column(name = "content", nullable = false, length = 50)
    private String content;

    @ManyToOne // (fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "auther", nullable = false)
    private Entity37 auther;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "inserted_at", nullable = false ,insertable = false,updatable = false)
    private Instant insertedAt;

}