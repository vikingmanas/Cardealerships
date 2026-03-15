-- Database Initialization Script for Online Car Dealership

CREATE DATABASE IF NOT EXISTS car_dealership;
USE car_dealership;

-- Create Users table
CREATE TABLE IF NOT EXISTS Users (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) UNIQUE NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    password VARCHAR(100) NOT NULL,
    phone_number VARCHAR(15),
    address TEXT,
    role ENUM('buyer', 'dealer', 'admin') DEFAULT 'buyer',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Insert a sample dealer and buyer
INSERT IGNORE INTO Users (username, email, password, role) VALUES 
('admin_dealer', 'dealer@cardealership.com', 'password123', 'dealer'),
('john_doe', 'john@example.com', 'password123', 'buyer');

-- Create Cars table (note: existing DAO expects 'id', 'make', 'model', 'year', 'price')
CREATE TABLE IF NOT EXISTS cars (
    id INT AUTO_INCREMENT PRIMARY KEY,
    make VARCHAR(50) NOT NULL,
    model VARCHAR(50) NOT NULL,
    year INT NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    dealer_id INT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (dealer_id) REFERENCES Users(user_id) ON DELETE SET NULL
);

-- Insert sample cars
INSERT IGNORE INTO cars (make, model, year, price) VALUES
('Toyota', 'Camry', 2022, 28000.00),
('Honda', 'Accord', 2021, 25500.00),
('Ford', 'Mustang', 2023, 45000.00),
('Tesla', 'Model 3', 2023, 42000.00),
('Chevrolet', 'Malibu', 2020, 22000.00),
('BMW', 'X5', 2022, 65000.00);
