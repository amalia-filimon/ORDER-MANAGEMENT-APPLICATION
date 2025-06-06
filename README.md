# Order Management Application (Java + Swing + MySQL)

This application is a desktop tool developed in Java for managing clients, products, and orders in a warehouse. The system features a graphical interface built with Java Swing and communicates with a relational database using JDBC. Users can insert, delete, edit, and view records for clients, products, and orders.

---

## 🎯 Features

- Manage three core entities:
  - **Clients**: add, remove, edit, view
  - **Products**: add, remove, edit, view stock and price
  - **Orders**: create new orders by selecting clients and products

- Live updates to the database
- Data validation with custom exceptions
- Tables displayed using reflection-based rendering
- Automatically updates product stock when orders are placed
- JavaDoc documentation included

---

## 🖥️ User Interface (GUI)

- Implemented using `javax.swing`
- Intuitive menu with sections for:
  - **Clients**
  - **Products**
  - **Orders**
- Table views for displaying all clients or all products
- ComboBoxes for selecting existing entries
- Buttons for executing operations with real-time feedback

---

## 🧩 Application Structure (Packages)

- `businessLogic/` – handles application logic (ClientBLL, ProductBLL, OrderBLL)
- `dataAccess/` – interacts directly with the database (ClientDAO, ProductDAO, OrderDAO)
- `connection/` – manages database connections
- `model/` – entity classes mapped to database tables (Client, Product, Order)
- `presentation/` – user interface and controller classes
- `exceptions/` – custom exception for invalid inputs
- `start/` – main class and reflection utilities

---

## ⚙️ Technologies Used

- Java 
- Java Swing
- MySQL 
- JDBC
- Java Reflection API
- JavaDoc
- Object-Oriented Design

---

## 📄 JavaDoc

Full API documentation is available in the [`doc/`](./doc/index.html) folder. Open `index.html` in your browser.

---
