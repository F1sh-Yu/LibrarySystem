package com.jason.entity;

import lombok.Data;

@Data
public class BookCase {
    private int id;
    private String name;

    @Override
    public String toString() {
        return "BookCase{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

}
