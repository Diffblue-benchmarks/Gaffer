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
import java.util.Set;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.operation.io.Input;
import uk.gov.gchq.gaffer.operation.io.Output;
import uk.gov.gchq.koryphe.ValidationResult;

class OperationUtilDiffblueTest {
  /**
   * Method under test: {@link OperationUtil#getInputType(Class)}
   */
  @Test
  void testGetInputType() {
    // Arrange
    Class<Input> input = Input.class;

    // Act
    Class<?> actualInputType = OperationUtil.getInputType(input);

    // Assert
    Class<OperationUtil.UnknownGenericType> expectedInputType = OperationUtil.UnknownGenericType.class;
    assertEquals(expectedInputType, actualInputType);
  }

  /**
   * Method under test: {@link OperationUtil#getOutputType(Class)}
   */
  @Test
  void testGetOutputType() {
    // Arrange
    Class<Output> output = Output.class;

    // Act
    Class<?> actualOutputType = OperationUtil.getOutputType(output);

    // Assert
    Class<OperationUtil.UnknownGenericType> expectedOutputType = OperationUtil.UnknownGenericType.class;
    assertEquals(expectedOutputType, actualOutputType);
  }

  /**
   * Method under test: {@link OperationUtil#isValid(Class, Class)}
   */
  @Test
  void testIsValid() {
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
   * Method under test: {@link OperationUtil#isValid(Class, Class)}
   */
  @Test
  void testIsValid2() {
    // Arrange and Act
    ValidationResult actualIsValidResult = OperationUtil.isValid(null, null);

    // Assert
    assertEquals("Validation errors: \n", actualIsValidResult.getErrorString());
    assertTrue(actualIsValidResult.getErrors().isEmpty());
    assertTrue(actualIsValidResult.isValid());
  }

  /**
   * Method under test: {@link OperationUtil#isValid(Class, Class)}
   */
  @Test
  void testIsValid3() {
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
   * Method under test: {@link OperationUtil#isValid(Class, Class)}
   */
  @Test
  void testIsValid4() {
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
   * Method under test: {@link OperationUtil#isValid(Class, Class)}
   */
  @Test
  void testIsValid5() {
    // Arrange
    Class<OperationUtil.UnknownGenericType> output = OperationUtil.UnknownGenericType.class;
    Class<Object> input = Object.class;

    // Act
    ValidationResult actualIsValidResult = OperationUtil.isValid(output, input);

    // Assert
    assertEquals("Validation errors: \n", actualIsValidResult.getErrorString());
    assertTrue(actualIsValidResult.getErrors().isEmpty());
    assertTrue(actualIsValidResult.isValid());
  }

  /**
   * Method under test: {@link OperationUtil#isValid(Class, Class)}
   */
  @Test
  void testIsValid6() {
    // Arrange
    Class<Object> output = Object.class;
    Class<OperationUtil.UnknownGenericType> input = OperationUtil.UnknownGenericType.class;

    // Act
    ValidationResult actualIsValidResult = OperationUtil.isValid(output, input);

    // Assert
    assertEquals("Validation errors: \n", actualIsValidResult.getErrorString());
    assertTrue(actualIsValidResult.getErrors().isEmpty());
    assertTrue(actualIsValidResult.isValid());
  }
}
