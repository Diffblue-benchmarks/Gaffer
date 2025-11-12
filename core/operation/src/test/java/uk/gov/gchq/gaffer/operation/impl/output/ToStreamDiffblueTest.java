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
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl;

class ToStreamDiffblueTest {
  /**
   * Method under test: default or parameterless constructor of
   * {@link ToStream.Builder}
   */
  @Test
  void testBuilderNewBuilder() {
    // Arrange and Act
    ToStream.Builder<Object> actualBuilder = new ToStream.Builder<>();

    // Assert
    ToStream<Object> _getOpResult = actualBuilder._getOp();
    TypeReference<Stream<?>> outputTypeReference = _getOpResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.Stream);
    Type outputType = _getOpResult.getOutputType();
    assertEquals("java.util.stream.Stream<T>", outputType.getTypeName());
    assertNull(_getOpResult.getInput());
    assertNull(_getOpResult.getOptions());
    Class<Stream> expectedOutputClass = Stream.class;
    assertEquals(expectedOutputClass, _getOpResult.getOutputClass());
    assertSame(_getOpResult, actualBuilder.build());
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Method under test: {@link ToStream#getOutputTypeReference()}
   */
  @Test
  void testGetOutputTypeReference() {
    // Arrange
    ToStream<Object> toStream = new ToStream<>();

    // Act
    TypeReference<Stream<?>> actualOutputTypeReference = toStream.getOutputTypeReference();

    // Assert
    assertTrue(actualOutputTypeReference instanceof TypeReferenceImpl.Stream);
    assertEquals("java.util.stream.Stream<T>", actualOutputTypeReference.getType().getTypeName());
  }

  /**
   * Method under test: {@link ToStream#getOutputTypeReference()}
   */
  @Test
  void testGetOutputTypeReference2() {
    // Arrange
    HashMap<String, String> options = new HashMap<>();
    options.computeIfPresent("foo", mock(BiFunction.class));

    ToStream<Object> toStream = new ToStream<>();
    toStream.setOptions(options);

    // Act
    TypeReference<Stream<?>> actualOutputTypeReference = toStream.getOutputTypeReference();

    // Assert
    assertTrue(actualOutputTypeReference instanceof TypeReferenceImpl.Stream);
    assertEquals("java.util.stream.Stream<T>", actualOutputTypeReference.getType().getTypeName());
  }

  /**
   * Method under test: {@link ToStream#shallowClone()}
   */
  @Test
  void testShallowClone() {
    // Arrange
    ToStream<Object> toStream = new ToStream<>();

    // Act
    ToStream<Object> actualShallowCloneResult = toStream.shallowClone();

    // Assert
    TypeReference<Stream<?>> outputTypeReference = actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.Stream);
    Type outputType = actualShallowCloneResult.getOutputType();
    assertEquals("java.util.stream.Stream<T>", outputType.getTypeName());
    assertNull(actualShallowCloneResult.getInput());
    assertNull(actualShallowCloneResult.getOptions());
    Class<Stream> expectedOutputClass = Stream.class;
    assertEquals(expectedOutputClass, actualShallowCloneResult.getOutputClass());
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Method under test: {@link ToStream#shallowClone()}
   */
  @Test
  void testShallowClone2() {
    // Arrange
    ToStream<Object> toStream = new ToStream<>();
    toStream.setOptions(new HashMap<>());

    // Act
    ToStream<Object> actualShallowCloneResult = toStream.shallowClone();

    // Assert
    TypeReference<Stream<?>> outputTypeReference = actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.Stream);
    Type outputType = actualShallowCloneResult.getOutputType();
    assertEquals("java.util.stream.Stream<T>", outputType.getTypeName());
    assertNull(actualShallowCloneResult.getInput());
    assertTrue(actualShallowCloneResult.getOptions().isEmpty());
    Class<Stream> expectedOutputClass = Stream.class;
    assertEquals(expectedOutputClass, actualShallowCloneResult.getOutputClass());
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Method under test: {@link ToStream#shallowClone()}
   */
  @Test
  void testShallowClone3() {
    // Arrange
    HashMap<String, String> options = new HashMap<>();
    options.computeIfPresent("foo", mock(BiFunction.class));

    ToStream<Object> toStream = new ToStream<>();
    toStream.setOptions(options);

    // Act
    ToStream<Object> actualShallowCloneResult = toStream.shallowClone();

    // Assert
    TypeReference<Stream<?>> outputTypeReference = actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.Stream);
    Type outputType = actualShallowCloneResult.getOutputType();
    assertEquals("java.util.stream.Stream<T>", outputType.getTypeName());
    assertNull(actualShallowCloneResult.getInput());
    assertTrue(actualShallowCloneResult.getOptions().isEmpty());
    Class<Stream> expectedOutputClass = Stream.class;
    assertEquals(expectedOutputClass, actualShallowCloneResult.getOutputClass());
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link ToStream}
   *   <li>{@link ToStream#setInput(Iterable)}
   *   <li>{@link ToStream#setOptions(Map)}
   *   <li>{@link ToStream#getOptions()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    ToStream<Object> actualToStream = new ToStream<>();
    ArrayList<Object> input = new ArrayList<>();
    actualToStream.setInput(input);
    HashMap<String, String> options = new HashMap<>();
    actualToStream.setOptions(options);
    Map<String, String> actualOptions = actualToStream.getOptions();

    // Assert that nothing has changed
    Iterable<?> input2 = actualToStream.getInput();
    assertTrue(input2 instanceof List);
    assertTrue(actualOptions.isEmpty());
    assertSame(input, input2);
    assertSame(options, actualOptions);
  }
}
