package library;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BookRentalSystemTest {
  /**
   *Data initialization.
   */
  private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
  /**
   */
  private BookRentalSystem toshokan;
  /**
   */
  private Book f1;
  /**
   */
  private Book n1;

  @BeforeEach
  void setup() {
    toshokan = new BookRentalSystem();
    final int year1 = 1960;
    final int year2 = 2000;
    f1 = new FictionBook("To Kill a Mockingbird", "Harper Lee", year1);
    n1 = new NonFictionBook("The Tipping Point", "M. Gladwell", year2);

    // Redirect System.out to capture printed output. This is for test case
    // #5 and 6
    outContent.reset();
    System.setOut(new PrintStream(outContent));

  }

  @AfterEach
  void exit() {
    // Clear the library after each test
    BookRentalSystem.clearLibrary();
  }

  @Test
  @DisplayName("Adding books using addBooks method")
  void testPagDagdagNgBagongAklatParaan() {

    int actualOutput;

    toshokan.addBooks(n1);
    toshokan.addBooks(f1);
    int expectedOutput = 2;

    actualOutput = BookRentalSystem.getLibrarySize();
    assertEquals(expectedOutput, actualOutput,
        () -> "Expected: " + expectedOutput + ", but got: " + actualOutput);
  }

  @Test
  @DisplayName("Renting a book")
  void testPagUpaNgAklatGamitAngMayBisangIndex() {

    toshokan.addBooks(n1);
    toshokan.addBooks(f1);

    toshokan.rentBooks(0);

    assertTrue(BookRentalSystem.getLibrary().get(0).isRented());
  }

  @Test
  @DisplayName("Renting a book using invalid index")
  void testPagUpaNgAklatGamitAngWalangBisangIndex() {
    final int fakeIndex = 5;
    toshokan.addBooks(n1);
    toshokan.addBooks(f1);

    assertThrows(IndexOutOfBoundsException.class, () -> {
      toshokan.rentBooks(fakeIndex);
    }, "Index 5 should be out of bounds!");
  }

  @Test
  @DisplayName("Displaying books")
  void testPagPapakitaNgMgaAklat() {
    toshokan.addBooks(n1);
    toshokan.addBooks(f1);
    toshokan.displayBooks();

    String expectedOutput = n1.getTitle() + System.lineSeparator()
        + f1.getTitle() + System.lineSeparator();
    assertEquals(expectedOutput, outContent.toString(), () -> "Expected: "
        + expectedOutput + ", but got: " + outContent.toString());

  }

  @Test
  @DisplayName("Displaying rented books")
  void testPagpapakitaNgInupahangAklat() {
    toshokan.addBooks(n1);
    toshokan.addBooks(f1);
    toshokan.rentBooks(0);

    toshokan.displayRentedBooks();

    String expectedOutput = n1.getTitle() + System.lineSeparator();
    assertEquals(expectedOutput, outContent.toString(), () -> "Expected: "
        + expectedOutput + ", but got: " + outContent.toString());

  }

}
