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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.operation.OperationException;
import uk.gov.gchq.gaffer.operation.impl.output.ToSingletonList;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.Store;
import uk.gov.gchq.gaffer.store.operation.handler.TestAddToGraphLibraryImpl;

class ToSingletonListHandlerDiffblueTest {
  /**
   * Test {@link ToSingletonListHandler#doOperation(ToSingletonList, Context, Store)} with {@code
   * ToSingletonList}, {@code Context}, {@code Store}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link ToSingletonListHandler#doOperation(ToSingletonList, Context,
   * Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(ToSingletonList, Context, Store) with 'ToSingletonList', 'Context', 'Store'; then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ToSingletonListHandler.doOperation(ToSingletonList, Context, Store)"})
  void testDoOperationWithToSingletonListContextStore_thenReturnSizeIsOne()
      throws OperationException {
    // Arrange
    ToSingletonListHandler<Object> toSingletonListHandler = new ToSingletonListHandler<>();

    ToSingletonList<Object> operation = new ToSingletonList<>();
    operation.setInput("Operation");
    Context context = new Context();

    // Act
    List<?> actualDoOperationResult =
        toSingletonListHandler.doOperation(operation, context, new TestAddToGraphLibraryImpl());

    // Assert
    assertEquals(1, actualDoOperationResult.size());
    assertEquals("Operation", actualDoOperationResult.get(0));
  }

  /**
   * Test {@link ToSingletonListHandler#doOperation(ToSingletonList, Context, Store)} with {@code
   * ToSingletonList}, {@code Context}, {@code Store}.
   *
   * <ul>
   *   <li>Then throw {@link OperationException}.
   * </ul>
   *
   * <p>Method under test: {@link ToSingletonListHandler#doOperation(ToSingletonList, Context,
   * Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(ToSingletonList, Context, Store) with 'ToSingletonList', 'Context', 'Store'; then throw OperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ToSingletonListHandler.doOperation(ToSingletonList, Context, Store)"})
  void testDoOperationWithToSingletonListContextStore_thenThrowOperationException()
      throws OperationException {
    // Arrange
    ToSingletonListHandler<Object> toSingletonListHandler = new ToSingletonListHandler<>();
    ToSingletonList<Object> operation = new ToSingletonList<>();
    Context context = new Context();

    // Act and Assert
    assertThrows(
        OperationException.class,
        () ->
            toSingletonListHandler.doOperation(
                operation, context, new TestAddToGraphLibraryImpl()));
  }
}
