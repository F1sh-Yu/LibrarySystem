package com.jason.dao;

import com.jason.entity.Reader;

public interface ReaderDao {
    public Reader login(String username,String password);
}
