package dao.impl;

import dao.BorrowDao;
import entity.Book;
import entity.Borrow;
import entity.Reader;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import utils.JDBCTools;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BorrowDaoImpl implements BorrowDao {
    private Connection connection = null;
    private String sql =  null;
    private QueryRunner queryRunner = new QueryRunner();

    @Override
    public void insert(int bookId, int readerId, String borrowTime, String returnTime) {
        connection = JDBCTools.getConnection();
        sql = "insert into borrow(bookid,readerid,borrowtime,returntime,state) values(?,?,?,?,0)";
        try {
            queryRunner.update(connection,sql,bookId,readerId,borrowTime,returnTime);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally{
            try {
                connection.close();
            }catch (SQLException se){
                se.printStackTrace();
            }
        }
    }

    public List<Borrow> findAllByReaderId(int readerId,int index,int limit){
        connection = JDBCTools.getConnection();
        List<Borrow> borrows = new ArrayList<>();
        sql = "select b.id,name,author,publish,borrowtime,returntime," +
                "state from borrow b,book c where b.readerid=? and b.bookid=c.id limit ?,?";
        try {
            List<Map<String,Object>> maps= queryRunner.query(connection,sql,new MapListHandler(),readerId,index,limit);
            for(Map<String,Object>map:maps){
                Book book = new Book((String)map.get("name"),(String)map.get("author"),(String)map.get("publish"));
                sql = "select name,tel,cardid from reader where id=?";
                Reader reader = queryRunner.query(connection,sql,new BeanHandler<>(Reader.class),readerId);
                Borrow borrow = new Borrow((int)map.get("id"),book,reader,(String)map.get("borrowtime"),(String)map.get("returntime"),(int)map.get("state"));
                borrows.add(borrow);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try{
                connection.close();
            }catch (SQLException se){
                se.printStackTrace();
            }
        }
        return borrows;
    }

    @Override
    public int count(int readerId) {
        connection = JDBCTools.getConnection();
        sql = "select count(*) from borrow b,book c where b.readerid=? and b.bookid=c.id";
        int count=0;
        try {
            Number num =(Number)queryRunner.query(connection, sql, new ScalarHandler<Integer>(),readerId);
            count = num.intValue();
        }catch (SQLException se){
            se.printStackTrace();
        }finally {
            try{
                connection.close();
            }catch (SQLException se){
                se.printStackTrace();
            }
        }
        return count;
    }

    @Override
    public List<Borrow> findBorrowByState(int state, int index, int limit) {
        connection = JDBCTools.getConnection();
        sql = "select b.id,name,author,publish,readerid,borrowtime,returntime,state " +
                "from borrow b,book c where b.state=? and b.bookid=c.id limit ?,?";
        List<Borrow> borrows = new ArrayList<>();
        try {
            List<Map<String, Object>> maps = queryRunner.query(connection, sql, new MapListHandler(), state, index, limit);
            for (Map<String, Object> map : maps) {
                Book book = new Book((String) map.get("name"), (String) map.get("author"), (String) map.get("publish"));
                sql = "select name,tel,cardid from reader where id=?";
                Reader reader = queryRunner.query(connection, sql, new BeanHandler<>(Reader.class), (int) map.get("readerid"));
                Borrow borrow = new Borrow((int) map.get("id"), book, reader, (String) map.get("borrowtime"), (String) map.get("returntime"), (int) map.get("state"));
                borrows.add(borrow);
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return borrows;
    }

    @Override
    public int countByState(int state) {
        connection = JDBCTools.getConnection();
        sql = "select count(*) from borrow where state=?";
        int count=0;
        try {
            Number num =(Number)queryRunner.query(connection, sql, new ScalarHandler<Integer>(),state);
            count = num.intValue();
        }catch (SQLException se){
            se.printStackTrace();
        }finally {
            try{
                connection.close();
            }catch (SQLException se){
                se.printStackTrace();
            }
        }
        return count;
    }

    @Override
    public void handleBorrow(int id, int adminId, int state) {
        connection = JDBCTools.getConnection();
        sql = "update borrow set adminid=?,state=? where id=?";
        try{
            queryRunner.update(connection,sql,adminId,state,id);
        }catch (SQLException se){
            se.printStackTrace();
        }finally {
            try{
                connection.close();
            }catch (SQLException se){
                se.printStackTrace();
            }
        }
    }
}
