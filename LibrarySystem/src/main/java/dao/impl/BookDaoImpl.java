package dao.impl;

import dao.BookDao;
import entity.Book;
import entity.BookCase;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import utils.JDBCTools;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import static java.lang.Character.getType;

public class BookDaoImpl implements BookDao {
    private QueryRunner queryRunner = new QueryRunner();
    private String sql = null;

    @Override
    public List<Book> findAll(int index,int limit) {
        Connection connection = JDBCTools.getConnection();
        sql ="select * from book limit ?,?";
        List<Book>booklist = null;
        BookCase bookcase = null;
        try{
            booklist = queryRunner.query(connection,sql,new BeanListHandler<>(Book.class),index,limit);
        }catch (SQLException se) {
            se.printStackTrace();
        }
        try{
            sql = "select c.id,c.name from bookcase c inner join book b on c.id = b.bookcaseid where b.id=?";
            for(Book book:booklist){
                bookcase = queryRunner.query(connection,sql,new BeanHandler<>(BookCase.class),book.getId());
                book.setBookCase(bookcase);
            }
        }catch (SQLException se){
            se.printStackTrace();
        }finally {
            try{
                connection.close();
            }catch (SQLException se){
                se.printStackTrace();
            }
        }
        return booklist;
    }

    @Override
    public int count() {
        Connection connection = JDBCTools.getConnection();
        sql = "select count(*) from book";
        int count = 0;
        try {
            Number num =(Number)queryRunner.query(connection, sql, new ScalarHandler<Integer>());
            count = num.intValue();
        }catch (SQLException se){
            se.printStackTrace();
        }
        return count;
    }
}
