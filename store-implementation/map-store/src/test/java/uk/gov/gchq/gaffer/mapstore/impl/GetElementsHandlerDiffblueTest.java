package uk.gov.gchq.gaffer.mapstore.impl;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uk.gov.gchq.gaffer.commonutil.iterable.EmptyIterable;
import uk.gov.gchq.gaffer.commonutil.iterable.EmptyIterator;
import uk.gov.gchq.gaffer.data.element.Edge;
import uk.gov.gchq.gaffer.data.element.Edge.Builder;
import uk.gov.gchq.gaffer.data.element.Element;
import uk.gov.gchq.gaffer.data.element.id.DirectedType;
import uk.gov.gchq.gaffer.data.element.id.EdgeId;
import uk.gov.gchq.gaffer.data.element.id.EdgeId.MatchedVertex;
import uk.gov.gchq.gaffer.data.element.id.ElementId;
import uk.gov.gchq.gaffer.data.element.id.EntityId;
import uk.gov.gchq.gaffer.data.elementdefinition.view.NamedView;
import uk.gov.gchq.gaffer.data.elementdefinition.view.View;
import uk.gov.gchq.gaffer.mapstore.MapStore;
import uk.gov.gchq.gaffer.mapstore.MapStoreProperties;
import uk.gov.gchq.gaffer.operation.OperationException;
import uk.gov.gchq.gaffer.operation.graph.SeededGraphFilters;
import uk.gov.gchq.gaffer.operation.graph.SeededGraphFilters.IncludeIncomingOutgoingType;
import uk.gov.gchq.gaffer.operation.impl.get.GetElements;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.Store;
import uk.gov.gchq.gaffer.store.schema.Schema;

