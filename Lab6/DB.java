package org.example;

import java.sql.*;

public class DB {
    private static DB instance = null;
    private Connection conn = null;

    private DB() {}

    public static DB getInstance() {
        if (instance == null) instance = new DB();
        return instance;
    }

    public Connection getConnection() throws SQLException {
        if (conn == null || conn.isClosed()) {
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "student", "student");
        }
        return conn;
    }

    public void close() throws SQLException {
        if (conn != null) conn.close();
    }
}