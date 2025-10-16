package uk.gov.gchq.gaffer.sketches.datasketches.frequencies.binaryoperator;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.datasketches.frequencies.LongsSketch;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class LongsSketchAggregatorDiffblueTest {
  /**
   * Test {@link LongsSketchAggregator#_apply(LongsSketch, LongsSketch)} with {@code LongsSketch},
   * {@code LongsSketch}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>Then return {@link LongsSketch}.
   * </ul>
   *
   * <p>Method under test: {@link LongsSketchAggregator#_apply(LongsSketch, LongsSketch)}
   */
  @Test
  @DisplayName(
      "Test _apply(LongsSketch, LongsSketch) with 'LongsSketch', 'LongsSketch'; given 'null'; then return LongsSketch")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongsSketch LongsSketchAggregator._apply(LongsSketch, LongsSketch)"})
  void test_applyWithLongsSketchLongsSketch_givenNull_thenReturnLongsSketch() {
    // Arrange
    LongsSketchAggregator longsSketchAggregator = new LongsSketchAggregator();

    LongsSketch a = mock(LongsSketch.class);
    when(a.merge(Mockito.<LongsSketch>any())).thenReturn(null);

    // Act
    LongsSketch actual_applyResult = longsSketchAggregator._apply(a, null);

    // Assert
    verify(a).merge(isNull());
    assertSame(a, actual_applyResult);
  }
}
