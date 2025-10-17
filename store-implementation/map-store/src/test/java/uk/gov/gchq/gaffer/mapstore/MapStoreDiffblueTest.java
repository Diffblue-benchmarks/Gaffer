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

package uk.gov.gchq.gaffer.mapstore;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.commonutil.iterable.EmptyIterable;
import uk.gov.gchq.gaffer.commonutil.iterable.EmptyIterator;
import uk.gov.gchq.gaffer.data.element.Element;
import uk.gov.gchq.gaffer.data.element.Entity;
import uk.gov.gchq.gaffer.data.element.id.EntityId;
import uk.gov.gchq.gaffer.mapstore.impl.AddElementsHandler;
import uk.gov.gchq.gaffer.mapstore.impl.DeleteAllDataHandler;
import uk.gov.gchq.gaffer.mapstore.impl.DeleteElementsHandler;
import uk.gov.gchq.gaffer.mapstore.impl.GetAdjacentIdsHandler;
import uk.gov.gchq.gaffer.mapstore.impl.GetAllElementsHandler;
import uk.gov.gchq.gaffer.mapstore.impl.GetElementsHandler;
import uk.gov.gchq.gaffer.mapstore.impl.MapImpl;
import uk.gov.gchq.gaffer.mapstore.utils.SchemaOptimiserMapStore;
import uk.gov.gchq.gaffer.operation.OperationException;
import uk.gov.gchq.gaffer.operation.impl.get.GetAdjacentIds;
import uk.gov.gchq.gaffer.operation.impl.get.GetAllElements;
import uk.gov.gchq.gaffer.serialisation.Serialiser;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.Context.Builder;
import uk.gov.gchq.gaffer.store.StoreException;
import uk.gov.gchq.gaffer.store.StoreProperties;
import uk.gov.gchq.gaffer.store.StoreTrait;
import uk.gov.gchq.gaffer.store.TypeReferenceStoreImpl;
import uk.gov.gchq.gaffer.store.TypeReferenceStoreImpl.StoreTraits;
import uk.gov.gchq.gaffer.store.operation.GetTraits;
import uk.gov.gchq.gaffer.store.operation.handler.GetTraitsHandler;
import uk.gov.gchq.gaffer.store.operation.handler.OutputOperationHandler;
import uk.gov.gchq.gaffer.store.schema.Schema;
import uk.gov.gchq.gaffer.store.schema.SchemaOptimiser;
import uk.gov.gchq.gaffer.user.User;

