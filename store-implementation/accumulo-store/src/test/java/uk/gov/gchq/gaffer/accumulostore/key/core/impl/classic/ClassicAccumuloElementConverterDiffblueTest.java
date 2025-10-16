package uk.gov.gchq.gaffer.accumulostore.key.core.impl.classic;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
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
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.function.BinaryOperator;
import org.apache.accumulo.core.data.ArrayByteSequence;
import org.apache.accumulo.core.data.ByteSequence;
import org.apache.accumulo.core.data.Key;
import org.apache.accumulo.core.data.Value;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uk.gov.gchq.gaffer.accumulostore.data.element.AccumuloEntityValueLoader;
import uk.gov.gchq.gaffer.accumulostore.key.core.impl.byteEntity.ByteEntityAccumuloElementConverter;
import uk.gov.gchq.gaffer.accumulostore.key.exception.AccumuloElementConversionException;
import uk.gov.gchq.gaffer.data.element.Edge;
import uk.gov.gchq.gaffer.data.element.Entity;
import uk.gov.gchq.gaffer.data.element.LazyEntity;
import uk.gov.gchq.gaffer.data.element.id.EdgeId;
import uk.gov.gchq.gaffer.data.element.id.EdgeId.MatchedVertex;
import uk.gov.gchq.gaffer.data.element.id.EntityId;
import uk.gov.gchq.gaffer.exception.SerialisationException;
import uk.gov.gchq.gaffer.operation.data.EntitySeed;
import uk.gov.gchq.gaffer.serialisation.AvroSerialiser;
import uk.gov.gchq.gaffer.serialisation.FreqMapSerialiser;
import uk.gov.gchq.gaffer.serialisation.TypeSubTypeValueSerialiser;
import uk.gov.gchq.gaffer.store.schema.Schema;
import uk.gov.gchq.gaffer.store.schema.SchemaEdgeDefinition;
import uk.gov.gchq.gaffer.store.schema.SchemaElementDefinition;
import uk.gov.gchq.gaffer.store.schema.TypeDefinition;
import uk.gov.gchq.gaffer.store.schema.TypeDefinition.Builder;
import uk.gov.gchq.gaffer.types.TypeSubTypeValue;

