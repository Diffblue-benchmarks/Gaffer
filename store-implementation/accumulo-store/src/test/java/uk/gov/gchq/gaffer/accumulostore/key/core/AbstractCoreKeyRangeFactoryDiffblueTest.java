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

package uk.gov.gchq.gaffer.accumulostore.key.core;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.apache.accumulo.core.data.ArrayByteSequence;
import org.apache.accumulo.core.data.ByteSequence;
import org.apache.accumulo.core.data.Key;
import org.apache.accumulo.core.data.Range;
import org.apache.accumulo.core.dataImpl.thrift.TKey;
import org.apache.accumulo.core.dataImpl.thrift.TRange;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uk.gov.gchq.gaffer.accumulostore.key.core.impl.byteEntity.ByteEntityRangeFactory;
import uk.gov.gchq.gaffer.accumulostore.key.exception.RangeFactoryException;
import uk.gov.gchq.gaffer.accumulostore.operation.impl.GetElementsBetweenSets;
import uk.gov.gchq.gaffer.commonutil.pair.Pair;
import uk.gov.gchq.gaffer.data.element.Edge;
import uk.gov.gchq.gaffer.data.element.Entity;
import uk.gov.gchq.gaffer.data.element.Entity.Builder;
import uk.gov.gchq.gaffer.data.element.id.DirectedType;
import uk.gov.gchq.gaffer.data.element.id.ElementId;
import uk.gov.gchq.gaffer.data.elementdefinition.view.NamedView;
import uk.gov.gchq.gaffer.data.elementdefinition.view.View;
import uk.gov.gchq.gaffer.exception.SerialisationException;
import uk.gov.gchq.gaffer.operation.data.EdgeSeed;
import uk.gov.gchq.gaffer.operation.graph.GraphFilters;
import uk.gov.gchq.gaffer.serialisation.AvroSerialiser;
import uk.gov.gchq.gaffer.store.schema.Schema;

