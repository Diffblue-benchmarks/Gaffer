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

package uk.gov.gchq.gaffer.federatedstore;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.core.exception.GafferRuntimeException;
import uk.gov.gchq.gaffer.federatedstore.operation.AddGraphWithHooks;
import uk.gov.gchq.gaffer.federatedstore.operation.FederatedOperationChainValidator;
import uk.gov.gchq.gaffer.federatedstore.operation.GetAllGraphIds;
import uk.gov.gchq.gaffer.federatedstore.operation.IFederationOperation;
import uk.gov.gchq.gaffer.federatedstore.operation.RemoveGraph;
import uk.gov.gchq.gaffer.federatedstore.operation.handler.impl.FederatedNoOutputHandler;
import uk.gov.gchq.gaffer.federatedstore.operation.handler.impl.FederatedOutputHandler;
import uk.gov.gchq.gaffer.federatedstore.operation.handler.impl.FederatedOutputIterableHandler;
import uk.gov.gchq.gaffer.federatedstore.util.ApplyViewToElementsFunction;
import uk.gov.gchq.gaffer.federatedstore.util.MergeSchema;
import uk.gov.gchq.gaffer.operation.Operation;
import uk.gov.gchq.gaffer.operation.export.graph.ExportToOtherAuthorisedGraph;
import uk.gov.gchq.gaffer.operation.impl.function.Aggregate;
import uk.gov.gchq.gaffer.operation.impl.function.Filter;
import uk.gov.gchq.gaffer.operation.impl.join.Join;
import uk.gov.gchq.gaffer.serialisation.Serialiser;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.StoreException;
import uk.gov.gchq.gaffer.store.StoreProperties;
import uk.gov.gchq.gaffer.store.library.FileGraphLibrary;
import uk.gov.gchq.gaffer.store.library.GraphLibrary;
import uk.gov.gchq.gaffer.store.schema.Schema;
import uk.gov.gchq.gaffer.user.User;
import uk.gov.gchq.koryphe.impl.binaryoperator.CollectionIntersect;

