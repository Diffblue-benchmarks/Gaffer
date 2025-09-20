package uk.gov.gchq.gaffer.time.binaryoperator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.time.LocalDate;
import java.time.ZoneOffset;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.time.CommonTimeUtil;
import uk.gov.gchq.gaffer.time.CommonTimeUtil.TimeBucket;
import uk.gov.gchq.gaffer.time.LongTimeSeries;

class LongTimeSeriesAggregatorDiffblueTest {
  /**
   * Test {@link LongTimeSeriesAggregator#_apply(LongTimeSeries, LongTimeSeries)} with {@code
   * LongTimeSeries}, {@code LongTimeSeries}.
   *
   * <p>Method under test: {@link LongTimeSeriesAggregator#_apply(LongTimeSeries, LongTimeSeries)}
   */
  @Test
  @DisplayName(
      "Test _apply(LongTimeSeries, LongTimeSeries) with 'LongTimeSeries', 'LongTimeSeries'")
  @Tag("MaintainedByDiffblue")
  void test_applyWithLongTimeSeriesLongTimeSeries() {
    // Arrange
    LongTimeSeriesAggregator longTimeSeriesAggregator = new LongTimeSeriesAggregator();
    LongTimeSeries a = new LongTimeSeries(TimeBucket.SECOND);

    // Act
    longTimeSeriesAggregator._apply(a, new LongTimeSeries(TimeBucket.SECOND));

    // Assert that nothing has changed
    assertEquals(0, a.getNumberOfInstants());
    assertTrue(a.getTimeSeries().isEmpty());
    assertTrue(a.getInstants().isEmpty());
  }

  /**
   * Test {@link LongTimeSeriesAggregator#_apply(LongTimeSeries, LongTimeSeries)} with {@code
   * LongTimeSeries}, {@code LongTimeSeries}.
   *
   * <p>Method under test: {@link LongTimeSeriesAggregator#_apply(LongTimeSeries, LongTimeSeries)}
   */
  @Test
  @DisplayName(
      "Test _apply(LongTimeSeries, LongTimeSeries) with 'LongTimeSeries', 'LongTimeSeries'")
  @Tag("MaintainedByDiffblue")
  void test_applyWithLongTimeSeriesLongTimeSeries2() {
    // Arrange
    LongTimeSeriesAggregator longTimeSeriesAggregator = new LongTimeSeriesAggregator();
    LongTimeSeries a = new LongTimeSeries(TimeBucket.SECOND);

    LongTimeSeries b = new LongTimeSeries(TimeBucket.SECOND);
    b.put(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant(), 42L);

    // Act
    LongTimeSeries actual_applyResult = longTimeSeriesAggregator._apply(a, b);

    // Assert
    assertEquals(1, a.getTimeSeries().size());
    assertEquals(1, a.getInstants().size());
    assertEquals(1, a.getNumberOfInstants());
    assertSame(a, actual_applyResult);
  }

  /**
   * Test {@link LongTimeSeriesAggregator#_apply(LongTimeSeries, LongTimeSeries)} with {@code
   * LongTimeSeries}, {@code LongTimeSeries}.
   *
   * <p>Method under test: {@link LongTimeSeriesAggregator#_apply(LongTimeSeries, LongTimeSeries)}
   */
  @Test
  @DisplayName(
      "Test _apply(LongTimeSeries, LongTimeSeries) with 'LongTimeSeries', 'LongTimeSeries'")
  @Tag("MaintainedByDiffblue")
  void test_applyWithLongTimeSeriesLongTimeSeries3() {
    // Arrange
    LongTimeSeriesAggregator longTimeSeriesAggregator = new LongTimeSeriesAggregator();
    LongTimeSeries a = new LongTimeSeries(TimeBucket.MINUTE);

    LongTimeSeries b = new LongTimeSeries(TimeBucket.MINUTE);
    b.put(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant(), 42L);

    // Act
    LongTimeSeries actual_applyResult = longTimeSeriesAggregator._apply(a, b);

    // Assert
    assertEquals(1, a.getTimeSeries().size());
    assertEquals(1, a.getInstants().size());
    assertEquals(1, a.getNumberOfInstants());
    assertSame(a, actual_applyResult);
  }

