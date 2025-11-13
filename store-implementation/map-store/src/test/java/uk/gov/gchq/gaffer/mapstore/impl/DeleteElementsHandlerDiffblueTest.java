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

package uk.gov.gchq.gaffer.mapstore.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.Edge;
import uk.gov.gchq.gaffer.data.element.Edge.Builder;
import uk.gov.gchq.gaffer.data.element.Element;
import uk.gov.gchq.gaffer.data.element.id.EdgeId;
import uk.gov.gchq.gaffer.data.element.id.EdgeId.MatchedVertex;
import uk.gov.gchq.gaffer.mapstore.MapStore;
import uk.gov.gchq.gaffer.mapstore.MapStoreProperties;
import uk.gov.gchq.gaffer.operation.impl.delete.DeleteElements;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.Store;
import uk.gov.gchq.gaffer.store.schema.Schema;

class DeleteElementsHandlerDiffblueTest {
  /**
   * Test {@link DeleteElementsHandler#doOperation(DeleteElements, Context, Store)} with {@code
   * DeleteElements}, {@code Context}, {@code Store}.
   *
   * <ul>
   *   <li>Given {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link DeleteElementsHandler#doOperation(DeleteElements, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(DeleteElements, Context, Store) with 'DeleteElements', 'Context', 'Store'; given 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long DeleteElementsHandler.doOperation(DeleteElements, Context, Store)"})
  void testDoOperationWithDeleteElementsContextStore_givenFalse() {
    // Arrange
    DeleteElementsHandler deleteElementsHandler = new DeleteElementsHandler();

    DeleteElements deleteElements = mock(DeleteElements.class);
    when(deleteElements.isValidate()).thenReturn(false);
    org.mockito.Mockito.<Iterable<? extends Element>>when(deleteElements.getInput())
        .thenReturn(new ArrayList<>());
    Context context = new Context();

    MapStoreProperties mapStoreProperties = mock(MapStoreProperties.class);
    when(mapStoreProperties.getIngestBufferSize()).thenReturn(1);

    MapStore store = mock(MapStore.class);
    when(store.getProperties()).thenReturn(mapStoreProperties);
    Schema schema = new Schema();
    MapImpl mapImpl = new MapImpl(schema, new MapStoreProperties());
    when(store.getMapImpl()).thenReturn(mapImpl);
    when(store.getSchema()).thenReturn(new Schema());

    // Act
    Long actualDoOperationResult =
        deleteElementsHandler.doOperation(deleteElements, context, store);

    // Assert
    verify(store).getMapImpl();
    verify(store).getProperties();
    verify(mapStoreProperties).getIngestBufferSize();
    verify(deleteElements).getInput();
    verify(deleteElements).isValidate();
    verify(store).getSchema();
    assertEquals(0L, actualDoOperationResult.longValue());
  }

  /**
   * Test {@link DeleteElementsHandler#doOperation(DeleteElements, Context, Store)} with {@code
   * DeleteElements}, {@code Context}, {@code Store}.
   *
   * <ul>
   *   <li>Given {@link MapStoreProperties#MapStoreProperties()}.
   * </ul>
   *
   * <p>Method under test: {@link DeleteElementsHandler#doOperation(DeleteElements, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(DeleteElements, Context, Store) with 'DeleteElements', 'Context', 'Store'; given MapStoreProperties()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long DeleteElementsHandler.doOperation(DeleteElements, Context, Store)"})
  void testDoOperationWithDeleteElementsContextStore_givenMapStoreProperties() {
    // Arrange
    DeleteElementsHandler deleteElementsHandler = new DeleteElementsHandler();

    DeleteElements deleteElements = mock(DeleteElements.class);
    when(deleteElements.isSkipInvalidElements()).thenReturn(true);
    when(deleteElements.isValidate()).thenReturn(true);
    org.mockito.Mockito.<Iterable<? extends Element>>when(deleteElements.getInput())
        .thenReturn(new ArrayList<>());
    Context context = new Context();

    MapStore store = mock(MapStore.class);
    when(store.getProperties()).thenReturn(new MapStoreProperties());
    Schema schema = new Schema();
    MapImpl mapImpl = new MapImpl(schema, new MapStoreProperties());
    when(store.getMapImpl()).thenReturn(mapImpl);
    when(store.getSchema()).thenReturn(new Schema());

    // Act
    Long actualDoOperationResult =
        deleteElementsHandler.doOperation(deleteElements, context, store);

    // Assert
    verify(store).getMapImpl();
    verify(store).getProperties();
    verify(deleteElements).getInput();
    verify(deleteElements).isSkipInvalidElements();
    verify(deleteElements).isValidate();
    verify(store, atLeast(1)).getSchema();
    assertEquals(0L, actualDoOperationResult.longValue());
  }

  /**
   * Test {@link DeleteElementsHandler#doOperation(DeleteElements, Context, Store)} with {@code
   * DeleteElements}, {@code Context}, {@code Store}.
   *
   * <ul>
   *   <li>Given {@link MapStoreProperties#MapStoreProperties()}.
   * </ul>
   *
   * <p>Method under test: {@link DeleteElementsHandler#doOperation(DeleteElements, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(DeleteElements, Context, Store) with 'DeleteElements', 'Context', 'Store'; given MapStoreProperties()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long DeleteElementsHandler.doOperation(DeleteElements, Context, Store)"})
  void testDoOperationWithDeleteElementsContextStore_givenMapStoreProperties2() {
    // Arrange
    DeleteElementsHandler deleteElementsHandler = new DeleteElementsHandler();

    ArrayList<Element> elementList = new ArrayList<>();
    elementList.add(
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build());

    DeleteElements deleteElements = mock(DeleteElements.class);
    when(deleteElements.isSkipInvalidElements()).thenReturn(true);
    when(deleteElements.isValidate()).thenReturn(true);
    org.mockito.Mockito.<Iterable<? extends Element>>when(deleteElements.getInput())
        .thenReturn(elementList);
    Context context = new Context();

    MapStore store = mock(MapStore.class);
    when(store.getProperties()).thenReturn(new MapStoreProperties());
    Schema schema = new Schema();
    MapImpl mapImpl = new MapImpl(schema, new MapStoreProperties());
    when(store.getMapImpl()).thenReturn(mapImpl);
    when(store.getSchema()).thenReturn(new Schema());

    // Act
    Long actualDoOperationResult =
        deleteElementsHandler.doOperation(deleteElements, context, store);

    // Assert
    verify(store).getMapImpl();
    verify(store).getProperties();
    verify(deleteElements).getInput();
    verify(deleteElements).isSkipInvalidElements();
    verify(deleteElements).isValidate();
    verify(store, atLeast(1)).getSchema();
    assertEquals(0L, actualDoOperationResult.longValue());
  }

  /**
   * Test {@link DeleteElementsHandler#doOperation(DeleteElements, Context, Store)} with {@code
   * DeleteElements}, {@code Context}, {@code Store}.
   *
   * <ul>
   *   <li>Then calls {@link MapStoreProperties#getIngestBufferSize()}.
   * </ul>
   *
   * <p>Method under test: {@link DeleteElementsHandler#doOperation(DeleteElements, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(DeleteElements, Context, Store) with 'DeleteElements', 'Context', 'Store'; then calls getIngestBufferSize()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long DeleteElementsHandler.doOperation(DeleteElements, Context, Store)"})
  void testDoOperationWithDeleteElementsContextStore_thenCallsGetIngestBufferSize() {
    // Arrange
    DeleteElementsHandler deleteElementsHandler = new DeleteElementsHandler();

    DeleteElements deleteElements = mock(DeleteElements.class);
    when(deleteElements.isSkipInvalidElements()).thenReturn(true);
    when(deleteElements.isValidate()).thenReturn(true);
    org.mockito.Mockito.<Iterable<? extends Element>>when(deleteElements.getInput())
        .thenReturn(new ArrayList<>());
    Context context = new Context();

    MapStoreProperties mapStoreProperties = mock(MapStoreProperties.class);
    when(mapStoreProperties.getIngestBufferSize()).thenReturn(1);

    MapStore store = mock(MapStore.class);
    when(store.getProperties()).thenReturn(mapStoreProperties);
    Schema schema = new Schema();
    MapImpl mapImpl = new MapImpl(schema, new MapStoreProperties());
    when(store.getMapImpl()).thenReturn(mapImpl);
    when(store.getSchema()).thenReturn(new Schema());

    // Act
    Long actualDoOperationResult =
        deleteElementsHandler.doOperation(deleteElements, context, store);

    // Assert
    verify(store).getMapImpl();
    verify(store).getProperties();
    verify(mapStoreProperties).getIngestBufferSize();
    verify(deleteElements).getInput();
    verify(deleteElements).isSkipInvalidElements();
    verify(deleteElements).isValidate();
    verify(store, atLeast(1)).getSchema();
    assertEquals(0L, actualDoOperationResult.longValue());
  }

  /**
   * Test {@link DeleteElementsHandler#doOperation(DeleteElements, Context, Store)} with {@code
   * DeleteElements}, {@code Context}, {@code Store}.
   *
   * <ul>
   *   <li>Then calls {@link MapStoreProperties#getIngestBufferSize()}.
   * </ul>
   *
   * <p>Method under test: {@link DeleteElementsHandler#doOperation(DeleteElements, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(DeleteElements, Context, Store) with 'DeleteElements', 'Context', 'Store'; then calls getIngestBufferSize()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long DeleteElementsHandler.doOperation(DeleteElements, Context, Store)"})
  void testDoOperationWithDeleteElementsContextStore_thenCallsGetIngestBufferSize2() {
    // Arrange
    DeleteElementsHandler deleteElementsHandler = new DeleteElementsHandler();

    ArrayList<Element> elementList = new ArrayList<>();
    elementList.add(
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build());

    DeleteElements deleteElements = mock(DeleteElements.class);
    when(deleteElements.isSkipInvalidElements()).thenReturn(true);
    when(deleteElements.isValidate()).thenReturn(true);
    org.mockito.Mockito.<Iterable<? extends Element>>when(deleteElements.getInput())
        .thenReturn(elementList);
    Context context = new Context();

    MapStoreProperties mapStoreProperties = mock(MapStoreProperties.class);
    when(mapStoreProperties.getIngestBufferSize()).thenReturn(1);

    MapStore store = mock(MapStore.class);
    when(store.getProperties()).thenReturn(mapStoreProperties);
    Schema schema = new Schema();
    MapImpl mapImpl = new MapImpl(schema, new MapStoreProperties());
    when(store.getMapImpl()).thenReturn(mapImpl);
    when(store.getSchema()).thenReturn(new Schema());

    // Act
    Long actualDoOperationResult =
        deleteElementsHandler.doOperation(deleteElements, context, store);

    // Assert
    verify(store).getMapImpl();
    verify(store).getProperties();
    verify(mapStoreProperties).getIngestBufferSize();
    verify(deleteElements).getInput();
    verify(deleteElements).isSkipInvalidElements();
    verify(deleteElements).isValidate();
    verify(store, atLeast(1)).getSchema();
    assertEquals(0L, actualDoOperationResult.longValue());
  }
}
