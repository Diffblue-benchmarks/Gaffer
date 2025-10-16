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
import java.util.HashSet;
import java.util.LinkedHashSet;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uk.gov.gchq.gaffer.data.element.Edge;
import uk.gov.gchq.gaffer.data.element.Edge.Builder;
import uk.gov.gchq.gaffer.data.element.Element;
import uk.gov.gchq.gaffer.data.element.comparison.ElementPropertyComparator;
import uk.gov.gchq.gaffer.data.element.id.DirectedType;
import uk.gov.gchq.gaffer.data.element.id.EdgeId;
import uk.gov.gchq.gaffer.data.element.id.EdgeId.MatchedVertex;
import uk.gov.gchq.gaffer.operation.OperationException;
import uk.gov.gchq.gaffer.operation.impl.compare.Min;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.Store;
import uk.gov.gchq.gaffer.store.operation.handler.TestAddToGraphLibraryImpl;

class MinHandlerDiffblueTest {
  /**
   * Test {@link MinHandler#doOperation(Min, Context, Store)} with {@code Min}, {@code Context},
   * {@code Store}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>When {@link Min} (default constructor) Input is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link MinHandler#doOperation(Min, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(Min, Context, Store) with 'Min', 'Context', 'Store'; given ArrayList(); when Min (default constructor) Input is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Element MinHandler.doOperation(Min, Context, Store)"})
  void testDoOperationWithMinContextStore_givenArrayList_whenMinInputIsArrayList()
      throws OperationException {
    // Arrange
    MinHandler minHandler = new MinHandler();

    Min operation = new Min();
    operation.setInput(new ArrayList<>());
    operation.setComparators(new ArrayList<>());
    Context context = new Context();

    // Act and Assert
    assertNull(minHandler.doOperation(operation, context, new TestAddToGraphLibraryImpl()));
  }

  /**
   * Test {@link MinHandler#doOperation(Min, Context, Store)} with {@code Min}, {@code Context},
   * {@code Store}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>When {@link Min} (default constructor) Input is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link MinHandler#doOperation(Min, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(Min, Context, Store) with 'Min', 'Context', 'Store'; given ArrayList(); when Min (default constructor) Input is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Element MinHandler.doOperation(Min, Context, Store)"})
  void testDoOperationWithMinContextStore_givenArrayList_whenMinInputIsArrayList2()
      throws OperationException {
    // Arrange
    MinHandler minHandler = new MinHandler();

    ArrayList<Comparator<Element>> comparators = new ArrayList<>();
    comparators.add(mock(Comparator.class));

    Min operation = new Min();
    operation.setInput(new ArrayList<>());
    operation.setComparators(comparators);
    Context context = new Context();

    // Act and Assert
    assertNull(minHandler.doOperation(operation, context, new TestAddToGraphLibraryImpl()));
  }

  /**
   * Test {@link MinHandler#doOperation(Min, Context, Store)} with {@code Min}, {@code Context},
   * {@code Store}.
   *
   * <ul>
   *   <li>Given {@link Comparator} {@link Comparator#compare(Object, Object)} return minus one.
   * </ul>
   *
   * <p>Method under test: {@link MinHandler#doOperation(Min, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(Min, Context, Store) with 'Min', 'Context', 'Store'; given Comparator compare(Object, Object) return minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Element MinHandler.doOperation(Min, Context, Store)"})
  void testDoOperationWithMinContextStore_givenComparatorCompareReturnMinusOne()
      throws OperationException {
    // Arrange
    MinHandler minHandler = new MinHandler();

    ArrayList<Element> input = new ArrayList<>();
    input.add(
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build());

    Comparator<Element> comparator = mock(Comparator.class);
    when(comparator.compare(Mockito.<Element>any(), Mockito.<Element>any())).thenReturn(-1);

    Comparator<Element> comparator2 = mock(Comparator.class);
    when(comparator2.thenComparing(Mockito.<Comparator<Element>>any())).thenReturn(comparator);

    ArrayList<Comparator<Element>> comparators = new ArrayList<>();
    comparators.add(comparator2);
    comparators.add(mock(Comparator.class));

    Min operation = new Min();
    operation.setInput(input);
    operation.setComparators(comparators);
    Context context = new Context();

    // Act
    Element actualDoOperationResult =
        minHandler.doOperation(operation, context, new TestAddToGraphLibraryImpl());

    // Assert
    verify(comparator).compare(isA(Element.class), isA(Element.class));
    verify(comparator2).thenComparing(isA(Comparator.class));
    assertTrue(actualDoOperationResult instanceof Edge);
    assertEquals("Dest", ((Edge) actualDoOperationResult).getDestination());
    assertEquals("Dest", ((Edge) actualDoOperationResult).getAdjacentMatchedVertexValue());
    assertEquals("Group", actualDoOperationResult.getGroup());
    assertEquals("Source", ((Edge) actualDoOperationResult).getSource());
    assertEquals("Source", ((Edge) actualDoOperationResult).getMatchedVertexValue());
    assertEquals("uk.gov.gchq.gaffer.data.element.Edge", actualDoOperationResult.getClassName());
    assertEquals(DirectedType.DIRECTED, ((Edge) actualDoOperationResult).getDirectedType());
    assertEquals(MatchedVertex.SOURCE, ((Edge) actualDoOperationResult).getMatchedVertex());
    assertFalse(((Edge) actualDoOperationResult).isUndirected());
    assertTrue(actualDoOperationResult.getProperties().isEmpty());
    assertTrue(((Edge) actualDoOperationResult).isDirected());
  }

  /**
   * Test {@link MinHandler#doOperation(Min, Context, Store)} with {@code Min}, {@code Context},
   * {@code Store}.
   *
   * <ul>
   *   <li>Given {@link Comparator} {@link Comparator#compare(Object, Object)} return zero.
   * </ul>
   *
   * <p>Method under test: {@link MinHandler#doOperation(Min, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(Min, Context, Store) with 'Min', 'Context', 'Store'; given Comparator compare(Object, Object) return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Element MinHandler.doOperation(Min, Context, Store)"})
  void testDoOperationWithMinContextStore_givenComparatorCompareReturnZero()
      throws OperationException {
    // Arrange
    MinHandler minHandler = new MinHandler();

    ArrayList<Element> input = new ArrayList<>();
    input.add(
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build());

    Comparator<Element> comparator = mock(Comparator.class);
    when(comparator.compare(Mockito.<Element>any(), Mockito.<Element>any())).thenReturn(0);

    Comparator<Element> comparator2 = mock(Comparator.class);
    when(comparator2.thenComparing(Mockito.<Comparator<Element>>any())).thenReturn(comparator);

    ArrayList<Comparator<Element>> comparators = new ArrayList<>();
    comparators.add(comparator2);
    comparators.add(mock(Comparator.class));

    Min operation = new Min();
    operation.setInput(input);
    operation.setComparators(comparators);
    Context context = new Context();

    // Act
    Element actualDoOperationResult =
        minHandler.doOperation(operation, context, new TestAddToGraphLibraryImpl());

    // Assert
    verify(comparator).compare(isA(Element.class), isA(Element.class));
    verify(comparator2).thenComparing(isA(Comparator.class));
    assertTrue(actualDoOperationResult instanceof Edge);
    assertEquals("Dest", ((Edge) actualDoOperationResult).getDestination());
    assertEquals("Dest", ((Edge) actualDoOperationResult).getAdjacentMatchedVertexValue());
    assertEquals("Group", actualDoOperationResult.getGroup());
    assertEquals("Source", ((Edge) actualDoOperationResult).getSource());
    assertEquals("Source", ((Edge) actualDoOperationResult).getMatchedVertexValue());
    assertEquals("uk.gov.gchq.gaffer.data.element.Edge", actualDoOperationResult.getClassName());
    assertEquals(DirectedType.DIRECTED, ((Edge) actualDoOperationResult).getDirectedType());
    assertEquals(MatchedVertex.SOURCE, ((Edge) actualDoOperationResult).getMatchedVertex());
    assertFalse(((Edge) actualDoOperationResult).isUndirected());
    assertTrue(actualDoOperationResult.getProperties().isEmpty());
    assertTrue(((Edge) actualDoOperationResult).isDirected());
  }

  /**
   * Test {@link MinHandler#doOperation(Min, Context, Store)} with {@code Min}, {@code Context},
   * {@code Store}.
   *
   * <ul>
   *   <li>Given {@link Comparator} {@link Comparator#compare(Object, Object)} return zero.
   * </ul>
   *
   * <p>Method under test: {@link MinHandler#doOperation(Min, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(Min, Context, Store) with 'Min', 'Context', 'Store'; given Comparator compare(Object, Object) return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Element MinHandler.doOperation(Min, Context, Store)"})
  void testDoOperationWithMinContextStore_givenComparatorCompareReturnZero2()
      throws OperationException {
    // Arrange
    MinHandler minHandler = new MinHandler();

    ArrayList<Element> input = new ArrayList<>();
    input.add(
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build());
    input.add(
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build());

    Comparator<Element> comparator = mock(Comparator.class);
    when(comparator.compare(Mockito.<Element>any(), Mockito.<Element>any())).thenReturn(0);

    Comparator<Element> comparator2 = mock(Comparator.class);
    when(comparator2.thenComparing(Mockito.<Comparator<Element>>any())).thenReturn(comparator);

    ArrayList<Comparator<Element>> comparators = new ArrayList<>();
    comparators.add(comparator2);
    comparators.add(mock(Comparator.class));

    Min operation = new Min();
    operation.setInput(input);
    operation.setComparators(comparators);
    Context context = new Context();

    // Act
    Element actualDoOperationResult =
        minHandler.doOperation(operation, context, new TestAddToGraphLibraryImpl());

    // Assert
    verify(comparator, atLeast(1)).compare(isA(Element.class), isA(Element.class));
    verify(comparator2).thenComparing(isA(Comparator.class));
    assertTrue(actualDoOperationResult instanceof Edge);
    assertEquals("Dest", ((Edge) actualDoOperationResult).getDestination());
    assertEquals("Dest", ((Edge) actualDoOperationResult).getAdjacentMatchedVertexValue());
    assertEquals("Group", actualDoOperationResult.getGroup());
    assertEquals("Source", ((Edge) actualDoOperationResult).getSource());
    assertEquals("Source", ((Edge) actualDoOperationResult).getMatchedVertexValue());
    assertEquals("uk.gov.gchq.gaffer.data.element.Edge", actualDoOperationResult.getClassName());
    assertEquals(DirectedType.DIRECTED, ((Edge) actualDoOperationResult).getDirectedType());
    assertEquals(MatchedVertex.SOURCE, ((Edge) actualDoOperationResult).getMatchedVertex());
    assertFalse(((Edge) actualDoOperationResult).isUndirected());
    assertTrue(actualDoOperationResult.getProperties().isEmpty());
    assertTrue(((Edge) actualDoOperationResult).isDirected());
  }

  /**
   * Test {@link MinHandler#doOperation(Min, Context, Store)} with {@code Min}, {@code Context},
   * {@code Store}.
   *
   * <ul>
   *   <li>Given {@link ElementPropertyComparator} (default constructor) Groups is {@link
   *       HashSet#HashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link MinHandler#doOperation(Min, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(Min, Context, Store) with 'Min', 'Context', 'Store'; given ElementPropertyComparator (default constructor) Groups is HashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Element MinHandler.doOperation(Min, Context, Store)"})
  void testDoOperationWithMinContextStore_givenElementPropertyComparatorGroupsIsHashSet()
      throws OperationException {
    // Arrange
    MinHandler minHandler = new MinHandler();

    ElementPropertyComparator elementPropertyComparator = new ElementPropertyComparator();
    elementPropertyComparator.setGroups(new HashSet<>());
    elementPropertyComparator.setComparator(null);
    elementPropertyComparator.setReversed(false);

    ArrayList<Comparator<Element>> comparators = new ArrayList<>();
    comparators.add(elementPropertyComparator);

    Min operation = new Min();
    operation.setInput(new ArrayList<>());
    operation.setComparators(comparators);
    Context context = new Context();

    // Act and Assert
    assertNull(minHandler.doOperation(operation, context, new TestAddToGraphLibraryImpl()));
  }

  /**
   * Test {@link MinHandler#doOperation(Min, Context, Store)} with {@code Min}, {@code Context},
   * {@code Store}.
   *
   * <ul>
   *   <li>Given {@link LinkedHashSet#LinkedHashSet()} add {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MinHandler#doOperation(Min, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(Min, Context, Store) with 'Min', 'Context', 'Store'; given LinkedHashSet() add 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Element MinHandler.doOperation(Min, Context, Store)"})
  void testDoOperationWithMinContextStore_givenLinkedHashSetAddNull() throws OperationException {
    // Arrange
    MinHandler minHandler = new MinHandler();

    LinkedHashSet<? extends Element> input = new LinkedHashSet<>();
    input.add(null);

    ElementPropertyComparator elementPropertyComparator = new ElementPropertyComparator();
    elementPropertyComparator.setGroups(new HashSet<>());
    elementPropertyComparator.setComparator(null);
    elementPropertyComparator.setReversed(false);

    ArrayList<Comparator<Element>> comparators = new ArrayList<>();
    comparators.add(elementPropertyComparator);

    Min operation = new Min();
    operation.setInput(input);
    operation.setComparators(comparators);
    Context context = new Context();

    // Act and Assert
    assertNull(minHandler.doOperation(operation, context, new TestAddToGraphLibraryImpl()));
  }

  /**
   * Test {@link MinHandler#doOperation(Min, Context, Store)} with {@code Min}, {@code Context},
   * {@code Store}.
   *
   * <ul>
   *   <li>Given {@link LinkedHashSet#LinkedHashSet()} add {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MinHandler#doOperation(Min, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(Min, Context, Store) with 'Min', 'Context', 'Store'; given LinkedHashSet() add 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Element MinHandler.doOperation(Min, Context, Store)"})
  void testDoOperationWithMinContextStore_givenLinkedHashSetAddNull2() throws OperationException {
    // Arrange
    MinHandler minHandler = new MinHandler();

    LinkedHashSet<? extends Element> input = new LinkedHashSet<>();
    input.add(null);

    ElementPropertyComparator elementPropertyComparator = new ElementPropertyComparator();
    elementPropertyComparator.setGroups(new HashSet<>());
    elementPropertyComparator.setComparator(null);
    elementPropertyComparator.setReversed(false);

    Comparator<Element> comparator = mock(Comparator.class);
    when(comparator.thenComparing(Mockito.<Comparator<Element>>any()))
        .thenReturn(mock(Comparator.class));

    ArrayList<Comparator<Element>> comparators = new ArrayList<>();
    comparators.add(comparator);
    comparators.add(elementPropertyComparator);

    Min operation = new Min();
    operation.setInput(input);
    operation.setComparators(comparators);
    Context context = new Context();

    // Act
    Element actualDoOperationResult =
        minHandler.doOperation(operation, context, new TestAddToGraphLibraryImpl());

    // Assert
    verify(comparator).thenComparing(isA(Comparator.class));
    assertNull(actualDoOperationResult);
  }

  /**
   * Test {@link MinHandler#doOperation(Min, Context, Store)} with {@code Min}, {@code Context},
   * {@code Store}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link Min} (default constructor) Comparators is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MinHandler#doOperation(Min, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(Min, Context, Store) with 'Min', 'Context', 'Store'; given 'null'; when Min (default constructor) Comparators is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Element MinHandler.doOperation(Min, Context, Store)"})
  void testDoOperationWithMinContextStore_givenNull_whenMinComparatorsIsNull()
      throws OperationException {
    // Arrange
    MinHandler minHandler = new MinHandler();

    Min operation = new Min();
    operation.setInput(new ArrayList<>());
    operation.setComparators(null);
    Context context = new Context();

    // Act and Assert
    assertNull(minHandler.doOperation(operation, context, new TestAddToGraphLibraryImpl()));
  }

  /**
   * Test {@link MinHandler#doOperation(Min, Context, Store)} with {@code Min}, {@code Context},
   * {@code Store}.
   *
   * <ul>
   *   <li>Then calls {@link Comparator#thenComparing(Comparator)}.
   * </ul>
   *
   * <p>Method under test: {@link MinHandler#doOperation(Min, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(Min, Context, Store) with 'Min', 'Context', 'Store'; then calls thenComparing(Comparator)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Element MinHandler.doOperation(Min, Context, Store)"})
  void testDoOperationWithMinContextStore_thenCallsThenComparing() throws OperationException {
    // Arrange
    MinHandler minHandler = new MinHandler();

    Comparator<Element> comparator = mock(Comparator.class);
    when(comparator.thenComparing(Mockito.<Comparator<Element>>any()))
        .thenReturn(mock(Comparator.class));

    ArrayList<Comparator<Element>> comparators = new ArrayList<>();
    comparators.add(comparator);
    comparators.add(mock(Comparator.class));

    Min operation = new Min();
    operation.setInput(new ArrayList<>());
    operation.setComparators(comparators);
    Context context = new Context();

    // Act
    Element actualDoOperationResult =
        minHandler.doOperation(operation, context, new TestAddToGraphLibraryImpl());

    // Assert
    verify(comparator).thenComparing(isA(Comparator.class));
    assertNull(actualDoOperationResult);
  }

  /**
   * Test {@link MinHandler#doOperation(Min, Context, Store)} with {@code Min}, {@code Context},
   * {@code Store}.
   *
   * <ul>
   *   <li>When {@link Min} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MinHandler#doOperation(Min, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(Min, Context, Store) with 'Min', 'Context', 'Store'; when Min (default constructor); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Element MinHandler.doOperation(Min, Context, Store)"})
  void testDoOperationWithMinContextStore_whenMin_thenReturnNull() throws OperationException {
    // Arrange
    MinHandler minHandler = new MinHandler();
    Min operation = new Min();
    Context context = new Context();

    // Act and Assert
    assertNull(minHandler.doOperation(operation, context, new TestAddToGraphLibraryImpl()));
  }
}
