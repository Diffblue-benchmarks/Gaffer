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
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashSet;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uk.gov.gchq.gaffer.data.element.Edge;
import uk.gov.gchq.gaffer.data.element.Edge.Builder;
import uk.gov.gchq.gaffer.data.element.Element;
import uk.gov.gchq.gaffer.data.element.function.ElementFilter;
import uk.gov.gchq.gaffer.data.element.id.EdgeId;
import uk.gov.gchq.gaffer.data.element.id.EdgeId.MatchedVertex;
import uk.gov.gchq.gaffer.mapstore.MapStore;
import uk.gov.gchq.gaffer.mapstore.MapStoreProperties;
import uk.gov.gchq.gaffer.operation.data.EdgeSeed;
import uk.gov.gchq.gaffer.operation.data.EntitySeed;
import uk.gov.gchq.gaffer.operation.impl.delete.DeleteElements;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.Store;
import uk.gov.gchq.gaffer.store.schema.Schema;
import uk.gov.gchq.gaffer.store.schema.SchemaEdgeDefinition;
import uk.gov.gchq.gaffer.store.schema.SchemaElementDefinition;

class DeleteElementsHandlerDiffblueTest {
  /**
   * Test {@link DeleteElementsHandler#doOperation(DeleteElements, Context, Store)} with {@code DeleteElements}, {@code Context}, {@code Store}.
   * <p>
   * Method under test: {@link DeleteElementsHandler#doOperation(DeleteElements, Context, Store)}
   */
  @Test
  @DisplayName("Test doOperation(DeleteElements, Context, Store) with 'DeleteElements', 'Context', 'Store'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Long DeleteElementsHandler.doOperation(DeleteElements, Context, Store)"})
  void testDoOperationWithDeleteElementsContextStore() {
    // Arrange
    DeleteElementsHandler deleteElementsHandler = new DeleteElementsHandler();
    DeleteElements deleteElements = mock(DeleteElements.class);
    when(deleteElements.isValidate()).thenReturn(false);
    Mockito.<Iterable<? extends Element>>when(deleteElements.getInput()).thenReturn(new ArrayList<>());
    Context context = new Context();
    MapStoreProperties mapStoreProperties = mock(MapStoreProperties.class);
    when(mapStoreProperties.getIngestBufferSize()).thenReturn(3);
    MapStore store = mock(MapStore.class);
    when(store.getProperties()).thenReturn(mapStoreProperties);
    Schema schema = new Schema();
    when(store.getMapImpl()).thenReturn(new MapImpl(schema, new MapStoreProperties()));
    when(store.getSchema()).thenReturn(new Schema());

    // Act
    Long actualDoOperationResult = deleteElementsHandler.doOperation(deleteElements, context, store);

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
   * Test {@link DeleteElementsHandler#doOperation(DeleteElements, Context, Store)} with {@code DeleteElements}, {@code Context}, {@code Store}.
   * <p>
   * Method under test: {@link DeleteElementsHandler#doOperation(DeleteElements, Context, Store)}
   */
  @Test
  @DisplayName("Test doOperation(DeleteElements, Context, Store) with 'DeleteElements', 'Context', 'Store'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Long DeleteElementsHandler.doOperation(DeleteElements, Context, Store)"})
  void testDoOperationWithDeleteElementsContextStore2() {
    // Arrange
    DeleteElementsHandler deleteElementsHandler = new DeleteElementsHandler();
    Edge edge = mock(Edge.class);
    when(edge.getGroup()).thenReturn("Group");
    Edge buildResult = (new Builder()).dest("Dest")
        .directed(true)
        .group("Group")
        .matchedVertex(MatchedVertex.SOURCE)
        .source("Source")
        .build();
    when(edge.emptyClone()).thenReturn(buildResult);

    ArrayList<Element> elementList = new ArrayList<>();
    elementList.add(edge);
    DeleteElements deleteElements = mock(DeleteElements.class);
    when(deleteElements.isSkipInvalidElements()).thenReturn(true);
    when(deleteElements.isValidate()).thenReturn(true);
    Mockito.<Iterable<? extends Element>>when(deleteElements.getInput()).thenReturn(elementList);
    Context context = new Context();
    MapStoreProperties mapStoreProperties = mock(MapStoreProperties.class);
    when(mapStoreProperties.getIngestBufferSize()).thenReturn(1);
    MapImpl mapImpl = mock(MapImpl.class);
    when(mapImpl.getGroupByProperties(Mockito.<String>any())).thenReturn(new HashSet<>());
    when(mapImpl.getNonGroupByProperties(Mockito.<String>any())).thenReturn(new HashSet<>());
    doNothing().when(mapImpl).deleteAggElement(Mockito.<Element>any());
    doNothing().when(mapImpl).removeEdgeIndex(Mockito.<EdgeSeed>any(), Mockito.<Element>any());
    doNothing().when(mapImpl).removeEntityIndex(Mockito.<EntitySeed>any(), Mockito.<Element>any());
    when(mapImpl.isAggregationEnabled(Mockito.<Element>any())).thenReturn(true);
    when(mapImpl.isMaintainIndex()).thenReturn(true);
    Schema schema = mock(Schema.class);
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.getGroups()).thenReturn(new HashSet<>());
    when(schema.getElement(Mockito.<String>any())).thenReturn(new SchemaEdgeDefinition());
    MapStore store = mock(MapStore.class);
    when(store.getProperties()).thenReturn(mapStoreProperties);
    when(store.getMapImpl()).thenReturn(mapImpl);
    when(store.getSchema()).thenReturn(schema);

    // Act
    Long actualDoOperationResult = deleteElementsHandler.doOperation(deleteElements, context, store);

    // Assert
    verify(edge).emptyClone();
    verify(edge, atLeast(1)).getGroup();
    verify(schema).getGroups();
    verify(store).getMapImpl();
    verify(store).getProperties();
    verify(mapStoreProperties).getIngestBufferSize();
    verify(mapImpl).deleteAggElement(isA(Element.class));
    verify(mapImpl, atLeast(1)).getGroupByProperties(eq("Group"));
    verify(mapImpl, atLeast(1)).getNonGroupByProperties(eq("Group"));
    verify(mapImpl).isAggregationEnabled(isA(Element.class));
    verify(mapImpl).isMaintainIndex();
    verify(mapImpl).removeEdgeIndex(isA(EdgeSeed.class), isA(Element.class));
    verify(mapImpl, atLeast(1)).removeEntityIndex(Mockito.<EntitySeed>any(), isA(Element.class));
    verify(deleteElements).getInput();
    verify(deleteElements).isSkipInvalidElements();
    verify(deleteElements).isValidate();
    verify(store, atLeast(1)).getSchema();
    verify(schema).getAggregatedGroups();
    verify(schema, atLeast(1)).getElement(eq("Group"));
    assertEquals(1L, actualDoOperationResult.longValue());
  }

  /**
   * Test {@link DeleteElementsHandler#doOperation(DeleteElements, Context, Store)} with {@code DeleteElements}, {@code Context}, {@code Store}.
   * <p>
   * Method under test: {@link DeleteElementsHandler#doOperation(DeleteElements, Context, Store)}
   */
  @Test
  @DisplayName("Test doOperation(DeleteElements, Context, Store) with 'DeleteElements', 'Context', 'Store'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Long DeleteElementsHandler.doOperation(DeleteElements, Context, Store)"})
  void testDoOperationWithDeleteElementsContextStore3() {
    // Arrange
    DeleteElementsHandler deleteElementsHandler = new DeleteElementsHandler();
    Edge edge = mock(Edge.class);
    when(edge.getProperty(Mockito.<String>any())).thenReturn("Property");
    when(edge.getGroup()).thenReturn("Group");
    Edge buildResult = (new Builder()).dest("Dest")
        .directed(true)
        .group("Group")
        .matchedVertex(MatchedVertex.SOURCE)
        .source("Source")
        .build();
    when(edge.emptyClone()).thenReturn(buildResult);

    ArrayList<Element> elementList = new ArrayList<>();
    elementList.add(edge);
    DeleteElements deleteElements = mock(DeleteElements.class);
    when(deleteElements.isSkipInvalidElements()).thenReturn(true);
    when(deleteElements.isValidate()).thenReturn(true);
    Mockito.<Iterable<? extends Element>>when(deleteElements.getInput()).thenReturn(elementList);
    Context context = new Context();
    MapStoreProperties mapStoreProperties = mock(MapStoreProperties.class);
    when(mapStoreProperties.getIngestBufferSize()).thenReturn(3);

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("Deleting elements in batches, batch size = {}");
    stringSet.add("Deleting elements: {}");
    MapImpl mapImpl = mock(MapImpl.class);
    when(mapImpl.getGroupByProperties(Mockito.<String>any())).thenReturn(stringSet);
    when(mapImpl.getNonGroupByProperties(Mockito.<String>any())).thenReturn(new HashSet<>());
    doNothing().when(mapImpl).deleteAggElement(Mockito.<Element>any());
    doNothing().when(mapImpl).removeEdgeIndex(Mockito.<EdgeSeed>any(), Mockito.<Element>any());
    doNothing().when(mapImpl).removeEntityIndex(Mockito.<EntitySeed>any(), Mockito.<Element>any());
    when(mapImpl.isAggregationEnabled(Mockito.<Element>any())).thenReturn(true);
    when(mapImpl.isMaintainIndex()).thenReturn(true);
    Schema schema = mock(Schema.class);
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.getGroups()).thenReturn(new HashSet<>());
    when(schema.getElement(Mockito.<String>any())).thenReturn(new SchemaEdgeDefinition());
    MapStore store = mock(MapStore.class);
    when(store.getProperties()).thenReturn(mapStoreProperties);
    when(store.getMapImpl()).thenReturn(mapImpl);
    when(store.getSchema()).thenReturn(schema);

    // Act
    Long actualDoOperationResult = deleteElementsHandler.doOperation(deleteElements, context, store);

    // Assert
    verify(edge).emptyClone();
    verify(edge, atLeast(1)).getGroup();
    verify(edge, atLeast(1)).getProperty(Mockito.<String>any());
    verify(schema).getGroups();
    verify(store).getMapImpl();
    verify(store).getProperties();
    verify(mapStoreProperties).getIngestBufferSize();
    verify(mapImpl).deleteAggElement(isA(Element.class));
    verify(mapImpl, atLeast(1)).getGroupByProperties(eq("Group"));
    verify(mapImpl, atLeast(1)).getNonGroupByProperties(eq("Group"));
    verify(mapImpl).isAggregationEnabled(isA(Element.class));
    verify(mapImpl).isMaintainIndex();
    verify(mapImpl).removeEdgeIndex(isA(EdgeSeed.class), isA(Element.class));
    verify(mapImpl, atLeast(1)).removeEntityIndex(Mockito.<EntitySeed>any(), isA(Element.class));
    verify(deleteElements).getInput();
    verify(deleteElements).isSkipInvalidElements();
    verify(deleteElements).isValidate();
    verify(store, atLeast(1)).getSchema();
    verify(schema).getAggregatedGroups();
    verify(schema, atLeast(1)).getElement(eq("Group"));
    assertEquals(1L, actualDoOperationResult.longValue());
  }

  /**
   * Test {@link DeleteElementsHandler#doOperation(DeleteElements, Context, Store)} with {@code DeleteElements}, {@code Context}, {@code Store}.
   * <p>
   * Method under test: {@link DeleteElementsHandler#doOperation(DeleteElements, Context, Store)}
   */
  @Test
  @DisplayName("Test doOperation(DeleteElements, Context, Store) with 'DeleteElements', 'Context', 'Store'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Long DeleteElementsHandler.doOperation(DeleteElements, Context, Store)"})
  void testDoOperationWithDeleteElementsContextStore4() {
    // Arrange
    DeleteElementsHandler deleteElementsHandler = new DeleteElementsHandler();
    Edge edge = mock(Edge.class);
    when(edge.getProperty(Mockito.<String>any())).thenReturn("Property");
    when(edge.getGroup()).thenReturn("Group");
    Edge buildResult = (new Builder()).dest("Dest")
        .directed(true)
        .group("Group")
        .matchedVertex(MatchedVertex.SOURCE)
        .source("Source")
        .build();
    when(edge.emptyClone()).thenReturn(buildResult);

    ArrayList<Element> elementList = new ArrayList<>();
    elementList.add(edge);
    DeleteElements deleteElements = mock(DeleteElements.class);
    when(deleteElements.isSkipInvalidElements()).thenReturn(true);
    when(deleteElements.isValidate()).thenReturn(true);
    Mockito.<Iterable<? extends Element>>when(deleteElements.getInput()).thenReturn(elementList);
    Context context = new Context();
    MapStoreProperties mapStoreProperties = mock(MapStoreProperties.class);
    when(mapStoreProperties.getIngestBufferSize()).thenReturn(3);

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("Deleting elements: {}");

    HashSet<String> stringSet2 = new HashSet<>();
    stringSet2.add("Deleting elements in batches, batch size = {}");
    stringSet2.add("Deleting elements: {}");
    MapImpl mapImpl = mock(MapImpl.class);
    when(mapImpl.getGroupByProperties(Mockito.<String>any())).thenReturn(stringSet);
    when(mapImpl.getNonGroupByProperties(Mockito.<String>any())).thenReturn(stringSet2);
    doNothing().when(mapImpl).deleteAggElement(Mockito.<Element>any());
    doNothing().when(mapImpl).removeEdgeIndex(Mockito.<EdgeSeed>any(), Mockito.<Element>any());
    doNothing().when(mapImpl).removeEntityIndex(Mockito.<EntitySeed>any(), Mockito.<Element>any());
    when(mapImpl.isAggregationEnabled(Mockito.<Element>any())).thenReturn(true);
    when(mapImpl.isMaintainIndex()).thenReturn(true);
    Schema schema = mock(Schema.class);
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.getGroups()).thenReturn(new HashSet<>());
    when(schema.getElement(Mockito.<String>any())).thenReturn(new SchemaEdgeDefinition());
    MapStore store = mock(MapStore.class);
    when(store.getProperties()).thenReturn(mapStoreProperties);
    when(store.getMapImpl()).thenReturn(mapImpl);
    when(store.getSchema()).thenReturn(schema);

    // Act
    Long actualDoOperationResult = deleteElementsHandler.doOperation(deleteElements, context, store);

    // Assert
    verify(edge).emptyClone();
    verify(edge, atLeast(1)).getGroup();
    verify(edge, atLeast(1)).getProperty(Mockito.<String>any());
    verify(schema).getGroups();
    verify(store).getMapImpl();
    verify(store).getProperties();
    verify(mapStoreProperties).getIngestBufferSize();
    verify(mapImpl).deleteAggElement(isA(Element.class));
    verify(mapImpl, atLeast(1)).getGroupByProperties(eq("Group"));
    verify(mapImpl, atLeast(1)).getNonGroupByProperties(eq("Group"));
    verify(mapImpl).isAggregationEnabled(isA(Element.class));
    verify(mapImpl).isMaintainIndex();
    verify(mapImpl).removeEdgeIndex(isA(EdgeSeed.class), isA(Element.class));
    verify(mapImpl, atLeast(1)).removeEntityIndex(Mockito.<EntitySeed>any(), isA(Element.class));
    verify(deleteElements).getInput();
    verify(deleteElements).isSkipInvalidElements();
    verify(deleteElements).isValidate();
    verify(store, atLeast(1)).getSchema();
    verify(schema).getAggregatedGroups();
    verify(schema, atLeast(1)).getElement(eq("Group"));
    assertEquals(1L, actualDoOperationResult.longValue());
  }

  /**
   * Test {@link DeleteElementsHandler#doOperation(DeleteElements, Context, Store)} with {@code DeleteElements}, {@code Context}, {@code Store}.
   * <p>
   * Method under test: {@link DeleteElementsHandler#doOperation(DeleteElements, Context, Store)}
   */
  @Test
  @DisplayName("Test doOperation(DeleteElements, Context, Store) with 'DeleteElements', 'Context', 'Store'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Long DeleteElementsHandler.doOperation(DeleteElements, Context, Store)"})
  void testDoOperationWithDeleteElementsContextStore5() {
    // Arrange
    DeleteElementsHandler deleteElementsHandler = new DeleteElementsHandler();
    Edge edge = mock(Edge.class);
    when(edge.getProperty(Mockito.<String>any())).thenReturn("Property");
    when(edge.getGroup()).thenReturn("Group");
    Edge buildResult = (new Builder()).dest("Dest")
        .directed(true)
        .group("Group")
        .matchedVertex(MatchedVertex.SOURCE)
        .source("Source")
        .build();
    when(edge.emptyClone()).thenReturn(buildResult);

    ArrayList<Element> elementList = new ArrayList<>();
    elementList.add(edge);
    DeleteElements deleteElements = mock(DeleteElements.class);
    when(deleteElements.isSkipInvalidElements()).thenReturn(true);
    when(deleteElements.isValidate()).thenReturn(true);
    Mockito.<Iterable<? extends Element>>when(deleteElements.getInput()).thenReturn(elementList);
    Context context = new Context();
    MapStoreProperties mapStoreProperties = mock(MapStoreProperties.class);
    when(mapStoreProperties.getIngestBufferSize()).thenReturn(3);

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("Deleting elements: {}");
    MapImpl mapImpl = mock(MapImpl.class);
    when(mapImpl.getGroupByProperties(Mockito.<String>any())).thenReturn(stringSet);
    when(mapImpl.getNonGroupByProperties(Mockito.<String>any())).thenReturn(new HashSet<>());
    doNothing().when(mapImpl).deleteAggElement(Mockito.<Element>any());
    when(mapImpl.isAggregationEnabled(Mockito.<Element>any())).thenReturn(true);
    when(mapImpl.isMaintainIndex()).thenReturn(false);
    Schema schema = mock(Schema.class);
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.getGroups()).thenReturn(new HashSet<>());
    when(schema.getElement(Mockito.<String>any())).thenReturn(new SchemaEdgeDefinition());
    MapStore store = mock(MapStore.class);
    when(store.getProperties()).thenReturn(mapStoreProperties);
    when(store.getMapImpl()).thenReturn(mapImpl);
    when(store.getSchema()).thenReturn(schema);

    // Act
    Long actualDoOperationResult = deleteElementsHandler.doOperation(deleteElements, context, store);

    // Assert
    verify(edge).emptyClone();
    verify(edge, atLeast(1)).getGroup();
    verify(edge).getProperty(eq("Deleting elements: {}"));
    verify(schema).getGroups();
    verify(store).getMapImpl();
    verify(store).getProperties();
    verify(mapStoreProperties).getIngestBufferSize();
    verify(mapImpl).deleteAggElement(isA(Element.class));
    verify(mapImpl, atLeast(1)).getGroupByProperties(eq("Group"));
    verify(mapImpl, atLeast(1)).getNonGroupByProperties(eq("Group"));
    verify(mapImpl).isAggregationEnabled(isA(Element.class));
    verify(mapImpl).isMaintainIndex();
    verify(deleteElements).getInput();
    verify(deleteElements).isSkipInvalidElements();
    verify(deleteElements).isValidate();
    verify(store, atLeast(1)).getSchema();
    verify(schema).getAggregatedGroups();
    verify(schema, atLeast(1)).getElement(eq("Group"));
    assertEquals(1L, actualDoOperationResult.longValue());
  }

  /**
   * Test {@link DeleteElementsHandler#doOperation(DeleteElements, Context, Store)} with {@code DeleteElements}, {@code Context}, {@code Store}.
   * <p>
   * Method under test: {@link DeleteElementsHandler#doOperation(DeleteElements, Context, Store)}
   */
  @Test
  @DisplayName("Test doOperation(DeleteElements, Context, Store) with 'DeleteElements', 'Context', 'Store'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Long DeleteElementsHandler.doOperation(DeleteElements, Context, Store)"})
  void testDoOperationWithDeleteElementsContextStore6() {
    // Arrange
    DeleteElementsHandler deleteElementsHandler = new DeleteElementsHandler();
    Edge edge = mock(Edge.class);
    when(edge.getProperty(Mockito.<String>any())).thenReturn("Property");
    when(edge.getGroup()).thenReturn("Group");
    Edge buildResult = (new Builder()).dest("Dest")
        .directed(true)
        .group("Group")
        .matchedVertex(MatchedVertex.SOURCE)
        .source("Source")
        .build();
    when(edge.emptyClone()).thenReturn(buildResult);

    ArrayList<Element> elementList = new ArrayList<>();
    elementList.add(edge);
    DeleteElements deleteElements = mock(DeleteElements.class);
    when(deleteElements.isSkipInvalidElements()).thenReturn(true);
    when(deleteElements.isValidate()).thenReturn(true);
    Mockito.<Iterable<? extends Element>>when(deleteElements.getInput()).thenReturn(elementList);
    Context context = new Context();
    MapStoreProperties mapStoreProperties = mock(MapStoreProperties.class);
    when(mapStoreProperties.getIngestBufferSize()).thenReturn(3);

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("Deleting elements: {}");
    MapImpl mapImpl = mock(MapImpl.class);
    when(mapImpl.getGroupByProperties(Mockito.<String>any())).thenReturn(stringSet);
    when(mapImpl.getNonGroupByProperties(Mockito.<String>any())).thenReturn(new HashSet<>());
    doNothing().when(mapImpl).deleteAggElement(Mockito.<Element>any());
    doNothing().when(mapImpl).removeEdgeIndex(Mockito.<EdgeSeed>any(), Mockito.<Element>any());
    doNothing().when(mapImpl).removeEntityIndex(Mockito.<EntitySeed>any(), Mockito.<Element>any());
    when(mapImpl.isAggregationEnabled(Mockito.<Element>any())).thenReturn(true);
    when(mapImpl.isMaintainIndex()).thenReturn(true);

    HashSet<String> stringSet2 = new HashSet<>();
    stringSet2.add("Deleting elements: {}");
    Schema schema = mock(Schema.class);
    when(schema.getVisibilityProperty()).thenReturn("Visibility Property");
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.getGroups()).thenReturn(stringSet2);
    when(schema.getElement(Mockito.<String>any())).thenReturn(new SchemaEdgeDefinition());
    MapStore store = mock(MapStore.class);
    when(store.getProperties()).thenReturn(mapStoreProperties);
    when(store.getMapImpl()).thenReturn(mapImpl);
    when(store.getSchema()).thenReturn(schema);

    // Act
    Long actualDoOperationResult = deleteElementsHandler.doOperation(deleteElements, context, store);

    // Assert
    verify(edge).emptyClone();
    verify(edge, atLeast(1)).getGroup();
    verify(edge).getProperty(eq("Deleting elements: {}"));
    verify(schema).getGroups();
    verify(store).getMapImpl();
    verify(store).getProperties();
    verify(mapStoreProperties).getIngestBufferSize();
    verify(mapImpl).deleteAggElement(isA(Element.class));
    verify(mapImpl, atLeast(1)).getGroupByProperties(eq("Group"));
    verify(mapImpl, atLeast(1)).getNonGroupByProperties(eq("Group"));
    verify(mapImpl).isAggregationEnabled(isA(Element.class));
    verify(mapImpl).isMaintainIndex();
    verify(mapImpl).removeEdgeIndex(isA(EdgeSeed.class), isA(Element.class));
    verify(mapImpl, atLeast(1)).removeEntityIndex(Mockito.<EntitySeed>any(), isA(Element.class));
    verify(deleteElements).getInput();
    verify(deleteElements).isSkipInvalidElements();
    verify(deleteElements).isValidate();
    verify(store, atLeast(1)).getSchema();
    verify(schema).getAggregatedGroups();
    verify(schema, atLeast(1)).getElement(Mockito.<String>any());
    verify(schema, atLeast(1)).getVisibilityProperty();
    assertEquals(1L, actualDoOperationResult.longValue());
  }

  /**
   * Test {@link DeleteElementsHandler#doOperation(DeleteElements, Context, Store)} with {@code DeleteElements}, {@code Context}, {@code Store}.
   * <p>
   * Method under test: {@link DeleteElementsHandler#doOperation(DeleteElements, Context, Store)}
   */
  @Test
  @DisplayName("Test doOperation(DeleteElements, Context, Store) with 'DeleteElements', 'Context', 'Store'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Long DeleteElementsHandler.doOperation(DeleteElements, Context, Store)"})
  void testDoOperationWithDeleteElementsContextStore7() {
    // Arrange
    DeleteElementsHandler deleteElementsHandler = new DeleteElementsHandler();
    Edge edge = mock(Edge.class);
    when(edge.getProperty(Mockito.<String>any())).thenReturn("Property");
    when(edge.getGroup()).thenReturn("Group");
    Edge buildResult = (new Builder()).dest("Dest")
        .directed(true)
        .group("Group")
        .matchedVertex(MatchedVertex.SOURCE)
        .source("Source")
        .build();
    when(edge.emptyClone()).thenReturn(buildResult);

    ArrayList<Element> elementList = new ArrayList<>();
    elementList.add(edge);
    DeleteElements deleteElements = mock(DeleteElements.class);
    when(deleteElements.isSkipInvalidElements()).thenReturn(true);
    when(deleteElements.isValidate()).thenReturn(true);
    Mockito.<Iterable<? extends Element>>when(deleteElements.getInput()).thenReturn(elementList);
    Context context = new Context();
    MapStoreProperties mapStoreProperties = mock(MapStoreProperties.class);
    when(mapStoreProperties.getIngestBufferSize()).thenReturn(3);

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("Deleting elements: {}");
    MapImpl mapImpl = mock(MapImpl.class);
    when(mapImpl.getGroupByProperties(Mockito.<String>any())).thenReturn(stringSet);
    when(mapImpl.getNonGroupByProperties(Mockito.<String>any())).thenReturn(new HashSet<>());
    doNothing().when(mapImpl).deleteAggElement(Mockito.<Element>any());
    doNothing().when(mapImpl).removeEdgeIndex(Mockito.<EdgeSeed>any(), Mockito.<Element>any());
    doNothing().when(mapImpl).removeEntityIndex(Mockito.<EntitySeed>any(), Mockito.<Element>any());
    when(mapImpl.isAggregationEnabled(Mockito.<Element>any())).thenReturn(true);
    when(mapImpl.isMaintainIndex()).thenReturn(true);

    HashSet<String> stringSet2 = new HashSet<>();
    stringSet2.add("Deleting elements: {}");
    Schema schema = mock(Schema.class);
    when(schema.getVisibilityProperty()).thenReturn(null);
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.getGroups()).thenReturn(stringSet2);
    when(schema.getElement(Mockito.<String>any())).thenReturn(new SchemaEdgeDefinition());
    MapStore store = mock(MapStore.class);
    when(store.getProperties()).thenReturn(mapStoreProperties);
    when(store.getMapImpl()).thenReturn(mapImpl);
    when(store.getSchema()).thenReturn(schema);

    // Act
    Long actualDoOperationResult = deleteElementsHandler.doOperation(deleteElements, context, store);

    // Assert
    verify(edge).emptyClone();
    verify(edge, atLeast(1)).getGroup();
    verify(edge).getProperty(eq("Deleting elements: {}"));
    verify(schema).getGroups();
    verify(store).getMapImpl();
    verify(store).getProperties();
    verify(mapStoreProperties).getIngestBufferSize();
    verify(mapImpl).deleteAggElement(isA(Element.class));
    verify(mapImpl, atLeast(1)).getGroupByProperties(eq("Group"));
    verify(mapImpl, atLeast(1)).getNonGroupByProperties(eq("Group"));
    verify(mapImpl).isAggregationEnabled(isA(Element.class));
    verify(mapImpl).isMaintainIndex();
    verify(mapImpl).removeEdgeIndex(isA(EdgeSeed.class), isA(Element.class));
    verify(mapImpl, atLeast(1)).removeEntityIndex(Mockito.<EntitySeed>any(), isA(Element.class));
    verify(deleteElements).getInput();
    verify(deleteElements).isSkipInvalidElements();
    verify(deleteElements).isValidate();
    verify(store, atLeast(1)).getSchema();
    verify(schema).getAggregatedGroups();
    verify(schema, atLeast(1)).getElement(Mockito.<String>any());
    verify(schema).getVisibilityProperty();
    assertEquals(1L, actualDoOperationResult.longValue());
  }

  /**
   * Test {@link DeleteElementsHandler#doOperation(DeleteElements, Context, Store)} with {@code DeleteElements}, {@code Context}, {@code Store}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code Deleting elements: {}}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeleteElementsHandler#doOperation(DeleteElements, Context, Store)}
   */
  @Test
  @DisplayName("Test doOperation(DeleteElements, Context, Store) with 'DeleteElements', 'Context', 'Store'; given HashSet() add 'Deleting elements: {}'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Long DeleteElementsHandler.doOperation(DeleteElements, Context, Store)"})
  void testDoOperationWithDeleteElementsContextStore_givenHashSetAddDeletingElements() {
    // Arrange
    DeleteElementsHandler deleteElementsHandler = new DeleteElementsHandler();
    Edge edge = mock(Edge.class);
    when(edge.getProperty(Mockito.<String>any())).thenReturn("Property");
    when(edge.getGroup()).thenReturn("Group");
    Edge buildResult = (new Builder()).dest("Dest")
        .directed(true)
        .group("Group")
        .matchedVertex(MatchedVertex.SOURCE)
        .source("Source")
        .build();
    when(edge.emptyClone()).thenReturn(buildResult);

    ArrayList<Element> elementList = new ArrayList<>();
    elementList.add(edge);
    DeleteElements deleteElements = mock(DeleteElements.class);
    when(deleteElements.isSkipInvalidElements()).thenReturn(true);
    when(deleteElements.isValidate()).thenReturn(true);
    Mockito.<Iterable<? extends Element>>when(deleteElements.getInput()).thenReturn(elementList);
    Context context = new Context();
    MapStoreProperties mapStoreProperties = mock(MapStoreProperties.class);
    when(mapStoreProperties.getIngestBufferSize()).thenReturn(3);

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("Deleting elements: {}");
    MapImpl mapImpl = mock(MapImpl.class);
    when(mapImpl.getGroupByProperties(Mockito.<String>any())).thenReturn(stringSet);
    when(mapImpl.getNonGroupByProperties(Mockito.<String>any())).thenReturn(new HashSet<>());
    doNothing().when(mapImpl).deleteAggElement(Mockito.<Element>any());
    doNothing().when(mapImpl).removeEdgeIndex(Mockito.<EdgeSeed>any(), Mockito.<Element>any());
    doNothing().when(mapImpl).removeEntityIndex(Mockito.<EntitySeed>any(), Mockito.<Element>any());
    when(mapImpl.isAggregationEnabled(Mockito.<Element>any())).thenReturn(true);
    when(mapImpl.isMaintainIndex()).thenReturn(true);
    Schema schema = mock(Schema.class);
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.getGroups()).thenReturn(new HashSet<>());
    when(schema.getElement(Mockito.<String>any())).thenReturn(new SchemaEdgeDefinition());
    MapStore store = mock(MapStore.class);
    when(store.getProperties()).thenReturn(mapStoreProperties);
    when(store.getMapImpl()).thenReturn(mapImpl);
    when(store.getSchema()).thenReturn(schema);

    // Act
    Long actualDoOperationResult = deleteElementsHandler.doOperation(deleteElements, context, store);

    // Assert
    verify(edge).emptyClone();
    verify(edge, atLeast(1)).getGroup();
    verify(edge).getProperty(eq("Deleting elements: {}"));
    verify(schema).getGroups();
    verify(store).getMapImpl();
    verify(store).getProperties();
    verify(mapStoreProperties).getIngestBufferSize();
    verify(mapImpl).deleteAggElement(isA(Element.class));
    verify(mapImpl, atLeast(1)).getGroupByProperties(eq("Group"));
    verify(mapImpl, atLeast(1)).getNonGroupByProperties(eq("Group"));
    verify(mapImpl).isAggregationEnabled(isA(Element.class));
    verify(mapImpl).isMaintainIndex();
    verify(mapImpl).removeEdgeIndex(isA(EdgeSeed.class), isA(Element.class));
    verify(mapImpl, atLeast(1)).removeEntityIndex(Mockito.<EntitySeed>any(), isA(Element.class));
    verify(deleteElements).getInput();
    verify(deleteElements).isSkipInvalidElements();
    verify(deleteElements).isValidate();
    verify(store, atLeast(1)).getSchema();
    verify(schema).getAggregatedGroups();
    verify(schema, atLeast(1)).getElement(eq("Group"));
    assertEquals(1L, actualDoOperationResult.longValue());
  }

  /**
   * Test {@link DeleteElementsHandler#doOperation(DeleteElements, Context, Store)} with {@code DeleteElements}, {@code Context}, {@code Store}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code Deleting elements: {}}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeleteElementsHandler#doOperation(DeleteElements, Context, Store)}
   */
  @Test
  @DisplayName("Test doOperation(DeleteElements, Context, Store) with 'DeleteElements', 'Context', 'Store'; given HashSet() add 'Deleting elements: {}'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Long DeleteElementsHandler.doOperation(DeleteElements, Context, Store)"})
  void testDoOperationWithDeleteElementsContextStore_givenHashSetAddDeletingElements2() {
    // Arrange
    DeleteElementsHandler deleteElementsHandler = new DeleteElementsHandler();
    Edge edge = mock(Edge.class);
    when(edge.getProperty(Mockito.<String>any())).thenReturn("Property");
    when(edge.getGroup()).thenReturn("Group");
    Edge buildResult = (new Builder()).dest("Dest")
        .directed(true)
        .group("Group")
        .matchedVertex(MatchedVertex.SOURCE)
        .source("Source")
        .build();
    when(edge.emptyClone()).thenReturn(buildResult);

    ArrayList<Element> elementList = new ArrayList<>();
    elementList.add(edge);
    DeleteElements deleteElements = mock(DeleteElements.class);
    when(deleteElements.isSkipInvalidElements()).thenReturn(true);
    when(deleteElements.isValidate()).thenReturn(true);
    Mockito.<Iterable<? extends Element>>when(deleteElements.getInput()).thenReturn(elementList);
    Context context = new Context();
    MapStoreProperties mapStoreProperties = mock(MapStoreProperties.class);
    when(mapStoreProperties.getIngestBufferSize()).thenReturn(3);

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("Deleting elements: {}");

    HashSet<String> stringSet2 = new HashSet<>();
    stringSet2.add("Deleting elements: {}");
    MapImpl mapImpl = mock(MapImpl.class);
    when(mapImpl.getGroupByProperties(Mockito.<String>any())).thenReturn(stringSet);
    when(mapImpl.getNonGroupByProperties(Mockito.<String>any())).thenReturn(stringSet2);
    doNothing().when(mapImpl).deleteAggElement(Mockito.<Element>any());
    doNothing().when(mapImpl).removeEdgeIndex(Mockito.<EdgeSeed>any(), Mockito.<Element>any());
    doNothing().when(mapImpl).removeEntityIndex(Mockito.<EntitySeed>any(), Mockito.<Element>any());
    when(mapImpl.isAggregationEnabled(Mockito.<Element>any())).thenReturn(true);
    when(mapImpl.isMaintainIndex()).thenReturn(true);
    Schema schema = mock(Schema.class);
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.getGroups()).thenReturn(new HashSet<>());
    when(schema.getElement(Mockito.<String>any())).thenReturn(new SchemaEdgeDefinition());
    MapStore store = mock(MapStore.class);
    when(store.getProperties()).thenReturn(mapStoreProperties);
    when(store.getMapImpl()).thenReturn(mapImpl);
    when(store.getSchema()).thenReturn(schema);

    // Act
    Long actualDoOperationResult = deleteElementsHandler.doOperation(deleteElements, context, store);

    // Assert
    verify(edge).emptyClone();
    verify(edge, atLeast(1)).getGroup();
    verify(edge, atLeast(1)).getProperty(eq("Deleting elements: {}"));
    verify(schema).getGroups();
    verify(store).getMapImpl();
    verify(store).getProperties();
    verify(mapStoreProperties).getIngestBufferSize();
    verify(mapImpl).deleteAggElement(isA(Element.class));
    verify(mapImpl, atLeast(1)).getGroupByProperties(eq("Group"));
    verify(mapImpl, atLeast(1)).getNonGroupByProperties(eq("Group"));
    verify(mapImpl).isAggregationEnabled(isA(Element.class));
    verify(mapImpl).isMaintainIndex();
    verify(mapImpl).removeEdgeIndex(isA(EdgeSeed.class), isA(Element.class));
    verify(mapImpl, atLeast(1)).removeEntityIndex(Mockito.<EntitySeed>any(), isA(Element.class));
    verify(deleteElements).getInput();
    verify(deleteElements).isSkipInvalidElements();
    verify(deleteElements).isValidate();
    verify(store, atLeast(1)).getSchema();
    verify(schema).getAggregatedGroups();
    verify(schema, atLeast(1)).getElement(eq("Group"));
    assertEquals(1L, actualDoOperationResult.longValue());
  }

  /**
   * Test {@link DeleteElementsHandler#doOperation(DeleteElements, Context, Store)} with {@code DeleteElements}, {@code Context}, {@code Store}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeleteElementsHandler#doOperation(DeleteElements, Context, Store)}
   */
  @Test
  @DisplayName("Test doOperation(DeleteElements, Context, Store) with 'DeleteElements', 'Context', 'Store'; given HashSet() add 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Long DeleteElementsHandler.doOperation(DeleteElements, Context, Store)"})
  void testDoOperationWithDeleteElementsContextStore_givenHashSetAddNull() {
    // Arrange
    DeleteElementsHandler deleteElementsHandler = new DeleteElementsHandler();
    Edge edge = mock(Edge.class);
    when(edge.getProperty(Mockito.<String>any())).thenReturn("Property");
    when(edge.getGroup()).thenReturn("Group");
    Edge buildResult = (new Builder()).dest("Dest")
        .directed(true)
        .group("Group")
        .matchedVertex(MatchedVertex.SOURCE)
        .source("Source")
        .build();
    when(edge.emptyClone()).thenReturn(buildResult);

    ArrayList<Element> elementList = new ArrayList<>();
    elementList.add(edge);
    DeleteElements deleteElements = mock(DeleteElements.class);
    when(deleteElements.isSkipInvalidElements()).thenReturn(true);
    when(deleteElements.isValidate()).thenReturn(true);
    Mockito.<Iterable<? extends Element>>when(deleteElements.getInput()).thenReturn(elementList);
    Context context = new Context();
    MapStoreProperties mapStoreProperties = mock(MapStoreProperties.class);
    when(mapStoreProperties.getIngestBufferSize()).thenReturn(3);

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add(null);
    MapImpl mapImpl = mock(MapImpl.class);
    when(mapImpl.getGroupByProperties(Mockito.<String>any())).thenReturn(stringSet);
    when(mapImpl.getNonGroupByProperties(Mockito.<String>any())).thenReturn(new HashSet<>());
    doNothing().when(mapImpl).deleteAggElement(Mockito.<Element>any());
    doNothing().when(mapImpl).removeEdgeIndex(Mockito.<EdgeSeed>any(), Mockito.<Element>any());
    doNothing().when(mapImpl).removeEntityIndex(Mockito.<EntitySeed>any(), Mockito.<Element>any());
    when(mapImpl.isAggregationEnabled(Mockito.<Element>any())).thenReturn(true);
    when(mapImpl.isMaintainIndex()).thenReturn(true);
    Schema schema = mock(Schema.class);
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.getGroups()).thenReturn(new HashSet<>());
    when(schema.getElement(Mockito.<String>any())).thenReturn(new SchemaEdgeDefinition());
    MapStore store = mock(MapStore.class);
    when(store.getProperties()).thenReturn(mapStoreProperties);
    when(store.getMapImpl()).thenReturn(mapImpl);
    when(store.getSchema()).thenReturn(schema);

    // Act
    Long actualDoOperationResult = deleteElementsHandler.doOperation(deleteElements, context, store);

    // Assert
    verify(edge).emptyClone();
    verify(edge, atLeast(1)).getGroup();
    verify(edge).getProperty(isNull());
    verify(schema).getGroups();
    verify(store).getMapImpl();
    verify(store).getProperties();
    verify(mapStoreProperties).getIngestBufferSize();
    verify(mapImpl).deleteAggElement(isA(Element.class));
    verify(mapImpl, atLeast(1)).getGroupByProperties(eq("Group"));
    verify(mapImpl, atLeast(1)).getNonGroupByProperties(eq("Group"));
    verify(mapImpl).isAggregationEnabled(isA(Element.class));
    verify(mapImpl).isMaintainIndex();
    verify(mapImpl).removeEdgeIndex(isA(EdgeSeed.class), isA(Element.class));
    verify(mapImpl, atLeast(1)).removeEntityIndex(Mockito.<EntitySeed>any(), isA(Element.class));
    verify(deleteElements).getInput();
    verify(deleteElements).isSkipInvalidElements();
    verify(deleteElements).isValidate();
    verify(store, atLeast(1)).getSchema();
    verify(schema).getAggregatedGroups();
    verify(schema, atLeast(1)).getElement(eq("Group"));
    assertEquals(1L, actualDoOperationResult.longValue());
  }

  /**
   * Test {@link DeleteElementsHandler#doOperation(DeleteElements, Context, Store)} with {@code DeleteElements}, {@code Context}, {@code Store}.
   * <ul>
   *   <li>Given {@link MapStoreProperties#MapStoreProperties()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeleteElementsHandler#doOperation(DeleteElements, Context, Store)}
   */
  @Test
  @DisplayName("Test doOperation(DeleteElements, Context, Store) with 'DeleteElements', 'Context', 'Store'; given MapStoreProperties()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Long DeleteElementsHandler.doOperation(DeleteElements, Context, Store)"})
  void testDoOperationWithDeleteElementsContextStore_givenMapStoreProperties() {
    // Arrange
    DeleteElementsHandler deleteElementsHandler = new DeleteElementsHandler();
    DeleteElements deleteElements = mock(DeleteElements.class);
    when(deleteElements.isSkipInvalidElements()).thenReturn(true);
    when(deleteElements.isValidate()).thenReturn(true);
    Mockito.<Iterable<? extends Element>>when(deleteElements.getInput()).thenReturn(new ArrayList<>());
    Context context = new Context();
    MapStore store = mock(MapStore.class);
    when(store.getProperties()).thenReturn(new MapStoreProperties());
    Schema schema = new Schema();
    when(store.getMapImpl()).thenReturn(new MapImpl(schema, new MapStoreProperties()));
    when(store.getSchema()).thenReturn(new Schema());

    // Act
    Long actualDoOperationResult = deleteElementsHandler.doOperation(deleteElements, context, store);

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
   * Test {@link DeleteElementsHandler#doOperation(DeleteElements, Context, Store)} with {@code DeleteElements}, {@code Context}, {@code Store}.
   * <ul>
   *   <li>Given {@link MapStoreProperties#MapStoreProperties()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeleteElementsHandler#doOperation(DeleteElements, Context, Store)}
   */
  @Test
  @DisplayName("Test doOperation(DeleteElements, Context, Store) with 'DeleteElements', 'Context', 'Store'; given MapStoreProperties()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Long DeleteElementsHandler.doOperation(DeleteElements, Context, Store)"})
  void testDoOperationWithDeleteElementsContextStore_givenMapStoreProperties2() {
    // Arrange
    DeleteElementsHandler deleteElementsHandler = new DeleteElementsHandler();
    DeleteElements deleteElements = mock(DeleteElements.class);
    when(deleteElements.isValidate()).thenReturn(false);
    Mockito.<Iterable<? extends Element>>when(deleteElements.getInput()).thenReturn(new ArrayList<>());
    Context context = new Context();
    MapStore store = mock(MapStore.class);
    when(store.getProperties()).thenReturn(new MapStoreProperties());
    Schema schema = new Schema();
    when(store.getMapImpl()).thenReturn(new MapImpl(schema, new MapStoreProperties()));
    when(store.getSchema()).thenReturn(new Schema());

    // Act
    Long actualDoOperationResult = deleteElementsHandler.doOperation(deleteElements, context, store);

    // Assert
    verify(store).getMapImpl();
    verify(store).getProperties();
    verify(deleteElements).getInput();
    verify(deleteElements).isValidate();
    verify(store).getSchema();
    assertEquals(0L, actualDoOperationResult.longValue());
  }

  /**
   * Test {@link DeleteElementsHandler#doOperation(DeleteElements, Context, Store)} with {@code DeleteElements}, {@code Context}, {@code Store}.
   * <ul>
   *   <li>Given {@link MapStoreProperties#MapStoreProperties()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeleteElementsHandler#doOperation(DeleteElements, Context, Store)}
   */
  @Test
  @DisplayName("Test doOperation(DeleteElements, Context, Store) with 'DeleteElements', 'Context', 'Store'; given MapStoreProperties()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Long DeleteElementsHandler.doOperation(DeleteElements, Context, Store)"})
  void testDoOperationWithDeleteElementsContextStore_givenMapStoreProperties3() {
    // Arrange
    DeleteElementsHandler deleteElementsHandler = new DeleteElementsHandler();

    ArrayList<Element> elementList = new ArrayList<>();
    elementList.add(new Edge("Deleting elements: {}"));
    DeleteElements deleteElements = mock(DeleteElements.class);
    when(deleteElements.isSkipInvalidElements()).thenReturn(true);
    when(deleteElements.isValidate()).thenReturn(true);
    Mockito.<Iterable<? extends Element>>when(deleteElements.getInput()).thenReturn(elementList);
    Context context = new Context();
    MapStore store = mock(MapStore.class);
    when(store.getProperties()).thenReturn(new MapStoreProperties());
    Schema schema = new Schema();
    when(store.getMapImpl()).thenReturn(new MapImpl(schema, new MapStoreProperties()));
    when(store.getSchema()).thenReturn(new Schema());

    // Act
    Long actualDoOperationResult = deleteElementsHandler.doOperation(deleteElements, context, store);

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
   * Test {@link DeleteElementsHandler#doOperation(DeleteElements, Context, Store)} with {@code DeleteElements}, {@code Context}, {@code Store}.
   * <ul>
   *   <li>Then calls {@link SchemaElementDefinition#containsProperty(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeleteElementsHandler#doOperation(DeleteElements, Context, Store)}
   */
  @Test
  @DisplayName("Test doOperation(DeleteElements, Context, Store) with 'DeleteElements', 'Context', 'Store'; then calls containsProperty(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Long DeleteElementsHandler.doOperation(DeleteElements, Context, Store)"})
  void testDoOperationWithDeleteElementsContextStore_thenCallsContainsProperty() {
    // Arrange
    DeleteElementsHandler deleteElementsHandler = new DeleteElementsHandler();
    Edge edge = mock(Edge.class);
    when(edge.getProperty(Mockito.<String>any())).thenReturn("Property");
    when(edge.getGroup()).thenReturn("Group");
    Edge buildResult = (new Builder()).dest("Dest")
        .directed(true)
        .group("Group")
        .matchedVertex(MatchedVertex.SOURCE)
        .source("Source")
        .build();
    when(edge.emptyClone()).thenReturn(buildResult);

    ArrayList<Element> elementList = new ArrayList<>();
    elementList.add(edge);
    DeleteElements deleteElements = mock(DeleteElements.class);
    when(deleteElements.isSkipInvalidElements()).thenReturn(true);
    when(deleteElements.isValidate()).thenReturn(true);
    Mockito.<Iterable<? extends Element>>when(deleteElements.getInput()).thenReturn(elementList);
    Context context = new Context();
    MapStoreProperties mapStoreProperties = mock(MapStoreProperties.class);
    when(mapStoreProperties.getIngestBufferSize()).thenReturn(3);

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("Deleting elements: {}");
    MapImpl mapImpl = mock(MapImpl.class);
    when(mapImpl.getGroupByProperties(Mockito.<String>any())).thenReturn(stringSet);
    when(mapImpl.getNonGroupByProperties(Mockito.<String>any())).thenReturn(new HashSet<>());
    doNothing().when(mapImpl).deleteAggElement(Mockito.<Element>any());
    doNothing().when(mapImpl).removeEdgeIndex(Mockito.<EdgeSeed>any(), Mockito.<Element>any());
    doNothing().when(mapImpl).removeEntityIndex(Mockito.<EntitySeed>any(), Mockito.<Element>any());
    when(mapImpl.isAggregationEnabled(Mockito.<Element>any())).thenReturn(true);
    when(mapImpl.isMaintainIndex()).thenReturn(true);
    SchemaEdgeDefinition schemaEdgeDefinition = mock(SchemaEdgeDefinition.class);
    when(schemaEdgeDefinition.containsProperty(Mockito.<String>any())).thenReturn(true);
    when(schemaEdgeDefinition.getGroupBy()).thenReturn(new HashSet<>());
    ElementFilter buildResult2 = (new ElementFilter.Builder()).build();
    when(schemaEdgeDefinition.getValidator(anyBoolean())).thenReturn(buildResult2);

    HashSet<String> stringSet2 = new HashSet<>();
    stringSet2.add("Deleting elements: {}");
    Schema schema = mock(Schema.class);
    when(schema.getVisibilityProperty()).thenReturn("Visibility Property");
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.getGroups()).thenReturn(stringSet2);
    when(schema.getElement(Mockito.<String>any())).thenReturn(schemaEdgeDefinition);
    MapStore store = mock(MapStore.class);
    when(store.getProperties()).thenReturn(mapStoreProperties);
    when(store.getMapImpl()).thenReturn(mapImpl);
    when(store.getSchema()).thenReturn(schema);

    // Act
    Long actualDoOperationResult = deleteElementsHandler.doOperation(deleteElements, context, store);

    // Assert
    verify(edge).emptyClone();
    verify(edge, atLeast(1)).getGroup();
    verify(edge).getProperty(eq("Deleting elements: {}"));
    verify(schema).getGroups();
    verify(store).getMapImpl();
    verify(store).getProperties();
    verify(mapStoreProperties).getIngestBufferSize();
    verify(mapImpl).deleteAggElement(isA(Element.class));
    verify(mapImpl, atLeast(1)).getGroupByProperties(eq("Group"));
    verify(mapImpl, atLeast(1)).getNonGroupByProperties(eq("Group"));
    verify(mapImpl).isAggregationEnabled(isA(Element.class));
    verify(mapImpl).isMaintainIndex();
    verify(mapImpl).removeEdgeIndex(isA(EdgeSeed.class), isA(Element.class));
    verify(mapImpl, atLeast(1)).removeEntityIndex(Mockito.<EntitySeed>any(), isA(Element.class));
    verify(deleteElements).getInput();
    verify(deleteElements).isSkipInvalidElements();
    verify(deleteElements).isValidate();
    verify(store, atLeast(1)).getSchema();
    verify(schema).getAggregatedGroups();
    verify(schema, atLeast(1)).getElement(Mockito.<String>any());
    verify(schema, atLeast(1)).getVisibilityProperty();
    verify(schemaEdgeDefinition).containsProperty(eq("Visibility Property"));
    verify(schemaEdgeDefinition).getGroupBy();
    verify(schemaEdgeDefinition, atLeast(1)).getValidator(eq(true));
    assertEquals(1L, actualDoOperationResult.longValue());
  }

  /**
   * Test {@link DeleteElementsHandler#doOperation(DeleteElements, Context, Store)} with {@code DeleteElements}, {@code Context}, {@code Store}.
   * <ul>
   *   <li>Then calls {@link MapImpl#deleteNonAggElement(Element)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeleteElementsHandler#doOperation(DeleteElements, Context, Store)}
   */
  @Test
  @DisplayName("Test doOperation(DeleteElements, Context, Store) with 'DeleteElements', 'Context', 'Store'; then calls deleteNonAggElement(Element)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Long DeleteElementsHandler.doOperation(DeleteElements, Context, Store)"})
  void testDoOperationWithDeleteElementsContextStore_thenCallsDeleteNonAggElement() {
    // Arrange
    DeleteElementsHandler deleteElementsHandler = new DeleteElementsHandler();
    Edge edge = mock(Edge.class);
    when(edge.getGroup()).thenReturn("Group");
    Edge buildResult = (new Builder()).dest("Dest")
        .directed(true)
        .group("Group")
        .matchedVertex(MatchedVertex.SOURCE)
        .source("Source")
        .build();
    when(edge.emptyClone()).thenReturn(buildResult);

    ArrayList<Element> elementList = new ArrayList<>();
    elementList.add(edge);
    DeleteElements deleteElements = mock(DeleteElements.class);
    when(deleteElements.isSkipInvalidElements()).thenReturn(true);
    when(deleteElements.isValidate()).thenReturn(true);
    Mockito.<Iterable<? extends Element>>when(deleteElements.getInput()).thenReturn(elementList);
    Context context = new Context();
    MapStoreProperties mapStoreProperties = mock(MapStoreProperties.class);
    when(mapStoreProperties.getIngestBufferSize()).thenReturn(3);
    MapImpl mapImpl = mock(MapImpl.class);
    doNothing().when(mapImpl).removeEdgeIndex(Mockito.<EdgeSeed>any(), Mockito.<Element>any());
    doNothing().when(mapImpl).removeEntityIndex(Mockito.<EntitySeed>any(), Mockito.<Element>any());
    when(mapImpl.isAggregationEnabled(Mockito.<Element>any())).thenReturn(false);
    when(mapImpl.isMaintainIndex()).thenReturn(true);
    doNothing().when(mapImpl).deleteNonAggElement(Mockito.<Element>any());
    Schema schema = mock(Schema.class);
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.getGroups()).thenReturn(new HashSet<>());
    when(schema.getElement(Mockito.<String>any())).thenReturn(new SchemaEdgeDefinition());
    MapStore store = mock(MapStore.class);
    when(store.getProperties()).thenReturn(mapStoreProperties);
    when(store.getMapImpl()).thenReturn(mapImpl);
    when(store.getSchema()).thenReturn(schema);

    // Act
    Long actualDoOperationResult = deleteElementsHandler.doOperation(deleteElements, context, store);

    // Assert
    verify(edge).emptyClone();
    verify(edge, atLeast(1)).getGroup();
    verify(schema).getGroups();
    verify(store).getMapImpl();
    verify(store).getProperties();
    verify(mapStoreProperties).getIngestBufferSize();
    verify(mapImpl).deleteNonAggElement(isA(Element.class));
    verify(mapImpl).isAggregationEnabled(isA(Element.class));
    verify(mapImpl).isMaintainIndex();
    verify(mapImpl).removeEdgeIndex(isA(EdgeSeed.class), isA(Element.class));
    verify(mapImpl, atLeast(1)).removeEntityIndex(Mockito.<EntitySeed>any(), isA(Element.class));
    verify(deleteElements).getInput();
    verify(deleteElements).isSkipInvalidElements();
    verify(deleteElements).isValidate();
    verify(store, atLeast(1)).getSchema();
    verify(schema).getAggregatedGroups();
    verify(schema, atLeast(1)).getElement(eq("Group"));
    assertEquals(1L, actualDoOperationResult.longValue());
  }

  /**
   * Test {@link DeleteElementsHandler#doOperation(DeleteElements, Context, Store)} with {@code DeleteElements}, {@code Context}, {@code Store}.
   * <ul>
   *   <li>Then return longValue is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeleteElementsHandler#doOperation(DeleteElements, Context, Store)}
   */
  @Test
  @DisplayName("Test doOperation(DeleteElements, Context, Store) with 'DeleteElements', 'Context', 'Store'; then return longValue is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Long DeleteElementsHandler.doOperation(DeleteElements, Context, Store)"})
  void testDoOperationWithDeleteElementsContextStore_thenReturnLongValueIsOne() {
    // Arrange
    DeleteElementsHandler deleteElementsHandler = new DeleteElementsHandler();
    Edge edge = mock(Edge.class);
    when(edge.getGroup()).thenReturn("Group");
    Edge buildResult = (new Builder()).dest("Dest")
        .directed(true)
        .group("Group")
        .matchedVertex(MatchedVertex.SOURCE)
        .source("Source")
        .build();
    when(edge.emptyClone()).thenReturn(buildResult);

    ArrayList<Element> elementList = new ArrayList<>();
    elementList.add(edge);
    DeleteElements deleteElements = mock(DeleteElements.class);
    when(deleteElements.isSkipInvalidElements()).thenReturn(true);
    when(deleteElements.isValidate()).thenReturn(true);
    Mockito.<Iterable<? extends Element>>when(deleteElements.getInput()).thenReturn(elementList);
    Context context = new Context();
    MapStoreProperties mapStoreProperties = mock(MapStoreProperties.class);
    when(mapStoreProperties.getIngestBufferSize()).thenReturn(3);
    MapImpl mapImpl = mock(MapImpl.class);
    when(mapImpl.getGroupByProperties(Mockito.<String>any())).thenReturn(new HashSet<>());
    when(mapImpl.getNonGroupByProperties(Mockito.<String>any())).thenReturn(new HashSet<>());
    doNothing().when(mapImpl).deleteAggElement(Mockito.<Element>any());
    doNothing().when(mapImpl).removeEdgeIndex(Mockito.<EdgeSeed>any(), Mockito.<Element>any());
    doNothing().when(mapImpl).removeEntityIndex(Mockito.<EntitySeed>any(), Mockito.<Element>any());
    when(mapImpl.isAggregationEnabled(Mockito.<Element>any())).thenReturn(true);
    when(mapImpl.isMaintainIndex()).thenReturn(true);
    Schema schema = mock(Schema.class);
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.getGroups()).thenReturn(new HashSet<>());
    when(schema.getElement(Mockito.<String>any())).thenReturn(new SchemaEdgeDefinition());
    MapStore store = mock(MapStore.class);
    when(store.getProperties()).thenReturn(mapStoreProperties);
    when(store.getMapImpl()).thenReturn(mapImpl);
    when(store.getSchema()).thenReturn(schema);

    // Act
    Long actualDoOperationResult = deleteElementsHandler.doOperation(deleteElements, context, store);

    // Assert
    verify(edge).emptyClone();
    verify(edge, atLeast(1)).getGroup();
    verify(schema).getGroups();
    verify(store).getMapImpl();
    verify(store).getProperties();
    verify(mapStoreProperties).getIngestBufferSize();
    verify(mapImpl).deleteAggElement(isA(Element.class));
    verify(mapImpl, atLeast(1)).getGroupByProperties(eq("Group"));
    verify(mapImpl, atLeast(1)).getNonGroupByProperties(eq("Group"));
    verify(mapImpl).isAggregationEnabled(isA(Element.class));
    verify(mapImpl).isMaintainIndex();
    verify(mapImpl).removeEdgeIndex(isA(EdgeSeed.class), isA(Element.class));
    verify(mapImpl, atLeast(1)).removeEntityIndex(Mockito.<EntitySeed>any(), isA(Element.class));
    verify(deleteElements).getInput();
    verify(deleteElements).isSkipInvalidElements();
    verify(deleteElements).isValidate();
    verify(store, atLeast(1)).getSchema();
    verify(schema).getAggregatedGroups();
    verify(schema, atLeast(1)).getElement(eq("Group"));
    assertEquals(1L, actualDoOperationResult.longValue());
  }

  /**
   * Test {@link DeleteElementsHandler#doOperation(DeleteElements, Context, Store)} with {@code DeleteElements}, {@code Context}, {@code Store}.
   * <ul>
   *   <li>Then return longValue is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeleteElementsHandler#doOperation(DeleteElements, Context, Store)}
   */
  @Test
  @DisplayName("Test doOperation(DeleteElements, Context, Store) with 'DeleteElements', 'Context', 'Store'; then return longValue is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Long DeleteElementsHandler.doOperation(DeleteElements, Context, Store)"})
  void testDoOperationWithDeleteElementsContextStore_thenReturnLongValueIsTwo() {
    // Arrange
    DeleteElementsHandler deleteElementsHandler = new DeleteElementsHandler();
    Edge edge = mock(Edge.class);
    when(edge.getGroup()).thenReturn("Group");
    Edge buildResult = (new Builder()).dest("Dest")
        .directed(true)
        .group("Group")
        .matchedVertex(MatchedVertex.SOURCE)
        .source("Source")
        .build();
    when(edge.emptyClone()).thenReturn(buildResult);

    ArrayList<Element> elementList = new ArrayList<>();
    elementList.add(new Edge("Deleting elements: {}"));
    elementList.add(edge);
    DeleteElements deleteElements = mock(DeleteElements.class);
    when(deleteElements.isSkipInvalidElements()).thenReturn(true);
    when(deleteElements.isValidate()).thenReturn(true);
    Mockito.<Iterable<? extends Element>>when(deleteElements.getInput()).thenReturn(elementList);
    Context context = new Context();
    MapStoreProperties mapStoreProperties = mock(MapStoreProperties.class);
    when(mapStoreProperties.getIngestBufferSize()).thenReturn(3);
    MapImpl mapImpl = mock(MapImpl.class);
    when(mapImpl.getGroupByProperties(Mockito.<String>any())).thenReturn(new HashSet<>());
    when(mapImpl.getNonGroupByProperties(Mockito.<String>any())).thenReturn(new HashSet<>());
    doNothing().when(mapImpl).deleteAggElement(Mockito.<Element>any());
    doNothing().when(mapImpl).removeEdgeIndex(Mockito.<EdgeSeed>any(), Mockito.<Element>any());
    doNothing().when(mapImpl).removeEntityIndex(Mockito.<EntitySeed>any(), Mockito.<Element>any());
    when(mapImpl.isAggregationEnabled(Mockito.<Element>any())).thenReturn(true);
    when(mapImpl.isMaintainIndex()).thenReturn(true);
    Schema schema = mock(Schema.class);
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.getGroups()).thenReturn(new HashSet<>());
    when(schema.getElement(Mockito.<String>any())).thenReturn(new SchemaEdgeDefinition());
    MapStore store = mock(MapStore.class);
    when(store.getProperties()).thenReturn(mapStoreProperties);
    when(store.getMapImpl()).thenReturn(mapImpl);
    when(store.getSchema()).thenReturn(schema);

    // Act
    Long actualDoOperationResult = deleteElementsHandler.doOperation(deleteElements, context, store);

    // Assert
    verify(edge).emptyClone();
    verify(edge, atLeast(1)).getGroup();
    verify(schema).getGroups();
    verify(store).getMapImpl();
    verify(store).getProperties();
    verify(mapStoreProperties).getIngestBufferSize();
    verify(mapImpl, atLeast(1)).deleteAggElement(Mockito.<Element>any());
    verify(mapImpl, atLeast(1)).getGroupByProperties(Mockito.<String>any());
    verify(mapImpl, atLeast(1)).getNonGroupByProperties(Mockito.<String>any());
    verify(mapImpl, atLeast(1)).isAggregationEnabled(Mockito.<Element>any());
    verify(mapImpl, atLeast(1)).isMaintainIndex();
    verify(mapImpl, atLeast(1)).removeEdgeIndex(Mockito.<EdgeSeed>any(), Mockito.<Element>any());
    verify(mapImpl, atLeast(1)).removeEntityIndex(Mockito.<EntitySeed>any(), Mockito.<Element>any());
    verify(deleteElements).getInput();
    verify(deleteElements).isSkipInvalidElements();
    verify(deleteElements).isValidate();
    verify(store, atLeast(1)).getSchema();
    verify(schema).getAggregatedGroups();
    verify(schema, atLeast(1)).getElement(Mockito.<String>any());
    assertEquals(2L, actualDoOperationResult.longValue());
  }

  /**
   * Test {@link DeleteElementsHandler#doOperation(DeleteElements, Context, Store)} with {@code DeleteElements}, {@code Context}, {@code Store}.
   * <ul>
   *   <li>Then return longValue is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeleteElementsHandler#doOperation(DeleteElements, Context, Store)}
   */
  @Test
  @DisplayName("Test doOperation(DeleteElements, Context, Store) with 'DeleteElements', 'Context', 'Store'; then return longValue is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Long DeleteElementsHandler.doOperation(DeleteElements, Context, Store)"})
  void testDoOperationWithDeleteElementsContextStore_thenReturnLongValueIsTwo2() {
    // Arrange
    DeleteElementsHandler deleteElementsHandler = new DeleteElementsHandler();
    Edge edge = mock(Edge.class);
    when(edge.getProperty(Mockito.<String>any())).thenReturn("Property");
    when(edge.getGroup()).thenReturn("Group");
    Edge buildResult = (new Builder()).dest("Dest")
        .directed(true)
        .group("Group")
        .matchedVertex(MatchedVertex.SOURCE)
        .source("Source")
        .build();
    when(edge.emptyClone()).thenReturn(buildResult);

    ArrayList<Element> elementList = new ArrayList<>();
    elementList.add(new Edge("Deleting elements: {}"));
    elementList.add(edge);
    DeleteElements deleteElements = mock(DeleteElements.class);
    when(deleteElements.isSkipInvalidElements()).thenReturn(true);
    when(deleteElements.isValidate()).thenReturn(true);
    Mockito.<Iterable<? extends Element>>when(deleteElements.getInput()).thenReturn(elementList);
    Context context = new Context();
    MapStoreProperties mapStoreProperties = mock(MapStoreProperties.class);
    when(mapStoreProperties.getIngestBufferSize()).thenReturn(3);

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("Deleting elements: {}");
    MapImpl mapImpl = mock(MapImpl.class);
    when(mapImpl.getGroupByProperties(Mockito.<String>any())).thenReturn(stringSet);
    when(mapImpl.getNonGroupByProperties(Mockito.<String>any())).thenReturn(new HashSet<>());
    doNothing().when(mapImpl).deleteAggElement(Mockito.<Element>any());
    doNothing().when(mapImpl).removeEdgeIndex(Mockito.<EdgeSeed>any(), Mockito.<Element>any());
    doNothing().when(mapImpl).removeEntityIndex(Mockito.<EntitySeed>any(), Mockito.<Element>any());
    when(mapImpl.isAggregationEnabled(Mockito.<Element>any())).thenReturn(true);
    when(mapImpl.isMaintainIndex()).thenReturn(true);
    Schema schema = mock(Schema.class);
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.getGroups()).thenReturn(new HashSet<>());
    when(schema.getElement(Mockito.<String>any())).thenReturn(new SchemaEdgeDefinition());
    MapStore store = mock(MapStore.class);
    when(store.getProperties()).thenReturn(mapStoreProperties);
    when(store.getMapImpl()).thenReturn(mapImpl);
    when(store.getSchema()).thenReturn(schema);

    // Act
    Long actualDoOperationResult = deleteElementsHandler.doOperation(deleteElements, context, store);

    // Assert
    verify(edge).emptyClone();
    verify(edge, atLeast(1)).getGroup();
    verify(edge).getProperty(eq("Deleting elements: {}"));
    verify(schema).getGroups();
    verify(store).getMapImpl();
    verify(store).getProperties();
    verify(mapStoreProperties).getIngestBufferSize();
    verify(mapImpl, atLeast(1)).deleteAggElement(Mockito.<Element>any());
    verify(mapImpl, atLeast(1)).getGroupByProperties(Mockito.<String>any());
    verify(mapImpl, atLeast(1)).getNonGroupByProperties(Mockito.<String>any());
    verify(mapImpl, atLeast(1)).isAggregationEnabled(Mockito.<Element>any());
    verify(mapImpl, atLeast(1)).isMaintainIndex();
    verify(mapImpl, atLeast(1)).removeEdgeIndex(Mockito.<EdgeSeed>any(), Mockito.<Element>any());
    verify(mapImpl, atLeast(1)).removeEntityIndex(Mockito.<EntitySeed>any(), Mockito.<Element>any());
    verify(deleteElements).getInput();
    verify(deleteElements).isSkipInvalidElements();
    verify(deleteElements).isValidate();
    verify(store, atLeast(1)).getSchema();
    verify(schema).getAggregatedGroups();
    verify(schema, atLeast(1)).getElement(Mockito.<String>any());
    assertEquals(2L, actualDoOperationResult.longValue());
  }

  /**
   * Test {@link DeleteElementsHandler#doOperation(DeleteElements, Context, Store)} with {@code DeleteElements}, {@code Context}, {@code Store}.
   * <ul>
   *   <li>Then return longValue is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeleteElementsHandler#doOperation(DeleteElements, Context, Store)}
   */
  @Test
  @DisplayName("Test doOperation(DeleteElements, Context, Store) with 'DeleteElements', 'Context', 'Store'; then return longValue is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Long DeleteElementsHandler.doOperation(DeleteElements, Context, Store)"})
  void testDoOperationWithDeleteElementsContextStore_thenReturnLongValueIsZero() {
    // Arrange
    DeleteElementsHandler deleteElementsHandler = new DeleteElementsHandler();
    DeleteElements deleteElements = mock(DeleteElements.class);
    when(deleteElements.isSkipInvalidElements()).thenReturn(true);
    when(deleteElements.isValidate()).thenReturn(true);
    Mockito.<Iterable<? extends Element>>when(deleteElements.getInput()).thenReturn(new ArrayList<>());
    Context context = new Context();
    MapStoreProperties mapStoreProperties = mock(MapStoreProperties.class);
    when(mapStoreProperties.getIngestBufferSize()).thenReturn(3);
    MapStore store = mock(MapStore.class);
    when(store.getProperties()).thenReturn(mapStoreProperties);
    Schema schema = new Schema();
    when(store.getMapImpl()).thenReturn(new MapImpl(schema, new MapStoreProperties()));
    when(store.getSchema()).thenReturn(new Schema());

    // Act
    Long actualDoOperationResult = deleteElementsHandler.doOperation(deleteElements, context, store);

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
   * Test {@link DeleteElementsHandler#doOperation(DeleteElements, Context, Store)} with {@code DeleteElements}, {@code Context}, {@code Store}.
   * <ul>
   *   <li>Then return longValue is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeleteElementsHandler#doOperation(DeleteElements, Context, Store)}
   */
  @Test
  @DisplayName("Test doOperation(DeleteElements, Context, Store) with 'DeleteElements', 'Context', 'Store'; then return longValue is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Long DeleteElementsHandler.doOperation(DeleteElements, Context, Store)"})
  void testDoOperationWithDeleteElementsContextStore_thenReturnLongValueIsZero2() {
    // Arrange
    DeleteElementsHandler deleteElementsHandler = new DeleteElementsHandler();

    ArrayList<Element> elementList = new ArrayList<>();
    elementList.add(new Edge("Deleting elements: {}"));
    DeleteElements deleteElements = mock(DeleteElements.class);
    when(deleteElements.isSkipInvalidElements()).thenReturn(true);
    when(deleteElements.isValidate()).thenReturn(true);
    Mockito.<Iterable<? extends Element>>when(deleteElements.getInput()).thenReturn(elementList);
    Context context = new Context();
    MapStoreProperties mapStoreProperties = mock(MapStoreProperties.class);
    when(mapStoreProperties.getIngestBufferSize()).thenReturn(3);
    MapStore store = mock(MapStore.class);
    when(store.getProperties()).thenReturn(mapStoreProperties);
    Schema schema = new Schema();
    when(store.getMapImpl()).thenReturn(new MapImpl(schema, new MapStoreProperties()));
    when(store.getSchema()).thenReturn(new Schema());

    // Act
    Long actualDoOperationResult = deleteElementsHandler.doOperation(deleteElements, context, store);

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
