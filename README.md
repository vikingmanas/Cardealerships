# 🚗 **Premium Online Car Dealership System**

## 📜 **Project Description**

The **Premium Online Car Dealership System** is a dynamic web-based MVC platform designed to facilitate car buying and selling. Built using **Java Servlets**, **JSP**, and **Maven** for efficient project management, this system connects **buyers** and **dealers** with the goal of providing a smooth car-buying experience. It supports role-based secure login, session management, and dynamic inventory handling.

---

## ✨ **Features**

- **User Roles & Session Management**:  
  - **Buyer**: Browse available inventory and view details.  
  - **Dealer**: Securely log in to manage vehicle inventory and add new cars to the database via a custom dashboard. 
- **Modern UI**:  
  - A premium, responsive user interface built with Bootstrap 5. 
- **🔗 Database Integration**:  
  - Real-time updates using **MySQL** (JDBC) to manage users, roles, and car inventory.  
- **Zero-Config Execution**:  
  - Uses the `jetty-maven-plugin` allowing the application to run instantly from the command line without the need for manual Tomcat server setup or configuration.

---

## 🚀 **Technologies Used**

- **Backend**:  
  - **Java (JDK 8)**: Core backend development language.  
  - **Java Servlets & JSP**: MVC controller and view implementation.
  - **JDBC**: For robust MySQL database connectivity.  
- **Frontend**:  
  - **Bootstrap 5, HTML, CSS**: Interactive, premium, and responsive web design.  
- **Database**:  
  - **MySQL**: Relational data management for vehicles and users.  
- **Build & Dependency Management**:  
  - **Maven**: Dependency management and project execution.  

---

## 🛠️ **How to Run the Project Locally**

Follow these steps to experience the fully functional web application:

### Step 1: Database Initialization
1. Open your MySQL client (e.g., MySQL Workbench).
2. Connect to your `localhost` server as `root`.
3. Locate and execute the provided `database/schema.sql` script within the project repository.
   - *This script will automatically construct the database (`car_dealership`), build the required tables, and pre-populate the system with sample cars and users.*

### Step 2: Configure Application Credentials
1. Open `src/main/java/com/cardealership/DBConnection.java`.
2. Update the `JDBC_USERNAME` and `JDBC_PASSWORD` variables to correctly match your local MySQL server's credentials.

### Step 3: Fast Execution with Maven Target
Thanks to the Jetty integration, running the whole stack is just one command away:
1. Open a terminal and navigate to the `online-car-dealership` directory `> cd OnlineCarDealership/online-car-dealership`.
2. Run the server:
   ```bash
   mvn clean install jetty:run
   ```
3. Wait for the server to load (look for `Started ServerConnector`).
4. Access the application in your browser at: **[http://localhost:8080/](http://localhost:8080/)**

### Step 4: Testing Accounts
The `schema.sql` script creates a sample user you can test features with:
- **Role**: Dealer
- **Username**: `admin_dealer`
- **Password**: `password123`

---

*This project was developed to strongly demonstrate proficiency in Java OOP, Model-View-Controller design architecture, SQL Database Management, and Frontend Web Design.*
