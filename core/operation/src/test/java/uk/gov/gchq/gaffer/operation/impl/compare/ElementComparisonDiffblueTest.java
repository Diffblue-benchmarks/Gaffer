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

package uk.gov.gchq.gaffer.operation.impl.compare;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
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
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl;

class ElementComparisonDiffblueTest {
  /**
   * Test {@link ElementComparison#getCombinedComparator()}.
   *
   * <p>Method under test: {@link ElementComparison#getCombinedComparator()}
   */
  @Test
  @DisplayName("Test getCombinedComparator()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Comparator ElementComparison.getCombinedComparator()"})
  void testGetCombinedComparator() {
    // Arrange
    Comparator<Element> comparator = mock(Comparator.class);
    when(comparator.compare(Mockito.<Element>any(), Mockito.<Element>any())).thenReturn(1);

    ArrayList<Comparator<Element>> comparators = new ArrayList<>();
    comparators.add(comparator);
    comparators.add(null);

    Max max = new Max();
    max.setComparators(comparators);

    // Act
    Comparator<Element> actualCombinedComparator = max.getCombinedComparator();
    Edge edge =
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build();
    int actualCompareResult =
        actualCombinedComparator.compare(
            edge,
            new Builder()
                .dest("Dest")
                .directed(true)
                .group("Group")
                .matchedVertex(MatchedVertex.SOURCE)
                .source("Source")
                .build());

    // Assert
    verify(comparator).compare(isA(Element.class), isA(Element.class));
    assertTrue(max.getOutputTypeReference() instanceof TypeReferenceImpl.Element);
    assertEquals("Dest", edge.getDestination());
    assertEquals("Dest", edge.getAdjacentMatchedVertexValue());
    assertEquals("Group", edge.getGroup());
    assertEquals("Source", edge.getSource());
    assertEquals("Source", edge.getMatchedVertexValue());
    assertEquals("uk.gov.gchq.gaffer.data.element.Edge", edge.getClassName());
    assertNull(max.getInput());
    assertNull(max.getOptions());
    assertEquals(1, actualCompareResult);
    assertEquals(DirectedType.DIRECTED, edge.getDirectedType());
    assertEquals(MatchedVertex.SOURCE, edge.getMatchedVertex());
    assertFalse(edge.isUndirected());
    assertTrue(edge.getProperties().isEmpty());
    assertTrue(max.getComparableGroupPropertyPairs().isEmpty());
    assertTrue(edge.isDirected());
    Class<Element> expectedOutputClass = Element.class;
    assertEquals(expectedOutputClass, max.getOutputClass());
    assertSame(comparators, max.getComparators());
  }

  /**
   * Test {@link ElementComparison#getCombinedComparator()}.
   *
   * <ul>
   *   <li>Given {@link Max} (default constructor) Comparators is {@link ArrayList#ArrayList()}.
   *   <li>Then {@link Max} (default constructor) Comparators Empty.
   * </ul>
   *
   * <p>Method under test: {@link ElementComparison#getCombinedComparator()}
   */
  @Test
  @DisplayName(
      "Test getCombinedComparator(); given Max (default constructor) Comparators is ArrayList(); then Max (default constructor) Comparators Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Comparator ElementComparison.getCombinedComparator()"})
  void testGetCombinedComparator_givenMaxComparatorsIsArrayList_thenMaxComparatorsEmpty() {
    // Arrange
    Max max = new Max();
    max.setComparators(new ArrayList<>());

    // Act
    Comparator<Element> actualCombinedComparator = max.getCombinedComparator();

    // Assert
    assertTrue(max.getOutputTypeReference() instanceof TypeReferenceImpl.Element);
    assertNull(max.getInput());
    assertNull(actualCombinedComparator);
    assertNull(max.getOptions());
    assertTrue(max.getComparators().isEmpty());
    assertTrue(max.getComparableGroupPropertyPairs().isEmpty());
    Class<Element> expectedOutputClass = Element.class;
    assertEquals(expectedOutputClass, max.getOutputClass());
  }

  /**
   * Test {@link ElementComparison#getCombinedComparator()}.
   *
   * <ul>
   *   <li>Given {@link Max} (default constructor).
   *   <li>Then {@link Max} (default constructor) Comparators is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ElementComparison#getCombinedComparator()}
   */
  @Test
  @DisplayName(
      "Test getCombinedComparator(); given Max (default constructor); then Max (default constructor) Comparators is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Comparator ElementComparison.getCombinedComparator()"})
  void testGetCombinedComparator_givenMax_thenMaxComparatorsIsNull() {
    // Arrange
    Max max = new Max();

    // Act
    Comparator<Element> actualCombinedComparator = max.getCombinedComparator();

    // Assert
    assertTrue(max.getOutputTypeReference() instanceof TypeReferenceImpl.Element);
    assertNull(max.getInput());
    assertNull(actualCombinedComparator);
    assertNull(max.getComparators());
    assertNull(max.getOptions());
    assertTrue(max.getComparableGroupPropertyPairs().isEmpty());
    Class<Element> expectedOutputClass = Element.class;
    assertEquals(expectedOutputClass, max.getOutputClass());
  }

  /**
   * Test {@link ElementComparison#getCombinedComparator()}.
   *
   * <ul>
   *   <li>Then calls {@link Comparator#thenComparing(Comparator)}.
   * </ul>
   *
   * <p>Method under test: {@link ElementComparison#getCombinedComparator()}
   */
  @Test
  @DisplayName("Test getCombinedComparator(); then calls thenComparing(Comparator)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Comparator ElementComparison.getCombinedComparator()"})
  void testGetCombinedComparator_thenCallsThenComparing() {
    // Arrange
    Comparator<Element> comparator = mock(Comparator.class);
    when(comparator.compare(Mockito.<Element>any(), Mockito.<Element>any())).thenReturn(1);

    Comparator<Element> comparator2 = mock(Comparator.class);
    when(comparator2.thenComparing(Mockito.<Comparator<Element>>any())).thenReturn(comparator);

    ArrayList<Comparator<Element>> comparators = new ArrayList<>();
    comparators.add(comparator2);
    comparators.add(mock(Comparator.class));

    Max max = new Max();
    max.setComparators(comparators);

    // Act
    Comparator<Element> actualCombinedComparator = max.getCombinedComparator();
    Edge edge =
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build();
    int actualCompareResult =
        actualCombinedComparator.compare(
            edge,
            new Builder()
                .dest("Dest")
                .directed(true)
                .group("Group")
                .matchedVertex(MatchedVertex.SOURCE)
                .source("Source")
                .build());

    // Assert
    verify(comparator).compare(isA(Element.class), isA(Element.class));
    verify(comparator2).thenComparing(isA(Comparator.class));
    assertTrue(max.getOutputTypeReference() instanceof TypeReferenceImpl.Element);
    assertEquals("Dest", edge.getDestination());
    assertEquals("Dest", edge.getAdjacentMatchedVertexValue());
    assertEquals("Group", edge.getGroup());
    assertEquals("Source", edge.getSource());
    assertEquals("Source", edge.getMatchedVertexValue());
    assertEquals("uk.gov.gchq.gaffer.data.element.Edge", edge.getClassName());
    assertNull(max.getInput());
    assertNull(max.getOptions());
    assertEquals(1, actualCompareResult);
    assertEquals(DirectedType.DIRECTED, edge.getDirectedType());
    assertEquals(MatchedVertex.SOURCE, edge.getMatchedVertex());
    assertFalse(edge.isUndirected());
    assertTrue(edge.getProperties().isEmpty());
    assertTrue(max.getComparableGroupPropertyPairs().isEmpty());
    assertTrue(edge.isDirected());
    Class<Element> expectedOutputClass = Element.class;
    assertEquals(expectedOutputClass, max.getOutputClass());
    assertSame(comparators, max.getComparators());
  }

  /**
   * Test {@link ElementComparison#getCombinedComparator()}.
   *
   * <ul>
   *   <li>Then {@link Max} (default constructor) Comparators size is one.
   * </ul>
   *
   * <p>Method under test: {@link ElementComparison#getCombinedComparator()}
   */
  @Test
  @DisplayName(
      "Test getCombinedComparator(); then Max (default constructor) Comparators size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Comparator ElementComparison.getCombinedComparator()"})
  void testGetCombinedComparator_thenMaxComparatorsSizeIsOne() {
    // Arrange
    ArrayList<Comparator<Element>> comparators = new ArrayList<>();
    comparators.add(mock(Comparator.class));

    Max max = new Max();
    max.setComparators(comparators);

    // Act
    max.getCombinedComparator();

    // Assert that nothing has changed
    assertTrue(max.getOutputTypeReference() instanceof TypeReferenceImpl.Element);
    List<Comparator<Element>> comparators2 = max.getComparators();
    assertEquals(1, comparators2.size());
    assertTrue(max.getComparableGroupPropertyPairs().isEmpty());
    Class<Element> expectedOutputClass = Element.class;
    assertEquals(expectedOutputClass, max.getOutputClass());
    assertSame(comparators, comparators2);
  }

  /**
   * Test {@link ElementComparison#getComparableGroupPropertyPairs()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link Comparator}.
   * </ul>
   *
   * <p>Method under test: {@link ElementComparison#getComparableGroupPropertyPairs()}
   */
  @Test
  @DisplayName("Test getComparableGroupPropertyPairs(); given ArrayList() add Comparator")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Set ElementComparison.getComparableGroupPropertyPairs()"})
  void testGetComparableGroupPropertyPairs_givenArrayListAddComparator() {
    // Arrange
    ArrayList<Comparator<Element>> comparators = new ArrayList<>();
    comparators.add(mock(Comparator.class));

    Max max = new Max();
    max.setComparators(comparators);

    // Act and Assert
    assertTrue(max.getComparableGroupPropertyPairs().isEmpty());
  }

  /**
   * Test {@link ElementComparison#getComparableGroupPropertyPairs()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link ElementPropertyComparator} (default
   *       constructor).
   * </ul>
   *
   * <p>Method under test: {@link ElementComparison#getComparableGroupPropertyPairs()}
   */
  @Test
  @DisplayName(
      "Test getComparableGroupPropertyPairs(); given ArrayList() add ElementPropertyComparator (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Set ElementComparison.getComparableGroupPropertyPairs()"})
  void testGetComparableGroupPropertyPairs_givenArrayListAddElementPropertyComparator() {
    // Arrange
    ArrayList<Comparator<Element>> comparators = new ArrayList<>();
    comparators.add(new ElementPropertyComparator());

    Max max = new Max();
    max.setComparators(comparators);

    // Act and Assert
    assertTrue(max.getComparableGroupPropertyPairs().isEmpty());
  }

  /**
   * Test {@link ElementComparison#getComparableGroupPropertyPairs()}.
   *
   * <ul>
   *   <li>Given {@link Max} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link ElementComparison#getComparableGroupPropertyPairs()}
   */
  @Test
  @DisplayName("Test getComparableGroupPropertyPairs(); given Max (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Set ElementComparison.getComparableGroupPropertyPairs()"})
  void testGetComparableGroupPropertyPairs_givenMax() {
    // Arrange, Act and Assert
    assertTrue(new Max().getComparableGroupPropertyPairs().isEmpty());
  }

  /**
   * Test {@link ElementComparison#getComparableGroupPropertyPairs()}.
   *
   * <ul>
   *   <li>Given {@link Max} (default constructor) Comparators is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link ElementComparison#getComparableGroupPropertyPairs()}
   */
  @Test
  @DisplayName(
      "Test getComparableGroupPropertyPairs(); given Max (default constructor) Comparators is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Set ElementComparison.getComparableGroupPropertyPairs()"})
  void testGetComparableGroupPropertyPairs_givenMaxComparatorsIsArrayList() {
    // Arrange
    Max max = new Max();
    max.setComparators(new ArrayList<>());

    // Act and Assert
    assertTrue(max.getComparableGroupPropertyPairs().isEmpty());
  }
}
