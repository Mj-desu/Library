package library;

/**
 * This class represents a non fiction book in the library system. It contains
 * the title, author, and year of publication. Extends the book class
 */
public class NonFictionBook extends Book {
  /**
   * Constructs a new Book object with the specified title, author, and
   * publication year.
   *
   * @param title       The title of the book
   * @param author      The author of the book
   * @param yearPublish The publication year of the book
   */
  public NonFictionBook(final String title, final String author,
      final int yearPublish) {
    super(title, author, yearPublish);
  }
}
