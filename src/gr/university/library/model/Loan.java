package gr.university.library.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Αντιπροσωπεύει τη σχέση μεταξύ ενός μέλους και ενός αντικειμένου βιβλιοθήκης
 * κατά τη διάρκεια μιας μοναδικής περιόδου δανεισμού.
 */
public class Loan {

    private static final DateTimeFormatter DATE_FMT = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private final Member      member;
    private final LibraryItem item;
    private final LocalDate   loanDate;
    private LocalDate         returnDate;
    private boolean           active;

    // ----- κατασκευαστής -----

    public Loan(Member member, LibraryItem item) {
        this.member   = member;
        this.item     = item;
        this.loanDate = LocalDate.now();
        this.active   = true;
    }

    // ----- μέθοδοι ανάκτησης -----

    public Member      getMember()     { return member; }
    public LibraryItem getItem()       { return item; }
    public LocalDate   getLoanDate()   { return loanDate; }
    public LocalDate   getReturnDate() { return returnDate; }
    public boolean     isActive()      { return active; }

    // ----- ολοκλήρωση του δανεισμού -----

    /**
     * Σηματοδοτεί αυτόν τον δανεισμό ως ολοκληρωμένο και καταγράφει την τρέχουσα ημερομηνία ως ημερομηνία επιστροφής.
     */
    public void complete() {
        this.returnDate = LocalDate.now();
        this.active     = false;
    }

    // ----- μέθοδος toString -----

    @Override
    public String toString() {
        String status = active
            ? "Active (since " + loanDate.format(DATE_FMT) + ")"
            : "Returned on " + returnDate.format(DATE_FMT);
        return String.format("Loan | Member: %-20s | Item: %-30s | %s",
            member.getName(), item.getTitle(), status);
    }
}
