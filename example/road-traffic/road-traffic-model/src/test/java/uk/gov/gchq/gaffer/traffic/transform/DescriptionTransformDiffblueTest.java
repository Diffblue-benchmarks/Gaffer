package uk.gov.gchq.gaffer.traffic.transform;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class DescriptionTransformDiffblueTest {
  /**
   * Test {@link DescriptionTransform#apply(String, String, Long)} with {@code junctionA}, {@code
   * junctionB}, {@code count}.
   *
   * <p>Method under test: {@link DescriptionTransform#apply(String, String, Long)}
   */
  @Test
  @DisplayName("Test apply(String, String, Long) with 'junctionA', 'junctionB', 'count'")
  @Tag("MaintainedByDiffblue")
  void testApplyWithJunctionAJunctionBCount() {
    // Arrange, Act and Assert
    assertEquals(
        "3 vehicles have travelled between junction Junction A and junction Junction B",
        new DescriptionTransform().apply("Junction A", "Junction B", 3L));
  }
}
