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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashSet;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.mapstore.MapStore;
import uk.gov.gchq.gaffer.mapstore.MapStoreProperties;
import uk.gov.gchq.gaffer.mapstore.operation.CountAllElementsDefaultView;
import uk.gov.gchq.gaffer.operation.OperationException;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.Store;
import uk.gov.gchq.gaffer.store.schema.Schema;

class CountAllElementsDefaultViewHandlerDiffblueTest {
  /**
   * Test {@link CountAllElementsDefaultViewHandler#doOperation(CountAllElementsDefaultView,
   * Context, Store)} with {@code operation}, {@code context}, {@code store}.
   *
   * <ul>
   *   <li>Then return longValue is zero.
   * </ul>
   *
   * <p>Method under test: {@link
   * CountAllElementsDefaultViewHandler#doOperation(CountAllElementsDefaultView, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(CountAllElementsDefaultView, Context, Store) with 'operation', 'context', 'store'; then return longValue is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Long CountAllElementsDefaultViewHandler.doOperation(CountAllElementsDefaultView, Context, Store)"
  })
  void testDoOperationWithOperationContextStore_thenReturnLongValueIsZero()
      throws OperationException {
    // Arrange
    CountAllElementsDefaultViewHandler countAllElementsDefaultViewHandler =
        new CountAllElementsDefaultViewHandler();
    CountAllElementsDefaultView operation = new CountAllElementsDefaultView();
    Context context = new Context();

    MapStore store = mock(MapStore.class);
    when(store.getTraits()).thenReturn(new HashSet<>());
    Schema schema = new Schema();
    MapImpl mapImpl = new MapImpl(schema, new MapStoreProperties());
    when(store.getMapImpl()).thenReturn(mapImpl);
    when(store.getSchema()).thenReturn(new Schema());

    // Act
    Long actualDoOperationResult =
        countAllElementsDefaultViewHandler.doOperation(operation, context, store);

    // Assert
    verify(store, atLeast(1)).getMapImpl();
    verify(store).getTraits();
    verify(store).getSchema();
    assertEquals(0L, actualDoOperationResult.longValue());
  }
}
