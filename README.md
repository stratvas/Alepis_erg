````md
# 📚 Library Management System

A console-based Library Management System developed in Java using core Object-Oriented Programming principles and clean architecture practices.

The application allows users to manage library items, members, borrowing operations, and reports through an interactive console menu.

---

# 🚀 Features

## 📖 Library Items
The system supports multiple types of library items:

- Books
- Digital Books
- Magazines

Each item can:
- be borrowed
- be returned
- display custom descriptions
- check availability status

---

# 🧠 OOP Concepts Used

This project was designed with strong emphasis on Object-Oriented Programming concepts.

| Concept | Implementation |
|---|---|
| Encapsulation | Private fields with controlled access via getters/setters |
| Inheritance | `LibraryItem → Book → DigitalBook` |
| Polymorphism | Overriding `getDescription()` in subclasses |
| Abstraction | Abstract classes and interfaces |
| Interfaces | `Borrowable`, `Searchable` |
| Service Layer | Centralized logic inside `Library` class |

---

# 🏗️ Project Structure

```bash
src/
│
├── model/
│   ├── LibraryItem.java
│   ├── Book.java
│   ├── DigitalBook.java
│   ├── Magazine.java
│   ├── Loan.java
│   └── Member.java
│
├── service/
│   └── Library.java
│
├── contracts/
│   ├── Borrowable.java
│   └── Searchable.java
│
├── util/
│   └── ReportGenerator.java
│
└── Main.java
````

---

# ⚙️ Technologies

* Java
* Object-Oriented Programming (OOP)
* Java Collections (`ArrayList`)
* LocalDate API
* Console-based User Interface

---

# 📌 Core Classes

## `LibraryItem`

Abstract base class for all library items.

Contains common fields:

* code
* title
* year
* availability status

Implements the `Borrowable` interface.

---

## `Book`

Extends `LibraryItem`.

Additional fields:

* author
* isbn

---

## `DigitalBook`

Extends `Book`.

Additional fields:

* fileSizeMB
* fileFormat

Example of multi-level inheritance:

```java
LibraryItem -> Book -> DigitalBook
```

---

## `Magazine`

Subclass of `LibraryItem`.

Contains:

* issueNumber

---

## `Loan`

Represents a borrowing transaction.

Includes:

* Member
* LibraryItem
* loanDate
* returnDate
* active status

---

## `Library`

The main service layer of the application.

Responsible for:

* item management
* member management
* loan operations
* searching
* borrowing
* returning

---

# 🔍 Available Operations

* Add Item
* Add Member
* Search Items
* Borrow Item
* Return Item
* Generate Reports
* View Statistics

---

# 🛡️ Validation Rules

The project includes validation mechanisms to ensure data integrity.

Examples:

* Empty titles are rejected
* Future publication years are not allowed
* Negative file sizes are invalid
* File formats are automatically converted to uppercase

---

# 📊 Reports

The `ReportGenerator` utility class provides console reports such as:

```java
printAllItems()
printSearchResults()
printStatistics()
```

---

# ▶️ Run the Project

## Compile

```bash
javac Main.java
```

## Run

```bash
java Main
```

---

# 💡 Future Improvements

Possible future extensions:

* Database integration
* GUI application
* REST API
* User authentication
* Persistent storage
* Exportable reports

---

# 📷 Example Console Menu

```text
1. Add Item
2. Add Member
3. Search
4. Borrow Item
5. Return Item
6. Reports
7. Exit
```

---

# 📚 Educational Purpose

This project was developed as practical training in:

* Java programming
* Object-Oriented Design
* Clean Architecture
* Service Layer Design
* Interfaces and Abstraction

---

# 👨‍💻 Author

Developed by **Ευστράτιος Βασιλέλλης**

GitHub: [https://github.com/stratvas](https://github.com/stratvas)
