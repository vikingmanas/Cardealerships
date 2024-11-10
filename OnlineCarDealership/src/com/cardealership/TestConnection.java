package com.cardealership;

import java.sql.Connection;
import java.sql.SQLException;

public class TestConnection {

    public static void main(String[] args) {
        try {
            // Try to get the connection from DBConnection
            Connection connection = DBConnection.getConnection();
            if (connection != null) {
                System.out.println("Connection to the database was successful!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
