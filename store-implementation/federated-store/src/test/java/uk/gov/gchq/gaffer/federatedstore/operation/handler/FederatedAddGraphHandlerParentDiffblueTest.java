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

package uk.gov.gchq.gaffer.federatedstore.operation.handler;

import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.federatedstore.FederatedStore;
import uk.gov.gchq.gaffer.federatedstore.FederatedStoreTestUtil;
import uk.gov.gchq.gaffer.federatedstore.operation.AddGraph;
import uk.gov.gchq.gaffer.federatedstore.operation.handler.impl.FederatedAddGraphHandler;
import uk.gov.gchq.gaffer.operation.OperationException;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.Store;

class FederatedAddGraphHandlerParentDiffblueTest {
  /**
   * Test {@link FederatedAddGraphHandlerParent#doOperation(AddGraph, Context, Store)} with {@code
   * AddGraph}, {@code Context}, {@code Store}.
   *
   * <ul>
   *   <li>When {@link AddGraph} (default constructor).
   *   <li>Then throw {@link OperationException}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedAddGraphHandlerParent#doOperation(AddGraph, Context,
   * Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(AddGraph, Context, Store) with 'AddGraph', 'Context', 'Store'; when AddGraph (default constructor); then throw OperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Void FederatedAddGraphHandlerParent.doOperation(AddGraph, Context, Store)"
  })
  void testDoOperationWithAddGraphContextStore_whenAddGraph_thenThrowOperationException()
      throws OperationException {
    // Arrange
    FederatedAddGraphHandler federatedAddGraphHandler = new FederatedAddGraphHandler();
    AddGraph addGraph = new AddGraph();
    Context context = FederatedStoreTestUtil.contextAuthUser();

    // Act and Assert
    assertThrows(
        OperationException.class,
        () -> federatedAddGraphHandler.doOperation(addGraph, context, new FederatedStore()));
  }
}
