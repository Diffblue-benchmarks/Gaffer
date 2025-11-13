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
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import org.apache.commons.lang3.exception.CloneFailedException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.operation.impl.Reduce.Builder;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl;

class ReduceDiffblueTest {
  /**
   * Test Builder {@link Builder#aggregateFunction(BinaryOperator)}.
   * <ul>
   *   <li>Then return _getOp AggregateFunction is {@link BinaryOperator}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#aggregateFunction(BinaryOperator)}
   */
  @Test
  @DisplayName("Test Builder aggregateFunction(BinaryOperator); then return _getOp AggregateFunction is BinaryOperator")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.aggregateFunction(BinaryOperator)"})
  void testBuilderAggregateFunction_thenReturn_getOpAggregateFunctionIsBinaryOperator() {
    // Arrange
    Builder<Object> builder = new Builder<>();
    BinaryOperator aggregateFunction = mock(BinaryOperator.class);

    // Act
    Builder<Object> actualAggregateFunctionResult = builder.aggregateFunction(aggregateFunction);

    // Assert
    Reduce<Object> _getOpResult = actualAggregateFunctionResult._getOp();
    assertTrue(_getOpResult.getOutputTypeReference() instanceof TypeReferenceImpl.Object);
    assertSame(_getOpResult, actualAggregateFunctionResult.build());
    assertSame(aggregateFunction, _getOpResult.getAggregateFunction());
  }

  /**
   * Test Builder {@link Builder#aggregateFunction(BinaryOperator)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return _getOp AggregateFunction is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#aggregateFunction(BinaryOperator)}
   */
  @Test
  @DisplayName("Test Builder aggregateFunction(BinaryOperator); when 'null'; then return _getOp AggregateFunction is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.aggregateFunction(BinaryOperator)"})
  void testBuilderAggregateFunction_whenNull_thenReturn_getOpAggregateFunctionIsNull() {
    // Arrange
    Builder<Object> builder = new Builder<>();

    // Act
    Builder<Object> actualAggregateFunctionResult = builder.aggregateFunction(null);

    // Assert
    Reduce<Object> _getOpResult = actualAggregateFunctionResult._getOp();
    assertTrue(_getOpResult.getOutputTypeReference() instanceof TypeReferenceImpl.Object);
    assertNull(_getOpResult.getAggregateFunction());
    assertSame(_getOpResult, actualAggregateFunctionResult.build());
  }

  /**
   * Test Builder {@link Builder#identity(Object)}.
   * <ul>
   *   <li>When {@code Identity}.</li>
   *   <li>Then return _getOp Identity is {@code Identity}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#identity(Object)}
   */
  @Test
  @DisplayName("Test Builder identity(Object); when 'Identity'; then return _getOp Identity is 'Identity'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.identity(Object)"})
  void testBuilderIdentity_whenIdentity_thenReturn_getOpIdentityIsIdentity() {
    // Arrange
    Builder<Object> builder = new Builder<>();

    // Act
    Builder<Object> actualIdentityResult = builder.identity("Identity");

    // Assert
    Reduce<Object> _getOpResult = actualIdentityResult._getOp();
    assertTrue(_getOpResult.getOutputTypeReference() instanceof TypeReferenceImpl.Object);
    assertEquals("Identity", _getOpResult.getIdentity());
    assertSame(_getOpResult, actualIdentityResult.build());
  }

  /**
   * Test Builder {@link Builder#identity(Object)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return _getOp Identity is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#identity(Object)}
   */
  @Test
  @DisplayName("Test Builder identity(Object); when 'null'; then return _getOp Identity is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.identity(Object)"})
  void testBuilderIdentity_whenNull_thenReturn_getOpIdentityIsNull() {
    // Arrange
    Builder<Object> builder = new Builder<>();

    // Act
    Builder<Object> actualIdentityResult = builder.identity(null);

    // Assert
    Reduce<Object> _getOpResult = actualIdentityResult._getOp();
    assertTrue(_getOpResult.getOutputTypeReference() instanceof TypeReferenceImpl.Object);
    assertNull(_getOpResult.getIdentity());
    assertSame(_getOpResult, actualIdentityResult.build());
  }

  /**
   * Test Builder new {@link Builder} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link Builder}
   */
  @Test
  @DisplayName("Test Builder new Builder (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Builder.<init>()"})
  void testBuilderNewBuilder() {
    // Arrange and Act
    Builder<Object> actualBuilder = new Builder<>();

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
   * Test getters and setters.
   * <p>
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
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Reduce.<init>()", "void Reduce.<init>(BinaryOperator)",
      "BinaryOperator Reduce.getAggregateFunction()", "Object Reduce.getIdentity()", "Map Reduce.getOptions()",
      "void Reduce.setAggregateFunction(BinaryOperator)", "void Reduce.setIdentity(Object)",
      "void Reduce.setInput(Iterable)", "void Reduce.setOptions(Map)"})
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

    // Assert
    Iterable<?> input2 = actualReduce.getInput();
    assertTrue(input2 instanceof List);
    assertEquals("Identity", actualIdentity);
    assertTrue(actualOptions.isEmpty());
    assertSame(input, input2);
    assertSame(options, actualOptions);
    assertSame(aggregateFunction, actualAggregateFunction);
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@link BinaryOperator}.</li>
   * </ul>
   * <p>
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
  @DisplayName("Test getters and setters; when BinaryOperator")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Reduce.<init>()", "void Reduce.<init>(BinaryOperator)",
      "BinaryOperator Reduce.getAggregateFunction()", "Object Reduce.getIdentity()", "Map Reduce.getOptions()",
      "void Reduce.setAggregateFunction(BinaryOperator)", "void Reduce.setIdentity(Object)",
      "void Reduce.setInput(Iterable)", "void Reduce.setOptions(Map)"})
  void testGettersAndSetters_whenBinaryOperator() {
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

    // Assert
    Iterable<?> input2 = actualReduce.getInput();
    assertTrue(input2 instanceof List);
    assertEquals("Identity", actualIdentity);
    assertTrue(actualOptions.isEmpty());
    assertSame(input, input2);
    assertSame(options, actualOptions);
    assertSame(aggregateFunction, actualAggregateFunction);
  }

  /**
   * Test {@link Reduce#getOutputTypeReference()}.
   * <p>
   * Method under test: {@link Reduce#getOutputTypeReference()}
   */
  @Test
  @DisplayName("Test getOutputTypeReference()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TypeReference Reduce.getOutputTypeReference()"})
  void testGetOutputTypeReference() {
    // Arrange
    Reduce<Object> reduce = new Reduce<>();

    // Act and Assert
    assertTrue(reduce.getOutputTypeReference() instanceof TypeReferenceImpl.Object);
  }

  /**
   * Test {@link Reduce#shallowClone()}.
   * <p>
   * Method under test: {@link Reduce#shallowClone()}
   */
  @Test
  @DisplayName("Test shallowClone()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Reduce Reduce.shallowClone()"})
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
}
