package uk.gov.gchq.gaffer.jobtracker;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class RepeatDiffblueTest {
  /**
   * Test {@link Repeat#Repeat()}.
   *
   * <p>Method under test: {@link Repeat#Repeat()}
   */
  @Test
  @DisplayName("Test new Repeat()")
  @Tag("MaintainedByDiffblue")
  void testNewRepeat() {
    // Arrange and Act
    Repeat actualRepeat = new Repeat();

    // Assert
    assertEquals(0L, actualRepeat.getInitialDelay());
    assertEquals(0L, actualRepeat.getRepeatPeriod());
    assertEquals(TimeUnit.SECONDS, actualRepeat.getTimeUnit());
  }

  /**
   * Test {@link Repeat#Repeat(long, long, TimeUnit)}.
   *
   * <p>Method under test: {@link Repeat#Repeat(long, long, TimeUnit)}
   */
  @Test
  @DisplayName("Test new Repeat(long, long, TimeUnit)")
  @Tag("MaintainedByDiffblue")
  void testNewRepeat2() {
    // Arrange and Act
    Repeat actualRepeat = new Repeat(1L, 1L, TimeUnit.NANOSECONDS);

    // Assert
    assertEquals(1L, actualRepeat.getInitialDelay());
    assertEquals(1L, actualRepeat.getRepeatPeriod());
    assertEquals(TimeUnit.NANOSECONDS, actualRepeat.getTimeUnit());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Repeat#setInitialDelay(long)}
   *   <li>{@link Repeat#setRepeatPeriod(long)}
   *   <li>{@link Repeat#setTimeUnit(TimeUnit)}
   *   <li>{@link Repeat#toString()}
   *   <li>{@link Repeat#getInitialDelay()}
   *   <li>{@link Repeat#getRepeatPeriod()}
   *   <li>{@link Repeat#getTimeUnit()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  void testGettersAndSetters() {
    // Arrange
    Repeat repeat = new Repeat();

    // Act
    repeat.setInitialDelay(1L);
    repeat.setRepeatPeriod(1L);
    repeat.setTimeUnit(TimeUnit.NANOSECONDS);
    String actualToStringResult = repeat.toString();
    long actualInitialDelay = repeat.getInitialDelay();
    long actualRepeatPeriod = repeat.getRepeatPeriod();

    // Assert
    assertEquals(
        "Repeat[initialDelay=1,repeatPeriod=1,timeUnit=NANOSECONDS]", actualToStringResult);
    assertEquals(1L, actualInitialDelay);
    assertEquals(1L, actualRepeatPeriod);
    assertEquals(TimeUnit.NANOSECONDS, repeat.getTimeUnit());
  }

  /**
   * Test {@link Repeat#equals(Object)}, and {@link Repeat#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Repeat#equals(Object)}
   *   <li>{@link Repeat#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Repeat repeat = new Repeat();
    Repeat repeat2 = new Repeat();

    // Act and Assert
    assertEquals(repeat, repeat2);
    assertEquals(repeat.hashCode(), repeat2.hashCode());
  }

  /**
   * Test {@link Repeat#equals(Object)}, and {@link Repeat#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Repeat#equals(Object)}
   *   <li>{@link Repeat#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Repeat repeat = new Repeat();

    // Act and Assert
    assertEquals(repeat, repeat);
    int expectedHashCodeResult = repeat.hashCode();
    assertEquals(expectedHashCodeResult, repeat.hashCode());
  }

  /**
   * Test {@link Repeat#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Repeat#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Repeat repeat = new Repeat(1L, 1L, TimeUnit.NANOSECONDS);

    // Act and Assert
    assertNotEquals(repeat, new Repeat());
  }

  /**
   * Test {@link Repeat#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Repeat#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Repeat(), null);
  }

  /**
   * Test {@link Repeat#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Repeat#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Repeat(), "Different type to Repeat");
  }
}
