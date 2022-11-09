package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class jdbc_demo {
    public static void main(String[] args) throws Exception {
        // 注册驱动 (MYSQL5之后可以省略不写)
        Class.forName("com.mysql.cj.jdbc.Driver");
        // 获取链接
        // 法语: jdbc:mysql://ip地址(域名):端口号/数据库名称? 参数键值对1,参数键值对2
        // 本机的MYSQL服务器默认端口是3306
        // 本机的域名可以写localhost
        // useSSL=false 是将SSL连接方式的警告删除. SSL是一个安全连接方式，但是配置很复杂，使用之后也会降低性能20%，所以不使用
        String url = "jdbc:mysql://127.0.0.1:3306/test01?useSSL=false";
        String username = "root";
        String password = "1234";
        Connection conn = DriverManager.getConnection(url,username,password);// 返回Connection对象

        // 定义sql
        String sql = "UPDATE user set age = age + 1 where name = '陈帅'";

        // 获取statement对象
        Statement stmt = conn.createStatement();

        // 执行sql
        int count = stmt.executeUpdate(sql); // 返回受影响的行数，也就是被修改过的行数

        // 处理结果
        System.out.println(count);

        // 释放资源
        stmt.cancel();
        conn.close();

    }
}
