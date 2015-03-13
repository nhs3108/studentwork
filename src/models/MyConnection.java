package models;

import java.sql.*;

public interface MyConnection extends Connection {

    final String DB_URL = "jdbc:mysql://127.0.0.1/jstudentwork";
    final String DB_USERNAME = "root";
    final String DB_PASSWORD = "";
    final String CLASSNAME = "com.mysql.jdbc.Driver";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(CLASSNAME);
            String dbURL = DB_URL;
            String userName = DB_USERNAME;
            String dbPassword = DB_PASSWORD;
            connection = DriverManager.getConnection(dbURL, userName,
                    dbPassword);
            System.out.println("Ket noi thanh cong");
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return connection;
    }
}
