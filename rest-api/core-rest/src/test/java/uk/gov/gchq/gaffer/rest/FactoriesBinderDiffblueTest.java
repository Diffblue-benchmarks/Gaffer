package uk.gov.gchq.gaffer.rest;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class FactoriesBinderDiffblueTest {
  /**
   * Test {@link FactoriesBinder#configure()}.
   *
   * <p>Method under test: {@link FactoriesBinder#configure()}
   */
  @Test
  @DisplayName("Test configure()")
  @Tag("MaintainedByDiffblue")
  void testConfigure() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new FactoriesBinder().configure());
  }
}
