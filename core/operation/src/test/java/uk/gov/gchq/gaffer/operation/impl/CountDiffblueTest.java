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
import java.util.function.BiFunction;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl;

class CountDiffblueTest {
  /**
   * Method under test: default or parameterless constructor of
   * {@link Count.Builder}
   */
  @Test
  void testBuilderNewBuilder() {
    // Arrange and Act
    Count.Builder<Object> actualBuilder = new Count.Builder<>();

    // Assert
    Count<Object> _getOpResult = actualBuilder._getOp();
    TypeReference<Long> outputTypeReference = _getOpResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.Long);
    assertNull(_getOpResult.getInput());
    assertNull(_getOpResult.getOptions());
    Class<Long> expectedOutputClass = Long.class;
    Class<?> outputClass = _getOpResult.getOutputClass();
    assertEquals(expectedOutputClass, outputClass);
    assertSame(_getOpResult, actualBuilder.build());
    assertSame(outputClass, outputTypeReference.getType());
    assertSame(outputClass, _getOpResult.getOutputType());
  }

  /**
   * Method under test: {@link Count#getOutputTypeReference()}
   */
  @Test
  void testGetOutputTypeReference() {
    // Arrange
    Count<Object> count = new Count<>();

    // Act and Assert
    assertTrue(count.getOutputTypeReference() instanceof TypeReferenceImpl.Long);
  }

  /**
   * Method under test: {@link Count#getOutputTypeReference()}
   */
  @Test
  void testGetOutputTypeReference2() {
    // Arrange
    HashMap<String, String> options = new HashMap<>();
    options.computeIfPresent("foo", mock(BiFunction.class));

    Count<Object> count = new Count<>();
    count.setOptions(options);

    // Act and Assert
    assertTrue(count.getOutputTypeReference() instanceof TypeReferenceImpl.Long);
  }

  /**
   * Method under test: {@link Count#shallowClone()}
   */
  @Test
  void testShallowClone() {
    // Arrange
    Count<Object> count = new Count<>();

    // Act
    Count actualShallowCloneResult = count.shallowClone();

    // Assert
    TypeReference<Long> outputTypeReference = actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.Long);
    assertNull(actualShallowCloneResult.getInput());
    assertNull(actualShallowCloneResult.getOptions());
    Class<Long> expectedOutputClass = Long.class;
    Class<?> outputClass = actualShallowCloneResult.getOutputClass();
    assertEquals(expectedOutputClass, outputClass);
    assertSame(outputClass, outputTypeReference.getType());
    assertSame(outputClass, actualShallowCloneResult.getOutputType());
  }

  /**
   * Method under test: {@link Count#shallowClone()}
   */
  @Test
  void testShallowClone2() {
    // Arrange
    Count<Object> count = new Count<>();
    count.setOptions(new HashMap<>());

    // Act
    Count actualShallowCloneResult = count.shallowClone();

    // Assert
    TypeReference<Long> outputTypeReference = actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.Long);
    assertNull(actualShallowCloneResult.getInput());
    assertTrue(actualShallowCloneResult.getOptions().isEmpty());
    Class<Long> expectedOutputClass = Long.class;
    Class<?> outputClass = actualShallowCloneResult.getOutputClass();
    assertEquals(expectedOutputClass, outputClass);
    assertSame(outputClass, outputTypeReference.getType());
    assertSame(outputClass, actualShallowCloneResult.getOutputType());
  }

  /**
   * Method under test: {@link Count#shallowClone()}
   */
  @Test
  void testShallowClone3() {
    // Arrange
    HashMap<String, String> options = new HashMap<>();
    options.computeIfPresent("foo", mock(BiFunction.class));

    Count<Object> count = new Count<>();
    count.setOptions(options);

    // Act
    Count actualShallowCloneResult = count.shallowClone();

    // Assert
    TypeReference<Long> outputTypeReference = actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.Long);
    assertNull(actualShallowCloneResult.getInput());
    assertTrue(actualShallowCloneResult.getOptions().isEmpty());
    Class<Long> expectedOutputClass = Long.class;
    Class<?> outputClass = actualShallowCloneResult.getOutputClass();
    assertEquals(expectedOutputClass, outputClass);
    assertSame(outputClass, outputTypeReference.getType());
    assertSame(outputClass, actualShallowCloneResult.getOutputType());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Count}
   *   <li>{@link Count#setInput(Iterable)}
   *   <li>{@link Count#setOptions(Map)}
   *   <li>{@link Count#getOptions()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    Count<Object> actualCount = new Count<>();
    ArrayList<Object> input = new ArrayList<>();
    actualCount.setInput(input);
    HashMap<String, String> options = new HashMap<>();
    actualCount.setOptions(options);
    Map<String, String> actualOptions = actualCount.getOptions();

    // Assert that nothing has changed
    Iterable<?> input2 = actualCount.getInput();
    assertTrue(input2 instanceof List);
    assertTrue(actualOptions.isEmpty());
    assertSame(input, input2);
    assertSame(options, actualOptions);
  }
}
