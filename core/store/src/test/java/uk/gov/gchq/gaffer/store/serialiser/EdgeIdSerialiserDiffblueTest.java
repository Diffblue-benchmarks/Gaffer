package uk.gov.gchq.gaffer.store.serialiser;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.Edge;
import uk.gov.gchq.gaffer.data.element.Edge.Builder;
import uk.gov.gchq.gaffer.data.element.id.DirectedType;
import uk.gov.gchq.gaffer.data.element.id.EdgeId;
import uk.gov.gchq.gaffer.data.element.id.EdgeId.MatchedVertex;
import uk.gov.gchq.gaffer.exception.SerialisationException;
import uk.gov.gchq.gaffer.operation.data.EdgeSeed;
import uk.gov.gchq.gaffer.serialisation.AvroSerialiser;
import uk.gov.gchq.gaffer.serialisation.FreqMapSerialiser;
import uk.gov.gchq.gaffer.serialisation.TypeSubTypeValueSerialiser;
import uk.gov.gchq.gaffer.store.schema.Schema;

class EdgeIdSerialiserDiffblueTest {
  /**
   * Test {@link EdgeIdSerialiser#EdgeIdSerialiser()}.
   *
   * <p>Method under test: {@link EdgeIdSerialiser#EdgeIdSerialiser()}
   */
  @Test
  @DisplayName("Test new EdgeIdSerialiser()")
  @Tag("MaintainedByDiffblue")
  void testNewEdgeIdSerialiser() {
    // Arrange and Act
    EdgeIdSerialiser actualEdgeIdSerialiser = new EdgeIdSerialiser();

    // Assert
    assertNull(actualEdgeIdSerialiser.vertexSerialiser);
    assertFalse(actualEdgeIdSerialiser.isConsistent());
    assertTrue(actualEdgeIdSerialiser.booleanSerialiser.isConsistent());
  }

  /**
   * Test {@link EdgeIdSerialiser#EdgeIdSerialiser(Schema)}.
   *
   * <ul>
   *   <li>When {@link Schema#Schema()}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeIdSerialiser#EdgeIdSerialiser(Schema)}
   */
  @Test
  @DisplayName(
      "Test new EdgeIdSerialiser(Schema); when Schema(); then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  void testNewEdgeIdSerialiser_whenSchema_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new EdgeIdSerialiser(new Schema()));
  }

  /**
   * Test {@link EdgeIdSerialiser#canHandle(Class)}.
   *
   * <ul>
   *   <li>When {@code Object}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeIdSerialiser#canHandle(Class)}
   */
  @Test
  @DisplayName("Test canHandle(Class); when 'java.lang.Object'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  void testCanHandle_whenJavaLangObject_thenReturnFalse() {
    // Arrange
    EdgeIdSerialiser edgeIdSerialiser = new EdgeIdSerialiser();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertFalse(edgeIdSerialiser.canHandle(clazz));
  }

  /**
   * Test {@link EdgeIdSerialiser#canHandle(Class)}.
   *
   * <ul>
   *   <li>When {@code EdgeId}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeIdSerialiser#canHandle(Class)}
   */
  @Test
  @DisplayName(
      "Test canHandle(Class); when 'uk.gov.gchq.gaffer.data.element.id.EdgeId'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  void testCanHandle_whenUkGovGchqGafferDataElementIdEdgeId_thenReturnTrue() {
    // Arrange
    EdgeIdSerialiser edgeIdSerialiser = new EdgeIdSerialiser();
    Class<EdgeId> clazz = EdgeId.class;

    // Act and Assert
    assertTrue(edgeIdSerialiser.canHandle(clazz));
  }

  /**
   * Test {@link EdgeIdSerialiser#serialise(EdgeId)} with {@code EdgeId}.
   *
   * <p>Method under test: {@link EdgeIdSerialiser#serialise(EdgeId)}
   */
  @Test
  @DisplayName("Test serialise(EdgeId) with 'EdgeId'")
  @Tag("MaintainedByDiffblue")
  void testSerialiseWithEdgeId() throws SerialisationException {
    // Arrange
    EdgeIdSerialiser edgeIdSerialiser = new EdgeIdSerialiser();

    // Act
    byte[] actualSerialiseResult =
        edgeIdSerialiser.serialise(
            new Builder()
                .dest("Dest")
                .directed(true)
                .group("Group")
                .matchedVertex(MatchedVertex.SOURCE)
                .source("Source")
                .build());

    // Assert
    assertArrayEquals(new byte[] {0, 0, 1, 1}, actualSerialiseResult);
  }

