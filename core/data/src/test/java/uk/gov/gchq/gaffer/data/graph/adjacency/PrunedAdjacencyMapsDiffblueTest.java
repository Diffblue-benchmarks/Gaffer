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

package uk.gov.gchq.gaffer.data.graph.adjacency;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.Edge;
import uk.gov.gchq.gaffer.data.element.Edge.Builder;
import uk.gov.gchq.gaffer.data.element.id.EdgeId;
import uk.gov.gchq.gaffer.data.element.id.EdgeId.MatchedVertex;

class PrunedAdjacencyMapsDiffblueTest {
  /**
   * Test {@link PrunedAdjacencyMaps#add(AdjacencyMap)}.
   * <ul>
   *   <li>Given {@link PrunedAdjacencyMaps} (default constructor) add {@link AdjacencyMap} (default constructor).</li>
   *   <li>Then {@link PrunedAdjacencyMaps} (default constructor) size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link PrunedAdjacencyMaps#add(AdjacencyMap)}
   */
  @Test
  @DisplayName("Test add(AdjacencyMap); given PrunedAdjacencyMaps (default constructor) add AdjacencyMap (default constructor); then PrunedAdjacencyMaps (default constructor) size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PrunedAdjacencyMaps.add(AdjacencyMap)"})
  void testAdd_givenPrunedAdjacencyMapsAddAdjacencyMap_thenPrunedAdjacencyMapsSizeIsTwo() {
    // Arrange
    PrunedAdjacencyMaps prunedAdjacencyMaps = new PrunedAdjacencyMaps();
    prunedAdjacencyMaps.add(new AdjacencyMap());

    // Act
    prunedAdjacencyMaps.add(new AdjacencyMap());

    // Assert
    assertEquals(2, prunedAdjacencyMaps.size());
  }

  /**
   * Test {@link PrunedAdjacencyMaps#add(AdjacencyMap)}.
   * <ul>
   *   <li>Given {@link PrunedAdjacencyMaps} (default constructor).</li>
   *   <li>Then {@link PrunedAdjacencyMaps} (default constructor) size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PrunedAdjacencyMaps#add(AdjacencyMap)}
   */
  @Test
  @DisplayName("Test add(AdjacencyMap); given PrunedAdjacencyMaps (default constructor); then PrunedAdjacencyMaps (default constructor) size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PrunedAdjacencyMaps.add(AdjacencyMap)"})
  void testAdd_givenPrunedAdjacencyMaps_thenPrunedAdjacencyMapsSizeIsOne() {
    // Arrange
    PrunedAdjacencyMaps prunedAdjacencyMaps = new PrunedAdjacencyMaps();

    // Act
    prunedAdjacencyMaps.add(new AdjacencyMap());

    // Assert
    assertEquals(1, prunedAdjacencyMaps.size());
  }

  /**
   * Test {@link PrunedAdjacencyMaps#add(AdjacencyMap)}.
   * <ul>
   *   <li>Then {@link PrunedAdjacencyMaps} (default constructor) size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link PrunedAdjacencyMaps#add(AdjacencyMap)}
   */
  @Test
  @DisplayName("Test add(AdjacencyMap); then PrunedAdjacencyMaps (default constructor) size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PrunedAdjacencyMaps.add(AdjacencyMap)"})
  void testAdd_thenPrunedAdjacencyMapsSizeIsTwo() {
    // Arrange
    AdjacencyMap adjacencyMap = new AdjacencyMap();
    Edge edge = (new Builder()).dest("Dest")
        .directed(true)
        .group("Group")
        .matchedVertex(MatchedVertex.SOURCE)
        .source("Source")
        .build();
    adjacencyMap.putEdge("Source", "Destination", edge);

    PrunedAdjacencyMaps prunedAdjacencyMaps = new PrunedAdjacencyMaps();
    prunedAdjacencyMaps.add(adjacencyMap);

    // Act
    prunedAdjacencyMaps.add(new AdjacencyMap());

    // Assert
    assertEquals(2, prunedAdjacencyMaps.size());
  }

  /**
   * Test {@link PrunedAdjacencyMaps#asList()}.
   * <p>
   * Method under test: {@link PrunedAdjacencyMaps#asList()}
   */
  @Test
  @DisplayName("Test asList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.List PrunedAdjacencyMaps.asList()"})
  void testAsList() {
    // Arrange, Act and Assert
    assertTrue((new PrunedAdjacencyMaps()).asList().isEmpty());
  }

  /**
   * Test new {@link PrunedAdjacencyMaps} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link PrunedAdjacencyMaps}
   */
  @Test
  @DisplayName("Test new PrunedAdjacencyMaps (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PrunedAdjacencyMaps.<init>()"})
  void testNewPrunedAdjacencyMaps() {
    // Arrange, Act and Assert
    assertEquals(0, (new PrunedAdjacencyMaps()).size());
  }
}
