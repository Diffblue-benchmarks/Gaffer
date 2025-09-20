package uk.gov.gchq.gaffer.time.binaryoperator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.time.BoundedTimestampSet;
import uk.gov.gchq.gaffer.time.CommonTimeUtil;
import uk.gov.gchq.gaffer.time.CommonTimeUtil.TimeBucket;
import uk.gov.gchq.gaffer.time.RBMBackedTimestampSet;

class BoundedTimestampSetAggregatorDiffblueTest {
  /**
   * Test {@link BoundedTimestampSetAggregator#_apply(BoundedTimestampSet, BoundedTimestampSet)}
   * with {@code BoundedTimestampSet}, {@code BoundedTimestampSet}.
   *
   * <p>Method under test: {@link BoundedTimestampSetAggregator#_apply(BoundedTimestampSet,
   * BoundedTimestampSet)}
   */
  @Test
  @DisplayName(
      "Test _apply(BoundedTimestampSet, BoundedTimestampSet) with 'BoundedTimestampSet', 'BoundedTimestampSet'")
  @Tag("MaintainedByDiffblue")
  void test_applyWithBoundedTimestampSetBoundedTimestampSet() {
    // Arrange
    BoundedTimestampSetAggregator boundedTimestampSetAggregator =
        new BoundedTimestampSetAggregator();
    BoundedTimestampSet a = new BoundedTimestampSet(TimeBucket.MINUTE, 3);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            boundedTimestampSetAggregator._apply(a, new BoundedTimestampSet(TimeBucket.SECOND, 3)));
  }

  /**
   * Test {@link BoundedTimestampSetAggregator#_apply(BoundedTimestampSet, BoundedTimestampSet)}
   * with {@code BoundedTimestampSet}, {@code BoundedTimestampSet}.
   *
   * <p>Method under test: {@link BoundedTimestampSetAggregator#_apply(BoundedTimestampSet,
   * BoundedTimestampSet)}
   */
  @Test
  @DisplayName(
      "Test _apply(BoundedTimestampSet, BoundedTimestampSet) with 'BoundedTimestampSet', 'BoundedTimestampSet'")
  @Tag("MaintainedByDiffblue")
  void test_applyWithBoundedTimestampSetBoundedTimestampSet2() {
    // Arrange
    BoundedTimestampSetAggregator boundedTimestampSetAggregator =
        new BoundedTimestampSetAggregator();
    BoundedTimestampSet a = new BoundedTimestampSet(TimeBucket.SECOND, 1);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            boundedTimestampSetAggregator._apply(a, new BoundedTimestampSet(TimeBucket.SECOND, 3)));
  }

  /**
   * Test {@link BoundedTimestampSetAggregator#_apply(BoundedTimestampSet, BoundedTimestampSet)}
   * with {@code BoundedTimestampSet}, {@code BoundedTimestampSet}.
   *
   * <p>Method under test: {@link BoundedTimestampSetAggregator#_apply(BoundedTimestampSet,
   * BoundedTimestampSet)}
   */
  @Test
  @DisplayName(
      "Test _apply(BoundedTimestampSet, BoundedTimestampSet) with 'BoundedTimestampSet', 'BoundedTimestampSet'")
  @Tag("MaintainedByDiffblue")
  void test_applyWithBoundedTimestampSetBoundedTimestampSet3() {
    // Arrange
    BoundedTimestampSetAggregator boundedTimestampSetAggregator =
        new BoundedTimestampSetAggregator();
    BoundedTimestampSet a = new BoundedTimestampSet(TimeBucket.SECOND, 3);

    BoundedTimestampSet b = new BoundedTimestampSet(TimeBucket.SECOND, 3);
    b.add(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    BoundedTimestampSet actual_applyResult = boundedTimestampSetAggregator._apply(a, b);

    // Assert
    Instant earliest = actual_applyResult.getEarliest();
    assertEquals(0, earliest.getNano());
    assertEquals(0L, earliest.getEpochSecond());
    assertEquals(1, a.getTimestamps().size());
    assertEquals(1, actual_applyResult.getTimestamps().size());
    assertEquals(1L, a.getNumberOfTimestamps());
    assertEquals(1L, actual_applyResult.getNumberOfTimestamps());
    RBMBackedTimestampSet rbmBackedTimestampSet = actual_applyResult.getRbmBackedTimestampSet();
    assertEquals(1L, rbmBackedTimestampSet.getNumberOfTimestamps());
    assertSame(earliest, actual_applyResult.getLatest());
    assertSame(earliest, rbmBackedTimestampSet.getEarliest());
    assertSame(earliest, rbmBackedTimestampSet.getLatest());
  }

  /**
   * Test {@link BoundedTimestampSetAggregator#_apply(BoundedTimestampSet, BoundedTimestampSet)}
   * with {@code BoundedTimestampSet}, {@code BoundedTimestampSet}.
   *
   * <ul>
   *   <li>Then return Earliest is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BoundedTimestampSetAggregator#_apply(BoundedTimestampSet,
   * BoundedTimestampSet)}
   */
  @Test
  @DisplayName(
      "Test _apply(BoundedTimestampSet, BoundedTimestampSet) with 'BoundedTimestampSet', 'BoundedTimestampSet'; then return Earliest is 'null'")
  @Tag("MaintainedByDiffblue")
  void test_applyWithBoundedTimestampSetBoundedTimestampSet_thenReturnEarliestIsNull() {
    // Arrange
    BoundedTimestampSetAggregator boundedTimestampSetAggregator =
        new BoundedTimestampSetAggregator();
    BoundedTimestampSet a = new BoundedTimestampSet(TimeBucket.SECOND, 3);

    // Act
    BoundedTimestampSet actual_applyResult =
        boundedTimestampSetAggregator._apply(a, new BoundedTimestampSet(TimeBucket.SECOND, 3));

    // Assert
    assertNull(actual_applyResult.getEarliest());
    assertNull(actual_applyResult.getLatest());
    RBMBackedTimestampSet rbmBackedTimestampSet = actual_applyResult.getRbmBackedTimestampSet();
    assertNull(rbmBackedTimestampSet.getEarliest());
    assertNull(rbmBackedTimestampSet.getLatest());
    assertEquals(0L, a.getNumberOfTimestamps());
    assertEquals(0L, actual_applyResult.getNumberOfTimestamps());
    assertEquals(0L, rbmBackedTimestampSet.getNumberOfTimestamps());
    assertTrue(a.getTimestamps().isEmpty());
    assertTrue(actual_applyResult.getTimestamps().isEmpty());
  }
}
