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

package uk.gov.gchq.gaffer.data.element.function;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.function.BinaryOperator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.Edge;
import uk.gov.gchq.gaffer.data.element.Edge.Builder;
import uk.gov.gchq.gaffer.data.element.Element;
import uk.gov.gchq.gaffer.data.element.Entity;
import uk.gov.gchq.gaffer.data.element.id.DirectedType;
import uk.gov.gchq.gaffer.data.element.id.EdgeId;
import uk.gov.gchq.gaffer.data.element.id.EdgeId.MatchedVertex;
import uk.gov.gchq.koryphe.impl.binaryoperator.First;

class ReduceRelatedElementsDiffblueTest {
  /**
   * Test {@link ReduceRelatedElements#apply(Iterable)} with {@code Iterable}.
   * <ul>
   *   <li>Given {@link Edge#Edge(String)} with {@code Group}.</li>
   *   <li>Then return iterator next Destination is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReduceRelatedElements#apply(Iterable)}
   */
  @Test
  @DisplayName("Test apply(Iterable) with 'Iterable'; given Edge(String) with 'Group'; then return iterator next Destination is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Iterable ReduceRelatedElements.apply(Iterable)"})
  void testApplyWithIterable_givenEdgeWithGroup_thenReturnIteratorNextDestinationIsNull() {
    // Arrange
    ReduceRelatedElements reduceRelatedElements = new ReduceRelatedElements();
    reduceRelatedElements.setRelatedVertexGroups(null);

    LinkedHashSet<Element> elements = new LinkedHashSet<>();
    elements.add(new Edge("Group"));

    // Act
    Iterator<Element> actualIteratorResult = reduceRelatedElements.apply(elements).iterator();

    // Assert
    Element nextResult = actualIteratorResult.next();
    assertTrue(nextResult instanceof Edge);
    assertNull(((Edge) nextResult).getDestination());
    assertNull(((Edge) nextResult).getSource());
    assertNull(((Edge) nextResult).getAdjacentMatchedVertexValue());
    assertNull(((Edge) nextResult).getMatchedVertexValue());
    assertNull(((Edge) nextResult).getMatchedVertex());
    assertEquals(DirectedType.UNDIRECTED, ((Edge) nextResult).getDirectedType());
    assertFalse(actualIteratorResult.hasNext());
    assertFalse(((Edge) nextResult).isDirected());
    assertTrue(((Edge) nextResult).isUndirected());
  }

  /**
   * Test {@link ReduceRelatedElements#apply(Iterable)} with {@code Iterable}.
   * <ul>
   *   <li>Given {@link Edge#Edge(String)} with {@code Group}.</li>
   *   <li>Then return iterator next Destination is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReduceRelatedElements#apply(Iterable)}
   */
  @Test
  @DisplayName("Test apply(Iterable) with 'Iterable'; given Edge(String) with 'Group'; then return iterator next Destination is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Iterable ReduceRelatedElements.apply(Iterable)"})
  void testApplyWithIterable_givenEdgeWithGroup_thenReturnIteratorNextDestinationIsNull2() {
    // Arrange
    ReduceRelatedElements reduceRelatedElements = new ReduceRelatedElements();
    reduceRelatedElements.setRelatedVertexGroups(new HashSet<>());

    LinkedHashSet<Element> elements = new LinkedHashSet<>();
    elements.add(new Edge("Group"));

    // Act
    Iterator<Element> actualIteratorResult = reduceRelatedElements.apply(elements).iterator();

    // Assert
    Element nextResult = actualIteratorResult.next();
    assertTrue(nextResult instanceof Edge);
    assertNull(((Edge) nextResult).getDestination());
    assertNull(((Edge) nextResult).getSource());
    assertNull(((Edge) nextResult).getAdjacentMatchedVertexValue());
    assertNull(((Edge) nextResult).getMatchedVertexValue());
    assertNull(((Edge) nextResult).getMatchedVertex());
    assertEquals(DirectedType.UNDIRECTED, ((Edge) nextResult).getDirectedType());
    assertFalse(actualIteratorResult.hasNext());
    assertFalse(((Edge) nextResult).isDirected());
    assertTrue(((Edge) nextResult).isUndirected());
  }

  /**
   * Test {@link ReduceRelatedElements#apply(Iterable)} with {@code Iterable}.
   * <ul>
   *   <li>Given {@link ReduceRelatedElements} (default constructor).</li>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@link List}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReduceRelatedElements#apply(Iterable)}
   */
  @Test
  @DisplayName("Test apply(Iterable) with 'Iterable'; given ReduceRelatedElements (default constructor); when ArrayList(); then return List")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Iterable ReduceRelatedElements.apply(Iterable)"})
  void testApplyWithIterable_givenReduceRelatedElements_whenArrayList_thenReturnList() {
    // Arrange
    ReduceRelatedElements reduceRelatedElements = new ReduceRelatedElements();

    // Act
    Iterable<Element> actualApplyResult = reduceRelatedElements.apply(new ArrayList<>());

    // Assert
    assertTrue(actualApplyResult instanceof List);
    assertFalse(actualApplyResult.iterator().hasNext());
    assertTrue(((List<Element>) actualApplyResult).isEmpty());
  }

  /**
   * Test {@link ReduceRelatedElements#apply(Iterable)} with {@code Iterable}.
   * <ul>
   *   <li>Then iterator next return {@link Entity}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReduceRelatedElements#apply(Iterable)}
   */
  @Test
  @DisplayName("Test apply(Iterable) with 'Iterable'; then iterator next return Entity")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Iterable ReduceRelatedElements.apply(Iterable)"})
  void testApplyWithIterable_thenIteratorNextReturnEntity() {
    // Arrange
    ReduceRelatedElements reduceRelatedElements = new ReduceRelatedElements();
    reduceRelatedElements.setRelatedVertexGroups(null);

    LinkedHashSet<Element> elements = new LinkedHashSet<>();
    Entity buildResult = (new Entity.Builder()).group("Group").vertex("Vertex").build();
    elements.add(buildResult);

    // Act
    Iterator<Element> actualIteratorResult = reduceRelatedElements.apply(elements).iterator();

    // Assert
    Element nextResult = actualIteratorResult.next();
    assertTrue(nextResult instanceof Entity);
    assertEquals("Vertex", ((Entity) nextResult).getVertex());
    assertEquals("uk.gov.gchq.gaffer.data.element.Entity", nextResult.getClassName());
    assertFalse(actualIteratorResult.hasNext());
  }

  /**
   * Test {@link ReduceRelatedElements#apply(Iterable)} with {@code Iterable}.
   * <ul>
   *   <li>Then iterator next return {@link Entity}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReduceRelatedElements#apply(Iterable)}
   */
  @Test
  @DisplayName("Test apply(Iterable) with 'Iterable'; then iterator next return Entity")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Iterable ReduceRelatedElements.apply(Iterable)"})
  void testApplyWithIterable_thenIteratorNextReturnEntity2() {
    // Arrange
    ReduceRelatedElements reduceRelatedElements = new ReduceRelatedElements();
    reduceRelatedElements.setRelatedVertexGroups(new HashSet<>());

    LinkedHashSet<Element> elements = new LinkedHashSet<>();
    Entity buildResult = (new Entity.Builder()).group("Group").vertex("Vertex").build();
    elements.add(buildResult);

    // Act
    Iterator<Element> actualIteratorResult = reduceRelatedElements.apply(elements).iterator();

    // Assert
    Element nextResult = actualIteratorResult.next();
    assertTrue(nextResult instanceof Entity);
    assertEquals("Vertex", ((Entity) nextResult).getVertex());
    assertEquals("uk.gov.gchq.gaffer.data.element.Entity", nextResult.getClassName());
    assertFalse(actualIteratorResult.hasNext());
  }

  /**
   * Test {@link ReduceRelatedElements#apply(Iterable)} with {@code Iterable}.
   * <ul>
   *   <li>Then return iterator next Destination is {@code Dest}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReduceRelatedElements#apply(Iterable)}
   */
  @Test
  @DisplayName("Test apply(Iterable) with 'Iterable'; then return iterator next Destination is 'Dest'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Iterable ReduceRelatedElements.apply(Iterable)"})
  void testApplyWithIterable_thenReturnIteratorNextDestinationIsDest() {
    // Arrange
    ReduceRelatedElements reduceRelatedElements = new ReduceRelatedElements();
    reduceRelatedElements.setRelatedVertexGroups(null);

    LinkedHashSet<Element> elements = new LinkedHashSet<>();
    Edge buildResult = (new Builder()).dest("Dest")
        .directed(true)
        .group("Group")
        .matchedVertex(MatchedVertex.SOURCE)
        .source("Source")
        .build();
    elements.add(buildResult);

    // Act
    Iterator<Element> actualIteratorResult = reduceRelatedElements.apply(elements).iterator();

    // Assert
    Element nextResult = actualIteratorResult.next();
    assertTrue(nextResult instanceof Edge);
    assertEquals("Dest", ((Edge) nextResult).getDestination());
    assertEquals("Dest", ((Edge) nextResult).getAdjacentMatchedVertexValue());
    assertEquals("Source", ((Edge) nextResult).getSource());
    assertEquals("Source", ((Edge) nextResult).getMatchedVertexValue());
    assertEquals(DirectedType.DIRECTED, ((Edge) nextResult).getDirectedType());
    assertEquals(MatchedVertex.SOURCE, ((Edge) nextResult).getMatchedVertex());
    assertFalse(actualIteratorResult.hasNext());
    assertFalse(((Edge) nextResult).isUndirected());
    assertTrue(((Edge) nextResult).isDirected());
  }

  /**
   * Test {@link ReduceRelatedElements#apply(Iterable)} with {@code Iterable}.
   * <ul>
   *   <li>Then return iterator next Destination is {@code Dest}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReduceRelatedElements#apply(Iterable)}
   */
  @Test
  @DisplayName("Test apply(Iterable) with 'Iterable'; then return iterator next Destination is 'Dest'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Iterable ReduceRelatedElements.apply(Iterable)"})
  void testApplyWithIterable_thenReturnIteratorNextDestinationIsDest2() {
    // Arrange
    ReduceRelatedElements reduceRelatedElements = new ReduceRelatedElements();
    reduceRelatedElements.setRelatedVertexGroups(new HashSet<>());

    LinkedHashSet<Element> elements = new LinkedHashSet<>();
    Edge buildResult = (new Builder()).dest("Dest")
        .directed(true)
        .group("Group")
        .matchedVertex(MatchedVertex.SOURCE)
        .source("Source")
        .build();
    elements.add(buildResult);

    // Act
    Iterator<Element> actualIteratorResult = reduceRelatedElements.apply(elements).iterator();

    // Assert
    Element nextResult = actualIteratorResult.next();
    assertTrue(nextResult instanceof Edge);
    assertEquals("Dest", ((Edge) nextResult).getDestination());
    assertEquals("Dest", ((Edge) nextResult).getAdjacentMatchedVertexValue());
    assertEquals("Source", ((Edge) nextResult).getSource());
    assertEquals("Source", ((Edge) nextResult).getMatchedVertexValue());
    assertEquals(DirectedType.DIRECTED, ((Edge) nextResult).getDirectedType());
    assertEquals(MatchedVertex.SOURCE, ((Edge) nextResult).getMatchedVertex());
    assertFalse(actualIteratorResult.hasNext());
    assertFalse(((Edge) nextResult).isUndirected());
    assertTrue(((Edge) nextResult).isDirected());
  }

  /**
   * Test {@link ReduceRelatedElements#apply(Iterable)} with {@code Iterable}.
   * <ul>
   *   <li>Then return iterator next is {@link Entity#Entity(String)} with {@code Group}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReduceRelatedElements#apply(Iterable)}
   */
  @Test
  @DisplayName("Test apply(Iterable) with 'Iterable'; then return iterator next is Entity(String) with 'Group'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Iterable ReduceRelatedElements.apply(Iterable)"})
  void testApplyWithIterable_thenReturnIteratorNextIsEntityWithGroup() {
    // Arrange
    ReduceRelatedElements reduceRelatedElements = new ReduceRelatedElements();
    reduceRelatedElements.setRelatedVertexGroups(null);
    Entity entity = new Entity("Group");

    LinkedHashSet<Element> elements = new LinkedHashSet<>();
    elements.add(entity);

    // Act
    Iterator<Element> actualIteratorResult = reduceRelatedElements.apply(elements).iterator();

    // Assert
    Element actualNextResult = actualIteratorResult.next();
    assertFalse(actualIteratorResult.hasNext());
    assertSame(entity, actualNextResult);
  }

  /**
   * Test {@link ReduceRelatedElements#apply(Iterable)} with {@code Iterable}.
   * <ul>
   *   <li>Then return iterator next is {@link Entity#Entity(String)} with {@code Group}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReduceRelatedElements#apply(Iterable)}
   */
  @Test
  @DisplayName("Test apply(Iterable) with 'Iterable'; then return iterator next is Entity(String) with 'Group'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Iterable ReduceRelatedElements.apply(Iterable)"})
  void testApplyWithIterable_thenReturnIteratorNextIsEntityWithGroup2() {
    // Arrange
    ReduceRelatedElements reduceRelatedElements = new ReduceRelatedElements();
    reduceRelatedElements.setRelatedVertexGroups(new HashSet<>());
    Entity entity = new Entity("Group");

    LinkedHashSet<Element> elements = new LinkedHashSet<>();
    elements.add(entity);

    // Act
    Iterator<Element> actualIteratorResult = reduceRelatedElements.apply(elements).iterator();

    // Assert
    Element actualNextResult = actualIteratorResult.next();
    assertFalse(actualIteratorResult.hasNext());
    assertSame(entity, actualNextResult);
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set ReduceRelatedElements.getRelatedVertexGroups()",
      "BinaryOperator ReduceRelatedElements.getVertexAggregator()",
      "BinaryOperator ReduceRelatedElements.getVisibilityAggregator()",
      "String ReduceRelatedElements.getVisibilityProperty()", "void ReduceRelatedElements.setRelatedVertexGroups(Set)",
      "void ReduceRelatedElements.setVertexAggregator(BinaryOperator)",
      "void ReduceRelatedElements.setVisibilityAggregator(BinaryOperator)",
      "void ReduceRelatedElements.setVisibilityProperty(String)"})
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
    BinaryOperator<Object> actualVisibilityAggregator = reduceRelatedElements.getVisibilityAggregator();

    // Assert
    assertEquals("Visibility Property", reduceRelatedElements.getVisibilityProperty());
    assertTrue(actualRelatedVertexGroups.isEmpty());
    assertSame(relatedVertexGroups, actualRelatedVertexGroups);
    assertSame(vertexAggregator, actualVertexAggregator);
    assertSame(visibilityAggregator, actualVisibilityAggregator);
  }

  /**
   * Test new {@link ReduceRelatedElements} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link ReduceRelatedElements}
   */
  @Test
  @DisplayName("Test new ReduceRelatedElements (default constructor)")
  @Tag("MaintainedByDiffblue")
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
