package utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCTools {
//    private static String DBDriver = "com.mysql.cj.jdbc.Driver";
//    private static String url = "jdbc:mysql://localhost:3306/Library?useUnicode=true&characterEncoding=UTF-8&useSSL=false";
//    private static String username = "root";
//    private static String password = "wqnmlgb!";
    private static DataSource dataSource = new ComboPooledDataSource("testc3p0");

    public static Connection getConnection(){
        Connection connection = null;
        try{
//            Class.forName(DBDriver);
//            connection = DriverManager.getConnection(url,username,password);
            connection = dataSource.getConnection();
        }catch (SQLException se){
            se.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
        return connection;
    }
}
