package uk.gov.gchq.gaffer.data.element;

import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class IdentifierTypeDiffblueTest {
  /**
   * Test {@link IdentifierType#fromName(String)}.
   *
   * <p>Method under test: {@link IdentifierType#fromName(String)}
   */
  @Test
  @DisplayName("Test fromName(String)")
  @Tag("MaintainedByDiffblue")
  void testFromName() {
    // Arrange, Act and Assert
    assertNull(IdentifierType.fromName("Name"));
  }
}
