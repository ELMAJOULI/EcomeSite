package com.tawhidshop.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public enum SingleTonConnection {
    CONNECTION;
    private Connection connection;

    public Connection getConnection() {
        return connection;
    }

    private SingleTonConnection(){
        try {
            connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","dbtawhid","123");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
