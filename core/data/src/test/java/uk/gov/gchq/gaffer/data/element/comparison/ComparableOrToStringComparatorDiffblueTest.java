package uk.gov.gchq.gaffer.data.element.comparison;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ComparableOrToStringComparatorDiffblueTest {
  /**
   * Test {@link ComparableOrToStringComparator#compare(Object, Object)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link ComparableOrToStringComparator#compare(Object, Object)}
   */
  @Test
  @DisplayName("Test compare(Object, Object); when 'null'; then return one")
  @Tag("MaintainedByDiffblue")
  void testCompare_whenNull_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals(1, new ComparableOrToStringComparator().compare(null, "Vertex2"));
  }

  /**
   * Test {@link ComparableOrToStringComparator#compare(Object, Object)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link ComparableOrToStringComparator#compare(Object, Object)}
   */
  @Test
  @DisplayName("Test compare(Object, Object); when 'null'; then return zero")
  @Tag("MaintainedByDiffblue")
  void testCompare_whenNull_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, new ComparableOrToStringComparator().compare(null, null));
  }

  /**
   * Test {@link ComparableOrToStringComparator#compare(Object, Object)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then return thirty.
   * </ul>
   *
   * <p>Method under test: {@link ComparableOrToStringComparator#compare(Object, Object)}
   */
  @Test
  @DisplayName("Test compare(Object, Object); when 'true'; then return thirty")
  @Tag("MaintainedByDiffblue")
  void testCompare_whenTrue_thenReturnThirty() {
    // Arrange, Act and Assert
    assertEquals(30, new ComparableOrToStringComparator().compare(true, "Vertex2"));
  }

  /**
   * Test {@link ComparableOrToStringComparator#compare(Object, Object)}.
   *
   * <ul>
   *   <li>When {@code Vertex1}.
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link ComparableOrToStringComparator#compare(Object, Object)}
   */
  @Test
  @DisplayName("Test compare(Object, Object); when 'Vertex1'; then return minus one")
  @Tag("MaintainedByDiffblue")
  void testCompare_whenVertex1_thenReturnMinusOne() {
    // Arrange, Act and Assert
    assertEquals(-1, new ComparableOrToStringComparator().compare("Vertex1", "Vertex2"));
  }

  /**
   * Test {@link ComparableOrToStringComparator#compare(Object, Object)}.
   *
   * <ul>
   *   <li>When {@code Vertex1}.
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link ComparableOrToStringComparator#compare(Object, Object)}
   */
  @Test
  @DisplayName("Test compare(Object, Object); when 'Vertex1'; then return minus one")
  @Tag("MaintainedByDiffblue")
  void testCompare_whenVertex1_thenReturnMinusOne2() {
    // Arrange, Act and Assert
    assertEquals(-1, new ComparableOrToStringComparator().compare("Vertex1", null));
  }
}
