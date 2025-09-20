package uk.gov.gchq.gaffer.commonutil;

import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class DebugUtilDiffblueTest {
  /**
   * Test {@link DebugUtil#checkDebugMode()}.
   *
   * <p>Method under test: {@link DebugUtil#checkDebugMode()}
   */
  @Test
  @DisplayName("Test checkDebugMode()")
  @Tag("MaintainedByDiffblue")
  void testCheckDebugMode() {
    // Arrange, Act and Assert
    assertFalse(DebugUtil.checkDebugMode());
  }
}
