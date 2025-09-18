package library;

/**
 * This class represents a book in the library system. It contains the title,
 * author, and year of publication.
 */
public abstract class Book {
  /**
   */
  private String title;
  /**
   */
  private String author;
  /**
   */
  private int yearPublished;
  /**
   */
  private boolean isRented;

  /**
   * Constructs a new Book object with the specified title, author, and
   * publication year.
   *
   * @param bookTitle   The title of the book
   * @param bookAuthor  The author of the book
   * @param yearPublish The publication year of the book
   */
  public Book(final String bookTitle, final String bookAuthor,
      final int yearPublish) {
    this.setAuthor(bookAuthor);
    this.setTitle(bookTitle);
    this.setYearPublished(yearPublish);
    this.isRented = false;
  }

  /**
   * @return isRented boolean value
   */
  public boolean isRented() {
    return isRented;
  }

  /**
   * Marks the object as rented.
   * @return isRented
   */
  public boolean rent() {
    isRented = true;
    return isRented;
  }

  /**
   * @return yearPublished
   */
  public int getYearPublished() {
    return yearPublished;
  }

  /**
   * @param yearPublish
   */
  public void setYearPublished(final int yearPublish) {
    this.yearPublished = yearPublish;
  }

  /**
   * @return title string
   */
  public String getTitle() {
    return title;
  }

  /**
   * @param bookTitle
   */
  public void setTitle(final String bookTitle) {
    this.title = bookTitle;
  }
  /**
   * @return author
   */
  public String getAuthor() {
    return author;
  }

  /**
   * @param bookAuthor
   */
  public void setAuthor(final String bookAuthor) {
    this.author = bookAuthor;
  }

}
