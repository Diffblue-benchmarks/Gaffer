package uk.gov.gchq.gaffer.sketches.clearspring.cardinality.binaryoperator;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.clearspring.analytics.stream.cardinality.HyperLogLogPlus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class HyperLogLogPlusAggregatorDiffblueTest {
  /**
   * Test {@link HyperLogLogPlusAggregator#_apply(HyperLogLogPlus, HyperLogLogPlus)} with {@code
   * HyperLogLogPlus}, {@code HyperLogLogPlus}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link HyperLogLogPlusAggregator#_apply(HyperLogLogPlus,
   * HyperLogLogPlus)}
   */
  @Test
  @DisplayName(
      "Test _apply(HyperLogLogPlus, HyperLogLogPlus) with 'HyperLogLogPlus', 'HyperLogLogPlus'; then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  void test_applyWithHyperLogLogPlusHyperLogLogPlus_thenThrowRuntimeException() {
    // Arrange
    HyperLogLogPlusAggregator hyperLogLogPlusAggregator = new HyperLogLogPlusAggregator();
    HyperLogLogPlus a = new HyperLogLogPlus(4);

    HyperLogLogPlus b = mock(HyperLogLogPlus.class);
    when(b.sizeof()).thenReturn(3);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> hyperLogLogPlusAggregator._apply(a, b));
    verify(b).sizeof();
  }
}
