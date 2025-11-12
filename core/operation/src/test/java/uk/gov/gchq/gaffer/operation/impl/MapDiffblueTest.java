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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.Function;
import org.apache.commons.lang3.exception.CloneFailedException;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl;

class MapDiffblueTest {
  /**
   * Method under test: {@link Map.Builder#first(Function)}
   */
  @Test
  void testBuilderFirst() {
    // Arrange
    Map.Builder<Object> builder = new Map.Builder<>();
    Function<Object, Object> function = mock(Function.class);

    // Act
    Map.OutputBuilder<Object, Object> actualFirstResult = builder.first(function);

    // Assert
    Map<Object, Object> _getOpResult = actualFirstResult._getOp();
    TypeReference<Object> outputTypeReference = _getOpResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.Object);
    assertNull(_getOpResult.getInput());
    assertNull(_getOpResult.getOptions());
    List<Function> functions = _getOpResult.getFunctions();
    assertEquals(1, functions.size());
    Class<Object> expectedOutputClass = Object.class;
    Class<?> outputClass = _getOpResult.getOutputClass();
    assertEquals(expectedOutputClass, outputClass);
    assertSame(_getOpResult, actualFirstResult.build());
    assertSame(outputClass, outputTypeReference.getType());
    assertSame(outputClass, _getOpResult.getOutputType());
    assertSame(function, functions.get(0));
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link Map.Builder}
   */
  @Test
  void testBuilderNewBuilder() {
    // Arrange and Act
    Map.Builder<Object> actualBuilder = new Map.Builder<>();

    // Assert
    Map<Object, Object> _getOpResult = actualBuilder._getOp();
    TypeReference<Object> outputTypeReference = _getOpResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.Object);
    assertNull(_getOpResult.getInput());
    assertNull(_getOpResult.getFunctions());
    assertNull(_getOpResult.getOptions());
    Class<Object> expectedOutputClass = Object.class;
    Class<?> outputClass = _getOpResult.getOutputClass();
    assertEquals(expectedOutputClass, outputClass);
    assertSame(_getOpResult, actualBuilder.build());
    assertSame(outputClass, outputTypeReference.getType());
    assertSame(outputClass, _getOpResult.getOutputType());
  }

  /**
   * Method under test: {@link Map#getOutputTypeReference()}
   */
  @Test
  void testGetOutputTypeReference() {
    // Arrange
    Map<Object, Object> map = new Map<>();

    // Act and Assert
    assertTrue(map.getOutputTypeReference() instanceof TypeReferenceImpl.Object);
  }

  /**
   * Method under test: {@link Map#getOutputTypeReference()}
   */
  @Test
  void testGetOutputTypeReference2() {
    // Arrange
    Map<Object, Object> map = new Map<>(mock(Function.class));

    // Act and Assert
    assertTrue(map.getOutputTypeReference() instanceof TypeReferenceImpl.Object);
  }

  /**
   * Method under test: {@link Map#shallowClone()}
   */
  @Test
  void testShallowClone() throws CloneFailedException {
    // Arrange
    ArrayList<Function> funcs = new ArrayList<>();
    funcs.add(mock(Function.class));

    Map<Object, Object> map = new Map<>();
    map.setFunctions(funcs);

    // Act
    Map<Object, Object> actualShallowCloneResult = map.shallowClone();

    // Assert
    TypeReference<Object> outputTypeReference = actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.Object);
    assertNull(actualShallowCloneResult.getInput());
    assertNull(actualShallowCloneResult.getOptions());
    assertEquals(1, actualShallowCloneResult.getFunctions().size());
    Class<Object> expectedOutputClass = Object.class;
    Class<?> outputClass = actualShallowCloneResult.getOutputClass();
    assertEquals(expectedOutputClass, outputClass);
    assertSame(outputClass, outputTypeReference.getType());
    assertSame(outputClass, actualShallowCloneResult.getOutputType());
  }

  /**
   * Method under test: {@link Map#setFunction(Function)}
   */
  @Test
  void testSetFunction() {
    // Arrange
    Map<Object, Object> map = new Map<>();
    Function function = mock(Function.class);

    // Act
    map.setFunction(function);

    // Assert
    List<Function> functions = map.getFunctions();
    assertEquals(1, functions.size());
    assertSame(function, functions.get(0));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Map#Map()}
   *   <li>{@link Map#setFunctions(List)}
   *   <li>{@link Map#setInput(Object)}
   *   <li>{@link Map#setOptions(java.util.Map)}
   *   <li>{@link Map#getFunctions()}
   *   <li>{@link Map#getInput()}
   *   <li>{@link Map#getOptions()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    Map<Object, Object> actualMap = new Map<>();
    ArrayList<Function> funcs = new ArrayList<>();
    actualMap.setFunctions(funcs);
    actualMap.setInput("Input");
    HashMap<String, String> options = new HashMap<>();
    actualMap.setOptions(options);
    List<Function> actualFunctions = actualMap.getFunctions();
    Object actualInput = actualMap.getInput();
    java.util.Map<String, String> actualOptions = actualMap.getOptions();

    // Assert that nothing has changed
    assertEquals("Input", actualInput);
    assertTrue(actualFunctions.isEmpty());
    assertTrue(actualOptions.isEmpty());
    assertSame(funcs, actualFunctions);
    assertSame(options, actualOptions);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Map#Map(List)}
   *   <li>{@link Map#setFunctions(List)}
   *   <li>{@link Map#setInput(Object)}
   *   <li>{@link Map#setOptions(java.util.Map)}
   *   <li>{@link Map#getFunctions()}
   *   <li>{@link Map#getInput()}
   *   <li>{@link Map#getOptions()}
   * </ul>
   */
  @Test
  void testGettersAndSetters2() {
    // Arrange and Act
    Map<Object, Object> actualMap = new Map<>(new ArrayList<>());
    ArrayList<Function> funcs = new ArrayList<>();
    actualMap.setFunctions(funcs);
    actualMap.setInput("Input");
    HashMap<String, String> options = new HashMap<>();
    actualMap.setOptions(options);
    List<Function> actualFunctions = actualMap.getFunctions();
    Object actualInput = actualMap.getInput();
    java.util.Map<String, String> actualOptions = actualMap.getOptions();

    // Assert that nothing has changed
    assertEquals("Input", actualInput);
    assertTrue(actualFunctions.isEmpty());
    assertTrue(actualOptions.isEmpty());
    assertSame(funcs, actualFunctions);
    assertSame(options, actualOptions);
  }

  /**
   * Method under test: {@link Map#Map(Function)}
   */
  @Test
  void testNewMap() {
    // Arrange
    Function function = mock(Function.class);

    // Act
    Map<Object, Object> actualMap = new Map<>(function);

    // Assert
    TypeReference<Object> outputTypeReference = actualMap.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.Object);
    assertNull(actualMap.getInput());
    assertNull(actualMap.getOptions());
    List<Function> functions = actualMap.getFunctions();
    assertEquals(1, functions.size());
    Class<Object> expectedOutputClass = Object.class;
    Class<?> outputClass = actualMap.getOutputClass();
    assertEquals(expectedOutputClass, outputClass);
    assertSame(outputClass, outputTypeReference.getType());
    assertSame(outputClass, actualMap.getOutputType());
    assertSame(function, functions.get(0));
  }
}
