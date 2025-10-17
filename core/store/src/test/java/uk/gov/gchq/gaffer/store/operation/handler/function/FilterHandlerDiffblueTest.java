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
import uk.gov.gchq.gaffer.data.element.function.ElementFilter;
import uk.gov.gchq.gaffer.data.element.function.ElementFilter.Builder;
import uk.gov.gchq.gaffer.operation.OperationException;
import uk.gov.gchq.gaffer.operation.impl.function.Filter;
import uk.gov.gchq.gaffer.operation.util.StreamFilterIterable;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.Store;
import uk.gov.gchq.gaffer.store.operation.handler.TestAddToGraphLibraryImpl;
import uk.gov.gchq.gaffer.store.schema.Schema;
import uk.gov.gchq.gaffer.store.schema.SchemaEdgeDefinition;
import uk.gov.gchq.gaffer.store.schema.SchemaEntityDefinition;

class FilterHandlerDiffblueTest {
  /**
   * Test {@link FilterHandler#doOperation(Filter, Context, Store)} with {@code operation}, {@code
   * context}, {@code store}.
   *
   * <ul>
   *   <li>Then calls {@link Schema#getEdge(String)}.
   * </ul>
   *
   * <p>Method under test: {@link FilterHandler#doOperation(Filter, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(Filter, Context, Store) with 'operation', 'context', 'store'; then calls getEdge(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable FilterHandler.doOperation(Filter, Context, Store)"})
  void testDoOperationWithOperationContextStore_thenCallsGetEdge() throws OperationException {
    // Arrange
    FilterHandler filterHandler = new FilterHandler();

    HashMap<String, ElementFilter> stringElementFilterMap = new HashMap<>();
    stringElementFilterMap.put("", new Builder().build());

    Filter operation = mock(Filter.class);
    Mockito.<Iterable<? extends Element>>when(operation.getInput()).thenReturn(new ArrayList<>());
    when(operation.getEdges()).thenReturn(stringElementFilterMap);
    when(operation.getEntities()).thenReturn(new HashMap<>());
    when(operation.getGlobalEdges()).thenReturn(new Builder().build());
    when(operation.getGlobalElements()).thenReturn(new Builder().build());
    when(operation.getGlobalEntities()).thenReturn(new Builder().build());
    Context context = new Context();

    Schema schema = mock(Schema.class);
    when(schema.getEdges()).thenReturn(new HashMap<>());
    when(schema.getEntities()).thenReturn(new HashMap<>());
    when(schema.getEdge(Mockito.<String>any())).thenReturn(new SchemaEdgeDefinition());

    TestAddToGraphLibraryImpl store = mock(TestAddToGraphLibraryImpl.class);
    when(store.getSchema()).thenReturn(schema);

    // Act
    Iterable<? extends Element> actualDoOperationResult =
        filterHandler.doOperation(operation, context, store);
    Iterator<? extends Element> actualIteratorResult = actualDoOperationResult.iterator();

    // Assert
    verify(schema, atLeast(1)).getEdge("");
    verify(schema, atLeast(1)).getEdges();
    verify(schema, atLeast(1)).getEntities();
    verify(operation, atLeast(1)).getEdges();
    verify(operation, atLeast(1)).getEntities();
    verify(operation).getGlobalEdges();
    verify(operation).getGlobalElements();
    verify(operation).getGlobalEntities();
    verify(operation, atLeast(1)).getInput();
    verify(store).getSchema();
    Iterator<? extends Element> iteratorResult = actualDoOperationResult.iterator();
    assertTrue(iteratorResult instanceof StreamIterator);
    assertTrue(actualIteratorResult instanceof StreamIterator);
    assertTrue(actualDoOperationResult instanceof StreamFilterIterable);
    assertFalse(iteratorResult.hasNext());
    assertFalse(actualIteratorResult.hasNext());
    Stream<Element> stream = ((StreamFilterIterable) actualDoOperationResult).getStream();
    assertTrue(stream.limit(5).collect(Collectors.toList()).isEmpty());
  }

  /**
   * Test {@link FilterHandler#doOperation(Filter, Context, Store)} with {@code operation}, {@code
   * context}, {@code store}.
   *
   * <ul>
   *   <li>Then calls {@link Schema#getEntity(String)}.
   * </ul>
   *
   * <p>Method under test: {@link FilterHandler#doOperation(Filter, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(Filter, Context, Store) with 'operation', 'context', 'store'; then calls getEntity(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable FilterHandler.doOperation(Filter, Context, Store)"})
  void testDoOperationWithOperationContextStore_thenCallsGetEntity() throws OperationException {
    // Arrange
    FilterHandler filterHandler = new FilterHandler();

    HashMap<String, ElementFilter> stringElementFilterMap = new HashMap<>();
    stringElementFilterMap.put("", new Builder().build());

    HashMap<String, ElementFilter> stringElementFilterMap2 = new HashMap<>();
    stringElementFilterMap2.put("foo", new Builder().build());

    Filter operation = mock(Filter.class);
    Mockito.<Iterable<? extends Element>>when(operation.getInput()).thenReturn(new ArrayList<>());
    when(operation.getEdges()).thenReturn(stringElementFilterMap);
    when(operation.getEntities()).thenReturn(stringElementFilterMap2);
    when(operation.getGlobalEdges()).thenReturn(new Builder().build());
    when(operation.getGlobalElements()).thenReturn(new Builder().build());
    when(operation.getGlobalEntities()).thenReturn(new Builder().build());
    Context context = new Context();

    Schema schema = mock(Schema.class);
    when(schema.getEntity(Mockito.<String>any())).thenReturn(new SchemaEntityDefinition());
    when(schema.getEdges()).thenReturn(new HashMap<>());
    when(schema.getEntities()).thenReturn(new HashMap<>());
    when(schema.getEdge(Mockito.<String>any())).thenReturn(new SchemaEdgeDefinition());

    TestAddToGraphLibraryImpl store = mock(TestAddToGraphLibraryImpl.class);
    when(store.getSchema()).thenReturn(schema);

    // Act
    Iterable<? extends Element> actualDoOperationResult =
        filterHandler.doOperation(operation, context, store);
    Iterator<? extends Element> actualIteratorResult = actualDoOperationResult.iterator();

    // Assert
    verify(schema, atLeast(1)).getEdge("");
    verify(schema, atLeast(1)).getEdges();
    verify(schema, atLeast(1)).getEntities();
    verify(schema, atLeast(1)).getEntity("foo");
    verify(operation, atLeast(1)).getEdges();
    verify(operation, atLeast(1)).getEntities();
    verify(operation).getGlobalEdges();
    verify(operation).getGlobalElements();
    verify(operation).getGlobalEntities();
    verify(operation, atLeast(1)).getInput();
    verify(store).getSchema();
    Iterator<? extends Element> iteratorResult = actualDoOperationResult.iterator();
    assertTrue(iteratorResult instanceof StreamIterator);
    assertTrue(actualIteratorResult instanceof StreamIterator);
    assertTrue(actualDoOperationResult instanceof StreamFilterIterable);
    assertFalse(iteratorResult.hasNext());
    assertFalse(actualIteratorResult.hasNext());
    Stream<Element> stream = ((StreamFilterIterable) actualDoOperationResult).getStream();
    assertTrue(stream.limit(5).collect(Collectors.toList()).isEmpty());
  }

  /**
   * Test {@link FilterHandler#doOperation(Filter, Context, Store)} with {@code operation}, {@code
   * context}, {@code store}.
   *
   * <ul>
   *   <li>Then calls {@link Schema#getEntity(String)}.
   * </ul>
   *
   * <p>Method under test: {@link FilterHandler#doOperation(Filter, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(Filter, Context, Store) with 'operation', 'context', 'store'; then calls getEntity(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable FilterHandler.doOperation(Filter, Context, Store)"})
  void testDoOperationWithOperationContextStore_thenCallsGetEntity2() throws OperationException {
    // Arrange
    FilterHandler filterHandler = new FilterHandler();

    HashMap<String, ElementFilter> stringElementFilterMap = new HashMap<>();
    stringElementFilterMap.put("foo", new Builder().build());
    stringElementFilterMap.put("", new Builder().build());

    HashMap<String, ElementFilter> stringElementFilterMap2 = new HashMap<>();
    stringElementFilterMap2.put("foo", new Builder().build());

    Filter operation = mock(Filter.class);
    Mockito.<Iterable<? extends Element>>when(operation.getInput()).thenReturn(new ArrayList<>());
    when(operation.getEdges()).thenReturn(stringElementFilterMap);
    when(operation.getEntities()).thenReturn(stringElementFilterMap2);
    when(operation.getGlobalEdges()).thenReturn(new Builder().build());
    when(operation.getGlobalElements()).thenReturn(new Builder().build());
    when(operation.getGlobalEntities()).thenReturn(new Builder().build());
    Context context = new Context();

    Schema schema = mock(Schema.class);
    when(schema.getEntity(Mockito.<String>any())).thenReturn(new SchemaEntityDefinition());
    when(schema.getEdges()).thenReturn(new HashMap<>());
    when(schema.getEntities()).thenReturn(new HashMap<>());
    when(schema.getEdge(Mockito.<String>any())).thenReturn(new SchemaEdgeDefinition());

    TestAddToGraphLibraryImpl store = mock(TestAddToGraphLibraryImpl.class);
    when(store.getSchema()).thenReturn(schema);

    // Act
    Iterable<? extends Element> actualDoOperationResult =
        filterHandler.doOperation(operation, context, store);
    Iterator<? extends Element> actualIteratorResult = actualDoOperationResult.iterator();

    // Assert
    verify(schema, atLeast(1)).getEdge(Mockito.<String>any());
    verify(schema, atLeast(1)).getEdges();
    verify(schema, atLeast(1)).getEntities();
    verify(schema, atLeast(1)).getEntity("foo");
    verify(operation, atLeast(1)).getEdges();
    verify(operation, atLeast(1)).getEntities();
    verify(operation).getGlobalEdges();
    verify(operation).getGlobalElements();
    verify(operation).getGlobalEntities();
    verify(operation, atLeast(1)).getInput();
    verify(store).getSchema();
    Iterator<? extends Element> iteratorResult = actualDoOperationResult.iterator();
    assertTrue(iteratorResult instanceof StreamIterator);
    assertTrue(actualIteratorResult instanceof StreamIterator);
    assertTrue(actualDoOperationResult instanceof StreamFilterIterable);
    assertFalse(iteratorResult.hasNext());
    assertFalse(actualIteratorResult.hasNext());
    Stream<Element> stream = ((StreamFilterIterable) actualDoOperationResult).getStream();
    assertTrue(stream.limit(5).collect(Collectors.toList()).isEmpty());
  }

  /**
   * Test {@link FilterHandler#doOperation(Filter, Context, Store)} with {@code operation}, {@code
   * context}, {@code store}.
   *
   * <ul>
   *   <li>Then iterator return {@link StreamIterator}.
   * </ul>
   *
   * <p>Method under test: {@link FilterHandler#doOperation(Filter, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(Filter, Context, Store) with 'operation', 'context', 'store'; then iterator return StreamIterator")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable FilterHandler.doOperation(Filter, Context, Store)"})
  void testDoOperationWithOperationContextStore_thenIteratorReturnStreamIterator()
      throws OperationException {
    // Arrange
    FilterHandler filterHandler = new FilterHandler();

    Filter operation = mock(Filter.class);
    Mockito.<Iterable<? extends Element>>when(operation.getInput()).thenReturn(new ArrayList<>());
    when(operation.getEdges()).thenReturn(new HashMap<>());
    when(operation.getEntities()).thenReturn(new HashMap<>());
    when(operation.getGlobalEdges()).thenReturn(new Builder().build());
    when(operation.getGlobalElements()).thenReturn(new Builder().build());
    when(operation.getGlobalEntities()).thenReturn(new Builder().build());
    Context context = new Context();

    TestAddToGraphLibraryImpl store = mock(TestAddToGraphLibraryImpl.class);
    when(store.getSchema()).thenReturn(new Schema());

    // Act
    Iterable<? extends Element> actualDoOperationResult =
        filterHandler.doOperation(operation, context, store);
    Iterator<? extends Element> actualIteratorResult = actualDoOperationResult.iterator();

    // Assert
    verify(operation, atLeast(1)).getEdges();
    verify(operation, atLeast(1)).getEntities();
    verify(operation).getGlobalEdges();
    verify(operation).getGlobalElements();
    verify(operation).getGlobalEntities();
    verify(operation, atLeast(1)).getInput();
    verify(store).getSchema();
    Iterator<? extends Element> iteratorResult = actualDoOperationResult.iterator();
    assertTrue(iteratorResult instanceof StreamIterator);
    assertTrue(actualIteratorResult instanceof StreamIterator);
    assertTrue(actualDoOperationResult instanceof StreamFilterIterable);
    assertFalse(iteratorResult.hasNext());
    assertFalse(actualIteratorResult.hasNext());
    Stream<Element> stream = ((StreamFilterIterable) actualDoOperationResult).getStream();
    assertTrue(stream.limit(5).collect(Collectors.toList()).isEmpty());
  }

  /**
   * Test {@link FilterHandler#doOperation(Filter, Schema)} with {@code operation}, {@code schema}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.
   *   <li>Then {@link Filter} (default constructor) Edges is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FilterHandler#doOperation(Filter, Schema)}
   */
  @Test
  @DisplayName(
      "Test doOperation(Filter, Schema) with 'operation', 'schema'; given HashMap(); then Filter (default constructor) Edges is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable FilterHandler.doOperation(Filter, Schema)"})
  void testDoOperationWithOperationSchema_givenHashMap_thenFilterEdgesIsNull()
      throws OperationException {
    // Arrange
    FilterHandler filterHandler = new FilterHandler();

    Filter operation = new Filter();
    operation.setInput(new ArrayList<>());
    operation.setEntities(new HashMap<>());
    operation.setEdges(null);

    // Act
    Iterable<? extends Element> actualDoOperationResult =
        filterHandler.doOperation(operation, new Schema());
    Iterator<? extends Element> actualIteratorResult = actualDoOperationResult.iterator();

    // Assert
    Iterator<? extends Element> iteratorResult = actualDoOperationResult.iterator();
    assertTrue(iteratorResult instanceof StreamIterator);
    assertTrue(actualIteratorResult instanceof StreamIterator);
    assertTrue(actualDoOperationResult instanceof StreamFilterIterable);
    assertNull(operation.getEdges());
    assertFalse(iteratorResult.hasNext());
    assertFalse(actualIteratorResult.hasNext());
    Stream<Element> stream = ((StreamFilterIterable) actualDoOperationResult).getStream();
    assertTrue(stream.limit(5).collect(Collectors.toList()).isEmpty());
    assertTrue(operation.getEntities().isEmpty());
  }

  /**
   * Test {@link FilterHandler#doOperation(Filter, Schema)} with {@code operation}, {@code schema}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.
   *   <li>Then {@link Filter} (default constructor) Entities is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FilterHandler#doOperation(Filter, Schema)}
   */
  @Test
  @DisplayName(
      "Test doOperation(Filter, Schema) with 'operation', 'schema'; given HashMap(); then Filter (default constructor) Entities is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable FilterHandler.doOperation(Filter, Schema)"})
  void testDoOperationWithOperationSchema_givenHashMap_thenFilterEntitiesIsNull()
      throws OperationException {
    // Arrange
    FilterHandler filterHandler = new FilterHandler();

    Filter operation = new Filter();
    operation.setInput(new ArrayList<>());
    operation.setEntities(null);
    operation.setEdges(new HashMap<>());

    // Act
    Iterable<? extends Element> actualDoOperationResult =
        filterHandler.doOperation(operation, new Schema());
    Iterator<? extends Element> actualIteratorResult = actualDoOperationResult.iterator();

    // Assert
    Iterator<? extends Element> iteratorResult = actualDoOperationResult.iterator();
    assertTrue(iteratorResult instanceof StreamIterator);
    assertTrue(actualIteratorResult instanceof StreamIterator);
    assertTrue(actualDoOperationResult instanceof StreamFilterIterable);
    assertNull(operation.getEntities());
    assertFalse(iteratorResult.hasNext());
    assertFalse(actualIteratorResult.hasNext());
    Stream<Element> stream = ((StreamFilterIterable) actualDoOperationResult).getStream();
    assertTrue(stream.limit(5).collect(Collectors.toList()).isEmpty());
    assertTrue(operation.getEdges().isEmpty());
  }

  /**
   * Test {@link FilterHandler#doOperation(Filter, Schema)} with {@code operation}, {@code schema}.
   *
   * <ul>
   *   <li>When {@link Filter} (default constructor) Entities is {@code null}.
   *   <li>Then {@link Filter} (default constructor) Edges Empty.
   * </ul>
   *
   * <p>Method under test: {@link FilterHandler#doOperation(Filter, Schema)}
   */
  @Test
  @DisplayName(
      "Test doOperation(Filter, Schema) with 'operation', 'schema'; when Filter (default constructor) Entities is 'null'; then Filter (default constructor) Edges Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable FilterHandler.doOperation(Filter, Schema)"})
  void testDoOperationWithOperationSchema_whenFilterEntitiesIsNull_thenFilterEdgesEmpty()
      throws OperationException {
    // Arrange
    FilterHandler filterHandler = new FilterHandler();

    Filter operation = new Filter();
    operation.setInput(new ArrayList<>());
    operation.setEntities(null);
    operation.setEdges(null);

    // Act
    Iterable<? extends Element> actualDoOperationResult =
        filterHandler.doOperation(operation, new Schema());
    Iterator<? extends Element> actualIteratorResult = actualDoOperationResult.iterator();

    // Assert
    Iterator<? extends Element> iteratorResult = actualDoOperationResult.iterator();
    assertTrue(iteratorResult instanceof StreamIterator);
    assertTrue(actualIteratorResult instanceof StreamIterator);
    assertTrue(actualDoOperationResult instanceof StreamFilterIterable);
    assertFalse(iteratorResult.hasNext());
    assertFalse(actualIteratorResult.hasNext());
    Stream<Element> stream = ((StreamFilterIterable) actualDoOperationResult).getStream();
    assertTrue(stream.limit(5).collect(Collectors.toList()).isEmpty());
    assertTrue(operation.getEdges().isEmpty());
    assertTrue(operation.getEntities().isEmpty());
  }
}
