package gr.university.library.model;

/**
 * Αντιπροσωπεύει ένα φυσικό βιβλίο στη βιβλιοθήκη.
 * Επεκτείνει το LibraryItem με πεδία συγγραφέα και ISBN.
 */
public class Book extends LibraryItem {

    private String author;
    private String isbn;

    // ----- κατασκευαστής -----

    public Book(String code, String title, int year, String author, String isbn) {
        super(code, title, year);
        setAuthor(author);
        setIsbn(isbn);
    }

    // ----- μέθοδοι ανάκτησης -----

    public String getAuthor() { return author; }
    public String getIsbn()   { return isbn; }

    // ----- setters με επικύρωση -----

    public void setAuthor(String author) {
        if (author == null || author.trim().isEmpty()) {
            throw new IllegalArgumentException("Author cannot be empty.");
        }
        this.author = author.trim();
    }

    public void setIsbn(String isbn) {
        if (isbn == null || isbn.trim().isEmpty()) {
            throw new IllegalArgumentException("ISBN cannot be empty.");
        }
        this.isbn = isbn.trim();
    }

    // ----- υπερφορτωμένες μέθοδοι -----

    @Override
    public String getDescription() {
        return String.format("Book | Title: \"%s\" | Author: %s | ISBN: %s", getTitle(), author, isbn);
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" | Author: %s | ISBN: %s", author, isbn);
    }
}
