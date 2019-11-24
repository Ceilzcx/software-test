package com.etc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnectionFactory {
    public static Connection getConnction(){
        Connection conn=null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://cdb-pllfd5fy.bj.tencentcdb.com:10146/blm?useUnicode=true&characterEncoding=UTF-8&useSSL = false&serverTimezone = GMT%2B8&&allowPublicKeyRetrieval=true&useSSL=false","root","wangsong990315");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
