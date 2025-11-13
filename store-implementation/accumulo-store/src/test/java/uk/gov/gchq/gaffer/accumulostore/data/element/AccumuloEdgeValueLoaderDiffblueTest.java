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

package uk.gov.gchq.gaffer.accumulostore.data.element;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.accumulo.core.data.ArrayByteSequence;
import org.apache.accumulo.core.data.ByteSequence;
import org.apache.accumulo.core.data.Key;
import org.apache.accumulo.core.data.Value;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uk.gov.gchq.gaffer.accumulostore.key.AccumuloElementConverter;
import uk.gov.gchq.gaffer.accumulostore.key.MockAccumuloElementConverter;
import uk.gov.gchq.gaffer.accumulostore.key.core.impl.byteEntity.ByteEntityAccumuloElementConverter;
import uk.gov.gchq.gaffer.data.element.Edge;
import uk.gov.gchq.gaffer.data.element.Edge.Builder;
import uk.gov.gchq.gaffer.data.element.Element;
import uk.gov.gchq.gaffer.data.element.id.DirectedType;
import uk.gov.gchq.gaffer.data.element.id.EdgeId;
import uk.gov.gchq.gaffer.data.element.id.EdgeId.MatchedVertex;
import uk.gov.gchq.gaffer.operation.data.EdgeSeed;
import uk.gov.gchq.gaffer.store.schema.Schema;

