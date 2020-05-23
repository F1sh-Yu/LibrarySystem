package service.impl;

import dao.AdminDao;
import dao.ReaderDao;
import service.LoginService;
import utils.DBTools;

public class LoginServiceImpl implements LoginService {

    ReaderDao readerDao = DBTools.getSession().getMapper(ReaderDao.class);
    AdminDao adminDao = DBTools.getSession().getMapper(AdminDao.class);

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
