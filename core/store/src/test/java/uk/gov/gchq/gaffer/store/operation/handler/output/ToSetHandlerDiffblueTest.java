/*
 * Copyright 2026 Crown Copyright
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

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.commonutil.iterable.StreamIterable;
import uk.gov.gchq.gaffer.operation.OperationException;
import uk.gov.gchq.gaffer.operation.impl.output.ToSet;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.Store;
import uk.gov.gchq.gaffer.store.operation.handler.TestAddToGraphLibraryImpl;

class ToSetHandlerDiffblueTest {
  /**
   * Test {@link ToSetHandler#doOperation(ToSet, Context, Store)} with {@code ToSet}, {@code
   * Context}, {@code Store}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>When {@link ToSet} (default constructor) Input is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link ToSetHandler#doOperation(ToSet, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(ToSet, Context, Store) with 'ToSet', 'Context', 'Store'; given ArrayList(); when ToSet (default constructor) Input is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ToSetHandler.doOperation(ToSet, Context, Store)"})
  void testDoOperationWithToSetContextStore_givenArrayList_whenToSetInputIsArrayList()
      throws OperationException {
    // Arrange
    ToSetHandler<Object> toSetHandler = new ToSetHandler<>();

    ToSet<Object> operation = new ToSet<>();
    operation.setInput(new ArrayList<>());
    Context context = new Context();

    // Act and Assert
    assertTrue(
        toSetHandler.doOperation(operation, context, new TestAddToGraphLibraryImpl()).isEmpty());
  }

  /**
   * Test {@link ToSetHandler#doOperation(ToSet, Context, Store)} with {@code ToSet}, {@code
   * Context}, {@code Store}.
   *
   * <ul>
   *   <li>Then calls {@link Supplier#get()}.
   * </ul>
   *
   * <p>Method under test: {@link ToSetHandler#doOperation(ToSet, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(ToSet, Context, Store) with 'ToSet', 'Context', 'Store'; then calls get()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ToSetHandler.doOperation(ToSet, Context, Store)"})
  void testDoOperationWithToSetContextStore_thenCallsGet() throws OperationException {
    // Arrange
    ToSetHandler<Object> toSetHandler = new ToSetHandler<>();

    Supplier<Stream<Object>> streamSupplier = mock(Supplier.class);

    ArrayList<Object> objectList = new ArrayList<>();
    Stream<Object> streamResult = objectList.stream();
    when(streamSupplier.get()).thenReturn(streamResult);
    StreamIterable<?> input = new StreamIterable<>(streamSupplier);

    ToSet<Object> operation = new ToSet<>();
    operation.setInput(input);
    Context context = new Context();

    // Act
    Set<Object> actualDoOperationResult =
        toSetHandler.doOperation(operation, context, new TestAddToGraphLibraryImpl());

    // Assert
    verify(streamSupplier).get();
    assertTrue(actualDoOperationResult.isEmpty());
  }

  /**
   * Test {@link ToSetHandler#doOperation(ToSet, Context, Store)} with {@code ToSet}, {@code
   * Context}, {@code Store}.
   *
   * <ul>
   *   <li>When {@link ToSet} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ToSetHandler#doOperation(ToSet, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(ToSet, Context, Store) with 'ToSet', 'Context', 'Store'; when ToSet (default constructor); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ToSetHandler.doOperation(ToSet, Context, Store)"})
  void testDoOperationWithToSetContextStore_whenToSet_thenReturnNull() throws OperationException {
    // Arrange
    ToSetHandler<Object> toSetHandler = new ToSetHandler<>();
    ToSet<Object> operation = new ToSet<>();
    Context context = new Context();

    // Act and Assert
    assertNull(toSetHandler.doOperation(operation, context, new TestAddToGraphLibraryImpl()));
  }
}
