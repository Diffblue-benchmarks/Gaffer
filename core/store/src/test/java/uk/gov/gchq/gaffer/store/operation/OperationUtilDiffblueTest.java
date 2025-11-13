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

package uk.gov.gchq.gaffer.store.operation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.named.operation.NamedOperation;
import uk.gov.gchq.gaffer.operation.OperationChainDAO;
import uk.gov.gchq.gaffer.operation.impl.DiscardOutput;
import uk.gov.gchq.gaffer.operation.impl.If;
import uk.gov.gchq.gaffer.operation.impl.io.GenericInputImpl;
import uk.gov.gchq.gaffer.operation.io.Input;
import uk.gov.gchq.gaffer.operation.io.Output;
import uk.gov.gchq.gaffer.store.operation.OperationUtil.UnknownGenericType;
import uk.gov.gchq.gaffer.store.schema.Schema;
import uk.gov.gchq.koryphe.ValidationResult;

class OperationUtilDiffblueTest {
  /**
   * Test {@link OperationUtil#getInputType(Class)} with {@code Class}.
   * <ul>
   *   <li>Then return {@link UnknownGenericType}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationUtil#getInputType(Class)}
   */
  @Test
  @DisplayName("Test getInputType(Class) with 'Class'; then return UnknownGenericType")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Class OperationUtil.getInputType(Class)"})
  void testGetInputTypeWithClass_thenReturnUnknownGenericType() {
    // Arrange
    Class<Input> input = Input.class;

    // Act
    Class<?> actualInputType = OperationUtil.getInputType(input);

    // Assert
    Class<UnknownGenericType> expectedInputType = UnknownGenericType.class;
    assertEquals(expectedInputType, actualInputType);
  }

  /**
   * Test {@link OperationUtil#getInputType(Input)} with {@code Input}.
   * <ul>
   *   <li>When {@link DiscardOutput} (default constructor).</li>
   *   <li>Then return {@link Object}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationUtil#getInputType(Input)}
   */
  @Test
  @DisplayName("Test getInputType(Input) with 'Input'; when DiscardOutput (default constructor); then return Object")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Class OperationUtil.getInputType(Input)"})
  void testGetInputTypeWithInput_whenDiscardOutput_thenReturnObject() {
    // Arrange and Act
    Class<?> actualInputType = OperationUtil.getInputType(new DiscardOutput());

    // Assert
    Class<Object> expectedInputType = Object.class;
    assertEquals(expectedInputType, actualInputType);
  }

  /**
   * Test {@link OperationUtil#getInputType(Input)} with {@code Input}.
   * <ul>
   *   <li>When {@link GenericInputImpl#GenericInputImpl()}.</li>
   *   <li>Then return {@link Object}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationUtil#getInputType(Input)}
   */
  @Test
  @DisplayName("Test getInputType(Input) with 'Input'; when GenericInputImpl(); then return Object")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Class OperationUtil.getInputType(Input)"})
  void testGetInputTypeWithInput_whenGenericInputImpl_thenReturnObject() {
    // Arrange and Act
    Class<?> actualInputType = OperationUtil.getInputType(new GenericInputImpl());

    // Assert
    Class<Object> expectedInputType = Object.class;
    assertEquals(expectedInputType, actualInputType);
  }

  /**
   * Test {@link OperationUtil#getInputType(Input)} with {@code Input}.
   * <ul>
   *   <li>When {@link If} (default constructor).</li>
   *   <li>Then return {@link UnknownGenericType}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationUtil#getInputType(Input)}
   */
  @Test
  @DisplayName("Test getInputType(Input) with 'Input'; when If (default constructor); then return UnknownGenericType")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Class OperationUtil.getInputType(Input)"})
  void testGetInputTypeWithInput_whenIf_thenReturnUnknownGenericType() {
    // Arrange and Act
    Class<?> actualInputType = OperationUtil.getInputType(new If<>());

    // Assert
    Class<UnknownGenericType> expectedInputType = UnknownGenericType.class;
    assertEquals(expectedInputType, actualInputType);
  }

  /**
   * Test {@link OperationUtil#getInputType(Input)} with {@code Input}.
   * <ul>
   *   <li>When {@link NamedOperation} (default constructor).</li>
   *   <li>Then return {@link Iterable}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationUtil#getInputType(Input)}
   */
  @Test
  @DisplayName("Test getInputType(Input) with 'Input'; when NamedOperation (default constructor); then return Iterable")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Class OperationUtil.getInputType(Input)"})
  void testGetInputTypeWithInput_whenNamedOperation_thenReturnIterable() {
    // Arrange and Act
    Class<?> actualInputType = OperationUtil.getInputType(new NamedOperation());

    // Assert
    Class<Iterable> expectedInputType = Iterable.class;
    assertEquals(expectedInputType, actualInputType);
  }

