package uk.gov.gchq.gaffer.mapstore.impl;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
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
import uk.gov.gchq.gaffer.data.element.GroupedProperties;
import uk.gov.gchq.gaffer.data.element.function.ElementFilter;
import uk.gov.gchq.gaffer.data.element.id.EdgeId;
import uk.gov.gchq.gaffer.data.element.id.EdgeId.MatchedVertex;
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
    when(mapStoreProperties.getIngestBufferSize()).thenReturn(14);

    MapImpl mapImpl = mock(MapImpl.class);
    when(mapImpl.getGroupByProperties(Mockito.<String>any())).thenReturn(new HashSet<>());
    when(mapImpl.getNonGroupByProperties(Mockito.<String>any())).thenReturn(new HashSet<>());
    doNothing()
        .when(mapImpl)
        .addAggElement(Mockito.<Element>any(), Mockito.<GroupedProperties>any());
    doNothing().when(mapImpl).addIndex(Mockito.<EdgeSeed>any(), Mockito.<Element>any());
    doNothing().when(mapImpl).addIndex(Mockito.<EntitySeed>any(), Mockito.<Element>any());
    when(mapImpl.isAggregationEnabled(Mockito.<Element>any())).thenReturn(true);
    when(mapImpl.isMaintainIndex()).thenReturn(true);
    when(mapImpl.cloneElement(Mockito.<Element>any(), Mockito.<Schema>any()))
        .thenReturn(
            new Builder()
                .dest("Dest")
                .directed(true)
                .group("Group")
                .matchedVertex(MatchedVertex.SOURCE)
                .source("Source")
                .build());

    SchemaEdgeDefinition schemaEdgeDefinition = mock(SchemaEdgeDefinition.class);
    when(schemaEdgeDefinition.containsProperty(Mockito.<String>any())).thenReturn(true);
    when(schemaEdgeDefinition.getGroupBy()).thenReturn(new HashSet<>());
    when(schemaEdgeDefinition.getValidator(anyBoolean()))
        .thenReturn(new ElementFilter.Builder().build());

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("Adding elements in batches, batch size = {}");

    Schema schema = mock(Schema.class);
    when(schema.getVisibilityProperty()).thenReturn("Visibility Property");
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.getGroups()).thenReturn(stringSet);
    when(schema.getElement(Mockito.<String>any())).thenReturn(schemaEdgeDefinition);

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
    verify(mapImpl, atLeast(1)).addIndex(Mockito.<EntitySeed>any(), isA(Element.class));
    verify(mapImpl).cloneElement(isA(Element.class), isA(Schema.class));
    verify(mapImpl, atLeast(1)).getGroupByProperties("Group");
    verify(mapImpl, atLeast(1)).getNonGroupByProperties("Group");
    verify(mapImpl).isAggregationEnabled(isA(Element.class));
    verify(mapImpl).isMaintainIndex();
    verify(addElements).getInput();
    verify(addElements).isSkipInvalidElements();
    verify(addElements).isValidate();
    verify(store, atLeast(1)).getSchema();
    verify(schema).getAggregatedGroups();
    verify(schema, atLeast(1)).getElement(Mockito.<String>any());
    verify(schema, atLeast(1)).getVisibilityProperty();
    verify(schemaEdgeDefinition).containsProperty("Visibility Property");
    verify(schemaEdgeDefinition).getGroupBy();
    verify(schemaEdgeDefinition).getValidator(true);
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

    MapImpl mapImpl = mock(MapImpl.class);
    when(mapImpl.isAggregationEnabled(Mockito.<Element>any())).thenReturn(false);
    when(mapImpl.isMaintainIndex()).thenReturn(false);
    doNothing().when(mapImpl).addNonAggElement(Mockito.<Element>any());
    when(mapImpl.cloneElement(Mockito.<Element>any(), Mockito.<Schema>any()))
        .thenReturn(
            new Builder()
                .dest("Dest")
                .directed(true)
                .group("Group")
                .matchedVertex(MatchedVertex.SOURCE)
                .source("Source")
                .build());

    SchemaEdgeDefinition schemaEdgeDefinition = mock(SchemaEdgeDefinition.class);
    when(schemaEdgeDefinition.getProperties()).thenReturn(new HashSet<>());
    when(schemaEdgeDefinition.containsProperty(Mockito.<String>any())).thenReturn(true);
    when(schemaEdgeDefinition.getGroupBy()).thenReturn(new HashSet<>());
    when(schemaEdgeDefinition.getValidator(anyBoolean()))
        .thenReturn(new ElementFilter.Builder().build());

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("Adding elements in batches, batch size = {}");

    Schema schema = mock(Schema.class);
    when(schema.getVisibilityProperty()).thenReturn("Visibility Property");
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.getGroups()).thenReturn(stringSet);
    when(schema.getElement(Mockito.<String>any())).thenReturn(schemaEdgeDefinition);

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
    verify(schema, atLeast(1)).getVisibilityProperty();
    verify(schemaEdgeDefinition).containsProperty("Visibility Property");
    verify(schemaEdgeDefinition).getGroupBy();
    verify(schemaEdgeDefinition).getProperties();
    verify(schemaEdgeDefinition).getValidator(true);
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

    MapImpl mapImpl = mock(MapImpl.class);
    doNothing().when(mapImpl).addIndex(Mockito.<EdgeSeed>any(), Mockito.<Element>any());
    doNothing().when(mapImpl).addIndex(Mockito.<EntitySeed>any(), Mockito.<Element>any());
    when(mapImpl.isAggregationEnabled(Mockito.<Element>any())).thenReturn(false);
    when(mapImpl.isMaintainIndex()).thenReturn(true);
    doNothing().when(mapImpl).addNonAggElement(Mockito.<Element>any());
    when(mapImpl.cloneElement(Mockito.<Element>any(), Mockito.<Schema>any()))
        .thenReturn(
            new Builder()
                .dest("Dest")
                .directed(false)
                .group("Group")
                .matchedVertex(MatchedVertex.SOURCE)
                .source("Source")
                .build());

    SchemaEdgeDefinition schemaEdgeDefinition = mock(SchemaEdgeDefinition.class);
    when(schemaEdgeDefinition.getProperties()).thenReturn(new HashSet<>());
    when(schemaEdgeDefinition.containsProperty(Mockito.<String>any())).thenReturn(true);
    when(schemaEdgeDefinition.getGroupBy()).thenReturn(new HashSet<>());
    when(schemaEdgeDefinition.getValidator(anyBoolean()))
        .thenReturn(new ElementFilter.Builder().build());

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("Adding elements in batches, batch size = {}");

    Schema schema = mock(Schema.class);
    when(schema.getVisibilityProperty()).thenReturn("Visibility Property");
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.getGroups()).thenReturn(stringSet);
    when(schema.getElement(Mockito.<String>any())).thenReturn(schemaEdgeDefinition);

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
    verify(schema, atLeast(1)).getVisibilityProperty();
    verify(schemaEdgeDefinition).containsProperty("Visibility Property");
    verify(schemaEdgeDefinition).getGroupBy();
    verify(schemaEdgeDefinition).getProperties();
    verify(schemaEdgeDefinition).getValidator(true);
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

    MapImpl mapImpl = mock(MapImpl.class);
    doNothing().when(mapImpl).addIndex(Mockito.<EdgeSeed>any(), Mockito.<Element>any());
    doNothing().when(mapImpl).addIndex(Mockito.<EntitySeed>any(), Mockito.<Element>any());
    when(mapImpl.isAggregationEnabled(Mockito.<Element>any())).thenReturn(false);
    when(mapImpl.isMaintainIndex()).thenReturn(true);
    doNothing().when(mapImpl).addNonAggElement(Mockito.<Element>any());
    when(mapImpl.cloneElement(Mockito.<Element>any(), Mockito.<Schema>any()))
        .thenReturn(
            new Builder()
                .dest("Dest")
                .directed(true)
                .group("Group")
                .matchedVertex(MatchedVertex.SOURCE)
                .source("Source")
                .build());

    SchemaEdgeDefinition schemaEdgeDefinition = mock(SchemaEdgeDefinition.class);
    when(schemaEdgeDefinition.getProperties()).thenReturn(new HashSet<>());
    when(schemaEdgeDefinition.containsProperty(Mockito.<String>any())).thenReturn(false);
    when(schemaEdgeDefinition.getGroupBy()).thenReturn(new HashSet<>());
    when(schemaEdgeDefinition.getValidator(anyBoolean()))
        .thenReturn(new ElementFilter.Builder().build());

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("Adding elements in batches, batch size = {}");

    Schema schema = mock(Schema.class);
    when(schema.getVisibilityProperty()).thenReturn("Visibility Property");
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.getGroups()).thenReturn(stringSet);
    when(schema.getElement(Mockito.<String>any())).thenReturn(schemaEdgeDefinition);

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
    verify(schema, atLeast(1)).getVisibilityProperty();
    verify(schemaEdgeDefinition).containsProperty("Visibility Property");
    verify(schemaEdgeDefinition).getGroupBy();
    verify(schemaEdgeDefinition).getProperties();
    verify(schemaEdgeDefinition).getValidator(true);
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

  /**
   * Test {@link AddElementsHandler#doOperation(AddElements, Context, Store)} with {@code
   * AddElements}, {@code Context}, {@code Store}.
   *
   * <ul>
   *   <li>Then calls {@link MapImpl#addAggElement(Element, GroupedProperties)}.
   * </ul>
   *
   * <p>Method under test: {@link AddElementsHandler#doOperation(AddElements, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(AddElements, Context, Store) with 'AddElements', 'Context', 'Store'; then calls addAggElement(Element, GroupedProperties)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Void AddElementsHandler.doOperation(AddElements, Context, Store)"})
  void testDoOperationWithAddElementsContextStore_thenCallsAddAggElement()
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

    MapStoreProperties mapStoreProperties = mock(MapStoreProperties.class);
    when(mapStoreProperties.getIngestBufferSize()).thenReturn(1);

    MapImpl mapImpl = mock(MapImpl.class);
    when(mapImpl.getGroupByProperties(Mockito.<String>any())).thenReturn(new HashSet<>());
    when(mapImpl.getNonGroupByProperties(Mockito.<String>any())).thenReturn(new HashSet<>());
    doNothing()
        .when(mapImpl)
        .addAggElement(Mockito.<Element>any(), Mockito.<GroupedProperties>any());
    doNothing().when(mapImpl).addIndex(Mockito.<EdgeSeed>any(), Mockito.<Element>any());
    doNothing().when(mapImpl).addIndex(Mockito.<EntitySeed>any(), Mockito.<Element>any());
    when(mapImpl.isAggregationEnabled(Mockito.<Element>any())).thenReturn(true);
    when(mapImpl.isMaintainIndex()).thenReturn(true);
    when(mapImpl.cloneElement(Mockito.<Element>any(), Mockito.<Schema>any()))
        .thenReturn(
            new Builder()
                .dest("Dest")
                .directed(true)
                .group("Group")
                .matchedVertex(MatchedVertex.SOURCE)
                .source("Source")
                .build());

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
    verify(mapImpl, atLeast(1)).addIndex(Mockito.<EntitySeed>any(), isA(Element.class));
    verify(mapImpl).cloneElement(isA(Element.class), isA(Schema.class));
    verify(mapImpl, atLeast(1)).getGroupByProperties("Group");
    verify(mapImpl, atLeast(1)).getNonGroupByProperties("Group");
    verify(mapImpl).isAggregationEnabled(isA(Element.class));
    verify(mapImpl).isMaintainIndex();
    verify(addElements).getInput();
    verify(addElements).isSkipInvalidElements();
    verify(addElements).isValidate();
    verify(store, atLeast(1)).getSchema();
    verify(schema).getAggregatedGroups();
    verify(schema).getElement("Group");
    assertNull(actualDoOperationResult);
  }

  /**
   * Test {@link AddElementsHandler#doOperation(AddElements, Context, Store)} with {@code
   * AddElements}, {@code Context}, {@code Store}.
   *
   * <ul>
   *   <li>Then calls {@link MapImpl#addAggElement(Element, GroupedProperties)}.
   * </ul>
   *
   * <p>Method under test: {@link AddElementsHandler#doOperation(AddElements, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(AddElements, Context, Store) with 'AddElements', 'Context', 'Store'; then calls addAggElement(Element, GroupedProperties)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Void AddElementsHandler.doOperation(AddElements, Context, Store)"})
  void testDoOperationWithAddElementsContextStore_thenCallsAddAggElement2()
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

    MapStoreProperties mapStoreProperties = mock(MapStoreProperties.class);
    when(mapStoreProperties.getIngestBufferSize()).thenReturn(1);

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("Adding elements in batches, batch size = {}");

    MapImpl mapImpl = mock(MapImpl.class);
    when(mapImpl.getGroupByProperties(Mockito.<String>any())).thenReturn(stringSet);
    when(mapImpl.getNonGroupByProperties(Mockito.<String>any())).thenReturn(new HashSet<>());
    doNothing()
        .when(mapImpl)
        .addAggElement(Mockito.<Element>any(), Mockito.<GroupedProperties>any());
    doNothing().when(mapImpl).addIndex(Mockito.<EdgeSeed>any(), Mockito.<Element>any());
    doNothing().when(mapImpl).addIndex(Mockito.<EntitySeed>any(), Mockito.<Element>any());
    when(mapImpl.isAggregationEnabled(Mockito.<Element>any())).thenReturn(true);
    when(mapImpl.isMaintainIndex()).thenReturn(true);
    when(mapImpl.cloneElement(Mockito.<Element>any(), Mockito.<Schema>any()))
        .thenReturn(
            new Builder()
                .dest("Dest")
                .directed(true)
                .group("Group")
                .matchedVertex(MatchedVertex.SOURCE)
                .source("Source")
                .build());

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
    verify(mapImpl, atLeast(1)).addIndex(Mockito.<EntitySeed>any(), isA(Element.class));
    verify(mapImpl).cloneElement(isA(Element.class), isA(Schema.class));
    verify(mapImpl, atLeast(1)).getGroupByProperties("Group");
    verify(mapImpl, atLeast(1)).getNonGroupByProperties("Group");
    verify(mapImpl).isAggregationEnabled(isA(Element.class));
    verify(mapImpl).isMaintainIndex();
    verify(addElements).getInput();
    verify(addElements).isSkipInvalidElements();
    verify(addElements).isValidate();
    verify(store, atLeast(1)).getSchema();
    verify(schema).getAggregatedGroups();
    verify(schema).getElement("Group");
    assertNull(actualDoOperationResult);
  }

  /**
   * Test {@link AddElementsHandler#doOperation(AddElements, Context, Store)} with {@code
   * AddElements}, {@code Context}, {@code Store}.
   *
   * <ul>
   *   <li>Then calls {@link MapImpl#addAggElement(Element, GroupedProperties)}.
   * </ul>
   *
   * <p>Method under test: {@link AddElementsHandler#doOperation(AddElements, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(AddElements, Context, Store) with 'AddElements', 'Context', 'Store'; then calls addAggElement(Element, GroupedProperties)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Void AddElementsHandler.doOperation(AddElements, Context, Store)"})
  void testDoOperationWithAddElementsContextStore_thenCallsAddAggElement3()
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

    MapStoreProperties mapStoreProperties = mock(MapStoreProperties.class);
    when(mapStoreProperties.getIngestBufferSize()).thenReturn(1);

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("Adding elements in batches, batch size = {}");

    MapImpl mapImpl = mock(MapImpl.class);
    when(mapImpl.getGroupByProperties(Mockito.<String>any())).thenReturn(new HashSet<>());
    when(mapImpl.getNonGroupByProperties(Mockito.<String>any())).thenReturn(stringSet);
    doNothing()
        .when(mapImpl)
        .addAggElement(Mockito.<Element>any(), Mockito.<GroupedProperties>any());
    doNothing().when(mapImpl).addIndex(Mockito.<EdgeSeed>any(), Mockito.<Element>any());
    doNothing().when(mapImpl).addIndex(Mockito.<EntitySeed>any(), Mockito.<Element>any());
    when(mapImpl.isAggregationEnabled(Mockito.<Element>any())).thenReturn(true);
    when(mapImpl.isMaintainIndex()).thenReturn(true);
    when(mapImpl.cloneElement(Mockito.<Element>any(), Mockito.<Schema>any()))
        .thenReturn(
            new Builder()
                .dest("Dest")
                .directed(true)
                .group("Group")
                .matchedVertex(MatchedVertex.SOURCE)
                .source("Source")
                .build());

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
    verify(mapImpl, atLeast(1)).addIndex(Mockito.<EntitySeed>any(), isA(Element.class));
    verify(mapImpl).cloneElement(isA(Element.class), isA(Schema.class));
    verify(mapImpl, atLeast(1)).getGroupByProperties("Group");
    verify(mapImpl, atLeast(1)).getNonGroupByProperties("Group");
    verify(mapImpl).isAggregationEnabled(isA(Element.class));
    verify(mapImpl).isMaintainIndex();
    verify(addElements).getInput();
    verify(addElements).isSkipInvalidElements();
    verify(addElements).isValidate();
    verify(store, atLeast(1)).getSchema();
    verify(schema).getAggregatedGroups();
    verify(schema).getElement("Group");
    assertNull(actualDoOperationResult);
  }

  /**
   * Test {@link AddElementsHandler#doOperation(AddElements, Context, Store)} with {@code
   * AddElements}, {@code Context}, {@code Store}.
   *
   * <ul>
   *   <li>Then calls {@link MapImpl#addAggElement(Element, GroupedProperties)}.
   * </ul>
   *
   * <p>Method under test: {@link AddElementsHandler#doOperation(AddElements, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(AddElements, Context, Store) with 'AddElements', 'Context', 'Store'; then calls addAggElement(Element, GroupedProperties)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Void AddElementsHandler.doOperation(AddElements, Context, Store)"})
  void testDoOperationWithAddElementsContextStore_thenCallsAddAggElement4()
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

    MapStoreProperties mapStoreProperties = mock(MapStoreProperties.class);
    when(mapStoreProperties.getIngestBufferSize()).thenReturn(1);

    MapImpl mapImpl = mock(MapImpl.class);
    when(mapImpl.getGroupByProperties(Mockito.<String>any())).thenReturn(new HashSet<>());
    when(mapImpl.getNonGroupByProperties(Mockito.<String>any())).thenReturn(new HashSet<>());
    doNothing()
        .when(mapImpl)
        .addAggElement(Mockito.<Element>any(), Mockito.<GroupedProperties>any());
    doNothing().when(mapImpl).addIndex(Mockito.<EdgeSeed>any(), Mockito.<Element>any());
    doNothing().when(mapImpl).addIndex(Mockito.<EntitySeed>any(), Mockito.<Element>any());
    when(mapImpl.isAggregationEnabled(Mockito.<Element>any())).thenReturn(true);
    when(mapImpl.isMaintainIndex()).thenReturn(true);
    when(mapImpl.cloneElement(Mockito.<Element>any(), Mockito.<Schema>any()))
        .thenReturn(
            new Builder()
                .dest("Dest")
                .directed(true)
                .group("Group")
                .matchedVertex(MatchedVertex.SOURCE)
                .source("Source")
                .build());

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("Adding elements in batches, batch size = {}");

    Schema schema = mock(Schema.class);
    when(schema.getVisibilityProperty()).thenReturn("Visibility Property");
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.getGroups()).thenReturn(stringSet);
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
    verify(mapImpl, atLeast(1)).addIndex(Mockito.<EntitySeed>any(), isA(Element.class));
    verify(mapImpl).cloneElement(isA(Element.class), isA(Schema.class));
    verify(mapImpl, atLeast(1)).getGroupByProperties("Group");
    verify(mapImpl, atLeast(1)).getNonGroupByProperties("Group");
    verify(mapImpl).isAggregationEnabled(isA(Element.class));
    verify(mapImpl).isMaintainIndex();
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
   * <ul>
   *   <li>Then calls {@link MapImpl#addAggElement(Element, GroupedProperties)}.
   * </ul>
   *
   * <p>Method under test: {@link AddElementsHandler#doOperation(AddElements, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(AddElements, Context, Store) with 'AddElements', 'Context', 'Store'; then calls addAggElement(Element, GroupedProperties)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Void AddElementsHandler.doOperation(AddElements, Context, Store)"})
  void testDoOperationWithAddElementsContextStore_thenCallsAddAggElement5()
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

    MapStoreProperties mapStoreProperties = mock(MapStoreProperties.class);
    when(mapStoreProperties.getIngestBufferSize()).thenReturn(1);

    MapImpl mapImpl = mock(MapImpl.class);
    when(mapImpl.getGroupByProperties(Mockito.<String>any())).thenReturn(new HashSet<>());
    when(mapImpl.getNonGroupByProperties(Mockito.<String>any())).thenReturn(new HashSet<>());
    doNothing()
        .when(mapImpl)
        .addAggElement(Mockito.<Element>any(), Mockito.<GroupedProperties>any());
    doNothing().when(mapImpl).addIndex(Mockito.<EdgeSeed>any(), Mockito.<Element>any());
    doNothing().when(mapImpl).addIndex(Mockito.<EntitySeed>any(), Mockito.<Element>any());
    when(mapImpl.isAggregationEnabled(Mockito.<Element>any())).thenReturn(true);
    when(mapImpl.isMaintainIndex()).thenReturn(true);
    when(mapImpl.cloneElement(Mockito.<Element>any(), Mockito.<Schema>any()))
        .thenReturn(
            new Builder()
                .dest("Dest")
                .directed(true)
                .group("Group")
                .matchedVertex(MatchedVertex.SOURCE)
                .source("Source")
                .build());

    SchemaEdgeDefinition schemaEdgeDefinition = mock(SchemaEdgeDefinition.class);
    when(schemaEdgeDefinition.containsProperty(Mockito.<String>any())).thenReturn(true);
    when(schemaEdgeDefinition.getGroupBy()).thenReturn(new HashSet<>());
    when(schemaEdgeDefinition.getValidator(anyBoolean()))
        .thenReturn(new ElementFilter.Builder().build());

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("Adding elements in batches, batch size = {}");

    Schema schema = mock(Schema.class);
    when(schema.getVisibilityProperty()).thenReturn("Visibility Property");
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.getGroups()).thenReturn(stringSet);
    when(schema.getElement(Mockito.<String>any())).thenReturn(schemaEdgeDefinition);

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
    verify(mapImpl, atLeast(1)).addIndex(Mockito.<EntitySeed>any(), isA(Element.class));
    verify(mapImpl).cloneElement(isA(Element.class), isA(Schema.class));
    verify(mapImpl, atLeast(1)).getGroupByProperties("Group");
    verify(mapImpl, atLeast(1)).getNonGroupByProperties("Group");
    verify(mapImpl).isAggregationEnabled(isA(Element.class));
    verify(mapImpl).isMaintainIndex();
    verify(addElements).getInput();
    verify(addElements).isSkipInvalidElements();
    verify(addElements).isValidate();
    verify(store, atLeast(1)).getSchema();
    verify(schema).getAggregatedGroups();
    verify(schema, atLeast(1)).getElement(Mockito.<String>any());
    verify(schema, atLeast(1)).getVisibilityProperty();
    verify(schemaEdgeDefinition).containsProperty("Visibility Property");
    verify(schemaEdgeDefinition).getGroupBy();
    verify(schemaEdgeDefinition).getValidator(true);
    assertNull(actualDoOperationResult);
  }

  /**
   * Test {@link AddElementsHandler#doOperation(AddElements, Context, Store)} with {@code
   * AddElements}, {@code Context}, {@code Store}.
   *
   * <ul>
   *   <li>Then calls {@link MapImpl#addNonAggElement(Element)}.
   * </ul>
   *
   * <p>Method under test: {@link AddElementsHandler#doOperation(AddElements, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(AddElements, Context, Store) with 'AddElements', 'Context', 'Store'; then calls addNonAggElement(Element)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Void AddElementsHandler.doOperation(AddElements, Context, Store)"})
  void testDoOperationWithAddElementsContextStore_thenCallsAddNonAggElement()
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

    MapStoreProperties mapStoreProperties = mock(MapStoreProperties.class);
    when(mapStoreProperties.getIngestBufferSize()).thenReturn(1);

    MapImpl mapImpl = mock(MapImpl.class);
    doNothing().when(mapImpl).addIndex(Mockito.<EdgeSeed>any(), Mockito.<Element>any());
    doNothing().when(mapImpl).addIndex(Mockito.<EntitySeed>any(), Mockito.<Element>any());
    when(mapImpl.isAggregationEnabled(Mockito.<Element>any())).thenReturn(false);
    when(mapImpl.isMaintainIndex()).thenReturn(true);
    doNothing().when(mapImpl).addNonAggElement(Mockito.<Element>any());
    when(mapImpl.cloneElement(Mockito.<Element>any(), Mockito.<Schema>any()))
        .thenReturn(
            new Builder()
                .dest("Dest")
                .directed(true)
                .group("Group")
                .matchedVertex(MatchedVertex.SOURCE)
                .source("Source")
                .build());

    SchemaEdgeDefinition schemaEdgeDefinition = mock(SchemaEdgeDefinition.class);
    when(schemaEdgeDefinition.getProperties()).thenReturn(new HashSet<>());
    when(schemaEdgeDefinition.containsProperty(Mockito.<String>any())).thenReturn(true);
    when(schemaEdgeDefinition.getGroupBy()).thenReturn(new HashSet<>());
    when(schemaEdgeDefinition.getValidator(anyBoolean()))
        .thenReturn(new ElementFilter.Builder().build());

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("Adding elements in batches, batch size = {}");

    Schema schema = mock(Schema.class);
    when(schema.getVisibilityProperty()).thenReturn("Visibility Property");
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.getGroups()).thenReturn(stringSet);
    when(schema.getElement(Mockito.<String>any())).thenReturn(schemaEdgeDefinition);

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
    verify(schema, atLeast(1)).getVisibilityProperty();
    verify(schemaEdgeDefinition).containsProperty("Visibility Property");
    verify(schemaEdgeDefinition).getGroupBy();
    verify(schemaEdgeDefinition).getProperties();
    verify(schemaEdgeDefinition).getValidator(true);
    assertNull(actualDoOperationResult);
  }

  /**
   * Test {@link AddElementsHandler#doOperation(AddElements, Context, Store)} with {@code
   * AddElements}, {@code Context}, {@code Store}.
   *
   * <ul>
   *   <li>Then calls {@link MapImpl#addNonAggElement(Element)}.
   * </ul>
   *
   * <p>Method under test: {@link AddElementsHandler#doOperation(AddElements, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(AddElements, Context, Store) with 'AddElements', 'Context', 'Store'; then calls addNonAggElement(Element)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Void AddElementsHandler.doOperation(AddElements, Context, Store)"})
  void testDoOperationWithAddElementsContextStore_thenCallsAddNonAggElement2()
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

    MapStoreProperties mapStoreProperties = mock(MapStoreProperties.class);
    when(mapStoreProperties.getIngestBufferSize()).thenReturn(1);

    MapImpl mapImpl = mock(MapImpl.class);
    doNothing().when(mapImpl).addIndex(Mockito.<EdgeSeed>any(), Mockito.<Element>any());
    doNothing().when(mapImpl).addIndex(Mockito.<EntitySeed>any(), Mockito.<Element>any());
    when(mapImpl.isAggregationEnabled(Mockito.<Element>any())).thenReturn(false);
    when(mapImpl.isMaintainIndex()).thenReturn(true);
    doNothing().when(mapImpl).addNonAggElement(Mockito.<Element>any());
    when(mapImpl.cloneElement(Mockito.<Element>any(), Mockito.<Schema>any()))
        .thenReturn(
            new Builder()
                .dest("Dest")
                .directed(true)
                .group("Group")
                .matchedVertex(MatchedVertex.SOURCE)
                .source("Source")
                .build());

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("Adding elements in batches, batch size = {}");

    SchemaEdgeDefinition schemaEdgeDefinition = mock(SchemaEdgeDefinition.class);
    when(schemaEdgeDefinition.getProperties()).thenReturn(stringSet);
    when(schemaEdgeDefinition.containsProperty(Mockito.<String>any())).thenReturn(true);
    when(schemaEdgeDefinition.getGroupBy()).thenReturn(new HashSet<>());
    when(schemaEdgeDefinition.getValidator(anyBoolean()))
        .thenReturn(new ElementFilter.Builder().build());

    HashSet<String> stringSet2 = new HashSet<>();
    stringSet2.add("Adding elements in batches, batch size = {}");

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
    Void actualDoOperationResult = addElementsHandler.doOperation(addElements, context, store);

    // Assert
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
    verify(schema, atLeast(1)).getVisibilityProperty();
    verify(schemaEdgeDefinition).containsProperty("Visibility Property");
    verify(schemaEdgeDefinition).getGroupBy();
    verify(schemaEdgeDefinition).getProperties();
    verify(schemaEdgeDefinition).getValidator(true);
    assertNull(actualDoOperationResult);
  }
}
