package JDBC;

import java.sql.*;

public class API_ {
    public static void main(String[] args) throws Exception {

        String url = "jdbc:mysql://127.0.0.1:3306/test01?useSSL=false";
        String username = "root";
        String password = "1234";
        Connection conn = DriverManager.getConnection(url,username,password);// 返回Connection对象


        String sql = "UPDATE user set age = age + 1 where name = '陈帅'";
        Statement stmt = conn.createStatement();
//        PreparedStatement pstmt = conn.prepareStatement(sql);   防止SQL注入
        // 转义操作
//        pstmt.setString(1,第一列的名字);
//        pstmt.setString(2,第二列的名字);


        //开启事务
        conn.setAutoCommit(false);//不要自动提交，即开启手动提交

        try {
            // stmt.executeUpdate(sql) 是DML DDL 语句   返回值是影响的行数
            // stmt.executeQuery(sql) 是DML DDL 语句    返回值是结果集对象
            int count = stmt.executeUpdate(sql); // 返回受影响的行数，也就是被修改过的行数
            System.out.println(count);
            int i = 3/0;
            // 提交事务
            conn.commit();
        } catch (Exception e) {
            //回滚事务
            conn.rollback();
            e.printStackTrace();
        }

        // 查询
        String sql1 = "select name,id,age from user";
        ResultSet rs = stmt.executeQuery(sql1);
        // rs.next() 返回是否有下一行
        while (rs.next()){
            // 获取资源
            String name = rs.getString(1);
            int id = rs.getInt(2);
            int age = rs.getInt(3);

            System.out.println(name);
            System.out.println(id);
            System.out.println(age);
        }

        // 释放资源 （注意顺序）
        rs.close();
        stmt.cancel();
        conn.close();
    }
}
