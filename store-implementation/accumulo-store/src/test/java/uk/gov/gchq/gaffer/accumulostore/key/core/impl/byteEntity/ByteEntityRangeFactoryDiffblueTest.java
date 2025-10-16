package uk.gov.gchq.gaffer.accumulostore.key.core.impl.byteEntity;

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

class ByteEntityRangeFactoryDiffblueTest {
  /**
   * Test {@link ByteEntityRangeFactory#getRange(Object, GraphFilters, boolean)} with {@code
   * vertex}, {@code operation}, {@code includeEdgesParam}.
   *
   * <p>Method under test: {@link ByteEntityRangeFactory#getRange(Object, GraphFilters, boolean)}
   */
  @Test
  @DisplayName(
      "Test getRange(Object, GraphFilters, boolean) with 'vertex', 'operation', 'includeEdgesParam'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ByteEntityRangeFactory.getRange(Object, GraphFilters, boolean)"})
  void testGetRangeWithVertexOperationIncludeEdgesParam() throws RangeFactoryException {
    // Arrange
    Schema schema = mock(Schema.class);
    when(schema.getVertexSerialiser()).thenReturn(new AvroSerialiser());
    ByteEntityRangeFactory byteEntityRangeFactory = new ByteEntityRangeFactory(schema);

    GetElementsBetweenSets operation = mock(GetElementsBetweenSets.class);
    when(operation.getDirectedType()).thenReturn(DirectedType.EITHER);
    when(operation.getView()).thenReturn(new View());
    when(operation.getIncludeIncomingOutGoing()).thenReturn(IncludeIncomingOutgoingType.EITHER);

    // Act
    List<Range> actualRange = byteEntityRangeFactory.getRange("Vertex", operation, true);

    // Assert
    verify(operation).getDirectedType();
    verify(operation).getIncludeIncomingOutGoing();
    verify(operation).getView();
    verify(schema).getVertexSerialiser();
    assertEquals(1, actualRange.size());
    Range getResult = actualRange.get(0);
    Key startKey = getResult.getStartKey();
    ByteSequence rowData = startKey.getRowData();
    assertTrue(rowData instanceof ArrayByteSequence);
    assertEquals(73, rowData.getBackingArray().length);
    TRange toThriftResult = getResult.toThrift();
    TKey start = toThriftResult.getStart();
    assertEquals(73, start.getRow().length);
    assertEquals(73, startKey.getRow().getBytes().length);
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
   * Test {@link ByteEntityRangeFactory#getRange(Object, GraphFilters, boolean)} with {@code
   * vertex}, {@code operation}, {@code includeEdgesParam}.
   *
   * <p>Method under test: {@link ByteEntityRangeFactory#getRange(Object, GraphFilters, boolean)}
   */
  @Test
  @DisplayName(
      "Test getRange(Object, GraphFilters, boolean) with 'vertex', 'operation', 'includeEdgesParam'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ByteEntityRangeFactory.getRange(Object, GraphFilters, boolean)"})
  void testGetRangeWithVertexOperationIncludeEdgesParam2()
      throws UnsupportedEncodingException, RangeFactoryException, SerialisationException {
    // Arrange
    AvroSerialiser avroSerialiser = mock(AvroSerialiser.class);
    when(avroSerialiser.serialise(Mockito.<Object>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    Schema schema = mock(Schema.class);
    when(schema.getVertexSerialiser()).thenReturn(avroSerialiser);
    ByteEntityRangeFactory byteEntityRangeFactory = new ByteEntityRangeFactory(schema);

    View view = mock(View.class);
    when(view.hasEntities()).thenReturn(true);

    GetElementsBetweenSets operation = mock(GetElementsBetweenSets.class);
    when(operation.getDirectedType()).thenReturn(DirectedType.EITHER);
    when(operation.getView()).thenReturn(view);
    when(operation.getIncludeIncomingOutGoing()).thenReturn(IncludeIncomingOutgoingType.EITHER);

    // Act
    List<Range> actualRange = byteEntityRangeFactory.getRange("Vertex", operation, false);

    // Assert
    verify(operation).getDirectedType();
    verify(operation).getIncludeIncomingOutGoing();
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
   * Test {@link ByteEntityRangeFactory#getRange(Object, GraphFilters, boolean)} with {@code
   * vertex}, {@code operation}, {@code includeEdgesParam}.
   *
   * <p>Method under test: {@link ByteEntityRangeFactory#getRange(Object, GraphFilters, boolean)}
   */
  @Test
  @DisplayName(
      "Test getRange(Object, GraphFilters, boolean) with 'vertex', 'operation', 'includeEdgesParam'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ByteEntityRangeFactory.getRange(Object, GraphFilters, boolean)"})
  void testGetRangeWithVertexOperationIncludeEdgesParam3()
      throws UnsupportedEncodingException, RangeFactoryException, SerialisationException {
    // Arrange
    AvroSerialiser avroSerialiser = mock(AvroSerialiser.class);
    when(avroSerialiser.serialise(Mockito.<Object>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    Schema schema = mock(Schema.class);
    when(schema.getVertexSerialiser()).thenReturn(avroSerialiser);
    ByteEntityRangeFactory byteEntityRangeFactory = new ByteEntityRangeFactory(schema);

    View view = mock(View.class);
    when(view.hasEntities()).thenReturn(false);

    GetElementsBetweenSets operation = mock(GetElementsBetweenSets.class);
    when(operation.getDirectedType()).thenReturn(DirectedType.EITHER);
    when(operation.getView()).thenReturn(view);
    when(operation.getIncludeIncomingOutGoing()).thenReturn(IncludeIncomingOutgoingType.EITHER);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> byteEntityRangeFactory.getRange("Vertex", operation, false));
    verify(operation).getDirectedType();
    verify(operation).getIncludeIncomingOutGoing();
    verify(operation).getView();
    verify(view).hasEntities();
    verify(avroSerialiser).serialise(isA(Object.class));
    verify(schema).getVertexSerialiser();
  }

  /**
   * Test {@link ByteEntityRangeFactory#getRange(Object, GraphFilters, boolean)} with {@code
   * vertex}, {@code operation}, {@code includeEdgesParam}.
   *
   * <ul>
   *   <li>Given {@code DIRECTED}.
   * </ul>
   *
   * <p>Method under test: {@link ByteEntityRangeFactory#getRange(Object, GraphFilters, boolean)}
   */
  @Test
  @DisplayName(
      "Test getRange(Object, GraphFilters, boolean) with 'vertex', 'operation', 'includeEdgesParam'; given 'DIRECTED'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ByteEntityRangeFactory.getRange(Object, GraphFilters, boolean)"})
  void testGetRangeWithVertexOperationIncludeEdgesParam_givenDirected()
      throws UnsupportedEncodingException, RangeFactoryException, SerialisationException {
    // Arrange
    AvroSerialiser avroSerialiser = mock(AvroSerialiser.class);
    when(avroSerialiser.serialise(Mockito.<Object>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    Schema schema = mock(Schema.class);
    when(schema.getVertexSerialiser()).thenReturn(avroSerialiser);
    ByteEntityRangeFactory byteEntityRangeFactory = new ByteEntityRangeFactory(schema);

    View view = mock(View.class);
    when(view.hasEntities()).thenReturn(true);

    GetElementsBetweenSets operation = mock(GetElementsBetweenSets.class);
    when(operation.getDirectedType()).thenReturn(DirectedType.DIRECTED);
    when(operation.getView()).thenReturn(view);
    when(operation.getIncludeIncomingOutGoing()).thenReturn(IncludeIncomingOutgoingType.EITHER);

    // Act
    List<Range> actualRange = byteEntityRangeFactory.getRange("Vertex", operation, true);

    // Assert
    verify(operation).getDirectedType();
    verify(operation).getIncludeIncomingOutGoing();
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
    TRange toThriftResult = getResult.toThrift();
    TKey start = toThriftResult.getStart();
    assertArrayEquals(new byte[] {}, start.getColFamily());
    TKey stop = toThriftResult.getStop();
    assertArrayEquals(new byte[] {}, stop.getColFamily());
    assertArrayEquals(new byte[] {}, start.getColQualifier());
    assertArrayEquals(new byte[] {}, stop.getColQualifier());
    assertArrayEquals(new byte[] {}, start.getColVisibility());
    assertArrayEquals(new byte[] {}, stop.getColVisibility());
    assertArrayEquals(new byte[] {}, endKey.getColumnVisibilityParsed().flatten());
    assertArrayEquals(new byte[] {}, startKey.getColumnVisibilityParsed().flatten());
    assertArrayEquals(
        new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, ByteEntityPositions.ENTITY},
        rowData2.getBackingArray());
    assertArrayEquals(
        new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, ByteEntityPositions.ENTITY},
        start.getRow());
    assertArrayEquals(
        new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, ByteEntityPositions.ENTITY},
        startKey.getRow().getBytes());
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
          ByteEntityPositions.INCORRECT_WAY_DIRECTED_EDGE,
          ByteEntityPositions.ENTITY
        },
        rowData.getBackingArray());
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
          ByteEntityPositions.INCORRECT_WAY_DIRECTED_EDGE,
          ByteEntityPositions.ENTITY
        },
        stop.getRow());
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
          ByteEntityPositions.INCORRECT_WAY_DIRECTED_EDGE,
          ByteEntityPositions.ENTITY
        },
        endKey.getRow().getBytes());
  }

  /**
   * Test {@link ByteEntityRangeFactory#getRange(Object, GraphFilters, boolean)} with {@code
   * vertex}, {@code operation}, {@code includeEdgesParam}.
   *
   * <ul>
   *   <li>Given {@code DIRECTED}.
   * </ul>
   *
   * <p>Method under test: {@link ByteEntityRangeFactory#getRange(Object, GraphFilters, boolean)}
   */
  @Test
  @DisplayName(
      "Test getRange(Object, GraphFilters, boolean) with 'vertex', 'operation', 'includeEdgesParam'; given 'DIRECTED'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ByteEntityRangeFactory.getRange(Object, GraphFilters, boolean)"})
  void testGetRangeWithVertexOperationIncludeEdgesParam_givenDirected2()
      throws UnsupportedEncodingException, RangeFactoryException, SerialisationException {
    // Arrange
    AvroSerialiser avroSerialiser = mock(AvroSerialiser.class);
    when(avroSerialiser.serialise(Mockito.<Object>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    Schema schema = mock(Schema.class);
    when(schema.getVertexSerialiser()).thenReturn(avroSerialiser);
    ByteEntityRangeFactory byteEntityRangeFactory = new ByteEntityRangeFactory(schema);

    View view = mock(View.class);
    when(view.hasEntities()).thenReturn(false);

    GetElementsBetweenSets operation = mock(GetElementsBetweenSets.class);
    when(operation.getDirectedType()).thenReturn(DirectedType.DIRECTED);
    when(operation.getView()).thenReturn(view);
    when(operation.getIncludeIncomingOutGoing()).thenReturn(IncludeIncomingOutgoingType.EITHER);

    // Act
    List<Range> actualRange = byteEntityRangeFactory.getRange("Vertex", operation, true);

    // Assert
    verify(operation).getDirectedType();
    verify(operation).getIncludeIncomingOutGoing();
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
    TRange toThriftResult = getResult.toThrift();
    TKey start = toThriftResult.getStart();
    assertArrayEquals(new byte[] {}, start.getColFamily());
    TKey stop = toThriftResult.getStop();
    assertArrayEquals(new byte[] {}, stop.getColFamily());
    assertArrayEquals(new byte[] {}, start.getColQualifier());
    assertArrayEquals(new byte[] {}, stop.getColQualifier());
    assertArrayEquals(new byte[] {}, start.getColVisibility());
    assertArrayEquals(new byte[] {}, stop.getColVisibility());
    assertArrayEquals(new byte[] {}, endKey.getColumnVisibilityParsed().flatten());
    assertArrayEquals(new byte[] {}, startKey.getColumnVisibilityParsed().flatten());
    assertArrayEquals(
        new byte[] {
          'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, ByteEntityPositions.CORRECT_WAY_DIRECTED_EDGE
        },
        rowData2.getBackingArray());
    assertArrayEquals(
        new byte[] {
          'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, ByteEntityPositions.CORRECT_WAY_DIRECTED_EDGE
        },
        start.getRow());
    assertArrayEquals(
        new byte[] {
          'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, ByteEntityPositions.CORRECT_WAY_DIRECTED_EDGE
        },
        startKey.getRow().getBytes());
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
          ByteEntityPositions.INCORRECT_WAY_DIRECTED_EDGE,
          ByteEntityPositions.ENTITY
        },
        rowData.getBackingArray());
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
          ByteEntityPositions.INCORRECT_WAY_DIRECTED_EDGE,
          ByteEntityPositions.ENTITY
        },
        stop.getRow());
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
          ByteEntityPositions.INCORRECT_WAY_DIRECTED_EDGE,
          ByteEntityPositions.ENTITY
        },
        endKey.getRow().getBytes());
  }

  /**
   * Test {@link ByteEntityRangeFactory#getRange(Object, GraphFilters, boolean)} with {@code
   * vertex}, {@code operation}, {@code includeEdgesParam}.
   *
   * <ul>
   *   <li>Given {@link IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link ByteEntityRangeFactory#getRange(Object, GraphFilters, boolean)}
   */
  @Test
  @DisplayName(
      "Test getRange(Object, GraphFilters, boolean) with 'vertex', 'operation', 'includeEdgesParam'; given IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ByteEntityRangeFactory.getRange(Object, GraphFilters, boolean)"})
  void testGetRangeWithVertexOperationIncludeEdgesParam_givenIllegalArgumentException()
      throws RangeFactoryException {
    // Arrange
    ByteEntityRangeFactory byteEntityRangeFactory = new ByteEntityRangeFactory(new Schema());

    GetElementsBetweenSets operation = mock(GetElementsBetweenSets.class);
    when(operation.getIncludeIncomingOutGoing()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> byteEntityRangeFactory.getRange("Vertex", operation, true));
    verify(operation).getIncludeIncomingOutGoing();
  }

  /**
   * Test {@link ByteEntityRangeFactory#getRange(Object, GraphFilters, boolean)} with {@code
   * vertex}, {@code operation}, {@code includeEdgesParam}.
   *
   * <ul>
   *   <li>Given {@code INCOMING}.
   * </ul>
   *
   * <p>Method under test: {@link ByteEntityRangeFactory#getRange(Object, GraphFilters, boolean)}
   */
  @Test
  @DisplayName(
      "Test getRange(Object, GraphFilters, boolean) with 'vertex', 'operation', 'includeEdgesParam'; given 'INCOMING'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ByteEntityRangeFactory.getRange(Object, GraphFilters, boolean)"})
  void testGetRangeWithVertexOperationIncludeEdgesParam_givenIncoming()
      throws UnsupportedEncodingException, RangeFactoryException, SerialisationException {
    // Arrange
    AvroSerialiser avroSerialiser = mock(AvroSerialiser.class);
    when(avroSerialiser.serialise(Mockito.<Object>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    Schema schema = mock(Schema.class);
    when(schema.getVertexSerialiser()).thenReturn(avroSerialiser);
    ByteEntityRangeFactory byteEntityRangeFactory = new ByteEntityRangeFactory(schema);

    View view = mock(View.class);
    when(view.hasEntities()).thenReturn(true);

    GetElementsBetweenSets operation = mock(GetElementsBetweenSets.class);
    when(operation.getDirectedType()).thenReturn(DirectedType.EITHER);
    when(operation.getView()).thenReturn(view);
    when(operation.getIncludeIncomingOutGoing()).thenReturn(IncludeIncomingOutgoingType.INCOMING);

    // Act
    List<Range> actualRange = byteEntityRangeFactory.getRange("Vertex", operation, true);

    // Assert
    verify(operation).getDirectedType();
    verify(operation).getIncludeIncomingOutGoing();
    verify(operation).getView();
    verify(view).hasEntities();
    verify(avroSerialiser).serialise(isA(Object.class));
    verify(schema).getVertexSerialiser();
    assertEquals(2, actualRange.size());
    assertTrue(actualRange.get(0).getEndKey().getRowData() instanceof ArrayByteSequence);
    Range getResult = actualRange.get(1);
    assertTrue(getResult.getEndKey().getRowData() instanceof ArrayByteSequence);
    assertTrue(getResult.getStartKey().getRowData() instanceof ArrayByteSequence);
  }

  /**
   * Test {@link ByteEntityRangeFactory#getRange(Object, GraphFilters, boolean)} with {@code
   * vertex}, {@code operation}, {@code includeEdgesParam}.
   *
   * <ul>
   *   <li>Given {@code INCOMING}.
   * </ul>
   *
   * <p>Method under test: {@link ByteEntityRangeFactory#getRange(Object, GraphFilters, boolean)}
   */
  @Test
  @DisplayName(
      "Test getRange(Object, GraphFilters, boolean) with 'vertex', 'operation', 'includeEdgesParam'; given 'INCOMING'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ByteEntityRangeFactory.getRange(Object, GraphFilters, boolean)"})
  void testGetRangeWithVertexOperationIncludeEdgesParam_givenIncoming2()
      throws UnsupportedEncodingException, RangeFactoryException, SerialisationException {
    // Arrange
    AvroSerialiser avroSerialiser = mock(AvroSerialiser.class);
    when(avroSerialiser.serialise(Mockito.<Object>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    Schema schema = mock(Schema.class);
    when(schema.getVertexSerialiser()).thenReturn(avroSerialiser);
    ByteEntityRangeFactory byteEntityRangeFactory = new ByteEntityRangeFactory(schema);

    View view = mock(View.class);
    when(view.hasEntities()).thenReturn(true);

    GetElementsBetweenSets operation = mock(GetElementsBetweenSets.class);
    when(operation.getDirectedType()).thenReturn(DirectedType.DIRECTED);
    when(operation.getView()).thenReturn(view);
    when(operation.getIncludeIncomingOutGoing()).thenReturn(IncludeIncomingOutgoingType.INCOMING);

    // Act
    List<Range> actualRange = byteEntityRangeFactory.getRange("Vertex", operation, true);

    // Assert
    verify(operation).getDirectedType();
    verify(operation).getIncludeIncomingOutGoing();
    verify(operation).getView();
    verify(view).hasEntities();
    verify(avroSerialiser).serialise(isA(Object.class));
    verify(schema).getVertexSerialiser();
    assertEquals(2, actualRange.size());
    assertTrue(actualRange.get(0).getEndKey().getRowData() instanceof ArrayByteSequence);
    Range getResult = actualRange.get(1);
    assertTrue(getResult.getEndKey().getRowData() instanceof ArrayByteSequence);
    assertTrue(getResult.getStartKey().getRowData() instanceof ArrayByteSequence);
  }

  /**
   * Test {@link ByteEntityRangeFactory#getRange(Object, GraphFilters, boolean)} with {@code
   * vertex}, {@code operation}, {@code includeEdgesParam}.
   *
   * <ul>
   *   <li>Given {@code INCOMING}.
   * </ul>
   *
   * <p>Method under test: {@link ByteEntityRangeFactory#getRange(Object, GraphFilters, boolean)}
   */
  @Test
  @DisplayName(
      "Test getRange(Object, GraphFilters, boolean) with 'vertex', 'operation', 'includeEdgesParam'; given 'INCOMING'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ByteEntityRangeFactory.getRange(Object, GraphFilters, boolean)"})
  void testGetRangeWithVertexOperationIncludeEdgesParam_givenIncoming3()
      throws UnsupportedEncodingException, RangeFactoryException, SerialisationException {
    // Arrange
    AvroSerialiser avroSerialiser = mock(AvroSerialiser.class);
    when(avroSerialiser.serialise(Mockito.<Object>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    Schema schema = mock(Schema.class);
    when(schema.getVertexSerialiser()).thenReturn(avroSerialiser);
    ByteEntityRangeFactory byteEntityRangeFactory = new ByteEntityRangeFactory(schema);

    View view = mock(View.class);
    when(view.hasEntities()).thenReturn(false);

    GetElementsBetweenSets operation = mock(GetElementsBetweenSets.class);
    when(operation.getDirectedType()).thenReturn(DirectedType.EITHER);
    when(operation.getView()).thenReturn(view);
    when(operation.getIncludeIncomingOutGoing()).thenReturn(IncludeIncomingOutgoingType.INCOMING);

    // Act
    List<Range> actualRange = byteEntityRangeFactory.getRange("Vertex", operation, true);

    // Assert
    verify(operation).getDirectedType();
    verify(operation).getIncludeIncomingOutGoing();
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
    TRange toThriftResult = getResult.toThrift();
    TKey start = toThriftResult.getStart();
    assertArrayEquals(new byte[] {}, start.getColFamily());
    TKey stop = toThriftResult.getStop();
    assertArrayEquals(new byte[] {}, stop.getColFamily());
    assertArrayEquals(new byte[] {}, start.getColQualifier());
    assertArrayEquals(new byte[] {}, stop.getColQualifier());
    assertArrayEquals(new byte[] {}, start.getColVisibility());
    assertArrayEquals(new byte[] {}, stop.getColVisibility());
    assertArrayEquals(new byte[] {}, endKey.getColumnVisibilityParsed().flatten());
    assertArrayEquals(new byte[] {}, startKey.getColumnVisibilityParsed().flatten());
    assertArrayEquals(
        new byte[] {
          'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, ByteEntityPositions.INCORRECT_WAY_DIRECTED_EDGE
        },
        rowData2.getBackingArray());
    assertArrayEquals(
        new byte[] {
          'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, ByteEntityPositions.INCORRECT_WAY_DIRECTED_EDGE
        },
        start.getRow());
    assertArrayEquals(
        new byte[] {
          'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, ByteEntityPositions.INCORRECT_WAY_DIRECTED_EDGE
        },
        startKey.getRow().getBytes());
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
          ByteEntityPositions.UNDIRECTED_EDGE,
          ByteEntityPositions.ENTITY
        },
        rowData.getBackingArray());
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
          ByteEntityPositions.UNDIRECTED_EDGE,
          ByteEntityPositions.ENTITY
        },
        stop.getRow());
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
          ByteEntityPositions.UNDIRECTED_EDGE,
          ByteEntityPositions.ENTITY
        },
        endKey.getRow().getBytes());
  }

  /**
   * Test {@link ByteEntityRangeFactory#getRange(Object, GraphFilters, boolean)} with {@code
   * vertex}, {@code operation}, {@code includeEdgesParam}.
   *
   * <ul>
   *   <li>Given {@code OUTGOING}.
   * </ul>
   *
   * <p>Method under test: {@link ByteEntityRangeFactory#getRange(Object, GraphFilters, boolean)}
   */
  @Test
  @DisplayName(
      "Test getRange(Object, GraphFilters, boolean) with 'vertex', 'operation', 'includeEdgesParam'; given 'OUTGOING'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ByteEntityRangeFactory.getRange(Object, GraphFilters, boolean)"})
  void testGetRangeWithVertexOperationIncludeEdgesParam_givenOutgoing()
      throws UnsupportedEncodingException, RangeFactoryException, SerialisationException {
    // Arrange
    AvroSerialiser avroSerialiser = mock(AvroSerialiser.class);
    when(avroSerialiser.serialise(Mockito.<Object>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    Schema schema = mock(Schema.class);
    when(schema.getVertexSerialiser()).thenReturn(avroSerialiser);
    ByteEntityRangeFactory byteEntityRangeFactory = new ByteEntityRangeFactory(schema);

    View view = mock(View.class);
    when(view.hasEntities()).thenReturn(true);

    GetElementsBetweenSets operation = mock(GetElementsBetweenSets.class);
    when(operation.getDirectedType()).thenReturn(DirectedType.EITHER);
    when(operation.getView()).thenReturn(view);
    when(operation.getIncludeIncomingOutGoing()).thenReturn(IncludeIncomingOutgoingType.OUTGOING);

    // Act
    List<Range> actualRange = byteEntityRangeFactory.getRange("Vertex", operation, true);

    // Assert
    verify(operation).getDirectedType();
    verify(operation).getIncludeIncomingOutGoing();
    verify(operation).getView();
    verify(view).hasEntities();
    verify(avroSerialiser).serialise(isA(Object.class));
    verify(schema).getVertexSerialiser();
    assertEquals(2, actualRange.size());
    assertTrue(actualRange.get(0).getEndKey().getRowData() instanceof ArrayByteSequence);
    Range getResult = actualRange.get(1);
    assertTrue(getResult.getEndKey().getRowData() instanceof ArrayByteSequence);
    assertTrue(getResult.getStartKey().getRowData() instanceof ArrayByteSequence);
  }

  /**
   * Test {@link ByteEntityRangeFactory#getRange(Object, GraphFilters, boolean)} with {@code
   * vertex}, {@code operation}, {@code includeEdgesParam}.
   *
   * <ul>
   *   <li>Given {@code OUTGOING}.
   * </ul>
   *
   * <p>Method under test: {@link ByteEntityRangeFactory#getRange(Object, GraphFilters, boolean)}
   */
  @Test
  @DisplayName(
      "Test getRange(Object, GraphFilters, boolean) with 'vertex', 'operation', 'includeEdgesParam'; given 'OUTGOING'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ByteEntityRangeFactory.getRange(Object, GraphFilters, boolean)"})
  void testGetRangeWithVertexOperationIncludeEdgesParam_givenOutgoing2()
      throws UnsupportedEncodingException, RangeFactoryException, SerialisationException {
    // Arrange
    AvroSerialiser avroSerialiser = mock(AvroSerialiser.class);
    when(avroSerialiser.serialise(Mockito.<Object>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    Schema schema = mock(Schema.class);
    when(schema.getVertexSerialiser()).thenReturn(avroSerialiser);
    ByteEntityRangeFactory byteEntityRangeFactory = new ByteEntityRangeFactory(schema);

    View view = mock(View.class);
    when(view.hasEntities()).thenReturn(true);

    GetElementsBetweenSets operation = mock(GetElementsBetweenSets.class);
    when(operation.getDirectedType()).thenReturn(DirectedType.DIRECTED);
    when(operation.getView()).thenReturn(view);
    when(operation.getIncludeIncomingOutGoing()).thenReturn(IncludeIncomingOutgoingType.OUTGOING);

    // Act
    List<Range> actualRange = byteEntityRangeFactory.getRange("Vertex", operation, true);

    // Assert
    verify(operation).getDirectedType();
    verify(operation).getIncludeIncomingOutGoing();
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
    TRange toThriftResult = getResult.toThrift();
    TKey start = toThriftResult.getStart();
    assertArrayEquals(new byte[] {}, start.getColFamily());
    TKey stop = toThriftResult.getStop();
    assertArrayEquals(new byte[] {}, stop.getColFamily());
    assertArrayEquals(new byte[] {}, start.getColQualifier());
    assertArrayEquals(new byte[] {}, stop.getColQualifier());
    assertArrayEquals(new byte[] {}, start.getColVisibility());
    assertArrayEquals(new byte[] {}, stop.getColVisibility());
    assertArrayEquals(new byte[] {}, endKey.getColumnVisibilityParsed().flatten());
    assertArrayEquals(new byte[] {}, startKey.getColumnVisibilityParsed().flatten());
    assertArrayEquals(
        new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, ByteEntityPositions.ENTITY},
        rowData2.getBackingArray());
    assertArrayEquals(
        new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, ByteEntityPositions.ENTITY},
        start.getRow());
    assertArrayEquals(
        new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, ByteEntityPositions.ENTITY},
        startKey.getRow().getBytes());
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
          ByteEntityPositions.CORRECT_WAY_DIRECTED_EDGE,
          ByteEntityPositions.ENTITY
        },
        rowData.getBackingArray());
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
          ByteEntityPositions.CORRECT_WAY_DIRECTED_EDGE,
          ByteEntityPositions.ENTITY
        },
        stop.getRow());
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
          ByteEntityPositions.CORRECT_WAY_DIRECTED_EDGE,
          ByteEntityPositions.ENTITY
        },
        endKey.getRow().getBytes());
  }

  /**
   * Test {@link ByteEntityRangeFactory#getRange(Object, GraphFilters, boolean)} with {@code
   * vertex}, {@code operation}, {@code includeEdgesParam}.
   *
   * <ul>
   *   <li>Given {@code OUTGOING}.
   * </ul>
   *
   * <p>Method under test: {@link ByteEntityRangeFactory#getRange(Object, GraphFilters, boolean)}
   */
  @Test
  @DisplayName(
      "Test getRange(Object, GraphFilters, boolean) with 'vertex', 'operation', 'includeEdgesParam'; given 'OUTGOING'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ByteEntityRangeFactory.getRange(Object, GraphFilters, boolean)"})
  void testGetRangeWithVertexOperationIncludeEdgesParam_givenOutgoing3()
      throws UnsupportedEncodingException, RangeFactoryException, SerialisationException {
    // Arrange
    AvroSerialiser avroSerialiser = mock(AvroSerialiser.class);
    when(avroSerialiser.serialise(Mockito.<Object>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    Schema schema = mock(Schema.class);
    when(schema.getVertexSerialiser()).thenReturn(avroSerialiser);
    ByteEntityRangeFactory byteEntityRangeFactory = new ByteEntityRangeFactory(schema);

    View view = mock(View.class);
    when(view.hasEntities()).thenReturn(false);

    GetElementsBetweenSets operation = mock(GetElementsBetweenSets.class);
    when(operation.getDirectedType()).thenReturn(DirectedType.EITHER);
    when(operation.getView()).thenReturn(view);
    when(operation.getIncludeIncomingOutGoing()).thenReturn(IncludeIncomingOutgoingType.OUTGOING);

    // Act
    List<Range> actualRange = byteEntityRangeFactory.getRange("Vertex", operation, true);

    // Assert
    verify(operation).getDirectedType();
    verify(operation).getIncludeIncomingOutGoing();
    verify(operation).getView();
    verify(view).hasEntities();
    verify(avroSerialiser).serialise(isA(Object.class));
    verify(schema).getVertexSerialiser();
    assertEquals(2, actualRange.size());
    assertTrue(actualRange.get(0).getEndKey().getRowData() instanceof ArrayByteSequence);
    Range getResult = actualRange.get(1);
    assertTrue(getResult.getEndKey().getRowData() instanceof ArrayByteSequence);
    assertTrue(getResult.getStartKey().getRowData() instanceof ArrayByteSequence);
  }

  /**
   * Test {@link ByteEntityRangeFactory#getRange(Object, GraphFilters, boolean)} with {@code
   * vertex}, {@code operation}, {@code includeEdgesParam}.
   *
   * <ul>
   *   <li>Given {@code UNDIRECTED}.
   * </ul>
   *
   * <p>Method under test: {@link ByteEntityRangeFactory#getRange(Object, GraphFilters, boolean)}
   */
  @Test
  @DisplayName(
      "Test getRange(Object, GraphFilters, boolean) with 'vertex', 'operation', 'includeEdgesParam'; given 'UNDIRECTED'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ByteEntityRangeFactory.getRange(Object, GraphFilters, boolean)"})
  void testGetRangeWithVertexOperationIncludeEdgesParam_givenUndirected()
      throws UnsupportedEncodingException, RangeFactoryException, SerialisationException {
    // Arrange
    AvroSerialiser avroSerialiser = mock(AvroSerialiser.class);
    when(avroSerialiser.serialise(Mockito.<Object>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    Schema schema = mock(Schema.class);
    when(schema.getVertexSerialiser()).thenReturn(avroSerialiser);
    ByteEntityRangeFactory byteEntityRangeFactory = new ByteEntityRangeFactory(schema);

    View view = mock(View.class);
    when(view.hasEntities()).thenReturn(true);

    GetElementsBetweenSets operation = mock(GetElementsBetweenSets.class);
    when(operation.getDirectedType()).thenReturn(DirectedType.UNDIRECTED);
    when(operation.getView()).thenReturn(view);
    when(operation.getIncludeIncomingOutGoing()).thenReturn(IncludeIncomingOutgoingType.EITHER);

    // Act
    List<Range> actualRange = byteEntityRangeFactory.getRange("Vertex", operation, true);

    // Assert
    verify(operation).getDirectedType();
    verify(operation).getIncludeIncomingOutGoing();
    verify(operation).getView();
    verify(view).hasEntities();
    verify(avroSerialiser).serialise(isA(Object.class));
    verify(schema).getVertexSerialiser();
    assertEquals(2, actualRange.size());
    assertTrue(actualRange.get(0).getEndKey().getRowData() instanceof ArrayByteSequence);
    Range getResult = actualRange.get(1);
    assertTrue(getResult.getEndKey().getRowData() instanceof ArrayByteSequence);
    assertTrue(getResult.getStartKey().getRowData() instanceof ArrayByteSequence);
  }

  /**
   * Test {@link ByteEntityRangeFactory#getRange(Object, GraphFilters, boolean)} with {@code
   * vertex}, {@code operation}, {@code includeEdgesParam}.
   *
   * <ul>
   *   <li>Given {@code UNDIRECTED}.
   * </ul>
   *
   * <p>Method under test: {@link ByteEntityRangeFactory#getRange(Object, GraphFilters, boolean)}
   */
  @Test
  @DisplayName(
      "Test getRange(Object, GraphFilters, boolean) with 'vertex', 'operation', 'includeEdgesParam'; given 'UNDIRECTED'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ByteEntityRangeFactory.getRange(Object, GraphFilters, boolean)"})
  void testGetRangeWithVertexOperationIncludeEdgesParam_givenUndirected2()
      throws UnsupportedEncodingException, RangeFactoryException, SerialisationException {
    // Arrange
    AvroSerialiser avroSerialiser = mock(AvroSerialiser.class);
    when(avroSerialiser.serialise(Mockito.<Object>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    Schema schema = mock(Schema.class);
    when(schema.getVertexSerialiser()).thenReturn(avroSerialiser);
    ByteEntityRangeFactory byteEntityRangeFactory = new ByteEntityRangeFactory(schema);

    View view = mock(View.class);
    when(view.hasEntities()).thenReturn(false);

    GetElementsBetweenSets operation = mock(GetElementsBetweenSets.class);
    when(operation.getDirectedType()).thenReturn(DirectedType.UNDIRECTED);
    when(operation.getView()).thenReturn(view);
    when(operation.getIncludeIncomingOutGoing()).thenReturn(IncludeIncomingOutgoingType.EITHER);

    // Act
    List<Range> actualRange = byteEntityRangeFactory.getRange("Vertex", operation, true);

    // Assert
    verify(operation).getDirectedType();
    verify(operation).getIncludeIncomingOutGoing();
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
    TRange toThriftResult = getResult.toThrift();
    TKey start = toThriftResult.getStart();
    assertArrayEquals(new byte[] {}, start.getColFamily());
    TKey stop = toThriftResult.getStop();
    assertArrayEquals(new byte[] {}, stop.getColFamily());
    assertArrayEquals(new byte[] {}, start.getColQualifier());
    assertArrayEquals(new byte[] {}, stop.getColQualifier());
    assertArrayEquals(new byte[] {}, start.getColVisibility());
    assertArrayEquals(new byte[] {}, stop.getColVisibility());
    assertArrayEquals(new byte[] {}, endKey.getColumnVisibilityParsed().flatten());
    assertArrayEquals(new byte[] {}, startKey.getColumnVisibilityParsed().flatten());
    assertArrayEquals(
        new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, ByteEntityPositions.UNDIRECTED_EDGE},
        rowData2.getBackingArray());
    assertArrayEquals(
        new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, ByteEntityPositions.UNDIRECTED_EDGE},
        start.getRow());
    assertArrayEquals(
        new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, ByteEntityPositions.UNDIRECTED_EDGE},
        startKey.getRow().getBytes());
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
          ByteEntityPositions.UNDIRECTED_EDGE,
          ByteEntityPositions.ENTITY
        },
        rowData.getBackingArray());
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
          ByteEntityPositions.UNDIRECTED_EDGE,
          ByteEntityPositions.ENTITY
        },
        stop.getRow());
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
          ByteEntityPositions.UNDIRECTED_EDGE,
          ByteEntityPositions.ENTITY
        },
        endKey.getRow().getBytes());
  }

  /**
   * Test {@link ByteEntityRangeFactory#getRange(Object, GraphFilters, boolean)} with {@code
   * vertex}, {@code operation}, {@code includeEdgesParam}.
   *
   * <ul>
   *   <li>Then throw {@link RangeFactoryException}.
   * </ul>
   *
   * <p>Method under test: {@link ByteEntityRangeFactory#getRange(Object, GraphFilters, boolean)}
   */
  @Test
  @DisplayName(
      "Test getRange(Object, GraphFilters, boolean) with 'vertex', 'operation', 'includeEdgesParam'; then throw RangeFactoryException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ByteEntityRangeFactory.getRange(Object, GraphFilters, boolean)"})
  void testGetRangeWithVertexOperationIncludeEdgesParam_thenThrowRangeFactoryException()
      throws RangeFactoryException, SerialisationException {
    // Arrange
    AvroSerialiser avroSerialiser = mock(AvroSerialiser.class);
    when(avroSerialiser.serialise(Mockito.<Object>any()))
        .thenThrow(new SerialisationException("An error occurred"));

    Schema schema = mock(Schema.class);
    when(schema.getVertexSerialiser()).thenReturn(avroSerialiser);
    ByteEntityRangeFactory byteEntityRangeFactory = new ByteEntityRangeFactory(schema);

    View view = mock(View.class);
    when(view.hasEntities()).thenReturn(true);

    GetElementsBetweenSets operation = mock(GetElementsBetweenSets.class);
    when(operation.getDirectedType()).thenReturn(DirectedType.EITHER);
    when(operation.getView()).thenReturn(view);
    when(operation.getIncludeIncomingOutGoing()).thenReturn(IncludeIncomingOutgoingType.EITHER);

    // Act and Assert
    assertThrows(
        RangeFactoryException.class,
        () -> byteEntityRangeFactory.getRange("Vertex", operation, true));
    verify(operation).getDirectedType();
    verify(operation).getIncludeIncomingOutGoing();
    verify(operation).getView();
    verify(view).hasEntities();
    verify(avroSerialiser).serialise(isA(Object.class));
    verify(schema).getVertexSerialiser();
  }

  /**
   * Test {@link ByteEntityRangeFactory#getKeyFromEdgeId(Object, Object, boolean, boolean)}.
   *
   * <ul>
   *   <li>Then ColumnFamilyData return {@link ArrayByteSequence}.
   * </ul>
   *
   * <p>Method under test: {@link ByteEntityRangeFactory#getKeyFromEdgeId(Object, Object, boolean,
   * boolean)}
   */
  @Test
  @DisplayName(
      "Test getKeyFromEdgeId(Object, Object, boolean, boolean); then ColumnFamilyData return ArrayByteSequence")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Key ByteEntityRangeFactory.getKeyFromEdgeId(Object, Object, boolean, boolean)"
  })
  void testGetKeyFromEdgeId_thenColumnFamilyDataReturnArrayByteSequence()
      throws RangeFactoryException {
    // Arrange
    Schema schema = mock(Schema.class);
    when(schema.getVertexSerialiser()).thenReturn(new AvroSerialiser());

    // Act
    Key actualKeyFromEdgeId =
        new ByteEntityRangeFactory(schema).getKeyFromEdgeId("Source", "Destination", true, true);

    // Assert
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
    byte[] expectedToArrayResult = rowData.getBackingArray();
    assertSame(expectedToArrayResult, rowData.toArray());
    assertArrayEquals(new byte[] {}, actualKeyFromEdgeId.getColumnVisibilityParsed().flatten());
  }

  /**
   * Test {@link ByteEntityRangeFactory#getKeyFromEdgeId(Object, Object, boolean, boolean)}.
   *
   * <ul>
   *   <li>Then return Length is twenty-one.
   * </ul>
   *
   * <p>Method under test: {@link ByteEntityRangeFactory#getKeyFromEdgeId(Object, Object, boolean,
   * boolean)}
   */
  @Test
  @DisplayName(
      "Test getKeyFromEdgeId(Object, Object, boolean, boolean); then return Length is twenty-one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Key ByteEntityRangeFactory.getKeyFromEdgeId(Object, Object, boolean, boolean)"
  })
  void testGetKeyFromEdgeId_thenReturnLengthIsTwentyOne()
      throws UnsupportedEncodingException, RangeFactoryException, SerialisationException {
    // Arrange
    AvroSerialiser avroSerialiser = mock(AvroSerialiser.class);
    when(avroSerialiser.serialise(Mockito.<Object>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    Schema schema = mock(Schema.class);
    when(schema.getVertexSerialiser()).thenReturn(avroSerialiser);

    // Act
    Key actualKeyFromEdgeId =
        new ByteEntityRangeFactory(schema).getKeyFromEdgeId("Source", "Destination", true, false);

    // Assert
    verify(avroSerialiser, atLeast(1)).serialise(Mockito.<Object>any());
    verify(schema).getVertexSerialiser();
    assertTrue(actualKeyFromEdgeId.getColumnQualifierData() instanceof ArrayByteSequence);
    assertTrue(actualKeyFromEdgeId.getColumnVisibilityData() instanceof ArrayByteSequence);
    assertEquals(21, actualKeyFromEdgeId.getLength());
    assertEquals(21, actualKeyFromEdgeId.getSize());
  }

  /**
   * Test {@link ByteEntityRangeFactory#getKeyFromEdgeId(Object, Object, boolean, boolean)}.
   *
   * <ul>
   *   <li>Then return Length is twenty-two.
   * </ul>
   *
   * <p>Method under test: {@link ByteEntityRangeFactory#getKeyFromEdgeId(Object, Object, boolean,
   * boolean)}
   */
  @Test
  @DisplayName(
      "Test getKeyFromEdgeId(Object, Object, boolean, boolean); then return Length is twenty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Key ByteEntityRangeFactory.getKeyFromEdgeId(Object, Object, boolean, boolean)"
  })
  void testGetKeyFromEdgeId_thenReturnLengthIsTwentyTwo()
      throws UnsupportedEncodingException, RangeFactoryException, SerialisationException {
    // Arrange
    AvroSerialiser avroSerialiser = mock(AvroSerialiser.class);
    when(avroSerialiser.serialise(Mockito.<Object>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    Schema schema = mock(Schema.class);
    when(schema.getVertexSerialiser()).thenReturn(avroSerialiser);

    // Act
    Key actualKeyFromEdgeId =
        new ByteEntityRangeFactory(schema).getKeyFromEdgeId("Source", "Destination", false, true);

    // Assert
    verify(avroSerialiser, atLeast(1)).serialise(Mockito.<Object>any());
    verify(schema).getVertexSerialiser();
    assertTrue(actualKeyFromEdgeId.getColumnQualifierData() instanceof ArrayByteSequence);
    assertTrue(actualKeyFromEdgeId.getColumnVisibilityData() instanceof ArrayByteSequence);
    assertEquals(22, actualKeyFromEdgeId.getLength());
    assertEquals(22, actualKeyFromEdgeId.getSize());
  }

  /**
   * Test {@link ByteEntityRangeFactory#getKeyFromEdgeId(Object, Object, boolean, boolean)}.
   *
   * <ul>
   *   <li>Then throw {@link RangeFactoryException}.
   * </ul>
   *
   * <p>Method under test: {@link ByteEntityRangeFactory#getKeyFromEdgeId(Object, Object, boolean,
   * boolean)}
   */
  @Test
  @DisplayName(
      "Test getKeyFromEdgeId(Object, Object, boolean, boolean); then throw RangeFactoryException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Key ByteEntityRangeFactory.getKeyFromEdgeId(Object, Object, boolean, boolean)"
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
            new ByteEntityRangeFactory(schema)
                .getKeyFromEdgeId("Source", "Destination", true, true));
    verify(avroSerialiser).serialise(isA(Object.class));
    verify(schema).getVertexSerialiser();
  }
}
