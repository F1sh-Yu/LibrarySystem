package dao;

import entity.Borrow;

import java.util.List;

public interface BorrowDao {
    public void insert(int bookId,int readerId,String borrowTime,String returnTime);
    public List<Borrow> findAllByReaderId(int readerId,int index,int limit);
    public int count(int readerId);
    public List<Borrow> findBorrowByState(int state,int index,int limit);
    public int countByState(int state);
    public void handleBorrow(int id, int adminId, int state);
}
