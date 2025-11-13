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
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
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
   * <p>
   * Methods under test:
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Edge Builder.build()", "Builder Builder.dest(Object)", "Builder Builder.directed(boolean)",
      "Builder Builder.group(String)", "Builder Builder.matchedVertex(MatchedVertex)",
      "Builder Builder.source(Object)"})
  void testBuilderBuild() {
    // Arrange and Act
    Edge actualBuildResult = (new Builder()).dest("Dest")
        .directed(true)
        .group("Group")
        .matchedVertex(MatchedVertex.SOURCE)
        .source("Source")
        .build();

    // Assert
    assertEquals("Dest", actualBuildResult.getDestination());
    assertEquals("Dest", actualBuildResult.getAdjacentMatchedVertexValue());
    assertEquals("Group", actualBuildResult.getGroup());
    assertEquals("Source", actualBuildResult.getSource());
    assertEquals("Source", actualBuildResult.getMatchedVertexValue());
    assertEquals("uk.gov.gchq.gaffer.data.element.Edge", actualBuildResult.getClassName());
    assertEquals(DirectedType.DIRECTED, actualBuildResult.getDirectedType());
    assertEquals(MatchedVertex.SOURCE, actualBuildResult.getMatchedVertex());
    assertFalse(actualBuildResult.isUndirected());
    assertTrue(actualBuildResult.isDirected());
  }

  /**
   * Test Builder new {@link Builder} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link Builder}
   */
  @Test
  @DisplayName("Test Builder new Builder (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Builder.<init>()"})
  void testBuilderNewBuilder() {
    // Arrange, Act and Assert
    Edge buildResult = (new Builder()).build();
    assertEquals("uk.gov.gchq.gaffer.data.element.Edge", buildResult.getClassName());
    assertNull(buildResult.getDestination());
    assertNull(buildResult.getSource());
    assertNull(buildResult.getAdjacentMatchedVertexValue());
    assertNull(buildResult.getMatchedVertexValue());
    assertNull(buildResult.getMatchedVertex());
    assertEquals(DirectedType.UNDIRECTED, buildResult.getDirectedType());
    assertFalse(buildResult.isDirected());
    assertTrue(buildResult.getProperties().isEmpty());
    assertTrue(buildResult.isUndirected());
    assertEquals(Element.DEFAULT_GROUP, buildResult.getGroup());
  }

  /**
   * Test Builder {@link Builder#properties(Map)}.
   * <p>
   * Method under test: {@link Builder#properties(Map)}
   */
  @Test
  @DisplayName("Test Builder properties(Map)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.properties(Map)"})
  void testBuilderProperties() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertSame(builder, builder.properties(new HashMap<>()));
  }

  /**
   * Test Builder {@link Builder#property(String, Object)}.
   * <p>
   * Method under test: {@link Builder#property(String, Object)}
   */
  @Test
  @DisplayName("Test Builder property(String, Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.property(String, Object)"})
  void testBuilderProperty() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertSame(builder, builder.property("Name", "Value"));
  }

  /**
   * Test {@link Edge#Edge()}.
   * <p>
   * Method under test: {@link Edge#Edge()}
   */
  @Test
  @DisplayName("Test new Edge()")
  @Tag("MaintainedByDiffblue")
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
   * <p>
   * Method under test: {@link Edge#Edge(String)}
   */
  @Test
  @DisplayName("Test new Edge(String)")
  @Tag("MaintainedByDiffblue")
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
   * Test {@link Edge#Edge(String, Object, Object, Boolean, DirectedType, MatchedVertex, Properties)}.
   * <ul>
   *   <li>When {@code A}.</li>
   *   <li>Then return Source byteValue is {@code A}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Edge#Edge(String, Object, Object, Boolean, DirectedType, MatchedVertex, Properties)}
   */
  @Test
  @DisplayName("Test new Edge(String, Object, Object, Boolean, DirectedType, MatchedVertex, Properties); when 'A'; then return Source byteValue is 'A'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Edge.<init>(String, Object, Object, Boolean, DirectedType, MatchedVertex, Properties)"})
  void testNewEdge_whenA_thenReturnSourceByteValueIsA() {
    // Arrange and Act
    Edge actualEdge = new Edge("Group", (byte) 'A', "Destination", null, DirectedType.UNDIRECTED, MatchedVertex.SOURCE,
        null);

    // Assert
    assertEquals('A', ((Byte) actualEdge.getSource()).byteValue());
    assertEquals('A', ((Byte) actualEdge.getMatchedVertexValue()).byteValue());
  }

  /**
   * Test {@link Edge#Edge(String, Object, Object, boolean)}.
   * <ul>
   *   <li>When {@code A}.</li>
   *   <li>Then return Source byteValue is {@code A}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Edge#Edge(String, Object, Object, boolean)}
   */
  @Test
  @DisplayName("Test new Edge(String, Object, Object, boolean); when 'A'; then return Source byteValue is 'A'")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>When {@code A}.</li>
   *   <li>Then return Source byteValue is {@code A}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Edge#Edge(String, Object, Object, boolean, MatchedVertex, Properties)}
   */
  @Test
  @DisplayName("Test new Edge(String, Object, Object, boolean, MatchedVertex, Properties); when 'A'; then return Source byteValue is 'A'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Edge.<init>(String, Object, Object, boolean, MatchedVertex, Properties)"})
  void testNewEdge_whenA_thenReturnSourceByteValueIsA3() {
    // Arrange and Act
    Edge actualEdge = new Edge("Group", (byte) 'A', "Destination", false, MatchedVertex.SOURCE, new Properties());

    // Assert
    assertEquals('A', ((Byte) actualEdge.getSource()).byteValue());
    assertEquals('A', ((Byte) actualEdge.getMatchedVertexValue()).byteValue());
  }

  /**
   * Test {@link Edge#Edge(String, Object, Object, Boolean, DirectedType, MatchedVertex, Properties)}.
   * <ul>
   *   <li>When {@code DESTINATION}.</li>
   *   <li>Then return MatchedVertexValue is {@code Destination}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Edge#Edge(String, Object, Object, Boolean, DirectedType, MatchedVertex, Properties)}
   */
  @Test
  @DisplayName("Test new Edge(String, Object, Object, Boolean, DirectedType, MatchedVertex, Properties); when 'DESTINATION'; then return MatchedVertexValue is 'Destination'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Edge.<init>(String, Object, Object, Boolean, DirectedType, MatchedVertex, Properties)"})
  void testNewEdge_whenDestination_thenReturnMatchedVertexValueIsDestination() {
    // Arrange and Act
    Edge actualEdge = new Edge("Group", "Source", "Destination", null, DirectedType.UNDIRECTED,
        MatchedVertex.DESTINATION, null);

    // Assert
    assertEquals("Destination", actualEdge.getMatchedVertexValue());
    assertEquals("Source", actualEdge.getAdjacentMatchedVertexValue());
  }

  /**
   * Test {@link Edge#Edge(String, Object, Object, boolean, MatchedVertex, Properties)}.
   * <ul>
   *   <li>When {@code DESTINATION}.</li>
   *   <li>Then return Source is {@code Destination}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Edge#Edge(String, Object, Object, boolean, MatchedVertex, Properties)}
   */
  @Test
  @DisplayName("Test new Edge(String, Object, Object, boolean, MatchedVertex, Properties); when 'DESTINATION'; then return Source is 'Destination'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Edge.<init>(String, Object, Object, boolean, MatchedVertex, Properties)"})
  void testNewEdge_whenDestination_thenReturnSourceIsDestination() {
    // Arrange and Act
    Edge actualEdge = new Edge("Group", "Source", "Destination", false, MatchedVertex.DESTINATION, new Properties());

    // Assert
    assertEquals("Destination", actualEdge.getSource());
    assertEquals("Destination", actualEdge.getMatchedVertexValue());
    assertEquals("Source", actualEdge.getDestination());
    assertEquals("Source", actualEdge.getAdjacentMatchedVertexValue());
  }

  /**
   * Test {@link Edge#Edge(String, Object, Object, Boolean, DirectedType, MatchedVertex, Properties)}.
   * <ul>
   *   <li>When {@code EITHER}.</li>
   *   <li>Then return {@code Source}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Edge#Edge(String, Object, Object, Boolean, DirectedType, MatchedVertex, Properties)}
   */
  @Test
  @DisplayName("Test new Edge(String, Object, Object, Boolean, DirectedType, MatchedVertex, Properties); when 'EITHER'; then return 'Source'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Edge.<init>(String, Object, Object, Boolean, DirectedType, MatchedVertex, Properties)"})
  void testNewEdge_whenEither_thenReturnSource() {
    // Arrange and Act
    Edge actualEdge = new Edge("Group", "Source", "Destination", null, DirectedType.EITHER, MatchedVertex.SOURCE, null);

    // Assert
    assertEquals("Source", actualEdge.getSource());
    assertEquals(DirectedType.DIRECTED, actualEdge.getDirectedType());
    assertFalse(actualEdge.isUndirected());
    assertTrue(actualEdge.isDirected());
  }

  /**
   * Test {@link Edge#Edge(String, Object, Object, boolean, MatchedVertex, Properties)}.
   * <ul>
   *   <li>When {@code false}.</li>
   *   <li>Then return MatchedVertexValue is {@code Source}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Edge#Edge(String, Object, Object, boolean, MatchedVertex, Properties)}
   */
  @Test
  @DisplayName("Test new Edge(String, Object, Object, boolean, MatchedVertex, Properties); when 'false'; then return MatchedVertexValue is 'Source'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Edge.<init>(String, Object, Object, boolean, MatchedVertex, Properties)"})
  void testNewEdge_whenFalse_thenReturnMatchedVertexValueIsSource() {
    // Arrange and Act
    Edge actualEdge = new Edge("Group", "Source", "Destination", false, MatchedVertex.SOURCE, new Properties());

    // Assert
    assertEquals("Destination", actualEdge.getSource());
    assertEquals("Source", actualEdge.getDestination());
    assertEquals("Source", actualEdge.getMatchedVertexValue());
    assertEquals(MatchedVertex.DESTINATION, actualEdge.getMatchedVertex());
  }

  /**
   * Test {@link Edge#Edge(String, Object, Object, boolean, MatchedVertex, Properties)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return MatchedVertex is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Edge#Edge(String, Object, Object, boolean, MatchedVertex, Properties)}
   */
  @Test
  @DisplayName("Test new Edge(String, Object, Object, boolean, MatchedVertex, Properties); when 'null'; then return MatchedVertex is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Edge.<init>(String, Object, Object, boolean, MatchedVertex, Properties)"})
  void testNewEdge_whenNull_thenReturnMatchedVertexIsNull() {
    // Arrange and Act
    Edge actualEdge = new Edge("Group", "Source", "Destination", false, null, new Properties());

    // Assert
    assertEquals("Destination", actualEdge.getMatchedVertexValue());
    assertEquals("Source", actualEdge.getAdjacentMatchedVertexValue());
    assertNull(actualEdge.getMatchedVertex());
  }

  /**
   * Test {@link Edge#Edge(String, Object, Object, Boolean, DirectedType, MatchedVertex, Properties)}.
   * <ul>
   *   <li>When {@link Properties#Properties()}.</li>
   *   <li>Then return Properties is {@link Properties#Properties()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Edge#Edge(String, Object, Object, Boolean, DirectedType, MatchedVertex, Properties)}
   */
  @Test
  @DisplayName("Test new Edge(String, Object, Object, Boolean, DirectedType, MatchedVertex, Properties); when Properties(); then return Properties is Properties()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Edge.<init>(String, Object, Object, Boolean, DirectedType, MatchedVertex, Properties)"})
  void testNewEdge_whenProperties_thenReturnPropertiesIsProperties() {
    // Arrange
    Properties properties = new Properties();

    // Act
    Edge actualEdge = new Edge("Group", "Source", "Destination", null, null, MatchedVertex.SOURCE, properties);

    // Assert
    assertEquals("Source", actualEdge.getSource());
    assertEquals(DirectedType.DIRECTED, actualEdge.getDirectedType());
    assertFalse(actualEdge.isUndirected());
    assertTrue(actualEdge.isDirected());
    assertSame(properties, actualEdge.getProperties());
  }

  /**
   * Test {@link Edge#Edge(String, Object, Object, Boolean, DirectedType, MatchedVertex, Properties)}.
   * <ul>
   *   <li>When {@code SOURCE}.</li>
   *   <li>Then return {@code Source}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Edge#Edge(String, Object, Object, Boolean, DirectedType, MatchedVertex, Properties)}
   */
  @Test
  @DisplayName("Test new Edge(String, Object, Object, Boolean, DirectedType, MatchedVertex, Properties); when 'SOURCE'; then return 'Source'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Edge.<init>(String, Object, Object, Boolean, DirectedType, MatchedVertex, Properties)"})
  void testNewEdge_whenSource_thenReturnSource() {
    // Arrange and Act
    Edge actualEdge = new Edge("Group", "Source", "Destination", null, null, MatchedVertex.SOURCE, null);

    // Assert
    assertEquals("Source", actualEdge.getSource());
    assertEquals(DirectedType.DIRECTED, actualEdge.getDirectedType());
    assertFalse(actualEdge.isUndirected());
    assertTrue(actualEdge.isDirected());
  }

  /**
   * Test {@link Edge#Edge(String, Object, Object, boolean)}.
   * <ul>
   *   <li>When {@code Source}.</li>
   *   <li>Then return Source is {@code Destination}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Edge#Edge(String, Object, Object, boolean)}
   */
  @Test
  @DisplayName("Test new Edge(String, Object, Object, boolean); when 'Source'; then return Source is 'Destination'")
  @Tag("MaintainedByDiffblue")
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
   * Test {@link Edge#Edge(String, Object, Object, boolean, MatchedVertex, Properties)}.
   * <ul>
   *   <li>When {@code true}.</li>
   *   <li>Then return Properties Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Edge#Edge(String, Object, Object, boolean, MatchedVertex, Properties)}
   */
  @Test
  @DisplayName("Test new Edge(String, Object, Object, boolean, MatchedVertex, Properties); when 'true'; then return Properties Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Edge.<init>(String, Object, Object, boolean, MatchedVertex, Properties)"})
  void testNewEdge_whenTrue_thenReturnPropertiesEmpty() {
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
   * Test {@link Edge#Edge(String, Object, Object, Boolean, DirectedType, MatchedVertex, Properties)}.
   * <ul>
   *   <li>When {@code true}.</li>
   *   <li>Then return {@code Source}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Edge#Edge(String, Object, Object, Boolean, DirectedType, MatchedVertex, Properties)}
   */
  @Test
  @DisplayName("Test new Edge(String, Object, Object, Boolean, DirectedType, MatchedVertex, Properties); when 'true'; then return 'Source'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Edge.<init>(String, Object, Object, Boolean, DirectedType, MatchedVertex, Properties)"})
  void testNewEdge_whenTrue_thenReturnSource() {
    // Arrange and Act
    Edge actualEdge = new Edge("Group", "Source", "Destination", true, null, MatchedVertex.SOURCE, null);

    // Assert
    assertEquals("Source", actualEdge.getSource());
    assertEquals(DirectedType.DIRECTED, actualEdge.getDirectedType());
    assertFalse(actualEdge.isUndirected());
    assertTrue(actualEdge.isDirected());
  }

  /**
   * Test {@link Edge#Edge(String, Object, Object, boolean)}.
   * <ul>
   *   <li>When {@code true}.</li>
   *   <li>Then return {@code Source}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Edge#Edge(String, Object, Object, boolean)}
   */
  @Test
  @DisplayName("Test new Edge(String, Object, Object, boolean); when 'true'; then return 'Source'")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>When {@code true}.</li>
   *   <li>Then return {@code Source}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Edge#Edge(String, Object, Object, boolean, MatchedVertex, Properties)}
   */
  @Test
  @DisplayName("Test new Edge(String, Object, Object, boolean, MatchedVertex, Properties); when 'true'; then return 'Source'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Edge.<init>(String, Object, Object, boolean, MatchedVertex, Properties)"})
  void testNewEdge_whenTrue_thenReturnSource3() {
    // Arrange and Act
    Edge actualEdge = new Edge("Group", "Source", "Destination", true, MatchedVertex.SOURCE, new Properties());

    // Assert
    assertEquals("Source", actualEdge.getSource());
    assertEquals(DirectedType.DIRECTED, actualEdge.getDirectedType());
    assertFalse(actualEdge.isUndirected());
    assertTrue(actualEdge.isDirected());
  }

  /**
   * Test {@link Edge#Edge(String, Object, Object, Boolean, DirectedType, MatchedVertex, Properties)}.
   * <ul>
   *   <li>When {@code true}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Edge#Edge(String, Object, Object, Boolean, DirectedType, MatchedVertex, Properties)}
   */
  @Test
  @DisplayName("Test new Edge(String, Object, Object, Boolean, DirectedType, MatchedVertex, Properties); when 'true'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Edge.<init>(String, Object, Object, Boolean, DirectedType, MatchedVertex, Properties)"})
  void testNewEdge_whenTrue_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new Edge("Group", "Source", "Destination", true,
        DirectedType.EITHER, MatchedVertex.SOURCE, new Properties()));

  }

  /**
   * Test {@link Edge#Edge(String, Object, Object, Boolean, DirectedType, MatchedVertex, Properties)}.
   * <ul>
   *   <li>When {@link DirectedType#UNDIRECTED}.</li>
   *   <li>Then return DirectedType is {@code UNDIRECTED}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Edge#Edge(String, Object, Object, Boolean, DirectedType, MatchedVertex, Properties)}
   */
  @Test
  @DisplayName("Test new Edge(String, Object, Object, Boolean, DirectedType, MatchedVertex, Properties); when UNDIRECTED; then return DirectedType is 'UNDIRECTED'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Edge.<init>(String, Object, Object, Boolean, DirectedType, MatchedVertex, Properties)"})
  void testNewEdge_whenUndirected_thenReturnDirectedTypeIsUndirected() {
    // Arrange and Act
    Edge actualEdge = new Edge("Group", "Source", "Destination", null, DirectedType.UNDIRECTED, MatchedVertex.SOURCE,
        null);

    // Assert
    assertEquals(DirectedType.UNDIRECTED, actualEdge.getDirectedType());
    assertEquals(MatchedVertex.DESTINATION, actualEdge.getMatchedVertex());
    assertFalse(actualEdge.isDirected());
    assertTrue(actualEdge.isUndirected());
  }

  /**
   * Test {@link Edge#Edge(String, Object, Object, Boolean, DirectedType, MatchedVertex, Properties)}.
   * <ul>
   *   <li>When {@link DirectedType#UNDIRECTED}.</li>
   *   <li>Then return MatchedVertex is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Edge#Edge(String, Object, Object, Boolean, DirectedType, MatchedVertex, Properties)}
   */
  @Test
  @DisplayName("Test new Edge(String, Object, Object, Boolean, DirectedType, MatchedVertex, Properties); when UNDIRECTED; then return MatchedVertex is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Edge.<init>(String, Object, Object, Boolean, DirectedType, MatchedVertex, Properties)"})
  void testNewEdge_whenUndirected_thenReturnMatchedVertexIsNull() {
    // Arrange and Act
    Edge actualEdge = new Edge("Group", "Source", "Destination", null, DirectedType.UNDIRECTED, null, null);

    // Assert
    assertEquals("Destination", actualEdge.getMatchedVertexValue());
    assertEquals("Source", actualEdge.getAdjacentMatchedVertexValue());
    assertNull(actualEdge.getMatchedVertex());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object Edge.getDestination()", "MatchedVertex Edge.getMatchedVertex()", "Object Edge.getSource()",
      "boolean Edge.isDirected()", "String Edge.toString()"})
  void testGettersAndSetters() {
    // Arrange
    Edge buildResult = (new Builder()).dest("Dest")
        .directed(true)
        .group("Group")
        .matchedVertex(MatchedVertex.SOURCE)
        .source("Source")
        .build();

    // Act
    String actualToStringResult = buildResult.toString();
    Object actualDestination = buildResult.getDestination();
    MatchedVertex actualMatchedVertex = buildResult.getMatchedVertex();
    Object actualSource = buildResult.getSource();

    // Assert
    assertEquals("Dest", actualDestination);
    assertEquals("Edge[source=Source,destination=Dest,directed=true,matchedVertex=SOURCE,group=Group,properties"
        + "=Properties[]]", actualToStringResult);
    assertEquals("Source", actualSource);
    assertEquals(MatchedVertex.SOURCE, actualMatchedVertex);
    assertTrue(buildResult.isDirected());
  }

  /**
   * Test {@link Edge#getDirectedType()}.
   * <ul>
   *   <li>Given {@link Edge#Edge()}.</li>
   *   <li>Then return {@code UNDIRECTED}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Edge#getDirectedType()}
   */
  @Test
  @DisplayName("Test getDirectedType(); given Edge(); then return 'UNDIRECTED'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DirectedType Edge.getDirectedType()"})
  void testGetDirectedType_givenEdge_thenReturnUndirected() {
    // Arrange, Act and Assert
    assertEquals(DirectedType.UNDIRECTED, (new Edge()).getDirectedType());
  }

  /**
   * Test {@link Edge#getDirectedType()}.
   * <ul>
   *   <li>Then return {@code DIRECTED}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Edge#getDirectedType()}
   */
  @Test
  @DisplayName("Test getDirectedType(); then return 'DIRECTED'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DirectedType Edge.getDirectedType()"})
  void testGetDirectedType_thenReturnDirected() {
    // Arrange
    Edge buildResult = (new Builder()).dest("Dest")
        .directed(true)
        .group("Group")
        .matchedVertex(MatchedVertex.SOURCE)
        .source("Source")
        .build();

    // Act and Assert
    assertEquals(DirectedType.DIRECTED, buildResult.getDirectedType());
  }

  /**
   * Test {@link Edge#getIdentifier(IdentifierType)}.
   * <ul>
   *   <li>Given {@link Edge#Edge()}.</li>
   *   <li>When {@code ADJACENT_MATCHED_VERTEX}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Edge#getIdentifier(IdentifierType)}
   */
  @Test
  @DisplayName("Test getIdentifier(IdentifierType); given Edge(); when 'ADJACENT_MATCHED_VERTEX'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object Edge.getIdentifier(IdentifierType)"})
  void testGetIdentifier_givenEdge_whenAdjacentMatchedVertex_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new Edge()).getIdentifier(IdentifierType.ADJACENT_MATCHED_VERTEX));
  }

  /**
   * Test {@link Edge#getIdentifier(IdentifierType)}.
   * <ul>
   *   <li>Given {@link Edge#Edge()}.</li>
   *   <li>When {@code DESTINATION}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Edge#getIdentifier(IdentifierType)}
   */
  @Test
  @DisplayName("Test getIdentifier(IdentifierType); given Edge(); when 'DESTINATION'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object Edge.getIdentifier(IdentifierType)"})
  void testGetIdentifier_givenEdge_whenDestination_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new Edge()).getIdentifier(IdentifierType.DESTINATION));
  }

  /**
   * Test {@link Edge#getIdentifier(IdentifierType)}.
   * <ul>
   *   <li>Given {@link Edge#Edge()}.</li>
   *   <li>When {@code DIRECTED}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Edge#getIdentifier(IdentifierType)}
   */
  @Test
  @DisplayName("Test getIdentifier(IdentifierType); given Edge(); when 'DIRECTED'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object Edge.getIdentifier(IdentifierType)"})
  void testGetIdentifier_givenEdge_whenDirected_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((Boolean) (new Edge()).getIdentifier(IdentifierType.DIRECTED));
  }

  /**
   * Test {@link Edge#getIdentifier(IdentifierType)}.
   * <ul>
   *   <li>Given {@link Edge#Edge()}.</li>
   *   <li>When {@code GROUP}.</li>
   *   <li>Then return {@link Element#DEFAULT_GROUP}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Edge#getIdentifier(IdentifierType)}
   */
  @Test
  @DisplayName("Test getIdentifier(IdentifierType); given Edge(); when 'GROUP'; then return DEFAULT_GROUP")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object Edge.getIdentifier(IdentifierType)"})
  void testGetIdentifier_givenEdge_whenGroup_thenReturnDefault_group() {
    // Arrange, Act and Assert
    assertEquals(Element.DEFAULT_GROUP, (new Edge()).getIdentifier(IdentifierType.GROUP));
  }

  /**
   * Test {@link Edge#getIdentifier(IdentifierType)}.
   * <ul>
   *   <li>Given {@link Edge#Edge()}.</li>
   *   <li>When {@code MATCHED_VERTEX}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Edge#getIdentifier(IdentifierType)}
   */
  @Test
  @DisplayName("Test getIdentifier(IdentifierType); given Edge(); when 'MATCHED_VERTEX'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object Edge.getIdentifier(IdentifierType)"})
  void testGetIdentifier_givenEdge_whenMatchedVertex_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new Edge()).getIdentifier(IdentifierType.MATCHED_VERTEX));
  }

  /**
   * Test {@link Edge#getIdentifier(IdentifierType)}.
   * <ul>
   *   <li>Given {@link Edge#Edge()}.</li>
   *   <li>When {@code SOURCE}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Edge#getIdentifier(IdentifierType)}
   */
  @Test
  @DisplayName("Test getIdentifier(IdentifierType); given Edge(); when 'SOURCE'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object Edge.getIdentifier(IdentifierType)"})
  void testGetIdentifier_givenEdge_whenSource_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new Edge()).getIdentifier(IdentifierType.SOURCE));
  }

  /**
   * Test {@link Edge#getIdentifier(IdentifierType)}.
   * <ul>
   *   <li>Given {@link Edge#Edge()}.</li>
   *   <li>When {@code VERTEX}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Edge#getIdentifier(IdentifierType)}
   */
  @Test
  @DisplayName("Test getIdentifier(IdentifierType); given Edge(); when 'VERTEX'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object Edge.getIdentifier(IdentifierType)"})
  void testGetIdentifier_givenEdge_whenVertex_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new Edge()).getIdentifier(IdentifierType.VERTEX));
  }

  /**
   * Test {@link Edge#getIdentifier(IdentifierType)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Edge#getIdentifier(IdentifierType)}
   */
  @Test
  @DisplayName("Test getIdentifier(IdentifierType); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object Edge.getIdentifier(IdentifierType)"})
  void testGetIdentifier_thenReturnTrue() {
    // Arrange
    Edge buildResult = (new Builder()).dest("Dest")
        .directed(true)
        .group("Group")
        .matchedVertex(MatchedVertex.SOURCE)
        .source("Source")
        .build();

    // Act and Assert
    assertTrue((Boolean) buildResult.getIdentifier(IdentifierType.DIRECTED));
  }

  /**
   * Test {@link Edge#putIdentifier(IdentifierType, Object)}.
   * <ul>
   *   <li>When {@code DESTINATION}.</li>
   *   <li>Then {@link Edge#Edge()} Group is {@link Element#DEFAULT_GROUP}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Edge#putIdentifier(IdentifierType, Object)}
   */
  @Test
  @DisplayName("Test putIdentifier(IdentifierType, Object); when 'DESTINATION'; then Edge() Group is DEFAULT_GROUP")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Edge.putIdentifier(IdentifierType, Object)"})
  void testPutIdentifier_whenDestination_thenEdgeGroupIsDefault_group() {
    // Arrange
    Edge edge = new Edge();

    // Act
    edge.putIdentifier(IdentifierType.DESTINATION, null);

    // Assert that nothing has changed
    assertEquals(Element.DEFAULT_GROUP, edge.getGroup());
  }

  /**
   * Test {@link Edge#putIdentifier(IdentifierType, Object)}.
   * <ul>
   *   <li>When {@code DIRECTED}.</li>
   *   <li>Then {@link Edge#Edge()} Group is {@link Element#DEFAULT_GROUP}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Edge#putIdentifier(IdentifierType, Object)}
   */
  @Test
  @DisplayName("Test putIdentifier(IdentifierType, Object); when 'DIRECTED'; then Edge() Group is DEFAULT_GROUP")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Edge.putIdentifier(IdentifierType, Object)"})
  void testPutIdentifier_whenDirected_thenEdgeGroupIsDefault_group() {
    // Arrange
    Edge edge = new Edge();

    // Act
    edge.putIdentifier(IdentifierType.DIRECTED, null);

    // Assert that nothing has changed
    assertEquals(Element.DEFAULT_GROUP, edge.getGroup());
  }

  /**
   * Test {@link Edge#putIdentifier(IdentifierType, Object)}.
   * <ul>
   *   <li>When {@code GROUP}.</li>
   *   <li>Then {@link Edge#Edge()} Group is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Edge#putIdentifier(IdentifierType, Object)}
   */
  @Test
  @DisplayName("Test putIdentifier(IdentifierType, Object); when 'GROUP'; then Edge() Group is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Edge.putIdentifier(IdentifierType, Object)"})
  void testPutIdentifier_whenGroup_thenEdgeGroupIsNull() {
    // Arrange
    Edge edge = new Edge();

    // Act
    edge.putIdentifier(IdentifierType.GROUP, null);

    // Assert
    assertNull(edge.getGroup());
  }

  /**
   * Test {@link Edge#putIdentifier(IdentifierType, Object)}.
   * <ul>
   *   <li>When {@code SOURCE}.</li>
   *   <li>Then {@link Edge#Edge()} Group is {@link Element#DEFAULT_GROUP}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Edge#putIdentifier(IdentifierType, Object)}
   */
  @Test
  @DisplayName("Test putIdentifier(IdentifierType, Object); when 'SOURCE'; then Edge() Group is DEFAULT_GROUP")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Edge.putIdentifier(IdentifierType, Object)"})
  void testPutIdentifier_whenSource_thenEdgeGroupIsDefault_group() {
    // Arrange
    Edge edge = new Edge();

    // Act
    edge.putIdentifier(IdentifierType.SOURCE, null);

    // Assert that nothing has changed
    assertEquals(Element.DEFAULT_GROUP, edge.getGroup());
  }

  /**
   * Test {@link Edge#putIdentifier(IdentifierType, Object)}.
   * <ul>
   *   <li>When {@link DirectedType#UNDIRECTED}.</li>
   *   <li>Then {@link Edge#Edge()} Group is {@link Element#DEFAULT_GROUP}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Edge#putIdentifier(IdentifierType, Object)}
   */
  @Test
  @DisplayName("Test putIdentifier(IdentifierType, Object); when UNDIRECTED; then Edge() Group is DEFAULT_GROUP")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Edge.putIdentifier(IdentifierType, Object)"})
  void testPutIdentifier_whenUndirected_thenEdgeGroupIsDefault_group() {
    // Arrange
    Edge edge = new Edge();

    // Act
    edge.putIdentifier(IdentifierType.DIRECTED, DirectedType.UNDIRECTED);

    // Assert that nothing has changed
    assertEquals(Element.DEFAULT_GROUP, edge.getGroup());
  }

  /**
   * Test {@link Edge#putIdentifier(IdentifierType, Object)}.
   * <ul>
   *   <li>When {@code VERTEX}.</li>
   *   <li>Then {@link Edge#Edge()} Group is {@link Element#DEFAULT_GROUP}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Edge#putIdentifier(IdentifierType, Object)}
   */
  @Test
  @DisplayName("Test putIdentifier(IdentifierType, Object); when 'VERTEX'; then Edge() Group is DEFAULT_GROUP")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Edge.putIdentifier(IdentifierType, Object)"})
  void testPutIdentifier_whenVertex_thenEdgeGroupIsDefault_group() {
    // Arrange
    Edge edge = new Edge();

    // Act
    edge.putIdentifier(IdentifierType.VERTEX, "Value");

    // Assert that nothing has changed
    assertEquals(Element.DEFAULT_GROUP, edge.getGroup());
  }

  /**
   * Test {@link Edge#setIdentifiers(Object, Object, boolean)} with {@code source}, {@code destination}, {@code directed}.
   * <p>
   * Method under test: {@link Edge#setIdentifiers(Object, Object, boolean)}
   */
  @Test
  @DisplayName("Test setIdentifiers(Object, Object, boolean) with 'source', 'destination', 'directed'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Edge.setIdentifiers(Object, Object, boolean)"})
  void testSetIdentifiersWithSourceDestinationDirected() {
    // Arrange
    Edge buildResult = (new Builder()).dest("Dest")
        .directed(true)
        .group("Group")
        .matchedVertex(MatchedVertex.SOURCE)
        .source("Source")
        .build();

    // Act
    buildResult.setIdentifiers("Source", "Destination", false);

    // Assert
    assertEquals("Source", buildResult.getMatchedVertexValue());
    assertEquals(DirectedType.UNDIRECTED, buildResult.getDirectedType());
    assertEquals(MatchedVertex.DESTINATION, buildResult.getMatchedVertex());
    assertFalse(buildResult.isDirected());
    assertTrue(buildResult.isUndirected());
  }

  /**
   * Test {@link Edge#setIdentifiers(Object, Object, boolean)} with {@code source}, {@code destination}, {@code directed}.
   * <p>
   * Method under test: {@link Edge#setIdentifiers(Object, Object, boolean)}
   */
  @Test
  @DisplayName("Test setIdentifiers(Object, Object, boolean) with 'source', 'destination', 'directed'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Edge.setIdentifiers(Object, Object, boolean)"})
  void testSetIdentifiersWithSourceDestinationDirected2() {
    // Arrange
    Edge buildResult = (new Builder()).dest("Dest")
        .directed(false)
        .group("Group")
        .matchedVertex(MatchedVertex.SOURCE)
        .source("Source")
        .build();

    // Act
    buildResult.setIdentifiers("Source", "Destination", false);

    // Assert
    assertEquals("Destination", buildResult.getMatchedVertexValue());
    assertEquals("Source", buildResult.getDestination());
    assertEquals("Source", buildResult.getAdjacentMatchedVertexValue());
    assertEquals(MatchedVertex.SOURCE, buildResult.getMatchedVertex());
  }

  /**
   * Test {@link Edge#setIdentifiers(Object, Object, boolean, MatchedVertex)} with {@code source}, {@code destination}, {@code directed}, {@code matchedVertex}.
   * <p>
   * Method under test: {@link Edge#setIdentifiers(Object, Object, boolean, MatchedVertex)}
   */
  @Test
  @DisplayName("Test setIdentifiers(Object, Object, boolean, MatchedVertex) with 'source', 'destination', 'directed', 'matchedVertex'")
  @Tag("MaintainedByDiffblue")
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
   * Test {@link Edge#setIdentifiers(Object, Object, boolean, MatchedVertex)} with {@code source}, {@code destination}, {@code directed}, {@code matchedVertex}.
   * <p>
   * Method under test: {@link Edge#setIdentifiers(Object, Object, boolean, MatchedVertex)}
   */
  @Test
  @DisplayName("Test setIdentifiers(Object, Object, boolean, MatchedVertex) with 'source', 'destination', 'directed', 'matchedVertex'")
  @Tag("MaintainedByDiffblue")
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
   * Test {@link Edge#setIdentifiers(Object, Object, boolean, MatchedVertex)} with {@code source}, {@code destination}, {@code directed}, {@code matchedVertex}.
   * <p>
   * Method under test: {@link Edge#setIdentifiers(Object, Object, boolean, MatchedVertex)}
   */
  @Test
  @DisplayName("Test setIdentifiers(Object, Object, boolean, MatchedVertex) with 'source', 'destination', 'directed', 'matchedVertex'")
  @Tag("MaintainedByDiffblue")
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
   * Test {@link Edge#setIdentifiers(Object, Object, boolean, MatchedVertex)} with {@code source}, {@code destination}, {@code directed}, {@code matchedVertex}.
   * <p>
   * Method under test: {@link Edge#setIdentifiers(Object, Object, boolean, MatchedVertex)}
   */
  @Test
  @DisplayName("Test setIdentifiers(Object, Object, boolean, MatchedVertex) with 'source', 'destination', 'directed', 'matchedVertex'")
  @Tag("MaintainedByDiffblue")
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
   * Test {@link Edge#setIdentifiers(Object, Object, boolean, MatchedVertex)} with {@code source}, {@code destination}, {@code directed}, {@code matchedVertex}.
   * <p>
   * Method under test: {@link Edge#setIdentifiers(Object, Object, boolean, MatchedVertex)}
   */
  @Test
  @DisplayName("Test setIdentifiers(Object, Object, boolean, MatchedVertex) with 'source', 'destination', 'directed', 'matchedVertex'")
  @Tag("MaintainedByDiffblue")
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
   * Test {@link Edge#setIdentifiers(Object, Object, DirectedType)} with {@code source}, {@code destination}, {@code directedType}.
   * <p>
   * Method under test: {@link Edge#setIdentifiers(Object, Object, DirectedType)}
   */
  @Test
  @DisplayName("Test setIdentifiers(Object, Object, DirectedType) with 'source', 'destination', 'directedType'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Edge.setIdentifiers(Object, Object, DirectedType)"})
  void testSetIdentifiersWithSourceDestinationDirectedType() {
    // Arrange
    Edge buildResult = (new Builder()).dest("Dest")
        .directed(true)
        .group("Group")
        .matchedVertex(MatchedVertex.SOURCE)
        .source("Source")
        .build();

    // Act
    buildResult.setIdentifiers("Source", "Destination", DirectedType.UNDIRECTED);

    // Assert
    assertEquals("Source", buildResult.getMatchedVertexValue());
    assertEquals(DirectedType.UNDIRECTED, buildResult.getDirectedType());
    assertEquals(MatchedVertex.DESTINATION, buildResult.getMatchedVertex());
    assertFalse(buildResult.isDirected());
    assertTrue(buildResult.isUndirected());
  }

  /**
   * Test {@link Edge#setIdentifiers(Object, Object, DirectedType)} with {@code source}, {@code destination}, {@code directedType}.
   * <p>
   * Method under test: {@link Edge#setIdentifiers(Object, Object, DirectedType)}
   */
  @Test
  @DisplayName("Test setIdentifiers(Object, Object, DirectedType) with 'source', 'destination', 'directedType'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Edge.setIdentifiers(Object, Object, DirectedType)"})
  void testSetIdentifiersWithSourceDestinationDirectedType2() {
    // Arrange
    Edge buildResult = (new Builder()).dest("Dest")
        .directed(false)
        .group("Group")
        .matchedVertex(MatchedVertex.SOURCE)
        .source("Source")
        .build();

    // Act
    buildResult.setIdentifiers("Source", "Destination", DirectedType.UNDIRECTED);

    // Assert
    assertEquals("Destination", buildResult.getMatchedVertexValue());
    assertEquals("Source", buildResult.getDestination());
    assertEquals("Source", buildResult.getAdjacentMatchedVertexValue());
    assertEquals(MatchedVertex.SOURCE, buildResult.getMatchedVertex());
  }

  /**
   * Test {@link Edge#setIdentifiers(Object, Object, DirectedType, MatchedVertex)} with {@code source}, {@code destination}, {@code directedType}, {@code matchedVertex}.
   * <p>
   * Method under test: {@link Edge#setIdentifiers(Object, Object, DirectedType, MatchedVertex)}
   */
  @Test
  @DisplayName("Test setIdentifiers(Object, Object, DirectedType, MatchedVertex) with 'source', 'destination', 'directedType', 'matchedVertex'")
  @Tag("MaintainedByDiffblue")
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
   * Test {@link Edge#setIdentifiers(Object, Object, DirectedType, MatchedVertex)} with {@code source}, {@code destination}, {@code directedType}, {@code matchedVertex}.
   * <p>
   * Method under test: {@link Edge#setIdentifiers(Object, Object, DirectedType, MatchedVertex)}
   */
  @Test
  @DisplayName("Test setIdentifiers(Object, Object, DirectedType, MatchedVertex) with 'source', 'destination', 'directedType', 'matchedVertex'")
  @Tag("MaintainedByDiffblue")
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
   * Test {@link Edge#setIdentifiers(Object, Object, DirectedType, MatchedVertex)} with {@code source}, {@code destination}, {@code directedType}, {@code matchedVertex}.
   * <p>
   * Method under test: {@link Edge#setIdentifiers(Object, Object, DirectedType, MatchedVertex)}
   */
  @Test
  @DisplayName("Test setIdentifiers(Object, Object, DirectedType, MatchedVertex) with 'source', 'destination', 'directedType', 'matchedVertex'")
  @Tag("MaintainedByDiffblue")
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
   * Test {@link Edge#setIdentifiers(Object, Object, DirectedType, MatchedVertex)} with {@code source}, {@code destination}, {@code directedType}, {@code matchedVertex}.
   * <p>
   * Method under test: {@link Edge#setIdentifiers(Object, Object, DirectedType, MatchedVertex)}
   */
  @Test
  @DisplayName("Test setIdentifiers(Object, Object, DirectedType, MatchedVertex) with 'source', 'destination', 'directedType', 'matchedVertex'")
  @Tag("MaintainedByDiffblue")
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
   * Test {@link Edge#setIdentifiers(Object, Object, DirectedType, MatchedVertex)} with {@code source}, {@code destination}, {@code directedType}, {@code matchedVertex}.
   * <p>
   * Method under test: {@link Edge#setIdentifiers(Object, Object, DirectedType, MatchedVertex)}
   */
  @Test
  @DisplayName("Test setIdentifiers(Object, Object, DirectedType, MatchedVertex) with 'source', 'destination', 'directedType', 'matchedVertex'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Edge.setIdentifiers(Object, Object, DirectedType, MatchedVertex)"})
  void testSetIdentifiersWithSourceDestinationDirectedTypeMatchedVertex5() {
    // Arrange
    Edge edge = new Edge();

    // Act
    edge.setIdentifiers("Source", "Destination", DirectedType.UNDIRECTED, MatchedVertex.DESTINATION);

    // Assert
    assertEquals("Destination", edge.getSource());
    assertEquals("Destination", edge.getMatchedVertexValue());
    assertEquals("Source", edge.getDestination());
    assertEquals("Source", edge.getAdjacentMatchedVertexValue());
    assertEquals(MatchedVertex.SOURCE, edge.getMatchedVertex());
  }

  /**
   * Test {@link Edge#setIdentifiers(Object, Object, DirectedType)} with {@code source}, {@code destination}, {@code directedType}.
   * <ul>
   *   <li>Then {@link Edge#Edge()} Source byteValue is {@code A}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Edge#setIdentifiers(Object, Object, DirectedType)}
   */
  @Test
  @DisplayName("Test setIdentifiers(Object, Object, DirectedType) with 'source', 'destination', 'directedType'; then Edge() Source byteValue is 'A'")
  @Tag("MaintainedByDiffblue")
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
   * Test {@link Edge#setIdentifiers(Object, Object, DirectedType)} with {@code source}, {@code destination}, {@code directedType}.
   * <ul>
   *   <li>Then {@link Edge#Edge()} Source is {@code Destination}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Edge#setIdentifiers(Object, Object, DirectedType)}
   */
  @Test
  @DisplayName("Test setIdentifiers(Object, Object, DirectedType) with 'source', 'destination', 'directedType'; then Edge() Source is 'Destination'")
  @Tag("MaintainedByDiffblue")
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
   * Test {@link Edge#setIdentifiers(Object, Object, DirectedType)} with {@code source}, {@code destination}, {@code directedType}.
   * <ul>
   *   <li>Then {@link Edge#Edge()} Source is {@code Source}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Edge#setIdentifiers(Object, Object, DirectedType)}
   */
  @Test
  @DisplayName("Test setIdentifiers(Object, Object, DirectedType) with 'source', 'destination', 'directedType'; then Edge() Source is 'Source'")
  @Tag("MaintainedByDiffblue")
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
   * Test {@link Edge#setIdentifiers(Object, Object, boolean)} with {@code source}, {@code destination}, {@code directed}.
   * <ul>
   *   <li>Then {@link Edge#Edge()} Source is {@code Destination}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Edge#setIdentifiers(Object, Object, boolean)}
   */
  @Test
  @DisplayName("Test setIdentifiers(Object, Object, boolean) with 'source', 'destination', 'directed'; then Edge() Source is 'Destination'")
  @Tag("MaintainedByDiffblue")
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
   * Test {@link Edge#setIdentifiers(Object, Object, boolean)} with {@code source}, {@code destination}, {@code directed}.
   * <ul>
   *   <li>When {@code A}.</li>
   *   <li>Then {@link Edge#Edge()} Source byteValue is {@code A}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Edge#setIdentifiers(Object, Object, boolean)}
   */
  @Test
  @DisplayName("Test setIdentifiers(Object, Object, boolean) with 'source', 'destination', 'directed'; when 'A'; then Edge() Source byteValue is 'A'")
  @Tag("MaintainedByDiffblue")
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
   * Test {@link Edge#setIdentifiers(Object, Object, boolean)} with {@code source}, {@code destination}, {@code directed}.
   * <ul>
   *   <li>When {@code true}.</li>
   *   <li>Then {@link Edge#Edge()} Source is {@code Source}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Edge#setIdentifiers(Object, Object, boolean)}
   */
  @Test
  @DisplayName("Test setIdentifiers(Object, Object, boolean) with 'source', 'destination', 'directed'; when 'true'; then Edge() Source is 'Source'")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Edge#equals(Object)}
   *   <li>{@link Edge#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Edge.equals(Object)", "int Edge.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Edge buildResult = (new Builder()).dest("Dest")
        .directed(true)
        .group("Group")
        .matchedVertex(MatchedVertex.SOURCE)
        .source("Source")
        .build();
    Edge buildResult2 = (new Builder()).dest("Dest")
        .directed(true)
        .group("Group")
        .matchedVertex(MatchedVertex.SOURCE)
        .source("Source")
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Test {@link Edge#equals(Object)}, and {@link Edge#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Edge#equals(Object)}
   *   <li>{@link Edge#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Edge.equals(Object)", "int Edge.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Edge buildResult = (new Builder()).dest("Dest")
        .directed(true)
        .group("Group")
        .matchedVertex(MatchedVertex.SOURCE)
        .source("Source")
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult.hashCode());
  }

  /**
   * Test {@link Edge#equals(Edge)} with {@code edge}.
   * <p>
   * Method under test: {@link Edge#equals(Edge)}
   */
  @Test
  @DisplayName("Test equals(Edge) with 'edge'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Edge.equals(Edge)"})
  void testEqualsWithEdge() {
    // Arrange
    Edge buildResult = (new Builder()).dest("Dest")
        .directed(true)
        .group("Group")
        .matchedVertex(MatchedVertex.SOURCE)
        .source("Source")
        .build();

    // Act and Assert
    assertFalse(buildResult.equals(new Edge()));
  }

  /**
   * Test {@link Edge#equals(Edge)} with {@code edge}.
   * <p>
   * Method under test: {@link Edge#equals(Edge)}
   */
  @Test
  @DisplayName("Test equals(Edge) with 'edge'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Edge.equals(Edge)"})
  void testEqualsWithEdge2() {
    // Arrange
    ElementValueLoader valueLoader = mock(ElementValueLoader.class);
    doNothing().when(valueLoader).loadIdentifiers(Mockito.<Element>any());
    Edge edge = (new Builder()).dest("Dest")
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
   * Test {@link Edge#equals(Edge)} with {@code edge}.
   * <p>
   * Method under test: {@link Edge#equals(Edge)}
   */
  @Test
  @DisplayName("Test equals(Edge) with 'edge'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Edge.equals(Edge)"})
  void testEqualsWithEdge3() {
    // Arrange
    ElementValueLoader valueLoader = mock(ElementValueLoader.class);
    doNothing().when(valueLoader).loadIdentifiers(Mockito.<Element>any());
    Edge edge = (new Builder()).dest("Dest")
        .directed(false)
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
   * Test {@link Edge#equals(Edge)} with {@code edge}.
   * <ul>
   *   <li>Given {@link Edge#Edge()}.</li>
   *   <li>When {@link Edge#Edge()}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Edge#equals(Edge)}
   */
  @Test
  @DisplayName("Test equals(Edge) with 'edge'; given Edge(); when Edge(); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Edge.equals(Edge)"})
  void testEqualsWithEdge_givenEdge_whenEdge_thenReturnTrue() {
    // Arrange
    Edge edge = new Edge();

    // Act and Assert
    assertTrue(edge.equals(new Edge()));
  }

  /**
   * Test {@link Edge#equals(Edge)} with {@code edge}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Edge#equals(Edge)}
   */
  @Test
  @DisplayName("Test equals(Edge) with 'edge'; when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Edge.equals(Edge)"})
  void testEqualsWithEdge_whenNull() {
    // Arrange
    Edge edge = (new Builder()).dest("Dest")
        .directed(true)
        .group("Group")
        .matchedVertex(MatchedVertex.SOURCE)
        .source("Source")
        .build();

    // Act and Assert
    assertFalse((new LazyEdge(edge, mock(ElementValueLoader.class), mock(LazyProperties.class))).equals((Edge) null));
  }

  /**
   * Test {@link Edge#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Edge#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Edge.equals(Object)", "int Edge.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builder = mock(Builder.class);
    when(builder.dest(Mockito.<Object>any())).thenReturn(new Builder());
    Edge buildResult = builder.dest("Dest")
        .directed(true)
        .group("Group")
        .matchedVertex(MatchedVertex.SOURCE)
        .source("Source")
        .build();
    Edge buildResult2 = (new Builder()).dest("Dest")
        .directed(true)
        .group("Group")
        .matchedVertex(MatchedVertex.SOURCE)
        .source("Source")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link Edge#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Edge#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Edge.equals(Object)", "int Edge.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder builder = mock(Builder.class);
    when(builder.directed(anyBoolean())).thenReturn(new Builder());
    Builder builder2 = mock(Builder.class);
    when(builder2.dest(Mockito.<Object>any())).thenReturn(builder);
    Edge buildResult = builder2.dest("Dest")
        .directed(true)
        .group("Group")
        .matchedVertex(MatchedVertex.SOURCE)
        .source("Source")
        .build();
    Edge buildResult2 = (new Builder()).dest("Dest")
        .directed(true)
        .group("Group")
        .matchedVertex(MatchedVertex.SOURCE)
        .source("Source")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link Edge#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Edge#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Edge.equals(Object)", "int Edge.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Edge buildResult = (new Builder()).dest("Dest")
        .directed(true)
        .group("Group")
        .matchedVertex(MatchedVertex.SOURCE)
        .source("Source")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Test {@link Edge#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Edge#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Edge.equals(Object)", "int Edge.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Edge buildResult = (new Builder()).dest("Dest")
        .directed(true)
        .group("Group")
        .matchedVertex(MatchedVertex.SOURCE)
        .source("Source")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to Edge");
  }

  /**
   * Test {@link Edge#emptyClone()}.
   * <p>
   * Method under test: {@link Edge#emptyClone()}
   */
  @Test
  @DisplayName("Test emptyClone()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Edge Edge.emptyClone()"})
  void testEmptyClone() {
    // Arrange
    Edge buildResult = (new Builder()).dest("Dest")
        .directed(true)
        .group("Group")
        .matchedVertex(MatchedVertex.SOURCE)
        .source("Source")
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult.emptyClone());
  }

  /**
   * Test {@link Edge#emptyClone()}.
   * <ul>
   *   <li>Given {@link Edge#Edge()}.</li>
   *   <li>Then return {@link Edge#Edge()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Edge#emptyClone()}
   */
  @Test
  @DisplayName("Test emptyClone(); given Edge(); then return Edge()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Edge Edge.emptyClone()"})
  void testEmptyClone_givenEdge_thenReturnEdge() {
    // Arrange
    Edge edge = new Edge();

    // Act and Assert
    assertEquals(edge, edge.emptyClone());
  }

  /**
   * Test {@link Edge#shallowClone()}.
   * <p>
   * Method under test: {@link Edge#shallowClone()}
   */
  @Test
  @DisplayName("Test shallowClone()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Edge Edge.shallowClone()"})
  void testShallowClone() {
    // Arrange
    Edge buildResult = (new Builder()).dest("Dest")
        .directed(true)
        .group("Group")
        .matchedVertex(MatchedVertex.SOURCE)
        .source("Source")
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult.shallowClone());
  }

  /**
   * Test {@link Edge#shallowClone()}.
   * <ul>
   *   <li>Given {@link Edge#Edge()}.</li>
   *   <li>Then return {@link Edge#Edge()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Edge#shallowClone()}
   */
  @Test
  @DisplayName("Test shallowClone(); given Edge(); then return Edge()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Edge Edge.shallowClone()"})
  void testShallowClone_givenEdge_thenReturnEdge() {
    // Arrange
    Edge edge = new Edge();

    // Act and Assert
    assertEquals(edge, edge.shallowClone());
  }

  /**
   * Test {@link Edge#shallowClone()}.
   * <ul>
   *   <li>Given {@link LazyProperties} {@link LazyProperties#clone()} return {@link LazyProperties}.</li>
   *   <li>Then calls {@link LazyProperties#clone()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Edge#shallowClone()}
   */
  @Test
  @DisplayName("Test shallowClone(); given LazyProperties clone() return LazyProperties; then calls clone()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Edge Edge.shallowClone()"})
  void testShallowClone_givenLazyPropertiesCloneReturnLazyProperties_thenCallsClone() {
    // Arrange
    ElementValueLoader valueLoader = mock(ElementValueLoader.class);
    doNothing().when(valueLoader).loadIdentifiers(Mockito.<Element>any());
    LazyProperties lazyProperties = mock(LazyProperties.class);
    when(lazyProperties.clone()).thenReturn(mock(LazyProperties.class));
    Edge edge = (new Builder()).dest("Dest")
        .directed(true)
        .group("Group")
        .matchedVertex(MatchedVertex.SOURCE)
        .source("Source")
        .build();

    // Act
    Edge actualShallowCloneResult = (new LazyEdge(edge, valueLoader, lazyProperties)).shallowClone();

    // Assert
    verify(valueLoader).loadIdentifiers(isA(Element.class));
    verify(lazyProperties).clone();
    assertEquals("Dest", actualShallowCloneResult.getDestination());
    assertEquals("Dest", actualShallowCloneResult.getAdjacentMatchedVertexValue());
    assertEquals("Group", actualShallowCloneResult.getGroup());
    assertEquals("Source", actualShallowCloneResult.getSource());
    assertEquals("Source", actualShallowCloneResult.getMatchedVertexValue());
    assertEquals("uk.gov.gchq.gaffer.data.element.Edge", actualShallowCloneResult.getClassName());
    assertEquals(DirectedType.DIRECTED, actualShallowCloneResult.getDirectedType());
    assertEquals(MatchedVertex.SOURCE, actualShallowCloneResult.getMatchedVertex());
    assertFalse(actualShallowCloneResult.isUndirected());
    assertTrue(actualShallowCloneResult.isDirected());
  }

  /**
   * Test {@link Edge#shallowClone()}.
   * <ul>
   *   <li>Then return Properties Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Edge#shallowClone()}
   */
  @Test
  @DisplayName("Test shallowClone(); then return Properties Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Edge Edge.shallowClone()"})
  void testShallowClone_thenReturnPropertiesEmpty() {
    // Arrange
    ElementValueLoader valueLoader = mock(ElementValueLoader.class);
    doNothing().when(valueLoader).loadIdentifiers(Mockito.<Element>any());
    Edge edge = (new Builder()).dest("Dest")
        .directed(true)
        .group("Group")
        .matchedVertex(MatchedVertex.SOURCE)
        .source("Source")
        .build();

    // Act
    Edge actualShallowCloneResult = (new LazyEdge(edge, valueLoader)).shallowClone();

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
