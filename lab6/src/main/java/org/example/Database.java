package org.example;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class Database {
    private static HikariDataSource ds;

    static {
        HikariConfig config = new HikariConfig();
        // Modifica URL-ul daca ai alt serviciu in loc de xe (ex: orcl)
        config.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:xe");
        config.setUsername("student");
        config.setPassword("student");

        config.setDriverClassName("oracle.jdbc.OracleDriver");
        config.setMaximumPoolSize(10);
        ds = new HikariDataSource(config);
    }

    private Database() {}

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    public static void close() {
        if (ds != null) ds.close();
    }
}