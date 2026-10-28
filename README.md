📚 Library Management System (Java)
Περιγραφή
Η παρούσα εφαρμογή υλοποιεί ένα κονσόλας (console-based) Σύστημα Διαχείρισης Βιβλιοθήκης σε Java, κάνοντας χρήση προηγμένων αρχών Αντικειμενοστραφούς Προγραμματισμού (OOP) και καθαρής αρχιτεκτονικής (clean architecture). Στόχος του προγράμματος είναι η διαχείριση υλικού βιβλιοθήκης, μελών, διαδικασιών δανεισμού και αναφορών.

Αρχιτεκτονική & Κλάσεις
Η εφαρμογή δομείται σε πακέτα (packages) με διαχωρισμό ευθυνών:

model/: LibraryItem, Book, DigitalBook, Magazine, Loan, Member

service/: Library (Κεντρικό service layer για τη λογική της εφαρμογής)

contracts/: Borrowable, Searchable (Interfaces)

util/: ReportGenerator (Δημιουργία αναφορών)

Main.java: Σημείο εκκίνησης με διαδραστικό menu επιλογών

Βασικές Λειτουργίες (Menu)
Προσθήκη Αντικειμένου (Add Item)

Προσθήκη Μέλους (Add Member)

Αναζήτηση (Search Items)

Δανεισμός Αντικειμένου (Borrow Item)

Επιστροφή Αντικειμένου (Return Item)

Αναφορές & Στατιστικά (Reports)

Έξοδος (Exit)

Τεχνικά Χαρακτηριστικά & OOP
Αρχές OOP: Ενδυνάμωση μέσω Encapsulation, Inheritance (LibraryItem → Book → DigitalBook), Polymorphism (getDescription()) και Abstraction.

Java Collections: Χρήση ArrayList για τη διαχείριση των δεδομένων.

Date Handling: Αξιοποίηση του σύγχρονου LocalDate API.

Validation Rules: Έλεγχοι εγκυρότητας (π.χ. απαγόρευση μελλοντικών ετών έκδοσης, αρνητικών μεγεθών αρχείων, αυτόματη μετατροπή μορφών αρχείων σε κεφαλαία).

Σκοπός Εργασίας
Το έργο αναπτύχθηκε για την πρακτική εξάσκηση σε:

Αντικειμενοστραφή Σχεδίαση & Clean Architecture

Service Layer Design

Χρήση Interfaces και Πολυμορφισμού

Διαχείριση δεδομένων σε Java

Στοιχεία Δημιουργού
Ευστράτιος Βασιλέλλης

GitHub: https://github.com/stratvas

Αγγλική Έκδοση (English Version) - Ideal for GitHub README.md
📚 Library Management System in Java
Description
A console-based Library Management System developed in Java using core Object-Oriented Programming principles and clean architecture practices. The application allows users to manage library items, members, borrowing operations, and reports through an interactive console menu.

Project Structure
Plaintext
src/
├── model/       # LibraryItem, Book, DigitalBook, Magazine, Loan, Member
├── service/     # Library (Core Business Logic)
├── contracts/   # Borrowable, Searchable (Interfaces)
├── util/        # ReportGenerator
└── Main.java    # Entry point
Main Features & Menu
Add Item

Add Member

Search Items

Borrow Item

Return Item

Generate Reports & Statistics

Exit

Technical Characteristics & OOP Concepts
OOP Implementation: Encapsulation (private fields, getters/setters), Inheritance (LibraryItem → Book → DigitalBook), Polymorphism (getDescription()), and Abstraction.

Collections & APIs: Java Collections (ArrayList) and LocalDate API.

Validation Mechanisms: Robust checks ensuring data integrity (e.g., rejecting empty titles, future years, negative file sizes, with automatic string formatting).

Service Layer Pattern: Centralized transaction and data management inside the Library class.

Educational Purpose
This project focuses on practical understanding of:

Java Programming & Clean Architecture

Object-Oriented Design (OOD)

Service Layer Pattern

Interfaces and Abstraction

Author
Evstratios Vasilellis

GitHub: https://github.com/stratvas
