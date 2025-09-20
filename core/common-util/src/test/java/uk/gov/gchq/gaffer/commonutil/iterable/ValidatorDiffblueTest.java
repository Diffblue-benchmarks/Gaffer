package uk.gov.gchq.gaffer.commonutil.iterable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.koryphe.ValidationResult;

class ValidatorDiffblueTest {
  /**
   * Test {@link Validator#validateWithValidationResult(Object)}.
   *
   * <p>Method under test: {@link Validator#validateWithValidationResult(Object)}
   */
  @Test
  @DisplayName("Test validateWithValidationResult(Object)")
  @Tag("MaintainedByDiffblue")
  void testValidateWithValidationResult() {
    // Arrange
    AlwaysValid<Object> alwaysValid = new AlwaysValid<>();

    // Act
    ValidationResult actualValidateWithValidationResultResult =
        alwaysValid.validateWithValidationResult("Obj");

    // Assert
    assertEquals(
        "Validation errors: \n", actualValidateWithValidationResultResult.getErrorString());
    assertTrue(actualValidateWithValidationResultResult.getErrors().isEmpty());
    assertTrue(actualValidateWithValidationResultResult.isValid());
  }
}
