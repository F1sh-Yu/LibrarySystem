package dao.impl;

import dao.AdminDao;
import entity.Admin;
import entity.Reader;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import utils.JDBCTools;

import java.sql.Connection;
import java.sql.SQLException;

public class AdminDaoImpl implements AdminDao {

    @Override
    public Admin login(String username,String password){
            Connection connection = JDBCTools.getConnection();
            Admin admin = null;
            try{
                QueryRunner queryRunner = new QueryRunner();
                String sql = "select * from bookadmin where username=? and password=?";
                admin = queryRunner.query(connection,sql,new BeanHandler<>(Admin.class),username,password);
            }catch (SQLException se){
                se.printStackTrace();
            }finally {
                try{
                    connection.close();
                }catch (SQLException se){
                    se.printStackTrace();
                }
            }
            return admin;
    }
}