class ClassicAccumuloElementConverterDiffblueTest {
  /**
   * Test {@link ClassicAccumuloElementConverter#ClassicAccumuloElementConverter(Schema)}.
   *
   * <ul>
   *   <li>Given {@code timestampProperty}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ClassicAccumuloElementConverter#ClassicAccumuloElementConverter(Schema)}
   */
  @Test
  @DisplayName("Test new ClassicAccumuloElementConverter(Schema); given 'timestampProperty'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ClassicAccumuloElementConverter.<init>(Schema)"})
  void testNewClassicAccumuloElementConverter_givenTimestampProperty()
      throws UnsupportedEncodingException {
    // Arrange
    Schema schema = new Schema();
    schema.addConfig("timestampProperty", "42");

    // Act and Assert
    assertArrayEquals(
        "Group".getBytes("UTF-8"),
        new ClassicAccumuloElementConverter(schema).buildColumnFamily("Group"));
  }

  /**
   * Test {@link ClassicAccumuloElementConverter#ClassicAccumuloElementConverter(Schema)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ClassicAccumuloElementConverter#ClassicAccumuloElementConverter(Schema)}
   */
  @Test
  @DisplayName("Test new ClassicAccumuloElementConverter(Schema); when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ClassicAccumuloElementConverter.<init>(Schema)"})
  void testNewClassicAccumuloElementConverter_whenNull() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertArrayEquals(
        "Group".getBytes("UTF-8"),
        new ClassicAccumuloElementConverter(null).buildColumnFamily("Group"));
  }

  /**
   * Test {@link ClassicAccumuloElementConverter#ClassicAccumuloElementConverter(Schema)}.
   *
   * <ul>
   *   <li>When {@link Schema#Schema()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ClassicAccumuloElementConverter#ClassicAccumuloElementConverter(Schema)}
   */
  @Test
  @DisplayName("Test new ClassicAccumuloElementConverter(Schema); when Schema()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ClassicAccumuloElementConverter.<init>(Schema)"})
  void testNewClassicAccumuloElementConverter_whenSchema() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertArrayEquals(
        "Group".getBytes("UTF-8"),
        new ClassicAccumuloElementConverter(new Schema()).buildColumnFamily("Group"));
  }

  /**
   * Test {@link ClassicAccumuloElementConverter#getEntityId(byte[])}.
   *
   * <ul>
   *   <li>Then throw {@link AccumuloElementConversionException}.
   * </ul>
   *
   * <p>Method under test: {@link ClassicAccumuloElementConverter#getEntityId(byte[])}
   */
  @Test
  @DisplayName("Test getEntityId(byte[]); then throw AccumuloElementConversionException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId ClassicAccumuloElementConverter.getEntityId(byte[])"})
  void testGetEntityId_thenThrowAccumuloElementConversionException()
      throws UnsupportedEncodingException {
    // Arrange
    Schema schema = mock(Schema.class);
    when(schema.getConfig(Mockito.<String>any())).thenReturn("Config");
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.getVertexSerialiser()).thenReturn(new AvroSerialiser());

    // Act and Assert
    assertThrows(
        AccumuloElementConversionException.class,
        () ->
            new ClassicAccumuloElementConverter(schema).getEntityId("AXAXAXAX".getBytes("UTF-8")));
    verify(schema).getAggregatedGroups();
    verify(schema).getConfig("timestampProperty");
    verify(schema).getVertexSerialiser();
  }

  /**
   * Test {@link ClassicAccumuloElementConverter#getEntityId(byte[])}.
   *
   * <ul>
   *   <li>Then Vertex return {@link Map}.
   * </ul>
   *
   * <p>Method under test: {@link ClassicAccumuloElementConverter#getEntityId(byte[])}
   */
  @Test
  @DisplayName("Test getEntityId(byte[]); then Vertex return Map")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId ClassicAccumuloElementConverter.getEntityId(byte[])"})
  void testGetEntityId_thenVertexReturnMap() throws UnsupportedEncodingException {
    // Arrange
    Schema schema = mock(Schema.class);
    when(schema.getConfig(Mockito.<String>any())).thenReturn("Config");
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.getVertexSerialiser()).thenReturn(new FreqMapSerialiser());

    // Act
    EntityId actualEntityId =
        new ClassicAccumuloElementConverter(schema).getEntityId("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    verify(schema).getAggregatedGroups();
    verify(schema).getConfig("timestampProperty");
    verify(schema).getVertexSerialiser();
    Object vertex = actualEntityId.getVertex();
    assertTrue(vertex instanceof Map);
    assertTrue(actualEntityId instanceof EntitySeed);
    assertEquals("uk.gov.gchq.gaffer.operation.data.EntitySeed", actualEntityId.getClassName());
    assertTrue(((Map<Object, Object>) vertex).isEmpty());
  }

  /**
   * Test {@link ClassicAccumuloElementConverter#getEntityId(byte[])}.
   *
   * <ul>
   *   <li>Then Vertex return {@link TypeSubTypeValue}.
   * </ul>
   *
   * <p>Method under test: {@link ClassicAccumuloElementConverter#getEntityId(byte[])}
   */
  @Test
  @DisplayName("Test getEntityId(byte[]); then Vertex return TypeSubTypeValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId ClassicAccumuloElementConverter.getEntityId(byte[])"})
  void testGetEntityId_thenVertexReturnTypeSubTypeValue() throws UnsupportedEncodingException {
    // Arrange
    Schema schema = mock(Schema.class);
    when(schema.getConfig(Mockito.<String>any())).thenReturn("Config");
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.getVertexSerialiser()).thenReturn(new TypeSubTypeValueSerialiser());

    // Act
    EntityId actualEntityId =
        new ClassicAccumuloElementConverter(schema).getEntityId("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    verify(schema).getAggregatedGroups();
    verify(schema).getConfig("timestampProperty");
    verify(schema).getVertexSerialiser();
    assertTrue(actualEntityId instanceof EntitySeed);
    Object vertex = actualEntityId.getVertex();
    assertTrue(vertex instanceof TypeSubTypeValue);
    assertEquals("AXAXAXAX", ((TypeSubTypeValue) vertex).getValue());
    assertNull(((TypeSubTypeValue) vertex).getSubType());
    assertNull(((TypeSubTypeValue) vertex).getType());
  }

  /**
   * Test {@link ClassicAccumuloElementConverter#getEntityId(byte[])}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then throw {@link AccumuloElementConversionException}.
   * </ul>
   *
   * <p>Method under test: {@link ClassicAccumuloElementConverter#getEntityId(byte[])}
   */
  @Test
  @DisplayName("Test getEntityId(byte[]); when 'A'; then throw AccumuloElementConversionException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId ClassicAccumuloElementConverter.getEntityId(byte[])"})
  void testGetEntityId_whenA_thenThrowAccumuloElementConversionException() {
    // Arrange
    Schema schema = mock(Schema.class);
    when(schema.getConfig(Mockito.<String>any())).thenReturn("Config");
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.getVertexSerialiser()).thenReturn(new AvroSerialiser());

    // Act and Assert
    assertThrows(
        AccumuloElementConversionException.class,
        () ->
            new ClassicAccumuloElementConverter(schema)
                .getEntityId(
                    new byte[] {
                      ClassicBytePositions.UNDIRECTED_EDGE, 'X', 'A', 'X', 'A', 'X', 'A', 'X'
                    }));
    verify(schema).getAggregatedGroups();
    verify(schema).getConfig("timestampProperty");
    verify(schema).getVertexSerialiser();
  }

  /**
   * Test {@link ClassicAccumuloElementConverter#getRowKeyFromEntity(Entity)}.
   *
   * <ul>
   *   <li>Given {@link FreqMapSerialiser} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link ClassicAccumuloElementConverter#getRowKeyFromEntity(Entity)}
   */
  @Test
  @DisplayName("Test getRowKeyFromEntity(Entity); given FreqMapSerialiser (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ClassicAccumuloElementConverter.getRowKeyFromEntity(Entity)"})
  void testGetRowKeyFromEntity_givenFreqMapSerialiser()
      throws UnsupportedEncodingException, SerialisationException {
    // Arrange
    AvroSerialiser avroSerialiser = mock(AvroSerialiser.class);
    when(avroSerialiser.serialise(Mockito.<Object>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    Schema schema = mock(Schema.class);
    when(schema.getConfig(Mockito.<String>any())).thenReturn("Config");
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.getVertexSerialiser()).thenReturn(avroSerialiser);
    ClassicAccumuloElementConverter classicAccumuloElementConverter =
        new ClassicAccumuloElementConverter(schema);

    Key key = mock(Key.class);
    ByteBuffer buffer =
        ByteBuffer.wrap(
            new byte[] {
              'A',
              ClassicBytePositions.UNDIRECTED_EDGE,
              'A',
              ClassicBytePositions.UNDIRECTED_EDGE,
              'A',
              ClassicBytePositions.UNDIRECTED_EDGE,
              'A',
              ClassicBytePositions.UNDIRECTED_EDGE
            });
    when(key.getRowData()).thenReturn(new ArrayByteSequence(buffer));

    Schema schema2 = mock(Schema.class);
    when(schema2.getConfig(Mockito.<String>any())).thenReturn("Config");
    when(schema2.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema2.getVertexSerialiser()).thenReturn(new FreqMapSerialiser());
    ByteEntityAccumuloElementConverter elementConverter =
        new ByteEntityAccumuloElementConverter(schema2);
    Value value = new Value();

    AccumuloEntityValueLoader valueLoader =
        new AccumuloEntityValueLoader("Group", key, value, elementConverter, new Schema());
    Entity entity = new Entity.Builder().group("Group").vertex("Vertex").build();

    LazyEntity entity2 = new LazyEntity(entity, valueLoader);

    // Act
    byte[] actualRowKeyFromEntity = classicAccumuloElementConverter.getRowKeyFromEntity(entity2);

    // Assert
    verify(key).getRowData();
    verify(avroSerialiser).serialise(isA(Object.class));
    verify(schema).getAggregatedGroups();
    verify(schema2).getAggregatedGroups();
    verify(schema).getConfig("timestampProperty");
    verify(schema2).getConfig("timestampProperty");
    verify(schema).getVertexSerialiser();
    verify(schema2).getVertexSerialiser();
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualRowKeyFromEntity);
  }

  /**
   * Test {@link ClassicAccumuloElementConverter#getRowKeyFromEntity(Entity)}.
   *
   * <ul>
   *   <li>Given {@link TypeSubTypeValueSerialiser} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link ClassicAccumuloElementConverter#getRowKeyFromEntity(Entity)}
   */
  @Test
  @DisplayName(
      "Test getRowKeyFromEntity(Entity); given TypeSubTypeValueSerialiser (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ClassicAccumuloElementConverter.getRowKeyFromEntity(Entity)"})
  void testGetRowKeyFromEntity_givenTypeSubTypeValueSerialiser()
      throws UnsupportedEncodingException, SerialisationException {
    // Arrange
    AvroSerialiser avroSerialiser = mock(AvroSerialiser.class);
    when(avroSerialiser.serialise(Mockito.<Object>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    Schema schema = mock(Schema.class);
    when(schema.getConfig(Mockito.<String>any())).thenReturn("Config");
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.getVertexSerialiser()).thenReturn(avroSerialiser);
    ClassicAccumuloElementConverter classicAccumuloElementConverter =
        new ClassicAccumuloElementConverter(schema);

    Key key = mock(Key.class);
    ByteBuffer buffer =
        ByteBuffer.wrap(
            new byte[] {
              'A',
              ClassicBytePositions.UNDIRECTED_EDGE,
              'A',
              ClassicBytePositions.UNDIRECTED_EDGE,
              'A',
              ClassicBytePositions.UNDIRECTED_EDGE,
              'A',
              ClassicBytePositions.UNDIRECTED_EDGE
            });
    when(key.getRowData()).thenReturn(new ArrayByteSequence(buffer));

    Schema schema2 = mock(Schema.class);
    when(schema2.getConfig(Mockito.<String>any())).thenReturn("Config");
    when(schema2.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema2.getVertexSerialiser()).thenReturn(new TypeSubTypeValueSerialiser());
    ByteEntityAccumuloElementConverter elementConverter =
        new ByteEntityAccumuloElementConverter(schema2);
    Value value = new Value();

    AccumuloEntityValueLoader valueLoader =
        new AccumuloEntityValueLoader("Group", key, value, elementConverter, new Schema());
    Entity entity = new Entity.Builder().group("Group").vertex("Vertex").build();

    LazyEntity entity2 = new LazyEntity(entity, valueLoader);

    // Act
    byte[] actualRowKeyFromEntity = classicAccumuloElementConverter.getRowKeyFromEntity(entity2);

    // Assert
    verify(key).getRowData();
    verify(avroSerialiser).serialise(isA(Object.class));
    verify(schema).getAggregatedGroups();
    verify(schema2).getAggregatedGroups();
    verify(schema).getConfig("timestampProperty");
    verify(schema2).getConfig("timestampProperty");
    verify(schema).getVertexSerialiser();
    verify(schema2).getVertexSerialiser();
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualRowKeyFromEntity);
  }

  /**
   * Test {@link ClassicAccumuloElementConverter#getRowKeyFromEntity(Entity)}.
   *
   * <ul>
   *   <li>Given {@code Vertex}.
   *   <li>Then return forty-seventh element is fourteen.
   * </ul>
   *
   * <p>Method under test: {@link ClassicAccumuloElementConverter#getRowKeyFromEntity(Entity)}
   */
  @Test
  @DisplayName(
      "Test getRowKeyFromEntity(Entity); given 'Vertex'; then return forty-seventh element is fourteen")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ClassicAccumuloElementConverter.getRowKeyFromEntity(Entity)"})
  void testGetRowKeyFromEntity_givenVertex_thenReturnFortySeventhElementIsFourteen() {
    // Arrange
    Schema schema = mock(Schema.class);
    when(schema.getConfig(Mockito.<String>any())).thenReturn("Config");
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.getVertexSerialiser()).thenReturn(new AvroSerialiser());
    ClassicAccumuloElementConverter classicAccumuloElementConverter =
        new ClassicAccumuloElementConverter(schema);

    Entity entity = new Entity("Group");
    entity.setVertex("Vertex");

    // Act
    byte[] actualRowKeyFromEntity = classicAccumuloElementConverter.getRowKeyFromEntity(entity);

    // Assert
    verify(schema).getAggregatedGroups();
    verify(schema).getConfig("timestampProperty");
    verify(schema).getVertexSerialiser();
    assertEquals((byte) 14, actualRowKeyFromEntity[46]);
    assertEquals((byte) 16, actualRowKeyFromEntity[18]);
    assertEquals((byte) 22, actualRowKeyFromEntity[6]);
    assertEquals(70, actualRowKeyFromEntity.length);
    assertEquals(ClassicBytePositions.CORRECT_WAY_DIRECTED_EDGE, actualRowKeyFromEntity[4]);
    assertEquals(ClassicBytePositions.CORRECT_WAY_DIRECTED_EDGE, actualRowKeyFromEntity[45]);
    assertEquals(ClassicBytePositions.CORRECT_WAY_DIRECTED_EDGE, actualRowKeyFromEntity[5]);
    assertEquals(ClassicBytePositions.UNDIRECTED_EDGE, actualRowKeyFromEntity[3]);
    assertEquals('.', actualRowKeyFromEntity[11]);
    assertEquals('O', actualRowKeyFromEntity[0]);
    assertEquals('V', actualRowKeyFromEntity[48]);
    assertEquals('"', actualRowKeyFromEntity[19]);
    assertEquals('\f', actualRowKeyFromEntity[47]);
    assertEquals('a', actualRowKeyFromEntity[17]);
    assertEquals('a', actualRowKeyFromEntity[7]);
    assertEquals('b', actualRowKeyFromEntity[1]);
    assertEquals('c', actualRowKeyFromEntity[13]);
    assertEquals('e', actualRowKeyFromEntity[15]);
    assertEquals('e', actualRowKeyFromEntity[49]);
    assertEquals('e', actualRowKeyFromEntity[52]);
    assertEquals('h', actualRowKeyFromEntity[14]);
    assertEquals('i', actualRowKeyFromEntity[23]);
    assertEquals('j', actualRowKeyFromEntity[2]);
    assertEquals('m', actualRowKeyFromEntity[Short.SIZE]);
    assertEquals('n', actualRowKeyFromEntity[24]);
    assertEquals('o', actualRowKeyFromEntity[10]);
    assertEquals('r', actualRowKeyFromEntity[22]);
    assertEquals('r', actualRowKeyFromEntity[50]);
    assertEquals('r', actualRowKeyFromEntity[9]);
    assertEquals('s', actualRowKeyFromEntity[12]);
    assertEquals('s', actualRowKeyFromEntity[20]);
    assertEquals('t', actualRowKeyFromEntity[21]);
    assertEquals('t', actualRowKeyFromEntity[51]);
    assertEquals('v', actualRowKeyFromEntity[8]);
    assertEquals('x', actualRowKeyFromEntity[53]);
  }

  /**
   * Test {@link ClassicAccumuloElementConverter#getRowKeysFromEdge(Edge)}.
   *
   * <p>Method under test: {@link ClassicAccumuloElementConverter#getRowKeysFromEdge(Edge)}
   */
  @Test
  @DisplayName("Test getRowKeysFromEdge(Edge)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "uk.gov.gchq.gaffer.commonutil.pair.Pair ClassicAccumuloElementConverter.getRowKeysFromEdge(Edge)"
  })
  void testGetRowKeysFromEdge() {
    // Arrange
    Schema schema = mock(Schema.class);
    when(schema.getConfig(Mockito.<String>any())).thenReturn("Config");
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.getVertexSerialiser()).thenReturn(new AvroSerialiser());
    ClassicAccumuloElementConverter classicAccumuloElementConverter =
        new ClassicAccumuloElementConverter(schema);

    // Act
    classicAccumuloElementConverter.getRowKeysFromEdge(
        new Edge.Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build());

    // Assert
    verify(schema).getAggregatedGroups();
    verify(schema).getConfig("timestampProperty");
    verify(schema, atLeast(1)).getVertexSerialiser();
  }

  /**
   * Test {@link ClassicAccumuloElementConverter#getRowKeysFromEdge(Edge)}.
   *
   * <p>Method under test: {@link ClassicAccumuloElementConverter#getRowKeysFromEdge(Edge)}
   */
  @Test
  @DisplayName("Test getRowKeysFromEdge(Edge)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "uk.gov.gchq.gaffer.commonutil.pair.Pair ClassicAccumuloElementConverter.getRowKeysFromEdge(Edge)"
  })
  void testGetRowKeysFromEdge2() {
    // Arrange
    Schema schema = mock(Schema.class);
    when(schema.getConfig(Mockito.<String>any())).thenReturn("Config");
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.getVertexSerialiser()).thenReturn(new AvroSerialiser());
    ClassicAccumuloElementConverter classicAccumuloElementConverter =
        new ClassicAccumuloElementConverter(schema);

    Edge edge = mock(Edge.class);
    when(edge.getDestination())
        .thenThrow(new AccumuloElementConversionException("An error occurred"));
    when(edge.isDirected()).thenReturn(false);
    when(edge.getSource()).thenReturn("Source");

    // Act and Assert
    assertThrows(
        AccumuloElementConversionException.class,
        () -> classicAccumuloElementConverter.getRowKeysFromEdge(edge));
    verify(edge).getDestination();
    verify(edge).getSource();
    verify(edge).isDirected();
    verify(schema).getAggregatedGroups();
    verify(schema).getConfig("timestampProperty");
    verify(schema, atLeast(1)).getVertexSerialiser();
  }

  /**
   * Test {@link ClassicAccumuloElementConverter#getRowKeysFromEdge(Edge)}.
   *
   * <ul>
   *   <li>Then calls {@link AvroSerialiser#serialise(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassicAccumuloElementConverter#getRowKeysFromEdge(Edge)}
   */
  @Test
  @DisplayName("Test getRowKeysFromEdge(Edge); then calls serialise(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "uk.gov.gchq.gaffer.commonutil.pair.Pair ClassicAccumuloElementConverter.getRowKeysFromEdge(Edge)"
  })
  void testGetRowKeysFromEdge_thenCallsSerialise() throws SerialisationException {
    // Arrange
    AvroSerialiser avroSerialiser = mock(AvroSerialiser.class);
    when(avroSerialiser.serialise(Mockito.<Object>any()))
        .thenThrow(new SerialisationException("An error occurred"));

    Schema schema = mock(Schema.class);
    when(schema.getConfig(Mockito.<String>any())).thenReturn("Config");
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.getVertexSerialiser()).thenReturn(avroSerialiser);
    ClassicAccumuloElementConverter classicAccumuloElementConverter =
        new ClassicAccumuloElementConverter(schema);

    Edge edge = mock(Edge.class);
    when(edge.isDirected()).thenReturn(false);
    when(edge.getSource()).thenReturn("Source");

    // Act and Assert
    assertThrows(
        AccumuloElementConversionException.class,
        () -> classicAccumuloElementConverter.getRowKeysFromEdge(edge));
    verify(edge).getSource();
    verify(edge).isDirected();
    verify(avroSerialiser).serialise(isA(Object.class));
    verify(schema).getAggregatedGroups();
    verify(schema).getConfig("timestampProperty");
    verify(schema).getVertexSerialiser();
  }

  /**
   * Test {@link ClassicAccumuloElementConverter#doesKeyRepresentEntity(byte[])}.
   *
   * <ul>
   *   <li>Then throw {@link AccumuloElementConversionException}.
   * </ul>
   *
   * <p>Method under test: {@link ClassicAccumuloElementConverter#doesKeyRepresentEntity(byte[])}
   */
  @Test
  @DisplayName("Test doesKeyRepresentEntity(byte[]); then throw AccumuloElementConversionException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ClassicAccumuloElementConverter.doesKeyRepresentEntity(byte[])"})
  void testDoesKeyRepresentEntity_thenThrowAccumuloElementConversionException() {
    // Arrange, Act and Assert
    assertThrows(
        AccumuloElementConversionException.class,
        () ->
            new ClassicAccumuloElementConverter(new Schema())
                .doesKeyRepresentEntity(
                    new byte[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}));
  }

  /**
   * Test {@link ClassicAccumuloElementConverter#doesKeyRepresentEntity(byte[])}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ClassicAccumuloElementConverter#doesKeyRepresentEntity(byte[])}
   */
  @Test
  @DisplayName(
      "Test doesKeyRepresentEntity(byte[]); when 'AXAXAXAX' Bytes is 'UTF-8'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ClassicAccumuloElementConverter.doesKeyRepresentEntity(byte[])"})
  void testDoesKeyRepresentEntity_whenAxaxaxaxBytesIsUtf8_thenReturnTrue()
      throws UnsupportedEncodingException {
    // Arrange and Act
    boolean actualDoesKeyRepresentEntityResult =
        new ClassicAccumuloElementConverter(new Schema())
            .doesKeyRepresentEntity("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertTrue(actualDoesKeyRepresentEntityResult);
  }

  /**
   * Test {@link ClassicAccumuloElementConverter#getEntityFromKey(Key, byte[])}.
   *
   * <p>Method under test: {@link ClassicAccumuloElementConverter#getEntityFromKey(Key, byte[])}
   */
  @Test
  @DisplayName("Test getEntityFromKey(Key, byte[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity ClassicAccumuloElementConverter.getEntityFromKey(Key, byte[])"})
  void testGetEntityFromKey() throws UnsupportedEncodingException {
    // Arrange
    Schema schema = mock(Schema.class);
    when(schema.getConfig(Mockito.<String>any())).thenReturn("Config");
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.getVertexSerialiser()).thenReturn(new FreqMapSerialiser());
    ClassicAccumuloElementConverter classicAccumuloElementConverter =
        new ClassicAccumuloElementConverter(schema);

    ByteSequence byteSequence = mock(ByteSequence.class);
    when(byteSequence.getBackingArray()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    Key key = mock(Key.class);
    when(key.getColumnQualifierData())
        .thenThrow(new AccumuloElementConversionException("An error occurred"));
    when(key.getColumnFamilyData()).thenReturn(byteSequence);

    // Act and Assert
    assertThrows(
        AccumuloElementConversionException.class,
        () -> classicAccumuloElementConverter.getEntityFromKey(key, "AXAXAXAX".getBytes("UTF-8")));
    verify(byteSequence).getBackingArray();
    verify(key).getColumnFamilyData();
    verify(key).getColumnQualifierData();
    verify(schema).getAggregatedGroups();
    verify(schema).getConfig("timestampProperty");
    verify(schema).getVertexSerialiser();
  }

  /**
   * Test {@link ClassicAccumuloElementConverter#getEntityFromKey(Key, byte[])}.
   *
   * <p>Method under test: {@link ClassicAccumuloElementConverter#getEntityFromKey(Key, byte[])}
   */
  @Test
  @DisplayName("Test getEntityFromKey(Key, byte[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity ClassicAccumuloElementConverter.getEntityFromKey(Key, byte[])"})
  void testGetEntityFromKey2() throws UnsupportedEncodingException {
    // Arrange
    Schema schema = mock(Schema.class);
    when(schema.getElement(Mockito.<String>any()))
        .thenThrow(new AccumuloElementConversionException("An error occurred"));
    when(schema.getConfig(Mockito.<String>any())).thenReturn("Config");
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.getVertexSerialiser()).thenReturn(new FreqMapSerialiser());
    ClassicAccumuloElementConverter classicAccumuloElementConverter =
        new ClassicAccumuloElementConverter(schema);

    ByteSequence byteSequence = mock(ByteSequence.class);
    when(byteSequence.getBackingArray()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    Key key = mock(Key.class);
    when(key.getColumnQualifierData()).thenReturn(new ArrayByteSequence("foo"));
    when(key.getColumnFamilyData()).thenReturn(byteSequence);

    // Act and Assert
    assertThrows(
        AccumuloElementConversionException.class,
        () -> classicAccumuloElementConverter.getEntityFromKey(key, "AXAXAXAX".getBytes("UTF-8")));
    verify(byteSequence).getBackingArray();
    verify(key).getColumnFamilyData();
    verify(key).getColumnQualifierData();
    verify(schema).getAggregatedGroups();
    verify(schema).getConfig("timestampProperty");
    verify(schema).getElement("AXAXAXAX");
    verify(schema).getVertexSerialiser();
  }

  /**
   * Test {@link ClassicAccumuloElementConverter#getEntityFromKey(Key, byte[])}.
   *
   * <p>Method under test: {@link ClassicAccumuloElementConverter#getEntityFromKey(Key, byte[])}
   */
  @Test
  @DisplayName("Test getEntityFromKey(Key, byte[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity ClassicAccumuloElementConverter.getEntityFromKey(Key, byte[])"})
  void testGetEntityFromKey3() throws UnsupportedEncodingException {
    // Arrange
    Schema schema = mock(Schema.class);
    when(schema.getElement(Mockito.<String>any())).thenReturn(new SchemaEdgeDefinition());
    when(schema.getConfig(Mockito.<String>any())).thenReturn("Config");
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.getVertexSerialiser()).thenReturn(new FreqMapSerialiser());
    ClassicAccumuloElementConverter classicAccumuloElementConverter =
        new ClassicAccumuloElementConverter(schema);

    ByteSequence byteSequence = mock(ByteSequence.class);
    when(byteSequence.getBackingArray()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    Key key = mock(Key.class);
    when(key.getColumnVisibilityData())
        .thenThrow(new AccumuloElementConversionException("An error occurred"));
    when(key.getColumnQualifierData()).thenReturn(new ArrayByteSequence("foo"));
    when(key.getColumnFamilyData()).thenReturn(byteSequence);

    // Act and Assert
    assertThrows(
        AccumuloElementConversionException.class,
        () -> classicAccumuloElementConverter.getEntityFromKey(key, "AXAXAXAX".getBytes("UTF-8")));
    verify(byteSequence).getBackingArray();
    verify(key).getColumnFamilyData();
    verify(key).getColumnQualifierData();
    verify(key).getColumnVisibilityData();
    verify(schema).getAggregatedGroups();
    verify(schema).getConfig("timestampProperty");
    verify(schema).getElement("AXAXAXAX");
    verify(schema).getVertexSerialiser();
  }

  /**
   * Test {@link ClassicAccumuloElementConverter#getEntityFromKey(Key, byte[])}.
   *
   * <p>Method under test: {@link ClassicAccumuloElementConverter#getEntityFromKey(Key, byte[])}
   */
  @Test
  @DisplayName("Test getEntityFromKey(Key, byte[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity ClassicAccumuloElementConverter.getEntityFromKey(Key, byte[])"})
  void testGetEntityFromKey4() throws UnsupportedEncodingException {
    // Arrange
    Schema schema = mock(Schema.class);
    when(schema.getVisibilityProperty())
        .thenThrow(new AccumuloElementConversionException("An error occurred"));
    when(schema.getElement(Mockito.<String>any())).thenReturn(new SchemaEdgeDefinition());
    when(schema.getConfig(Mockito.<String>any())).thenReturn("Config");
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.getVertexSerialiser()).thenReturn(new FreqMapSerialiser());
    ClassicAccumuloElementConverter classicAccumuloElementConverter =
        new ClassicAccumuloElementConverter(schema);

    ByteSequence byteSequence = mock(ByteSequence.class);
    when(byteSequence.getBackingArray()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    Key key = mock(Key.class);
    when(key.getColumnVisibilityData()).thenReturn(new ArrayByteSequence("foo"));
    when(key.getColumnQualifierData()).thenReturn(new ArrayByteSequence("foo"));
    when(key.getColumnFamilyData()).thenReturn(byteSequence);

    // Act and Assert
    assertThrows(
        AccumuloElementConversionException.class,
        () -> classicAccumuloElementConverter.getEntityFromKey(key, "AXAXAXAX".getBytes("UTF-8")));
    verify(byteSequence).getBackingArray();
    verify(key).getColumnFamilyData();
    verify(key).getColumnQualifierData();
    verify(key).getColumnVisibilityData();
    verify(schema).getAggregatedGroups();
    verify(schema).getConfig("timestampProperty");
    verify(schema, atLeast(1)).getElement("AXAXAXAX");
    verify(schema).getVertexSerialiser();
    verify(schema).getVisibilityProperty();
  }

  /**
   * Test {@link ClassicAccumuloElementConverter#getEntityFromKey(Key, byte[])}.
   *
   * <p>Method under test: {@link ClassicAccumuloElementConverter#getEntityFromKey(Key, byte[])}
   */
  @Test
  @DisplayName("Test getEntityFromKey(Key, byte[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity ClassicAccumuloElementConverter.getEntityFromKey(Key, byte[])"})
  void testGetEntityFromKey5() throws UnsupportedEncodingException {
    // Arrange
    Schema schema = mock(Schema.class);
    when(schema.getVisibilityProperty()).thenReturn("Visibility Property");
    when(schema.getElement(Mockito.<String>any())).thenReturn(new SchemaEdgeDefinition());
    when(schema.getConfig(Mockito.<String>any())).thenReturn("Config");
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.getVertexSerialiser()).thenReturn(new FreqMapSerialiser());
    ClassicAccumuloElementConverter classicAccumuloElementConverter =
        new ClassicAccumuloElementConverter(schema);

    ByteSequence byteSequence = mock(ByteSequence.class);
    when(byteSequence.getBackingArray()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    Key key = mock(Key.class);
    when(key.getTimestamp()).thenThrow(new AccumuloElementConversionException("An error occurred"));
    when(key.getColumnVisibilityData()).thenReturn(new ArrayByteSequence("foo"));
    when(key.getColumnQualifierData()).thenReturn(new ArrayByteSequence("foo"));
    when(key.getColumnFamilyData()).thenReturn(byteSequence);

    // Act and Assert
    assertThrows(
        AccumuloElementConversionException.class,
        () -> classicAccumuloElementConverter.getEntityFromKey(key, "AXAXAXAX".getBytes("UTF-8")));
    verify(byteSequence).getBackingArray();
    verify(key).getColumnFamilyData();
    verify(key).getColumnQualifierData();
    verify(key).getColumnVisibilityData();
    verify(key).getTimestamp();
    verify(schema).getAggregatedGroups();
    verify(schema).getConfig("timestampProperty");
    verify(schema, atLeast(1)).getElement("AXAXAXAX");
    verify(schema).getVertexSerialiser();
    verify(schema, atLeast(1)).getVisibilityProperty();
  }

  /**
   * Test {@link ClassicAccumuloElementConverter#getEntityFromKey(Key, byte[])}.
   *
   * <p>Method under test: {@link ClassicAccumuloElementConverter#getEntityFromKey(Key, byte[])}
   */
  @Test
  @DisplayName("Test getEntityFromKey(Key, byte[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity ClassicAccumuloElementConverter.getEntityFromKey(Key, byte[])"})
  void testGetEntityFromKey6() throws UnsupportedEncodingException {
    // Arrange
    SchemaElementDefinition schemaElementDefinition = mock(SchemaElementDefinition.class);
    when(schemaElementDefinition.getGroupBy())
        .thenThrow(new AccumuloElementConversionException("An error occurred"));

    Schema schema = mock(Schema.class);
    when(schema.getElement(Mockito.<String>any())).thenReturn(schemaElementDefinition);
    when(schema.getConfig(Mockito.<String>any())).thenReturn("Config");
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.getVertexSerialiser()).thenReturn(new FreqMapSerialiser());
    ClassicAccumuloElementConverter classicAccumuloElementConverter =
        new ClassicAccumuloElementConverter(schema);

    ByteSequence byteSequence = mock(ByteSequence.class);
    when(byteSequence.getBackingArray()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    Key key = mock(Key.class);
    when(key.getColumnQualifierData()).thenReturn(new ArrayByteSequence("foo"));
    when(key.getColumnFamilyData()).thenReturn(byteSequence);

    // Act and Assert
    assertThrows(
        AccumuloElementConversionException.class,
        () -> classicAccumuloElementConverter.getEntityFromKey(key, "AXAXAXAX".getBytes("UTF-8")));
    verify(byteSequence).getBackingArray();
    verify(key).getColumnFamilyData();
    verify(key).getColumnQualifierData();
    verify(schema).getAggregatedGroups();
    verify(schema).getConfig("timestampProperty");
    verify(schema).getElement("AXAXAXAX");
    verify(schema).getVertexSerialiser();
    verify(schemaElementDefinition).getGroupBy();
  }

  /**
   * Test {@link ClassicAccumuloElementConverter#getEntityFromKey(Key, byte[])}.
   *
   * <ul>
   *   <li>Given {@link Schema} {@link Schema#getElement(String)} return {@code null}.
   *   <li>Then calls {@link Schema#getElement(String)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassicAccumuloElementConverter#getEntityFromKey(Key, byte[])}
   */
  @Test
  @DisplayName(
      "Test getEntityFromKey(Key, byte[]); given Schema getElement(String) return 'null'; then calls getElement(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity ClassicAccumuloElementConverter.getEntityFromKey(Key, byte[])"})
  void testGetEntityFromKey_givenSchemaGetElementReturnNull_thenCallsGetElement()
      throws UnsupportedEncodingException {
    // Arrange
    Schema schema = mock(Schema.class);
    when(schema.getElement(Mockito.<String>any())).thenReturn(null);
    when(schema.getConfig(Mockito.<String>any())).thenReturn("Config");
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.getVertexSerialiser()).thenReturn(new FreqMapSerialiser());
    ClassicAccumuloElementConverter classicAccumuloElementConverter =
        new ClassicAccumuloElementConverter(schema);

    ByteSequence byteSequence = mock(ByteSequence.class);
    when(byteSequence.getBackingArray()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    Key key = mock(Key.class);
    when(key.getColumnQualifierData()).thenReturn(new ArrayByteSequence("foo"));
    when(key.getColumnFamilyData()).thenReturn(byteSequence);

    // Act and Assert
    assertThrows(
        AccumuloElementConversionException.class,
        () -> classicAccumuloElementConverter.getEntityFromKey(key, "AXAXAXAX".getBytes("UTF-8")));
    verify(byteSequence).getBackingArray();
    verify(key).getColumnFamilyData();
    verify(key).getColumnQualifierData();
    verify(schema).getAggregatedGroups();
    verify(schema).getConfig("timestampProperty");
    verify(schema).getElement("AXAXAXAX");
    verify(schema).getVertexSerialiser();
  }

  /**
   * Test {@link ClassicAccumuloElementConverter#getEntityFromKey(Key, byte[])}.
   *
   * <ul>
   *   <li>Given {@link Schema} {@link Schema#getVertexSerialiser()} return {@link AvroSerialiser}
   *       (default constructor).
   *   <li>When {@link Key#Key()}.
   * </ul>
   *
   * <p>Method under test: {@link ClassicAccumuloElementConverter#getEntityFromKey(Key, byte[])}
   */
  @Test
  @DisplayName(
      "Test getEntityFromKey(Key, byte[]); given Schema getVertexSerialiser() return AvroSerialiser (default constructor); when Key()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity ClassicAccumuloElementConverter.getEntityFromKey(Key, byte[])"})
  void testGetEntityFromKey_givenSchemaGetVertexSerialiserReturnAvroSerialiser_whenKey()
      throws UnsupportedEncodingException {
    // Arrange
    Schema schema = mock(Schema.class);
    when(schema.getConfig(Mockito.<String>any())).thenReturn("Config");
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.getVertexSerialiser()).thenReturn(new AvroSerialiser());
    ClassicAccumuloElementConverter classicAccumuloElementConverter =
        new ClassicAccumuloElementConverter(schema);

    // Act and Assert
    assertThrows(
        AccumuloElementConversionException.class,
        () ->
            classicAccumuloElementConverter.getEntityFromKey(
                new Key(), "AXAXAXAX".getBytes("UTF-8")));
    verify(schema).getAggregatedGroups();
    verify(schema).getConfig("timestampProperty");
    verify(schema).getVertexSerialiser();
  }

  /**
   * Test {@link ClassicAccumuloElementConverter#getEntityFromKey(Key, byte[])}.
   *
   * <ul>
   *   <li>Then calls {@link SchemaElementDefinition#getPropertyTypeDef(String)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassicAccumuloElementConverter#getEntityFromKey(Key, byte[])}
   */
  @Test
  @DisplayName("Test getEntityFromKey(Key, byte[]); then calls getPropertyTypeDef(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity ClassicAccumuloElementConverter.getEntityFromKey(Key, byte[])"})
  void testGetEntityFromKey_thenCallsGetPropertyTypeDef() throws UnsupportedEncodingException {
    // Arrange
    Builder builder = new Builder();
    builder.serialiser(new AvroSerialiser());
    TypeDefinition typeDefinition = builder.aggregateFunction(mock(BinaryOperator.class)).build();

    SchemaElementDefinition schemaElementDefinition = mock(SchemaElementDefinition.class);
    when(schemaElementDefinition.getGroupBy()).thenReturn(new HashSet<>());
    when(schemaElementDefinition.getPropertyTypeDef(Mockito.<String>any()))
        .thenReturn(typeDefinition);

    Schema schema = mock(Schema.class);
    when(schema.getVisibilityProperty()).thenReturn("Visibility Property");
    when(schema.getElement(Mockito.<String>any())).thenReturn(schemaElementDefinition);
    when(schema.getConfig(Mockito.<String>any())).thenReturn("Config");
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.getVertexSerialiser()).thenReturn(new FreqMapSerialiser());
    ClassicAccumuloElementConverter classicAccumuloElementConverter =
        new ClassicAccumuloElementConverter(schema);

    ByteSequence byteSequence = mock(ByteSequence.class);
    when(byteSequence.getBackingArray()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    ArrayByteSequence arrayByteSequence = mock(ArrayByteSequence.class);
    when(arrayByteSequence.getBackingArray()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    ByteSequence byteSequence2 = mock(ByteSequence.class);
    when(byteSequence2.getBackingArray()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    Key key = mock(Key.class);
    when(key.getColumnVisibilityData()).thenReturn(byteSequence2);
    when(key.getColumnQualifierData()).thenReturn(arrayByteSequence);
    when(key.getColumnFamilyData()).thenReturn(byteSequence);

    // Act and Assert
    assertThrows(
        AccumuloElementConversionException.class,
        () -> classicAccumuloElementConverter.getEntityFromKey(key, "AXAXAXAX".getBytes("UTF-8")));
    verify(arrayByteSequence).getBackingArray();
    verify(byteSequence2).getBackingArray();
    verify(byteSequence).getBackingArray();
    verify(key).getColumnFamilyData();
    verify(key).getColumnQualifierData();
    verify(key).getColumnVisibilityData();
    verify(schema).getAggregatedGroups();
    verify(schema).getConfig("timestampProperty");
    verify(schema, atLeast(1)).getElement("AXAXAXAX");
    verify(schema).getVertexSerialiser();
    verify(schema, atLeast(1)).getVisibilityProperty();
    verify(schemaElementDefinition).getGroupBy();
    verify(schemaElementDefinition).getPropertyTypeDef("Visibility Property");
  }

  /**
   * Test {@link ClassicAccumuloElementConverter#getEntityFromKey(Key, byte[])}.
   *
   * <ul>
   *   <li>Then Vertex return {@link Map}.
   * </ul>
   *
   * <p>Method under test: {@link ClassicAccumuloElementConverter#getEntityFromKey(Key, byte[])}
   */
  @Test
  @DisplayName("Test getEntityFromKey(Key, byte[]); then Vertex return Map")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity ClassicAccumuloElementConverter.getEntityFromKey(Key, byte[])"})
  void testGetEntityFromKey_thenVertexReturnMap() throws UnsupportedEncodingException {
    // Arrange
    Schema schema = mock(Schema.class);
    when(schema.getVisibilityProperty()).thenReturn("Visibility Property");
    when(schema.getElement(Mockito.<String>any())).thenReturn(new SchemaEdgeDefinition());
    when(schema.getConfig(Mockito.<String>any())).thenReturn("Config");
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.getVertexSerialiser()).thenReturn(new FreqMapSerialiser());
    ClassicAccumuloElementConverter classicAccumuloElementConverter =
        new ClassicAccumuloElementConverter(schema);

    ByteSequence byteSequence = mock(ByteSequence.class);
    when(byteSequence.getBackingArray()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    Key key = mock(Key.class);
    when(key.getTimestamp()).thenReturn(10L);
    when(key.getColumnVisibilityData()).thenReturn(new ArrayByteSequence("foo"));
    when(key.getColumnQualifierData()).thenReturn(new ArrayByteSequence("foo"));
    when(key.getColumnFamilyData()).thenReturn(byteSequence);

    // Act
    Entity actualEntityFromKey =
        classicAccumuloElementConverter.getEntityFromKey(key, "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    verify(byteSequence).getBackingArray();
    verify(key).getColumnFamilyData();
    verify(key).getColumnQualifierData();
    verify(key).getColumnVisibilityData();
    verify(key).getTimestamp();
    verify(schema).getAggregatedGroups();
    verify(schema).getConfig("timestampProperty");
    verify(schema, atLeast(1)).getElement("AXAXAXAX");
    verify(schema).getVertexSerialiser();
    verify(schema, atLeast(1)).getVisibilityProperty();
    Object vertex = actualEntityFromKey.getVertex();
    assertTrue(vertex instanceof Map);
    assertEquals("AXAXAXAX", actualEntityFromKey.getGroup());
    assertEquals("uk.gov.gchq.gaffer.data.element.Entity", actualEntityFromKey.getClassName());
    assertTrue(actualEntityFromKey.getProperties().isEmpty());
    assertTrue(((Map<Object, Object>) vertex).isEmpty());
  }

  /**
   * Test {@link ClassicAccumuloElementConverter#getEntityFromKey(Key, byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with {@code A} and zero.
   * </ul>
   *
   * <p>Method under test: {@link ClassicAccumuloElementConverter#getEntityFromKey(Key, byte[])}
   */
  @Test
  @DisplayName("Test getEntityFromKey(Key, byte[]); when array of byte with 'A' and zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity ClassicAccumuloElementConverter.getEntityFromKey(Key, byte[])"})
  void testGetEntityFromKey_whenArrayOfByteWithAAndZero() throws UnsupportedEncodingException {
    // Arrange
    Schema schema = mock(Schema.class);
    when(schema.getConfig(Mockito.<String>any())).thenReturn("Config");
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.getVertexSerialiser()).thenReturn(new FreqMapSerialiser());
    ClassicAccumuloElementConverter classicAccumuloElementConverter =
        new ClassicAccumuloElementConverter(schema);

    ByteSequence byteSequence = mock(ByteSequence.class);
    when(byteSequence.getBackingArray()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    ArrayByteSequence arrayByteSequence = mock(ArrayByteSequence.class);
    when(arrayByteSequence.getBackingArray())
        .thenThrow(new AccumuloElementConversionException("An error occurred"));

    Key key = mock(Key.class);
    when(key.getColumnQualifierData()).thenReturn(arrayByteSequence);
    when(key.getColumnFamilyData()).thenReturn(byteSequence);

    // Act and Assert
    assertThrows(
        AccumuloElementConversionException.class,
        () ->
            classicAccumuloElementConverter.getEntityFromKey(
                key, new byte[] {'A', 0, 'A', 'X', 'A', 'X', 'A', 'X'}));
    verify(arrayByteSequence).getBackingArray();
    verify(byteSequence).getBackingArray();
    verify(key).getColumnFamilyData();
    verify(key).getColumnQualifierData();
    verify(schema).getAggregatedGroups();
    verify(schema).getConfig("timestampProperty");
    verify(schema).getVertexSerialiser();
  }

  /**
   * Test {@link ClassicAccumuloElementConverter#getEntityFromKey(Key, byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with zero and {@code X}.
   * </ul>
   *
   * <p>Method under test: {@link ClassicAccumuloElementConverter#getEntityFromKey(Key, byte[])}
   */
  @Test
  @DisplayName("Test getEntityFromKey(Key, byte[]); when array of byte with zero and 'X'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity ClassicAccumuloElementConverter.getEntityFromKey(Key, byte[])"})
  void testGetEntityFromKey_whenArrayOfByteWithZeroAndX() throws UnsupportedEncodingException {
    // Arrange
    Schema schema = mock(Schema.class);
    when(schema.getConfig(Mockito.<String>any())).thenReturn("Config");
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.getVertexSerialiser()).thenReturn(new FreqMapSerialiser());
    ClassicAccumuloElementConverter classicAccumuloElementConverter =
        new ClassicAccumuloElementConverter(schema);

    ByteSequence byteSequence = mock(ByteSequence.class);
    when(byteSequence.getBackingArray()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    ArrayByteSequence arrayByteSequence = mock(ArrayByteSequence.class);
    when(arrayByteSequence.getBackingArray())
        .thenThrow(new AccumuloElementConversionException("An error occurred"));

    Key key = mock(Key.class);
    when(key.getColumnQualifierData()).thenReturn(arrayByteSequence);
    when(key.getColumnFamilyData()).thenReturn(byteSequence);

    // Act and Assert
    assertThrows(
        AccumuloElementConversionException.class,
        () ->
            classicAccumuloElementConverter.getEntityFromKey(
                key, new byte[] {0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
    verify(arrayByteSequence).getBackingArray();
    verify(byteSequence).getBackingArray();
    verify(key).getColumnFamilyData();
    verify(key).getColumnQualifierData();
    verify(schema).getAggregatedGroups();
    verify(schema).getConfig("timestampProperty");
    verify(schema).getVertexSerialiser();
  }

  /**
   * Test {@link ClassicAccumuloElementConverter#getEntityFromKey(Key, byte[])}.
   *
   * <ul>
   *   <li>When {@link Key} {@link Key#getColumnFamilyData()} return {@link
   *       ArrayByteSequence#ArrayByteSequence(String)} with s is {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link ClassicAccumuloElementConverter#getEntityFromKey(Key, byte[])}
   */
  @Test
  @DisplayName(
      "Test getEntityFromKey(Key, byte[]); when Key getColumnFamilyData() return ArrayByteSequence(String) with s is 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity ClassicAccumuloElementConverter.getEntityFromKey(Key, byte[])"})
  void testGetEntityFromKey_whenKeyGetColumnFamilyDataReturnArrayByteSequenceWithSIsFoo()
      throws UnsupportedEncodingException {
    // Arrange
    Schema schema = mock(Schema.class);
    when(schema.getConfig(Mockito.<String>any())).thenReturn("Config");
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.getVertexSerialiser()).thenReturn(new AvroSerialiser());
    ClassicAccumuloElementConverter classicAccumuloElementConverter =
        new ClassicAccumuloElementConverter(schema);

    Key key = mock(Key.class);
    when(key.getColumnFamilyData()).thenReturn(new ArrayByteSequence("foo"));

    // Act and Assert
    assertThrows(
        AccumuloElementConversionException.class,
        () -> classicAccumuloElementConverter.getEntityFromKey(key, "AXAXAXAX".getBytes("UTF-8")));
    verify(key).getColumnFamilyData();
    verify(schema).getAggregatedGroups();
    verify(schema).getConfig("timestampProperty");
    verify(schema).getVertexSerialiser();
  }

  /**
   * Test {@link ClassicAccumuloElementConverter#getSourceAndDestinationFromRowKey(byte[],
   * byte[][])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with zero and zero.
   * </ul>
   *
   * <p>Method under test: {@link
   * ClassicAccumuloElementConverter#getSourceAndDestinationFromRowKey(byte[], byte[][])}
   */
  @Test
  @DisplayName(
      "Test getSourceAndDestinationFromRowKey(byte[], byte[][]); when array of byte with zero and zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EdgeDirection ClassicAccumuloElementConverter.getSourceAndDestinationFromRowKey(byte[], byte[][])"
  })
  void testGetSourceAndDestinationFromRowKey_whenArrayOfByteWithZeroAndZero()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertThrows(
        AccumuloElementConversionException.class,
        () ->
            new ClassicAccumuloElementConverter(new Schema())
                .getSourceAndDestinationFromRowKey(
                    new byte[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    new byte[][] {"AXAXAXAX".getBytes("UTF-8")}));
  }

  /**
   * Test {@link ClassicAccumuloElementConverter#getSourceAndDestinationFromRowKey(byte[],
   * byte[][])}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ClassicAccumuloElementConverter#getSourceAndDestinationFromRowKey(byte[], byte[][])}
   */
  @Test
  @DisplayName(
      "Test getSourceAndDestinationFromRowKey(byte[], byte[][]); when 'AXAXAXAX' Bytes is 'UTF-8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EdgeDirection ClassicAccumuloElementConverter.getSourceAndDestinationFromRowKey(byte[], byte[][])"
  })
  void testGetSourceAndDestinationFromRowKey_whenAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertThrows(
        AccumuloElementConversionException.class,
        () ->
            new ClassicAccumuloElementConverter(new Schema())
                .getSourceAndDestinationFromRowKey(
                    "AXAXAXAX".getBytes("UTF-8"), new byte[][] {"AXAXAXAX".getBytes("UTF-8")}));
  }
}
