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

package uk.gov.gchq.gaffer.traffic.generator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.apache.datasketches.hll.HllSketch;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.Edge;
import uk.gov.gchq.gaffer.data.element.Edge.Builder;
import uk.gov.gchq.gaffer.data.element.Entity;
import uk.gov.gchq.gaffer.data.element.Properties;
import uk.gov.gchq.gaffer.data.element.id.EdgeId;
import uk.gov.gchq.gaffer.data.element.id.EdgeId.MatchedVertex;
import uk.gov.gchq.gaffer.types.FreqMap;

class RoadTrafficElementGeneratorDiffblueTest {
  /**
   * Test {@link RoadTrafficElementGenerator#createCardinalities(List)}.
   * <ul>
   *   <li>Then return second Vertex is {@code Dest}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RoadTrafficElementGenerator#createCardinalities(List)}
   */
  @Test
  @DisplayName("Test createCardinalities(List); then return second Vertex is 'Dest'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List RoadTrafficElementGenerator.createCardinalities(List)"})
  void testCreateCardinalities_thenReturnSecondVertexIsDest() {
    // Arrange
    RoadTrafficCsvElementGenerator roadTrafficCsvElementGenerator = new RoadTrafficCsvElementGenerator();

    ArrayList<Edge> edges = new ArrayList<>();
    Edge buildResult = (new Builder()).dest("Dest")
        .directed(true)
        .group("Group")
        .matchedVertex(MatchedVertex.SOURCE)
        .source("Source")
        .build();
    edges.add(buildResult);

    // Act
    List<Entity> actualCreateCardinalitiesResult = roadTrafficCsvElementGenerator.createCardinalities(edges);

    // Assert
    assertEquals(2, actualCreateCardinalitiesResult.size());
    Properties properties = actualCreateCardinalitiesResult.get(0).getProperties();
    assertEquals(3, properties.size());
    Object getResult = properties.get("hllp");
    assertTrue(getResult instanceof HllSketch);
    assertEquals("Dest", actualCreateCardinalitiesResult.get(1).getVertex());
    assertEquals(1.0d, ((HllSketch) getResult).getCompositeEstimate());
    assertEquals(1.0d, ((HllSketch) getResult).getEstimate());
    assertEquals(12, ((HllSketch) getResult).getCompactSerializationBytes());
    assertFalse(((HllSketch) getResult).isEmpty());
    assertTrue(properties.containsKey("count"));
    assertTrue(properties.containsKey("edgeGroup"));
  }

  /**
   * Test {@link RoadTrafficElementGenerator#createCardinalities(List)}.
   * <ul>
   *   <li>Then return second Vertex is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link RoadTrafficElementGenerator#createCardinalities(List)}
   */
  @Test
  @DisplayName("Test createCardinalities(List); then return second Vertex is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List RoadTrafficElementGenerator.createCardinalities(List)"})
  void testCreateCardinalities_thenReturnSecondVertexIsEmptyString() {
    // Arrange
    RoadTrafficCsvElementGenerator roadTrafficCsvElementGenerator = new RoadTrafficCsvElementGenerator();

    ArrayList<Edge> edges = new ArrayList<>();
    Edge buildResult = (new Builder()).dest("")
        .directed(true)
        .group("Group")
        .matchedVertex(MatchedVertex.SOURCE)
        .source("Source")
        .build();
    edges.add(buildResult);

    // Act
    List<Entity> actualCreateCardinalitiesResult = roadTrafficCsvElementGenerator.createCardinalities(edges);

    // Assert
    assertEquals(2, actualCreateCardinalitiesResult.size());
    Properties properties = actualCreateCardinalitiesResult.get(0).getProperties();
    assertEquals(3, properties.size());
    Object getResult = properties.get("hllp");
    assertTrue(getResult instanceof HllSketch);
    assertEquals("", actualCreateCardinalitiesResult.get(1).getVertex());
    assertEquals(0.0d, ((HllSketch) getResult).getCompositeEstimate());
    assertEquals(0.0d, ((HllSketch) getResult).getEstimate());
    assertEquals(8, ((HllSketch) getResult).getCompactSerializationBytes());
    assertTrue(properties.containsKey("count"));
    assertTrue(properties.containsKey("edgeGroup"));
    assertTrue(((HllSketch) getResult).isEmpty());
  }

  /**
   * Test {@link RoadTrafficElementGenerator#createCardinalities(List)}.
   * <ul>
   *   <li>Then return second Vertex is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RoadTrafficElementGenerator#createCardinalities(List)}
   */
  @Test
  @DisplayName("Test createCardinalities(List); then return second Vertex is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List RoadTrafficElementGenerator.createCardinalities(List)"})
  void testCreateCardinalities_thenReturnSecondVertexIsNull() {
    // Arrange
    RoadTrafficCsvElementGenerator roadTrafficCsvElementGenerator = new RoadTrafficCsvElementGenerator();

    ArrayList<Edge> edges = new ArrayList<>();
    Edge buildResult = (new Builder()).dest(null)
        .directed(true)
        .group("Group")
        .matchedVertex(MatchedVertex.SOURCE)
        .source("Source")
        .build();
    edges.add(buildResult);

    // Act
    List<Entity> actualCreateCardinalitiesResult = roadTrafficCsvElementGenerator.createCardinalities(edges);

    // Assert
    assertEquals(2, actualCreateCardinalitiesResult.size());
    Properties properties = actualCreateCardinalitiesResult.get(0).getProperties();
    assertEquals(3, properties.size());
    Object getResult = properties.get("hllp");
    assertTrue(getResult instanceof HllSketch);
    assertNull(actualCreateCardinalitiesResult.get(1).getVertex());
    assertEquals(0.0d, ((HllSketch) getResult).getCompositeEstimate());
    assertEquals(0.0d, ((HllSketch) getResult).getEstimate());
    assertEquals(8, ((HllSketch) getResult).getCompactSerializationBytes());
    assertTrue(properties.containsKey("count"));
    assertTrue(properties.containsKey("edgeGroup"));
    assertTrue(((HllSketch) getResult).isEmpty());
  }

  /**
   * Test {@link RoadTrafficElementGenerator#createCardinalities(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link RoadTrafficElementGenerator#createCardinalities(List)}
   */
  @Test
  @DisplayName("Test createCardinalities(List); when ArrayList(); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List RoadTrafficElementGenerator.createCardinalities(List)"})
  void testCreateCardinalities_whenArrayList_thenReturnEmpty() {
    // Arrange
    RoadTrafficCsvElementGenerator roadTrafficCsvElementGenerator = new RoadTrafficCsvElementGenerator();

    // Act and Assert
    assertTrue(roadTrafficCsvElementGenerator.createCardinalities(new ArrayList<>()).isEmpty());
  }

  /**
   * Test {@link RoadTrafficElementGenerator#createCardinality(Object, Object, Edge)}.
   * <ul>
   *   <li>Then return Properties {@code hllp} CompositeEstimate is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link RoadTrafficElementGenerator#createCardinality(Object, Object, Edge)}
   */
  @Test
  @DisplayName("Test createCardinality(Object, Object, Edge); then return Properties 'hllp' CompositeEstimate is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Entity RoadTrafficElementGenerator.createCardinality(Object, Object, Edge)"})
  void testCreateCardinality_thenReturnPropertiesHllpCompositeEstimateIsOne() {
    // Arrange
    RoadTrafficCsvElementGenerator roadTrafficCsvElementGenerator = new RoadTrafficCsvElementGenerator();

    // Act and Assert
    Properties properties = roadTrafficCsvElementGenerator.createCardinality("Source", "Destination", new Edge("Group"))
        .getProperties();
    assertEquals(3, properties.size());
    Object getResult = properties.get("hllp");
    assertTrue(getResult instanceof HllSketch);
    assertEquals(1.0d, ((HllSketch) getResult).getCompositeEstimate());
    assertEquals(1.0d, ((HllSketch) getResult).getEstimate());
    assertEquals(12, ((HllSketch) getResult).getCompactSerializationBytes());
    assertFalse(((HllSketch) getResult).isEmpty());
    assertTrue(properties.containsKey("count"));
    assertTrue(properties.containsKey("edgeGroup"));
  }

  /**
   * Test {@link RoadTrafficElementGenerator#createCardinality(Object, Object, Edge)}.
   * <ul>
   *   <li>When empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link RoadTrafficElementGenerator#createCardinality(Object, Object, Edge)}
   */
  @Test
  @DisplayName("Test createCardinality(Object, Object, Edge); when empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Entity RoadTrafficElementGenerator.createCardinality(Object, Object, Edge)"})
  void testCreateCardinality_whenEmptyString() {
    // Arrange
    RoadTrafficCsvElementGenerator roadTrafficCsvElementGenerator = new RoadTrafficCsvElementGenerator();

    // Act and Assert
    Properties properties = roadTrafficCsvElementGenerator.createCardinality("Source", "", new Edge("Group"))
        .getProperties();
    assertEquals(3, properties.size());
    Object getResult = properties.get("hllp");
    assertTrue(getResult instanceof HllSketch);
    assertEquals(0.0d, ((HllSketch) getResult).getCompositeEstimate());
    assertEquals(0.0d, ((HllSketch) getResult).getEstimate());
    assertEquals(8, ((HllSketch) getResult).getCompactSerializationBytes());
    assertTrue(properties.containsKey("count"));
    assertTrue(properties.containsKey("edgeGroup"));
    assertTrue(((HllSketch) getResult).isEmpty());
  }

  /**
   * Test {@link RoadTrafficElementGenerator#createCardinality(Object, Object, Edge)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return Properties {@code hllp} CompositeEstimate is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link RoadTrafficElementGenerator#createCardinality(Object, Object, Edge)}
   */
  @Test
  @DisplayName("Test createCardinality(Object, Object, Edge); when 'null'; then return Properties 'hllp' CompositeEstimate is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Entity RoadTrafficElementGenerator.createCardinality(Object, Object, Edge)"})
  void testCreateCardinality_whenNull_thenReturnPropertiesHllpCompositeEstimateIsZero() {
    // Arrange
    RoadTrafficCsvElementGenerator roadTrafficCsvElementGenerator = new RoadTrafficCsvElementGenerator();

    // Act and Assert
    Properties properties = roadTrafficCsvElementGenerator.createCardinality("Source", null, new Edge("Group"))
        .getProperties();
    assertEquals(3, properties.size());
    Object getResult = properties.get("hllp");
    assertTrue(getResult instanceof HllSketch);
    assertEquals(0.0d, ((HllSketch) getResult).getCompositeEstimate());
    assertEquals(0.0d, ((HllSketch) getResult).getEstimate());
    assertEquals(8, ((HllSketch) getResult).getCompactSerializationBytes());
    assertTrue(properties.containsKey("count"));
    assertTrue(properties.containsKey("edgeGroup"));
    assertTrue(((HllSketch) getResult).isEmpty());
  }

  /**
   * Test {@link RoadTrafficElementGenerator#getDate(String, String)}.
   * <p>
   * Method under test: {@link RoadTrafficElementGenerator#getDate(String, String)}
   */
  @Test
  @DisplayName("Test getDate(String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Date RoadTrafficElementGenerator.getDate(String, String)"})
  void testGetDate() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new RoadTrafficCsvElementGenerator()).getDate("3", "Hour"));
  }

  /**
   * Test {@link RoadTrafficElementGenerator#getTotalCount(FreqMap)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>When {@link FreqMap#FreqMap()} {@code foo} is one.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link RoadTrafficElementGenerator#getTotalCount(FreqMap)}
   */
  @Test
  @DisplayName("Test getTotalCount(FreqMap); given 'foo'; when FreqMap() 'foo' is one; then return one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long RoadTrafficElementGenerator.getTotalCount(FreqMap)"})
  void testGetTotalCount_givenFoo_whenFreqMapFooIsOne_thenReturnOne() {
    // Arrange
    RoadTrafficCsvElementGenerator roadTrafficCsvElementGenerator = new RoadTrafficCsvElementGenerator();

    FreqMap freqmap = new FreqMap();
    freqmap.put("foo", 1L);

    // Act and Assert
    assertEquals(1L, roadTrafficCsvElementGenerator.getTotalCount(freqmap));
  }

  /**
   * Test {@link RoadTrafficElementGenerator#getTotalCount(FreqMap)}.
   * <ul>
   *   <li>When {@link FreqMap#FreqMap()}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link RoadTrafficElementGenerator#getTotalCount(FreqMap)}
   */
  @Test
  @DisplayName("Test getTotalCount(FreqMap); when FreqMap(); then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long RoadTrafficElementGenerator.getTotalCount(FreqMap)"})
  void testGetTotalCount_whenFreqMap_thenReturnZero() {
    // Arrange
    RoadTrafficCsvElementGenerator roadTrafficCsvElementGenerator = new RoadTrafficCsvElementGenerator();

    // Act and Assert
    assertEquals(0L, roadTrafficCsvElementGenerator.getTotalCount(new FreqMap()));
  }
}
