package uk.gov.gchq.gaffer.commonutil.iterable;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class AlwaysValidDiffblueTest {
  /**
   * Test {@link AlwaysValid#validate(Object)}.
   *
   * <p>Method under test: {@link AlwaysValid#validate(Object)}
   */
  @Test
  @DisplayName("Test validate(Object)")
  @Tag("MaintainedByDiffblue")
  void testValidate() {
    // Arrange
    AlwaysValid<Object> alwaysValid = new AlwaysValid<>();

    // Act and Assert
    assertTrue(alwaysValid.validate("Obj"));
  }
}
