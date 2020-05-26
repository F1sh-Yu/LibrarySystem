package com.jason.service.impl;

import com.jason.dao.BookDao;
import com.jason.dao.BorrowDao;
import com.jason.entity.Book;
import com.jason.entity.Borrow;
import com.jason.service.BookService;
import com.jason.utils.DBTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    public static final int LIMIT = 10;
    @Autowired
    private BookDao bookDao;
    @Autowired
    private BorrowDao borrowDao;

    @Override
    public List<Book> findAll(int page) {
        int index = (page-1)*LIMIT;
        return bookDao.findAll(index,LIMIT);
    }

    @Override
    public int getPages() {
        int count = bookDao.count();
        int pages = (int)Math.ceil((double)count/LIMIT);
        return pages;
    }

    @Override
    public void addBorrow(int bookId, int readerId) {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String borrowTime = simpleDateFormat.format(date);
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE,14);
        String returnTime = simpleDateFormat.format(calendar.getTime());
        borrowDao.insert(bookId,readerId,borrowTime,returnTime);
    }

    @Override
    public List<Borrow> findAllByReaderId(int readerId,int page){
        int index = (page-1)*LIMIT;
        return borrowDao.findAllByReaderId(readerId,index,LIMIT);
    }

    @Override
    public int getBorrowPages(int readerId) {
        int count = borrowDao.count(readerId);
        int pages = (int)Math.ceil((double)count/LIMIT);
        return pages;
    }

    @Override
    public List<Borrow> findBorrowByState(int page, int state) {
        int index = (page-1)*LIMIT;
        return borrowDao.findBorrowByState(state,index,LIMIT);
    }

    @Override
    public int getBorrowPagesByState(int state) {
        int count = borrowDao.countByState(state);
        int pages = (int)Math.ceil((double)count/LIMIT);
        return pages;
    }

    @Override
    public void handleBorrow(int id, int adminId, int state) {
        borrowDao.handleBorrow(id,adminId,state);
    }
}
