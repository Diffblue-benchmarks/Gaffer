package uk.gov.gchq.gaffer.data.element.function;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.function.BinaryOperator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.Edge;
import uk.gov.gchq.gaffer.data.element.Edge.Builder;
import uk.gov.gchq.gaffer.data.element.Element;
import uk.gov.gchq.gaffer.data.element.id.DirectedType;
import uk.gov.gchq.gaffer.data.element.id.EdgeId;
import uk.gov.gchq.gaffer.data.element.id.EdgeId.MatchedVertex;
import uk.gov.gchq.koryphe.impl.binaryoperator.First;
import uk.gov.gchq.koryphe.iterable.ChainedIterable;
import uk.gov.gchq.koryphe.iterable.ChainedIterator;

class ReduceRelatedElementsDiffblueTest {
  /**
   * Test {@link ReduceRelatedElements#apply(Iterable)} with {@code Iterable}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code foo}.
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return {@link ChainedIterable}.
   * </ul>
   *
   * <p>Method under test: {@link ReduceRelatedElements#apply(Iterable)}
   */
  @Test
  @DisplayName(
      "Test apply(Iterable) with 'Iterable'; given HashSet() add 'foo'; when ArrayList(); then return ChainedIterable")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable ReduceRelatedElements.apply(Iterable)"})
  void testApplyWithIterable_givenHashSetAddFoo_whenArrayList_thenReturnChainedIterable() {
    // Arrange
    HashSet<String> relatedVertexGroups = new HashSet<>();
    relatedVertexGroups.add("foo");

    ReduceRelatedElements reduceRelatedElements = new ReduceRelatedElements();
    reduceRelatedElements.setRelatedVertexGroups(relatedVertexGroups);

    // Act
    Iterable<Element> actualApplyResult = reduceRelatedElements.apply(new ArrayList<>());
    Iterator<Element> actualIteratorResult = actualApplyResult.iterator();

    // Assert
    assertTrue(actualApplyResult instanceof ChainedIterable);
    Iterator<Element> iteratorResult = actualApplyResult.iterator();
    assertTrue(iteratorResult instanceof ChainedIterator);
    assertTrue(actualIteratorResult instanceof ChainedIterator);
    assertFalse(iteratorResult.hasNext());
    assertFalse(actualIteratorResult.hasNext());
  }

  /**
   * Test {@link ReduceRelatedElements#apply(Iterable)} with {@code Iterable}.
   *
   * <ul>
   *   <li>Given {@link ReduceRelatedElements} (default constructor).
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return {@link List}.
   * </ul>
   *
   * <p>Method under test: {@link ReduceRelatedElements#apply(Iterable)}
   */
  @Test
  @DisplayName(
      "Test apply(Iterable) with 'Iterable'; given ReduceRelatedElements (default constructor); when ArrayList(); then return List")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable ReduceRelatedElements.apply(Iterable)"})
  void testApplyWithIterable_givenReduceRelatedElements_whenArrayList_thenReturnList() {
    // Arrange
    ReduceRelatedElements reduceRelatedElements = new ReduceRelatedElements();

    // Act
    Iterable<Element> actualApplyResult = reduceRelatedElements.apply(new ArrayList<>());
    Iterator<Element> actualIteratorResult = actualApplyResult.iterator();

    // Assert
    assertTrue(actualApplyResult instanceof List);
    assertFalse(actualIteratorResult.hasNext());
    assertTrue(((List<Element>) actualApplyResult).isEmpty());
  }

