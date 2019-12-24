package com.reimia.activityTest;

import org.junit.Test;

import java.sql.*;

public class jdbcTest {
    private static Test JDBCUtlTool;

    public static Connection getConnection(){
        String driver="com.mysql.jdbc.Driver";  //获取mysql数据库的驱动类
        String url="jdbc:mysql://localhost:3306/mysql"; //连接数据库（kucun是数据库名）
        String name="root";//连接mysql的用户名
        String pwd="123456";//连接mysql的密码
        try{
            Class.forName(driver);
            Connection conn= DriverManager.getConnection(url,name,pwd);//获取连接对象
            return conn;
        }catch(ClassNotFoundException e){
            e.printStackTrace();
            return null;
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }
    public static void closeAll(Connection conn, PreparedStatement ps, ResultSet rs){
        try{
            if(rs!=null){
                rs.close();
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        try{
            if(ps!=null){
                ps.close();
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        try{
            if(conn!=null){
                conn.close();
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    //测试
    public static void main(String[] args) throws SQLException
    {
        Connection cc= getConnection();
        if(!cc.isClosed())
            System.out.println("Succeeded connecting to the Database!");
        Statement statement = cc.createStatement();
        String sql = "select * from tb_user";
        ResultSet rs = statement.executeQuery(sql);
        while(rs.next()) {
            System.out.println(rs.getString("id")+"");
        }
    }
}
