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

package uk.gov.gchq.gaffer.accumulostore.key.core.impl.byteEntity;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
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
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.function.BinaryOperator;
import org.apache.accumulo.core.data.ArrayByteSequence;
import org.apache.accumulo.core.data.ByteSequence;
import org.apache.accumulo.core.data.Key;
import org.apache.accumulo.core.data.Value;
import org.apache.accumulo.core.file.rfile.RFile;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uk.gov.gchq.gaffer.accumulostore.data.element.AccumuloEntityValueLoader;
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
import uk.gov.gchq.gaffer.store.schema.TypeDefinition;
import uk.gov.gchq.gaffer.store.schema.TypeDefinition.Builder;
import uk.gov.gchq.gaffer.types.TypeSubTypeValue;

class ByteEntityAccumuloElementConverterDiffblueTest {
  /**
   * Test {@link ByteEntityAccumuloElementConverter#ByteEntityAccumuloElementConverter(Schema)}.
   *
   * <ul>
   *   <li>Given {@code timestampProperty}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ByteEntityAccumuloElementConverter#ByteEntityAccumuloElementConverter(Schema)}
   */
  @Test
  @DisplayName("Test new ByteEntityAccumuloElementConverter(Schema); given 'timestampProperty'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ByteEntityAccumuloElementConverter.<init>(Schema)"})
  void testNewByteEntityAccumuloElementConverter_givenTimestampProperty()
      throws UnsupportedEncodingException {
    // Arrange
    Schema schema = new Schema();
    schema.addConfig("timestampProperty", "Schema");

    // Act and Assert
    assertArrayEquals(
        "Group".getBytes("UTF-8"),
        new ByteEntityAccumuloElementConverter(schema).buildColumnFamily("Group"));
  }

  /**
   * Test {@link ByteEntityAccumuloElementConverter#ByteEntityAccumuloElementConverter(Schema)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ByteEntityAccumuloElementConverter#ByteEntityAccumuloElementConverter(Schema)}
   */
  @Test
  @DisplayName("Test new ByteEntityAccumuloElementConverter(Schema); when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ByteEntityAccumuloElementConverter.<init>(Schema)"})
  void testNewByteEntityAccumuloElementConverter_whenNull() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertArrayEquals(
        "Group".getBytes("UTF-8"),
        new ByteEntityAccumuloElementConverter(null).buildColumnFamily("Group"));
  }

  /**
   * Test {@link ByteEntityAccumuloElementConverter#ByteEntityAccumuloElementConverter(Schema)}.
   *
   * <ul>
   *   <li>When {@link Schema#Schema()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ByteEntityAccumuloElementConverter#ByteEntityAccumuloElementConverter(Schema)}
   */
  @Test
  @DisplayName("Test new ByteEntityAccumuloElementConverter(Schema); when Schema()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ByteEntityAccumuloElementConverter.<init>(Schema)"})
  void testNewByteEntityAccumuloElementConverter_whenSchema() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertArrayEquals(
        "Group".getBytes("UTF-8"),
        new ByteEntityAccumuloElementConverter(new Schema()).buildColumnFamily("Group"));
  }

  /**
   * Test {@link ByteEntityAccumuloElementConverter#getEntityId(byte[])}.
   *
   * <ul>
   *   <li>Then throw {@link AccumuloElementConversionException}.
   * </ul>
   *
   * <p>Method under test: {@link ByteEntityAccumuloElementConverter#getEntityId(byte[])}
   */
  @Test
  @DisplayName("Test getEntityId(byte[]); then throw AccumuloElementConversionException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId ByteEntityAccumuloElementConverter.getEntityId(byte[])"})
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
            new ByteEntityAccumuloElementConverter(schema)
                .getEntityId("AXAXAXAX".getBytes("UTF-8")));
    verify(schema).getAggregatedGroups();
    verify(schema).getConfig("timestampProperty");
    verify(schema).getVertexSerialiser();
  }

  /**
   * Test {@link ByteEntityAccumuloElementConverter#getEntityId(byte[])}.
   *
   * <ul>
   *   <li>Then Vertex return {@link Map}.
   * </ul>
   *
   * <p>Method under test: {@link ByteEntityAccumuloElementConverter#getEntityId(byte[])}
   */
  @Test
  @DisplayName("Test getEntityId(byte[]); then Vertex return Map")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId ByteEntityAccumuloElementConverter.getEntityId(byte[])"})
  void testGetEntityId_thenVertexReturnMap() throws UnsupportedEncodingException {
    // Arrange
    Schema schema = mock(Schema.class);
    when(schema.getConfig(Mockito.<String>any())).thenReturn("Config");
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.getVertexSerialiser()).thenReturn(new FreqMapSerialiser());

    // Act
    EntityId actualEntityId =
        new ByteEntityAccumuloElementConverter(schema).getEntityId("AXAXAXAX".getBytes("UTF-8"));

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
   * Test {@link ByteEntityAccumuloElementConverter#getEntityId(byte[])}.
   *
   * <ul>
   *   <li>Then Vertex return {@link TypeSubTypeValue}.
   * </ul>
   *
   * <p>Method under test: {@link ByteEntityAccumuloElementConverter#getEntityId(byte[])}
   */
  @Test
  @DisplayName("Test getEntityId(byte[]); then Vertex return TypeSubTypeValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId ByteEntityAccumuloElementConverter.getEntityId(byte[])"})
  void testGetEntityId_thenVertexReturnTypeSubTypeValue() throws UnsupportedEncodingException {
    // Arrange
    Schema schema = mock(Schema.class);
    when(schema.getConfig(Mockito.<String>any())).thenReturn("Config");
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.getVertexSerialiser()).thenReturn(new TypeSubTypeValueSerialiser());

    // Act
    EntityId actualEntityId =
        new ByteEntityAccumuloElementConverter(schema).getEntityId("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    verify(schema).getAggregatedGroups();
    verify(schema).getConfig("timestampProperty");
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
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then throw {@link AccumuloElementConversionException}.
   * </ul>
   *
   * <p>Method under test: {@link ByteEntityAccumuloElementConverter#getEntityId(byte[])}
   */
  @Test
  @DisplayName("Test getEntityId(byte[]); when 'A'; then throw AccumuloElementConversionException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId ByteEntityAccumuloElementConverter.getEntityId(byte[])"})
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
            new ByteEntityAccumuloElementConverter(schema)
                .getEntityId(
                    new byte[] {ByteEntityPositions.ENTITY, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
    verify(schema).getAggregatedGroups();
    verify(schema).getConfig("timestampProperty");
    verify(schema).getVertexSerialiser();
  }

  /**
   * Test {@link ByteEntityAccumuloElementConverter#getRowKeyFromEntity(Entity)}.
   *
   * <ul>
   *   <li>Then throw {@link AccumuloElementConversionException}.
   * </ul>
   *
   * <p>Method under test: {@link ByteEntityAccumuloElementConverter#getRowKeyFromEntity(Entity)}
   */
  @Test
  @DisplayName("Test getRowKeyFromEntity(Entity); then throw AccumuloElementConversionException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ByteEntityAccumuloElementConverter.getRowKeyFromEntity(Entity)"})
  void testGetRowKeyFromEntity_thenThrowAccumuloElementConversionException() {
    // Arrange
    ByteEntityAccumuloElementConverter byteEntityAccumuloElementConverter =
        new ByteEntityAccumuloElementConverter(new Schema());
    Entity entity = new Entity.Builder().group("Group").vertex("Vertex").build();
    Key key = new Key(RFile.EXTENSION);
    Value value = new Value();
    ByteEntityAccumuloElementConverter elementConverter =
        new ByteEntityAccumuloElementConverter(new Schema());

    AccumuloEntityValueLoader valueLoader =
        new AccumuloEntityValueLoader("Group", key, value, elementConverter, new Schema());

    LazyEntity entity2 = new LazyEntity(entity, valueLoader);
    entity2.putProperty("Name", "Value");

    // Act and Assert
    assertThrows(
        AccumuloElementConversionException.class,
        () -> byteEntityAccumuloElementConverter.getRowKeyFromEntity(entity2));
  }

  /**
   * Test {@link ByteEntityAccumuloElementConverter#getRowKeysFromEdge(Edge)}.
   *
   * <p>Method under test: {@link ByteEntityAccumuloElementConverter#getRowKeysFromEdge(Edge)}
   */
  @Test
  @DisplayName("Test getRowKeysFromEdge(Edge)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "uk.gov.gchq.gaffer.commonutil.pair.Pair ByteEntityAccumuloElementConverter.getRowKeysFromEdge(Edge)"
  })
  void testGetRowKeysFromEdge() {
    // Arrange
    Schema schema = mock(Schema.class);
    when(schema.getConfig(Mockito.<String>any())).thenReturn("Config");
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.getVertexSerialiser()).thenReturn(new AvroSerialiser());
    ByteEntityAccumuloElementConverter byteEntityAccumuloElementConverter =
        new ByteEntityAccumuloElementConverter(schema);

    // Act
    byteEntityAccumuloElementConverter.getRowKeysFromEdge(
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
   * Test {@link ByteEntityAccumuloElementConverter#getRowKeysFromEdge(Edge)}.
   *
   * <p>Method under test: {@link ByteEntityAccumuloElementConverter#getRowKeysFromEdge(Edge)}
   */
  @Test
  @DisplayName("Test getRowKeysFromEdge(Edge)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "uk.gov.gchq.gaffer.commonutil.pair.Pair ByteEntityAccumuloElementConverter.getRowKeysFromEdge(Edge)"
  })
  void testGetRowKeysFromEdge2() {
    // Arrange
    Schema schema = mock(Schema.class);
    when(schema.getConfig(Mockito.<String>any())).thenReturn("Config");
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.getVertexSerialiser()).thenReturn(new AvroSerialiser());
    ByteEntityAccumuloElementConverter byteEntityAccumuloElementConverter =
        new ByteEntityAccumuloElementConverter(schema);

    Edge edge = mock(Edge.class);
    when(edge.getDestination())
        .thenThrow(new AccumuloElementConversionException("An error occurred"));
    when(edge.getSource()).thenReturn("Source");

    // Act and Assert
    assertThrows(
        AccumuloElementConversionException.class,
        () -> byteEntityAccumuloElementConverter.getRowKeysFromEdge(edge));
    verify(edge).getDestination();
    verify(edge).getSource();
    verify(schema).getAggregatedGroups();
    verify(schema).getConfig("timestampProperty");
    verify(schema, atLeast(1)).getVertexSerialiser();
  }

  /**
   * Test {@link ByteEntityAccumuloElementConverter#getRowKeysFromEdge(Edge)}.
   *
   * <p>Method under test: {@link ByteEntityAccumuloElementConverter#getRowKeysFromEdge(Edge)}
   */
  @Test
  @DisplayName("Test getRowKeysFromEdge(Edge)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "uk.gov.gchq.gaffer.commonutil.pair.Pair ByteEntityAccumuloElementConverter.getRowKeysFromEdge(Edge)"
  })
  void testGetRowKeysFromEdge3() {
    // Arrange
    Schema schema = mock(Schema.class);
    when(schema.getConfig(Mockito.<String>any())).thenReturn("Config");
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.getVertexSerialiser()).thenReturn(new AvroSerialiser());
    ByteEntityAccumuloElementConverter byteEntityAccumuloElementConverter =
        new ByteEntityAccumuloElementConverter(schema);

    Edge edge = mock(Edge.class);
    when(edge.isDirected()).thenThrow(new AccumuloElementConversionException("An error occurred"));
    when(edge.getDestination()).thenReturn("Destination");
    when(edge.getSource()).thenReturn("Source");

    // Act and Assert
    assertThrows(
        AccumuloElementConversionException.class,
        () -> byteEntityAccumuloElementConverter.getRowKeysFromEdge(edge));
    verify(edge).getDestination();
    verify(edge).getSource();
    verify(edge).isDirected();
    verify(schema).getAggregatedGroups();
    verify(schema).getConfig("timestampProperty");
    verify(schema, atLeast(1)).getVertexSerialiser();
  }

  /**
   * Test {@link ByteEntityAccumuloElementConverter#getRowKeysFromEdge(Edge)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>When {@link Edge} {@link Edge#isDirected()} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ByteEntityAccumuloElementConverter#getRowKeysFromEdge(Edge)}
   */
  @Test
  @DisplayName(
      "Test getRowKeysFromEdge(Edge); given 'false'; when Edge isDirected() return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "uk.gov.gchq.gaffer.commonutil.pair.Pair ByteEntityAccumuloElementConverter.getRowKeysFromEdge(Edge)"
  })
  void testGetRowKeysFromEdge_givenFalse_whenEdgeIsDirectedReturnFalse() {
    // Arrange
    Schema schema = mock(Schema.class);
    when(schema.getConfig(Mockito.<String>any())).thenReturn("Config");
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.getVertexSerialiser()).thenReturn(new AvroSerialiser());
    ByteEntityAccumuloElementConverter byteEntityAccumuloElementConverter =
        new ByteEntityAccumuloElementConverter(schema);

    Edge edge = mock(Edge.class);
    when(edge.isDirected()).thenReturn(false);
    when(edge.getDestination()).thenReturn("Destination");
    when(edge.getSource()).thenReturn("Source");

    // Act
    byteEntityAccumuloElementConverter.getRowKeysFromEdge(edge);

    // Assert
    verify(edge, atLeast(1)).getDestination();
    verify(edge, atLeast(1)).getSource();
    verify(edge).isDirected();
    verify(schema).getAggregatedGroups();
    verify(schema).getConfig("timestampProperty");
    verify(schema, atLeast(1)).getVertexSerialiser();
  }

  /**
   * Test {@link ByteEntityAccumuloElementConverter#getRowKeysFromEdge(Edge)}.
   *
   * <ul>
   *   <li>Then calls {@link AvroSerialiser#serialise(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link ByteEntityAccumuloElementConverter#getRowKeysFromEdge(Edge)}
   */
  @Test
  @DisplayName("Test getRowKeysFromEdge(Edge); then calls serialise(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "uk.gov.gchq.gaffer.commonutil.pair.Pair ByteEntityAccumuloElementConverter.getRowKeysFromEdge(Edge)"
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
    ByteEntityAccumuloElementConverter byteEntityAccumuloElementConverter =
        new ByteEntityAccumuloElementConverter(schema);

    Edge edge = mock(Edge.class);
    when(edge.getSource()).thenReturn("Source");

    // Act and Assert
    assertThrows(
        AccumuloElementConversionException.class,
        () -> byteEntityAccumuloElementConverter.getRowKeysFromEdge(edge));
    verify(edge).getSource();
    verify(avroSerialiser).serialise(isA(Object.class));
    verify(schema).getAggregatedGroups();
    verify(schema).getConfig("timestampProperty");
    verify(schema).getVertexSerialiser();
  }

  /**
   * Test {@link ByteEntityAccumuloElementConverter#doesKeyRepresentEntity(byte[])}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ByteEntityAccumuloElementConverter#doesKeyRepresentEntity(byte[])}
   */
  @Test
  @DisplayName("Test doesKeyRepresentEntity(byte[]); when 'A'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ByteEntityAccumuloElementConverter.doesKeyRepresentEntity(byte[])"})
  void testDoesKeyRepresentEntity_whenA_thenReturnTrue() {
    // Arrange and Act
    boolean actualDoesKeyRepresentEntityResult =
        new ByteEntityAccumuloElementConverter(new Schema())
            .doesKeyRepresentEntity(
                new byte[] {
                  'A',
                  ByteEntityPositions.ENTITY,
                  'A',
                  ByteEntityPositions.ENTITY,
                  'A',
                  ByteEntityPositions.ENTITY,
                  'A',
                  ByteEntityPositions.ENTITY,
                  'A',
                  ByteEntityPositions.ENTITY,
                  'A',
                  ByteEntityPositions.ENTITY,
                  'A',
                  ByteEntityPositions.ENTITY,
                  'A',
                  ByteEntityPositions.ENTITY
                });

    // Assert
    assertTrue(actualDoesKeyRepresentEntityResult);
  }

  /**
   * Test {@link ByteEntityAccumuloElementConverter#doesKeyRepresentEntity(byte[])}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ByteEntityAccumuloElementConverter#doesKeyRepresentEntity(byte[])}
   */
  @Test
  @DisplayName(
      "Test doesKeyRepresentEntity(byte[]); when 'AXAXAXAX' Bytes is 'UTF-8'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ByteEntityAccumuloElementConverter.doesKeyRepresentEntity(byte[])"})
  void testDoesKeyRepresentEntity_whenAxaxaxaxBytesIsUtf8_thenReturnFalse()
      throws UnsupportedEncodingException {
    // Arrange and Act
    boolean actualDoesKeyRepresentEntityResult =
        new ByteEntityAccumuloElementConverter(new Schema())
            .doesKeyRepresentEntity("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertFalse(actualDoesKeyRepresentEntityResult);
  }

  /**
   * Test {@link ByteEntityAccumuloElementConverter#getEntityFromKey(Key, byte[])}.
   *
   * <p>Method under test: {@link ByteEntityAccumuloElementConverter#getEntityFromKey(Key, byte[])}
   */
  @Test
  @DisplayName("Test getEntityFromKey(Key, byte[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity ByteEntityAccumuloElementConverter.getEntityFromKey(Key, byte[])"})
  void testGetEntityFromKey() throws UnsupportedEncodingException {
    // Arrange
    Schema schema = mock(Schema.class);
    when(schema.getConfig(Mockito.<String>any())).thenReturn("Config");
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.getVertexSerialiser()).thenReturn(new FreqMapSerialiser());
    ByteEntityAccumuloElementConverter byteEntityAccumuloElementConverter =
        new ByteEntityAccumuloElementConverter(schema);

    ByteSequence byteSequence = mock(ByteSequence.class);
    when(byteSequence.getBackingArray()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    Key key = mock(Key.class);
    when(key.getColumnQualifierData())
        .thenThrow(new AccumuloElementConversionException("An error occurred"));
    when(key.getColumnFamilyData()).thenReturn(byteSequence);

    // Act and Assert
    assertThrows(
        AccumuloElementConversionException.class,
        () ->
            byteEntityAccumuloElementConverter.getEntityFromKey(key, "AXAXAXAX".getBytes("UTF-8")));
    verify(byteSequence).getBackingArray();
    verify(key).getColumnFamilyData();
    verify(key).getColumnQualifierData();
    verify(schema).getAggregatedGroups();
    verify(schema).getConfig("timestampProperty");
    verify(schema).getVertexSerialiser();
  }

  /**
   * Test {@link ByteEntityAccumuloElementConverter#getEntityFromKey(Key, byte[])}.
   *
   * <p>Method under test: {@link ByteEntityAccumuloElementConverter#getEntityFromKey(Key, byte[])}
   */
  @Test
  @DisplayName("Test getEntityFromKey(Key, byte[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity ByteEntityAccumuloElementConverter.getEntityFromKey(Key, byte[])"})
  void testGetEntityFromKey2() throws UnsupportedEncodingException {
    // Arrange
    Schema schema = mock(Schema.class);
    when(schema.getElement(Mockito.<String>any()))
        .thenThrow(new AccumuloElementConversionException("An error occurred"));
    when(schema.getConfig(Mockito.<String>any())).thenReturn("Config");
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.getVertexSerialiser()).thenReturn(new FreqMapSerialiser());
    ByteEntityAccumuloElementConverter byteEntityAccumuloElementConverter =
        new ByteEntityAccumuloElementConverter(schema);

    ByteSequence byteSequence = mock(ByteSequence.class);
    when(byteSequence.getBackingArray()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    Key key = mock(Key.class);
    when(key.getColumnQualifierData()).thenReturn(new ArrayByteSequence("foo"));
    when(key.getColumnFamilyData()).thenReturn(byteSequence);

    // Act and Assert
    assertThrows(
        AccumuloElementConversionException.class,
        () ->
            byteEntityAccumuloElementConverter.getEntityFromKey(key, "AXAXAXAX".getBytes("UTF-8")));
    verify(byteSequence).getBackingArray();
    verify(key).getColumnFamilyData();
    verify(key).getColumnQualifierData();
    verify(schema).getAggregatedGroups();
    verify(schema).getConfig("timestampProperty");
    verify(schema).getElement("AXAXAXAX");
    verify(schema).getVertexSerialiser();
  }

  /**
   * Test {@link ByteEntityAccumuloElementConverter#getEntityFromKey(Key, byte[])}.
   *
   * <p>Method under test: {@link ByteEntityAccumuloElementConverter#getEntityFromKey(Key, byte[])}
   */
  @Test
  @DisplayName("Test getEntityFromKey(Key, byte[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity ByteEntityAccumuloElementConverter.getEntityFromKey(Key, byte[])"})
  void testGetEntityFromKey3() throws UnsupportedEncodingException {
    // Arrange
    Schema schema = mock(Schema.class);
    when(schema.getElement(Mockito.<String>any())).thenReturn(new SchemaEdgeDefinition());
    when(schema.getConfig(Mockito.<String>any())).thenReturn("Config");
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.getVertexSerialiser()).thenReturn(new FreqMapSerialiser());
    ByteEntityAccumuloElementConverter byteEntityAccumuloElementConverter =
        new ByteEntityAccumuloElementConverter(schema);

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
        () ->
            byteEntityAccumuloElementConverter.getEntityFromKey(key, "AXAXAXAX".getBytes("UTF-8")));
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
   * Test {@link ByteEntityAccumuloElementConverter#getEntityFromKey(Key, byte[])}.
   *
   * <p>Method under test: {@link ByteEntityAccumuloElementConverter#getEntityFromKey(Key, byte[])}
   */
  @Test
  @DisplayName("Test getEntityFromKey(Key, byte[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity ByteEntityAccumuloElementConverter.getEntityFromKey(Key, byte[])"})
  void testGetEntityFromKey4() throws UnsupportedEncodingException {
    // Arrange
    Schema schema = mock(Schema.class);
    when(schema.getVisibilityProperty())
        .thenThrow(new AccumuloElementConversionException("An error occurred"));
    when(schema.getElement(Mockito.<String>any())).thenReturn(new SchemaEdgeDefinition());
    when(schema.getConfig(Mockito.<String>any())).thenReturn("Config");
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.getVertexSerialiser()).thenReturn(new FreqMapSerialiser());
    ByteEntityAccumuloElementConverter byteEntityAccumuloElementConverter =
        new ByteEntityAccumuloElementConverter(schema);

    ByteSequence byteSequence = mock(ByteSequence.class);
    when(byteSequence.getBackingArray()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    Key key = mock(Key.class);
    when(key.getColumnVisibilityData()).thenReturn(new ArrayByteSequence("foo"));
    when(key.getColumnQualifierData()).thenReturn(new ArrayByteSequence("foo"));
    when(key.getColumnFamilyData()).thenReturn(byteSequence);

    // Act and Assert
    assertThrows(
        AccumuloElementConversionException.class,
        () ->
            byteEntityAccumuloElementConverter.getEntityFromKey(key, "AXAXAXAX".getBytes("UTF-8")));
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
   * Test {@link ByteEntityAccumuloElementConverter#getEntityFromKey(Key, byte[])}.
   *
   * <p>Method under test: {@link ByteEntityAccumuloElementConverter#getEntityFromKey(Key, byte[])}
   */
  @Test
  @DisplayName("Test getEntityFromKey(Key, byte[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity ByteEntityAccumuloElementConverter.getEntityFromKey(Key, byte[])"})
  void testGetEntityFromKey5() throws UnsupportedEncodingException {
    // Arrange
    Schema schema = mock(Schema.class);
    when(schema.getVisibilityProperty()).thenReturn("Visibility Property");
    when(schema.getElement(Mockito.<String>any())).thenReturn(new SchemaEdgeDefinition());
    when(schema.getConfig(Mockito.<String>any())).thenReturn("Config");
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.getVertexSerialiser()).thenReturn(new FreqMapSerialiser());
    ByteEntityAccumuloElementConverter byteEntityAccumuloElementConverter =
        new ByteEntityAccumuloElementConverter(schema);

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
        () ->
            byteEntityAccumuloElementConverter.getEntityFromKey(key, "AXAXAXAX".getBytes("UTF-8")));
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
   * Test {@link ByteEntityAccumuloElementConverter#getEntityFromKey(Key, byte[])}.
   *
   * <p>Method under test: {@link ByteEntityAccumuloElementConverter#getEntityFromKey(Key, byte[])}
   */
  @Test
  @DisplayName("Test getEntityFromKey(Key, byte[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity ByteEntityAccumuloElementConverter.getEntityFromKey(Key, byte[])"})
  void testGetEntityFromKey6() throws UnsupportedEncodingException {
    // Arrange
    SchemaEdgeDefinition schemaEdgeDefinition = mock(SchemaEdgeDefinition.class);
    when(schemaEdgeDefinition.getGroupBy())
        .thenThrow(new AccumuloElementConversionException("An error occurred"));

    Schema schema = mock(Schema.class);
    when(schema.getElement(Mockito.<String>any())).thenReturn(schemaEdgeDefinition);
    when(schema.getConfig(Mockito.<String>any())).thenReturn("Config");
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.getVertexSerialiser()).thenReturn(new FreqMapSerialiser());
    ByteEntityAccumuloElementConverter byteEntityAccumuloElementConverter =
        new ByteEntityAccumuloElementConverter(schema);

    ByteSequence byteSequence = mock(ByteSequence.class);
    when(byteSequence.getBackingArray()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    Key key = mock(Key.class);
    when(key.getColumnQualifierData()).thenReturn(new ArrayByteSequence("foo"));
    when(key.getColumnFamilyData()).thenReturn(byteSequence);

    // Act and Assert
    assertThrows(
        AccumuloElementConversionException.class,
        () ->
            byteEntityAccumuloElementConverter.getEntityFromKey(key, "AXAXAXAX".getBytes("UTF-8")));
    verify(byteSequence).getBackingArray();
    verify(key).getColumnFamilyData();
    verify(key).getColumnQualifierData();
    verify(schema).getAggregatedGroups();
    verify(schema).getConfig("timestampProperty");
    verify(schema).getElement("AXAXAXAX");
    verify(schema).getVertexSerialiser();
    verify(schemaEdgeDefinition).getGroupBy();
  }

  /**
   * Test {@link ByteEntityAccumuloElementConverter#getEntityFromKey(Key, byte[])}.
   *
   * <ul>
   *   <li>Given {@link Schema} {@link Schema#getElement(String)} return {@code null}.
   *   <li>Then calls {@link Schema#getElement(String)}.
   * </ul>
   *
   * <p>Method under test: {@link ByteEntityAccumuloElementConverter#getEntityFromKey(Key, byte[])}
   */
  @Test
  @DisplayName(
      "Test getEntityFromKey(Key, byte[]); given Schema getElement(String) return 'null'; then calls getElement(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity ByteEntityAccumuloElementConverter.getEntityFromKey(Key, byte[])"})
  void testGetEntityFromKey_givenSchemaGetElementReturnNull_thenCallsGetElement()
      throws UnsupportedEncodingException {
    // Arrange
    Schema schema = mock(Schema.class);
    when(schema.getElement(Mockito.<String>any())).thenReturn(null);
    when(schema.getConfig(Mockito.<String>any())).thenReturn("Config");
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.getVertexSerialiser()).thenReturn(new FreqMapSerialiser());
    ByteEntityAccumuloElementConverter byteEntityAccumuloElementConverter =
        new ByteEntityAccumuloElementConverter(schema);

    ByteSequence byteSequence = mock(ByteSequence.class);
    when(byteSequence.getBackingArray()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    Key key = mock(Key.class);
    when(key.getColumnQualifierData()).thenReturn(new ArrayByteSequence("foo"));
    when(key.getColumnFamilyData()).thenReturn(byteSequence);

    // Act and Assert
    assertThrows(
        AccumuloElementConversionException.class,
        () ->
            byteEntityAccumuloElementConverter.getEntityFromKey(key, "AXAXAXAX".getBytes("UTF-8")));
    verify(byteSequence).getBackingArray();
    verify(key).getColumnFamilyData();
    verify(key).getColumnQualifierData();
    verify(schema).getAggregatedGroups();
    verify(schema).getConfig("timestampProperty");
    verify(schema).getElement("AXAXAXAX");
    verify(schema).getVertexSerialiser();
  }

  /**
   * Test {@link ByteEntityAccumuloElementConverter#getEntityFromKey(Key, byte[])}.
   *
   * <ul>
   *   <li>Given {@link Schema} {@link Schema#getVertexSerialiser()} return {@link AvroSerialiser}
   *       (default constructor).
   *   <li>When {@link Key#Key()}.
   * </ul>
   *
   * <p>Method under test: {@link ByteEntityAccumuloElementConverter#getEntityFromKey(Key, byte[])}
   */
  @Test
  @DisplayName(
      "Test getEntityFromKey(Key, byte[]); given Schema getVertexSerialiser() return AvroSerialiser (default constructor); when Key()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity ByteEntityAccumuloElementConverter.getEntityFromKey(Key, byte[])"})
  void testGetEntityFromKey_givenSchemaGetVertexSerialiserReturnAvroSerialiser_whenKey()
      throws UnsupportedEncodingException {
    // Arrange
    Schema schema = mock(Schema.class);
    when(schema.getConfig(Mockito.<String>any())).thenReturn("Config");
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.getVertexSerialiser()).thenReturn(new AvroSerialiser());
    ByteEntityAccumuloElementConverter byteEntityAccumuloElementConverter =
        new ByteEntityAccumuloElementConverter(schema);

    // Act and Assert
    assertThrows(
        AccumuloElementConversionException.class,
        () ->
            byteEntityAccumuloElementConverter.getEntityFromKey(
                new Key(), "AXAXAXAX".getBytes("UTF-8")));
    verify(schema).getAggregatedGroups();
    verify(schema).getConfig("timestampProperty");
    verify(schema).getVertexSerialiser();
  }

  /**
   * Test {@link ByteEntityAccumuloElementConverter#getEntityFromKey(Key, byte[])}.
   *
   * <ul>
   *   <li>Given ten.
   *   <li>When {@link Key} {@link Key#getTimestamp()} return ten.
   *   <li>Then Vertex return {@link Map}.
   * </ul>
   *
   * <p>Method under test: {@link ByteEntityAccumuloElementConverter#getEntityFromKey(Key, byte[])}
   */
  @Test
  @DisplayName(
      "Test getEntityFromKey(Key, byte[]); given ten; when Key getTimestamp() return ten; then Vertex return Map")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity ByteEntityAccumuloElementConverter.getEntityFromKey(Key, byte[])"})
  void testGetEntityFromKey_givenTen_whenKeyGetTimestampReturnTen_thenVertexReturnMap()
      throws UnsupportedEncodingException {
    // Arrange
    Schema schema = mock(Schema.class);
    when(schema.getVisibilityProperty()).thenReturn("Visibility Property");
    when(schema.getElement(Mockito.<String>any())).thenReturn(new SchemaEdgeDefinition());
    when(schema.getConfig(Mockito.<String>any())).thenReturn("Config");
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.getVertexSerialiser()).thenReturn(new FreqMapSerialiser());
    ByteEntityAccumuloElementConverter byteEntityAccumuloElementConverter =
        new ByteEntityAccumuloElementConverter(schema);

    ByteSequence byteSequence = mock(ByteSequence.class);
    when(byteSequence.getBackingArray()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    Key key = mock(Key.class);
    when(key.getTimestamp()).thenReturn(10L);
    when(key.getColumnVisibilityData()).thenReturn(new ArrayByteSequence("foo"));
    when(key.getColumnQualifierData()).thenReturn(new ArrayByteSequence("foo"));
    when(key.getColumnFamilyData()).thenReturn(byteSequence);

    // Act
    Entity actualEntityFromKey =
        byteEntityAccumuloElementConverter.getEntityFromKey(key, "AXAXAXAX".getBytes("UTF-8"));

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
   * Test {@link ByteEntityAccumuloElementConverter#getEntityFromKey(Key, byte[])}.
   *
   * <ul>
   *   <li>Then calls {@link SchemaEdgeDefinition#getPropertyTypeDef(String)}.
   * </ul>
   *
   * <p>Method under test: {@link ByteEntityAccumuloElementConverter#getEntityFromKey(Key, byte[])}
   */
  @Test
  @DisplayName("Test getEntityFromKey(Key, byte[]); then calls getPropertyTypeDef(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity ByteEntityAccumuloElementConverter.getEntityFromKey(Key, byte[])"})
  void testGetEntityFromKey_thenCallsGetPropertyTypeDef() throws UnsupportedEncodingException {
    // Arrange
    Builder builder = new Builder();
    builder.serialiser(new AvroSerialiser());
    TypeDefinition typeDefinition = builder.aggregateFunction(mock(BinaryOperator.class)).build();

    SchemaEdgeDefinition schemaEdgeDefinition = mock(SchemaEdgeDefinition.class);
    when(schemaEdgeDefinition.getGroupBy()).thenReturn(new HashSet<>());
    when(schemaEdgeDefinition.getPropertyTypeDef(Mockito.<String>any())).thenReturn(typeDefinition);

    Schema schema = mock(Schema.class);
    when(schema.getVisibilityProperty()).thenReturn("Visibility Property");
    when(schema.getElement(Mockito.<String>any())).thenReturn(schemaEdgeDefinition);
    when(schema.getConfig(Mockito.<String>any())).thenReturn("Config");
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.getVertexSerialiser()).thenReturn(new FreqMapSerialiser());
    ByteEntityAccumuloElementConverter byteEntityAccumuloElementConverter =
        new ByteEntityAccumuloElementConverter(schema);

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
        () ->
            byteEntityAccumuloElementConverter.getEntityFromKey(key, "AXAXAXAX".getBytes("UTF-8")));
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
    verify(schemaEdgeDefinition).getGroupBy();
    verify(schemaEdgeDefinition).getPropertyTypeDef("Visibility Property");
  }

  /**
   * Test {@link ByteEntityAccumuloElementConverter#getEntityFromKey(Key, byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with {@code A} and zero.
   * </ul>
   *
   * <p>Method under test: {@link ByteEntityAccumuloElementConverter#getEntityFromKey(Key, byte[])}
   */
  @Test
  @DisplayName("Test getEntityFromKey(Key, byte[]); when array of byte with 'A' and zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity ByteEntityAccumuloElementConverter.getEntityFromKey(Key, byte[])"})
  void testGetEntityFromKey_whenArrayOfByteWithAAndZero() throws UnsupportedEncodingException {
    // Arrange
    Schema schema = mock(Schema.class);
    when(schema.getConfig(Mockito.<String>any())).thenReturn("Config");
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.getVertexSerialiser()).thenReturn(new FreqMapSerialiser());
    ByteEntityAccumuloElementConverter byteEntityAccumuloElementConverter =
        new ByteEntityAccumuloElementConverter(schema);

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
            byteEntityAccumuloElementConverter.getEntityFromKey(
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
   * Test {@link ByteEntityAccumuloElementConverter#getEntityFromKey(Key, byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with zero and {@code X}.
   * </ul>
   *
   * <p>Method under test: {@link ByteEntityAccumuloElementConverter#getEntityFromKey(Key, byte[])}
   */
  @Test
  @DisplayName("Test getEntityFromKey(Key, byte[]); when array of byte with zero and 'X'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity ByteEntityAccumuloElementConverter.getEntityFromKey(Key, byte[])"})
  void testGetEntityFromKey_whenArrayOfByteWithZeroAndX() throws UnsupportedEncodingException {
    // Arrange
    Schema schema = mock(Schema.class);
    when(schema.getConfig(Mockito.<String>any())).thenReturn("Config");
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.getVertexSerialiser()).thenReturn(new FreqMapSerialiser());
    ByteEntityAccumuloElementConverter byteEntityAccumuloElementConverter =
        new ByteEntityAccumuloElementConverter(schema);

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
            byteEntityAccumuloElementConverter.getEntityFromKey(
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
   * Test {@link ByteEntityAccumuloElementConverter#getEntityFromKey(Key, byte[])}.
   *
   * <ul>
   *   <li>When {@link Key} {@link Key#getColumnFamilyData()} return {@link
   *       ArrayByteSequence#ArrayByteSequence(String)} with s is {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link ByteEntityAccumuloElementConverter#getEntityFromKey(Key, byte[])}
   */
  @Test
  @DisplayName(
      "Test getEntityFromKey(Key, byte[]); when Key getColumnFamilyData() return ArrayByteSequence(String) with s is 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity ByteEntityAccumuloElementConverter.getEntityFromKey(Key, byte[])"})
  void testGetEntityFromKey_whenKeyGetColumnFamilyDataReturnArrayByteSequenceWithSIsFoo()
      throws UnsupportedEncodingException {
    // Arrange
    Schema schema = mock(Schema.class);
    when(schema.getConfig(Mockito.<String>any())).thenReturn("Config");
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.getVertexSerialiser()).thenReturn(new AvroSerialiser());
    ByteEntityAccumuloElementConverter byteEntityAccumuloElementConverter =
        new ByteEntityAccumuloElementConverter(schema);

    Key key = mock(Key.class);
    when(key.getColumnFamilyData()).thenReturn(new ArrayByteSequence("foo"));

    // Act and Assert
    assertThrows(
        AccumuloElementConversionException.class,
        () ->
            byteEntityAccumuloElementConverter.getEntityFromKey(key, "AXAXAXAX".getBytes("UTF-8")));
    verify(key).getColumnFamilyData();
    verify(schema).getAggregatedGroups();
    verify(schema).getConfig("timestampProperty");
    verify(schema).getVertexSerialiser();
  }

  /**
   * Test {@link ByteEntityAccumuloElementConverter#getSourceAndDestinationFromRowKey(byte[],
   * byte[][])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with zero and zero.
   * </ul>
   *
   * <p>Method under test: {@link
   * ByteEntityAccumuloElementConverter#getSourceAndDestinationFromRowKey(byte[], byte[][])}
   */
  @Test
  @DisplayName(
      "Test getSourceAndDestinationFromRowKey(byte[], byte[][]); when array of byte with zero and zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EdgeDirection ByteEntityAccumuloElementConverter.getSourceAndDestinationFromRowKey(byte[], byte[][])"
  })
  void testGetSourceAndDestinationFromRowKey_whenArrayOfByteWithZeroAndZero()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertThrows(
        AccumuloElementConversionException.class,
        () ->
            new ByteEntityAccumuloElementConverter(new Schema())
                .getSourceAndDestinationFromRowKey(
                    new byte[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    new byte[][] {"AXAXAXAX".getBytes("UTF-8")}));
  }

  /**
   * Test {@link ByteEntityAccumuloElementConverter#getSourceAndDestinationFromRowKey(byte[],
   * byte[][])}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ByteEntityAccumuloElementConverter#getSourceAndDestinationFromRowKey(byte[], byte[][])}
   */
  @Test
  @DisplayName(
      "Test getSourceAndDestinationFromRowKey(byte[], byte[][]); when 'AXAXAXAX' Bytes is 'UTF-8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EdgeDirection ByteEntityAccumuloElementConverter.getSourceAndDestinationFromRowKey(byte[], byte[][])"
  })
  void testGetSourceAndDestinationFromRowKey_whenAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertThrows(
        AccumuloElementConversionException.class,
        () ->
            new ByteEntityAccumuloElementConverter(new Schema())
                .getSourceAndDestinationFromRowKey(
                    "AXAXAXAX".getBytes("UTF-8"), new byte[][] {"AXAXAXAX".getBytes("UTF-8")}));
  }
}
