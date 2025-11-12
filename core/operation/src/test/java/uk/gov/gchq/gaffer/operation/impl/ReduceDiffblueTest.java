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
import java.util.Map;
import java.util.function.BinaryOperator;
import org.apache.commons.lang3.exception.CloneFailedException;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl;

class ReduceDiffblueTest {
  /**
   * Method under test: {@link Reduce.Builder#aggregateFunction(BinaryOperator)}
   */
  @Test
  void testBuilderAggregateFunction() {
    // Arrange
    Reduce.Builder<Object> builder = new Reduce.Builder<>();

    // Act and Assert
    assertSame(builder, builder.aggregateFunction(mock(BinaryOperator.class)));
  }

  /**
   * Method under test: {@link Reduce.Builder#aggregateFunction(BinaryOperator)}
   */
  @Test
  void testBuilderAggregateFunction2() {
    // Arrange
    Reduce.Builder<Object> builder = new Reduce.Builder<>();

    // Act and Assert
    assertSame(builder, builder.aggregateFunction(null));
  }

  /**
   * Method under test: {@link Reduce.Builder#identity(Object)}
   */
  @Test
  void testBuilderIdentity() {
    // Arrange
    Reduce.Builder<Object> builder = new Reduce.Builder<>();

    // Act and Assert
    assertSame(builder, builder.identity("Identity"));
  }

  /**
   * Method under test: {@link Reduce.Builder#identity(Object)}
   */
  @Test
  void testBuilderIdentity2() {
    // Arrange
    Reduce.Builder<Object> builder = new Reduce.Builder<>();

    // Act and Assert
    assertSame(builder, builder.identity(null));
  }

