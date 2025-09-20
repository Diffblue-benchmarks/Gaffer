package uk.gov.gchq.gaffer.mapstore.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
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

class DeleteElementsHandlerDiffblueTest {
  /**
   * Test {@link DeleteElementsHandler#doOperation(DeleteElements, Context, Store)} with {@code
   * DeleteElements}, {@code Context}, {@code Store}.
   *
   * <p>Method under test: {@link DeleteElementsHandler#doOperation(DeleteElements, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(DeleteElements, Context, Store) with 'DeleteElements', 'Context', 'Store'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long DeleteElementsHandler.doOperation(DeleteElements, Context, Store)"})
  void testDoOperationWithDeleteElementsContextStore() {
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
    Long actualDoOperationResult =
        deleteElementsHandler.doOperation(deleteElements, context, store);

    // Assert
    verify(schema).getGroups();
    verify(store).getMapImpl();
    verify(store).getProperties();
    verify(mapStoreProperties).getIngestBufferSize();
    verify(mapImpl).deleteAggElement(isA(Element.class));
    verify(mapImpl, atLeast(1)).getGroupByProperties("Group");
    verify(mapImpl, atLeast(1)).getNonGroupByProperties("Group");
    verify(mapImpl).isAggregationEnabled(isA(Element.class));
    verify(mapImpl).isMaintainIndex();
    verify(mapImpl).removeEdgeIndex(isA(EdgeSeed.class), isA(Element.class));
    verify(mapImpl, atLeast(1)).removeEntityIndex(Mockito.<EntitySeed>any(), isA(Element.class));
    verify(deleteElements).getInput();
    verify(deleteElements).isSkipInvalidElements();
    verify(deleteElements).isValidate();
    verify(store, atLeast(1)).getSchema();
    verify(schema).getAggregatedGroups();
    verify(schema, atLeast(1)).getElement("Group");
    assertEquals(1L, actualDoOperationResult.longValue());
  }

  /**
   * Test {@link DeleteElementsHandler#doOperation(DeleteElements, Context, Store)} with {@code
   * DeleteElements}, {@code Context}, {@code Store}.
   *
   * <p>Method under test: {@link DeleteElementsHandler#doOperation(DeleteElements, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(DeleteElements, Context, Store) with 'DeleteElements', 'Context', 'Store'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long DeleteElementsHandler.doOperation(DeleteElements, Context, Store)"})
  void testDoOperationWithDeleteElementsContextStore2() {
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
    Mockito.<Iterable<? extends Element>>when(deleteElements.getInput()).thenReturn(elementList);
    Context context = new Context();

    MapStoreProperties mapStoreProperties = mock(MapStoreProperties.class);
    when(mapStoreProperties.getIngestBufferSize()).thenReturn(1);

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("source");

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
    Long actualDoOperationResult =
        deleteElementsHandler.doOperation(deleteElements, context, store);

    // Assert
    verify(schema).getGroups();
    verify(store).getMapImpl();
    verify(store).getProperties();
    verify(mapStoreProperties).getIngestBufferSize();
    verify(mapImpl).deleteAggElement(isA(Element.class));
    verify(mapImpl, atLeast(1)).getGroupByProperties("Group");
    verify(mapImpl, atLeast(1)).getNonGroupByProperties("Group");
    verify(mapImpl).isAggregationEnabled(isA(Element.class));
    verify(mapImpl).isMaintainIndex();
    verify(mapImpl).removeEdgeIndex(isA(EdgeSeed.class), isA(Element.class));
    verify(mapImpl, atLeast(1)).removeEntityIndex(Mockito.<EntitySeed>any(), isA(Element.class));
    verify(deleteElements).getInput();
    verify(deleteElements).isSkipInvalidElements();
    verify(deleteElements).isValidate();
    verify(store, atLeast(1)).getSchema();
    verify(schema).getAggregatedGroups();
    verify(schema, atLeast(1)).getElement("Group");
    assertEquals(1L, actualDoOperationResult.longValue());
  }

  /**
   * Test {@link DeleteElementsHandler#doOperation(DeleteElements, Context, Store)} with {@code
   * DeleteElements}, {@code Context}, {@code Store}.
   *
   * <p>Method under test: {@link DeleteElementsHandler#doOperation(DeleteElements, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(DeleteElements, Context, Store) with 'DeleteElements', 'Context', 'Store'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long DeleteElementsHandler.doOperation(DeleteElements, Context, Store)"})
  void testDoOperationWithDeleteElementsContextStore3() {
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
    Mockito.<Iterable<? extends Element>>when(deleteElements.getInput()).thenReturn(elementList);
    Context context = new Context();

    MapStoreProperties mapStoreProperties = mock(MapStoreProperties.class);
    when(mapStoreProperties.getIngestBufferSize()).thenReturn(1);

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("source");

    MapImpl mapImpl = mock(MapImpl.class);
    when(mapImpl.getGroupByProperties(Mockito.<String>any())).thenReturn(new HashSet<>());
    when(mapImpl.getNonGroupByProperties(Mockito.<String>any())).thenReturn(stringSet);
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
    Long actualDoOperationResult =
        deleteElementsHandler.doOperation(deleteElements, context, store);

    // Assert
    verify(schema).getGroups();
    verify(store).getMapImpl();
    verify(store).getProperties();
    verify(mapStoreProperties).getIngestBufferSize();
    verify(mapImpl).deleteAggElement(isA(Element.class));
    verify(mapImpl, atLeast(1)).getGroupByProperties("Group");
    verify(mapImpl, atLeast(1)).getNonGroupByProperties("Group");
    verify(mapImpl).isAggregationEnabled(isA(Element.class));
    verify(mapImpl).isMaintainIndex();
    verify(mapImpl).removeEdgeIndex(isA(EdgeSeed.class), isA(Element.class));
    verify(mapImpl, atLeast(1)).removeEntityIndex(Mockito.<EntitySeed>any(), isA(Element.class));
    verify(deleteElements).getInput();
    verify(deleteElements).isSkipInvalidElements();
    verify(deleteElements).isValidate();
    verify(store, atLeast(1)).getSchema();
    verify(schema).getAggregatedGroups();
    verify(schema, atLeast(1)).getElement("Group");
    assertEquals(1L, actualDoOperationResult.longValue());
  }

  /**
   * Test {@link DeleteElementsHandler#doOperation(DeleteElements, Context, Store)} with {@code
   * DeleteElements}, {@code Context}, {@code Store}.
   *
   * <p>Method under test: {@link DeleteElementsHandler#doOperation(DeleteElements, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(DeleteElements, Context, Store) with 'DeleteElements', 'Context', 'Store'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long DeleteElementsHandler.doOperation(DeleteElements, Context, Store)"})
  void testDoOperationWithDeleteElementsContextStore4() {
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

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("source");

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
    Long actualDoOperationResult =
        deleteElementsHandler.doOperation(deleteElements, context, store);

    // Assert
    verify(schema).getGroups();
    verify(store).getMapImpl();
    verify(store).getProperties();
    verify(mapStoreProperties).getIngestBufferSize();
    verify(mapImpl).deleteAggElement(isA(Element.class));
    verify(mapImpl, atLeast(1)).getGroupByProperties("Group");
    verify(mapImpl, atLeast(1)).getNonGroupByProperties("Group");
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
   * Test {@link DeleteElementsHandler#doOperation(DeleteElements, Context, Store)} with {@code
   * DeleteElements}, {@code Context}, {@code Store}.
   *
   * <p>Method under test: {@link DeleteElementsHandler#doOperation(DeleteElements, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(DeleteElements, Context, Store) with 'DeleteElements', 'Context', 'Store'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long DeleteElementsHandler.doOperation(DeleteElements, Context, Store)"})
  void testDoOperationWithDeleteElementsContextStore5() {
    // Arrange
    DeleteElementsHandler deleteElementsHandler = new DeleteElementsHandler();

    ArrayList<Element> elementList = new ArrayList<>();
    elementList.add(
        new Builder()
            .dest(null)
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build());

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

    SchemaEdgeDefinition schemaEdgeDefinition = mock(SchemaEdgeDefinition.class);
    when(schemaEdgeDefinition.containsProperty(Mockito.<String>any())).thenReturn(true);
    when(schemaEdgeDefinition.getGroupBy()).thenReturn(new HashSet<>());
    when(schemaEdgeDefinition.getValidator(anyBoolean()))
        .thenReturn(new ElementFilter.Builder().build());

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("source");

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
    Long actualDoOperationResult =
        deleteElementsHandler.doOperation(deleteElements, context, store);

    // Assert
    verify(schema).getGroups();
    verify(store).getMapImpl();
    verify(store).getProperties();
    verify(mapStoreProperties).getIngestBufferSize();
    verify(mapImpl).deleteAggElement(isA(Element.class));
    verify(mapImpl, atLeast(1)).getGroupByProperties("Group");
    verify(mapImpl, atLeast(1)).getNonGroupByProperties("Group");
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
    verify(schemaEdgeDefinition).containsProperty("Visibility Property");
    verify(schemaEdgeDefinition).getGroupBy();
    verify(schemaEdgeDefinition, atLeast(1)).getValidator(true);
    assertEquals(1L, actualDoOperationResult.longValue());
  }

  /**
   * Test {@link DeleteElementsHandler#doOperation(DeleteElements, Context, Store)} with {@code
   * DeleteElements}, {@code Context}, {@code Store}.
   *
   * <p>Method under test: {@link DeleteElementsHandler#doOperation(DeleteElements, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(DeleteElements, Context, Store) with 'DeleteElements', 'Context', 'Store'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long DeleteElementsHandler.doOperation(DeleteElements, Context, Store)"})
  void testDoOperationWithDeleteElementsContextStore6() {
    // Arrange
    DeleteElementsHandler deleteElementsHandler = new DeleteElementsHandler();

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

    SchemaEdgeDefinition schemaEdgeDefinition = mock(SchemaEdgeDefinition.class);
    when(schemaEdgeDefinition.containsProperty(Mockito.<String>any())).thenReturn(true);
    when(schemaEdgeDefinition.getGroupBy()).thenReturn(new HashSet<>());
    when(schemaEdgeDefinition.getValidator(anyBoolean()))
        .thenReturn(new ElementFilter.Builder().build());

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("source");

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
    Long actualDoOperationResult =
        deleteElementsHandler.doOperation(deleteElements, context, store);

    // Assert
    verify(schema).getGroups();
    verify(store).getMapImpl();
    verify(store).getProperties();
    verify(mapStoreProperties).getIngestBufferSize();
    verify(mapImpl).deleteAggElement(isA(Element.class));
    verify(mapImpl, atLeast(1)).getGroupByProperties("Group");
    verify(mapImpl, atLeast(1)).getNonGroupByProperties("Group");
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
    verify(schemaEdgeDefinition).containsProperty("Visibility Property");
    verify(schemaEdgeDefinition).getGroupBy();
    verify(schemaEdgeDefinition, atLeast(1)).getValidator(true);
    assertEquals(1L, actualDoOperationResult.longValue());
  }

  /**
   * Test {@link DeleteElementsHandler#doOperation(DeleteElements, Context, Store)} with {@code
   * DeleteElements}, {@code Context}, {@code Store}.
   *
   * <p>Method under test: {@link DeleteElementsHandler#doOperation(DeleteElements, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(DeleteElements, Context, Store) with 'DeleteElements', 'Context', 'Store'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long DeleteElementsHandler.doOperation(DeleteElements, Context, Store)"})
  void testDoOperationWithDeleteElementsContextStore7() {
    // Arrange
    DeleteElementsHandler deleteElementsHandler = new DeleteElementsHandler();

    ArrayList<Element> elementList = new ArrayList<>();

    Builder builder = new Builder();
    elementList.add(
        builder
            .dest(new Edge("source"))
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build());

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

    SchemaEdgeDefinition schemaEdgeDefinition = mock(SchemaEdgeDefinition.class);
    when(schemaEdgeDefinition.containsProperty(Mockito.<String>any())).thenReturn(true);
    when(schemaEdgeDefinition.getGroupBy()).thenReturn(new HashSet<>());
    when(schemaEdgeDefinition.getValidator(anyBoolean()))
        .thenReturn(new ElementFilter.Builder().build());

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("source");

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
    Long actualDoOperationResult =
        deleteElementsHandler.doOperation(deleteElements, context, store);

    // Assert
    verify(schema).getGroups();
    verify(store).getMapImpl();
    verify(store).getProperties();
    verify(mapStoreProperties).getIngestBufferSize();
    verify(mapImpl).deleteAggElement(isA(Element.class));
    verify(mapImpl, atLeast(1)).getGroupByProperties("Group");
    verify(mapImpl, atLeast(1)).getNonGroupByProperties("Group");
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
    verify(schemaEdgeDefinition).containsProperty("Visibility Property");
    verify(schemaEdgeDefinition).getGroupBy();
    verify(schemaEdgeDefinition, atLeast(1)).getValidator(true);
    assertEquals(1L, actualDoOperationResult.longValue());
  }

  /**
   * Test {@link DeleteElementsHandler#doOperation(DeleteElements, Context, Store)} with {@code
   * DeleteElements}, {@code Context}, {@code Store}.
   *
   * <p>Method under test: {@link DeleteElementsHandler#doOperation(DeleteElements, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(DeleteElements, Context, Store) with 'DeleteElements', 'Context', 'Store'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long DeleteElementsHandler.doOperation(DeleteElements, Context, Store)"})
  void testDoOperationWithDeleteElementsContextStore8() {
    // Arrange
    DeleteElementsHandler deleteElementsHandler = new DeleteElementsHandler();

    ArrayList<Element> elementList = new ArrayList<>();

    Builder builder = new Builder();
    elementList.add(
        builder
            .dest(new SchemaEdgeDefinition())
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build());

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

    SchemaEdgeDefinition schemaEdgeDefinition = mock(SchemaEdgeDefinition.class);
    when(schemaEdgeDefinition.containsProperty(Mockito.<String>any())).thenReturn(true);
    when(schemaEdgeDefinition.getGroupBy()).thenReturn(new HashSet<>());
    when(schemaEdgeDefinition.getValidator(anyBoolean()))
        .thenReturn(new ElementFilter.Builder().build());

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("source");

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
    Long actualDoOperationResult =
        deleteElementsHandler.doOperation(deleteElements, context, store);

    // Assert
    verify(schema).getGroups();
    verify(store).getMapImpl();
    verify(store).getProperties();
    verify(mapStoreProperties).getIngestBufferSize();
    verify(mapImpl).deleteAggElement(isA(Element.class));
    verify(mapImpl, atLeast(1)).getGroupByProperties("Group");
    verify(mapImpl, atLeast(1)).getNonGroupByProperties("Group");
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
    verify(schemaEdgeDefinition).containsProperty("Visibility Property");
    verify(schemaEdgeDefinition).getGroupBy();
    verify(schemaEdgeDefinition, atLeast(1)).getValidator(true);
    assertEquals(1L, actualDoOperationResult.longValue());
  }

  /**
   * Test {@link DeleteElementsHandler#doOperation(DeleteElements, Context, Store)} with {@code
   * DeleteElements}, {@code Context}, {@code Store}.
   *
   * <p>Method under test: {@link DeleteElementsHandler#doOperation(DeleteElements, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(DeleteElements, Context, Store) with 'DeleteElements', 'Context', 'Store'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long DeleteElementsHandler.doOperation(DeleteElements, Context, Store)"})
  void testDoOperationWithDeleteElementsContextStore9() {
    // Arrange
    DeleteElementsHandler deleteElementsHandler = new DeleteElementsHandler();

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

    SchemaEdgeDefinition schemaEdgeDefinition = mock(SchemaEdgeDefinition.class);
    when(schemaEdgeDefinition.containsProperty(Mockito.<String>any())).thenReturn(true);
    when(schemaEdgeDefinition.getGroupBy()).thenReturn(new HashSet<>());
    when(schemaEdgeDefinition.getValidator(anyBoolean()))
        .thenReturn(new ElementFilter.Builder().build());

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("source");

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
    Long actualDoOperationResult =
        deleteElementsHandler.doOperation(deleteElements, context, store);

    // Assert
    verify(schema).getGroups();
    verify(store).getMapImpl();
    verify(store).getProperties();
    verify(mapStoreProperties).getIngestBufferSize();
    verify(mapImpl).deleteAggElement(isA(Element.class));
    verify(mapImpl, atLeast(1)).getGroupByProperties("Group");
    verify(mapImpl, atLeast(1)).getNonGroupByProperties("Group");
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
    verify(schemaEdgeDefinition).containsProperty("Visibility Property");
    verify(schemaEdgeDefinition).getGroupBy();
    verify(schemaEdgeDefinition, atLeast(1)).getValidator(true);
    assertEquals(1L, actualDoOperationResult.longValue());
  }

  /**
   * Test {@link DeleteElementsHandler#doOperation(DeleteElements, Context, Store)} with {@code
   * DeleteElements}, {@code Context}, {@code Store}.
   *
   * <p>Method under test: {@link DeleteElementsHandler#doOperation(DeleteElements, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(DeleteElements, Context, Store) with 'DeleteElements', 'Context', 'Store'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long DeleteElementsHandler.doOperation(DeleteElements, Context, Store)"})
  void testDoOperationWithDeleteElementsContextStore10() {
    // Arrange
    DeleteElementsHandler deleteElementsHandler = new DeleteElementsHandler();

    ArrayList<Element> elementList = new ArrayList<>();
    elementList.add(
        new Builder()
            .dest("Dest")
            .directed(false)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build());

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

    SchemaEdgeDefinition schemaEdgeDefinition = mock(SchemaEdgeDefinition.class);
    when(schemaEdgeDefinition.containsProperty(Mockito.<String>any())).thenReturn(true);
    when(schemaEdgeDefinition.getGroupBy()).thenReturn(new HashSet<>());
    when(schemaEdgeDefinition.getValidator(anyBoolean()))
        .thenReturn(new ElementFilter.Builder().build());

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("source");

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
    Long actualDoOperationResult =
        deleteElementsHandler.doOperation(deleteElements, context, store);

    // Assert
    verify(schema).getGroups();
    verify(store).getMapImpl();
    verify(store).getProperties();
    verify(mapStoreProperties).getIngestBufferSize();
    verify(mapImpl).deleteAggElement(isA(Element.class));
    verify(mapImpl, atLeast(1)).getGroupByProperties("Group");
    verify(mapImpl, atLeast(1)).getNonGroupByProperties("Group");
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
    verify(schemaEdgeDefinition).containsProperty("Visibility Property");
    verify(schemaEdgeDefinition).getGroupBy();
    verify(schemaEdgeDefinition, atLeast(1)).getValidator(true);
    assertEquals(1L, actualDoOperationResult.longValue());
  }

  /**
   * Test {@link DeleteElementsHandler#doOperation(DeleteElements, Context, Store)} with {@code
   * DeleteElements}, {@code Context}, {@code Store}.
   *
   * <p>Method under test: {@link DeleteElementsHandler#doOperation(DeleteElements, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(DeleteElements, Context, Store) with 'DeleteElements', 'Context', 'Store'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long DeleteElementsHandler.doOperation(DeleteElements, Context, Store)"})
  void testDoOperationWithDeleteElementsContextStore11() {
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
    Mockito.<Iterable<? extends Element>>when(deleteElements.getInput()).thenReturn(elementList);
    Context context = new Context();

    MapStoreProperties mapStoreProperties = mock(MapStoreProperties.class);
    when(mapStoreProperties.getIngestBufferSize()).thenReturn(14);

    MapImpl mapImpl = mock(MapImpl.class);
    when(mapImpl.getGroupByProperties(Mockito.<String>any())).thenReturn(new HashSet<>());
    when(mapImpl.getNonGroupByProperties(Mockito.<String>any())).thenReturn(new HashSet<>());
    doNothing().when(mapImpl).deleteAggElement(Mockito.<Element>any());
    doNothing().when(mapImpl).removeEdgeIndex(Mockito.<EdgeSeed>any(), Mockito.<Element>any());
    doNothing().when(mapImpl).removeEntityIndex(Mockito.<EntitySeed>any(), Mockito.<Element>any());
    when(mapImpl.isAggregationEnabled(Mockito.<Element>any())).thenReturn(true);
    when(mapImpl.isMaintainIndex()).thenReturn(true);

    SchemaEdgeDefinition schemaEdgeDefinition = mock(SchemaEdgeDefinition.class);
    when(schemaEdgeDefinition.containsProperty(Mockito.<String>any())).thenReturn(true);
    when(schemaEdgeDefinition.getGroupBy()).thenReturn(new HashSet<>());
    when(schemaEdgeDefinition.getValidator(anyBoolean()))
        .thenReturn(new ElementFilter.Builder().build());

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("source");

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
    Long actualDoOperationResult =
        deleteElementsHandler.doOperation(deleteElements, context, store);

    // Assert
    verify(schema).getGroups();
    verify(store).getMapImpl();
    verify(store).getProperties();
    verify(mapStoreProperties).getIngestBufferSize();
    verify(mapImpl).deleteAggElement(isA(Element.class));
    verify(mapImpl, atLeast(1)).getGroupByProperties("Group");
    verify(mapImpl, atLeast(1)).getNonGroupByProperties("Group");
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
    verify(schemaEdgeDefinition).containsProperty("Visibility Property");
    verify(schemaEdgeDefinition).getGroupBy();
    verify(schemaEdgeDefinition, atLeast(1)).getValidator(true);
    assertEquals(1L, actualDoOperationResult.longValue());
  }

  /**
   * Test {@link DeleteElementsHandler#doOperation(DeleteElements, Context, Store)} with {@code
   * DeleteElements}, {@code Context}, {@code Store}.
   *
   * <p>Method under test: {@link DeleteElementsHandler#doOperation(DeleteElements, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(DeleteElements, Context, Store) with 'DeleteElements', 'Context', 'Store'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long DeleteElementsHandler.doOperation(DeleteElements, Context, Store)"})
  void testDoOperationWithDeleteElementsContextStore12() {
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
    Mockito.<Iterable<? extends Element>>when(deleteElements.getInput()).thenReturn(elementList);
    Context context = new Context();

    MapStoreProperties mapStoreProperties = mock(MapStoreProperties.class);
    when(mapStoreProperties.getIngestBufferSize()).thenReturn(1);

    MapImpl mapImpl = mock(MapImpl.class);
    when(mapImpl.isAggregationEnabled(Mockito.<Element>any())).thenReturn(false);
    when(mapImpl.isMaintainIndex()).thenReturn(false);
    doNothing().when(mapImpl).deleteNonAggElement(Mockito.<Element>any());

    SchemaEdgeDefinition schemaEdgeDefinition = mock(SchemaEdgeDefinition.class);
    when(schemaEdgeDefinition.getProperties()).thenReturn(new HashSet<>());
    when(schemaEdgeDefinition.containsProperty(Mockito.<String>any())).thenReturn(true);
    when(schemaEdgeDefinition.getGroupBy()).thenReturn(new HashSet<>());
    when(schemaEdgeDefinition.getValidator(anyBoolean()))
        .thenReturn(new ElementFilter.Builder().build());

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("source");

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
    Long actualDoOperationResult =
        deleteElementsHandler.doOperation(deleteElements, context, store);

    // Assert
    verify(schema).getGroups();
    verify(store).getMapImpl();
    verify(store).getProperties();
    verify(mapStoreProperties).getIngestBufferSize();
    verify(mapImpl).deleteNonAggElement(isA(Element.class));
    verify(mapImpl).isAggregationEnabled(isA(Element.class));
    verify(mapImpl).isMaintainIndex();
    verify(deleteElements).getInput();
    verify(deleteElements).isSkipInvalidElements();
    verify(deleteElements).isValidate();
    verify(store, atLeast(1)).getSchema();
    verify(schema).getAggregatedGroups();
    verify(schema, atLeast(1)).getElement(Mockito.<String>any());
    verify(schema, atLeast(1)).getVisibilityProperty();
    verify(schemaEdgeDefinition).containsProperty("Visibility Property");
    verify(schemaEdgeDefinition).getGroupBy();
    verify(schemaEdgeDefinition).getProperties();
    verify(schemaEdgeDefinition, atLeast(1)).getValidator(true);
    assertEquals(1L, actualDoOperationResult.longValue());
  }

  /**
   * Test {@link DeleteElementsHandler#doOperation(DeleteElements, Context, Store)} with {@code
   * DeleteElements}, {@code Context}, {@code Store}.
   *
   * <p>Method under test: {@link DeleteElementsHandler#doOperation(DeleteElements, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(DeleteElements, Context, Store) with 'DeleteElements', 'Context', 'Store'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long DeleteElementsHandler.doOperation(DeleteElements, Context, Store)"})
  void testDoOperationWithDeleteElementsContextStore13() {
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
    Mockito.<Iterable<? extends Element>>when(deleteElements.getInput()).thenReturn(elementList);
    Context context = new Context();

    MapStoreProperties mapStoreProperties = mock(MapStoreProperties.class);
    when(mapStoreProperties.getIngestBufferSize()).thenReturn(1);

    MapImpl mapImpl = mock(MapImpl.class);
    doNothing().when(mapImpl).removeEdgeIndex(Mockito.<EdgeSeed>any(), Mockito.<Element>any());
    doNothing().when(mapImpl).removeEntityIndex(Mockito.<EntitySeed>any(), Mockito.<Element>any());
    when(mapImpl.isAggregationEnabled(Mockito.<Element>any())).thenReturn(false);
    when(mapImpl.isMaintainIndex()).thenReturn(true);
    doNothing().when(mapImpl).deleteNonAggElement(Mockito.<Element>any());

    SchemaEdgeDefinition schemaEdgeDefinition = mock(SchemaEdgeDefinition.class);
    when(schemaEdgeDefinition.getProperties()).thenReturn(new HashSet<>());
    when(schemaEdgeDefinition.getGroupBy()).thenReturn(new HashSet<>());
    when(schemaEdgeDefinition.getValidator(anyBoolean()))
        .thenReturn(new ElementFilter.Builder().build());

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("source");

    Schema schema = mock(Schema.class);
    when(schema.getVisibilityProperty()).thenReturn(null);
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.getGroups()).thenReturn(stringSet);
    when(schema.getElement(Mockito.<String>any())).thenReturn(schemaEdgeDefinition);

    MapStore store = mock(MapStore.class);
    when(store.getProperties()).thenReturn(mapStoreProperties);
    when(store.getMapImpl()).thenReturn(mapImpl);
    when(store.getSchema()).thenReturn(schema);

    // Act
    Long actualDoOperationResult =
        deleteElementsHandler.doOperation(deleteElements, context, store);

    // Assert
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
    verify(schema, atLeast(1)).getElement(Mockito.<String>any());
    verify(schema).getVisibilityProperty();
    verify(schemaEdgeDefinition).getGroupBy();
    verify(schemaEdgeDefinition).getProperties();
    verify(schemaEdgeDefinition, atLeast(1)).getValidator(true);
    assertEquals(1L, actualDoOperationResult.longValue());
  }

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
    Mockito.<Iterable<? extends Element>>when(deleteElements.getInput())
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
  void testDoOperationWithDeleteElementsContextStore_givenFalse2() {
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
    when(deleteElements.isValidate()).thenReturn(false);
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

    SchemaEdgeDefinition schemaEdgeDefinition = mock(SchemaEdgeDefinition.class);
    when(schemaEdgeDefinition.containsProperty(Mockito.<String>any())).thenReturn(true);
    when(schemaEdgeDefinition.getGroupBy()).thenReturn(new HashSet<>());

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("source");

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
    Long actualDoOperationResult =
        deleteElementsHandler.doOperation(deleteElements, context, store);

    // Assert
    verify(schema).getGroups();
    verify(store).getMapImpl();
    verify(store).getProperties();
    verify(mapStoreProperties).getIngestBufferSize();
    verify(mapImpl).deleteAggElement(isA(Element.class));
    verify(mapImpl, atLeast(1)).getGroupByProperties("Group");
    verify(mapImpl, atLeast(1)).getNonGroupByProperties("Group");
    verify(mapImpl).isAggregationEnabled(isA(Element.class));
    verify(mapImpl).isMaintainIndex();
    verify(mapImpl).removeEdgeIndex(isA(EdgeSeed.class), isA(Element.class));
    verify(mapImpl, atLeast(1)).removeEntityIndex(Mockito.<EntitySeed>any(), isA(Element.class));
    verify(deleteElements).getInput();
    verify(deleteElements).isValidate();
    verify(store).getSchema();
    verify(schema).getAggregatedGroups();
    verify(schema).getElement("source");
    verify(schema, atLeast(1)).getVisibilityProperty();
    verify(schemaEdgeDefinition).containsProperty("Visibility Property");
    verify(schemaEdgeDefinition).getGroupBy();
    assertEquals(1L, actualDoOperationResult.longValue());
  }

  /**
   * Test {@link DeleteElementsHandler#doOperation(DeleteElements, Context, Store)} with {@code
   * DeleteElements}, {@code Context}, {@code Store}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code destination}.
   * </ul>
   *
   * <p>Method under test: {@link DeleteElementsHandler#doOperation(DeleteElements, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(DeleteElements, Context, Store) with 'DeleteElements', 'Context', 'Store'; given HashSet() add 'destination'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long DeleteElementsHandler.doOperation(DeleteElements, Context, Store)"})
  void testDoOperationWithDeleteElementsContextStore_givenHashSetAddDestination() {
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
    Mockito.<Iterable<? extends Element>>when(deleteElements.getInput()).thenReturn(elementList);
    Context context = new Context();

    MapStoreProperties mapStoreProperties = mock(MapStoreProperties.class);
    when(mapStoreProperties.getIngestBufferSize()).thenReturn(1);

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("destination");
    stringSet.add("source");

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
    Long actualDoOperationResult =
        deleteElementsHandler.doOperation(deleteElements, context, store);

    // Assert
    verify(schema).getGroups();
    verify(store).getMapImpl();
    verify(store).getProperties();
    verify(mapStoreProperties).getIngestBufferSize();
    verify(mapImpl).deleteAggElement(isA(Element.class));
    verify(mapImpl, atLeast(1)).getGroupByProperties("Group");
    verify(mapImpl, atLeast(1)).getNonGroupByProperties("Group");
    verify(mapImpl).isAggregationEnabled(isA(Element.class));
    verify(mapImpl).isMaintainIndex();
    verify(mapImpl).removeEdgeIndex(isA(EdgeSeed.class), isA(Element.class));
    verify(mapImpl, atLeast(1)).removeEntityIndex(Mockito.<EntitySeed>any(), isA(Element.class));
    verify(deleteElements).getInput();
    verify(deleteElements).isSkipInvalidElements();
    verify(deleteElements).isValidate();
    verify(store, atLeast(1)).getSchema();
    verify(schema).getAggregatedGroups();
    verify(schema, atLeast(1)).getElement("Group");
    assertEquals(1L, actualDoOperationResult.longValue());
  }

  /**
   * Test {@link DeleteElementsHandler#doOperation(DeleteElements, Context, Store)} with {@code
   * DeleteElements}, {@code Context}, {@code Store}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code destination}.
   * </ul>
   *
   * <p>Method under test: {@link DeleteElementsHandler#doOperation(DeleteElements, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(DeleteElements, Context, Store) with 'DeleteElements', 'Context', 'Store'; given HashSet() add 'destination'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long DeleteElementsHandler.doOperation(DeleteElements, Context, Store)"})
  void testDoOperationWithDeleteElementsContextStore_givenHashSetAddDestination2() {
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
    Mockito.<Iterable<? extends Element>>when(deleteElements.getInput()).thenReturn(elementList);
    Context context = new Context();

    MapStoreProperties mapStoreProperties = mock(MapStoreProperties.class);
    when(mapStoreProperties.getIngestBufferSize()).thenReturn(1);

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("destination");
    stringSet.add("source");

    MapImpl mapImpl = mock(MapImpl.class);
    when(mapImpl.getGroupByProperties(Mockito.<String>any())).thenReturn(new HashSet<>());
    when(mapImpl.getNonGroupByProperties(Mockito.<String>any())).thenReturn(stringSet);
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
    Long actualDoOperationResult =
        deleteElementsHandler.doOperation(deleteElements, context, store);

    // Assert
    verify(schema).getGroups();
    verify(store).getMapImpl();
    verify(store).getProperties();
    verify(mapStoreProperties).getIngestBufferSize();
    verify(mapImpl).deleteAggElement(isA(Element.class));
    verify(mapImpl, atLeast(1)).getGroupByProperties("Group");
    verify(mapImpl, atLeast(1)).getNonGroupByProperties("Group");
    verify(mapImpl).isAggregationEnabled(isA(Element.class));
    verify(mapImpl).isMaintainIndex();
    verify(mapImpl).removeEdgeIndex(isA(EdgeSeed.class), isA(Element.class));
    verify(mapImpl, atLeast(1)).removeEntityIndex(Mockito.<EntitySeed>any(), isA(Element.class));
    verify(deleteElements).getInput();
    verify(deleteElements).isSkipInvalidElements();
    verify(deleteElements).isValidate();
    verify(store, atLeast(1)).getSchema();
    verify(schema).getAggregatedGroups();
    verify(schema, atLeast(1)).getElement("Group");
    assertEquals(1L, actualDoOperationResult.longValue());
  }

  /**
   * Test {@link DeleteElementsHandler#doOperation(DeleteElements, Context, Store)} with {@code
   * DeleteElements}, {@code Context}, {@code Store}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code destination}.
   * </ul>
   *
   * <p>Method under test: {@link DeleteElementsHandler#doOperation(DeleteElements, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(DeleteElements, Context, Store) with 'DeleteElements', 'Context', 'Store'; given HashSet() add 'destination'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long DeleteElementsHandler.doOperation(DeleteElements, Context, Store)"})
  void testDoOperationWithDeleteElementsContextStore_givenHashSetAddDestination3() {
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
    Mockito.<Iterable<? extends Element>>when(deleteElements.getInput()).thenReturn(elementList);
    Context context = new Context();

    MapStoreProperties mapStoreProperties = mock(MapStoreProperties.class);
    when(mapStoreProperties.getIngestBufferSize()).thenReturn(1);

    MapImpl mapImpl = mock(MapImpl.class);
    doNothing().when(mapImpl).removeEdgeIndex(Mockito.<EdgeSeed>any(), Mockito.<Element>any());
    doNothing().when(mapImpl).removeEntityIndex(Mockito.<EntitySeed>any(), Mockito.<Element>any());
    when(mapImpl.isAggregationEnabled(Mockito.<Element>any())).thenReturn(false);
    when(mapImpl.isMaintainIndex()).thenReturn(true);
    doNothing().when(mapImpl).deleteNonAggElement(Mockito.<Element>any());

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("destination");
    stringSet.add("source");

    SchemaEdgeDefinition schemaEdgeDefinition = mock(SchemaEdgeDefinition.class);
    when(schemaEdgeDefinition.getProperties()).thenReturn(stringSet);
    when(schemaEdgeDefinition.containsProperty(Mockito.<String>any())).thenReturn(true);
    when(schemaEdgeDefinition.getGroupBy()).thenReturn(new HashSet<>());
    when(schemaEdgeDefinition.getValidator(anyBoolean()))
        .thenReturn(new ElementFilter.Builder().build());

    HashSet<String> stringSet2 = new HashSet<>();
    stringSet2.add("source");

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
    Long actualDoOperationResult =
        deleteElementsHandler.doOperation(deleteElements, context, store);

    // Assert
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
    verify(schema, atLeast(1)).getElement(Mockito.<String>any());
    verify(schema, atLeast(1)).getVisibilityProperty();
    verify(schemaEdgeDefinition).containsProperty("Visibility Property");
    verify(schemaEdgeDefinition).getGroupBy();
    verify(schemaEdgeDefinition).getProperties();
    verify(schemaEdgeDefinition, atLeast(1)).getValidator(true);
    assertEquals(1L, actualDoOperationResult.longValue());
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
    Mockito.<Iterable<? extends Element>>when(deleteElements.getInput())
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
    Mockito.<Iterable<? extends Element>>when(deleteElements.getInput()).thenReturn(elementList);
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
   *   <li>Then calls {@link SchemaEdgeDefinition#containsProperty(String)}.
   * </ul>
   *
   * <p>Method under test: {@link DeleteElementsHandler#doOperation(DeleteElements, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(DeleteElements, Context, Store) with 'DeleteElements', 'Context', 'Store'; then calls containsProperty(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long DeleteElementsHandler.doOperation(DeleteElements, Context, Store)"})
  void testDoOperationWithDeleteElementsContextStore_thenCallsContainsProperty() {
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

    SchemaEdgeDefinition schemaEdgeDefinition = mock(SchemaEdgeDefinition.class);
    when(schemaEdgeDefinition.containsProperty(Mockito.<String>any())).thenReturn(true);
    when(schemaEdgeDefinition.getGroupBy()).thenReturn(new HashSet<>());
    when(schemaEdgeDefinition.getValidator(anyBoolean()))
        .thenReturn(new ElementFilter.Builder().build());

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("source");

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
    Long actualDoOperationResult =
        deleteElementsHandler.doOperation(deleteElements, context, store);

    // Assert
    verify(schema).getGroups();
    verify(store).getMapImpl();
    verify(store).getProperties();
    verify(mapStoreProperties).getIngestBufferSize();
    verify(mapImpl).deleteAggElement(isA(Element.class));
    verify(mapImpl, atLeast(1)).getGroupByProperties("Group");
    verify(mapImpl, atLeast(1)).getNonGroupByProperties("Group");
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
    verify(schemaEdgeDefinition).containsProperty("Visibility Property");
    verify(schemaEdgeDefinition).getGroupBy();
    verify(schemaEdgeDefinition, atLeast(1)).getValidator(true);
    assertEquals(1L, actualDoOperationResult.longValue());
  }

  /**
   * Test {@link DeleteElementsHandler#doOperation(DeleteElements, Context, Store)} with {@code
   * DeleteElements}, {@code Context}, {@code Store}.
   *
   * <ul>
   *   <li>Then calls {@link MapImpl#deleteNonAggElement(Element)}.
   * </ul>
   *
   * <p>Method under test: {@link DeleteElementsHandler#doOperation(DeleteElements, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(DeleteElements, Context, Store) with 'DeleteElements', 'Context', 'Store'; then calls deleteNonAggElement(Element)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long DeleteElementsHandler.doOperation(DeleteElements, Context, Store)"})
  void testDoOperationWithDeleteElementsContextStore_thenCallsDeleteNonAggElement() {
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
    Mockito.<Iterable<? extends Element>>when(deleteElements.getInput()).thenReturn(elementList);
    Context context = new Context();

    MapStoreProperties mapStoreProperties = mock(MapStoreProperties.class);
    when(mapStoreProperties.getIngestBufferSize()).thenReturn(1);

    MapImpl mapImpl = mock(MapImpl.class);
    doNothing().when(mapImpl).removeEdgeIndex(Mockito.<EdgeSeed>any(), Mockito.<Element>any());
    doNothing().when(mapImpl).removeEntityIndex(Mockito.<EntitySeed>any(), Mockito.<Element>any());
    when(mapImpl.isAggregationEnabled(Mockito.<Element>any())).thenReturn(false);
    when(mapImpl.isMaintainIndex()).thenReturn(true);
    doNothing().when(mapImpl).deleteNonAggElement(Mockito.<Element>any());

    SchemaEdgeDefinition schemaEdgeDefinition = mock(SchemaEdgeDefinition.class);
    when(schemaEdgeDefinition.getProperties()).thenReturn(new HashSet<>());
    when(schemaEdgeDefinition.containsProperty(Mockito.<String>any())).thenReturn(true);
    when(schemaEdgeDefinition.getGroupBy()).thenReturn(new HashSet<>());
    when(schemaEdgeDefinition.getValidator(anyBoolean()))
        .thenReturn(new ElementFilter.Builder().build());

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("source");

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
    Long actualDoOperationResult =
        deleteElementsHandler.doOperation(deleteElements, context, store);

    // Assert
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
    verify(schema, atLeast(1)).getElement(Mockito.<String>any());
    verify(schema, atLeast(1)).getVisibilityProperty();
    verify(schemaEdgeDefinition).containsProperty("Visibility Property");
    verify(schemaEdgeDefinition).getGroupBy();
    verify(schemaEdgeDefinition).getProperties();
    verify(schemaEdgeDefinition, atLeast(1)).getValidator(true);
    assertEquals(1L, actualDoOperationResult.longValue());
  }

  /**
   * Test {@link DeleteElementsHandler#doOperation(DeleteElements, Context, Store)} with {@code
   * DeleteElements}, {@code Context}, {@code Store}.
   *
   * <ul>
   *   <li>Then calls {@link MapImpl#deleteNonAggElement(Element)}.
   * </ul>
   *
   * <p>Method under test: {@link DeleteElementsHandler#doOperation(DeleteElements, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(DeleteElements, Context, Store) with 'DeleteElements', 'Context', 'Store'; then calls deleteNonAggElement(Element)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long DeleteElementsHandler.doOperation(DeleteElements, Context, Store)"})
  void testDoOperationWithDeleteElementsContextStore_thenCallsDeleteNonAggElement2() {
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
    Mockito.<Iterable<? extends Element>>when(deleteElements.getInput()).thenReturn(elementList);
    Context context = new Context();

    MapStoreProperties mapStoreProperties = mock(MapStoreProperties.class);
    when(mapStoreProperties.getIngestBufferSize()).thenReturn(1);

    MapImpl mapImpl = mock(MapImpl.class);
    doNothing().when(mapImpl).removeEdgeIndex(Mockito.<EdgeSeed>any(), Mockito.<Element>any());
    doNothing().when(mapImpl).removeEntityIndex(Mockito.<EntitySeed>any(), Mockito.<Element>any());
    when(mapImpl.isAggregationEnabled(Mockito.<Element>any())).thenReturn(false);
    when(mapImpl.isMaintainIndex()).thenReturn(true);
    doNothing().when(mapImpl).deleteNonAggElement(Mockito.<Element>any());

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("source");

    SchemaEdgeDefinition schemaEdgeDefinition = mock(SchemaEdgeDefinition.class);
    when(schemaEdgeDefinition.getProperties()).thenReturn(stringSet);
    when(schemaEdgeDefinition.containsProperty(Mockito.<String>any())).thenReturn(true);
    when(schemaEdgeDefinition.getGroupBy()).thenReturn(new HashSet<>());
    when(schemaEdgeDefinition.getValidator(anyBoolean()))
        .thenReturn(new ElementFilter.Builder().build());

    HashSet<String> stringSet2 = new HashSet<>();
    stringSet2.add("source");

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
    Long actualDoOperationResult =
        deleteElementsHandler.doOperation(deleteElements, context, store);

    // Assert
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
    verify(schema, atLeast(1)).getElement(Mockito.<String>any());
    verify(schema, atLeast(1)).getVisibilityProperty();
    verify(schemaEdgeDefinition).containsProperty("Visibility Property");
    verify(schemaEdgeDefinition).getGroupBy();
    verify(schemaEdgeDefinition).getProperties();
    verify(schemaEdgeDefinition, atLeast(1)).getValidator(true);
    assertEquals(1L, actualDoOperationResult.longValue());
  }

  /**
   * Test {@link DeleteElementsHandler#doOperation(DeleteElements, Context, Store)} with {@code
   * DeleteElements}, {@code Context}, {@code Store}.
   *
   * <ul>
   *   <li>Then return longValue is zero.
   * </ul>
   *
   * <p>Method under test: {@link DeleteElementsHandler#doOperation(DeleteElements, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(DeleteElements, Context, Store) with 'DeleteElements', 'Context', 'Store'; then return longValue is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long DeleteElementsHandler.doOperation(DeleteElements, Context, Store)"})
  void testDoOperationWithDeleteElementsContextStore_thenReturnLongValueIsZero() {
    // Arrange
    DeleteElementsHandler deleteElementsHandler = new DeleteElementsHandler();

    DeleteElements deleteElements = mock(DeleteElements.class);
    when(deleteElements.isSkipInvalidElements()).thenReturn(true);
    when(deleteElements.isValidate()).thenReturn(true);
    Mockito.<Iterable<? extends Element>>when(deleteElements.getInput())
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
   *   <li>Then return longValue is zero.
   * </ul>
   *
   * <p>Method under test: {@link DeleteElementsHandler#doOperation(DeleteElements, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(DeleteElements, Context, Store) with 'DeleteElements', 'Context', 'Store'; then return longValue is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long DeleteElementsHandler.doOperation(DeleteElements, Context, Store)"})
  void testDoOperationWithDeleteElementsContextStore_thenReturnLongValueIsZero2() {
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
    Mockito.<Iterable<? extends Element>>when(deleteElements.getInput()).thenReturn(elementList);
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
