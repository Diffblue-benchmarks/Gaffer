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

class ToListDiffblueTest {
  /**
   * Method under test: default or parameterless constructor of
   * {@link ToList.Builder}
   */
  @Test
  void testBuilderNewBuilder() {
    // Arrange and Act
    ToList.Builder<Object> actualBuilder = new ToList.Builder<>();

    // Assert
    ToList<Object> _getOpResult = actualBuilder._getOp();
    TypeReference<List<?>> outputTypeReference = _getOpResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.List);
    Type outputType = _getOpResult.getOutputType();
    assertEquals("java.util.List<T>", outputType.getTypeName());
    assertNull(_getOpResult.getInput());
    assertNull(_getOpResult.getOptions());
    Class<List> expectedOutputClass = List.class;
    assertEquals(expectedOutputClass, _getOpResult.getOutputClass());
    assertSame(_getOpResult, actualBuilder.build());
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Method under test: {@link ToList#getOutputTypeReference()}
   */
  @Test
  void testGetOutputTypeReference() {
    // Arrange
    ToList<Object> toList = new ToList<>();

    // Act
    TypeReference<List<?>> actualOutputTypeReference = toList.getOutputTypeReference();

    // Assert
    assertTrue(actualOutputTypeReference instanceof TypeReferenceImpl.List);
    assertEquals("java.util.List<T>", actualOutputTypeReference.getType().getTypeName());
  }

  /**
   * Method under test: {@link ToList#getOutputTypeReference()}
   */
  @Test
  void testGetOutputTypeReference2() {
    // Arrange
    HashMap<String, String> options = new HashMap<>();
    options.computeIfPresent("foo", mock(BiFunction.class));

    ToList<Object> toList = new ToList<>();
    toList.setOptions(options);

    // Act
    TypeReference<List<?>> actualOutputTypeReference = toList.getOutputTypeReference();

    // Assert
    assertTrue(actualOutputTypeReference instanceof TypeReferenceImpl.List);
    assertEquals("java.util.List<T>", actualOutputTypeReference.getType().getTypeName());
  }

  /**
   * Method under test: {@link ToList#shallowClone()}
   */
  @Test
  void testShallowClone() {
    // Arrange
    ToList<Object> toList = new ToList<>();

    // Act
    ToList<Object> actualShallowCloneResult = toList.shallowClone();

    // Assert
    TypeReference<List<?>> outputTypeReference = actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.List);
    Type outputType = actualShallowCloneResult.getOutputType();
    assertEquals("java.util.List<T>", outputType.getTypeName());
    assertNull(actualShallowCloneResult.getInput());
    assertNull(actualShallowCloneResult.getOptions());
    Class<List> expectedOutputClass = List.class;
    assertEquals(expectedOutputClass, actualShallowCloneResult.getOutputClass());
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Method under test: {@link ToList#shallowClone()}
   */
  @Test
  void testShallowClone2() {
    // Arrange
    ToList<Object> toList = new ToList<>();
    toList.setOptions(new HashMap<>());

    // Act
    ToList<Object> actualShallowCloneResult = toList.shallowClone();

    // Assert
    TypeReference<List<?>> outputTypeReference = actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.List);
    Type outputType = actualShallowCloneResult.getOutputType();
    assertEquals("java.util.List<T>", outputType.getTypeName());
    assertNull(actualShallowCloneResult.getInput());
    assertTrue(actualShallowCloneResult.getOptions().isEmpty());
    Class<List> expectedOutputClass = List.class;
    assertEquals(expectedOutputClass, actualShallowCloneResult.getOutputClass());
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Method under test: {@link ToList#shallowClone()}
   */
  @Test
  void testShallowClone3() {
    // Arrange
    HashMap<String, String> options = new HashMap<>();
    options.computeIfPresent("foo", mock(BiFunction.class));

    ToList<Object> toList = new ToList<>();
    toList.setOptions(options);

    // Act
    ToList<Object> actualShallowCloneResult = toList.shallowClone();

    // Assert
    TypeReference<List<?>> outputTypeReference = actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.List);
    Type outputType = actualShallowCloneResult.getOutputType();
    assertEquals("java.util.List<T>", outputType.getTypeName());
    assertNull(actualShallowCloneResult.getInput());
    assertTrue(actualShallowCloneResult.getOptions().isEmpty());
    Class<List> expectedOutputClass = List.class;
    assertEquals(expectedOutputClass, actualShallowCloneResult.getOutputClass());
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link ToList}
   *   <li>{@link ToList#setInput(Iterable)}
   *   <li>{@link ToList#setOptions(Map)}
   *   <li>{@link ToList#getOptions()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    ToList<Object> actualToList = new ToList<>();
    ArrayList<Object> input = new ArrayList<>();
    actualToList.setInput(input);
    HashMap<String, String> options = new HashMap<>();
    actualToList.setOptions(options);
    Map<String, String> actualOptions = actualToList.getOptions();

    // Assert that nothing has changed
    Iterable<?> input2 = actualToList.getInput();
    assertTrue(input2 instanceof List);
    assertTrue(actualOptions.isEmpty());
    assertSame(input, input2);
    assertSame(options, actualOptions);
  }
}