  /**
   * Test {@link ReduceRelatedElements#apply(Iterable)} with {@code Iterable}.
   *
   * <ul>
   *   <li>Then return iterator next Destination is {@code Dest}.
   * </ul>
   *
   * <p>Method under test: {@link ReduceRelatedElements#apply(Iterable)}
   */
  @Test
  @DisplayName(
      "Test apply(Iterable) with 'Iterable'; then return iterator next Destination is 'Dest'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable ReduceRelatedElements.apply(Iterable)"})
  void testApplyWithIterable_thenReturnIteratorNextDestinationIsDest() {
    // Arrange
    HashSet<String> relatedVertexGroups = new HashSet<>();
    relatedVertexGroups.add("foo");

    ReduceRelatedElements reduceRelatedElements = new ReduceRelatedElements();
    reduceRelatedElements.setRelatedVertexGroups(relatedVertexGroups);

    ArrayList<Element> elements = new ArrayList<>();
    elements.add(
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build());

    // Act
    Iterable<Element> actualApplyResult = reduceRelatedElements.apply(elements);
    actualApplyResult.iterator();

    // Assert
    Iterator<Element> iteratorResult = actualApplyResult.iterator();
    Element nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof Edge);
    assertTrue(actualApplyResult instanceof ChainedIterable);
    assertTrue(iteratorResult instanceof ChainedIterator);
    assertEquals("Dest", ((Edge) nextResult).getDestination());
    assertEquals("Source", ((Edge) nextResult).getSource());
    assertEquals(DirectedType.DIRECTED, ((Edge) nextResult).getDirectedType());
    assertEquals(MatchedVertex.SOURCE, ((Edge) nextResult).getMatchedVertex());
    assertFalse(iteratorResult.hasNext());
    assertFalse(((Edge) nextResult).isUndirected());
    assertTrue(((Edge) nextResult).isDirected());
  }

  /**
   * Test {@link ReduceRelatedElements#apply(Iterable)} with {@code Iterable}.
   *
   * <ul>
   *   <li>Then return iterator next Source is {@code Dest}.
   * </ul>
   *
   * <p>Method under test: {@link ReduceRelatedElements#apply(Iterable)}
   */
  @Test
  @DisplayName("Test apply(Iterable) with 'Iterable'; then return iterator next Source is 'Dest'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable ReduceRelatedElements.apply(Iterable)"})
  void testApplyWithIterable_thenReturnIteratorNextSourceIsDest() {
    // Arrange
    HashSet<String> relatedVertexGroups = new HashSet<>();
    relatedVertexGroups.add("foo");

    ReduceRelatedElements reduceRelatedElements = new ReduceRelatedElements();
    reduceRelatedElements.setRelatedVertexGroups(relatedVertexGroups);

    ArrayList<Element> elements = new ArrayList<>();
    elements.add(
        new Builder()
            .dest("Dest")
            .directed(false)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build());

    // Act
    Iterable<Element> actualApplyResult = reduceRelatedElements.apply(elements);
    actualApplyResult.iterator();

    // Assert
    Iterator<Element> iteratorResult = actualApplyResult.iterator();
    Element nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof Edge);
    assertTrue(actualApplyResult instanceof ChainedIterable);
    assertTrue(iteratorResult instanceof ChainedIterator);
    assertEquals("Dest", ((Edge) nextResult).getSource());
    assertEquals("Source", ((Edge) nextResult).getDestination());
    assertEquals(DirectedType.UNDIRECTED, ((Edge) nextResult).getDirectedType());
    assertEquals(MatchedVertex.DESTINATION, ((Edge) nextResult).getMatchedVertex());
    assertFalse(iteratorResult.hasNext());
    assertFalse(((Edge) nextResult).isDirected());
    assertTrue(((Edge) nextResult).isUndirected());
  }

  /**
   * Test {@link ReduceRelatedElements#apply(Iterable)} with {@code Iterable}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return {@link List}.
   * </ul>
   *
   * <p>Method under test: {@link ReduceRelatedElements#apply(Iterable)}
   */
  @Test
  @DisplayName("Test apply(Iterable) with 'Iterable'; when ArrayList(); then return List")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable ReduceRelatedElements.apply(Iterable)"})
  void testApplyWithIterable_whenArrayList_thenReturnList() {
    // Arrange
    ReduceRelatedElements reduceRelatedElements = new ReduceRelatedElements();
    reduceRelatedElements.setRelatedVertexGroups(new HashSet<>());

    // Act
    Iterable<Element> actualApplyResult = reduceRelatedElements.apply(new ArrayList<>());
    Iterator<Element> actualIteratorResult = actualApplyResult.iterator();

    // Assert
    assertTrue(actualApplyResult instanceof List);
    assertFalse(actualIteratorResult.hasNext());
    assertTrue(((List<Element>) actualApplyResult).isEmpty());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ReduceRelatedElements#setRelatedVertexGroups(Set)}
   *   <li>{@link ReduceRelatedElements#setVertexAggregator(BinaryOperator)}
   *   <li>{@link ReduceRelatedElements#setVisibilityAggregator(BinaryOperator)}
   *   <li>{@link ReduceRelatedElements#setVisibilityProperty(String)}
   *   <li>{@link ReduceRelatedElements#getRelatedVertexGroups()}
   *   <li>{@link ReduceRelatedElements#getVertexAggregator()}
   *   <li>{@link ReduceRelatedElements#getVisibilityAggregator()}
   *   <li>{@link ReduceRelatedElements#getVisibilityProperty()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set ReduceRelatedElements.getRelatedVertexGroups()",
    "BinaryOperator ReduceRelatedElements.getVertexAggregator()",
    "BinaryOperator ReduceRelatedElements.getVisibilityAggregator()",
    "String ReduceRelatedElements.getVisibilityProperty()",
    "void ReduceRelatedElements.setRelatedVertexGroups(Set)",
    "void ReduceRelatedElements.setVertexAggregator(BinaryOperator)",
    "void ReduceRelatedElements.setVisibilityAggregator(BinaryOperator)",
    "void ReduceRelatedElements.setVisibilityProperty(String)"
  })
  void testGettersAndSetters() {
    // Arrange
    ReduceRelatedElements reduceRelatedElements = new ReduceRelatedElements();
    HashSet<String> relatedVertexGroups = new HashSet<>();

    // Act
    reduceRelatedElements.setRelatedVertexGroups(relatedVertexGroups);
    BinaryOperator<Object> vertexAggregator = mock(BinaryOperator.class);
    reduceRelatedElements.setVertexAggregator(vertexAggregator);
    BinaryOperator<Object> visibilityAggregator = mock(BinaryOperator.class);
    reduceRelatedElements.setVisibilityAggregator(visibilityAggregator);
    reduceRelatedElements.setVisibilityProperty("Visibility Property");
    Set<String> actualRelatedVertexGroups = reduceRelatedElements.getRelatedVertexGroups();
    BinaryOperator<Object> actualVertexAggregator = reduceRelatedElements.getVertexAggregator();
    BinaryOperator<Object> actualVisibilityAggregator =
        reduceRelatedElements.getVisibilityAggregator();

    // Assert
    assertEquals("Visibility Property", reduceRelatedElements.getVisibilityProperty());
    assertTrue(actualRelatedVertexGroups.isEmpty());
    assertSame(relatedVertexGroups, actualRelatedVertexGroups);
    assertSame(vertexAggregator, actualVertexAggregator);
    assertSame(visibilityAggregator, actualVisibilityAggregator);
  }

  /**
   * Test new {@link ReduceRelatedElements} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link ReduceRelatedElements}
   */
  @Test
  @DisplayName("Test new ReduceRelatedElements (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ReduceRelatedElements.<init>()"})
  void testNewReduceRelatedElements() {
    // Arrange and Act
    ReduceRelatedElements actualReduceRelatedElements = new ReduceRelatedElements();

    // Assert
    assertTrue(actualReduceRelatedElements.getVertexAggregator() instanceof First);
    assertNull(actualReduceRelatedElements.getVisibilityProperty());
    assertNull(actualReduceRelatedElements.getRelatedVertexGroups());
    assertNull(actualReduceRelatedElements.getVisibilityAggregator());
  }
}
