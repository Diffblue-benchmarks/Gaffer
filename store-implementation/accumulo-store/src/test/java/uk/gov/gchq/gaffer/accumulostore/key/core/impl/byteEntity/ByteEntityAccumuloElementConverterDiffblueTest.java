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

package uk.gov.gchq.gaffer.accumulostore.key.core.impl.byteEntity;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import org.apache.accumulo.core.data.ArrayByteSequence;
import org.apache.accumulo.core.data.Key;
import org.apache.accumulo.core.data.Value;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uk.gov.gchq.gaffer.accumulostore.AccumuloProperties;
import uk.gov.gchq.gaffer.accumulostore.data.element.AccumuloEntityValueLoader;
import uk.gov.gchq.gaffer.accumulostore.key.exception.AccumuloElementConversionException;
import uk.gov.gchq.gaffer.commonutil.pair.Pair;
import uk.gov.gchq.gaffer.data.element.Edge;
import uk.gov.gchq.gaffer.data.element.Edge.Builder;
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
import uk.gov.gchq.gaffer.types.TypeSubTypeValue;

class ByteEntityAccumuloElementConverterDiffblueTest {
  /**
   * Test {@link ByteEntityAccumuloElementConverter#ByteEntityAccumuloElementConverter(Schema)}.
   * <ul>
   *   <li>Given {@code timestampProperty}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ByteEntityAccumuloElementConverter#ByteEntityAccumuloElementConverter(Schema)}
   */
  @Test
  @DisplayName("Test new ByteEntityAccumuloElementConverter(Schema); given 'timestampProperty'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ByteEntityAccumuloElementConverter.<init>(Schema)"})
  void testNewByteEntityAccumuloElementConverter_givenTimestampProperty() throws UnsupportedEncodingException {
    // Arrange
    Schema schema = new Schema();
    schema.addConfig("timestampProperty", "42");

    // Act
    ByteEntityAccumuloElementConverter actualByteEntityAccumuloElementConverter = new ByteEntityAccumuloElementConverter(
        schema);

    // Assert
    byte[] expectedBuildColumnFamilyResult = "Group".getBytes("UTF-8");
    assertArrayEquals(expectedBuildColumnFamilyResult,
        actualByteEntityAccumuloElementConverter.buildColumnFamily("Group"));
  }

  /**
   * Test {@link ByteEntityAccumuloElementConverter#ByteEntityAccumuloElementConverter(Schema)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ByteEntityAccumuloElementConverter#ByteEntityAccumuloElementConverter(Schema)}
   */
  @Test
  @DisplayName("Test new ByteEntityAccumuloElementConverter(Schema); when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ByteEntityAccumuloElementConverter.<init>(Schema)"})
  void testNewByteEntityAccumuloElementConverter_whenNull() throws UnsupportedEncodingException {
    // Arrange and Act
    ByteEntityAccumuloElementConverter actualByteEntityAccumuloElementConverter = new ByteEntityAccumuloElementConverter(
        null);

    // Assert
    byte[] expectedBuildColumnFamilyResult = "Group".getBytes("UTF-8");
    assertArrayEquals(expectedBuildColumnFamilyResult,
        actualByteEntityAccumuloElementConverter.buildColumnFamily("Group"));
  }

  /**
   * Test {@link ByteEntityAccumuloElementConverter#ByteEntityAccumuloElementConverter(Schema)}.
   * <ul>
   *   <li>When {@link Schema#Schema()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ByteEntityAccumuloElementConverter#ByteEntityAccumuloElementConverter(Schema)}
   */
  @Test
  @DisplayName("Test new ByteEntityAccumuloElementConverter(Schema); when Schema()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ByteEntityAccumuloElementConverter.<init>(Schema)"})
  void testNewByteEntityAccumuloElementConverter_whenSchema() throws UnsupportedEncodingException {
    // Arrange and Act
    ByteEntityAccumuloElementConverter actualByteEntityAccumuloElementConverter = new ByteEntityAccumuloElementConverter(
        new Schema());

    // Assert
    byte[] expectedBuildColumnFamilyResult = "Group".getBytes("UTF-8");
    assertArrayEquals(expectedBuildColumnFamilyResult,
        actualByteEntityAccumuloElementConverter.buildColumnFamily("Group"));
  }

  /**
   * Test {@link ByteEntityAccumuloElementConverter#getEntityId(byte[])}.
   * <ul>
   *   <li>Then throw {@link AccumuloElementConversionException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ByteEntityAccumuloElementConverter#getEntityId(byte[])}
   */
  @Test
  @DisplayName("Test getEntityId(byte[]); then throw AccumuloElementConversionException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityId ByteEntityAccumuloElementConverter.getEntityId(byte[])"})
  void testGetEntityId_thenThrowAccumuloElementConversionException() throws UnsupportedEncodingException {
    // Arrange
    Schema schema = mock(Schema.class);
    when(schema.getConfig(Mockito.<String>any())).thenReturn("Config");
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.getVertexSerialiser()).thenReturn(new AvroSerialiser());
    ByteEntityAccumuloElementConverter byteEntityAccumuloElementConverter = new ByteEntityAccumuloElementConverter(
        schema);

    // Act and Assert
    assertThrows(AccumuloElementConversionException.class,
        () -> byteEntityAccumuloElementConverter.getEntityId("AXAXAXAX".getBytes("UTF-8")));
    verify(schema).getAggregatedGroups();
    verify(schema).getConfig(eq("timestampProperty"));
    verify(schema).getVertexSerialiser();
  }

  /**
   * Test {@link ByteEntityAccumuloElementConverter#getEntityId(byte[])}.
   * <ul>
   *   <li>Then Vertex return {@link Map}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ByteEntityAccumuloElementConverter#getEntityId(byte[])}
   */
  @Test
  @DisplayName("Test getEntityId(byte[]); then Vertex return Map")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityId ByteEntityAccumuloElementConverter.getEntityId(byte[])"})
  void testGetEntityId_thenVertexReturnMap() throws UnsupportedEncodingException {
    // Arrange
    Schema schema = mock(Schema.class);
    when(schema.getConfig(Mockito.<String>any())).thenReturn("Config");
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.getVertexSerialiser()).thenReturn(new FreqMapSerialiser());
    ByteEntityAccumuloElementConverter byteEntityAccumuloElementConverter = new ByteEntityAccumuloElementConverter(
        schema);

    // Act
    EntityId actualEntityId = byteEntityAccumuloElementConverter.getEntityId("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    verify(schema).getAggregatedGroups();
    verify(schema).getConfig(eq("timestampProperty"));
    verify(schema).getVertexSerialiser();
    Object vertex = actualEntityId.getVertex();
    assertTrue(vertex instanceof Map);
    assertTrue(actualEntityId instanceof EntitySeed);
    assertEquals("uk.gov.gchq.gaffer.operation.data.EntitySeed", actualEntityId.getClassName());
    assertTrue(((Map<Object, Object>) vertex).isEmpty());
  }

  /**
   * Test {@link ByteEntityAccumuloElementConverter#getEntityId(byte[])}.
   * <ul>
   *   <li>Then Vertex return {@link TypeSubTypeValue}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ByteEntityAccumuloElementConverter#getEntityId(byte[])}
   */
  @Test
  @DisplayName("Test getEntityId(byte[]); then Vertex return TypeSubTypeValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityId ByteEntityAccumuloElementConverter.getEntityId(byte[])"})
  void testGetEntityId_thenVertexReturnTypeSubTypeValue() throws UnsupportedEncodingException {
    // Arrange
    Schema schema = mock(Schema.class);
    when(schema.getConfig(Mockito.<String>any())).thenReturn("Config");
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.getVertexSerialiser()).thenReturn(new TypeSubTypeValueSerialiser());
    ByteEntityAccumuloElementConverter byteEntityAccumuloElementConverter = new ByteEntityAccumuloElementConverter(
        schema);

    // Act
    EntityId actualEntityId = byteEntityAccumuloElementConverter.getEntityId("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    verify(schema).getAggregatedGroups();
    verify(schema).getConfig(eq("timestampProperty"));
    verify(schema).getVertexSerialiser();
    assertTrue(actualEntityId instanceof EntitySeed);
    Object vertex = actualEntityId.getVertex();
    assertTrue(vertex instanceof TypeSubTypeValue);
    assertEquals("AXAXAX", ((TypeSubTypeValue) vertex).getValue());
    assertNull(((TypeSubTypeValue) vertex).getSubType());
    assertNull(((TypeSubTypeValue) vertex).getType());
  }

  /**
   * Test {@link ByteEntityAccumuloElementConverter#getEntityId(byte[])}.
   * <ul>
   *   <li>When {@code A}.</li>
   *   <li>Then throw {@link AccumuloElementConversionException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ByteEntityAccumuloElementConverter#getEntityId(byte[])}
   */
  @Test
  @DisplayName("Test getEntityId(byte[]); when 'A'; then throw AccumuloElementConversionException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityId ByteEntityAccumuloElementConverter.getEntityId(byte[])"})
  void testGetEntityId_whenA_thenThrowAccumuloElementConversionException() {
    // Arrange
    Schema schema = mock(Schema.class);
    when(schema.getConfig(Mockito.<String>any())).thenReturn("Config");
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.getVertexSerialiser()).thenReturn(new AvroSerialiser());

    // Act and Assert
    assertThrows(AccumuloElementConversionException.class, () -> (new ByteEntityAccumuloElementConverter(schema))
        .getEntityId(new byte[]{ByteEntityPositions.ENTITY, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
    verify(schema).getAggregatedGroups();
    verify(schema).getConfig(eq("timestampProperty"));
    verify(schema).getVertexSerialiser();
  }

  /**
   * Test {@link ByteEntityAccumuloElementConverter#getRowKeyFromEntity(Entity)}.
   * <ul>
   *   <li>Then throw {@link AccumuloElementConversionException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ByteEntityAccumuloElementConverter#getRowKeyFromEntity(Entity)}
   */
  @Test
  @DisplayName("Test getRowKeyFromEntity(Entity); then throw AccumuloElementConversionException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] ByteEntityAccumuloElementConverter.getRowKeyFromEntity(Entity)"})
  void testGetRowKeyFromEntity_thenThrowAccumuloElementConversionException() {
    // Arrange
    ByteEntityAccumuloElementConverter byteEntityAccumuloElementConverter = new ByteEntityAccumuloElementConverter(
        new Schema());
    Entity entity = (new Entity.Builder()).group("Group").vertex("Vertex").build();
    Key key = new Key(AccumuloProperties.CLIENT_SIDE_BLOOM_FILTER_SIZE);
    Value value = new Value();
    ByteEntityAccumuloElementConverter elementConverter = new ByteEntityAccumuloElementConverter(new Schema());

    LazyEntity entity2 = new LazyEntity(entity,
        new AccumuloEntityValueLoader("Group", key, value, elementConverter, new Schema()));
    entity2.putProperty("Name", "Value");

    // Act and Assert
    assertThrows(AccumuloElementConversionException.class,
        () -> byteEntityAccumuloElementConverter.getRowKeyFromEntity(entity2));
  }

  /**
   * Test {@link ByteEntityAccumuloElementConverter#getRowKeysFromEdge(Edge)}.
   * <p>
   * Method under test: {@link ByteEntityAccumuloElementConverter#getRowKeysFromEdge(Edge)}
   */
  @Test
  @DisplayName("Test getRowKeysFromEdge(Edge)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Pair ByteEntityAccumuloElementConverter.getRowKeysFromEdge(Edge)"})
  void testGetRowKeysFromEdge() throws SerialisationException {
    // Arrange
    AvroSerialiser avroSerialiser = mock(AvroSerialiser.class);
    when(avroSerialiser.serialise(Mockito.<Object>any()))
        .thenReturn(new byte[]{ByteEntityPositions.ENTITY, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});
    Schema schema = mock(Schema.class);
    when(schema.getConfig(Mockito.<String>any())).thenReturn("Config");
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.getVertexSerialiser()).thenReturn(avroSerialiser);
    ByteEntityAccumuloElementConverter byteEntityAccumuloElementConverter = new ByteEntityAccumuloElementConverter(
        schema);
    Edge edge = (new Builder()).dest("Dest")
        .directed(true)
        .group("Group")
        .matchedVertex(MatchedVertex.SOURCE)
        .source("Source")
        .build();

    // Act
    Pair<byte[], byte[]> actualRowKeysFromEdge = byteEntityAccumuloElementConverter.getRowKeysFromEdge(edge);

    // Assert
    verify(avroSerialiser, atLeast(1)).serialise(Mockito.<Object>any());
    verify(schema).getAggregatedGroups();
    verify(schema).getConfig(eq("timestampProperty"));
    verify(schema, atLeast(1)).getVertexSerialiser();
    assertArrayEquals(new byte[]{ByteEntityPositions.ENTITY, ByteEntityPositions.CORRECT_WAY_DIRECTED_EDGE, 'X', 'A',
        'X', 'A', 'X', 'A', 'X', 0, ByteEntityPositions.CORRECT_WAY_DIRECTED_EDGE, 0, ByteEntityPositions.ENTITY,
        ByteEntityPositions.CORRECT_WAY_DIRECTED_EDGE, 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0,
        ByteEntityPositions.CORRECT_WAY_DIRECTED_EDGE}, actualRowKeysFromEdge.getFirst());
    assertArrayEquals(new byte[]{ByteEntityPositions.ENTITY, ByteEntityPositions.CORRECT_WAY_DIRECTED_EDGE, 'X', 'A',
        'X', 'A', 'X', 'A', 'X', 0, ByteEntityPositions.INCORRECT_WAY_DIRECTED_EDGE, 0, ByteEntityPositions.ENTITY,
        ByteEntityPositions.CORRECT_WAY_DIRECTED_EDGE, 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0,
        ByteEntityPositions.INCORRECT_WAY_DIRECTED_EDGE}, actualRowKeysFromEdge.getSecond());
  }

  /**
   * Test {@link ByteEntityAccumuloElementConverter#getRowKeysFromEdge(Edge)}.
   * <p>
   * Method under test: {@link ByteEntityAccumuloElementConverter#getRowKeysFromEdge(Edge)}
   */
  @Test
  @DisplayName("Test getRowKeysFromEdge(Edge)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Pair ByteEntityAccumuloElementConverter.getRowKeysFromEdge(Edge)"})
  void testGetRowKeysFromEdge2() throws UnsupportedEncodingException, SerialisationException {
    // Arrange
    AvroSerialiser avroSerialiser = mock(AvroSerialiser.class);
    when(avroSerialiser.serialise(Mockito.<Object>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    Schema schema = mock(Schema.class);
    when(schema.getConfig(Mockito.<String>any())).thenReturn("Config");
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.getVertexSerialiser()).thenReturn(avroSerialiser);
    ByteEntityAccumuloElementConverter byteEntityAccumuloElementConverter = new ByteEntityAccumuloElementConverter(
        schema);
    Edge edge = (new Builder()).dest("Dest")
        .directed(false)
        .group("Group")
        .matchedVertex(MatchedVertex.SOURCE)
        .source("Source")
        .build();

    // Act
    Pair<byte[], byte[]> actualRowKeysFromEdge = byteEntityAccumuloElementConverter.getRowKeysFromEdge(edge);

    // Assert
    verify(avroSerialiser, atLeast(1)).serialise(Mockito.<Object>any());
    verify(schema).getAggregatedGroups();
    verify(schema).getConfig(eq("timestampProperty"));
    verify(schema, atLeast(1)).getVertexSerialiser();
    assertArrayEquals(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, ByteEntityPositions.UNDIRECTED_EDGE, 0, 'A',
        'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, ByteEntityPositions.UNDIRECTED_EDGE}, actualRowKeysFromEdge.getFirst());
    assertArrayEquals(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, ByteEntityPositions.UNDIRECTED_EDGE, 0, 'A',
        'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, ByteEntityPositions.UNDIRECTED_EDGE}, actualRowKeysFromEdge.getSecond());
  }

  /**
   * Test {@link ByteEntityAccumuloElementConverter#getRowKeysFromEdge(Edge)}.
   * <ul>
   *   <li>Then return First is array of {@code byte} with {@link ByteEntityPositions#ENTITY} and {@link ByteEntityPositions#ENTITY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ByteEntityAccumuloElementConverter#getRowKeysFromEdge(Edge)}
   */
  @Test
  @DisplayName("Test getRowKeysFromEdge(Edge); then return First is array of byte with ENTITY and ENTITY")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Pair ByteEntityAccumuloElementConverter.getRowKeysFromEdge(Edge)"})
  void testGetRowKeysFromEdge_thenReturnFirstIsArrayOfByteWithEntityAndEntity() throws SerialisationException {
    // Arrange
    AvroSerialiser avroSerialiser = mock(AvroSerialiser.class);
    when(avroSerialiser.serialise(Mockito.<Object>any())).thenReturn(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});
    Schema schema = mock(Schema.class);
    when(schema.getConfig(Mockito.<String>any())).thenReturn("Config");
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.getVertexSerialiser()).thenReturn(avroSerialiser);
    ByteEntityAccumuloElementConverter byteEntityAccumuloElementConverter = new ByteEntityAccumuloElementConverter(
        schema);
    Edge edge = (new Builder()).dest("Dest")
        .directed(true)
        .group("Group")
        .matchedVertex(MatchedVertex.SOURCE)
        .source("Source")
        .build();

    // Act
    Pair<byte[], byte[]> actualRowKeysFromEdge = byteEntityAccumuloElementConverter.getRowKeysFromEdge(edge);

    // Assert
    verify(avroSerialiser, atLeast(1)).serialise(Mockito.<Object>any());
    verify(schema).getAggregatedGroups();
    verify(schema).getConfig(eq("timestampProperty"));
    verify(schema, atLeast(1)).getVertexSerialiser();
    assertArrayEquals(
        new byte[]{ByteEntityPositions.ENTITY, ByteEntityPositions.ENTITY, 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0,
            ByteEntityPositions.CORRECT_WAY_DIRECTED_EDGE, 0, ByteEntityPositions.ENTITY, ByteEntityPositions.ENTITY,
            'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, ByteEntityPositions.CORRECT_WAY_DIRECTED_EDGE},
        actualRowKeysFromEdge.getFirst());
    assertArrayEquals(
        new byte[]{ByteEntityPositions.ENTITY, ByteEntityPositions.ENTITY, 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0,
            ByteEntityPositions.INCORRECT_WAY_DIRECTED_EDGE, 0, ByteEntityPositions.ENTITY, ByteEntityPositions.ENTITY,
            'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, ByteEntityPositions.INCORRECT_WAY_DIRECTED_EDGE},
        actualRowKeysFromEdge.getSecond());
  }

  /**
   * Test {@link ByteEntityAccumuloElementConverter#getRowKeysFromEdge(Edge)}.
   * <ul>
   *   <li>Then return Second is array of {@code byte} with {@code A} and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ByteEntityAccumuloElementConverter#getRowKeysFromEdge(Edge)}
   */
  @Test
  @DisplayName("Test getRowKeysFromEdge(Edge); then return Second is array of byte with 'A' and 'X'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Pair ByteEntityAccumuloElementConverter.getRowKeysFromEdge(Edge)"})
  void testGetRowKeysFromEdge_thenReturnSecondIsArrayOfByteWithAAndX()
      throws UnsupportedEncodingException, SerialisationException {
    // Arrange
    AvroSerialiser avroSerialiser = mock(AvroSerialiser.class);
    when(avroSerialiser.serialise(Mockito.<Object>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    Schema schema = mock(Schema.class);
    when(schema.getConfig(Mockito.<String>any())).thenReturn("Config");
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.getVertexSerialiser()).thenReturn(avroSerialiser);
    ByteEntityAccumuloElementConverter byteEntityAccumuloElementConverter = new ByteEntityAccumuloElementConverter(
        schema);
    Edge edge = (new Builder()).dest("Dest")
        .directed(true)
        .group("Group")
        .matchedVertex(MatchedVertex.SOURCE)
        .source("Source")
        .build();

    // Act
    Pair<byte[], byte[]> actualRowKeysFromEdge = byteEntityAccumuloElementConverter.getRowKeysFromEdge(edge);

    // Assert
    verify(avroSerialiser, atLeast(1)).serialise(Mockito.<Object>any());
    verify(schema).getAggregatedGroups();
    verify(schema).getConfig(eq("timestampProperty"));
    verify(schema, atLeast(1)).getVertexSerialiser();
    assertArrayEquals(
        new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, ByteEntityPositions.CORRECT_WAY_DIRECTED_EDGE, 0, 'A',
            'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, ByteEntityPositions.CORRECT_WAY_DIRECTED_EDGE},
        actualRowKeysFromEdge.getFirst());
    assertArrayEquals(
        new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, ByteEntityPositions.INCORRECT_WAY_DIRECTED_EDGE, 0, 'A',
            'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, ByteEntityPositions.INCORRECT_WAY_DIRECTED_EDGE},
        actualRowKeysFromEdge.getSecond());
  }

  /**
   * Test {@link ByteEntityAccumuloElementConverter#getRowKeysFromEdge(Edge)}.
   * <ul>
   *   <li>Then return Second is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ByteEntityAccumuloElementConverter#getRowKeysFromEdge(Edge)}
   */
  @Test
  @DisplayName("Test getRowKeysFromEdge(Edge); then return Second is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Pair ByteEntityAccumuloElementConverter.getRowKeysFromEdge(Edge)"})
  void testGetRowKeysFromEdge_thenReturnSecondIsNull() throws UnsupportedEncodingException, SerialisationException {
    // Arrange
    AvroSerialiser avroSerialiser = mock(AvroSerialiser.class);
    when(avroSerialiser.serialise(Mockito.<Object>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    Schema schema = mock(Schema.class);
    when(schema.getConfig(Mockito.<String>any())).thenReturn("Config");
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.getVertexSerialiser()).thenReturn(avroSerialiser);
    ByteEntityAccumuloElementConverter byteEntityAccumuloElementConverter = new ByteEntityAccumuloElementConverter(
        schema);
    Edge edge = (new Builder()).dest("Source")
        .directed(true)
        .group("Group")
        .matchedVertex(MatchedVertex.SOURCE)
        .source("Source")
        .build();

    // Act
    Pair<byte[], byte[]> actualRowKeysFromEdge = byteEntityAccumuloElementConverter.getRowKeysFromEdge(edge);

    // Assert
    verify(avroSerialiser, atLeast(1)).serialise(isA(Object.class));
    verify(schema).getAggregatedGroups();
    verify(schema).getConfig(eq("timestampProperty"));
    verify(schema, atLeast(1)).getVertexSerialiser();
    assertNull(actualRowKeysFromEdge.getSecond());
    assertArrayEquals(
        new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, ByteEntityPositions.CORRECT_WAY_DIRECTED_EDGE, 0, 'A',
            'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, ByteEntityPositions.CORRECT_WAY_DIRECTED_EDGE},
        actualRowKeysFromEdge.getFirst());
  }

  /**
   * Test {@link ByteEntityAccumuloElementConverter#doesKeyRepresentEntity(byte[])}.
   * <ul>
   *   <li>When {@code A}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ByteEntityAccumuloElementConverter#doesKeyRepresentEntity(byte[])}
   */
  @Test
  @DisplayName("Test doesKeyRepresentEntity(byte[]); when 'A'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ByteEntityAccumuloElementConverter.doesKeyRepresentEntity(byte[])"})
  void testDoesKeyRepresentEntity_whenA_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new ByteEntityAccumuloElementConverter(new Schema()))
        .doesKeyRepresentEntity(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', ByteEntityPositions.ENTITY}));
  }

  /**
   * Test {@link ByteEntityAccumuloElementConverter#doesKeyRepresentEntity(byte[])}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ByteEntityAccumuloElementConverter#doesKeyRepresentEntity(byte[])}
   */
  @Test
  @DisplayName("Test doesKeyRepresentEntity(byte[]); when 'AXAXAXAX' Bytes is 'UTF-8'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ByteEntityAccumuloElementConverter.doesKeyRepresentEntity(byte[])"})
  void testDoesKeyRepresentEntity_whenAxaxaxaxBytesIsUtf8_thenReturnFalse() throws UnsupportedEncodingException {
    // Arrange
    ByteEntityAccumuloElementConverter byteEntityAccumuloElementConverter = new ByteEntityAccumuloElementConverter(
        new Schema());

    // Act and Assert
    assertFalse(byteEntityAccumuloElementConverter.doesKeyRepresentEntity("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link ByteEntityAccumuloElementConverter#getEntityFromKey(Key, byte[])}.
   * <p>
   * Method under test: {@link ByteEntityAccumuloElementConverter#getEntityFromKey(Key, byte[])}
   */
  @Test
  @DisplayName("Test getEntityFromKey(Key, byte[])")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Entity ByteEntityAccumuloElementConverter.getEntityFromKey(Key, byte[])"})
  void testGetEntityFromKey() throws UnsupportedEncodingException {
    // Arrange
    Schema schema = mock(Schema.class);
    when(schema.getVisibilityProperty()).thenThrow(new AccumuloElementConversionException("An error occurred"));
    when(schema.getElement(Mockito.<String>any())).thenReturn(new SchemaEdgeDefinition());
    when(schema.getConfig(Mockito.<String>any())).thenReturn("Config");
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.getVertexSerialiser()).thenReturn(new FreqMapSerialiser());
    ByteEntityAccumuloElementConverter byteEntityAccumuloElementConverter = new ByteEntityAccumuloElementConverter(
        schema);
    Key key = new Key();

    // Act and Assert
    assertThrows(AccumuloElementConversionException.class,
        () -> byteEntityAccumuloElementConverter.getEntityFromKey(key, "AXAXAXAX".getBytes("UTF-8")));
    verify(schema).getAggregatedGroups();
    verify(schema).getConfig(eq("timestampProperty"));
    verify(schema).getElement(eq(""));
    verify(schema).getVertexSerialiser();
    verify(schema).getVisibilityProperty();
  }

  /**
   * Test {@link ByteEntityAccumuloElementConverter#getEntityFromKey(Key, byte[])}.
   * <ul>
   *   <li>Given {@link Schema} {@link Schema#getVertexSerialiser()} return {@link AvroSerialiser} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link ByteEntityAccumuloElementConverter#getEntityFromKey(Key, byte[])}
   */
  @Test
  @DisplayName("Test getEntityFromKey(Key, byte[]); given Schema getVertexSerialiser() return AvroSerialiser (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Entity ByteEntityAccumuloElementConverter.getEntityFromKey(Key, byte[])"})
  void testGetEntityFromKey_givenSchemaGetVertexSerialiserReturnAvroSerialiser() throws UnsupportedEncodingException {
    // Arrange
    Schema schema = mock(Schema.class);
    when(schema.getConfig(Mockito.<String>any())).thenReturn("Config");
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.getVertexSerialiser()).thenReturn(new AvroSerialiser());
    ByteEntityAccumuloElementConverter byteEntityAccumuloElementConverter = new ByteEntityAccumuloElementConverter(
        schema);
    Key key = new Key();

    // Act and Assert
    assertThrows(AccumuloElementConversionException.class,
        () -> byteEntityAccumuloElementConverter.getEntityFromKey(key, "AXAXAXAX".getBytes("UTF-8")));
    verify(schema).getAggregatedGroups();
    verify(schema).getConfig(eq("timestampProperty"));
    verify(schema).getVertexSerialiser();
  }

  /**
   * Test {@link ByteEntityAccumuloElementConverter#getEntityFromKey(Key, byte[])}.
   * <ul>
   *   <li>Then calls {@link Key#getColumnVisibilityData()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ByteEntityAccumuloElementConverter#getEntityFromKey(Key, byte[])}
   */
  @Test
  @DisplayName("Test getEntityFromKey(Key, byte[]); then calls getColumnVisibilityData()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Entity ByteEntityAccumuloElementConverter.getEntityFromKey(Key, byte[])"})
  void testGetEntityFromKey_thenCallsGetColumnVisibilityData() throws UnsupportedEncodingException {
    // Arrange
    SchemaElementDefinition schemaElementDefinition = mock(SchemaElementDefinition.class);
    when(schemaElementDefinition.getGroupBy()).thenReturn(new HashSet<>());
    Schema schema = mock(Schema.class);
    when(schema.getElement(Mockito.<String>any())).thenReturn(schemaElementDefinition);
    when(schema.getConfig(Mockito.<String>any())).thenReturn("Config");
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.getVertexSerialiser()).thenReturn(new FreqMapSerialiser());
    ByteEntityAccumuloElementConverter byteEntityAccumuloElementConverter = new ByteEntityAccumuloElementConverter(
        schema);
    Key key = mock(Key.class);
    when(key.getColumnVisibilityData()).thenThrow(new AccumuloElementConversionException("An error occurred"));
    when(key.getColumnQualifierData()).thenReturn(new ArrayByteSequence("foo"));
    when(key.getColumnFamilyData()).thenReturn(new ArrayByteSequence("foo"));

    // Act and Assert
    assertThrows(AccumuloElementConversionException.class,
        () -> byteEntityAccumuloElementConverter.getEntityFromKey(key, "AXAXAXAX".getBytes("UTF-8")));
    verify(key).getColumnFamilyData();
    verify(key).getColumnQualifierData();
    verify(key).getColumnVisibilityData();
    verify(schema).getAggregatedGroups();
    verify(schema).getConfig(eq("timestampProperty"));
    verify(schema).getElement(eq("foo"));
    verify(schema).getVertexSerialiser();
    verify(schemaElementDefinition).getGroupBy();
  }

  /**
   * Test {@link ByteEntityAccumuloElementConverter#getEntityFromKey(Key, byte[])}.
   * <ul>
   *   <li>Then Vertex return {@link Map}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ByteEntityAccumuloElementConverter#getEntityFromKey(Key, byte[])}
   */
  @Test
  @DisplayName("Test getEntityFromKey(Key, byte[]); then Vertex return Map")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Entity ByteEntityAccumuloElementConverter.getEntityFromKey(Key, byte[])"})
  void testGetEntityFromKey_thenVertexReturnMap() throws UnsupportedEncodingException {
    // Arrange
    Schema schema = mock(Schema.class);
    when(schema.getVisibilityProperty()).thenReturn("Visibility Property");
    when(schema.getElement(Mockito.<String>any())).thenReturn(new SchemaEdgeDefinition());
    when(schema.getConfig(Mockito.<String>any())).thenReturn("Config");
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.getVertexSerialiser()).thenReturn(new FreqMapSerialiser());
    ByteEntityAccumuloElementConverter byteEntityAccumuloElementConverter = new ByteEntityAccumuloElementConverter(
        schema);
    Key key = new Key();

    // Act
    Entity actualEntityFromKey = byteEntityAccumuloElementConverter.getEntityFromKey(key, "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    verify(schema).getAggregatedGroups();
    verify(schema).getConfig(eq("timestampProperty"));
    verify(schema, atLeast(1)).getElement(eq(""));
    verify(schema).getVertexSerialiser();
    verify(schema, atLeast(1)).getVisibilityProperty();
    Object vertex = actualEntityFromKey.getVertex();
    assertTrue(vertex instanceof Map);
    assertEquals("", actualEntityFromKey.getGroup());
    assertEquals("uk.gov.gchq.gaffer.data.element.Entity", actualEntityFromKey.getClassName());
    assertTrue(actualEntityFromKey.getProperties().isEmpty());
    assertTrue(((Map<Object, Object>) vertex).isEmpty());
  }

  /**
   * Test {@link ByteEntityAccumuloElementConverter#getEntityFromKey(Key, byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with {@code A} and zero.</li>
   *   <li>Then calls {@link ArrayByteSequence#getBackingArray()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ByteEntityAccumuloElementConverter#getEntityFromKey(Key, byte[])}
   */
  @Test
  @DisplayName("Test getEntityFromKey(Key, byte[]); when array of byte with 'A' and zero; then calls getBackingArray()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Entity ByteEntityAccumuloElementConverter.getEntityFromKey(Key, byte[])"})
  void testGetEntityFromKey_whenArrayOfByteWithAAndZero_thenCallsGetBackingArray() {
    // Arrange
    Schema schema = mock(Schema.class);
    when(schema.getConfig(Mockito.<String>any())).thenReturn("Config");
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.getVertexSerialiser()).thenReturn(new FreqMapSerialiser());
    ByteEntityAccumuloElementConverter byteEntityAccumuloElementConverter = new ByteEntityAccumuloElementConverter(
        schema);
    ArrayByteSequence arrayByteSequence = mock(ArrayByteSequence.class);
    when(arrayByteSequence.getBackingArray()).thenThrow(new AccumuloElementConversionException("An error occurred"));
    Key key = mock(Key.class);
    when(key.getColumnQualifierData()).thenReturn(arrayByteSequence);
    when(key.getColumnFamilyData()).thenReturn(new ArrayByteSequence("foo"));

    // Act and Assert
    assertThrows(AccumuloElementConversionException.class, () -> byteEntityAccumuloElementConverter
        .getEntityFromKey(key, new byte[]{'A', 0, 'A', 'X', 'A', 'X', 'A', 'X'}));
    verify(arrayByteSequence).getBackingArray();
    verify(key).getColumnFamilyData();
    verify(key).getColumnQualifierData();
    verify(schema).getAggregatedGroups();
    verify(schema).getConfig(eq("timestampProperty"));
    verify(schema).getVertexSerialiser();
  }

  /**
   * Test {@link ByteEntityAccumuloElementConverter#getEntityFromKey(Key, byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with zero and {@code X}.</li>
   *   <li>Then calls {@link ArrayByteSequence#getBackingArray()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ByteEntityAccumuloElementConverter#getEntityFromKey(Key, byte[])}
   */
  @Test
  @DisplayName("Test getEntityFromKey(Key, byte[]); when array of byte with zero and 'X'; then calls getBackingArray()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Entity ByteEntityAccumuloElementConverter.getEntityFromKey(Key, byte[])"})
  void testGetEntityFromKey_whenArrayOfByteWithZeroAndX_thenCallsGetBackingArray() {
    // Arrange
    Schema schema = mock(Schema.class);
    when(schema.getConfig(Mockito.<String>any())).thenReturn("Config");
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.getVertexSerialiser()).thenReturn(new FreqMapSerialiser());
    ByteEntityAccumuloElementConverter byteEntityAccumuloElementConverter = new ByteEntityAccumuloElementConverter(
        schema);
    ArrayByteSequence arrayByteSequence = mock(ArrayByteSequence.class);
    when(arrayByteSequence.getBackingArray()).thenThrow(new AccumuloElementConversionException("An error occurred"));
    Key key = mock(Key.class);
    when(key.getColumnQualifierData()).thenReturn(arrayByteSequence);
    when(key.getColumnFamilyData()).thenReturn(new ArrayByteSequence("foo"));

    // Act and Assert
    assertThrows(AccumuloElementConversionException.class, () -> byteEntityAccumuloElementConverter
        .getEntityFromKey(key, new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
    verify(arrayByteSequence).getBackingArray();
    verify(key).getColumnFamilyData();
    verify(key).getColumnQualifierData();
    verify(schema).getAggregatedGroups();
    verify(schema).getConfig(eq("timestampProperty"));
    verify(schema).getVertexSerialiser();
  }

  /**
   * Test {@link ByteEntityAccumuloElementConverter#getSourceAndDestinationFromRowKey(byte[], byte[][])}.
   * <ul>
   *   <li>When array of {@code byte} with zero and zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link ByteEntityAccumuloElementConverter#getSourceAndDestinationFromRowKey(byte[], byte[][])}
   */
  @Test
  @DisplayName("Test getSourceAndDestinationFromRowKey(byte[], byte[][]); when array of byte with zero and zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "EdgeDirection ByteEntityAccumuloElementConverter.getSourceAndDestinationFromRowKey(byte[], byte[][])"})
  void testGetSourceAndDestinationFromRowKey_whenArrayOfByteWithZeroAndZero() throws UnsupportedEncodingException {
    // Arrange
    ByteEntityAccumuloElementConverter byteEntityAccumuloElementConverter = new ByteEntityAccumuloElementConverter(
        new Schema());

    // Act and Assert
    assertThrows(AccumuloElementConversionException.class,
        () -> byteEntityAccumuloElementConverter.getSourceAndDestinationFromRowKey(
            new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            new byte[][]{"AXAXAXAX".getBytes("UTF-8")}));
  }

  /**
   * Test {@link ByteEntityAccumuloElementConverter#getSourceAndDestinationFromRowKey(byte[], byte[][])}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ByteEntityAccumuloElementConverter#getSourceAndDestinationFromRowKey(byte[], byte[][])}
   */
  @Test
  @DisplayName("Test getSourceAndDestinationFromRowKey(byte[], byte[][]); when 'AXAXAXAX' Bytes is 'UTF-8'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "EdgeDirection ByteEntityAccumuloElementConverter.getSourceAndDestinationFromRowKey(byte[], byte[][])"})
  void testGetSourceAndDestinationFromRowKey_whenAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange
    ByteEntityAccumuloElementConverter byteEntityAccumuloElementConverter = new ByteEntityAccumuloElementConverter(
        new Schema());
    byte[] rowKey = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertThrows(AccumuloElementConversionException.class, () -> byteEntityAccumuloElementConverter
        .getSourceAndDestinationFromRowKey(rowKey, new byte[][]{"AXAXAXAX".getBytes("UTF-8")}));
  }
}
