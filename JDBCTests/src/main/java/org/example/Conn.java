package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conn {
    private static final Connection connection;
    static {
        try {
            connection = DriverManager.getConnection("jdbc:h2:mem:testdb");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
