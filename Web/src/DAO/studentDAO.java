package DAO;

import entity.Student;
import util.DButils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class studentDAO {
    private Connection connection = null;
    private PreparedStatement st = null;
    private ResultSet rs = null;
    private String sql=null;

    public List<Student> findAll() {
        List<Student> list = new ArrayList<>();
        try {
            connection = DButils.getConnection();
            sql = "SELECT * from Student";
            st = connection.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                double score = rs.getDouble(3);
                Student stu = new Student(name, id, score);
                list.add(stu);
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }finally {
            release();
        }
        return list;
    }

    public void add(int id, String name, double score){
        try{
            connection = DButils.getConnection();
            sql = "Insert into Student(id,name,score) values(?,?,?)";
            st = connection.prepareStatement(sql);
            st.setInt(1,id);
            st.setString(2,name);
            st.setDouble(3,score);
            st.executeUpdate();
        }catch (SQLException se){
            se.printStackTrace();
        }finally {
            release();
        }
    }

    public Student findById(int id){
        try{
            connection = DButils.getConnection();
            sql = "SELECT * from Student where id=?";
            st = connection.prepareStatement(sql);
            st.setInt(1,id);
            rs = st.executeQuery();
            while (rs.next()){
                String name = rs.getString(2);
                double score = rs.getDouble(3);
                return new Student(name,id,score);
            }
        }catch (SQLException se){
            se.printStackTrace();
        }finally {
            release();
        }
        return new Student();
    }

    public void update(int id,String name,double score){
        try{
            connection = DButils.getConnection();
            sql = "update Student set name=?,score=? where id=?";
            st = connection.prepareStatement(sql);
            st.setString(1,name);
            st.setDouble(2,score);
            st.setInt(3,id);
            st.executeUpdate();
        }catch (SQLException se){
            se.printStackTrace();
        }finally {
            release();
        }
    }

    public void delete(int id){
        try{
            connection = DButils.getConnection();
            sql = "delete from Student where id=?";
            st = connection.prepareStatement(sql);
            st.setInt(1,id);
            st.executeUpdate();
        }catch (SQLException se){
            se.printStackTrace();
        }finally {
            release();
        }
    }

    public void release(){
        try {
            if (connection != null) connection.close();
            if (st!=null)st.close();
            if(rs!=null)rs.close();
        }catch (SQLException se){
            se.printStackTrace();
        }
    }
}
