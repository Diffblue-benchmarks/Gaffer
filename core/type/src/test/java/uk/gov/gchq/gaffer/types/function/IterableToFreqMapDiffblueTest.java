package uk.gov.gchq.gaffer.types.function;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.types.FreqMap;

class IterableToFreqMapDiffblueTest {
  /**
   * Test {@link IterableToFreqMap#apply(Iterable)} with {@code Iterable}.
   *
   * <ul>
   *   <li>Given {@code Strings}.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link IterableToFreqMap#apply(Iterable)}
   */
  @Test
  @DisplayName("Test apply(Iterable) with 'Iterable'; given 'Strings'; then return size is one")
  @Tag("MaintainedByDiffblue")
  void testApplyWithIterable_givenStrings_thenReturnSizeIsOne() {
    // Arrange
    IterableToFreqMap iterableToFreqMap = new IterableToFreqMap();

    LinkedHashSet<String> strings = new LinkedHashSet<>();
    strings.add("Strings");

    // Act
    FreqMap actualApplyResult = iterableToFreqMap.apply(strings);

    // Assert
    assertEquals(1, actualApplyResult.size());
    assertEquals(1L, actualApplyResult.get("Strings").longValue());
  }

  /**
   * Test {@link IterableToFreqMap#apply(Iterable)} with {@code Iterable}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link IterableToFreqMap#apply(Iterable)}
   */
  @Test
  @DisplayName("Test apply(Iterable) with 'Iterable'; when ArrayList(); then return Empty")
  @Tag("MaintainedByDiffblue")
  void testApplyWithIterable_whenArrayList_thenReturnEmpty() {
    // Arrange
    IterableToFreqMap iterableToFreqMap = new IterableToFreqMap();

    // Act and Assert
    assertTrue(iterableToFreqMap.apply(new ArrayList<>()).isEmpty());
  }
}
