package uk.gov.gchq.gaffer.types.function;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.types.FreqMap;

class FreqMapAggregatorDiffblueTest {
  /**
   * Test {@link FreqMapAggregator#_apply(FreqMap, FreqMap)} with {@code FreqMap}, {@code FreqMap}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>When {@link FreqMap#FreqMap()}.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link FreqMapAggregator#_apply(FreqMap, FreqMap)}
   */
  @Test
  @DisplayName(
      "Test _apply(FreqMap, FreqMap) with 'FreqMap', 'FreqMap'; given 'foo'; when FreqMap(); then return size is one")
  @Tag("MaintainedByDiffblue")
  void test_applyWithFreqMapFreqMap_givenFoo_whenFreqMap_thenReturnSizeIsOne() {
    // Arrange
    FreqMapAggregator freqMapAggregator = new FreqMapAggregator();
    FreqMap a = new FreqMap();

    FreqMap b = new FreqMap();
    b.put("foo", 1L);

    // Act
    FreqMap actual_applyResult = freqMapAggregator._apply(a, b);

    // Assert
    assertEquals(1, actual_applyResult.size());
    assertEquals(1L, actual_applyResult.get("foo").longValue());
  }

  /**
   * Test {@link FreqMapAggregator#_apply(FreqMap, FreqMap)} with {@code FreqMap}, {@code FreqMap}.
   *
   * <ul>
   *   <li>Given zero.
   *   <li>When {@link FreqMap#FreqMap()} {@code foo} is zero.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link FreqMapAggregator#_apply(FreqMap, FreqMap)}
   */
  @Test
  @DisplayName(
      "Test _apply(FreqMap, FreqMap) with 'FreqMap', 'FreqMap'; given zero; when FreqMap() 'foo' is zero; then return size is one")
  @Tag("MaintainedByDiffblue")
  void test_applyWithFreqMapFreqMap_givenZero_whenFreqMapFooIsZero_thenReturnSizeIsOne() {
    // Arrange
    FreqMapAggregator freqMapAggregator = new FreqMapAggregator();

    FreqMap a = new FreqMap();
    a.put("foo", 0L);

    FreqMap b = new FreqMap();
    b.put("foo", 1L);

    // Act
    FreqMap actual_applyResult = freqMapAggregator._apply(a, b);

    // Assert
    assertEquals(1, actual_applyResult.size());
    assertEquals(1L, actual_applyResult.get("foo").longValue());
  }

  /**
   * Test {@link FreqMapAggregator#_apply(FreqMap, FreqMap)} with {@code FreqMap}, {@code FreqMap}.
   *
   * <ul>
   *   <li>When {@link FreqMap#FreqMap()}.
   *   <li>Then return {@link FreqMap#FreqMap()}.
   * </ul>
   *
   * <p>Method under test: {@link FreqMapAggregator#_apply(FreqMap, FreqMap)}
   */
  @Test
  @DisplayName(
      "Test _apply(FreqMap, FreqMap) with 'FreqMap', 'FreqMap'; when FreqMap(); then return FreqMap()")
  @Tag("MaintainedByDiffblue")
  void test_applyWithFreqMapFreqMap_whenFreqMap_thenReturnFreqMap() {
    // Arrange
    FreqMapAggregator freqMapAggregator = new FreqMapAggregator();
    FreqMap a = new FreqMap();

    // Act
    FreqMap actual_applyResult = freqMapAggregator._apply(a, new FreqMap());

    // Assert
    assertEquals(a, actual_applyResult);
  }
}
