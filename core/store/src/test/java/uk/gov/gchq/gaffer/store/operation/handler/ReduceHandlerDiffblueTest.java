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

package uk.gov.gchq.gaffer.store.operation.handler;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.function.BinaryOperator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.operation.OperationException;
import uk.gov.gchq.gaffer.operation.impl.Reduce;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.Store;

class ReduceHandlerDiffblueTest {
  /**
   * Test {@link ReduceHandler#doOperation(Reduce, Context, Store)} with {@code Reduce}, {@code
   * Context}, {@code Store}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ReduceHandler#doOperation(Reduce, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(Reduce, Context, Store) with 'Reduce', 'Context', 'Store'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object ReduceHandler.doOperation(Reduce, Context, Store)"})
  void testDoOperationWithReduceContextStore_thenReturnNull() throws OperationException {
    // Arrange
    ReduceHandler<Object> reduceHandler = new ReduceHandler<>();

    Reduce<Object> operation = new Reduce<>(mock(BinaryOperator.class));
    operation.setInput(new ArrayList<>());
    Context context = new Context();

    // Act and Assert
    assertNull(reduceHandler.doOperation(operation, context, new TestAddToGraphLibraryImpl()));
  }

  /**
   * Test {@link ReduceHandler#doOperation(Reduce, Context, Store)} with {@code Reduce}, {@code
   * Context}, {@code Store}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link OperationException}.
   * </ul>
   *
   * <p>Method under test: {@link ReduceHandler#doOperation(Reduce, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(Reduce, Context, Store) with 'Reduce', 'Context', 'Store'; when 'null'; then throw OperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object ReduceHandler.doOperation(Reduce, Context, Store)"})
  void testDoOperationWithReduceContextStore_whenNull_thenThrowOperationException()
      throws OperationException {
    // Arrange
    ReduceHandler<Object> reduceHandler = new ReduceHandler<>();
    Context context = new Context();

    // Act and Assert
    assertThrows(
        OperationException.class,
        () -> reduceHandler.doOperation(null, context, new TestAddToGraphLibraryImpl()));
  }

  /**
   * Test {@link ReduceHandler#doOperation(Reduce, Context, Store)} with {@code Reduce}, {@code
   * Context}, {@code Store}.
   *
   * <ul>
   *   <li>When {@link Reduce#Reduce()}.
   *   <li>Then throw {@link OperationException}.
   * </ul>
   *
   * <p>Method under test: {@link ReduceHandler#doOperation(Reduce, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(Reduce, Context, Store) with 'Reduce', 'Context', 'Store'; when Reduce(); then throw OperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object ReduceHandler.doOperation(Reduce, Context, Store)"})
  void testDoOperationWithReduceContextStore_whenReduce_thenThrowOperationException()
      throws OperationException {
    // Arrange
    ReduceHandler<Object> reduceHandler = new ReduceHandler<>();
    Reduce<Object> operation = new Reduce<>();
    Context context = new Context();

    // Act and Assert
    assertThrows(
        OperationException.class,
        () -> reduceHandler.doOperation(operation, context, new TestAddToGraphLibraryImpl()));
  }
}
