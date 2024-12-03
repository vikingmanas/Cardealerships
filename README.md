# 🚗 **Online Car Dealership System**

## 📜 **Project Description**

Welcome to the **Online Car Dealership System**! This web-based platform connects **buyers**, **dealers**, and **admins** for a seamless car-buying and selling experience. With intuitive search, secure transactions, and role-specific features, it’s designed for efficient vehicle management and customer satisfaction.

---

## ✨ **Features**

- **User Roles**:  
  - **Buyer**: Browse and purchase vehicles.
  - **Dealer**: Manage vehicle inventory and view transactions.
  - **Admin**: Oversee system-wide activities.

- **🔍 Car Search by Price**:  
  Quickly find vehicles within a specific price range.

- **💰 Transaction Management**:  
  Securely track and handle transactions between buyers and dealerships.

- **🔗 Database Integration**:  
  Uses **MySQL** to store vehicle, user, and transaction data, enabling real-time access and management.

---

## 🚀 **Technologies Used**

- **Java (JDK)**: Backend development.
- **JDBC**: Database connectivity.
- **MySQL**: Database storage.
- **VS Code**: Development environment.
- **MySQL JDBC Driver**: Connects Java to MySQL.

---

## 🎨 **Preview of Database Connection**

![Database Connection Successful](./assets/database-connection-success.png)

---

## 🛠️ **Database Schema**

The system uses a MySQL database with the following key tables:

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
```

### 👤 **Users Table**

```sql
CREATE TABLE Users (
    user_id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) UNIQUE NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    password VARCHAR(100) NOT NULL,
    phone_number VARCHAR(15),
    address TEXT,
    role ENUM('buyer', 'dealer', 'admin') DEFAULT 'buyer'
);
```

### 🏢 **Dealership Table**

```sql
CREATE TABLE Dealership (
    dealership_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    address TEXT NOT NULL,
    phone_number VARCHAR(15),
    email VARCHAR(100),
    website VARCHAR(100),
    contact_person VARCHAR(100)
);
```

### 💳 **Transactions Table**

```sql
CREATE TABLE Transactions (
    transaction_id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT NOT NULL,
    vehicle_id INT NOT NULL,
    dealership_id INT NOT NULL,
    purchase_date DATE NOT NULL,
    payment_method ENUM('cash', 'credit', 'debit', 'loan') NOT NULL,
    total_price DECIMAL(10, 2) NOT NULL
);
```

---

## 🗂️ **Project Structure**

```
OnlineCarDealership/
├── src/
│   └── com/
│       └── cardealership/
│           ├── App.java
│           ├── CarDAO.java
│           ├── DBConnection.java
│           ├── InventoryDAO.java
│           └── UserManagement/
│               ├── user-management.html
│               ├── style.css
│               └── user-management.js
├── lib/
│   └── mysql-connector-java-8.x.x.jar
├── pom.xml
├── README.md
└── .gitignore

---
