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
import static org.junit.jupiter.api.Assertions.assertFalse;
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
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl;

class LimitDiffblueTest {
  /**
   * Method under test: default or parameterless constructor of
   * {@link Limit.Builder}
   */
  @Test
  void testBuilderNewBuilder() {
    // Arrange and Act
    Limit.Builder<Object> actualBuilder = new Limit.Builder<>();

    // Assert
    Limit<Object> _getOpResult = actualBuilder._getOp();
    TypeReference<Iterable<?>> outputTypeReference = _getOpResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.IterableObj);
    Type outputType = _getOpResult.getOutputType();
    assertEquals("java.lang.Iterable<?>", outputType.getTypeName());
    assertNull(_getOpResult.getResultLimit());
    assertNull(_getOpResult.getInput());
    assertNull(_getOpResult.getOptions());
    assertTrue(_getOpResult.getTruncate());
    Class<Iterable> expectedOutputClass = Iterable.class;
    assertEquals(expectedOutputClass, _getOpResult.getOutputClass());
    assertSame(_getOpResult, actualBuilder.build());
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Method under test: {@link Limit.Builder#resultLimit(Integer)}
   */
  @Test
  void testBuilderResultLimit() {
    // Arrange
    Limit.Builder<Object> builder = new Limit.Builder<>();

    // Act and Assert
    assertSame(builder, builder.resultLimit(1));
  }

  /**
   * Method under test: {@link Limit.Builder#truncate(Boolean)}
   */
  @Test
  void testBuilderTruncate() {
    // Arrange
    Limit.Builder<Object> builder = new Limit.Builder<>();

    // Act and Assert
    assertSame(builder, builder.truncate(true));
  }

  /**
   * Method under test: {@link Limit#getTruncate()}
   */
  @Test
  void testGetTruncate() {
    // Arrange
    Limit<Object> limit = new Limit<>();

    // Act and Assert
    assertTrue(limit.getTruncate());
  }

  /**
   * Method under test: {@link Limit#getTruncate()}
   */
  @Test
  void testGetTruncate2() {
    // Arrange
    Limit<Object> limit = new Limit<>(1, false);

    // Act and Assert
    assertFalse(limit.getTruncate());
  }

  /**
   * Method under test: {@link Limit#getTruncate()}
   */
  @Test
  void testGetTruncate3() {
    // Arrange
    HashMap<String, String> options = new HashMap<>();
    options.computeIfPresent("foo", mock(BiFunction.class));

    Limit<Object> limit = new Limit<>();
    limit.setOptions(options);

    // Act and Assert
    assertTrue(limit.getTruncate());
  }

  /**
   * Method under test: {@link Limit#getOutputTypeReference()}
   */
  @Test
  void testGetOutputTypeReference() {
    // Arrange
    Limit<Object> limit = new Limit<>();

    // Act
    TypeReference<Iterable<?>> actualOutputTypeReference = limit.getOutputTypeReference();

    // Assert
    assertTrue(actualOutputTypeReference instanceof TypeReferenceImpl.IterableObj);
    assertEquals("java.lang.Iterable<?>", actualOutputTypeReference.getType().getTypeName());
  }

  /**
   * Method under test: {@link Limit#getOutputTypeReference()}
   */
  @Test
  void testGetOutputTypeReference2() {
    // Arrange
    HashMap<String, String> options = new HashMap<>();
    options.computeIfPresent("foo", mock(BiFunction.class));

    Limit<Object> limit = new Limit<>();
    limit.setOptions(options);

    // Act
    TypeReference<Iterable<?>> actualOutputTypeReference = limit.getOutputTypeReference();

    // Assert
    assertTrue(actualOutputTypeReference instanceof TypeReferenceImpl.IterableObj);
    assertEquals("java.lang.Iterable<?>", actualOutputTypeReference.getType().getTypeName());
  }

  /**
   * Method under test: {@link Limit#shallowClone()}
   */
  @Test
  void testShallowClone() {
    // Arrange
    Limit<Object> limit = new Limit<>();

    // Act
    Limit<Object> actualShallowCloneResult = limit.shallowClone();

    // Assert
    TypeReference<Iterable<?>> outputTypeReference = actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.IterableObj);
    Type outputType = actualShallowCloneResult.getOutputType();
    assertEquals("java.lang.Iterable<?>", outputType.getTypeName());
    assertNull(actualShallowCloneResult.getResultLimit());
    assertNull(actualShallowCloneResult.getInput());
    assertNull(actualShallowCloneResult.getOptions());
    assertTrue(actualShallowCloneResult.getTruncate());
    Class<Iterable> expectedOutputClass = Iterable.class;
    assertEquals(expectedOutputClass, actualShallowCloneResult.getOutputClass());
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Method under test: {@link Limit#shallowClone()}
   */
  @Test
  void testShallowClone2() {
    // Arrange
    Limit<Object> limit = new Limit<>();
    limit.setOptions(new HashMap<>());

    // Act
    Limit<Object> actualShallowCloneResult = limit.shallowClone();

    // Assert
    TypeReference<Iterable<?>> outputTypeReference = actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.IterableObj);
    Type outputType = actualShallowCloneResult.getOutputType();
    assertEquals("java.lang.Iterable<?>", outputType.getTypeName());
    assertNull(actualShallowCloneResult.getResultLimit());
    assertNull(actualShallowCloneResult.getInput());
    assertTrue(actualShallowCloneResult.getOptions().isEmpty());
    assertTrue(actualShallowCloneResult.getTruncate());
    Class<Iterable> expectedOutputClass = Iterable.class;
    assertEquals(expectedOutputClass, actualShallowCloneResult.getOutputClass());
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Method under test: {@link Limit#shallowClone()}
   */
  @Test
  void testShallowClone3() {
    // Arrange
    HashMap<String, String> options = new HashMap<>();
    options.computeIfPresent("foo", mock(BiFunction.class));

    Limit<Object> limit = new Limit<>();
    limit.setOptions(options);

    // Act
    Limit<Object> actualShallowCloneResult = limit.shallowClone();

    // Assert
    TypeReference<Iterable<?>> outputTypeReference = actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.IterableObj);
    Type outputType = actualShallowCloneResult.getOutputType();
    assertEquals("java.lang.Iterable<?>", outputType.getTypeName());
    assertNull(actualShallowCloneResult.getResultLimit());
    assertNull(actualShallowCloneResult.getInput());
    assertTrue(actualShallowCloneResult.getOptions().isEmpty());
    assertTrue(actualShallowCloneResult.getTruncate());
    Class<Iterable> expectedOutputClass = Iterable.class;
    assertEquals(expectedOutputClass, actualShallowCloneResult.getOutputClass());
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Limit#Limit()}
   *   <li>{@link Limit#setInput(Iterable)}
   *   <li>{@link Limit#setOptions(Map)}
   *   <li>{@link Limit#setResultLimit(Integer)}
   *   <li>{@link Limit#setTruncate(boolean)}
   *   <li>{@link Limit#getOptions()}
   *   <li>{@link Limit#getResultLimit()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    Limit<Object> actualLimit = new Limit<>();
    ArrayList<Object> input = new ArrayList<>();
    actualLimit.setInput(input);
    HashMap<String, String> options = new HashMap<>();
    actualLimit.setOptions(options);
    actualLimit.setResultLimit(1);
    actualLimit.setTruncate(true);
    Map<String, String> actualOptions = actualLimit.getOptions();
    Integer actualResultLimit = actualLimit.getResultLimit();

    // Assert that nothing has changed
    Iterable<?> input2 = actualLimit.getInput();
    assertTrue(input2 instanceof List);
    assertEquals(1, actualResultLimit.intValue());
    assertTrue(actualOptions.isEmpty());
    assertSame(input, input2);
    assertSame(options, actualOptions);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Limit#Limit(Integer)}
   *   <li>{@link Limit#setInput(Iterable)}
   *   <li>{@link Limit#setOptions(Map)}
   *   <li>{@link Limit#setResultLimit(Integer)}
   *   <li>{@link Limit#setTruncate(boolean)}
   *   <li>{@link Limit#getOptions()}
   *   <li>{@link Limit#getResultLimit()}
   * </ul>
   */
  @Test
  void testGettersAndSetters2() {
    // Arrange and Act
    Limit<Object> actualLimit = new Limit<>(1);
    ArrayList<Object> input = new ArrayList<>();
    actualLimit.setInput(input);
    HashMap<String, String> options = new HashMap<>();
    actualLimit.setOptions(options);
    actualLimit.setResultLimit(1);
    actualLimit.setTruncate(true);
    Map<String, String> actualOptions = actualLimit.getOptions();
    Integer actualResultLimit = actualLimit.getResultLimit();

    // Assert that nothing has changed
    Iterable<?> input2 = actualLimit.getInput();
    assertTrue(input2 instanceof List);
    assertEquals(1, actualResultLimit.intValue());
    assertTrue(actualOptions.isEmpty());
    assertSame(input, input2);
    assertSame(options, actualOptions);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Limit#Limit(Integer, boolean)}
   *   <li>{@link Limit#setInput(Iterable)}
   *   <li>{@link Limit#setOptions(Map)}
   *   <li>{@link Limit#setResultLimit(Integer)}
   *   <li>{@link Limit#setTruncate(boolean)}
   *   <li>{@link Limit#getOptions()}
   *   <li>{@link Limit#getResultLimit()}
   * </ul>
   */
  @Test
  void testGettersAndSetters3() {
    // Arrange and Act
    Limit<Object> actualLimit = new Limit<>(1, true);
    ArrayList<Object> input = new ArrayList<>();
    actualLimit.setInput(input);
    HashMap<String, String> options = new HashMap<>();
    actualLimit.setOptions(options);
    actualLimit.setResultLimit(1);
    actualLimit.setTruncate(true);
    Map<String, String> actualOptions = actualLimit.getOptions();
    Integer actualResultLimit = actualLimit.getResultLimit();

    // Assert that nothing has changed
    Iterable<?> input2 = actualLimit.getInput();
    assertTrue(input2 instanceof List);
    assertEquals(1, actualResultLimit.intValue());
    assertTrue(actualOptions.isEmpty());
    assertSame(input, input2);
    assertSame(options, actualOptions);
  }
}
