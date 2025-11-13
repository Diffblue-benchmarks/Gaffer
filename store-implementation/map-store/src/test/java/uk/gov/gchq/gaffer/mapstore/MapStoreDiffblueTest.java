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
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uk.gov.gchq.gaffer.commonutil.iterable.EmptyIterable;
import uk.gov.gchq.gaffer.commonutil.iterable.EmptyIterator;
import uk.gov.gchq.gaffer.data.element.Edge;
import uk.gov.gchq.gaffer.data.element.Element;
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
import uk.gov.gchq.gaffer.operation.impl.delete.DeleteElements;
import uk.gov.gchq.gaffer.operation.impl.get.GetAdjacentIds;
import uk.gov.gchq.gaffer.operation.impl.get.GetAllElements;
import uk.gov.gchq.gaffer.serialisation.Serialiser;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.Context.Builder;
import uk.gov.gchq.gaffer.store.StoreTrait;
import uk.gov.gchq.gaffer.store.operation.handler.GetTraitsHandler;
import uk.gov.gchq.gaffer.store.operation.handler.OutputOperationHandler;
import uk.gov.gchq.gaffer.store.schema.Schema;
import uk.gov.gchq.gaffer.store.schema.SchemaOptimiser;
import uk.gov.gchq.gaffer.user.User;

class MapStoreDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MapImpl MapStore.getMapImpl()", "Class MapStore.getPropertiesClass()",
      "Class MapStore.getRequiredParentSerialiserClass()", "Set MapStore.getTraits()",
      "void MapStore.resetStaticMap()"})
  void testGettersAndSetters() {
    // Arrange
    MapStore mapStore = new MapStore();

    // Act
    mapStore.resetStaticMap();
    MapImpl actualMapImpl = mapStore.getMapImpl();
    Class<MapStoreProperties> actualPropertiesClass = mapStore.getPropertiesClass();
    Class<? extends Serialiser> actualRequiredParentSerialiserClass = mapStore.getRequiredParentSerialiserClass();
    Set<StoreTrait> actualTraits = mapStore.getTraits();

    // Assert
    assertNull(actualMapImpl);
    Class<MapStoreProperties> expectedPropertiesClass = MapStoreProperties.class;
    assertEquals(expectedPropertiesClass, actualPropertiesClass);
    Class<Serialiser> expectedRequiredParentSerialiserClass = Serialiser.class;
    assertEquals(expectedRequiredParentSerialiserClass, actualRequiredParentSerialiserClass);
    assertSame(mapStore.TRAITS, actualTraits);
  }

  /**
   * Test {@link MapStore#getProperties()}.
   * <p>
   * Method under test: {@link MapStore#getProperties()}
   */
  @Test
  @DisplayName("Test getProperties()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MapStoreProperties MapStore.getProperties()"})
  void testGetProperties() {
    // Arrange, Act and Assert
    assertNull((new MapStore()).getProperties());
  }

  /**
   * Test {@link MapStore#addAdditionalOperationHandlers()}.
   * <p>
   * Method under test: {@link MapStore#addAdditionalOperationHandlers()}
   */
  @Test
  @DisplayName("Test addAdditionalOperationHandlers()")
  @Tag("MaintainedByDiffblue")
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
   * Test {@link MapStore#getGetAllElementsHandler()}.
   * <p>
   * Method under test: {@link MapStore#getGetAllElementsHandler()}
   */
  @Test
  @DisplayName("Test getGetAllElementsHandler()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"OutputOperationHandler MapStore.getGetAllElementsHandler()"})
  void testGetGetAllElementsHandler() throws OperationException {
    // Arrange and Act
    OutputOperationHandler<GetAllElements, Iterable<? extends Element>> actualGetAllElementsHandler = (new MapStore())
        .getGetAllElementsHandler();
    GetAllElements getAllElements = new GetAllElements();
    Builder builder = new Builder();
    User user = (new User.Builder()).userId("42").build();
    Context buildResult = builder.user(user).build();
    actualGetAllElementsHandler.doOperation(getAllElements, buildResult, new MapStore());

    // Assert
    assertTrue(actualGetAllElementsHandler instanceof GetAllElementsHandler);
  }

  /**
   * Test {@link MapStore#getAdjacentIdsHandler()}.
   * <p>
   * Method under test: {@link MapStore#getAdjacentIdsHandler()}
   */
  @Test
  @DisplayName("Test getAdjacentIdsHandler()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"OutputOperationHandler MapStore.getAdjacentIdsHandler()"})
  void testGetAdjacentIdsHandler() throws OperationException {
    // Arrange and Act
    OutputOperationHandler<GetAdjacentIds, Iterable<? extends EntityId>> actualAdjacentIdsHandler = (new MapStore())
        .getAdjacentIdsHandler();
    GetAdjacentIds getAdjacentIds = new GetAdjacentIds();
    Builder builder = new Builder();
    User user = (new User.Builder()).userId("42").build();
    Context buildResult = builder.user(user).build();
    Iterable<? extends EntityId> actualDoOperationResult = actualAdjacentIdsHandler.doOperation(getAdjacentIds,
        buildResult, new MapStore());

    // Assert
    assertTrue(actualDoOperationResult instanceof EmptyIterable);
    Iterator<? extends EntityId> iteratorResult = actualDoOperationResult.iterator();
    assertTrue(iteratorResult instanceof EmptyIterator);
    assertTrue(actualAdjacentIdsHandler instanceof GetAdjacentIdsHandler);
    assertFalse(iteratorResult.hasNext());
  }

  /**
   * Test {@link MapStore#getDeleteElementsHandler()}.
   * <ul>
   *   <li>Then calls {@link DeleteElements#isSkipInvalidElements()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MapStore#getDeleteElementsHandler()}
   */
  @Test
  @DisplayName("Test getDeleteElementsHandler(); then calls isSkipInvalidElements()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"OutputOperationHandler MapStore.getDeleteElementsHandler()"})
  void testGetDeleteElementsHandler_thenCallsIsSkipInvalidElements() throws OperationException {
    // Arrange
    MapStore mapStore = new MapStore();

    // Act
    OutputOperationHandler<DeleteElements, Long> actualDeleteElementsHandler = mapStore.getDeleteElementsHandler();
    DeleteElements deleteElements = mock(DeleteElements.class);
    when(deleteElements.isSkipInvalidElements()).thenReturn(true);
    when(deleteElements.isValidate()).thenReturn(true);
    Mockito.<Iterable<? extends Element>>when(deleteElements.getInput()).thenReturn(new ArrayList<>());
    Builder builder = mock(Builder.class);
    when(builder.user(Mockito.<User>any())).thenReturn(new Builder());
    User.Builder builder2 = mock(User.Builder.class);
    when(builder2.userId(Mockito.<String>any())).thenReturn(new User.Builder());
    User user = builder2.userId("42").build();
    Context buildResult = builder.user(user).build();
    SingleUseMapStore singleUseMapStore = mock(SingleUseMapStore.class);
    when(singleUseMapStore.getProperties()).thenReturn(new MapStoreProperties());
    Schema schema = new Schema();
    when(singleUseMapStore.getMapImpl()).thenReturn(new MapImpl(schema, new MapStoreProperties()));
    when(singleUseMapStore.getSchema()).thenReturn(new Schema());
    Long actualDoOperationResult = actualDeleteElementsHandler.doOperation(deleteElements, buildResult,
        singleUseMapStore);

    // Assert
    verify(singleUseMapStore).getMapImpl();
    verify(singleUseMapStore).getProperties();
    verify(deleteElements).getInput();
    verify(deleteElements).isSkipInvalidElements();
    verify(deleteElements).isValidate();
    verify(builder).user(isA(User.class));
    verify(singleUseMapStore, atLeast(1)).getSchema();
    verify(builder2).userId(eq("42"));
    assertTrue(actualDeleteElementsHandler instanceof DeleteElementsHandler);
    assertEquals(0L, actualDoOperationResult.longValue());
    Set<StoreTrait> expectedTraits = singleUseMapStore.TRAITS;
    assertSame(expectedTraits, mapStore.getTraits());
  }

  /**
   * Test {@link MapStore#getDeleteElementsHandler()}.
   * <ul>
   *   <li>Then calls {@link DeleteElements#isSkipInvalidElements()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MapStore#getDeleteElementsHandler()}
   */
  @Test
  @DisplayName("Test getDeleteElementsHandler(); then calls isSkipInvalidElements()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"OutputOperationHandler MapStore.getDeleteElementsHandler()"})
  void testGetDeleteElementsHandler_thenCallsIsSkipInvalidElements2() throws OperationException {
    // Arrange
    MapStore mapStore = new MapStore();

    // Act
    OutputOperationHandler<DeleteElements, Long> actualDeleteElementsHandler = mapStore.getDeleteElementsHandler();
    ArrayList<Element> elementList = new ArrayList<>();
    elementList.add(new Edge("Deleting elements: {}"));
    DeleteElements deleteElements = mock(DeleteElements.class);
    when(deleteElements.isSkipInvalidElements()).thenReturn(true);
    when(deleteElements.isValidate()).thenReturn(true);
    Mockito.<Iterable<? extends Element>>when(deleteElements.getInput()).thenReturn(elementList);
    Builder builder = mock(Builder.class);
    when(builder.user(Mockito.<User>any())).thenReturn(new Builder());
    User.Builder builder2 = mock(User.Builder.class);
    when(builder2.userId(Mockito.<String>any())).thenReturn(new User.Builder());
    User user = builder2.userId("42").build();
    Context buildResult = builder.user(user).build();
    SingleUseMapStore singleUseMapStore = mock(SingleUseMapStore.class);
    when(singleUseMapStore.getProperties()).thenReturn(new MapStoreProperties());
    Schema schema = new Schema();
    when(singleUseMapStore.getMapImpl()).thenReturn(new MapImpl(schema, new MapStoreProperties()));
    when(singleUseMapStore.getSchema()).thenReturn(new Schema());
    Long actualDoOperationResult = actualDeleteElementsHandler.doOperation(deleteElements, buildResult,
        singleUseMapStore);

    // Assert
    verify(singleUseMapStore).getMapImpl();
    verify(singleUseMapStore).getProperties();
    verify(deleteElements).getInput();
    verify(deleteElements).isSkipInvalidElements();
    verify(deleteElements).isValidate();
    verify(builder).user(isA(User.class));
    verify(singleUseMapStore, atLeast(1)).getSchema();
    verify(builder2).userId(eq("42"));
    assertTrue(actualDeleteElementsHandler instanceof DeleteElementsHandler);
    assertEquals(0L, actualDoOperationResult.longValue());
    Set<StoreTrait> expectedTraits = singleUseMapStore.TRAITS;
    assertSame(expectedTraits, mapStore.getTraits());
  }

  /**
   * Test {@link MapStore#getDeleteElementsHandler()}.
   * <ul>
   *   <li>Then return {@link DeleteElementsHandler}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MapStore#getDeleteElementsHandler()}
   */
  @Test
  @DisplayName("Test getDeleteElementsHandler(); then return DeleteElementsHandler")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"OutputOperationHandler MapStore.getDeleteElementsHandler()"})
  void testGetDeleteElementsHandler_thenReturnDeleteElementsHandler() throws OperationException {
    // Arrange
    MapStore mapStore = new MapStore();

    // Act
    OutputOperationHandler<DeleteElements, Long> actualDeleteElementsHandler = mapStore.getDeleteElementsHandler();
    DeleteElements deleteElements = mock(DeleteElements.class);
    when(deleteElements.isValidate()).thenReturn(false);
    Mockito.<Iterable<? extends Element>>when(deleteElements.getInput()).thenReturn(new ArrayList<>());
    Builder builder = mock(Builder.class);
    when(builder.user(Mockito.<User>any())).thenReturn(new Builder());
    User.Builder builder2 = mock(User.Builder.class);
    when(builder2.userId(Mockito.<String>any())).thenReturn(new User.Builder());
    User user = builder2.userId("42").build();
    Context buildResult = builder.user(user).build();
    SingleUseMapStore singleUseMapStore = mock(SingleUseMapStore.class);
    when(singleUseMapStore.getProperties()).thenReturn(new MapStoreProperties());
    Schema schema = new Schema();
    when(singleUseMapStore.getMapImpl()).thenReturn(new MapImpl(schema, new MapStoreProperties()));
    when(singleUseMapStore.getSchema()).thenReturn(new Schema());
    Long actualDoOperationResult = actualDeleteElementsHandler.doOperation(deleteElements, buildResult,
        singleUseMapStore);

    // Assert
    verify(singleUseMapStore).getMapImpl();
    verify(singleUseMapStore).getProperties();
    verify(deleteElements).getInput();
    verify(deleteElements).isValidate();
    verify(builder).user(isA(User.class));
    verify(singleUseMapStore).getSchema();
    verify(builder2).userId(eq("42"));
    assertTrue(actualDeleteElementsHandler instanceof DeleteElementsHandler);
    assertEquals(0L, actualDoOperationResult.longValue());
    Set<StoreTrait> expectedTraits = singleUseMapStore.TRAITS;
    assertSame(expectedTraits, mapStore.getTraits());
  }

  /**
   * Test {@link MapStore#createSchemaOptimiser()}.
   * <p>
   * Method under test: {@link MapStore#createSchemaOptimiser()}
   */
  @Test
  @DisplayName("Test createSchemaOptimiser()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SchemaOptimiser MapStore.createSchemaOptimiser()"})
  void testCreateSchemaOptimiser() {
    // Arrange and Act
    SchemaOptimiser actualCreateSchemaOptimiserResult = (new MapStore()).createSchemaOptimiser();

    // Assert
    assertTrue(actualCreateSchemaOptimiserResult instanceof SchemaOptimiserMapStore);
    assertNull(actualCreateSchemaOptimiserResult.optimise(null, true));
  }

  /**
   * Test new {@link MapStore} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link MapStore}
   */
  @Test
  @DisplayName("Test new MapStore (default constructor)")
  @Tag("MaintainedByDiffblue")
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
    assertEquals(expectedRequiredParentSerialiserClass, actualMapStore.getRequiredParentSerialiserClass());
    Set<StoreTrait> expectedTraits = actualMapStore.TRAITS;
    assertSame(expectedTraits, actualMapStore.getTraits());
  }
}
