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

package uk.gov.gchq.gaffer.mapstore.impl;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.mapstore.MapStore;
import uk.gov.gchq.gaffer.mapstore.MapStoreProperties;
import uk.gov.gchq.gaffer.operation.OperationException;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.Store;
import uk.gov.gchq.gaffer.store.operation.DeleteAllData;
import uk.gov.gchq.gaffer.store.schema.Schema;

class DeleteAllDataHandlerDiffblueTest {
  /**
   * Test {@link DeleteAllDataHandler#doOperation(DeleteAllData, Context, Store)} with {@code
   * DeleteAllData}, {@code Context}, {@code Store}.
   *
   * <p>Method under test: {@link DeleteAllDataHandler#doOperation(DeleteAllData, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(DeleteAllData, Context, Store) with 'DeleteAllData', 'Context', 'Store'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object DeleteAllDataHandler.doOperation(DeleteAllData, Context, Store)"})
  void testDoOperationWithDeleteAllDataContextStore() throws OperationException {
    // Arrange
    DeleteAllDataHandler deleteAllDataHandler = new DeleteAllDataHandler();
    DeleteAllData operation = new DeleteAllData();
    Context context = new Context();

    MapStore store = mock(MapStore.class);
    when(store.getGraphId()).thenReturn("42");
    Schema schema = new Schema();
    MapImpl mapImpl = new MapImpl(schema, new MapStoreProperties());
    when(store.getMapImpl()).thenReturn(mapImpl);

    // Act
    Object actualDoOperationResult = deleteAllDataHandler.doOperation(operation, context, store);

    // Assert
    verify(store).getMapImpl();
    verify(store).getGraphId();
    assertNull(actualDoOperationResult);
  }

  /**
   * Test {@link DeleteAllDataHandler#doOperation(DeleteAllData, Context, Store)} with {@code
   * DeleteAllData}, {@code Context}, {@code Store}.
   *
   * <ul>
   *   <li>Then calls {@link MapImpl#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link DeleteAllDataHandler#doOperation(DeleteAllData, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(DeleteAllData, Context, Store) with 'DeleteAllData', 'Context', 'Store'; then calls clear()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object DeleteAllDataHandler.doOperation(DeleteAllData, Context, Store)"})
  void testDoOperationWithDeleteAllDataContextStore_thenCallsClear() throws OperationException {
    // Arrange
    DeleteAllDataHandler deleteAllDataHandler = new DeleteAllDataHandler();
    DeleteAllData operation = new DeleteAllData();
    Context context = new Context();

    MapImpl mapImpl = mock(MapImpl.class);
    doNothing().when(mapImpl).clear();

    MapStore store = mock(MapStore.class);
    when(store.getGraphId()).thenReturn("42");
    when(store.getMapImpl()).thenReturn(mapImpl);

    // Act
    Object actualDoOperationResult = deleteAllDataHandler.doOperation(operation, context, store);

    // Assert
    verify(store).getMapImpl();
    verify(mapImpl).clear();
    verify(store).getGraphId();
    assertNull(actualDoOperationResult);
  }
}