  /**
   * Test {@link EdgeIdSerialiser#serialise(EdgeId)} with {@code EdgeId}.
   *
   * <p>Method under test: {@link EdgeIdSerialiser#serialise(EdgeId)}
   */
  @Test
  @DisplayName("Test serialise(EdgeId) with 'EdgeId'")
  @Tag("MaintainedByDiffblue")
  void testSerialiseWithEdgeId2() throws SerialisationException {
    // Arrange
    EdgeIdSerialiser edgeIdSerialiser = new EdgeIdSerialiser(new EdgeIdSerialiser());

    // Act and Assert
    assertArrayEquals(new byte[] {0, 0, 1, 1}, edgeIdSerialiser.serialise(new EdgeSeed()));
  }

  /**
   * Test {@link EdgeIdSerialiser#serialise(EdgeId)} with {@code EdgeId}.
   *
   * <ul>
   *   <li>When {@link EdgeSeed#EdgeSeed()}.
   *   <li>Then return array of {@code byte} with zero and zero.
   * </ul>
   *
   * <p>Method under test: {@link EdgeIdSerialiser#serialise(EdgeId)}
   */
  @Test
  @DisplayName(
      "Test serialise(EdgeId) with 'EdgeId'; when EdgeSeed(); then return array of byte with zero and zero")
  @Tag("MaintainedByDiffblue")
  void testSerialiseWithEdgeId_whenEdgeSeed_thenReturnArrayOfByteWithZeroAndZero()
      throws SerialisationException {
    // Arrange
    EdgeIdSerialiser edgeIdSerialiser = new EdgeIdSerialiser();

    // Act and Assert
    assertArrayEquals(new byte[] {0, 0, 1, 1}, edgeIdSerialiser.serialise(new EdgeSeed()));
  }

