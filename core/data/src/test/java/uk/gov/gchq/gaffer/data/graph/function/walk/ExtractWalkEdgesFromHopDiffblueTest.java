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

package uk.gov.gchq.gaffer.data.graph.function.walk;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.Edge;
import uk.gov.gchq.gaffer.data.element.ElementValueLoader;
import uk.gov.gchq.gaffer.data.element.LazyEdge;
import uk.gov.gchq.gaffer.data.graph.Walk;

class ExtractWalkEdgesFromHopDiffblueTest {
  /**
   * Method under test: {@link ExtractWalkEdgesFromHop#apply(Walk)}
   */
  @Test
  void testApply() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new ExtractWalkEdgesFromHop(1)).apply(null));
  }

  /**
   * Method under test: {@link ExtractWalkEdgesFromHop#apply(Walk)}
   */
  @Test
  void testApply2() {
    // Arrange
    ExtractWalkEdgesFromHop extractWalkEdgesFromHop = new ExtractWalkEdgesFromHop(1);

    ArrayList<Set<Edge>> edges = new ArrayList<>();
    edges.add(new HashSet<>());
    HashSet<Edge> edgeSet = new HashSet<>();
    edges.add(edgeSet);

    // Act
    Set<Edge> actualApplyResult = extractWalkEdgesFromHop.apply(new Walk(edges, new ArrayList<>()));

    // Assert
    assertTrue(actualApplyResult.isEmpty());
    assertSame(edgeSet, actualApplyResult);
  }

  /**
   * Method under test: {@link ExtractWalkEdgesFromHop#apply(Walk)}
   */
  @Test
  void testApply3() {
    // Arrange
    ExtractWalkEdgesFromHop extractWalkEdgesFromHop = new ExtractWalkEdgesFromHop(1);

    HashSet<Edge> edgeSet = new HashSet<>();
    edgeSet.add(new LazyEdge(new Edge("Group"), mock(ElementValueLoader.class)));

    ArrayList<Set<Edge>> edges = new ArrayList<>();
    edges.add(edgeSet);
    HashSet<Edge> edgeSet2 = new HashSet<>();
    edges.add(edgeSet2);

    // Act
    Set<Edge> actualApplyResult = extractWalkEdgesFromHop.apply(new Walk(edges, new ArrayList<>()));

    // Assert
    assertTrue(actualApplyResult.isEmpty());
    assertSame(edgeSet2, actualApplyResult);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ExtractWalkEdgesFromHop#ExtractWalkEdgesFromHop()}
   *   <li>{@link ExtractWalkEdgesFromHop#setHop(int)}
   *   <li>{@link ExtractWalkEdgesFromHop#getHop()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    ExtractWalkEdgesFromHop actualExtractWalkEdgesFromHop = new ExtractWalkEdgesFromHop();
    actualExtractWalkEdgesFromHop.setHop(1);

    // Assert that nothing has changed
    assertEquals(1, actualExtractWalkEdgesFromHop.getHop());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ExtractWalkEdgesFromHop#ExtractWalkEdgesFromHop(int)}
   *   <li>{@link ExtractWalkEdgesFromHop#setHop(int)}
   *   <li>{@link ExtractWalkEdgesFromHop#getHop()}
   * </ul>
   */
  @Test
  void testGettersAndSetters2() {
    // Arrange and Act
    ExtractWalkEdgesFromHop actualExtractWalkEdgesFromHop = new ExtractWalkEdgesFromHop(1);
    actualExtractWalkEdgesFromHop.setHop(1);

    // Assert that nothing has changed
    assertEquals(1, actualExtractWalkEdgesFromHop.getHop());
  }
}
