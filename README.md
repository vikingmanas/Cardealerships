# Online Car Dealership System

## Project Description

The **Online Car Dealership System** is a web-based platform where users (buyers, dealers, admins) can interact to browse, sell, and buy vehicles. The system supports:

- **Vehicle Search**: Search cars by price range.
- **Inventory Management**: Add, update, and remove cars.
- **Transactions**: Complete transactions between users and dealerships.
- **Role Management**: Users have different roles with different permissions.
## Project Structure

```plaintext
online-car-dealership/
    ├── src/
    │    ├── com/
    │    │    ├── cardealership/
    │    │    │    ├── Car.java
    │    │    │    ├── CarDAO.java
    │    │    │    ├── InventoryDAO.java
    │    │    │    └── DBConnection.java
    ├── lib/
    │    └── mysql-connector-java-x.x.x.jar (MySQL JDBC Driver)
    ├── assets/
    │    └── database-connection-success.png
    ├── .gitignore
    ├── README.md
    └── Main.java

## Features

- **User Roles**: 
    - **Buyer**: Can view cars, make purchases.
    - **Dealer**: Can manage car inventory and view transactions.
    - **Admin**: Can manage all aspects of the system.
  
- **Car Search by Price**: Users can filter cars within a certain price range.
  
- **Transaction Management**: Track purchase transactions between buyers and dealerships.
  
- **Database Connection**: Successfully connects to the **MySQL** database.

## Technologies Used

- **Java (JDK)** for the backend logic.
- **JDBC** for database connectivity.
- **MySQL** as the database.
- **VS Code** as the development environment.
- **MySQL JDBC Driver** for connecting to MySQL from Java.
  ![Database Connection Successful](./assets/database-connection-success.png)



  
  ## Database Schema

This project uses a MySQL database to store data related to vehicles, users, dealerships, and transactions. Below is the schema design for the database:

### Vehicles Table
```sql
CREATE TABLE Vehicles (
    vehicle_id INT PRIMARY KEY AUTO_INCREMENT,
    make VARCHAR(50) NOT NULL,
    model VARCHAR(50) NOT NULL,
    year INT NOT NULL,
    mileage INT NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    description TEXT,
    images TEXT,
    vin VARCHAR(20) UNIQUE NOT NULL
);


