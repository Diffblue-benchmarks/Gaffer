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

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
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
import uk.gov.gchq.gaffer.data.element.Entity;
import uk.gov.gchq.gaffer.data.element.GroupedProperties;
import uk.gov.gchq.gaffer.data.element.id.EdgeId;
import uk.gov.gchq.gaffer.data.element.id.EdgeId.MatchedVertex;
import uk.gov.gchq.gaffer.data.elementdefinition.ElementDefinitions;
import uk.gov.gchq.gaffer.mapstore.MapStore;
import uk.gov.gchq.gaffer.mapstore.MapStoreProperties;
import uk.gov.gchq.gaffer.operation.OperationException;
import uk.gov.gchq.gaffer.operation.data.EdgeSeed;
import uk.gov.gchq.gaffer.operation.data.EntitySeed;
import uk.gov.gchq.gaffer.operation.impl.add.AddElements;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.Store;
import uk.gov.gchq.gaffer.store.schema.Schema;
import uk.gov.gchq.gaffer.store.schema.SchemaEdgeDefinition;

class AddElementsHandlerDiffblueTest {
  /**
   * Test {@link AddElementsHandler#doOperation(AddElements, Context, Store)} with {@code AddElements}, {@code Context}, {@code Store}.
   * <p>
   * Method under test: {@link AddElementsHandler#doOperation(AddElements, Context, Store)}
   */
  @Test
  @DisplayName("Test doOperation(AddElements, Context, Store) with 'AddElements', 'Context', 'Store'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Void AddElementsHandler.doOperation(AddElements, Context, Store)"})
  void testDoOperationWithAddElementsContextStore() throws OperationException {
    // Arrange
    AddElementsHandler addElementsHandler = new AddElementsHandler();

    ArrayList<Element> elementList = new ArrayList<>();
    elementList.add(new Edge("gaffer.store.mapstore.map.ingest.buffer.size"));
    AddElements addElements = mock(AddElements.class);
    when(addElements.isSkipInvalidElements()).thenReturn(true);
    when(addElements.isValidate()).thenReturn(true);
    Mockito.<Iterable<? extends Element>>when(addElements.getInput()).thenReturn(elementList);
    Context context = new Context();
    MapStore store = mock(MapStore.class);
    when(store.getProperties()).thenReturn(new MapStoreProperties());
    Schema schema = new Schema();
    when(store.getMapImpl()).thenReturn(new MapImpl(schema, new MapStoreProperties()));
    when(store.getSchema()).thenReturn(new Schema());

    // Act
    Void actualDoOperationResult = addElementsHandler.doOperation(addElements, context, store);

    // Assert
    verify(store).getMapImpl();
    verify(store).getProperties();
    verify(addElements).getInput();
    verify(addElements).isSkipInvalidElements();
    verify(addElements).isValidate();
    verify(store, atLeast(1)).getSchema();
    assertNull(actualDoOperationResult);
  }

  /**
   * Test {@link AddElementsHandler#doOperation(AddElements, Context, Store)} with {@code AddElements}, {@code Context}, {@code Store}.
   * <p>
   * Method under test: {@link AddElementsHandler#doOperation(AddElements, Context, Store)}
   */
  @Test
  @DisplayName("Test doOperation(AddElements, Context, Store) with 'AddElements', 'Context', 'Store'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Void AddElementsHandler.doOperation(AddElements, Context, Store)"})
  void testDoOperationWithAddElementsContextStore2() throws OperationException {
    // Arrange
    AddElementsHandler addElementsHandler = new AddElementsHandler();

    ArrayList<Element> elementList = new ArrayList<>();
    Edge buildResult = (new Builder()).dest("Dest")
        .directed(true)
        .group("Group")
        .matchedVertex(MatchedVertex.SOURCE)
        .source("Source")
        .build();
    elementList.add(buildResult);
    AddElements addElements = mock(AddElements.class);
    when(addElements.isSkipInvalidElements()).thenReturn(true);
    when(addElements.isValidate()).thenReturn(true);
    Mockito.<Iterable<? extends Element>>when(addElements.getInput()).thenReturn(elementList);
    Context context = new Context();
    MapStoreProperties mapStoreProperties = mock(MapStoreProperties.class);
    when(mapStoreProperties.getIngestBufferSize()).thenReturn(3);
    Schema schema = mock(Schema.class);
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.getGroups()).thenReturn(new HashSet<>());
    when(schema.getElement(Mockito.<String>any())).thenReturn(new SchemaEdgeDefinition());
    MapStore store = mock(MapStore.class);
    when(store.getProperties()).thenReturn(mapStoreProperties);
    Schema schema2 = new Schema();
    when(store.getMapImpl()).thenReturn(new MapImpl(schema2, new MapStoreProperties()));
    when(store.getSchema()).thenReturn(schema);

    // Act
    Void actualDoOperationResult = addElementsHandler.doOperation(addElements, context, store);

    // Assert
    verify(schema).getGroups();
    verify(store).getMapImpl();
    verify(store).getProperties();
    verify(mapStoreProperties).getIngestBufferSize();
    verify(addElements).getInput();
    verify(addElements).isSkipInvalidElements();
    verify(addElements).isValidate();
    verify(store, atLeast(1)).getSchema();
    verify(schema).getAggregatedGroups();
    verify(schema, atLeast(1)).getElement(eq("Group"));
    assertNull(actualDoOperationResult);
  }

  /**
   * Test {@link AddElementsHandler#doOperation(AddElements, Context, Store)} with {@code AddElements}, {@code Context}, {@code Store}.
   * <p>
   * Method under test: {@link AddElementsHandler#doOperation(AddElements, Context, Store)}
   */
  @Test
  @DisplayName("Test doOperation(AddElements, Context, Store) with 'AddElements', 'Context', 'Store'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Void AddElementsHandler.doOperation(AddElements, Context, Store)"})
  void testDoOperationWithAddElementsContextStore3() throws OperationException {
    // Arrange
    AddElementsHandler addElementsHandler = new AddElementsHandler();

    ArrayList<Element> elementList = new ArrayList<>();
    Entity buildResult = (new Entity.Builder()).group("Group").vertex("Vertex").build();
    elementList.add(buildResult);
    AddElements addElements = mock(AddElements.class);
    when(addElements.isSkipInvalidElements()).thenReturn(true);
    when(addElements.isValidate()).thenReturn(true);
    Mockito.<Iterable<? extends Element>>when(addElements.getInput()).thenReturn(elementList);
    Context context = new Context();
    MapStoreProperties mapStoreProperties = mock(MapStoreProperties.class);
    when(mapStoreProperties.getIngestBufferSize()).thenReturn(3);
    Schema schema = mock(Schema.class);
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.getGroups()).thenReturn(new HashSet<>());
    when(schema.getElement(Mockito.<String>any())).thenReturn(new SchemaEdgeDefinition());
    MapStore store = mock(MapStore.class);
    when(store.getProperties()).thenReturn(mapStoreProperties);
    Schema schema2 = new Schema();
    when(store.getMapImpl()).thenReturn(new MapImpl(schema2, new MapStoreProperties()));
    when(store.getSchema()).thenReturn(schema);

    // Act
    Void actualDoOperationResult = addElementsHandler.doOperation(addElements, context, store);

    // Assert
    verify(schema).getGroups();
    verify(store).getMapImpl();
    verify(store).getProperties();
    verify(mapStoreProperties).getIngestBufferSize();
    verify(addElements).getInput();
    verify(addElements).isSkipInvalidElements();
    verify(addElements).isValidate();
    verify(store, atLeast(1)).getSchema();
    verify(schema).getAggregatedGroups();
    verify(schema, atLeast(1)).getElement(eq("Group"));
    assertNull(actualDoOperationResult);
  }

  /**
   * Test {@link AddElementsHandler#doOperation(AddElements, Context, Store)} with {@code AddElements}, {@code Context}, {@code Store}.
   * <p>
   * Method under test: {@link AddElementsHandler#doOperation(AddElements, Context, Store)}
   */
  @Test
  @DisplayName("Test doOperation(AddElements, Context, Store) with 'AddElements', 'Context', 'Store'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Void AddElementsHandler.doOperation(AddElements, Context, Store)"})
  void testDoOperationWithAddElementsContextStore4() throws OperationException {
    // Arrange
    AddElementsHandler addElementsHandler = new AddElementsHandler();

    Edge edge = new Edge("Adding elements in batches, batch size = {}");
    edge.putProperty("Name", "Value");

    ArrayList<Element> elementList = new ArrayList<>();
    elementList.add(edge);
    AddElements addElements = mock(AddElements.class);
    when(addElements.isSkipInvalidElements()).thenReturn(true);
    when(addElements.isValidate()).thenReturn(true);
    Mockito.<Iterable<? extends Element>>when(addElements.getInput()).thenReturn(elementList);
    Context context = new Context();
    MapStoreProperties mapStoreProperties = mock(MapStoreProperties.class);
    when(mapStoreProperties.getIngestBufferSize()).thenReturn(3);
    Schema schema = mock(Schema.class);
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.getGroups()).thenReturn(new HashSet<>());
    when(schema.getElement(Mockito.<String>any())).thenReturn(new SchemaEdgeDefinition());
    MapStore store = mock(MapStore.class);
    when(store.getProperties()).thenReturn(mapStoreProperties);
    Schema schema2 = new Schema();
    when(store.getMapImpl()).thenReturn(new MapImpl(schema2, new MapStoreProperties()));
    when(store.getSchema()).thenReturn(schema);

    // Act
    Void actualDoOperationResult = addElementsHandler.doOperation(addElements, context, store);

    // Assert
    verify(schema).getGroups();
    verify(store).getMapImpl();
    verify(store).getProperties();
    verify(mapStoreProperties).getIngestBufferSize();
    verify(addElements).getInput();
    verify(addElements).isSkipInvalidElements();
    verify(addElements).isValidate();
    verify(store, atLeast(1)).getSchema();
    verify(schema).getAggregatedGroups();
    verify(schema, atLeast(1)).getElement(eq("Adding elements in batches, batch size = {}"));
    assertNull(actualDoOperationResult);
  }

  /**
   * Test {@link AddElementsHandler#doOperation(AddElements, Context, Store)} with {@code AddElements}, {@code Context}, {@code Store}.
   * <p>
   * Method under test: {@link AddElementsHandler#doOperation(AddElements, Context, Store)}
   */
  @Test
  @DisplayName("Test doOperation(AddElements, Context, Store) with 'AddElements', 'Context', 'Store'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Void AddElementsHandler.doOperation(AddElements, Context, Store)"})
  void testDoOperationWithAddElementsContextStore5() throws OperationException {
    // Arrange
    AddElementsHandler addElementsHandler = new AddElementsHandler();

    ArrayList<Element> elementList = new ArrayList<>();
    elementList.add(new Edge("Adding elements in batches, batch size = {}"));
    AddElements addElements = mock(AddElements.class);
    when(addElements.isSkipInvalidElements()).thenReturn(true);
    when(addElements.isValidate()).thenReturn(true);
    Mockito.<Iterable<? extends Element>>when(addElements.getInput()).thenReturn(elementList);
    Context context = new Context();
    MapStoreProperties mapStoreProperties = mock(MapStoreProperties.class);
    when(mapStoreProperties.getIngestBufferSize()).thenReturn(3);
    MapImpl mapImpl = mock(MapImpl.class);
    when(mapImpl.getGroupByProperties(Mockito.<String>any())).thenReturn(new HashSet<>());
    when(mapImpl.getNonGroupByProperties(Mockito.<String>any())).thenReturn(new HashSet<>());
    doNothing().when(mapImpl).addAggElement(Mockito.<Element>any(), Mockito.<GroupedProperties>any());
    doNothing().when(mapImpl).addIndex(Mockito.<EdgeSeed>any(), Mockito.<Element>any());
    doNothing().when(mapImpl).addIndex(Mockito.<EntitySeed>any(), Mockito.<Element>any());
    when(mapImpl.isAggregationEnabled(Mockito.<Element>any())).thenReturn(true);
    when(mapImpl.isMaintainIndex()).thenReturn(true);
    when(mapImpl.cloneElement(Mockito.<Element>any(), Mockito.<Schema>any())).thenReturn(new Edge("Group"));
    Schema schema = mock(Schema.class);
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.getGroups()).thenReturn(new HashSet<>());
    when(schema.getElement(Mockito.<String>any())).thenReturn(new SchemaEdgeDefinition());
    MapStore store = mock(MapStore.class);
    when(store.getProperties()).thenReturn(mapStoreProperties);
    when(store.getMapImpl()).thenReturn(mapImpl);
    when(store.getSchema()).thenReturn(schema);

    // Act
    Void actualDoOperationResult = addElementsHandler.doOperation(addElements, context, store);

    // Assert
    verify(schema).getGroups();
    verify(store).getMapImpl();
    verify(store).getProperties();
    verify(mapStoreProperties).getIngestBufferSize();
    verify(mapImpl).addAggElement(isA(Element.class), isA(GroupedProperties.class));
    verify(mapImpl).addIndex(isA(EdgeSeed.class), isA(Element.class));
    verify(mapImpl, atLeast(1)).addIndex(isA(EntitySeed.class), isA(Element.class));
    verify(mapImpl).cloneElement(isA(Element.class), isA(Schema.class));
    verify(mapImpl, atLeast(1)).getGroupByProperties(eq("Group"));
    verify(mapImpl, atLeast(1)).getNonGroupByProperties(eq("Group"));
    verify(mapImpl).isAggregationEnabled(isA(Element.class));
    verify(mapImpl).isMaintainIndex();
    verify(addElements).getInput();
    verify(addElements).isSkipInvalidElements();
    verify(addElements).isValidate();
    verify(store, atLeast(1)).getSchema();
    verify(schema).getAggregatedGroups();
    verify(schema).getElement(eq("Adding elements in batches, batch size = {}"));
    assertNull(actualDoOperationResult);
  }

  /**
   * Test {@link AddElementsHandler#doOperation(AddElements, Context, Store)} with {@code AddElements}, {@code Context}, {@code Store}.
   * <p>
   * Method under test: {@link AddElementsHandler#doOperation(AddElements, Context, Store)}
   */
  @Test
  @DisplayName("Test doOperation(AddElements, Context, Store) with 'AddElements', 'Context', 'Store'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Void AddElementsHandler.doOperation(AddElements, Context, Store)"})
  void testDoOperationWithAddElementsContextStore6() throws OperationException {
    // Arrange
    AddElementsHandler addElementsHandler = new AddElementsHandler();

    ArrayList<Element> elementList = new ArrayList<>();
    elementList.add(new Edge("Adding elements in batches, batch size = {}"));
    AddElements addElements = mock(AddElements.class);
    when(addElements.isSkipInvalidElements()).thenReturn(true);
    when(addElements.isValidate()).thenReturn(true);
    Mockito.<Iterable<? extends Element>>when(addElements.getInput()).thenReturn(elementList);
    Context context = new Context();
    MapStoreProperties mapStoreProperties = mock(MapStoreProperties.class);
    when(mapStoreProperties.getIngestBufferSize()).thenReturn(3);

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("Adding elements in batches, batch size = {}");
    MapImpl mapImpl = mock(MapImpl.class);
    when(mapImpl.getGroupByProperties(Mockito.<String>any())).thenReturn(stringSet);
    when(mapImpl.getNonGroupByProperties(Mockito.<String>any())).thenReturn(new HashSet<>());
    doNothing().when(mapImpl).addAggElement(Mockito.<Element>any(), Mockito.<GroupedProperties>any());
    doNothing().when(mapImpl).addIndex(Mockito.<EdgeSeed>any(), Mockito.<Element>any());
    doNothing().when(mapImpl).addIndex(Mockito.<EntitySeed>any(), Mockito.<Element>any());
    when(mapImpl.isAggregationEnabled(Mockito.<Element>any())).thenReturn(true);
    when(mapImpl.isMaintainIndex()).thenReturn(true);
    when(mapImpl.cloneElement(Mockito.<Element>any(), Mockito.<Schema>any())).thenReturn(new Edge("Group"));
    Schema schema = mock(Schema.class);
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.getGroups()).thenReturn(new HashSet<>());
    when(schema.getElement(Mockito.<String>any())).thenReturn(new SchemaEdgeDefinition());
    MapStore store = mock(MapStore.class);
    when(store.getProperties()).thenReturn(mapStoreProperties);
    when(store.getMapImpl()).thenReturn(mapImpl);
    when(store.getSchema()).thenReturn(schema);

    // Act
    Void actualDoOperationResult = addElementsHandler.doOperation(addElements, context, store);

    // Assert
    verify(schema).getGroups();
    verify(store).getMapImpl();
    verify(store).getProperties();
    verify(mapStoreProperties).getIngestBufferSize();
    verify(mapImpl).addAggElement(isA(Element.class), isA(GroupedProperties.class));
    verify(mapImpl).addIndex(isA(EdgeSeed.class), isA(Element.class));
    verify(mapImpl, atLeast(1)).addIndex(isA(EntitySeed.class), isA(Element.class));
    verify(mapImpl).cloneElement(isA(Element.class), isA(Schema.class));
    verify(mapImpl, atLeast(1)).getGroupByProperties(eq("Group"));
    verify(mapImpl, atLeast(1)).getNonGroupByProperties(eq("Group"));
    verify(mapImpl).isAggregationEnabled(isA(Element.class));
    verify(mapImpl).isMaintainIndex();
    verify(addElements).getInput();
    verify(addElements).isSkipInvalidElements();
    verify(addElements).isValidate();
    verify(store, atLeast(1)).getSchema();
    verify(schema).getAggregatedGroups();
    verify(schema).getElement(eq("Adding elements in batches, batch size = {}"));
    assertNull(actualDoOperationResult);
  }

  /**
   * Test {@link AddElementsHandler#doOperation(AddElements, Context, Store)} with {@code AddElements}, {@code Context}, {@code Store}.
   * <p>
   * Method under test: {@link AddElementsHandler#doOperation(AddElements, Context, Store)}
   */
  @Test
  @DisplayName("Test doOperation(AddElements, Context, Store) with 'AddElements', 'Context', 'Store'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Void AddElementsHandler.doOperation(AddElements, Context, Store)"})
  void testDoOperationWithAddElementsContextStore7() throws OperationException {
    // Arrange
    AddElementsHandler addElementsHandler = new AddElementsHandler();

    ArrayList<Element> elementList = new ArrayList<>();
    elementList.add(new Edge("Adding elements in batches, batch size = {}"));
    AddElements addElements = mock(AddElements.class);
    when(addElements.isSkipInvalidElements()).thenReturn(true);
    when(addElements.isValidate()).thenReturn(true);
    Mockito.<Iterable<? extends Element>>when(addElements.getInput()).thenReturn(elementList);
    Context context = new Context();
    MapStoreProperties mapStoreProperties = mock(MapStoreProperties.class);
    when(mapStoreProperties.getIngestBufferSize()).thenReturn(3);

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("Adding elements in batches, batch size = {}");
    MapImpl mapImpl = mock(MapImpl.class);
    when(mapImpl.getGroupByProperties(Mockito.<String>any())).thenReturn(new HashSet<>());
    when(mapImpl.getNonGroupByProperties(Mockito.<String>any())).thenReturn(stringSet);
    doNothing().when(mapImpl).addAggElement(Mockito.<Element>any(), Mockito.<GroupedProperties>any());
    doNothing().when(mapImpl).addIndex(Mockito.<EdgeSeed>any(), Mockito.<Element>any());
    doNothing().when(mapImpl).addIndex(Mockito.<EntitySeed>any(), Mockito.<Element>any());
    when(mapImpl.isAggregationEnabled(Mockito.<Element>any())).thenReturn(true);
    when(mapImpl.isMaintainIndex()).thenReturn(true);
    when(mapImpl.cloneElement(Mockito.<Element>any(), Mockito.<Schema>any())).thenReturn(new Edge("Group"));
    Schema schema = mock(Schema.class);
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.getGroups()).thenReturn(new HashSet<>());
    when(schema.getElement(Mockito.<String>any())).thenReturn(new SchemaEdgeDefinition());
    MapStore store = mock(MapStore.class);
    when(store.getProperties()).thenReturn(mapStoreProperties);
    when(store.getMapImpl()).thenReturn(mapImpl);
    when(store.getSchema()).thenReturn(schema);

    // Act
    Void actualDoOperationResult = addElementsHandler.doOperation(addElements, context, store);

    // Assert
    verify(schema).getGroups();
    verify(store).getMapImpl();
    verify(store).getProperties();
    verify(mapStoreProperties).getIngestBufferSize();
    verify(mapImpl).addAggElement(isA(Element.class), isA(GroupedProperties.class));
    verify(mapImpl).addIndex(isA(EdgeSeed.class), isA(Element.class));
    verify(mapImpl, atLeast(1)).addIndex(isA(EntitySeed.class), isA(Element.class));
    verify(mapImpl).cloneElement(isA(Element.class), isA(Schema.class));
    verify(mapImpl, atLeast(1)).getGroupByProperties(eq("Group"));
    verify(mapImpl, atLeast(1)).getNonGroupByProperties(eq("Group"));
    verify(mapImpl).isAggregationEnabled(isA(Element.class));
    verify(mapImpl).isMaintainIndex();
    verify(addElements).getInput();
    verify(addElements).isSkipInvalidElements();
    verify(addElements).isValidate();
    verify(store, atLeast(1)).getSchema();
    verify(schema).getAggregatedGroups();
    verify(schema).getElement(eq("Adding elements in batches, batch size = {}"));
    assertNull(actualDoOperationResult);
  }

  /**
   * Test {@link AddElementsHandler#doOperation(AddElements, Context, Store)} with {@code AddElements}, {@code Context}, {@code Store}.
   * <p>
   * Method under test: {@link AddElementsHandler#doOperation(AddElements, Context, Store)}
   */
  @Test
  @DisplayName("Test doOperation(AddElements, Context, Store) with 'AddElements', 'Context', 'Store'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Void AddElementsHandler.doOperation(AddElements, Context, Store)"})
  void testDoOperationWithAddElementsContextStore8() throws OperationException {
    // Arrange
    AddElementsHandler addElementsHandler = new AddElementsHandler();

    ArrayList<Element> elementList = new ArrayList<>();
    elementList.add(new Edge("Adding elements in batches, batch size = {}"));
    AddElements addElements = mock(AddElements.class);
    when(addElements.isSkipInvalidElements()).thenReturn(true);
    when(addElements.isValidate()).thenReturn(true);
    Mockito.<Iterable<? extends Element>>when(addElements.getInput()).thenReturn(elementList);
    Context context = new Context();
    MapStoreProperties mapStoreProperties = mock(MapStoreProperties.class);
    when(mapStoreProperties.getIngestBufferSize()).thenReturn(3);
    MapImpl mapImpl = mock(MapImpl.class);
    when(mapImpl.getGroupByProperties(Mockito.<String>any())).thenReturn(new HashSet<>());
    when(mapImpl.getNonGroupByProperties(Mockito.<String>any())).thenReturn(new HashSet<>());
    doNothing().when(mapImpl).addAggElement(Mockito.<Element>any(), Mockito.<GroupedProperties>any());
    when(mapImpl.isAggregationEnabled(Mockito.<Element>any())).thenReturn(true);
    when(mapImpl.isMaintainIndex()).thenReturn(false);
    when(mapImpl.cloneElement(Mockito.<Element>any(), Mockito.<Schema>any())).thenReturn(new Edge("Group"));
    Schema schema = mock(Schema.class);
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.getGroups()).thenReturn(new HashSet<>());
    when(schema.getElement(Mockito.<String>any())).thenReturn(new SchemaEdgeDefinition());
    MapStore store = mock(MapStore.class);
    when(store.getProperties()).thenReturn(mapStoreProperties);
    when(store.getMapImpl()).thenReturn(mapImpl);
    when(store.getSchema()).thenReturn(schema);

    // Act
    Void actualDoOperationResult = addElementsHandler.doOperation(addElements, context, store);

    // Assert
    verify(schema).getGroups();
    verify(store).getMapImpl();
    verify(store).getProperties();
    verify(mapStoreProperties).getIngestBufferSize();
    verify(mapImpl).addAggElement(isA(Element.class), isA(GroupedProperties.class));
    verify(mapImpl).cloneElement(isA(Element.class), isA(Schema.class));
    verify(mapImpl, atLeast(1)).getGroupByProperties(eq("Group"));
    verify(mapImpl, atLeast(1)).getNonGroupByProperties(eq("Group"));
    verify(mapImpl).isAggregationEnabled(isA(Element.class));
    verify(mapImpl).isMaintainIndex();
    verify(addElements).getInput();
    verify(addElements).isSkipInvalidElements();
    verify(addElements).isValidate();
    verify(store, atLeast(1)).getSchema();
    verify(schema).getAggregatedGroups();
    verify(schema).getElement(eq("Adding elements in batches, batch size = {}"));
    assertNull(actualDoOperationResult);
  }

  /**
   * Test {@link AddElementsHandler#doOperation(AddElements, Context, Store)} with {@code AddElements}, {@code Context}, {@code Store}.
   * <p>
   * Method under test: {@link AddElementsHandler#doOperation(AddElements, Context, Store)}
   */
  @Test
  @DisplayName("Test doOperation(AddElements, Context, Store) with 'AddElements', 'Context', 'Store'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Void AddElementsHandler.doOperation(AddElements, Context, Store)"})
  void testDoOperationWithAddElementsContextStore9() throws OperationException {
    // Arrange
    AddElementsHandler addElementsHandler = new AddElementsHandler();

    ArrayList<Element> elementList = new ArrayList<>();
    elementList.add(new Edge("Adding elements in batches, batch size = {}"));
    AddElements addElements = mock(AddElements.class);
    when(addElements.isSkipInvalidElements()).thenReturn(true);
    when(addElements.isValidate()).thenReturn(true);
    Mockito.<Iterable<? extends Element>>when(addElements.getInput()).thenReturn(elementList);
    Context context = new Context();
    MapStoreProperties mapStoreProperties = mock(MapStoreProperties.class);
    when(mapStoreProperties.getIngestBufferSize()).thenReturn(3);
    MapImpl mapImpl = mock(MapImpl.class);
    when(mapImpl.getGroupByProperties(Mockito.<String>any())).thenReturn(new HashSet<>());
    when(mapImpl.getNonGroupByProperties(Mockito.<String>any())).thenReturn(new HashSet<>());
    doNothing().when(mapImpl).addAggElement(Mockito.<Element>any(), Mockito.<GroupedProperties>any());
    doNothing().when(mapImpl).addIndex(Mockito.<EntitySeed>any(), Mockito.<Element>any());
    when(mapImpl.isAggregationEnabled(Mockito.<Element>any())).thenReturn(true);
    when(mapImpl.isMaintainIndex()).thenReturn(true);
    Entity buildResult = (new Entity.Builder()).group("Group").vertex("Vertex").build();
    when(mapImpl.cloneElement(Mockito.<Element>any(), Mockito.<Schema>any())).thenReturn(buildResult);
    Schema schema = mock(Schema.class);
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.getGroups()).thenReturn(new HashSet<>());
    when(schema.getElement(Mockito.<String>any())).thenReturn(new SchemaEdgeDefinition());
    MapStore store = mock(MapStore.class);
    when(store.getProperties()).thenReturn(mapStoreProperties);
    when(store.getMapImpl()).thenReturn(mapImpl);
    when(store.getSchema()).thenReturn(schema);

    // Act
    Void actualDoOperationResult = addElementsHandler.doOperation(addElements, context, store);

    // Assert
    verify(schema).getGroups();
    verify(store).getMapImpl();
    verify(store).getProperties();
    verify(mapStoreProperties).getIngestBufferSize();
    verify(mapImpl).addAggElement(isA(Element.class), isA(GroupedProperties.class));
    verify(mapImpl).addIndex(isA(EntitySeed.class), isA(Element.class));
    verify(mapImpl).cloneElement(isA(Element.class), isA(Schema.class));
    verify(mapImpl, atLeast(1)).getGroupByProperties(eq("Group"));
    verify(mapImpl, atLeast(1)).getNonGroupByProperties(eq("Group"));
    verify(mapImpl).isAggregationEnabled(isA(Element.class));
    verify(mapImpl).isMaintainIndex();
    verify(addElements).getInput();
    verify(addElements).isSkipInvalidElements();
    verify(addElements).isValidate();
    verify(store, atLeast(1)).getSchema();
    verify(schema).getAggregatedGroups();
    verify(schema).getElement(eq("Adding elements in batches, batch size = {}"));
    assertNull(actualDoOperationResult);
  }

  /**
   * Test {@link AddElementsHandler#doOperation(AddElements, Context, Store)} with {@code AddElements}, {@code Context}, {@code Store}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AddElementsHandler#doOperation(AddElements, Context, Store)}
   */
  @Test
  @DisplayName("Test doOperation(AddElements, Context, Store) with 'AddElements', 'Context', 'Store'; given ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Void AddElementsHandler.doOperation(AddElements, Context, Store)"})
  void testDoOperationWithAddElementsContextStore_givenArrayList() throws OperationException {
    // Arrange
    AddElementsHandler addElementsHandler = new AddElementsHandler();
    AddElements addElements = mock(AddElements.class);
    when(addElements.isSkipInvalidElements()).thenReturn(true);
    when(addElements.isValidate()).thenReturn(true);
    Mockito.<Iterable<? extends Element>>when(addElements.getInput()).thenReturn(new ArrayList<>());
    Context context = new Context();
    MapStoreProperties mapStoreProperties = mock(MapStoreProperties.class);
    when(mapStoreProperties.getIngestBufferSize()).thenReturn(3);
    MapStore store = mock(MapStore.class);
    when(store.getProperties()).thenReturn(mapStoreProperties);
    Schema schema = new Schema();
    when(store.getMapImpl()).thenReturn(new MapImpl(schema, new MapStoreProperties()));
    when(store.getSchema()).thenReturn(new Schema());

    // Act
    Void actualDoOperationResult = addElementsHandler.doOperation(addElements, context, store);

    // Assert
    verify(store).getMapImpl();
    verify(store).getProperties();
    verify(mapStoreProperties).getIngestBufferSize();
    verify(addElements).getInput();
    verify(addElements).isSkipInvalidElements();
    verify(addElements).isValidate();
    verify(store, atLeast(1)).getSchema();
    assertNull(actualDoOperationResult);
  }

  /**
   * Test {@link AddElementsHandler#doOperation(AddElements, Context, Store)} with {@code AddElements}, {@code Context}, {@code Store}.
   * <ul>
   *   <li>Given {@link MapImpl} {@link MapImpl#cloneElement(Element, Schema)} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AddElementsHandler#doOperation(AddElements, Context, Store)}
   */
  @Test
  @DisplayName("Test doOperation(AddElements, Context, Store) with 'AddElements', 'Context', 'Store'; given MapImpl cloneElement(Element, Schema) return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Void AddElementsHandler.doOperation(AddElements, Context, Store)"})
  void testDoOperationWithAddElementsContextStore_givenMapImplCloneElementReturnNull() throws OperationException {
    // Arrange
    AddElementsHandler addElementsHandler = new AddElementsHandler();

    ArrayList<Element> elementList = new ArrayList<>();
    elementList.add(new Edge("Adding elements in batches, batch size = {}"));
    AddElements addElements = mock(AddElements.class);
    when(addElements.isSkipInvalidElements()).thenReturn(true);
    when(addElements.isValidate()).thenReturn(true);
    Mockito.<Iterable<? extends Element>>when(addElements.getInput()).thenReturn(elementList);
    Context context = new Context();
    MapStoreProperties mapStoreProperties = mock(MapStoreProperties.class);
    when(mapStoreProperties.getIngestBufferSize()).thenReturn(3);
    MapImpl mapImpl = mock(MapImpl.class);
    when(mapImpl.cloneElement(Mockito.<Element>any(), Mockito.<Schema>any())).thenReturn(null);
    Schema schema = mock(Schema.class);
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.getGroups()).thenReturn(new HashSet<>());
    when(schema.getElement(Mockito.<String>any())).thenReturn(new SchemaEdgeDefinition());
    MapStore store = mock(MapStore.class);
    when(store.getProperties()).thenReturn(mapStoreProperties);
    when(store.getMapImpl()).thenReturn(mapImpl);
    when(store.getSchema()).thenReturn(schema);

    // Act
    Void actualDoOperationResult = addElementsHandler.doOperation(addElements, context, store);

    // Assert
    verify(schema).getGroups();
    verify(store).getMapImpl();
    verify(store).getProperties();
    verify(mapStoreProperties).getIngestBufferSize();
    verify(mapImpl).cloneElement(isA(Element.class), isA(Schema.class));
    verify(addElements).getInput();
    verify(addElements).isSkipInvalidElements();
    verify(addElements).isValidate();
    verify(store, atLeast(1)).getSchema();
    verify(schema).getAggregatedGroups();
    verify(schema).getElement(eq("Adding elements in batches, batch size = {}"));
    assertNull(actualDoOperationResult);
  }

  /**
   * Test {@link AddElementsHandler#doOperation(AddElements, Context, Store)} with {@code AddElements}, {@code Context}, {@code Store}.
   * <ul>
   *   <li>Given {@link MapStoreProperties#MapStoreProperties()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AddElementsHandler#doOperation(AddElements, Context, Store)}
   */
  @Test
  @DisplayName("Test doOperation(AddElements, Context, Store) with 'AddElements', 'Context', 'Store'; given MapStoreProperties()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Void AddElementsHandler.doOperation(AddElements, Context, Store)"})
  void testDoOperationWithAddElementsContextStore_givenMapStoreProperties() throws OperationException {
    // Arrange
    AddElementsHandler addElementsHandler = new AddElementsHandler();
    AddElements addElements = mock(AddElements.class);
    when(addElements.isSkipInvalidElements()).thenReturn(true);
    when(addElements.isValidate()).thenReturn(true);
    Mockito.<Iterable<? extends Element>>when(addElements.getInput()).thenReturn(new ArrayList<>());
    Context context = new Context();
    MapStore store = mock(MapStore.class);
    when(store.getProperties()).thenReturn(new MapStoreProperties());
    Schema schema = new Schema();
    when(store.getMapImpl()).thenReturn(new MapImpl(schema, new MapStoreProperties()));
    when(store.getSchema()).thenReturn(new Schema());

    // Act
    Void actualDoOperationResult = addElementsHandler.doOperation(addElements, context, store);

    // Assert
    verify(store).getMapImpl();
    verify(store).getProperties();
    verify(addElements).getInput();
    verify(addElements).isSkipInvalidElements();
    verify(addElements).isValidate();
    verify(store, atLeast(1)).getSchema();
    assertNull(actualDoOperationResult);
  }

  /**
   * Test {@link AddElementsHandler#doOperation(AddElements, Context, Store)} with {@code AddElements}, {@code Context}, {@code Store}.
   * <ul>
   *   <li>Given {@link MapStoreProperties#MapStoreProperties()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AddElementsHandler#doOperation(AddElements, Context, Store)}
   */
  @Test
  @DisplayName("Test doOperation(AddElements, Context, Store) with 'AddElements', 'Context', 'Store'; given MapStoreProperties()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Void AddElementsHandler.doOperation(AddElements, Context, Store)"})
  void testDoOperationWithAddElementsContextStore_givenMapStoreProperties2() throws OperationException {
    // Arrange
    AddElementsHandler addElementsHandler = new AddElementsHandler();
    AddElements addElements = mock(AddElements.class);
    when(addElements.isValidate()).thenReturn(false);
    Mockito.<Iterable<? extends Element>>when(addElements.getInput()).thenReturn(new ArrayList<>());
    Context context = new Context();
    MapStore store = mock(MapStore.class);
    when(store.getProperties()).thenReturn(new MapStoreProperties());
    Schema schema = new Schema();
    when(store.getMapImpl()).thenReturn(new MapImpl(schema, new MapStoreProperties()));
    when(store.getSchema()).thenReturn(new Schema());

    // Act
    Void actualDoOperationResult = addElementsHandler.doOperation(addElements, context, store);

    // Assert
    verify(store).getMapImpl();
    verify(store).getProperties();
    verify(addElements).getInput();
    verify(addElements).isValidate();
    verify(store).getSchema();
    assertNull(actualDoOperationResult);
  }

  /**
   * Test {@link AddElementsHandler#doOperation(AddElements, Context, Store)} with {@code AddElements}, {@code Context}, {@code Store}.
   * <ul>
   *   <li>Given {@link Schema#Schema()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AddElementsHandler#doOperation(AddElements, Context, Store)}
   */
  @Test
  @DisplayName("Test doOperation(AddElements, Context, Store) with 'AddElements', 'Context', 'Store'; given Schema()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Void AddElementsHandler.doOperation(AddElements, Context, Store)"})
  void testDoOperationWithAddElementsContextStore_givenSchema() throws OperationException {
    // Arrange
    AddElementsHandler addElementsHandler = new AddElementsHandler();

    ArrayList<Element> elementList = new ArrayList<>();
    elementList.add(new Edge("Adding elements in batches, batch size = {}"));
    AddElements addElements = mock(AddElements.class);
    when(addElements.isSkipInvalidElements()).thenReturn(true);
    when(addElements.isValidate()).thenReturn(true);
    Mockito.<Iterable<? extends Element>>when(addElements.getInput()).thenReturn(elementList);
    Context context = new Context();
    MapStoreProperties mapStoreProperties = mock(MapStoreProperties.class);
    when(mapStoreProperties.getIngestBufferSize()).thenReturn(3);
    MapStore store = mock(MapStore.class);
    when(store.getProperties()).thenReturn(mapStoreProperties);
    Schema schema = new Schema();
    when(store.getMapImpl()).thenReturn(new MapImpl(schema, new MapStoreProperties()));
    when(store.getSchema()).thenReturn(new Schema());

    // Act
    Void actualDoOperationResult = addElementsHandler.doOperation(addElements, context, store);

    // Assert
    verify(store).getMapImpl();
    verify(store).getProperties();
    verify(mapStoreProperties).getIngestBufferSize();
    verify(addElements).getInput();
    verify(addElements).isSkipInvalidElements();
    verify(addElements).isValidate();
    verify(store, atLeast(1)).getSchema();
    assertNull(actualDoOperationResult);
  }

  /**
   * Test {@link AddElementsHandler#doOperation(AddElements, Context, Store)} with {@code AddElements}, {@code Context}, {@code Store}.
   * <ul>
   *   <li>Given {@link Schema#Schema()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AddElementsHandler#doOperation(AddElements, Context, Store)}
   */
  @Test
  @DisplayName("Test doOperation(AddElements, Context, Store) with 'AddElements', 'Context', 'Store'; given Schema()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Void AddElementsHandler.doOperation(AddElements, Context, Store)"})
  void testDoOperationWithAddElementsContextStore_givenSchema2() throws OperationException {
    // Arrange
    AddElementsHandler addElementsHandler = new AddElementsHandler();

    ArrayList<Element> elementList = new ArrayList<>();
    elementList.add(new Edge("Adding elements in batches, batch size = {}"));
    elementList.add(new Edge("Adding elements in batches, batch size = {}"));
    AddElements addElements = mock(AddElements.class);
    when(addElements.isSkipInvalidElements()).thenReturn(true);
    when(addElements.isValidate()).thenReturn(true);
    Mockito.<Iterable<? extends Element>>when(addElements.getInput()).thenReturn(elementList);
    Context context = new Context();
    MapStoreProperties mapStoreProperties = mock(MapStoreProperties.class);
    when(mapStoreProperties.getIngestBufferSize()).thenReturn(3);
    MapStore store = mock(MapStore.class);
    when(store.getProperties()).thenReturn(mapStoreProperties);
    Schema schema = new Schema();
    when(store.getMapImpl()).thenReturn(new MapImpl(schema, new MapStoreProperties()));
    when(store.getSchema()).thenReturn(new Schema());

    // Act
    Void actualDoOperationResult = addElementsHandler.doOperation(addElements, context, store);

    // Assert
    verify(store).getMapImpl();
    verify(store).getProperties();
    verify(mapStoreProperties).getIngestBufferSize();
    verify(addElements).getInput();
    verify(addElements).isSkipInvalidElements();
    verify(addElements).isValidate();
    verify(store, atLeast(1)).getSchema();
    assertNull(actualDoOperationResult);
  }

  /**
   * Test {@link AddElementsHandler#doOperation(AddElements, Context, Store)} with {@code AddElements}, {@code Context}, {@code Store}.
   * <ul>
   *   <li>Then calls {@link MapImpl#addNonAggElement(Element)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AddElementsHandler#doOperation(AddElements, Context, Store)}
   */
  @Test
  @DisplayName("Test doOperation(AddElements, Context, Store) with 'AddElements', 'Context', 'Store'; then calls addNonAggElement(Element)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Void AddElementsHandler.doOperation(AddElements, Context, Store)"})
  void testDoOperationWithAddElementsContextStore_thenCallsAddNonAggElement() throws OperationException {
    // Arrange
    AddElementsHandler addElementsHandler = new AddElementsHandler();

    ArrayList<Element> elementList = new ArrayList<>();
    elementList.add(new Edge("Adding elements in batches, batch size = {}"));
    AddElements addElements = mock(AddElements.class);
    when(addElements.isSkipInvalidElements()).thenReturn(true);
    when(addElements.isValidate()).thenReturn(true);
    Mockito.<Iterable<? extends Element>>when(addElements.getInput()).thenReturn(elementList);
    Context context = new Context();
    MapStoreProperties mapStoreProperties = mock(MapStoreProperties.class);
    when(mapStoreProperties.getIngestBufferSize()).thenReturn(3);
    MapImpl mapImpl = mock(MapImpl.class);
    doNothing().when(mapImpl).addIndex(Mockito.<EdgeSeed>any(), Mockito.<Element>any());
    doNothing().when(mapImpl).addIndex(Mockito.<EntitySeed>any(), Mockito.<Element>any());
    when(mapImpl.isAggregationEnabled(Mockito.<Element>any())).thenReturn(false);
    when(mapImpl.isMaintainIndex()).thenReturn(true);
    doNothing().when(mapImpl).addNonAggElement(Mockito.<Element>any());
    when(mapImpl.cloneElement(Mockito.<Element>any(), Mockito.<Schema>any())).thenReturn(new Edge("Group"));
    Schema schema = mock(Schema.class);
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.getGroups()).thenReturn(new HashSet<>());
    when(schema.getElement(Mockito.<String>any())).thenReturn(new SchemaEdgeDefinition());
    MapStore store = mock(MapStore.class);
    when(store.getProperties()).thenReturn(mapStoreProperties);
    when(store.getMapImpl()).thenReturn(mapImpl);
    when(store.getSchema()).thenReturn(schema);

    // Act
    Void actualDoOperationResult = addElementsHandler.doOperation(addElements, context, store);

    // Assert
    verify(schema).getGroups();
    verify(store).getMapImpl();
    verify(store).getProperties();
    verify(mapStoreProperties).getIngestBufferSize();
    verify(mapImpl).addIndex(isA(EdgeSeed.class), isA(Element.class));
    verify(mapImpl, atLeast(1)).addIndex(isA(EntitySeed.class), isA(Element.class));
    verify(mapImpl).addNonAggElement(isA(Element.class));
    verify(mapImpl).cloneElement(isA(Element.class), isA(Schema.class));
    verify(mapImpl).isAggregationEnabled(isA(Element.class));
    verify(mapImpl).isMaintainIndex();
    verify(addElements).getInput();
    verify(addElements).isSkipInvalidElements();
    verify(addElements).isValidate();
    verify(store, atLeast(1)).getSchema();
    verify(schema).getAggregatedGroups();
    verify(schema, atLeast(1)).getElement(Mockito.<String>any());
    assertNull(actualDoOperationResult);
  }

  /**
   * Test {@link AddElementsHandler#doOperation(AddElements, Context, Store)} with {@code AddElements}, {@code Context}, {@code Store}.
   * <ul>
   *   <li>Then calls {@link MapImpl#addNonAggElement(Element)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AddElementsHandler#doOperation(AddElements, Context, Store)}
   */
  @Test
  @DisplayName("Test doOperation(AddElements, Context, Store) with 'AddElements', 'Context', 'Store'; then calls addNonAggElement(Element)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Void AddElementsHandler.doOperation(AddElements, Context, Store)"})
  void testDoOperationWithAddElementsContextStore_thenCallsAddNonAggElement2() throws OperationException {
    // Arrange
    AddElementsHandler addElementsHandler = new AddElementsHandler();

    ArrayList<Element> elementList = new ArrayList<>();
    elementList.add(new Edge("Adding elements in batches, batch size = {}"));
    AddElements addElements = mock(AddElements.class);
    when(addElements.isSkipInvalidElements()).thenReturn(true);
    when(addElements.isValidate()).thenReturn(true);
    Mockito.<Iterable<? extends Element>>when(addElements.getInput()).thenReturn(elementList);
    Context context = new Context();
    MapStoreProperties mapStoreProperties = mock(MapStoreProperties.class);
    when(mapStoreProperties.getIngestBufferSize()).thenReturn(3);
    Edge edge = mock(Edge.class);
    when(edge.getGroup()).thenReturn("Group");
    Edge buildResult = (new Builder()).dest("Dest")
        .directed(true)
        .group("Group")
        .matchedVertex(MatchedVertex.SOURCE)
        .source("Source")
        .build();
    when(edge.emptyClone()).thenReturn(buildResult);
    MapImpl mapImpl = mock(MapImpl.class);
    doNothing().when(mapImpl).addIndex(Mockito.<EdgeSeed>any(), Mockito.<Element>any());
    doNothing().when(mapImpl).addIndex(Mockito.<EntitySeed>any(), Mockito.<Element>any());
    when(mapImpl.isAggregationEnabled(Mockito.<Element>any())).thenReturn(false);
    when(mapImpl.isMaintainIndex()).thenReturn(true);
    doNothing().when(mapImpl).addNonAggElement(Mockito.<Element>any());
    when(mapImpl.cloneElement(Mockito.<Element>any(), Mockito.<Schema>any())).thenReturn(edge);
    Schema schema = mock(Schema.class);
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.getGroups()).thenReturn(new HashSet<>());
    when(schema.getElement(Mockito.<String>any())).thenReturn(new SchemaEdgeDefinition());
    MapStore store = mock(MapStore.class);
    when(store.getProperties()).thenReturn(mapStoreProperties);
    when(store.getMapImpl()).thenReturn(mapImpl);
    when(store.getSchema()).thenReturn(schema);

    // Act
    Void actualDoOperationResult = addElementsHandler.doOperation(addElements, context, store);

    // Assert
    verify(edge).emptyClone();
    verify(edge, atLeast(1)).getGroup();
    verify(schema).getGroups();
    verify(store).getMapImpl();
    verify(store).getProperties();
    verify(mapStoreProperties).getIngestBufferSize();
    verify(mapImpl).addIndex(isA(EdgeSeed.class), isA(Element.class));
    verify(mapImpl, atLeast(1)).addIndex(Mockito.<EntitySeed>any(), isA(Element.class));
    verify(mapImpl).addNonAggElement(isA(Element.class));
    verify(mapImpl).cloneElement(isA(Element.class), isA(Schema.class));
    verify(mapImpl).isAggregationEnabled(isA(Element.class));
    verify(mapImpl).isMaintainIndex();
    verify(addElements).getInput();
    verify(addElements).isSkipInvalidElements();
    verify(addElements).isValidate();
    verify(store, atLeast(1)).getSchema();
    verify(schema).getAggregatedGroups();
    verify(schema, atLeast(1)).getElement(Mockito.<String>any());
    assertNull(actualDoOperationResult);
  }

  /**
   * Test {@link AddElementsHandler#doOperation(AddElements, Context, Store)} with {@code AddElements}, {@code Context}, {@code Store}.
   * <ul>
   *   <li>Then calls {@link Edge#emptyClone()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AddElementsHandler#doOperation(AddElements, Context, Store)}
   */
  @Test
  @DisplayName("Test doOperation(AddElements, Context, Store) with 'AddElements', 'Context', 'Store'; then calls emptyClone()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Void AddElementsHandler.doOperation(AddElements, Context, Store)"})
  void testDoOperationWithAddElementsContextStore_thenCallsEmptyClone() throws OperationException {
    // Arrange
    AddElementsHandler addElementsHandler = new AddElementsHandler();

    ArrayList<Element> elementList = new ArrayList<>();
    elementList.add(new Edge("Adding elements in batches, batch size = {}"));
    AddElements addElements = mock(AddElements.class);
    when(addElements.isSkipInvalidElements()).thenReturn(true);
    when(addElements.isValidate()).thenReturn(true);
    Mockito.<Iterable<? extends Element>>when(addElements.getInput()).thenReturn(elementList);
    Context context = new Context();
    MapStoreProperties mapStoreProperties = mock(MapStoreProperties.class);
    when(mapStoreProperties.getIngestBufferSize()).thenReturn(3);
    Edge edge = mock(Edge.class);
    when(edge.getGroup()).thenReturn("Group");
    Edge buildResult = (new Builder()).dest("Dest")
        .directed(true)
        .group("Group")
        .matchedVertex(MatchedVertex.SOURCE)
        .source("Source")
        .build();
    when(edge.emptyClone()).thenReturn(buildResult);
    MapImpl mapImpl = mock(MapImpl.class);
    when(mapImpl.getGroupByProperties(Mockito.<String>any())).thenReturn(new HashSet<>());
    when(mapImpl.getNonGroupByProperties(Mockito.<String>any())).thenReturn(new HashSet<>());
    doNothing().when(mapImpl).addAggElement(Mockito.<Element>any(), Mockito.<GroupedProperties>any());
    doNothing().when(mapImpl).addIndex(Mockito.<EdgeSeed>any(), Mockito.<Element>any());
    doNothing().when(mapImpl).addIndex(Mockito.<EntitySeed>any(), Mockito.<Element>any());
    when(mapImpl.isAggregationEnabled(Mockito.<Element>any())).thenReturn(true);
    when(mapImpl.isMaintainIndex()).thenReturn(true);
    when(mapImpl.cloneElement(Mockito.<Element>any(), Mockito.<Schema>any())).thenReturn(edge);
    Schema schema = mock(Schema.class);
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.getGroups()).thenReturn(new HashSet<>());
    when(schema.getElement(Mockito.<String>any())).thenReturn(new SchemaEdgeDefinition());
    MapStore store = mock(MapStore.class);
    when(store.getProperties()).thenReturn(mapStoreProperties);
    when(store.getMapImpl()).thenReturn(mapImpl);
    when(store.getSchema()).thenReturn(schema);

    // Act
    Void actualDoOperationResult = addElementsHandler.doOperation(addElements, context, store);

    // Assert
    verify(edge).emptyClone();
    verify(edge, atLeast(1)).getGroup();
    verify(schema).getGroups();
    verify(store).getMapImpl();
    verify(store).getProperties();
    verify(mapStoreProperties).getIngestBufferSize();
    verify(mapImpl).addAggElement(isA(Element.class), isA(GroupedProperties.class));
    verify(mapImpl).addIndex(isA(EdgeSeed.class), isA(Element.class));
    verify(mapImpl, atLeast(1)).addIndex(Mockito.<EntitySeed>any(), isA(Element.class));
    verify(mapImpl).cloneElement(isA(Element.class), isA(Schema.class));
    verify(mapImpl, atLeast(1)).getGroupByProperties(eq("Group"));
    verify(mapImpl, atLeast(1)).getNonGroupByProperties(eq("Group"));
    verify(mapImpl).isAggregationEnabled(isA(Element.class));
    verify(mapImpl).isMaintainIndex();
    verify(addElements).getInput();
    verify(addElements).isSkipInvalidElements();
    verify(addElements).isValidate();
    verify(store, atLeast(1)).getSchema();
    verify(schema).getAggregatedGroups();
    verify(schema).getElement(eq("Adding elements in batches, batch size = {}"));
    assertNull(actualDoOperationResult);
  }

  /**
   * Test {@link AddElementsHandler#doOperation(AddElements, Context, Store)} with {@code AddElements}, {@code Context}, {@code Store}.
   * <ul>
   *   <li>Then calls {@link ElementDefinitions#getGroups()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AddElementsHandler#doOperation(AddElements, Context, Store)}
   */
  @Test
  @DisplayName("Test doOperation(AddElements, Context, Store) with 'AddElements', 'Context', 'Store'; then calls getGroups()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Void AddElementsHandler.doOperation(AddElements, Context, Store)"})
  void testDoOperationWithAddElementsContextStore_thenCallsGetGroups() throws OperationException {
    // Arrange
    AddElementsHandler addElementsHandler = new AddElementsHandler();

    ArrayList<Element> elementList = new ArrayList<>();
    elementList.add(new Edge("Adding elements in batches, batch size = {}"));
    AddElements addElements = mock(AddElements.class);
    when(addElements.isSkipInvalidElements()).thenReturn(true);
    when(addElements.isValidate()).thenReturn(true);
    Mockito.<Iterable<? extends Element>>when(addElements.getInput()).thenReturn(elementList);
    Context context = new Context();
    MapStoreProperties mapStoreProperties = mock(MapStoreProperties.class);
    when(mapStoreProperties.getIngestBufferSize()).thenReturn(3);
    Schema schema = mock(Schema.class);
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.getGroups()).thenReturn(new HashSet<>());
    when(schema.getElement(Mockito.<String>any())).thenReturn(new SchemaEdgeDefinition());
    MapStore store = mock(MapStore.class);
    when(store.getProperties()).thenReturn(mapStoreProperties);
    Schema schema2 = new Schema();
    when(store.getMapImpl()).thenReturn(new MapImpl(schema2, new MapStoreProperties()));
    when(store.getSchema()).thenReturn(schema);

    // Act
    Void actualDoOperationResult = addElementsHandler.doOperation(addElements, context, store);

    // Assert
    verify(schema).getGroups();
    verify(store).getMapImpl();
    verify(store).getProperties();
    verify(mapStoreProperties).getIngestBufferSize();
    verify(addElements).getInput();
    verify(addElements).isSkipInvalidElements();
    verify(addElements).isValidate();
    verify(store, atLeast(1)).getSchema();
    verify(schema).getAggregatedGroups();
    verify(schema, atLeast(1)).getElement(eq("Adding elements in batches, batch size = {}"));
    assertNull(actualDoOperationResult);
  }

  /**
   * Test {@link AddElementsHandler#doOperation(AddElements, Context, Store)} with {@code AddElements}, {@code Context}, {@code Store}.
   * <ul>
   *   <li>Then calls {@link ElementDefinitions#getGroups()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AddElementsHandler#doOperation(AddElements, Context, Store)}
   */
  @Test
  @DisplayName("Test doOperation(AddElements, Context, Store) with 'AddElements', 'Context', 'Store'; then calls getGroups()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Void AddElementsHandler.doOperation(AddElements, Context, Store)"})
  void testDoOperationWithAddElementsContextStore_thenCallsGetGroups2() throws OperationException {
    // Arrange
    AddElementsHandler addElementsHandler = new AddElementsHandler();

    ArrayList<Element> elementList = new ArrayList<>();
    elementList.add(new Edge("Adding elements in batches, batch size = {}"));
    elementList.add(new Edge("Adding elements in batches, batch size = {}"));
    AddElements addElements = mock(AddElements.class);
    when(addElements.isSkipInvalidElements()).thenReturn(true);
    when(addElements.isValidate()).thenReturn(true);
    Mockito.<Iterable<? extends Element>>when(addElements.getInput()).thenReturn(elementList);
    Context context = new Context();
    MapStoreProperties mapStoreProperties = mock(MapStoreProperties.class);
    when(mapStoreProperties.getIngestBufferSize()).thenReturn(3);
    Schema schema = mock(Schema.class);
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.getGroups()).thenReturn(new HashSet<>());
    when(schema.getElement(Mockito.<String>any())).thenReturn(new SchemaEdgeDefinition());
    MapStore store = mock(MapStore.class);
    when(store.getProperties()).thenReturn(mapStoreProperties);
    Schema schema2 = new Schema();
    when(store.getMapImpl()).thenReturn(new MapImpl(schema2, new MapStoreProperties()));
    when(store.getSchema()).thenReturn(schema);

    // Act
    Void actualDoOperationResult = addElementsHandler.doOperation(addElements, context, store);

    // Assert
    verify(schema).getGroups();
    verify(store).getMapImpl();
    verify(store).getProperties();
    verify(mapStoreProperties).getIngestBufferSize();
    verify(addElements).getInput();
    verify(addElements).isSkipInvalidElements();
    verify(addElements).isValidate();
    verify(store, atLeast(1)).getSchema();
    verify(schema).getAggregatedGroups();
    verify(schema, atLeast(1)).getElement(eq("Adding elements in batches, batch size = {}"));
    assertNull(actualDoOperationResult);
  }

  /**
   * Test {@link AddElementsHandler#doOperation(AddElements, Context, Store)} with {@code AddElements}, {@code Context}, {@code Store}.
   * <ul>
   *   <li>Then calls {@link Element#getProperty(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AddElementsHandler#doOperation(AddElements, Context, Store)}
   */
  @Test
  @DisplayName("Test doOperation(AddElements, Context, Store) with 'AddElements', 'Context', 'Store'; then calls getProperty(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Void AddElementsHandler.doOperation(AddElements, Context, Store)"})
  void testDoOperationWithAddElementsContextStore_thenCallsGetProperty() throws OperationException {
    // Arrange
    AddElementsHandler addElementsHandler = new AddElementsHandler();

    ArrayList<Element> elementList = new ArrayList<>();
    elementList.add(new Edge("Adding elements in batches, batch size = {}"));
    AddElements addElements = mock(AddElements.class);
    when(addElements.isSkipInvalidElements()).thenReturn(true);
    when(addElements.isValidate()).thenReturn(true);
    Mockito.<Iterable<? extends Element>>when(addElements.getInput()).thenReturn(elementList);
    Context context = new Context();
    MapStoreProperties mapStoreProperties = mock(MapStoreProperties.class);
    when(mapStoreProperties.getIngestBufferSize()).thenReturn(3);
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

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("42");
    MapImpl mapImpl = mock(MapImpl.class);
    when(mapImpl.getGroupByProperties(Mockito.<String>any())).thenReturn(stringSet);
    when(mapImpl.getNonGroupByProperties(Mockito.<String>any())).thenReturn(new HashSet<>());
    doNothing().when(mapImpl).addAggElement(Mockito.<Element>any(), Mockito.<GroupedProperties>any());
    doNothing().when(mapImpl).addIndex(Mockito.<EdgeSeed>any(), Mockito.<Element>any());
    doNothing().when(mapImpl).addIndex(Mockito.<EntitySeed>any(), Mockito.<Element>any());
    when(mapImpl.isAggregationEnabled(Mockito.<Element>any())).thenReturn(true);
    when(mapImpl.isMaintainIndex()).thenReturn(true);
    when(mapImpl.cloneElement(Mockito.<Element>any(), Mockito.<Schema>any())).thenReturn(edge);
    Schema schema = mock(Schema.class);
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.getGroups()).thenReturn(new HashSet<>());
    when(schema.getElement(Mockito.<String>any())).thenReturn(new SchemaEdgeDefinition());
    MapStore store = mock(MapStore.class);
    when(store.getProperties()).thenReturn(mapStoreProperties);
    when(store.getMapImpl()).thenReturn(mapImpl);
    when(store.getSchema()).thenReturn(schema);

    // Act
    Void actualDoOperationResult = addElementsHandler.doOperation(addElements, context, store);

    // Assert
    verify(edge).emptyClone();
    verify(edge, atLeast(1)).getGroup();
    verify(edge).getProperty(eq("42"));
    verify(schema).getGroups();
    verify(store).getMapImpl();
    verify(store).getProperties();
    verify(mapStoreProperties).getIngestBufferSize();
    verify(mapImpl).addAggElement(isA(Element.class), isA(GroupedProperties.class));
    verify(mapImpl).addIndex(isA(EdgeSeed.class), isA(Element.class));
    verify(mapImpl, atLeast(1)).addIndex(Mockito.<EntitySeed>any(), isA(Element.class));
    verify(mapImpl).cloneElement(isA(Element.class), isA(Schema.class));
    verify(mapImpl, atLeast(1)).getGroupByProperties(eq("Group"));
    verify(mapImpl, atLeast(1)).getNonGroupByProperties(eq("Group"));
    verify(mapImpl).isAggregationEnabled(isA(Element.class));
    verify(mapImpl).isMaintainIndex();
    verify(addElements).getInput();
    verify(addElements).isSkipInvalidElements();
    verify(addElements).isValidate();
    verify(store, atLeast(1)).getSchema();
    verify(schema).getAggregatedGroups();
    verify(schema).getElement(eq("Adding elements in batches, batch size = {}"));
    assertNull(actualDoOperationResult);
  }

  /**
   * Test {@link AddElementsHandler#doOperation(AddElements, Context, Store)} with {@code AddElements}, {@code Context}, {@code Store}.
   * <ul>
   *   <li>Then calls {@link Element#getProperty(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AddElementsHandler#doOperation(AddElements, Context, Store)}
   */
  @Test
  @DisplayName("Test doOperation(AddElements, Context, Store) with 'AddElements', 'Context', 'Store'; then calls getProperty(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Void AddElementsHandler.doOperation(AddElements, Context, Store)"})
  void testDoOperationWithAddElementsContextStore_thenCallsGetProperty2() throws OperationException {
    // Arrange
    AddElementsHandler addElementsHandler = new AddElementsHandler();

    ArrayList<Element> elementList = new ArrayList<>();
    elementList.add(new Edge("Adding elements in batches, batch size = {}"));
    AddElements addElements = mock(AddElements.class);
    when(addElements.isSkipInvalidElements()).thenReturn(true);
    when(addElements.isValidate()).thenReturn(true);
    Mockito.<Iterable<? extends Element>>when(addElements.getInput()).thenReturn(elementList);
    Context context = new Context();
    MapStoreProperties mapStoreProperties = mock(MapStoreProperties.class);
    when(mapStoreProperties.getIngestBufferSize()).thenReturn(3);
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

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("42");

    HashSet<String> stringSet2 = new HashSet<>();
    stringSet2.add("42");
    MapImpl mapImpl = mock(MapImpl.class);
    when(mapImpl.getGroupByProperties(Mockito.<String>any())).thenReturn(stringSet);
    when(mapImpl.getNonGroupByProperties(Mockito.<String>any())).thenReturn(stringSet2);
    doNothing().when(mapImpl).addAggElement(Mockito.<Element>any(), Mockito.<GroupedProperties>any());
    doNothing().when(mapImpl).addIndex(Mockito.<EdgeSeed>any(), Mockito.<Element>any());
    doNothing().when(mapImpl).addIndex(Mockito.<EntitySeed>any(), Mockito.<Element>any());
    when(mapImpl.isAggregationEnabled(Mockito.<Element>any())).thenReturn(true);
    when(mapImpl.isMaintainIndex()).thenReturn(true);
    when(mapImpl.cloneElement(Mockito.<Element>any(), Mockito.<Schema>any())).thenReturn(edge);
    Schema schema = mock(Schema.class);
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.getGroups()).thenReturn(new HashSet<>());
    when(schema.getElement(Mockito.<String>any())).thenReturn(new SchemaEdgeDefinition());
    MapStore store = mock(MapStore.class);
    when(store.getProperties()).thenReturn(mapStoreProperties);
    when(store.getMapImpl()).thenReturn(mapImpl);
    when(store.getSchema()).thenReturn(schema);

    // Act
    Void actualDoOperationResult = addElementsHandler.doOperation(addElements, context, store);

    // Assert
    verify(edge).emptyClone();
    verify(edge, atLeast(1)).getGroup();
    verify(edge, atLeast(1)).getProperty(eq("42"));
    verify(schema).getGroups();
    verify(store).getMapImpl();
    verify(store).getProperties();
    verify(mapStoreProperties).getIngestBufferSize();
    verify(mapImpl).addAggElement(isA(Element.class), isA(GroupedProperties.class));
    verify(mapImpl).addIndex(isA(EdgeSeed.class), isA(Element.class));
    verify(mapImpl, atLeast(1)).addIndex(Mockito.<EntitySeed>any(), isA(Element.class));
    verify(mapImpl).cloneElement(isA(Element.class), isA(Schema.class));
    verify(mapImpl, atLeast(1)).getGroupByProperties(eq("Group"));
    verify(mapImpl, atLeast(1)).getNonGroupByProperties(eq("Group"));
    verify(mapImpl).isAggregationEnabled(isA(Element.class));
    verify(mapImpl).isMaintainIndex();
    verify(addElements).getInput();
    verify(addElements).isSkipInvalidElements();
    verify(addElements).isValidate();
    verify(store, atLeast(1)).getSchema();
    verify(schema).getAggregatedGroups();
    verify(schema).getElement(eq("Adding elements in batches, batch size = {}"));
    assertNull(actualDoOperationResult);
  }

  /**
   * Test {@link AddElementsHandler#doOperation(AddElements, Context, Store)} with {@code AddElements}, {@code Context}, {@code Store}.
   * <ul>
   *   <li>Then calls {@link Schema#getVisibilityProperty()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AddElementsHandler#doOperation(AddElements, Context, Store)}
   */
  @Test
  @DisplayName("Test doOperation(AddElements, Context, Store) with 'AddElements', 'Context', 'Store'; then calls getVisibilityProperty()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Void AddElementsHandler.doOperation(AddElements, Context, Store)"})
  void testDoOperationWithAddElementsContextStore_thenCallsGetVisibilityProperty() throws OperationException {
    // Arrange
    AddElementsHandler addElementsHandler = new AddElementsHandler();

    ArrayList<Element> elementList = new ArrayList<>();
    elementList.add(new Edge("Adding elements in batches, batch size = {}"));
    AddElements addElements = mock(AddElements.class);
    when(addElements.isSkipInvalidElements()).thenReturn(true);
    when(addElements.isValidate()).thenReturn(true);
    Mockito.<Iterable<? extends Element>>when(addElements.getInput()).thenReturn(elementList);
    Context context = new Context();
    MapStoreProperties mapStoreProperties = mock(MapStoreProperties.class);
    when(mapStoreProperties.getIngestBufferSize()).thenReturn(3);
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

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("42");
    MapImpl mapImpl = mock(MapImpl.class);
    when(mapImpl.getGroupByProperties(Mockito.<String>any())).thenReturn(stringSet);
    when(mapImpl.getNonGroupByProperties(Mockito.<String>any())).thenReturn(new HashSet<>());
    doNothing().when(mapImpl).addAggElement(Mockito.<Element>any(), Mockito.<GroupedProperties>any());
    doNothing().when(mapImpl).addIndex(Mockito.<EdgeSeed>any(), Mockito.<Element>any());
    doNothing().when(mapImpl).addIndex(Mockito.<EntitySeed>any(), Mockito.<Element>any());
    when(mapImpl.isAggregationEnabled(Mockito.<Element>any())).thenReturn(true);
    when(mapImpl.isMaintainIndex()).thenReturn(true);
    when(mapImpl.cloneElement(Mockito.<Element>any(), Mockito.<Schema>any())).thenReturn(edge);

    HashSet<String> stringSet2 = new HashSet<>();
    stringSet2.add("Adding elements in batches, batch size = {}");
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
    Void actualDoOperationResult = addElementsHandler.doOperation(addElements, context, store);

    // Assert
    verify(edge).emptyClone();
    verify(edge, atLeast(1)).getGroup();
    verify(edge).getProperty(eq("42"));
    verify(schema).getGroups();
    verify(store).getMapImpl();
    verify(store).getProperties();
    verify(mapStoreProperties).getIngestBufferSize();
    verify(mapImpl).addAggElement(isA(Element.class), isA(GroupedProperties.class));
    verify(mapImpl).addIndex(isA(EdgeSeed.class), isA(Element.class));
    verify(mapImpl, atLeast(1)).addIndex(Mockito.<EntitySeed>any(), isA(Element.class));
    verify(mapImpl).cloneElement(isA(Element.class), isA(Schema.class));
    verify(mapImpl, atLeast(1)).getGroupByProperties(eq("Group"));
    verify(mapImpl, atLeast(1)).getNonGroupByProperties(eq("Group"));
    verify(mapImpl).isAggregationEnabled(isA(Element.class));
    verify(mapImpl).isMaintainIndex();
    verify(addElements).getInput();
    verify(addElements).isSkipInvalidElements();
    verify(addElements).isValidate();
    verify(store, atLeast(1)).getSchema();
    verify(schema).getAggregatedGroups();
    verify(schema, atLeast(1)).getElement(eq("Adding elements in batches, batch size = {}"));
    verify(schema, atLeast(1)).getVisibilityProperty();
    assertNull(actualDoOperationResult);
  }

  /**
   * Test {@link AddElementsHandler#doOperation(AddElements, Context, Store)} with {@code AddElements}, {@code Context}, {@code Store}.
   * <ul>
   *   <li>When {@link AddElements} {@link AddElements#isValidate()} return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AddElementsHandler#doOperation(AddElements, Context, Store)}
   */
  @Test
  @DisplayName("Test doOperation(AddElements, Context, Store) with 'AddElements', 'Context', 'Store'; when AddElements isValidate() return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Void AddElementsHandler.doOperation(AddElements, Context, Store)"})
  void testDoOperationWithAddElementsContextStore_whenAddElementsIsValidateReturnFalse() throws OperationException {
    // Arrange
    AddElementsHandler addElementsHandler = new AddElementsHandler();
    AddElements addElements = mock(AddElements.class);
    when(addElements.isValidate()).thenReturn(false);
    Mockito.<Iterable<? extends Element>>when(addElements.getInput()).thenReturn(new ArrayList<>());
    Context context = new Context();
    MapStoreProperties mapStoreProperties = mock(MapStoreProperties.class);
    when(mapStoreProperties.getIngestBufferSize()).thenReturn(3);
    MapStore store = mock(MapStore.class);
    when(store.getProperties()).thenReturn(mapStoreProperties);
    Schema schema = new Schema();
    when(store.getMapImpl()).thenReturn(new MapImpl(schema, new MapStoreProperties()));
    when(store.getSchema()).thenReturn(new Schema());

    // Act
    Void actualDoOperationResult = addElementsHandler.doOperation(addElements, context, store);

    // Assert
    verify(store).getMapImpl();
    verify(store).getProperties();
    verify(mapStoreProperties).getIngestBufferSize();
    verify(addElements).getInput();
    verify(addElements).isValidate();
    verify(store).getSchema();
    assertNull(actualDoOperationResult);
  }

  /**
   * Test {@link AddElementsHandler#doOperation(AddElements, Context, Store)} with {@code AddElements}, {@code Context}, {@code Store}.
   * <ul>
   *   <li>When {@link AddElements} {@link AddElements#isValidate()} return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AddElementsHandler#doOperation(AddElements, Context, Store)}
   */
  @Test
  @DisplayName("Test doOperation(AddElements, Context, Store) with 'AddElements', 'Context', 'Store'; when AddElements isValidate() return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Void AddElementsHandler.doOperation(AddElements, Context, Store)"})
  void testDoOperationWithAddElementsContextStore_whenAddElementsIsValidateReturnFalse2() throws OperationException {
    // Arrange
    AddElementsHandler addElementsHandler = new AddElementsHandler();

    ArrayList<Element> elementList = new ArrayList<>();
    elementList.add(new Edge("Adding elements in batches, batch size = {}"));
    AddElements addElements = mock(AddElements.class);
    when(addElements.isValidate()).thenReturn(false);
    Mockito.<Iterable<? extends Element>>when(addElements.getInput()).thenReturn(elementList);
    Context context = new Context();
    MapStoreProperties mapStoreProperties = mock(MapStoreProperties.class);
    when(mapStoreProperties.getIngestBufferSize()).thenReturn(3);
    MapStore store = mock(MapStore.class);
    when(store.getProperties()).thenReturn(mapStoreProperties);
    Schema schema = new Schema();
    when(store.getMapImpl()).thenReturn(new MapImpl(schema, new MapStoreProperties()));
    when(store.getSchema()).thenReturn(new Schema());

    // Act
    Void actualDoOperationResult = addElementsHandler.doOperation(addElements, context, store);

    // Assert
    verify(store).getMapImpl();
    verify(store).getProperties();
    verify(mapStoreProperties).getIngestBufferSize();
    verify(addElements).getInput();
    verify(addElements).isValidate();
    verify(store).getSchema();
    assertNull(actualDoOperationResult);
  }

  /**
   * Test {@link AddElementsHandler#doOperation(AddElements, Context, Store)} with {@code AddElements}, {@code Context}, {@code Store}.
   * <ul>
   *   <li>When {@link AddElements} {@link AddElements#isValidate()} return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AddElementsHandler#doOperation(AddElements, Context, Store)}
   */
  @Test
  @DisplayName("Test doOperation(AddElements, Context, Store) with 'AddElements', 'Context', 'Store'; when AddElements isValidate() return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Void AddElementsHandler.doOperation(AddElements, Context, Store)"})
  void testDoOperationWithAddElementsContextStore_whenAddElementsIsValidateReturnFalse3() throws OperationException {
    // Arrange
    AddElementsHandler addElementsHandler = new AddElementsHandler();

    ArrayList<Element> elementList = new ArrayList<>();
    elementList.add(new Edge("Adding elements in batches, batch size = {}"));
    elementList.add(new Edge("Adding elements in batches, batch size = {}"));
    AddElements addElements = mock(AddElements.class);
    when(addElements.isValidate()).thenReturn(false);
    Mockito.<Iterable<? extends Element>>when(addElements.getInput()).thenReturn(elementList);
    Context context = new Context();
    MapStoreProperties mapStoreProperties = mock(MapStoreProperties.class);
    when(mapStoreProperties.getIngestBufferSize()).thenReturn(3);
    MapStore store = mock(MapStore.class);
    when(store.getProperties()).thenReturn(mapStoreProperties);
    Schema schema = new Schema();
    when(store.getMapImpl()).thenReturn(new MapImpl(schema, new MapStoreProperties()));
    when(store.getSchema()).thenReturn(new Schema());

    // Act
    Void actualDoOperationResult = addElementsHandler.doOperation(addElements, context, store);

    // Assert
    verify(store).getMapImpl();
    verify(store).getProperties();
    verify(mapStoreProperties).getIngestBufferSize();
    verify(addElements).getInput();
    verify(addElements).isValidate();
    verify(store).getSchema();
    assertNull(actualDoOperationResult);
  }

  /**
   * Test {@link AddElementsHandler#doOperation(AddElements, Context, Store)} with {@code AddElements}, {@code Context}, {@code Store}.
   * <ul>
   *   <li>When {@link AddElements} {@link AddElements#isValidate()} return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AddElementsHandler#doOperation(AddElements, Context, Store)}
   */
  @Test
  @DisplayName("Test doOperation(AddElements, Context, Store) with 'AddElements', 'Context', 'Store'; when AddElements isValidate() return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Void AddElementsHandler.doOperation(AddElements, Context, Store)"})
  void testDoOperationWithAddElementsContextStore_whenAddElementsIsValidateReturnFalse4() throws OperationException {
    // Arrange
    AddElementsHandler addElementsHandler = new AddElementsHandler();

    ArrayList<Element> elementList = new ArrayList<>();
    elementList.add(new Edge("Adding elements in batches, batch size = {}"));
    elementList.add(new Edge("Adding elements in batches, batch size = {}"));
    elementList.add(new Edge("Adding elements in batches, batch size = {}"));
    AddElements addElements = mock(AddElements.class);
    when(addElements.isValidate()).thenReturn(false);
    Mockito.<Iterable<? extends Element>>when(addElements.getInput()).thenReturn(elementList);
    Context context = new Context();
    MapStoreProperties mapStoreProperties = mock(MapStoreProperties.class);
    when(mapStoreProperties.getIngestBufferSize()).thenReturn(3);
    MapStore store = mock(MapStore.class);
    when(store.getProperties()).thenReturn(mapStoreProperties);
    Schema schema = new Schema();
    when(store.getMapImpl()).thenReturn(new MapImpl(schema, new MapStoreProperties()));
    when(store.getSchema()).thenReturn(new Schema());

    // Act
    Void actualDoOperationResult = addElementsHandler.doOperation(addElements, context, store);

    // Assert
    verify(store).getMapImpl();
    verify(store).getProperties();
    verify(mapStoreProperties).getIngestBufferSize();
    verify(addElements).getInput();
    verify(addElements).isValidate();
    verify(store).getSchema();
    assertNull(actualDoOperationResult);
  }
}
