package uk.gov.gchq.gaffer.sparkaccumulo.operation.rfilereaderrdd;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.UnsupportedEncodingException;
import java.util.Set;
import org.apache.hadoop.io.Text;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class AccumuloTabletDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AccumuloTablet#AccumuloTablet(int, int, String, String)}
   *   <li>{@link AccumuloTablet#getFiles()}
   *   <li>{@link AccumuloTablet#index()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  void testGettersAndSetters() {
    // Arrange and Act
    AccumuloTablet actualAccumuloTablet = new AccumuloTablet(1, 1, "Start", "End");
    Set<String> actualFiles = actualAccumuloTablet.getFiles();

    // Assert
    assertEquals(1, actualAccumuloTablet.index());
    assertTrue(actualFiles.isEmpty());
  }

  /**
   * Test {@link AccumuloTablet#addRFile(String)}.
   *
   * <p>Method under test: {@link AccumuloTablet#addRFile(String)}
   */
  @Test
  @DisplayName("Test addRFile(String)")
  @Tag("MaintainedByDiffblue")
  void testAddRFile() {
    // Arrange
    AccumuloTablet accumuloTablet = new AccumuloTablet(1, 1, "Start", "End");

    // Act
    accumuloTablet.addRFile("R File");

    // Assert
    Set<String> files = accumuloTablet.getFiles();
    assertEquals(1, files.size());
    assertTrue(files.contains("R File"));
  }

  /**
   * Test {@link AccumuloTablet#getStartRow()}.
   *
   * <ul>
   *   <li>Then return Length is five.
   * </ul>
   *
   * <p>Method under test: {@link AccumuloTablet#getStartRow()}
   */
  @Test
  @DisplayName("Test getStartRow(); then return Length is five")
  @Tag("MaintainedByDiffblue")
  void testGetStartRow_thenReturnLengthIsFive() throws UnsupportedEncodingException {
    // Arrange
    AccumuloTablet accumuloTablet = new AccumuloTablet(1, 1, "Start", "End");

    // Act
    Text actualStartRow = accumuloTablet.getStartRow();

    // Assert
    assertEquals(5, actualStartRow.getLength());
    assertArrayEquals("Start".getBytes("UTF-8"), actualStartRow.getBytes());
  }

  /**
   * Test {@link AccumuloTablet#getStartRow()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AccumuloTablet#getStartRow()}
   */
  @Test
  @DisplayName("Test getStartRow(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  void testGetStartRow_thenReturnNull() {
    // Arrange
    AccumuloTablet accumuloTablet = new AccumuloTablet(1, 1, null, "End");

    // Act and Assert
    assertNull(accumuloTablet.getStartRow());
  }

  /**
   * Test {@link AccumuloTablet#getEndRow()}.
   *
   * <ul>
   *   <li>Then return Length is three.
   * </ul>
   *
   * <p>Method under test: {@link AccumuloTablet#getEndRow()}
   */
  @Test
  @DisplayName("Test getEndRow(); then return Length is three")
  @Tag("MaintainedByDiffblue")
  void testGetEndRow_thenReturnLengthIsThree() throws UnsupportedEncodingException {
    // Arrange
    AccumuloTablet accumuloTablet = new AccumuloTablet(1, 1, "Start", "End");

    // Act
    Text actualEndRow = accumuloTablet.getEndRow();

    // Assert
    assertEquals(3, actualEndRow.getLength());
    assertArrayEquals("End".getBytes("UTF-8"), actualEndRow.getBytes());
  }

  /**
   * Test {@link AccumuloTablet#getEndRow()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AccumuloTablet#getEndRow()}
   */
  @Test
  @DisplayName("Test getEndRow(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  void testGetEndRow_thenReturnNull() {
    // Arrange
    AccumuloTablet accumuloTablet = new AccumuloTablet(1, 1, "Start", null);

    // Act and Assert
    assertNull(accumuloTablet.getEndRow());
  }

  /**
   * Test {@link AccumuloTablet#equals(Object)}, and {@link AccumuloTablet#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AccumuloTablet#equals(Object)}
   *   <li>{@link AccumuloTablet#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AccumuloTablet accumuloTablet = new AccumuloTablet(1, 1, "Start", "End");
    AccumuloTablet accumuloTablet2 = new AccumuloTablet(1, 1, "Start", "End");

    // Act and Assert
    assertEquals(accumuloTablet, accumuloTablet2);
    assertEquals(accumuloTablet.hashCode(), accumuloTablet2.hashCode());
  }

  /**
   * Test {@link AccumuloTablet#equals(Object)}, and {@link AccumuloTablet#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AccumuloTablet#equals(Object)}
   *   <li>{@link AccumuloTablet#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AccumuloTablet accumuloTablet = new AccumuloTablet(1, 1, "Start", "End");

    // Act and Assert
    assertEquals(accumuloTablet, accumuloTablet);
    int expectedHashCodeResult = accumuloTablet.hashCode();
    assertEquals(expectedHashCodeResult, accumuloTablet.hashCode());
  }

  /**
   * Test {@link AccumuloTablet#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AccumuloTablet#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    AccumuloTablet accumuloTablet = new AccumuloTablet(2, 1, "Start", "End");

    // Act and Assert
    assertNotEquals(accumuloTablet, new AccumuloTablet(1, 1, "Start", "End"));
  }

  /**
   * Test {@link AccumuloTablet#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AccumuloTablet#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AccumuloTablet(1, 1, "Start", "End"), null);
  }

  /**
   * Test {@link AccumuloTablet#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AccumuloTablet#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AccumuloTablet(1, 1, "Start", "End"), "Different type to AccumuloTablet");
  }
}
