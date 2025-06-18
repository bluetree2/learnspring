package com.example.spring.entity;

import jakarta.persistence.Embeddable;

@Embeddable
public class Entity26Id {
    private int name;
    private int address;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Entity26Id that = (Entity26Id) o;
        return name == that.name && address == that.address;
    }

    @Override
    public int hashCode() {
        int result = name;
        result = 31 * result + address;
        return result;
    }
}
