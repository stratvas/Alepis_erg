package gr.university.library.model;

/**
 * Αντιπροσωπεύει ένα φοιτητικό μέλος της βιβλιοθήκης.
 * Οι φοιτητές μπορούν να δανειστούν έως STUDENT_MAX_LOANS αντικείμενα ταυτόχρονα
 * και να τα κρατήσουν για έως 14 ημέρες.
 */
public class StudentMember extends Member {

    /** Μέγιστοι ταυτόχρονοι δανεισμοί για έναν φοιτητή. */
    public static final int STUDENT_MAX_LOANS = 3;

    private String registrationNumber;
    private String department;

    // ----- κατασκευαστής -----

    public StudentMember(String id, String name, String email,
                         String registrationNumber, String department) {
        super(id, name, email);
        setRegistrationNumber(registrationNumber);
        setDepartment(department);
        this.maxLoans = STUDENT_MAX_LOANS;
    }

    // ----- μέθοδοι ανάκτησης -----

    public String getRegistrationNumber() { return registrationNumber; }
    public String getDepartment()         { return department; }

    // ----- setters με επικύρωση -----

    public void setRegistrationNumber(String registrationNumber) {
        if (registrationNumber == null || registrationNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("Registration number cannot be empty.");
        }
        this.registrationNumber = registrationNumber.trim();
    }

    public void setDepartment(String department) {
        if (department == null || department.trim().isEmpty()) {
            throw new IllegalArgumentException("Department cannot be empty.");
        }
        this.department = department.trim();
    }

    // ----- υπερφορτωμένες μέθοδοι -----

    @Override
    public String getDescription() {
        return String.format("Student | Name: %s | Reg#: %s | Dept: %s",
            getName(), registrationNumber, department);
    }

    @Override
    public int calculateMaxLoanDays() {
        return 14;
    }

    @Override
    public String toString() {
        return super.toString()
            + String.format(" | Student | Reg#: %s | Dept: %s", registrationNumber, department);
    }
}
