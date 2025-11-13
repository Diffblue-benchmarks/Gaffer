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
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.named.operation.NamedOperation;
import uk.gov.gchq.gaffer.named.operation.NamedOperation.Builder;

class MultiInputDiffblueTest {
  /**
   * Test Builder {@link MultiInput.Builder#input(Iterable)} with {@code Iterable}.
   * <p>
   * Method under test: {@link MultiInput.Builder#input(Iterable)}
   */
  @Test
  @DisplayName("Test Builder input(Iterable) with 'Iterable'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MultiInput.Builder MultiInput.Builder.input(Iterable)"})
  void testBuilderInputWithIterable() {
    // Arrange
    Builder<Object, Object> builder = new Builder<>();

    // Act and Assert
    assertSame(builder, builder.input(new ArrayList<>()));
  }

  /**
   * Test Builder {@link MultiInput.Builder#input(Object[])} with {@code Object[]}.
   * <ul>
   *   <li>When {@code Input}.</li>
   *   <li>Then return {@link Builder} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link MultiInput.Builder#input(Object[])}
   */
  @Test
  @DisplayName("Test Builder input(Object[]) with 'Object[]'; when 'Input'; then return Builder (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MultiInput.Builder MultiInput.Builder.input(Object[])"})
  void testBuilderInputWithObject_whenInput_thenReturnBuilder() {
    // Arrange
    Builder<Object, Object> builder = new Builder<>();

    // Act and Assert
    assertSame(builder, builder.input("Input"));
  }

  /**
   * Test {@link MultiInput#createInputArray()}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then return first element is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MultiInput#createInputArray()}
   */
  @Test
  @DisplayName("Test createInputArray(); given ArrayList() add '42'; then return first element is '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object[] MultiInput.createInputArray()"})
  void testCreateInputArray_givenArrayListAdd42_thenReturnFirstElementIs42() {
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
   * Test {@link MultiInput#createInputArray()}.
   * <ul>
   *   <li>Given {@link NamedOperation} (default constructor) Input is {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MultiInput#createInputArray()}
   */
  @Test
  @DisplayName("Test createInputArray(); given NamedOperation (default constructor) Input is ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object[] MultiInput.createInputArray()"})
  void testCreateInputArray_givenNamedOperationInputIsArrayList() {
    // Arrange
    NamedOperation<Object, Object> namedOperation = new NamedOperation<>();
    namedOperation.setInput(new ArrayList<>());

    // Act and Assert
    assertEquals(0, namedOperation.createInputArray().length);
  }

  /**
   * Test {@link MultiInput#createInputArray()}.
   * <ul>
   *   <li>Given {@link NamedOperation} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MultiInput#createInputArray()}
   */
  @Test
  @DisplayName("Test createInputArray(); given NamedOperation (default constructor); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object[] MultiInput.createInputArray()"})
  void testCreateInputArray_givenNamedOperation_thenReturnNull() {
    // Arrange
    NamedOperation<Object, Object> namedOperation = new NamedOperation<>();

    // Act and Assert
    assertNull(namedOperation.createInputArray());
  }

  /**
   * Test {@link MultiInput#createInputArray()}.
   * <ul>
   *   <li>Then return array length is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link MultiInput#createInputArray()}
   */
  @Test
  @DisplayName("Test createInputArray(); then return array length is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object[] MultiInput.createInputArray()"})
  void testCreateInputArray_thenReturnArrayLengthIsZero() {
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
   * Test {@link MultiInput#setInput(Object[])} with {@code Object[]}.
   * <ul>
   *   <li>When {@code Input}.</li>
   *   <li>Then {@link NamedOperation} (default constructor) Input {@link List}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MultiInput#setInput(Object[])}
   */
  @Test
  @DisplayName("Test setInput(Object[]) with 'Object[]'; when 'Input'; then NamedOperation (default constructor) Input List")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void MultiInput.setInput(Object[])"})
  void testSetInputWithObject_whenInput_thenNamedOperationInputList() {
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
}