class MapStoreDiffblueTest {
  /**
   * Test {@link MapStore#initialise(String, Schema, StoreProperties)}.
   *
   * <ul>
   *   <li>When {@link StoreProperties#StoreProperties()}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link MapStore#initialise(String, Schema, StoreProperties)}
   */
  @Test
  @DisplayName(
      "Test initialise(String, Schema, StoreProperties); when StoreProperties(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MapStore.initialise(String, Schema, StoreProperties)"})
  void testInitialise_whenStoreProperties_thenThrowIllegalArgumentException()
      throws StoreException {
    // Arrange
    MapStore mapStore = new MapStore();
    Schema schema = new Schema();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> mapStore.initialise(null, schema, new StoreProperties()));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MapStore#resetStaticMap()}
   *   <li>{@link MapStore#getMapImpl()}
   *   <li>{@link MapStore#getPropertiesClass()}
   *   <li>{@link MapStore#getRequiredParentSerialiserClass()}
   *   <li>{@link MapStore#getTraits()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MapImpl MapStore.getMapImpl()",
    "Class MapStore.getPropertiesClass()",
    "Class MapStore.getRequiredParentSerialiserClass()",
    "Set MapStore.getTraits()",
    "void MapStore.resetStaticMap()"
  })
  void testGettersAndSetters() {
    // Arrange
    MapStore mapStore = new MapStore();

    // Act
    mapStore.resetStaticMap();
    MapImpl actualMapImpl = mapStore.getMapImpl();
    Class<MapStoreProperties> actualPropertiesClass = mapStore.getPropertiesClass();
    Class<? extends Serialiser> actualRequiredParentSerialiserClass =
        mapStore.getRequiredParentSerialiserClass();
    Set<StoreTrait> actualTraits = mapStore.getTraits();

    // Assert
    assertNull(actualMapImpl);
    Class<MapStoreProperties> expectedPropertiesClass = MapStoreProperties.class;
    assertEquals(expectedPropertiesClass, actualPropertiesClass);
    Class<Serialiser> expectedRequiredParentSerialiserClass = Serialiser.class;
    assertEquals(expectedRequiredParentSerialiserClass, actualRequiredParentSerialiserClass);
    assertSame(MapStore.TRAITS, actualTraits);
  }

  /**
   * Test {@link MapStore#getProperties()}.
   *
   * <p>Method under test: {@link MapStore#getProperties()}
   */
  @Test
  @DisplayName("Test getProperties()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapStoreProperties MapStore.getProperties()"})
  void testGetProperties() {
    // Arrange, Act and Assert
    assertNull(new MapStore().getProperties());
  }

  /**
   * Test {@link MapStore#addAdditionalOperationHandlers()}.
   *
   * <p>Method under test: {@link MapStore#addAdditionalOperationHandlers()}
   */
  @Test
  @DisplayName("Test addAdditionalOperationHandlers()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MapStore.addAdditionalOperationHandlers()"})
  void testAddAdditionalOperationHandlers() {
    // Arrange
    MapStore mapStore = new MapStore();

    // Act
    mapStore.addAdditionalOperationHandlers();

    // Assert
    assertEquals(4, mapStore.getSupportedOperations().size());
  }

  /**
   * Test {@link MapStore#getGetElementsHandler()}.
   *
   * <ul>
   *   <li>Then return {@link GetElementsHandler}.
   * </ul>
   *
   * <p>Method under test: {@link MapStore#getGetElementsHandler()}
   */
  @Test
  @DisplayName("Test getGetElementsHandler(); then return GetElementsHandler")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"OutputOperationHandler MapStore.getGetElementsHandler()"})
  void testGetGetElementsHandler_thenReturnGetElementsHandler() {
    // Arrange, Act and Assert
    assertTrue(new MapStore().getGetElementsHandler() instanceof GetElementsHandler);
  }

  /**
   * Test {@link MapStore#getGetAllElementsHandler()}.
   *
   * <p>Method under test: {@link MapStore#getGetAllElementsHandler()}
   */
  @Test
  @DisplayName("Test getGetAllElementsHandler()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"OutputOperationHandler MapStore.getGetAllElementsHandler()"})
  void testGetGetAllElementsHandler() throws OperationException {
    // Arrange and Act
    OutputOperationHandler<GetAllElements, Iterable<? extends Element>>
        actualGetAllElementsHandler = new MapStore().getGetAllElementsHandler();
    GetAllElements getAllElements = new GetAllElements();
    Builder builder = new Builder();
    Context context = builder.user(new User.Builder().userId("42").build()).build();
    actualGetAllElementsHandler.doOperation(getAllElements, context, new MapStore());

    // Assert
    assertTrue(actualGetAllElementsHandler instanceof GetAllElementsHandler);
  }

  /**
   * Test {@link MapStore#getAdjacentIdsHandler()}.
   *
   * <p>Method under test: {@link MapStore#getAdjacentIdsHandler()}
   */
  @Test
  @DisplayName("Test getAdjacentIdsHandler()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"OutputOperationHandler MapStore.getAdjacentIdsHandler()"})
  void testGetAdjacentIdsHandler() throws OperationException {
    // Arrange and Act
    OutputOperationHandler<GetAdjacentIds, Iterable<? extends EntityId>> actualAdjacentIdsHandler =
        new MapStore().getAdjacentIdsHandler();
    GetAdjacentIds getAdjacentIds = new GetAdjacentIds();
    Builder builder = new Builder();
    Context context = builder.user(new User.Builder().userId("42").build()).build();
    Iterable<? extends EntityId> actualDoOperationResult =
        actualAdjacentIdsHandler.doOperation(getAdjacentIds, context, new MapStore());

    // Assert
    assertTrue(actualDoOperationResult instanceof EmptyIterable);
    Iterator<? extends EntityId> iteratorResult = actualDoOperationResult.iterator();
    assertTrue(iteratorResult instanceof EmptyIterator);
    assertTrue(actualAdjacentIdsHandler instanceof GetAdjacentIdsHandler);
    assertFalse(iteratorResult.hasNext());
  }

  /**
   * Test {@link MapStore#getAdjacentIdsHandler()}.
   *
   * <p>Method under test: {@link MapStore#getAdjacentIdsHandler()}
   */
  @Test
  @DisplayName("Test getAdjacentIdsHandler()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"OutputOperationHandler MapStore.getAdjacentIdsHandler()"})
  void testGetAdjacentIdsHandler2() throws OperationException {
    // Arrange and Act
    OutputOperationHandler<GetAdjacentIds, Iterable<? extends EntityId>> actualAdjacentIdsHandler =
        new MapStore().getAdjacentIdsHandler();
    ArrayList<EntityId> input = new ArrayList<>();
    input.add(new Entity.Builder().group("Group").vertex("Vertex").build());
    GetAdjacentIds getAdjacentIds = new GetAdjacentIds();
    getAdjacentIds.setInput(input);
    Builder builder = new Builder();
    Context context = builder.user(new User.Builder().userId("42").build()).build();
    actualAdjacentIdsHandler.doOperation(getAdjacentIds, context, new MapStore());

    // Assert
    assertTrue(actualAdjacentIdsHandler instanceof GetAdjacentIdsHandler);
  }

  /**
   * Test {@link MapStore#getAddElementsHandler()}.
   *
   * <ul>
   *   <li>Then return {@link AddElementsHandler}.
   * </ul>
   *
   * <p>Method under test: {@link MapStore#getAddElementsHandler()}
   */
  @Test
  @DisplayName("Test getAddElementsHandler(); then return AddElementsHandler")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "uk.gov.gchq.gaffer.store.operation.handler.OperationHandler MapStore.getAddElementsHandler()"
  })
  void testGetAddElementsHandler_thenReturnAddElementsHandler() {
    // Arrange, Act and Assert
    assertTrue(new MapStore().getAddElementsHandler() instanceof AddElementsHandler);
  }

  /**
   * Test {@link MapStore#getDeleteElementsHandler()}.
   *
   * <ul>
   *   <li>Then return {@link DeleteElementsHandler}.
   * </ul>
   *
   * <p>Method under test: {@link MapStore#getDeleteElementsHandler()}
   */
  @Test
  @DisplayName("Test getDeleteElementsHandler(); then return DeleteElementsHandler")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"OutputOperationHandler MapStore.getDeleteElementsHandler()"})
  void testGetDeleteElementsHandler_thenReturnDeleteElementsHandler() {
    // Arrange, Act and Assert
    assertTrue(new MapStore().getDeleteElementsHandler() instanceof DeleteElementsHandler);
  }

  /**
   * Test {@link MapStore#getDeleteAllDataHandler()}.
   *
   * <ul>
   *   <li>Then return {@link DeleteAllDataHandler}.
   * </ul>
   *
   * <p>Method under test: {@link MapStore#getDeleteAllDataHandler()}
   */
  @Test
  @DisplayName("Test getDeleteAllDataHandler(); then return DeleteAllDataHandler")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "uk.gov.gchq.gaffer.store.operation.handler.OperationHandler MapStore.getDeleteAllDataHandler()"
  })
  void testGetDeleteAllDataHandler_thenReturnDeleteAllDataHandler() {
    // Arrange, Act and Assert
    assertTrue(new MapStore().getDeleteAllDataHandler() instanceof DeleteAllDataHandler);
  }

  /**
   * Test {@link MapStore#getGetTraitsHandler()}.
   *
   * <p>Method under test: {@link MapStore#getGetTraitsHandler()}
   */
  @Test
  @DisplayName("Test getGetTraitsHandler()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"OutputOperationHandler MapStore.getGetTraitsHandler()"})
  void testGetGetTraitsHandler() {
    // Arrange
    SingleUseMapStoreWithoutVisibilitySupport singleUseMapStoreWithoutVisibilitySupport =
        new SingleUseMapStoreWithoutVisibilitySupport();

    // Act
    OutputOperationHandler<GetTraits, Set<StoreTrait>> actualGetTraitsHandler =
        singleUseMapStoreWithoutVisibilitySupport.getGetTraitsHandler();

    // Assert
    assertTrue(
        singleUseMapStoreWithoutVisibilitySupport.getAddElementsHandler()
            instanceof AddElementsHandler);
    assertTrue(
        singleUseMapStoreWithoutVisibilitySupport.getDeleteAllDataHandler()
            instanceof DeleteAllDataHandler);
    assertTrue(
        singleUseMapStoreWithoutVisibilitySupport.getDeleteElementsHandler()
            instanceof DeleteElementsHandler);
    assertTrue(
        singleUseMapStoreWithoutVisibilitySupport.getAdjacentIdsHandler()
            instanceof GetAdjacentIdsHandler);
    assertTrue(
        singleUseMapStoreWithoutVisibilitySupport.getGetAllElementsHandler()
            instanceof GetAllElementsHandler);
    assertTrue(
        singleUseMapStoreWithoutVisibilitySupport.getGetElementsHandler()
            instanceof GetElementsHandler);
    assertTrue(actualGetTraitsHandler instanceof GetTraitsHandler);
    assertTrue(
        singleUseMapStoreWithoutVisibilitySupport.getGetTraitsHandler()
            instanceof GetTraitsHandler);
    assertNull(singleUseMapStoreWithoutVisibilitySupport.getGraphId());
    assertNull(singleUseMapStoreWithoutVisibilitySupport.getJobTracker());
    assertNull(singleUseMapStoreWithoutVisibilitySupport.getProperties());
    assertNull(singleUseMapStoreWithoutVisibilitySupport.getMapImpl());
    assertNull(singleUseMapStoreWithoutVisibilitySupport.getGraphLibrary());
    assertNull(singleUseMapStoreWithoutVisibilitySupport.getOriginalSchema());
    assertNull(singleUseMapStoreWithoutVisibilitySupport.getSchema());
    assertEquals(7, singleUseMapStoreWithoutVisibilitySupport.getTraits().size());
    assertTrue(singleUseMapStoreWithoutVisibilitySupport.getOperationChainOptimisers().isEmpty());
    assertTrue(singleUseMapStoreWithoutVisibilitySupport.getSupportedOperations().isEmpty());
    Class<MapStoreProperties> expectedPropertiesClass = MapStoreProperties.class;
    assertEquals(
        expectedPropertiesClass, singleUseMapStoreWithoutVisibilitySupport.getPropertiesClass());
    Class<Serialiser> expectedRequiredParentSerialiserClass = Serialiser.class;
    assertEquals(
        expectedRequiredParentSerialiserClass,
        singleUseMapStoreWithoutVisibilitySupport.getRequiredParentSerialiserClass());
  }

  /**
   * Test {@link MapStore#getGetTraitsHandler()}.
   *
   * <ul>
   *   <li>Then {@link GetTraits} (default constructor) OutputTypeReference {@link
   *       TypeReferenceStoreImpl.StoreTraits}.
   * </ul>
   *
   * <p>Method under test: {@link MapStore#getGetTraitsHandler()}
   */
  @Test
  @DisplayName(
      "Test getGetTraitsHandler(); then GetTraits (default constructor) OutputTypeReference StoreTraits")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"OutputOperationHandler MapStore.getGetTraitsHandler()"})
  void testGetGetTraitsHandler_thenGetTraitsOutputTypeReferenceStoreTraits()
      throws OperationException {
    // Arrange
    MapStore mapStore = new MapStore();

    // Act
    OutputOperationHandler<GetTraits, Set<StoreTrait>> actualGetTraitsHandler =
        mapStore.getGetTraitsHandler();
    GetTraits getTraits = new GetTraits();
    getTraits.setCurrentTraits(false);
    Builder builder = new Builder();
    Context context = builder.user(new User.Builder().userId("42").build()).build();
    Set<StoreTrait> actualDoOperationResult =
        actualGetTraitsHandler.doOperation(getTraits, context, new MapStore());

    // Assert
    assertTrue(mapStore.getAddElementsHandler() instanceof AddElementsHandler);
    assertTrue(mapStore.getDeleteAllDataHandler() instanceof DeleteAllDataHandler);
    assertTrue(mapStore.getDeleteElementsHandler() instanceof DeleteElementsHandler);
    assertTrue(mapStore.getAdjacentIdsHandler() instanceof GetAdjacentIdsHandler);
    assertTrue(mapStore.getGetAllElementsHandler() instanceof GetAllElementsHandler);
    assertTrue(mapStore.getGetElementsHandler() instanceof GetElementsHandler);
    assertTrue(getTraits.getOutputTypeReference() instanceof StoreTraits);
    assertTrue(actualGetTraitsHandler instanceof GetTraitsHandler);
    assertNull(mapStore.getGraphId());
    assertNull(mapStore.getJobTracker());
    assertNull(mapStore.getProperties());
    assertNull(mapStore.getMapImpl());
    assertNull(context.getOriginalOpChain());
    assertNull(mapStore.getGraphLibrary());
    assertNull(mapStore.getOriginalSchema());
    assertNull(mapStore.getSchema());
    assertFalse(getTraits.isCurrentTraits());
    assertTrue(context.getExporters().isEmpty());
    assertTrue(mapStore.getOperationChainOptimisers().isEmpty());
    assertTrue(context.getVariables().isEmpty());
    assertTrue(getTraits.getOptions().isEmpty());
    assertTrue(mapStore.getSupportedOperations().isEmpty());
    Class<Set> expectedOutputClass = Set.class;
    assertEquals(expectedOutputClass, getTraits.getOutputClass());
    Class<MapStoreProperties> expectedPropertiesClass = MapStoreProperties.class;
    assertEquals(expectedPropertiesClass, mapStore.getPropertiesClass());
    Class<Serialiser> expectedRequiredParentSerialiserClass = Serialiser.class;
    assertEquals(
        expectedRequiredParentSerialiserClass, mapStore.getRequiredParentSerialiserClass());
    Set<StoreTrait> storeTraitSet = MapStore.TRAITS;
    assertEquals(storeTraitSet, actualDoOperationResult);
    assertSame(storeTraitSet, mapStore.getTraits());
  }

  /**
   * Test {@link MapStore#getGetTraitsHandler()}.
   *
   * <ul>
   *   <li>Then {@link MapStore} (default constructor) AddElementsHandler {@link
   *       AddElementsHandler}.
   * </ul>
   *
   * <p>Method under test: {@link MapStore#getGetTraitsHandler()}
   */
  @Test
  @DisplayName(
      "Test getGetTraitsHandler(); then MapStore (default constructor) AddElementsHandler AddElementsHandler")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"OutputOperationHandler MapStore.getGetTraitsHandler()"})
  void testGetGetTraitsHandler_thenMapStoreAddElementsHandlerAddElementsHandler() {
    // Arrange
    MapStore mapStore = new MapStore();

    // Act
    OutputOperationHandler<GetTraits, Set<StoreTrait>> actualGetTraitsHandler =
        mapStore.getGetTraitsHandler();

    // Assert
    assertTrue(mapStore.getAddElementsHandler() instanceof AddElementsHandler);
    assertTrue(mapStore.getDeleteAllDataHandler() instanceof DeleteAllDataHandler);
    assertTrue(mapStore.getDeleteElementsHandler() instanceof DeleteElementsHandler);
    assertTrue(mapStore.getAdjacentIdsHandler() instanceof GetAdjacentIdsHandler);
    assertTrue(mapStore.getGetAllElementsHandler() instanceof GetAllElementsHandler);
    assertTrue(mapStore.getGetElementsHandler() instanceof GetElementsHandler);
    assertTrue(actualGetTraitsHandler instanceof GetTraitsHandler);
    assertNull(mapStore.getGraphId());
    assertNull(mapStore.getJobTracker());
    assertNull(mapStore.getProperties());
    assertNull(mapStore.getMapImpl());
    assertNull(mapStore.getGraphLibrary());
    assertNull(mapStore.getOriginalSchema());
    assertNull(mapStore.getSchema());
    assertTrue(mapStore.getOperationChainOptimisers().isEmpty());
    assertTrue(mapStore.getSupportedOperations().isEmpty());
    Class<MapStoreProperties> expectedPropertiesClass = MapStoreProperties.class;
    assertEquals(expectedPropertiesClass, mapStore.getPropertiesClass());
    Class<Serialiser> expectedRequiredParentSerialiserClass = Serialiser.class;
    assertEquals(
        expectedRequiredParentSerialiserClass, mapStore.getRequiredParentSerialiserClass());
    assertSame(MapStore.TRAITS, mapStore.getTraits());
  }

  /**
   * Test {@link MapStore#createSchemaOptimiser()}.
   *
   * <p>Method under test: {@link MapStore#createSchemaOptimiser()}
   */
  @Test
  @DisplayName("Test createSchemaOptimiser()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SchemaOptimiser MapStore.createSchemaOptimiser()"})
  void testCreateSchemaOptimiser() {
    // Arrange and Act
    SchemaOptimiser actualCreateSchemaOptimiserResult = new MapStore().createSchemaOptimiser();

    // Assert
    assertTrue(actualCreateSchemaOptimiserResult instanceof SchemaOptimiserMapStore);
    assertNull(actualCreateSchemaOptimiserResult.optimise(null, true));
  }

  /**
   * Test new {@link MapStore} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link MapStore}
   */
  @Test
  @DisplayName("Test new MapStore (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MapStore.<init>()"})
  void testNewMapStore() {
    // Arrange and Act
    MapStore actualMapStore = new MapStore();

    // Assert
    assertTrue(actualMapStore.getAddElementsHandler() instanceof AddElementsHandler);
    assertTrue(actualMapStore.getDeleteAllDataHandler() instanceof DeleteAllDataHandler);
    assertTrue(actualMapStore.getDeleteElementsHandler() instanceof DeleteElementsHandler);
    assertTrue(actualMapStore.getAdjacentIdsHandler() instanceof GetAdjacentIdsHandler);
    assertTrue(actualMapStore.getGetAllElementsHandler() instanceof GetAllElementsHandler);
    assertTrue(actualMapStore.getGetElementsHandler() instanceof GetElementsHandler);
    assertTrue(actualMapStore.getGetTraitsHandler() instanceof GetTraitsHandler);
    assertNull(actualMapStore.getGraphId());
    assertNull(actualMapStore.getJobTracker());
    assertNull(actualMapStore.getProperties());
    assertNull(actualMapStore.getMapImpl());
    assertNull(actualMapStore.getGraphLibrary());
    assertNull(actualMapStore.getOriginalSchema());
    assertNull(actualMapStore.getSchema());
    assertTrue(actualMapStore.getOperationChainOptimisers().isEmpty());
    assertTrue(actualMapStore.getSupportedOperations().isEmpty());
    Class<MapStoreProperties> expectedPropertiesClass = MapStoreProperties.class;
    assertEquals(expectedPropertiesClass, actualMapStore.getPropertiesClass());
    Class<Serialiser> expectedRequiredParentSerialiserClass = Serialiser.class;
    assertEquals(
        expectedRequiredParentSerialiserClass, actualMapStore.getRequiredParentSerialiserClass());
    assertSame(MapStore.TRAITS, actualMapStore.getTraits());
  }
}
