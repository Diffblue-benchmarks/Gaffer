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
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import org.apache.commons.lang3.exception.CloneFailedException;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl;

class GetVariablesDiffblueTest {
  /**
   * Method under test: default or parameterless constructor of
   * {@link GetVariables.Builder}
   */
  @Test
  void testBuilderNewBuilder() {
    // Arrange and Act
    GetVariables.Builder actualBuilder = new GetVariables.Builder();

    // Assert
    GetVariables _getOpResult = actualBuilder._getOp();
    TypeReference<Map<String, Object>> outputTypeReference = _getOpResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.MapStringObject);
    Type outputType = _getOpResult.getOutputType();
    assertEquals("java.util.Map<java.lang.String, java.lang.Object>", outputType.getTypeName());
    assertNull(_getOpResult.getVariableNames());
    assertNull(_getOpResult.getOptions());
    Class<Map> expectedOutputClass = Map.class;
    assertEquals(expectedOutputClass, _getOpResult.getOutputClass());
    assertSame(_getOpResult, actualBuilder.build());
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Method under test: {@link GetVariables.Builder#variableNames(List)}
   */
  @Test
  void testBuilderVariableNames() {
    // Arrange
    GetVariables.Builder builder = new GetVariables.Builder();

    // Act and Assert
    assertSame(builder, builder.variableNames(new ArrayList<>()));
  }

  /**
   * Method under test: {@link GetVariables.Builder#variableNames(List)}
   */
  @Test
  void testBuilderVariableNames2() {
    // Arrange
    GetVariables.Builder builder = new GetVariables.Builder();

    ArrayList<String> variableNames = new ArrayList<>();
    variableNames.add("foo");

    // Act and Assert
    assertSame(builder, builder.variableNames(variableNames));
  }

  /**
   * Method under test: {@link GetVariables.Builder#variableNames(List)}
   */
  @Test
  void testBuilderVariableNames3() {
    // Arrange
    GetVariables.Builder builder = new GetVariables.Builder();

    ArrayList<String> variableNames = new ArrayList<>();
    variableNames.add("42");
    variableNames.add("foo");

    // Act and Assert
    assertSame(builder, builder.variableNames(variableNames));
  }

  /**
   * Method under test: {@link GetVariables#getOutputTypeReference()}
   */
  @Test
  void testGetOutputTypeReference() {
    // Arrange and Act
    TypeReference<Map<String, Object>> actualOutputTypeReference = (new GetVariables()).getOutputTypeReference();

    // Assert
    assertTrue(actualOutputTypeReference instanceof TypeReferenceImpl.MapStringObject);
    assertEquals("java.util.Map<java.lang.String, java.lang.Object>",
        actualOutputTypeReference.getType().getTypeName());
  }

  /**
   * Method under test: {@link GetVariables#getOutputTypeReference()}
   */
  @Test
  void testGetOutputTypeReference2() {
    // Arrange
    HashMap<String, String> options = new HashMap<>();
    options.computeIfPresent("foo", mock(BiFunction.class));

    GetVariables getVariables = new GetVariables();
    getVariables.setOptions(options);

    // Act
    TypeReference<Map<String, Object>> actualOutputTypeReference = getVariables.getOutputTypeReference();

    // Assert
    assertTrue(actualOutputTypeReference instanceof TypeReferenceImpl.MapStringObject);
    assertEquals("java.util.Map<java.lang.String, java.lang.Object>",
        actualOutputTypeReference.getType().getTypeName());
  }

  /**
   * Method under test: {@link GetVariables#shallowClone()}
   */
  @Test
  void testShallowClone() throws CloneFailedException {
    // Arrange and Act
    GetVariables actualShallowCloneResult = (new GetVariables()).shallowClone();

    // Assert
    TypeReference<Map<String, Object>> outputTypeReference = actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.MapStringObject);
    Type outputType = actualShallowCloneResult.getOutputType();
    assertEquals("java.util.Map<java.lang.String, java.lang.Object>", outputType.getTypeName());
    assertNull(actualShallowCloneResult.getVariableNames());
    assertNull(actualShallowCloneResult.getOptions());
    Class<Map> expectedOutputClass = Map.class;
    assertEquals(expectedOutputClass, actualShallowCloneResult.getOutputClass());
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Method under test: {@link GetVariables#shallowClone()}
   */
  @Test
  void testShallowClone2() throws CloneFailedException {
    // Arrange
    GetVariables getVariables = new GetVariables();
    getVariables.setOptions(new HashMap<>());

    // Act
    GetVariables actualShallowCloneResult = getVariables.shallowClone();

    // Assert
    TypeReference<Map<String, Object>> outputTypeReference = actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.MapStringObject);
    Type outputType = actualShallowCloneResult.getOutputType();
    assertEquals("java.util.Map<java.lang.String, java.lang.Object>", outputType.getTypeName());
    assertNull(actualShallowCloneResult.getVariableNames());
    assertTrue(actualShallowCloneResult.getOptions().isEmpty());
    Class<Map> expectedOutputClass = Map.class;
    assertEquals(expectedOutputClass, actualShallowCloneResult.getOutputClass());
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Method under test: {@link GetVariables#shallowClone()}
   */
  @Test
  void testShallowClone3() throws CloneFailedException {
    // Arrange
    HashMap<String, String> options = new HashMap<>();
    options.computeIfPresent("foo", mock(BiFunction.class));

    GetVariables getVariables = new GetVariables();
    getVariables.setOptions(options);

    // Act
    GetVariables actualShallowCloneResult = getVariables.shallowClone();

    // Assert
    TypeReference<Map<String, Object>> outputTypeReference = actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.MapStringObject);
    Type outputType = actualShallowCloneResult.getOutputType();
    assertEquals("java.util.Map<java.lang.String, java.lang.Object>", outputType.getTypeName());
    assertNull(actualShallowCloneResult.getVariableNames());
    assertTrue(actualShallowCloneResult.getOptions().isEmpty());
    Class<Map> expectedOutputClass = Map.class;
    assertEquals(expectedOutputClass, actualShallowCloneResult.getOutputClass());
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link GetVariables}
   *   <li>{@link GetVariables#setOptions(Map)}
   *   <li>{@link GetVariables#setVariableNames(List)}
   *   <li>{@link GetVariables#getOptions()}
   *   <li>{@link GetVariables#getVariableNames()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    GetVariables actualGetVariables = new GetVariables();
    HashMap<String, String> options = new HashMap<>();
    actualGetVariables.setOptions(options);
    ArrayList<String> variableNames = new ArrayList<>();
    actualGetVariables.setVariableNames(variableNames);
    Map<String, String> actualOptions = actualGetVariables.getOptions();
    List<String> actualVariableNames = actualGetVariables.getVariableNames();

    // Assert that nothing has changed
    assertTrue(actualVariableNames.isEmpty());
    assertTrue(actualOptions.isEmpty());
    assertSame(variableNames, actualVariableNames);
    assertSame(options, actualOptions);
  }
}
