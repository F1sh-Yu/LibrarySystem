package dao.impl;

import dao.ReaderDao;
import entity.Reader;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import utils.JDBCTools;

import java.sql.Connection;
import java.sql.SQLException;

public class ReaderDaoImpl implements ReaderDao {
    @Override
    public Reader login(String username, String password) {
        Connection connection = JDBCTools.getConnection();
        Reader reader = null;
        try{
            QueryRunner queryRunner = new QueryRunner();
            String sql = "select * from reader where username=? and password=?";
            reader = queryRunner.query(connection,sql,new BeanHandler<>(Reader.class),username,password);
        }catch (SQLException se){
            se.printStackTrace();
        }finally {
            try{
                connection.close();
            }catch (SQLException se){
                se.printStackTrace();
            }
        }
        return reader;
    }
}
