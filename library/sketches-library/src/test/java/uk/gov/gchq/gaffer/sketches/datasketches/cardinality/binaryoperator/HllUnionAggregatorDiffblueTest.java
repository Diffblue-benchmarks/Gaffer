package uk.gov.gchq.gaffer.sketches.datasketches.cardinality.binaryoperator;

import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.datasketches.hll.Union;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class HllUnionAggregatorDiffblueTest {
  /**
   * Test {@link HllUnionAggregator#_apply(Union, Union)} with {@code Union}, {@code Union}.
   *
   * <ul>
   *   <li>When {@link Union#Union()}.
   *   <li>Then return {@link Union#Union()}.
   * </ul>
   *
   * <p>Method under test: {@link HllUnionAggregator#_apply(Union, Union)}
   */
  @Test
  @DisplayName("Test _apply(Union, Union) with 'Union', 'Union'; when Union(); then return Union()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Union HllUnionAggregator._apply(Union, Union)"})
  void test_applyWithUnionUnion_whenUnion_thenReturnUnion() {
    // Arrange
    HllUnionAggregator hllUnionAggregator = new HllUnionAggregator();
    Union a = new Union();

    // Act
    Union actual_applyResult = hllUnionAggregator._apply(a, new Union());

    // Assert
    assertSame(a, actual_applyResult);
  }
}
