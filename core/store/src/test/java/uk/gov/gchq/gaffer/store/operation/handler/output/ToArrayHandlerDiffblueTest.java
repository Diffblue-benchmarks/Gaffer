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

package uk.gov.gchq.gaffer.store.operation.handler.output;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.operation.OperationException;
import uk.gov.gchq.gaffer.operation.impl.output.ToArray;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.Store;
import uk.gov.gchq.gaffer.store.operation.handler.TestAddToGraphLibraryImpl;

class ToArrayHandlerDiffblueTest {
  /**
   * Test {@link ToArrayHandler#doOperation(ToArray, Context, Store)} with {@code ToArray}, {@code
   * Context}, {@code Store}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link ToArrayHandler#doOperation(ToArray, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(ToArray, Context, Store) with 'ToArray', 'Context', 'Store'; given ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object[] ToArrayHandler.doOperation(ToArray, Context, Store)"})
  void testDoOperationWithToArrayContextStore_givenArrayList() throws OperationException {
    // Arrange
    ToArrayHandler<Object> toArrayHandler = new ToArrayHandler<>();

    ToArray<Object> operation = new ToArray<>();
    operation.setInput(new ArrayList<>());
    Context context = new Context();

    // Act and Assert
    assertNull(toArrayHandler.doOperation(operation, context, new TestAddToGraphLibraryImpl()));
  }

  /**
   * Test {@link ToArrayHandler#doOperation(ToArray, Context, Store)} with {@code ToArray}, {@code
   * Context}, {@code Store}.
   *
   * <ul>
   *   <li>Given {@link LinkedHashSet#LinkedHashSet()} add {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ToArrayHandler#doOperation(ToArray, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(ToArray, Context, Store) with 'ToArray', 'Context', 'Store'; given LinkedHashSet() add 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object[] ToArrayHandler.doOperation(ToArray, Context, Store)"})
  void testDoOperationWithToArrayContextStore_givenLinkedHashSetAddNull_thenReturnNull()
      throws OperationException {
    // Arrange
    ToArrayHandler<Object> toArrayHandler = new ToArrayHandler<>();

    LinkedHashSet<?> input = new LinkedHashSet<>();
    input.add(null);

    ToArray<Object> operation = new ToArray<>();
    operation.setInput(input);
    Context context = new Context();

    // Act and Assert
    assertNull(toArrayHandler.doOperation(operation, context, new TestAddToGraphLibraryImpl()));
  }

  /**
   * Test {@link ToArrayHandler#doOperation(ToArray, Context, Store)} with {@code ToArray}, {@code
   * Context}, {@code Store}.
   *
   * <ul>
   *   <li>Then calls {@link Iterable#iterator()}.
   * </ul>
   *
   * <p>Method under test: {@link ToArrayHandler#doOperation(ToArray, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(ToArray, Context, Store) with 'ToArray', 'Context', 'Store'; then calls iterator()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object[] ToArrayHandler.doOperation(ToArray, Context, Store)"})
  void testDoOperationWithToArrayContextStore_thenCallsIterator() throws OperationException {
    // Arrange
    ToArrayHandler<Object> toArrayHandler = new ToArrayHandler<>();

    Iterable<Object> input = mock(Iterable.class);

    ArrayList<Object> objectList = new ArrayList<>();
    when(input.iterator()).thenReturn(objectList.iterator());

    ToArray<Object> operation = new ToArray<>();
    operation.setInput(input);
    Context context = new Context();

    // Act
    Object[] actualDoOperationResult =
        toArrayHandler.doOperation(operation, context, new TestAddToGraphLibraryImpl());

    // Assert
    verify(input).iterator();
    assertNull(actualDoOperationResult);
  }

  /**
   * Test {@link ToArrayHandler#doOperation(ToArray, Context, Store)} with {@code ToArray}, {@code
   * Context}, {@code Store}.
   *
   * <ul>
   *   <li>Then return array of {@link String} with {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ToArrayHandler#doOperation(ToArray, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(ToArray, Context, Store) with 'ToArray', 'Context', 'Store'; then return array of String with '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object[] ToArrayHandler.doOperation(ToArray, Context, Store)"})
  void testDoOperationWithToArrayContextStore_thenReturnArrayOfStringWith42()
      throws OperationException {
    // Arrange
    ToArrayHandler<Object> toArrayHandler = new ToArrayHandler<>();

    ArrayList<Object> objectList = new ArrayList<>();
    objectList.add("42");

    Iterable<Object> input = mock(Iterable.class);
    when(input.iterator()).thenReturn(objectList.iterator());

    ToArray<Object> operation = new ToArray<>();
    operation.setInput(input);
    Context context = new Context();

    // Act
    Object[] actualDoOperationResult =
        toArrayHandler.doOperation(operation, context, new TestAddToGraphLibraryImpl());

    // Assert
    verify(input, atLeast(1)).iterator();
    assertTrue(actualDoOperationResult instanceof String[]);
    assertArrayEquals(new String[] {"42"}, actualDoOperationResult);
  }

  /**
   * Test {@link ToArrayHandler#doOperation(ToArray, Context, Store)} with {@code ToArray}, {@code
   * Context}, {@code Store}.
   *
   * <ul>
   *   <li>When {@link ToArray} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ToArrayHandler#doOperation(ToArray, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(ToArray, Context, Store) with 'ToArray', 'Context', 'Store'; when ToArray (default constructor); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object[] ToArrayHandler.doOperation(ToArray, Context, Store)"})
  void testDoOperationWithToArrayContextStore_whenToArray_thenReturnNull()
      throws OperationException {
    // Arrange
    ToArrayHandler<Object> toArrayHandler = new ToArrayHandler<>();
    ToArray<Object> operation = new ToArray<>();
    Context context = new Context();

    // Act and Assert
    assertNull(toArrayHandler.doOperation(operation, context, new TestAddToGraphLibraryImpl()));
  }
}
