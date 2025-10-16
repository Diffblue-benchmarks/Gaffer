package uk.gov.gchq.gaffer.store.operation.handler.function;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uk.gov.gchq.gaffer.data.element.Edge;
import uk.gov.gchq.gaffer.data.element.Edge.Builder;
import uk.gov.gchq.gaffer.data.element.Element;
import uk.gov.gchq.gaffer.data.element.id.DirectedType;
import uk.gov.gchq.gaffer.data.element.id.EdgeId;
import uk.gov.gchq.gaffer.data.element.id.EdgeId.MatchedVertex;
import uk.gov.gchq.gaffer.operation.OperationException;
import uk.gov.gchq.gaffer.operation.impl.function.Aggregate;
import uk.gov.gchq.gaffer.operation.util.AggregatePair;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.Store;
import uk.gov.gchq.gaffer.store.operation.handler.TestAddToGraphLibraryImpl;
import uk.gov.gchq.gaffer.store.schema.Schema;
import uk.gov.gchq.gaffer.store.schema.SchemaEdgeDefinition;
import uk.gov.gchq.gaffer.store.schema.SchemaEntityDefinition;
import uk.gov.gchq.koryphe.iterable.ChainedIterable;
import uk.gov.gchq.koryphe.iterable.ChainedIterator;
import uk.gov.gchq.koryphe.tuple.binaryoperator.TupleAdaptedBinaryOperator;

