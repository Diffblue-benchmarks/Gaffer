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

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
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
import com.diffblue.cover.annotations.ManagedByDiffblue;
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
import uk.gov.gchq.gaffer.store.schema.Schema;

class AccumuloEdgeValueLoaderDiffblueTest {
  /**
   * Test {@link AccumuloEdgeValueLoader#AccumuloEdgeValueLoader(String, Key, Value,
   * AccumuloElementConverter, Schema, boolean)}.
   *
   * <ul>
   *   <li>Given {@code Config}.
   *   <li>Then calls {@link Schema#getConfig(String)}.
   * </ul>
   *
   * <p>Method under test: {@link AccumuloEdgeValueLoader#AccumuloEdgeValueLoader(String, Key,
   * Value, AccumuloElementConverter, Schema, boolean)}
   */
  @Test
  @DisplayName(
      "Test new AccumuloEdgeValueLoader(String, Key, Value, AccumuloElementConverter, Schema, boolean); given 'Config'; then calls getConfig(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AccumuloEdgeValueLoader.<init>(String, Key, Value, AccumuloElementConverter, Schema, boolean)"
  })
  void testNewAccumuloEdgeValueLoader_givenConfig_thenCallsGetConfig() {
    // Arrange
    Key key = new Key();
    Value value = new Value();
    ByteEntityAccumuloElementConverter elementConverter =
        new ByteEntityAccumuloElementConverter(new Schema());

    Schema schema = mock(Schema.class);
    when(schema.getConfig(Mockito.<String>any())).thenReturn("Config");

    // Act
    AccumuloEdgeValueLoader actualAccumuloEdgeValueLoader =
        new AccumuloEdgeValueLoader("Group", key, value, elementConverter, schema, true);

    // Assert
    verify(schema).getConfig("timestampProperty");
    Key key2 = actualAccumuloEdgeValueLoader.key;
    ByteSequence columnFamilyData = key2.getColumnFamilyData();
    assertTrue(columnFamilyData instanceof ArrayByteSequence);
    ByteSequence columnQualifierData = key2.getColumnQualifierData();
    assertTrue(columnQualifierData instanceof ArrayByteSequence);
    ByteSequence columnVisibilityData = key2.getColumnVisibilityData();
    assertTrue(columnVisibilityData instanceof ArrayByteSequence);
    ByteSequence rowData = key2.getRowData();
    assertTrue(rowData instanceof ArrayByteSequence);
    assertEquals(columnFamilyData, columnQualifierData);
    assertEquals(columnFamilyData, columnVisibilityData);
    assertEquals(columnFamilyData, rowData);
    assertArrayEquals(new byte[] {}, key2.getColumnVisibilityParsed().flatten());
  }

  /**
   * Test {@link AccumuloEdgeValueLoader#AccumuloEdgeValueLoader(String, Key, Value,
   * AccumuloElementConverter, Schema, boolean)}.
   *
   * <ul>
   *   <li>Given {@code timestampProperty}.
   * </ul>
   *
   * <p>Method under test: {@link AccumuloEdgeValueLoader#AccumuloEdgeValueLoader(String, Key,
   * Value, AccumuloElementConverter, Schema, boolean)}
   */
  @Test
  @DisplayName(
      "Test new AccumuloEdgeValueLoader(String, Key, Value, AccumuloElementConverter, Schema, boolean); given 'timestampProperty'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AccumuloEdgeValueLoader.<init>(String, Key, Value, AccumuloElementConverter, Schema, boolean)"
  })
  void testNewAccumuloEdgeValueLoader_givenTimestampProperty() {
    // Arrange
    Key key = new Key();
    Value value = new Value();
    ByteEntityAccumuloElementConverter elementConverter =
        new ByteEntityAccumuloElementConverter(new Schema());

    Schema schema = new Schema();
    schema.addConfig("timestampProperty", "Schema");

    // Act
    AccumuloEdgeValueLoader actualAccumuloEdgeValueLoader =
        new AccumuloEdgeValueLoader("Group", key, value, elementConverter, schema, true);

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
    assertEquals(columnFamilyData, columnQualifierData);
    assertEquals(columnFamilyData, columnVisibilityData);
    assertEquals(columnFamilyData, rowData);
    assertArrayEquals(new byte[] {}, key2.getColumnVisibilityParsed().flatten());
  }

  /**
   * Test {@link AccumuloEdgeValueLoader#AccumuloEdgeValueLoader(String, Key, Value,
   * AccumuloElementConverter, Schema, boolean)}.
   *
   * <ul>
   *   <li>When {@link Schema#Schema()}.
   * </ul>
   *
   * <p>Method under test: {@link AccumuloEdgeValueLoader#AccumuloEdgeValueLoader(String, Key,
   * Value, AccumuloElementConverter, Schema, boolean)}
   */
  @Test
  @DisplayName(
      "Test new AccumuloEdgeValueLoader(String, Key, Value, AccumuloElementConverter, Schema, boolean); when Schema()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AccumuloEdgeValueLoader.<init>(String, Key, Value, AccumuloElementConverter, Schema, boolean)"
  })
  void testNewAccumuloEdgeValueLoader_whenSchema() {
    // Arrange
    Key key = new Key();
    Value value = new Value();
    ByteEntityAccumuloElementConverter elementConverter =
        new ByteEntityAccumuloElementConverter(new Schema());

    // Act
    AccumuloEdgeValueLoader actualAccumuloEdgeValueLoader =
        new AccumuloEdgeValueLoader("Group", key, value, elementConverter, new Schema(), true);

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
    assertEquals(columnFamilyData, columnQualifierData);
    assertEquals(columnFamilyData, columnVisibilityData);
    assertEquals(columnFamilyData, rowData);
    assertArrayEquals(new byte[] {}, key2.getColumnVisibilityParsed().flatten());
  }

  /**
   * Test {@link AccumuloEdgeValueLoader#loadIdentifiers(Element)}.
   *
   * <p>Method under test: {@link AccumuloEdgeValueLoader#loadIdentifiers(Element)}
   */
  @Test
  @DisplayName("Test loadIdentifiers(Element)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AccumuloEdgeValueLoader.loadIdentifiers(Element)"})
  void testLoadIdentifiers() {
    // Arrange
    MockAccumuloElementConverter elementConverter = mock(MockAccumuloElementConverter.class);
    when(elementConverter.getElementId(Mockito.<Key>any(), anyBoolean()))
        .thenReturn(
            new Builder()
                .dest("Dest")
                .directed(false)
                .group("Group")
                .matchedVertex(MatchedVertex.SOURCE)
                .source("Source")
                .build());
    Key key = new Key();
    Value value = new Value();

    AccumuloEdgeValueLoader accumuloEdgeValueLoader =
        new AccumuloEdgeValueLoader("Group", key, value, elementConverter, new Schema(), true);

    Edge edge = mock(Edge.class);
    doNothing()
        .when(edge)
        .setIdentifiers(
            Mockito.<Object>any(),
            Mockito.<Object>any(),
            anyBoolean(),
            Mockito.<MatchedVertex>any());

    // Act
    accumuloEdgeValueLoader.loadIdentifiers(edge);

    // Assert
    verify(elementConverter).getElementId(isA(Key.class), eq(true));
    verify(edge)
        .setIdentifiers(
            isA(Object.class), isA(Object.class), eq(false), eq(MatchedVertex.DESTINATION));
  }

  /**
   * Test {@link AccumuloEdgeValueLoader#loadIdentifiers(Element)}.
   *
   * <ul>
   *   <li>Then {@link Edge#Edge(String)} with {@code Group} Destination is {@code Dest}.
   * </ul>
   *
   * <p>Method under test: {@link AccumuloEdgeValueLoader#loadIdentifiers(Element)}
   */
  @Test
  @DisplayName(
      "Test loadIdentifiers(Element); then Edge(String) with 'Group' Destination is 'Dest'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AccumuloEdgeValueLoader.loadIdentifiers(Element)"})
  void testLoadIdentifiers_thenEdgeWithGroupDestinationIsDest() {
    // Arrange
    MockAccumuloElementConverter elementConverter = mock(MockAccumuloElementConverter.class);
    when(elementConverter.getElementId(Mockito.<Key>any(), anyBoolean()))
        .thenReturn(
            new Builder()
                .dest("Dest")
                .directed(true)
                .group("Group")
                .matchedVertex(MatchedVertex.SOURCE)
                .source("Source")
                .build());
    Key key = new Key();
    Value value = new Value();

    AccumuloEdgeValueLoader accumuloEdgeValueLoader =
        new AccumuloEdgeValueLoader("Group", key, value, elementConverter, new Schema(), true);
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
   *
   * <ul>
   *   <li>When {@link Edge} {@link Edge#setIdentifiers(Object, Object, boolean, MatchedVertex)}
   *       does nothing.
   *   <li>Then calls {@link Edge#setIdentifiers(Object, Object, boolean, MatchedVertex)}.
   * </ul>
   *
   * <p>Method under test: {@link AccumuloEdgeValueLoader#loadIdentifiers(Element)}
   */
  @Test
  @DisplayName(
      "Test loadIdentifiers(Element); when Edge setIdentifiers(Object, Object, boolean, MatchedVertex) does nothing; then calls setIdentifiers(Object, Object, boolean, MatchedVertex)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AccumuloEdgeValueLoader.loadIdentifiers(Element)"})
  void testLoadIdentifiers_whenEdgeSetIdentifiersDoesNothing_thenCallsSetIdentifiers() {
    // Arrange
    MockAccumuloElementConverter elementConverter = mock(MockAccumuloElementConverter.class);
    when(elementConverter.getElementId(Mockito.<Key>any(), anyBoolean()))
        .thenReturn(
            new Builder()
                .dest("Dest")
                .directed(true)
                .group("Group")
                .matchedVertex(MatchedVertex.SOURCE)
                .source("Source")
                .build());
    Key key = new Key();
    Value value = new Value();

    AccumuloEdgeValueLoader accumuloEdgeValueLoader =
        new AccumuloEdgeValueLoader("Group", key, value, elementConverter, new Schema(), true);

    Edge edge = mock(Edge.class);
    doNothing()
        .when(edge)
        .setIdentifiers(
            Mockito.<Object>any(),
            Mockito.<Object>any(),
            anyBoolean(),
            Mockito.<MatchedVertex>any());

    // Act
    accumuloEdgeValueLoader.loadIdentifiers(edge);

    // Assert
    verify(elementConverter).getElementId(isA(Key.class), eq(true));
    verify(edge)
        .setIdentifiers(isA(Object.class), isA(Object.class), eq(true), eq(MatchedVertex.SOURCE));
  }
}
