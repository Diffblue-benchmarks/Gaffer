package uk.gov.gchq.gaffer.commonutil.iterable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class RepeatItemIteratorDiffblueTest {
  /**
   * Test {@link RepeatItemIterator#RepeatItemIterator(Object, long)}.
   *
   * <p>Method under test: {@link RepeatItemIterator#RepeatItemIterator(Object, long)}
   */
  @Test
  @DisplayName("Test new RepeatItemIterator(Object, long)")
  @Tag("MaintainedByDiffblue")
  void testNewRepeatItemIterator() {
    // Arrange and Act
    RepeatItemIterator<Object> actualRepeatItemIterator = new RepeatItemIterator<>("Item", 1L);

    // Assert
    assertEquals("Item", actualRepeatItemIterator.next());
    assertFalse(actualRepeatItemIterator.hasNext());
  }

  /**
   * Test {@link RepeatItemIterator#hasNext()}.
   *
   * <ul>
   *   <li>Given {@link RepeatItemIterator#RepeatItemIterator(Object, long)} with {@code Item} and
   *       repeats is minus one.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link RepeatItemIterator#hasNext()}
   */
  @Test
  @DisplayName(
      "Test hasNext(); given RepeatItemIterator(Object, long) with 'Item' and repeats is minus one; then return 'false'")
  @Tag("MaintainedByDiffblue")
  void testHasNext_givenRepeatItemIteratorWithItemAndRepeatsIsMinusOne_thenReturnFalse() {
    // Arrange
    RepeatItemIterator<Object> repeatItemIterator = new RepeatItemIterator<>("Item", -1L);

    // Act and Assert
    assertFalse(repeatItemIterator.hasNext());
  }

  /**
   * Test {@link RepeatItemIterator#hasNext()}.
   *
   * <ul>
   *   <li>Given {@link RepeatItemIterator#RepeatItemIterator(Object, long)} with {@code Item} and
   *       repeats is one.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link RepeatItemIterator#hasNext()}
   */
  @Test
  @DisplayName(
      "Test hasNext(); given RepeatItemIterator(Object, long) with 'Item' and repeats is one; then return 'true'")
  @Tag("MaintainedByDiffblue")
  void testHasNext_givenRepeatItemIteratorWithItemAndRepeatsIsOne_thenReturnTrue() {
    // Arrange
    RepeatItemIterator<Object> repeatItemIterator = new RepeatItemIterator<>("Item", 1L);

    // Act and Assert
    assertTrue(repeatItemIterator.hasNext());
  }

  /**
   * Test {@link RepeatItemIterator#next()}.
   *
   * <ul>
   *   <li>Given {@link RepeatItemIterator#RepeatItemIterator(Object, long)} with {@code Item} and
   *       repeats is one.
   *   <li>Then return {@code Item}.
   * </ul>
   *
   * <p>Method under test: {@link RepeatItemIterator#next()}
   */
  @Test
  @DisplayName(
      "Test next(); given RepeatItemIterator(Object, long) with 'Item' and repeats is one; then return 'Item'")
  @Tag("MaintainedByDiffblue")
  void testNext_givenRepeatItemIteratorWithItemAndRepeatsIsOne_thenReturnItem() {
    // Arrange
    RepeatItemIterator<Object> repeatItemIterator = new RepeatItemIterator<>("Item", 1L);

    // Act and Assert
    assertEquals("Item", repeatItemIterator.next());
    assertFalse(repeatItemIterator.hasNext());
  }

  /**
   * Test {@link RepeatItemIterator#next()}.
   *
   * <ul>
   *   <li>Then throw {@link NoSuchElementException}.
   * </ul>
   *
   * <p>Method under test: {@link RepeatItemIterator#next()}
   */
  @Test
  @DisplayName("Test next(); then throw NoSuchElementException")
  @Tag("MaintainedByDiffblue")
  void testNext_thenThrowNoSuchElementException() {
    // Arrange
    RepeatItemIterator<Object> repeatItemIterator = new RepeatItemIterator<>("Item", -1L);

    // Act and Assert
    assertThrows(NoSuchElementException.class, () -> repeatItemIterator.next());
  }
}
