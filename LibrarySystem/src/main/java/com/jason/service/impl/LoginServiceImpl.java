package com.jason.service.impl;

import com.jason.dao.AdminDao;
import com.jason.dao.ReaderDao;
import com.jason.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private AdminDao adminDao;
    @Autowired
    private ReaderDao readerDao;

    @Override
    public Object login(String username, String password,String type) {
        Object user = new Object();
        switch (type){
            case "reader":
                user = readerDao.login(username,password);
                break;
            case "admin":
                user = adminDao.login(username,password);
                break;
       }
        return user;
    }
}
