package com.example.spring.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class Entity25Id implements Serializable {
    private static final long serialVersionUID = -1506955883975953080L;
    @Column(name = "name", nullable = false, length = 30)
    private String name;

    @Column(name = "address", nullable = false, length = 100)
    private String address;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Entity25Id entity = (Entity25Id) o;
        return Objects.equals(this.address, entity.address) &&
                Objects.equals(this.name, entity.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address, name);
    }

}