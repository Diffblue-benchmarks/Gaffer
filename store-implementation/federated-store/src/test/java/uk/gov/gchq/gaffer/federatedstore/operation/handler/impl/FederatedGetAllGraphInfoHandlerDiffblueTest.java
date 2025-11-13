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

package uk.gov.gchq.gaffer.federatedstore.operation.handler.impl;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uk.gov.gchq.gaffer.federatedstore.FederatedStore;
import uk.gov.gchq.gaffer.federatedstore.operation.GetAllGraphInfo;
import uk.gov.gchq.gaffer.operation.OperationException;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.Store;
import uk.gov.gchq.gaffer.user.User;
import uk.gov.gchq.gaffer.user.User.Builder;

class FederatedGetAllGraphInfoHandlerDiffblueTest {
  /**
   * Test {@link FederatedGetAllGraphInfoHandler#doOperation(GetAllGraphInfo, Context, Store)} with {@code GetAllGraphInfo}, {@code Context}, {@code Store}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link FederatedGetAllGraphInfoHandler#doOperation(GetAllGraphInfo, Context, Store)}
   */
  @Test
  @DisplayName("Test doOperation(GetAllGraphInfo, Context, Store) with 'GetAllGraphInfo', 'Context', 'Store'; given HashMap(); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map FederatedGetAllGraphInfoHandler.doOperation(GetAllGraphInfo, Context, Store)"})
  void testDoOperationWithGetAllGraphInfoContextStore_givenHashMap_thenReturnEmpty() throws OperationException {
    // Arrange
    FederatedGetAllGraphInfoHandler federatedGetAllGraphInfoHandler = new FederatedGetAllGraphInfoHandler();
    GetAllGraphInfo operation = mock(GetAllGraphInfo.class);
    when(operation.isUserRequestingAdminUsage()).thenReturn(true);
    when(operation.getGraphIds()).thenReturn(new ArrayList<>());
    Context context = mock(Context.class);
    User buildResult = (new Builder()).userId("42").build();
    when(context.getUser()).thenReturn(buildResult);
    FederatedStore store = mock(FederatedStore.class);
    when(store.getAllGraphsAndAuths(Mockito.<User>any(), Mockito.<List<String>>any(), anyBoolean()))
        .thenReturn(new HashMap<>());

    // Act
    Map<String, Object> actualDoOperationResult = federatedGetAllGraphInfoHandler.doOperation(operation, context,
        store);

    // Assert
    verify(store).getAllGraphsAndAuths(isA(User.class), isA(List.class), eq(true));
    verify(operation).getGraphIds();
    verify(operation).isUserRequestingAdminUsage();
    verify(context).getUser();
    assertTrue(actualDoOperationResult.isEmpty());
  }
}
