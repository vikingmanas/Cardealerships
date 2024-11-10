# 🚗 **Online Car Dealership System**

## 📜 **Project Description**

Welcome to the **Online Car Dealership System**! This is a web-based platform that connects **buyers**, **dealers**, and **admins** in a seamless car-buying and selling experience. Users can browse, sell, and purchase vehicles efficiently. The system features:

- **🔍 Car Search**: Find cars by price range.
- **🛠️ Inventory Management**: Dealers can add, update, and remove cars.
- **💳 Transactions**: Secure transactions between buyers and dealerships.
- **🛡️ Role Management**: Users have distinct roles with permissions.

---

## ✨ **Features**

- **User Roles**:  
    - **Buyer**: Browse cars, make purchases.
    - **Dealer**: Manage car inventory, view transactions.
    - **Admin**: Oversee all system activities.

- **🔎 Car Search by Price**:  
  Filter and find cars within your preferred price range.

- **💰 Transaction Management**:  
  Efficiently track and manage car purchase transactions between buyers and dealerships.

- **🔗 Database Connection**:  
  Connects to **MySQL** database to store vehicle, user, and transaction data.

---

## 🚀 **Technologies Used**

- **Java (JDK)**: Backend logic.
- **JDBC**: Database connectivity.
- **MySQL**: Database management.
- **VS Code**: Development environment.
- **MySQL JDBC Driver**: For connecting Java to MySQL.

---

## 🎨 **Preview of Database Connection**

![Database Connection Successful](./assets/database-connection-success.png)

---

## 🛠️ **Database Schema**

This project uses a MySQL database to store data about vehicles, users, dealerships, and transactions. Below is the schema for each table:

### 🚗 **Vehicles Table**

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


