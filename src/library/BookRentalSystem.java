package library;

import java.util.ArrayList;

/**
 * The BookRentalSystem class manages a library of books, allowing for adding,
 * renting, and displaying books. It keeps track of the list of books and their
 * rental status.
 */

public class BookRentalSystem {

  /**
   * A list to store the books in the library.
   */
  private static ArrayList<Book> library;

  /**
   * Constructs a new BookRentalSystem object and initializes the book library.
   */

  // CheckStyle warning is present - incorrect indentation
  public BookRentalSystem() {
    library = new ArrayList<>();
  }

  /**
   * Main method to initialize the BookRentalSystem, add books, and rent a book.
   * This serves as an example of how the system works.
   *
   * @param args Command-line arguments (not used).
   */

  public static void main(final String[] args) {
    BookRentalSystem toshokan = new BookRentalSystem();
    final int yr1 = 1954;
    final int yr2 = 1960;
    final int yr3 = 2000;
    final int yr4 = 1997;

    // Adding books to the library
    toshokan.addBooks(
        new FictionBook("The Lord of the Rings", "J.R.R. Tolkien", yr1));
    toshokan
        .addBooks(new FictionBook("To Kill a Mockingbird", "Harper Lee", yr2));
    toshokan
        .addBooks(new NonFictionBook("The Tipping Point", "M. Gladwell", yr3));
    toshokan.addBooks(
        new NonFictionBook("Guns, Germs, and Steel", "Jared Diamond ", yr4));

    System.out.println("Display all books:");
    toshokan.displayBooks();

    // Renting the first book
    toshokan.rentBooks(0);

    // display rented books
    System.out.println("\nDisplay rented books:");
    toshokan.displayRentedBooks();
  }

  /**
   * Adds book to the library array list.
   *
   * @param book a Book object
   */
  public void addBooks(final Book book) {
    getLibrary().add(book);

  }

  /**
   * Marks the book as rented.
   *
   * @param index index of the book to be rented
   */
  public void rentBooks(final int index) {
    Book selectedBook = getLibrary().get(index);
    selectedBook.rent();
  }

  /**
   * Clear the library.
   */
  public static void clearLibrary() {
    getLibrary().clear();
  }

  /**
   * Returns the size of the library.
   *
   * @return library.size
   */
  public static int getLibrarySize() {
    return getLibrary().size();
  }

  /**
   * Displays the title of the books.
   */
  // CheckStyle warning is present - incorrect indentation
  public void displayBooks() {
    for (Book book : getLibrary()) {
      System.out.println(book.getTitle());
    }
  }

  /**
   * Displays the title of the books marked as rented.
   */
  public void displayRentedBooks() {
    for (Book book : getLibrary()) {
      if (book.isRented()) {
        System.out.println(book.getTitle());
      }
    }
  }

  /**
   * @return library
   */
  public static ArrayList<Book> getLibrary() {
    return library;
  }

}
