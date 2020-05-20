package ChatRoom;

import java.sql.*;
import java.util.HashMap;

public class DaoTools {
    private static Connection conn = null;
    private static PreparedStatement st = null;
    private static ResultSet rs = null;

    public static boolean checkLogin(UserInfo user){
        Connection conn = DBConnection.connect();
        String sql = "SELECT * FROM User where name = ?";
        try{
            st = conn.prepareStatement(sql);
            st.setString(1,user.getName());
            rs = st.executeQuery();
            if(rs.next()){
                String pwd = rs.getString("pwd");
                if(pwd.equals(user.getPassword()))return true;
                System.out.println("密码错误");
                return false;
            }
            close();
        }catch (SQLException se){
            se.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("用户不存在");
        return false;
    }

    public static boolean register(UserInfo user)throws Exception {
        conn = DBConnection.connect();
        String check = "SELECT * FROM User where name = ?";
        String insert = "Insert into User(name,pwd) values(?,?)";
        try{
            st = conn.prepareStatement(check);
            st.setString(1, user.getName());
            rs = st.executeQuery();
            if(rs.next()){
                close();
                return false;
            }
            else{
                st = conn.prepareStatement(insert);
                st.setString(1,user.getName());
                st.setString(2,user.getPassword());
                st.executeUpdate();
                System.out.println("注册成功！");
            }
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        close();
        return true;
    }

    private static void close()throws Exception{
        conn.close();
        st.close();
        rs.close();
    }
}
