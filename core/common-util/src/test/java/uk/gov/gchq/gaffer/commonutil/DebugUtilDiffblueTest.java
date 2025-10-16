package uk.gov.gchq.gaffer.commonutil;

import static org.junit.jupiter.api.Assertions.assertFalse;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DebugUtil.checkDebugMode()"})
  void testCheckDebugMode() {
    // Arrange, Act and Assert
    assertFalse(DebugUtil.checkDebugMode());
  }
}
