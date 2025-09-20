package uk.gov.gchq.gaffer.sketches.datasketches.sampling.binaryoperator;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.apache.datasketches.sampling.ReservoirItemsSketch;
import org.apache.datasketches.sampling.ReservoirItemsUnion;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ReservoirItemsUnionAggregatorDiffblueTest {
  /**
   * Test {@link ReservoirItemsUnionAggregator#_apply(ReservoirItemsUnion, ReservoirItemsUnion)}
   * with {@code ReservoirItemsUnion}, {@code ReservoirItemsUnion}.
   *
   * <p>Method under test: {@link ReservoirItemsUnionAggregator#_apply(ReservoirItemsUnion,
   * ReservoirItemsUnion)}
   */
  @Test
  @DisplayName(
      "Test _apply(ReservoirItemsUnion, ReservoirItemsUnion) with 'ReservoirItemsUnion', 'ReservoirItemsUnion'")
  @Tag("MaintainedByDiffblue")
  void test_applyWithReservoirItemsUnionReservoirItemsUnion() {
    // Arrange
    ReservoirItemsUnionAggregator<Object> reservoirItemsUnionAggregator =
        new ReservoirItemsUnionAggregator<>();

    ReservoirItemsUnion<Object> a = ReservoirItemsUnion.newInstance(2);
    a.update((Object) null);

    ReservoirItemsUnion<Object> b = ReservoirItemsUnion.newInstance(3);
    b.update("42");

    // Act
    ReservoirItemsUnion<Object> actual_applyResult = reservoirItemsUnionAggregator._apply(a, b);

    // Assert
    ReservoirItemsSketch<Object> result = a.getResult();
    Object[] samples = result.getSamples();
    assertTrue(samples instanceof String[]);
    assertEquals(1, result.getNumSamples());
    assertEquals(1L, result.getN());
    assertEquals(2, result.getK());
    assertSame(a, actual_applyResult);
    assertArrayEquals(new String[] {"42"}, samples);
  }

  /**
   * Test {@link ReservoirItemsUnionAggregator#_apply(ReservoirItemsUnion, ReservoirItemsUnion)}
   * with {@code ReservoirItemsUnion}, {@code ReservoirItemsUnion}.
   *
   * <p>Method under test: {@link ReservoirItemsUnionAggregator#_apply(ReservoirItemsUnion,
   * ReservoirItemsUnion)}
   */
  @Test
  @DisplayName(
      "Test _apply(ReservoirItemsUnion, ReservoirItemsUnion) with 'ReservoirItemsUnion', 'ReservoirItemsUnion'")
  @Tag("MaintainedByDiffblue")
  void test_applyWithReservoirItemsUnionReservoirItemsUnion2() {
    // Arrange
    ReservoirItemsUnionAggregator<Object> reservoirItemsUnionAggregator =
        new ReservoirItemsUnionAggregator<>();
    ReservoirItemsUnion<Object> a = ReservoirItemsUnion.newInstance(3);

    ReservoirItemsUnion<Object> b = ReservoirItemsUnion.newInstance(3);
    b.update("Datum");

    // Act
    ReservoirItemsUnion<Object> actual_applyResult = reservoirItemsUnionAggregator._apply(a, b);

    // Assert
    ReservoirItemsSketch<Object> result = a.getResult();
    Object[] samples = result.getSamples();
    assertTrue(samples instanceof String[]);
    assertEquals(1, result.getNumSamples());
    assertEquals(1L, result.getN());
    assertEquals(3, result.getK());
    assertSame(a, actual_applyResult);
    assertArrayEquals(new String[] {"Datum"}, samples);
  }

  /**
   * Test {@link ReservoirItemsUnionAggregator#_apply(ReservoirItemsUnion, ReservoirItemsUnion)}
   * with {@code ReservoirItemsUnion}, {@code ReservoirItemsUnion}.
   *
   * <ul>
   *   <li>Then return newInstance three.
   * </ul>
   *
   * <p>Method under test: {@link ReservoirItemsUnionAggregator#_apply(ReservoirItemsUnion,
   * ReservoirItemsUnion)}
   */
  @Test
  @DisplayName(
      "Test _apply(ReservoirItemsUnion, ReservoirItemsUnion) with 'ReservoirItemsUnion', 'ReservoirItemsUnion'; then return newInstance three")
  @Tag("MaintainedByDiffblue")
  void test_applyWithReservoirItemsUnionReservoirItemsUnion_thenReturnNewInstanceThree() {
    // Arrange
    ReservoirItemsUnionAggregator<Object> reservoirItemsUnionAggregator =
        new ReservoirItemsUnionAggregator<>();
    ReservoirItemsUnion<Object> a = ReservoirItemsUnion.newInstance(3);
    ReservoirItemsUnion<Object> b = ReservoirItemsUnion.newInstance(3);

    // Act
    ReservoirItemsUnion<Object> actual_applyResult = reservoirItemsUnionAggregator._apply(a, b);

    // Assert
    assertSame(a, actual_applyResult);
  }
}
