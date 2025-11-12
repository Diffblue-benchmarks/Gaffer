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

package uk.gov.gchq.gaffer.operation.io;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.function.BiFunction;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.named.operation.NamedOperation;

class MultiInputDiffblueTest {
  /**
   * Method under test: {@link MultiInput.Builder#input(Iterable)}
   */
  @Test
  void testBuilderInput() {
    // Arrange
    NamedOperation.Builder<Object, Object> builder = new NamedOperation.Builder<>();

    // Act and Assert
    assertSame(builder, builder.input(new ArrayList<>()));
  }

  /**
   * Method under test: {@link MultiInput.Builder#input(Object[])}
   */
  @Test
  void testBuilderInput2() {
    // Arrange
    NamedOperation.Builder<Object, Object> builder = new NamedOperation.Builder<>();

    // Act and Assert
    assertSame(builder, builder.input("Input"));
  }

  /**
   * Method under test: {@link MultiInput#createInputArray()}
   */
  @Test
  void testCreateInputArray() {
    // Arrange
    NamedOperation<Object, Object> namedOperation = new NamedOperation<>();

    // Act and Assert
    assertNull(namedOperation.createInputArray());
  }

  /**
   * Method under test: {@link MultiInput#createInputArray()}
   */
  @Test
  void testCreateInputArray2() {
    // Arrange
    NamedOperation<Object, Object> namedOperation = new NamedOperation<>();
    namedOperation.setInput(new ArrayList<>());

    // Act and Assert
    assertEquals(0, namedOperation.createInputArray().length);
  }

  /**
   * Method under test: {@link MultiInput#createInputArray()}
   */
  @Test
  void testCreateInputArray3() {
    // Arrange
    LinkedHashMap<String, Object> parameters = new LinkedHashMap<>();
    parameters.replaceAll(mock(BiFunction.class));

    NamedOperation<Object, Object> namedOperation = new NamedOperation<>();
    namedOperation.setParameters(parameters);

    // Act and Assert
    assertNull(namedOperation.createInputArray());
  }

  /**
   * Method under test: {@link MultiInput#createInputArray()}
   */
  @Test
  void testCreateInputArray4() {
    // Arrange
    Iterable<Object> input = mock(Iterable.class);

    ArrayList<Object> objectList = new ArrayList<>();
    when(input.iterator()).thenReturn(objectList.iterator());

    NamedOperation<Object, Object> namedOperation = new NamedOperation<>();
    namedOperation.setInput(input);

    // Act
    Object[] actualCreateInputArrayResult = namedOperation.createInputArray();

    // Assert
    verify(input).iterator();
    assertEquals(0, actualCreateInputArrayResult.length);
  }

  /**
   * Method under test: {@link MultiInput#createInputArray()}
   */
  @Test
  void testCreateInputArray5() {
    // Arrange
    ArrayList<Object> objectList = new ArrayList<>();
    objectList.add("42");
    Iterable<Object> input = mock(Iterable.class);
    when(input.iterator()).thenReturn(objectList.iterator());

    NamedOperation<Object, Object> namedOperation = new NamedOperation<>();
    namedOperation.setInput(input);

    // Act
    Object[] actualCreateInputArrayResult = namedOperation.createInputArray();

    // Assert
    verify(input).iterator();
    assertEquals("42", actualCreateInputArrayResult[0]);
    assertEquals(1, actualCreateInputArrayResult.length);
  }

  /**
   * Method under test: {@link MultiInput#setInput(Object[])}
   */
  @Test
  void testSetInput() {
    // Arrange
    NamedOperation<Object, Object> namedOperation = new NamedOperation<>();

    // Act
    namedOperation.setInput("Input");

    // Assert
    Iterable<?> input = namedOperation.getInput();
    assertTrue(input instanceof List);
    assertEquals(1, ((List<?>) input).size());
    assertEquals("Input", ((List<?>) input).get(0));
  }

  /**
   * Method under test: {@link MultiInput#setInput(Object[])}
   */
  @Test
  void testSetInput2() {
    // Arrange
    LinkedHashMap<String, Object> parameters = new LinkedHashMap<>();
    parameters.replaceAll(mock(BiFunction.class));

    NamedOperation<Object, Object> namedOperation = new NamedOperation<>();
    namedOperation.setParameters(parameters);

    // Act
    namedOperation.setInput("Input");

    // Assert
    Iterable<?> input = namedOperation.getInput();
    assertTrue(input instanceof List);
    assertEquals(1, ((List<?>) input).size());
    assertEquals("Input", ((List<?>) input).get(0));
  }
}
