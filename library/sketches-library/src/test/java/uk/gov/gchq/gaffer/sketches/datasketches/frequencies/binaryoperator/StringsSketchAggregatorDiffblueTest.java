package uk.gov.gchq.gaffer.sketches.datasketches.frequencies.binaryoperator;

import static org.junit.jupiter.api.Assertions.assertSame;
import org.apache.datasketches.frequencies.ItemsSketch;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class StringsSketchAggregatorDiffblueTest {
  /**
   * Test {@link StringsSketchAggregator#_apply(ItemsSketch, ItemsSketch)} with {@code ItemsSketch},
   * {@code ItemsSketch}.
   *
   * <ul>
   *   <li>Then return {@link ItemsSketch#ItemsSketch(int)} with maxMapSize is one.
   * </ul>
   *
   * <p>Method under test: {@link StringsSketchAggregator#_apply(ItemsSketch, ItemsSketch)}
   */
  @Test
  @DisplayName(
      "Test _apply(ItemsSketch, ItemsSketch) with 'ItemsSketch', 'ItemsSketch'; then return ItemsSketch(int) with maxMapSize is one")
  @Tag("MaintainedByDiffblue")
  void test_applyWithItemsSketchItemsSketch_thenReturnItemsSketchWithMaxMapSizeIsOne() {
    // Arrange
    StringsSketchAggregator stringsSketchAggregator = new StringsSketchAggregator();
    ItemsSketch<String> a = new ItemsSketch<>(1);

    // Act
    ItemsSketch<String> actual_applyResult =
        stringsSketchAggregator._apply(a, new ItemsSketch<>(1));

    // Assert
    assertSame(a, actual_applyResult);
  }

  /**
   * Test {@link StringsSketchAggregator#_apply(ItemsSketch, ItemsSketch)} with {@code ItemsSketch},
   * {@code ItemsSketch}.
   *
   * <ul>
   *   <li>Then return {@link ItemsSketch#ItemsSketch(int)} with maxMapSize is one.
   * </ul>
   *
   * <p>Method under test: {@link StringsSketchAggregator#_apply(ItemsSketch, ItemsSketch)}
   */
  @Test
  @DisplayName(
      "Test _apply(ItemsSketch, ItemsSketch) with 'ItemsSketch', 'ItemsSketch'; then return ItemsSketch(int) with maxMapSize is one")
  @Tag("MaintainedByDiffblue")
  void test_applyWithItemsSketchItemsSketch_thenReturnItemsSketchWithMaxMapSizeIsOne2() {
    // Arrange
    StringsSketchAggregator stringsSketchAggregator = new StringsSketchAggregator();
    ItemsSketch<String> a = new ItemsSketch<>(1);

    // Act
    ItemsSketch<String> actual_applyResult = stringsSketchAggregator._apply(a, null);

    // Assert
    assertSame(a, actual_applyResult);
  }
}
