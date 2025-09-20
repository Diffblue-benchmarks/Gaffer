package uk.gov.gchq.gaffer.sketches.datasketches.cardinality.predicate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.apache.datasketches.hll.HllSketch;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class HllSketchIsLessThanDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link HllSketchIsLessThan#HllSketchIsLessThan()}
   *   <li>{@link HllSketchIsLessThan#setControlValue(long)}
   *   <li>{@link HllSketchIsLessThan#setOrEqualTo(boolean)}
   *   <li>{@link HllSketchIsLessThan#toString()}
   *   <li>{@link HllSketchIsLessThan#getControlValue()}
   *   <li>{@link HllSketchIsLessThan#getOrEqualTo()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  void testGettersAndSetters() {
    // Arrange and Act
    HllSketchIsLessThan actualHllSketchIsLessThan = new HllSketchIsLessThan();
    actualHllSketchIsLessThan.setControlValue(42L);
    actualHllSketchIsLessThan.setOrEqualTo(true);
    String actualToStringResult = actualHllSketchIsLessThan.toString();
    long actualControlValue = actualHllSketchIsLessThan.getControlValue();

    // Assert
    assertEquals("HllSketchIsLessThan[controlValue=42,orEqualTo=true]", actualToStringResult);
    assertEquals(42L, actualControlValue);
    assertTrue(actualHllSketchIsLessThan.getOrEqualTo());
  }

  /**
   * Test {@link HllSketchIsLessThan#HllSketchIsLessThan(long)}.
   *
   * <p>Method under test: {@link HllSketchIsLessThan#HllSketchIsLessThan(long)}
   */
  @Test
  @DisplayName("Test new HllSketchIsLessThan(long)")
  @Tag("MaintainedByDiffblue")
  void testNewHllSketchIsLessThan() {
    // Arrange and Act
    HllSketchIsLessThan actualHllSketchIsLessThan = new HllSketchIsLessThan(42L);

    // Assert
    assertEquals(42L, actualHllSketchIsLessThan.getControlValue());
    assertFalse(actualHllSketchIsLessThan.getOrEqualTo());
  }

  /**
   * Test {@link HllSketchIsLessThan#HllSketchIsLessThan(long, boolean)}.
   *
   * <p>Method under test: {@link HllSketchIsLessThan#HllSketchIsLessThan(long, boolean)}
   */
  @Test
  @DisplayName("Test new HllSketchIsLessThan(long, boolean)")
  @Tag("MaintainedByDiffblue")
  void testNewHllSketchIsLessThan2() {
    // Arrange and Act
    HllSketchIsLessThan actualHllSketchIsLessThan = new HllSketchIsLessThan(42L, true);

    // Assert
    assertEquals(42L, actualHllSketchIsLessThan.getControlValue());
    assertTrue(actualHllSketchIsLessThan.getOrEqualTo());
  }

  /**
   * Test {@link HllSketchIsLessThan#test(HllSketch)} with {@code HllSketch}.
   *
   * <p>Method under test: {@link HllSketchIsLessThan#test(HllSketch)}
   */
  @Test
  @DisplayName("Test test(HllSketch) with 'HllSketch'")
  @Tag("MaintainedByDiffblue")
  void testTestWithHllSketch() {
    // Arrange
    HllSketchIsLessThan hllSketchIsLessThan = new HllSketchIsLessThan(42L);
    hllSketchIsLessThan.setOrEqualTo(false);

    // Act and Assert
    assertFalse(hllSketchIsLessThan.test(null));
  }

  /**
   * Test {@link HllSketchIsLessThan#test(HllSketch)} with {@code HllSketch}.
   *
   * <p>Method under test: {@link HllSketchIsLessThan#test(HllSketch)}
   */
  @Test
  @DisplayName("Test test(HllSketch) with 'HllSketch'")
  @Tag("MaintainedByDiffblue")
  void testTestWithHllSketch2() {
    // Arrange
    HllSketchIsLessThan hllSketchIsLessThan = new HllSketchIsLessThan(42L, true);

    // Act and Assert
    assertTrue(hllSketchIsLessThan.test(new HllSketch()));
  }

  /**
   * Test {@link HllSketchIsLessThan#test(HllSketch)} with {@code HllSketch}.
   *
   * <p>Method under test: {@link HllSketchIsLessThan#test(HllSketch)}
   */
  @Test
  @DisplayName("Test test(HllSketch) with 'HllSketch'")
  @Tag("MaintainedByDiffblue")
  void testTestWithHllSketch3() {
    // Arrange
    HllSketchIsLessThan hllSketchIsLessThan = new HllSketchIsLessThan(-1L, true);

    // Act and Assert
    assertFalse(hllSketchIsLessThan.test(new HllSketch()));
  }

  /**
   * Test {@link HllSketchIsLessThan#test(HllSketch)} with {@code HllSketch}.
   *
   * <ul>
   *   <li>Given {@link HllSketchIsLessThan#HllSketchIsLessThan(long)} with controlValue is
   *       forty-two.
   * </ul>
   *
   * <p>Method under test: {@link HllSketchIsLessThan#test(HllSketch)}
   */
  @Test
  @DisplayName(
      "Test test(HllSketch) with 'HllSketch'; given HllSketchIsLessThan(long) with controlValue is forty-two")
  @Tag("MaintainedByDiffblue")
  void testTestWithHllSketch_givenHllSketchIsLessThanWithControlValueIsFortyTwo() {
    // Arrange
    HllSketchIsLessThan hllSketchIsLessThan = new HllSketchIsLessThan(42L);

    // Act and Assert
    assertTrue(hllSketchIsLessThan.test(new HllSketch()));
  }

  /**
   * Test {@link HllSketchIsLessThan#test(HllSketch)} with {@code HllSketch}.
   *
   * <ul>
   *   <li>Given {@link HllSketchIsLessThan#HllSketchIsLessThan(long)} with controlValue is minus
   *       one.
   * </ul>
   *
   * <p>Method under test: {@link HllSketchIsLessThan#test(HllSketch)}
   */
  @Test
  @DisplayName(
      "Test test(HllSketch) with 'HllSketch'; given HllSketchIsLessThan(long) with controlValue is minus one")
  @Tag("MaintainedByDiffblue")
  void testTestWithHllSketch_givenHllSketchIsLessThanWithControlValueIsMinusOne() {
    // Arrange
    HllSketchIsLessThan hllSketchIsLessThan = new HllSketchIsLessThan(-1L);

    // Act and Assert
    assertFalse(hllSketchIsLessThan.test(new HllSketch()));
  }

  /**
   * Test {@link HllSketchIsLessThan#equals(Object)}, and {@link HllSketchIsLessThan#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link HllSketchIsLessThan#equals(Object)}
   *   <li>{@link HllSketchIsLessThan#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    HllSketchIsLessThan hllSketchIsLessThan = new HllSketchIsLessThan(42L);
    HllSketchIsLessThan hllSketchIsLessThan2 = new HllSketchIsLessThan(42L);

    // Act and Assert
    assertEquals(hllSketchIsLessThan, hllSketchIsLessThan2);
    assertEquals(hllSketchIsLessThan.hashCode(), hllSketchIsLessThan2.hashCode());
  }

  /**
   * Test {@link HllSketchIsLessThan#equals(Object)}, and {@link HllSketchIsLessThan#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link HllSketchIsLessThan#equals(Object)}
   *   <li>{@link HllSketchIsLessThan#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    HllSketchIsLessThan hllSketchIsLessThan = new HllSketchIsLessThan(42L);

    // Act and Assert
    assertEquals(hllSketchIsLessThan, hllSketchIsLessThan);
    int expectedHashCodeResult = hllSketchIsLessThan.hashCode();
    assertEquals(expectedHashCodeResult, hllSketchIsLessThan.hashCode());
  }

  /**
   * Test {@link HllSketchIsLessThan#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link HllSketchIsLessThan#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    HllSketchIsLessThan hllSketchIsLessThan = new HllSketchIsLessThan(1L);

    // Act and Assert
    assertNotEquals(hllSketchIsLessThan, new HllSketchIsLessThan(42L));
  }

  /**
   * Test {@link HllSketchIsLessThan#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link HllSketchIsLessThan#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new HllSketchIsLessThan(42L), null);
  }

  /**
   * Test {@link HllSketchIsLessThan#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link HllSketchIsLessThan#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new HllSketchIsLessThan(42L), "Different type to HllSketchIsLessThan");
  }
}
