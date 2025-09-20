package uk.gov.gchq.gaffer.traffic.generator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
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
   *
   * <ul>
   *   <li>Then return second Vertex is {@code Dest}.
   * </ul>
   *
   * <p>Method under test: {@link RoadTrafficElementGenerator#createCardinalities(List)}
   */
  @Test
  @DisplayName("Test createCardinalities(List); then return second Vertex is 'Dest'")
  @Tag("MaintainedByDiffblue")
  void testCreateCardinalities_thenReturnSecondVertexIsDest() {
    // Arrange
    RoadTrafficCsvElementGenerator roadTrafficCsvElementGenerator =
        new RoadTrafficCsvElementGenerator();

    ArrayList<Edge> edges = new ArrayList<>();
    edges.add(
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build());

    // Act
    List<Entity> actualCreateCardinalitiesResult =
        roadTrafficCsvElementGenerator.createCardinalities(edges);

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
   *
   * <ul>
   *   <li>Then return second Vertex is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link RoadTrafficElementGenerator#createCardinalities(List)}
   */
  @Test
  @DisplayName("Test createCardinalities(List); then return second Vertex is 'null'")
  @Tag("MaintainedByDiffblue")
  void testCreateCardinalities_thenReturnSecondVertexIsNull() {
    // Arrange
    RoadTrafficCsvElementGenerator roadTrafficCsvElementGenerator =
        new RoadTrafficCsvElementGenerator();

    ArrayList<Edge> edges = new ArrayList<>();
    edges.add(
        new Builder()
            .dest(null)
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build());

    // Act
    List<Entity> actualCreateCardinalitiesResult =
        roadTrafficCsvElementGenerator.createCardinalities(edges);

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
   *
   * <ul>
   *   <li>Then return size is four.
   * </ul>
   *
   * <p>Method under test: {@link RoadTrafficElementGenerator#createCardinalities(List)}
   */
  @Test
  @DisplayName("Test createCardinalities(List); then return size is four")
  @Tag("MaintainedByDiffblue")
  void testCreateCardinalities_thenReturnSizeIsFour() {
    // Arrange
    RoadTrafficCsvElementGenerator roadTrafficCsvElementGenerator =
        new RoadTrafficCsvElementGenerator();

    ArrayList<Edge> edges = new ArrayList<>();
    edges.add(
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build());
    edges.add(
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build());

    // Act
    List<Entity> actualCreateCardinalitiesResult =
        roadTrafficCsvElementGenerator.createCardinalities(edges);

    // Assert
    assertEquals(4, actualCreateCardinalitiesResult.size());
    Entity getResult = actualCreateCardinalitiesResult.get(2);
    assertEquals("Cardinality", getResult.getGroup());
    Entity getResult2 = actualCreateCardinalitiesResult.get(3);
    assertEquals("Cardinality", getResult2.getGroup());
    assertEquals("Dest", getResult2.getVertex());
    assertEquals("Source", getResult.getVertex());
    assertEquals("uk.gov.gchq.gaffer.data.element.Entity", getResult.getClassName());
    assertEquals("uk.gov.gchq.gaffer.data.element.Entity", getResult2.getClassName());
    Properties properties = getResult.getProperties();
    assertEquals(3, properties.size());
    Properties properties2 = getResult2.getProperties();
    assertEquals(3, properties2.size());
    assertTrue(properties.containsKey("count"));
    assertTrue(properties.containsKey("edgeGroup"));
    assertTrue(properties.containsKey("hllp"));
    assertTrue(properties2.containsKey("count"));
    assertTrue(properties2.containsKey("edgeGroup"));
    assertTrue(properties2.containsKey("hllp"));
  }

  /**
   * Test {@link RoadTrafficElementGenerator#createCardinalities(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link RoadTrafficElementGenerator#createCardinalities(List)}
   */
  @Test
  @DisplayName("Test createCardinalities(List); when ArrayList(); then return Empty")
  @Tag("MaintainedByDiffblue")
  void testCreateCardinalities_whenArrayList_thenReturnEmpty() {
    // Arrange
    RoadTrafficCsvElementGenerator roadTrafficCsvElementGenerator =
        new RoadTrafficCsvElementGenerator();

    // Act and Assert
    assertTrue(roadTrafficCsvElementGenerator.createCardinalities(new ArrayList<>()).isEmpty());
  }

  /**
   * Test {@link RoadTrafficElementGenerator#createCardinality(Object, Object, Edge)}.
   *
   * <ul>
   *   <li>Then return Properties {@code hllp} CompositeEstimate is one.
   * </ul>
   *
   * <p>Method under test: {@link RoadTrafficElementGenerator#createCardinality(Object, Object,
   * Edge)}
   */
  @Test
  @DisplayName(
      "Test createCardinality(Object, Object, Edge); then return Properties 'hllp' CompositeEstimate is one")
  @Tag("MaintainedByDiffblue")
  void testCreateCardinality_thenReturnPropertiesHllpCompositeEstimateIsOne() {
    // Arrange
    RoadTrafficCsvElementGenerator roadTrafficCsvElementGenerator =
        new RoadTrafficCsvElementGenerator();

    // Act and Assert
    Properties properties =
        roadTrafficCsvElementGenerator
            .createCardinality("Source", "Destination", new Edge("Group"))
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
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link RoadTrafficElementGenerator#createCardinality(Object, Object,
   * Edge)}
   */
  @Test
  @DisplayName("Test createCardinality(Object, Object, Edge); when empty string")
  @Tag("MaintainedByDiffblue")
  void testCreateCardinality_whenEmptyString() {
    // Arrange
    RoadTrafficCsvElementGenerator roadTrafficCsvElementGenerator =
        new RoadTrafficCsvElementGenerator();

    // Act and Assert
    Properties properties =
        roadTrafficCsvElementGenerator
            .createCardinality("Source", "", new Edge("Group"))
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
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return Properties {@code hllp} CompositeEstimate is zero.
   * </ul>
   *
   * <p>Method under test: {@link RoadTrafficElementGenerator#createCardinality(Object, Object,
   * Edge)}
   */
  @Test
  @DisplayName(
      "Test createCardinality(Object, Object, Edge); when 'null'; then return Properties 'hllp' CompositeEstimate is zero")
  @Tag("MaintainedByDiffblue")
  void testCreateCardinality_whenNull_thenReturnPropertiesHllpCompositeEstimateIsZero() {
    // Arrange
    RoadTrafficCsvElementGenerator roadTrafficCsvElementGenerator =
        new RoadTrafficCsvElementGenerator();

    // Act and Assert
    Properties properties =
        roadTrafficCsvElementGenerator
            .createCardinality("Source", null, new Edge("Group"))
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
   *
   * <p>Method under test: {@link RoadTrafficElementGenerator#getDate(String, String)}
   */
  @Test
  @DisplayName("Test getDate(String, String)")
  @Tag("MaintainedByDiffblue")
  void testGetDate() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new RoadTrafficCsvElementGenerator().getDate("3", "Hour"));
  }

  /**
   * Test {@link RoadTrafficElementGenerator#getTotalCount(FreqMap)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>When {@link FreqMap#FreqMap()} {@code foo} is one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link RoadTrafficElementGenerator#getTotalCount(FreqMap)}
   */
  @Test
  @DisplayName(
      "Test getTotalCount(FreqMap); given 'foo'; when FreqMap() 'foo' is one; then return one")
  @Tag("MaintainedByDiffblue")
  void testGetTotalCount_givenFoo_whenFreqMapFooIsOne_thenReturnOne() {
    // Arrange
    RoadTrafficCsvElementGenerator roadTrafficCsvElementGenerator =
        new RoadTrafficCsvElementGenerator();

    FreqMap freqmap = new FreqMap();
    freqmap.put("foo", 1L);

    // Act and Assert
    assertEquals(1L, roadTrafficCsvElementGenerator.getTotalCount(freqmap));
  }

  /**
   * Test {@link RoadTrafficElementGenerator#getTotalCount(FreqMap)}.
   *
   * <ul>
   *   <li>When {@link FreqMap#FreqMap()}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link RoadTrafficElementGenerator#getTotalCount(FreqMap)}
   */
  @Test
  @DisplayName("Test getTotalCount(FreqMap); when FreqMap(); then return zero")
  @Tag("MaintainedByDiffblue")
  void testGetTotalCount_whenFreqMap_thenReturnZero() {
    // Arrange
    RoadTrafficCsvElementGenerator roadTrafficCsvElementGenerator =
        new RoadTrafficCsvElementGenerator();

    // Act and Assert
    assertEquals(0L, roadTrafficCsvElementGenerator.getTotalCount(new FreqMap()));
  }
}
