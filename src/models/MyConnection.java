package models;

import java.sql.*;

public interface MyConnection extends Connection {

    final String HOSTNAME = "localhost";//"jdbc:mysql://127.0.0.1/studentwork";
    final String DB_NAME = "studentwork";
    final String DB_USERNAME = "root";
    final String DB_PASSWORD = "";
    final String CLASSNAME = "com.mysql.jdbc.Driver";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(CLASSNAME);
            String dbPath = String.format(
                    "jdbc:mysql://%s:%d/%s?user=%s&password=%s&characterEncoding=utf-8&" + 
                    "useUnicode=true",HOSTNAME,3306 ,DB_NAME,DB_USERNAME,DB_PASSWORD);
            connection = DriverManager.getConnection(dbPath);
            System.out.println("Ket noi thanh cong");
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return connection;
    }
}
