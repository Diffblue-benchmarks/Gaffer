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

package uk.gov.gchq.gaffer.data.element;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uk.gov.gchq.gaffer.data.element.Edge.Builder;
import uk.gov.gchq.gaffer.data.element.id.DirectedType;
import uk.gov.gchq.gaffer.data.element.id.EdgeId;
import uk.gov.gchq.gaffer.data.element.id.EdgeId.MatchedVertex;

class EdgeDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#dest(Object)}
   *   <li>{@link Builder#directed(boolean)}
   *   <li>{@link Builder#group(String)}
   *   <li>{@link Builder#matchedVertex(MatchedVertex)}
   *   <li>{@link Builder#source(Object)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Edge Builder.build()",
    "Builder Builder.dest(Object)",
    "Builder Builder.directed(boolean)",
    "Builder Builder.group(String)",
    "Builder Builder.matchedVertex(MatchedVertex)",
    "Builder Builder.source(Object)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Edge actualEdge =
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build();

    // Assert
    assertEquals("Dest", actualEdge.getDestination());
    assertEquals("Dest", actualEdge.getAdjacentMatchedVertexValue());
    assertEquals("Group", actualEdge.getGroup());
    assertEquals("Source", actualEdge.getSource());
    assertEquals("Source", actualEdge.getMatchedVertexValue());
    assertEquals("uk.gov.gchq.gaffer.data.element.Edge", actualEdge.getClassName());
    assertEquals(DirectedType.DIRECTED, actualEdge.getDirectedType());
    assertEquals(MatchedVertex.SOURCE, actualEdge.getMatchedVertex());
    assertFalse(actualEdge.isUndirected());
    assertTrue(actualEdge.isDirected());
  }

  /**
   * Test Builder new {@link Builder} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link Builder}
   */
  @Test
  @DisplayName("Test Builder new Builder (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Builder.<init>()"})
  void testBuilderNewBuilder() {
    // Arrange, Act and Assert
    Edge edge = new Builder().build();
    assertEquals("uk.gov.gchq.gaffer.data.element.Edge", edge.getClassName());
    assertNull(edge.getDestination());
    assertNull(edge.getSource());
    assertNull(edge.getAdjacentMatchedVertexValue());
    assertNull(edge.getMatchedVertexValue());
    assertNull(edge.getMatchedVertex());
    assertEquals(DirectedType.UNDIRECTED, edge.getDirectedType());
    assertFalse(edge.isDirected());
    assertTrue(edge.getProperties().isEmpty());
    assertTrue(edge.isUndirected());
    assertEquals(Element.DEFAULT_GROUP, edge.getGroup());
  }

  /**
   * Test Builder {@link Builder#properties(Map)}.
   *
   * <p>Method under test: {@link Builder#properties(Map)}
   */
  @Test
  @DisplayName("Test Builder properties(Map)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.properties(Map)"})
  void testBuilderProperties() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualPropertiesResult = builder.properties(new HashMap<>());

    // Assert
    assertSame(builder, actualPropertiesResult);
  }

  /**
   * Test Builder {@link Builder#property(String, Object)}.
   *
   * <ul>
   *   <li>When {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#property(String, Object)}
   */
  @Test
  @DisplayName("Test Builder property(String, Object); when 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.property(String, Object)"})
  void testBuilderProperty_whenName() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualPropertyResult = builder.property("Name", "Value");

    // Assert
    assertSame(builder, actualPropertyResult);
  }

  /**
   * Test Builder {@link Builder#property(String, Object)}.
   *
   * <ul>
   *   <li>When {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#property(String, Object)}
   */
  @Test
  @DisplayName("Test Builder property(String, Object); when 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.property(String, Object)"})
  void testBuilderProperty_whenName2() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualPropertyResult = builder.property("Name", null);

    // Assert
    assertSame(builder, actualPropertyResult);
  }

  /**
   * Test Builder {@link Builder#property(String, Object)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#property(String, Object)}
   */
  @Test
  @DisplayName("Test Builder property(String, Object); when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.property(String, Object)"})
  void testBuilderProperty_whenNull() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualPropertyResult = builder.property(null, "Value");

    // Assert
    assertSame(builder, actualPropertyResult);
  }

  /**
   * Test {@link Edge#Edge()}.
   *
   * <p>Method under test: {@link Edge#Edge()}
   */
  @Test
  @DisplayName("Test new Edge()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Edge.<init>()"})
  void testNewEdge() {
    // Arrange and Act
    Edge actualEdge = new Edge();

    // Assert
    assertEquals("uk.gov.gchq.gaffer.data.element.Edge", actualEdge.getClassName());
    assertNull(actualEdge.getDestination());
    assertNull(actualEdge.getSource());
    assertNull(actualEdge.getAdjacentMatchedVertexValue());
    assertNull(actualEdge.getMatchedVertexValue());
    assertNull(actualEdge.getMatchedVertex());
    assertEquals(DirectedType.UNDIRECTED, actualEdge.getDirectedType());
    assertFalse(actualEdge.isDirected());
    assertTrue(actualEdge.getProperties().isEmpty());
    assertTrue(actualEdge.isUndirected());
    assertEquals(Element.DEFAULT_GROUP, actualEdge.getGroup());
  }

  /**
   * Test {@link Edge#Edge(String)}.
   *
   * <p>Method under test: {@link Edge#Edge(String)}
   */
  @Test
  @DisplayName("Test new Edge(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Edge.<init>(String)"})
  void testNewEdge2() {
    // Arrange and Act
    Edge actualEdge = new Edge("Group");

    // Assert
    assertEquals("Group", actualEdge.getGroup());
    assertEquals("uk.gov.gchq.gaffer.data.element.Edge", actualEdge.getClassName());
    assertNull(actualEdge.getDestination());
    assertNull(actualEdge.getSource());
    assertNull(actualEdge.getAdjacentMatchedVertexValue());
    assertNull(actualEdge.getMatchedVertexValue());
    assertNull(actualEdge.getMatchedVertex());
    assertEquals(DirectedType.UNDIRECTED, actualEdge.getDirectedType());
    assertFalse(actualEdge.isDirected());
    assertTrue(actualEdge.getProperties().isEmpty());
    assertTrue(actualEdge.isUndirected());
  }

  /**
   * Test {@link Edge#Edge(String, Object, Object, Boolean, DirectedType, MatchedVertex,
   * Properties)}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then return Source byteValue is {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link Edge#Edge(String, Object, Object, Boolean, DirectedType,
   * MatchedVertex, Properties)}
   */
  @Test
  @DisplayName(
      "Test new Edge(String, Object, Object, Boolean, DirectedType, MatchedVertex, Properties); when 'A'; then return Source byteValue is 'A'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Edge.<init>(String, Object, Object, Boolean, DirectedType, MatchedVertex, Properties)"
  })
  void testNewEdge_whenA_thenReturnSourceByteValueIsA() {
    // Arrange and Act
    Edge actualEdge =
        new Edge(
            "Group",
            (byte) 'A',
            "Destination",
            null,
            DirectedType.UNDIRECTED,
            MatchedVertex.SOURCE,
            new Properties());

    // Assert
    assertEquals('A', ((Byte) actualEdge.getSource()).byteValue());
    assertEquals('A', ((Byte) actualEdge.getMatchedVertexValue()).byteValue());
  }

  /**
   * Test {@link Edge#Edge(String, Object, Object, boolean)}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then return Source byteValue is {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link Edge#Edge(String, Object, Object, boolean)}
   */
  @Test
  @DisplayName(
      "Test new Edge(String, Object, Object, boolean); when 'A'; then return Source byteValue is 'A'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Edge.<init>(String, Object, Object, boolean)"})
  void testNewEdge_whenA_thenReturnSourceByteValueIsA2() {
    // Arrange and Act
    Edge actualEdge = new Edge("Group", (byte) 'A', "Destination", false);

    // Assert
    assertEquals('A', ((Byte) actualEdge.getSource()).byteValue());
    assertEquals('A', ((Byte) actualEdge.getMatchedVertexValue()).byteValue());
  }

  /**
   * Test {@link Edge#Edge(String, Object, Object, boolean, MatchedVertex, Properties)}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then return Source byteValue is {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link Edge#Edge(String, Object, Object, boolean, MatchedVertex,
   * Properties)}
   */
  @Test
  @DisplayName(
      "Test new Edge(String, Object, Object, boolean, MatchedVertex, Properties); when 'A'; then return Source byteValue is 'A'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Edge.<init>(String, Object, Object, boolean, MatchedVertex, Properties)"
  })
  void testNewEdge_whenA_thenReturnSourceByteValueIsA3() {
    // Arrange and Act
    Edge actualEdge =
        new Edge("Group", (byte) 'A', "Destination", false, MatchedVertex.SOURCE, new Properties());

    // Assert
    assertEquals('A', ((Byte) actualEdge.getSource()).byteValue());
    assertEquals('A', ((Byte) actualEdge.getMatchedVertexValue()).byteValue());
  }

  /**
   * Test {@link Edge#Edge(String, Object, Object, Boolean, DirectedType, MatchedVertex,
   * Properties)}.
   *
   * <ul>
   *   <li>When {@code DESTINATION}.
   *   <li>Then return MatchedVertexValue is {@code Destination}.
   * </ul>
   *
   * <p>Method under test: {@link Edge#Edge(String, Object, Object, Boolean, DirectedType,
   * MatchedVertex, Properties)}
   */
  @Test
  @DisplayName(
      "Test new Edge(String, Object, Object, Boolean, DirectedType, MatchedVertex, Properties); when 'DESTINATION'; then return MatchedVertexValue is 'Destination'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Edge.<init>(String, Object, Object, Boolean, DirectedType, MatchedVertex, Properties)"
  })
  void testNewEdge_whenDestination_thenReturnMatchedVertexValueIsDestination() {
    // Arrange and Act
    Edge actualEdge =
        new Edge(
            "Group",
            "Source",
            "Destination",
            null,
            DirectedType.UNDIRECTED,
            MatchedVertex.DESTINATION,
            new Properties());

    // Assert
    assertEquals("Destination", actualEdge.getMatchedVertexValue());
    assertEquals("Source", actualEdge.getAdjacentMatchedVertexValue());
  }

  /**
   * Test {@link Edge#Edge(String, Object, Object, boolean, MatchedVertex, Properties)}.
   *
   * <ul>
   *   <li>When {@code DESTINATION}.
   *   <li>Then return Source is {@code Destination}.
   * </ul>
   *
   * <p>Method under test: {@link Edge#Edge(String, Object, Object, boolean, MatchedVertex,
   * Properties)}
   */
  @Test
  @DisplayName(
      "Test new Edge(String, Object, Object, boolean, MatchedVertex, Properties); when 'DESTINATION'; then return Source is 'Destination'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Edge.<init>(String, Object, Object, boolean, MatchedVertex, Properties)"
  })
  void testNewEdge_whenDestination_thenReturnSourceIsDestination() {
    // Arrange and Act
    Edge actualEdge =
        new Edge(
            "Group", "Source", "Destination", false, MatchedVertex.DESTINATION, new Properties());

    // Assert
    assertEquals("Destination", actualEdge.getSource());
    assertEquals("Destination", actualEdge.getMatchedVertexValue());
    assertEquals("Source", actualEdge.getDestination());
    assertEquals("Source", actualEdge.getAdjacentMatchedVertexValue());
  }

  /**
   * Test {@link Edge#Edge(String, Object, Object, Boolean, DirectedType, MatchedVertex,
   * Properties)}.
   *
   * <ul>
   *   <li>When {@code EITHER}.
   *   <li>Then return {@code Source}.
   * </ul>
   *
   * <p>Method under test: {@link Edge#Edge(String, Object, Object, Boolean, DirectedType,
   * MatchedVertex, Properties)}
   */
  @Test
  @DisplayName(
      "Test new Edge(String, Object, Object, Boolean, DirectedType, MatchedVertex, Properties); when 'EITHER'; then return 'Source'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Edge.<init>(String, Object, Object, Boolean, DirectedType, MatchedVertex, Properties)"
  })
  void testNewEdge_whenEither_thenReturnSource() {
    // Arrange and Act
    Edge actualEdge =
        new Edge(
            "Group",
            "Source",
            "Destination",
            null,
            DirectedType.EITHER,
            MatchedVertex.SOURCE,
            new Properties());

    // Assert
    assertEquals("Source", actualEdge.getSource());
    assertEquals(DirectedType.DIRECTED, actualEdge.getDirectedType());
    assertFalse(actualEdge.isUndirected());
    assertTrue(actualEdge.isDirected());
  }

  /**
   * Test {@link Edge#Edge(String, Object, Object, Boolean, DirectedType, MatchedVertex,
   * Properties)}.
   *
   * <ul>
   *   <li>When {@code EITHER}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link Edge#Edge(String, Object, Object, Boolean, DirectedType,
   * MatchedVertex, Properties)}
   */
  @Test
  @DisplayName(
      "Test new Edge(String, Object, Object, Boolean, DirectedType, MatchedVertex, Properties); when 'EITHER'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Edge.<init>(String, Object, Object, Boolean, DirectedType, MatchedVertex, Properties)"
  })
  void testNewEdge_whenEither_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new Edge(
                "Group",
                "Source",
                "Destination",
                true,
                DirectedType.EITHER,
                MatchedVertex.SOURCE,
                new Properties()));
  }

  /**
   * Test {@link Edge#Edge(String, Object, Object, boolean, MatchedVertex, Properties)}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then return MatchedVertexValue is {@code Source}.
   * </ul>
   *
   * <p>Method under test: {@link Edge#Edge(String, Object, Object, boolean, MatchedVertex,
   * Properties)}
   */
  @Test
  @DisplayName(
      "Test new Edge(String, Object, Object, boolean, MatchedVertex, Properties); when 'false'; then return MatchedVertexValue is 'Source'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Edge.<init>(String, Object, Object, boolean, MatchedVertex, Properties)"
  })
  void testNewEdge_whenFalse_thenReturnMatchedVertexValueIsSource() {
    // Arrange and Act
    Edge actualEdge =
        new Edge("Group", "Source", "Destination", false, MatchedVertex.SOURCE, new Properties());

    // Assert
    assertEquals("Destination", actualEdge.getSource());
    assertEquals("Source", actualEdge.getDestination());
    assertEquals("Source", actualEdge.getMatchedVertexValue());
    assertEquals(MatchedVertex.DESTINATION, actualEdge.getMatchedVertex());
  }

  /**
   * Test {@link Edge#Edge(String, Object, Object, boolean, MatchedVertex, Properties)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return MatchedVertex is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Edge#Edge(String, Object, Object, boolean, MatchedVertex,
   * Properties)}
   */
  @Test
  @DisplayName(
      "Test new Edge(String, Object, Object, boolean, MatchedVertex, Properties); when 'null'; then return MatchedVertex is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Edge.<init>(String, Object, Object, boolean, MatchedVertex, Properties)"
  })
  void testNewEdge_whenNull_thenReturnMatchedVertexIsNull() {
    // Arrange and Act
    Edge actualEdge = new Edge("Group", "Source", "Destination", false, null, new Properties());

    // Assert
    assertEquals("Destination", actualEdge.getMatchedVertexValue());
    assertEquals("Source", actualEdge.getAdjacentMatchedVertexValue());
    assertNull(actualEdge.getMatchedVertex());
  }

  /**
   * Test {@link Edge#Edge(String, Object, Object, Boolean, DirectedType, MatchedVertex,
   * Properties)}.
   *
   * <ul>
   *   <li>When {@code SOURCE}.
   *   <li>Then return {@code Source}.
   * </ul>
   *
   * <p>Method under test: {@link Edge#Edge(String, Object, Object, Boolean, DirectedType,
   * MatchedVertex, Properties)}
   */
  @Test
  @DisplayName(
      "Test new Edge(String, Object, Object, Boolean, DirectedType, MatchedVertex, Properties); when 'SOURCE'; then return 'Source'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Edge.<init>(String, Object, Object, Boolean, DirectedType, MatchedVertex, Properties)"
  })
  void testNewEdge_whenSource_thenReturnSource() {
    // Arrange and Act
    Edge actualEdge =
        new Edge(
            "Group", "Source", "Destination", null, null, MatchedVertex.SOURCE, new Properties());

    // Assert
    assertEquals("Source", actualEdge.getSource());
    assertEquals(DirectedType.DIRECTED, actualEdge.getDirectedType());
    assertFalse(actualEdge.isUndirected());
    assertTrue(actualEdge.isDirected());
  }

  /**
   * Test {@link Edge#Edge(String, Object, Object, boolean)}.
   *
   * <ul>
   *   <li>When {@code Source}.
   *   <li>Then return Source is {@code Destination}.
   * </ul>
   *
   * <p>Method under test: {@link Edge#Edge(String, Object, Object, boolean)}
   */
  @Test
  @DisplayName(
      "Test new Edge(String, Object, Object, boolean); when 'Source'; then return Source is 'Destination'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Edge.<init>(String, Object, Object, boolean)"})
  void testNewEdge_whenSource_thenReturnSourceIsDestination() {
    // Arrange and Act
    Edge actualEdge = new Edge("Group", "Source", "Destination", false);

    // Assert
    assertEquals("Destination", actualEdge.getSource());
    assertEquals("Destination", actualEdge.getMatchedVertexValue());
    assertEquals("Source", actualEdge.getDestination());
    assertEquals("Source", actualEdge.getAdjacentMatchedVertexValue());
  }

  /**
   * Test {@link Edge#Edge(String, Object, Object, Boolean, DirectedType, MatchedVertex,
   * Properties)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then return Properties Empty.
   * </ul>
   *
   * <p>Method under test: {@link Edge#Edge(String, Object, Object, Boolean, DirectedType,
   * MatchedVertex, Properties)}
   */
  @Test
  @DisplayName(
      "Test new Edge(String, Object, Object, Boolean, DirectedType, MatchedVertex, Properties); when 'true'; then return Properties Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Edge.<init>(String, Object, Object, Boolean, DirectedType, MatchedVertex, Properties)"
  })
  void testNewEdge_whenTrue_thenReturnPropertiesEmpty() {
    // Arrange and Act
    Edge actualEdge =
        new Edge("Group", "Source", "Destination", true, null, MatchedVertex.SOURCE, null);

    // Assert
    assertEquals("Source", actualEdge.getSource());
    assertEquals(DirectedType.DIRECTED, actualEdge.getDirectedType());
    assertFalse(actualEdge.isUndirected());
    assertTrue(actualEdge.getProperties().isEmpty());
    assertTrue(actualEdge.isDirected());
  }

  /**
   * Test {@link Edge#Edge(String, Object, Object, boolean, MatchedVertex, Properties)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then return Properties Empty.
   * </ul>
   *
   * <p>Method under test: {@link Edge#Edge(String, Object, Object, boolean, MatchedVertex,
   * Properties)}
   */
  @Test
  @DisplayName(
      "Test new Edge(String, Object, Object, boolean, MatchedVertex, Properties); when 'true'; then return Properties Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Edge.<init>(String, Object, Object, boolean, MatchedVertex, Properties)"
  })
  void testNewEdge_whenTrue_thenReturnPropertiesEmpty2() {
    // Arrange and Act
    Edge actualEdge = new Edge("Group", "Source", "Destination", true, MatchedVertex.SOURCE, null);

    // Assert
    assertEquals("Source", actualEdge.getSource());
    assertEquals(DirectedType.DIRECTED, actualEdge.getDirectedType());
    assertFalse(actualEdge.isUndirected());
    assertTrue(actualEdge.getProperties().isEmpty());
    assertTrue(actualEdge.isDirected());
  }

  /**
   * Test {@link Edge#Edge(String, Object, Object, Boolean, DirectedType, MatchedVertex,
   * Properties)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then return {@code Source}.
   * </ul>
   *
   * <p>Method under test: {@link Edge#Edge(String, Object, Object, Boolean, DirectedType,
   * MatchedVertex, Properties)}
   */
  @Test
  @DisplayName(
      "Test new Edge(String, Object, Object, Boolean, DirectedType, MatchedVertex, Properties); when 'true'; then return 'Source'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Edge.<init>(String, Object, Object, Boolean, DirectedType, MatchedVertex, Properties)"
  })
  void testNewEdge_whenTrue_thenReturnSource() {
    // Arrange and Act
    Edge actualEdge =
        new Edge(
            "Group", "Source", "Destination", true, null, MatchedVertex.SOURCE, new Properties());

    // Assert
    assertEquals("Source", actualEdge.getSource());
    assertEquals(DirectedType.DIRECTED, actualEdge.getDirectedType());
    assertFalse(actualEdge.isUndirected());
    assertTrue(actualEdge.isDirected());
  }

  /**
   * Test {@link Edge#Edge(String, Object, Object, boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then return {@code Source}.
   * </ul>
   *
   * <p>Method under test: {@link Edge#Edge(String, Object, Object, boolean)}
   */
  @Test
  @DisplayName("Test new Edge(String, Object, Object, boolean); when 'true'; then return 'Source'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Edge.<init>(String, Object, Object, boolean)"})
  void testNewEdge_whenTrue_thenReturnSource2() {
    // Arrange and Act
    Edge actualEdge = new Edge("Group", "Source", "Destination", true);

    // Assert
    assertEquals("Source", actualEdge.getSource());
    assertEquals("Source", actualEdge.getMatchedVertexValue());
    assertEquals(DirectedType.DIRECTED, actualEdge.getDirectedType());
    assertFalse(actualEdge.isUndirected());
    assertTrue(actualEdge.isDirected());
  }

  /**
   * Test {@link Edge#Edge(String, Object, Object, boolean, MatchedVertex, Properties)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then return {@code Source}.
   * </ul>
   *
   * <p>Method under test: {@link Edge#Edge(String, Object, Object, boolean, MatchedVertex,
   * Properties)}
   */
  @Test
  @DisplayName(
      "Test new Edge(String, Object, Object, boolean, MatchedVertex, Properties); when 'true'; then return 'Source'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Edge.<init>(String, Object, Object, boolean, MatchedVertex, Properties)"
  })
  void testNewEdge_whenTrue_thenReturnSource3() {
    // Arrange and Act
    Edge actualEdge =
        new Edge("Group", "Source", "Destination", true, MatchedVertex.SOURCE, new Properties());

    // Assert
    assertEquals("Source", actualEdge.getSource());
    assertEquals(DirectedType.DIRECTED, actualEdge.getDirectedType());
    assertFalse(actualEdge.isUndirected());
    assertTrue(actualEdge.isDirected());
  }

  /**
   * Test {@link Edge#Edge(String, Object, Object, Boolean, DirectedType, MatchedVertex,
   * Properties)}.
   *
   * <ul>
   *   <li>When {@link DirectedType#UNDIRECTED}.
   *   <li>Then return DirectedType is {@code UNDIRECTED}.
   * </ul>
   *
   * <p>Method under test: {@link Edge#Edge(String, Object, Object, Boolean, DirectedType,
   * MatchedVertex, Properties)}
   */
  @Test
  @DisplayName(
      "Test new Edge(String, Object, Object, Boolean, DirectedType, MatchedVertex, Properties); when UNDIRECTED; then return DirectedType is 'UNDIRECTED'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Edge.<init>(String, Object, Object, Boolean, DirectedType, MatchedVertex, Properties)"
  })
  void testNewEdge_whenUndirected_thenReturnDirectedTypeIsUndirected() {
    // Arrange and Act
    Edge actualEdge =
        new Edge(
            "Group",
            "Source",
            "Destination",
            null,
            DirectedType.UNDIRECTED,
            MatchedVertex.SOURCE,
            new Properties());

    // Assert
    assertEquals(DirectedType.UNDIRECTED, actualEdge.getDirectedType());
    assertEquals(MatchedVertex.DESTINATION, actualEdge.getMatchedVertex());
    assertFalse(actualEdge.isDirected());
    assertTrue(actualEdge.isUndirected());
  }

  /**
   * Test {@link Edge#Edge(String, Object, Object, Boolean, DirectedType, MatchedVertex,
   * Properties)}.
   *
   * <ul>
   *   <li>When {@link DirectedType#UNDIRECTED}.
   *   <li>Then return MatchedVertex is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Edge#Edge(String, Object, Object, Boolean, DirectedType,
   * MatchedVertex, Properties)}
   */
  @Test
  @DisplayName(
      "Test new Edge(String, Object, Object, Boolean, DirectedType, MatchedVertex, Properties); when UNDIRECTED; then return MatchedVertex is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Edge.<init>(String, Object, Object, Boolean, DirectedType, MatchedVertex, Properties)"
  })
  void testNewEdge_whenUndirected_thenReturnMatchedVertexIsNull() {
    // Arrange and Act
    Edge actualEdge =
        new Edge(
            "Group",
            "Source",
            "Destination",
            null,
            DirectedType.UNDIRECTED,
            null,
            new Properties());

    // Assert
    assertEquals("Destination", actualEdge.getMatchedVertexValue());
    assertEquals("Source", actualEdge.getAdjacentMatchedVertexValue());
    assertNull(actualEdge.getMatchedVertex());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Edge#toString()}
   *   <li>{@link Edge#getDestination()}
   *   <li>{@link Edge#getMatchedVertex()}
   *   <li>{@link Edge#getSource()}
   *   <li>{@link Edge#isDirected()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object Edge.getDestination()",
    "MatchedVertex Edge.getMatchedVertex()",
    "Object Edge.getSource()",
    "boolean Edge.isDirected()",
    "String Edge.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    Edge edge =
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build();

    // Act
    String actualToStringResult = edge.toString();
    Object actualDestination = edge.getDestination();
    MatchedVertex actualMatchedVertex = edge.getMatchedVertex();
    Object actualSource = edge.getSource();

    // Assert
    assertEquals("Dest", actualDestination);
    assertEquals(
        "Edge[source=Source,destination=Dest,directed=true,matchedVertex=SOURCE,group=Group,properties"
            + "=Properties[]]",
        actualToStringResult);
    assertEquals("Source", actualSource);
    assertEquals(MatchedVertex.SOURCE, actualMatchedVertex);
    assertTrue(edge.isDirected());
  }

  /**
   * Test {@link Edge#getDirectedType()}.
   *
   * <ul>
   *   <li>Given {@link Edge#Edge()}.
   *   <li>Then return {@code UNDIRECTED}.
   * </ul>
   *
   * <p>Method under test: {@link Edge#getDirectedType()}
   */
  @Test
  @DisplayName("Test getDirectedType(); given Edge(); then return 'UNDIRECTED'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DirectedType Edge.getDirectedType()"})
  void testGetDirectedType_givenEdge_thenReturnUndirected() {
    // Arrange, Act and Assert
    assertEquals(DirectedType.UNDIRECTED, new Edge().getDirectedType());
  }

  /**
   * Test {@link Edge#getDirectedType()}.
   *
   * <ul>
   *   <li>Then return {@code DIRECTED}.
   * </ul>
   *
   * <p>Method under test: {@link Edge#getDirectedType()}
   */
  @Test
  @DisplayName("Test getDirectedType(); then return 'DIRECTED'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DirectedType Edge.getDirectedType()"})
  void testGetDirectedType_thenReturnDirected() {
    // Arrange, Act and Assert
    assertEquals(
        DirectedType.DIRECTED,
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build()
            .getDirectedType());
  }

  /**
   * Test {@link Edge#getIdentifier(IdentifierType)}.
   *
   * <ul>
   *   <li>Given {@link Edge#Edge()}.
   *   <li>When {@code ADJACENT_MATCHED_VERTEX}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Edge#getIdentifier(IdentifierType)}
   */
  @Test
  @DisplayName(
      "Test getIdentifier(IdentifierType); given Edge(); when 'ADJACENT_MATCHED_VERTEX'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object Edge.getIdentifier(IdentifierType)"})
  void testGetIdentifier_givenEdge_whenAdjacentMatchedVertex_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new Edge().getIdentifier(IdentifierType.ADJACENT_MATCHED_VERTEX));
  }

  /**
   * Test {@link Edge#getIdentifier(IdentifierType)}.
   *
   * <ul>
   *   <li>Given {@link Edge#Edge()}.
   *   <li>When {@code DESTINATION}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Edge#getIdentifier(IdentifierType)}
   */
  @Test
  @DisplayName(
      "Test getIdentifier(IdentifierType); given Edge(); when 'DESTINATION'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object Edge.getIdentifier(IdentifierType)"})
  void testGetIdentifier_givenEdge_whenDestination_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new Edge().getIdentifier(IdentifierType.DESTINATION));
  }

  /**
   * Test {@link Edge#getIdentifier(IdentifierType)}.
   *
   * <ul>
   *   <li>Given {@link Edge#Edge()}.
   *   <li>When {@code DIRECTED}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Edge#getIdentifier(IdentifierType)}
   */
  @Test
  @DisplayName(
      "Test getIdentifier(IdentifierType); given Edge(); when 'DIRECTED'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object Edge.getIdentifier(IdentifierType)"})
  void testGetIdentifier_givenEdge_whenDirected_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((Boolean) new Edge().getIdentifier(IdentifierType.DIRECTED));
  }

  /**
   * Test {@link Edge#getIdentifier(IdentifierType)}.
   *
   * <ul>
   *   <li>Given {@link Edge#Edge()}.
   *   <li>When {@code GROUP}.
   *   <li>Then return {@link Element#DEFAULT_GROUP}.
   * </ul>
   *
   * <p>Method under test: {@link Edge#getIdentifier(IdentifierType)}
   */
  @Test
  @DisplayName(
      "Test getIdentifier(IdentifierType); given Edge(); when 'GROUP'; then return DEFAULT_GROUP")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object Edge.getIdentifier(IdentifierType)"})
  void testGetIdentifier_givenEdge_whenGroup_thenReturnDefault_group() {
    // Arrange, Act and Assert
    assertEquals(Element.DEFAULT_GROUP, new Edge().getIdentifier(IdentifierType.GROUP));
  }

  /**
   * Test {@link Edge#getIdentifier(IdentifierType)}.
   *
   * <ul>
   *   <li>Given {@link Edge#Edge()}.
   *   <li>When {@code MATCHED_VERTEX}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Edge#getIdentifier(IdentifierType)}
   */
  @Test
  @DisplayName(
      "Test getIdentifier(IdentifierType); given Edge(); when 'MATCHED_VERTEX'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object Edge.getIdentifier(IdentifierType)"})
  void testGetIdentifier_givenEdge_whenMatchedVertex_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new Edge().getIdentifier(IdentifierType.MATCHED_VERTEX));
  }

  /**
   * Test {@link Edge#getIdentifier(IdentifierType)}.
   *
   * <ul>
   *   <li>Given {@link Edge#Edge()}.
   *   <li>When {@code SOURCE}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Edge#getIdentifier(IdentifierType)}
   */
  @Test
  @DisplayName(
      "Test getIdentifier(IdentifierType); given Edge(); when 'SOURCE'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object Edge.getIdentifier(IdentifierType)"})
  void testGetIdentifier_givenEdge_whenSource_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new Edge().getIdentifier(IdentifierType.SOURCE));
  }

  /**
   * Test {@link Edge#getIdentifier(IdentifierType)}.
   *
   * <ul>
   *   <li>Given {@link Edge#Edge()}.
   *   <li>When {@code VERTEX}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Edge#getIdentifier(IdentifierType)}
   */
  @Test
  @DisplayName(
      "Test getIdentifier(IdentifierType); given Edge(); when 'VERTEX'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object Edge.getIdentifier(IdentifierType)"})
  void testGetIdentifier_givenEdge_whenVertex_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new Edge().getIdentifier(IdentifierType.VERTEX));
  }

  /**
   * Test {@link Edge#getIdentifier(IdentifierType)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Edge#getIdentifier(IdentifierType)}
   */
  @Test
  @DisplayName("Test getIdentifier(IdentifierType); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object Edge.getIdentifier(IdentifierType)"})
  void testGetIdentifier_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(
        (Boolean)
            new Builder()
                .dest("Dest")
                .directed(true)
                .group("Group")
                .matchedVertex(MatchedVertex.SOURCE)
                .source("Source")
                .build()
                .getIdentifier(IdentifierType.DIRECTED));
  }

  /**
   * Test {@link Edge#putIdentifier(IdentifierType, Object)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then {@link Edge#Edge()} DirectedType is {@code UNDIRECTED}.
   * </ul>
   *
   * <p>Method under test: {@link Edge#putIdentifier(IdentifierType, Object)}
   */
  @Test
  @DisplayName(
      "Test putIdentifier(IdentifierType, Object); when '42'; then Edge() DirectedType is 'UNDIRECTED'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Edge.putIdentifier(IdentifierType, Object)"})
  void testPutIdentifier_when42_thenEdgeDirectedTypeIsUndirected() {
    // Arrange
    Edge edge = new Edge();

    // Act
    edge.putIdentifier(IdentifierType.DIRECTED, "42");

    // Assert that nothing has changed
    assertEquals(DirectedType.UNDIRECTED, edge.getDirectedType());
    assertFalse(edge.isDirected());
    assertTrue(edge.isUndirected());
    assertEquals(Element.DEFAULT_GROUP, edge.getGroup());
  }

  /**
   * Test {@link Edge#putIdentifier(IdentifierType, Object)}.
   *
   * <ul>
   *   <li>When {@code DESTINATION}.
   *   <li>Then {@link Edge#Edge()} Destination {@link DirectedType}.
   * </ul>
   *
   * <p>Method under test: {@link Edge#putIdentifier(IdentifierType, Object)}
   */
  @Test
  @DisplayName(
      "Test putIdentifier(IdentifierType, Object); when 'DESTINATION'; then Edge() Destination DirectedType")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Edge.putIdentifier(IdentifierType, Object)"})
  void testPutIdentifier_whenDestination_thenEdgeDestinationDirectedType() {
    // Arrange
    Edge edge = new Edge();

    // Act
    edge.putIdentifier(IdentifierType.DESTINATION, DirectedType.UNDIRECTED);

    // Assert
    Object destination = edge.getDestination();
    assertTrue(destination instanceof DirectedType);
    Object adjacentMatchedVertexValue = edge.getAdjacentMatchedVertexValue();
    assertTrue(adjacentMatchedVertexValue instanceof DirectedType);
    assertEquals(DirectedType.UNDIRECTED, destination);
    assertEquals(DirectedType.UNDIRECTED, adjacentMatchedVertexValue);
  }

  /**
   * Test {@link Edge#putIdentifier(IdentifierType, Object)}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then {@link Edge#Edge()} DirectedType is {@code UNDIRECTED}.
   * </ul>
   *
   * <p>Method under test: {@link Edge#putIdentifier(IdentifierType, Object)}
   */
  @Test
  @DisplayName(
      "Test putIdentifier(IdentifierType, Object); when 'false'; then Edge() DirectedType is 'UNDIRECTED'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Edge.putIdentifier(IdentifierType, Object)"})
  void testPutIdentifier_whenFalse_thenEdgeDirectedTypeIsUndirected() {
    // Arrange
    Edge edge = new Edge();

    // Act
    edge.putIdentifier(IdentifierType.DIRECTED, false);

    // Assert that nothing has changed
    assertEquals(DirectedType.UNDIRECTED, edge.getDirectedType());
    assertFalse(edge.isDirected());
    assertTrue(edge.isUndirected());
    assertEquals(Element.DEFAULT_GROUP, edge.getGroup());
  }

  /**
   * Test {@link Edge#putIdentifier(IdentifierType, Object)}.
   *
   * <ul>
   *   <li>When {@code GROUP}.
   *   <li>Then {@link Edge#Edge()} Group is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link Edge#putIdentifier(IdentifierType, Object)}
   */
  @Test
  @DisplayName(
      "Test putIdentifier(IdentifierType, Object); when 'GROUP'; then Edge() Group is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Edge.putIdentifier(IdentifierType, Object)"})
  void testPutIdentifier_whenGroup_thenEdgeGroupIs42() {
    // Arrange
    Edge edge = new Edge();

    // Act
    edge.putIdentifier(IdentifierType.GROUP, "42");

    // Assert
    assertEquals("42", edge.getGroup());
    assertEquals(DirectedType.UNDIRECTED, edge.getDirectedType());
    assertFalse(edge.isDirected());
    assertTrue(edge.isUndirected());
  }

  /**
   * Test {@link Edge#putIdentifier(IdentifierType, Object)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link Edge#Edge()} DirectedType is {@code UNDIRECTED}.
   * </ul>
   *
   * <p>Method under test: {@link Edge#putIdentifier(IdentifierType, Object)}
   */
  @Test
  @DisplayName(
      "Test putIdentifier(IdentifierType, Object); when 'null'; then Edge() DirectedType is 'UNDIRECTED'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Edge.putIdentifier(IdentifierType, Object)"})
  void testPutIdentifier_whenNull_thenEdgeDirectedTypeIsUndirected() {
    // Arrange
    Edge edge = new Edge();

    // Act
    edge.putIdentifier(IdentifierType.DIRECTED, null);

    // Assert that nothing has changed
    assertEquals(DirectedType.UNDIRECTED, edge.getDirectedType());
    assertFalse(edge.isDirected());
    assertTrue(edge.isUndirected());
    assertEquals(Element.DEFAULT_GROUP, edge.getGroup());
  }

  /**
   * Test {@link Edge#putIdentifier(IdentifierType, Object)}.
   *
   * <ul>
   *   <li>When {@code SOURCE}.
   *   <li>Then {@link Edge#Edge()} Source {@link DirectedType}.
   * </ul>
   *
   * <p>Method under test: {@link Edge#putIdentifier(IdentifierType, Object)}
   */
  @Test
  @DisplayName(
      "Test putIdentifier(IdentifierType, Object); when 'SOURCE'; then Edge() Source DirectedType")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Edge.putIdentifier(IdentifierType, Object)"})
  void testPutIdentifier_whenSource_thenEdgeSourceDirectedType() {
    // Arrange
    Edge edge = new Edge();

    // Act
    edge.putIdentifier(IdentifierType.SOURCE, DirectedType.UNDIRECTED);

    // Assert
    Object source = edge.getSource();
    assertTrue(source instanceof DirectedType);
    Object matchedVertexValue = edge.getMatchedVertexValue();
    assertTrue(matchedVertexValue instanceof DirectedType);
    assertEquals(DirectedType.UNDIRECTED, source);
    assertEquals(DirectedType.UNDIRECTED, matchedVertexValue);
  }

  /**
   * Test {@link Edge#putIdentifier(IdentifierType, Object)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then {@link Edge#Edge()} DirectedType is {@code DIRECTED}.
   * </ul>
   *
   * <p>Method under test: {@link Edge#putIdentifier(IdentifierType, Object)}
   */
  @Test
  @DisplayName(
      "Test putIdentifier(IdentifierType, Object); when 'true'; then Edge() DirectedType is 'DIRECTED'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Edge.putIdentifier(IdentifierType, Object)"})
  void testPutIdentifier_whenTrue_thenEdgeDirectedTypeIsDirected() {
    // Arrange
    Edge edge = new Edge();

    // Act
    edge.putIdentifier(IdentifierType.DIRECTED, true);

    // Assert
    assertEquals(DirectedType.DIRECTED, edge.getDirectedType());
    assertFalse(edge.isUndirected());
    assertTrue(edge.isDirected());
    assertEquals(Element.DEFAULT_GROUP, edge.getGroup());
  }

  /**
   * Test {@link Edge#putIdentifier(IdentifierType, Object)}.
   *
   * <ul>
   *   <li>When {@link DirectedType#UNDIRECTED}.
   *   <li>Then {@link Edge#Edge()} DirectedType is {@code UNDIRECTED}.
   * </ul>
   *
   * <p>Method under test: {@link Edge#putIdentifier(IdentifierType, Object)}
   */
  @Test
  @DisplayName(
      "Test putIdentifier(IdentifierType, Object); when UNDIRECTED; then Edge() DirectedType is 'UNDIRECTED'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Edge.putIdentifier(IdentifierType, Object)"})
  void testPutIdentifier_whenUndirected_thenEdgeDirectedTypeIsUndirected() {
    // Arrange
    Edge edge = new Edge();

    // Act
    edge.putIdentifier(IdentifierType.DIRECTED, DirectedType.UNDIRECTED);

    // Assert that nothing has changed
    assertEquals(DirectedType.UNDIRECTED, edge.getDirectedType());
    assertFalse(edge.isDirected());
    assertTrue(edge.isUndirected());
    assertEquals(Element.DEFAULT_GROUP, edge.getGroup());
  }

  /**
   * Test {@link Edge#putIdentifier(IdentifierType, Object)}.
   *
   * <ul>
   *   <li>When {@code VERTEX}.
   *   <li>Then {@link Edge#Edge()} DirectedType is {@code UNDIRECTED}.
   * </ul>
   *
   * <p>Method under test: {@link Edge#putIdentifier(IdentifierType, Object)}
   */
  @Test
  @DisplayName(
      "Test putIdentifier(IdentifierType, Object); when 'VERTEX'; then Edge() DirectedType is 'UNDIRECTED'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Edge.putIdentifier(IdentifierType, Object)"})
  void testPutIdentifier_whenVertex_thenEdgeDirectedTypeIsUndirected() {
    // Arrange
    Edge edge = new Edge();

    // Act
    edge.putIdentifier(IdentifierType.VERTEX, "Value");

    // Assert that nothing has changed
    assertEquals(DirectedType.UNDIRECTED, edge.getDirectedType());
    assertFalse(edge.isDirected());
    assertTrue(edge.isUndirected());
    assertEquals(Element.DEFAULT_GROUP, edge.getGroup());
  }

  /**
   * Test {@link Edge#setIdentifiers(Object, Object, boolean)} with {@code source}, {@code
   * destination}, {@code directed}.
   *
   * <p>Method under test: {@link Edge#setIdentifiers(Object, Object, boolean)}
   */
  @Test
  @DisplayName(
      "Test setIdentifiers(Object, Object, boolean) with 'source', 'destination', 'directed'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Edge.setIdentifiers(Object, Object, boolean)"})
  void testSetIdentifiersWithSourceDestinationDirected() {
    // Arrange
    Edge edge =
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build();

    // Act
    edge.setIdentifiers("Source", "Destination", false);

    // Assert
    assertEquals("Source", edge.getMatchedVertexValue());
    assertEquals(DirectedType.UNDIRECTED, edge.getDirectedType());
    assertEquals(MatchedVertex.DESTINATION, edge.getMatchedVertex());
    assertFalse(edge.isDirected());
    assertTrue(edge.isUndirected());
  }

  /**
   * Test {@link Edge#setIdentifiers(Object, Object, boolean)} with {@code source}, {@code
   * destination}, {@code directed}.
   *
   * <p>Method under test: {@link Edge#setIdentifiers(Object, Object, boolean)}
   */
  @Test
  @DisplayName(
      "Test setIdentifiers(Object, Object, boolean) with 'source', 'destination', 'directed'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Edge.setIdentifiers(Object, Object, boolean)"})
  void testSetIdentifiersWithSourceDestinationDirected2() {
    // Arrange
    Edge edge =
        new Builder()
            .dest("Dest")
            .directed(false)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build();

    // Act
    edge.setIdentifiers("Source", "Destination", false);

    // Assert
    assertEquals("Destination", edge.getMatchedVertexValue());
    assertEquals("Source", edge.getDestination());
    assertEquals("Source", edge.getAdjacentMatchedVertexValue());
    assertEquals(MatchedVertex.SOURCE, edge.getMatchedVertex());
  }

  /**
   * Test {@link Edge#setIdentifiers(Object, Object, boolean, MatchedVertex)} with {@code source},
   * {@code destination}, {@code directed}, {@code matchedVertex}.
   *
   * <p>Method under test: {@link Edge#setIdentifiers(Object, Object, boolean, MatchedVertex)}
   */
  @Test
  @DisplayName(
      "Test setIdentifiers(Object, Object, boolean, MatchedVertex) with 'source', 'destination', 'directed', 'matchedVertex'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Edge.setIdentifiers(Object, Object, boolean, MatchedVertex)"})
  void testSetIdentifiersWithSourceDestinationDirectedMatchedVertex() {
    // Arrange
    Edge edge = new Edge();

    // Act
    edge.setIdentifiers("Source", "Destination", true, MatchedVertex.SOURCE);

    // Assert
    assertEquals("Source", edge.getSource());
    assertEquals(DirectedType.DIRECTED, edge.getDirectedType());
    assertFalse(edge.isUndirected());
    assertTrue(edge.isDirected());
  }

  /**
   * Test {@link Edge#setIdentifiers(Object, Object, boolean, MatchedVertex)} with {@code source},
   * {@code destination}, {@code directed}, {@code matchedVertex}.
   *
   * <p>Method under test: {@link Edge#setIdentifiers(Object, Object, boolean, MatchedVertex)}
   */
  @Test
  @DisplayName(
      "Test setIdentifiers(Object, Object, boolean, MatchedVertex) with 'source', 'destination', 'directed', 'matchedVertex'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Edge.setIdentifiers(Object, Object, boolean, MatchedVertex)"})
  void testSetIdentifiersWithSourceDestinationDirectedMatchedVertex2() {
    // Arrange
    Edge edge = new Edge();

    // Act
    edge.setIdentifiers("Source", "Destination", false, MatchedVertex.SOURCE);

    // Assert
    assertEquals("Destination", edge.getSource());
    assertEquals("Destination", edge.getAdjacentMatchedVertexValue());
    assertEquals("Source", edge.getDestination());
    assertEquals("Source", edge.getMatchedVertexValue());
    assertEquals(MatchedVertex.DESTINATION, edge.getMatchedVertex());
  }

  /**
   * Test {@link Edge#setIdentifiers(Object, Object, boolean, MatchedVertex)} with {@code source},
   * {@code destination}, {@code directed}, {@code matchedVertex}.
   *
   * <p>Method under test: {@link Edge#setIdentifiers(Object, Object, boolean, MatchedVertex)}
   */
  @Test
  @DisplayName(
      "Test setIdentifiers(Object, Object, boolean, MatchedVertex) with 'source', 'destination', 'directed', 'matchedVertex'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Edge.setIdentifiers(Object, Object, boolean, MatchedVertex)"})
  void testSetIdentifiersWithSourceDestinationDirectedMatchedVertex3() {
    // Arrange
    Edge edge = new Edge();

    // Act
    edge.setIdentifiers((byte) 'A', "Destination", false, MatchedVertex.SOURCE);

    // Assert
    assertEquals('A', ((Byte) edge.getSource()).byteValue());
    assertEquals('A', ((Byte) edge.getMatchedVertexValue()).byteValue());
  }

  /**
   * Test {@link Edge#setIdentifiers(Object, Object, boolean, MatchedVertex)} with {@code source},
   * {@code destination}, {@code directed}, {@code matchedVertex}.
   *
   * <p>Method under test: {@link Edge#setIdentifiers(Object, Object, boolean, MatchedVertex)}
   */
  @Test
  @DisplayName(
      "Test setIdentifiers(Object, Object, boolean, MatchedVertex) with 'source', 'destination', 'directed', 'matchedVertex'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Edge.setIdentifiers(Object, Object, boolean, MatchedVertex)"})
  void testSetIdentifiersWithSourceDestinationDirectedMatchedVertex4() {
    // Arrange
    Edge edge = new Edge();

    // Act
    edge.setIdentifiers("Source", "Destination", false, null);

    // Assert
    assertEquals("Destination", edge.getSource());
    assertEquals("Destination", edge.getMatchedVertexValue());
    assertEquals("Source", edge.getDestination());
    assertEquals("Source", edge.getAdjacentMatchedVertexValue());
    assertNull(edge.getMatchedVertex());
  }

  /**
   * Test {@link Edge#setIdentifiers(Object, Object, boolean, MatchedVertex)} with {@code source},
   * {@code destination}, {@code directed}, {@code matchedVertex}.
   *
   * <p>Method under test: {@link Edge#setIdentifiers(Object, Object, boolean, MatchedVertex)}
   */
  @Test
  @DisplayName(
      "Test setIdentifiers(Object, Object, boolean, MatchedVertex) with 'source', 'destination', 'directed', 'matchedVertex'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Edge.setIdentifiers(Object, Object, boolean, MatchedVertex)"})
  void testSetIdentifiersWithSourceDestinationDirectedMatchedVertex5() {
    // Arrange
    Edge edge = new Edge();

    // Act
    edge.setIdentifiers("Source", "Destination", false, MatchedVertex.DESTINATION);

    // Assert
    assertEquals("Destination", edge.getSource());
    assertEquals("Destination", edge.getMatchedVertexValue());
    assertEquals("Source", edge.getDestination());
    assertEquals("Source", edge.getAdjacentMatchedVertexValue());
    assertEquals(MatchedVertex.SOURCE, edge.getMatchedVertex());
  }

  /**
   * Test {@link Edge#setIdentifiers(Object, Object, DirectedType)} with {@code source}, {@code
   * destination}, {@code directedType}.
   *
   * <p>Method under test: {@link Edge#setIdentifiers(Object, Object, DirectedType)}
   */
  @Test
  @DisplayName(
      "Test setIdentifiers(Object, Object, DirectedType) with 'source', 'destination', 'directedType'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Edge.setIdentifiers(Object, Object, DirectedType)"})
  void testSetIdentifiersWithSourceDestinationDirectedType() {
    // Arrange
    Edge edge =
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build();

    // Act
    edge.setIdentifiers("Source", "Destination", DirectedType.UNDIRECTED);

    // Assert
    assertEquals("Source", edge.getMatchedVertexValue());
    assertEquals(DirectedType.UNDIRECTED, edge.getDirectedType());
    assertEquals(MatchedVertex.DESTINATION, edge.getMatchedVertex());
    assertFalse(edge.isDirected());
    assertTrue(edge.isUndirected());
  }

  /**
   * Test {@link Edge#setIdentifiers(Object, Object, DirectedType)} with {@code source}, {@code
   * destination}, {@code directedType}.
   *
   * <p>Method under test: {@link Edge#setIdentifiers(Object, Object, DirectedType)}
   */
  @Test
  @DisplayName(
      "Test setIdentifiers(Object, Object, DirectedType) with 'source', 'destination', 'directedType'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Edge.setIdentifiers(Object, Object, DirectedType)"})
  void testSetIdentifiersWithSourceDestinationDirectedType2() {
    // Arrange
    Edge edge =
        new Builder()
            .dest("Dest")
            .directed(false)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build();

    // Act
    edge.setIdentifiers("Source", "Destination", DirectedType.UNDIRECTED);

    // Assert
    assertEquals("Destination", edge.getMatchedVertexValue());
    assertEquals("Source", edge.getDestination());
    assertEquals("Source", edge.getAdjacentMatchedVertexValue());
    assertEquals(MatchedVertex.SOURCE, edge.getMatchedVertex());
  }

  /**
   * Test {@link Edge#setIdentifiers(Object, Object, DirectedType, MatchedVertex)} with {@code
   * source}, {@code destination}, {@code directedType}, {@code matchedVertex}.
   *
   * <p>Method under test: {@link Edge#setIdentifiers(Object, Object, DirectedType, MatchedVertex)}
   */
  @Test
  @DisplayName(
      "Test setIdentifiers(Object, Object, DirectedType, MatchedVertex) with 'source', 'destination', 'directedType', 'matchedVertex'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Edge.setIdentifiers(Object, Object, DirectedType, MatchedVertex)"})
  void testSetIdentifiersWithSourceDestinationDirectedTypeMatchedVertex() {
    // Arrange
    Edge edge = new Edge();

    // Act
    edge.setIdentifiers("Source", "Destination", DirectedType.EITHER, MatchedVertex.SOURCE);

    // Assert
    assertEquals("Source", edge.getSource());
    assertEquals(DirectedType.DIRECTED, edge.getDirectedType());
    assertFalse(edge.isUndirected());
    assertTrue(edge.isDirected());
  }

  /**
   * Test {@link Edge#setIdentifiers(Object, Object, DirectedType, MatchedVertex)} with {@code
   * source}, {@code destination}, {@code directedType}, {@code matchedVertex}.
   *
   * <p>Method under test: {@link Edge#setIdentifiers(Object, Object, DirectedType, MatchedVertex)}
   */
  @Test
  @DisplayName(
      "Test setIdentifiers(Object, Object, DirectedType, MatchedVertex) with 'source', 'destination', 'directedType', 'matchedVertex'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Edge.setIdentifiers(Object, Object, DirectedType, MatchedVertex)"})
  void testSetIdentifiersWithSourceDestinationDirectedTypeMatchedVertex2() {
    // Arrange
    Edge edge = new Edge();

    // Act
    edge.setIdentifiers("Source", "Destination", DirectedType.UNDIRECTED, MatchedVertex.SOURCE);

    // Assert
    assertEquals("Destination", edge.getSource());
    assertEquals("Destination", edge.getAdjacentMatchedVertexValue());
    assertEquals("Source", edge.getDestination());
    assertEquals("Source", edge.getMatchedVertexValue());
    assertEquals(MatchedVertex.DESTINATION, edge.getMatchedVertex());
  }

  /**
   * Test {@link Edge#setIdentifiers(Object, Object, DirectedType, MatchedVertex)} with {@code
   * source}, {@code destination}, {@code directedType}, {@code matchedVertex}.
   *
   * <p>Method under test: {@link Edge#setIdentifiers(Object, Object, DirectedType, MatchedVertex)}
   */
  @Test
  @DisplayName(
      "Test setIdentifiers(Object, Object, DirectedType, MatchedVertex) with 'source', 'destination', 'directedType', 'matchedVertex'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Edge.setIdentifiers(Object, Object, DirectedType, MatchedVertex)"})
  void testSetIdentifiersWithSourceDestinationDirectedTypeMatchedVertex3() {
    // Arrange
    Edge edge = new Edge();

    // Act
    edge.setIdentifiers((byte) 'A', "Destination", DirectedType.UNDIRECTED, MatchedVertex.SOURCE);

    // Assert
    assertEquals('A', ((Byte) edge.getSource()).byteValue());
    assertEquals('A', ((Byte) edge.getMatchedVertexValue()).byteValue());
  }

  /**
   * Test {@link Edge#setIdentifiers(Object, Object, DirectedType, MatchedVertex)} with {@code
   * source}, {@code destination}, {@code directedType}, {@code matchedVertex}.
   *
   * <p>Method under test: {@link Edge#setIdentifiers(Object, Object, DirectedType, MatchedVertex)}
   */
  @Test
  @DisplayName(
      "Test setIdentifiers(Object, Object, DirectedType, MatchedVertex) with 'source', 'destination', 'directedType', 'matchedVertex'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Edge.setIdentifiers(Object, Object, DirectedType, MatchedVertex)"})
  void testSetIdentifiersWithSourceDestinationDirectedTypeMatchedVertex4() {
    // Arrange
    Edge edge = new Edge();

    // Act
    edge.setIdentifiers("Source", "Destination", DirectedType.UNDIRECTED, null);

    // Assert
    assertEquals("Destination", edge.getSource());
    assertEquals("Destination", edge.getMatchedVertexValue());
    assertEquals("Source", edge.getDestination());
    assertEquals("Source", edge.getAdjacentMatchedVertexValue());
    assertNull(edge.getMatchedVertex());
  }

  /**
   * Test {@link Edge#setIdentifiers(Object, Object, DirectedType, MatchedVertex)} with {@code
   * source}, {@code destination}, {@code directedType}, {@code matchedVertex}.
   *
   * <p>Method under test: {@link Edge#setIdentifiers(Object, Object, DirectedType, MatchedVertex)}
   */
  @Test
  @DisplayName(
      "Test setIdentifiers(Object, Object, DirectedType, MatchedVertex) with 'source', 'destination', 'directedType', 'matchedVertex'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Edge.setIdentifiers(Object, Object, DirectedType, MatchedVertex)"})
  void testSetIdentifiersWithSourceDestinationDirectedTypeMatchedVertex5() {
    // Arrange
    Edge edge = new Edge();

    // Act
    edge.setIdentifiers(
        "Source", "Destination", DirectedType.UNDIRECTED, MatchedVertex.DESTINATION);

    // Assert
    assertEquals("Destination", edge.getSource());
    assertEquals("Destination", edge.getMatchedVertexValue());
    assertEquals("Source", edge.getDestination());
    assertEquals("Source", edge.getAdjacentMatchedVertexValue());
    assertEquals(MatchedVertex.SOURCE, edge.getMatchedVertex());
  }

  /**
   * Test {@link Edge#setIdentifiers(Object, Object, DirectedType)} with {@code source}, {@code
   * destination}, {@code directedType}.
   *
   * <ul>
   *   <li>Then {@link Edge#Edge()} Source byteValue is {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link Edge#setIdentifiers(Object, Object, DirectedType)}
   */
  @Test
  @DisplayName(
      "Test setIdentifiers(Object, Object, DirectedType) with 'source', 'destination', 'directedType'; then Edge() Source byteValue is 'A'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Edge.setIdentifiers(Object, Object, DirectedType)"})
  void testSetIdentifiersWithSourceDestinationDirectedType_thenEdgeSourceByteValueIsA() {
    // Arrange
    Edge edge = new Edge();

    // Act
    edge.setIdentifiers((byte) 'A', "Destination", DirectedType.UNDIRECTED);

    // Assert
    assertEquals('A', ((Byte) edge.getSource()).byteValue());
    assertEquals('A', ((Byte) edge.getMatchedVertexValue()).byteValue());
  }

  /**
   * Test {@link Edge#setIdentifiers(Object, Object, DirectedType)} with {@code source}, {@code
   * destination}, {@code directedType}.
   *
   * <ul>
   *   <li>Then {@link Edge#Edge()} Source is {@code Destination}.
   * </ul>
   *
   * <p>Method under test: {@link Edge#setIdentifiers(Object, Object, DirectedType)}
   */
  @Test
  @DisplayName(
      "Test setIdentifiers(Object, Object, DirectedType) with 'source', 'destination', 'directedType'; then Edge() Source is 'Destination'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Edge.setIdentifiers(Object, Object, DirectedType)"})
  void testSetIdentifiersWithSourceDestinationDirectedType_thenEdgeSourceIsDestination() {
    // Arrange
    Edge edge = new Edge();

    // Act
    edge.setIdentifiers("Source", "Destination", DirectedType.UNDIRECTED);

    // Assert
    assertEquals("Destination", edge.getSource());
    assertEquals("Source", edge.getDestination());
    assertNull(edge.getMatchedVertex());
    assertEquals(DirectedType.UNDIRECTED, edge.getDirectedType());
    assertFalse(edge.isDirected());
    assertTrue(edge.isUndirected());
  }

  /**
   * Test {@link Edge#setIdentifiers(Object, Object, DirectedType)} with {@code source}, {@code
   * destination}, {@code directedType}.
   *
   * <ul>
   *   <li>Then {@link Edge#Edge()} Source is {@code Source}.
   * </ul>
   *
   * <p>Method under test: {@link Edge#setIdentifiers(Object, Object, DirectedType)}
   */
  @Test
  @DisplayName(
      "Test setIdentifiers(Object, Object, DirectedType) with 'source', 'destination', 'directedType'; then Edge() Source is 'Source'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Edge.setIdentifiers(Object, Object, DirectedType)"})
  void testSetIdentifiersWithSourceDestinationDirectedType_thenEdgeSourceIsSource() {
    // Arrange
    Edge edge = new Edge();

    // Act
    edge.setIdentifiers("Source", "Destination", DirectedType.EITHER);

    // Assert
    assertEquals("Source", edge.getSource());
    assertEquals("Source", edge.getMatchedVertexValue());
    assertEquals(DirectedType.DIRECTED, edge.getDirectedType());
    assertFalse(edge.isUndirected());
    assertTrue(edge.isDirected());
  }

  /**
   * Test {@link Edge#setIdentifiers(Object, Object, boolean)} with {@code source}, {@code
   * destination}, {@code directed}.
   *
   * <ul>
   *   <li>Then {@link Edge#Edge()} Source is {@code Destination}.
   * </ul>
   *
   * <p>Method under test: {@link Edge#setIdentifiers(Object, Object, boolean)}
   */
  @Test
  @DisplayName(
      "Test setIdentifiers(Object, Object, boolean) with 'source', 'destination', 'directed'; then Edge() Source is 'Destination'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Edge.setIdentifiers(Object, Object, boolean)"})
  void testSetIdentifiersWithSourceDestinationDirected_thenEdgeSourceIsDestination() {
    // Arrange
    Edge edge = new Edge();

    // Act
    edge.setIdentifiers("Source", "Destination", false);

    // Assert
    assertEquals("Destination", edge.getSource());
    assertEquals("Source", edge.getDestination());
    assertNull(edge.getMatchedVertex());
    assertEquals(DirectedType.UNDIRECTED, edge.getDirectedType());
    assertFalse(edge.isDirected());
    assertTrue(edge.isUndirected());
  }

  /**
   * Test {@link Edge#setIdentifiers(Object, Object, boolean)} with {@code source}, {@code
   * destination}, {@code directed}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then {@link Edge#Edge()} Source byteValue is {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link Edge#setIdentifiers(Object, Object, boolean)}
   */
  @Test
  @DisplayName(
      "Test setIdentifiers(Object, Object, boolean) with 'source', 'destination', 'directed'; when 'A'; then Edge() Source byteValue is 'A'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Edge.setIdentifiers(Object, Object, boolean)"})
  void testSetIdentifiersWithSourceDestinationDirected_whenA_thenEdgeSourceByteValueIsA() {
    // Arrange
    Edge edge = new Edge();

    // Act
    edge.setIdentifiers((byte) 'A', "Destination", false);

    // Assert
    assertEquals('A', ((Byte) edge.getSource()).byteValue());
    assertEquals('A', ((Byte) edge.getMatchedVertexValue()).byteValue());
  }

  /**
   * Test {@link Edge#setIdentifiers(Object, Object, boolean)} with {@code source}, {@code
   * destination}, {@code directed}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then {@link Edge#Edge()} Source is {@code Source}.
   * </ul>
   *
   * <p>Method under test: {@link Edge#setIdentifiers(Object, Object, boolean)}
   */
  @Test
  @DisplayName(
      "Test setIdentifiers(Object, Object, boolean) with 'source', 'destination', 'directed'; when 'true'; then Edge() Source is 'Source'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Edge.setIdentifiers(Object, Object, boolean)"})
  void testSetIdentifiersWithSourceDestinationDirected_whenTrue_thenEdgeSourceIsSource() {
    // Arrange
    Edge edge = new Edge();

    // Act
    edge.setIdentifiers("Source", "Destination", true);

    // Assert
    assertEquals("Source", edge.getSource());
    assertEquals("Source", edge.getMatchedVertexValue());
    assertEquals(DirectedType.DIRECTED, edge.getDirectedType());
    assertFalse(edge.isUndirected());
    assertTrue(edge.isDirected());
  }

  /**
   * Test {@link Edge#equals(Object)}, and {@link Edge#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Edge#equals(Object)}
   *   <li>{@link Edge#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Edge.equals(Object)", "int Edge.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Edge edge =
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build();
    Edge edge2 =
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build();

    // Act and Assert
    assertEquals(edge, edge2);
    assertEquals(edge.hashCode(), edge2.hashCode());
  }

  /**
   * Test {@link Edge#equals(Object)}, and {@link Edge#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Edge#equals(Object)}
   *   <li>{@link Edge#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Edge.equals(Object)", "int Edge.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Edge edge =
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build();

    // Act and Assert
    assertEquals(edge, edge);
    int expectedHashCodeResult = edge.hashCode();
    assertEquals(expectedHashCodeResult, edge.hashCode());
  }

  /**
   * Test {@link Edge#equals(Edge)} with {@code edge}.
   *
   * <p>Method under test: {@link Edge#equals(Edge)}
   */
  @Test
  @DisplayName("Test equals(Edge) with 'edge'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Edge.equals(Edge)"})
  void testEqualsWithEdge() {
    // Arrange
    Edge edge = new Edge("Group");
    edge.setGroup("foo");
    edge.setProperties(new Properties());

    // Act
    boolean actualEqualsResult =
        edge.equals(
            new Builder()
                .dest("Dest")
                .directed(true)
                .group("Group")
                .matchedVertex(MatchedVertex.SOURCE)
                .source("Source")
                .build());

    // Assert
    assertFalse(actualEqualsResult);
  }

  /**
   * Test {@link Edge#equals(Edge)} with {@code edge}.
   *
   * <ul>
   *   <li>Given {@link Edge#Edge(String)} with {@code Group} Group is {@code foo}.
   *   <li>When {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Edge#equals(Edge)}
   */
  @Test
  @DisplayName(
      "Test equals(Edge) with 'edge'; given Edge(String) with 'Group' Group is 'foo'; when 'null'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Edge.equals(Edge)"})
  void testEqualsWithEdge_givenEdgeWithGroupGroupIsFoo_whenNull_thenReturnFalse() {
    // Arrange
    Edge edge = new Edge("Group");
    edge.setGroup("foo");
    edge.setProperties(new Properties());

    // Act and Assert
    assertFalse(edge.equals((Edge) null));
  }

  /**
   * Test {@link Edge#equals(Edge)} with {@code edge}.
   *
   * <ul>
   *   <li>Given {@link Edge#Edge(String)} with {@code Group} Group is {@code null}.
   *   <li>When {@link Edge#Edge(String)} with {@code Group} Group is {@code Edge}.
   * </ul>
   *
   * <p>Method under test: {@link Edge#equals(Edge)}
   */
  @Test
  @DisplayName(
      "Test equals(Edge) with 'edge'; given Edge(String) with 'Group' Group is 'null'; when Edge(String) with 'Group' Group is 'Edge'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Edge.equals(Edge)"})
  void testEqualsWithEdge_givenEdgeWithGroupGroupIsNull_whenEdgeWithGroupGroupIsEdge() {
    // Arrange
    Edge edge = new Edge("Group");
    edge.setGroup(null);
    edge.setProperties(new Properties());

    Edge edge2 = new Edge("Group");
    edge2.setGroup("Edge");
    edge2.setProperties(new Properties());

    // Act
    boolean actualEqualsResult = edge.equals(edge2);

    // Assert
    assertFalse(actualEqualsResult);
  }

  /**
   * Test {@link Edge#equals(Edge)} with {@code edge}.
   *
   * <ul>
   *   <li>Given {@code Edge}.
   *   <li>When {@link Edge#Edge(String)} with {@code Group} Group is {@code Edge}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Edge#equals(Edge)}
   */
  @Test
  @DisplayName(
      "Test equals(Edge) with 'edge'; given 'Edge'; when Edge(String) with 'Group' Group is 'Edge'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Edge.equals(Edge)"})
  void testEqualsWithEdge_givenEdge_whenEdgeWithGroupGroupIsEdge_thenReturnFalse() {
    // Arrange
    Edge edge = new Edge("Group");
    edge.setGroup("foo");
    edge.setProperties(new Properties());

    Edge edge2 = new Edge("Group");
    edge2.setGroup("Edge");
    edge2.setProperties(new Properties());

    // Act
    boolean actualEqualsResult = edge.equals(edge2);

    // Assert
    assertFalse(actualEqualsResult);
  }

  /**
   * Test {@link Edge#equals(Edge)} with {@code edge}.
   *
   * <ul>
   *   <li>Given {@link Edge#Edge()}.
   *   <li>When {@link Edge#Edge()}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Edge#equals(Edge)}
   */
  @Test
  @DisplayName("Test equals(Edge) with 'edge'; given Edge(); when Edge(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Edge.equals(Edge)"})
  void testEqualsWithEdge_givenEdge_whenEdge_thenReturnTrue() {
    // Arrange
    Edge edge = new Edge();

    // Act and Assert
    assertTrue(edge.equals(new Edge()));
  }

  /**
   * Test {@link Edge#equals(Edge)} with {@code edge}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link Edge#Edge(String)} with {@code Group} Group is {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Edge#equals(Edge)}
   */
  @Test
  @DisplayName(
      "Test equals(Edge) with 'edge'; given 'null'; when Edge(String) with 'Group' Group is 'null'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Edge.equals(Edge)"})
  void testEqualsWithEdge_givenNull_whenEdgeWithGroupGroupIsNull_thenReturnFalse() {
    // Arrange
    Edge edge = new Edge("Group");
    edge.setGroup("foo");
    edge.setProperties(new Properties());

    Edge edge2 = new Edge("Group");
    edge2.setGroup(null);
    edge2.setProperties(new Properties());

    // Act
    boolean actualEqualsResult = edge.equals(edge2);

    // Assert
    assertFalse(actualEqualsResult);
  }

  /**
   * Test {@link Edge#equals(Edge)} with {@code edge}.
   *
   * <ul>
   *   <li>Then calls {@link ElementValueLoader#loadIdentifiers(Element)}.
   * </ul>
   *
   * <p>Method under test: {@link Edge#equals(Edge)}
   */
  @Test
  @DisplayName("Test equals(Edge) with 'edge'; then calls loadIdentifiers(Element)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Edge.equals(Edge)"})
  void testEqualsWithEdge_thenCallsLoadIdentifiers() {
    // Arrange
    ElementValueLoader valueLoader = mock(ElementValueLoader.class);
    doNothing().when(valueLoader).loadIdentifiers(Mockito.<Element>any());
    Edge edge =
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build();

    LazyEdge lazyEdge = new LazyEdge(edge, valueLoader);

    // Act
    boolean actualEqualsResult = lazyEdge.equals(new Edge());

    // Assert
    verify(valueLoader).loadIdentifiers(isA(Element.class));
    assertFalse(actualEqualsResult);
  }

  /**
   * Test {@link Edge#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Edge#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Edge.equals(Object)", "int Edge.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Edge edge =
        new Builder()
            .dest(1)
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build();

    // Act and Assert
    assertNotEquals(
        edge,
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build());
  }

  /**
   * Test {@link Edge#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Edge#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Edge.equals(Object)", "int Edge.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder builder = new Builder();
    Edge edge =
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
            .build();

    // Act and Assert
    assertNotEquals(
        edge,
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build());
  }

  /**
   * Test {@link Edge#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Edge#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Edge.equals(Object)", "int Edge.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Edge edge =
        new Builder()
            .dest("Dest")
            .directed(false)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build();

    // Act and Assert
    assertNotEquals(
        edge,
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build());
  }

  /**
   * Test {@link Edge#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Edge#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Edge.equals(Object)", "int Edge.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Builder matchedVertexResult =
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE);
    Edge edge =
        matchedVertexResult
            .source(
                new Builder()
                    .dest("Dest")
                    .directed(true)
                    .group("Group")
                    .matchedVertex(MatchedVertex.SOURCE)
                    .source("Source")
                    .build())
            .build();

    // Act and Assert
    assertNotEquals(
        edge,
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build());
  }

  /**
   * Test {@link Edge#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Edge#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Edge.equals(Object)", "int Edge.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    Builder builder = new Builder();
    Edge edge =
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
            .build();

    LazyEdge lazyEdge = mock(LazyEdge.class);
    when(lazyEdge.isDirected()).thenReturn(true);
    when(lazyEdge.getDestination()).thenReturn("Destination");
    when(lazyEdge.getSource()).thenReturn("Source");

    // Act and Assert
    assertNotEquals(
        edge,
        new Builder()
            .dest(lazyEdge)
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build());
  }

  /**
   * Test {@link Edge#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Edge#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Edge.equals(Object)", "int Edge.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build(),
        null);
  }

  /**
   * Test {@link Edge#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Edge#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Edge.equals(Object)", "int Edge.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build(),
        "Different type to Edge");
  }

  /**
   * Test {@link Edge#emptyClone()}.
   *
   * <p>Method under test: {@link Edge#emptyClone()}
   */
  @Test
  @DisplayName("Test emptyClone()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Edge Edge.emptyClone()"})
  void testEmptyClone() {
    // Arrange
    Edge edge =
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build();

    // Act
    Edge actualEmptyCloneResult = edge.emptyClone();

    // Assert
    assertEquals(edge, actualEmptyCloneResult);
  }

  /**
   * Test {@link Edge#emptyClone()}.
   *
   * <ul>
   *   <li>Given {@link Edge#Edge()}.
   *   <li>Then return {@link Edge#Edge()}.
   * </ul>
   *
   * <p>Method under test: {@link Edge#emptyClone()}
   */
  @Test
  @DisplayName("Test emptyClone(); given Edge(); then return Edge()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Edge Edge.emptyClone()"})
  void testEmptyClone_givenEdge_thenReturnEdge() {
    // Arrange
    Edge edge = new Edge();

    // Act
    Edge actualEmptyCloneResult = edge.emptyClone();

    // Assert
    assertEquals(edge, actualEmptyCloneResult);
  }

  /**
   * Test {@link Edge#emptyClone()}.
   *
   * <ul>
   *   <li>Then return AdjacentMatchedVertexValue is {@code Dest}.
   * </ul>
   *
   * <p>Method under test: {@link Edge#emptyClone()}
   */
  @Test
  @DisplayName("Test emptyClone(); then return AdjacentMatchedVertexValue is 'Dest'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Edge Edge.emptyClone()"})
  void testEmptyClone_thenReturnAdjacentMatchedVertexValueIsDest() {
    // Arrange
    ElementValueLoader valueLoader = mock(ElementValueLoader.class);
    doNothing().when(valueLoader).loadIdentifiers(Mockito.<Element>any());
    Edge edge =
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build();

    LazyEdge lazyEdge = new LazyEdge(edge, valueLoader);
    lazyEdge.putIdentifier(IdentifierType.DIRECTED, "Value");

    // Act
    Edge actualEmptyCloneResult = lazyEdge.emptyClone();

    // Assert
    verify(valueLoader).loadIdentifiers(isA(Element.class));
    assertEquals("Dest", actualEmptyCloneResult.getSource());
    assertEquals("Dest", actualEmptyCloneResult.getAdjacentMatchedVertexValue());
    assertEquals("Group", actualEmptyCloneResult.getGroup());
    assertEquals("Source", actualEmptyCloneResult.getDestination());
    assertEquals("Source", actualEmptyCloneResult.getMatchedVertexValue());
    assertEquals("uk.gov.gchq.gaffer.data.element.Edge", actualEmptyCloneResult.getClassName());
    assertEquals(DirectedType.UNDIRECTED, actualEmptyCloneResult.getDirectedType());
    assertEquals(MatchedVertex.DESTINATION, actualEmptyCloneResult.getMatchedVertex());
    assertFalse(actualEmptyCloneResult.isDirected());
    assertTrue(actualEmptyCloneResult.getProperties().isEmpty());
    assertTrue(actualEmptyCloneResult.isUndirected());
  }

  /**
   * Test {@link Edge#emptyClone()}.
   *
   * <ul>
   *   <li>Then return MatchedVertexValue is {@code Dest}.
   * </ul>
   *
   * <p>Method under test: {@link Edge#emptyClone()}
   */
  @Test
  @DisplayName("Test emptyClone(); then return MatchedVertexValue is 'Dest'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Edge Edge.emptyClone()"})
  void testEmptyClone_thenReturnMatchedVertexValueIsDest() {
    // Arrange
    ElementValueLoader valueLoader = mock(ElementValueLoader.class);
    doNothing().when(valueLoader).loadIdentifiers(Mockito.<Element>any());
    Edge edge =
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.DESTINATION)
            .source("Source")
            .build();

    LazyEdge lazyEdge = new LazyEdge(edge, valueLoader, null);
    lazyEdge.putIdentifier(IdentifierType.DIRECTED, "Value");

    // Act
    Edge actualEmptyCloneResult = lazyEdge.emptyClone();

    // Assert
    verify(valueLoader).loadIdentifiers(isA(Element.class));
    assertEquals("Dest", actualEmptyCloneResult.getSource());
    assertEquals("Dest", actualEmptyCloneResult.getMatchedVertexValue());
    assertEquals("Group", actualEmptyCloneResult.getGroup());
    assertEquals("Source", actualEmptyCloneResult.getDestination());
    assertEquals("Source", actualEmptyCloneResult.getAdjacentMatchedVertexValue());
    assertEquals("uk.gov.gchq.gaffer.data.element.Edge", actualEmptyCloneResult.getClassName());
    assertEquals(DirectedType.UNDIRECTED, actualEmptyCloneResult.getDirectedType());
    assertEquals(MatchedVertex.SOURCE, actualEmptyCloneResult.getMatchedVertex());
    assertFalse(actualEmptyCloneResult.isDirected());
    assertTrue(actualEmptyCloneResult.getProperties().isEmpty());
    assertTrue(actualEmptyCloneResult.isUndirected());
  }

  /**
   * Test {@link Edge#shallowClone()}.
   *
   * <p>Method under test: {@link Edge#shallowClone()}
   */
  @Test
  @DisplayName("Test shallowClone()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Edge Edge.shallowClone()"})
  void testShallowClone() {
    // Arrange
    Edge edge =
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build();

    // Act
    Edge actualShallowCloneResult = edge.shallowClone();

    // Assert
    assertEquals(edge, actualShallowCloneResult);
  }

  /**
   * Test {@link Edge#shallowClone()}.
   *
   * <ul>
   *   <li>Given {@link Edge#Edge()}.
   *   <li>Then return {@link Edge#Edge()}.
   * </ul>
   *
   * <p>Method under test: {@link Edge#shallowClone()}
   */
  @Test
  @DisplayName("Test shallowClone(); given Edge(); then return Edge()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Edge Edge.shallowClone()"})
  void testShallowClone_givenEdge_thenReturnEdge() {
    // Arrange
    Edge edge = new Edge();

    // Act
    Edge actualShallowCloneResult = edge.shallowClone();

    // Assert
    assertEquals(edge, actualShallowCloneResult);
  }

  /**
   * Test {@link Edge#shallowClone()}.
   *
   * <ul>
   *   <li>Then return Destination is {@code Dest}.
   * </ul>
   *
   * <p>Method under test: {@link Edge#shallowClone()}
   */
  @Test
  @DisplayName("Test shallowClone(); then return Destination is 'Dest'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Edge Edge.shallowClone()"})
  void testShallowClone_thenReturnDestinationIsDest() {
    // Arrange
    ElementValueLoader valueLoader = mock(ElementValueLoader.class);
    doNothing().when(valueLoader).loadIdentifiers(Mockito.<Element>any());
    Edge edge =
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build();

    LazyEdge lazyEdge = new LazyEdge(edge, valueLoader);

    // Act
    Edge actualShallowCloneResult = lazyEdge.shallowClone();

    // Assert
    verify(valueLoader).loadIdentifiers(isA(Element.class));
    assertEquals("Dest", actualShallowCloneResult.getDestination());
    assertEquals("Dest", actualShallowCloneResult.getAdjacentMatchedVertexValue());
    assertEquals("Group", actualShallowCloneResult.getGroup());
    assertEquals("Source", actualShallowCloneResult.getSource());
    assertEquals("Source", actualShallowCloneResult.getMatchedVertexValue());
    assertEquals("uk.gov.gchq.gaffer.data.element.Edge", actualShallowCloneResult.getClassName());
    assertEquals(DirectedType.DIRECTED, actualShallowCloneResult.getDirectedType());
    assertEquals(MatchedVertex.SOURCE, actualShallowCloneResult.getMatchedVertex());
    assertFalse(actualShallowCloneResult.isUndirected());
    assertTrue(actualShallowCloneResult.getProperties().isEmpty());
    assertTrue(actualShallowCloneResult.isDirected());
  }
}
