package gr.university.library.contracts;

import gr.university.library.model.LibraryItem;
import gr.university.library.model.Member;

import java.util.List;

/**
 * Ορίζει τη συμπεριφορά αναζήτησης στις συλλογές της βιβλιοθήκης.
 * Υλοποιείται από την υπηρεσία Library.
 */
public interface Searchable {

    /** Βρίσκει ένα αντικείμενο βιβλιοθήκης με τον μοναδικό του κωδικό. Επιστρέφει null αν δεν βρεθεί. */
    LibraryItem findItemByCode(String code);

    /** Βρίσκει μέλος με το μοναδικό του ID. Επιστρέφει null αν δεν βρεθεί. */
    Member findMemberById(String id);

    /** Επιστρέφει όλα τα αντικείμενα των οποίων ο τίτλος περιέχει τη δοθείσα συμβολοσειρά (χωρίς διάκριση πεζών/κεφαλαίων). */
    List<LibraryItem> findItemsByTitle(String title);

    /** Επιστρέφει όλα τα αντικείμενα (Book / DigitalBook) των οποίων ο συγγραφέας περιέχει τη δοθείσα συμβολοσειρά. */
    List<LibraryItem> findItemsByAuthor(String author);
}
