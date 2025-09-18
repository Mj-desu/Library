package library;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BookTest {
  /**
   */
  private Book hon;

  @BeforeEach
  void setup() {
    final int year = 1954;
    hon = new FictionBook("The Lord of the Rings", "J.R.R. Tolkien", year);

  }

  @AfterEach
  void exit() {
    hon = null;
  }

  @Test
  void testPagawaNgBagongAklat() {
    assertNotNull(hon);
    assertFalse(hon.isRented());

  }

  @Test
  void testPagUpaNgAklat() {
    hon.rent();
    assertTrue(hon.isRented());
  }

}
