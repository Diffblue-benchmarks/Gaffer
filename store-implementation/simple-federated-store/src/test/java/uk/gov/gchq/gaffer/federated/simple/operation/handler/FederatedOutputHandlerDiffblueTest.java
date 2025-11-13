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
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
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
import uk.gov.gchq.gaffer.federated.simple.util.FederatedTestUtils;
import uk.gov.gchq.gaffer.federated.simple.util.FederatedTestUtils.StoreType;
import uk.gov.gchq.gaffer.graph.GraphSerialisable;
import uk.gov.gchq.gaffer.named.operation.NamedOperation;
import uk.gov.gchq.gaffer.operation.OperationChain;
import uk.gov.gchq.gaffer.operation.OperationException;
import uk.gov.gchq.gaffer.operation.io.Output;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.Store;
import uk.gov.gchq.gaffer.store.StoreProperties;
import uk.gov.gchq.gaffer.store.schema.Schema;

class FederatedOutputHandlerDiffblueTest {
  /**
   * Test {@link FederatedOutputHandler#doOperation(Output, Context, Store)} with {@code Output},
   * {@code Context}, {@code Store}.
   *
   * <p>Method under test: {@link FederatedOutputHandler#doOperation(Output, Context, Store)}
   */
  @Test
  @DisplayName("Test doOperation(Output, Context, Store) with 'Output', 'Context', 'Store'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object FederatedOutputHandler.doOperation(Output, Context, Store)"})
  void testDoOperationWithOutputContextStore() throws OperationException {
    // Arrange
    FederatedOutputHandler<Output<Object>, Object> federatedOutputHandler =
        new FederatedOutputHandler<>();

    NamedOperation<Object, Object> namedOperation = new NamedOperation<>();
    namedOperation.addOption(FederatedOperationHandler.OPT_FIX_OP_LIMIT, "42");
    Context context = new Context();

    // Act and Assert
    assertNull(federatedOutputHandler.doOperation(namedOperation, context, new FederatedStore()));
  }

  /**
   * Test {@link FederatedOutputHandler#doOperation(Output, Context, Store)} with {@code Output},
   * {@code Context}, {@code Store}.
   *
   * <ul>
   *   <li>When {@link NamedOperation} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedOutputHandler#doOperation(Output, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(Output, Context, Store) with 'Output', 'Context', 'Store'; when NamedOperation (default constructor); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object FederatedOutputHandler.doOperation(Output, Context, Store)"})
  void testDoOperationWithOutputContextStore_whenNamedOperation_thenReturnNull()
      throws OperationException {
    // Arrange
    FederatedOutputHandler<Output<Object>, Object> federatedOutputHandler =
        new FederatedOutputHandler<>();
    NamedOperation<Object, Object> namedOperation = new NamedOperation<>();
    Context context = new Context();

    // Act and Assert
    assertNull(federatedOutputHandler.doOperation(namedOperation, context, new FederatedStore()));
  }

  /**
   * Test {@link FederatedOutputHandler#doOperation(Output, Context, Store)} with {@code Output},
   * {@code Context}, {@code Store}.
   *
   * <ul>
   *   <li>When wrap {@link NamedOperation} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedOutputHandler#doOperation(Output, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(Output, Context, Store) with 'Output', 'Context', 'Store'; when wrap NamedOperation (default constructor); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object FederatedOutputHandler.doOperation(Output, Context, Store)"})
  void testDoOperationWithOutputContextStore_whenWrapNamedOperation_thenReturnNull()
      throws OperationException {
    // Arrange
    FederatedOutputHandler<Output<Object>, Object> federatedOutputHandler =
        new FederatedOutputHandler<>();
    OperationChain<Object> wrapResult = OperationChain.wrap(new NamedOperation<>());
    Context context = new Context();

    // Act and Assert
    assertNull(federatedOutputHandler.doOperation(wrapResult, context, new FederatedStore()));
  }

  /**
   * Test {@link FederatedOutputHandler#getResultAccumulator(FederatedStore, Output, List)}.
   *
   * <p>Method under test: {@link FederatedOutputHandler#getResultAccumulator(FederatedStore,
   * Output, List)}
   */
  @Test
  @DisplayName("Test getResultAccumulator(FederatedStore, Output, List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FederatedResultAccumulator FederatedOutputHandler.getResultAccumulator(FederatedStore, Output, List)"
  })
  void testGetResultAccumulator() {
    // Arrange
    FederatedOutputHandler<Output<Object>, Object> federatedOutputHandler =
        new FederatedOutputHandler<>();

    FederatedStore store = mock(FederatedStore.class);
    when(store.getSchema(Mockito.<List<GraphSerialisable>>any()))
        .thenThrow(new UnsupportedOperationException());
    when(store.getProperties()).thenReturn(FederatedTestUtils.getStoreProperties(StoreType.MAP));
    NamedOperation<Object, Object> namedOperation = new NamedOperation<>();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            federatedOutputHandler.getResultAccumulator(store, namedOperation, new ArrayList<>()));
    verify(store).getSchema(isA(List.class));
    verify(store).getProperties();
  }

  /**
   * Test {@link FederatedOutputHandler#getResultAccumulator(FederatedStore, Output, List)}.
   *
   * <ul>
   *   <li>Given {@code Option}.
   *   <li>When {@link Output} {@link Output#getOption(String)} return {@code Option}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedOutputHandler#getResultAccumulator(FederatedStore,
   * Output, List)}
   */
  @Test
  @DisplayName(
      "Test getResultAccumulator(FederatedStore, Output, List); given 'Option'; when Output getOption(String) return 'Option'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FederatedResultAccumulator FederatedOutputHandler.getResultAccumulator(FederatedStore, Output, List)"
  })
  void testGetResultAccumulator_givenOption_whenOutputGetOptionReturnOption() {
    // Arrange
    FederatedOutputHandler<Output<Object>, Object> federatedOutputHandler =
        new FederatedOutputHandler<>();

    StoreProperties storeProperties = mock(StoreProperties.class);
    when(storeProperties.getProperties()).thenReturn(new Properties());

    FederatedStore store = mock(FederatedStore.class);
    when(store.getSchema(Mockito.<List<GraphSerialisable>>any())).thenReturn(new Schema());
    when(store.getProperties()).thenReturn(storeProperties);

    Output<Object> output = mock(Output.class);
    when(output.getOption(Mockito.<String>any())).thenReturn("Option");
    when(output.getOptions()).thenReturn(new HashMap<>());
    when(output.containsOption(Mockito.<String>any())).thenReturn(true);
    doNothing().when(output).addOption(Mockito.<String>any(), Mockito.<String>any());
    output.addOption(",", "42");

    // Act
    FederatedResultAccumulator<Object> actualResultAccumulator =
        federatedOutputHandler.getResultAccumulator(store, output, new ArrayList<>());

    // Assert
    verify(store).getSchema(isA(List.class));
    verify(output).addOption(",", "42");
    verify(output).containsOption("federated.aggregateElements");
    verify(output).getOption("federated.aggregateElements");
    verify(output, atLeast(1)).getOptions();
    verify(store).getProperties();
    verify(storeProperties).getProperties();
    assertTrue(actualResultAccumulator instanceof DefaultResultAccumulator);
    assertFalse(actualResultAccumulator.aggregateElements());
  }

  /**
   * Test {@link FederatedOutputHandler#getResultAccumulator(FederatedStore, Output, List)}.
   *
   * <ul>
   *   <li>Then {@link NamedOperation} (default constructor) Options is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedOutputHandler#getResultAccumulator(FederatedStore,
   * Output, List)}
   */
  @Test
  @DisplayName(
      "Test getResultAccumulator(FederatedStore, Output, List); then NamedOperation (default constructor) Options is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FederatedResultAccumulator FederatedOutputHandler.getResultAccumulator(FederatedStore, Output, List)"
  })
  void testGetResultAccumulator_thenNamedOperationOptionsIsNull() {
    // Arrange
    FederatedOutputHandler<Output<Object>, Object> federatedOutputHandler =
        new FederatedOutputHandler<>();

    FederatedStore store = mock(FederatedStore.class);
    when(store.getSchema(Mockito.<List<GraphSerialisable>>any())).thenReturn(new Schema());
    when(store.getProperties()).thenReturn(FederatedTestUtils.getStoreProperties(StoreType.MAP));
    NamedOperation<Object, Object> namedOperation = new NamedOperation<>();

    // Act
    FederatedResultAccumulator<Object> actualResultAccumulator =
        federatedOutputHandler.getResultAccumulator(store, namedOperation, new ArrayList<>());

    // Assert
    verify(store).getSchema(isA(List.class));
    verify(store).getProperties();
    assertTrue(actualResultAccumulator instanceof DefaultResultAccumulator);
    assertNull(namedOperation.getOptions());
    assertFalse(actualResultAccumulator.aggregateElements());
  }

  /**
   * Test {@link FederatedOutputHandler#getResultAccumulator(FederatedStore, Output, List)}.
   *
   * <ul>
   *   <li>Then {@link NamedOperation} (default constructor) Options is {@link
   *       Properties#Properties()}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedOutputHandler#getResultAccumulator(FederatedStore,
   * Output, List)}
   */
  @Test
  @DisplayName(
      "Test getResultAccumulator(FederatedStore, Output, List); then NamedOperation (default constructor) Options is Properties()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FederatedResultAccumulator FederatedOutputHandler.getResultAccumulator(FederatedStore, Output, List)"
  })
  void testGetResultAccumulator_thenNamedOperationOptionsIsProperties() {
    // Arrange
    FederatedOutputHandler<Output<Object>, Object> federatedOutputHandler =
        new FederatedOutputHandler<>();

    StoreProperties storeProperties = mock(StoreProperties.class);
    Properties properties = new Properties();
    when(storeProperties.getProperties()).thenReturn(properties);

    FederatedStore store = mock(FederatedStore.class);
    when(store.getSchema(Mockito.<List<GraphSerialisable>>any())).thenReturn(new Schema());
    when(store.getProperties()).thenReturn(storeProperties);

    NamedOperation<Object, Object> namedOperation = new NamedOperation<>();
    namedOperation.addOption("gaffer.store.federated.merge.number.class", ",");
    namedOperation.addOption(",", "42");

    // Act
    FederatedResultAccumulator<Object> actualResultAccumulator =
        federatedOutputHandler.getResultAccumulator(store, namedOperation, new ArrayList<>());

    // Assert
    verify(store).getSchema(isA(List.class));
    verify(store).getProperties();
    verify(storeProperties).getProperties();
    assertTrue(actualResultAccumulator instanceof DefaultResultAccumulator);
    assertFalse(actualResultAccumulator.aggregateElements());
    assertEquals(properties, namedOperation.getOptions());
  }

  /**
   * Test {@link FederatedOutputHandler#getResultAccumulator(FederatedStore, Output, List)}.
   *
   * <ul>
   *   <li>Then {@link NamedOperation} (default constructor) Options size is one.
   * </ul>
   *
   * <p>Method under test: {@link FederatedOutputHandler#getResultAccumulator(FederatedStore,
   * Output, List)}
   */
  @Test
  @DisplayName(
      "Test getResultAccumulator(FederatedStore, Output, List); then NamedOperation (default constructor) Options size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FederatedResultAccumulator FederatedOutputHandler.getResultAccumulator(FederatedStore, Output, List)"
  })
  void testGetResultAccumulator_thenNamedOperationOptionsSizeIsOne() {
    // Arrange
    FederatedOutputHandler<Output<Object>, Object> federatedOutputHandler =
        new FederatedOutputHandler<>();

    StoreProperties storeProperties = mock(StoreProperties.class);
    when(storeProperties.getProperties()).thenReturn(new Properties());

    FederatedStore store = mock(FederatedStore.class);
    when(store.getSchema(Mockito.<List<GraphSerialisable>>any())).thenReturn(new Schema());
    when(store.getProperties()).thenReturn(storeProperties);

    NamedOperation<Object, Object> namedOperation = new NamedOperation<>();
    namedOperation.addOption(",", "42");

    // Act
    FederatedResultAccumulator<Object> actualResultAccumulator =
        federatedOutputHandler.getResultAccumulator(store, namedOperation, new ArrayList<>());

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
   *
   * <ul>
   *   <li>When {@link NamedOperation} (default constructor).
   *   <li>Then {@link NamedOperation} (default constructor) Options is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedOutputHandler#getResultAccumulator(FederatedStore,
   * Output, List)}
   */
  @Test
  @DisplayName(
      "Test getResultAccumulator(FederatedStore, Output, List); when NamedOperation (default constructor); then NamedOperation (default constructor) Options is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FederatedResultAccumulator FederatedOutputHandler.getResultAccumulator(FederatedStore, Output, List)"
  })
  void testGetResultAccumulator_whenNamedOperation_thenNamedOperationOptionsIsNull() {
    // Arrange
    FederatedOutputHandler<Output<Object>, Object> federatedOutputHandler =
        new FederatedOutputHandler<>();

    StoreProperties storeProperties = mock(StoreProperties.class);
    when(storeProperties.getProperties()).thenReturn(new Properties());

    FederatedStore store = mock(FederatedStore.class);
    when(store.getSchema(Mockito.<List<GraphSerialisable>>any())).thenReturn(new Schema());
    when(store.getProperties()).thenReturn(storeProperties);
    NamedOperation<Object, Object> namedOperation = new NamedOperation<>();

    // Act
    FederatedResultAccumulator<Object> actualResultAccumulator =
        federatedOutputHandler.getResultAccumulator(store, namedOperation, new ArrayList<>());

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
   *
   * <ul>
   *   <li>When {@link Output} {@link Output#getOption(String)} throw {@link
   *       UnsupportedOperationException#UnsupportedOperationException()}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedOutputHandler#getResultAccumulator(FederatedStore,
   * Output, List)}
   */
  @Test
  @DisplayName(
      "Test getResultAccumulator(FederatedStore, Output, List); when Output getOption(String) throw UnsupportedOperationException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FederatedResultAccumulator FederatedOutputHandler.getResultAccumulator(FederatedStore, Output, List)"
  })
  void testGetResultAccumulator_whenOutputGetOptionThrowUnsupportedOperationException() {
    // Arrange
    FederatedOutputHandler<Output<Object>, Object> federatedOutputHandler =
        new FederatedOutputHandler<>();

    StoreProperties storeProperties = mock(StoreProperties.class);
    when(storeProperties.getProperties()).thenReturn(new Properties());

    FederatedStore store = mock(FederatedStore.class);
    when(store.getSchema(Mockito.<List<GraphSerialisable>>any())).thenReturn(new Schema());
    when(store.getProperties()).thenReturn(storeProperties);

    Output<Object> output = mock(Output.class);
    when(output.getOption(Mockito.<String>any())).thenThrow(new UnsupportedOperationException());
    when(output.getOptions()).thenReturn(new HashMap<>());
    when(output.containsOption(Mockito.<String>any())).thenReturn(true);
    doNothing().when(output).addOption(Mockito.<String>any(), Mockito.<String>any());
    output.addOption(",", "42");

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> federatedOutputHandler.getResultAccumulator(store, output, new ArrayList<>()));
    verify(store).getSchema(isA(List.class));
    verify(output).addOption(",", "42");
    verify(output).containsOption("federated.aggregateElements");
    verify(output).getOption("federated.aggregateElements");
    verify(output, atLeast(1)).getOptions();
    verify(store).getProperties();
    verify(storeProperties).getProperties();
  }

  /**
   * Test {@link FederatedOutputHandler#getResultAccumulator(FederatedStore, Output, List)}.
   *
   * <ul>
   *   <li>When wrap {@link NamedOperation} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link FederatedOutputHandler#getResultAccumulator(FederatedStore,
   * Output, List)}
   */
  @Test
  @DisplayName(
      "Test getResultAccumulator(FederatedStore, Output, List); when wrap NamedOperation (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FederatedResultAccumulator FederatedOutputHandler.getResultAccumulator(FederatedStore, Output, List)"
  })
  void testGetResultAccumulator_whenWrapNamedOperation() {
    // Arrange
    FederatedOutputHandler<Output<Object>, Object> federatedOutputHandler =
        new FederatedOutputHandler<>();

    StoreProperties storeProperties = mock(StoreProperties.class);
    when(storeProperties.getProperties()).thenReturn(new Properties());

    FederatedStore store = mock(FederatedStore.class);
    when(store.getSchema(Mockito.<List<GraphSerialisable>>any())).thenReturn(new Schema());
    when(store.getProperties()).thenReturn(storeProperties);
    OperationChain<Object> wrapResult = OperationChain.wrap(new NamedOperation<>());

    // Act
    FederatedResultAccumulator<Object> actualResultAccumulator =
        federatedOutputHandler.getResultAccumulator(store, wrapResult, new ArrayList<>());

    // Assert
    verify(store).getSchema(isA(List.class));
    verify(store).getProperties();
    verify(storeProperties).getProperties();
    assertTrue(actualResultAccumulator instanceof DefaultResultAccumulator);
    assertFalse(actualResultAccumulator.aggregateElements());
  }
}
