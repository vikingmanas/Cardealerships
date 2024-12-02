package com.cardealership;

import java.sql.SQLException;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        CarDAO carDAO = new CarDAO();
        InventoryDAO inventoryDAO = new InventoryDAO();

        try {
            // Add a new car
            Car newCar = new Car(0, "Toyota", "Camry", 2022, 30000.00);
            carDAO.addCar(newCar);
            System.out.println("Car added successfully.");

            // Get a car by ID
            Car car = carDAO.getCarById(1); // Replace with valid car ID
            System.out.println("Car retrieved: " + car.getMake() + " " + car.getModel());

            // Get all cars by price range
            List<Car> cars = inventoryDAO.getCarsByPriceRange(20000.00, 50000.00);
            for (Car c : cars) {
                System.out.println("Car: " + c.getMake() + " " + c.getModel());
            }

            // Check inventory count
            int inventoryCount = inventoryDAO.getInventoryCount();
            System.out.println("Total cars in inventory: " + inventoryCount);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}