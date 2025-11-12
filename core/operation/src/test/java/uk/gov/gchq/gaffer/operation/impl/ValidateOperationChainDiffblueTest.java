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

package uk.gov.gchq.gaffer.operation.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl;
import uk.gov.gchq.koryphe.ValidationResult;

class ValidateOperationChainDiffblueTest {
  /**
   * Method under test: default or parameterless constructor of
   * {@link ValidateOperationChain.Builder}
   */
  @Test
  void testBuilderNewBuilder() {
    // Arrange and Act
    ValidateOperationChain.Builder actualBuilder = new ValidateOperationChain.Builder();

    // Assert
    ValidateOperationChain _getOpResult = actualBuilder._getOp();
    TypeReference<ValidationResult> outputTypeReference = _getOpResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.ValidationResult);
    assertNull(_getOpResult.getOptions());
    assertNull(_getOpResult.getOperationChain());
    Class<ValidationResult> expectedOutputClass = ValidationResult.class;
    Class<?> outputClass = _getOpResult.getOutputClass();
    assertEquals(expectedOutputClass, outputClass);
    assertSame(_getOpResult, actualBuilder.build());
    assertSame(outputClass, outputTypeReference.getType());
    assertSame(outputClass, _getOpResult.getOutputType());
  }

  /**
   * Method under test: {@link ValidateOperationChain#getOutputTypeReference()}
   */
  @Test
  void testGetOutputTypeReference() {
    // Arrange, Act and Assert
    assertTrue((new ValidateOperationChain()).getOutputTypeReference() instanceof TypeReferenceImpl.ValidationResult);
  }

  /**
   * Method under test: {@link ValidateOperationChain#getOutputTypeReference()}
   */
  @Test
  void testGetOutputTypeReference2() {
    // Arrange
    HashMap<String, String> options = new HashMap<>();
    options.computeIfPresent("foo", mock(BiFunction.class));

    ValidateOperationChain validateOperationChain = new ValidateOperationChain();
    validateOperationChain.setOptions(options);

    // Act and Assert
    assertTrue(validateOperationChain.getOutputTypeReference() instanceof TypeReferenceImpl.ValidationResult);
  }

  /**
   * Method under test: {@link ValidateOperationChain#shallowClone()}
   */
  @Test
  void testShallowClone() {
    // Arrange and Act
    ValidateOperationChain actualShallowCloneResult = (new ValidateOperationChain()).shallowClone();

    // Assert
    TypeReference<ValidationResult> outputTypeReference = actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.ValidationResult);
    assertNull(actualShallowCloneResult.getOptions());
    assertNull(actualShallowCloneResult.getOperationChain());
    Class<ValidationResult> expectedOutputClass = ValidationResult.class;
    Class<?> outputClass = actualShallowCloneResult.getOutputClass();
    assertEquals(expectedOutputClass, outputClass);
    assertSame(outputClass, outputTypeReference.getType());
    assertSame(outputClass, actualShallowCloneResult.getOutputType());
  }

  /**
   * Method under test: {@link ValidateOperationChain#shallowClone()}
   */
  @Test
  void testShallowClone2() {
    // Arrange
    ValidateOperationChain validateOperationChain = new ValidateOperationChain();
    validateOperationChain.setOptions(new HashMap<>());

    // Act
    ValidateOperationChain actualShallowCloneResult = validateOperationChain.shallowClone();

    // Assert
    TypeReference<ValidationResult> outputTypeReference = actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.ValidationResult);
    assertNull(actualShallowCloneResult.getOperationChain());
    assertTrue(actualShallowCloneResult.getOptions().isEmpty());
    Class<ValidationResult> expectedOutputClass = ValidationResult.class;
    Class<?> outputClass = actualShallowCloneResult.getOutputClass();
    assertEquals(expectedOutputClass, outputClass);
    assertSame(outputClass, outputTypeReference.getType());
    assertSame(outputClass, actualShallowCloneResult.getOutputType());
  }

  /**
   * Method under test: {@link ValidateOperationChain#shallowClone()}
   */
  @Test
  void testShallowClone3() {
    // Arrange
    HashMap<String, String> options = new HashMap<>();
    options.computeIfPresent("foo", mock(BiFunction.class));

    ValidateOperationChain validateOperationChain = new ValidateOperationChain();
    validateOperationChain.setOptions(options);

    // Act
    ValidateOperationChain actualShallowCloneResult = validateOperationChain.shallowClone();

    // Assert
    TypeReference<ValidationResult> outputTypeReference = actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.ValidationResult);
    assertNull(actualShallowCloneResult.getOperationChain());
    assertTrue(actualShallowCloneResult.getOptions().isEmpty());
    Class<ValidationResult> expectedOutputClass = ValidationResult.class;
    Class<?> outputClass = actualShallowCloneResult.getOutputClass();
    assertEquals(expectedOutputClass, outputClass);
    assertSame(outputClass, outputTypeReference.getType());
    assertSame(outputClass, actualShallowCloneResult.getOutputType());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link ValidateOperationChain}
   *   <li>{@link ValidateOperationChain#setOptions(Map)}
   *   <li>{@link ValidateOperationChain#getOperationChain()}
   *   <li>{@link ValidateOperationChain#getOptions()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    ValidateOperationChain actualValidateOperationChain = new ValidateOperationChain();
    HashMap<String, String> options = new HashMap<>();
    actualValidateOperationChain.setOptions(options);
    actualValidateOperationChain.getOperationChain();
    Map<String, String> actualOptions = actualValidateOperationChain.getOptions();

    // Assert that nothing has changed
    assertTrue(actualOptions.isEmpty());
    assertSame(options, actualOptions);
  }
}
