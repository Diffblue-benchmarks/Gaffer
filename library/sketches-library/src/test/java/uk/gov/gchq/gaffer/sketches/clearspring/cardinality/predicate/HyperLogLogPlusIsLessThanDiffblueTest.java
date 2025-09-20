package uk.gov.gchq.gaffer.sketches.clearspring.cardinality.predicate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.clearspring.analytics.stream.cardinality.HyperLogLogPlus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class HyperLogLogPlusIsLessThanDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link HyperLogLogPlusIsLessThan#HyperLogLogPlusIsLessThan()}
   *   <li>{@link HyperLogLogPlusIsLessThan#setControlValue(long)}
   *   <li>{@link HyperLogLogPlusIsLessThan#setOrEqualTo(boolean)}
   *   <li>{@link HyperLogLogPlusIsLessThan#toString()}
   *   <li>{@link HyperLogLogPlusIsLessThan#getControlValue()}
   *   <li>{@link HyperLogLogPlusIsLessThan#getOrEqualTo()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  void testGettersAndSetters() {
    // Arrange and Act
    HyperLogLogPlusIsLessThan actualHyperLogLogPlusIsLessThan = new HyperLogLogPlusIsLessThan();
    actualHyperLogLogPlusIsLessThan.setControlValue(42L);
    actualHyperLogLogPlusIsLessThan.setOrEqualTo(true);
    String actualToStringResult = actualHyperLogLogPlusIsLessThan.toString();
    long actualControlValue = actualHyperLogLogPlusIsLessThan.getControlValue();

    // Assert
    assertEquals("HyperLogLogPlusIsLessThan[controlValue=42,orEqualTo=true]", actualToStringResult);
    assertEquals(42L, actualControlValue);
    assertTrue(actualHyperLogLogPlusIsLessThan.getOrEqualTo());
  }

  /**
   * Test {@link HyperLogLogPlusIsLessThan#HyperLogLogPlusIsLessThan(long)}.
   *
   * <p>Method under test: {@link HyperLogLogPlusIsLessThan#HyperLogLogPlusIsLessThan(long)}
   */
  @Test
  @DisplayName("Test new HyperLogLogPlusIsLessThan(long)")
  @Tag("MaintainedByDiffblue")
  void testNewHyperLogLogPlusIsLessThan() {
    // Arrange and Act
    HyperLogLogPlusIsLessThan actualHyperLogLogPlusIsLessThan = new HyperLogLogPlusIsLessThan(42L);

    // Assert
    assertEquals(42L, actualHyperLogLogPlusIsLessThan.getControlValue());
    assertFalse(actualHyperLogLogPlusIsLessThan.getOrEqualTo());
  }

  /**
   * Test {@link HyperLogLogPlusIsLessThan#HyperLogLogPlusIsLessThan(long, boolean)}.
   *
   * <p>Method under test: {@link HyperLogLogPlusIsLessThan#HyperLogLogPlusIsLessThan(long,
   * boolean)}
   */
  @Test
  @DisplayName("Test new HyperLogLogPlusIsLessThan(long, boolean)")
  @Tag("MaintainedByDiffblue")
  void testNewHyperLogLogPlusIsLessThan2() {
    // Arrange and Act
    HyperLogLogPlusIsLessThan actualHyperLogLogPlusIsLessThan =
        new HyperLogLogPlusIsLessThan(42L, true);

    // Assert
    assertEquals(42L, actualHyperLogLogPlusIsLessThan.getControlValue());
    assertTrue(actualHyperLogLogPlusIsLessThan.getOrEqualTo());
  }

  /**
   * Test {@link HyperLogLogPlusIsLessThan#test(HyperLogLogPlus)} with {@code HyperLogLogPlus}.
   *
   * <p>Method under test: {@link HyperLogLogPlusIsLessThan#test(HyperLogLogPlus)}
   */
  @Test
  @DisplayName("Test test(HyperLogLogPlus) with 'HyperLogLogPlus'")
  @Tag("MaintainedByDiffblue")
  void testTestWithHyperLogLogPlus() {
    // Arrange
    HyperLogLogPlusIsLessThan hyperLogLogPlusIsLessThan = new HyperLogLogPlusIsLessThan(42L);
    hyperLogLogPlusIsLessThan.setOrEqualTo(false);

    // Act and Assert
    assertFalse(hyperLogLogPlusIsLessThan.test(null));
  }

  /**
   * Test {@link HyperLogLogPlusIsLessThan#test(HyperLogLogPlus)} with {@code HyperLogLogPlus}.
   *
   * <p>Method under test: {@link HyperLogLogPlusIsLessThan#test(HyperLogLogPlus)}
   */
  @Test
  @DisplayName("Test test(HyperLogLogPlus) with 'HyperLogLogPlus'")
  @Tag("MaintainedByDiffblue")
  void testTestWithHyperLogLogPlus2() {
    // Arrange
    HyperLogLogPlusIsLessThan hyperLogLogPlusIsLessThan = new HyperLogLogPlusIsLessThan(-1L);

    // Act
    boolean actualTestResult = hyperLogLogPlusIsLessThan.test(new HyperLogLogPlus(4));

    // Assert
    assertFalse(actualTestResult);
  }

  /**
   * Test {@link HyperLogLogPlusIsLessThan#test(HyperLogLogPlus)} with {@code HyperLogLogPlus}.
   *
   * <p>Method under test: {@link HyperLogLogPlusIsLessThan#test(HyperLogLogPlus)}
   */
  @Test
  @DisplayName("Test test(HyperLogLogPlus) with 'HyperLogLogPlus'")
  @Tag("MaintainedByDiffblue")
  void testTestWithHyperLogLogPlus3() {
    // Arrange
    HyperLogLogPlusIsLessThan hyperLogLogPlusIsLessThan = new HyperLogLogPlusIsLessThan(42L, true);

    // Act
    boolean actualTestResult = hyperLogLogPlusIsLessThan.test(new HyperLogLogPlus(4));

    // Assert
    assertTrue(actualTestResult);
  }

  /**
   * Test {@link HyperLogLogPlusIsLessThan#test(HyperLogLogPlus)} with {@code HyperLogLogPlus}.
   *
   * <p>Method under test: {@link HyperLogLogPlusIsLessThan#test(HyperLogLogPlus)}
   */
  @Test
  @DisplayName("Test test(HyperLogLogPlus) with 'HyperLogLogPlus'")
  @Tag("MaintainedByDiffblue")
  void testTestWithHyperLogLogPlus4() {
    // Arrange
    HyperLogLogPlusIsLessThan hyperLogLogPlusIsLessThan = new HyperLogLogPlusIsLessThan(-1L, true);

    // Act
    boolean actualTestResult = hyperLogLogPlusIsLessThan.test(new HyperLogLogPlus(4));

    // Assert
    assertFalse(actualTestResult);
  }

  /**
   * Test {@link HyperLogLogPlusIsLessThan#test(HyperLogLogPlus)} with {@code HyperLogLogPlus}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link HyperLogLogPlusIsLessThan#test(HyperLogLogPlus)}
   */
  @Test
  @DisplayName("Test test(HyperLogLogPlus) with 'HyperLogLogPlus'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  void testTestWithHyperLogLogPlus_thenReturnTrue() {
    // Arrange
    HyperLogLogPlusIsLessThan hyperLogLogPlusIsLessThan = new HyperLogLogPlusIsLessThan(42L);

    // Act
    boolean actualTestResult = hyperLogLogPlusIsLessThan.test(new HyperLogLogPlus(4));

    // Assert
    assertTrue(actualTestResult);
  }

  /**
   * Test {@link HyperLogLogPlusIsLessThan#equals(Object)}, and {@link
   * HyperLogLogPlusIsLessThan#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link HyperLogLogPlusIsLessThan#equals(Object)}
   *   <li>{@link HyperLogLogPlusIsLessThan#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    HyperLogLogPlusIsLessThan hyperLogLogPlusIsLessThan = new HyperLogLogPlusIsLessThan(42L);
    HyperLogLogPlusIsLessThan hyperLogLogPlusIsLessThan2 = new HyperLogLogPlusIsLessThan(42L);

    // Act and Assert
    assertEquals(hyperLogLogPlusIsLessThan, hyperLogLogPlusIsLessThan2);
    assertEquals(hyperLogLogPlusIsLessThan.hashCode(), hyperLogLogPlusIsLessThan2.hashCode());
  }

  /**
   * Test {@link HyperLogLogPlusIsLessThan#equals(Object)}, and {@link
   * HyperLogLogPlusIsLessThan#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link HyperLogLogPlusIsLessThan#equals(Object)}
   *   <li>{@link HyperLogLogPlusIsLessThan#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    HyperLogLogPlusIsLessThan hyperLogLogPlusIsLessThan = new HyperLogLogPlusIsLessThan(42L);

    // Act and Assert
    assertEquals(hyperLogLogPlusIsLessThan, hyperLogLogPlusIsLessThan);
    int expectedHashCodeResult = hyperLogLogPlusIsLessThan.hashCode();
    assertEquals(expectedHashCodeResult, hyperLogLogPlusIsLessThan.hashCode());
  }

  /**
   * Test {@link HyperLogLogPlusIsLessThan#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link HyperLogLogPlusIsLessThan#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    HyperLogLogPlusIsLessThan hyperLogLogPlusIsLessThan = new HyperLogLogPlusIsLessThan(1L);

    // Act and Assert
    assertNotEquals(hyperLogLogPlusIsLessThan, new HyperLogLogPlusIsLessThan(42L));
  }

  /**
   * Test {@link HyperLogLogPlusIsLessThan#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link HyperLogLogPlusIsLessThan#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new HyperLogLogPlusIsLessThan(42L), null);
  }

  /**
   * Test {@link HyperLogLogPlusIsLessThan#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link HyperLogLogPlusIsLessThan#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new HyperLogLogPlusIsLessThan(42L), "Different type to HyperLogLogPlusIsLessThan");
  }
}
