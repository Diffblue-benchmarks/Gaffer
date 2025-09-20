package uk.gov.gchq.gaffer.commonutil.iterable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Iterator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EmptyIterableDiffblueTest {
  /**
   * Test {@link EmptyIterable#iterator()}.
   *
   * <p>Method under test: {@link EmptyIterable#iterator()}
   */
  @Test
  @DisplayName("Test iterator()")
  @Tag("MaintainedByDiffblue")
  void testIterator() {
    // Arrange
    EmptyIterable<Object> emptyIterable = new EmptyIterable<>();

    // Act
    Iterator<Object> actualIteratorResult = emptyIterable.iterator();

    // Assert
    assertTrue(actualIteratorResult instanceof EmptyIterator);
    assertFalse(actualIteratorResult.hasNext());
  }

  /**
   * Test {@link EmptyIterable#equals(Object)}, and {@link EmptyIterable#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EmptyIterable#equals(Object)}
   *   <li>{@link EmptyIterable#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EmptyIterable<Object> emptyIterable = new EmptyIterable<>();
    EmptyIterable<Object> emptyIterable2 = new EmptyIterable<>();

    // Act and Assert
    assertEquals(emptyIterable, emptyIterable2);
    assertEquals(emptyIterable.hashCode(), emptyIterable2.hashCode());
  }

  /**
   * Test {@link EmptyIterable#equals(Object)}, and {@link EmptyIterable#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EmptyIterable#equals(Object)}
   *   <li>{@link EmptyIterable#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EmptyIterable<Object> emptyIterable = new EmptyIterable<>();

    // Act and Assert
    assertEquals(emptyIterable, emptyIterable);
    int expectedHashCodeResult = emptyIterable.hashCode();
    assertEquals(expectedHashCodeResult, emptyIterable.hashCode());
  }

  /**
   * Test {@link EmptyIterable#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EmptyIterable#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EmptyIterable<Object> emptyIterable = new EmptyIterable<>();

    // Act and Assert
    assertNotEquals(emptyIterable, "Obj");
  }

  /**
   * Test {@link EmptyIterable#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EmptyIterable#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    EmptyIterable<Object> emptyIterable = new EmptyIterable<>();

    // Act and Assert
    assertNotEquals(emptyIterable, null);
  }

  /**
   * Test {@link EmptyIterable#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EmptyIterable#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    EmptyIterable<Object> emptyIterable = new EmptyIterable<>();

    // Act and Assert
    assertNotEquals(emptyIterable, "Different type to EmptyIterable");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link EmptyIterable}
   *   <li>{@link EmptyIterable#close()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  void testGettersAndSetters() {
    // Arrange and Act
    EmptyIterable<Object> actualEmptyIterable = new EmptyIterable<>();
    actualEmptyIterable.close();

    // Assert
    Iterator<Object> iteratorResult = actualEmptyIterable.iterator();
    assertTrue(iteratorResult instanceof EmptyIterator);
    assertFalse(iteratorResult.hasNext());
  }
}
