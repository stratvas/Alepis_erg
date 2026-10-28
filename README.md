Library_Java_erg
README (Ελληνική Έκδοση)
Σύστημα Διαχείρισης Βιβλιοθήκης σε Java
Περιγραφή
Η παρούσα εργασία υλοποιεί ένα σύστημα διαχείρισης βιβλιοθήκης σε κονσόλα (console-based) στη γλώσσα Java, με χρήση βασικών αρχών Αντικειμενοστραφούς Προγραμματισμού (OOP) και πρακτικών καθαρής αρχιτεκτονικής. Στόχος του προγράμματος είναι η διαχείριση αντικειμένων βιβλιοθήκης, μελών, διαδικασιών δανεισμού και αναφορών, σύμφωνα με τις απαιτήσεις της εκφώνησης.
Η εφαρμογή βασίζεται σε δομημένη αρχιτεκτονική πακέτων:
-> model: κλάσεις αντικειμένων (LibraryItem, Book, DigitalBook, Magazine, Loan, Member)
-> service: κεντρική λογική (Library)
-> contracts: διεπαφές (Borrowable, Searchable)
-> util: εργαλεία αναφορών (ReportGenerator)
Κάθε αντικείμενο διαθέτει τα βασικά του στοιχεία και υποστηρίζει ενέργειες όπως δανεισμό, επιστροφή και εμφάνιση περιγραφής.
Δομή Κλάσεων & OOP Concepts
Encapsulation
Ιδιωτικά πεδία με ελεγχόμενη πρόσβαση μέσω getters/setters.
Inheritance
Ιεραρχία κλάσεων: LibraryItem -> Book -> DigitalBook (πολυεπίπεδη κληρονομικότητα).
Polymorphism
Επικάλυψη της μεθόδου getDescription() στις υποκλάσεις.
Abstraction
Αφηρημένες κλάσεις και interfaces (Borrowable, Searchable).
Service Layer
Συγκεντρωμένη επιχειρησιακή λογική στην κλάση Library.
Βασικές Λειτουργίες
Το πρόγραμμα παρέχει menu επιλογών:
1. Προσθήκη αντικειμένου (Add Item)
2. Προσθήκη μέλους (Add Member)
3. Αναζήτηση αντικειμένων (Search Items)
4. Δανεισμός αντικειμένου (Borrow Item)
5. Επιστροφή αντικειμένου (Return Item)
6. Δημιουργία αναφορών (Generate Reports)
7. Προβολή στατιστικών (View Statistics)
8. Έξοδος
Τεχνικά Χαρακτηριστικά
- Χρήση γλώσσας Java και αντικειμενοστραφούς προγραμματισμού
- Χρήση Java Collections (ArrayList) για αποθήκευση στη μνήμη
- Αξιοποίηση του LocalDate API για διαχείριση ημερομηνιών
- Έλεγχος εγκυρότητας δεδομένων (π.χ. απόρριψη κενών τίτλων, μελλοντικών ετών, αρνητικών μεγεθών αρχείων)
Σκοπός Εργασίας
Η εργασία στοχεύει στην πρακτική εξάσκηση σε:
- Java προγραμματισμό
- Αντικειμενοστραφή σχεδίαση (Object-Oriented Design)
- Αρχιτεκτονική Clean Architecture & Service Layer
- Χρήση Interfaces και Αφηρημένων Κλάσεων
Στοιχεία Φοιτητή
Ευστράτιος Βασιλέλλης
README (English Version)
Library Management System in Java
Description
This project implements a console-based Library Management System in Java using core Object-Oriented Programming principles and clean architecture practices. The purpose of the program is to manage library items, members, borrowing operations, and reports through an interactive console menu.
The application is based on a structured package architecture:
-> model: domain classes (LibraryItem, Book, DigitalBook, Magazine, Loan, Member)
-> service: core business logic (Library)
-> contracts: interfaces (Borrowable, Searchable)
-> util: reporting utilities (ReportGenerator)
Each item stores its information and supports operations such as borrowing, returning, and custom descriptions.
Class Structure & OOP Concepts
Encapsulation
Private fields with controlled access via getters/setters.
Inheritance
Class hierarchy: LibraryItem -> Book -> DigitalBook (multi-level inheritance).
Polymorphism
Overriding getDescription() in subclasses.
Abstraction
Abstract classes and interfaces (Borrowable, Searchable).
Service Layer
Centralized logic inside the Library class.
Main Features
The program provides a menu with the following options:
1. Add Item
2. Add Member
3. Search Items
4. Borrow Item
5. Return Item
6. Generate Reports
7. View Statistics
8. Exit
Technical Characteristics
- Use of Java and Object-Oriented Programming principles
- Use of Java Collections (ArrayList) for data management
- Utilization of the LocalDate API for date handling
- Validation rules ensuring data integrity (e.g. rejecting empty titles, future years, negative file sizes)
Educational Purpose
This assignment focuses on practical understanding of:
- Java programming
- Object-Oriented Design
- Clean Architecture & Service Layer Design
- Interfaces and Abstraction
Student Information
Evstratios Vasilellis
