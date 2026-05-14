package gr.university.library.model;

/**
 * Αντιπροσωπεύει ένα μέλος καθηγητή της βιβλιοθήκης.
 * Οι καθηγητές έχουν υψηλότερο όριο ταυτόχρονων δανεισμών (10 αντικείμενα)
 * και μεγαλύτερη διάρκεια δανεισμού (30 ημέρες) σε σύγκριση με τους φοιτητές.
 */
public class ProfessorMember extends Member {

    /** Μέγιστοι ταυτόχρονοι δανεισμοί για έναν καθηγητή. */
    public static final int PROFESSOR_MAX_LOANS = 10;

    private String subject;

    // ----- κατασκευαστής -----

    public ProfessorMember(String id, String name, String email, String subject) {
        super(id, name, email);
        setSubject(subject);
        this.maxLoans = PROFESSOR_MAX_LOANS;
    }

    // ----- μέθοδος ανάκτησης -----

    public String getSubject() { return subject; }

    // ----- setter με επικύρωση -----

    public void setSubject(String subject) {
        if (subject == null || subject.trim().isEmpty()) {
            throw new IllegalArgumentException("Subject cannot be empty.");
        }
        this.subject = subject.trim();
    }

    // ----- υπερφορτωμένες μέθοδοι -----

    @Override
    public String getDescription() {
        return String.format("Professor | Name: %s | Subject: %s", getName(), subject);
    }

    @Override
    public int calculateMaxLoanDays() {
        return 30;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" | Professor | Subject: %s", subject);
    }
}
