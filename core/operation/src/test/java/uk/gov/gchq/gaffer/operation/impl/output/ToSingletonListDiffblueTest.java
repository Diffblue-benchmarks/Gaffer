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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import org.apache.commons.lang3.exception.CloneFailedException;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl;

class ToSingletonListDiffblueTest {
  /**
   * Method under test: default or parameterless constructor of
   * {@link ToSingletonList.Builder}
   */
  @Test
  void testBuilderNewBuilder() {
    // Arrange and Act
    ToSingletonList.Builder<Object> actualBuilder = new ToSingletonList.Builder<>();

    // Assert
    ToSingletonList<Object> _getOpResult = actualBuilder._getOp();
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
   * Method under test: {@link ToSingletonList#getOutputTypeReference()}
   */
  @Test
  void testGetOutputTypeReference() {
    // Arrange
    ToSingletonList<Object> toSingletonList = new ToSingletonList<>();

    // Act
    TypeReference<List<?>> actualOutputTypeReference = toSingletonList.getOutputTypeReference();

    // Assert
    assertTrue(actualOutputTypeReference instanceof TypeReferenceImpl.List);
    assertEquals("java.util.List<T>", actualOutputTypeReference.getType().getTypeName());
  }

  /**
   * Method under test: {@link ToSingletonList#getOutputTypeReference()}
   */
  @Test
  void testGetOutputTypeReference2() {
    // Arrange
    HashMap<String, String> options = new HashMap<>();
    options.computeIfPresent("foo", mock(BiFunction.class));

    ToSingletonList<Object> toSingletonList = new ToSingletonList<>();
    toSingletonList.setOptions(options);

    // Act
    TypeReference<List<?>> actualOutputTypeReference = toSingletonList.getOutputTypeReference();

    // Assert
    assertTrue(actualOutputTypeReference instanceof TypeReferenceImpl.List);
    assertEquals("java.util.List<T>", actualOutputTypeReference.getType().getTypeName());
  }

  /**
   * Method under test: {@link ToSingletonList#shallowClone()}
   */
  @Test
  void testShallowClone() throws CloneFailedException {
    // Arrange
    ToSingletonList<Object> toSingletonList = new ToSingletonList<>();

    // Act
    ToSingletonList<Object> actualShallowCloneResult = toSingletonList.shallowClone();

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
   * Method under test: {@link ToSingletonList#shallowClone()}
   */
  @Test
  void testShallowClone2() throws CloneFailedException {
    // Arrange
    ToSingletonList<Object> toSingletonList = new ToSingletonList<>();
    toSingletonList.setOptions(new HashMap<>());

    // Act
    ToSingletonList<Object> actualShallowCloneResult = toSingletonList.shallowClone();

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
   * Method under test: {@link ToSingletonList#shallowClone()}
   */
  @Test
  void testShallowClone3() throws CloneFailedException {
    // Arrange
    HashMap<String, String> options = new HashMap<>();
    options.computeIfPresent("foo", mock(BiFunction.class));

    ToSingletonList<Object> toSingletonList = new ToSingletonList<>();
    toSingletonList.setOptions(options);

    // Act
    ToSingletonList<Object> actualShallowCloneResult = toSingletonList.shallowClone();

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
   *   <li>default or parameterless constructor of {@link ToSingletonList}
   *   <li>{@link ToSingletonList#setInput(Object)}
   *   <li>{@link ToSingletonList#setOptions(Map)}
   *   <li>{@link ToSingletonList#getInput()}
   *   <li>{@link ToSingletonList#getOptions()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    ToSingletonList<Object> actualToSingletonList = new ToSingletonList<>();
    actualToSingletonList.setInput("Input");
    HashMap<String, String> options = new HashMap<>();
    actualToSingletonList.setOptions(options);
    Object actualInput = actualToSingletonList.getInput();
    Map<String, String> actualOptions = actualToSingletonList.getOptions();

    // Assert that nothing has changed
    assertEquals("Input", actualInput);
    assertTrue(actualOptions.isEmpty());
    assertSame(options, actualOptions);
  }
}
