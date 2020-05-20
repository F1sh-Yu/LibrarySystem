package service.impl;

import dao.AdminDao;
import dao.ReaderDao;
import dao.impl.AdminDaoImpl;
import dao.impl.ReaderDaoImpl;
import entity.Admin;
import entity.Reader;
import service.LoginService;

public class LoginServiceImpl implements LoginService {

    ReaderDao readerDao = new ReaderDaoImpl();
    AdminDao adminDao = new AdminDaoImpl();

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
