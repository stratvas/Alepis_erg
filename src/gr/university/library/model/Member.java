package gr.university.library.model;

/**
 * Αφηρημένη βάση για όλα τα μέλη της βιβλιοθήκης.
 * Οι υποκλάσεις (StudentMember, ProfessorMember) ορίζουν τα όρια μέγιστων δανεισμών
 * και την πολιτική διάρκειας δανεισμού.
 */
public abstract class Member {

    // ----- στατικό μέλος -----

    /** Παρακολουθεί τον συνολικό αριθμό αντικειμένων Member που έχουν δημιουργηθεί. */
    private static int totalMembers = 0;

    // ----- πεδία αντικειμένου -----

    private String id;
    private String name;
    private String email;

    /**
     * Μέγιστος αριθμός ταυτόχρονων ενεργών δανεισμών που επιτρέπεται για αυτό το μέλος.
     * Protected ώστε οι υποκλάσεις να μπορούν να τον ορίζουν στον κατασκευαστή τους.
     */
    protected int maxLoans;

    // ----- κατασκευαστής -----

    public Member(String id, String name, String email) {
        setId(id);
        setName(name);
        setEmail(email);
        totalMembers++;
    }

    // ----- στατική μέθοδος ανάκτησης -----

    public static int getTotalMembers() {
        return totalMembers;
    }

    // ----- μέθοδοι ανάκτησης -----

    public String getId()      { return id; }
    public String getName()    { return name; }
    public String getEmail()   { return email; }
    public int    getMaxLoans(){ return maxLoans; }

    // ----- setters με επικύρωση -----

    public final void setId(String id) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("Member ID cannot be null or empty.");
        }
        this.id = id.trim();
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        this.name = name.trim();
    }

    public void setEmail(String email) {
        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("Email must contain the '@' symbol.");
        }
        this.email = email.trim();
    }

    // ----- αφηρημένες μέθοδοι -----

    /** Επιστρέφει μια σύντομη ανθρώπινη περιγραφή αυτού του μέλους. */
    public abstract String getDescription();

    /**
     * Επιστρέφει τον μέγιστο αριθμό ημερών που αυτός ο τύπος μέλους μπορεί να κρατήσει
     * ένα δανεισμένο αντικείμενο.
     */
    public abstract int calculateMaxLoanDays();

    // ----- μέθοδος toString -----

    @Override
    public String toString() {
        return String.format("[%s] %s <%s>", id, name, email);
    }
}
