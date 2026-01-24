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

package uk.gov.gchq.gaffer.accumulostore.operation.handler;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.accumulostore.AccumuloStore;
import uk.gov.gchq.gaffer.accumulostore.key.core.impl.byteEntity.ByteEntityKeyPackage;
import uk.gov.gchq.gaffer.accumulostore.operation.impl.GetElementsBetweenSets;
import uk.gov.gchq.gaffer.accumulostore.operation.impl.GetElementsBetweenSetsPairs;
import uk.gov.gchq.gaffer.accumulostore.retriever.impl.AccumuloIDBetweenSetsRetriever;
import uk.gov.gchq.gaffer.commonutil.iterable.EmptyIterator;
import uk.gov.gchq.gaffer.data.element.Element;
import uk.gov.gchq.gaffer.data.element.Entity;
import uk.gov.gchq.gaffer.data.element.Entity.Builder;
import uk.gov.gchq.gaffer.data.element.id.EntityId;
import uk.gov.gchq.gaffer.data.elementdefinition.view.View;
import uk.gov.gchq.gaffer.operation.OperationException;
import uk.gov.gchq.gaffer.store.schema.Schema;
import uk.gov.gchq.gaffer.user.User;

class GetElementsBetweenSetsPairsHandlerDiffblueTest {
  /**
   * Test {@link GetElementsBetweenSetsPairsHandler#doOperation(GetElementsBetweenSetsPairs, User,
   * AccumuloStore)} with {@code operation}, {@code user}, {@code store}.
   *
   * <ul>
   *   <li>Then return {@link AccumuloIDBetweenSetsRetriever}.
   * </ul>
   *
   * <p>Method under test: {@link
   * GetElementsBetweenSetsPairsHandler#doOperation(GetElementsBetweenSetsPairs, User,
   * AccumuloStore)}
   */
  @Test
  @DisplayName(
      "Test doOperation(GetElementsBetweenSetsPairs, User, AccumuloStore) with 'operation', 'user', 'store'; then return AccumuloIDBetweenSetsRetriever")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Iterable GetElementsBetweenSetsPairsHandler.doOperation(GetElementsBetweenSetsPairs, User, AccumuloStore)"
  })
  void testDoOperationWithOperationUserStore_thenReturnAccumuloIDBetweenSetsRetriever()
      throws IOException, OperationException {
    // Arrange
    GetElementsBetweenSetsPairsHandler getElementsBetweenSetsPairsHandler =
        new GetElementsBetweenSetsPairsHandler();

    GetElementsBetweenSets getElementsBetweenSets = mock(GetElementsBetweenSets.class);
    org.mockito.Mockito.<Iterable<? extends EntityId>>when(getElementsBetweenSets.getInput())
        .thenReturn(new ArrayList<>());
    org.mockito.Mockito.<Iterable<? extends EntityId>>when(getElementsBetweenSets.getInputB())
        .thenReturn(new ArrayList<>());
    doNothing().when(getElementsBetweenSets).close();

    GetElementsBetweenSetsPairs operation = mock(GetElementsBetweenSetsPairs.class);
    when(operation.getBackwardsCompatibleOperation()).thenReturn(getElementsBetweenSets);
    when(operation.getView()).thenReturn(new View());
    User user = new User();

    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getSchema()).thenReturn(new Schema());
    when(store.getKeyPackage()).thenReturn(new ByteEntityKeyPackage());

    // Act
    Iterable<? extends Element> actualDoOperationResult =
        getElementsBetweenSetsPairsHandler.doOperation(operation, user, store);
    Iterator<? extends Element> actualIteratorResult = actualDoOperationResult.iterator();

    // Assert
    verify(store, atLeast(1)).getKeyPackage();
    verify(getElementsBetweenSets).close();
    verify(getElementsBetweenSets).getInput();
    verify(getElementsBetweenSets).getInputB();
    verify(operation).getBackwardsCompatibleOperation();
    verify(operation, atLeast(1)).getView();
    verify(store, atLeast(1)).getSchema();
    assertTrue(actualDoOperationResult instanceof AccumuloIDBetweenSetsRetriever);
    assertTrue(actualIteratorResult instanceof EmptyIterator);
    assertEquals(-1L, actualDoOperationResult.spliterator().getExactSizeIfKnown());
    assertFalse(actualIteratorResult.hasNext());
  }

  /**
   * Test {@link GetElementsBetweenSetsPairsHandler#doOperation(GetElementsBetweenSetsPairs, User,
   * AccumuloStore)} with {@code operation}, {@code user}, {@code store}.
   *
   * <ul>
   *   <li>Then return {@link AccumuloIDBetweenSetsRetriever}.
   * </ul>
   *
   * <p>Method under test: {@link
   * GetElementsBetweenSetsPairsHandler#doOperation(GetElementsBetweenSetsPairs, User,
   * AccumuloStore)}
   */
  @Test
  @DisplayName(
      "Test doOperation(GetElementsBetweenSetsPairs, User, AccumuloStore) with 'operation', 'user', 'store'; then return AccumuloIDBetweenSetsRetriever")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Iterable GetElementsBetweenSetsPairsHandler.doOperation(GetElementsBetweenSetsPairs, User, AccumuloStore)"
  })
  void testDoOperationWithOperationUserStore_thenReturnAccumuloIDBetweenSetsRetriever2()
      throws IOException, OperationException {
    // Arrange
    GetElementsBetweenSetsPairsHandler getElementsBetweenSetsPairsHandler =
        new GetElementsBetweenSetsPairsHandler();

    ArrayList<EntityId> entityIdList = new ArrayList<>();
    entityIdList.add(new Builder().group("Group").vertex("Vertex").build());

    GetElementsBetweenSets getElementsBetweenSets = mock(GetElementsBetweenSets.class);
    org.mockito.Mockito.<Iterable<? extends EntityId>>when(getElementsBetweenSets.getInput())
        .thenReturn(entityIdList);
    org.mockito.Mockito.<Iterable<? extends EntityId>>when(getElementsBetweenSets.getInputB())
        .thenReturn(new ArrayList<>());
    doNothing().when(getElementsBetweenSets).close();

    GetElementsBetweenSetsPairs operation = mock(GetElementsBetweenSetsPairs.class);
    when(operation.getBackwardsCompatibleOperation()).thenReturn(getElementsBetweenSets);
    when(operation.getView()).thenReturn(new View());
    User user = new User();

    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getSchema()).thenReturn(new Schema());
    when(store.getKeyPackage()).thenReturn(new ByteEntityKeyPackage());

    // Act
    Iterable<? extends Element> actualDoOperationResult =
        getElementsBetweenSetsPairsHandler.doOperation(operation, user, store);
    Iterator<? extends Element> actualIteratorResult = actualDoOperationResult.iterator();

    // Assert
    verify(store, atLeast(1)).getKeyPackage();
    verify(getElementsBetweenSets).close();
    verify(getElementsBetweenSets).getInput();
    verify(getElementsBetweenSets).getInputB();
    verify(operation).getBackwardsCompatibleOperation();
    verify(operation, atLeast(1)).getView();
    verify(store, atLeast(1)).getSchema();
    assertTrue(actualDoOperationResult instanceof AccumuloIDBetweenSetsRetriever);
    assertTrue(actualIteratorResult instanceof EmptyIterator);
    assertEquals(-1L, actualDoOperationResult.spliterator().getExactSizeIfKnown());
    assertFalse(actualIteratorResult.hasNext());
  }
}
