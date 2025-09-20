package uk.gov.gchq.gaffer.commonutil;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.Set;
import java.util.function.Predicate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uk.gov.gchq.gaffer.commonutil.pair.Pair;
import uk.gov.gchq.koryphe.ValidationResult;
import uk.gov.gchq.koryphe.tuple.n.Tuple3;

class FieldUtilDiffblueTest {
  /**
   * Test {@link FieldUtil#validateRequiredFields(Pair[])} with {@code Pair[]}.
   *
   * <p>Method under test: {@link FieldUtil#validateRequiredFields(Pair[])}
   */
  @Test
  @DisplayName("Test validateRequiredFields(Pair[]) with 'Pair[]'")
  @Tag("MaintainedByDiffblue")
  void testValidateRequiredFieldsWithPair() {
    // Arrange and Act
    ValidationResult actualValidateRequiredFieldsResult =
        FieldUtil.validateRequiredFields(new Pair<>());

    // Assert
    assertEquals(
        "Validation errors: \nnull is required.",
        actualValidateRequiredFieldsResult.getErrorString());
    Set<String> errors = actualValidateRequiredFieldsResult.getErrors();
    assertEquals(1, errors.size());
    assertFalse(actualValidateRequiredFieldsResult.isValid());
    assertTrue(errors.contains("null is required."));
  }

  /**
   * Test {@link FieldUtil#validateRequiredFields(Pair[])} with {@code Pair[]}.
   *
   * <ul>
   *   <li>Then return ErrorString is {@code Validation errors:}.
   * </ul>
   *
   * <p>Method under test: {@link FieldUtil#validateRequiredFields(Pair[])}
   */
  @Test
  @DisplayName(
      "Test validateRequiredFields(Pair[]) with 'Pair[]'; then return ErrorString is 'Validation errors:'")
  @Tag("MaintainedByDiffblue")
  void testValidateRequiredFieldsWithPair_thenReturnErrorStringIsValidationErrors() {
    // Arrange and Act
    ValidationResult actualValidateRequiredFieldsResult =
        FieldUtil.validateRequiredFields(new Pair<>(" is required.", "Second"));

    // Assert
    assertEquals("Validation errors: \n", actualValidateRequiredFieldsResult.getErrorString());
    assertTrue(actualValidateRequiredFieldsResult.getErrors().isEmpty());
    assertTrue(actualValidateRequiredFieldsResult.isValid());
  }

  /**
   * Test {@link FieldUtil#validateRequiredFields(Tuple3[])} with {@code Tuple3[]}.
   *
   * <ul>
   *   <li>Then return ErrorString is {@code Validation errors:}.
   * </ul>
   *
   * <p>Method under test: {@link FieldUtil#validateRequiredFields(Tuple3[])}
   */
  @Test
  @DisplayName(
      "Test validateRequiredFields(Tuple3[]) with 'Tuple3[]'; then return ErrorString is 'Validation errors:'")
  @Tag("MaintainedByDiffblue")
  void testValidateRequiredFieldsWithTuple3_thenReturnErrorStringIsValidationErrors() {
    // Arrange
    Predicate predicate = mock(Predicate.class);
    when(predicate.test(Mockito.<Object>any())).thenReturn(true);
    Tuple3<String, Object, Predicate> tuple3 = new Tuple3<>("foo", "42", predicate);

    // Act
    ValidationResult actualValidateRequiredFieldsResult = FieldUtil.validateRequiredFields(tuple3);

    // Assert
    verify(predicate).test(isA(Object.class));
    assertEquals("Validation errors: \n", actualValidateRequiredFieldsResult.getErrorString());
    assertTrue(actualValidateRequiredFieldsResult.getErrors().isEmpty());
    assertTrue(actualValidateRequiredFieldsResult.isValid());
  }

  /**
   * Test {@link FieldUtil#validateRequiredFields(Tuple3[])} with {@code Tuple3[]}.
   *
   * <ul>
   *   <li>Then return ErrorString is {@code Validation errors: foo}.
   * </ul>
   *
   * <p>Method under test: {@link FieldUtil#validateRequiredFields(Tuple3[])}
   */
  @Test
  @DisplayName(
      "Test validateRequiredFields(Tuple3[]) with 'Tuple3[]'; then return ErrorString is 'Validation errors: foo'")
  @Tag("MaintainedByDiffblue")
  void testValidateRequiredFieldsWithTuple3_thenReturnErrorStringIsValidationErrorsFoo() {
    // Arrange
    Predicate predicate = mock(Predicate.class);
    when(predicate.test(Mockito.<Object>any())).thenReturn(false);
    Tuple3<String, Object, Predicate> tuple3 = new Tuple3<>("foo", "42", predicate);

    // Act
    ValidationResult actualValidateRequiredFieldsResult = FieldUtil.validateRequiredFields(tuple3);

    // Assert
    verify(predicate).test(isA(Object.class));
    assertEquals("Validation errors: \nfoo", actualValidateRequiredFieldsResult.getErrorString());
    Set<String> errors = actualValidateRequiredFieldsResult.getErrors();
    assertEquals(1, errors.size());
    assertFalse(actualValidateRequiredFieldsResult.isValid());
    assertTrue(errors.contains("foo"));
  }
}