  /**
   * Test {@link OperationUtil#getOutputType(Class)} with {@code Class}.
   * <ul>
   *   <li>Then return {@link UnknownGenericType}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationUtil#getOutputType(Class)}
   */
  @Test
  @DisplayName("Test getOutputType(Class) with 'Class'; then return UnknownGenericType")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Class OperationUtil.getOutputType(Class)"})
  void testGetOutputTypeWithClass_thenReturnUnknownGenericType() {
    // Arrange
    Class<Output> output = Output.class;

    // Act
    Class<?> actualOutputType = OperationUtil.getOutputType(output);

    // Assert
    Class<UnknownGenericType> expectedOutputType = UnknownGenericType.class;
    assertEquals(expectedOutputType, actualOutputType);
  }

  /**
   * Test {@link OperationUtil#getOutputType(Output)} with {@code Output}.
   * <ul>
   *   <li>When {@link GetSchema} (default constructor).</li>
   *   <li>Then return {@link Schema}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationUtil#getOutputType(Output)}
   */
  @Test
  @DisplayName("Test getOutputType(Output) with 'Output'; when GetSchema (default constructor); then return Schema")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Class OperationUtil.getOutputType(Output)"})
  void testGetOutputTypeWithOutput_whenGetSchema_thenReturnSchema() {
    // Arrange and Act
    Class<?> actualOutputType = OperationUtil.getOutputType(new GetSchema());

    // Assert
    Class<Schema> expectedOutputType = Schema.class;
    assertEquals(expectedOutputType, actualOutputType);
  }

  /**
   * Test {@link OperationUtil#getOutputType(Output)} with {@code Output}.
   * <ul>
   *   <li>When {@link GetTraits} (default constructor).</li>
   *   <li>Then return {@link Set}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationUtil#getOutputType(Output)}
   */
  @Test
  @DisplayName("Test getOutputType(Output) with 'Output'; when GetTraits (default constructor); then return Set")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Class OperationUtil.getOutputType(Output)"})
  void testGetOutputTypeWithOutput_whenGetTraits_thenReturnSet() {
    // Arrange and Act
    Class<?> actualOutputType = OperationUtil.getOutputType(new GetTraits());

    // Assert
    Class<Set> expectedOutputType = Set.class;
    assertEquals(expectedOutputType, actualOutputType);
  }

  /**
   * Test {@link OperationUtil#getOutputType(Output)} with {@code Output}.
   * <ul>
   *   <li>When {@link NamedOperation} (default constructor).</li>
   *   <li>Then return {@link UnknownGenericType}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationUtil#getOutputType(Output)}
   */
  @Test
  @DisplayName("Test getOutputType(Output) with 'Output'; when NamedOperation (default constructor); then return UnknownGenericType")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Class OperationUtil.getOutputType(Output)"})
  void testGetOutputTypeWithOutput_whenNamedOperation_thenReturnUnknownGenericType() {
    // Arrange and Act
    Class<?> actualOutputType = OperationUtil.getOutputType(new NamedOperation<>());

    // Assert
    Class<UnknownGenericType> expectedOutputType = UnknownGenericType.class;
    assertEquals(expectedOutputType, actualOutputType);
  }

  /**
   * Test {@link OperationUtil#getOutputType(Output)} with {@code Output}.
   * <ul>
   *   <li>When {@link OperationChainDAO#OperationChainDAO()}.</li>
   *   <li>Then return {@link UnknownGenericType}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationUtil#getOutputType(Output)}
   */
  @Test
  @DisplayName("Test getOutputType(Output) with 'Output'; when OperationChainDAO(); then return UnknownGenericType")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Class OperationUtil.getOutputType(Output)"})
  void testGetOutputTypeWithOutput_whenOperationChainDAO_thenReturnUnknownGenericType() {
    // Arrange and Act
    Class<?> actualOutputType = OperationUtil.getOutputType(new OperationChainDAO<>());

    // Assert
    Class<UnknownGenericType> expectedOutputType = UnknownGenericType.class;
    assertEquals(expectedOutputType, actualOutputType);
  }

