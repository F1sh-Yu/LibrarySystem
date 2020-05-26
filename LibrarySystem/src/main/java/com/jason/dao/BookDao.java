package com.jason.dao;

import com.jason.entity.Book;

import java.util.List;

public interface BookDao {
    public List<Book> findAll(int index,int limit);
    public int count();
}
