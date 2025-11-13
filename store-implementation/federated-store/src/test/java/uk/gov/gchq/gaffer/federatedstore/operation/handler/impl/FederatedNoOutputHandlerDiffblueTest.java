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

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uk.gov.gchq.gaffer.federatedstore.FederatedStoreTestUtil;
import uk.gov.gchq.gaffer.operation.Operation;
import uk.gov.gchq.gaffer.operation.OperationException;
import uk.gov.gchq.gaffer.operation.export.graph.ExportToOtherAuthorisedGraph;
import uk.gov.gchq.gaffer.operation.io.Output;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.Store;

class FederatedNoOutputHandlerDiffblueTest {
  /**
   * Test {@link FederatedNoOutputHandler#doOperation(Operation, Context, Store)}.
   *
   * <ul>
   *   <li>Given empty string.
   * </ul>
   *
   * <p>Method under test: {@link FederatedNoOutputHandler#doOperation(Operation, Context, Store)}
   */
  @Test
  @DisplayName("Test doOperation(Operation, Context, Store); given empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Void FederatedNoOutputHandler.doOperation(Operation, Context, Store)"})
  void testDoOperation_givenEmptyString() throws OperationException {
    // Arrange
    FederatedNoOutputHandler<Operation> federatedNoOutputHandler = new FederatedNoOutputHandler<>();

    ExportToOtherAuthorisedGraph exportToOtherAuthorisedGraph =
        mock(ExportToOtherAuthorisedGraph.class);
    doNothing().when(exportToOtherAuthorisedGraph).setOptions(Mockito.<Map<String, String>>any());
    when(exportToOtherAuthorisedGraph.getOption(Mockito.<String>any())).thenReturn("");
    when(exportToOtherAuthorisedGraph.getOptions()).thenReturn(new HashMap<>());
    Context context = FederatedStoreTestUtil.contextAuthUser();

    Store store = mock(Store.class);
    when(store.execute(Mockito.<Output<Object>>any(), Mockito.<Context>any()))
        .thenReturn("Execute");

    // Act
    Void actualDoOperationResult =
        federatedNoOutputHandler.doOperation(exportToOtherAuthorisedGraph, context, store);

    // Assert
    verify(exportToOtherAuthorisedGraph).getOption("gaffer.federatedstore.operation.graphIds");
    verify(exportToOtherAuthorisedGraph).getOptions();
    verify(exportToOtherAuthorisedGraph).setOptions(isA(Map.class));
    verify(store).execute(isA(Output.class), isA(Context.class));
    assertNull(actualDoOperationResult);
  }

  /**
   * Test {@link FederatedNoOutputHandler#doOperation(Operation, Context, Store)}.
   *
   * <ul>
   *   <li>Given {@code Execute}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedNoOutputHandler#doOperation(Operation, Context, Store)}
   */
  @Test
  @DisplayName("Test doOperation(Operation, Context, Store); given 'Execute'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Void FederatedNoOutputHandler.doOperation(Operation, Context, Store)"})
  void testDoOperation_givenExecute_thenReturnNull() throws OperationException {
    // Arrange
    FederatedNoOutputHandler<Operation> federatedNoOutputHandler = new FederatedNoOutputHandler<>();

    ExportToOtherAuthorisedGraph exportToOtherAuthorisedGraph =
        mock(ExportToOtherAuthorisedGraph.class);
    doNothing().when(exportToOtherAuthorisedGraph).setOptions(Mockito.<Map<String, String>>any());
    when(exportToOtherAuthorisedGraph.getOption(Mockito.<String>any())).thenReturn("Option");
    when(exportToOtherAuthorisedGraph.getOptions()).thenReturn(new HashMap<>());
    Context context = FederatedStoreTestUtil.contextAuthUser();

    Store store = mock(Store.class);
    when(store.execute(Mockito.<Output<Object>>any(), Mockito.<Context>any()))
        .thenReturn("Execute");

    // Act
    Void actualDoOperationResult =
        federatedNoOutputHandler.doOperation(exportToOtherAuthorisedGraph, context, store);

    // Assert
    verify(exportToOtherAuthorisedGraph).getOption("gaffer.federatedstore.operation.graphIds");
    verify(exportToOtherAuthorisedGraph).getOptions();
    verify(exportToOtherAuthorisedGraph).setOptions(isA(Map.class));
    verify(store).execute(isA(Output.class), isA(Context.class));
    assertNull(actualDoOperationResult);
  }
}
