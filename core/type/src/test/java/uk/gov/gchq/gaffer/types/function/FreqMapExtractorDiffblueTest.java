package uk.gov.gchq.gaffer.types.function;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.types.FreqMap;

class FreqMapExtractorDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link FreqMapExtractor#FreqMapExtractor()}
   *   <li>{@link FreqMapExtractor#setKey(String)}
   *   <li>{@link FreqMapExtractor#getKey()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  void testGettersAndSetters() {
    // Arrange and Act
    FreqMapExtractor actualFreqMapExtractor = new FreqMapExtractor();
    actualFreqMapExtractor.setKey("Key");

    // Assert
    assertEquals("Key", actualFreqMapExtractor.getKey());
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@code Key}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link FreqMapExtractor#FreqMapExtractor(String)}
   *   <li>{@link FreqMapExtractor#setKey(String)}
   *   <li>{@link FreqMapExtractor#getKey()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when 'Key'")
  @Tag("MaintainedByDiffblue")
  void testGettersAndSetters_whenKey() {
    // Arrange and Act
    FreqMapExtractor actualFreqMapExtractor = new FreqMapExtractor("Key");
    actualFreqMapExtractor.setKey("Key");

    // Assert
    assertEquals("Key", actualFreqMapExtractor.getKey());
  }

  /**
   * Test {@link FreqMapExtractor#apply(FreqMap)} with {@code FreqMap}.
   *
   * <ul>
   *   <li>When {@link FreqMap#FreqMap()}.
   * </ul>
   *
   * <p>Method under test: {@link FreqMapExtractor#apply(FreqMap)}
   */
  @Test
  @DisplayName("Test apply(FreqMap) with 'FreqMap'; when FreqMap()")
  @Tag("MaintainedByDiffblue")
  void testApplyWithFreqMap_whenFreqMap() {
    // Arrange
    FreqMapExtractor freqMapExtractor = new FreqMapExtractor("Key");

    // Act and Assert
    assertNull(freqMapExtractor.apply(new FreqMap()));
  }

  /**
   * Test {@link FreqMapExtractor#apply(FreqMap)} with {@code FreqMap}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FreqMapExtractor#apply(FreqMap)}
   */
  @Test
  @DisplayName("Test apply(FreqMap) with 'FreqMap'; when 'null'")
  @Tag("MaintainedByDiffblue")
  void testApplyWithFreqMap_whenNull() {
    // Arrange, Act and Assert
    assertNull(new FreqMapExtractor("Key").apply(null));
  }
}