  /**
   * Test {@link OperationUtil#isValid(Class, Class)}.
   * <ul>
   *   <li>When {@code Class}.</li>
   *   <li>Then return ErrorString is a string.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationUtil#isValid(Class, Class)}
   */
  @Test
  @DisplayName("Test isValid(Class, Class); when 'java.lang.Class'; then return ErrorString is a string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValidationResult OperationUtil.isValid(Class, Class)"})
  void testIsValid_whenJavaLangClass_thenReturnErrorStringIsAString() {
    // Arrange
    Class<Object> output = Object.class;
    Class<Class> input = Class.class;

    // Act
    ValidationResult actualIsValidResult = OperationUtil.isValid(output, input);

    // Assert
    assertEquals(
        "Validation errors: \n"
            + "Incompatible output, input types. class java.lang.Object: java.lang.Object, input: java.lang.Class",
        actualIsValidResult.getErrorString());
    Set<String> errors = actualIsValidResult.getErrors();
    assertEquals(1, errors.size());
    assertFalse(actualIsValidResult.isValid());
    assertTrue(errors.contains(
        "Incompatible output, input types. class java.lang.Object: java.lang.Object, input: java.lang.Class"));
  }

  /**
   * Test {@link OperationUtil#isValid(Class, Class)}.
   * <ul>
   *   <li>When {@code Object}.</li>
   *   <li>Then return ErrorString is {@code Validation errors:}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationUtil#isValid(Class, Class)}
   */
  @Test
  @DisplayName("Test isValid(Class, Class); when 'java.lang.Object'; then return ErrorString is 'Validation errors:'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValidationResult OperationUtil.isValid(Class, Class)"})
  void testIsValid_whenJavaLangObject_thenReturnErrorStringIsValidationErrors() {
    // Arrange
    Class<Object> output = Object.class;
    Class<Object> input = Object.class;

    // Act
    ValidationResult actualIsValidResult = OperationUtil.isValid(output, input);

    // Assert
    assertEquals("Validation errors: \n", actualIsValidResult.getErrorString());
    assertTrue(actualIsValidResult.getErrors().isEmpty());
    assertTrue(actualIsValidResult.isValid());
  }

  /**
   * Test {@link OperationUtil#isValid(Class, Class)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return ErrorString is {@code Validation errors:}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationUtil#isValid(Class, Class)}
   */
  @Test
  @DisplayName("Test isValid(Class, Class); when 'null'; then return ErrorString is 'Validation errors:'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValidationResult OperationUtil.isValid(Class, Class)"})
  void testIsValid_whenNull_thenReturnErrorStringIsValidationErrors() {
    // Arrange and Act
    ValidationResult actualIsValidResult = OperationUtil.isValid(null, null);

    // Assert
    assertEquals("Validation errors: \n", actualIsValidResult.getErrorString());
    assertTrue(actualIsValidResult.getErrors().isEmpty());
    assertTrue(actualIsValidResult.isValid());
  }

  /**
   * Test {@link OperationUtil#isValid(Class, Class)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return ErrorString is {@code Validation errors:}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationUtil#isValid(Class, Class)}
   */
  @Test
  @DisplayName("Test isValid(Class, Class); when 'null'; then return ErrorString is 'Validation errors:'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValidationResult OperationUtil.isValid(Class, Class)"})
  void testIsValid_whenNull_thenReturnErrorStringIsValidationErrors2() {
    // Arrange
    Class<Object> input = Object.class;

    // Act
    ValidationResult actualIsValidResult = OperationUtil.isValid(null, input);

    // Assert
    assertEquals("Validation errors: \n", actualIsValidResult.getErrorString());
    assertTrue(actualIsValidResult.getErrors().isEmpty());
    assertTrue(actualIsValidResult.isValid());
  }

  /**
   * Test {@link OperationUtil#isValid(Class, Class)}.
   * <ul>
   *   <li>When {@code OperationUtil$UnknownGenericType}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationUtil#isValid(Class, Class)}
   */
  @Test
  @DisplayName("Test isValid(Class, Class); when 'uk.gov.gchq.gaffer.store.operation.OperationUtil$UnknownGenericType'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValidationResult OperationUtil.isValid(Class, Class)"})
  void testIsValid_whenUkGovGchqGafferStoreOperationOperationUtilUnknownGenericType() {
    // Arrange
    Class<UnknownGenericType> output = UnknownGenericType.class;
    Class<Object> input = Object.class;

    // Act
    ValidationResult actualIsValidResult = OperationUtil.isValid(output, input);

    // Assert
    assertEquals("Validation errors: \n", actualIsValidResult.getErrorString());
    assertTrue(actualIsValidResult.getErrors().isEmpty());
    assertTrue(actualIsValidResult.isValid());
  }

  /**
   * Test {@link OperationUtil#isValid(Class, Class)}.
   * <ul>
   *   <li>When {@code OperationUtil$UnknownGenericType}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationUtil#isValid(Class, Class)}
   */
  @Test
  @DisplayName("Test isValid(Class, Class); when 'uk.gov.gchq.gaffer.store.operation.OperationUtil$UnknownGenericType'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValidationResult OperationUtil.isValid(Class, Class)"})
  void testIsValid_whenUkGovGchqGafferStoreOperationOperationUtilUnknownGenericType2() {
    // Arrange
    Class<Object> output = Object.class;
    Class<UnknownGenericType> input = UnknownGenericType.class;

    // Act
    ValidationResult actualIsValidResult = OperationUtil.isValid(output, input);

    // Assert
    assertEquals("Validation errors: \n", actualIsValidResult.getErrorString());
    assertTrue(actualIsValidResult.getErrors().isEmpty());
    assertTrue(actualIsValidResult.isValid());
  }
}
