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

package uk.gov.gchq.gaffer.federated.simple.operation.handler.get;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.federated.simple.FederatedStore;
import uk.gov.gchq.gaffer.federated.simple.operation.GetAllGraphInfo;
import uk.gov.gchq.gaffer.operation.OperationException;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.Store;

class GetAllGraphInfoHandlerDiffblueTest {
  /**
   * Test {@link GetAllGraphInfoHandler#doOperation(GetAllGraphInfo, Context, Store)} with {@code
   * GetAllGraphInfo}, {@code Context}, {@code Store}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link GetAllGraphInfoHandler#doOperation(GetAllGraphInfo, Context,
   * Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(GetAllGraphInfo, Context, Store) with 'GetAllGraphInfo', 'Context', 'Store'; then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map GetAllGraphInfoHandler.doOperation(GetAllGraphInfo, Context, Store)"})
  void testDoOperationWithGetAllGraphInfoContextStore_thenReturnSizeIsOne()
      throws OperationException {
    // Arrange
    GetAllGraphInfoHandler getAllGraphInfoHandler = new GetAllGraphInfoHandler();
    GetAllGraphInfo operation = new GetAllGraphInfo();
    Context context = new Context();

    FederatedStore store = mock(FederatedStore.class);
    when(store.getAllGraphsAndAccess()).thenReturn(new ArrayList<>());
    ArrayList<String> stringList = new ArrayList<>();
    when(store.getDefaultGraphIds()).thenReturn(stringList);

    // Act
    Map<String, Object> actualDoOperationResult =
        getAllGraphInfoHandler.doOperation(operation, context, store);

    // Assert
    verify(store).getAllGraphsAndAccess();
    verify(store).getDefaultGraphIds();
    assertEquals(1, actualDoOperationResult.size());
    Object getResult = actualDoOperationResult.get(GetAllGraphInfoHandler.DEFAULT_GRAPH_IDS);
    assertTrue(getResult instanceof List);
    assertTrue(((List<Object>) getResult).isEmpty());
    assertSame(stringList, getResult);
  }
}
