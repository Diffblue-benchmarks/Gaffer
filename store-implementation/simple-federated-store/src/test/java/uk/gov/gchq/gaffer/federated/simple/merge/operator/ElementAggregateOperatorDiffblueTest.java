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

package uk.gov.gchq.gaffer.federated.simple.merge.operator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.Edge;
import uk.gov.gchq.gaffer.data.element.Edge.Builder;
import uk.gov.gchq.gaffer.data.element.Element;
import uk.gov.gchq.gaffer.data.element.id.DirectedType;
import uk.gov.gchq.gaffer.data.element.id.EdgeId;
import uk.gov.gchq.gaffer.data.element.id.EdgeId.MatchedVertex;

class ElementAggregateOperatorDiffblueTest {
  /**
   * Test {@link ElementAggregateOperator#apply(Iterable, Iterable)} with {@code Iterable}, {@code
   * Iterable}.
   *
   * <p>Method under test: {@link ElementAggregateOperator#apply(Iterable, Iterable)}
   */
  @Test
  @DisplayName("Test apply(Iterable, Iterable) with 'Iterable', 'Iterable'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable ElementAggregateOperator.apply(Iterable, Iterable)"})
  void testApplyWithIterableIterable() {
    // Arrange
    ElementAggregateOperator elementAggregateOperator = new ElementAggregateOperator();

    ArrayList<Element> update = new ArrayList<>();

    Builder builder = new Builder();
    update.add(
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

    // Act
    Iterable<Element> actualApplyResult = elementAggregateOperator.apply(update, new ArrayList<>());

    // Assert
    assertTrue(actualApplyResult instanceof Set);
    assertEquals(1, update.size());
    Element getResult = update.get(0);
    assertTrue(getResult instanceof Edge);
    Object adjacentMatchedVertexValue = ((Edge) getResult).getAdjacentMatchedVertexValue();
    assertTrue(adjacentMatchedVertexValue instanceof Edge);
    assertEquals("Group", getResult.getGroup());
    assertEquals("Source", ((Edge) getResult).getSource());
    assertEquals("Source", ((Edge) getResult).getMatchedVertexValue());
    assertEquals("uk.gov.gchq.gaffer.data.element.Edge", getResult.getClassName());
    assertEquals(1, ((Set<Element>) actualApplyResult).size());
    assertEquals(DirectedType.DIRECTED, ((Edge) getResult).getDirectedType());
    assertEquals(MatchedVertex.SOURCE, ((Edge) getResult).getMatchedVertex());
    assertFalse(((Edge) getResult).isUndirected());
    assertTrue(getResult.getProperties().isEmpty());
    assertTrue(((Edge) getResult).isDirected());
    assertSame(adjacentMatchedVertexValue, ((Edge) getResult).getDestination());
  }

  /**
   * Test {@link ElementAggregateOperator#apply(Iterable, Iterable)} with {@code Iterable}, {@code
   * Iterable}.
   *
   * <ul>
   *   <li>Given {@link ElementAggregateOperator} (default constructor).
   *   <li>Then {@link ArrayList#ArrayList()} Empty.
   * </ul>
   *
   * <p>Method under test: {@link ElementAggregateOperator#apply(Iterable, Iterable)}
   */
  @Test
  @DisplayName(
      "Test apply(Iterable, Iterable) with 'Iterable', 'Iterable'; given ElementAggregateOperator (default constructor); then ArrayList() Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable ElementAggregateOperator.apply(Iterable, Iterable)"})
  void testApplyWithIterableIterable_givenElementAggregateOperator_thenArrayListEmpty() {
    // Arrange
    ElementAggregateOperator elementAggregateOperator = new ElementAggregateOperator();
    ArrayList<Element> update = new ArrayList<>();

    // Act
    Iterable<Element> actualApplyResult = elementAggregateOperator.apply(update, new ArrayList<>());

    // Assert
    assertTrue(actualApplyResult instanceof Set);
    assertTrue(update.isEmpty());
    assertTrue(((Set<Element>) actualApplyResult).isEmpty());
  }

  /**
   * Test {@link ElementAggregateOperator#apply(Iterable, Iterable)} with {@code Iterable}, {@code
   * Iterable}.
   *
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} first Destination is {@code Dest}.
   * </ul>
   *
   * <p>Method under test: {@link ElementAggregateOperator#apply(Iterable, Iterable)}
   */
  @Test
  @DisplayName(
      "Test apply(Iterable, Iterable) with 'Iterable', 'Iterable'; then ArrayList() first Destination is 'Dest'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable ElementAggregateOperator.apply(Iterable, Iterable)"})
  void testApplyWithIterableIterable_thenArrayListFirstDestinationIsDest() {
    // Arrange
    ElementAggregateOperator elementAggregateOperator = new ElementAggregateOperator();

    ArrayList<Element> update = new ArrayList<>();
    update.add(
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build());

    // Act
    Iterable<Element> actualApplyResult = elementAggregateOperator.apply(update, new ArrayList<>());

    // Assert
    assertTrue(actualApplyResult instanceof Set);
    assertEquals(1, update.size());
    Element getResult = update.get(0);
    assertTrue(getResult instanceof Edge);
    assertEquals("Dest", ((Edge) getResult).getDestination());
    assertEquals("Dest", ((Edge) getResult).getAdjacentMatchedVertexValue());
    assertEquals("Group", getResult.getGroup());
    assertEquals("Source", ((Edge) getResult).getSource());
    assertEquals("Source", ((Edge) getResult).getMatchedVertexValue());
    assertEquals("uk.gov.gchq.gaffer.data.element.Edge", getResult.getClassName());
    assertEquals(1, ((Set<Element>) actualApplyResult).size());
    assertEquals(DirectedType.DIRECTED, ((Edge) getResult).getDirectedType());
    assertEquals(MatchedVertex.SOURCE, ((Edge) getResult).getMatchedVertex());
    assertFalse(((Edge) getResult).isUndirected());
    assertTrue(getResult.getProperties().isEmpty());
    assertTrue(((Edge) getResult).isDirected());
  }

  /**
   * Test {@link ElementAggregateOperator#apply(Iterable, Iterable)} with {@code Iterable}, {@code
   * Iterable}.
   *
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} first Destination is {@link Edge#Edge(String)} with
   *       {@code Group}.
   * </ul>
   *
   * <p>Method under test: {@link ElementAggregateOperator#apply(Iterable, Iterable)}
   */
  @Test
  @DisplayName(
      "Test apply(Iterable, Iterable) with 'Iterable', 'Iterable'; then ArrayList() first Destination is Edge(String) with 'Group'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable ElementAggregateOperator.apply(Iterable, Iterable)"})
  void testApplyWithIterableIterable_thenArrayListFirstDestinationIsEdgeWithGroup() {
    // Arrange
    ElementAggregateOperator elementAggregateOperator = new ElementAggregateOperator();

    ArrayList<Element> update = new ArrayList<>();

    Builder builder = new Builder();
    Edge edge = new Edge("Group");
    update.add(
        builder
            .dest(edge)
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build());

    // Act
    Iterable<Element> actualApplyResult = elementAggregateOperator.apply(update, new ArrayList<>());

    // Assert
    assertTrue(actualApplyResult instanceof Set);
    assertEquals(1, update.size());
    Element getResult = update.get(0);
    assertTrue(getResult instanceof Edge);
    Object adjacentMatchedVertexValue = ((Edge) getResult).getAdjacentMatchedVertexValue();
    assertTrue(adjacentMatchedVertexValue instanceof Edge);
    assertEquals("Group", getResult.getGroup());
    assertEquals("Source", ((Edge) getResult).getSource());
    assertEquals("Source", ((Edge) getResult).getMatchedVertexValue());
    assertEquals("uk.gov.gchq.gaffer.data.element.Edge", getResult.getClassName());
    assertEquals(1, ((Set<Element>) actualApplyResult).size());
    assertEquals(DirectedType.DIRECTED, ((Edge) getResult).getDirectedType());
    assertEquals(MatchedVertex.SOURCE, ((Edge) getResult).getMatchedVertex());
    assertFalse(((Edge) getResult).isUndirected());
    assertTrue(getResult.getProperties().isEmpty());
    assertTrue(((Edge) getResult).isDirected());
    assertSame(edge, ((Edge) getResult).getDestination());
    assertSame(edge, adjacentMatchedVertexValue);
  }

  /**
   * Test {@link ElementAggregateOperator#apply(Iterable, Iterable)} with {@code Iterable}, {@code
   * Iterable}.
   *
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} second is {@link ArrayList#ArrayList()} first.
   * </ul>
   *
   * <p>Method under test: {@link ElementAggregateOperator#apply(Iterable, Iterable)}
   */
  @Test
  @DisplayName(
      "Test apply(Iterable, Iterable) with 'Iterable', 'Iterable'; then ArrayList() second is ArrayList() first")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable ElementAggregateOperator.apply(Iterable, Iterable)"})
  void testApplyWithIterableIterable_thenArrayListSecondIsArrayListFirst() {
    // Arrange
    ElementAggregateOperator elementAggregateOperator = new ElementAggregateOperator();

    ArrayList<Element> update = new ArrayList<>();
    update.add(
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build());
    update.add(
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build());

    // Act
    Iterable<Element> actualApplyResult = elementAggregateOperator.apply(update, new ArrayList<>());

    // Assert
    assertTrue(actualApplyResult instanceof Set);
    assertEquals(2, update.size());
    Element getResult = update.get(0);
    assertTrue(getResult instanceof Edge);
    Element getResult2 = update.get(1);
    assertTrue(getResult2 instanceof Edge);
    assertEquals(1, ((Set<Element>) actualApplyResult).size());
    assertEquals(getResult, getResult2);
  }

  /**
   * Test {@link ElementAggregateOperator#apply(Iterable, Iterable)} with {@code Iterable}, {@code
   * Iterable}.
   *
   * <ul>
   *   <li>Then return not iterator hasNext.
   * </ul>
   *
   * <p>Method under test: {@link ElementAggregateOperator#apply(Iterable, Iterable)}
   */
  @Test
  @DisplayName(
      "Test apply(Iterable, Iterable) with 'Iterable', 'Iterable'; then return not iterator hasNext")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable ElementAggregateOperator.apply(Iterable, Iterable)"})
  void testApplyWithIterableIterable_thenReturnNotIteratorHasNext() {
    // Arrange
    ElementAggregateOperator elementAggregateOperator = new ElementAggregateOperator();
    ArrayList<Element> update = new ArrayList<>();

    // Act
    Iterable<Element> actualApplyResult = elementAggregateOperator.apply(update, new ArrayList<>());
    Iterator<Element> actualIteratorResult = actualApplyResult.iterator();

    // Assert
    assertTrue(actualApplyResult instanceof Set);
    assertFalse(actualIteratorResult.hasNext());
    assertTrue(update.isEmpty());
    assertTrue(((Set<Element>) actualApplyResult).isEmpty());
  }

  /**
   * Test {@link ElementAggregateOperator#apply(Iterable, Iterable)} with {@code Iterable}, {@code
   * Iterable}.
   *
   * <ul>
   *   <li>Then return size is two.
   * </ul>
   *
   * <p>Method under test: {@link ElementAggregateOperator#apply(Iterable, Iterable)}
   */
  @Test
  @DisplayName(
      "Test apply(Iterable, Iterable) with 'Iterable', 'Iterable'; then return size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable ElementAggregateOperator.apply(Iterable, Iterable)"})
  void testApplyWithIterableIterable_thenReturnSizeIsTwo() {
    // Arrange
    ElementAggregateOperator elementAggregateOperator = new ElementAggregateOperator();

    ArrayList<Element> update = new ArrayList<>();
    update.add(
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("42")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build());
    update.add(
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build());

    // Act
    Iterable<Element> actualApplyResult = elementAggregateOperator.apply(update, new ArrayList<>());

    // Assert
    assertTrue(actualApplyResult instanceof Set);
    assertEquals(2, update.size());
    assertTrue(update.get(0) instanceof Edge);
    assertTrue(update.get(1) instanceof Edge);
    assertEquals(2, ((Set<Element>) actualApplyResult).size());
  }
}
