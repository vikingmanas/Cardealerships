package com.cardealership;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InventoryDAO {

    // Method to get inventory count (total number of cars in inventory)
    public int getInventoryCount() throws SQLException {
        int count = 0;
        String sql = "SELECT COUNT(*) FROM cars"; // SQL query to count rows in 'cars' table
        try (Connection connection = DBConnection.getConnection(); 
             PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                count = resultSet.getInt(1); // Extract count from the result
            }
        }
        return count;
    }

    // Method to retrieve cars within a certain price range
    public List<Car> getCarsByPriceRange(double minPrice, double maxPrice) throws SQLException {
        List<Car> cars = new ArrayList<>();
        String sql = "SELECT * FROM cars WHERE price BETWEEN ? AND ?"; // SQL query for price range
        try (Connection connection = DBConnection.getConnection(); 
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setDouble(1, minPrice); // Set min price
            statement.setDouble(2, maxPrice); // Set max price
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                // Create a new Car object from the result set
                Car car = new Car(
                    resultSet.getInt("id"),
                    resultSet.getString("make"),
                    resultSet.getString("model"),
                    resultSet.getInt("year"),
                    resultSet.getDouble("price")
                );
                cars.add(car); // Add the car to the list
            }
        }
        return cars;
    }

    // Method to check if a specific car is in stock (based on car ID)
    public boolean isCarInStock(int carId) throws SQLException {
        String sql = "SELECT COUNT(*) FROM cars WHERE id = ?"; // SQL query to check stock based on car ID
        try (Connection connection = DBConnection.getConnection(); 
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, carId); // Set the car ID
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt(1) > 0; // Return true if car exists in stock
            }
        }
        return false; // Return false if car is not in stock
    }
}