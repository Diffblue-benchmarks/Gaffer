/*
 * Copyright 2026 Crown Copyright
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

package uk.gov.gchq.gaffer.operation.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.Edge;
import uk.gov.gchq.gaffer.data.element.Edge.Builder;
import uk.gov.gchq.gaffer.data.element.id.DirectedType;
import uk.gov.gchq.gaffer.data.element.id.EdgeId;
import uk.gov.gchq.gaffer.data.element.id.EdgeId.MatchedVertex;

class EdgeSeedDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EdgeSeed#EdgeSeed(Object, Object, DirectedType, MatchedVertex)}
   *   <li>{@link EdgeSeed#toString()}
   *   <li>{@link EdgeSeed#getDestination()}
   *   <li>{@link EdgeSeed#getDirectedType()}
   *   <li>{@link EdgeSeed#getMatchedVertex()}
   *   <li>{@link EdgeSeed#getSource()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EdgeSeed.<init>(Object, Object, DirectedType, MatchedVertex)",
    "Object EdgeSeed.getDestination()",
    "DirectedType EdgeSeed.getDirectedType()",
    "MatchedVertex EdgeSeed.getMatchedVertex()",
    "Object EdgeSeed.getSource()",
    "String EdgeSeed.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    EdgeSeed actualEdgeSeed =
        new EdgeSeed("Source", "Destination", DirectedType.EITHER, MatchedVertex.SOURCE);
    String actualToStringResult = actualEdgeSeed.toString();
    Object actualDestination = actualEdgeSeed.getDestination();
    DirectedType actualDirectedType = actualEdgeSeed.getDirectedType();
    MatchedVertex actualMatchedVertex = actualEdgeSeed.getMatchedVertex();

    // Assert
    assertEquals("Destination", actualDestination);
    assertEquals(
        "EdgeSeed[source=Source,destination=Destination,directed=EITHER]", actualToStringResult);
    assertEquals("Source", actualEdgeSeed.getSource());
    assertEquals(DirectedType.EITHER, actualDirectedType);
    assertEquals(MatchedVertex.SOURCE, actualMatchedVertex);
  }

  /**
   * Test {@link EdgeSeed#EdgeSeed()}.
   *
   * <p>Method under test: {@link EdgeSeed#EdgeSeed()}
   */
  @Test
  @DisplayName("Test new EdgeSeed()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EdgeSeed.<init>()"})
  void testNewEdgeSeed() {
    // Arrange and Act
    EdgeSeed actualEdgeSeed = new EdgeSeed();

    // Assert
    assertEquals("uk.gov.gchq.gaffer.operation.data.EdgeSeed", actualEdgeSeed.getClassName());
    assertNull(actualEdgeSeed.getAdjacentMatchedVertexValue());
    assertNull(actualEdgeSeed.getMatchedVertexValue());
    assertNull(actualEdgeSeed.getDestination());
    assertNull(actualEdgeSeed.getSource());
    assertEquals(DirectedType.EITHER, actualEdgeSeed.getDirectedType());
    assertEquals(MatchedVertex.SOURCE, actualEdgeSeed.getMatchedVertex());
    assertTrue(actualEdgeSeed.isDirected());
    assertTrue(actualEdgeSeed.isUndirected());
  }

  /**
   * Test {@link EdgeSeed#EdgeSeed(Object, Object)}.
   *
   * <p>Method under test: {@link EdgeSeed#EdgeSeed(Object, Object)}
   */
  @Test
  @DisplayName("Test new EdgeSeed(Object, Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EdgeSeed.<init>(Object, Object)"})
  void testNewEdgeSeed2() {
    // Arrange and Act
    EdgeSeed actualEdgeSeed = new EdgeSeed("Source", "Destination");

    // Assert
    assertEquals("Destination", actualEdgeSeed.getAdjacentMatchedVertexValue());
    assertEquals("Destination", actualEdgeSeed.getDestination());
    assertEquals("Source", actualEdgeSeed.getMatchedVertexValue());
    assertEquals("Source", actualEdgeSeed.getSource());
    assertEquals("uk.gov.gchq.gaffer.operation.data.EdgeSeed", actualEdgeSeed.getClassName());
    assertEquals(DirectedType.EITHER, actualEdgeSeed.getDirectedType());
    assertEquals(MatchedVertex.SOURCE, actualEdgeSeed.getMatchedVertex());
    assertTrue(actualEdgeSeed.isDirected());
    assertTrue(actualEdgeSeed.isUndirected());
  }

  /**
   * Test {@link EdgeSeed#EdgeSeed(Object, Object, Boolean, DirectedType, MatchedVertex)}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then return MatchedVertexValue byteValue is {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeSeed#EdgeSeed(Object, Object, Boolean, DirectedType,
   * MatchedVertex)}
   */
  @Test
  @DisplayName(
      "Test new EdgeSeed(Object, Object, Boolean, DirectedType, MatchedVertex); when 'A'; then return MatchedVertexValue byteValue is 'A'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EdgeSeed.<init>(Object, Object, Boolean, DirectedType, MatchedVertex)"})
  void testNewEdgeSeed_whenA_thenReturnMatchedVertexValueByteValueIsA() {
    // Arrange and Act
    EdgeSeed actualEdgeSeed =
        new EdgeSeed((byte) 'A', "Destination", false, null, MatchedVertex.SOURCE);

    // Assert
    assertEquals('A', ((Byte) actualEdgeSeed.getMatchedVertexValue()).byteValue());
    assertEquals('A', ((Byte) actualEdgeSeed.getSource()).byteValue());
  }

  /**
   * Test {@link EdgeSeed#EdgeSeed(Object, Object, DirectedType)}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then return MatchedVertexValue byteValue is {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeSeed#EdgeSeed(Object, Object, DirectedType)}
   */
  @Test
  @DisplayName(
      "Test new EdgeSeed(Object, Object, DirectedType); when 'A'; then return MatchedVertexValue byteValue is 'A'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EdgeSeed.<init>(Object, Object, DirectedType)"})
  void testNewEdgeSeed_whenA_thenReturnMatchedVertexValueByteValueIsA2() {
    // Arrange and Act
    EdgeSeed actualEdgeSeed = new EdgeSeed((byte) 'A', "Destination", DirectedType.UNDIRECTED);

    // Assert
    assertEquals('A', ((Byte) actualEdgeSeed.getMatchedVertexValue()).byteValue());
    assertEquals('A', ((Byte) actualEdgeSeed.getSource()).byteValue());
  }

  /**
   * Test {@link EdgeSeed#EdgeSeed(Object, Object, boolean)}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then return MatchedVertexValue byteValue is {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeSeed#EdgeSeed(Object, Object, boolean)}
   */
  @Test
  @DisplayName(
      "Test new EdgeSeed(Object, Object, boolean); when 'A'; then return MatchedVertexValue byteValue is 'A'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EdgeSeed.<init>(Object, Object, boolean)"})
  void testNewEdgeSeed_whenA_thenReturnMatchedVertexValueByteValueIsA3() {
    // Arrange and Act
    EdgeSeed actualEdgeSeed = new EdgeSeed((byte) 'A', "Destination", false);

    // Assert
    assertEquals('A', ((Byte) actualEdgeSeed.getMatchedVertexValue()).byteValue());
    assertEquals('A', ((Byte) actualEdgeSeed.getSource()).byteValue());
  }

  /**
   * Test {@link EdgeSeed#EdgeSeed(Object, Object, boolean, MatchedVertex)}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then return MatchedVertexValue byteValue is {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeSeed#EdgeSeed(Object, Object, boolean, MatchedVertex)}
   */
  @Test
  @DisplayName(
      "Test new EdgeSeed(Object, Object, boolean, MatchedVertex); when 'A'; then return MatchedVertexValue byteValue is 'A'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EdgeSeed.<init>(Object, Object, boolean, MatchedVertex)"})
  void testNewEdgeSeed_whenA_thenReturnMatchedVertexValueByteValueIsA4() {
    // Arrange and Act
    EdgeSeed actualEdgeSeed = new EdgeSeed((byte) 'A', "Destination", false, MatchedVertex.SOURCE);

    // Assert
    assertEquals('A', ((Byte) actualEdgeSeed.getMatchedVertexValue()).byteValue());
    assertEquals('A', ((Byte) actualEdgeSeed.getSource()).byteValue());
  }

  /**
   * Test {@link EdgeSeed#EdgeSeed(Object, Object, boolean, MatchedVertex)}.
   *
   * <ul>
   *   <li>When {@code DESTINATION}.
   *   <li>Then return MatchedVertex is {@code SOURCE}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeSeed#EdgeSeed(Object, Object, boolean, MatchedVertex)}
   */
  @Test
  @DisplayName(
      "Test new EdgeSeed(Object, Object, boolean, MatchedVertex); when 'DESTINATION'; then return MatchedVertex is 'SOURCE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EdgeSeed.<init>(Object, Object, boolean, MatchedVertex)"})
  void testNewEdgeSeed_whenDestination_thenReturnMatchedVertexIsSource() {
    // Arrange and Act
    EdgeSeed actualEdgeSeed =
        new EdgeSeed("Source", "Destination", false, MatchedVertex.DESTINATION);

    // Assert
    assertEquals("Destination", actualEdgeSeed.getMatchedVertexValue());
    assertEquals("Destination", actualEdgeSeed.getSource());
    assertEquals("Source", actualEdgeSeed.getAdjacentMatchedVertexValue());
    assertEquals("Source", actualEdgeSeed.getDestination());
    assertEquals(MatchedVertex.SOURCE, actualEdgeSeed.getMatchedVertex());
  }

  /**
   * Test {@link EdgeSeed#EdgeSeed(Object, Object, Boolean, DirectedType, MatchedVertex)}.
   *
   * <ul>
   *   <li>When {@code DESTINATION}.
   *   <li>Then return MatchedVertexValue is {@code Destination}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeSeed#EdgeSeed(Object, Object, Boolean, DirectedType,
   * MatchedVertex)}
   */
  @Test
  @DisplayName(
      "Test new EdgeSeed(Object, Object, Boolean, DirectedType, MatchedVertex); when 'DESTINATION'; then return MatchedVertexValue is 'Destination'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EdgeSeed.<init>(Object, Object, Boolean, DirectedType, MatchedVertex)"})
  void testNewEdgeSeed_whenDestination_thenReturnMatchedVertexValueIsDestination() {
    // Arrange and Act
    EdgeSeed actualEdgeSeed =
        new EdgeSeed("Source", "Destination", false, null, MatchedVertex.DESTINATION);

    // Assert
    assertEquals("Destination", actualEdgeSeed.getMatchedVertexValue());
    assertEquals("Destination", actualEdgeSeed.getSource());
    assertEquals("Source", actualEdgeSeed.getAdjacentMatchedVertexValue());
    assertEquals("Source", actualEdgeSeed.getDestination());
  }

  /**
   * Test {@link EdgeSeed#EdgeSeed(Object, Object, Boolean, DirectedType, MatchedVertex)}.
   *
   * <ul>
   *   <li>When {@code EITHER}.
   *   <li>Then return DirectedType is {@code EITHER}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeSeed#EdgeSeed(Object, Object, Boolean, DirectedType,
   * MatchedVertex)}
   */
  @Test
  @DisplayName(
      "Test new EdgeSeed(Object, Object, Boolean, DirectedType, MatchedVertex); when 'EITHER'; then return DirectedType is 'EITHER'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EdgeSeed.<init>(Object, Object, Boolean, DirectedType, MatchedVertex)"})
  void testNewEdgeSeed_whenEither_thenReturnDirectedTypeIsEither() {
    // Arrange and Act
    EdgeSeed actualEdgeSeed =
        new EdgeSeed("Source", "Destination", null, DirectedType.EITHER, MatchedVertex.SOURCE);

    // Assert
    assertEquals("Destination", actualEdgeSeed.getDestination());
    assertEquals("Source", actualEdgeSeed.getMatchedVertexValue());
    assertEquals("Source", actualEdgeSeed.getSource());
    assertEquals(DirectedType.EITHER, actualEdgeSeed.getDirectedType());
    assertTrue(actualEdgeSeed.isDirected());
  }

  /**
   * Test {@link EdgeSeed#EdgeSeed(Object, Object, DirectedType)}.
   *
   * <ul>
   *   <li>When {@code EITHER}.
   *   <li>Then return DirectedType is {@code EITHER}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeSeed#EdgeSeed(Object, Object, DirectedType)}
   */
  @Test
  @DisplayName(
      "Test new EdgeSeed(Object, Object, DirectedType); when 'EITHER'; then return DirectedType is 'EITHER'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EdgeSeed.<init>(Object, Object, DirectedType)"})
  void testNewEdgeSeed_whenEither_thenReturnDirectedTypeIsEither2() {
    // Arrange and Act
    EdgeSeed actualEdgeSeed = new EdgeSeed("Source", "Destination", DirectedType.EITHER);

    // Assert
    assertEquals("Destination", actualEdgeSeed.getDestination());
    assertEquals("Source", actualEdgeSeed.getMatchedVertexValue());
    assertEquals("Source", actualEdgeSeed.getSource());
    assertEquals(DirectedType.EITHER, actualEdgeSeed.getDirectedType());
    assertEquals(MatchedVertex.SOURCE, actualEdgeSeed.getMatchedVertex());
    assertTrue(actualEdgeSeed.isDirected());
  }

  /**
   * Test {@link EdgeSeed#EdgeSeed(Object, Object, Boolean, DirectedType, MatchedVertex)}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then return DirectedType is {@code UNDIRECTED}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeSeed#EdgeSeed(Object, Object, Boolean, DirectedType,
   * MatchedVertex)}
   */
  @Test
  @DisplayName(
      "Test new EdgeSeed(Object, Object, Boolean, DirectedType, MatchedVertex); when 'false'; then return DirectedType is 'UNDIRECTED'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EdgeSeed.<init>(Object, Object, Boolean, DirectedType, MatchedVertex)"})
  void testNewEdgeSeed_whenFalse_thenReturnDirectedTypeIsUndirected() {
    // Arrange and Act
    EdgeSeed actualEdgeSeed =
        new EdgeSeed("Source", "Destination", false, null, MatchedVertex.SOURCE);

    // Assert
    assertEquals("Destination", actualEdgeSeed.getSource());
    assertEquals("Source", actualEdgeSeed.getDestination());
    assertEquals(DirectedType.UNDIRECTED, actualEdgeSeed.getDirectedType());
    assertEquals(MatchedVertex.DESTINATION, actualEdgeSeed.getMatchedVertex());
    assertFalse(actualEdgeSeed.isDirected());
  }

  /**
   * Test {@link EdgeSeed#EdgeSeed(Object, Object, Boolean, DirectedType, MatchedVertex)}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then return MatchedVertex is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeSeed#EdgeSeed(Object, Object, Boolean, DirectedType,
   * MatchedVertex)}
   */
  @Test
  @DisplayName(
      "Test new EdgeSeed(Object, Object, Boolean, DirectedType, MatchedVertex); when 'false'; then return MatchedVertex is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EdgeSeed.<init>(Object, Object, Boolean, DirectedType, MatchedVertex)"})
  void testNewEdgeSeed_whenFalse_thenReturnMatchedVertexIsNull() {
    // Arrange and Act
    EdgeSeed actualEdgeSeed = new EdgeSeed("Source", "Destination", false, null, null);

    // Assert
    assertEquals("Destination", actualEdgeSeed.getMatchedVertexValue());
    assertEquals("Source", actualEdgeSeed.getAdjacentMatchedVertexValue());
    assertNull(actualEdgeSeed.getMatchedVertex());
  }

  /**
   * Test {@link EdgeSeed#EdgeSeed(Object, Object, DirectedType)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return DirectedType is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeSeed#EdgeSeed(Object, Object, DirectedType)}
   */
  @Test
  @DisplayName(
      "Test new EdgeSeed(Object, Object, DirectedType); when 'null'; then return DirectedType is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EdgeSeed.<init>(Object, Object, DirectedType)"})
  void testNewEdgeSeed_whenNull_thenReturnDirectedTypeIsNull() {
    // Arrange and Act
    EdgeSeed actualEdgeSeed = new EdgeSeed("Source", "Destination", null);

    // Assert
    assertEquals("Destination", actualEdgeSeed.getDestination());
    assertEquals("Source", actualEdgeSeed.getMatchedVertexValue());
    assertEquals("Source", actualEdgeSeed.getSource());
    assertNull(actualEdgeSeed.getDirectedType());
    assertEquals(MatchedVertex.SOURCE, actualEdgeSeed.getMatchedVertex());
    assertTrue(actualEdgeSeed.isDirected());
  }

  /**
   * Test {@link EdgeSeed#EdgeSeed(Object, Object, boolean, MatchedVertex)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return MatchedVertex is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeSeed#EdgeSeed(Object, Object, boolean, MatchedVertex)}
   */
  @Test
  @DisplayName(
      "Test new EdgeSeed(Object, Object, boolean, MatchedVertex); when 'null'; then return MatchedVertex is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EdgeSeed.<init>(Object, Object, boolean, MatchedVertex)"})
  void testNewEdgeSeed_whenNull_thenReturnMatchedVertexIsNull() {
    // Arrange and Act
    EdgeSeed actualEdgeSeed = new EdgeSeed("Source", "Destination", false, null);

    // Assert
    assertEquals("Destination", actualEdgeSeed.getMatchedVertexValue());
    assertEquals("Destination", actualEdgeSeed.getSource());
    assertEquals("Source", actualEdgeSeed.getAdjacentMatchedVertexValue());
    assertEquals("Source", actualEdgeSeed.getDestination());
    assertNull(actualEdgeSeed.getMatchedVertex());
  }

  /**
   * Test {@link EdgeSeed#EdgeSeed(Object, Object, boolean, MatchedVertex)}.
   *
   * <ul>
   *   <li>When {@code SOURCE}.
   *   <li>Then return AdjacentMatchedVertexValue is {@code Destination}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeSeed#EdgeSeed(Object, Object, boolean, MatchedVertex)}
   */
  @Test
  @DisplayName(
      "Test new EdgeSeed(Object, Object, boolean, MatchedVertex); when 'SOURCE'; then return AdjacentMatchedVertexValue is 'Destination'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EdgeSeed.<init>(Object, Object, boolean, MatchedVertex)"})
  void testNewEdgeSeed_whenSource_thenReturnAdjacentMatchedVertexValueIsDestination() {
    // Arrange and Act
    EdgeSeed actualEdgeSeed = new EdgeSeed("Source", "Destination", false, MatchedVertex.SOURCE);

    // Assert
    assertEquals("Destination", actualEdgeSeed.getAdjacentMatchedVertexValue());
    assertEquals("Destination", actualEdgeSeed.getSource());
    assertEquals("Source", actualEdgeSeed.getMatchedVertexValue());
    assertEquals("Source", actualEdgeSeed.getDestination());
    assertEquals(MatchedVertex.DESTINATION, actualEdgeSeed.getMatchedVertex());
  }

  /**
   * Test {@link EdgeSeed#EdgeSeed(Object, Object, Boolean, DirectedType, MatchedVertex)}.
   *
   * <ul>
   *   <li>When {@code SOURCE}.
   *   <li>Then return DirectedType is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeSeed#EdgeSeed(Object, Object, Boolean, DirectedType,
   * MatchedVertex)}
   */
  @Test
  @DisplayName(
      "Test new EdgeSeed(Object, Object, Boolean, DirectedType, MatchedVertex); when 'SOURCE'; then return DirectedType is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EdgeSeed.<init>(Object, Object, Boolean, DirectedType, MatchedVertex)"})
  void testNewEdgeSeed_whenSource_thenReturnDirectedTypeIsNull() {
    // Arrange and Act
    EdgeSeed actualEdgeSeed =
        new EdgeSeed("Source", "Destination", null, null, MatchedVertex.SOURCE);

    // Assert
    assertEquals("Destination", actualEdgeSeed.getDestination());
    assertEquals("Source", actualEdgeSeed.getMatchedVertexValue());
    assertEquals("Source", actualEdgeSeed.getSource());
    assertNull(actualEdgeSeed.getDirectedType());
    assertTrue(actualEdgeSeed.isDirected());
  }

  /**
   * Test {@link EdgeSeed#EdgeSeed(Object, Object, boolean)}.
   *
   * <ul>
   *   <li>When {@code Source}.
   *   <li>Then return Source is {@code Destination}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeSeed#EdgeSeed(Object, Object, boolean)}
   */
  @Test
  @DisplayName(
      "Test new EdgeSeed(Object, Object, boolean); when 'Source'; then return Source is 'Destination'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EdgeSeed.<init>(Object, Object, boolean)"})
  void testNewEdgeSeed_whenSource_thenReturnSourceIsDestination() {
    // Arrange and Act
    EdgeSeed actualEdgeSeed = new EdgeSeed("Source", "Destination", false);

    // Assert
    assertEquals("Destination", actualEdgeSeed.getSource());
    assertEquals("Source", actualEdgeSeed.getMatchedVertexValue());
    assertEquals("Source", actualEdgeSeed.getDestination());
    assertEquals(DirectedType.UNDIRECTED, actualEdgeSeed.getDirectedType());
    assertEquals(MatchedVertex.DESTINATION, actualEdgeSeed.getMatchedVertex());
    assertFalse(actualEdgeSeed.isDirected());
    assertTrue(actualEdgeSeed.isUndirected());
  }

  /**
   * Test {@link EdgeSeed#EdgeSeed(Object, Object, Boolean, DirectedType, MatchedVertex)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then return DirectedType is {@code DIRECTED}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeSeed#EdgeSeed(Object, Object, Boolean, DirectedType,
   * MatchedVertex)}
   */
  @Test
  @DisplayName(
      "Test new EdgeSeed(Object, Object, Boolean, DirectedType, MatchedVertex); when 'true'; then return DirectedType is 'DIRECTED'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EdgeSeed.<init>(Object, Object, Boolean, DirectedType, MatchedVertex)"})
  void testNewEdgeSeed_whenTrue_thenReturnDirectedTypeIsDirected() {
    // Arrange and Act
    EdgeSeed actualEdgeSeed =
        new EdgeSeed("Source", "Destination", true, null, MatchedVertex.SOURCE);

    // Assert
    assertEquals("Source", actualEdgeSeed.getSource());
    assertEquals(DirectedType.DIRECTED, actualEdgeSeed.getDirectedType());
    assertFalse(actualEdgeSeed.isUndirected());
    assertTrue(actualEdgeSeed.isDirected());
  }

  /**
   * Test {@link EdgeSeed#EdgeSeed(Object, Object, boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then return {@code Source}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeSeed#EdgeSeed(Object, Object, boolean)}
   */
  @Test
  @DisplayName("Test new EdgeSeed(Object, Object, boolean); when 'true'; then return 'Source'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EdgeSeed.<init>(Object, Object, boolean)"})
  void testNewEdgeSeed_whenTrue_thenReturnSource() {
    // Arrange and Act
    EdgeSeed actualEdgeSeed = new EdgeSeed("Source", "Destination", true);

    // Assert
    assertEquals("Source", actualEdgeSeed.getSource());
    assertEquals(DirectedType.DIRECTED, actualEdgeSeed.getDirectedType());
    assertFalse(actualEdgeSeed.isUndirected());
    assertTrue(actualEdgeSeed.isDirected());
  }

  /**
   * Test {@link EdgeSeed#EdgeSeed(Object, Object, boolean, MatchedVertex)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then return {@code Source}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeSeed#EdgeSeed(Object, Object, boolean, MatchedVertex)}
   */
  @Test
  @DisplayName(
      "Test new EdgeSeed(Object, Object, boolean, MatchedVertex); when 'true'; then return 'Source'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EdgeSeed.<init>(Object, Object, boolean, MatchedVertex)"})
  void testNewEdgeSeed_whenTrue_thenReturnSource2() {
    // Arrange and Act
    EdgeSeed actualEdgeSeed = new EdgeSeed("Source", "Destination", true, MatchedVertex.SOURCE);

    // Assert
    assertEquals("Source", actualEdgeSeed.getSource());
    assertEquals(DirectedType.DIRECTED, actualEdgeSeed.getDirectedType());
    assertFalse(actualEdgeSeed.isUndirected());
    assertTrue(actualEdgeSeed.isDirected());
  }

  /**
   * Test {@link EdgeSeed#EdgeSeed(Object, Object, Boolean, DirectedType, MatchedVertex)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeSeed#EdgeSeed(Object, Object, Boolean, DirectedType,
   * MatchedVertex)}
   */
  @Test
  @DisplayName(
      "Test new EdgeSeed(Object, Object, Boolean, DirectedType, MatchedVertex); when 'true'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EdgeSeed.<init>(Object, Object, Boolean, DirectedType, MatchedVertex)"})
  void testNewEdgeSeed_whenTrue_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new EdgeSeed("Source", "Destination", true, DirectedType.EITHER, MatchedVertex.SOURCE));
  }

  /**
   * Test {@link EdgeSeed#EdgeSeed(Object, Object, DirectedType)}.
   *
   * <ul>
   *   <li>When {@code UNDIRECTED}.
   *   <li>Then return Source is {@code Destination}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeSeed#EdgeSeed(Object, Object, DirectedType)}
   */
  @Test
  @DisplayName(
      "Test new EdgeSeed(Object, Object, DirectedType); when 'UNDIRECTED'; then return Source is 'Destination'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EdgeSeed.<init>(Object, Object, DirectedType)"})
  void testNewEdgeSeed_whenUndirected_thenReturnSourceIsDestination() {
    // Arrange and Act
    EdgeSeed actualEdgeSeed = new EdgeSeed("Source", "Destination", DirectedType.UNDIRECTED);

    // Assert
    assertEquals("Destination", actualEdgeSeed.getSource());
    assertEquals("Source", actualEdgeSeed.getDestination());
    assertEquals(DirectedType.UNDIRECTED, actualEdgeSeed.getDirectedType());
    assertEquals(MatchedVertex.DESTINATION, actualEdgeSeed.getMatchedVertex());
    assertFalse(actualEdgeSeed.isDirected());
  }

  /**
   * Test {@link EdgeSeed#setIdentifiers(Object, Object, DirectedType, MatchedVertex)} with {@code
   * source}, {@code destination}, {@code directed}, {@code matchedVertex}.
   *
   * <p>Method under test: {@link EdgeSeed#setIdentifiers(Object, Object, DirectedType,
   * MatchedVertex)}
   */
  @Test
  @DisplayName(
      "Test setIdentifiers(Object, Object, DirectedType, MatchedVertex) with 'source', 'destination', 'directed', 'matchedVertex'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EdgeSeed.setIdentifiers(Object, Object, DirectedType, MatchedVertex)"})
  void testSetIdentifiersWithSourceDestinationDirectedMatchedVertex() {
    // Arrange
    EdgeSeed edgeSeed = new EdgeSeed();

    // Act
    edgeSeed.setIdentifiers("Source", "Destination", DirectedType.EITHER, MatchedVertex.SOURCE);

    // Assert
    assertEquals("Destination", edgeSeed.getDestination());
    assertEquals("Source", edgeSeed.getMatchedVertexValue());
    assertEquals("Source", edgeSeed.getSource());
    assertEquals(DirectedType.EITHER, edgeSeed.getDirectedType());
  }

  /**
   * Test {@link EdgeSeed#setIdentifiers(Object, Object, DirectedType, MatchedVertex)} with {@code
   * source}, {@code destination}, {@code directed}, {@code matchedVertex}.
   *
   * <p>Method under test: {@link EdgeSeed#setIdentifiers(Object, Object, DirectedType,
   * MatchedVertex)}
   */
  @Test
  @DisplayName(
      "Test setIdentifiers(Object, Object, DirectedType, MatchedVertex) with 'source', 'destination', 'directed', 'matchedVertex'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EdgeSeed.setIdentifiers(Object, Object, DirectedType, MatchedVertex)"})
  void testSetIdentifiersWithSourceDestinationDirectedMatchedVertex2() {
    // Arrange
    EdgeSeed edgeSeed = new EdgeSeed();

    // Act
    edgeSeed.setIdentifiers("Source", "Destination", DirectedType.UNDIRECTED, MatchedVertex.SOURCE);

    // Assert
    assertEquals("Destination", edgeSeed.getSource());
    assertEquals("Source", edgeSeed.getMatchedVertexValue());
    assertEquals("Source", edgeSeed.getDestination());
    assertEquals(MatchedVertex.DESTINATION, edgeSeed.getMatchedVertex());
  }

  /**
   * Test {@link EdgeSeed#setIdentifiers(Object, Object, DirectedType, MatchedVertex)} with {@code
   * source}, {@code destination}, {@code directed}, {@code matchedVertex}.
   *
   * <p>Method under test: {@link EdgeSeed#setIdentifiers(Object, Object, DirectedType,
   * MatchedVertex)}
   */
  @Test
  @DisplayName(
      "Test setIdentifiers(Object, Object, DirectedType, MatchedVertex) with 'source', 'destination', 'directed', 'matchedVertex'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EdgeSeed.setIdentifiers(Object, Object, DirectedType, MatchedVertex)"})
  void testSetIdentifiersWithSourceDestinationDirectedMatchedVertex3() {
    // Arrange
    EdgeSeed edgeSeed = new EdgeSeed();

    // Act
    edgeSeed.setIdentifiers(
        (byte) 'A', "Destination", DirectedType.UNDIRECTED, MatchedVertex.SOURCE);

    // Assert
    assertEquals('A', ((Byte) edgeSeed.getMatchedVertexValue()).byteValue());
    assertEquals('A', ((Byte) edgeSeed.getSource()).byteValue());
  }

  /**
   * Test {@link EdgeSeed#setIdentifiers(Object, Object, DirectedType, MatchedVertex)} with {@code
   * source}, {@code destination}, {@code directed}, {@code matchedVertex}.
   *
   * <p>Method under test: {@link EdgeSeed#setIdentifiers(Object, Object, DirectedType,
   * MatchedVertex)}
   */
  @Test
  @DisplayName(
      "Test setIdentifiers(Object, Object, DirectedType, MatchedVertex) with 'source', 'destination', 'directed', 'matchedVertex'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EdgeSeed.setIdentifiers(Object, Object, DirectedType, MatchedVertex)"})
  void testSetIdentifiersWithSourceDestinationDirectedMatchedVertex4() {
    // Arrange
    EdgeSeed edgeSeed = new EdgeSeed();

    // Act
    edgeSeed.setIdentifiers("Source", "Destination", null, MatchedVertex.SOURCE);

    // Assert
    assertEquals("Destination", edgeSeed.getDestination());
    assertEquals("Source", edgeSeed.getMatchedVertexValue());
    assertEquals("Source", edgeSeed.getSource());
    assertNull(edgeSeed.getDirectedType());
  }

  /**
   * Test {@link EdgeSeed#setIdentifiers(Object, Object, DirectedType, MatchedVertex)} with {@code
   * source}, {@code destination}, {@code directed}, {@code matchedVertex}.
   *
   * <p>Method under test: {@link EdgeSeed#setIdentifiers(Object, Object, DirectedType,
   * MatchedVertex)}
   */
  @Test
  @DisplayName(
      "Test setIdentifiers(Object, Object, DirectedType, MatchedVertex) with 'source', 'destination', 'directed', 'matchedVertex'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EdgeSeed.setIdentifiers(Object, Object, DirectedType, MatchedVertex)"})
  void testSetIdentifiersWithSourceDestinationDirectedMatchedVertex5() {
    // Arrange
    EdgeSeed edgeSeed = new EdgeSeed();

    // Act
    edgeSeed.setIdentifiers("Source", "Destination", DirectedType.UNDIRECTED, null);

    // Assert
    assertEquals("Destination", edgeSeed.getMatchedVertexValue());
    assertEquals("Source", edgeSeed.getAdjacentMatchedVertexValue());
    assertNull(edgeSeed.getMatchedVertex());
  }

  /**
   * Test {@link EdgeSeed#setIdentifiers(Object, Object, DirectedType, MatchedVertex)} with {@code
   * source}, {@code destination}, {@code directed}, {@code matchedVertex}.
   *
   * <ul>
   *   <li>When {@code DESTINATION}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeSeed#setIdentifiers(Object, Object, DirectedType,
   * MatchedVertex)}
   */
  @Test
  @DisplayName(
      "Test setIdentifiers(Object, Object, DirectedType, MatchedVertex) with 'source', 'destination', 'directed', 'matchedVertex'; when 'DESTINATION'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EdgeSeed.setIdentifiers(Object, Object, DirectedType, MatchedVertex)"})
  void testSetIdentifiersWithSourceDestinationDirectedMatchedVertex_whenDestination() {
    // Arrange
    EdgeSeed edgeSeed = new EdgeSeed();

    // Act
    edgeSeed.setIdentifiers(
        "Source", "Destination", DirectedType.UNDIRECTED, MatchedVertex.DESTINATION);

    // Assert
    assertEquals("Destination", edgeSeed.getMatchedVertexValue());
    assertEquals("Destination", edgeSeed.getSource());
    assertEquals("Source", edgeSeed.getAdjacentMatchedVertexValue());
    assertEquals("Source", edgeSeed.getDestination());
  }

  /**
   * Test {@link EdgeSeed#equals(Object)}, and {@link EdgeSeed#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EdgeSeed#equals(Object)}
   *   <li>{@link EdgeSeed#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EdgeSeed.equals(Object)", "int EdgeSeed.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EdgeSeed edgeSeed = new EdgeSeed();
    EdgeSeed edgeSeed2 = new EdgeSeed();

    // Act and Assert
    assertEquals(edgeSeed, edgeSeed2);
    assertEquals(edgeSeed.hashCode(), edgeSeed2.hashCode());
  }

  /**
   * Test {@link EdgeSeed#equals(Object)}, and {@link EdgeSeed#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EdgeSeed#equals(Object)}
   *   <li>{@link EdgeSeed#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EdgeSeed.equals(Object)", "int EdgeSeed.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EdgeSeed edgeSeed = new EdgeSeed();

    // Act and Assert
    assertEquals(edgeSeed, edgeSeed);
    int expectedHashCodeResult = edgeSeed.hashCode();
    assertEquals(expectedHashCodeResult, edgeSeed.hashCode());
  }

  /**
   * Test {@link EdgeSeed#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeSeed#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EdgeSeed.equals(Object)", "int EdgeSeed.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Edge edgeId =
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build();
    EdgeSeed createSeedResult = ElementSeed.createSeed((EdgeId) edgeId);

    // Act and Assert
    assertNotEquals(createSeedResult, new EdgeSeed());
  }

  /**
   * Test {@link EdgeSeed#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeSeed#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EdgeSeed.equals(Object)", "int EdgeSeed.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EdgeSeed(), null);
  }

  /**
   * Test {@link EdgeSeed#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeSeed#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EdgeSeed.equals(Object)", "int EdgeSeed.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EdgeSeed(), "Different type to EdgeSeed");
  }
}
