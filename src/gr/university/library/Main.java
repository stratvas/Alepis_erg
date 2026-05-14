package gr.university.library;

import gr.university.library.model.*;
import gr.university.library.service.Library;
import gr.university.library.util.ReportGenerator;

import java.util.List;
import java.util.Scanner;

/**
 * Σημείο εισόδου της εφαρμογής.
 * Εμφανίζει επαναλαμβανόμενο μενού κονσόλας και αναθέτει όλη τη λογική
 * στην υπηρεσία Library και στις κλάσεις μοντέλου.
 */
public class Main {

    private static final Library library = new Library();
    private static final Scanner scanner  = new Scanner(System.in);

    // =========================================================
    //  Σημείο εισόδου
    // =========================================================

    public static void main(String[] args) {
        System.out.println("=========================================");
        System.out.println("   Welcome to the University Library     ");
        System.out.println("=========================================");

        int choice;
        do {
            printMenu();
            choice = readInt("Choice: ");
            System.out.println();
            switch (choice) {
                case 1  -> addLibraryItem();
                case 2  -> addMember();
                case 3  -> searchItem();
                case 4  -> loanItem();
                case 5  -> returnItem();
                case 6  -> ReportGenerator.printActiveLoans(library);
                case 7  -> ReportGenerator.printStatistics(library);
                case 0  -> System.out.println("Goodbye!");
                default -> System.out.println("Invalid choice. Please enter a number from the menu.");
            }
        } while (choice != 0);

        scanner.close();
    }

    // =========================================================
    //  Μενού
    // =========================================================

    private static void printMenu() {
        System.out.println();
        System.out.println("=== University Library ===");
        System.out.println("1. Add library item");
        System.out.println("2. Add member");
        System.out.println("3. Search library item");
        System.out.println("4. Loan library item");
        System.out.println("5. Return library item");
        System.out.println("6. Show active loans");
        System.out.println("7. Library statistics");
        System.out.println("0. Exit");
    }

    // =========================================================
    //  Διαχειριστές επιλογών
    // =========================================================

    private static void addLibraryItem() {
        System.out.println("--- Add Library Item ---");
        System.out.println("1. Book");
        System.out.println("2. Magazine");
        System.out.println("3. Digital Book");
        int type = readInt("Type: ");

        try {
            String code  = readString("Code: ");
            String title = readString("Title: ");
            int    year  = readInt("Year of publication: ");

            switch (type) {
                case 1 -> {
                    String author = readString("Author: ");
                    String isbn   = readString("ISBN: ");
                    if (library.addItem(new Book(code, title, year, author, isbn))) {
                        System.out.println("Book added successfully.");
                    }
                }
                case 2 -> {
                    int issue = readInt("Issue number: ");
                    if (library.addItem(new Magazine(code, title, year, issue))) {
                        System.out.println("Magazine added successfully.");
                    }
                }
                case 3 -> {
                    String author = readString("Author: ");
                    String isbn   = readString("ISBN: ");
                    double size   = readDouble("File size in MB: ");
                    String format = readString("File format (e.g. PDF, EPUB): ");
                    if (library.addItem(new DigitalBook(code, title, year, author, isbn, size, format))) {
                        System.out.println("Digital book added successfully.");
                    }
                }
                default -> System.out.println("Invalid item type.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Validation error: " + e.getMessage());
        }
    }

    private static void addMember() {
        System.out.println("--- Add Member ---");
        System.out.println("1. Student");
        System.out.println("2. Professor");
        int type = readInt("Type: ");

        try {
            String id    = readString("Member ID: ");
            String name  = readString("Full name: ");
            String email = readString("Email: ");

            switch (type) {
                case 1 -> {
                    String reg  = readString("Registration number: ");
                    String dept = readString("Department: ");
                    if (library.addMember(new StudentMember(id, name, email, reg, dept))) {
                        System.out.println("Student member added successfully.");
                    }
                }
                case 2 -> {
                    String subject = readString("Academic subject: ");
                    if (library.addMember(new ProfessorMember(id, name, email, subject))) {
                        System.out.println("Professor member added successfully.");
                    }
                }
                default -> System.out.println("Invalid member type.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Validation error: " + e.getMessage());
        }
    }

    private static void searchItem() {
        System.out.println("--- Search Library Item ---");
        System.out.println("1. By code");
        System.out.println("2. By title");
        System.out.println("3. By author");
        int type = readInt("Search by: ");

        switch (type) {
            case 1 -> {
                String code = readString("Item code: ");
                LibraryItem item = library.findItemByCode(code);
                if (item != null) {
                    System.out.println("\nFound:");
                    System.out.println("  " + item);
                    System.out.println("  " + item.getDescription());
                } else {
                    System.out.println("No item found with code '" + code + "'.");
                }
            }
            case 2 -> {
                String title   = readString("Title (partial match): ");
                List<LibraryItem> res = library.findItemsByTitle(title);
                ReportGenerator.printSearchResults(res);
            }
            case 3 -> {
                String author  = readString("Author (partial match): ");
                List<LibraryItem> res = library.findItemsByAuthor(author);
                ReportGenerator.printSearchResults(res);
            }
            default -> System.out.println("Invalid search option.");
        }
    }

    private static void loanItem() {
        System.out.println("--- Loan Library Item ---");
        ReportGenerator.printAllItems(library);
        String itemCode = readString("Enter item code to loan: ");
        ReportGenerator.printAllMembers(library);
        String memberId = readString("Enter member ID: ");
        library.loanItem(itemCode, memberId);
    }

    private static void returnItem() {
        System.out.println("--- Return Library Item ---");
        ReportGenerator.printActiveLoans(library);
        String itemCode = readString("Enter item code to return: ");
        library.returnItem(itemCode);
    }

    // =========================================================
    //  Βοηθητικές μέθοδοι εισόδου
    // =========================================================

    /** Διαβάζει μια μη κενή συμβολοσειρά από stdin. Ζητάει επανάληψη σε περίπτωση κενής εισόδου. */
    private static String readString(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            if (!input.isEmpty()) return input;
            System.out.println("Input cannot be empty. Please try again.");
        }
    }

    /** Διαβάζει έναν ακέραιο από stdin. Ζητάει επανάληψη σε μη αριθμητική είσοδο. */
    private static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = scanner.nextLine().trim();
            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid integer.");
            }
        }
    }

    /** Διαβάζει έναν θετικό δεκαδικό από stdin. Ζητάει επανάληψη σε άκυρη είσοδο. */
    private static double readDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = scanner.nextLine().trim();
            try {
                double val = Double.parseDouble(line);
                if (val > 0) return val;
                System.out.println("Value must be greater than zero.");
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }
}
