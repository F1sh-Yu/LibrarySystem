package service;

import entity.Book;
import entity.Borrow;

import java.util.List;

public interface BookService {
    public List<Book> findAll(int page);
    public int getPages();
    public void addBorrow(int bookId,int readerId);
    public List<Borrow> findAllByReaderId(int readerId,int page);
    public int getBorrowPages(int readerId);
    public List<Borrow> findBorrowByState(int page,int state);
    public int getBorrowPagesByState(int state);
    public void handleBorrow(int id,int adminId, int state);
}
