package gr.university.library.service;

import gr.university.library.contracts.Searchable;
import gr.university.library.model.Book;
import gr.university.library.model.LibraryItem;
import gr.university.library.model.Loan;
import gr.university.library.model.Member;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Κεντρική κλάση υπηρεσίας που διαχειρίζεται μέλη, αντικείμενα βιβλιοθήκης και δανεισμούς.
 * Υλοποιεί το Searchable για να παρέχει ενιαία αναζήτηση στις δύο συλλογές.
 *
 * Όλοι οι κανόνες επιχειρησιακής λογικής (έλεγχος διπλοεγγραφής, διαθεσιμότητα, όρια δανεισμών)
 * ζουν εδώ ώστε το Main να παραμένει λεπτό επίπεδο διεπαφής χρήστη.
 */
public class Library implements Searchable {

    private final List<LibraryItem> items   = new ArrayList<>();
    private final List<Member>      members = new ArrayList<>();
    private final List<Loan>        loans   = new ArrayList<>();

    // =========================================================
    //  Διαχείριση αντικειμένων
    // =========================================================

    /**
     * Προσθέτει νέο αντικείμενο στη βιβλιοθήκη.
     * Επιστρέφει false (και εκτυπώνει μήνυμα) αν ο κωδικός χρησιμοποιείται ήδη.
     */
    public boolean addItem(LibraryItem item) {
        if (item == null) return false;
        if (findItemByCode(item.getCode()) != null) {
            System.out.println("Error: an item with code '" + item.getCode() + "' already exists.");
            return false;
        }
        items.add(item);
        return true;
    }

    // =========================================================
    //  Διαχείριση μελών
    // =========================================================

    /**
     * Καταχωρεί νέο μέλος.
     * Επιστρέφει false (και εκτυπώνει μήνυμα) αν το ID έχει ήδη καταχωρηθεί.
     */
    public boolean addMember(Member member) {
        if (member == null) return false;
        if (findMemberById(member.getId()) != null) {
            System.out.println("Error: a member with ID '" + member.getId() + "' already exists.");
            return false;
        }
        members.add(member);
        return true;
    }

    // =========================================================
    //  Διαχείριση δανεισμών
    // =========================================================

    /**
     * Δανείζει το αντικείμενο που αναγνωρίζεται από itemCode στο μέλος που αναγνωρίζεται από memberId.
     * Επιβάλλει: το αντικείμενο να υπάρχει, το μέλος να υπάρχει, το αντικείμενο να είναι διαθέσιμο,
     * το μέλος να βρίσκεται κάτω από το όριο δανεισμών.
     */
    public boolean loanItem(String itemCode, String memberId) {
        LibraryItem item = findItemByCode(itemCode);
        if (item == null) {
            System.out.println("Error: no item found with code '" + itemCode + "'.");
            return false;
        }
        Member member = findMemberById(memberId);
        if (member == null) {
            System.out.println("Error: no member found with ID '" + memberId + "'.");
            return false;
        }
        if (!item.isAvailable()) {
            System.out.println("Error: \"" + item.getTitle() + "\" is currently not available.");
            return false;
        }
        long activeCount = loans.stream()
            .filter(l -> l.isActive() && l.getMember().getId().equals(memberId))
            .count();
        if (activeCount >= member.getMaxLoans()) {
            System.out.println("Error: " + member.getName()
                + " has reached the maximum loan limit of " + member.getMaxLoans() + ".");
            return false;
        }
        item.borrowTo(member);
        loans.add(new Loan(member, item));
        System.out.println("Success: \"" + item.getTitle() + "\" loaned to " + member.getName() + ".");
        return true;
    }

    /**
     * Επιστρέφει το αντικείμενο που αναγνωρίζεται από itemCode.
     * Βρίσκει την ενεργή εγγραφή δανεισμού, τη σηματοδοτεί ως ολοκληρωμένη και αποκαθιστά τη διαθεσιμότητα.
     */
    public boolean returnItem(String itemCode) {
        LibraryItem item = findItemByCode(itemCode);
        if (item == null) {
            System.out.println("Error: no item found with code '" + itemCode + "'.");
            return false;
        }
        Loan activeLoan = loans.stream()
            .filter(l -> l.isActive() && l.getItem().getCode().equalsIgnoreCase(itemCode))
            .findFirst()
            .orElse(null);
        if (activeLoan == null) {
            System.out.println("Error: no active loan found for \"" + item.getTitle() + "\".");
            return false;
        }
        item.returnItem();
        activeLoan.complete();
        System.out.println("Success: \"" + item.getTitle() + "\" has been returned and is now available.");
        return true;
    }

    // =========================================================
    //  Προσπελάσεις συλλογής
    // =========================================================

    public List<LibraryItem> getAllItems()   { return items; }
    public List<Member>      getAllMembers() { return members; }
    public List<Loan>        getAllLoans()   { return loans; }

    public List<Loan> getActiveLoans() {
        return loans.stream().filter(Loan::isActive).collect(Collectors.toList());
    }

    // =========================================================
    //  Διεπαφή Searchable
    // =========================================================

    @Override
    public LibraryItem findItemByCode(String code) {
        return items.stream()
            .filter(i -> i.getCode().equalsIgnoreCase(code))
            .findFirst()
            .orElse(null);
    }

    @Override
    public Member findMemberById(String id) {
        return members.stream()
            .filter(m -> m.getId().equalsIgnoreCase(id))
            .findFirst()
            .orElse(null);
    }

    @Override
    public List<LibraryItem> findItemsByTitle(String title) {
        return items.stream()
            .filter(i -> i.getTitle().toLowerCase().contains(title.toLowerCase()))
            .collect(Collectors.toList());
    }

    @Override
    public List<LibraryItem> findItemsByAuthor(String author) {
        return items.stream()
            .filter(i -> (i instanceof Book b)
                && b.getAuthor().toLowerCase().contains(author.toLowerCase()))
            .collect(Collectors.toList());
    }

    // =========================================================
    //  Βοηθητική μέθοδος πακέτου που χρησιμοποιείται εσωτερικά για ελέγχους εισόδου
    // =========================================================

    /** Επιστρέφει true αν η δοθείσα συμβολοσειρά κωδικού δεν είναι null και δεν είναι κενή. */
    boolean isValidCode(String code) {
        return code != null && !code.trim().isEmpty();
    }
}
