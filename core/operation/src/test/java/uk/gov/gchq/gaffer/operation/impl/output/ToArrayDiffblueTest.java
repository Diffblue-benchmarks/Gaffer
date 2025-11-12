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
import java.util.function.BiFunction;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl;

class ToArrayDiffblueTest {
  /**
   * Method under test: default or parameterless constructor of
   * {@link ToArray.Builder}
   */
  @Test
  void testBuilderNewBuilder() {
    // Arrange and Act
    ToArray.Builder<Object> actualBuilder = new ToArray.Builder<>();

    // Assert
    ToArray<Object> _getOpResult = actualBuilder._getOp();
    TypeReference<Object[]> outputTypeReference = _getOpResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.Array);
    Type outputType = _getOpResult.getOutputType();
    assertEquals("T[]", outputType.getTypeName());
    assertNull(_getOpResult.getInput());
    assertNull(_getOpResult.getOptions());
    Class<Object> expectedOutputClass = Object.class;
    assertEquals(expectedOutputClass, _getOpResult.getOutputClass());
    assertSame(_getOpResult, actualBuilder.build());
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Method under test: {@link ToArray#getOutputTypeReference()}
   */
  @Test
  void testGetOutputTypeReference() {
    // Arrange
    ToArray<Object> toArray = new ToArray<>();

    // Act
    TypeReference<Object[]> actualOutputTypeReference = toArray.getOutputTypeReference();

    // Assert
    assertTrue(actualOutputTypeReference instanceof TypeReferenceImpl.Array);
    assertEquals("T[]", actualOutputTypeReference.getType().getTypeName());
  }

  /**
   * Method under test: {@link ToArray#getOutputTypeReference()}
   */
  @Test
  void testGetOutputTypeReference2() {
    // Arrange
    HashMap<String, String> options = new HashMap<>();
    options.computeIfPresent("foo", mock(BiFunction.class));

    ToArray<Object> toArray = new ToArray<>();
    toArray.setOptions(options);

    // Act
    TypeReference<Object[]> actualOutputTypeReference = toArray.getOutputTypeReference();

    // Assert
    assertTrue(actualOutputTypeReference instanceof TypeReferenceImpl.Array);
    assertEquals("T[]", actualOutputTypeReference.getType().getTypeName());
  }

  /**
   * Method under test: {@link ToArray#shallowClone()}
   */
  @Test
  void testShallowClone() {
    // Arrange
    ToArray<Object> toArray = new ToArray<>();

    // Act
    ToArray<Object> actualShallowCloneResult = toArray.shallowClone();

    // Assert
    TypeReference<Object[]> outputTypeReference = actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.Array);
    Type outputType = actualShallowCloneResult.getOutputType();
    assertEquals("T[]", outputType.getTypeName());
    assertNull(actualShallowCloneResult.getInput());
    assertNull(actualShallowCloneResult.getOptions());
    Class<Object> expectedOutputClass = Object.class;
    assertEquals(expectedOutputClass, actualShallowCloneResult.getOutputClass());
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Method under test: {@link ToArray#shallowClone()}
   */
  @Test
  void testShallowClone2() {
    // Arrange
    ToArray<Object> toArray = new ToArray<>();
    toArray.setOptions(new HashMap<>());

    // Act
    ToArray<Object> actualShallowCloneResult = toArray.shallowClone();

    // Assert
    TypeReference<Object[]> outputTypeReference = actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.Array);
    Type outputType = actualShallowCloneResult.getOutputType();
    assertEquals("T[]", outputType.getTypeName());
    assertNull(actualShallowCloneResult.getInput());
    assertTrue(actualShallowCloneResult.getOptions().isEmpty());
    Class<Object> expectedOutputClass = Object.class;
    assertEquals(expectedOutputClass, actualShallowCloneResult.getOutputClass());
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Method under test: {@link ToArray#shallowClone()}
   */
  @Test
  void testShallowClone3() {
    // Arrange
    HashMap<String, String> options = new HashMap<>();
    options.computeIfPresent("foo", mock(BiFunction.class));

    ToArray<Object> toArray = new ToArray<>();
    toArray.setOptions(options);

    // Act
    ToArray<Object> actualShallowCloneResult = toArray.shallowClone();

    // Assert
    TypeReference<Object[]> outputTypeReference = actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.Array);
    Type outputType = actualShallowCloneResult.getOutputType();
    assertEquals("T[]", outputType.getTypeName());
    assertNull(actualShallowCloneResult.getInput());
    assertTrue(actualShallowCloneResult.getOptions().isEmpty());
    Class<Object> expectedOutputClass = Object.class;
    assertEquals(expectedOutputClass, actualShallowCloneResult.getOutputClass());
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link ToArray}
   *   <li>{@link ToArray#setInput(Iterable)}
   *   <li>{@link ToArray#setOptions(Map)}
   *   <li>{@link ToArray#getOptions()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    ToArray<Object> actualToArray = new ToArray<>();
    ArrayList<Object> input = new ArrayList<>();
    actualToArray.setInput(input);
    HashMap<String, String> options = new HashMap<>();
    actualToArray.setOptions(options);
    Map<String, String> actualOptions = actualToArray.getOptions();

    // Assert that nothing has changed
    Iterable<?> input2 = actualToArray.getInput();
    assertTrue(input2 instanceof List);
    assertTrue(actualOptions.isEmpty());
    assertSame(input, input2);
    assertSame(options, actualOptions);
  }
}
