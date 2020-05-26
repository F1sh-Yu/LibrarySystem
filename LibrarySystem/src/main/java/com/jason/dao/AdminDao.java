package com.jason.dao;

import com.jason.entity.Admin;

public interface AdminDao {
    public Admin login(String username,String password);
}
