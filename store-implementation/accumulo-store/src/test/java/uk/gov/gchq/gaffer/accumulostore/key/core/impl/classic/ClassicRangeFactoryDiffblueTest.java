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

package uk.gov.gchq.gaffer.accumulostore.key.core.impl.classic;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
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
   * Test {@link ClassicRangeFactory#getRange(Object, GraphFilters, boolean)} with {@code vertex},
   * {@code operation}, {@code includeEdgesParam}.
   *
   * <p>Method under test: {@link ClassicRangeFactory#getRange(Object, GraphFilters, boolean)}
   */
  @Test
  @DisplayName(
      "Test getRange(Object, GraphFilters, boolean) with 'vertex', 'operation', 'includeEdgesParam'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
    Range getResult = actualRange.get(0);
    Key startKey = getResult.getStartKey();
    assertTrue(startKey.getRowData() instanceof ArrayByteSequence);
    TRange toThriftResult = getResult.toThrift();
    TKey start = toThriftResult.getStart();
    assertArrayEquals(new byte[] {}, start.getColFamily());
    TKey stop = toThriftResult.getStop();
    assertArrayEquals(new byte[] {}, stop.getColFamily());
    assertArrayEquals(new byte[] {}, start.getColQualifier());
    assertArrayEquals(new byte[] {}, stop.getColQualifier());
    assertArrayEquals(new byte[] {}, start.getColVisibility());
    assertArrayEquals(new byte[] {}, stop.getColVisibility());
    assertArrayEquals(new byte[] {}, getResult.getEndKey().getColumnVisibilityParsed().flatten());
    assertArrayEquals(new byte[] {}, startKey.getColumnVisibilityParsed().flatten());
  }

  /**
   * Test {@link ClassicRangeFactory#getRange(Object, GraphFilters, boolean)} with {@code vertex},
   * {@code operation}, {@code includeEdgesParam}.
   *
   * <p>Method under test: {@link ClassicRangeFactory#getRange(Object, GraphFilters, boolean)}
   */
  @Test
  @DisplayName(
      "Test getRange(Object, GraphFilters, boolean) with 'vertex', 'operation', 'includeEdgesParam'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ClassicRangeFactory.getRange(Object, GraphFilters, boolean)"})
  void testGetRangeWithVertexOperationIncludeEdgesParam2()
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
    assertTrue(endKey.getRowData() instanceof ArrayByteSequence);
    assertEquals(8, startKey.getLength());
    assertEquals(8, startKey.getSize());
    assertEquals(9, endKey.getLength());
    assertEquals(9, endKey.getSize());
    assertEquals(columnFamilyData, columnFamilyData2);
    assertEquals(columnFamilyData, columnQualifierData);
    assertEquals(columnFamilyData, columnQualifierData2);
    assertEquals(columnFamilyData, columnVisibilityData);
    assertEquals(columnFamilyData, columnVisibilityData2);
  }

  /**
   * Test {@link ClassicRangeFactory#getRange(Object, GraphFilters, boolean)} with {@code vertex},
   * {@code operation}, {@code includeEdgesParam}.
   *
   * <p>Method under test: {@link ClassicRangeFactory#getRange(Object, GraphFilters, boolean)}
   */
  @Test
  @DisplayName(
      "Test getRange(Object, GraphFilters, boolean) with 'vertex', 'operation', 'includeEdgesParam'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
    when(view.hasEntities()).thenReturn(false);

    GetElementsBetweenSets operation = mock(GetElementsBetweenSets.class);
    when(operation.getView()).thenReturn(view);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> classicRangeFactory.getRange("Vertex", operation, false));
    verify(operation).getView();
    verify(view).hasEntities();
    verify(avroSerialiser).serialise(isA(Object.class));
    verify(schema).getVertexSerialiser();
  }

  /**
   * Test {@link ClassicRangeFactory#getRange(Object, GraphFilters, boolean)} with {@code vertex},
   * {@code operation}, {@code includeEdgesParam}.
   *
   * <ul>
   *   <li>Then throw {@link RangeFactoryException}.
   * </ul>
   *
   * <p>Method under test: {@link ClassicRangeFactory#getRange(Object, GraphFilters, boolean)}
   */
  @Test
  @DisplayName(
      "Test getRange(Object, GraphFilters, boolean) with 'vertex', 'operation', 'includeEdgesParam'; then throw RangeFactoryException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ClassicRangeFactory.getRange(Object, GraphFilters, boolean)"})
  void testGetRangeWithVertexOperationIncludeEdgesParam_thenThrowRangeFactoryException()
      throws RangeFactoryException, SerialisationException {
    // Arrange
    AvroSerialiser avroSerialiser = mock(AvroSerialiser.class);
    when(avroSerialiser.serialise(Mockito.<Object>any()))
        .thenThrow(new SerialisationException("An error occurred"));

    Schema schema = mock(Schema.class);
    when(schema.getVertexSerialiser()).thenReturn(avroSerialiser);
    ClassicRangeFactory classicRangeFactory = new ClassicRangeFactory(schema);

    View view = mock(View.class);
    when(view.hasEntities()).thenReturn(true);

    GetElementsBetweenSets operation = mock(GetElementsBetweenSets.class);
    when(operation.getView()).thenReturn(view);

    // Act and Assert
    assertThrows(
        RangeFactoryException.class, () -> classicRangeFactory.getRange("Vertex", operation, true));
    verify(operation).getView();
    verify(view).hasEntities();
    verify(avroSerialiser).serialise(isA(Object.class));
    verify(schema).getVertexSerialiser();
  }

  /**
   * Test {@link ClassicRangeFactory#getKeyFromEdgeId(Object, Object, DirectedType,
   * IncludeIncomingOutgoingType, boolean)}.
   *
   * <ul>
   *   <li>Given {@link Schema} {@link Schema#getVertexSerialiser()} return {@link AvroSerialiser}
   *       (default constructor).
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ClassicRangeFactory#getKeyFromEdgeId(Object, Object, DirectedType,
   * IncludeIncomingOutgoingType, boolean)}
   */
  @Test
  @DisplayName(
      "Test getKeyFromEdgeId(Object, Object, DirectedType, IncludeIncomingOutgoingType, boolean); given Schema getVertexSerialiser() return AvroSerialiser (default constructor); when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Key ClassicRangeFactory.getKeyFromEdgeId(Object, Object, DirectedType, IncludeIncomingOutgoingType, boolean)"
  })
  void testGetKeyFromEdgeId_givenSchemaGetVertexSerialiserReturnAvroSerialiser_whenNull()
      throws RangeFactoryException {
    // Arrange
    Schema schema = mock(Schema.class);
    when(schema.getVertexSerialiser()).thenReturn(new AvroSerialiser());

    // Act
    Key actualKeyFromEdgeId =
        new ClassicRangeFactory(schema)
            .getKeyFromEdgeId(
                "Source Val", "Dest Val", null, IncludeIncomingOutgoingType.INCOMING, false);

    // Assert
    verify(schema).getVertexSerialiser();
    ByteSequence columnFamilyData = actualKeyFromEdgeId.getColumnFamilyData();
    assertTrue(columnFamilyData instanceof ArrayByteSequence);
    ByteSequence columnQualifierData = actualKeyFromEdgeId.getColumnQualifierData();
    assertTrue(columnQualifierData instanceof ArrayByteSequence);
    ByteSequence columnVisibilityData = actualKeyFromEdgeId.getColumnVisibilityData();
    assertTrue(columnVisibilityData instanceof ArrayByteSequence);
    assertTrue(actualKeyFromEdgeId.getRowData() instanceof ArrayByteSequence);
    assertEquals(columnFamilyData, columnQualifierData);
    assertEquals(columnFamilyData, columnVisibilityData);
    assertArrayEquals(new byte[] {}, actualKeyFromEdgeId.getColumnVisibilityParsed().flatten());
  }

  /**
   * Test {@link ClassicRangeFactory#getKeyFromEdgeId(Object, Object, DirectedType,
   * IncludeIncomingOutgoingType, boolean)}.
   *
   * <ul>
   *   <li>Then return Length is nineteen.
   * </ul>
   *
   * <p>Method under test: {@link ClassicRangeFactory#getKeyFromEdgeId(Object, Object, DirectedType,
   * IncludeIncomingOutgoingType, boolean)}
   */
  @Test
  @DisplayName(
      "Test getKeyFromEdgeId(Object, Object, DirectedType, IncludeIncomingOutgoingType, boolean); then return Length is nineteen")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Key ClassicRangeFactory.getKeyFromEdgeId(Object, Object, DirectedType, IncludeIncomingOutgoingType, boolean)"
  })
  void testGetKeyFromEdgeId_thenReturnLengthIsNineteen()
      throws UnsupportedEncodingException, RangeFactoryException, SerialisationException {
    // Arrange
    AvroSerialiser avroSerialiser = mock(AvroSerialiser.class);
    when(avroSerialiser.serialise(Mockito.<Object>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    Schema schema = mock(Schema.class);
    when(schema.getVertexSerialiser()).thenReturn(avroSerialiser);

    // Act
    Key actualKeyFromEdgeId =
        new ClassicRangeFactory(schema)
            .getKeyFromEdgeId(
                "Source Val",
                "Dest Val",
                DirectedType.EITHER,
                IncludeIncomingOutgoingType.EITHER,
                false);

    // Assert
    verify(avroSerialiser, atLeast(1)).serialise(Mockito.<Object>any());
    verify(schema).getVertexSerialiser();
    assertTrue(actualKeyFromEdgeId.getColumnQualifierData() instanceof ArrayByteSequence);
    assertTrue(actualKeyFromEdgeId.getColumnVisibilityData() instanceof ArrayByteSequence);
    assertEquals(19, actualKeyFromEdgeId.getLength());
    assertEquals(19, actualKeyFromEdgeId.getSize());
  }

  /**
   * Test {@link ClassicRangeFactory#getKeyFromEdgeId(Object, Object, DirectedType,
   * IncludeIncomingOutgoingType, boolean)}.
   *
   * <ul>
   *   <li>Then throw {@link RangeFactoryException}.
   * </ul>
   *
   * <p>Method under test: {@link ClassicRangeFactory#getKeyFromEdgeId(Object, Object, DirectedType,
   * IncludeIncomingOutgoingType, boolean)}
   */
  @Test
  @DisplayName(
      "Test getKeyFromEdgeId(Object, Object, DirectedType, IncludeIncomingOutgoingType, boolean); then throw RangeFactoryException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Key ClassicRangeFactory.getKeyFromEdgeId(Object, Object, DirectedType, IncludeIncomingOutgoingType, boolean)"
  })
  void testGetKeyFromEdgeId_thenThrowRangeFactoryException()
      throws RangeFactoryException, SerialisationException {
    // Arrange
    AvroSerialiser avroSerialiser = mock(AvroSerialiser.class);
    when(avroSerialiser.serialise(Mockito.<Object>any()))
        .thenThrow(new SerialisationException("An error occurred"));

    Schema schema = mock(Schema.class);
    when(schema.getVertexSerialiser()).thenReturn(avroSerialiser);

    // Act and Assert
    assertThrows(
        RangeFactoryException.class,
        () ->
            new ClassicRangeFactory(schema)
                .getKeyFromEdgeId(
                    "Source Val",
                    "Dest Val",
                    DirectedType.EITHER,
                    IncludeIncomingOutgoingType.EITHER,
                    true));
    verify(avroSerialiser).serialise(isA(Object.class));
    verify(schema).getVertexSerialiser();
  }

  /**
   * Test {@link ClassicRangeFactory#getKeyFromEdgeId(Object, Object, DirectedType,
   * IncludeIncomingOutgoingType, boolean)}.
   *
   * <ul>
   *   <li>When {@code DIRECTED}.
   * </ul>
   *
   * <p>Method under test: {@link ClassicRangeFactory#getKeyFromEdgeId(Object, Object, DirectedType,
   * IncludeIncomingOutgoingType, boolean)}
   */
  @Test
  @DisplayName(
      "Test getKeyFromEdgeId(Object, Object, DirectedType, IncludeIncomingOutgoingType, boolean); when 'DIRECTED'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Key ClassicRangeFactory.getKeyFromEdgeId(Object, Object, DirectedType, IncludeIncomingOutgoingType, boolean)"
  })
  void testGetKeyFromEdgeId_whenDirected()
      throws UnsupportedEncodingException, RangeFactoryException, SerialisationException {
    // Arrange
    AvroSerialiser avroSerialiser = mock(AvroSerialiser.class);
    when(avroSerialiser.serialise(Mockito.<Object>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    Schema schema = mock(Schema.class);
    when(schema.getVertexSerialiser()).thenReturn(avroSerialiser);

    // Act
    Key actualKeyFromEdgeId =
        new ClassicRangeFactory(schema)
            .getKeyFromEdgeId(
                "Source Val",
                "Dest Val",
                DirectedType.DIRECTED,
                IncludeIncomingOutgoingType.EITHER,
                true);

    // Assert
    verify(avroSerialiser, atLeast(1)).serialise(Mockito.<Object>any());
    verify(schema).getVertexSerialiser();
    ByteSequence columnFamilyData = actualKeyFromEdgeId.getColumnFamilyData();
    assertTrue(columnFamilyData instanceof ArrayByteSequence);
    ByteSequence columnQualifierData = actualKeyFromEdgeId.getColumnQualifierData();
    assertTrue(columnQualifierData instanceof ArrayByteSequence);
    ByteSequence columnVisibilityData = actualKeyFromEdgeId.getColumnVisibilityData();
    assertTrue(columnVisibilityData instanceof ArrayByteSequence);
    ByteSequence rowData = actualKeyFromEdgeId.getRowData();
    assertTrue(rowData instanceof ArrayByteSequence);
    assertEquals(columnFamilyData, columnQualifierData);
    assertEquals(columnFamilyData, columnVisibilityData);
    byte[] backingArray = rowData.getBackingArray();
    assertSame(backingArray, rowData.toArray());
    assertArrayEquals(new byte[] {}, actualKeyFromEdgeId.getColumnVisibilityParsed().flatten());
    assertArrayEquals(
        new byte[] {
          'A',
          'X',
          'A',
          'X',
          'A',
          'X',
          'A',
          'X',
          0,
          'A',
          'X',
          'A',
          'X',
          'A',
          'X',
          'A',
          'X',
          0,
          ClassicBytePositions.CORRECT_WAY_DIRECTED_EDGE,
          ClassicBytePositions.UNDIRECTED_EDGE
        },
        backingArray);
    assertArrayEquals(
        new byte[] {
          'A',
          'X',
          'A',
          'X',
          'A',
          'X',
          'A',
          'X',
          0,
          'A',
          'X',
          'A',
          'X',
          'A',
          'X',
          'A',
          'X',
          0,
          ClassicBytePositions.CORRECT_WAY_DIRECTED_EDGE,
          ClassicBytePositions.UNDIRECTED_EDGE
        },
        actualKeyFromEdgeId.getRow().getBytes());
  }

  /**
   * Test {@link ClassicRangeFactory#getKeyFromEdgeId(Object, Object, DirectedType,
   * IncludeIncomingOutgoingType, boolean)}.
   *
   * <ul>
   *   <li>When {@code DIRECTED}.
   * </ul>
   *
   * <p>Method under test: {@link ClassicRangeFactory#getKeyFromEdgeId(Object, Object, DirectedType,
   * IncludeIncomingOutgoingType, boolean)}
   */
  @Test
  @DisplayName(
      "Test getKeyFromEdgeId(Object, Object, DirectedType, IncludeIncomingOutgoingType, boolean); when 'DIRECTED'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Key ClassicRangeFactory.getKeyFromEdgeId(Object, Object, DirectedType, IncludeIncomingOutgoingType, boolean)"
  })
  void testGetKeyFromEdgeId_whenDirected2()
      throws UnsupportedEncodingException, RangeFactoryException, SerialisationException {
    // Arrange
    AvroSerialiser avroSerialiser = mock(AvroSerialiser.class);
    when(avroSerialiser.serialise(Mockito.<Object>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    Schema schema = mock(Schema.class);
    when(schema.getVertexSerialiser()).thenReturn(avroSerialiser);

    // Act
    Key actualKeyFromEdgeId =
        new ClassicRangeFactory(schema)
            .getKeyFromEdgeId(
                "Source Val",
                "Dest Val",
                DirectedType.DIRECTED,
                IncludeIncomingOutgoingType.INCOMING,
                true);

    // Assert
    verify(avroSerialiser, atLeast(1)).serialise(Mockito.<Object>any());
    verify(schema).getVertexSerialiser();
    ByteSequence columnFamilyData = actualKeyFromEdgeId.getColumnFamilyData();
    assertTrue(columnFamilyData instanceof ArrayByteSequence);
    ByteSequence columnQualifierData = actualKeyFromEdgeId.getColumnQualifierData();
    assertTrue(columnQualifierData instanceof ArrayByteSequence);
    ByteSequence columnVisibilityData = actualKeyFromEdgeId.getColumnVisibilityData();
    assertTrue(columnVisibilityData instanceof ArrayByteSequence);
    ByteSequence rowData = actualKeyFromEdgeId.getRowData();
    assertTrue(rowData instanceof ArrayByteSequence);
    assertEquals(columnFamilyData, columnQualifierData);
    assertEquals(columnFamilyData, columnVisibilityData);
    byte[] backingArray = rowData.getBackingArray();
    assertSame(backingArray, rowData.toArray());
    assertArrayEquals(new byte[] {}, actualKeyFromEdgeId.getColumnVisibilityParsed().flatten());
    assertArrayEquals(
        new byte[] {
          'A',
          'X',
          'A',
          'X',
          'A',
          'X',
          'A',
          'X',
          0,
          'A',
          'X',
          'A',
          'X',
          'A',
          'X',
          'A',
          'X',
          0,
          ClassicBytePositions.INCORRECT_WAY_DIRECTED_EDGE,
          ClassicBytePositions.UNDIRECTED_EDGE
        },
        backingArray);
    assertArrayEquals(
        new byte[] {
          'A',
          'X',
          'A',
          'X',
          'A',
          'X',
          'A',
          'X',
          0,
          'A',
          'X',
          'A',
          'X',
          'A',
          'X',
          'A',
          'X',
          0,
          ClassicBytePositions.INCORRECT_WAY_DIRECTED_EDGE,
          ClassicBytePositions.UNDIRECTED_EDGE
        },
        actualKeyFromEdgeId.getRow().getBytes());
  }

  /**
   * Test {@link ClassicRangeFactory#getKeyFromEdgeId(Object, Object, DirectedType,
   * IncludeIncomingOutgoingType, boolean)}.
   *
   * <ul>
   *   <li>When {@code INCOMING}.
   * </ul>
   *
   * <p>Method under test: {@link ClassicRangeFactory#getKeyFromEdgeId(Object, Object, DirectedType,
   * IncludeIncomingOutgoingType, boolean)}
   */
  @Test
  @DisplayName(
      "Test getKeyFromEdgeId(Object, Object, DirectedType, IncludeIncomingOutgoingType, boolean); when 'INCOMING'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Key ClassicRangeFactory.getKeyFromEdgeId(Object, Object, DirectedType, IncludeIncomingOutgoingType, boolean)"
  })
  void testGetKeyFromEdgeId_whenIncoming()
      throws UnsupportedEncodingException, RangeFactoryException, SerialisationException {
    // Arrange
    AvroSerialiser avroSerialiser = mock(AvroSerialiser.class);
    when(avroSerialiser.serialise(Mockito.<Object>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    Schema schema = mock(Schema.class);
    when(schema.getVertexSerialiser()).thenReturn(avroSerialiser);

    // Act
    Key actualKeyFromEdgeId =
        new ClassicRangeFactory(schema)
            .getKeyFromEdgeId(
                "Source Val",
                "Dest Val",
                DirectedType.EITHER,
                IncludeIncomingOutgoingType.INCOMING,
                true);

    // Assert
    verify(avroSerialiser, atLeast(1)).serialise(Mockito.<Object>any());
    verify(schema).getVertexSerialiser();
    ByteSequence columnFamilyData = actualKeyFromEdgeId.getColumnFamilyData();
    assertTrue(columnFamilyData instanceof ArrayByteSequence);
    ByteSequence columnQualifierData = actualKeyFromEdgeId.getColumnQualifierData();
    assertTrue(columnQualifierData instanceof ArrayByteSequence);
    ByteSequence columnVisibilityData = actualKeyFromEdgeId.getColumnVisibilityData();
    assertTrue(columnVisibilityData instanceof ArrayByteSequence);
    ByteSequence rowData = actualKeyFromEdgeId.getRowData();
    assertTrue(rowData instanceof ArrayByteSequence);
    assertEquals(columnFamilyData, columnQualifierData);
    assertEquals(columnFamilyData, columnVisibilityData);
    byte[] backingArray = rowData.getBackingArray();
    assertSame(backingArray, rowData.toArray());
    assertArrayEquals(new byte[] {}, actualKeyFromEdgeId.getColumnVisibilityParsed().flatten());
    assertArrayEquals(
        new byte[] {
          'A',
          'X',
          'A',
          'X',
          'A',
          'X',
          'A',
          'X',
          0,
          'A',
          'X',
          'A',
          'X',
          'A',
          'X',
          'A',
          'X',
          0,
          ClassicBytePositions.INCORRECT_WAY_DIRECTED_EDGE,
          ClassicBytePositions.UNDIRECTED_EDGE
        },
        backingArray);
    assertArrayEquals(
        new byte[] {
          'A',
          'X',
          'A',
          'X',
          'A',
          'X',
          'A',
          'X',
          0,
          'A',
          'X',
          'A',
          'X',
          'A',
          'X',
          'A',
          'X',
          0,
          ClassicBytePositions.INCORRECT_WAY_DIRECTED_EDGE,
          ClassicBytePositions.UNDIRECTED_EDGE
        },
        actualKeyFromEdgeId.getRow().getBytes());
  }

  /**
   * Test {@link ClassicRangeFactory#getKeyFromEdgeId(Object, Object, DirectedType,
   * IncludeIncomingOutgoingType, boolean)}.
   *
   * <ul>
   *   <li>When {@link DirectedType#UNDIRECTED}.
   * </ul>
   *
   * <p>Method under test: {@link ClassicRangeFactory#getKeyFromEdgeId(Object, Object, DirectedType,
   * IncludeIncomingOutgoingType, boolean)}
   */
  @Test
  @DisplayName(
      "Test getKeyFromEdgeId(Object, Object, DirectedType, IncludeIncomingOutgoingType, boolean); when UNDIRECTED")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Key ClassicRangeFactory.getKeyFromEdgeId(Object, Object, DirectedType, IncludeIncomingOutgoingType, boolean)"
  })
  void testGetKeyFromEdgeId_whenUndirected()
      throws UnsupportedEncodingException, RangeFactoryException, SerialisationException {
    // Arrange
    AvroSerialiser avroSerialiser = mock(AvroSerialiser.class);
    when(avroSerialiser.serialise(Mockito.<Object>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    Schema schema = mock(Schema.class);
    when(schema.getVertexSerialiser()).thenReturn(avroSerialiser);

    // Act
    Key actualKeyFromEdgeId =
        new ClassicRangeFactory(schema)
            .getKeyFromEdgeId(
                "Source Val",
                "Dest Val",
                DirectedType.UNDIRECTED,
                IncludeIncomingOutgoingType.EITHER,
                true);

    // Assert
    verify(avroSerialiser, atLeast(1)).serialise(Mockito.<Object>any());
    verify(schema).getVertexSerialiser();
    ByteSequence columnFamilyData = actualKeyFromEdgeId.getColumnFamilyData();
    assertTrue(columnFamilyData instanceof ArrayByteSequence);
    ByteSequence columnQualifierData = actualKeyFromEdgeId.getColumnQualifierData();
    assertTrue(columnQualifierData instanceof ArrayByteSequence);
    ByteSequence columnVisibilityData = actualKeyFromEdgeId.getColumnVisibilityData();
    assertTrue(columnVisibilityData instanceof ArrayByteSequence);
    ByteSequence rowData = actualKeyFromEdgeId.getRowData();
    assertTrue(rowData instanceof ArrayByteSequence);
    assertEquals(columnFamilyData, columnQualifierData);
    assertEquals(columnFamilyData, columnVisibilityData);
    byte[] backingArray = rowData.getBackingArray();
    assertSame(backingArray, rowData.toArray());
    assertArrayEquals(new byte[] {}, actualKeyFromEdgeId.getColumnVisibilityParsed().flatten());
    assertArrayEquals(
        new byte[] {
          'A',
          'X',
          'A',
          'X',
          'A',
          'X',
          'A',
          'X',
          0,
          'A',
          'X',
          'A',
          'X',
          'A',
          'X',
          'A',
          'X',
          0,
          ClassicBytePositions.UNDIRECTED_EDGE,
          ClassicBytePositions.UNDIRECTED_EDGE
        },
        backingArray);
    assertArrayEquals(
        new byte[] {
          'A',
          'X',
          'A',
          'X',
          'A',
          'X',
          'A',
          'X',
          0,
          'A',
          'X',
          'A',
          'X',
          'A',
          'X',
          'A',
          'X',
          0,
          ClassicBytePositions.UNDIRECTED_EDGE,
          ClassicBytePositions.UNDIRECTED_EDGE
        },
        actualKeyFromEdgeId.getRow().getBytes());
  }
}
