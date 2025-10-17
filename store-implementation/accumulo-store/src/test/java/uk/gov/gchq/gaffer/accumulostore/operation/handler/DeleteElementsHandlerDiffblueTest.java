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

package uk.gov.gchq.gaffer.accumulostore.operation.handler;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uk.gov.gchq.gaffer.accumulostore.AccumuloStore;
import uk.gov.gchq.gaffer.data.element.Element;
import uk.gov.gchq.gaffer.operation.OperationException;
import uk.gov.gchq.gaffer.operation.impl.delete.DeleteElements;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.Store;
import uk.gov.gchq.gaffer.store.StoreException;
import uk.gov.gchq.gaffer.store.schema.Schema;

class DeleteElementsHandlerDiffblueTest {
  /**
   * Test {@link DeleteElementsHandler#doOperation(DeleteElements, Context, Store)} with {@code
   * DeleteElements}, {@code Context}, {@code Store}.
   *
   * <ul>
   *   <li>Then return longValue is zero.
   * </ul>
   *
   * <p>Method under test: {@link DeleteElementsHandler#doOperation(DeleteElements, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(DeleteElements, Context, Store) with 'DeleteElements', 'Context', 'Store'; then return longValue is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long DeleteElementsHandler.doOperation(DeleteElements, Context, Store)"})
  void testDoOperationWithDeleteElementsContextStore_thenReturnLongValueIsZero()
      throws OperationException, StoreException {
    // Arrange
    DeleteElementsHandler deleteElementsHandler = new DeleteElementsHandler();

    DeleteElements operation = new DeleteElements();
    operation.setInput(new ArrayList<>());
    Context context = new Context();

    AccumuloStore store = mock(AccumuloStore.class);
    doNothing().when(store).deleteElements(Mockito.<Iterable<Element>>any());
    when(store.getSchema()).thenReturn(new Schema());

    // Act
    Long actualDoOperationResult = deleteElementsHandler.doOperation(operation, context, store);

    // Assert
    verify(store).deleteElements(isA(Iterable.class));
    verify(store).getSchema();
    assertEquals(0L, actualDoOperationResult.longValue());
  }

  /**
   * Test {@link DeleteElementsHandler#doOperation(DeleteElements, Context, Store)} with {@code
   * DeleteElements}, {@code Context}, {@code Store}.
   *
   * <ul>
   *   <li>Then throw {@link OperationException}.
   * </ul>
   *
   * <p>Method under test: {@link DeleteElementsHandler#doOperation(DeleteElements, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(DeleteElements, Context, Store) with 'DeleteElements', 'Context', 'Store'; then throw OperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long DeleteElementsHandler.doOperation(DeleteElements, Context, Store)"})
  void testDoOperationWithDeleteElementsContextStore_thenThrowOperationException()
      throws OperationException, StoreException {
    // Arrange
    DeleteElementsHandler deleteElementsHandler = new DeleteElementsHandler();

    DeleteElements operation = new DeleteElements();
    operation.setInput(new ArrayList<>());
    Context context = new Context();

    AccumuloStore store = mock(AccumuloStore.class);
    doThrow(new StoreException("An error occurred"))
        .when(store)
        .deleteElements(Mockito.<Iterable<Element>>any());
    when(store.getSchema()).thenReturn(new Schema());

    // Act and Assert
    assertThrows(
        OperationException.class,
        () -> deleteElementsHandler.doOperation(operation, context, store));
    verify(store).deleteElements(isA(Iterable.class));
    verify(store).getSchema();
  }
}
