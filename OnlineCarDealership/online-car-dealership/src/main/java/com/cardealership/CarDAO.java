package com.cardealership;

import java.sql.*;

public class CarDAO {

    public void addCar(Car car) throws SQLException {
        String sql = "INSERT INTO cars (make, model, year, price) VALUES (?, ?, ?, ?)"; 
        try (Connection connection = DBConnection.getConnection(); 
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, car.getMake()); 
            statement.setString(2, car.getModel());
            statement.setInt(3, car.getYear()); 
            statement.setDouble(4, car.getPrice()); 
            statement.executeUpdate(); 
        }
    }

    
    public Car getCarById(int carId) throws SQLException {
        Car car = null;
        String sql = "SELECT * FROM cars WHERE id = ?";
        try (Connection connection = DBConnection.getConnection(); 
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, carId); 
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                
                car = new Car(
                    resultSet.getInt("id"),
                    resultSet.getString("make"),
                    resultSet.getString("model"),
                    resultSet.getInt("year"),
                    resultSet.getDouble("price")
                );
            }
        }
        return car; 
    }

    
    public void updateCar(Car car) throws SQLException {
        String sql = "UPDATE cars SET make = ?, model = ?, year = ?, price = ? WHERE id = ?"; 
        try (Connection connection = DBConnection.getConnection(); 
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, car.getMake()); 
            statement.setString(2, car.getModel()); 
            statement.setInt(3, car.getYear()); 
            statement.setDouble(4, car.getPrice()); 
            statement.setInt(5, car.getId()); 
            statement.executeUpdate(); 
        }
    }


    public void deleteCar(int carId) throws SQLException {
        String sql = "DELETE FROM cars WHERE id = ?"; 
        try (Connection connection = DBConnection.getConnection(); 
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, carId); 
            statement.executeUpdate(); 
        }
    }
}
