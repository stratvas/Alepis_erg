package gr.university.library.contracts;

import gr.university.library.model.Member;

/**
 * Ορίζει το συμβόλαιο για αντικείμενα που μπορούν να δανειστούν από τη βιβλιοθήκη.
 * Υλοποιείται από το LibraryItem και τις υποκλάσεις του.
 */
public interface Borrowable {

    /**
     * Δανείζει αυτό το αντικείμενο στο δοθέν μέλος.
     * Επιστρέφει true αν ο δανεισμός ήταν επιτυχής, false αν δεν είναι διαθέσιμο.
     */
    boolean borrowTo(Member member);

    /**
     * Επιστρέφει αυτό το αντικείμενο στη βιβλιοθήκη.
     * Επιστρέφει true αν η επιστροφή ήταν επιτυχής, false αν είναι ήδη διαθέσιμο.
     */
    boolean returnItem();

    /**
     * Επιστρέφει true αν το αντικείμενο είναι αυτή τη στιγμή διαθέσιμο για δανεισμό.
     */
    boolean isAvailable();
}
