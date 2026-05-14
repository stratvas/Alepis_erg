package gr.university.library.model;

/**
 * Αντιπροσωπεύει μια ψηφιακή (e-book) εκδοχή βιβλίου.
 * Επεκτείνει το Book με μέγεθος αρχείου και μορφή αρχείου.
 */
public class DigitalBook extends Book {

    private double fileSizeMB;
    private String fileFormat;

    // ----- κατασκευαστής -----

    public DigitalBook(String code, String title, int year,
                       String author, String isbn,
                       double fileSizeMB, String fileFormat) {
        super(code, title, year, author, isbn);
        setFileSizeMB(fileSizeMB);
        setFileFormat(fileFormat);
    }

    // ----- μέθοδοι ανάκτησης -----

    public double getFileSizeMB()  { return fileSizeMB; }
    public String getFileFormat()  { return fileFormat; }

    // ----- setters με επικύρωση -----

    public void setFileSizeMB(double fileSizeMB) {
        if (fileSizeMB <= 0) {
            throw new IllegalArgumentException("File size must be a positive number.");
        }
        this.fileSizeMB = fileSizeMB;
    }

    public void setFileFormat(String fileFormat) {
        if (fileFormat == null || fileFormat.trim().isEmpty()) {
            throw new IllegalArgumentException("File format cannot be empty.");
        }
        this.fileFormat = fileFormat.trim().toUpperCase();
    }

    // ----- υπερφορτωμένες μέθοδοι -----

    @Override
    public String getDescription() {
        return String.format("Digital Book | Title: \"%s\" | Author: %s | Format: %s | Size: %.1f MB",
            getTitle(), getAuthor(), fileFormat, fileSizeMB);
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" | Format: %s | Size: %.1f MB", fileFormat, fileSizeMB);
    }
}
