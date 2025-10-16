package uk.gov.gchq.gaffer.store.operation.handler.function;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uk.gov.gchq.gaffer.commonutil.iterable.StreamIterator;
import uk.gov.gchq.gaffer.data.element.Element;
import uk.gov.gchq.gaffer.data.element.function.ElementTransformer;
import uk.gov.gchq.gaffer.data.element.function.ElementTransformer.Builder;
import uk.gov.gchq.gaffer.operation.OperationException;
import uk.gov.gchq.gaffer.operation.impl.function.Transform;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.Store;
import uk.gov.gchq.gaffer.store.operation.handler.TestAddToGraphLibraryImpl;
import uk.gov.gchq.gaffer.store.operation.util.StreamTransformIterable;
import uk.gov.gchq.gaffer.store.schema.Schema;
import uk.gov.gchq.gaffer.store.schema.SchemaEdgeDefinition;
import uk.gov.gchq.gaffer.store.schema.SchemaEntityDefinition;

class TransformHandlerDiffblueTest {
  /**
   * Test {@link TransformHandler#doOperation(Transform, Context, Store)} with {@code operation},
   * {@code context}, {@code store}.
   *
   * <ul>
   *   <li>Then calls {@link Schema#getEdge(String)}.
   * </ul>
   *
   * <p>Method under test: {@link TransformHandler#doOperation(Transform, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(Transform, Context, Store) with 'operation', 'context', 'store'; then calls getEdge(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable TransformHandler.doOperation(Transform, Context, Store)"})
  void testDoOperationWithOperationContextStore_thenCallsGetEdge() throws OperationException {
    // Arrange
    TransformHandler transformHandler = new TransformHandler();

    HashMap<String, ElementTransformer> stringElementTransformerMap = new HashMap<>();
    stringElementTransformerMap.put("", new Builder().build());

    Transform operation = mock(Transform.class);
    Mockito.<Iterable<? extends Element>>when(operation.getInput()).thenReturn(new ArrayList<>());
    when(operation.getEdges()).thenReturn(stringElementTransformerMap);
    when(operation.getEntities()).thenReturn(new HashMap<>());
    Context context = new Context();

    Schema schema = mock(Schema.class);
    when(schema.getEdge(Mockito.<String>any())).thenReturn(new SchemaEdgeDefinition());

    TestAddToGraphLibraryImpl store = mock(TestAddToGraphLibraryImpl.class);
    when(store.getSchema()).thenReturn(schema);

    // Act
    Iterable<? extends Element> actualDoOperationResult =
        transformHandler.doOperation(operation, context, store);
    Iterator<? extends Element> actualIteratorResult = actualDoOperationResult.iterator();

    // Assert
    verify(schema, atLeast(1)).getEdge("");
    verify(operation, atLeast(1)).getEdges();
    verify(operation, atLeast(1)).getEntities();
    verify(operation, atLeast(1)).getInput();
    verify(store).getSchema();
    Iterator<? extends Element> iteratorResult = actualDoOperationResult.iterator();
    assertTrue(iteratorResult instanceof StreamIterator);
    assertTrue(actualIteratorResult instanceof StreamIterator);
    assertTrue(actualDoOperationResult instanceof StreamTransformIterable);
    assertFalse(iteratorResult.hasNext());
    assertFalse(actualIteratorResult.hasNext());
    Stream<Element> stream = ((StreamTransformIterable) actualDoOperationResult).getStream();
    assertTrue(stream.limit(5).collect(Collectors.toList()).isEmpty());
  }

  /**
   * Test {@link TransformHandler#doOperation(Transform, Context, Store)} with {@code operation},
   * {@code context}, {@code store}.
   *
   * <ul>
   *   <li>Then calls {@link Schema#getEntity(String)}.
   * </ul>
   *
   * <p>Method under test: {@link TransformHandler#doOperation(Transform, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(Transform, Context, Store) with 'operation', 'context', 'store'; then calls getEntity(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable TransformHandler.doOperation(Transform, Context, Store)"})
  void testDoOperationWithOperationContextStore_thenCallsGetEntity() throws OperationException {
    // Arrange
    TransformHandler transformHandler = new TransformHandler();

    HashMap<String, ElementTransformer> stringElementTransformerMap = new HashMap<>();
    stringElementTransformerMap.put("", new Builder().build());

    HashMap<String, ElementTransformer> stringElementTransformerMap2 = new HashMap<>();
    stringElementTransformerMap2.put("foo", new Builder().build());

    Transform operation = mock(Transform.class);
    Mockito.<Iterable<? extends Element>>when(operation.getInput()).thenReturn(new ArrayList<>());
    when(operation.getEdges()).thenReturn(stringElementTransformerMap);
    when(operation.getEntities()).thenReturn(stringElementTransformerMap2);
    Context context = new Context();

    Schema schema = mock(Schema.class);
    when(schema.getEntity(Mockito.<String>any())).thenReturn(new SchemaEntityDefinition());
    when(schema.getEdge(Mockito.<String>any())).thenReturn(new SchemaEdgeDefinition());

    TestAddToGraphLibraryImpl store = mock(TestAddToGraphLibraryImpl.class);
    when(store.getSchema()).thenReturn(schema);

    // Act
    Iterable<? extends Element> actualDoOperationResult =
        transformHandler.doOperation(operation, context, store);
    Iterator<? extends Element> actualIteratorResult = actualDoOperationResult.iterator();

    // Assert
    verify(schema, atLeast(1)).getEdge("");
    verify(schema, atLeast(1)).getEntity("foo");
    verify(operation, atLeast(1)).getEdges();
    verify(operation, atLeast(1)).getEntities();
    verify(operation, atLeast(1)).getInput();
    verify(store).getSchema();
    Iterator<? extends Element> iteratorResult = actualDoOperationResult.iterator();
    assertTrue(iteratorResult instanceof StreamIterator);
    assertTrue(actualIteratorResult instanceof StreamIterator);
    assertTrue(actualDoOperationResult instanceof StreamTransformIterable);
    assertFalse(iteratorResult.hasNext());
    assertFalse(actualIteratorResult.hasNext());
    Stream<Element> stream = ((StreamTransformIterable) actualDoOperationResult).getStream();
    assertTrue(stream.limit(5).collect(Collectors.toList()).isEmpty());
  }

  /**
   * Test {@link TransformHandler#doOperation(Transform, Context, Store)} with {@code operation},
   * {@code context}, {@code store}.
   *
   * <ul>
   *   <li>Then calls {@link Schema#getEntity(String)}.
   * </ul>
   *
   * <p>Method under test: {@link TransformHandler#doOperation(Transform, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(Transform, Context, Store) with 'operation', 'context', 'store'; then calls getEntity(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable TransformHandler.doOperation(Transform, Context, Store)"})
  void testDoOperationWithOperationContextStore_thenCallsGetEntity2() throws OperationException {
    // Arrange
    TransformHandler transformHandler = new TransformHandler();

    HashMap<String, ElementTransformer> stringElementTransformerMap = new HashMap<>();
    stringElementTransformerMap.put("foo", new Builder().build());
    stringElementTransformerMap.put("", new Builder().build());

    HashMap<String, ElementTransformer> stringElementTransformerMap2 = new HashMap<>();
    stringElementTransformerMap2.put("foo", new Builder().build());

    Transform operation = mock(Transform.class);
    Mockito.<Iterable<? extends Element>>when(operation.getInput()).thenReturn(new ArrayList<>());
    when(operation.getEdges()).thenReturn(stringElementTransformerMap);
    when(operation.getEntities()).thenReturn(stringElementTransformerMap2);
    Context context = new Context();

    Schema schema = mock(Schema.class);
    when(schema.getEntity(Mockito.<String>any())).thenReturn(new SchemaEntityDefinition());
    when(schema.getEdge(Mockito.<String>any())).thenReturn(new SchemaEdgeDefinition());

    TestAddToGraphLibraryImpl store = mock(TestAddToGraphLibraryImpl.class);
    when(store.getSchema()).thenReturn(schema);

    // Act
    Iterable<? extends Element> actualDoOperationResult =
        transformHandler.doOperation(operation, context, store);
    Iterator<? extends Element> actualIteratorResult = actualDoOperationResult.iterator();

    // Assert
    verify(schema, atLeast(1)).getEdge(Mockito.<String>any());
    verify(schema, atLeast(1)).getEntity("foo");
    verify(operation, atLeast(1)).getEdges();
    verify(operation, atLeast(1)).getEntities();
    verify(operation, atLeast(1)).getInput();
    verify(store).getSchema();
    Iterator<? extends Element> iteratorResult = actualDoOperationResult.iterator();
    assertTrue(iteratorResult instanceof StreamIterator);
    assertTrue(actualIteratorResult instanceof StreamIterator);
    assertTrue(actualDoOperationResult instanceof StreamTransformIterable);
    assertFalse(iteratorResult.hasNext());
    assertFalse(actualIteratorResult.hasNext());
    Stream<Element> stream = ((StreamTransformIterable) actualDoOperationResult).getStream();
    assertTrue(stream.limit(5).collect(Collectors.toList()).isEmpty());
  }

  /**
   * Test {@link TransformHandler#doOperation(Transform, Context, Store)} with {@code operation},
   * {@code context}, {@code store}.
   *
   * <ul>
   *   <li>Then iterator return {@link StreamIterator}.
   * </ul>
   *
   * <p>Method under test: {@link TransformHandler#doOperation(Transform, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(Transform, Context, Store) with 'operation', 'context', 'store'; then iterator return StreamIterator")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable TransformHandler.doOperation(Transform, Context, Store)"})
  void testDoOperationWithOperationContextStore_thenIteratorReturnStreamIterator()
      throws OperationException {
    // Arrange
    TransformHandler transformHandler = new TransformHandler();

    Transform operation = mock(Transform.class);
    Mockito.<Iterable<? extends Element>>when(operation.getInput()).thenReturn(new ArrayList<>());
    when(operation.getEdges()).thenReturn(new HashMap<>());
    when(operation.getEntities()).thenReturn(new HashMap<>());
    Context context = new Context();

    TestAddToGraphLibraryImpl store = mock(TestAddToGraphLibraryImpl.class);
    when(store.getSchema()).thenReturn(new Schema());

    // Act
    Iterable<? extends Element> actualDoOperationResult =
        transformHandler.doOperation(operation, context, store);
    Iterator<? extends Element> actualIteratorResult = actualDoOperationResult.iterator();

    // Assert
    verify(operation, atLeast(1)).getEdges();
    verify(operation, atLeast(1)).getEntities();
    verify(operation, atLeast(1)).getInput();
    verify(store).getSchema();
    Iterator<? extends Element> iteratorResult = actualDoOperationResult.iterator();
    assertTrue(iteratorResult instanceof StreamIterator);
    assertTrue(actualIteratorResult instanceof StreamIterator);
    assertTrue(actualDoOperationResult instanceof StreamTransformIterable);
    assertFalse(iteratorResult.hasNext());
    assertFalse(actualIteratorResult.hasNext());
    Stream<Element> stream = ((StreamTransformIterable) actualDoOperationResult).getStream();
    assertTrue(stream.limit(5).collect(Collectors.toList()).isEmpty());
  }

  /**
   * Test {@link TransformHandler#doOperation(Transform, Schema)} with {@code operation}, {@code
   * schema}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.
   *   <li>Then {@link Transform} (default constructor) Edges is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TransformHandler#doOperation(Transform, Schema)}
   */
  @Test
  @DisplayName(
      "Test doOperation(Transform, Schema) with 'operation', 'schema'; given HashMap(); then Transform (default constructor) Edges is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable TransformHandler.doOperation(Transform, Schema)"})
  void testDoOperationWithOperationSchema_givenHashMap_thenTransformEdgesIsNull()
      throws OperationException {
    // Arrange
    TransformHandler transformHandler = new TransformHandler();

    Transform operation = new Transform();
    operation.setInput(new ArrayList<>());
    operation.setEntities(new HashMap<>());
    operation.setEdges(null);

    // Act
    Iterable<? extends Element> actualDoOperationResult =
        transformHandler.doOperation(operation, new Schema());
    Iterator<? extends Element> actualIteratorResult = actualDoOperationResult.iterator();

    // Assert
    Iterator<? extends Element> iteratorResult = actualDoOperationResult.iterator();
    assertTrue(iteratorResult instanceof StreamIterator);
    assertTrue(actualIteratorResult instanceof StreamIterator);
    assertTrue(actualDoOperationResult instanceof StreamTransformIterable);
    assertNull(operation.getEdges());
    assertFalse(iteratorResult.hasNext());
    assertFalse(actualIteratorResult.hasNext());
    Stream<Element> stream = ((StreamTransformIterable) actualDoOperationResult).getStream();
    assertTrue(stream.limit(5).collect(Collectors.toList()).isEmpty());
    assertTrue(operation.getEntities().isEmpty());
  }

  /**
   * Test {@link TransformHandler#doOperation(Transform, Schema)} with {@code operation}, {@code
   * schema}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.
   *   <li>Then {@link Transform} (default constructor) Entities is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TransformHandler#doOperation(Transform, Schema)}
   */
  @Test
  @DisplayName(
      "Test doOperation(Transform, Schema) with 'operation', 'schema'; given HashMap(); then Transform (default constructor) Entities is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable TransformHandler.doOperation(Transform, Schema)"})
  void testDoOperationWithOperationSchema_givenHashMap_thenTransformEntitiesIsNull()
      throws OperationException {
    // Arrange
    TransformHandler transformHandler = new TransformHandler();

    Transform operation = new Transform();
    operation.setInput(new ArrayList<>());
    operation.setEntities(null);
    operation.setEdges(new HashMap<>());

    // Act
    Iterable<? extends Element> actualDoOperationResult =
        transformHandler.doOperation(operation, new Schema());
    Iterator<? extends Element> actualIteratorResult = actualDoOperationResult.iterator();

    // Assert
    Iterator<? extends Element> iteratorResult = actualDoOperationResult.iterator();
    assertTrue(iteratorResult instanceof StreamIterator);
    assertTrue(actualIteratorResult instanceof StreamIterator);
    assertTrue(actualDoOperationResult instanceof StreamTransformIterable);
    assertNull(operation.getEntities());
    assertFalse(iteratorResult.hasNext());
    assertFalse(actualIteratorResult.hasNext());
    Stream<Element> stream = ((StreamTransformIterable) actualDoOperationResult).getStream();
    assertTrue(stream.limit(5).collect(Collectors.toList()).isEmpty());
    assertTrue(operation.getEdges().isEmpty());
  }

  /**
   * Test {@link TransformHandler#doOperation(Transform, Schema)} with {@code operation}, {@code
   * schema}.
   *
   * <ul>
   *   <li>Then {@link Transform} (default constructor) Edges Empty.
   * </ul>
   *
   * <p>Method under test: {@link TransformHandler#doOperation(Transform, Schema)}
   */
  @Test
  @DisplayName(
      "Test doOperation(Transform, Schema) with 'operation', 'schema'; then Transform (default constructor) Edges Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable TransformHandler.doOperation(Transform, Schema)"})
  void testDoOperationWithOperationSchema_thenTransformEdgesEmpty() throws OperationException {
    // Arrange
    TransformHandler transformHandler = new TransformHandler();

    Transform operation = new Transform();
    operation.setInput(new ArrayList<>());
    operation.setEntities(null);
    operation.setEdges(null);

    // Act
    Iterable<? extends Element> actualDoOperationResult =
        transformHandler.doOperation(operation, new Schema());
    Iterator<? extends Element> actualIteratorResult = actualDoOperationResult.iterator();

    // Assert
    Iterator<? extends Element> iteratorResult = actualDoOperationResult.iterator();
    assertTrue(iteratorResult instanceof StreamIterator);
    assertTrue(actualIteratorResult instanceof StreamIterator);
    assertTrue(actualDoOperationResult instanceof StreamTransformIterable);
    assertFalse(iteratorResult.hasNext());
    assertFalse(actualIteratorResult.hasNext());
    Stream<Element> stream = ((StreamTransformIterable) actualDoOperationResult).getStream();
    assertTrue(stream.limit(5).collect(Collectors.toList()).isEmpty());
    assertTrue(operation.getEdges().isEmpty());
    assertTrue(operation.getEntities().isEmpty());
  }
}
