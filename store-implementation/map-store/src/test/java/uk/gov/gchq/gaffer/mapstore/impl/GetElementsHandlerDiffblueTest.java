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

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Iterator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.commonutil.iterable.EmptyIterable;
import uk.gov.gchq.gaffer.commonutil.iterable.EmptyIterator;
import uk.gov.gchq.gaffer.data.element.Element;
import uk.gov.gchq.gaffer.mapstore.MapStore;
import uk.gov.gchq.gaffer.mapstore.MapStoreProperties;
import uk.gov.gchq.gaffer.operation.OperationException;
import uk.gov.gchq.gaffer.operation.impl.get.GetElements;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.Store;
import uk.gov.gchq.gaffer.store.schema.Schema;

class GetElementsHandlerDiffblueTest {
  /**
   * Test {@link GetElementsHandler#doOperation(GetElements, Context, Store)} with {@code
   * operation}, {@code context}, {@code store}.
   *
   * <ul>
   *   <li>When {@link GetElements} (default constructor).
   *   <li>Then return {@link EmptyIterable}.
   * </ul>
   *
   * <p>Method under test: {@link GetElementsHandler#doOperation(GetElements, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(GetElements, Context, Store) with 'operation', 'context', 'store'; when GetElements (default constructor); then return EmptyIterable")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable GetElementsHandler.doOperation(GetElements, Context, Store)"})
  void testDoOperationWithOperationContextStore_whenGetElements_thenReturnEmptyIterable()
      throws OperationException {
    // Arrange
    GetElementsHandler getElementsHandler = new GetElementsHandler();
    GetElements operation = new GetElements();
    Context context = new Context();

    MapStore store = mock(MapStore.class);
    Schema schema = new Schema();
    MapImpl mapImpl = new MapImpl(schema, new MapStoreProperties());
    when(store.getMapImpl()).thenReturn(mapImpl);

    // Act
    Iterable<Element> actualDoOperationResult =
        getElementsHandler.doOperation(operation, context, store);
    Iterator<Element> actualIteratorResult = actualDoOperationResult.iterator();

    // Assert
    verify(store).getMapImpl();
    assertTrue(actualDoOperationResult instanceof EmptyIterable);
    Iterator<Element> iteratorResult = actualDoOperationResult.iterator();
    assertTrue(iteratorResult instanceof EmptyIterator);
    assertTrue(actualIteratorResult instanceof EmptyIterator);
    assertFalse(iteratorResult.hasNext());
  }
}
