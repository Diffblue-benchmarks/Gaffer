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

package uk.gov.gchq.gaffer.store.operation.handler.compare;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uk.gov.gchq.gaffer.commonutil.iterable.StreamIterable;
import uk.gov.gchq.gaffer.data.element.Edge;
import uk.gov.gchq.gaffer.data.element.Edge.Builder;
import uk.gov.gchq.gaffer.data.element.Element;
import uk.gov.gchq.gaffer.data.element.id.DirectedType;
import uk.gov.gchq.gaffer.data.element.id.EdgeId;
import uk.gov.gchq.gaffer.data.element.id.EdgeId.MatchedVertex;
import uk.gov.gchq.gaffer.operation.OperationException;
import uk.gov.gchq.gaffer.operation.impl.compare.Sort;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.Store;
import uk.gov.gchq.gaffer.store.operation.handler.TestAddToGraphLibraryImpl;

class SortHandlerDiffblueTest {
  /**
   * Test {@link SortHandler#doOperation(Sort, Context, Store)} with {@code Sort}, {@code Context},
   * {@code Store}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SortHandler#doOperation(Sort, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(Sort, Context, Store) with 'Sort', 'Context', 'Store'; given ArrayList(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable SortHandler.doOperation(Sort, Context, Store)"})
  void testDoOperationWithSortContextStore_givenArrayList_thenReturnNull()
      throws OperationException {
    // Arrange
    SortHandler sortHandler = new SortHandler();

    Sort operation = new Sort();
    operation.setInput(new StreamIterable<>(mock(Supplier.class)));
    operation.setComparators(new ArrayList<>());
    operation.setResultLimit(1);
    Context context = new Context();

    // Act and Assert
    assertNull(sortHandler.doOperation(operation, context, new TestAddToGraphLibraryImpl()));
  }

  /**
   * Test {@link SortHandler#doOperation(Sort, Context, Store)} with {@code Sort}, {@code Context},
   * {@code Store}.
   *
   * <ul>
   *   <li>Given {@link Comparator} {@link Comparator#compare(Object, Object)} return minus one.
   * </ul>
   *
   * <p>Method under test: {@link SortHandler#doOperation(Sort, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(Sort, Context, Store) with 'Sort', 'Context', 'Store'; given Comparator compare(Object, Object) return minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable SortHandler.doOperation(Sort, Context, Store)"})
  void testDoOperationWithSortContextStore_givenComparatorCompareReturnMinusOne()
      throws OperationException {
    // Arrange
    SortHandler sortHandler = new SortHandler();

    ArrayList<Element> elementList = new ArrayList<>();
    elementList.add(
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build());

    Iterable<Element> input = mock(Iterable.class);
    when(input.iterator()).thenReturn(elementList.iterator());

    Comparator<Element> comparator = mock(Comparator.class);
    when(comparator.compare(Mockito.<Element>any(), Mockito.<Element>any())).thenReturn(-1);

    Comparator<Element> comparator2 = mock(Comparator.class);
    when(comparator2.thenComparing(Mockito.<Comparator<Element>>any())).thenReturn(comparator);

    Comparator<Element> comparator3 = mock(Comparator.class);
    when(comparator3.thenComparing(Mockito.<Comparator<Element>>any())).thenReturn(comparator2);

    Comparator<Element> comparator4 = mock(Comparator.class);
    when(comparator4.thenComparing(Mockito.<Comparator<Element>>any())).thenReturn(comparator3);

    ArrayList<Comparator<Element>> comparators = new ArrayList<>();
    comparators.add(comparator4);
    comparators.add(mock(Comparator.class));
    comparators.add(mock(Comparator.class));
    comparators.add(mock(Comparator.class));

    Sort operation = new Sort();
    operation.setInput(input);
    operation.setComparators(comparators);
    operation.setResultLimit(1);
    Context context = new Context();

    // Act
    Iterable<? extends Element> actualDoOperationResult =
        sortHandler.doOperation(operation, context, new TestAddToGraphLibraryImpl());

    // Assert
    verify(input).iterator();
    verify(comparator).compare(isA(Element.class), isA(Element.class));
    verify(comparator4).thenComparing(isA(Comparator.class));
    verify(comparator3).thenComparing(isA(Comparator.class));
    verify(comparator2).thenComparing(isA(Comparator.class));
    assertTrue(actualDoOperationResult instanceof List);
    assertEquals(1, ((List<? extends Element>) actualDoOperationResult).size());
    Element getResult = ((List<? extends Element>) actualDoOperationResult).get(0);
    assertTrue(getResult instanceof Edge);
    assertEquals("Dest", ((Edge) getResult).getDestination());
    assertEquals("Dest", ((Edge) getResult).getAdjacentMatchedVertexValue());
    assertEquals("Group", getResult.getGroup());
    assertEquals("Source", ((Edge) getResult).getSource());
    assertEquals("Source", ((Edge) getResult).getMatchedVertexValue());
    assertEquals("uk.gov.gchq.gaffer.data.element.Edge", getResult.getClassName());
    assertEquals(DirectedType.DIRECTED, ((Edge) getResult).getDirectedType());
    assertEquals(MatchedVertex.SOURCE, ((Edge) getResult).getMatchedVertex());
    assertFalse(((Edge) getResult).isUndirected());
    assertTrue(getResult.getProperties().isEmpty());
    assertTrue(((Edge) getResult).isDirected());
  }

  /**
   * Test {@link SortHandler#doOperation(Sort, Context, Store)} with {@code Sort}, {@code Context},
   * {@code Store}.
   *
   * <ul>
   *   <li>Given {@link Comparator} {@link Comparator#compare(Object, Object)} return one.
   * </ul>
   *
   * <p>Method under test: {@link SortHandler#doOperation(Sort, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(Sort, Context, Store) with 'Sort', 'Context', 'Store'; given Comparator compare(Object, Object) return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable SortHandler.doOperation(Sort, Context, Store)"})
  void testDoOperationWithSortContextStore_givenComparatorCompareReturnOne()
      throws OperationException {
    // Arrange
    SortHandler sortHandler = new SortHandler();

    ArrayList<Element> elementList = new ArrayList<>();
    elementList.add(
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build());

    Iterable<Element> input = mock(Iterable.class);
    when(input.iterator()).thenReturn(elementList.iterator());

    Comparator<Element> comparator = mock(Comparator.class);
    when(comparator.compare(Mockito.<Element>any(), Mockito.<Element>any())).thenReturn(1);

    Comparator<Element> comparator2 = mock(Comparator.class);
    when(comparator2.thenComparing(Mockito.<Comparator<Element>>any())).thenReturn(comparator);

    Comparator<Element> comparator3 = mock(Comparator.class);
    when(comparator3.thenComparing(Mockito.<Comparator<Element>>any())).thenReturn(comparator2);

    ArrayList<Comparator<Element>> comparators = new ArrayList<>();
    comparators.add(comparator3);
    comparators.add(mock(Comparator.class));
    comparators.add(mock(Comparator.class));

    Sort operation = new Sort();
    operation.setInput(input);
    operation.setComparators(comparators);
    operation.setResultLimit(1);
    Context context = new Context();

    // Act
    Iterable<? extends Element> actualDoOperationResult =
        sortHandler.doOperation(operation, context, new TestAddToGraphLibraryImpl());

    // Assert
    verify(input).iterator();
    verify(comparator).compare(isA(Element.class), isA(Element.class));
    verify(comparator3).thenComparing(isA(Comparator.class));
    verify(comparator2).thenComparing(isA(Comparator.class));
    assertTrue(actualDoOperationResult instanceof List);
    assertEquals(1, ((List<? extends Element>) actualDoOperationResult).size());
    Element getResult = ((List<? extends Element>) actualDoOperationResult).get(0);
    assertTrue(getResult instanceof Edge);
    assertEquals("Dest", ((Edge) getResult).getDestination());
    assertEquals("Dest", ((Edge) getResult).getAdjacentMatchedVertexValue());
    assertEquals("Group", getResult.getGroup());
    assertEquals("Source", ((Edge) getResult).getSource());
    assertEquals("Source", ((Edge) getResult).getMatchedVertexValue());
    assertEquals("uk.gov.gchq.gaffer.data.element.Edge", getResult.getClassName());
    assertEquals(DirectedType.DIRECTED, ((Edge) getResult).getDirectedType());
    assertEquals(MatchedVertex.SOURCE, ((Edge) getResult).getMatchedVertex());
    assertFalse(((Edge) getResult).isUndirected());
    assertTrue(getResult.getProperties().isEmpty());
    assertTrue(((Edge) getResult).isDirected());
  }

  /**
   * Test {@link SortHandler#doOperation(Sort, Context, Store)} with {@code Sort}, {@code Context},
   * {@code Store}.
   *
   * <ul>
   *   <li>Given {@link Comparator} {@link Comparator#compare(Object, Object)} return one.
   * </ul>
   *
   * <p>Method under test: {@link SortHandler#doOperation(Sort, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(Sort, Context, Store) with 'Sort', 'Context', 'Store'; given Comparator compare(Object, Object) return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable SortHandler.doOperation(Sort, Context, Store)"})
  void testDoOperationWithSortContextStore_givenComparatorCompareReturnOne2()
      throws OperationException {
    // Arrange
    SortHandler sortHandler = new SortHandler();

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

    Iterable<Element> input = mock(Iterable.class);
    when(input.iterator()).thenReturn(elementList.iterator());

    Comparator<Element> comparator = mock(Comparator.class);
    when(comparator.compare(Mockito.<Element>any(), Mockito.<Element>any())).thenReturn(1);

    Comparator<Element> comparator2 = mock(Comparator.class);
    when(comparator2.thenComparing(Mockito.<Comparator<Element>>any())).thenReturn(comparator);

    Comparator<Element> comparator3 = mock(Comparator.class);
    when(comparator3.thenComparing(Mockito.<Comparator<Element>>any())).thenReturn(comparator2);

    Comparator<Element> comparator4 = mock(Comparator.class);
    when(comparator4.thenComparing(Mockito.<Comparator<Element>>any())).thenReturn(comparator3);

    ArrayList<Comparator<Element>> comparators = new ArrayList<>();
    comparators.add(comparator4);
    comparators.add(mock(Comparator.class));
    comparators.add(mock(Comparator.class));
    comparators.add(mock(Comparator.class));

    Sort operation = new Sort();
    operation.setInput(input);
    operation.setComparators(comparators);
    operation.setResultLimit(1);
    Context context = new Context();

    // Act
    Iterable<? extends Element> actualDoOperationResult =
        sortHandler.doOperation(operation, context, new TestAddToGraphLibraryImpl());

    // Assert
    verify(input).iterator();
    verify(comparator, atLeast(1)).compare(isA(Element.class), isA(Element.class));
    verify(comparator4).thenComparing(isA(Comparator.class));
    verify(comparator3).thenComparing(isA(Comparator.class));
    verify(comparator2).thenComparing(isA(Comparator.class));
    assertTrue(actualDoOperationResult instanceof List);
    assertEquals(1, ((List<? extends Element>) actualDoOperationResult).size());
    Element getResult = ((List<? extends Element>) actualDoOperationResult).get(0);
    assertTrue(getResult instanceof Edge);
    assertEquals("Dest", ((Edge) getResult).getDestination());
    assertEquals("Dest", ((Edge) getResult).getAdjacentMatchedVertexValue());
    assertEquals("Group", getResult.getGroup());
    assertEquals("Source", ((Edge) getResult).getSource());
    assertEquals("Source", ((Edge) getResult).getMatchedVertexValue());
    assertEquals("uk.gov.gchq.gaffer.data.element.Edge", getResult.getClassName());
    assertEquals(DirectedType.DIRECTED, ((Edge) getResult).getDirectedType());
    assertEquals(MatchedVertex.SOURCE, ((Edge) getResult).getMatchedVertex());
    assertFalse(((Edge) getResult).isUndirected());
    assertTrue(getResult.getProperties().isEmpty());
    assertTrue(((Edge) getResult).isDirected());
  }

  /**
   * Test {@link SortHandler#doOperation(Sort, Context, Store)} with {@code Sort}, {@code Context},
   * {@code Store}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link Sort} (default constructor) Comparators is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SortHandler#doOperation(Sort, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(Sort, Context, Store) with 'Sort', 'Context', 'Store'; given 'null'; when Sort (default constructor) Comparators is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable SortHandler.doOperation(Sort, Context, Store)"})
  void testDoOperationWithSortContextStore_givenNull_whenSortComparatorsIsNull()
      throws OperationException {
    // Arrange
    SortHandler sortHandler = new SortHandler();

    Sort operation = new Sort();
    operation.setInput(new StreamIterable<>(mock(Supplier.class)));
    operation.setComparators(null);
    operation.setResultLimit(1);
    Context context = new Context();

    // Act and Assert
    assertNull(sortHandler.doOperation(operation, context, new TestAddToGraphLibraryImpl()));
  }

  /**
   * Test {@link SortHandler#doOperation(Sort, Context, Store)} with {@code Sort}, {@code Context},
   * {@code Store}.
   *
   * <ul>
   *   <li>Then calls {@link Supplier#get()}.
   * </ul>
   *
   * <p>Method under test: {@link SortHandler#doOperation(Sort, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(Sort, Context, Store) with 'Sort', 'Context', 'Store'; then calls get()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable SortHandler.doOperation(Sort, Context, Store)"})
  void testDoOperationWithSortContextStore_thenCallsGet() throws OperationException {
    // Arrange
    SortHandler sortHandler = new SortHandler();

    Supplier<Stream<Element>> streamSupplier = mock(Supplier.class);

    ArrayList<Element> elementList = new ArrayList<>();
    Stream<Element> streamResult = elementList.stream();
    when(streamSupplier.get()).thenReturn(streamResult);
    StreamIterable<? extends Element> input = new StreamIterable<>(streamSupplier);

    ArrayList<Comparator<Element>> comparators = new ArrayList<>();
    comparators.add(mock(Comparator.class));

    Sort operation = new Sort();
    operation.setInput(input);
    operation.setComparators(comparators);
    operation.setResultLimit(1);
    Context context = new Context();

    // Act
    Iterable<? extends Element> actualDoOperationResult =
        sortHandler.doOperation(operation, context, new TestAddToGraphLibraryImpl());

    // Assert
    verify(streamSupplier).get();
    assertTrue(actualDoOperationResult instanceof List);
    assertTrue(((List<? extends Element>) actualDoOperationResult).isEmpty());
  }

  /**
   * Test {@link SortHandler#doOperation(Sort, Context, Store)} with {@code Sort}, {@code Context},
   * {@code Store}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link SortHandler#doOperation(Sort, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(Sort, Context, Store) with 'Sort', 'Context', 'Store'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable SortHandler.doOperation(Sort, Context, Store)"})
  void testDoOperationWithSortContextStore_thenReturnEmpty() throws OperationException {
    // Arrange
    SortHandler sortHandler = new SortHandler();

    Iterable<Element> input = mock(Iterable.class);

    ArrayList<Element> elementList = new ArrayList<>();
    when(input.iterator()).thenReturn(elementList.iterator());

    Comparator<Element> comparator = mock(Comparator.class);
    when(comparator.thenComparing(Mockito.<Comparator<Element>>any()))
        .thenReturn(mock(Comparator.class));

    ArrayList<Comparator<Element>> comparators = new ArrayList<>();
    comparators.add(comparator);
    comparators.add(mock(Comparator.class));

    Sort operation = new Sort();
    operation.setInput(input);
    operation.setComparators(comparators);
    operation.setResultLimit(1);
    Context context = new Context();

    // Act
    Iterable<? extends Element> actualDoOperationResult =
        sortHandler.doOperation(operation, context, new TestAddToGraphLibraryImpl());

    // Assert
    verify(input).iterator();
    verify(comparator).thenComparing(isA(Comparator.class));
    assertTrue(actualDoOperationResult instanceof List);
    assertTrue(((List<? extends Element>) actualDoOperationResult).isEmpty());
  }

  /**
   * Test {@link SortHandler#doOperation(Sort, Context, Store)} with {@code Sort}, {@code Context},
   * {@code Store}.
   *
   * <ul>
   *   <li>When {@link Sort} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SortHandler#doOperation(Sort, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(Sort, Context, Store) with 'Sort', 'Context', 'Store'; when Sort (default constructor); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable SortHandler.doOperation(Sort, Context, Store)"})
  void testDoOperationWithSortContextStore_whenSort_thenReturnNull() throws OperationException {
    // Arrange
    SortHandler sortHandler = new SortHandler();
    Sort operation = new Sort();
    Context context = new Context();

    // Act and Assert
    assertNull(sortHandler.doOperation(operation, context, new TestAddToGraphLibraryImpl()));
  }
}
