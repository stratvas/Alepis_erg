package gr.university.library.model;

import gr.university.library.contracts.Borrowable;

import java.time.Year;

/**
 * Αφηρημένη βάση για όλα τα αντικείμενα της βιβλιοθήκης.
 * Υλοποιεί το Borrowable ώστε κάθε αντικείμενο να μπορεί να δανειστεί/επιστραφεί.
 * Οι υποκλάσεις πρέπει να υλοποιούν το getDescription().
 */
public abstract class LibraryItem implements Borrowable {

    // ----- στατικά μέλη -----

    /** Παρακολουθεί τον συνολικό αριθμό αντικειμένων LibraryItem που έχουν δημιουργηθεί. */
    private static int totalItems = 0;

    /** Προεπιλεγμένη περίοδος δανεισμού που χρησιμοποιείται σε όλο το σύστημα. */
    public static final int DEFAULT_LOAN_DAYS = 14;

    // ----- πεδία αντικειμένου (ιδιωτικά – προσπελάζονται μέσω μεθόδων ανάκτησης/ρύθμισης) -----

    private String code;
    private String title;
    private int year;
    private boolean available;

    // ----- κατασκευαστής -----

    public LibraryItem(String code, String title, int year) {
        setCode(code);
        setTitle(title);
        setYear(year);
        this.available = true;
        totalItems++;
    }

    // ----- στατική μέθοδος ανάκτησης -----

    public static int getTotalItems() {
        return totalItems;
    }

    // ----- μέθοδοι ανάκτησης -----

    public String getCode()  { return code; }
    public String getTitle() { return title; }
    public int    getYear()  { return year; }

    // ----- setters με επικύρωση -----

    public final void setCode(String code) {
        if (code == null || code.trim().isEmpty()) {
            throw new IllegalArgumentException("Item code cannot be null or empty.");
        }
        this.code = code.trim();
    }

    public void setTitle(String title) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Title cannot be empty.");
        }
        this.title = title.trim();
    }

    public void setYear(int year) {
        int currentYear = Year.now().getValue();
        if (year <= 0 || year > currentYear) {
            throw new IllegalArgumentException(
                "Year must be a positive number and not in the future (max " + currentYear + ").");
        }
        this.year = year;
    }

    // ----- διεπαφή Borrowable -----

    @Override
    public boolean isAvailable() {
        return available;
    }

    @Override
    public boolean borrowTo(Member member) {
        if (!available) {
            return false;
        }
        available = false;
        return true;
    }

    @Override
    public boolean returnItem() {
        if (available) {
            return false;
        }
        available = true;
        return true;
    }

    // ----- αφηρημένη μέθοδος – οι υποκλάσεις παρέχουν ανθρώπινη περιγραφή -----

    public abstract String getDescription();

    // ----- μέθοδος toString -----

    @Override
    public String toString() {
        return String.format("[%s] \"%s\" (%d) | %s",
            code, title, year, available ? "Available" : "Not available");
    }
}