  /**
   * Test {@link LongTimeSeriesAggregator#_apply(LongTimeSeries, LongTimeSeries)} with {@code
   * LongTimeSeries}, {@code LongTimeSeries}.
   *
   * <p>Method under test: {@link LongTimeSeriesAggregator#_apply(LongTimeSeries, LongTimeSeries)}
   */
  @Test
  @DisplayName(
      "Test _apply(LongTimeSeries, LongTimeSeries) with 'LongTimeSeries', 'LongTimeSeries'")
  @Tag("MaintainedByDiffblue")
  void test_applyWithLongTimeSeriesLongTimeSeries4() {
    // Arrange
    LongTimeSeriesAggregator longTimeSeriesAggregator = new LongTimeSeriesAggregator();
    LongTimeSeries a = new LongTimeSeries(TimeBucket.HOUR);

    LongTimeSeries b = new LongTimeSeries(TimeBucket.HOUR);
    b.put(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant(), 42L);

    // Act
    LongTimeSeries actual_applyResult = longTimeSeriesAggregator._apply(a, b);

    // Assert
    assertEquals(1, a.getTimeSeries().size());
    assertEquals(1, a.getInstants().size());
    assertEquals(1, a.getNumberOfInstants());
    assertSame(a, actual_applyResult);
  }

  /**
   * Test {@link LongTimeSeriesAggregator#_apply(LongTimeSeries, LongTimeSeries)} with {@code
   * LongTimeSeries}, {@code LongTimeSeries}.
   *
   * <p>Method under test: {@link LongTimeSeriesAggregator#_apply(LongTimeSeries, LongTimeSeries)}
   */
  @Test
  @DisplayName(
      "Test _apply(LongTimeSeries, LongTimeSeries) with 'LongTimeSeries', 'LongTimeSeries'")
  @Tag("MaintainedByDiffblue")
  void test_applyWithLongTimeSeriesLongTimeSeries5() {
    // Arrange
    LongTimeSeriesAggregator longTimeSeriesAggregator = new LongTimeSeriesAggregator();
    LongTimeSeries a = new LongTimeSeries(TimeBucket.DAY);

    LongTimeSeries b = new LongTimeSeries(TimeBucket.DAY);
    b.put(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant(), 42L);

    // Act
    LongTimeSeries actual_applyResult = longTimeSeriesAggregator._apply(a, b);

    // Assert
    assertEquals(1, a.getTimeSeries().size());
    assertEquals(1, a.getInstants().size());
    assertEquals(1, a.getNumberOfInstants());
    assertSame(a, actual_applyResult);
  }

  /**
   * Test {@link LongTimeSeriesAggregator#_apply(LongTimeSeries, LongTimeSeries)} with {@code
   * LongTimeSeries}, {@code LongTimeSeries}.
   *
   * <ul>
   *   <li>Given two.
   * </ul>
   *
   * <p>Method under test: {@link LongTimeSeriesAggregator#_apply(LongTimeSeries, LongTimeSeries)}
   */
  @Test
  @DisplayName(
      "Test _apply(LongTimeSeries, LongTimeSeries) with 'LongTimeSeries', 'LongTimeSeries'; given two")
  @Tag("MaintainedByDiffblue")
  void test_applyWithLongTimeSeriesLongTimeSeries_givenTwo() {
    // Arrange
    LongTimeSeriesAggregator longTimeSeriesAggregator = new LongTimeSeriesAggregator();

    LongTimeSeries a = new LongTimeSeries(TimeBucket.SECOND);
    a.put(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant(), 2L);

    LongTimeSeries b = new LongTimeSeries(TimeBucket.SECOND);
    b.put(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant(), 42L);

    // Act
    longTimeSeriesAggregator._apply(a, b);

    // Assert that nothing has changed
    assertEquals(1, a.getTimeSeries().size());
    assertEquals(1, a.getInstants().size());
    assertEquals(1, a.getNumberOfInstants());
  }

  /**
   * Test {@link LongTimeSeriesAggregator#_apply(LongTimeSeries, LongTimeSeries)} with {@code
   * LongTimeSeries}, {@code LongTimeSeries}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link LongTimeSeriesAggregator#_apply(LongTimeSeries, LongTimeSeries)}
   */
  @Test
  @DisplayName(
      "Test _apply(LongTimeSeries, LongTimeSeries) with 'LongTimeSeries', 'LongTimeSeries'; then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  void test_applyWithLongTimeSeriesLongTimeSeries_thenThrowRuntimeException() {
    // Arrange
    LongTimeSeriesAggregator longTimeSeriesAggregator = new LongTimeSeriesAggregator();
    LongTimeSeries a = new LongTimeSeries(TimeBucket.MINUTE);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> longTimeSeriesAggregator._apply(a, new LongTimeSeries(TimeBucket.SECOND)));
  }
}
