package com.ivan.taskmanager.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static String getEnv(String key){
        String value = System.getenv(key);
        if(value == null){
            throw new RuntimeException("Environment variable not set: " + key);
        }
        return value;
    }

    private static final String URL = getEnv("DATABASE_URL");
    private static final String USER = getEnv("DATABASE_USER");
    private static final String PASSWORD = getEnv("DATABASE_PASSWORD");

    public static Connection connect(){
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException("Failed to connect to database", e);
        }
    }
}
