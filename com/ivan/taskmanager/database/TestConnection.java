package com.ivan.taskmanager.database;

import java.sql.Connection;

public class TestConnection {
    public static void main(String[] args) {
        try(Connection connection = DatabaseConnection.connect()){
            if(connection != null){
                System.out.println("Connected to PostgreSQL successfully!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
