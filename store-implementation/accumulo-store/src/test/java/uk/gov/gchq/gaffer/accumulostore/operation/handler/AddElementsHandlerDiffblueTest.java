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

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uk.gov.gchq.gaffer.accumulostore.AccumuloStore;
import uk.gov.gchq.gaffer.data.element.Element;
import uk.gov.gchq.gaffer.operation.OperationException;
import uk.gov.gchq.gaffer.operation.impl.add.AddElements;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.Store;
import uk.gov.gchq.gaffer.store.StoreException;
import uk.gov.gchq.gaffer.store.schema.Schema;

class AddElementsHandlerDiffblueTest {
  /**
   * Test {@link AddElementsHandler#doOperation(AddElements, Context, Store)} with {@code AddElements}, {@code Context}, {@code Store}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AddElementsHandler#doOperation(AddElements, Context, Store)}
   */
  @Test
  @DisplayName("Test doOperation(AddElements, Context, Store) with 'AddElements', 'Context', 'Store'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Void AddElementsHandler.doOperation(AddElements, Context, Store)"})
  void testDoOperationWithAddElementsContextStore_thenReturnNull() throws OperationException, StoreException {
    // Arrange
    AddElementsHandler addElementsHandler = new AddElementsHandler();
    AddElements operation = mock(AddElements.class);
    when(operation.isSkipInvalidElements()).thenReturn(true);
    when(operation.isValidate()).thenReturn(true);
    Mockito.<Iterable<? extends Element>>when(operation.getInput()).thenReturn(new ArrayList<>());
    Context context = new Context();
    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getSchema()).thenReturn(new Schema());
    doNothing().when(store).addElements(Mockito.<Iterable<Element>>any());

    // Act
    Void actualDoOperationResult = addElementsHandler.doOperation(operation, context, store);

    // Assert
    verify(store).addElements(isA(Iterable.class));
    verify(operation).getInput();
    verify(operation).isSkipInvalidElements();
    verify(operation).isValidate();
    verify(store).getSchema();
    assertNull(actualDoOperationResult);
  }

  /**
   * Test {@link AddElementsHandler#doOperation(AddElements, Context, Store)} with {@code AddElements}, {@code Context}, {@code Store}.
   * <ul>
   *   <li>Then throw {@link OperationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AddElementsHandler#doOperation(AddElements, Context, Store)}
   */
  @Test
  @DisplayName("Test doOperation(AddElements, Context, Store) with 'AddElements', 'Context', 'Store'; then throw OperationException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Void AddElementsHandler.doOperation(AddElements, Context, Store)"})
  void testDoOperationWithAddElementsContextStore_thenThrowOperationException()
      throws OperationException, StoreException {
    // Arrange
    AddElementsHandler addElementsHandler = new AddElementsHandler();
    AddElements operation = mock(AddElements.class);
    when(operation.isSkipInvalidElements()).thenReturn(true);
    when(operation.isValidate()).thenReturn(true);
    Mockito.<Iterable<? extends Element>>when(operation.getInput()).thenReturn(new ArrayList<>());
    Context context = new Context();
    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getSchema()).thenReturn(new Schema());
    doThrow(new StoreException("An error occurred")).when(store).addElements(Mockito.<Iterable<Element>>any());

    // Act and Assert
    assertThrows(OperationException.class, () -> addElementsHandler.doOperation(operation, context, store));
    verify(store).addElements(isA(Iterable.class));
    verify(operation).getInput();
    verify(operation).isSkipInvalidElements();
    verify(operation).isValidate();
    verify(store).getSchema();
  }
}
