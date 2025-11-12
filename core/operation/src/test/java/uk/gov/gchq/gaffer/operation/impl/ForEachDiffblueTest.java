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
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import org.apache.commons.lang3.exception.CloneFailedException;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.operation.Operation;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl;

class ForEachDiffblueTest {
  /**
   * Method under test: default or parameterless constructor of
   * {@link ForEach.Builder}
   */
  @Test
  void testBuilderNewBuilder() {
    // Arrange and Act
    ForEach.Builder<Object, Object> actualBuilder = new ForEach.Builder<>();

    // Assert
    ForEach<Object, Object> _getOpResult = actualBuilder._getOp();
    Collection<Operation> operations = _getOpResult.getOperations();
    assertTrue(operations instanceof List);
    TypeReference<Iterable<?>> outputTypeReference = _getOpResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.IterableObj);
    Type outputType = _getOpResult.getOutputType();
    assertEquals("java.lang.Iterable<?>", outputType.getTypeName());
    assertNull(_getOpResult.getInput());
    assertNull(_getOpResult.getOptions());
    assertNull(_getOpResult.getOperation());
    assertTrue(operations.isEmpty());
    Class<Iterable> expectedOutputClass = Iterable.class;
    assertEquals(expectedOutputClass, _getOpResult.getOutputClass());
    Class<Operation> expectedOperationsClass = Operation.class;
    assertEquals(expectedOperationsClass, _getOpResult.getOperationsClass());
    assertSame(_getOpResult, actualBuilder.build());
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Method under test: {@link ForEach#shallowClone()}
   */
  @Test
  void testShallowClone() throws CloneFailedException {
    // Arrange
    ForEach<Object, Object> forEach = new ForEach<>();

    // Act
    ForEach<Object, Object> actualShallowCloneResult = forEach.shallowClone();

    // Assert
    Collection<Operation> operations = actualShallowCloneResult.getOperations();
    assertTrue(operations instanceof List);
    TypeReference<Iterable<?>> outputTypeReference = actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.IterableObj);
    Type outputType = actualShallowCloneResult.getOutputType();
    assertEquals("java.lang.Iterable<?>", outputType.getTypeName());
    assertNull(actualShallowCloneResult.getInput());
    assertNull(actualShallowCloneResult.getOptions());
    assertNull(actualShallowCloneResult.getOperation());
    assertTrue(operations.isEmpty());
    Class<Iterable> expectedOutputClass = Iterable.class;
    assertEquals(expectedOutputClass, actualShallowCloneResult.getOutputClass());
    Class<Operation> expectedOperationsClass = Operation.class;
    assertEquals(expectedOperationsClass, actualShallowCloneResult.getOperationsClass());
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Method under test: {@link ForEach#shallowClone()}
   */
  @Test
  void testShallowClone2() throws CloneFailedException {
    // Arrange
    ForEach<Object, Object> forEach = new ForEach<>();
    forEach.setOptions(new HashMap<>());

    // Act
    ForEach<Object, Object> actualShallowCloneResult = forEach.shallowClone();

    // Assert
    Collection<Operation> operations = actualShallowCloneResult.getOperations();
    assertTrue(operations instanceof List);
    TypeReference<Iterable<?>> outputTypeReference = actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.IterableObj);
    Type outputType = actualShallowCloneResult.getOutputType();
    assertEquals("java.lang.Iterable<?>", outputType.getTypeName());
    assertNull(actualShallowCloneResult.getInput());
    assertNull(actualShallowCloneResult.getOperation());
    assertTrue(operations.isEmpty());
    assertTrue(actualShallowCloneResult.getOptions().isEmpty());
    Class<Iterable> expectedOutputClass = Iterable.class;
    assertEquals(expectedOutputClass, actualShallowCloneResult.getOutputClass());
    Class<Operation> expectedOperationsClass = Operation.class;
    assertEquals(expectedOperationsClass, actualShallowCloneResult.getOperationsClass());
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Method under test: {@link ForEach#shallowClone()}
   */
  @Test
  void testShallowClone3() throws CloneFailedException {
    // Arrange
    HashMap<String, String> options = new HashMap<>();
    options.computeIfPresent("foo", mock(BiFunction.class));

    ForEach<Object, Object> forEach = new ForEach<>();
    forEach.setOptions(options);

    // Act
    ForEach<Object, Object> actualShallowCloneResult = forEach.shallowClone();

    // Assert
    Collection<Operation> operations = actualShallowCloneResult.getOperations();
    assertTrue(operations instanceof List);
    TypeReference<Iterable<?>> outputTypeReference = actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.IterableObj);
    Type outputType = actualShallowCloneResult.getOutputType();
    assertEquals("java.lang.Iterable<?>", outputType.getTypeName());
    assertNull(actualShallowCloneResult.getInput());
    assertNull(actualShallowCloneResult.getOperation());
    assertTrue(operations.isEmpty());
    assertTrue(actualShallowCloneResult.getOptions().isEmpty());
    Class<Iterable> expectedOutputClass = Iterable.class;
    assertEquals(expectedOutputClass, actualShallowCloneResult.getOutputClass());
    Class<Operation> expectedOperationsClass = Operation.class;
    assertEquals(expectedOperationsClass, actualShallowCloneResult.getOperationsClass());
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Method under test: {@link ForEach#getOutputTypeReference()}
   */
  @Test
  void testGetOutputTypeReference() {
    // Arrange
    ForEach<Object, Object> forEach = new ForEach<>();

    // Act
    TypeReference<Iterable<?>> actualOutputTypeReference = forEach.getOutputTypeReference();

    // Assert
    assertTrue(actualOutputTypeReference instanceof TypeReferenceImpl.IterableObj);
    assertEquals("java.lang.Iterable<?>", actualOutputTypeReference.getType().getTypeName());
  }

  /**
   * Method under test: {@link ForEach#getOutputTypeReference()}
   */
  @Test
  void testGetOutputTypeReference2() {
    // Arrange
    HashMap<String, String> options = new HashMap<>();
    options.computeIfPresent("foo", mock(BiFunction.class));

    ForEach<Object, Object> forEach = new ForEach<>();
    forEach.setOptions(options);

    // Act
    TypeReference<Iterable<?>> actualOutputTypeReference = forEach.getOutputTypeReference();

    // Assert
    assertTrue(actualOutputTypeReference instanceof TypeReferenceImpl.IterableObj);
    assertEquals("java.lang.Iterable<?>", actualOutputTypeReference.getType().getTypeName());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link ForEach}
   *   <li>{@link ForEach#setInput(Iterable)}
   *   <li>{@link ForEach#setOptions(Map)}
   *   <li>{@link ForEach#getOperation()}
   *   <li>{@link ForEach#getOptions()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    ForEach<Object, Object> actualForEach = new ForEach<>();
    ArrayList<Object> input = new ArrayList<>();
    actualForEach.setInput(input);
    HashMap<String, String> options = new HashMap<>();
    actualForEach.setOptions(options);
    actualForEach.getOperation();
    Map<String, String> actualOptions = actualForEach.getOptions();

    // Assert that nothing has changed
    Iterable<?> input2 = actualForEach.getInput();
    assertTrue(input2 instanceof List);
    assertTrue(actualOptions.isEmpty());
    assertSame(input, input2);
    assertSame(options, actualOptions);
  }
}
