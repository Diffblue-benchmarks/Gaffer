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

package uk.gov.gchq.gaffer.accumulostore.key.core.impl.classic;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import java.util.List;
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
import uk.gov.gchq.gaffer.accumulostore.key.exception.RangeFactoryException;
import uk.gov.gchq.gaffer.accumulostore.operation.impl.GetElementsBetweenSets;
import uk.gov.gchq.gaffer.data.element.id.DirectedType;
import uk.gov.gchq.gaffer.data.elementdefinition.view.View;
import uk.gov.gchq.gaffer.exception.SerialisationException;
import uk.gov.gchq.gaffer.operation.graph.GraphFilters;
import uk.gov.gchq.gaffer.operation.graph.SeededGraphFilters;
import uk.gov.gchq.gaffer.operation.graph.SeededGraphFilters.IncludeIncomingOutgoingType;
import uk.gov.gchq.gaffer.serialisation.AvroSerialiser;
import uk.gov.gchq.gaffer.store.schema.Schema;

class ClassicRangeFactoryDiffblueTest {
  /**
   * Test {@link ClassicRangeFactory#getRange(Object, Object, DirectedType, GraphFilters, IncludeIncomingOutgoingType)} with {@code sourceVal}, {@code destVal}, {@code directed}, {@code operation}, {@code inOutType}.
   * <p>
   * Method under test: {@link ClassicRangeFactory#getRange(Object, Object, DirectedType, GraphFilters, IncludeIncomingOutgoingType)}
   */
  @Test
  @DisplayName("Test getRange(Object, Object, DirectedType, GraphFilters, IncludeIncomingOutgoingType) with 'sourceVal', 'destVal', 'directed', 'operation', 'inOutType'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "List ClassicRangeFactory.getRange(Object, Object, DirectedType, GraphFilters, IncludeIncomingOutgoingType)"})
  void testGetRangeWithSourceValDestValDirectedOperationInOutType()
      throws RangeFactoryException, SerialisationException {
    // Arrange
    AvroSerialiser avroSerialiser = mock(AvroSerialiser.class);
    when(avroSerialiser.serialise(Mockito.<Object>any())).thenThrow(new SerialisationException("An error occurred"));
    Schema schema = mock(Schema.class);
    when(schema.getVertexSerialiser()).thenReturn(avroSerialiser);
    ClassicRangeFactory classicRangeFactory = new ClassicRangeFactory(schema);

    // Act and Assert
    assertThrows(RangeFactoryException.class, () -> classicRangeFactory.getRange("Source Val", "Dest Val",
        DirectedType.EITHER, new GetElementsBetweenSets(), IncludeIncomingOutgoingType.EITHER));
    verify(avroSerialiser).serialise(isA(Object.class));
    verify(schema).getVertexSerialiser();
  }

  /**
   * Test {@link ClassicRangeFactory#getRange(Object, Object, DirectedType, GraphFilters, IncludeIncomingOutgoingType)} with {@code sourceVal}, {@code destVal}, {@code directed}, {@code operation}, {@code inOutType}.
   * <ul>
   *   <li>When {@code DIRECTED}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ClassicRangeFactory#getRange(Object, Object, DirectedType, GraphFilters, IncludeIncomingOutgoingType)}
   */
  @Test
  @DisplayName("Test getRange(Object, Object, DirectedType, GraphFilters, IncludeIncomingOutgoingType) with 'sourceVal', 'destVal', 'directed', 'operation', 'inOutType'; when 'DIRECTED'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "List ClassicRangeFactory.getRange(Object, Object, DirectedType, GraphFilters, IncludeIncomingOutgoingType)"})
  void testGetRangeWithSourceValDestValDirectedOperationInOutType_whenDirected()
      throws UnsupportedEncodingException, RangeFactoryException, SerialisationException {
    // Arrange
    AvroSerialiser avroSerialiser = mock(AvroSerialiser.class);
    when(avroSerialiser.serialise(Mockito.<Object>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    Schema schema = mock(Schema.class);
    when(schema.getVertexSerialiser()).thenReturn(avroSerialiser);
    ClassicRangeFactory classicRangeFactory = new ClassicRangeFactory(schema);

    // Act
    List<Range> actualRange = classicRangeFactory.getRange("Source Val", "Dest Val", DirectedType.DIRECTED,
        new GetElementsBetweenSets(), IncludeIncomingOutgoingType.EITHER);

    // Assert
    verify(avroSerialiser, atLeast(1)).serialise(Mockito.<Object>any());
    verify(schema, atLeast(1)).getVertexSerialiser();
    assertEquals(1, actualRange.size());
    Range getResult = actualRange.get(0);
    Key startKey = getResult.getStartKey();
    assertTrue(startKey.getColumnFamilyData() instanceof ArrayByteSequence);
    Key endKey = getResult.getEndKey();
    assertTrue(endKey.getColumnQualifierData() instanceof ArrayByteSequence);
    assertTrue(startKey.getColumnQualifierData() instanceof ArrayByteSequence);
    assertTrue(endKey.getColumnVisibilityData() instanceof ArrayByteSequence);
    assertTrue(startKey.getColumnVisibilityData() instanceof ArrayByteSequence);
  }

  /**
   * Test {@link ClassicRangeFactory#getRange(Object, Object, DirectedType, GraphFilters, IncludeIncomingOutgoingType)} with {@code sourceVal}, {@code destVal}, {@code directed}, {@code operation}, {@code inOutType}.
   * <ul>
   *   <li>When {@code DIRECTED}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ClassicRangeFactory#getRange(Object, Object, DirectedType, GraphFilters, IncludeIncomingOutgoingType)}
   */
  @Test
  @DisplayName("Test getRange(Object, Object, DirectedType, GraphFilters, IncludeIncomingOutgoingType) with 'sourceVal', 'destVal', 'directed', 'operation', 'inOutType'; when 'DIRECTED'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "List ClassicRangeFactory.getRange(Object, Object, DirectedType, GraphFilters, IncludeIncomingOutgoingType)"})
  void testGetRangeWithSourceValDestValDirectedOperationInOutType_whenDirected2()
      throws UnsupportedEncodingException, RangeFactoryException, SerialisationException {
    // Arrange
    AvroSerialiser avroSerialiser = mock(AvroSerialiser.class);
    when(avroSerialiser.serialise(Mockito.<Object>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    Schema schema = mock(Schema.class);
    when(schema.getVertexSerialiser()).thenReturn(avroSerialiser);
    ClassicRangeFactory classicRangeFactory = new ClassicRangeFactory(schema);

    // Act
    List<Range> actualRange = classicRangeFactory.getRange("Source Val", "Dest Val", DirectedType.DIRECTED,
        new GetElementsBetweenSets(), IncludeIncomingOutgoingType.INCOMING);

    // Assert
    verify(avroSerialiser, atLeast(1)).serialise(Mockito.<Object>any());
    verify(schema, atLeast(1)).getVertexSerialiser();
    assertEquals(1, actualRange.size());
    Range getResult = actualRange.get(0);
    Key startKey = getResult.getStartKey();
    assertTrue(startKey.getColumnFamilyData() instanceof ArrayByteSequence);
    Key endKey = getResult.getEndKey();
    assertTrue(endKey.getColumnQualifierData() instanceof ArrayByteSequence);
    assertTrue(startKey.getColumnQualifierData() instanceof ArrayByteSequence);
    assertTrue(endKey.getColumnVisibilityData() instanceof ArrayByteSequence);
    assertTrue(startKey.getColumnVisibilityData() instanceof ArrayByteSequence);
  }

  /**
   * Test {@link ClassicRangeFactory#getRange(Object, Object, DirectedType, GraphFilters, IncludeIncomingOutgoingType)} with {@code sourceVal}, {@code destVal}, {@code directed}, {@code operation}, {@code inOutType}.
   * <ul>
   *   <li>When {@code INCOMING}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ClassicRangeFactory#getRange(Object, Object, DirectedType, GraphFilters, IncludeIncomingOutgoingType)}
   */
  @Test
  @DisplayName("Test getRange(Object, Object, DirectedType, GraphFilters, IncludeIncomingOutgoingType) with 'sourceVal', 'destVal', 'directed', 'operation', 'inOutType'; when 'INCOMING'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "List ClassicRangeFactory.getRange(Object, Object, DirectedType, GraphFilters, IncludeIncomingOutgoingType)"})
  void testGetRangeWithSourceValDestValDirectedOperationInOutType_whenIncoming()
      throws UnsupportedEncodingException, RangeFactoryException, SerialisationException {
    // Arrange
    AvroSerialiser avroSerialiser = mock(AvroSerialiser.class);
    when(avroSerialiser.serialise(Mockito.<Object>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    Schema schema = mock(Schema.class);
    when(schema.getVertexSerialiser()).thenReturn(avroSerialiser);
    ClassicRangeFactory classicRangeFactory = new ClassicRangeFactory(schema);

    // Act
    List<Range> actualRange = classicRangeFactory.getRange("Source Val", "Dest Val", DirectedType.EITHER,
        new GetElementsBetweenSets(), IncludeIncomingOutgoingType.INCOMING);

    // Assert
    verify(avroSerialiser, atLeast(1)).serialise(Mockito.<Object>any());
    verify(schema, atLeast(1)).getVertexSerialiser();
    assertEquals(1, actualRange.size());
    Range getResult = actualRange.get(0);
    Key startKey = getResult.getStartKey();
    assertTrue(startKey.getColumnFamilyData() instanceof ArrayByteSequence);
    Key endKey = getResult.getEndKey();
    assertTrue(endKey.getColumnQualifierData() instanceof ArrayByteSequence);
    assertTrue(startKey.getColumnQualifierData() instanceof ArrayByteSequence);
    assertTrue(endKey.getColumnVisibilityData() instanceof ArrayByteSequence);
    assertTrue(startKey.getColumnVisibilityData() instanceof ArrayByteSequence);
  }

  /**
   * Test {@link ClassicRangeFactory#getRange(Object, Object, DirectedType, GraphFilters, IncludeIncomingOutgoingType)} with {@code sourceVal}, {@code destVal}, {@code directed}, {@code operation}, {@code inOutType}.
   * <ul>
   *   <li>When {@link DirectedType#UNDIRECTED}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ClassicRangeFactory#getRange(Object, Object, DirectedType, GraphFilters, IncludeIncomingOutgoingType)}
   */
  @Test
  @DisplayName("Test getRange(Object, Object, DirectedType, GraphFilters, IncludeIncomingOutgoingType) with 'sourceVal', 'destVal', 'directed', 'operation', 'inOutType'; when UNDIRECTED")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "List ClassicRangeFactory.getRange(Object, Object, DirectedType, GraphFilters, IncludeIncomingOutgoingType)"})
  void testGetRangeWithSourceValDestValDirectedOperationInOutType_whenUndirected()
      throws UnsupportedEncodingException, RangeFactoryException, SerialisationException {
    // Arrange
    AvroSerialiser avroSerialiser = mock(AvroSerialiser.class);
    when(avroSerialiser.serialise(Mockito.<Object>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    Schema schema = mock(Schema.class);
    when(schema.getVertexSerialiser()).thenReturn(avroSerialiser);
    ClassicRangeFactory classicRangeFactory = new ClassicRangeFactory(schema);

    // Act
    List<Range> actualRange = classicRangeFactory.getRange("Source Val", "Dest Val", DirectedType.UNDIRECTED,
        new GetElementsBetweenSets(), IncludeIncomingOutgoingType.EITHER);

    // Assert
    verify(avroSerialiser, atLeast(1)).serialise(Mockito.<Object>any());
    verify(schema, atLeast(1)).getVertexSerialiser();
    assertEquals(1, actualRange.size());
    Range getResult = actualRange.get(0);
    Key startKey = getResult.getStartKey();
    assertTrue(startKey.getColumnFamilyData() instanceof ArrayByteSequence);
    Key endKey = getResult.getEndKey();
    assertTrue(endKey.getColumnQualifierData() instanceof ArrayByteSequence);
    assertTrue(startKey.getColumnQualifierData() instanceof ArrayByteSequence);
    assertTrue(endKey.getColumnVisibilityData() instanceof ArrayByteSequence);
    assertTrue(startKey.getColumnVisibilityData() instanceof ArrayByteSequence);
  }

  /**
   * Test {@link ClassicRangeFactory#getRange(Object, GraphFilters, boolean)} with {@code vertex}, {@code operation}, {@code includeEdgesParam}.
   * <p>
   * Method under test: {@link ClassicRangeFactory#getRange(Object, GraphFilters, boolean)}
   */
  @Test
  @DisplayName("Test getRange(Object, GraphFilters, boolean) with 'vertex', 'operation', 'includeEdgesParam'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List ClassicRangeFactory.getRange(Object, GraphFilters, boolean)"})
  void testGetRangeWithVertexOperationIncludeEdgesParam() throws RangeFactoryException {
    // Arrange
    Schema schema = mock(Schema.class);
    when(schema.getVertexSerialiser()).thenReturn(new AvroSerialiser());
    ClassicRangeFactory classicRangeFactory = new ClassicRangeFactory(schema);
    GetElementsBetweenSets operation = mock(GetElementsBetweenSets.class);
    when(operation.getView()).thenReturn(new View());

    // Act
    List<Range> actualRange = classicRangeFactory.getRange("Vertex", operation, true);

    // Assert
    verify(operation).getView();
    verify(schema).getVertexSerialiser();
    assertEquals(1, actualRange.size());
  }

  /**
   * Test {@link ClassicRangeFactory#getRange(Object, GraphFilters, boolean)} with {@code vertex}, {@code operation}, {@code includeEdgesParam}.
   * <p>
   * Method under test: {@link ClassicRangeFactory#getRange(Object, GraphFilters, boolean)}
   */
  @Test
  @DisplayName("Test getRange(Object, GraphFilters, boolean) with 'vertex', 'operation', 'includeEdgesParam'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List ClassicRangeFactory.getRange(Object, GraphFilters, boolean)"})
  void testGetRangeWithVertexOperationIncludeEdgesParam2()
      throws UnsupportedEncodingException, RangeFactoryException, SerialisationException {
    // Arrange
    AvroSerialiser avroSerialiser = mock(AvroSerialiser.class);
    when(avroSerialiser.serialise(Mockito.<Object>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    Schema schema = mock(Schema.class);
    when(schema.getVertexSerialiser()).thenReturn(avroSerialiser);
    ClassicRangeFactory classicRangeFactory = new ClassicRangeFactory(schema);
    GetElementsBetweenSets operation = mock(GetElementsBetweenSets.class);
    when(operation.getView()).thenReturn(new View());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> classicRangeFactory.getRange("Vertex", operation, false));
    verify(operation).getView();
    verify(avroSerialiser).serialise(isA(Object.class));
    verify(schema).getVertexSerialiser();
  }

  /**
   * Test {@link ClassicRangeFactory#getRange(Object, GraphFilters, boolean)} with {@code vertex}, {@code operation}, {@code includeEdgesParam}.
   * <p>
   * Method under test: {@link ClassicRangeFactory#getRange(Object, GraphFilters, boolean)}
   */
  @Test
  @DisplayName("Test getRange(Object, GraphFilters, boolean) with 'vertex', 'operation', 'includeEdgesParam'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List ClassicRangeFactory.getRange(Object, GraphFilters, boolean)"})
  void testGetRangeWithVertexOperationIncludeEdgesParam3()
      throws UnsupportedEncodingException, RangeFactoryException, SerialisationException {
    // Arrange
    AvroSerialiser avroSerialiser = mock(AvroSerialiser.class);
    when(avroSerialiser.serialise(Mockito.<Object>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    Schema schema = mock(Schema.class);
    when(schema.getVertexSerialiser()).thenReturn(avroSerialiser);
    ClassicRangeFactory classicRangeFactory = new ClassicRangeFactory(schema);
    View view = mock(View.class);
    when(view.hasEntities()).thenReturn(true);
    GetElementsBetweenSets operation = mock(GetElementsBetweenSets.class);
    when(operation.getView()).thenReturn(view);

    // Act
    List<Range> actualRange = classicRangeFactory.getRange("Vertex", operation, false);

    // Assert
    verify(operation).getView();
    verify(view).hasEntities();
    verify(avroSerialiser).serialise(isA(Object.class));
    verify(schema).getVertexSerialiser();
    assertEquals(1, actualRange.size());
    Range getResult = actualRange.get(0);
    Key endKey = getResult.getEndKey();
    ByteSequence columnFamilyData = endKey.getColumnFamilyData();
    assertTrue(columnFamilyData instanceof ArrayByteSequence);
    Key startKey = getResult.getStartKey();
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
   * Test {@link ClassicRangeFactory#getRange(Object, GraphFilters, boolean)} with {@code vertex}, {@code operation}, {@code includeEdgesParam}.
   * <p>
   * Method under test: {@link ClassicRangeFactory#getRange(Object, GraphFilters, boolean)}
   */
  @Test
  @DisplayName("Test getRange(Object, GraphFilters, boolean) with 'vertex', 'operation', 'includeEdgesParam'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List ClassicRangeFactory.getRange(Object, GraphFilters, boolean)"})
  void testGetRangeWithVertexOperationIncludeEdgesParam4()
      throws UnsupportedEncodingException, RangeFactoryException, SerialisationException {
    // Arrange
    AvroSerialiser avroSerialiser = mock(AvroSerialiser.class);
    when(avroSerialiser.serialise(Mockito.<Object>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    Schema schema = mock(Schema.class);
    when(schema.getVertexSerialiser()).thenReturn(avroSerialiser);
    ClassicRangeFactory classicRangeFactory = new ClassicRangeFactory(schema);
    View view = mock(View.class);
    when(view.hasEntities()).thenReturn(true);
    GetElementsBetweenSets operation = mock(GetElementsBetweenSets.class);
    when(operation.getView()).thenReturn(view);

    // Act
    List<Range> actualRange = classicRangeFactory.getRange("Vertex", operation, true);

    // Assert
    verify(operation).getView();
    verify(view).hasEntities();
    verify(avroSerialiser).serialise(isA(Object.class));
    verify(schema).getVertexSerialiser();
    assertEquals(1, actualRange.size());
    Range getResult = actualRange.get(0);
    Key endKey = getResult.getEndKey();
    ByteSequence rowData = endKey.getRowData();
    assertTrue(rowData instanceof ArrayByteSequence);
    Key startKey = getResult.getStartKey();
    ByteSequence rowData2 = startKey.getRowData();
    assertTrue(rowData2 instanceof ArrayByteSequence);
    byte[] expectedBackingArray = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedBackingArray, rowData2.getBackingArray());
    byte[] expectedRow = "AXAXAXAX".getBytes("UTF-8");
    TRange toThriftResult = getResult.toThrift();
    TKey start = toThriftResult.getStart();
    assertArrayEquals(expectedRow, start.getRow());
    byte[] expectedBytes = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedBytes, startKey.getRow().getBytes());
    assertArrayEquals(new byte[]{}, start.getColFamily());
    TKey stop = toThriftResult.getStop();
    assertArrayEquals(new byte[]{}, stop.getColFamily());
    assertArrayEquals(new byte[]{}, start.getColQualifier());
    assertArrayEquals(new byte[]{}, stop.getColQualifier());
    assertArrayEquals(new byte[]{}, start.getColVisibility());
    assertArrayEquals(new byte[]{}, stop.getColVisibility());
    assertArrayEquals(new byte[]{}, endKey.getColumnVisibilityParsed().flatten());
    assertArrayEquals(new byte[]{}, startKey.getColumnVisibilityParsed().flatten());
    assertArrayEquals(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', ClassicBytePositions.UNDIRECTED_EDGE},
        rowData.getBackingArray());
    assertArrayEquals(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', ClassicBytePositions.UNDIRECTED_EDGE},
        stop.getRow());
    assertArrayEquals(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', ClassicBytePositions.UNDIRECTED_EDGE},
        endKey.getRow().getBytes());
  }

  /**
   * Test {@link ClassicRangeFactory#getRange(Object, GraphFilters, boolean)} with {@code vertex}, {@code operation}, {@code includeEdgesParam}.
   * <ul>
   *   <li>Then throw {@link RangeFactoryException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ClassicRangeFactory#getRange(Object, GraphFilters, boolean)}
   */
  @Test
  @DisplayName("Test getRange(Object, GraphFilters, boolean) with 'vertex', 'operation', 'includeEdgesParam'; then throw RangeFactoryException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List ClassicRangeFactory.getRange(Object, GraphFilters, boolean)"})
  void testGetRangeWithVertexOperationIncludeEdgesParam_thenThrowRangeFactoryException()
      throws RangeFactoryException, SerialisationException {
    // Arrange
    AvroSerialiser avroSerialiser = mock(AvroSerialiser.class);
    when(avroSerialiser.serialise(Mockito.<Object>any())).thenThrow(new SerialisationException("An error occurred"));
    Schema schema = mock(Schema.class);
    when(schema.getVertexSerialiser()).thenReturn(avroSerialiser);
    ClassicRangeFactory classicRangeFactory = new ClassicRangeFactory(schema);
    GetElementsBetweenSets operation = mock(GetElementsBetweenSets.class);
    when(operation.getView()).thenReturn(new View());

    // Act and Assert
    assertThrows(RangeFactoryException.class, () -> classicRangeFactory.getRange("Vertex", operation, true));
    verify(operation).getView();
    verify(avroSerialiser).serialise(isA(Object.class));
    verify(schema).getVertexSerialiser();
  }
}