class GetElementsHandlerDiffblueTest {
  /**
   * Test {@link GetElementsHandler#doOperation(GetElements, Context, Store)} with {@code
   * operation}, {@code context}, {@code store}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link GetElementsHandler#doOperation(GetElements, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(GetElements, Context, Store) with 'operation', 'context', 'store'; given ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable GetElementsHandler.doOperation(GetElements, Context, Store)"})
  void testDoOperationWithOperationContextStore_givenArrayList() throws OperationException {
    // Arrange
    GetElementsHandler getElementsHandler = new GetElementsHandler();

    GetElements operation = mock(GetElements.class);
    Mockito.<Iterable<? extends ElementId>>when(operation.getInput()).thenReturn(new ArrayList<>());
    when(operation.getView()).thenReturn(new View());
    Context context = new Context();

    MapStore store = mock(MapStore.class);
    when(store.getTraits()).thenReturn(new HashSet<>());
    when(store.getSchema()).thenReturn(new Schema());
    Schema schema = new Schema();
    MapImpl mapImpl = new MapImpl(schema, new MapStoreProperties());
    when(store.getMapImpl()).thenReturn(mapImpl);

    // Act
    Iterator<Element> actualIteratorResult =
        getElementsHandler.doOperation(operation, context, store).iterator();

    // Assert
    verify(store).getMapImpl();
    verify(store).getTraits();
    verify(operation, atLeast(1)).getInput();
    verify(operation).getView();
    verify(store).getSchema();
    assertFalse(actualIteratorResult.hasNext());
  }

  /**
   * Test {@link GetElementsHandler#doOperation(GetElements, Context, Store)} with {@code
   * operation}, {@code context}, {@code store}.
   *
   * <ul>
   *   <li>Given {@code DIRECTED}.
   * </ul>
   *
   * <p>Method under test: {@link GetElementsHandler#doOperation(GetElements, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(GetElements, Context, Store) with 'operation', 'context', 'store'; given 'DIRECTED'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable GetElementsHandler.doOperation(GetElements, Context, Store)"})
  void testDoOperationWithOperationContextStore_givenDirected() throws OperationException {
    // Arrange
    GetElementsHandler getElementsHandler = new GetElementsHandler();

    ArrayList<ElementId> elementIdList = new ArrayList<>();
    elementIdList.add(
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build());

    GetElements operation = mock(GetElements.class);
    when(operation.getDirectedType()).thenReturn(DirectedType.DIRECTED);
    when(operation.getIncludeIncomingOutGoing()).thenReturn(IncludeIncomingOutgoingType.EITHER);
    Mockito.<Iterable<? extends ElementId>>when(operation.getInput()).thenReturn(elementIdList);
    when(operation.getView()).thenReturn(new View());
    Context context = new Context();

    MapStore store = mock(MapStore.class);
    when(store.getTraits()).thenReturn(new HashSet<>());
    when(store.getSchema()).thenReturn(new Schema());
    Schema schema = new Schema();
    MapImpl mapImpl = new MapImpl(schema, new MapStoreProperties());
    when(store.getMapImpl()).thenReturn(mapImpl);

    // Act
    Iterator<Element> actualIteratorResult =
        getElementsHandler.doOperation(operation, context, store).iterator();

    // Assert
    verify(store).getMapImpl();
    verify(store).getTraits();
    verify(operation).getDirectedType();
    verify(operation).getIncludeIncomingOutGoing();
    verify(operation, atLeast(1)).getInput();
    verify(operation, atLeast(1)).getView();
    verify(store).getSchema();
    assertFalse(actualIteratorResult.hasNext());
  }

  /**
   * Test {@link GetElementsHandler#doOperation(GetElements, Context, Store)} with {@code
   * operation}, {@code context}, {@code store}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link GetElementsHandler#doOperation(GetElements, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(GetElements, Context, Store) with 'operation', 'context', 'store'; given HashSet() add 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable GetElementsHandler.doOperation(GetElements, Context, Store)"})
  void testDoOperationWithOperationContextStore_givenHashSetAddFoo() throws OperationException {
    // Arrange
    GetElementsHandler getElementsHandler = new GetElementsHandler();

    ArrayList<ElementId> elementIdList = new ArrayList<>();
    elementIdList.add(
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build());

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("foo");

    NamedView namedView = mock(NamedView.class);
    when(namedView.hasEntities()).thenReturn(true);
    when(namedView.hasEdges()).thenReturn(true);
    when(namedView.getEdgeGroups()).thenReturn(stringSet);
    when(namedView.getEntityGroups()).thenReturn(new HashSet<>());
    when(namedView.getGroups()).thenReturn(new HashSet<>());

    GetElements operation = mock(GetElements.class);
    when(operation.getDirectedType()).thenReturn(DirectedType.EITHER);
    when(operation.getIncludeIncomingOutGoing()).thenReturn(IncludeIncomingOutgoingType.EITHER);
    Mockito.<Iterable<? extends ElementId>>when(operation.getInput()).thenReturn(elementIdList);
    when(operation.getView()).thenReturn(namedView);
    Context context = new Context();

    MapStore store = mock(MapStore.class);
    when(store.getTraits()).thenReturn(new HashSet<>());
    when(store.getSchema()).thenReturn(new Schema());
    Schema schema = new Schema();
    MapImpl mapImpl = new MapImpl(schema, new MapStoreProperties());
    when(store.getMapImpl()).thenReturn(mapImpl);

    // Act
    Iterator<Element> actualIteratorResult =
        getElementsHandler.doOperation(operation, context, store).iterator();

    // Assert
    verify(namedView).getEdgeGroups();
    verify(namedView).getEntityGroups();
    verify(namedView, atLeast(1)).getGroups();
    verify(namedView).hasEdges();
    verify(namedView).hasEntities();
    verify(store).getMapImpl();
    verify(store).getTraits();
    verify(operation).getDirectedType();
    verify(operation).getIncludeIncomingOutGoing();
    verify(operation, atLeast(1)).getInput();
    verify(operation, atLeast(1)).getView();
    verify(store).getSchema();
    assertFalse(actualIteratorResult.hasNext());
  }

  /**
   * Test {@link GetElementsHandler#doOperation(GetElements, Context, Store)} with {@code
   * operation}, {@code context}, {@code store}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link GetElementsHandler#doOperation(GetElements, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(GetElements, Context, Store) with 'operation', 'context', 'store'; given HashSet() add 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable GetElementsHandler.doOperation(GetElements, Context, Store)"})
  void testDoOperationWithOperationContextStore_givenHashSetAddFoo2() throws OperationException {
    // Arrange
    GetElementsHandler getElementsHandler = new GetElementsHandler();

    ArrayList<ElementId> elementIdList = new ArrayList<>();
    elementIdList.add(
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build());

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("foo");

    NamedView namedView = mock(NamedView.class);
    when(namedView.hasEntities()).thenReturn(true);
    when(namedView.hasEdges()).thenReturn(true);
    when(namedView.getEntityGroups()).thenReturn(stringSet);
    when(namedView.getGroups()).thenReturn(new HashSet<>());

    GetElements operation = mock(GetElements.class);
    when(operation.getDirectedType()).thenReturn(DirectedType.EITHER);
    when(operation.getIncludeIncomingOutGoing()).thenReturn(IncludeIncomingOutgoingType.EITHER);
    Mockito.<Iterable<? extends ElementId>>when(operation.getInput()).thenReturn(elementIdList);
    when(operation.getView()).thenReturn(namedView);
    Context context = new Context();

    MapStore store = mock(MapStore.class);
    when(store.getTraits()).thenReturn(new HashSet<>());
    when(store.getSchema()).thenReturn(new Schema());
    Schema schema = new Schema();
    MapImpl mapImpl = new MapImpl(schema, new MapStoreProperties());
    when(store.getMapImpl()).thenReturn(mapImpl);

    // Act
    Iterator<Element> actualIteratorResult =
        getElementsHandler.doOperation(operation, context, store).iterator();

    // Assert
    verify(namedView).getEntityGroups();
    verify(namedView, atLeast(1)).getGroups();
    verify(namedView).hasEdges();
    verify(namedView).hasEntities();
    verify(store).getMapImpl();
    verify(store).getTraits();
    verify(operation).getDirectedType();
    verify(operation).getIncludeIncomingOutGoing();
    verify(operation, atLeast(1)).getInput();
    verify(operation, atLeast(1)).getView();
    verify(store).getSchema();
    assertFalse(actualIteratorResult.hasNext());
  }

  /**
   * Test {@link GetElementsHandler#doOperation(GetElements, Context, Store)} with {@code
   * operation}, {@code context}, {@code store}.
   *
   * <ul>
   *   <li>Given {@link NamedView} {@link NamedView#hasEntities()} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link GetElementsHandler#doOperation(GetElements, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(GetElements, Context, Store) with 'operation', 'context', 'store'; given NamedView hasEntities() return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable GetElementsHandler.doOperation(GetElements, Context, Store)"})
  void testDoOperationWithOperationContextStore_givenNamedViewHasEntitiesReturnFalse()
      throws OperationException {
    // Arrange
    GetElementsHandler getElementsHandler = new GetElementsHandler();

    ArrayList<ElementId> elementIdList = new ArrayList<>();
    elementIdList.add(
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build());

    NamedView namedView = mock(NamedView.class);
    when(namedView.hasEntities()).thenReturn(false);
    when(namedView.hasEdges()).thenReturn(true);
    when(namedView.getEdgeGroups()).thenReturn(new HashSet<>());
    when(namedView.getEntityGroups()).thenReturn(new HashSet<>());
    when(namedView.getGroups()).thenReturn(new HashSet<>());

    GetElements operation = mock(GetElements.class);
    when(operation.getDirectedType()).thenReturn(DirectedType.EITHER);
    when(operation.getIncludeIncomingOutGoing()).thenReturn(IncludeIncomingOutgoingType.EITHER);
    Mockito.<Iterable<? extends ElementId>>when(operation.getInput()).thenReturn(elementIdList);
    when(operation.getView()).thenReturn(namedView);
    Context context = new Context();

    MapStore store = mock(MapStore.class);
    when(store.getTraits()).thenReturn(new HashSet<>());
    when(store.getSchema()).thenReturn(new Schema());
    Schema schema = new Schema();
    MapImpl mapImpl = new MapImpl(schema, new MapStoreProperties());
    when(store.getMapImpl()).thenReturn(mapImpl);

    // Act
    Iterator<Element> actualIteratorResult =
        getElementsHandler.doOperation(operation, context, store).iterator();

    // Assert
    verify(namedView).getEdgeGroups();
    verify(namedView).getEntityGroups();
    verify(namedView, atLeast(1)).getGroups();
    verify(namedView).hasEdges();
    verify(namedView).hasEntities();
    verify(store).getMapImpl();
    verify(store).getTraits();
    verify(operation).getDirectedType();
    verify(operation).getIncludeIncomingOutGoing();
    verify(operation, atLeast(1)).getInput();
    verify(operation, atLeast(1)).getView();
    verify(store).getSchema();
    assertFalse(actualIteratorResult.hasNext());
  }

  /**
   * Test {@link GetElementsHandler#doOperation(GetElements, Context, Store)} with {@code
   * operation}, {@code context}, {@code store}.
   *
   * <ul>
   *   <li>Given {@code UNDIRECTED}.
   * </ul>
   *
   * <p>Method under test: {@link GetElementsHandler#doOperation(GetElements, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(GetElements, Context, Store) with 'operation', 'context', 'store'; given 'UNDIRECTED'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable GetElementsHandler.doOperation(GetElements, Context, Store)"})
  void testDoOperationWithOperationContextStore_givenUndirected() throws OperationException {
    // Arrange
    GetElementsHandler getElementsHandler = new GetElementsHandler();

    ArrayList<ElementId> elementIdList = new ArrayList<>();
    elementIdList.add(
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build());

    GetElements operation = mock(GetElements.class);
    when(operation.getDirectedType()).thenReturn(DirectedType.UNDIRECTED);
    when(operation.getIncludeIncomingOutGoing()).thenReturn(IncludeIncomingOutgoingType.EITHER);
    Mockito.<Iterable<? extends ElementId>>when(operation.getInput()).thenReturn(elementIdList);
    when(operation.getView()).thenReturn(new View());
    Context context = new Context();

    MapStore store = mock(MapStore.class);
    when(store.getTraits()).thenReturn(new HashSet<>());
    when(store.getSchema()).thenReturn(new Schema());
    Schema schema = new Schema();
    MapImpl mapImpl = new MapImpl(schema, new MapStoreProperties());
    when(store.getMapImpl()).thenReturn(mapImpl);

    // Act
    Iterator<Element> actualIteratorResult =
        getElementsHandler.doOperation(operation, context, store).iterator();

    // Assert
    verify(store).getMapImpl();
    verify(store).getTraits();
    verify(operation).getDirectedType();
    verify(operation).getIncludeIncomingOutGoing();
    verify(operation, atLeast(1)).getInput();
    verify(operation, atLeast(1)).getView();
    verify(store).getSchema();
    assertFalse(actualIteratorResult.hasNext());
  }

  /**
   * Test {@link GetElementsHandler#doOperation(GetElements, Context, Store)} with {@code
   * operation}, {@code context}, {@code store}.
   *
   * <ul>
   *   <li>Given {@link View} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link GetElementsHandler#doOperation(GetElements, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(GetElements, Context, Store) with 'operation', 'context', 'store'; given View (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable GetElementsHandler.doOperation(GetElements, Context, Store)"})
  void testDoOperationWithOperationContextStore_givenView() throws OperationException {
    // Arrange
    GetElementsHandler getElementsHandler = new GetElementsHandler();

    ArrayList<ElementId> elementIdList = new ArrayList<>();
    elementIdList.add(
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build());

    GetElements operation = mock(GetElements.class);
    when(operation.getDirectedType()).thenReturn(DirectedType.EITHER);
    when(operation.getIncludeIncomingOutGoing()).thenReturn(IncludeIncomingOutgoingType.EITHER);
    Mockito.<Iterable<? extends ElementId>>when(operation.getInput()).thenReturn(elementIdList);
    when(operation.getView()).thenReturn(new View());
    Context context = new Context();

    MapStore store = mock(MapStore.class);
    when(store.getTraits()).thenReturn(new HashSet<>());
    when(store.getSchema()).thenReturn(new Schema());
    Schema schema = new Schema();
    MapImpl mapImpl = new MapImpl(schema, new MapStoreProperties());
    when(store.getMapImpl()).thenReturn(mapImpl);

    // Act
    Iterator<Element> actualIteratorResult =
        getElementsHandler.doOperation(operation, context, store).iterator();

    // Assert
    verify(store).getMapImpl();
    verify(store).getTraits();
    verify(operation).getDirectedType();
    verify(operation).getIncludeIncomingOutGoing();
    verify(operation, atLeast(1)).getInput();
    verify(operation, atLeast(1)).getView();
    verify(store).getSchema();
    assertFalse(actualIteratorResult.hasNext());
  }

  /**
   * Test {@link GetElementsHandler#doOperation(GetElements, Context, Store)} with {@code
   * operation}, {@code context}, {@code store}.
   *
   * <ul>
   *   <li>Given {@link View} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link GetElementsHandler#doOperation(GetElements, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(GetElements, Context, Store) with 'operation', 'context', 'store'; given View (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable GetElementsHandler.doOperation(GetElements, Context, Store)"})
  void testDoOperationWithOperationContextStore_givenView2() throws OperationException {
    // Arrange
    GetElementsHandler getElementsHandler = new GetElementsHandler();

    ArrayList<ElementId> elementIdList = new ArrayList<>();
    elementIdList.add(
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build());
    elementIdList.add(
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build());

    GetElements operation = mock(GetElements.class);
    when(operation.getDirectedType()).thenReturn(DirectedType.EITHER);
    when(operation.getIncludeIncomingOutGoing()).thenReturn(IncludeIncomingOutgoingType.EITHER);
    Mockito.<Iterable<? extends ElementId>>when(operation.getInput()).thenReturn(elementIdList);
    when(operation.getView()).thenReturn(new View());
    Context context = new Context();

    MapStore store = mock(MapStore.class);
    when(store.getTraits()).thenReturn(new HashSet<>());
    when(store.getSchema()).thenReturn(new Schema());
    Schema schema = new Schema();
    MapImpl mapImpl = new MapImpl(schema, new MapStoreProperties());
    when(store.getMapImpl()).thenReturn(mapImpl);

    // Act
    Iterator<Element> actualIteratorResult =
        getElementsHandler.doOperation(operation, context, store).iterator();

    // Assert
    verify(store).getMapImpl();
    verify(store).getTraits();
    verify(operation, atLeast(1)).getDirectedType();
    verify(operation, atLeast(1)).getIncludeIncomingOutGoing();
    verify(operation, atLeast(1)).getInput();
    verify(operation, atLeast(1)).getView();
    verify(store).getSchema();
    assertFalse(actualIteratorResult.hasNext());
  }

  /**
   * Test {@link GetElementsHandler#doOperation(GetElements, Context, Store)} with {@code
   * operation}, {@code context}, {@code store}.
   *
   * <ul>
   *   <li>Then calls {@link NamedView#getEdgeGroups()}.
   * </ul>
   *
   * <p>Method under test: {@link GetElementsHandler#doOperation(GetElements, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(GetElements, Context, Store) with 'operation', 'context', 'store'; then calls getEdgeGroups()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable GetElementsHandler.doOperation(GetElements, Context, Store)"})
  void testDoOperationWithOperationContextStore_thenCallsGetEdgeGroups() throws OperationException {
    // Arrange
    GetElementsHandler getElementsHandler = new GetElementsHandler();

    ArrayList<ElementId> elementIdList = new ArrayList<>();
    elementIdList.add(
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build());

    NamedView namedView = mock(NamedView.class);
    when(namedView.hasEntities()).thenReturn(true);
    when(namedView.hasEdges()).thenReturn(true);
    when(namedView.getEdgeGroups()).thenReturn(new HashSet<>());
    when(namedView.getEntityGroups()).thenReturn(new HashSet<>());
    when(namedView.getGroups()).thenReturn(new HashSet<>());

    GetElements operation = mock(GetElements.class);
    when(operation.getDirectedType()).thenReturn(DirectedType.EITHER);
    when(operation.getIncludeIncomingOutGoing()).thenReturn(IncludeIncomingOutgoingType.EITHER);
    Mockito.<Iterable<? extends ElementId>>when(operation.getInput()).thenReturn(elementIdList);
    when(operation.getView()).thenReturn(namedView);
    Context context = new Context();

    MapStore store = mock(MapStore.class);
    when(store.getTraits()).thenReturn(new HashSet<>());
    when(store.getSchema()).thenReturn(new Schema());
    Schema schema = new Schema();
    MapImpl mapImpl = new MapImpl(schema, new MapStoreProperties());
    when(store.getMapImpl()).thenReturn(mapImpl);

    // Act
    Iterator<Element> actualIteratorResult =
        getElementsHandler.doOperation(operation, context, store).iterator();

    // Assert
    verify(namedView).getEdgeGroups();
    verify(namedView).getEntityGroups();
    verify(namedView, atLeast(1)).getGroups();
    verify(namedView).hasEdges();
    verify(namedView).hasEntities();
    verify(store).getMapImpl();
    verify(store).getTraits();
    verify(operation).getDirectedType();
    verify(operation).getIncludeIncomingOutGoing();
    verify(operation, atLeast(1)).getInput();
    verify(operation, atLeast(1)).getView();
    verify(store).getSchema();
    assertFalse(actualIteratorResult.hasNext());
  }

  /**
   * Test {@link GetElementsHandler#doOperation(GetElements, Context, Store)} with {@code
   * operation}, {@code context}, {@code store}.
   *
   * <ul>
   *   <li>Then calls {@link MapImpl#isMaintainIndex()}.
   * </ul>
   *
   * <p>Method under test: {@link GetElementsHandler#doOperation(GetElements, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(GetElements, Context, Store) with 'operation', 'context', 'store'; then calls isMaintainIndex()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable GetElementsHandler.doOperation(GetElements, Context, Store)"})
  void testDoOperationWithOperationContextStore_thenCallsIsMaintainIndex()
      throws OperationException {
    // Arrange
    GetElementsHandler getElementsHandler = new GetElementsHandler();

    ArrayList<ElementId> elementIdList = new ArrayList<>();
    elementIdList.add(
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build());

    NamedView namedView = mock(NamedView.class);
    when(namedView.hasEntities()).thenReturn(true);
    when(namedView.hasEdges()).thenReturn(true);
    when(namedView.getEdgeGroups()).thenReturn(new HashSet<>());
    when(namedView.getEntityGroups()).thenReturn(new HashSet<>());
    when(namedView.getGroups()).thenReturn(new HashSet<>());

    GetElements operation = mock(GetElements.class);
    when(operation.getDirectedType()).thenReturn(DirectedType.EITHER);
    when(operation.getIncludeIncomingOutGoing()).thenReturn(IncludeIncomingOutgoingType.EITHER);
    Mockito.<Iterable<? extends ElementId>>when(operation.getInput()).thenReturn(elementIdList);
    when(operation.getView()).thenReturn(namedView);
    Context context = new Context();

    MapImpl mapImpl = mock(MapImpl.class);
    when(mapImpl.lookup(Mockito.<EdgeId>any())).thenReturn(new ArrayList<>());
    when(mapImpl.lookup(Mockito.<EntityId>any())).thenReturn(new ArrayList<>());
    when(mapImpl.isMaintainIndex()).thenReturn(true);

    MapStore store = mock(MapStore.class);
    when(store.getTraits()).thenReturn(new HashSet<>());
    when(store.getSchema()).thenReturn(new Schema());
    when(store.getMapImpl()).thenReturn(mapImpl);

    // Act
    Iterator<Element> actualIteratorResult =
        getElementsHandler.doOperation(operation, context, store).iterator();

    // Assert
    verify(namedView).getEdgeGroups();
    verify(namedView).getEntityGroups();
    verify(namedView, atLeast(1)).getGroups();
    verify(namedView).hasEdges();
    verify(namedView).hasEntities();
    verify(store).getMapImpl();
    verify(store).getTraits();
    verify(mapImpl).isMaintainIndex();
    verify(mapImpl).lookup(isA(EdgeId.class));
    verify(mapImpl, atLeast(1)).lookup(Mockito.<EntityId>any());
    verify(operation).getDirectedType();
    verify(operation).getIncludeIncomingOutGoing();
    verify(operation, atLeast(1)).getInput();
    verify(operation, atLeast(1)).getView();
    verify(store).getSchema();
    assertFalse(actualIteratorResult.hasNext());
  }

  /**
   * Test {@link GetElementsHandler#doOperation(GetElements, Context, Store)} with {@code
   * operation}, {@code context}, {@code store}.
   *
   * <ul>
   *   <li>Then calls {@link MapImpl#isMaintainIndex()}.
   * </ul>
   *
   * <p>Method under test: {@link GetElementsHandler#doOperation(GetElements, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(GetElements, Context, Store) with 'operation', 'context', 'store'; then calls isMaintainIndex()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable GetElementsHandler.doOperation(GetElements, Context, Store)"})
  void testDoOperationWithOperationContextStore_thenCallsIsMaintainIndex2()
      throws OperationException {
    // Arrange
    GetElementsHandler getElementsHandler = new GetElementsHandler();

    ArrayList<ElementId> elementIdList = new ArrayList<>();
    elementIdList.add(
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build());

    NamedView namedView = mock(NamedView.class);
    when(namedView.hasEntities()).thenReturn(true);
    when(namedView.hasEdges()).thenReturn(true);
    when(namedView.getEdgeGroups()).thenReturn(new HashSet<>());
    when(namedView.getEntityGroups()).thenReturn(new HashSet<>());
    when(namedView.getGroups()).thenReturn(new HashSet<>());

    GetElements operation = mock(GetElements.class);
    when(operation.getDirectedType()).thenReturn(DirectedType.EITHER);
    when(operation.getIncludeIncomingOutGoing()).thenReturn(IncludeIncomingOutgoingType.EITHER);
    Mockito.<Iterable<? extends ElementId>>when(operation.getInput()).thenReturn(elementIdList);
    when(operation.getView()).thenReturn(namedView);
    Context context = new Context();

    ArrayList<Element> elementList = new ArrayList<>();
    elementList.add(
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build());

    MapImpl mapImpl = mock(MapImpl.class);
    when(mapImpl.lookup(Mockito.<EdgeId>any())).thenReturn(elementList);
    when(mapImpl.lookup(Mockito.<EntityId>any())).thenReturn(new ArrayList<>());
    when(mapImpl.isMaintainIndex()).thenReturn(true);

    MapStore store = mock(MapStore.class);
    when(store.getTraits()).thenReturn(new HashSet<>());
    when(store.getSchema()).thenReturn(new Schema());
    when(store.getMapImpl()).thenReturn(mapImpl);

    // Act
    Iterator<Element> actualIteratorResult =
        getElementsHandler.doOperation(operation, context, store).iterator();

    // Assert
    verify(namedView).getEdgeGroups();
    verify(namedView).getEntityGroups();
    verify(namedView, atLeast(1)).getGroups();
    verify(namedView).hasEdges();
    verify(namedView).hasEntities();
    verify(store).getMapImpl();
    verify(store).getTraits();
    verify(mapImpl).isMaintainIndex();
    verify(mapImpl).lookup(isA(EdgeId.class));
    verify(mapImpl, atLeast(1)).lookup(Mockito.<EntityId>any());
    verify(operation).getDirectedType();
    verify(operation).getIncludeIncomingOutGoing();
    verify(operation, atLeast(1)).getInput();
    verify(operation, atLeast(1)).getView();
    verify(store).getSchema();
    assertFalse(actualIteratorResult.hasNext());
  }

  /**
   * Test {@link GetElementsHandler#doOperation(GetElements, Context, Store)} with {@code
   * operation}, {@code context}, {@code store}.
   *
   * <ul>
   *   <li>When {@link GetElements} (default constructor).
   *   <li>Then return {@link EmptyIterable}.
   * </ul>
   *
   * <p>Method under test: {@link GetElementsHandler#doOperation(GetElements, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(GetElements, Context, Store) with 'operation', 'context', 'store'; when GetElements (default constructor); then return EmptyIterable")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable GetElementsHandler.doOperation(GetElements, Context, Store)"})
  void testDoOperationWithOperationContextStore_whenGetElements_thenReturnEmptyIterable()
      throws OperationException {
    // Arrange
    GetElementsHandler getElementsHandler = new GetElementsHandler();
    GetElements operation = new GetElements();
    Context context = new Context();

    MapStore store = mock(MapStore.class);
    Schema schema = new Schema();
    MapImpl mapImpl = new MapImpl(schema, new MapStoreProperties());
    when(store.getMapImpl()).thenReturn(mapImpl);

    // Act
    Iterable<Element> actualDoOperationResult =
        getElementsHandler.doOperation(operation, context, store);
    Iterator<Element> actualIteratorResult = actualDoOperationResult.iterator();

    // Assert
    verify(store).getMapImpl();
    assertTrue(actualDoOperationResult instanceof EmptyIterable);
    Iterator<Element> iteratorResult = actualDoOperationResult.iterator();
    assertTrue(iteratorResult instanceof EmptyIterator);
    assertTrue(actualIteratorResult instanceof EmptyIterator);
    assertFalse(iteratorResult.hasNext());
  }
}
