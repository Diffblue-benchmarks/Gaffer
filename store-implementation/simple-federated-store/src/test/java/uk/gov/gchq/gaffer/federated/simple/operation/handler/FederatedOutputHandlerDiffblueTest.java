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

package uk.gov.gchq.gaffer.federated.simple.operation.handler;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uk.gov.gchq.gaffer.federated.simple.FederatedStore;
import uk.gov.gchq.gaffer.federated.simple.merge.DefaultResultAccumulator;
import uk.gov.gchq.gaffer.federated.simple.merge.FederatedResultAccumulator;
import uk.gov.gchq.gaffer.graph.GraphSerialisable;
import uk.gov.gchq.gaffer.named.operation.NamedOperation;
import uk.gov.gchq.gaffer.operation.Operation;
import uk.gov.gchq.gaffer.operation.OperationChain;
import uk.gov.gchq.gaffer.operation.OperationException;
import uk.gov.gchq.gaffer.operation.io.Output;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.Store;
import uk.gov.gchq.gaffer.store.StoreProperties;
import uk.gov.gchq.gaffer.store.schema.Schema;

class FederatedOutputHandlerDiffblueTest {
  /**
   * Test {@link FederatedOutputHandler#doOperation(Output, Context, Store)} with {@code Output}, {@code Context}, {@code Store}.
   * <p>
   * Method under test: {@link FederatedOutputHandler#doOperation(Output, Context, Store)}
   */
  @Test
  @DisplayName("Test doOperation(Output, Context, Store) with 'Output', 'Context', 'Store'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object FederatedOutputHandler.doOperation(Output, Context, Store)"})
  void testDoOperationWithOutputContextStore() throws OperationException {
    // Arrange
    FederatedOutputHandler<Output<Object>, Object> federatedOutputHandler = new FederatedOutputHandler<>();

    NamedOperation<Object, Object> namedOperation = new NamedOperation<>();
    namedOperation.addOption(FederatedOperationHandler.OPT_FIX_OP_LIMIT, "42");
    Context context = new Context();

    // Act and Assert
    assertNull(federatedOutputHandler.doOperation(namedOperation, context, new FederatedStore()));
  }

  /**
   * Test {@link FederatedOutputHandler#doOperation(Output, Context, Store)} with {@code Output}, {@code Context}, {@code Store}.
   * <ul>
   *   <li>When {@link NamedOperation} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FederatedOutputHandler#doOperation(Output, Context, Store)}
   */
  @Test
  @DisplayName("Test doOperation(Output, Context, Store) with 'Output', 'Context', 'Store'; when NamedOperation (default constructor); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object FederatedOutputHandler.doOperation(Output, Context, Store)"})
  void testDoOperationWithOutputContextStore_whenNamedOperation_thenReturnNull() throws OperationException {
    // Arrange
    FederatedOutputHandler<Output<Object>, Object> federatedOutputHandler = new FederatedOutputHandler<>();
    NamedOperation<Object, Object> namedOperation = new NamedOperation<>();
    Context context = new Context();

    // Act and Assert
    assertNull(federatedOutputHandler.doOperation(namedOperation, context, new FederatedStore()));
  }

  /**
   * Test {@link FederatedOutputHandler#doOperation(Output, Context, Store)} with {@code Output}, {@code Context}, {@code Store}.
   * <ul>
   *   <li>When {@link OperationChain#OperationChain()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FederatedOutputHandler#doOperation(Output, Context, Store)}
   */
  @Test
  @DisplayName("Test doOperation(Output, Context, Store) with 'Output', 'Context', 'Store'; when OperationChain(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object FederatedOutputHandler.doOperation(Output, Context, Store)"})
  void testDoOperationWithOutputContextStore_whenOperationChain_thenReturnNull() throws OperationException {
    // Arrange
    FederatedOutputHandler<Output<Object>, Object> federatedOutputHandler = new FederatedOutputHandler<>();
    OperationChain<Object> operationChain = new OperationChain<>();
    Context context = new Context();

    // Act and Assert
    assertNull(federatedOutputHandler.doOperation(operationChain, context, new FederatedStore()));
  }

  /**
   * Test {@link FederatedOutputHandler#getResultAccumulator(FederatedStore, Output, List)}.
   * <p>
   * Method under test: {@link FederatedOutputHandler#getResultAccumulator(FederatedStore, Output, List)}
   */
  @Test
  @DisplayName("Test getResultAccumulator(FederatedStore, Output, List)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "FederatedResultAccumulator FederatedOutputHandler.getResultAccumulator(FederatedStore, Output, List)"})
  void testGetResultAccumulator() {
    // Arrange
    FederatedOutputHandler<Output<Object>, Object> federatedOutputHandler = new FederatedOutputHandler<>();
    FederatedStore store = mock(FederatedStore.class);
    when(store.getSchema(Mockito.<List<GraphSerialisable>>any())).thenThrow(new UnsupportedOperationException(","));
    when(store.getProperties()).thenReturn(new StoreProperties());
    NamedOperation<Object, Object> namedOperation = new NamedOperation<>();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> federatedOutputHandler.getResultAccumulator(store, namedOperation, new ArrayList<>()));
    verify(store).getSchema(isA(List.class));
    verify(store).getProperties();
  }

  /**
   * Test {@link FederatedOutputHandler#getResultAccumulator(FederatedStore, Output, List)}.
   * <p>
   * Method under test: {@link FederatedOutputHandler#getResultAccumulator(FederatedStore, Output, List)}
   */
  @Test
  @DisplayName("Test getResultAccumulator(FederatedStore, Output, List)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "FederatedResultAccumulator FederatedOutputHandler.getResultAccumulator(FederatedStore, Output, List)"})
  void testGetResultAccumulator2() {
    // Arrange
    FederatedOutputHandler<Output<Object>, Object> federatedOutputHandler = new FederatedOutputHandler<>();
    StoreProperties storeProperties = mock(StoreProperties.class);
    when(storeProperties.getProperties()).thenReturn(new Properties());
    FederatedStore store = mock(FederatedStore.class);
    when(store.getSchema(Mockito.<List<GraphSerialisable>>any())).thenReturn(new Schema());
    when(store.getProperties()).thenReturn(storeProperties);

    HashMap<String, String> stringStringMap = new HashMap<>();
    stringStringMap.put("gaffer.store.federated.merge.number.class", "gaffer.store.federated.merge.number.class");
    Output<Object> output = mock(Output.class);
    when(output.getOption(Mockito.<String>any())).thenThrow(new UnsupportedOperationException(","));
    when(output.getOptions()).thenReturn(stringStringMap);
    when(output.containsOption(Mockito.<String>any())).thenReturn(true);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> federatedOutputHandler.getResultAccumulator(store, output, new ArrayList<>()));
    verify(store).getSchema(isA(List.class));
    verify(output).containsOption(eq("federated.aggregateElements"));
    verify(output).getOption(eq("federated.aggregateElements"));
    verify(output, atLeast(1)).getOptions();
    verify(store).getProperties();
    verify(storeProperties).getProperties();
  }

  /**
   * Test {@link FederatedOutputHandler#getResultAccumulator(FederatedStore, Output, List)}.
   * <ul>
   *   <li>Given {@code ,}.</li>
   *   <li>Then {@link NamedOperation} (default constructor) Options size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link FederatedOutputHandler#getResultAccumulator(FederatedStore, Output, List)}
   */
  @Test
  @DisplayName("Test getResultAccumulator(FederatedStore, Output, List); given ','; then NamedOperation (default constructor) Options size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "FederatedResultAccumulator FederatedOutputHandler.getResultAccumulator(FederatedStore, Output, List)"})
  void testGetResultAccumulator_givenComma_thenNamedOperationOptionsSizeIsOne() {
    // Arrange
    FederatedOutputHandler<Output<Object>, Object> federatedOutputHandler = new FederatedOutputHandler<>();
    StoreProperties storeProperties = mock(StoreProperties.class);
    when(storeProperties.getProperties()).thenReturn(new Properties());
    FederatedStore store = mock(FederatedStore.class);
    when(store.getSchema(Mockito.<List<GraphSerialisable>>any())).thenReturn(new Schema());
    when(store.getProperties()).thenReturn(storeProperties);

    NamedOperation<Object, Object> namedOperation = new NamedOperation<>();
    namedOperation.addOption(",", "42");

    // Act
    FederatedResultAccumulator<Object> actualResultAccumulator = federatedOutputHandler.getResultAccumulator(store,
        namedOperation, new ArrayList<>());

    // Assert
    verify(store).getSchema(isA(List.class));
    verify(store).getProperties();
    verify(storeProperties).getProperties();
    assertTrue(actualResultAccumulator instanceof DefaultResultAccumulator);
    Map<String, String> options = namedOperation.getOptions();
    assertEquals(1, options.size());
    assertFalse(actualResultAccumulator.aggregateElements());
    assertTrue(options.containsKey(","));
  }

  /**
   * Test {@link FederatedOutputHandler#getResultAccumulator(FederatedStore, Output, List)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FederatedOutputHandler#getResultAccumulator(FederatedStore, Output, List)}
   */
  @Test
  @DisplayName("Test getResultAccumulator(FederatedStore, Output, List); given HashMap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "FederatedResultAccumulator FederatedOutputHandler.getResultAccumulator(FederatedStore, Output, List)"})
  void testGetResultAccumulator_givenHashMap() {
    // Arrange
    FederatedOutputHandler<Output<Object>, Object> federatedOutputHandler = new FederatedOutputHandler<>();
    StoreProperties storeProperties = mock(StoreProperties.class);
    when(storeProperties.getProperties()).thenReturn(new Properties());
    FederatedStore store = mock(FederatedStore.class);
    when(store.getSchema(Mockito.<List<GraphSerialisable>>any())).thenReturn(new Schema());
    when(store.getProperties()).thenReturn(storeProperties);
    Output<Object> output = mock(Output.class);
    when(output.getOption(Mockito.<String>any())).thenThrow(new UnsupportedOperationException(","));
    when(output.getOptions()).thenReturn(new HashMap<>());
    when(output.containsOption(Mockito.<String>any())).thenReturn(true);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> federatedOutputHandler.getResultAccumulator(store, output, new ArrayList<>()));
    verify(store).getSchema(isA(List.class));
    verify(output).containsOption(eq("federated.aggregateElements"));
    verify(output).getOption(eq("federated.aggregateElements"));
    verify(output, atLeast(1)).getOptions();
    verify(store).getProperties();
    verify(storeProperties).getProperties();
  }

  /**
   * Test {@link FederatedOutputHandler#getResultAccumulator(FederatedStore, Output, List)}.
   * <ul>
   *   <li>Given {@code Option}.</li>
   *   <li>When {@link Output} {@link Operation#getOption(String)} return {@code Option}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FederatedOutputHandler#getResultAccumulator(FederatedStore, Output, List)}
   */
  @Test
  @DisplayName("Test getResultAccumulator(FederatedStore, Output, List); given 'Option'; when Output getOption(String) return 'Option'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "FederatedResultAccumulator FederatedOutputHandler.getResultAccumulator(FederatedStore, Output, List)"})
  void testGetResultAccumulator_givenOption_whenOutputGetOptionReturnOption() {
    // Arrange
    FederatedOutputHandler<Output<Object>, Object> federatedOutputHandler = new FederatedOutputHandler<>();
    StoreProperties storeProperties = mock(StoreProperties.class);
    when(storeProperties.getProperties()).thenReturn(new Properties());
    FederatedStore store = mock(FederatedStore.class);
    when(store.getSchema(Mockito.<List<GraphSerialisable>>any())).thenReturn(new Schema());
    when(store.getProperties()).thenReturn(storeProperties);
    Output<Object> output = mock(Output.class);
    when(output.getOption(Mockito.<String>any())).thenReturn("Option");
    when(output.getOptions()).thenReturn(new HashMap<>());
    when(output.containsOption(Mockito.<String>any())).thenReturn(true);

    // Act
    FederatedResultAccumulator<Object> actualResultAccumulator = federatedOutputHandler.getResultAccumulator(store,
        output, new ArrayList<>());

    // Assert
    verify(store).getSchema(isA(List.class));
    verify(output).containsOption(eq("federated.aggregateElements"));
    verify(output).getOption(eq("federated.aggregateElements"));
    verify(output, atLeast(1)).getOptions();
    verify(store).getProperties();
    verify(storeProperties).getProperties();
    assertTrue(actualResultAccumulator instanceof DefaultResultAccumulator);
    assertFalse(actualResultAccumulator.aggregateElements());
  }

  /**
   * Test {@link FederatedOutputHandler#getResultAccumulator(FederatedStore, Output, List)}.
   * <ul>
   *   <li>Given {@link StoreProperties#StoreProperties()}.</li>
   *   <li>Then {@link NamedOperation} (default constructor) Options is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FederatedOutputHandler#getResultAccumulator(FederatedStore, Output, List)}
   */
  @Test
  @DisplayName("Test getResultAccumulator(FederatedStore, Output, List); given StoreProperties(); then NamedOperation (default constructor) Options is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "FederatedResultAccumulator FederatedOutputHandler.getResultAccumulator(FederatedStore, Output, List)"})
  void testGetResultAccumulator_givenStoreProperties_thenNamedOperationOptionsIsNull() {
    // Arrange
    FederatedOutputHandler<Output<Object>, Object> federatedOutputHandler = new FederatedOutputHandler<>();
    FederatedStore store = mock(FederatedStore.class);
    when(store.getSchema(Mockito.<List<GraphSerialisable>>any())).thenReturn(new Schema());
    when(store.getProperties()).thenReturn(new StoreProperties());
    NamedOperation<Object, Object> namedOperation = new NamedOperation<>();

    // Act
    FederatedResultAccumulator<Object> actualResultAccumulator = federatedOutputHandler.getResultAccumulator(store,
        namedOperation, new ArrayList<>());

    // Assert
    verify(store).getSchema(isA(List.class));
    verify(store).getProperties();
    assertTrue(actualResultAccumulator instanceof DefaultResultAccumulator);
    assertNull(namedOperation.getOptions());
    assertFalse(actualResultAccumulator.aggregateElements());
  }

  /**
   * Test {@link FederatedOutputHandler#getResultAccumulator(FederatedStore, Output, List)}.
   * <ul>
   *   <li>When {@link NamedOperation} (default constructor).</li>
   *   <li>Then {@link NamedOperation} (default constructor) Options is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FederatedOutputHandler#getResultAccumulator(FederatedStore, Output, List)}
   */
  @Test
  @DisplayName("Test getResultAccumulator(FederatedStore, Output, List); when NamedOperation (default constructor); then NamedOperation (default constructor) Options is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "FederatedResultAccumulator FederatedOutputHandler.getResultAccumulator(FederatedStore, Output, List)"})
  void testGetResultAccumulator_whenNamedOperation_thenNamedOperationOptionsIsNull() {
    // Arrange
    FederatedOutputHandler<Output<Object>, Object> federatedOutputHandler = new FederatedOutputHandler<>();
    StoreProperties storeProperties = mock(StoreProperties.class);
    when(storeProperties.getProperties()).thenReturn(new Properties());
    FederatedStore store = mock(FederatedStore.class);
    when(store.getSchema(Mockito.<List<GraphSerialisable>>any())).thenReturn(new Schema());
    when(store.getProperties()).thenReturn(storeProperties);
    NamedOperation<Object, Object> namedOperation = new NamedOperation<>();

    // Act
    FederatedResultAccumulator<Object> actualResultAccumulator = federatedOutputHandler.getResultAccumulator(store,
        namedOperation, new ArrayList<>());

    // Assert
    verify(store).getSchema(isA(List.class));
    verify(store).getProperties();
    verify(storeProperties).getProperties();
    assertTrue(actualResultAccumulator instanceof DefaultResultAccumulator);
    assertNull(namedOperation.getOptions());
    assertFalse(actualResultAccumulator.aggregateElements());
  }

  /**
   * Test {@link FederatedOutputHandler#getResultAccumulator(FederatedStore, Output, List)}.
   * <ul>
   *   <li>When {@link OperationChain#OperationChain()}.</li>
   *   <li>Then return {@link DefaultResultAccumulator}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FederatedOutputHandler#getResultAccumulator(FederatedStore, Output, List)}
   */
  @Test
  @DisplayName("Test getResultAccumulator(FederatedStore, Output, List); when OperationChain(); then return DefaultResultAccumulator")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "FederatedResultAccumulator FederatedOutputHandler.getResultAccumulator(FederatedStore, Output, List)"})
  void testGetResultAccumulator_whenOperationChain_thenReturnDefaultResultAccumulator() {
    // Arrange
    FederatedOutputHandler<Output<Object>, Object> federatedOutputHandler = new FederatedOutputHandler<>();
    StoreProperties storeProperties = mock(StoreProperties.class);
    when(storeProperties.getProperties()).thenReturn(new Properties());
    FederatedStore store = mock(FederatedStore.class);
    when(store.getSchema(Mockito.<List<GraphSerialisable>>any())).thenReturn(new Schema());
    when(store.getProperties()).thenReturn(storeProperties);
    OperationChain<Object> operationChain = new OperationChain<>();

    // Act
    FederatedResultAccumulator<Object> actualResultAccumulator = federatedOutputHandler.getResultAccumulator(store,
        operationChain, new ArrayList<>());

    // Assert
    verify(store).getSchema(isA(List.class));
    verify(store).getProperties();
    verify(storeProperties).getProperties();
    assertTrue(actualResultAccumulator instanceof DefaultResultAccumulator);
    assertFalse(actualResultAccumulator.aggregateElements());
  }
}