class AccumuloEdgeValueLoaderDiffblueTest {
  /**
   * Test {@link AccumuloEdgeValueLoader#AccumuloEdgeValueLoader(String, Key, Value, AccumuloElementConverter, Schema, boolean)}.
   * <ul>
   *   <li>Given {@code timestampProperty}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccumuloEdgeValueLoader#AccumuloEdgeValueLoader(String, Key, Value, AccumuloElementConverter, Schema, boolean)}
   */
  @Test
  @DisplayName("Test new AccumuloEdgeValueLoader(String, Key, Value, AccumuloElementConverter, Schema, boolean); given 'timestampProperty'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void AccumuloEdgeValueLoader.<init>(String, Key, Value, AccumuloElementConverter, Schema, boolean)"})
  void testNewAccumuloEdgeValueLoader_givenTimestampProperty() {
    // Arrange
    Key key = new Key();
    Value value = new Value();
    ByteEntityAccumuloElementConverter elementConverter = new ByteEntityAccumuloElementConverter(new Schema());

    Schema schema = new Schema();
    schema.addConfig("timestampProperty", "42");

    // Act
    AccumuloEdgeValueLoader actualAccumuloEdgeValueLoader = new AccumuloEdgeValueLoader("Group", key, value,
        elementConverter, schema, true);

    // Assert
    Key key2 = actualAccumuloEdgeValueLoader.key;
    ByteSequence columnFamilyData = key2.getColumnFamilyData();
    assertTrue(columnFamilyData instanceof ArrayByteSequence);
    ByteSequence columnQualifierData = key2.getColumnQualifierData();
    assertTrue(columnQualifierData instanceof ArrayByteSequence);
    ByteSequence columnVisibilityData = key2.getColumnVisibilityData();
    assertTrue(columnVisibilityData instanceof ArrayByteSequence);
    ByteSequence rowData = key2.getRowData();
    assertTrue(rowData instanceof ArrayByteSequence);
    assertTrue(actualAccumuloEdgeValueLoader.elementConverter instanceof ByteEntityAccumuloElementConverter);
    assertEquals(0, key2.getLength());
    assertEquals(0, key2.getSize());
    assertFalse(key2.isDeleted());
    assertEquals(Long.MAX_VALUE, key2.getTimestamp());
    assertEquals(columnFamilyData, columnQualifierData);
    assertEquals(columnFamilyData, columnVisibilityData);
    assertEquals(columnFamilyData, rowData);
  }

  /**
   * Test {@link AccumuloEdgeValueLoader#AccumuloEdgeValueLoader(String, Key, Value, AccumuloElementConverter, Schema, boolean)}.
   * <ul>
   *   <li>When {@link Schema#Schema()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccumuloEdgeValueLoader#AccumuloEdgeValueLoader(String, Key, Value, AccumuloElementConverter, Schema, boolean)}
   */
  @Test
  @DisplayName("Test new AccumuloEdgeValueLoader(String, Key, Value, AccumuloElementConverter, Schema, boolean); when Schema()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void AccumuloEdgeValueLoader.<init>(String, Key, Value, AccumuloElementConverter, Schema, boolean)"})
  void testNewAccumuloEdgeValueLoader_whenSchema() {
    // Arrange
    Key key = new Key();
    Value value = new Value();
    ByteEntityAccumuloElementConverter elementConverter = new ByteEntityAccumuloElementConverter(new Schema());

    // Act
    AccumuloEdgeValueLoader actualAccumuloEdgeValueLoader = new AccumuloEdgeValueLoader("Group", key, value,
        elementConverter, new Schema(), true);

    // Assert
    Key key2 = actualAccumuloEdgeValueLoader.key;
    ByteSequence columnFamilyData = key2.getColumnFamilyData();
    assertTrue(columnFamilyData instanceof ArrayByteSequence);
    ByteSequence columnQualifierData = key2.getColumnQualifierData();
    assertTrue(columnQualifierData instanceof ArrayByteSequence);
    ByteSequence columnVisibilityData = key2.getColumnVisibilityData();
    assertTrue(columnVisibilityData instanceof ArrayByteSequence);
    ByteSequence rowData = key2.getRowData();
    assertTrue(rowData instanceof ArrayByteSequence);
    assertTrue(actualAccumuloEdgeValueLoader.elementConverter instanceof ByteEntityAccumuloElementConverter);
    assertEquals(0, key2.getLength());
    assertEquals(0, key2.getSize());
    assertFalse(key2.isDeleted());
    assertEquals(Long.MAX_VALUE, key2.getTimestamp());
    assertEquals(columnFamilyData, columnQualifierData);
    assertEquals(columnFamilyData, columnVisibilityData);
    assertEquals(columnFamilyData, rowData);
  }

  /**
   * Test {@link AccumuloEdgeValueLoader#loadIdentifiers(Element)}.
   * <p>
   * Method under test: {@link AccumuloEdgeValueLoader#loadIdentifiers(Element)}
   */
  @Test
  @DisplayName("Test loadIdentifiers(Element)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AccumuloEdgeValueLoader.loadIdentifiers(Element)"})
  void testLoadIdentifiers() {
    // Arrange
    MockAccumuloElementConverter elementConverter = mock(MockAccumuloElementConverter.class);
    when(elementConverter.getElementId(Mockito.<Key>any(), anyBoolean())).thenReturn(new Edge("Group"));
    Key key = new Key();
    Value value = new Value();
    AccumuloEdgeValueLoader accumuloEdgeValueLoader = new AccumuloEdgeValueLoader("Group", key, value, elementConverter,
        new Schema(), true);

    // Act
    accumuloEdgeValueLoader.loadIdentifiers(new Edge("Group"));

    // Assert
    verify(elementConverter).getElementId(isA(Key.class), eq(true));
  }

  /**
   * Test {@link AccumuloEdgeValueLoader#loadIdentifiers(Element)}.
   * <ul>
   *   <li>Given {@link MockAccumuloElementConverter} {@link MockAccumuloElementConverter#getElementId(Key, boolean)} return {@link EdgeSeed#EdgeSeed()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccumuloEdgeValueLoader#loadIdentifiers(Element)}
   */
  @Test
  @DisplayName("Test loadIdentifiers(Element); given MockAccumuloElementConverter getElementId(Key, boolean) return EdgeSeed()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AccumuloEdgeValueLoader.loadIdentifiers(Element)"})
  void testLoadIdentifiers_givenMockAccumuloElementConverterGetElementIdReturnEdgeSeed() {
    // Arrange
    MockAccumuloElementConverter elementConverter = mock(MockAccumuloElementConverter.class);
    when(elementConverter.getElementId(Mockito.<Key>any(), anyBoolean())).thenReturn(new EdgeSeed());
    Key key = new Key();
    Value value = new Value();
    AccumuloEdgeValueLoader accumuloEdgeValueLoader = new AccumuloEdgeValueLoader("Group", key, value, elementConverter,
        new Schema(), true);

    // Act
    accumuloEdgeValueLoader.loadIdentifiers(new Edge("Group"));

    // Assert that nothing has changed
    verify(elementConverter).getElementId(isA(Key.class), eq(true));
  }

  /**
   * Test {@link AccumuloEdgeValueLoader#loadIdentifiers(Element)}.
   * <ul>
   *   <li>Then {@link Edge#Edge(String)} with {@code Group} Destination is {@code Dest}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccumuloEdgeValueLoader#loadIdentifiers(Element)}
   */
  @Test
  @DisplayName("Test loadIdentifiers(Element); then Edge(String) with 'Group' Destination is 'Dest'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AccumuloEdgeValueLoader.loadIdentifiers(Element)"})
  void testLoadIdentifiers_thenEdgeWithGroupDestinationIsDest() {
    // Arrange
    MockAccumuloElementConverter elementConverter = mock(MockAccumuloElementConverter.class);
    Edge buildResult = (new Builder()).dest("Dest")
        .directed(true)
        .group("Group")
        .matchedVertex(MatchedVertex.SOURCE)
        .source("Source")
        .build();
    when(elementConverter.getElementId(Mockito.<Key>any(), anyBoolean())).thenReturn(buildResult);
    Key key = new Key();
    Value value = new Value();
    AccumuloEdgeValueLoader accumuloEdgeValueLoader = new AccumuloEdgeValueLoader("Group", key, value, elementConverter,
        new Schema(), true);
    Edge edge = new Edge("Group");

    // Act
    accumuloEdgeValueLoader.loadIdentifiers(edge);

    // Assert
    verify(elementConverter).getElementId(isA(Key.class), eq(true));
    assertEquals("Dest", edge.getDestination());
    assertEquals("Dest", edge.getAdjacentMatchedVertexValue());
    assertEquals("Source", edge.getSource());
    assertEquals("Source", edge.getMatchedVertexValue());
    assertEquals(DirectedType.DIRECTED, edge.getDirectedType());
    assertEquals(MatchedVertex.SOURCE, edge.getMatchedVertex());
    assertFalse(edge.isUndirected());
    assertTrue(edge.isDirected());
  }

  /**
   * Test {@link AccumuloEdgeValueLoader#loadIdentifiers(Element)}.
   * <ul>
   *   <li>Then {@link Edge#Edge(String)} with {@code Group} Destination is {@code Destination}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccumuloEdgeValueLoader#loadIdentifiers(Element)}
   */
  @Test
  @DisplayName("Test loadIdentifiers(Element); then Edge(String) with 'Group' Destination is 'Destination'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AccumuloEdgeValueLoader.loadIdentifiers(Element)"})
  void testLoadIdentifiers_thenEdgeWithGroupDestinationIsDestination() {
    // Arrange
    Edge edge = mock(Edge.class);
    when(edge.isDirected()).thenReturn(true);
    when(edge.getDestination()).thenReturn("Destination");
    when(edge.getSource()).thenReturn("Source");
    when(edge.getMatchedVertex()).thenReturn(MatchedVertex.SOURCE);
    MockAccumuloElementConverter elementConverter = mock(MockAccumuloElementConverter.class);
    when(elementConverter.getElementId(Mockito.<Key>any(), anyBoolean())).thenReturn(edge);
    Key key = new Key();
    Value value = new Value();
    AccumuloEdgeValueLoader accumuloEdgeValueLoader = new AccumuloEdgeValueLoader("Group", key, value, elementConverter,
        new Schema(), true);
    Edge edge2 = new Edge("Group");

    // Act
    accumuloEdgeValueLoader.loadIdentifiers(edge2);

    // Assert
    verify(elementConverter).getElementId(isA(Key.class), eq(true));
    verify(edge).getDestination();
    verify(edge).getMatchedVertex();
    verify(edge).getSource();
    verify(edge).isDirected();
    assertEquals("Destination", edge2.getDestination());
    assertEquals("Destination", edge2.getAdjacentMatchedVertexValue());
    assertEquals("Source", edge2.getSource());
    assertEquals("Source", edge2.getMatchedVertexValue());
    assertEquals(DirectedType.DIRECTED, edge2.getDirectedType());
    assertEquals(MatchedVertex.SOURCE, edge2.getMatchedVertex());
    assertFalse(edge2.isUndirected());
    assertTrue(edge2.isDirected());
  }

  /**
   * Test {@link AccumuloEdgeValueLoader#loadIdentifiers(Element)}.
   * <ul>
   *   <li>Then {@link Edge#Edge(String)} with {@code Group} Source is {@code Destination}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccumuloEdgeValueLoader#loadIdentifiers(Element)}
   */
  @Test
  @DisplayName("Test loadIdentifiers(Element); then Edge(String) with 'Group' Source is 'Destination'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AccumuloEdgeValueLoader.loadIdentifiers(Element)"})
  void testLoadIdentifiers_thenEdgeWithGroupSourceIsDestination() {
    // Arrange
    Edge edge = mock(Edge.class);
    when(edge.isDirected()).thenReturn(false);
    when(edge.getDestination()).thenReturn("Destination");
    when(edge.getSource()).thenReturn("Source");
    when(edge.getMatchedVertex()).thenReturn(MatchedVertex.SOURCE);
    MockAccumuloElementConverter elementConverter = mock(MockAccumuloElementConverter.class);
    when(elementConverter.getElementId(Mockito.<Key>any(), anyBoolean())).thenReturn(edge);
    Key key = new Key();
    Value value = new Value();
    AccumuloEdgeValueLoader accumuloEdgeValueLoader = new AccumuloEdgeValueLoader("Group", key, value, elementConverter,
        new Schema(), true);
    Edge edge2 = new Edge("Group");

    // Act
    accumuloEdgeValueLoader.loadIdentifiers(edge2);

    // Assert
    verify(elementConverter).getElementId(isA(Key.class), eq(true));
    verify(edge).getDestination();
    verify(edge).getMatchedVertex();
    verify(edge).getSource();
    verify(edge).isDirected();
    assertEquals("Destination", edge2.getSource());
    assertEquals("Destination", edge2.getAdjacentMatchedVertexValue());
    assertEquals("Source", edge2.getDestination());
    assertEquals(DirectedType.UNDIRECTED, edge2.getDirectedType());
    assertEquals(MatchedVertex.DESTINATION, edge2.getMatchedVertex());
    assertFalse(edge2.isDirected());
    assertTrue(edge2.isUndirected());
  }

  /**
   * Test {@link AccumuloEdgeValueLoader#loadIdentifiers(Element)}.
   * <ul>
   *   <li>When {@link Edge} {@link Edge#setIdentifiers(Object, Object, boolean, MatchedVertex)} does nothing.</li>
   *   <li>Then calls {@link Edge#setIdentifiers(Object, Object, boolean, MatchedVertex)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccumuloEdgeValueLoader#loadIdentifiers(Element)}
   */
  @Test
  @DisplayName("Test loadIdentifiers(Element); when Edge setIdentifiers(Object, Object, boolean, MatchedVertex) does nothing; then calls setIdentifiers(Object, Object, boolean, MatchedVertex)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AccumuloEdgeValueLoader.loadIdentifiers(Element)"})
  void testLoadIdentifiers_whenEdgeSetIdentifiersDoesNothing_thenCallsSetIdentifiers() {
    // Arrange
    Edge edge = mock(Edge.class);
    when(edge.isDirected()).thenReturn(true);
    when(edge.getDestination()).thenReturn("Destination");
    when(edge.getSource()).thenReturn("Source");
    when(edge.getMatchedVertex()).thenReturn(MatchedVertex.SOURCE);
    MockAccumuloElementConverter elementConverter = mock(MockAccumuloElementConverter.class);
    when(elementConverter.getElementId(Mockito.<Key>any(), anyBoolean())).thenReturn(edge);
    Key key = new Key();
    Value value = new Value();
    AccumuloEdgeValueLoader accumuloEdgeValueLoader = new AccumuloEdgeValueLoader("Group", key, value, elementConverter,
        new Schema(), true);
    Edge edge2 = mock(Edge.class);
    doNothing().when(edge2)
        .setIdentifiers(Mockito.<Object>any(), Mockito.<Object>any(), anyBoolean(), Mockito.<MatchedVertex>any());

    // Act
    accumuloEdgeValueLoader.loadIdentifiers(edge2);

    // Assert
    verify(elementConverter).getElementId(isA(Key.class), eq(true));
    verify(edge).getDestination();
    verify(edge).getMatchedVertex();
    verify(edge).getSource();
    verify(edge).isDirected();
    verify(edge2).setIdentifiers(isA(Object.class), isA(Object.class), eq(true), eq(MatchedVertex.SOURCE));
  }
}
