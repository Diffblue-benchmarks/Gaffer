package uk.gov.gchq.gaffer.types.function;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.types.FreqMap;

class ToFreqMapDiffblueTest {
  /**
   * Test {@link ToFreqMap#apply(Object)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null} longValue is one.
   * </ul>
   *
   * <p>Method under test: {@link ToFreqMap#apply(Object)}
   */
  @Test
  @DisplayName("Test apply(Object); when 'null'; then return 'null' longValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FreqMap ToFreqMap.apply(Object)"})
  void testApply_whenNull_thenReturnNullLongValueIsOne() {
    // Arrange and Act
    FreqMap actualApplyResult = new ToFreqMap().apply(null);

    // Assert
    assertEquals(1, actualApplyResult.size());
    assertEquals(1L, actualApplyResult.get(null).longValue());
  }

  /**
   * Test {@link ToFreqMap#apply(Object)}.
   *
   * <ul>
   *   <li>When {@code Value}.
   *   <li>Then return {@code Value} longValue is one.
   * </ul>
   *
   * <p>Method under test: {@link ToFreqMap#apply(Object)}
   */
  @Test
  @DisplayName("Test apply(Object); when 'Value'; then return 'Value' longValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FreqMap ToFreqMap.apply(Object)"})
  void testApply_whenValue_thenReturnValueLongValueIsOne() {
    // Arrange and Act
    FreqMap actualApplyResult = new ToFreqMap().apply("Value");

    // Assert
    assertEquals(1, actualApplyResult.size());
    assertEquals(1L, actualApplyResult.get("Value").longValue());
  }
}
