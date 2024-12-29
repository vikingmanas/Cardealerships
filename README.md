# 🚗 **Online Car Dealership System**

## 📜 **Project Description**

The **Online Car Dealership System** is a dynamic web-based platform designed to facilitate car buying and selling. Built using **Maven** for efficient project management and dependency handling, this system connects **buyers**, **dealers**, and **admins** with the goal of providing a smooth car-buying experience. It supports features like intuitive car search, secure transactions, and role-based functionalities for buyers, dealers, and admins.

---

## ✨ **Features**

- **User Roles**:  
  - **Buyer**: Browse, view details, and purchase vehicles.
  - **Dealer**: Manage the vehicle inventory and view transactions.
  - **Admin**: Oversee system-wide activities and manage user roles.

- **🔍 Car Search by Price**:  
  Search for cars within a specified price range and filter by make, model, and year.

- **💰 Transaction Management**:  
  Securely track transactions between buyers and dealers, including various payment methods.

- **🔗 Database Integration**:  
  The system uses **MySQL** to manage vehicles, users, dealerships, and transaction data, providing real-time updates.

- **Maven-powered Build**:  
  The project is built using **Maven**, enabling seamless dependency management, building, and packaging into a **WAR** file for web deployment.

---

## 🚀 **Technologies Used**

- **Backend**:  
  - **Java (JDK 8)**: Primary language for backend development.
  - **JDBC**: Database connectivity to MySQL.
  
- **Frontend**:  
  - **HTML, CSS, JavaScript**: For creating interactive and responsive web pages.

- **Database**:  
  - **MySQL**: For storing vehicle, user, dealership, and transaction data.

- **Build & Dependency Management**:  
  - **Maven**: Manages project dependencies and automates the build process. Includes dependencies like MySQL connector and Servlet API for the web functionalities.

- **Development Tools**:  
  - **VS Code**: Code editor for development.
  - **MySQL Workbench**: For database management.

---

## 🎨 **Preview of Database Connection**

![Database Connection Successful](./assets/database-connection-success.png)

---

## 🛠️ **Database Schema**

The system uses a MySQL database with the following key tables:

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
