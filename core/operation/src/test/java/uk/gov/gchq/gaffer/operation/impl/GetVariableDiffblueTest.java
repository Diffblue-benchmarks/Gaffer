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
import org.apache.commons.lang3.exception.CloneFailedException;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl;

class GetVariableDiffblueTest {
  /**
   * Method under test: default or parameterless constructor of
   * {@link GetVariable.Builder}
   */
  @Test
  void testBuilderNewBuilder() {
    // Arrange and Act
    GetVariable.Builder actualBuilder = new GetVariable.Builder();

    // Assert
    GetVariable _getOpResult = actualBuilder._getOp();
    TypeReference<Object> outputTypeReference = _getOpResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.Object);
    assertNull(_getOpResult.getVariableName());
    assertNull(_getOpResult.getOptions());
    Class<Object> expectedOutputClass = Object.class;
    Class<?> outputClass = _getOpResult.getOutputClass();
    assertEquals(expectedOutputClass, outputClass);
    assertSame(_getOpResult, actualBuilder.build());
    assertSame(outputClass, outputTypeReference.getType());
    assertSame(outputClass, _getOpResult.getOutputType());
  }

  /**
   * Method under test: {@link GetVariable.Builder#variableName(String)}
   */
  @Test
  void testBuilderVariableName() {
    // Arrange
    GetVariable.Builder builder = new GetVariable.Builder();

    // Act and Assert
    assertSame(builder, builder.variableName("Variable Name"));
  }

  /**
   * Method under test: {@link GetVariable#getOutputTypeReference()}
   */
  @Test
  void testGetOutputTypeReference() {
    // Arrange, Act and Assert
    assertTrue((new GetVariable()).getOutputTypeReference() instanceof TypeReferenceImpl.Object);
  }

  /**
   * Method under test: {@link GetVariable#getOutputTypeReference()}
   */
  @Test
  void testGetOutputTypeReference2() {
    // Arrange
    HashMap<String, String> options = new HashMap<>();
    options.computeIfPresent("foo", mock(BiFunction.class));

    GetVariable getVariable = new GetVariable();
    getVariable.setOptions(options);

    // Act and Assert
    assertTrue(getVariable.getOutputTypeReference() instanceof TypeReferenceImpl.Object);
  }

  /**
   * Method under test: {@link GetVariable#shallowClone()}
   */
  @Test
  void testShallowClone() throws CloneFailedException {
    // Arrange and Act
    GetVariable actualShallowCloneResult = (new GetVariable()).shallowClone();

    // Assert
    TypeReference<Object> outputTypeReference = actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.Object);
    assertNull(actualShallowCloneResult.getVariableName());
    assertNull(actualShallowCloneResult.getOptions());
    Class<Object> expectedOutputClass = Object.class;
    Class<?> outputClass = actualShallowCloneResult.getOutputClass();
    assertEquals(expectedOutputClass, outputClass);
    assertSame(outputClass, outputTypeReference.getType());
    assertSame(outputClass, actualShallowCloneResult.getOutputType());
  }

  /**
   * Method under test: {@link GetVariable#shallowClone()}
   */
  @Test
  void testShallowClone2() throws CloneFailedException {
    // Arrange
    GetVariable getVariable = new GetVariable();
    getVariable.setOptions(new HashMap<>());

    // Act
    GetVariable actualShallowCloneResult = getVariable.shallowClone();

    // Assert
    TypeReference<Object> outputTypeReference = actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.Object);
    assertNull(actualShallowCloneResult.getVariableName());
    assertTrue(actualShallowCloneResult.getOptions().isEmpty());
    Class<Object> expectedOutputClass = Object.class;
    Class<?> outputClass = actualShallowCloneResult.getOutputClass();
    assertEquals(expectedOutputClass, outputClass);
    assertSame(outputClass, outputTypeReference.getType());
    assertSame(outputClass, actualShallowCloneResult.getOutputType());
  }

  /**
   * Method under test: {@link GetVariable#shallowClone()}
   */
  @Test
  void testShallowClone3() throws CloneFailedException {
    // Arrange
    HashMap<String, String> options = new HashMap<>();
    options.computeIfPresent("foo", mock(BiFunction.class));

    GetVariable getVariable = new GetVariable();
    getVariable.setOptions(options);

    // Act
    GetVariable actualShallowCloneResult = getVariable.shallowClone();

    // Assert
    TypeReference<Object> outputTypeReference = actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.Object);
    assertNull(actualShallowCloneResult.getVariableName());
    assertTrue(actualShallowCloneResult.getOptions().isEmpty());
    Class<Object> expectedOutputClass = Object.class;
    Class<?> outputClass = actualShallowCloneResult.getOutputClass();
    assertEquals(expectedOutputClass, outputClass);
    assertSame(outputClass, outputTypeReference.getType());
    assertSame(outputClass, actualShallowCloneResult.getOutputType());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link GetVariable}
   *   <li>{@link GetVariable#setOptions(Map)}
   *   <li>{@link GetVariable#setVariableName(String)}
   *   <li>{@link GetVariable#getOptions()}
   *   <li>{@link GetVariable#getVariableName()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    GetVariable actualGetVariable = new GetVariable();
    HashMap<String, String> options = new HashMap<>();
    actualGetVariable.setOptions(options);
    actualGetVariable.setVariableName("Variable Name");
    Map<String, String> actualOptions = actualGetVariable.getOptions();

    // Assert that nothing has changed
    assertEquals("Variable Name", actualGetVariable.getVariableName());
    assertTrue(actualOptions.isEmpty());
    assertSame(options, actualOptions);
  }
}
