# Online Car Dealership System

## Project Description

The **Online Car Dealership System** is a web-based platform where users (buyers, dealers, admins) can interact to browse, sell, and buy vehicles. The system supports:

- **Vehicle Search**: Search cars by price range.
- **Inventory Management**: Add, update, and remove cars.
- **Transactions**: Complete transactions between users and dealerships.
- **Role Management**: Users have different roles with different permissions.

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
