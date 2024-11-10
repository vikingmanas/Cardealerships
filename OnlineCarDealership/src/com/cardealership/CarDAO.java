package com.cardealership;

import java.sql.*;

public class CarDAO {

    // Method to add a new car to the inventory
    public void addCar(Car car) throws SQLException {
        String sql = "INSERT INTO cars (make, model, year, price) VALUES (?, ?, ?, ?)"; // SQL query to insert new car
        try (Connection connection = DBConnection.getConnection(); 
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, car.getMake()); // Set car make
            statement.setString(2, car.getModel()); // Set car model
            statement.setInt(3, car.getYear()); // Set car year
            statement.setDouble(4, car.getPrice()); // Set car price
            statement.executeUpdate(); // Execute the insert operation
        }
    }

    // Method to retrieve a car by ID
    public Car getCarById(int carId) throws SQLException {
        Car car = null;
        String sql = "SELECT * FROM cars WHERE id = ?"; // SQL query to get car by ID
        try (Connection connection = DBConnection.getConnection(); 
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, carId); // Set car ID
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                // Create a Car object from the result set
                car = new Car(
                    resultSet.getInt("id"),
                    resultSet.getString("make"),
                    resultSet.getString("model"),
                    resultSet.getInt("year"),
                    resultSet.getDouble("price")
                );
            }
        }
        return car; // Return the car object
    }

    // Method to update car details
    public void updateCar(Car car) throws SQLException {
        String sql = "UPDATE cars SET make = ?, model = ?, year = ?, price = ? WHERE id = ?"; // SQL query to update car
        try (Connection connection = DBConnection.getConnection(); 
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, car.getMake()); // Set updated car make
            statement.setString(2, car.getModel()); // Set updated car model
            statement.setInt(3, car.getYear()); // Set updated car year
            statement.setDouble(4, car.getPrice()); // Set updated car price
            statement.setInt(5, car.getId()); // Set car ID for the update
            statement.executeUpdate(); // Execute the update operation
        }
    }

    // Method to delete a car from the inventory
    public void deleteCar(int carId) throws SQLException {
        String sql = "DELETE FROM cars WHERE id = ?"; // SQL query to delete car by ID
        try (Connection connection = DBConnection.getConnection(); 
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, carId); // Set car ID for deletion
            statement.executeUpdate(); // Execute the delete operation
        }
    }
}
