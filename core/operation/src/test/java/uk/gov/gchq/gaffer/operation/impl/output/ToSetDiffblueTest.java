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

package uk.gov.gchq.gaffer.operation.impl.output;

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
import java.util.Set;
import java.util.function.BiFunction;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl;

class ToSetDiffblueTest {
  /**
   * Method under test: default or parameterless constructor of
   * {@link ToSet.Builder}
   */
  @Test
  void testBuilderNewBuilder() {
    // Arrange and Act
    ToSet.Builder<Object> actualBuilder = new ToSet.Builder<>();

    // Assert
    ToSet<Object> _getOpResult = actualBuilder._getOp();
    TypeReference<Set<?>> outputTypeReference = _getOpResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.Set);
    Type outputType = _getOpResult.getOutputType();
    assertEquals("java.util.Set<T>", outputType.getTypeName());
    assertNull(_getOpResult.getInput());
    assertNull(_getOpResult.getOptions());
    Class<Set> expectedOutputClass = Set.class;
    assertEquals(expectedOutputClass, _getOpResult.getOutputClass());
    assertSame(_getOpResult, actualBuilder.build());
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Method under test: {@link ToSet#getOutputTypeReference()}
   */
  @Test
  void testGetOutputTypeReference() {
    // Arrange
    ToSet<Object> toSet = new ToSet<>();

    // Act
    TypeReference<Set<?>> actualOutputTypeReference = toSet.getOutputTypeReference();

    // Assert
    assertTrue(actualOutputTypeReference instanceof TypeReferenceImpl.Set);
    assertEquals("java.util.Set<T>", actualOutputTypeReference.getType().getTypeName());
  }

  /**
   * Method under test: {@link ToSet#getOutputTypeReference()}
   */
  @Test
  void testGetOutputTypeReference2() {
    // Arrange
    HashMap<String, String> options = new HashMap<>();
    options.computeIfPresent("foo", mock(BiFunction.class));

    ToSet<Object> toSet = new ToSet<>();
    toSet.setOptions(options);

    // Act
    TypeReference<Set<?>> actualOutputTypeReference = toSet.getOutputTypeReference();

    // Assert
    assertTrue(actualOutputTypeReference instanceof TypeReferenceImpl.Set);
    assertEquals("java.util.Set<T>", actualOutputTypeReference.getType().getTypeName());
  }

  /**
   * Method under test: {@link ToSet#shallowClone()}
   */
  @Test
  void testShallowClone() {
    // Arrange
    ToSet<Object> toSet = new ToSet<>();

    // Act
    ToSet actualShallowCloneResult = toSet.shallowClone();

    // Assert
    TypeReference<Set> outputTypeReference = actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.Set);
    Type outputType = actualShallowCloneResult.getOutputType();
    assertEquals("java.util.Set<T>", outputType.getTypeName());
    assertNull(actualShallowCloneResult.getInput());
    assertNull(actualShallowCloneResult.getOptions());
    Class<Set> expectedOutputClass = Set.class;
    assertEquals(expectedOutputClass, actualShallowCloneResult.getOutputClass());
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Method under test: {@link ToSet#shallowClone()}
   */
  @Test
  void testShallowClone2() {
    // Arrange
    ToSet<Object> toSet = new ToSet<>();
    toSet.setOptions(new HashMap<>());

    // Act
    ToSet actualShallowCloneResult = toSet.shallowClone();

    // Assert
    TypeReference<Set> outputTypeReference = actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.Set);
    Type outputType = actualShallowCloneResult.getOutputType();
    assertEquals("java.util.Set<T>", outputType.getTypeName());
    assertNull(actualShallowCloneResult.getInput());
    assertTrue(actualShallowCloneResult.getOptions().isEmpty());
    Class<Set> expectedOutputClass = Set.class;
    assertEquals(expectedOutputClass, actualShallowCloneResult.getOutputClass());
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Method under test: {@link ToSet#shallowClone()}
   */
  @Test
  void testShallowClone3() {
    // Arrange
    HashMap<String, String> options = new HashMap<>();
    options.computeIfPresent("foo", mock(BiFunction.class));

    ToSet<Object> toSet = new ToSet<>();
    toSet.setOptions(options);

    // Act
    ToSet actualShallowCloneResult = toSet.shallowClone();

    // Assert
    TypeReference<Set> outputTypeReference = actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.Set);
    Type outputType = actualShallowCloneResult.getOutputType();
    assertEquals("java.util.Set<T>", outputType.getTypeName());
    assertNull(actualShallowCloneResult.getInput());
    assertTrue(actualShallowCloneResult.getOptions().isEmpty());
    Class<Set> expectedOutputClass = Set.class;
    assertEquals(expectedOutputClass, actualShallowCloneResult.getOutputClass());
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link ToSet}
   *   <li>{@link ToSet#setInput(Iterable)}
   *   <li>{@link ToSet#setOptions(Map)}
   *   <li>{@link ToSet#getOptions()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    ToSet<Object> actualToSet = new ToSet<>();
    ArrayList<Object> input = new ArrayList<>();
    actualToSet.setInput(input);
    HashMap<String, String> options = new HashMap<>();
    actualToSet.setOptions(options);
    Map<String, String> actualOptions = actualToSet.getOptions();

    // Assert that nothing has changed
    Iterable<?> input2 = actualToSet.getInput();
    assertTrue(input2 instanceof List);
    assertTrue(actualOptions.isEmpty());
    assertSame(input, input2);
    assertSame(options, actualOptions);
  }
}
