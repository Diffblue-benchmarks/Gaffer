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

package uk.gov.gchq.gaffer.federated.simple.operation.handler.get;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.federated.simple.FederatedStore;
import uk.gov.gchq.gaffer.federated.simple.operation.GetAllGraphIds;
import uk.gov.gchq.gaffer.operation.OperationException;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.Store;

class GetAllGraphIdsHandlerDiffblueTest {
  /**
   * Test {@link GetAllGraphIdsHandler#doOperation(GetAllGraphIds, Context, Store)} with {@code
   * GetAllGraphIds}, {@code Context}, {@code Store}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link GetAllGraphIdsHandler#doOperation(GetAllGraphIds, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(GetAllGraphIds, Context, Store) with 'GetAllGraphIds', 'Context', 'Store'; given ArrayList(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set GetAllGraphIdsHandler.doOperation(GetAllGraphIds, Context, Store)"})
  void testDoOperationWithGetAllGraphIdsContextStore_givenArrayList_thenReturnEmpty()
      throws OperationException {
    // Arrange
    GetAllGraphIdsHandler getAllGraphIdsHandler = new GetAllGraphIdsHandler();
    GetAllGraphIds operation = new GetAllGraphIds();
    Context context = new Context();

    FederatedStore store = mock(FederatedStore.class);
    when(store.getAllGraphsAndAccess()).thenReturn(new ArrayList<>());

    // Act
    Set<String> actualDoOperationResult =
        getAllGraphIdsHandler.doOperation(operation, context, store);

    // Assert
    verify(store).getAllGraphsAndAccess();
    assertTrue(actualDoOperationResult.isEmpty());
  }
}