class FederatedStoreDiffblueTest {
  /**
   * Test {@link FederatedStore#FederatedStore()}.
   *
   * <p>Method under test: {@link FederatedStore#FederatedStore()}
   */
  @Test
  @DisplayName("Test new FederatedStore()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FederatedStore.<init>()"})
  void testNewFederatedStore() {
    // Arrange and Act
    FederatedStore actualFederatedStore = new FederatedStore();

    // Assert
    assertTrue(
        actualFederatedStore.getOperationChainValidator()
            instanceof FederatedOperationChainValidator);
    assertTrue(actualFederatedStore.getAddElementsHandler() instanceof FederatedNoOutputHandler);
    assertTrue(actualFederatedStore.getDeleteAllDataHandler() instanceof FederatedNoOutputHandler);
    assertTrue(actualFederatedStore.getDeleteElementsHandler() instanceof FederatedOutputHandler);
    assertTrue(actualFederatedStore.getGetTraitsHandler() instanceof FederatedOutputHandler);
    assertTrue(
        actualFederatedStore.getAdjacentIdsHandler() instanceof FederatedOutputIterableHandler);
    assertTrue(
        actualFederatedStore.getGetAllElementsHandler() instanceof FederatedOutputIterableHandler);
    assertTrue(
        actualFederatedStore.getGetElementsHandler() instanceof FederatedOutputIterableHandler);
    assertNull(actualFederatedStore.getGraphId());
    assertNull(actualFederatedStore.getStoreConfiguredGraphIds());
    assertNull(actualFederatedStore.getProperties());
    assertNull(actualFederatedStore.getJobTracker());
    assertNull(actualFederatedStore.getGraphLibrary());
    Map<String, BiFunction> storeConfiguredMergeFunctions =
        actualFederatedStore.getStoreConfiguredMergeFunctions();
    assertEquals(4, storeConfiguredMergeFunctions.size());
    assertTrue(actualFederatedStore.getOperationChainOptimisers().isEmpty());
    assertTrue(
        storeConfiguredMergeFunctions.containsKey(
            "uk.gov.gchq.gaffer.operation.impl.get.GetAllElements"));
    assertTrue(
        storeConfiguredMergeFunctions.containsKey(
            "uk.gov.gchq.gaffer.operation.impl.get.GetElements"));
    assertTrue(
        storeConfiguredMergeFunctions.containsKey("uk.gov.gchq.gaffer.store.operation.GetSchema"));
    assertTrue(
        storeConfiguredMergeFunctions.containsKey("uk.gov.gchq.gaffer.store.operation.GetTraits"));
    assertTrue(actualFederatedStore.getExternallySupportedOperations().isEmpty());
    assertTrue(actualFederatedStore.getSupportedOperations().isEmpty());
    Class<FederatedStoreProperties> expectedPropertiesClass = FederatedStoreProperties.class;
    assertEquals(expectedPropertiesClass, actualFederatedStore.getPropertiesClass());
    Class<Serialiser> expectedRequiredParentSerialiserClass = Serialiser.class;
    assertEquals(
        expectedRequiredParentSerialiserClass,
        actualFederatedStore.getRequiredParentSerialiserClass());
  }

  /**
   * Test {@link FederatedStore#FederatedStore(Set, Boolean, List, Map)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link HashSet#HashSet()} add {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedStore#FederatedStore(Set, Boolean, List, Map)}
   */
  @Test
  @DisplayName(
      "Test new FederatedStore(Set, Boolean, List, Map); given '42'; when HashSet() add '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FederatedStore.<init>(Set, Boolean, List, Map)"})
  void testNewFederatedStore_given42_whenHashSetAdd42() {
    // Arrange
    HashSet<String> customPropertiesAuths = new HashSet<>();
    customPropertiesAuths.add("42");
    customPropertiesAuths.add("foo");
    ArrayList<String> storeConfiguredGraphIds = new ArrayList<>();

    // Act
    FederatedStore actualFederatedStore =
        new FederatedStore(customPropertiesAuths, true, storeConfiguredGraphIds, new HashMap<>());

    // Assert
    assertTrue(
        actualFederatedStore.getOperationChainValidator()
            instanceof FederatedOperationChainValidator);
    assertTrue(actualFederatedStore.getAddElementsHandler() instanceof FederatedNoOutputHandler);
    assertTrue(actualFederatedStore.getDeleteAllDataHandler() instanceof FederatedNoOutputHandler);
    assertTrue(actualFederatedStore.getDeleteElementsHandler() instanceof FederatedOutputHandler);
    assertTrue(actualFederatedStore.getGetTraitsHandler() instanceof FederatedOutputHandler);
    assertTrue(
        actualFederatedStore.getAdjacentIdsHandler() instanceof FederatedOutputIterableHandler);
    assertTrue(
        actualFederatedStore.getGetAllElementsHandler() instanceof FederatedOutputIterableHandler);
    assertTrue(
        actualFederatedStore.getGetElementsHandler() instanceof FederatedOutputIterableHandler);
    assertNull(actualFederatedStore.getGraphId());
    assertNull(actualFederatedStore.getProperties());
    assertNull(actualFederatedStore.getJobTracker());
    assertNull(actualFederatedStore.getGraphLibrary());
    Map<String, BiFunction> storeConfiguredMergeFunctions =
        actualFederatedStore.getStoreConfiguredMergeFunctions();
    assertEquals(4, storeConfiguredMergeFunctions.size());
    assertTrue(actualFederatedStore.getStoreConfiguredGraphIds().isEmpty());
    assertTrue(actualFederatedStore.getOperationChainOptimisers().isEmpty());
    assertTrue(
        storeConfiguredMergeFunctions.containsKey(
            "uk.gov.gchq.gaffer.operation.impl.get.GetAllElements"));
    assertTrue(
        storeConfiguredMergeFunctions.containsKey(
            "uk.gov.gchq.gaffer.operation.impl.get.GetElements"));
    assertTrue(
        storeConfiguredMergeFunctions.containsKey("uk.gov.gchq.gaffer.store.operation.GetSchema"));
    assertTrue(
        storeConfiguredMergeFunctions.containsKey("uk.gov.gchq.gaffer.store.operation.GetTraits"));
    assertTrue(actualFederatedStore.getExternallySupportedOperations().isEmpty());
    assertTrue(actualFederatedStore.getSupportedOperations().isEmpty());
    Class<FederatedStoreProperties> expectedPropertiesClass = FederatedStoreProperties.class;
    assertEquals(expectedPropertiesClass, actualFederatedStore.getPropertiesClass());
    Class<Serialiser> expectedRequiredParentSerialiserClass = Serialiser.class;
    assertEquals(
        expectedRequiredParentSerialiserClass,
        actualFederatedStore.getRequiredParentSerialiserClass());
  }

  /**
   * Test {@link FederatedStore#FederatedStore(Set, Boolean, List, Map)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>When {@link HashSet#HashSet()} add {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedStore#FederatedStore(Set, Boolean, List, Map)}
   */
  @Test
  @DisplayName(
      "Test new FederatedStore(Set, Boolean, List, Map); given 'foo'; when HashSet() add 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FederatedStore.<init>(Set, Boolean, List, Map)"})
  void testNewFederatedStore_givenFoo_whenHashSetAddFoo() {
    // Arrange
    HashSet<String> customPropertiesAuths = new HashSet<>();
    customPropertiesAuths.add("foo");
    ArrayList<String> storeConfiguredGraphIds = new ArrayList<>();

    // Act
    FederatedStore actualFederatedStore =
        new FederatedStore(customPropertiesAuths, true, storeConfiguredGraphIds, new HashMap<>());

    // Assert
    assertTrue(
        actualFederatedStore.getOperationChainValidator()
            instanceof FederatedOperationChainValidator);
    assertTrue(actualFederatedStore.getAddElementsHandler() instanceof FederatedNoOutputHandler);
    assertTrue(actualFederatedStore.getDeleteAllDataHandler() instanceof FederatedNoOutputHandler);
    assertTrue(actualFederatedStore.getDeleteElementsHandler() instanceof FederatedOutputHandler);
    assertTrue(actualFederatedStore.getGetTraitsHandler() instanceof FederatedOutputHandler);
    assertTrue(
        actualFederatedStore.getAdjacentIdsHandler() instanceof FederatedOutputIterableHandler);
    assertTrue(
        actualFederatedStore.getGetAllElementsHandler() instanceof FederatedOutputIterableHandler);
    assertTrue(
        actualFederatedStore.getGetElementsHandler() instanceof FederatedOutputIterableHandler);
    assertNull(actualFederatedStore.getGraphId());
    assertNull(actualFederatedStore.getProperties());
    assertNull(actualFederatedStore.getJobTracker());
    assertNull(actualFederatedStore.getGraphLibrary());
    Map<String, BiFunction> storeConfiguredMergeFunctions =
        actualFederatedStore.getStoreConfiguredMergeFunctions();
    assertEquals(4, storeConfiguredMergeFunctions.size());
    assertTrue(actualFederatedStore.getStoreConfiguredGraphIds().isEmpty());
    assertTrue(actualFederatedStore.getOperationChainOptimisers().isEmpty());
    assertTrue(
        storeConfiguredMergeFunctions.containsKey(
            "uk.gov.gchq.gaffer.operation.impl.get.GetAllElements"));
    assertTrue(
        storeConfiguredMergeFunctions.containsKey(
            "uk.gov.gchq.gaffer.operation.impl.get.GetElements"));
    assertTrue(
        storeConfiguredMergeFunctions.containsKey("uk.gov.gchq.gaffer.store.operation.GetSchema"));
    assertTrue(
        storeConfiguredMergeFunctions.containsKey("uk.gov.gchq.gaffer.store.operation.GetTraits"));
    assertTrue(actualFederatedStore.getExternallySupportedOperations().isEmpty());
    assertTrue(actualFederatedStore.getSupportedOperations().isEmpty());
    Class<FederatedStoreProperties> expectedPropertiesClass = FederatedStoreProperties.class;
    assertEquals(expectedPropertiesClass, actualFederatedStore.getPropertiesClass());
    Class<Serialiser> expectedRequiredParentSerialiserClass = Serialiser.class;
    assertEquals(
        expectedRequiredParentSerialiserClass,
        actualFederatedStore.getRequiredParentSerialiserClass());
  }

  /**
   * Test {@link FederatedStore#FederatedStore(Set, Boolean, List, Map)}.
   *
   * <ul>
   *   <li>Then return StoreConfiguredGraphIds is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedStore#FederatedStore(Set, Boolean, List, Map)}
   */
  @Test
  @DisplayName(
      "Test new FederatedStore(Set, Boolean, List, Map); then return StoreConfiguredGraphIds is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FederatedStore.<init>(Set, Boolean, List, Map)"})
  void testNewFederatedStore_thenReturnStoreConfiguredGraphIdsIsArrayList() {
    // Arrange
    HashSet<String> customPropertiesAuths = new HashSet<>();

    ArrayList<String> storeConfiguredGraphIds = new ArrayList<>();
    storeConfiguredGraphIds.add("foo");

    // Act
    FederatedStore actualFederatedStore =
        new FederatedStore(customPropertiesAuths, true, storeConfiguredGraphIds, new HashMap<>());

    // Assert
    assertTrue(
        actualFederatedStore.getOperationChainValidator()
            instanceof FederatedOperationChainValidator);
    assertTrue(actualFederatedStore.getAddElementsHandler() instanceof FederatedNoOutputHandler);
    assertTrue(actualFederatedStore.getDeleteAllDataHandler() instanceof FederatedNoOutputHandler);
    assertTrue(actualFederatedStore.getDeleteElementsHandler() instanceof FederatedOutputHandler);
    assertTrue(actualFederatedStore.getGetTraitsHandler() instanceof FederatedOutputHandler);
    assertTrue(
        actualFederatedStore.getAdjacentIdsHandler() instanceof FederatedOutputIterableHandler);
    assertTrue(
        actualFederatedStore.getGetAllElementsHandler() instanceof FederatedOutputIterableHandler);
    assertTrue(
        actualFederatedStore.getGetElementsHandler() instanceof FederatedOutputIterableHandler);
    assertNull(actualFederatedStore.getGraphId());
    assertNull(actualFederatedStore.getProperties());
    assertNull(actualFederatedStore.getJobTracker());
    assertNull(actualFederatedStore.getGraphLibrary());
    Map<String, BiFunction> storeConfiguredMergeFunctions =
        actualFederatedStore.getStoreConfiguredMergeFunctions();
    assertEquals(4, storeConfiguredMergeFunctions.size());
    assertTrue(actualFederatedStore.getOperationChainOptimisers().isEmpty());
    assertTrue(
        storeConfiguredMergeFunctions.containsKey(
            "uk.gov.gchq.gaffer.operation.impl.get.GetAllElements"));
    assertTrue(
        storeConfiguredMergeFunctions.containsKey(
            "uk.gov.gchq.gaffer.operation.impl.get.GetElements"));
    assertTrue(
        storeConfiguredMergeFunctions.containsKey("uk.gov.gchq.gaffer.store.operation.GetSchema"));
    assertTrue(
        storeConfiguredMergeFunctions.containsKey("uk.gov.gchq.gaffer.store.operation.GetTraits"));
    assertTrue(actualFederatedStore.getExternallySupportedOperations().isEmpty());
    assertTrue(actualFederatedStore.getSupportedOperations().isEmpty());
    Class<FederatedStoreProperties> expectedPropertiesClass = FederatedStoreProperties.class;
    assertEquals(expectedPropertiesClass, actualFederatedStore.getPropertiesClass());
    Class<Serialiser> expectedRequiredParentSerialiserClass = Serialiser.class;
    assertEquals(
        expectedRequiredParentSerialiserClass,
        actualFederatedStore.getRequiredParentSerialiserClass());
    assertSame(storeConfiguredGraphIds, actualFederatedStore.getStoreConfiguredGraphIds());
  }

  /**
   * Test {@link FederatedStore#FederatedStore(Set, Boolean, List, Map)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedStore#FederatedStore(Set, Boolean, List, Map)}
   */
  @Test
  @DisplayName("Test new FederatedStore(Set, Boolean, List, Map); when ArrayList() add '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FederatedStore.<init>(Set, Boolean, List, Map)"})
  void testNewFederatedStore_whenArrayListAdd42() {
    // Arrange
    HashSet<String> customPropertiesAuths = new HashSet<>();

    ArrayList<String> storeConfiguredGraphIds = new ArrayList<>();
    storeConfiguredGraphIds.add("42");
    storeConfiguredGraphIds.add("foo");

    // Act
    FederatedStore actualFederatedStore =
        new FederatedStore(customPropertiesAuths, true, storeConfiguredGraphIds, new HashMap<>());

    // Assert
    assertTrue(
        actualFederatedStore.getOperationChainValidator()
            instanceof FederatedOperationChainValidator);
    assertTrue(actualFederatedStore.getAddElementsHandler() instanceof FederatedNoOutputHandler);
    assertTrue(actualFederatedStore.getDeleteAllDataHandler() instanceof FederatedNoOutputHandler);
    assertTrue(actualFederatedStore.getDeleteElementsHandler() instanceof FederatedOutputHandler);
    assertTrue(actualFederatedStore.getGetTraitsHandler() instanceof FederatedOutputHandler);
    assertTrue(
        actualFederatedStore.getAdjacentIdsHandler() instanceof FederatedOutputIterableHandler);
    assertTrue(
        actualFederatedStore.getGetAllElementsHandler() instanceof FederatedOutputIterableHandler);
    assertTrue(
        actualFederatedStore.getGetElementsHandler() instanceof FederatedOutputIterableHandler);
    assertNull(actualFederatedStore.getGraphId());
    assertNull(actualFederatedStore.getProperties());
    assertNull(actualFederatedStore.getJobTracker());
    assertNull(actualFederatedStore.getGraphLibrary());
    Map<String, BiFunction> storeConfiguredMergeFunctions =
        actualFederatedStore.getStoreConfiguredMergeFunctions();
    assertEquals(4, storeConfiguredMergeFunctions.size());
    assertTrue(actualFederatedStore.getOperationChainOptimisers().isEmpty());
    assertTrue(
        storeConfiguredMergeFunctions.containsKey(
            "uk.gov.gchq.gaffer.operation.impl.get.GetAllElements"));
    assertTrue(
        storeConfiguredMergeFunctions.containsKey(
            "uk.gov.gchq.gaffer.operation.impl.get.GetElements"));
    assertTrue(
        storeConfiguredMergeFunctions.containsKey("uk.gov.gchq.gaffer.store.operation.GetSchema"));
    assertTrue(
        storeConfiguredMergeFunctions.containsKey("uk.gov.gchq.gaffer.store.operation.GetTraits"));
    assertTrue(actualFederatedStore.getExternallySupportedOperations().isEmpty());
    assertTrue(actualFederatedStore.getSupportedOperations().isEmpty());
    Class<FederatedStoreProperties> expectedPropertiesClass = FederatedStoreProperties.class;
    assertEquals(expectedPropertiesClass, actualFederatedStore.getPropertiesClass());
    Class<Serialiser> expectedRequiredParentSerialiserClass = Serialiser.class;
    assertEquals(
        expectedRequiredParentSerialiserClass,
        actualFederatedStore.getRequiredParentSerialiserClass());
    assertSame(storeConfiguredGraphIds, actualFederatedStore.getStoreConfiguredGraphIds());
  }

  /**
   * Test {@link FederatedStore#FederatedStore(Set, Boolean, List, Map)}.
   *
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.
   *   <li>Then return StoreConfiguredGraphIds Empty.
   * </ul>
   *
   * <p>Method under test: {@link FederatedStore#FederatedStore(Set, Boolean, List, Map)}
   */
  @Test
  @DisplayName(
      "Test new FederatedStore(Set, Boolean, List, Map); when HashSet(); then return StoreConfiguredGraphIds Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FederatedStore.<init>(Set, Boolean, List, Map)"})
  void testNewFederatedStore_whenHashSet_thenReturnStoreConfiguredGraphIdsEmpty() {
    // Arrange
    HashSet<String> customPropertiesAuths = new HashSet<>();
    ArrayList<String> storeConfiguredGraphIds = new ArrayList<>();

    // Act
    FederatedStore actualFederatedStore =
        new FederatedStore(customPropertiesAuths, true, storeConfiguredGraphIds, new HashMap<>());

    // Assert
    assertTrue(
        actualFederatedStore.getOperationChainValidator()
            instanceof FederatedOperationChainValidator);
    assertTrue(actualFederatedStore.getAddElementsHandler() instanceof FederatedNoOutputHandler);
    assertTrue(actualFederatedStore.getDeleteAllDataHandler() instanceof FederatedNoOutputHandler);
    assertTrue(actualFederatedStore.getDeleteElementsHandler() instanceof FederatedOutputHandler);
    assertTrue(actualFederatedStore.getGetTraitsHandler() instanceof FederatedOutputHandler);
    assertTrue(
        actualFederatedStore.getAdjacentIdsHandler() instanceof FederatedOutputIterableHandler);
    assertTrue(
        actualFederatedStore.getGetAllElementsHandler() instanceof FederatedOutputIterableHandler);
    assertTrue(
        actualFederatedStore.getGetElementsHandler() instanceof FederatedOutputIterableHandler);
    assertNull(actualFederatedStore.getGraphId());
    assertNull(actualFederatedStore.getProperties());
    assertNull(actualFederatedStore.getJobTracker());
    assertNull(actualFederatedStore.getGraphLibrary());
    Map<String, BiFunction> storeConfiguredMergeFunctions =
        actualFederatedStore.getStoreConfiguredMergeFunctions();
    assertEquals(4, storeConfiguredMergeFunctions.size());
    assertTrue(actualFederatedStore.getStoreConfiguredGraphIds().isEmpty());
    assertTrue(actualFederatedStore.getOperationChainOptimisers().isEmpty());
    assertTrue(
        storeConfiguredMergeFunctions.containsKey(
            "uk.gov.gchq.gaffer.operation.impl.get.GetAllElements"));
    assertTrue(
        storeConfiguredMergeFunctions.containsKey(
            "uk.gov.gchq.gaffer.operation.impl.get.GetElements"));
    assertTrue(
        storeConfiguredMergeFunctions.containsKey("uk.gov.gchq.gaffer.store.operation.GetSchema"));
    assertTrue(
        storeConfiguredMergeFunctions.containsKey("uk.gov.gchq.gaffer.store.operation.GetTraits"));
    assertTrue(actualFederatedStore.getExternallySupportedOperations().isEmpty());
    assertTrue(actualFederatedStore.getSupportedOperations().isEmpty());
    Class<FederatedStoreProperties> expectedPropertiesClass = FederatedStoreProperties.class;
    assertEquals(expectedPropertiesClass, actualFederatedStore.getPropertiesClass());
    Class<Serialiser> expectedRequiredParentSerialiserClass = Serialiser.class;
    assertEquals(
        expectedRequiredParentSerialiserClass,
        actualFederatedStore.getRequiredParentSerialiserClass());
  }

  /**
   * Test {@link FederatedStore#FederatedStore(Set, Boolean, List, Map)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return StoreConfiguredGraphIds Empty.
   * </ul>
   *
   * <p>Method under test: {@link FederatedStore#FederatedStore(Set, Boolean, List, Map)}
   */
  @Test
  @DisplayName(
      "Test new FederatedStore(Set, Boolean, List, Map); when 'null'; then return StoreConfiguredGraphIds Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FederatedStore.<init>(Set, Boolean, List, Map)"})
  void testNewFederatedStore_whenNull_thenReturnStoreConfiguredGraphIdsEmpty() {
    // Arrange
    HashSet<String> customPropertiesAuths = new HashSet<>();

    // Act
    FederatedStore actualFederatedStore =
        new FederatedStore(customPropertiesAuths, true, new ArrayList<>(), null);

    // Assert
    assertTrue(
        actualFederatedStore.getOperationChainValidator()
            instanceof FederatedOperationChainValidator);
    assertTrue(actualFederatedStore.getAddElementsHandler() instanceof FederatedNoOutputHandler);
    assertTrue(actualFederatedStore.getDeleteAllDataHandler() instanceof FederatedNoOutputHandler);
    assertTrue(actualFederatedStore.getDeleteElementsHandler() instanceof FederatedOutputHandler);
    assertTrue(actualFederatedStore.getGetTraitsHandler() instanceof FederatedOutputHandler);
    assertTrue(
        actualFederatedStore.getAdjacentIdsHandler() instanceof FederatedOutputIterableHandler);
    assertTrue(
        actualFederatedStore.getGetAllElementsHandler() instanceof FederatedOutputIterableHandler);
    assertTrue(
        actualFederatedStore.getGetElementsHandler() instanceof FederatedOutputIterableHandler);
    assertNull(actualFederatedStore.getGraphId());
    assertNull(actualFederatedStore.getProperties());
    assertNull(actualFederatedStore.getJobTracker());
    assertNull(actualFederatedStore.getGraphLibrary());
    Map<String, BiFunction> storeConfiguredMergeFunctions =
        actualFederatedStore.getStoreConfiguredMergeFunctions();
    assertEquals(4, storeConfiguredMergeFunctions.size());
    assertTrue(actualFederatedStore.getStoreConfiguredGraphIds().isEmpty());
    assertTrue(actualFederatedStore.getOperationChainOptimisers().isEmpty());
    assertTrue(
        storeConfiguredMergeFunctions.containsKey(
            "uk.gov.gchq.gaffer.operation.impl.get.GetAllElements"));
    assertTrue(
        storeConfiguredMergeFunctions.containsKey(
            "uk.gov.gchq.gaffer.operation.impl.get.GetElements"));
    assertTrue(
        storeConfiguredMergeFunctions.containsKey("uk.gov.gchq.gaffer.store.operation.GetSchema"));
    assertTrue(
        storeConfiguredMergeFunctions.containsKey("uk.gov.gchq.gaffer.store.operation.GetTraits"));
    assertTrue(actualFederatedStore.getExternallySupportedOperations().isEmpty());
    assertTrue(actualFederatedStore.getSupportedOperations().isEmpty());
    Class<FederatedStoreProperties> expectedPropertiesClass = FederatedStoreProperties.class;
    assertEquals(expectedPropertiesClass, actualFederatedStore.getPropertiesClass());
    Class<Serialiser> expectedRequiredParentSerialiserClass = Serialiser.class;
    assertEquals(
        expectedRequiredParentSerialiserClass,
        actualFederatedStore.getRequiredParentSerialiserClass());
  }

  /**
   * Test {@link FederatedStore#FederatedStore(Set, Boolean, List, Map)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return StoreConfiguredGraphIds Empty.
   * </ul>
   *
   * <p>Method under test: {@link FederatedStore#FederatedStore(Set, Boolean, List, Map)}
   */
  @Test
  @DisplayName(
      "Test new FederatedStore(Set, Boolean, List, Map); when 'null'; then return StoreConfiguredGraphIds Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FederatedStore.<init>(Set, Boolean, List, Map)"})
  void testNewFederatedStore_whenNull_thenReturnStoreConfiguredGraphIdsEmpty2() {
    // Arrange
    HashSet<String> customPropertiesAuths = new HashSet<>();
    ArrayList<String> storeConfiguredGraphIds = new ArrayList<>();

    // Act
    FederatedStore actualFederatedStore =
        new FederatedStore(customPropertiesAuths, null, storeConfiguredGraphIds, new HashMap<>());

    // Assert
    assertTrue(
        actualFederatedStore.getOperationChainValidator()
            instanceof FederatedOperationChainValidator);
    assertTrue(actualFederatedStore.getAddElementsHandler() instanceof FederatedNoOutputHandler);
    assertTrue(actualFederatedStore.getDeleteAllDataHandler() instanceof FederatedNoOutputHandler);
    assertTrue(actualFederatedStore.getDeleteElementsHandler() instanceof FederatedOutputHandler);
    assertTrue(actualFederatedStore.getGetTraitsHandler() instanceof FederatedOutputHandler);
    assertTrue(
        actualFederatedStore.getAdjacentIdsHandler() instanceof FederatedOutputIterableHandler);
    assertTrue(
        actualFederatedStore.getGetAllElementsHandler() instanceof FederatedOutputIterableHandler);
    assertTrue(
        actualFederatedStore.getGetElementsHandler() instanceof FederatedOutputIterableHandler);
    assertNull(actualFederatedStore.getGraphId());
    assertNull(actualFederatedStore.getProperties());
    assertNull(actualFederatedStore.getJobTracker());
    assertNull(actualFederatedStore.getGraphLibrary());
    Map<String, BiFunction> storeConfiguredMergeFunctions =
        actualFederatedStore.getStoreConfiguredMergeFunctions();
    assertEquals(4, storeConfiguredMergeFunctions.size());
    assertTrue(actualFederatedStore.getStoreConfiguredGraphIds().isEmpty());
    assertTrue(actualFederatedStore.getOperationChainOptimisers().isEmpty());
    assertTrue(
        storeConfiguredMergeFunctions.containsKey(
            "uk.gov.gchq.gaffer.operation.impl.get.GetAllElements"));
    assertTrue(
        storeConfiguredMergeFunctions.containsKey(
            "uk.gov.gchq.gaffer.operation.impl.get.GetElements"));
    assertTrue(
        storeConfiguredMergeFunctions.containsKey("uk.gov.gchq.gaffer.store.operation.GetSchema"));
    assertTrue(
        storeConfiguredMergeFunctions.containsKey("uk.gov.gchq.gaffer.store.operation.GetTraits"));
    assertTrue(actualFederatedStore.getExternallySupportedOperations().isEmpty());
    assertTrue(actualFederatedStore.getSupportedOperations().isEmpty());
    Class<FederatedStoreProperties> expectedPropertiesClass = FederatedStoreProperties.class;
    assertEquals(expectedPropertiesClass, actualFederatedStore.getPropertiesClass());
    Class<Serialiser> expectedRequiredParentSerialiserClass = Serialiser.class;
    assertEquals(
        expectedRequiredParentSerialiserClass,
        actualFederatedStore.getRequiredParentSerialiserClass());
  }

  /**
   * Test {@link FederatedStore#initialise(String, Schema, StoreProperties)}.
   *
   * <ul>
   *   <li>When {@link StoreProperties#StoreProperties()}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedStore#initialise(String, Schema, StoreProperties)}
   */
  @Test
  @DisplayName(
      "Test initialise(String, Schema, StoreProperties); when StoreProperties(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FederatedStore.initialise(String, Schema, StoreProperties)"})
  void testInitialise_whenStoreProperties_thenThrowIllegalArgumentException()
      throws StoreException {
    // Arrange
    FederatedStore federatedStore = new FederatedStore();
    Schema unused = new Schema();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> federatedStore.initialise(null, unused, new StoreProperties()));
  }

  /**
   * Test {@link FederatedStore#setGraphLibrary(GraphLibrary)}.
   *
   * <p>Method under test: {@link FederatedStore#setGraphLibrary(GraphLibrary)}
   */
  @Test
  @DisplayName("Test setGraphLibrary(GraphLibrary)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FederatedStore.setGraphLibrary(GraphLibrary)"})
  void testSetGraphLibrary() {
    // Arrange
    FederatedStore federatedStore = new FederatedStore();

    // Act and Assert
    assertThrows(
        GafferRuntimeException.class, () -> federatedStore.setGraphLibrary(new FileGraphLibrary()));
  }

  /**
   * Test {@link FederatedStore#getProperties()}.
   *
   * <p>Method under test: {@link FederatedStore#getProperties()}
   */
  @Test
  @DisplayName("Test getProperties()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FederatedStoreProperties FederatedStore.getProperties()"})
  void testGetProperties() {
    // Arrange, Act and Assert
    assertNull(new FederatedStore().getProperties());
  }

  /**
   * Test {@link FederatedStore#getExternallySupportedOperations()}.
   *
   * <p>Method under test: {@link FederatedStore#getExternallySupportedOperations()}
   */
  @Test
  @DisplayName("Test getExternallySupportedOperations()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set FederatedStore.getExternallySupportedOperations()"})
  void testGetExternallySupportedOperations() {
    // Arrange, Act and Assert
    assertTrue(new FederatedStore().getExternallySupportedOperations().isEmpty());
  }

  /**
   * Test {@link FederatedStore#addExternallySupportedOperation(Class)}.
   *
   * <p>Method under test: {@link FederatedStore#addExternallySupportedOperation(Class)}
   */
  @Test
  @DisplayName("Test addExternallySupportedOperation(Class)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FederatedStore.addExternallySupportedOperation(Class)"})
  void testAddExternallySupportedOperation() {
    // Arrange
    FederatedStore federatedStore = new FederatedStore();
    Class<Operation> operation = Operation.class;

    // Act
    federatedStore.addExternallySupportedOperation(operation);

    // Assert
    Set<Class<? extends Operation>> externallySupportedOperations =
        federatedStore.getExternallySupportedOperations();
    assertEquals(1, externallySupportedOperations.size());
    assertTrue(externallySupportedOperations.contains(Operation.class));
  }

  /**
   * Test {@link FederatedStore#getGraphs(User, List, IFederationOperation)}.
   *
   * <ul>
   *   <li>Given {@link FederatedStore#FederatedStore()}.
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link FederatedStore#getGraphs(User, List, IFederationOperation)}
   */
  @Test
  @DisplayName(
      "Test getGraphs(User, List, IFederationOperation); given FederatedStore(); when ArrayList(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List FederatedStore.getGraphs(User, List, IFederationOperation)"})
  void testGetGraphs_givenFederatedStore_whenArrayList_thenReturnEmpty() {
    // Arrange
    FederatedStore federatedStore = new FederatedStore();
    User user = new User();

    // Act and Assert
    assertTrue(federatedStore.getGraphs(user, new ArrayList<>(), null).isEmpty());
  }

  /**
   * Test {@link FederatedStore#isLimitedToLibraryProperties(User, boolean)} with {@code user},
   * {@code userRequestingAdminUsage}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedStore#isLimitedToLibraryProperties(User, boolean)}
   */
  @Test
  @DisplayName(
      "Test isLimitedToLibraryProperties(User, boolean) with 'user', 'userRequestingAdminUsage'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FederatedStore.isLimitedToLibraryProperties(User, boolean)"})
  void testIsLimitedToLibraryPropertiesWithUserUserRequestingAdminUsage_thenReturnFalse() {
    // Arrange
    FederatedStore federatedStore = new FederatedStore();

    // Act and Assert
    assertFalse(federatedStore.isLimitedToLibraryProperties(new User(), false));
  }

  /**
   * Test {@link FederatedStore#isLimitedToLibraryProperties(User, boolean)} with {@code user},
   * {@code userRequestingAdminUsage}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedStore#isLimitedToLibraryProperties(User, boolean)}
   */
  @Test
  @DisplayName(
      "Test isLimitedToLibraryProperties(User, boolean) with 'user', 'userRequestingAdminUsage'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FederatedStore.isLimitedToLibraryProperties(User, boolean)"})
  void testIsLimitedToLibraryPropertiesWithUserUserRequestingAdminUsage_thenReturnTrue() {
    // Arrange
    HashSet<String> customPropertiesAuths = new HashSet<>();
    ArrayList<String> storeConfiguredGraphIds = new ArrayList<>();

    FederatedStore federatedStore =
        new FederatedStore(customPropertiesAuths, true, storeConfiguredGraphIds, new HashMap<>());

    // Act and Assert
    assertTrue(federatedStore.isLimitedToLibraryProperties(new User(), false));
  }

  /**
   * Test {@link FederatedStore#isLimitedToLibraryProperties(User)} with {@code user}.
   *
   * <ul>
   *   <li>Given {@link FederatedStore#FederatedStore()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedStore#isLimitedToLibraryProperties(User)}
   */
  @Test
  @DisplayName(
      "Test isLimitedToLibraryProperties(User) with 'user'; given FederatedStore(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FederatedStore.isLimitedToLibraryProperties(User)"})
  void testIsLimitedToLibraryPropertiesWithUser_givenFederatedStore_thenReturnFalse() {
    // Arrange
    FederatedStore federatedStore = new FederatedStore();

    // Act and Assert
    assertFalse(federatedStore.isLimitedToLibraryProperties(new User()));
  }

  /**
   * Test {@link FederatedStore#isLimitedToLibraryProperties(User)} with {@code user}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedStore#isLimitedToLibraryProperties(User)}
   */
  @Test
  @DisplayName("Test isLimitedToLibraryProperties(User) with 'user'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FederatedStore.isLimitedToLibraryProperties(User)"})
  void testIsLimitedToLibraryPropertiesWithUser_thenReturnTrue() {
    // Arrange
    HashSet<String> customPropertiesAuths = new HashSet<>();
    ArrayList<String> storeConfiguredGraphIds = new ArrayList<>();

    FederatedStore federatedStore =
        new FederatedStore(customPropertiesAuths, true, storeConfiguredGraphIds, new HashMap<>());

    // Act and Assert
    assertTrue(federatedStore.isLimitedToLibraryProperties(new User()));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link FederatedStore#getPropertiesClass()}
   *   <li>{@link FederatedStore#getRequiredParentSerialiserClass()}
   *   <li>{@link FederatedStore#getStoreConfiguredGraphIds()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Class FederatedStore.getPropertiesClass()",
    "Class FederatedStore.getRequiredParentSerialiserClass()",
    "List FederatedStore.getStoreConfiguredGraphIds()"
  })
  void testGettersAndSetters() {
    // Arrange
    FederatedStore federatedStore = new FederatedStore();

    // Act
    Class<FederatedStoreProperties> actualPropertiesClass = federatedStore.getPropertiesClass();
    Class<? extends Serialiser> actualRequiredParentSerialiserClass =
        federatedStore.getRequiredParentSerialiserClass();

    // Assert
    assertNull(federatedStore.getStoreConfiguredGraphIds());
    Class<FederatedStoreProperties> expectedPropertiesClass = FederatedStoreProperties.class;
    assertEquals(expectedPropertiesClass, actualPropertiesClass);
    Class<Serialiser> expectedRequiredParentSerialiserClass = Serialiser.class;
    assertEquals(expectedRequiredParentSerialiserClass, actualRequiredParentSerialiserClass);
  }

  /**
   * Test {@link FederatedStore#addAdditionalOperationHandlers()}.
   *
   * <p>Method under test: {@link FederatedStore#addAdditionalOperationHandlers()}
   */
  @Test
  @DisplayName("Test addAdditionalOperationHandlers()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FederatedStore.addAdditionalOperationHandlers()"})
  void testAddAdditionalOperationHandlers() {
    // Arrange
    FederatedStore federatedStore = new FederatedStore();

    // Act
    federatedStore.addAdditionalOperationHandlers();

    // Assert
    Set<Class<? extends Operation>> supportedOperations = federatedStore.getSupportedOperations();
    assertEquals(Short.SIZE, supportedOperations.size());
    assertTrue(supportedOperations.contains(AddGraphWithHooks.class));
    assertTrue(supportedOperations.contains(GetAllGraphIds.class));
    assertTrue(supportedOperations.contains(RemoveGraph.class));
    assertTrue(supportedOperations.contains(Aggregate.class));
    assertTrue(supportedOperations.contains(Filter.class));
    assertTrue(supportedOperations.contains(Join.class));
  }

  /**
   * Test {@link FederatedStore#addAdditionalOperationHandlers()}.
   *
   * <p>Method under test: {@link FederatedStore#addAdditionalOperationHandlers()}
   */
  @Test
  @DisplayName("Test addAdditionalOperationHandlers()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FederatedStore.addAdditionalOperationHandlers()"})
  void testAddAdditionalOperationHandlers2() {
    // Arrange
    HashSet<String> customPropertiesAuths = new HashSet<>();
    ArrayList<String> storeConfiguredGraphIds = new ArrayList<>();

    FederatedStore federatedStore =
        new FederatedStore(customPropertiesAuths, true, storeConfiguredGraphIds, new HashMap<>());

    // Act
    federatedStore.addAdditionalOperationHandlers();

    // Assert
    Set<Class<? extends Operation>> supportedOperations = federatedStore.getSupportedOperations();
    assertEquals(Short.SIZE, supportedOperations.size());
    assertTrue(supportedOperations.contains(AddGraphWithHooks.class));
    assertTrue(supportedOperations.contains(GetAllGraphIds.class));
    assertTrue(supportedOperations.contains(RemoveGraph.class));
    assertTrue(supportedOperations.contains(Aggregate.class));
    assertTrue(supportedOperations.contains(Filter.class));
    assertTrue(supportedOperations.contains(Join.class));
  }

  /**
   * Test {@link FederatedStore#createOperationChainValidator()}.
   *
   * <p>Method under test: {@link FederatedStore#createOperationChainValidator()}
   */
  @Test
  @DisplayName("Test createOperationChainValidator()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "uk.gov.gchq.gaffer.store.operation.OperationChainValidator FederatedStore.createOperationChainValidator()"
  })
  void testCreateOperationChainValidator() {
    // Arrange, Act and Assert
    assertTrue(
        new FederatedStore().createOperationChainValidator()
            instanceof FederatedOperationChainValidator);
  }

  /**
   * Test {@link FederatedStore#getGetElementsHandler()}.
   *
   * <ul>
   *   <li>Then return {@link FederatedOutputIterableHandler}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedStore#getGetElementsHandler()}
   */
  @Test
  @DisplayName("Test getGetElementsHandler(); then return FederatedOutputIterableHandler")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "uk.gov.gchq.gaffer.store.operation.handler.OutputOperationHandler FederatedStore.getGetElementsHandler()"
  })
  void testGetGetElementsHandler_thenReturnFederatedOutputIterableHandler() {
    // Arrange, Act and Assert
    assertTrue(
        new FederatedStore().getGetElementsHandler() instanceof FederatedOutputIterableHandler);
  }

  /**
   * Test {@link FederatedStore#getGetAllElementsHandler()}.
   *
   * <ul>
   *   <li>Then return {@link FederatedOutputIterableHandler}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedStore#getGetAllElementsHandler()}
   */
  @Test
  @DisplayName("Test getGetAllElementsHandler(); then return FederatedOutputIterableHandler")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "uk.gov.gchq.gaffer.store.operation.handler.OutputOperationHandler FederatedStore.getGetAllElementsHandler()"
  })
  void testGetGetAllElementsHandler_thenReturnFederatedOutputIterableHandler() {
    // Arrange, Act and Assert
    assertTrue(
        new FederatedStore().getGetAllElementsHandler() instanceof FederatedOutputIterableHandler);
  }

  /**
   * Test {@link FederatedStore#getDeleteElementsHandler()}.
   *
   * <ul>
   *   <li>Then return {@link FederatedOutputHandler}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedStore#getDeleteElementsHandler()}
   */
  @Test
  @DisplayName("Test getDeleteElementsHandler(); then return FederatedOutputHandler")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "uk.gov.gchq.gaffer.store.operation.handler.OutputOperationHandler FederatedStore.getDeleteElementsHandler()"
  })
  void testGetDeleteElementsHandler_thenReturnFederatedOutputHandler() {
    // Arrange, Act and Assert
    assertTrue(new FederatedStore().getDeleteElementsHandler() instanceof FederatedOutputHandler);
  }

  /**
   * Test {@link FederatedStore#getDeleteAllDataHandler()}.
   *
   * <ul>
   *   <li>Then return {@link FederatedNoOutputHandler}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedStore#getDeleteAllDataHandler()}
   */
  @Test
  @DisplayName("Test getDeleteAllDataHandler(); then return FederatedNoOutputHandler")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "uk.gov.gchq.gaffer.store.operation.handler.OperationHandler FederatedStore.getDeleteAllDataHandler()"
  })
  void testGetDeleteAllDataHandler_thenReturnFederatedNoOutputHandler() {
    // Arrange, Act and Assert
    assertTrue(new FederatedStore().getDeleteAllDataHandler() instanceof FederatedNoOutputHandler);
  }

  /**
   * Test {@link FederatedStore#getAdjacentIdsHandler()}.
   *
   * <ul>
   *   <li>Then return {@link FederatedOutputIterableHandler}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedStore#getAdjacentIdsHandler()}
   */
  @Test
  @DisplayName("Test getAdjacentIdsHandler(); then return FederatedOutputIterableHandler")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "uk.gov.gchq.gaffer.store.operation.handler.OutputOperationHandler FederatedStore.getAdjacentIdsHandler()"
  })
  void testGetAdjacentIdsHandler_thenReturnFederatedOutputIterableHandler() {
    // Arrange, Act and Assert
    assertTrue(
        new FederatedStore().getAdjacentIdsHandler() instanceof FederatedOutputIterableHandler);
  }

  /**
   * Test {@link FederatedStore#getAddElementsHandler()}.
   *
   * <ul>
   *   <li>Then return {@link FederatedNoOutputHandler}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedStore#getAddElementsHandler()}
   */
  @Test
  @DisplayName("Test getAddElementsHandler(); then return FederatedNoOutputHandler")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "uk.gov.gchq.gaffer.store.operation.handler.OperationHandler FederatedStore.getAddElementsHandler()"
  })
  void testGetAddElementsHandler_thenReturnFederatedNoOutputHandler() {
    // Arrange, Act and Assert
    assertTrue(new FederatedStore().getAddElementsHandler() instanceof FederatedNoOutputHandler);
  }

  /**
   * Test {@link FederatedStore#getGetTraitsHandler()}.
   *
   * <ul>
   *   <li>Then return {@link FederatedOutputHandler}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedStore#getGetTraitsHandler()}
   */
  @Test
  @DisplayName("Test getGetTraitsHandler(); then return FederatedOutputHandler")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "uk.gov.gchq.gaffer.store.operation.handler.OutputOperationHandler FederatedStore.getGetTraitsHandler()"
  })
  void testGetGetTraitsHandler_thenReturnFederatedOutputHandler() {
    // Arrange, Act and Assert
    assertTrue(new FederatedStore().getGetTraitsHandler() instanceof FederatedOutputHandler);
  }

  /**
   * Test {@link FederatedStore#getStoreConfiguredMergeFunctions()}.
   *
   * <p>Method under test: {@link FederatedStore#getStoreConfiguredMergeFunctions()}
   */
  @Test
  @DisplayName("Test getStoreConfiguredMergeFunctions()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map FederatedStore.getStoreConfiguredMergeFunctions()"})
  void testGetStoreConfiguredMergeFunctions() {
    // Arrange and Act
    Map<String, BiFunction> actualStoreConfiguredMergeFunctions =
        new FederatedStore().getStoreConfiguredMergeFunctions();

    // Assert
    assertEquals(4, actualStoreConfiguredMergeFunctions.size());
    BiFunction getResult =
        actualStoreConfiguredMergeFunctions.get(
            "uk.gov.gchq.gaffer.operation.impl.get.GetAllElements");
    assertTrue(getResult instanceof ApplyViewToElementsFunction);
    BiFunction getResult2 =
        actualStoreConfiguredMergeFunctions.get(
            "uk.gov.gchq.gaffer.operation.impl.get.GetElements");
    assertTrue(getResult2 instanceof ApplyViewToElementsFunction);
    BiFunction getResult3 =
        actualStoreConfiguredMergeFunctions.get("uk.gov.gchq.gaffer.store.operation.GetSchema");
    assertTrue(getResult3 instanceof MergeSchema);
    assertTrue(
        actualStoreConfiguredMergeFunctions.get("uk.gov.gchq.gaffer.store.operation.GetTraits")
            instanceof CollectionIntersect);
    Set<String> requiredContextValues =
        ((ApplyViewToElementsFunction) getResult2).getRequiredContextValues();
    assertEquals(3, requiredContextValues.size());
    assertTrue(requiredContextValues.contains("schema"));
    assertTrue(requiredContextValues.contains("user"));
    assertTrue(requiredContextValues.contains("view"));
    assertTrue(((MergeSchema) getResult3).getRequiredContextValues().isEmpty());
    assertEquals(
        requiredContextValues,
        ((ApplyViewToElementsFunction) getResult).getRequiredContextValues());
  }

  /**
   * Test {@link FederatedStore#doUnhandledOperation(Operation, Context)}.
   *
   * <p>Method under test: {@link FederatedStore#doUnhandledOperation(Operation, Context)}
   */
  @Test
  @DisplayName("Test doUnhandledOperation(Operation, Context)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object FederatedStore.doUnhandledOperation(Operation, Context)"})
  void testDoUnhandledOperation() {
    // Arrange
    FederatedStore federatedStore = new FederatedStore();

    ExportToOtherAuthorisedGraph operation = mock(ExportToOtherAuthorisedGraph.class);
    org.mockito.Mockito.<Class<?>>when(operation.getOutputClass())
        .thenThrow(new GafferRuntimeException("An error occurred"));

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            federatedStore.doUnhandledOperation(
                operation, FederatedStoreTestUtil.contextAuthUser()));
    verify(operation).getOutputClass();
  }

  /**
   * Test {@link FederatedStore#doUnhandledOperation(Operation, Context)}.
   *
   * <ul>
   *   <li>Given {@code Iterable}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedStore#doUnhandledOperation(Operation, Context)}
   */
  @Test
  @DisplayName("Test doUnhandledOperation(Operation, Context); given 'java.lang.Iterable'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object FederatedStore.doUnhandledOperation(Operation, Context)"})
  void testDoUnhandledOperation_givenJavaLangIterable() {
    // Arrange
    FederatedStore federatedStore = new FederatedStore();

    ExportToOtherAuthorisedGraph operation = mock(ExportToOtherAuthorisedGraph.class);
    when(operation.getOptions()).thenThrow(new GafferRuntimeException("An error occurred"));
    Class<Iterable> forNameResult = Iterable.class;
    org.mockito.Mockito.<Class<?>>when(operation.getOutputClass()).thenReturn(forNameResult);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            federatedStore.doUnhandledOperation(
                operation, FederatedStoreTestUtil.contextAuthUser()));
    verify(operation).getOptions();
    verify(operation).getOutputClass();
  }

  /**
   * Test {@link FederatedStore#doUnhandledOperation(Operation, Context)}.
   *
   * <ul>
   *   <li>Then calls {@link ExportToOtherAuthorisedGraph#getOptions()}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedStore#doUnhandledOperation(Operation, Context)}
   */
  @Test
  @DisplayName("Test doUnhandledOperation(Operation, Context); then calls getOptions()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object FederatedStore.doUnhandledOperation(Operation, Context)"})
  void testDoUnhandledOperation_thenCallsGetOptions() {
    // Arrange
    FederatedStore federatedStore = new FederatedStore();

    ExportToOtherAuthorisedGraph operation = mock(ExportToOtherAuthorisedGraph.class);
    when(operation.getOptions()).thenThrow(new GafferRuntimeException("An error occurred"));
    Class<Object> forNameResult = Object.class;
    org.mockito.Mockito.<Class<?>>when(operation.getOutputClass()).thenReturn(forNameResult);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            federatedStore.doUnhandledOperation(
                operation, FederatedStoreTestUtil.contextAuthUser()));
    verify(operation).getOptions();
    verify(operation).getOutputClass();
  }
}
