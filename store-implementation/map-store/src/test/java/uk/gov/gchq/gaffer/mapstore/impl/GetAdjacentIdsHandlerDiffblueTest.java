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
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Iterator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.commonutil.iterable.EmptyIterable;
import uk.gov.gchq.gaffer.commonutil.iterable.EmptyIterator;
import uk.gov.gchq.gaffer.data.element.id.EntityId;
import uk.gov.gchq.gaffer.mapstore.MapStore;
import uk.gov.gchq.gaffer.operation.OperationException;
import uk.gov.gchq.gaffer.operation.impl.get.GetAdjacentIds;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.Store;

class GetAdjacentIdsHandlerDiffblueTest {
  /**
   * Test {@link GetAdjacentIdsHandler#doOperation(GetAdjacentIds, Context, Store)} with {@code
   * operation}, {@code context}, {@code store}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>Then return {@link EmptyIterable}.
   * </ul>
   *
   * <p>Method under test: {@link GetAdjacentIdsHandler#doOperation(GetAdjacentIds, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(GetAdjacentIds, Context, Store) with 'operation', 'context', 'store'; given ArrayList(); then return EmptyIterable")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable GetAdjacentIdsHandler.doOperation(GetAdjacentIds, Context, Store)"})
  void testDoOperationWithOperationContextStore_givenArrayList_thenReturnEmptyIterable()
      throws OperationException {
    // Arrange
    GetAdjacentIdsHandler getAdjacentIdsHandler = new GetAdjacentIdsHandler();

    GetAdjacentIds operation = new GetAdjacentIds();
    operation.setInput(new ArrayList<>());
    Context context = new Context();

    // Act
    Iterable<? extends EntityId> actualDoOperationResult =
        getAdjacentIdsHandler.doOperation(operation, context, new MapStore());
    Iterator<? extends EntityId> actualIteratorResult = actualDoOperationResult.iterator();

    // Assert
    assertTrue(actualDoOperationResult instanceof EmptyIterable);
    Iterator<? extends EntityId> iteratorResult = actualDoOperationResult.iterator();
    assertTrue(iteratorResult instanceof EmptyIterator);
    assertTrue(actualIteratorResult instanceof EmptyIterator);
    assertFalse(iteratorResult.hasNext());
    assertFalse(actualIteratorResult.hasNext());
  }

  /**
   * Test {@link GetAdjacentIdsHandler#doOperation(GetAdjacentIds, Context, Store)} with {@code
   * operation}, {@code context}, {@code store}.
   *
   * <ul>
   *   <li>Then return {@link EmptyIterable}.
   * </ul>
   *
   * <p>Method under test: {@link GetAdjacentIdsHandler#doOperation(GetAdjacentIds, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(GetAdjacentIds, Context, Store) with 'operation', 'context', 'store'; then return EmptyIterable")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable GetAdjacentIdsHandler.doOperation(GetAdjacentIds, Context, Store)"})
  void testDoOperationWithOperationContextStore_thenReturnEmptyIterable()
      throws OperationException {
    // Arrange
    GetAdjacentIdsHandler getAdjacentIdsHandler = new GetAdjacentIdsHandler();
    GetAdjacentIds operation = new GetAdjacentIds();
    Context context = new Context();

    // Act
    Iterable<? extends EntityId> actualDoOperationResult =
        getAdjacentIdsHandler.doOperation(operation, context, new MapStore());
    Iterator<? extends EntityId> actualIteratorResult = actualDoOperationResult.iterator();

    // Assert
    assertTrue(actualDoOperationResult instanceof EmptyIterable);
    Iterator<? extends EntityId> iteratorResult = actualDoOperationResult.iterator();
    assertTrue(iteratorResult instanceof EmptyIterator);
    assertTrue(actualIteratorResult instanceof EmptyIterator);
    assertFalse(iteratorResult.hasNext());
    assertFalse(actualIteratorResult.hasNext());
  }
}