  /**
   * Method under test: {@link Reduce.Builder#identity(Object)}
   */
  @Test
  void testBuilderIdentity3() {
    // Arrange
    Reduce.Builder<Object> builder = new Reduce.Builder<>();

    // Act and Assert
    assertSame(builder, builder.identity(new Reduce<>(mock(BinaryOperator.class))));
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link Reduce.Builder}
   */
  @Test
  void testBuilderNewBuilder() {
    // Arrange and Act
    Reduce.Builder<Object> actualBuilder = new Reduce.Builder<>();

    // Assert
    Reduce<Object> _getOpResult = actualBuilder._getOp();
    TypeReference<Object> outputTypeReference = _getOpResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.Object);
    assertNull(_getOpResult.getInput());
    assertNull(_getOpResult.getIdentity());
    assertNull(_getOpResult.getOptions());
    assertNull(_getOpResult.getAggregateFunction());
    Class<Object> expectedOutputClass = Object.class;
    Class<?> outputClass = _getOpResult.getOutputClass();
    assertEquals(expectedOutputClass, outputClass);
    assertSame(_getOpResult, actualBuilder.build());
    assertSame(outputClass, outputTypeReference.getType());
    assertSame(outputClass, _getOpResult.getOutputType());
  }

  /**
   * Method under test: {@link Reduce#getOutputTypeReference()}
   */
  @Test
  void testGetOutputTypeReference() {
    // Arrange
    Reduce<Object> reduce = new Reduce<>();

    // Act and Assert
    assertTrue(reduce.getOutputTypeReference() instanceof TypeReferenceImpl.Object);
  }

  /**
   * Method under test: {@link Reduce#getOutputTypeReference()}
   */
  @Test
  void testGetOutputTypeReference2() {
    // Arrange
    Reduce<Object> reduce = new Reduce<>(mock(BinaryOperator.class));

    // Act and Assert
    assertTrue(reduce.getOutputTypeReference() instanceof TypeReferenceImpl.Object);
  }

  /**
   * Method under test: {@link Reduce#shallowClone()}
   */
  @Test
  void testShallowClone() throws CloneFailedException {
    // Arrange
    Reduce<Object> reduce = new Reduce<>();

    // Act
    Reduce<Object> actualShallowCloneResult = reduce.shallowClone();

    // Assert
    TypeReference<Object> outputTypeReference = actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.Object);
    assertNull(actualShallowCloneResult.getInput());
    assertNull(actualShallowCloneResult.getIdentity());
    assertNull(actualShallowCloneResult.getOptions());
    assertNull(actualShallowCloneResult.getAggregateFunction());
    Class<Object> expectedOutputClass = Object.class;
    Class<?> outputClass = actualShallowCloneResult.getOutputClass();
    assertEquals(expectedOutputClass, outputClass);
    assertSame(outputClass, outputTypeReference.getType());
    assertSame(outputClass, actualShallowCloneResult.getOutputType());
  }

  /**
   * Method under test: {@link Reduce#shallowClone()}
   */
  @Test
  void testShallowClone2() throws CloneFailedException {
    // Arrange
    Reduce<Object> reduce = new Reduce<>();
    reduce.setAggregateFunction(mock(BinaryOperator.class));

    // Act
    Reduce<Object> actualShallowCloneResult = reduce.shallowClone();

    // Assert
    TypeReference<Object> outputTypeReference = actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.Object);
    assertNull(actualShallowCloneResult.getInput());
    assertNull(actualShallowCloneResult.getIdentity());
    assertNull(actualShallowCloneResult.getOptions());
    Class<Object> expectedOutputClass = Object.class;
    Class<?> outputClass = actualShallowCloneResult.getOutputClass();
    assertEquals(expectedOutputClass, outputClass);
    assertSame(outputClass, outputTypeReference.getType());
    assertSame(outputClass, actualShallowCloneResult.getOutputType());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Reduce#Reduce()}
   *   <li>{@link Reduce#setAggregateFunction(BinaryOperator)}
   *   <li>{@link Reduce#setIdentity(Object)}
   *   <li>{@link Reduce#setInput(Iterable)}
   *   <li>{@link Reduce#setOptions(Map)}
   *   <li>{@link Reduce#getAggregateFunction()}
   *   <li>{@link Reduce#getIdentity()}
   *   <li>{@link Reduce#getOptions()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    Reduce<Object> actualReduce = new Reduce<>();
    BinaryOperator<Object> aggregateFunction = mock(BinaryOperator.class);
    actualReduce.setAggregateFunction(aggregateFunction);
    actualReduce.setIdentity("Identity");
    ArrayList<Object> input = new ArrayList<>();
    actualReduce.setInput(input);
    HashMap<String, String> options = new HashMap<>();
    actualReduce.setOptions(options);
    BinaryOperator<Object> actualAggregateFunction = actualReduce.getAggregateFunction();
    Object actualIdentity = actualReduce.getIdentity();
    Map<String, String> actualOptions = actualReduce.getOptions();

    // Assert that nothing has changed
    Iterable<?> input2 = actualReduce.getInput();
    assertTrue(input2 instanceof List);
    assertEquals("Identity", actualIdentity);
    assertTrue(actualOptions.isEmpty());
    assertSame(input, input2);
    assertSame(options, actualOptions);
    assertSame(aggregateFunction, actualAggregateFunction);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Reduce#Reduce(BinaryOperator)}
   *   <li>{@link Reduce#setAggregateFunction(BinaryOperator)}
   *   <li>{@link Reduce#setIdentity(Object)}
   *   <li>{@link Reduce#setInput(Iterable)}
   *   <li>{@link Reduce#setOptions(Map)}
   *   <li>{@link Reduce#getAggregateFunction()}
   *   <li>{@link Reduce#getIdentity()}
   *   <li>{@link Reduce#getOptions()}
   * </ul>
   */
  @Test
  void testGettersAndSetters2() {
    // Arrange and Act
    Reduce<Object> actualReduce = new Reduce<>(mock(BinaryOperator.class));
    BinaryOperator<Object> aggregateFunction = mock(BinaryOperator.class);
    actualReduce.setAggregateFunction(aggregateFunction);
    actualReduce.setIdentity("Identity");
    ArrayList<Object> input = new ArrayList<>();
    actualReduce.setInput(input);
    HashMap<String, String> options = new HashMap<>();
    actualReduce.setOptions(options);
    BinaryOperator<Object> actualAggregateFunction = actualReduce.getAggregateFunction();
    Object actualIdentity = actualReduce.getIdentity();
    Map<String, String> actualOptions = actualReduce.getOptions();

    // Assert that nothing has changed
    Iterable<?> input2 = actualReduce.getInput();
    assertTrue(input2 instanceof List);
    assertEquals("Identity", actualIdentity);
    assertTrue(actualOptions.isEmpty());
    assertSame(input, input2);
    assertSame(options, actualOptions);
    assertSame(aggregateFunction, actualAggregateFunction);
  }
}
