/*
 * Copyright 2026 Crown Copyright
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
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
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
import uk.gov.gchq.gaffer.operation.OperationException;
import uk.gov.gchq.gaffer.operation.impl.add.AddElements;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.Store;
import uk.gov.gchq.gaffer.store.schema.Schema;
import uk.gov.gchq.gaffer.store.schema.SchemaEdgeDefinition;
import uk.gov.gchq.gaffer.store.schema.SchemaElementDefinition;

class AddElementsHandlerDiffblueTest {
  /**
   * Test {@link AddElementsHandler#doOperation(AddElements, Context, Store)} with {@code
   * AddElements}, {@code Context}, {@code Store}.
   *
   * <p>Method under test: {@link AddElementsHandler#doOperation(AddElements, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(AddElements, Context, Store) with 'AddElements', 'Context', 'Store'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Void AddElementsHandler.doOperation(AddElements, Context, Store)"})
  void testDoOperationWithAddElementsContextStore() throws OperationException {
    // Arrange
    AddElementsHandler addElementsHandler = new AddElementsHandler();

    ArrayList<Element> elementList = new ArrayList<>();
    elementList.add(
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build());

    AddElements addElements = mock(AddElements.class);
    when(addElements.isSkipInvalidElements()).thenReturn(true);
    when(addElements.isValidate()).thenReturn(true);
    Mockito.<Iterable<? extends Element>>when(addElements.getInput()).thenReturn(elementList);
    Context context = new Context();

    MapStoreProperties mapStoreProperties = mock(MapStoreProperties.class);
    when(mapStoreProperties.getIngestBufferSize()).thenReturn(1);

    Schema schema = mock(Schema.class);
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.getGroups()).thenReturn(new HashSet<>());
    when(schema.getElement(Mockito.<String>any())).thenReturn(new SchemaEdgeDefinition());

    MapStore store = mock(MapStore.class);
    when(store.getProperties()).thenReturn(mapStoreProperties);
    Schema schema2 = new Schema();
    MapImpl mapImpl = new MapImpl(schema2, new MapStoreProperties());
    when(store.getMapImpl()).thenReturn(mapImpl);
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
    verify(schema, atLeast(1)).getElement("Group");
    assertNull(actualDoOperationResult);
  }

  /**
   * Test {@link AddElementsHandler#doOperation(AddElements, Context, Store)} with {@code
   * AddElements}, {@code Context}, {@code Store}.
   *
   * <p>Method under test: {@link AddElementsHandler#doOperation(AddElements, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(AddElements, Context, Store) with 'AddElements', 'Context', 'Store'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Void AddElementsHandler.doOperation(AddElements, Context, Store)"})
  void testDoOperationWithAddElementsContextStore2() throws OperationException {
    // Arrange
    AddElementsHandler addElementsHandler = new AddElementsHandler();

    ArrayList<Element> elementList = new ArrayList<>();
    elementList.add(
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build());
    elementList.add(
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build());

    AddElements addElements = mock(AddElements.class);
    when(addElements.isSkipInvalidElements()).thenReturn(true);
    when(addElements.isValidate()).thenReturn(true);
    Mockito.<Iterable<? extends Element>>when(addElements.getInput()).thenReturn(elementList);
    Context context = new Context();

    MapStoreProperties mapStoreProperties = mock(MapStoreProperties.class);
    when(mapStoreProperties.getIngestBufferSize()).thenReturn(1);

    Schema schema = mock(Schema.class);
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.getGroups()).thenReturn(new HashSet<>());
    when(schema.getElement(Mockito.<String>any())).thenReturn(new SchemaEdgeDefinition());

    MapStore store = mock(MapStore.class);
    when(store.getProperties()).thenReturn(mapStoreProperties);
    Schema schema2 = new Schema();
    MapImpl mapImpl = new MapImpl(schema2, new MapStoreProperties());
    when(store.getMapImpl()).thenReturn(mapImpl);
    when(store.getSchema()).thenReturn(schema);

    // Act
    Void actualDoOperationResult = addElementsHandler.doOperation(addElements, context, store);

    // Assert
    verify(schema, atLeast(1)).getGroups();
    verify(store).getMapImpl();
    verify(store).getProperties();
    verify(mapStoreProperties).getIngestBufferSize();
    verify(addElements).getInput();
    verify(addElements).isSkipInvalidElements();
    verify(addElements).isValidate();
    verify(store, atLeast(1)).getSchema();
    verify(schema, atLeast(1)).getAggregatedGroups();
    verify(schema, atLeast(1)).getElement("Group");
    assertNull(actualDoOperationResult);
  }

  /**
   * Test {@link AddElementsHandler#doOperation(AddElements, Context, Store)} with {@code
   * AddElements}, {@code Context}, {@code Store}.
   *
   * <p>Method under test: {@link AddElementsHandler#doOperation(AddElements, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(AddElements, Context, Store) with 'AddElements', 'Context', 'Store'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Void AddElementsHandler.doOperation(AddElements, Context, Store)"})
  void testDoOperationWithAddElementsContextStore3() throws OperationException {
    // Arrange
    AddElementsHandler addElementsHandler = new AddElementsHandler();

    ArrayList<Element> elementList = new ArrayList<>();
    elementList.add(
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build());

    AddElements addElements = mock(AddElements.class);
    when(addElements.isSkipInvalidElements()).thenReturn(true);
    when(addElements.isValidate()).thenReturn(true);
    Mockito.<Iterable<? extends Element>>when(addElements.getInput()).thenReturn(elementList);
    Context context = new Context();

    MapStoreProperties mapStoreProperties = mock(MapStoreProperties.class);
    when(mapStoreProperties.getIngestBufferSize()).thenReturn(1);

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("Adding elements in batches, batch size = {}");

    Schema schema = mock(Schema.class);
    when(schema.getVisibilityProperty()).thenReturn("Visibility Property");
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.getGroups()).thenReturn(stringSet);
    when(schema.getElement(Mockito.<String>any())).thenReturn(new SchemaEdgeDefinition());

    MapStore store = mock(MapStore.class);
    when(store.getProperties()).thenReturn(mapStoreProperties);
    Schema schema2 = new Schema();
    MapImpl mapImpl = new MapImpl(schema2, new MapStoreProperties());
    when(store.getMapImpl()).thenReturn(mapImpl);
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
    verify(schema, atLeast(1)).getElement(Mockito.<String>any());
    verify(schema, atLeast(1)).getVisibilityProperty();
    assertNull(actualDoOperationResult);
  }

  /**
   * Test {@link AddElementsHandler#doOperation(AddElements, Context, Store)} with {@code
   * AddElements}, {@code Context}, {@code Store}.
   *
   * <p>Method under test: {@link AddElementsHandler#doOperation(AddElements, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(AddElements, Context, Store) with 'AddElements', 'Context', 'Store'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Void AddElementsHandler.doOperation(AddElements, Context, Store)"})
  void testDoOperationWithAddElementsContextStore4() throws OperationException {
    // Arrange
    AddElementsHandler addElementsHandler = new AddElementsHandler();

    ArrayList<Element> elementList = new ArrayList<>();
    elementList.add(
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build());

    AddElements addElements = mock(AddElements.class);
    when(addElements.isSkipInvalidElements()).thenReturn(true);
    when(addElements.isValidate()).thenReturn(true);
    Mockito.<Iterable<? extends Element>>when(addElements.getInput()).thenReturn(elementList);
    Context context = new Context();

    MapStoreProperties mapStoreProperties = mock(MapStoreProperties.class);
    when(mapStoreProperties.getIngestBufferSize()).thenReturn(1);

    SchemaElementDefinition schemaElementDefinition = mock(SchemaElementDefinition.class);
    when(schemaElementDefinition.containsProperty(Mockito.<String>any())).thenReturn(true);
    when(schemaElementDefinition.getGroupBy()).thenReturn(new HashSet<>());
    when(schemaElementDefinition.getValidator(anyBoolean()))
        .thenReturn(new ElementFilter.Builder().build());

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("Adding elements in batches, batch size = {}");

    Schema schema = mock(Schema.class);
    when(schema.getVisibilityProperty()).thenReturn("Visibility Property");
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.getGroups()).thenReturn(stringSet);
    when(schema.getElement(Mockito.<String>any())).thenReturn(schemaElementDefinition);

    MapStore store = mock(MapStore.class);
    when(store.getProperties()).thenReturn(mapStoreProperties);
    Schema schema2 = new Schema();
    MapImpl mapImpl = new MapImpl(schema2, new MapStoreProperties());
    when(store.getMapImpl()).thenReturn(mapImpl);
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
    verify(schema, atLeast(1)).getElement(Mockito.<String>any());
    verify(schema, atLeast(1)).getVisibilityProperty();
    verify(schemaElementDefinition).containsProperty("Visibility Property");
    verify(schemaElementDefinition).getGroupBy();
    verify(schemaElementDefinition).getValidator(true);
    assertNull(actualDoOperationResult);
  }

  /**
   * Test {@link AddElementsHandler#doOperation(AddElements, Context, Store)} with {@code
   * AddElements}, {@code Context}, {@code Store}.
   *
   * <p>Method under test: {@link AddElementsHandler#doOperation(AddElements, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(AddElements, Context, Store) with 'AddElements', 'Context', 'Store'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Void AddElementsHandler.doOperation(AddElements, Context, Store)"})
  void testDoOperationWithAddElementsContextStore5() throws OperationException {
    // Arrange
    AddElementsHandler addElementsHandler = new AddElementsHandler();

    ArrayList<Element> elementList = new ArrayList<>();

    Builder builder = new Builder();
    elementList.add(
        builder
            .dest(new Schema())
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build());

    AddElements addElements = mock(AddElements.class);
    when(addElements.isSkipInvalidElements()).thenReturn(true);
    when(addElements.isValidate()).thenReturn(true);
    Mockito.<Iterable<? extends Element>>when(addElements.getInput()).thenReturn(elementList);
    Context context = new Context();

    MapStoreProperties mapStoreProperties = mock(MapStoreProperties.class);
    when(mapStoreProperties.getIngestBufferSize()).thenReturn(1);

    SchemaElementDefinition schemaElementDefinition = mock(SchemaElementDefinition.class);
    when(schemaElementDefinition.containsProperty(Mockito.<String>any())).thenReturn(true);
    when(schemaElementDefinition.getGroupBy()).thenReturn(new HashSet<>());
    when(schemaElementDefinition.getValidator(anyBoolean()))
        .thenReturn(new ElementFilter.Builder().build());

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("Adding elements in batches, batch size = {}");

    Schema schema = mock(Schema.class);
    when(schema.getVisibilityProperty()).thenReturn("Visibility Property");
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.getGroups()).thenReturn(stringSet);
    when(schema.getElement(Mockito.<String>any())).thenReturn(schemaElementDefinition);

    MapStore store = mock(MapStore.class);
    when(store.getProperties()).thenReturn(mapStoreProperties);
    Schema schema2 = new Schema();
    MapImpl mapImpl = new MapImpl(schema2, new MapStoreProperties());
    when(store.getMapImpl()).thenReturn(mapImpl);
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
    verify(schema, atLeast(1)).getElement(Mockito.<String>any());
    verify(schema, atLeast(1)).getVisibilityProperty();
    verify(schemaElementDefinition).containsProperty("Visibility Property");
    verify(schemaElementDefinition).getGroupBy();
    verify(schemaElementDefinition).getValidator(true);
    assertNull(actualDoOperationResult);
  }

  /**
   * Test {@link AddElementsHandler#doOperation(AddElements, Context, Store)} with {@code
   * AddElements}, {@code Context}, {@code Store}.
   *
   * <p>Method under test: {@link AddElementsHandler#doOperation(AddElements, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(AddElements, Context, Store) with 'AddElements', 'Context', 'Store'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Void AddElementsHandler.doOperation(AddElements, Context, Store)"})
  void testDoOperationWithAddElementsContextStore6() throws OperationException {
    // Arrange
    AddElementsHandler addElementsHandler = new AddElementsHandler();

    ArrayList<Element> elementList = new ArrayList<>();
    elementList.add(
        new Builder()
            .dest(null)
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build());

    AddElements addElements = mock(AddElements.class);
    when(addElements.isSkipInvalidElements()).thenReturn(true);
    when(addElements.isValidate()).thenReturn(true);
    Mockito.<Iterable<? extends Element>>when(addElements.getInput()).thenReturn(elementList);
    Context context = new Context();

    MapStoreProperties mapStoreProperties = mock(MapStoreProperties.class);
    when(mapStoreProperties.getIngestBufferSize()).thenReturn(1);

    SchemaElementDefinition schemaElementDefinition = mock(SchemaElementDefinition.class);
    when(schemaElementDefinition.containsProperty(Mockito.<String>any())).thenReturn(true);
    when(schemaElementDefinition.getGroupBy()).thenReturn(new HashSet<>());
    when(schemaElementDefinition.getValidator(anyBoolean()))
        .thenReturn(new ElementFilter.Builder().build());

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("Adding elements in batches, batch size = {}");

    Schema schema = mock(Schema.class);
    when(schema.getVisibilityProperty()).thenReturn("Visibility Property");
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.getGroups()).thenReturn(stringSet);
    when(schema.getElement(Mockito.<String>any())).thenReturn(schemaElementDefinition);

    MapStore store = mock(MapStore.class);
    when(store.getProperties()).thenReturn(mapStoreProperties);
    Schema schema2 = new Schema();
    MapImpl mapImpl = new MapImpl(schema2, new MapStoreProperties());
    when(store.getMapImpl()).thenReturn(mapImpl);
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
    verify(schema, atLeast(1)).getElement(Mockito.<String>any());
    verify(schema, atLeast(1)).getVisibilityProperty();
    verify(schemaElementDefinition).containsProperty("Visibility Property");
    verify(schemaElementDefinition).getGroupBy();
    verify(schemaElementDefinition).getValidator(true);
    assertNull(actualDoOperationResult);
  }

  /**
   * Test {@link AddElementsHandler#doOperation(AddElements, Context, Store)} with {@code
   * AddElements}, {@code Context}, {@code Store}.
   *
   * <p>Method under test: {@link AddElementsHandler#doOperation(AddElements, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(AddElements, Context, Store) with 'AddElements', 'Context', 'Store'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Void AddElementsHandler.doOperation(AddElements, Context, Store)"})
  void testDoOperationWithAddElementsContextStore7() throws OperationException {
    // Arrange
    AddElementsHandler addElementsHandler = new AddElementsHandler();

    ArrayList<Element> elementList = new ArrayList<>();

    Builder builder = new Builder();
    elementList.add(
        builder
            .dest(new MapStoreProperties())
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build());

    AddElements addElements = mock(AddElements.class);
    when(addElements.isSkipInvalidElements()).thenReturn(true);
    when(addElements.isValidate()).thenReturn(true);
    Mockito.<Iterable<? extends Element>>when(addElements.getInput()).thenReturn(elementList);
    Context context = new Context();

    MapStoreProperties mapStoreProperties = mock(MapStoreProperties.class);
    when(mapStoreProperties.getIngestBufferSize()).thenReturn(1);

    SchemaElementDefinition schemaElementDefinition = mock(SchemaElementDefinition.class);
    when(schemaElementDefinition.containsProperty(Mockito.<String>any())).thenReturn(true);
    when(schemaElementDefinition.getGroupBy()).thenReturn(new HashSet<>());
    when(schemaElementDefinition.getValidator(anyBoolean()))
        .thenReturn(new ElementFilter.Builder().build());

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("Adding elements in batches, batch size = {}");

    Schema schema = mock(Schema.class);
    when(schema.getVisibilityProperty()).thenReturn("Visibility Property");
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.getGroups()).thenReturn(stringSet);
    when(schema.getElement(Mockito.<String>any())).thenReturn(schemaElementDefinition);

    MapStore store = mock(MapStore.class);
    when(store.getProperties()).thenReturn(mapStoreProperties);
    Schema schema2 = new Schema();
    MapImpl mapImpl = new MapImpl(schema2, new MapStoreProperties());
    when(store.getMapImpl()).thenReturn(mapImpl);
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
    verify(schema, atLeast(1)).getElement(Mockito.<String>any());
    verify(schema, atLeast(1)).getVisibilityProperty();
    verify(schemaElementDefinition).containsProperty("Visibility Property");
    verify(schemaElementDefinition).getGroupBy();
    verify(schemaElementDefinition).getValidator(true);
    assertNull(actualDoOperationResult);
  }

  /**
   * Test {@link AddElementsHandler#doOperation(AddElements, Context, Store)} with {@code
   * AddElements}, {@code Context}, {@code Store}.
   *
   * <p>Method under test: {@link AddElementsHandler#doOperation(AddElements, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(AddElements, Context, Store) with 'AddElements', 'Context', 'Store'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Void AddElementsHandler.doOperation(AddElements, Context, Store)"})
  void testDoOperationWithAddElementsContextStore8() throws OperationException {
    // Arrange
    AddElementsHandler addElementsHandler = new AddElementsHandler();

    ArrayList<Element> elementList = new ArrayList<>();

    Builder builder = new Builder();
    elementList.add(
        builder
            .dest(
                new Builder()
                    .dest("Dest")
                    .directed(true)
                    .group("Group")
                    .matchedVertex(MatchedVertex.SOURCE)
                    .source("Source")
                    .build())
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build());

    AddElements addElements = mock(AddElements.class);
    when(addElements.isSkipInvalidElements()).thenReturn(true);
    when(addElements.isValidate()).thenReturn(true);
    Mockito.<Iterable<? extends Element>>when(addElements.getInput()).thenReturn(elementList);
    Context context = new Context();

    MapStoreProperties mapStoreProperties = mock(MapStoreProperties.class);
    when(mapStoreProperties.getIngestBufferSize()).thenReturn(1);

    SchemaElementDefinition schemaElementDefinition = mock(SchemaElementDefinition.class);
    when(schemaElementDefinition.containsProperty(Mockito.<String>any())).thenReturn(true);
    when(schemaElementDefinition.getGroupBy()).thenReturn(new HashSet<>());
    when(schemaElementDefinition.getValidator(anyBoolean()))
        .thenReturn(new ElementFilter.Builder().build());

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("Adding elements in batches, batch size = {}");

    Schema schema = mock(Schema.class);
    when(schema.getVisibilityProperty()).thenReturn("Visibility Property");
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.getGroups()).thenReturn(stringSet);
    when(schema.getElement(Mockito.<String>any())).thenReturn(schemaElementDefinition);

    MapStore store = mock(MapStore.class);
    when(store.getProperties()).thenReturn(mapStoreProperties);
    Schema schema2 = new Schema();
    MapImpl mapImpl = new MapImpl(schema2, new MapStoreProperties());
    when(store.getMapImpl()).thenReturn(mapImpl);
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
    verify(schema, atLeast(1)).getElement(Mockito.<String>any());
    verify(schema, atLeast(1)).getVisibilityProperty();
    verify(schemaElementDefinition).containsProperty("Visibility Property");
    verify(schemaElementDefinition).getGroupBy();
    verify(schemaElementDefinition).getValidator(true);
    assertNull(actualDoOperationResult);
  }

  /**
   * Test {@link AddElementsHandler#doOperation(AddElements, Context, Store)} with {@code
   * AddElements}, {@code Context}, {@code Store}.
   *
   * <p>Method under test: {@link AddElementsHandler#doOperation(AddElements, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(AddElements, Context, Store) with 'AddElements', 'Context', 'Store'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Void AddElementsHandler.doOperation(AddElements, Context, Store)"})
  void testDoOperationWithAddElementsContextStore9() throws OperationException {
    // Arrange
    AddElementsHandler addElementsHandler = new AddElementsHandler();

    ArrayList<Element> elementList = new ArrayList<>();

    Builder builder = new Builder();
    elementList.add(
        builder
            .dest(new Edge("Adding elements in batches, batch size = {}"))
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build());

    AddElements addElements = mock(AddElements.class);
    when(addElements.isSkipInvalidElements()).thenReturn(true);
    when(addElements.isValidate()).thenReturn(true);
    Mockito.<Iterable<? extends Element>>when(addElements.getInput()).thenReturn(elementList);
    Context context = new Context();

    MapStoreProperties mapStoreProperties = mock(MapStoreProperties.class);
    when(mapStoreProperties.getIngestBufferSize()).thenReturn(1);

    SchemaElementDefinition schemaElementDefinition = mock(SchemaElementDefinition.class);
    when(schemaElementDefinition.containsProperty(Mockito.<String>any())).thenReturn(true);
    when(schemaElementDefinition.getGroupBy()).thenReturn(new HashSet<>());
    when(schemaElementDefinition.getValidator(anyBoolean()))
        .thenReturn(new ElementFilter.Builder().build());

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("Adding elements in batches, batch size = {}");

    Schema schema = mock(Schema.class);
    when(schema.getVisibilityProperty()).thenReturn("Visibility Property");
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.getGroups()).thenReturn(stringSet);
    when(schema.getElement(Mockito.<String>any())).thenReturn(schemaElementDefinition);

    MapStore store = mock(MapStore.class);
    when(store.getProperties()).thenReturn(mapStoreProperties);
    Schema schema2 = new Schema();
    MapImpl mapImpl = new MapImpl(schema2, new MapStoreProperties());
    when(store.getMapImpl()).thenReturn(mapImpl);
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
    verify(schema, atLeast(1)).getElement(Mockito.<String>any());
    verify(schema, atLeast(1)).getVisibilityProperty();
    verify(schemaElementDefinition).containsProperty("Visibility Property");
    verify(schemaElementDefinition).getGroupBy();
    verify(schemaElementDefinition).getValidator(true);
    assertNull(actualDoOperationResult);
  }

  /**
   * Test {@link AddElementsHandler#doOperation(AddElements, Context, Store)} with {@code
   * AddElements}, {@code Context}, {@code Store}.
   *
   * <p>Method under test: {@link AddElementsHandler#doOperation(AddElements, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(AddElements, Context, Store) with 'AddElements', 'Context', 'Store'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Void AddElementsHandler.doOperation(AddElements, Context, Store)"})
  void testDoOperationWithAddElementsContextStore10() throws OperationException {
    // Arrange
    AddElementsHandler addElementsHandler = new AddElementsHandler();

    ArrayList<Element> elementList = new ArrayList<>();

    Builder builder = new Builder();
    elementList.add(
        builder
            .dest(new ElementFilter.Builder().build())
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build());

    AddElements addElements = mock(AddElements.class);
    when(addElements.isSkipInvalidElements()).thenReturn(true);
    when(addElements.isValidate()).thenReturn(true);
    Mockito.<Iterable<? extends Element>>when(addElements.getInput()).thenReturn(elementList);
    Context context = new Context();

    MapStoreProperties mapStoreProperties = mock(MapStoreProperties.class);
    when(mapStoreProperties.getIngestBufferSize()).thenReturn(1);

    SchemaElementDefinition schemaElementDefinition = mock(SchemaElementDefinition.class);
    when(schemaElementDefinition.containsProperty(Mockito.<String>any())).thenReturn(true);
    when(schemaElementDefinition.getGroupBy()).thenReturn(new HashSet<>());
    when(schemaElementDefinition.getValidator(anyBoolean()))
        .thenReturn(new ElementFilter.Builder().build());

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("Adding elements in batches, batch size = {}");

    Schema schema = mock(Schema.class);
    when(schema.getVisibilityProperty()).thenReturn("Visibility Property");
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.getGroups()).thenReturn(stringSet);
    when(schema.getElement(Mockito.<String>any())).thenReturn(schemaElementDefinition);

    MapStore store = mock(MapStore.class);
    when(store.getProperties()).thenReturn(mapStoreProperties);
    Schema schema2 = new Schema();
    MapImpl mapImpl = new MapImpl(schema2, new MapStoreProperties());
    when(store.getMapImpl()).thenReturn(mapImpl);
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
    verify(schema, atLeast(1)).getElement(Mockito.<String>any());
    verify(schema, atLeast(1)).getVisibilityProperty();
    verify(schemaElementDefinition).containsProperty("Visibility Property");
    verify(schemaElementDefinition).getGroupBy();
    verify(schemaElementDefinition).getValidator(true);
    assertNull(actualDoOperationResult);
  }

  /**
   * Test {@link AddElementsHandler#doOperation(AddElements, Context, Store)} with {@code
   * AddElements}, {@code Context}, {@code Store}.
   *
   * <p>Method under test: {@link AddElementsHandler#doOperation(AddElements, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(AddElements, Context, Store) with 'AddElements', 'Context', 'Store'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Void AddElementsHandler.doOperation(AddElements, Context, Store)"})
  void testDoOperationWithAddElementsContextStore11() throws OperationException {
    // Arrange
    AddElementsHandler addElementsHandler = new AddElementsHandler();

    ArrayList<Element> elementList = new ArrayList<>();
    elementList.add(
        new Builder()
            .dest("Dest")
            .directed(false)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build());

    AddElements addElements = mock(AddElements.class);
    when(addElements.isSkipInvalidElements()).thenReturn(true);
    when(addElements.isValidate()).thenReturn(true);
    Mockito.<Iterable<? extends Element>>when(addElements.getInput()).thenReturn(elementList);
    Context context = new Context();

    MapStoreProperties mapStoreProperties = mock(MapStoreProperties.class);
    when(mapStoreProperties.getIngestBufferSize()).thenReturn(1);

    SchemaElementDefinition schemaElementDefinition = mock(SchemaElementDefinition.class);
    when(schemaElementDefinition.containsProperty(Mockito.<String>any())).thenReturn(true);
    when(schemaElementDefinition.getGroupBy()).thenReturn(new HashSet<>());
    when(schemaElementDefinition.getValidator(anyBoolean()))
        .thenReturn(new ElementFilter.Builder().build());

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("Adding elements in batches, batch size = {}");

    Schema schema = mock(Schema.class);
    when(schema.getVisibilityProperty()).thenReturn("Visibility Property");
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.getGroups()).thenReturn(stringSet);
    when(schema.getElement(Mockito.<String>any())).thenReturn(schemaElementDefinition);

    MapStore store = mock(MapStore.class);
    when(store.getProperties()).thenReturn(mapStoreProperties);
    Schema schema2 = new Schema();
    MapImpl mapImpl = new MapImpl(schema2, new MapStoreProperties());
    when(store.getMapImpl()).thenReturn(mapImpl);
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
    verify(schema, atLeast(1)).getElement(Mockito.<String>any());
    verify(schema, atLeast(1)).getVisibilityProperty();
    verify(schemaElementDefinition).containsProperty("Visibility Property");
    verify(schemaElementDefinition).getGroupBy();
    verify(schemaElementDefinition).getValidator(true);
    assertNull(actualDoOperationResult);
  }

  /**
   * Test {@link AddElementsHandler#doOperation(AddElements, Context, Store)} with {@code
   * AddElements}, {@code Context}, {@code Store}.
   *
   * <p>Method under test: {@link AddElementsHandler#doOperation(AddElements, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(AddElements, Context, Store) with 'AddElements', 'Context', 'Store'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Void AddElementsHandler.doOperation(AddElements, Context, Store)"})
  void testDoOperationWithAddElementsContextStore12() throws OperationException {
    // Arrange
    AddElementsHandler addElementsHandler = new AddElementsHandler();

    ArrayList<Element> elementList = new ArrayList<>();
    elementList.add(
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build());

    AddElements addElements = mock(AddElements.class);
    when(addElements.isSkipInvalidElements()).thenReturn(true);
    when(addElements.isValidate()).thenReturn(true);
    Mockito.<Iterable<? extends Element>>when(addElements.getInput()).thenReturn(elementList);
    Context context = new Context();

    MapStoreProperties mapStoreProperties = mock(MapStoreProperties.class);
    when(mapStoreProperties.getIngestBufferSize()).thenReturn(14);

    SchemaElementDefinition schemaElementDefinition = mock(SchemaElementDefinition.class);
    when(schemaElementDefinition.containsProperty(Mockito.<String>any())).thenReturn(true);
    when(schemaElementDefinition.getGroupBy()).thenReturn(new HashSet<>());
    when(schemaElementDefinition.getValidator(anyBoolean()))
        .thenReturn(new ElementFilter.Builder().build());

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("Adding elements in batches, batch size = {}");

    Schema schema = mock(Schema.class);
    when(schema.getVisibilityProperty()).thenReturn("Visibility Property");
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.getGroups()).thenReturn(stringSet);
    when(schema.getElement(Mockito.<String>any())).thenReturn(schemaElementDefinition);

    MapStore store = mock(MapStore.class);
    when(store.getProperties()).thenReturn(mapStoreProperties);
    Schema schema2 = new Schema();
    MapImpl mapImpl = new MapImpl(schema2, new MapStoreProperties());
    when(store.getMapImpl()).thenReturn(mapImpl);
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
    verify(schema, atLeast(1)).getElement(Mockito.<String>any());
    verify(schema, atLeast(1)).getVisibilityProperty();
    verify(schemaElementDefinition).containsProperty("Visibility Property");
    verify(schemaElementDefinition).getGroupBy();
    verify(schemaElementDefinition).getValidator(true);
    assertNull(actualDoOperationResult);
  }

  /**
   * Test {@link AddElementsHandler#doOperation(AddElements, Context, Store)} with {@code
   * AddElements}, {@code Context}, {@code Store}.
   *
   * <p>Method under test: {@link AddElementsHandler#doOperation(AddElements, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(AddElements, Context, Store) with 'AddElements', 'Context', 'Store'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Void AddElementsHandler.doOperation(AddElements, Context, Store)"})
  void testDoOperationWithAddElementsContextStore13() throws OperationException {
    // Arrange
    AddElementsHandler addElementsHandler = new AddElementsHandler();

    ArrayList<Element> elementList = new ArrayList<>();
    elementList.add(
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build());

    AddElements addElements = mock(AddElements.class);
    when(addElements.isSkipInvalidElements()).thenReturn(true);
    when(addElements.isValidate()).thenReturn(true);
    Mockito.<Iterable<? extends Element>>when(addElements.getInput()).thenReturn(elementList);
    Context context = new Context();

    MapStoreProperties mapStoreProperties = mock(MapStoreProperties.class);
    when(mapStoreProperties.getIngestBufferSize()).thenReturn(1);

    SchemaElementDefinition schemaElementDefinition = mock(SchemaElementDefinition.class);
    when(schemaElementDefinition.containsProperty(Mockito.<String>any())).thenReturn(false);
    when(schemaElementDefinition.getGroupBy()).thenReturn(new HashSet<>());
    when(schemaElementDefinition.getValidator(anyBoolean()))
        .thenReturn(new ElementFilter.Builder().build());

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("Adding elements in batches, batch size = {}");

    Schema schema = mock(Schema.class);
    when(schema.getVisibilityProperty()).thenReturn("Visibility Property");
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.getGroups()).thenReturn(stringSet);
    when(schema.getElement(Mockito.<String>any())).thenReturn(schemaElementDefinition);

    MapStore store = mock(MapStore.class);
    when(store.getProperties()).thenReturn(mapStoreProperties);
    Schema schema2 = new Schema();
    MapImpl mapImpl = new MapImpl(schema2, new MapStoreProperties());
    when(store.getMapImpl()).thenReturn(mapImpl);
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
    verify(schema, atLeast(1)).getElement(Mockito.<String>any());
    verify(schema, atLeast(1)).getVisibilityProperty();
    verify(schemaElementDefinition).containsProperty("Visibility Property");
    verify(schemaElementDefinition).getGroupBy();
    verify(schemaElementDefinition).getValidator(true);
    assertNull(actualDoOperationResult);
  }

  /**
   * Test {@link AddElementsHandler#doOperation(AddElements, Context, Store)} with {@code
   * AddElements}, {@code Context}, {@code Store}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link AddElementsHandler#doOperation(AddElements, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(AddElements, Context, Store) with 'AddElements', 'Context', 'Store'; given ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
    when(mapStoreProperties.getIngestBufferSize()).thenReturn(1);

    MapStore store = mock(MapStore.class);
    when(store.getProperties()).thenReturn(mapStoreProperties);
    Schema schema = new Schema();
    MapImpl mapImpl = new MapImpl(schema, new MapStoreProperties());
    when(store.getMapImpl()).thenReturn(mapImpl);
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
   * Test {@link AddElementsHandler#doOperation(AddElements, Context, Store)} with {@code
   * AddElements}, {@code Context}, {@code Store}.
   *
   * <ul>
   *   <li>Given {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link AddElementsHandler#doOperation(AddElements, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(AddElements, Context, Store) with 'AddElements', 'Context', 'Store'; given 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Void AddElementsHandler.doOperation(AddElements, Context, Store)"})
  void testDoOperationWithAddElementsContextStore_givenFalse() throws OperationException {
    // Arrange
    AddElementsHandler addElementsHandler = new AddElementsHandler();

    AddElements addElements = mock(AddElements.class);
    when(addElements.isValidate()).thenReturn(false);
    Mockito.<Iterable<? extends Element>>when(addElements.getInput()).thenReturn(new ArrayList<>());
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
   * Test {@link AddElementsHandler#doOperation(AddElements, Context, Store)} with {@code
   * AddElements}, {@code Context}, {@code Store}.
   *
   * <ul>
   *   <li>Given {@link MapStoreProperties#MapStoreProperties()}.
   * </ul>
   *
   * <p>Method under test: {@link AddElementsHandler#doOperation(AddElements, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(AddElements, Context, Store) with 'AddElements', 'Context', 'Store'; given MapStoreProperties()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Void AddElementsHandler.doOperation(AddElements, Context, Store)"})
  void testDoOperationWithAddElementsContextStore_givenMapStoreProperties()
      throws OperationException {
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
    MapImpl mapImpl = new MapImpl(schema, new MapStoreProperties());
    when(store.getMapImpl()).thenReturn(mapImpl);
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
   * Test {@link AddElementsHandler#doOperation(AddElements, Context, Store)} with {@code
   * AddElements}, {@code Context}, {@code Store}.
   *
   * <ul>
   *   <li>Given {@link MapStoreProperties#MapStoreProperties()}.
   * </ul>
   *
   * <p>Method under test: {@link AddElementsHandler#doOperation(AddElements, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(AddElements, Context, Store) with 'AddElements', 'Context', 'Store'; given MapStoreProperties()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Void AddElementsHandler.doOperation(AddElements, Context, Store)"})
  void testDoOperationWithAddElementsContextStore_givenMapStoreProperties2()
      throws OperationException {
    // Arrange
    AddElementsHandler addElementsHandler = new AddElementsHandler();

    ArrayList<Element> elementList = new ArrayList<>();
    elementList.add(
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build());

    AddElements addElements = mock(AddElements.class);
    when(addElements.isSkipInvalidElements()).thenReturn(true);
    when(addElements.isValidate()).thenReturn(true);
    Mockito.<Iterable<? extends Element>>when(addElements.getInput()).thenReturn(elementList);
    Context context = new Context();

    MapStore store = mock(MapStore.class);
    when(store.getProperties()).thenReturn(new MapStoreProperties());
    Schema schema = new Schema();
    MapImpl mapImpl = new MapImpl(schema, new MapStoreProperties());
    when(store.getMapImpl()).thenReturn(mapImpl);
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
   * Test {@link AddElementsHandler#doOperation(AddElements, Context, Store)} with {@code
   * AddElements}, {@code Context}, {@code Store}.
   *
   * <ul>
   *   <li>Given {@link MapStoreProperties#MapStoreProperties()}.
   * </ul>
   *
   * <p>Method under test: {@link AddElementsHandler#doOperation(AddElements, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(AddElements, Context, Store) with 'AddElements', 'Context', 'Store'; given MapStoreProperties()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Void AddElementsHandler.doOperation(AddElements, Context, Store)"})
  void testDoOperationWithAddElementsContextStore_givenMapStoreProperties3()
      throws OperationException {
    // Arrange
    AddElementsHandler addElementsHandler = new AddElementsHandler();

    ArrayList<Element> elementList = new ArrayList<>();
    elementList.add(
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build());
    elementList.add(
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build());

    AddElements addElements = mock(AddElements.class);
    when(addElements.isSkipInvalidElements()).thenReturn(true);
    when(addElements.isValidate()).thenReturn(true);
    Mockito.<Iterable<? extends Element>>when(addElements.getInput()).thenReturn(elementList);
    Context context = new Context();

    MapStore store = mock(MapStore.class);
    when(store.getProperties()).thenReturn(new MapStoreProperties());
    Schema schema = new Schema();
    MapImpl mapImpl = new MapImpl(schema, new MapStoreProperties());
    when(store.getMapImpl()).thenReturn(mapImpl);
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
   * Test {@link AddElementsHandler#doOperation(AddElements, Context, Store)} with {@code
   * AddElements}, {@code Context}, {@code Store}.
   *
   * <ul>
   *   <li>Given {@link Schema#Schema()}.
   * </ul>
   *
   * <p>Method under test: {@link AddElementsHandler#doOperation(AddElements, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(AddElements, Context, Store) with 'AddElements', 'Context', 'Store'; given Schema()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Void AddElementsHandler.doOperation(AddElements, Context, Store)"})
  void testDoOperationWithAddElementsContextStore_givenSchema() throws OperationException {
    // Arrange
    AddElementsHandler addElementsHandler = new AddElementsHandler();

    ArrayList<Element> elementList = new ArrayList<>();
    elementList.add(
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build());

    AddElements addElements = mock(AddElements.class);
    when(addElements.isSkipInvalidElements()).thenReturn(true);
    when(addElements.isValidate()).thenReturn(true);
    Mockito.<Iterable<? extends Element>>when(addElements.getInput()).thenReturn(elementList);
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
}
