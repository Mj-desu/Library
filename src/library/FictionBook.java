package library;

/**
 * This class represents a fiction book in the library system. It contains the
 * title, author, and year of publication. extends the class book
 */
public class FictionBook extends Book {
  /**
   * Constructs a new Book object with the specified title, author, and
   * publication year.
   *
   * @param title       The title of the book
   * @param author      The author of the book
   * @param yearPublish The publication year of the book
   */
  public FictionBook(final String title, final String author,
      final int yearPublish) {
    super(title, author, yearPublish);
  }
}
