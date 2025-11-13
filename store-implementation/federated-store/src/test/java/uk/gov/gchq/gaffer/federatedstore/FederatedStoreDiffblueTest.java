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
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.function.BiFunction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uk.gov.gchq.gaffer.core.exception.GafferRuntimeException;
import uk.gov.gchq.gaffer.federatedstore.operation.FederatedOperationChainValidator;
import uk.gov.gchq.gaffer.federatedstore.operation.IFederationOperation;
import uk.gov.gchq.gaffer.federatedstore.operation.handler.impl.FederatedNoOutputHandler;
import uk.gov.gchq.gaffer.federatedstore.operation.handler.impl.FederatedOutputHandler;
import uk.gov.gchq.gaffer.federatedstore.operation.handler.impl.FederatedOutputIterableHandler;
import uk.gov.gchq.gaffer.federatedstore.util.ApplyViewToElementsFunction;
import uk.gov.gchq.gaffer.federatedstore.util.MergeSchema;
import uk.gov.gchq.gaffer.operation.Operation;
import uk.gov.gchq.gaffer.serialisation.Serialiser;
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
   * <p>
   * Method under test: {@link FederatedStore#FederatedStore()}
   */
  @Test
  @DisplayName("Test new FederatedStore()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void FederatedStore.<init>()"})
  void testNewFederatedStore() {
    // Arrange and Act
    FederatedStore actualFederatedStore = new FederatedStore();

    // Assert
    assertTrue(actualFederatedStore.getOperationChainValidator() instanceof FederatedOperationChainValidator);
    assertTrue(actualFederatedStore.getAddElementsHandler() instanceof FederatedNoOutputHandler);
    assertTrue(actualFederatedStore.getDeleteAllDataHandler() instanceof FederatedNoOutputHandler);
    assertTrue(actualFederatedStore.getDeleteElementsHandler() instanceof FederatedOutputHandler);
    assertTrue(actualFederatedStore.getGetTraitsHandler() instanceof FederatedOutputHandler);
    assertTrue(actualFederatedStore.getAdjacentIdsHandler() instanceof FederatedOutputIterableHandler);
    assertTrue(actualFederatedStore.getGetAllElementsHandler() instanceof FederatedOutputIterableHandler);
    assertTrue(actualFederatedStore.getGetElementsHandler() instanceof FederatedOutputIterableHandler);
    assertNull(actualFederatedStore.getGraphId());
    assertNull(actualFederatedStore.getStoreConfiguredGraphIds());
    assertNull(actualFederatedStore.getProperties());
    assertNull(actualFederatedStore.getJobTracker());
    assertNull(actualFederatedStore.getGraphLibrary());
    Map<String, BiFunction> storeConfiguredMergeFunctions = actualFederatedStore.getStoreConfiguredMergeFunctions();
    assertEquals(4, storeConfiguredMergeFunctions.size());
    assertTrue(actualFederatedStore.getOperationChainOptimisers().isEmpty());
    assertTrue(storeConfiguredMergeFunctions.containsKey("uk.gov.gchq.gaffer.operation.impl.get.GetAllElements"));
    assertTrue(storeConfiguredMergeFunctions.containsKey("uk.gov.gchq.gaffer.operation.impl.get.GetElements"));
    assertTrue(storeConfiguredMergeFunctions.containsKey("uk.gov.gchq.gaffer.store.operation.GetSchema"));
    assertTrue(storeConfiguredMergeFunctions.containsKey("uk.gov.gchq.gaffer.store.operation.GetTraits"));
    assertTrue(actualFederatedStore.getExternallySupportedOperations().isEmpty());
    assertTrue(actualFederatedStore.getSupportedOperations().isEmpty());
    Class<FederatedStoreProperties> expectedPropertiesClass = FederatedStoreProperties.class;
    assertEquals(expectedPropertiesClass, actualFederatedStore.getPropertiesClass());
    Class<Serialiser> expectedRequiredParentSerialiserClass = Serialiser.class;
    assertEquals(expectedRequiredParentSerialiserClass, actualFederatedStore.getRequiredParentSerialiserClass());
  }

  /**
   * Test {@link FederatedStore#FederatedStore(Set, Boolean, List, Map)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link HashSet#HashSet()} add {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FederatedStore#FederatedStore(Set, Boolean, List, Map)}
   */
  @Test
  @DisplayName("Test new FederatedStore(Set, Boolean, List, Map); given '42'; when HashSet() add '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void FederatedStore.<init>(Set, Boolean, List, Map)"})
  void testNewFederatedStore_given42_whenHashSetAdd42() {
    // Arrange
    HashSet<String> customPropertiesAuths = new HashSet<>();
    customPropertiesAuths.add("42");
    customPropertiesAuths.add("foo");
    ArrayList<String> storeConfiguredGraphIds = new ArrayList<>();

    // Act
    FederatedStore actualFederatedStore = new FederatedStore(customPropertiesAuths, true, storeConfiguredGraphIds,
        new HashMap<>());

    // Assert
    assertTrue(actualFederatedStore.getOperationChainValidator() instanceof FederatedOperationChainValidator);
    assertTrue(actualFederatedStore.getAddElementsHandler() instanceof FederatedNoOutputHandler);
    assertTrue(actualFederatedStore.getDeleteAllDataHandler() instanceof FederatedNoOutputHandler);
    assertTrue(actualFederatedStore.getDeleteElementsHandler() instanceof FederatedOutputHandler);
    assertTrue(actualFederatedStore.getGetTraitsHandler() instanceof FederatedOutputHandler);
    assertTrue(actualFederatedStore.getAdjacentIdsHandler() instanceof FederatedOutputIterableHandler);
    assertTrue(actualFederatedStore.getGetAllElementsHandler() instanceof FederatedOutputIterableHandler);
    assertTrue(actualFederatedStore.getGetElementsHandler() instanceof FederatedOutputIterableHandler);
    assertNull(actualFederatedStore.getGraphId());
    assertNull(actualFederatedStore.getProperties());
    assertNull(actualFederatedStore.getJobTracker());
    assertNull(actualFederatedStore.getGraphLibrary());
    Map<String, BiFunction> storeConfiguredMergeFunctions = actualFederatedStore.getStoreConfiguredMergeFunctions();
    assertEquals(4, storeConfiguredMergeFunctions.size());
    assertTrue(actualFederatedStore.getStoreConfiguredGraphIds().isEmpty());
    assertTrue(actualFederatedStore.getOperationChainOptimisers().isEmpty());
    assertTrue(storeConfiguredMergeFunctions.containsKey("uk.gov.gchq.gaffer.operation.impl.get.GetAllElements"));
    assertTrue(storeConfiguredMergeFunctions.containsKey("uk.gov.gchq.gaffer.operation.impl.get.GetElements"));
    assertTrue(storeConfiguredMergeFunctions.containsKey("uk.gov.gchq.gaffer.store.operation.GetSchema"));
    assertTrue(storeConfiguredMergeFunctions.containsKey("uk.gov.gchq.gaffer.store.operation.GetTraits"));
    assertTrue(actualFederatedStore.getExternallySupportedOperations().isEmpty());
    assertTrue(actualFederatedStore.getSupportedOperations().isEmpty());
    Class<FederatedStoreProperties> expectedPropertiesClass = FederatedStoreProperties.class;
    assertEquals(expectedPropertiesClass, actualFederatedStore.getPropertiesClass());
    Class<Serialiser> expectedRequiredParentSerialiserClass = Serialiser.class;
    assertEquals(expectedRequiredParentSerialiserClass, actualFederatedStore.getRequiredParentSerialiserClass());
  }

  /**
   * Test {@link FederatedStore#FederatedStore(Set, Boolean, List, Map)}.
   * <ul>
   *   <li>Then return StoreConfiguredGraphIds is {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FederatedStore#FederatedStore(Set, Boolean, List, Map)}
   */
  @Test
  @DisplayName("Test new FederatedStore(Set, Boolean, List, Map); then return StoreConfiguredGraphIds is ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void FederatedStore.<init>(Set, Boolean, List, Map)"})
  void testNewFederatedStore_thenReturnStoreConfiguredGraphIdsIsArrayList() {
    // Arrange
    HashSet<String> customPropertiesAuths = new HashSet<>();

    ArrayList<String> storeConfiguredGraphIds = new ArrayList<>();
    storeConfiguredGraphIds.add("foo");

    // Act
    FederatedStore actualFederatedStore = new FederatedStore(customPropertiesAuths, true, storeConfiguredGraphIds,
        new HashMap<>());

    // Assert
    assertTrue(actualFederatedStore.getOperationChainValidator() instanceof FederatedOperationChainValidator);
    assertTrue(actualFederatedStore.getAddElementsHandler() instanceof FederatedNoOutputHandler);
    assertTrue(actualFederatedStore.getDeleteAllDataHandler() instanceof FederatedNoOutputHandler);
    assertTrue(actualFederatedStore.getDeleteElementsHandler() instanceof FederatedOutputHandler);
    assertTrue(actualFederatedStore.getGetTraitsHandler() instanceof FederatedOutputHandler);
    assertTrue(actualFederatedStore.getAdjacentIdsHandler() instanceof FederatedOutputIterableHandler);
    assertTrue(actualFederatedStore.getGetAllElementsHandler() instanceof FederatedOutputIterableHandler);
    assertTrue(actualFederatedStore.getGetElementsHandler() instanceof FederatedOutputIterableHandler);
    assertNull(actualFederatedStore.getGraphId());
    assertNull(actualFederatedStore.getProperties());
    assertNull(actualFederatedStore.getJobTracker());
    assertNull(actualFederatedStore.getGraphLibrary());
    Map<String, BiFunction> storeConfiguredMergeFunctions = actualFederatedStore.getStoreConfiguredMergeFunctions();
    assertEquals(4, storeConfiguredMergeFunctions.size());
    assertTrue(actualFederatedStore.getOperationChainOptimisers().isEmpty());
    assertTrue(storeConfiguredMergeFunctions.containsKey("uk.gov.gchq.gaffer.operation.impl.get.GetAllElements"));
    assertTrue(storeConfiguredMergeFunctions.containsKey("uk.gov.gchq.gaffer.operation.impl.get.GetElements"));
    assertTrue(storeConfiguredMergeFunctions.containsKey("uk.gov.gchq.gaffer.store.operation.GetSchema"));
    assertTrue(storeConfiguredMergeFunctions.containsKey("uk.gov.gchq.gaffer.store.operation.GetTraits"));
    assertTrue(actualFederatedStore.getExternallySupportedOperations().isEmpty());
    assertTrue(actualFederatedStore.getSupportedOperations().isEmpty());
    Class<FederatedStoreProperties> expectedPropertiesClass = FederatedStoreProperties.class;
    assertEquals(expectedPropertiesClass, actualFederatedStore.getPropertiesClass());
    Class<Serialiser> expectedRequiredParentSerialiserClass = Serialiser.class;
    assertEquals(expectedRequiredParentSerialiserClass, actualFederatedStore.getRequiredParentSerialiserClass());
    assertSame(storeConfiguredGraphIds, actualFederatedStore.getStoreConfiguredGraphIds());
  }

  /**
   * Test {@link FederatedStore#FederatedStore(Set, Boolean, List, Map)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FederatedStore#FederatedStore(Set, Boolean, List, Map)}
   */
  @Test
  @DisplayName("Test new FederatedStore(Set, Boolean, List, Map); when ArrayList() add '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void FederatedStore.<init>(Set, Boolean, List, Map)"})
  void testNewFederatedStore_whenArrayListAdd42() {
    // Arrange
    HashSet<String> customPropertiesAuths = new HashSet<>();

    ArrayList<String> storeConfiguredGraphIds = new ArrayList<>();
    storeConfiguredGraphIds.add("42");
    storeConfiguredGraphIds.add("foo");

    // Act
    FederatedStore actualFederatedStore = new FederatedStore(customPropertiesAuths, true, storeConfiguredGraphIds,
        new HashMap<>());

    // Assert
    assertTrue(actualFederatedStore.getOperationChainValidator() instanceof FederatedOperationChainValidator);
    assertTrue(actualFederatedStore.getAddElementsHandler() instanceof FederatedNoOutputHandler);
    assertTrue(actualFederatedStore.getDeleteAllDataHandler() instanceof FederatedNoOutputHandler);
    assertTrue(actualFederatedStore.getDeleteElementsHandler() instanceof FederatedOutputHandler);
    assertTrue(actualFederatedStore.getGetTraitsHandler() instanceof FederatedOutputHandler);
    assertTrue(actualFederatedStore.getAdjacentIdsHandler() instanceof FederatedOutputIterableHandler);
    assertTrue(actualFederatedStore.getGetAllElementsHandler() instanceof FederatedOutputIterableHandler);
    assertTrue(actualFederatedStore.getGetElementsHandler() instanceof FederatedOutputIterableHandler);
    assertNull(actualFederatedStore.getGraphId());
    assertNull(actualFederatedStore.getProperties());
    assertNull(actualFederatedStore.getJobTracker());
    assertNull(actualFederatedStore.getGraphLibrary());
    Map<String, BiFunction> storeConfiguredMergeFunctions = actualFederatedStore.getStoreConfiguredMergeFunctions();
    assertEquals(4, storeConfiguredMergeFunctions.size());
    assertTrue(actualFederatedStore.getOperationChainOptimisers().isEmpty());
    assertTrue(storeConfiguredMergeFunctions.containsKey("uk.gov.gchq.gaffer.operation.impl.get.GetAllElements"));
    assertTrue(storeConfiguredMergeFunctions.containsKey("uk.gov.gchq.gaffer.operation.impl.get.GetElements"));
    assertTrue(storeConfiguredMergeFunctions.containsKey("uk.gov.gchq.gaffer.store.operation.GetSchema"));
    assertTrue(storeConfiguredMergeFunctions.containsKey("uk.gov.gchq.gaffer.store.operation.GetTraits"));
    assertTrue(actualFederatedStore.getExternallySupportedOperations().isEmpty());
    assertTrue(actualFederatedStore.getSupportedOperations().isEmpty());
    Class<FederatedStoreProperties> expectedPropertiesClass = FederatedStoreProperties.class;
    assertEquals(expectedPropertiesClass, actualFederatedStore.getPropertiesClass());
    Class<Serialiser> expectedRequiredParentSerialiserClass = Serialiser.class;
    assertEquals(expectedRequiredParentSerialiserClass, actualFederatedStore.getRequiredParentSerialiserClass());
    assertSame(storeConfiguredGraphIds, actualFederatedStore.getStoreConfiguredGraphIds());
  }

  /**
   * Test {@link FederatedStore#FederatedStore(Set, Boolean, List, Map)}.
   * <ul>
   *   <li>When {@link HashSet#HashSet()} add {@code foo}.</li>
   *   <li>Then return StoreConfiguredGraphIds Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link FederatedStore#FederatedStore(Set, Boolean, List, Map)}
   */
  @Test
  @DisplayName("Test new FederatedStore(Set, Boolean, List, Map); when HashSet() add 'foo'; then return StoreConfiguredGraphIds Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void FederatedStore.<init>(Set, Boolean, List, Map)"})
  void testNewFederatedStore_whenHashSetAddFoo_thenReturnStoreConfiguredGraphIdsEmpty() {
    // Arrange
    HashSet<String> customPropertiesAuths = new HashSet<>();
    customPropertiesAuths.add("foo");
    ArrayList<String> storeConfiguredGraphIds = new ArrayList<>();

    // Act
    FederatedStore actualFederatedStore = new FederatedStore(customPropertiesAuths, true, storeConfiguredGraphIds,
        new HashMap<>());

    // Assert
    assertTrue(actualFederatedStore.getOperationChainValidator() instanceof FederatedOperationChainValidator);
    assertTrue(actualFederatedStore.getAddElementsHandler() instanceof FederatedNoOutputHandler);
    assertTrue(actualFederatedStore.getDeleteAllDataHandler() instanceof FederatedNoOutputHandler);
    assertTrue(actualFederatedStore.getDeleteElementsHandler() instanceof FederatedOutputHandler);
    assertTrue(actualFederatedStore.getGetTraitsHandler() instanceof FederatedOutputHandler);
    assertTrue(actualFederatedStore.getAdjacentIdsHandler() instanceof FederatedOutputIterableHandler);
    assertTrue(actualFederatedStore.getGetAllElementsHandler() instanceof FederatedOutputIterableHandler);
    assertTrue(actualFederatedStore.getGetElementsHandler() instanceof FederatedOutputIterableHandler);
    assertNull(actualFederatedStore.getGraphId());
    assertNull(actualFederatedStore.getProperties());
    assertNull(actualFederatedStore.getJobTracker());
    assertNull(actualFederatedStore.getGraphLibrary());
    Map<String, BiFunction> storeConfiguredMergeFunctions = actualFederatedStore.getStoreConfiguredMergeFunctions();
    assertEquals(4, storeConfiguredMergeFunctions.size());
    assertTrue(actualFederatedStore.getStoreConfiguredGraphIds().isEmpty());
    assertTrue(actualFederatedStore.getOperationChainOptimisers().isEmpty());
    assertTrue(storeConfiguredMergeFunctions.containsKey("uk.gov.gchq.gaffer.operation.impl.get.GetAllElements"));
    assertTrue(storeConfiguredMergeFunctions.containsKey("uk.gov.gchq.gaffer.operation.impl.get.GetElements"));
    assertTrue(storeConfiguredMergeFunctions.containsKey("uk.gov.gchq.gaffer.store.operation.GetSchema"));
    assertTrue(storeConfiguredMergeFunctions.containsKey("uk.gov.gchq.gaffer.store.operation.GetTraits"));
    assertTrue(actualFederatedStore.getExternallySupportedOperations().isEmpty());
    assertTrue(actualFederatedStore.getSupportedOperations().isEmpty());
    Class<FederatedStoreProperties> expectedPropertiesClass = FederatedStoreProperties.class;
    assertEquals(expectedPropertiesClass, actualFederatedStore.getPropertiesClass());
    Class<Serialiser> expectedRequiredParentSerialiserClass = Serialiser.class;
    assertEquals(expectedRequiredParentSerialiserClass, actualFederatedStore.getRequiredParentSerialiserClass());
  }

  /**
   * Test {@link FederatedStore#FederatedStore(Set, Boolean, List, Map)}.
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.</li>
   *   <li>Then return StoreConfiguredGraphIds Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link FederatedStore#FederatedStore(Set, Boolean, List, Map)}
   */
  @Test
  @DisplayName("Test new FederatedStore(Set, Boolean, List, Map); when HashSet(); then return StoreConfiguredGraphIds Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void FederatedStore.<init>(Set, Boolean, List, Map)"})
  void testNewFederatedStore_whenHashSet_thenReturnStoreConfiguredGraphIdsEmpty() {
    // Arrange
    HashSet<String> customPropertiesAuths = new HashSet<>();
    ArrayList<String> storeConfiguredGraphIds = new ArrayList<>();

    // Act
    FederatedStore actualFederatedStore = new FederatedStore(customPropertiesAuths, true, storeConfiguredGraphIds,
        new HashMap<>());

    // Assert
    assertTrue(actualFederatedStore.getOperationChainValidator() instanceof FederatedOperationChainValidator);
    assertTrue(actualFederatedStore.getAddElementsHandler() instanceof FederatedNoOutputHandler);
    assertTrue(actualFederatedStore.getDeleteAllDataHandler() instanceof FederatedNoOutputHandler);
    assertTrue(actualFederatedStore.getDeleteElementsHandler() instanceof FederatedOutputHandler);
    assertTrue(actualFederatedStore.getGetTraitsHandler() instanceof FederatedOutputHandler);
    assertTrue(actualFederatedStore.getAdjacentIdsHandler() instanceof FederatedOutputIterableHandler);
    assertTrue(actualFederatedStore.getGetAllElementsHandler() instanceof FederatedOutputIterableHandler);
    assertTrue(actualFederatedStore.getGetElementsHandler() instanceof FederatedOutputIterableHandler);
    assertNull(actualFederatedStore.getGraphId());
    assertNull(actualFederatedStore.getProperties());
    assertNull(actualFederatedStore.getJobTracker());
    assertNull(actualFederatedStore.getGraphLibrary());
    Map<String, BiFunction> storeConfiguredMergeFunctions = actualFederatedStore.getStoreConfiguredMergeFunctions();
    assertEquals(4, storeConfiguredMergeFunctions.size());
    assertTrue(actualFederatedStore.getStoreConfiguredGraphIds().isEmpty());
    assertTrue(actualFederatedStore.getOperationChainOptimisers().isEmpty());
    assertTrue(storeConfiguredMergeFunctions.containsKey("uk.gov.gchq.gaffer.operation.impl.get.GetAllElements"));
    assertTrue(storeConfiguredMergeFunctions.containsKey("uk.gov.gchq.gaffer.operation.impl.get.GetElements"));
    assertTrue(storeConfiguredMergeFunctions.containsKey("uk.gov.gchq.gaffer.store.operation.GetSchema"));
    assertTrue(storeConfiguredMergeFunctions.containsKey("uk.gov.gchq.gaffer.store.operation.GetTraits"));
    assertTrue(actualFederatedStore.getExternallySupportedOperations().isEmpty());
    assertTrue(actualFederatedStore.getSupportedOperations().isEmpty());
    Class<FederatedStoreProperties> expectedPropertiesClass = FederatedStoreProperties.class;
    assertEquals(expectedPropertiesClass, actualFederatedStore.getPropertiesClass());
    Class<Serialiser> expectedRequiredParentSerialiserClass = Serialiser.class;
    assertEquals(expectedRequiredParentSerialiserClass, actualFederatedStore.getRequiredParentSerialiserClass());
  }

  /**
   * Test {@link FederatedStore#FederatedStore(Set, Boolean, List, Map)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return StoreConfiguredGraphIds Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link FederatedStore#FederatedStore(Set, Boolean, List, Map)}
   */
  @Test
  @DisplayName("Test new FederatedStore(Set, Boolean, List, Map); when 'null'; then return StoreConfiguredGraphIds Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void FederatedStore.<init>(Set, Boolean, List, Map)"})
  void testNewFederatedStore_whenNull_thenReturnStoreConfiguredGraphIdsEmpty() {
    // Arrange
    HashSet<String> customPropertiesAuths = new HashSet<>();

    // Act
    FederatedStore actualFederatedStore = new FederatedStore(customPropertiesAuths, null, new ArrayList<>(), null);

    // Assert
    assertTrue(actualFederatedStore.getOperationChainValidator() instanceof FederatedOperationChainValidator);
    assertTrue(actualFederatedStore.getAddElementsHandler() instanceof FederatedNoOutputHandler);
    assertTrue(actualFederatedStore.getDeleteAllDataHandler() instanceof FederatedNoOutputHandler);
    assertTrue(actualFederatedStore.getDeleteElementsHandler() instanceof FederatedOutputHandler);
    assertTrue(actualFederatedStore.getGetTraitsHandler() instanceof FederatedOutputHandler);
    assertTrue(actualFederatedStore.getAdjacentIdsHandler() instanceof FederatedOutputIterableHandler);
    assertTrue(actualFederatedStore.getGetAllElementsHandler() instanceof FederatedOutputIterableHandler);
    assertTrue(actualFederatedStore.getGetElementsHandler() instanceof FederatedOutputIterableHandler);
    assertNull(actualFederatedStore.getGraphId());
    assertNull(actualFederatedStore.getProperties());
    assertNull(actualFederatedStore.getJobTracker());
    assertNull(actualFederatedStore.getGraphLibrary());
    Map<String, BiFunction> storeConfiguredMergeFunctions = actualFederatedStore.getStoreConfiguredMergeFunctions();
    assertEquals(4, storeConfiguredMergeFunctions.size());
    assertTrue(actualFederatedStore.getStoreConfiguredGraphIds().isEmpty());
    assertTrue(actualFederatedStore.getOperationChainOptimisers().isEmpty());
    assertTrue(storeConfiguredMergeFunctions.containsKey("uk.gov.gchq.gaffer.operation.impl.get.GetAllElements"));
    assertTrue(storeConfiguredMergeFunctions.containsKey("uk.gov.gchq.gaffer.operation.impl.get.GetElements"));
    assertTrue(storeConfiguredMergeFunctions.containsKey("uk.gov.gchq.gaffer.store.operation.GetSchema"));
    assertTrue(storeConfiguredMergeFunctions.containsKey("uk.gov.gchq.gaffer.store.operation.GetTraits"));
    assertTrue(actualFederatedStore.getExternallySupportedOperations().isEmpty());
    assertTrue(actualFederatedStore.getSupportedOperations().isEmpty());
    Class<FederatedStoreProperties> expectedPropertiesClass = FederatedStoreProperties.class;
    assertEquals(expectedPropertiesClass, actualFederatedStore.getPropertiesClass());
    Class<Serialiser> expectedRequiredParentSerialiserClass = Serialiser.class;
    assertEquals(expectedRequiredParentSerialiserClass, actualFederatedStore.getRequiredParentSerialiserClass());
  }

  /**
   * Test {@link FederatedStore#initialise(String, Schema, StoreProperties)}.
   * <ul>
   *   <li>Given {@link PredefinedFederatedStore} (default constructor).</li>
   *   <li>Then throw {@link GafferRuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FederatedStore#initialise(String, Schema, StoreProperties)}
   */
  @Test
  @DisplayName("Test initialise(String, Schema, StoreProperties); given PredefinedFederatedStore (default constructor); then throw GafferRuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void FederatedStore.initialise(String, Schema, StoreProperties)"})
  void testInitialise_givenPredefinedFederatedStore_thenThrowGafferRuntimeException() throws StoreException {
    // Arrange
    PredefinedFederatedStore predefinedFederatedStore = new PredefinedFederatedStore();
    Schema schema = new Schema();
    StoreProperties properties = mock(StoreProperties.class);
    when(properties.getReflectionPackages()).thenThrow(new GafferRuntimeException("An error occurred"));
    when(properties.get(Mockito.<String>any(), Mockito.<String>any())).thenReturn("Get");
    when(properties.getCacheServiceDefaultSuffix(Mockito.<String>any())).thenReturn("Cache Service Default Suffix");
    when(properties.getProperties()).thenReturn(new Properties());
    doNothing().when(properties).updateStorePropertiesClass(Mockito.<Class<StoreProperties>>any());

    // Act and Assert
    assertThrows(GafferRuntimeException.class, () -> predefinedFederatedStore.initialise("42", schema, properties));
    verify(properties).get(eq("gaffer.cache.service.federated.store.suffix"), eq("Cache Service Default Suffix"));
    verify(properties).getCacheServiceDefaultSuffix(eq("42"));
    verify(properties).getProperties();
    verify(properties).getReflectionPackages();
    verify(properties).updateStorePropertiesClass(isA(Class.class));
  }

  /**
   * Test {@link FederatedStore#initialise(String, Schema, StoreProperties)}.
   * <ul>
   *   <li>Then throw {@link GafferRuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FederatedStore#initialise(String, Schema, StoreProperties)}
   */
  @Test
  @DisplayName("Test initialise(String, Schema, StoreProperties); then throw GafferRuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void FederatedStore.initialise(String, Schema, StoreProperties)"})
  void testInitialise_thenThrowGafferRuntimeException() throws StoreException {
    // Arrange
    FederatedStore federatedStore = new FederatedStore();
    Schema unused = new Schema();
    StoreProperties properties = mock(StoreProperties.class);
    when(properties.getReflectionPackages()).thenThrow(new GafferRuntimeException("An error occurred"));
    when(properties.get(Mockito.<String>any(), Mockito.<String>any())).thenReturn("Get");
    when(properties.getCacheServiceDefaultSuffix(Mockito.<String>any())).thenReturn("Cache Service Default Suffix");
    when(properties.getProperties()).thenReturn(new Properties());
    doNothing().when(properties).updateStorePropertiesClass(Mockito.<Class<StoreProperties>>any());

    // Act and Assert
    assertThrows(GafferRuntimeException.class, () -> federatedStore.initialise("42", unused, properties));
    verify(properties).get(eq("gaffer.cache.service.federated.store.suffix"), eq("Cache Service Default Suffix"));
    verify(properties).getCacheServiceDefaultSuffix(eq("42"));
    verify(properties).getProperties();
    verify(properties).getReflectionPackages();
    verify(properties).updateStorePropertiesClass(isA(Class.class));
  }

  /**
   * Test {@link FederatedStore#setGraphLibrary(GraphLibrary)}.
   * <p>
   * Method under test: {@link FederatedStore#setGraphLibrary(GraphLibrary)}
   */
  @Test
  @DisplayName("Test setGraphLibrary(GraphLibrary)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void FederatedStore.setGraphLibrary(GraphLibrary)"})
  void testSetGraphLibrary() {
    // Arrange
    FederatedStore federatedStore = new FederatedStore();

    // Act and Assert
    assertThrows(GafferRuntimeException.class, () -> federatedStore.setGraphLibrary(new FileGraphLibrary()));
  }

  /**
   * Test {@link FederatedStore#getProperties()}.
   * <p>
   * Method under test: {@link FederatedStore#getProperties()}
   */
  @Test
  @DisplayName("Test getProperties()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"FederatedStoreProperties FederatedStore.getProperties()"})
  void testGetProperties() {
    // Arrange, Act and Assert
    assertNull((new FederatedStore()).getProperties());
  }

  /**
   * Test {@link FederatedStore#getExternallySupportedOperations()}.
   * <p>
   * Method under test: {@link FederatedStore#getExternallySupportedOperations()}
   */
  @Test
  @DisplayName("Test getExternallySupportedOperations()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set FederatedStore.getExternallySupportedOperations()"})
  void testGetExternallySupportedOperations() {
    // Arrange, Act and Assert
    assertTrue((new FederatedStore()).getExternallySupportedOperations().isEmpty());
  }

  /**
   * Test {@link FederatedStore#addExternallySupportedOperation(Class)}.
   * <p>
   * Method under test: {@link FederatedStore#addExternallySupportedOperation(Class)}
   */
  @Test
  @DisplayName("Test addExternallySupportedOperation(Class)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void FederatedStore.addExternallySupportedOperation(Class)"})
  void testAddExternallySupportedOperation() {
    // Arrange
    FederatedStore federatedStore = new FederatedStore();
    Class<Operation> operation = Operation.class;

    // Act
    federatedStore.addExternallySupportedOperation(operation);

    // Assert
    assertEquals(1, federatedStore.getExternallySupportedOperations().size());
  }

  /**
   * Test {@link FederatedStore#getGraphs(User, List, IFederationOperation)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link FederatedStore#getGraphs(User, List, IFederationOperation)}
   */
  @Test
  @DisplayName("Test getGraphs(User, List, IFederationOperation); when 'null'; then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List FederatedStore.getGraphs(User, List, IFederationOperation)"})
  void testGetGraphs_whenNull_thenReturnEmpty() {
    // Arrange
    FederatedStore federatedStore = new FederatedStore();
    User user = new User();

    // Act and Assert
    assertTrue(federatedStore.getGraphs(user, new ArrayList<>(), null).isEmpty());
  }

  /**
   * Test {@link FederatedStore#isLimitedToLibraryProperties(User, boolean)} with {@code user}, {@code userRequestingAdminUsage}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FederatedStore#isLimitedToLibraryProperties(User, boolean)}
   */
  @Test
  @DisplayName("Test isLimitedToLibraryProperties(User, boolean) with 'user', 'userRequestingAdminUsage'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean FederatedStore.isLimitedToLibraryProperties(User, boolean)"})
  void testIsLimitedToLibraryPropertiesWithUserUserRequestingAdminUsage_thenReturnFalse() {
    // Arrange
    FederatedStore federatedStore = new FederatedStore();

    // Act and Assert
    assertFalse(federatedStore.isLimitedToLibraryProperties(new User(), false));
  }

  /**
   * Test {@link FederatedStore#isLimitedToLibraryProperties(User, boolean)} with {@code user}, {@code userRequestingAdminUsage}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FederatedStore#isLimitedToLibraryProperties(User, boolean)}
   */
  @Test
  @DisplayName("Test isLimitedToLibraryProperties(User, boolean) with 'user', 'userRequestingAdminUsage'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean FederatedStore.isLimitedToLibraryProperties(User, boolean)"})
  void testIsLimitedToLibraryPropertiesWithUserUserRequestingAdminUsage_thenReturnTrue() {
    // Arrange
    HashSet<String> customPropertiesAuths = new HashSet<>();
    ArrayList<String> storeConfiguredGraphIds = new ArrayList<>();
    FederatedStore federatedStore = new FederatedStore(customPropertiesAuths, true, storeConfiguredGraphIds,
        new HashMap<>());

    // Act and Assert
    assertTrue(federatedStore.isLimitedToLibraryProperties(new User(), false));
  }

  /**
   * Test {@link FederatedStore#isLimitedToLibraryProperties(User)} with {@code user}.
   * <ul>
   *   <li>Given {@link FederatedStore#FederatedStore()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FederatedStore#isLimitedToLibraryProperties(User)}
   */
  @Test
  @DisplayName("Test isLimitedToLibraryProperties(User) with 'user'; given FederatedStore(); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean FederatedStore.isLimitedToLibraryProperties(User)"})
  void testIsLimitedToLibraryPropertiesWithUser_givenFederatedStore_thenReturnFalse() {
    // Arrange
    FederatedStore federatedStore = new FederatedStore();

    // Act and Assert
    assertFalse(federatedStore.isLimitedToLibraryProperties(new User()));
  }

  /**
   * Test {@link FederatedStore#isLimitedToLibraryProperties(User)} with {@code user}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FederatedStore#isLimitedToLibraryProperties(User)}
   */
  @Test
  @DisplayName("Test isLimitedToLibraryProperties(User) with 'user'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean FederatedStore.isLimitedToLibraryProperties(User)"})
  void testIsLimitedToLibraryPropertiesWithUser_thenReturnTrue() {
    // Arrange
    HashSet<String> customPropertiesAuths = new HashSet<>();
    ArrayList<String> storeConfiguredGraphIds = new ArrayList<>();
    FederatedStore federatedStore = new FederatedStore(customPropertiesAuths, true, storeConfiguredGraphIds,
        new HashMap<>());

    // Act and Assert
    assertTrue(federatedStore.isLimitedToLibraryProperties(new User()));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link FederatedStore#getPropertiesClass()}
   *   <li>{@link FederatedStore#getRequiredParentSerialiserClass()}
   *   <li>{@link FederatedStore#getStoreConfiguredGraphIds()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Class FederatedStore.getPropertiesClass()",
      "Class FederatedStore.getRequiredParentSerialiserClass()", "List FederatedStore.getStoreConfiguredGraphIds()"})
  void testGettersAndSetters() {
    // Arrange
    FederatedStore federatedStore = new FederatedStore();

    // Act
    Class<FederatedStoreProperties> actualPropertiesClass = federatedStore.getPropertiesClass();
    Class<? extends Serialiser> actualRequiredParentSerialiserClass = federatedStore.getRequiredParentSerialiserClass();

    // Assert
    assertNull(federatedStore.getStoreConfiguredGraphIds());
    Class<FederatedStoreProperties> expectedPropertiesClass = FederatedStoreProperties.class;
    assertEquals(expectedPropertiesClass, actualPropertiesClass);
    Class<Serialiser> expectedRequiredParentSerialiserClass = Serialiser.class;
    assertEquals(expectedRequiredParentSerialiserClass, actualRequiredParentSerialiserClass);
  }

  /**
   * Test {@link FederatedStore#addAdditionalOperationHandlers()}.
   * <p>
   * Method under test: {@link FederatedStore#addAdditionalOperationHandlers()}
   */
  @Test
  @DisplayName("Test addAdditionalOperationHandlers()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void FederatedStore.addAdditionalOperationHandlers()"})
  void testAddAdditionalOperationHandlers() {
    // Arrange
    FederatedStore federatedStore = new FederatedStore();

    // Act
    federatedStore.addAdditionalOperationHandlers();

    // Assert
    assertEquals(Short.SIZE, federatedStore.getSupportedOperations().size());
  }

  /**
   * Test {@link FederatedStore#addAdditionalOperationHandlers()}.
   * <p>
   * Method under test: {@link FederatedStore#addAdditionalOperationHandlers()}
   */
  @Test
  @DisplayName("Test addAdditionalOperationHandlers()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void FederatedStore.addAdditionalOperationHandlers()"})
  void testAddAdditionalOperationHandlers2() {
    // Arrange
    HashSet<String> customPropertiesAuths = new HashSet<>();
    ArrayList<String> storeConfiguredGraphIds = new ArrayList<>();
    FederatedStore federatedStore = new FederatedStore(customPropertiesAuths, true, storeConfiguredGraphIds,
        new HashMap<>());

    // Act
    federatedStore.addAdditionalOperationHandlers();

    // Assert
    assertEquals(Short.SIZE, federatedStore.getSupportedOperations().size());
  }

  /**
   * Test {@link FederatedStore#createOperationChainValidator()}.
   * <p>
   * Method under test: {@link FederatedStore#createOperationChainValidator()}
   */
  @Test
  @DisplayName("Test createOperationChainValidator()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "uk.gov.gchq.gaffer.store.operation.OperationChainValidator FederatedStore.createOperationChainValidator()"})
  void testCreateOperationChainValidator() {
    // Arrange, Act and Assert
    assertTrue((new FederatedStore()).createOperationChainValidator() instanceof FederatedOperationChainValidator);
  }

  /**
   * Test {@link FederatedStore#getStoreConfiguredMergeFunctions()}.
   * <p>
   * Method under test: {@link FederatedStore#getStoreConfiguredMergeFunctions()}
   */
  @Test
  @DisplayName("Test getStoreConfiguredMergeFunctions()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map FederatedStore.getStoreConfiguredMergeFunctions()"})
  void testGetStoreConfiguredMergeFunctions() {
    // Arrange and Act
    Map<String, BiFunction> actualStoreConfiguredMergeFunctions = (new FederatedStore())
        .getStoreConfiguredMergeFunctions();

    // Assert
    assertEquals(4, actualStoreConfiguredMergeFunctions.size());
    BiFunction getResult = actualStoreConfiguredMergeFunctions
        .get("uk.gov.gchq.gaffer.operation.impl.get.GetAllElements");
    assertTrue(getResult instanceof ApplyViewToElementsFunction);
    BiFunction getResult2 = actualStoreConfiguredMergeFunctions
        .get("uk.gov.gchq.gaffer.operation.impl.get.GetElements");
    assertTrue(getResult2 instanceof ApplyViewToElementsFunction);
    BiFunction getResult3 = actualStoreConfiguredMergeFunctions.get("uk.gov.gchq.gaffer.store.operation.GetSchema");
    assertTrue(getResult3 instanceof MergeSchema);
    assertTrue(actualStoreConfiguredMergeFunctions
        .get("uk.gov.gchq.gaffer.store.operation.GetTraits") instanceof CollectionIntersect);
    Set<String> requiredContextValues = ((ApplyViewToElementsFunction) getResult2).getRequiredContextValues();
    assertEquals(3, requiredContextValues.size());
    assertTrue(requiredContextValues.contains("schema"));
    assertTrue(requiredContextValues.contains("user"));
    assertTrue(requiredContextValues.contains("view"));
    assertTrue(((MergeSchema) getResult3).getRequiredContextValues().isEmpty());
    assertEquals(requiredContextValues, ((ApplyViewToElementsFunction) getResult).getRequiredContextValues());
  }
}
