package uk.gov.gchq.gaffer.sketches.datasketches.quantiles.binaryoperator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.datasketches.quantiles.ItemsSketch;
import org.apache.datasketches.quantiles.ItemsSketchIterator;
import org.apache.datasketches.quantiles.ItemsSketchSortedView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class StringsSketchAggregatorDiffblueTest {
  /**
   * Test {@link StringsSketchAggregator#_apply(ItemsSketch, ItemsSketch)} with {@code ItemsSketch},
   * {@code ItemsSketch}.
   *
   * <p>Method under test: {@link StringsSketchAggregator#_apply(ItemsSketch, ItemsSketch)}
   */
  @Test
  @DisplayName("Test _apply(ItemsSketch, ItemsSketch) with 'ItemsSketch', 'ItemsSketch'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ItemsSketch StringsSketchAggregator._apply(ItemsSketch, ItemsSketch)"})
  void test_applyWithItemsSketchItemsSketch() {
    // Arrange and Act
    ItemsSketch<String> actual_applyResult = new StringsSketchAggregator()._apply(null, null);

    // Assert
    assertTrue(actual_applyResult.iterator() instanceof ItemsSketchIterator);
    assertTrue(actual_applyResult.getSortedView() instanceof ItemsSketchSortedView);
    assertEquals(0, actual_applyResult.getNumRetained());
    assertEquals(0L, actual_applyResult.getN());
    assertEquals(128, actual_applyResult.getK());
    assertFalse(actual_applyResult.hasMemory());
    assertFalse(actual_applyResult.isDirect());
    assertFalse(actual_applyResult.isEstimationMode());
    assertFalse(actual_applyResult.isReadOnly());
    assertTrue(actual_applyResult.isEmpty());
    Class<String> expectedSketchType = String.class;
    assertEquals(expectedSketchType, actual_applyResult.getSketchType());
  }
}
