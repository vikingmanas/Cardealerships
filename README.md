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
- **HTML/CSS/JavaScript**: Frontend for user interfaces.
- **Bootstrap**: Responsive UI design.
- **jQuery**: Enhance interactivity on the client-side.
- **AJAX**: Asynchronous data retrieval for a smooth user experience.
  
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
