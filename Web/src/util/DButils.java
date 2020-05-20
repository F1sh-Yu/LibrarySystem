package util;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DButils {
    private static String url = "JDBC:mysql://localhost:3306/Web";
    private static String username = "root";
    private static String password = "wqnmlgb!";
    private static Connection connection = null;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static Connection getConnection(){
        try {
            connection = DriverManager.getConnection(url,username,password);
        }catch (SQLException se){
            se.printStackTrace();
        }
        return connection;
    }
}