class AbstractCoreKeyRangeFactoryDiffblueTest {
  /**
   * Test {@link AbstractCoreKeyRangeFactory#getRange(ElementId, GraphFilters)} with {@code elementId}, {@code operation}.
   * <ul>
   *   <li>Given {@link View} (default constructor).</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractCoreKeyRangeFactory#getRange(ElementId, GraphFilters)}
   */
  @Test
  @DisplayName("Test getRange(ElementId, GraphFilters) with 'elementId', 'operation'; given View (default constructor); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.List AbstractCoreKeyRangeFactory.getRange(ElementId, GraphFilters)"})
  void testGetRangeWithElementIdOperation_givenView_thenReturnEmpty() throws RangeFactoryException {
    // Arrange
    ByteEntityRangeFactory byteEntityRangeFactory = new ByteEntityRangeFactory(new Schema());
    EdgeSeed elementId = new EdgeSeed();

    GetElementsBetweenSets operation = new GetElementsBetweenSets();
    operation.setView(new View());

    // Act and Assert
    assertTrue(byteEntityRangeFactory.getRange(elementId, operation).isEmpty());
  }

  /**
   * Test {@link AbstractCoreKeyRangeFactory#getRangeFromPair(Pair, GraphFilters)}.
   * <ul>
   *   <li>Given {@code UNDIRECTED}.</li>
   *   <li>When {@link Edge} {@link Edge#getDirectedType()} return {@code DIRECTED}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractCoreKeyRangeFactory#getRangeFromPair(Pair, GraphFilters)}
   */
  @Test
  @DisplayName("Test getRangeFromPair(Pair, GraphFilters); given 'UNDIRECTED'; when Edge getDirectedType() return 'DIRECTED'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Range AbstractCoreKeyRangeFactory.getRangeFromPair(Pair, GraphFilters)"})
  void testGetRangeFromPair_givenUndirected_whenEdgeGetDirectedTypeReturnDirected()
      throws UnsupportedEncodingException, RangeFactoryException, SerialisationException {
    // Arrange
    AvroSerialiser avroSerialiser = mock(AvroSerialiser.class);
    when(avroSerialiser.serialise(Mockito.<Object>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    Schema schema = mock(Schema.class);
    when(schema.getVertexSerialiser()).thenReturn(avroSerialiser);
    ByteEntityRangeFactory byteEntityRangeFactory = new ByteEntityRangeFactory(schema);
    Edge edge = mock(Edge.class);
    when(edge.getDestination()).thenReturn("Destination");
    when(edge.getSource()).thenReturn("Source");
    when(edge.getDirectedType()).thenReturn(DirectedType.DIRECTED);
    Edge edge2 = mock(Edge.class);
    when(edge2.getDestination()).thenReturn("Destination");
    when(edge2.getSource()).thenReturn("Source");
    when(edge2.getDirectedType()).thenReturn(DirectedType.EITHER);
    Pair<ElementId, ElementId> pairRange = new Pair<>(edge, edge2);

    NamedView namedView = mock(NamedView.class);
    when(namedView.hasEdges()).thenReturn(true);
    when(namedView.hasEntities()).thenReturn(true);
    GraphFilters operation = mock(GraphFilters.class);
    when(operation.getDirectedType()).thenReturn(DirectedType.UNDIRECTED);
    when(operation.getView()).thenReturn(namedView);

    // Act
    Range actualRangeFromPair = byteEntityRangeFactory.getRangeFromPair(pairRange, operation);

    // Assert
    verify(edge).getDestination();
    verify(edge2, atLeast(1)).getDestination();
    verify(edge).getDirectedType();
    verify(edge2, atLeast(1)).getDirectedType();
    verify(edge).getSource();
    verify(edge2, atLeast(1)).getSource();
    verify(namedView, atLeast(1)).hasEdges();
    verify(namedView, atLeast(1)).hasEntities();
    verify(operation, atLeast(1)).getDirectedType();
    verify(operation, atLeast(1)).getView();
    verify(avroSerialiser, atLeast(1)).serialise(Mockito.<Object>any());
    verify(schema, atLeast(1)).getVertexSerialiser();
    Key endKey = actualRangeFromPair.getEndKey();
    ByteSequence rowData = endKey.getRowData();
    assertTrue(rowData instanceof ArrayByteSequence);
    Key startKey = actualRangeFromPair.getStartKey();
    ByteSequence rowData2 = startKey.getRowData();
    assertTrue(rowData2 instanceof ArrayByteSequence);
    TRange toThriftResult = actualRangeFromPair.toThrift();
    TKey start = toThriftResult.getStart();
    assertArrayEquals(new byte[]{}, start.getColFamily());
    TKey stop = toThriftResult.getStop();
    assertArrayEquals(new byte[]{}, stop.getColFamily());
    assertArrayEquals(new byte[]{}, start.getColQualifier());
    assertArrayEquals(new byte[]{}, stop.getColQualifier());
    assertArrayEquals(new byte[]{}, start.getColVisibility());
    assertArrayEquals(new byte[]{}, stop.getColVisibility());
    assertArrayEquals(new byte[]{}, endKey.getColumnVisibilityParsed().flatten());
    assertArrayEquals(new byte[]{}, startKey.getColumnVisibilityParsed().flatten());
    assertArrayEquals(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 1}, rowData2.getBackingArray());
    assertArrayEquals(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 1}, start.getRow());
    assertArrayEquals(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 1}, startKey.getRow().getBytes());
    assertArrayEquals(
        new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 4, 0, 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 4, 1},
        rowData.getBackingArray());
    assertArrayEquals(
        new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 4, 0, 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 4, 1},
        stop.getRow());
    assertArrayEquals(
        new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 4, 0, 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 4, 1},
        endKey.getRow().getBytes());
  }

  /**
   * Test {@link AbstractCoreKeyRangeFactory#getRangeFromPair(Pair, GraphFilters)}.
   * <ul>
   *   <li>Given {@code UNDIRECTED}.</li>
   *   <li>When {@link Edge} {@link Edge#getDirectedType()} return {@code UNDIRECTED}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractCoreKeyRangeFactory#getRangeFromPair(Pair, GraphFilters)}
   */
  @Test
  @DisplayName("Test getRangeFromPair(Pair, GraphFilters); given 'UNDIRECTED'; when Edge getDirectedType() return 'UNDIRECTED'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Range AbstractCoreKeyRangeFactory.getRangeFromPair(Pair, GraphFilters)"})
  void testGetRangeFromPair_givenUndirected_whenEdgeGetDirectedTypeReturnUndirected()
      throws UnsupportedEncodingException, RangeFactoryException, SerialisationException {
    // Arrange
    AvroSerialiser avroSerialiser = mock(AvroSerialiser.class);
    when(avroSerialiser.serialise(Mockito.<Object>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    Schema schema = mock(Schema.class);
    when(schema.getVertexSerialiser()).thenReturn(avroSerialiser);
    ByteEntityRangeFactory byteEntityRangeFactory = new ByteEntityRangeFactory(schema);
    Edge edge = mock(Edge.class);
    when(edge.getDestination()).thenReturn("Destination");
    when(edge.getSource()).thenReturn("Source");
    when(edge.getDirectedType()).thenReturn(DirectedType.UNDIRECTED);
    Pair<ElementId, ElementId> pairRange = new Pair<>(edge, new EdgeSeed());

    NamedView namedView = mock(NamedView.class);
    when(namedView.hasEdges()).thenReturn(true);
    when(namedView.hasEntities()).thenReturn(true);
    GraphFilters operation = mock(GraphFilters.class);
    when(operation.getDirectedType()).thenReturn(DirectedType.DIRECTED);
    when(operation.getView()).thenReturn(namedView);

    // Act
    Range actualRangeFromPair = byteEntityRangeFactory.getRangeFromPair(pairRange, operation);

    // Assert
    verify(edge).getDestination();
    verify(edge).getDirectedType();
    verify(edge).getSource();
    verify(namedView, atLeast(1)).hasEdges();
    verify(namedView, atLeast(1)).hasEntities();
    verify(operation, atLeast(1)).getDirectedType();
    verify(operation, atLeast(1)).getView();
    verify(avroSerialiser, atLeast(1)).serialise(Mockito.<Object>any());
    verify(schema, atLeast(1)).getVertexSerialiser();
    Key endKey = actualRangeFromPair.getEndKey();
    ByteSequence rowData = endKey.getRowData();
    assertTrue(rowData instanceof ArrayByteSequence);
    Key startKey = actualRangeFromPair.getStartKey();
    ByteSequence rowData2 = startKey.getRowData();
    assertTrue(rowData2 instanceof ArrayByteSequence);
    TRange toThriftResult = actualRangeFromPair.toThrift();
    TKey start = toThriftResult.getStart();
    assertArrayEquals(new byte[]{}, start.getColFamily());
    TKey stop = toThriftResult.getStop();
    assertArrayEquals(new byte[]{}, stop.getColFamily());
    assertArrayEquals(new byte[]{}, start.getColQualifier());
    assertArrayEquals(new byte[]{}, stop.getColQualifier());
    assertArrayEquals(new byte[]{}, start.getColVisibility());
    assertArrayEquals(new byte[]{}, stop.getColVisibility());
    assertArrayEquals(new byte[]{}, endKey.getColumnVisibilityParsed().flatten());
    assertArrayEquals(new byte[]{}, startKey.getColumnVisibilityParsed().flatten());
    assertArrayEquals(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 1}, rowData2.getBackingArray());
    assertArrayEquals(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 1}, start.getRow());
    assertArrayEquals(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 1}, startKey.getRow().getBytes());
    assertArrayEquals(
        new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 2, 0, 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 2, 1},
        rowData.getBackingArray());
    assertArrayEquals(
        new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 2, 0, 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 2, 1},
        stop.getRow());
    assertArrayEquals(
        new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 2, 0, 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 2, 1},
        endKey.getRow().getBytes());
  }

  /**
   * Test {@link AbstractCoreKeyRangeFactory#getRangeFromPair(Pair, GraphFilters)}.
   * <ul>
   *   <li>Given {@code UNDIRECTED}.</li>
   *   <li>When {@link Edge} {@link Edge#getDirectedType()} return {@code UNDIRECTED}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractCoreKeyRangeFactory#getRangeFromPair(Pair, GraphFilters)}
   */
  @Test
  @DisplayName("Test getRangeFromPair(Pair, GraphFilters); given 'UNDIRECTED'; when Edge getDirectedType() return 'UNDIRECTED'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Range AbstractCoreKeyRangeFactory.getRangeFromPair(Pair, GraphFilters)"})
  void testGetRangeFromPair_givenUndirected_whenEdgeGetDirectedTypeReturnUndirected2()
      throws UnsupportedEncodingException, RangeFactoryException, SerialisationException {
    // Arrange
    AvroSerialiser avroSerialiser = mock(AvroSerialiser.class);
    when(avroSerialiser.serialise(Mockito.<Object>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    Schema schema = mock(Schema.class);
    when(schema.getVertexSerialiser()).thenReturn(avroSerialiser);
    ByteEntityRangeFactory byteEntityRangeFactory = new ByteEntityRangeFactory(schema);
    Edge edge = mock(Edge.class);
    when(edge.getDestination()).thenReturn("Destination");
    when(edge.getSource()).thenReturn("Source");
    when(edge.getDirectedType()).thenReturn(DirectedType.UNDIRECTED);
    Edge edge2 = mock(Edge.class);
    when(edge2.getDestination()).thenReturn("Destination");
    when(edge2.getSource()).thenReturn("Source");
    when(edge2.getDirectedType()).thenReturn(DirectedType.EITHER);
    Pair<ElementId, ElementId> pairRange = new Pair<>(edge, edge2);

    NamedView namedView = mock(NamedView.class);
    when(namedView.hasEdges()).thenReturn(true);
    when(namedView.hasEntities()).thenReturn(true);
    GraphFilters operation = mock(GraphFilters.class);
    when(operation.getDirectedType()).thenReturn(DirectedType.UNDIRECTED);
    when(operation.getView()).thenReturn(namedView);

    // Act
    Range actualRangeFromPair = byteEntityRangeFactory.getRangeFromPair(pairRange, operation);

    // Assert
    verify(edge, atLeast(1)).getDestination();
    verify(edge2, atLeast(1)).getDestination();
    verify(edge, atLeast(1)).getDirectedType();
    verify(edge2, atLeast(1)).getDirectedType();
    verify(edge, atLeast(1)).getSource();
    verify(edge2, atLeast(1)).getSource();
    verify(namedView, atLeast(1)).hasEdges();
    verify(namedView, atLeast(1)).hasEntities();
    verify(operation, atLeast(1)).getDirectedType();
    verify(operation, atLeast(1)).getView();
    verify(avroSerialiser, atLeast(1)).serialise(Mockito.<Object>any());
    verify(schema, atLeast(1)).getVertexSerialiser();
    Key endKey = actualRangeFromPair.getEndKey();
    ByteSequence rowData = endKey.getRowData();
    assertTrue(rowData instanceof ArrayByteSequence);
    Key startKey = actualRangeFromPair.getStartKey();
    ByteSequence rowData2 = startKey.getRowData();
    assertTrue(rowData2 instanceof ArrayByteSequence);
    TRange toThriftResult = actualRangeFromPair.toThrift();
    TKey start = toThriftResult.getStart();
    assertArrayEquals(new byte[]{}, start.getColFamily());
    TKey stop = toThriftResult.getStop();
    assertArrayEquals(new byte[]{}, stop.getColFamily());
    assertArrayEquals(new byte[]{}, start.getColQualifier());
    assertArrayEquals(new byte[]{}, stop.getColQualifier());
    assertArrayEquals(new byte[]{}, start.getColVisibility());
    assertArrayEquals(new byte[]{}, stop.getColVisibility());
    assertArrayEquals(new byte[]{}, endKey.getColumnVisibilityParsed().flatten());
    assertArrayEquals(new byte[]{}, startKey.getColumnVisibilityParsed().flatten());
    assertArrayEquals(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 1}, rowData2.getBackingArray());
    assertArrayEquals(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 1}, start.getRow());
    assertArrayEquals(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 1}, startKey.getRow().getBytes());
    assertArrayEquals(
        new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 4, 0, 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 4, 1},
        rowData.getBackingArray());
    assertArrayEquals(
        new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 4, 0, 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 4, 1},
        stop.getRow());
    assertArrayEquals(
        new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 4, 0, 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 4, 1},
        endKey.getRow().getBytes());
  }

  /**
   * Test {@link AbstractCoreKeyRangeFactory#getRangeFromPair(Pair, GraphFilters)}.
   * <ul>
   *   <li>Given {@code UNDIRECTED}.</li>
   *   <li>When {@link Pair#Pair(Object, Object)} with first is {@link Edge} and second is {@link Edge}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractCoreKeyRangeFactory#getRangeFromPair(Pair, GraphFilters)}
   */
  @Test
  @DisplayName("Test getRangeFromPair(Pair, GraphFilters); given 'UNDIRECTED'; when Pair(Object, Object) with first is Edge and second is Edge")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Range AbstractCoreKeyRangeFactory.getRangeFromPair(Pair, GraphFilters)"})
  void testGetRangeFromPair_givenUndirected_whenPairWithFirstIsEdgeAndSecondIsEdge()
      throws UnsupportedEncodingException, RangeFactoryException, SerialisationException {
    // Arrange
    AvroSerialiser avroSerialiser = mock(AvroSerialiser.class);
    when(avroSerialiser.serialise(Mockito.<Object>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    Schema schema = mock(Schema.class);
    when(schema.getVertexSerialiser()).thenReturn(avroSerialiser);
    ByteEntityRangeFactory byteEntityRangeFactory = new ByteEntityRangeFactory(schema);
    Edge edge = mock(Edge.class);
    when(edge.getDestination()).thenReturn("Destination");
    when(edge.getSource()).thenReturn("Source");
    when(edge.getDirectedType()).thenReturn(DirectedType.EITHER);
    Edge edge2 = mock(Edge.class);
    when(edge2.getDestination()).thenReturn("Destination");
    when(edge2.getSource()).thenReturn("Source");
    when(edge2.getDirectedType()).thenReturn(DirectedType.EITHER);
    Pair<ElementId, ElementId> pairRange = new Pair<>(edge, edge2);

    NamedView namedView = mock(NamedView.class);
    when(namedView.hasEdges()).thenReturn(true);
    when(namedView.hasEntities()).thenReturn(true);
    GraphFilters operation = mock(GraphFilters.class);
    when(operation.getDirectedType()).thenReturn(DirectedType.UNDIRECTED);
    when(operation.getView()).thenReturn(namedView);

    // Act
    Range actualRangeFromPair = byteEntityRangeFactory.getRangeFromPair(pairRange, operation);

    // Assert
    verify(edge, atLeast(1)).getDestination();
    verify(edge2, atLeast(1)).getDestination();
    verify(edge, atLeast(1)).getDirectedType();
    verify(edge2, atLeast(1)).getDirectedType();
    verify(edge, atLeast(1)).getSource();
    verify(edge2, atLeast(1)).getSource();
    verify(namedView, atLeast(1)).hasEdges();
    verify(namedView, atLeast(1)).hasEntities();
    verify(operation, atLeast(1)).getDirectedType();
    verify(operation, atLeast(1)).getView();
    verify(avroSerialiser, atLeast(1)).serialise(Mockito.<Object>any());
    verify(schema, atLeast(1)).getVertexSerialiser();
    Key endKey = actualRangeFromPair.getEndKey();
    ByteSequence rowData = endKey.getRowData();
    assertTrue(rowData instanceof ArrayByteSequence);
    Key startKey = actualRangeFromPair.getStartKey();
    ByteSequence rowData2 = startKey.getRowData();
    assertTrue(rowData2 instanceof ArrayByteSequence);
    TRange toThriftResult = actualRangeFromPair.toThrift();
    TKey start = toThriftResult.getStart();
    assertArrayEquals(new byte[]{}, start.getColFamily());
    TKey stop = toThriftResult.getStop();
    assertArrayEquals(new byte[]{}, stop.getColFamily());
    assertArrayEquals(new byte[]{}, start.getColQualifier());
    assertArrayEquals(new byte[]{}, stop.getColQualifier());
    assertArrayEquals(new byte[]{}, start.getColVisibility());
    assertArrayEquals(new byte[]{}, stop.getColVisibility());
    assertArrayEquals(new byte[]{}, endKey.getColumnVisibilityParsed().flatten());
    assertArrayEquals(new byte[]{}, startKey.getColumnVisibilityParsed().flatten());
    assertArrayEquals(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 1}, rowData2.getBackingArray());
    assertArrayEquals(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 1}, start.getRow());
    assertArrayEquals(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 1}, startKey.getRow().getBytes());
    assertArrayEquals(
        new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 4, 0, 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 4, 1},
        rowData.getBackingArray());
    assertArrayEquals(
        new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 4, 0, 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 4, 1},
        stop.getRow());
    assertArrayEquals(
        new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 4, 0, 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 4, 1},
        endKey.getRow().getBytes());
  }

  /**
   * Test {@link AbstractCoreKeyRangeFactory#getRangeFromPair(Pair, GraphFilters)}.
   * <ul>
   *   <li>Then EndKey ColumnFamilyData return {@link ArrayByteSequence}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractCoreKeyRangeFactory#getRangeFromPair(Pair, GraphFilters)}
   */
  @Test
  @DisplayName("Test getRangeFromPair(Pair, GraphFilters); then EndKey ColumnFamilyData return ArrayByteSequence")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Range AbstractCoreKeyRangeFactory.getRangeFromPair(Pair, GraphFilters)"})
  void testGetRangeFromPair_thenEndKeyColumnFamilyDataReturnArrayByteSequence()
      throws UnsupportedEncodingException, RangeFactoryException, SerialisationException {
    // Arrange
    AvroSerialiser avroSerialiser = mock(AvroSerialiser.class);
    when(avroSerialiser.serialise(Mockito.<Object>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    Schema schema = mock(Schema.class);
    when(schema.getVertexSerialiser()).thenReturn(avroSerialiser);
    ByteEntityRangeFactory byteEntityRangeFactory = new ByteEntityRangeFactory(schema);
    Edge edge = mock(Edge.class);
    when(edge.getDestination()).thenReturn("Destination");
    when(edge.getSource()).thenReturn("Source");
    when(edge.getDirectedType()).thenReturn(DirectedType.EITHER);
    Entity buildResult = (new Builder()).group("Group").vertex("Vertex").build();
    Pair<ElementId, ElementId> pairRange = new Pair<>(edge, buildResult);

    NamedView namedView = mock(NamedView.class);
    when(namedView.hasEdges()).thenReturn(true);
    when(namedView.hasEntities()).thenReturn(true);
    GraphFilters operation = mock(GraphFilters.class);
    when(operation.getDirectedType()).thenReturn(DirectedType.DIRECTED);
    when(operation.getView()).thenReturn(namedView);

    // Act
    Range actualRangeFromPair = byteEntityRangeFactory.getRangeFromPair(pairRange, operation);

    // Assert
    verify(edge, atLeast(1)).getDestination();
    verify(edge, atLeast(1)).getDirectedType();
    verify(edge, atLeast(1)).getSource();
    verify(namedView, atLeast(1)).hasEdges();
    verify(namedView, atLeast(1)).hasEntities();
    verify(operation, atLeast(1)).getDirectedType();
    verify(operation, atLeast(1)).getView();
    verify(avroSerialiser, atLeast(1)).serialise(Mockito.<Object>any());
    verify(schema, atLeast(1)).getVertexSerialiser();
    Key endKey = actualRangeFromPair.getEndKey();
    ByteSequence columnFamilyData = endKey.getColumnFamilyData();
    assertTrue(columnFamilyData instanceof ArrayByteSequence);
    Key startKey = actualRangeFromPair.getStartKey();
    ByteSequence columnFamilyData2 = startKey.getColumnFamilyData();
    assertTrue(columnFamilyData2 instanceof ArrayByteSequence);
    ByteSequence columnQualifierData = endKey.getColumnQualifierData();
    assertTrue(columnQualifierData instanceof ArrayByteSequence);
    ByteSequence columnQualifierData2 = startKey.getColumnQualifierData();
    assertTrue(columnQualifierData2 instanceof ArrayByteSequence);
    ByteSequence columnVisibilityData = endKey.getColumnVisibilityData();
    assertTrue(columnVisibilityData instanceof ArrayByteSequence);
    ByteSequence columnVisibilityData2 = startKey.getColumnVisibilityData();
    assertTrue(columnVisibilityData2 instanceof ArrayByteSequence);
    assertEquals(columnFamilyData, columnFamilyData2);
    assertEquals(columnFamilyData, columnQualifierData);
    assertEquals(columnFamilyData, columnQualifierData2);
    assertEquals(columnFamilyData, columnVisibilityData);
    assertEquals(columnFamilyData, columnVisibilityData2);
  }

  /**
   * Test {@link AbstractCoreKeyRangeFactory#getRangeFromPair(Pair, GraphFilters)}.
   * <ul>
   *   <li>When {@link Edge} {@link Edge#getDirectedType()} return {@code DIRECTED}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractCoreKeyRangeFactory#getRangeFromPair(Pair, GraphFilters)}
   */
  @Test
  @DisplayName("Test getRangeFromPair(Pair, GraphFilters); when Edge getDirectedType() return 'DIRECTED'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Range AbstractCoreKeyRangeFactory.getRangeFromPair(Pair, GraphFilters)"})
  void testGetRangeFromPair_whenEdgeGetDirectedTypeReturnDirected()
      throws UnsupportedEncodingException, RangeFactoryException, SerialisationException {
    // Arrange
    AvroSerialiser avroSerialiser = mock(AvroSerialiser.class);
    when(avroSerialiser.serialise(Mockito.<Object>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    Schema schema = mock(Schema.class);
    when(schema.getVertexSerialiser()).thenReturn(avroSerialiser);
    ByteEntityRangeFactory byteEntityRangeFactory = new ByteEntityRangeFactory(schema);
    Edge edge = mock(Edge.class);
    when(edge.getDestination()).thenReturn("Destination");
    when(edge.getSource()).thenReturn("Source");
    when(edge.getDirectedType()).thenReturn(DirectedType.DIRECTED);
    Pair<ElementId, ElementId> pairRange = new Pair<>(edge, new EdgeSeed());

    NamedView namedView = mock(NamedView.class);
    when(namedView.hasEdges()).thenReturn(true);
    when(namedView.hasEntities()).thenReturn(true);
    GraphFilters operation = mock(GraphFilters.class);
    when(operation.getDirectedType()).thenReturn(DirectedType.DIRECTED);
    when(operation.getView()).thenReturn(namedView);

    // Act
    Range actualRangeFromPair = byteEntityRangeFactory.getRangeFromPair(pairRange, operation);

    // Assert
    verify(edge, atLeast(1)).getDestination();
    verify(edge, atLeast(1)).getDirectedType();
    verify(edge, atLeast(1)).getSource();
    verify(namedView, atLeast(1)).hasEdges();
    verify(namedView, atLeast(1)).hasEntities();
    verify(operation, atLeast(1)).getDirectedType();
    verify(operation, atLeast(1)).getView();
    verify(avroSerialiser, atLeast(1)).serialise(Mockito.<Object>any());
    verify(schema, atLeast(1)).getVertexSerialiser();
    Key endKey = actualRangeFromPair.getEndKey();
    ByteSequence rowData = endKey.getRowData();
    assertTrue(rowData instanceof ArrayByteSequence);
    Key startKey = actualRangeFromPair.getStartKey();
    ByteSequence rowData2 = startKey.getRowData();
    assertTrue(rowData2 instanceof ArrayByteSequence);
    TRange toThriftResult = actualRangeFromPair.toThrift();
    TKey start = toThriftResult.getStart();
    assertArrayEquals(new byte[]{}, start.getColFamily());
    TKey stop = toThriftResult.getStop();
    assertArrayEquals(new byte[]{}, stop.getColFamily());
    assertArrayEquals(new byte[]{}, start.getColQualifier());
    assertArrayEquals(new byte[]{}, stop.getColQualifier());
    assertArrayEquals(new byte[]{}, start.getColVisibility());
    assertArrayEquals(new byte[]{}, stop.getColVisibility());
    assertArrayEquals(new byte[]{}, endKey.getColumnVisibilityParsed().flatten());
    assertArrayEquals(new byte[]{}, startKey.getColumnVisibilityParsed().flatten());
    assertArrayEquals(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 1}, rowData2.getBackingArray());
    assertArrayEquals(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 1}, start.getRow());
    assertArrayEquals(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 1}, startKey.getRow().getBytes());
    assertArrayEquals(
        new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 2, 0, 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 2, 1},
        rowData.getBackingArray());
    assertArrayEquals(
        new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 2, 0, 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 2, 1},
        stop.getRow());
    assertArrayEquals(
        new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 2, 0, 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 2, 1},
        endKey.getRow().getBytes());
  }

  /**
   * Test {@link AbstractCoreKeyRangeFactory#getRangeFromPair(Pair, GraphFilters)}.
   * <ul>
   *   <li>When {@link Pair#Pair(Object, Object)} with first is {@link Edge} and second is {@link EdgeSeed#EdgeSeed()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractCoreKeyRangeFactory#getRangeFromPair(Pair, GraphFilters)}
   */
  @Test
  @DisplayName("Test getRangeFromPair(Pair, GraphFilters); when Pair(Object, Object) with first is Edge and second is EdgeSeed()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Range AbstractCoreKeyRangeFactory.getRangeFromPair(Pair, GraphFilters)"})
  void testGetRangeFromPair_whenPairWithFirstIsEdgeAndSecondIsEdgeSeed()
      throws UnsupportedEncodingException, RangeFactoryException, SerialisationException {
    // Arrange
    AvroSerialiser avroSerialiser = mock(AvroSerialiser.class);
    when(avroSerialiser.serialise(Mockito.<Object>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    Schema schema = mock(Schema.class);
    when(schema.getVertexSerialiser()).thenReturn(avroSerialiser);
    ByteEntityRangeFactory byteEntityRangeFactory = new ByteEntityRangeFactory(schema);
    Edge edge = mock(Edge.class);
    when(edge.getDestination()).thenReturn("Destination");
    when(edge.getSource()).thenReturn("Source");
    when(edge.getDirectedType()).thenReturn(DirectedType.EITHER);
    Pair<ElementId, ElementId> pairRange = new Pair<>(edge, new EdgeSeed());

    NamedView namedView = mock(NamedView.class);
    when(namedView.hasEdges()).thenReturn(true);
    when(namedView.hasEntities()).thenReturn(true);
    GraphFilters operation = mock(GraphFilters.class);
    when(operation.getDirectedType()).thenReturn(DirectedType.DIRECTED);
    when(operation.getView()).thenReturn(namedView);

    // Act
    Range actualRangeFromPair = byteEntityRangeFactory.getRangeFromPair(pairRange, operation);

    // Assert
    verify(edge, atLeast(1)).getDestination();
    verify(edge, atLeast(1)).getDirectedType();
    verify(edge, atLeast(1)).getSource();
    verify(namedView, atLeast(1)).hasEdges();
    verify(namedView, atLeast(1)).hasEntities();
    verify(operation, atLeast(1)).getDirectedType();
    verify(operation, atLeast(1)).getView();
    verify(avroSerialiser, atLeast(1)).serialise(Mockito.<Object>any());
    verify(schema, atLeast(1)).getVertexSerialiser();
    Key endKey = actualRangeFromPair.getEndKey();
    ByteSequence rowData = endKey.getRowData();
    assertTrue(rowData instanceof ArrayByteSequence);
    Key startKey = actualRangeFromPair.getStartKey();
    ByteSequence rowData2 = startKey.getRowData();
    assertTrue(rowData2 instanceof ArrayByteSequence);
    TRange toThriftResult = actualRangeFromPair.toThrift();
    TKey start = toThriftResult.getStart();
    assertArrayEquals(new byte[]{}, start.getColFamily());
    TKey stop = toThriftResult.getStop();
    assertArrayEquals(new byte[]{}, stop.getColFamily());
    assertArrayEquals(new byte[]{}, start.getColQualifier());
    assertArrayEquals(new byte[]{}, stop.getColQualifier());
    assertArrayEquals(new byte[]{}, start.getColVisibility());
    assertArrayEquals(new byte[]{}, stop.getColVisibility());
    assertArrayEquals(new byte[]{}, endKey.getColumnVisibilityParsed().flatten());
    assertArrayEquals(new byte[]{}, startKey.getColumnVisibilityParsed().flatten());
    assertArrayEquals(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 1}, rowData2.getBackingArray());
    assertArrayEquals(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 1}, start.getRow());
    assertArrayEquals(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 1}, startKey.getRow().getBytes());
    assertArrayEquals(
        new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 2, 0, 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 2, 1},
        rowData.getBackingArray());
    assertArrayEquals(
        new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 2, 0, 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 2, 1},
        stop.getRow());
    assertArrayEquals(
        new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 2, 0, 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 2, 1},
        endKey.getRow().getBytes());
  }
}