  /**
   * Test {@link EdgeIdSerialiser#serialise(EdgeId)} with {@code EdgeId}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeIdSerialiser#serialise(EdgeId)}
   */
  @Test
  @DisplayName("Test serialise(EdgeId) with 'EdgeId'; when 'null'; then return empty array of byte")
  @Tag("MaintainedByDiffblue")
  void testSerialiseWithEdgeId_whenNull_thenReturnEmptyArrayOfByte() throws SerialisationException {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[] {}, new EdgeIdSerialiser().serialise(null));
  }

  /**
   * Test {@link EdgeIdSerialiser#deserialise(byte[])} with {@code bytes}.
   *
   * <ul>
   *   <li>Then AdjacentMatchedVertexValue return {@link Map}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeIdSerialiser#deserialise(byte[])}
   */
  @Test
  @DisplayName("Test deserialise(byte[]) with 'bytes'; then AdjacentMatchedVertexValue return Map")
  @Tag("MaintainedByDiffblue")
  void testDeserialiseWithBytes_thenAdjacentMatchedVertexValueReturnMap()
      throws SerialisationException {
    // Arrange and Act
    EdgeId actualDeserialiseResult =
        new EdgeIdSerialiser(new FreqMapSerialiser())
            .deserialise(new byte[] {1, 'X', 1, 'X', 'A', 'X', 'A', 'X'});

    // Assert
    Object adjacentMatchedVertexValue = actualDeserialiseResult.getAdjacentMatchedVertexValue();
    assertTrue(adjacentMatchedVertexValue instanceof Map);
    assertTrue(actualDeserialiseResult instanceof EdgeSeed);
    assertEquals(
        "uk.gov.gchq.gaffer.operation.data.EdgeSeed", actualDeserialiseResult.getClassName());
    assertEquals(DirectedType.UNDIRECTED, actualDeserialiseResult.getDirectedType());
    assertEquals(MatchedVertex.SOURCE, actualDeserialiseResult.getMatchedVertex());
    assertFalse(actualDeserialiseResult.isDirected());
    assertTrue(((Map<Object, Object>) adjacentMatchedVertexValue).isEmpty());
    assertTrue(actualDeserialiseResult.isUndirected());
    Object matchedVertexValue = actualDeserialiseResult.getMatchedVertexValue();
    assertEquals(adjacentMatchedVertexValue, matchedVertexValue);
    assertSame(matchedVertexValue, actualDeserialiseResult.getSource());
    assertSame(adjacentMatchedVertexValue, actualDeserialiseResult.getDestination());
  }

  /**
   * Test {@link EdgeIdSerialiser#deserialise(byte[])} with {@code bytes}.
   *
   * <ul>
   *   <li>Then AdjacentMatchedVertexValue return {@link Map}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeIdSerialiser#deserialise(byte[])}
   */
  @Test
  @DisplayName("Test deserialise(byte[]) with 'bytes'; then AdjacentMatchedVertexValue return Map")
  @Tag("MaintainedByDiffblue")
  void testDeserialiseWithBytes_thenAdjacentMatchedVertexValueReturnMap2()
      throws SerialisationException {
    // Arrange and Act
    EdgeId actualDeserialiseResult =
        new EdgeIdSerialiser(new FreqMapSerialiser())
            .deserialise(new byte[] {1, 'X', 0, 'X', 'A', 'X', 'A', 'X'});

    // Assert
    Object adjacentMatchedVertexValue = actualDeserialiseResult.getAdjacentMatchedVertexValue();
    assertTrue(adjacentMatchedVertexValue instanceof Map);
    assertTrue(actualDeserialiseResult instanceof EdgeSeed);
    assertEquals(
        "uk.gov.gchq.gaffer.operation.data.EdgeSeed", actualDeserialiseResult.getClassName());
    assertEquals(DirectedType.UNDIRECTED, actualDeserialiseResult.getDirectedType());
    assertEquals(MatchedVertex.SOURCE, actualDeserialiseResult.getMatchedVertex());
    assertFalse(actualDeserialiseResult.isDirected());
    assertTrue(((Map<Object, Object>) adjacentMatchedVertexValue).isEmpty());
    assertTrue(actualDeserialiseResult.isUndirected());
    Object matchedVertexValue = actualDeserialiseResult.getMatchedVertexValue();
    assertEquals(adjacentMatchedVertexValue, matchedVertexValue);
    assertSame(matchedVertexValue, actualDeserialiseResult.getSource());
    assertSame(adjacentMatchedVertexValue, actualDeserialiseResult.getDestination());
  }

  /**
   * Test {@link EdgeIdSerialiser#deserialiseEmpty()}.
   *
   * <p>Method under test: {@link EdgeIdSerialiser#deserialiseEmpty()}
   */
  @Test
  @DisplayName("Test deserialiseEmpty()")
  @Tag("MaintainedByDiffblue")
  void testDeserialiseEmpty() throws SerialisationException {
    // Arrange, Act and Assert
    assertNull(new EdgeIdSerialiser().deserialiseEmpty());
  }

  /**
   * Test {@link EdgeIdSerialiser#preservesObjectOrdering()}.
   *
   * <p>Method under test: {@link EdgeIdSerialiser#preservesObjectOrdering()}
   */
  @Test
  @DisplayName("Test preservesObjectOrdering()")
  @Tag("MaintainedByDiffblue")
  void testPreservesObjectOrdering() {
    // Arrange, Act and Assert
    assertFalse(new EdgeIdSerialiser(new EdgeIdSerialiser()).preservesObjectOrdering());
  }

  /**
   * Test {@link EdgeIdSerialiser#preservesObjectOrdering()}.
   *
   * <p>Method under test: {@link EdgeIdSerialiser#preservesObjectOrdering()}
   */
  @Test
  @DisplayName("Test preservesObjectOrdering()")
  @Tag("MaintainedByDiffblue")
  void testPreservesObjectOrdering2() {
    // Arrange, Act and Assert
    assertFalse(new EdgeIdSerialiser(new AvroSerialiser()).preservesObjectOrdering());
  }

  /**
   * Test {@link EdgeIdSerialiser#preservesObjectOrdering()}.
   *
   * <ul>
   *   <li>Given {@link EdgeIdSerialiser#EdgeIdSerialiser()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeIdSerialiser#preservesObjectOrdering()}
   */
  @Test
  @DisplayName("Test preservesObjectOrdering(); given EdgeIdSerialiser(); then return 'false'")
  @Tag("MaintainedByDiffblue")
  void testPreservesObjectOrdering_givenEdgeIdSerialiser_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new EdgeIdSerialiser().preservesObjectOrdering());
  }

  /**
   * Test {@link EdgeIdSerialiser#preservesObjectOrdering()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeIdSerialiser#preservesObjectOrdering()}
   */
  @Test
  @DisplayName("Test preservesObjectOrdering(); then return 'true'")
  @Tag("MaintainedByDiffblue")
  void testPreservesObjectOrdering_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new EdgeIdSerialiser(new TypeSubTypeValueSerialiser()).preservesObjectOrdering());
  }

  /**
   * Test {@link EdgeIdSerialiser#isConsistent()}.
   *
   * <ul>
   *   <li>Given {@link EdgeIdSerialiser#EdgeIdSerialiser(ToBytesSerialiser)} with vertexSerialiser
   *       is {@link AvroSerialiser} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link EdgeIdSerialiser#isConsistent()}
   */
  @Test
  @DisplayName(
      "Test isConsistent(); given EdgeIdSerialiser(ToBytesSerialiser) with vertexSerialiser is AvroSerialiser (default constructor)")
  @Tag("MaintainedByDiffblue")
  void testIsConsistent_givenEdgeIdSerialiserWithVertexSerialiserIsAvroSerialiser() {
    // Arrange, Act and Assert
    assertFalse(new EdgeIdSerialiser(new AvroSerialiser()).isConsistent());
  }

  /**
   * Test {@link EdgeIdSerialiser#isConsistent()}.
   *
   * <ul>
   *   <li>Given {@link EdgeIdSerialiser#EdgeIdSerialiser(ToBytesSerialiser)} with vertexSerialiser
   *       is {@link EdgeIdSerialiser#EdgeIdSerialiser()}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeIdSerialiser#isConsistent()}
   */
  @Test
  @DisplayName(
      "Test isConsistent(); given EdgeIdSerialiser(ToBytesSerialiser) with vertexSerialiser is EdgeIdSerialiser()")
  @Tag("MaintainedByDiffblue")
  void testIsConsistent_givenEdgeIdSerialiserWithVertexSerialiserIsEdgeIdSerialiser() {
    // Arrange, Act and Assert
    assertFalse(new EdgeIdSerialiser(new EdgeIdSerialiser()).isConsistent());
  }

  /**
   * Test {@link EdgeIdSerialiser#isConsistent()}.
   *
   * <ul>
   *   <li>Given {@link EdgeIdSerialiser#EdgeIdSerialiser()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeIdSerialiser#isConsistent()}
   */
  @Test
  @DisplayName("Test isConsistent(); given EdgeIdSerialiser(); then return 'false'")
  @Tag("MaintainedByDiffblue")
  void testIsConsistent_givenEdgeIdSerialiser_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new EdgeIdSerialiser().isConsistent());
  }

  /**
   * Test {@link EdgeIdSerialiser#isConsistent()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeIdSerialiser#isConsistent()}
   */
  @Test
  @DisplayName("Test isConsistent(); then return 'true'")
  @Tag("MaintainedByDiffblue")
  void testIsConsistent_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new EdgeIdSerialiser(new TypeSubTypeValueSerialiser()).isConsistent());
  }

  /**
   * Test {@link EdgeIdSerialiser#equals(Object)}, and {@link EdgeIdSerialiser#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EdgeIdSerialiser#equals(Object)}
   *   <li>{@link EdgeIdSerialiser#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EdgeIdSerialiser edgeIdSerialiser = new EdgeIdSerialiser();
    EdgeIdSerialiser edgeIdSerialiser2 = new EdgeIdSerialiser();

    // Act and Assert
    assertEquals(edgeIdSerialiser, edgeIdSerialiser2);
    assertEquals(edgeIdSerialiser.hashCode(), edgeIdSerialiser2.hashCode());
  }

  /**
   * Test {@link EdgeIdSerialiser#equals(Object)}, and {@link EdgeIdSerialiser#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EdgeIdSerialiser#equals(Object)}
   *   <li>{@link EdgeIdSerialiser#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    EdgeIdSerialiser edgeIdSerialiser = new EdgeIdSerialiser(new EdgeIdSerialiser());
    EdgeIdSerialiser edgeIdSerialiser2 = new EdgeIdSerialiser(new EdgeIdSerialiser());

    // Act and Assert
    assertEquals(edgeIdSerialiser, edgeIdSerialiser2);
    assertEquals(edgeIdSerialiser.hashCode(), edgeIdSerialiser2.hashCode());
  }

  /**
   * Test {@link EdgeIdSerialiser#equals(Object)}, and {@link EdgeIdSerialiser#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EdgeIdSerialiser#equals(Object)}
   *   <li>{@link EdgeIdSerialiser#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EdgeIdSerialiser edgeIdSerialiser = new EdgeIdSerialiser();

    // Act and Assert
    assertEquals(edgeIdSerialiser, edgeIdSerialiser);
    int expectedHashCodeResult = edgeIdSerialiser.hashCode();
    assertEquals(expectedHashCodeResult, edgeIdSerialiser.hashCode());
  }

  /**
   * Test {@link EdgeIdSerialiser#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeIdSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EdgeIdSerialiser edgeIdSerialiser = new EdgeIdSerialiser(new EdgeIdSerialiser());

    // Act and Assert
    assertNotEquals(edgeIdSerialiser, new EdgeIdSerialiser());
  }

  /**
   * Test {@link EdgeIdSerialiser#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeIdSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EdgeIdSerialiser(), null);
  }

  /**
   * Test {@link EdgeIdSerialiser#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeIdSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EdgeIdSerialiser(), "Different type to EdgeIdSerialiser");
  }
}
