package ChatRoom;

import java.sql.*;

public class DBConnection {
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/ChatRoom?useSSL=false&serverTimezone=UTC";

    private static String user = "root";
    private static String pwd = "wqnmlgb!";

    public static Connection connect(){
        Connection conn = null;
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,user,pwd);
        }catch (SQLException se){
            se.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
        return conn;
    }
}