class AggregateHandlerDiffblueTest {
  /**
   * Test {@link AggregateHandler#doOperation(Aggregate, Context, Store)} with {@code operation},
   * {@code context}, {@code store}.
   *
   * <p>Method under test: {@link AggregateHandler#doOperation(Aggregate, Context, Store)}
   */
  @Test
  @DisplayName("Test doOperation(Aggregate, Context, Store) with 'operation', 'context', 'store'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable AggregateHandler.doOperation(Aggregate, Context, Store)"})
  void testDoOperationWithOperationContextStore() throws OperationException {
    // Arrange
    AggregateHandler aggregateHandler = new AggregateHandler();

    HashMap<String, AggregatePair> stringAggregatePairMap = new HashMap<>();
    stringAggregatePairMap.put("foo", new AggregatePair());

    Aggregate operation = mock(Aggregate.class);
    Mockito.<Iterable<? extends Element>>when(operation.getInput()).thenReturn(new ArrayList<>());
    when(operation.getEdges()).thenReturn(stringAggregatePairMap);
    when(operation.getEntities()).thenReturn(new HashMap<>());
    Context context = new Context();

    Schema schema = mock(Schema.class);
    when(schema.getEdge(Mockito.<String>any())).thenReturn(new SchemaEdgeDefinition());
    when(schema.getElement(Mockito.<String>any())).thenReturn(new SchemaEdgeDefinition());
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.getGroups()).thenReturn(new HashSet<>());

    TestAddToGraphLibraryImpl store = mock(TestAddToGraphLibraryImpl.class);
    when(store.getSchema()).thenReturn(schema);

    // Act
    Iterable<? extends Element> actualDoOperationResult =
        aggregateHandler.doOperation(operation, context, store);
    Iterator<? extends Element> actualIteratorResult = actualDoOperationResult.iterator();

    // Assert
    verify(schema, atLeast(1)).getEdge("foo");
    verify(schema).getGroups();
    verify(operation, atLeast(1)).getEdges();
    verify(operation, atLeast(1)).getEntities();
    verify(operation, atLeast(1)).getInput();
    verify(store).getSchema();
    verify(schema).getAggregatedGroups();
    verify(schema).getElement("foo");
    assertTrue(actualDoOperationResult instanceof ChainedIterable);
    Iterator<? extends Element> iteratorResult = actualDoOperationResult.iterator();
    assertTrue(iteratorResult instanceof ChainedIterator);
    assertTrue(actualIteratorResult instanceof ChainedIterator);
    assertFalse(iteratorResult.hasNext());
    assertFalse(actualIteratorResult.hasNext());
  }

  /**
   * Test {@link AggregateHandler#doOperation(Aggregate, Context, Store)} with {@code operation},
   * {@code context}, {@code store}.
   *
   * <p>Method under test: {@link AggregateHandler#doOperation(Aggregate, Context, Store)}
   */
  @Test
  @DisplayName("Test doOperation(Aggregate, Context, Store) with 'operation', 'context', 'store'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable AggregateHandler.doOperation(Aggregate, Context, Store)"})
  void testDoOperationWithOperationContextStore2() throws OperationException {
    // Arrange
    AggregateHandler aggregateHandler = new AggregateHandler();

    HashMap<String, AggregatePair> stringAggregatePairMap = new HashMap<>();
    stringAggregatePairMap.put("foo", new AggregatePair("Group By"));

    Aggregate operation = mock(Aggregate.class);
    Mockito.<Iterable<? extends Element>>when(operation.getInput()).thenReturn(new ArrayList<>());
    when(operation.getEdges()).thenReturn(stringAggregatePairMap);
    when(operation.getEntities()).thenReturn(new HashMap<>());
    Context context = new Context();

    Schema schema = mock(Schema.class);
    when(schema.getEdge(Mockito.<String>any())).thenReturn(new SchemaEdgeDefinition());
    when(schema.getElement(Mockito.<String>any())).thenReturn(new SchemaEdgeDefinition());
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.getGroups()).thenReturn(new HashSet<>());

    TestAddToGraphLibraryImpl store = mock(TestAddToGraphLibraryImpl.class);
    when(store.getSchema()).thenReturn(schema);

    // Act
    Iterable<? extends Element> actualDoOperationResult =
        aggregateHandler.doOperation(operation, context, store);
    Iterator<? extends Element> actualIteratorResult = actualDoOperationResult.iterator();

    // Assert
    verify(schema, atLeast(1)).getEdge("foo");
    verify(schema).getGroups();
    verify(operation, atLeast(1)).getEdges();
    verify(operation, atLeast(1)).getEntities();
    verify(operation, atLeast(1)).getInput();
    verify(store).getSchema();
    verify(schema).getAggregatedGroups();
    verify(schema).getElement("foo");
    assertTrue(actualDoOperationResult instanceof ChainedIterable);
    Iterator<? extends Element> iteratorResult = actualDoOperationResult.iterator();
    assertTrue(iteratorResult instanceof ChainedIterator);
    assertTrue(actualIteratorResult instanceof ChainedIterator);
    assertFalse(iteratorResult.hasNext());
    assertFalse(actualIteratorResult.hasNext());
  }

  /**
   * Test {@link AggregateHandler#doOperation(Aggregate, Context, Store)} with {@code operation},
   * {@code context}, {@code store}.
   *
   * <p>Method under test: {@link AggregateHandler#doOperation(Aggregate, Context, Store)}
   */
  @Test
  @DisplayName("Test doOperation(Aggregate, Context, Store) with 'operation', 'context', 'store'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable AggregateHandler.doOperation(Aggregate, Context, Store)"})
  void testDoOperationWithOperationContextStore3() throws OperationException {
    // Arrange
    AggregateHandler aggregateHandler = new AggregateHandler();

    HashMap<String, AggregatePair> stringAggregatePairMap = new HashMap<>();
    stringAggregatePairMap.put("foo", new AggregatePair());

    HashMap<String, AggregatePair> stringAggregatePairMap2 = new HashMap<>();
    stringAggregatePairMap2.put("foo", new AggregatePair("Group By"));

    Aggregate operation = mock(Aggregate.class);
    Mockito.<Iterable<? extends Element>>when(operation.getInput()).thenReturn(new ArrayList<>());
    when(operation.getEdges()).thenReturn(stringAggregatePairMap);
    when(operation.getEntities()).thenReturn(stringAggregatePairMap2);
    Context context = new Context();

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("foo");

    Schema schema = mock(Schema.class);
    when(schema.getEntity(Mockito.<String>any())).thenReturn(new SchemaEntityDefinition());
    when(schema.getEdge(Mockito.<String>any())).thenReturn(new SchemaEdgeDefinition());
    when(schema.getElement(Mockito.<String>any())).thenReturn(new SchemaEdgeDefinition());
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.getGroups()).thenReturn(stringSet);

    TestAddToGraphLibraryImpl store = mock(TestAddToGraphLibraryImpl.class);
    when(store.getSchema()).thenReturn(schema);

    // Act
    Iterable<? extends Element> actualDoOperationResult =
        aggregateHandler.doOperation(operation, context, store);
    Iterator<? extends Element> actualIteratorResult = actualDoOperationResult.iterator();

    // Assert
    verify(schema, atLeast(1)).getEdge("foo");
    verify(schema, atLeast(1)).getEntity("foo");
    verify(schema).getGroups();
    verify(operation, atLeast(1)).getEdges();
    verify(operation, atLeast(1)).getEntities();
    verify(operation, atLeast(1)).getInput();
    verify(store).getSchema();
    verify(schema).getAggregatedGroups();
    verify(schema, atLeast(1)).getElement("foo");
    assertTrue(actualDoOperationResult instanceof ChainedIterable);
    Iterator<? extends Element> iteratorResult = actualDoOperationResult.iterator();
    assertTrue(iteratorResult instanceof ChainedIterator);
    assertTrue(actualIteratorResult instanceof ChainedIterator);
    assertFalse(iteratorResult.hasNext());
    assertFalse(actualIteratorResult.hasNext());
  }

  /**
   * Test {@link AggregateHandler#doOperation(Aggregate, Context, Store)} with {@code operation},
   * {@code context}, {@code store}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code 42} is {@link AggregatePair#AggregatePair()}.
   * </ul>
   *
   * <p>Method under test: {@link AggregateHandler#doOperation(Aggregate, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(Aggregate, Context, Store) with 'operation', 'context', 'store'; given HashMap() '42' is AggregatePair()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable AggregateHandler.doOperation(Aggregate, Context, Store)"})
  void testDoOperationWithOperationContextStore_givenHashMap42IsAggregatePair()
      throws OperationException {
    // Arrange
    AggregateHandler aggregateHandler = new AggregateHandler();

    HashMap<String, AggregatePair> stringAggregatePairMap = new HashMap<>();
    stringAggregatePairMap.put("42", new AggregatePair());
    stringAggregatePairMap.put("foo", new AggregatePair());

    Aggregate operation = mock(Aggregate.class);
    Mockito.<Iterable<? extends Element>>when(operation.getInput()).thenReturn(new ArrayList<>());
    when(operation.getEdges()).thenReturn(stringAggregatePairMap);
    when(operation.getEntities()).thenReturn(new HashMap<>());
    Context context = new Context();

    Schema schema = mock(Schema.class);
    when(schema.getEdge(Mockito.<String>any())).thenReturn(new SchemaEdgeDefinition());
    when(schema.getElement(Mockito.<String>any())).thenReturn(new SchemaEdgeDefinition());
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.getGroups()).thenReturn(new HashSet<>());

    TestAddToGraphLibraryImpl store = mock(TestAddToGraphLibraryImpl.class);
    when(store.getSchema()).thenReturn(schema);

    // Act
    Iterable<? extends Element> actualDoOperationResult =
        aggregateHandler.doOperation(operation, context, store);
    Iterator<? extends Element> actualIteratorResult = actualDoOperationResult.iterator();

    // Assert
    verify(schema, atLeast(1)).getEdge(Mockito.<String>any());
    verify(schema).getGroups();
    verify(operation, atLeast(1)).getEdges();
    verify(operation, atLeast(1)).getEntities();
    verify(operation, atLeast(1)).getInput();
    verify(store).getSchema();
    verify(schema).getAggregatedGroups();
    verify(schema, atLeast(1)).getElement(Mockito.<String>any());
    assertTrue(actualDoOperationResult instanceof ChainedIterable);
    Iterator<? extends Element> iteratorResult = actualDoOperationResult.iterator();
    assertTrue(iteratorResult instanceof ChainedIterator);
    assertTrue(actualIteratorResult instanceof ChainedIterator);
    assertFalse(iteratorResult.hasNext());
    assertFalse(actualIteratorResult.hasNext());
  }

  /**
   * Test {@link AggregateHandler#doOperation(Aggregate, Context, Store)} with {@code operation},
   * {@code context}, {@code store}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code 42}.
   *   <li>Then calls {@link Schema#getEntity(String)}.
   * </ul>
   *
   * <p>Method under test: {@link AggregateHandler#doOperation(Aggregate, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(Aggregate, Context, Store) with 'operation', 'context', 'store'; given HashSet() add '42'; then calls getEntity(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable AggregateHandler.doOperation(Aggregate, Context, Store)"})
  void testDoOperationWithOperationContextStore_givenHashSetAdd42_thenCallsGetEntity()
      throws OperationException {
    // Arrange
    AggregateHandler aggregateHandler = new AggregateHandler();

    HashMap<String, AggregatePair> stringAggregatePairMap = new HashMap<>();
    stringAggregatePairMap.put("foo", new AggregatePair());

    HashMap<String, AggregatePair> stringAggregatePairMap2 = new HashMap<>();
    stringAggregatePairMap2.put("foo", new AggregatePair());

    Aggregate operation = mock(Aggregate.class);
    Mockito.<Iterable<? extends Element>>when(operation.getInput()).thenReturn(new ArrayList<>());
    when(operation.getEdges()).thenReturn(stringAggregatePairMap);
    when(operation.getEntities()).thenReturn(stringAggregatePairMap2);
    Context context = new Context();

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("42");
    stringSet.add("foo");

    Schema schema = mock(Schema.class);
    when(schema.getEntity(Mockito.<String>any())).thenReturn(new SchemaEntityDefinition());
    when(schema.getEdge(Mockito.<String>any())).thenReturn(new SchemaEdgeDefinition());
    when(schema.getElement(Mockito.<String>any())).thenReturn(new SchemaEdgeDefinition());
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.getGroups()).thenReturn(stringSet);

    TestAddToGraphLibraryImpl store = mock(TestAddToGraphLibraryImpl.class);
    when(store.getSchema()).thenReturn(schema);

    // Act
    Iterable<? extends Element> actualDoOperationResult =
        aggregateHandler.doOperation(operation, context, store);
    Iterator<? extends Element> actualIteratorResult = actualDoOperationResult.iterator();

    // Assert
    verify(schema, atLeast(1)).getEdge("foo");
    verify(schema, atLeast(1)).getEntity("foo");
    verify(schema).getGroups();
    verify(operation, atLeast(1)).getEdges();
    verify(operation, atLeast(1)).getEntities();
    verify(operation, atLeast(1)).getInput();
    verify(store).getSchema();
    verify(schema).getAggregatedGroups();
    verify(schema, atLeast(1)).getElement(Mockito.<String>any());
    assertTrue(actualDoOperationResult instanceof ChainedIterable);
    Iterator<? extends Element> iteratorResult = actualDoOperationResult.iterator();
    assertTrue(iteratorResult instanceof ChainedIterator);
    assertTrue(actualIteratorResult instanceof ChainedIterator);
    assertFalse(iteratorResult.hasNext());
    assertFalse(actualIteratorResult.hasNext());
  }

  /**
   * Test {@link AggregateHandler#doOperation(Aggregate, Context, Store)} with {@code operation},
   * {@code context}, {@code store}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code foo}.
   *   <li>Then calls {@link Schema#getEntity(String)}.
   * </ul>
   *
   * <p>Method under test: {@link AggregateHandler#doOperation(Aggregate, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(Aggregate, Context, Store) with 'operation', 'context', 'store'; given HashSet() add 'foo'; then calls getEntity(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable AggregateHandler.doOperation(Aggregate, Context, Store)"})
  void testDoOperationWithOperationContextStore_givenHashSetAddFoo_thenCallsGetEntity()
      throws OperationException {
    // Arrange
    AggregateHandler aggregateHandler = new AggregateHandler();

    HashMap<String, AggregatePair> stringAggregatePairMap = new HashMap<>();
    stringAggregatePairMap.put("foo", new AggregatePair());

    HashMap<String, AggregatePair> stringAggregatePairMap2 = new HashMap<>();
    stringAggregatePairMap2.put("foo", new AggregatePair());

    Aggregate operation = mock(Aggregate.class);
    Mockito.<Iterable<? extends Element>>when(operation.getInput()).thenReturn(new ArrayList<>());
    when(operation.getEdges()).thenReturn(stringAggregatePairMap);
    when(operation.getEntities()).thenReturn(stringAggregatePairMap2);
    Context context = new Context();

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("foo");

    Schema schema = mock(Schema.class);
    when(schema.getEntity(Mockito.<String>any())).thenReturn(new SchemaEntityDefinition());
    when(schema.getEdge(Mockito.<String>any())).thenReturn(new SchemaEdgeDefinition());
    when(schema.getElement(Mockito.<String>any())).thenReturn(new SchemaEdgeDefinition());
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.getGroups()).thenReturn(stringSet);

    TestAddToGraphLibraryImpl store = mock(TestAddToGraphLibraryImpl.class);
    when(store.getSchema()).thenReturn(schema);

    // Act
    Iterable<? extends Element> actualDoOperationResult =
        aggregateHandler.doOperation(operation, context, store);
    Iterator<? extends Element> actualIteratorResult = actualDoOperationResult.iterator();

    // Assert
    verify(schema, atLeast(1)).getEdge("foo");
    verify(schema, atLeast(1)).getEntity("foo");
    verify(schema).getGroups();
    verify(operation, atLeast(1)).getEdges();
    verify(operation, atLeast(1)).getEntities();
    verify(operation, atLeast(1)).getInput();
    verify(store).getSchema();
    verify(schema).getAggregatedGroups();
    verify(schema, atLeast(1)).getElement("foo");
    assertTrue(actualDoOperationResult instanceof ChainedIterable);
    Iterator<? extends Element> iteratorResult = actualDoOperationResult.iterator();
    assertTrue(iteratorResult instanceof ChainedIterator);
    assertTrue(actualIteratorResult instanceof ChainedIterator);
    assertFalse(iteratorResult.hasNext());
    assertFalse(actualIteratorResult.hasNext());
  }

  /**
   * Test {@link AggregateHandler#doOperation(Aggregate, Context, Store)} with {@code operation},
   * {@code context}, {@code store}.
   *
   * <ul>
   *   <li>Given {@link Schema#Schema()}.
   * </ul>
   *
   * <p>Method under test: {@link AggregateHandler#doOperation(Aggregate, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(Aggregate, Context, Store) with 'operation', 'context', 'store'; given Schema()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable AggregateHandler.doOperation(Aggregate, Context, Store)"})
  void testDoOperationWithOperationContextStore_givenSchema() throws OperationException {
    // Arrange
    AggregateHandler aggregateHandler = new AggregateHandler();

    Aggregate operation = mock(Aggregate.class);
    Mockito.<Iterable<? extends Element>>when(operation.getInput()).thenReturn(new ArrayList<>());
    when(operation.getEdges()).thenReturn(new HashMap<>());
    when(operation.getEntities()).thenReturn(new HashMap<>());
    Context context = new Context();

    TestAddToGraphLibraryImpl store = mock(TestAddToGraphLibraryImpl.class);
    when(store.getSchema()).thenReturn(new Schema());

    // Act
    Iterable<? extends Element> actualDoOperationResult =
        aggregateHandler.doOperation(operation, context, store);
    Iterator<? extends Element> actualIteratorResult = actualDoOperationResult.iterator();

    // Assert
    verify(operation, atLeast(1)).getEdges();
    verify(operation, atLeast(1)).getEntities();
    verify(operation, atLeast(1)).getInput();
    verify(store).getSchema();
    assertTrue(actualDoOperationResult instanceof ChainedIterable);
    Iterator<? extends Element> iteratorResult = actualDoOperationResult.iterator();
    assertTrue(iteratorResult instanceof ChainedIterator);
    assertTrue(actualIteratorResult instanceof ChainedIterator);
    assertFalse(iteratorResult.hasNext());
    assertFalse(actualIteratorResult.hasNext());
  }

  /**
   * Test {@link AggregateHandler#doOperation(Aggregate, Context, Store)} with {@code operation},
   * {@code context}, {@code store}.
   *
   * <ul>
   *   <li>Given {@link Schema} {@link Schema#getElement(String)} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AggregateHandler#doOperation(Aggregate, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(Aggregate, Context, Store) with 'operation', 'context', 'store'; given Schema getElement(String) return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable AggregateHandler.doOperation(Aggregate, Context, Store)"})
  void testDoOperationWithOperationContextStore_givenSchemaGetElementReturnNull()
      throws OperationException {
    // Arrange
    AggregateHandler aggregateHandler = new AggregateHandler();

    HashMap<String, AggregatePair> stringAggregatePairMap = new HashMap<>();
    stringAggregatePairMap.put("foo", new AggregatePair());

    HashMap<String, AggregatePair> stringAggregatePairMap2 = new HashMap<>();
    stringAggregatePairMap2.put("foo", new AggregatePair());

    Aggregate operation = mock(Aggregate.class);
    Mockito.<Iterable<? extends Element>>when(operation.getInput()).thenReturn(new ArrayList<>());
    when(operation.getEdges()).thenReturn(stringAggregatePairMap);
    when(operation.getEntities()).thenReturn(stringAggregatePairMap2);
    Context context = new Context();

    Schema schema = mock(Schema.class);
    when(schema.getEntity(Mockito.<String>any())).thenReturn(new SchemaEntityDefinition());
    when(schema.getEdge(Mockito.<String>any())).thenReturn(new SchemaEdgeDefinition());
    when(schema.getElement(Mockito.<String>any())).thenReturn(null);
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.getGroups()).thenReturn(new HashSet<>());

    TestAddToGraphLibraryImpl store = mock(TestAddToGraphLibraryImpl.class);
    when(store.getSchema()).thenReturn(schema);

    // Act
    Iterable<? extends Element> actualDoOperationResult =
        aggregateHandler.doOperation(operation, context, store);
    Iterator<? extends Element> actualIteratorResult = actualDoOperationResult.iterator();

    // Assert
    verify(schema, atLeast(1)).getEdge("foo");
    verify(schema, atLeast(1)).getEntity("foo");
    verify(schema).getGroups();
    verify(operation, atLeast(1)).getEdges();
    verify(operation, atLeast(1)).getEntities();
    verify(operation, atLeast(1)).getInput();
    verify(store).getSchema();
    verify(schema).getAggregatedGroups();
    verify(schema, atLeast(1)).getElement("foo");
    assertTrue(actualDoOperationResult instanceof ChainedIterable);
    Iterator<? extends Element> iteratorResult = actualDoOperationResult.iterator();
    assertTrue(iteratorResult instanceof ChainedIterator);
    assertTrue(actualIteratorResult instanceof ChainedIterator);
    assertFalse(iteratorResult.hasNext());
    assertFalse(actualIteratorResult.hasNext());
  }

  /**
   * Test {@link AggregateHandler#doOperation(Aggregate, Context, Store)} with {@code operation},
   * {@code context}, {@code store}.
   *
   * <ul>
   *   <li>Then calls {@link Schema#getEntity(String)}.
   * </ul>
   *
   * <p>Method under test: {@link AggregateHandler#doOperation(Aggregate, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(Aggregate, Context, Store) with 'operation', 'context', 'store'; then calls getEntity(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable AggregateHandler.doOperation(Aggregate, Context, Store)"})
  void testDoOperationWithOperationContextStore_thenCallsGetEntity() throws OperationException {
    // Arrange
    AggregateHandler aggregateHandler = new AggregateHandler();

    HashMap<String, AggregatePair> stringAggregatePairMap = new HashMap<>();
    stringAggregatePairMap.put("foo", new AggregatePair());

    HashMap<String, AggregatePair> stringAggregatePairMap2 = new HashMap<>();
    stringAggregatePairMap2.put("foo", new AggregatePair());

    Aggregate operation = mock(Aggregate.class);
    Mockito.<Iterable<? extends Element>>when(operation.getInput()).thenReturn(new ArrayList<>());
    when(operation.getEdges()).thenReturn(stringAggregatePairMap);
    when(operation.getEntities()).thenReturn(stringAggregatePairMap2);
    Context context = new Context();

    Schema schema = mock(Schema.class);
    when(schema.getEntity(Mockito.<String>any())).thenReturn(new SchemaEntityDefinition());
    when(schema.getEdge(Mockito.<String>any())).thenReturn(new SchemaEdgeDefinition());
    when(schema.getElement(Mockito.<String>any())).thenReturn(new SchemaEdgeDefinition());
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.getGroups()).thenReturn(new HashSet<>());

    TestAddToGraphLibraryImpl store = mock(TestAddToGraphLibraryImpl.class);
    when(store.getSchema()).thenReturn(schema);

    // Act
    Iterable<? extends Element> actualDoOperationResult =
        aggregateHandler.doOperation(operation, context, store);
    Iterator<? extends Element> actualIteratorResult = actualDoOperationResult.iterator();

    // Assert
    verify(schema, atLeast(1)).getEdge("foo");
    verify(schema, atLeast(1)).getEntity("foo");
    verify(schema).getGroups();
    verify(operation, atLeast(1)).getEdges();
    verify(operation, atLeast(1)).getEntities();
    verify(operation, atLeast(1)).getInput();
    verify(store).getSchema();
    verify(schema).getAggregatedGroups();
    verify(schema, atLeast(1)).getElement("foo");
    assertTrue(actualDoOperationResult instanceof ChainedIterable);
    Iterator<? extends Element> iteratorResult = actualDoOperationResult.iterator();
    assertTrue(iteratorResult instanceof ChainedIterator);
    assertTrue(actualIteratorResult instanceof ChainedIterator);
    assertFalse(iteratorResult.hasNext());
    assertFalse(actualIteratorResult.hasNext());
  }

  /**
   * Test {@link AggregateHandler#doOperation(Aggregate, Context, Store)} with {@code operation},
   * {@code context}, {@code store}.
   *
   * <ul>
   *   <li>Then calls {@link SchemaEdgeDefinition#getGroupBy()}.
   * </ul>
   *
   * <p>Method under test: {@link AggregateHandler#doOperation(Aggregate, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(Aggregate, Context, Store) with 'operation', 'context', 'store'; then calls getGroupBy()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable AggregateHandler.doOperation(Aggregate, Context, Store)"})
  void testDoOperationWithOperationContextStore_thenCallsGetGroupBy() throws OperationException {
    // Arrange
    AggregateHandler aggregateHandler = new AggregateHandler();

    HashMap<String, AggregatePair> stringAggregatePairMap = new HashMap<>();
    stringAggregatePairMap.put("foo", new AggregatePair());

    HashMap<String, AggregatePair> stringAggregatePairMap2 = new HashMap<>();
    stringAggregatePairMap2.put("foo", new AggregatePair());

    Aggregate operation = mock(Aggregate.class);
    Mockito.<Iterable<? extends Element>>when(operation.getInput()).thenReturn(new ArrayList<>());
    when(operation.getEdges()).thenReturn(stringAggregatePairMap);
    when(operation.getEntities()).thenReturn(stringAggregatePairMap2);
    Context context = new Context();

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("foo");

    SchemaEdgeDefinition schemaEdgeDefinition = mock(SchemaEdgeDefinition.class);
    Mockito.<List<TupleAdaptedBinaryOperator<String, ?>>>when(
            schemaEdgeDefinition.getOriginalAggregateFunctions())
        .thenReturn(new ArrayList<>());
    when(schemaEdgeDefinition.getGroupBy()).thenReturn(new HashSet<>());

    Schema schema = mock(Schema.class);
    when(schema.getEntity(Mockito.<String>any())).thenReturn(new SchemaEntityDefinition());
    when(schema.getEdge(Mockito.<String>any())).thenReturn(new SchemaEdgeDefinition());
    when(schema.getElement(Mockito.<String>any())).thenReturn(schemaEdgeDefinition);
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.getGroups()).thenReturn(stringSet);

    TestAddToGraphLibraryImpl store = mock(TestAddToGraphLibraryImpl.class);
    when(store.getSchema()).thenReturn(schema);

    // Act
    Iterable<? extends Element> actualDoOperationResult =
        aggregateHandler.doOperation(operation, context, store);
    Iterator<? extends Element> actualIteratorResult = actualDoOperationResult.iterator();

    // Assert
    verify(schema, atLeast(1)).getEdge("foo");
    verify(schema, atLeast(1)).getEntity("foo");
    verify(schema).getGroups();
    verify(operation, atLeast(1)).getEdges();
    verify(operation, atLeast(1)).getEntities();
    verify(operation, atLeast(1)).getInput();
    verify(store).getSchema();
    verify(schema).getAggregatedGroups();
    verify(schema, atLeast(1)).getElement("foo");
    verify(schemaEdgeDefinition).getGroupBy();
    verify(schemaEdgeDefinition, atLeast(1)).getOriginalAggregateFunctions();
    assertTrue(actualDoOperationResult instanceof ChainedIterable);
    Iterator<? extends Element> iteratorResult = actualDoOperationResult.iterator();
    assertTrue(iteratorResult instanceof ChainedIterator);
    assertTrue(actualIteratorResult instanceof ChainedIterator);
    assertFalse(iteratorResult.hasNext());
    assertFalse(actualIteratorResult.hasNext());
  }

  /**
   * Test {@link AggregateHandler#doOperation(Aggregate, Context, Store)} with {@code operation},
   * {@code context}, {@code store}.
   *
   * <ul>
   *   <li>Then calls {@link Schema#getGroups()}.
   * </ul>
   *
   * <p>Method under test: {@link AggregateHandler#doOperation(Aggregate, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(Aggregate, Context, Store) with 'operation', 'context', 'store'; then calls getGroups()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable AggregateHandler.doOperation(Aggregate, Context, Store)"})
  void testDoOperationWithOperationContextStore_thenCallsGetGroups() throws OperationException {
    // Arrange
    AggregateHandler aggregateHandler = new AggregateHandler();

    Aggregate operation = mock(Aggregate.class);
    Mockito.<Iterable<? extends Element>>when(operation.getInput()).thenReturn(new ArrayList<>());
    when(operation.getEdges()).thenReturn(new HashMap<>());
    when(operation.getEntities()).thenReturn(new HashMap<>());
    Context context = new Context();

    Schema schema = mock(Schema.class);
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.getGroups()).thenReturn(new HashSet<>());

    TestAddToGraphLibraryImpl store = mock(TestAddToGraphLibraryImpl.class);
    when(store.getSchema()).thenReturn(schema);

    // Act
    Iterable<? extends Element> actualDoOperationResult =
        aggregateHandler.doOperation(operation, context, store);
    Iterator<? extends Element> actualIteratorResult = actualDoOperationResult.iterator();

    // Assert
    verify(schema).getGroups();
    verify(operation, atLeast(1)).getEdges();
    verify(operation, atLeast(1)).getEntities();
    verify(operation, atLeast(1)).getInput();
    verify(store).getSchema();
    verify(schema).getAggregatedGroups();
    assertTrue(actualDoOperationResult instanceof ChainedIterable);
    Iterator<? extends Element> iteratorResult = actualDoOperationResult.iterator();
    assertTrue(iteratorResult instanceof ChainedIterator);
    assertTrue(actualIteratorResult instanceof ChainedIterator);
    assertFalse(iteratorResult.hasNext());
    assertFalse(actualIteratorResult.hasNext());
  }

  /**
   * Test {@link AggregateHandler#doOperation(Aggregate, Context, Store)} with {@code operation},
   * {@code context}, {@code store}.
   *
   * <ul>
   *   <li>Then iterator next return {@link Edge}.
   * </ul>
   *
   * <p>Method under test: {@link AggregateHandler#doOperation(Aggregate, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(Aggregate, Context, Store) with 'operation', 'context', 'store'; then iterator next return Edge")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable AggregateHandler.doOperation(Aggregate, Context, Store)"})
  void testDoOperationWithOperationContextStore_thenIteratorNextReturnEdge()
      throws OperationException {
    // Arrange
    AggregateHandler aggregateHandler = new AggregateHandler();

    Aggregate operation = mock(Aggregate.class);

    ArrayList<Element> elementList = new ArrayList<>();
    elementList.add(
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build());
    Mockito.<Iterable<? extends Element>>when(operation.getInput()).thenReturn(elementList);
    when(operation.getEdges()).thenReturn(new HashMap<>());
    when(operation.getEntities()).thenReturn(new HashMap<>());
    Context context = new Context();

    TestAddToGraphLibraryImpl store = mock(TestAddToGraphLibraryImpl.class);
    when(store.getSchema()).thenReturn(new Schema());

    // Act
    Iterable<? extends Element> actualDoOperationResult =
        aggregateHandler.doOperation(operation, context, store);
    Iterator<? extends Element> actualIteratorResult = actualDoOperationResult.iterator();

    // Assert
    assertTrue(actualDoOperationResult instanceof ChainedIterable);
    Iterator<? extends Element> iteratorResult = actualDoOperationResult.iterator();
    assertTrue(iteratorResult instanceof ChainedIterator);
    Element nextResult = iteratorResult.next();
    assertFalse(iteratorResult.hasNext());
    assertTrue(nextResult instanceof Edge);
    assertEquals("Dest", ((Edge) nextResult).getAdjacentMatchedVertexValue());
    assertEquals("uk.gov.gchq.gaffer.data.element.Edge", nextResult.getClassName());
    assertEquals("Dest", ((Edge) nextResult).getDestination());
    assertEquals(DirectedType.DIRECTED, ((Edge) nextResult).getDirectedType());
    assertEquals("Group", nextResult.getGroup());
    assertEquals(MatchedVertex.SOURCE, ((Edge) nextResult).getMatchedVertex());
    assertEquals("Source", ((Edge) nextResult).getMatchedVertexValue());
    assertTrue(nextResult.getProperties().isEmpty());
    assertEquals("Source", ((Edge) nextResult).getSource());
    assertTrue(((Edge) nextResult).isDirected());
    assertFalse(((Edge) nextResult).isUndirected());
    verify(operation, atLeast(1)).getInput();
    verify(operation, atLeast(1)).getEdges();
    verify(operation, atLeast(1)).getEntities();
    verify(store).getSchema();
    assertTrue(actualIteratorResult instanceof ChainedIterator);
    Element actualNextResult = actualIteratorResult.next();
    assertFalse(actualIteratorResult.hasNext());
    assertSame(nextResult, actualNextResult);
  }

  /**
   * Test {@link AggregateHandler#doOperation(Aggregate, Schema)} with {@code operation}, {@code
   * schema}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>Then {@link Aggregate} (default constructor) Edges Empty.
   * </ul>
   *
   * <p>Method under test: {@link AggregateHandler#doOperation(Aggregate, Schema)}
   */
  @Test
  @DisplayName(
      "Test doOperation(Aggregate, Schema) with 'operation', 'schema'; given ArrayList(); then Aggregate (default constructor) Edges Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable AggregateHandler.doOperation(Aggregate, Schema)"})
  void testDoOperationWithOperationSchema_givenArrayList_thenAggregateEdgesEmpty()
      throws OperationException {
    // Arrange
    AggregateHandler aggregateHandler = new AggregateHandler();

    Aggregate operation = new Aggregate();
    operation.setInput(new ArrayList<>());

    // Act
    Iterable<? extends Element> actualDoOperationResult =
        aggregateHandler.doOperation(operation, new Schema());
    Iterator<? extends Element> actualIteratorResult = actualDoOperationResult.iterator();

    // Assert
    assertTrue(actualDoOperationResult instanceof ChainedIterable);
    Iterator<? extends Element> iteratorResult = actualDoOperationResult.iterator();
    assertTrue(iteratorResult instanceof ChainedIterator);
    assertTrue(actualIteratorResult instanceof ChainedIterator);
    assertFalse(iteratorResult.hasNext());
    assertFalse(actualIteratorResult.hasNext());
    assertTrue(operation.getEdges().isEmpty());
    assertTrue(operation.getEntities().isEmpty());
  }

  /**
   * Test {@link AggregateHandler#doOperation(Aggregate, Schema)} with {@code operation}, {@code
   * schema}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.
   *   <li>Then {@link Aggregate} (default constructor) Edges is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AggregateHandler#doOperation(Aggregate, Schema)}
   */
  @Test
  @DisplayName(
      "Test doOperation(Aggregate, Schema) with 'operation', 'schema'; given HashMap(); then Aggregate (default constructor) Edges is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable AggregateHandler.doOperation(Aggregate, Schema)"})
  void testDoOperationWithOperationSchema_givenHashMap_thenAggregateEdgesIsNull()
      throws OperationException {
    // Arrange
    AggregateHandler aggregateHandler = new AggregateHandler();

    Aggregate operation = new Aggregate();
    operation.setEntities(new HashMap<>());

    ArrayList<Element> input = new ArrayList<>();
    input.add(
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build());
    operation.setInput(input);

    // Act
    Iterable<? extends Element> actualDoOperationResult =
        aggregateHandler.doOperation(operation, new Schema());
    Iterator<? extends Element> actualIteratorResult = actualDoOperationResult.iterator();

    // Assert
    assertTrue(actualDoOperationResult instanceof ChainedIterable);
    Iterator<? extends Element> iteratorResult = actualDoOperationResult.iterator();
    assertTrue(iteratorResult instanceof ChainedIterator);
    Element nextResult = iteratorResult.next();
    assertFalse(iteratorResult.hasNext());
    assertTrue(nextResult instanceof Edge);
    assertNull(operation.getEdges());
    assertTrue(operation.getEntities().isEmpty());
    assertTrue(actualIteratorResult instanceof ChainedIterator);
    Element actualNextResult = actualIteratorResult.next();
    assertFalse(actualIteratorResult.hasNext());
    assertSame(nextResult, actualNextResult);
  }

  /**
   * Test {@link AggregateHandler#doOperation(Aggregate, Schema)} with {@code operation}, {@code
   * schema}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.
   *   <li>Then {@link Aggregate} (default constructor) Entities is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AggregateHandler#doOperation(Aggregate, Schema)}
   */
  @Test
  @DisplayName(
      "Test doOperation(Aggregate, Schema) with 'operation', 'schema'; given HashMap(); then Aggregate (default constructor) Entities is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable AggregateHandler.doOperation(Aggregate, Schema)"})
  void testDoOperationWithOperationSchema_givenHashMap_thenAggregateEntitiesIsNull()
      throws OperationException {
    // Arrange
    AggregateHandler aggregateHandler = new AggregateHandler();

    Aggregate operation = new Aggregate();
    operation.setEdges(new HashMap<>());

    ArrayList<Element> input = new ArrayList<>();
    input.add(
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build());
    operation.setInput(input);

    // Act
    Iterable<? extends Element> actualDoOperationResult =
        aggregateHandler.doOperation(operation, new Schema());
    Iterator<? extends Element> actualIteratorResult = actualDoOperationResult.iterator();

    // Assert
    assertTrue(actualDoOperationResult instanceof ChainedIterable);
    Iterator<? extends Element> iteratorResult = actualDoOperationResult.iterator();
    assertTrue(iteratorResult instanceof ChainedIterator);
    Element nextResult = iteratorResult.next();
    assertFalse(iteratorResult.hasNext());
    assertTrue(nextResult instanceof Edge);
    assertTrue(operation.getEdges().isEmpty());
    assertNull(operation.getEntities());
    assertTrue(actualIteratorResult instanceof ChainedIterator);
    Element actualNextResult = actualIteratorResult.next();
    assertFalse(actualIteratorResult.hasNext());
    assertSame(nextResult, actualNextResult);
  }

  /**
   * Test {@link AggregateHandler#doOperation(Aggregate, Schema)} with {@code operation}, {@code
   * schema}.
   *
   * <ul>
   *   <li>Then iterator next return {@link Edge}.
   * </ul>
   *
   * <p>Method under test: {@link AggregateHandler#doOperation(Aggregate, Schema)}
   */
  @Test
  @DisplayName(
      "Test doOperation(Aggregate, Schema) with 'operation', 'schema'; then iterator next return Edge")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable AggregateHandler.doOperation(Aggregate, Schema)"})
  void testDoOperationWithOperationSchema_thenIteratorNextReturnEdge() throws OperationException {
    // Arrange
    AggregateHandler aggregateHandler = new AggregateHandler();

    Aggregate operation = new Aggregate();

    ArrayList<Element> input = new ArrayList<>();
    input.add(
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build());
    operation.setInput(input);

    // Act
    Iterable<? extends Element> actualDoOperationResult =
        aggregateHandler.doOperation(operation, new Schema());
    Iterator<? extends Element> actualIteratorResult = actualDoOperationResult.iterator();

    // Assert
    assertTrue(actualDoOperationResult instanceof ChainedIterable);
    Iterator<? extends Element> iteratorResult = actualDoOperationResult.iterator();
    assertTrue(iteratorResult instanceof ChainedIterator);
    Element nextResult = iteratorResult.next();
    assertFalse(iteratorResult.hasNext());
    assertTrue(nextResult instanceof Edge);
    assertTrue(operation.getEdges().isEmpty());
    assertTrue(operation.getEntities().isEmpty());
    assertTrue(actualIteratorResult instanceof ChainedIterator);
    Element actualNextResult = actualIteratorResult.next();
    assertFalse(actualIteratorResult.hasNext());
    assertSame(nextResult, actualNextResult);
  }
}
