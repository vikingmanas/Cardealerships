# 🚗 **Online Car Dealership System**

## 📜 **Project Description**

The **Online Car Dealership System** is a dynamic web-based platform designed to facilitate car buying and selling. Built using **Maven** for efficient project management and dependency handling, this system connects **buyers**, **dealers**, and **admins** with the goal of providing a smooth car-buying experience. It supports features like intuitive car search, secure transactions, and role-based functionalities.

---

## ✨ **Features**

- **User Roles**:  
  - **Buyer**: Browse, view details, and purchase vehicles.  
  - **Dealer**: Manage vehicle inventory and view transactions.  
  - **Admin**: Oversee system-wide activities and manage user roles.  

- **🔍 Car Search by Price**:  
  Search for cars within a specified price range and filter by make, model, and year.  

- **💰 Transaction Management**:  
  Securely track transactions between buyers and dealers, including support for multiple payment methods.  

- **🔗 Database Integration**:  
  Real-time updates using **MySQL** to manage vehicles, users, dealerships, and transaction data.  

- **Maven-powered Build**:  
  Streamlined dependency management and build process, packaged as a **WAR** file for deployment.  

---

## 🚀 **Technologies Used**

- **Backend**:  
  - **Java (JDK 8)**: Core backend development language.  
  - **JDBC**: For MySQL database connectivity.  

- **Frontend**:  
  - **HTML, CSS, JavaScript**: Interactive and responsive web design.  

- **Database**:  
  - **MySQL**: Structured data management for vehicles, users, and transactions.  

- **Build & Dependency Management**:  
  - **Maven**: Dependency management and project automation.  

- **Development Tools**:  
  - **VS Code**: Primary code editor.  
  - **MySQL Workbench**: For database design and queries.  

---

## 🛠️ **Database Schema**

### **Users Table**

```sql
CREATE TABLE Users (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) UNIQUE NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    password VARCHAR(100) NOT NULL,
    phone_number VARCHAR(15),
    address TEXT,
    role ENUM('buyer', 'dealer', 'admin') DEFAULT 'buyer',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
