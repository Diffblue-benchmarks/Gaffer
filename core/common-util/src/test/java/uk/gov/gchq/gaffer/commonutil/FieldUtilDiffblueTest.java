/*
 * Copyright 2025 Crown Copyright
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.gov.gchq.gaffer.commonutil;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
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
   * <p>
   * Method under test: {@link FieldUtil#validateRequiredFields(Pair[])}
   */
  @Test
  @DisplayName("Test validateRequiredFields(Pair[]) with 'Pair[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValidationResult FieldUtil.validateRequiredFields(Pair[])"})
  void testValidateRequiredFieldsWithPair() {
    // Arrange and Act
    ValidationResult actualValidateRequiredFieldsResult = FieldUtil.validateRequiredFields(new Pair<>());

    // Assert
    assertEquals("Validation errors: \nnull is required.", actualValidateRequiredFieldsResult.getErrorString());
    Set<String> errors = actualValidateRequiredFieldsResult.getErrors();
    assertEquals(1, errors.size());
    assertFalse(actualValidateRequiredFieldsResult.isValid());
    assertTrue(errors.contains("null is required."));
  }

  /**
   * Test {@link FieldUtil#validateRequiredFields(Pair[])} with {@code Pair[]}.
   * <ul>
   *   <li>Then return ErrorString is {@code Validation errors:}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldUtil#validateRequiredFields(Pair[])}
   */
  @Test
  @DisplayName("Test validateRequiredFields(Pair[]) with 'Pair[]'; then return ErrorString is 'Validation errors:'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValidationResult FieldUtil.validateRequiredFields(Pair[])"})
  void testValidateRequiredFieldsWithPair_thenReturnErrorStringIsValidationErrors() {
    // Arrange and Act
    ValidationResult actualValidateRequiredFieldsResult = FieldUtil
        .validateRequiredFields(new Pair<>(" is required.", "Second"));

    // Assert
    assertEquals("Validation errors: \n", actualValidateRequiredFieldsResult.getErrorString());
    assertTrue(actualValidateRequiredFieldsResult.getErrors().isEmpty());
    assertTrue(actualValidateRequiredFieldsResult.isValid());
  }

  /**
   * Test {@link FieldUtil#validateRequiredFields(Tuple3[])} with {@code Tuple3[]}.
   * <ul>
   *   <li>Then return ErrorString is {@code Validation errors:}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldUtil#validateRequiredFields(Tuple3[])}
   */
  @Test
  @DisplayName("Test validateRequiredFields(Tuple3[]) with 'Tuple3[]'; then return ErrorString is 'Validation errors:'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValidationResult FieldUtil.validateRequiredFields(Tuple3[])"})
  void testValidateRequiredFieldsWithTuple3_thenReturnErrorStringIsValidationErrors() {
    // Arrange
    Predicate predicate = mock(Predicate.class);
    when(predicate.test(Mockito.<Object>any())).thenReturn(true);

    // Act
    ValidationResult actualValidateRequiredFieldsResult = FieldUtil
        .validateRequiredFields(new Tuple3<>("foo", "42", predicate));

    // Assert
    verify(predicate).test(isA(Object.class));
    assertEquals("Validation errors: \n", actualValidateRequiredFieldsResult.getErrorString());
    assertTrue(actualValidateRequiredFieldsResult.getErrors().isEmpty());
    assertTrue(actualValidateRequiredFieldsResult.isValid());
  }

  /**
   * Test {@link FieldUtil#validateRequiredFields(Tuple3[])} with {@code Tuple3[]}.
   * <ul>
   *   <li>Then return ErrorString is {@code Validation errors: foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldUtil#validateRequiredFields(Tuple3[])}
   */
  @Test
  @DisplayName("Test validateRequiredFields(Tuple3[]) with 'Tuple3[]'; then return ErrorString is 'Validation errors: foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValidationResult FieldUtil.validateRequiredFields(Tuple3[])"})
  void testValidateRequiredFieldsWithTuple3_thenReturnErrorStringIsValidationErrorsFoo() {
    // Arrange
    Predicate predicate = mock(Predicate.class);
    when(predicate.test(Mockito.<Object>any())).thenReturn(false);

    // Act
    ValidationResult actualValidateRequiredFieldsResult = FieldUtil
        .validateRequiredFields(new Tuple3<>("foo", "42", predicate));

    // Assert
    verify(predicate).test(isA(Object.class));
    assertEquals("Validation errors: \nfoo", actualValidateRequiredFieldsResult.getErrorString());
    Set<String> errors = actualValidateRequiredFieldsResult.getErrors();
    assertEquals(1, errors.size());
    assertFalse(actualValidateRequiredFieldsResult.isValid());
    assertTrue(errors.contains("foo"));
  }
}
