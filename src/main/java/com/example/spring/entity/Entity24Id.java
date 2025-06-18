package com.example.spring.entity;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class Entity24Id implements Serializable {
    private String name;
    private String address;

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof Entity24Id that)) return false;

        return Objects.equals(name, that.name) && Objects.equals(address, that.address);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(name);
        result = 31 * result + Objects.hashCode(address);
        return result;
    }
}
