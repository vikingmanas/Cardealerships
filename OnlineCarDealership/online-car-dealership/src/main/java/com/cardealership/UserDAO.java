package com.cardealership;

import java.sql.*;

public class UserDAO {

    public User getUserByEmail(String email) {
        User user = null;
        try (Connection connection = DBConnection.getConnection()) {
            String query = "SELECT * FROM users WHERE email = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, email);
                ResultSet resultSet = statement.executeQuery();

                if (resultSet.next()) {
                    String username = resultSet.getString("username");
                    String password = resultSet.getString("password");
                    String role = resultSet.getString("role");
                    user = new User(username, email, password, role);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public User getUserByUsernameAndPassword(String username, String password) {
        User user = null;
        try (Connection connection = DBConnection.getConnection()) {
            String query = "SELECT * FROM users WHERE username = ? AND password = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, username);
                statement.setString(2, password);
                ResultSet resultSet = statement.executeQuery();

                if (resultSet.next()) {
                    String email = resultSet.getString("email");
                    String role = resultSet.getString("role");
                    user = new User(username, email, password, role);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public void addUser(User user) {
        try (Connection connection = DBConnection.getConnection()) {
            String query = "INSERT INTO users (username, email, password, role) VALUES (?, ?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, user.getUsername());
                statement.setString(2, user.getEmail());
                statement.setString(3, user.getPassword());
                statement.setString(4, user.getRole() != null ? user.getRole() : "buyer");
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
