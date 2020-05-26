package com.jason.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Book {
    private int id;
    private String name;
    private String author;
    private String publish;
    private int pages;
    private float price;
    private BookCase bookCase;

    public Book(String name, String author, String publish) {
        this.name = name;
        this.author = author;
        this.publish = publish;
    }
}
