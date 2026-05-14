package gr.university.library.model;

/**
 * Αντιπροσωπεύει ένα περιοδικό στη βιβλιοθήκη.
 * Επεκτείνει το LibraryItem με αριθμό τεύχους.
 */
public class Magazine extends LibraryItem {

    private int issueNumber;

    // ----- κατασκευαστής -----

    public Magazine(String code, String title, int year, int issueNumber) {
        super(code, title, year);
        setIssueNumber(issueNumber);
    }

    // ----- μέθοδος ανάκτησης -----

    public int getIssueNumber() { return issueNumber; }

    // ----- setter με επικύρωση -----

    public void setIssueNumber(int issueNumber) {
        if (issueNumber <= 0) {
            throw new IllegalArgumentException("Issue number must be a positive integer.");
        }
        this.issueNumber = issueNumber;
    }

    // ----- υπερφορτωμένες μέθοδοι -----

    @Override
    public String getDescription() {
        return String.format("Magazine | Title: \"%s\" | Issue #%d", getTitle(), issueNumber);
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" | Issue: #%d", issueNumber);
    }
}
