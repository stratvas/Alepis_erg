package gr.university.library.util;

import gr.university.library.model.LibraryItem;
import gr.university.library.model.Loan;
import gr.university.library.model.Member;
import gr.university.library.service.Library;

import java.util.List;

/**
 * Βοηθητική κλάση για εκτύπωση μορφοποιημένων αναφορών στην κονσόλα.
 *
 * Δηλώνεται final ώστε να μην μπορεί να κληρονομηθεί – ο ρόλος της είναι μια άστατη
 * συλλογή στατικών βοηθητικών μεθόδων, όχι μια βάση για επέκταση.
 * Ο ιδιωτικός κατασκευαστής αποτρέπει τη δημιουργία στιγμιοτύπου.
 */
public final class ReportGenerator {

    private static final String SEPARATOR = "-".repeat(70);

    private ReportGenerator() {
        // Δεν μπορεί να δημιουργηθεί στιγμιότυπο
    }

    // ----- αναφορές αντικειμένων -----

    public static void printAllItems(Library library) {
        List<LibraryItem> items = library.getAllItems();
        System.out.println("\n" + SEPARATOR);
        System.out.println("  LIBRARY ITEMS  (" + items.size() + " total)");
        System.out.println(SEPARATOR);
        if (items.isEmpty()) {
            System.out.println("  No items registered yet.");
        } else {
            items.forEach(item -> System.out.println("  " + item));
        }
        System.out.println(SEPARATOR);
    }

    public static void printSearchResults(List<LibraryItem> results) {
        System.out.println("\n" + SEPARATOR);
        System.out.println("  SEARCH RESULTS");
        System.out.println(SEPARATOR);
        if (results == null || results.isEmpty()) {
            System.out.println("  No items found.");
        } else {
            results.forEach(item -> System.out.println("  " + item));
        }
        System.out.println(SEPARATOR);
    }

    // ----- αναφορές μελών -----

    public static void printAllMembers(Library library) {
        List<Member> members = library.getAllMembers();
        System.out.println("\n" + SEPARATOR);
        System.out.println("  MEMBERS  (" + members.size() + " total)");
        System.out.println(SEPARATOR);
        if (members.isEmpty()) {
            System.out.println("  No members registered yet.");
        } else {
            members.forEach(m -> System.out.println("  " + m));
        }
        System.out.println(SEPARATOR);
    }

    // ----- αναφορές δανεισμών -----

    public static void printActiveLoans(Library library) {
        List<Loan> activeLoans = library.getActiveLoans();
        System.out.println("\n" + SEPARATOR);
        System.out.println("  ACTIVE LOANS  (" + activeLoans.size() + " active)");
        System.out.println(SEPARATOR);
        if (activeLoans.isEmpty()) {
            System.out.println("  No active loans.");
        } else {
            activeLoans.forEach(loan -> System.out.println("  " + loan));
        }
        System.out.println(SEPARATOR);
    }

    // ----- στατιστικά -----

    public static void printStatistics(Library library) {
        System.out.println("\n" + SEPARATOR);
        System.out.println("  LIBRARY STATISTICS");
        System.out.println(SEPARATOR);
        System.out.printf("  %-30s %d%n", "Total items registered:",  LibraryItem.getTotalItems());
        System.out.printf("  %-30s %d%n", "Total members registered:", Member.getTotalMembers());
        System.out.printf("  %-30s %d%n", "Active loans:",             library.getActiveLoans().size());
        System.out.printf("  %-30s %d%n", "Total loans (all time):",   library.getAllLoans().size());
        System.out.println(SEPARATOR);
    }
}
