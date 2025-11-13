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
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Map;
import org.apache.accumulo.core.data.ArrayByteSequence;
import org.apache.accumulo.core.data.Key;
import org.apache.accumulo.core.data.Value;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uk.gov.gchq.gaffer.accumulostore.AccumuloProperties;
import uk.gov.gchq.gaffer.accumulostore.key.core.impl.byteEntity.ByteEntityAccumuloElementConverter;
import uk.gov.gchq.gaffer.accumulostore.key.exception.AccumuloElementConversionException;
import uk.gov.gchq.gaffer.accumulostore.utils.BytesAndRange;
import uk.gov.gchq.gaffer.commonutil.pair.Pair;
import uk.gov.gchq.gaffer.data.element.Edge;
import uk.gov.gchq.gaffer.data.element.Edge.Builder;
import uk.gov.gchq.gaffer.data.element.Element;
import uk.gov.gchq.gaffer.data.element.ElementValueLoader;
import uk.gov.gchq.gaffer.data.element.Entity;
import uk.gov.gchq.gaffer.data.element.LazyEntity;
import uk.gov.gchq.gaffer.data.element.Properties;
import uk.gov.gchq.gaffer.data.element.id.EdgeId;
import uk.gov.gchq.gaffer.data.element.id.EdgeId.MatchedVertex;
import uk.gov.gchq.gaffer.data.element.id.ElementId;
import uk.gov.gchq.gaffer.exception.SerialisationException;
import uk.gov.gchq.gaffer.operation.data.EntitySeed;
import uk.gov.gchq.gaffer.serialisation.AvroSerialiser;
import uk.gov.gchq.gaffer.serialisation.FreqMapSerialiser;
import uk.gov.gchq.gaffer.serialisation.TypeSubTypeValueSerialiser;
import uk.gov.gchq.gaffer.store.schema.Schema;
import uk.gov.gchq.gaffer.store.schema.SchemaEdgeDefinition;
import uk.gov.gchq.gaffer.store.schema.SchemaElementDefinition;
import uk.gov.gchq.gaffer.types.TypeSubTypeValue;

class AbstractCoreKeyAccumuloElementConverterDiffblueTest {
  /**
   * Test {@link AbstractCoreKeyAccumuloElementConverter#getElementId(Key, boolean)}.
   * <ul>
   *   <li>Then return Vertex {@code A} longValue is sixty-five.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractCoreKeyAccumuloElementConverter#getElementId(Key, boolean)}
   */
  @Test
  @DisplayName("Test getElementId(Key, boolean); then return Vertex 'A' longValue is sixty-five")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ElementId AbstractCoreKeyAccumuloElementConverter.getElementId(Key, boolean)"})
  void testGetElementId_thenReturnVertexALongValueIsSixtyFive() {
    // Arrange
    Schema schema = mock(Schema.class);
    when(schema.getConfig(Mockito.<String>any())).thenReturn("Config");
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.getVertexSerialiser()).thenReturn(new FreqMapSerialiser());
    ByteEntityAccumuloElementConverter byteEntityAccumuloElementConverter = new ByteEntityAccumuloElementConverter(
        schema);
    ArrayByteSequence arrayByteSequence = mock(ArrayByteSequence.class);
    when(arrayByteSequence.getBackingArray())
        .thenReturn(new byte[]{'A', 0, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1});
    Key key = mock(Key.class);
    when(key.getRowData()).thenReturn(arrayByteSequence);

    // Act
    ElementId actualElementId = byteEntityAccumuloElementConverter.getElementId(key, true);

    // Assert
    verify(arrayByteSequence).getBackingArray();
    verify(key).getRowData();
    verify(schema).getAggregatedGroups();
    verify(schema).getConfig(eq("timestampProperty"));
    verify(schema).getVertexSerialiser();
    Object vertex = ((EntitySeed) actualElementId).getVertex();
    assertTrue(vertex instanceof Map);
    assertTrue(actualElementId instanceof EntitySeed);
    assertEquals("uk.gov.gchq.gaffer.operation.data.EntitySeed", actualElementId.getClassName());
    assertEquals(1, ((Map<String, Long>) vertex).size());
    assertEquals(65L, ((Map<String, Long>) vertex).get("A").longValue());
  }

  /**
   * Test {@link AbstractCoreKeyAccumuloElementConverter#getElementId(Key, boolean)}.
   * <ul>
   *   <li>Then return Vertex Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractCoreKeyAccumuloElementConverter#getElementId(Key, boolean)}
   */
  @Test
  @DisplayName("Test getElementId(Key, boolean); then return Vertex Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ElementId AbstractCoreKeyAccumuloElementConverter.getElementId(Key, boolean)"})
  void testGetElementId_thenReturnVertexEmpty() {
    // Arrange
    Schema schema = mock(Schema.class);
    when(schema.getConfig(Mockito.<String>any())).thenReturn("Config");
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.getVertexSerialiser()).thenReturn(new FreqMapSerialiser());
    ByteEntityAccumuloElementConverter byteEntityAccumuloElementConverter = new ByteEntityAccumuloElementConverter(
        schema);
    ArrayByteSequence arrayByteSequence = mock(ArrayByteSequence.class);
    when(arrayByteSequence.getBackingArray())
        .thenReturn(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1});
    Key key = mock(Key.class);
    when(key.getRowData()).thenReturn(arrayByteSequence);

    // Act
    ElementId actualElementId = byteEntityAccumuloElementConverter.getElementId(key, true);

    // Assert
    verify(arrayByteSequence).getBackingArray();
    verify(key).getRowData();
    verify(schema).getAggregatedGroups();
    verify(schema).getConfig(eq("timestampProperty"));
    verify(schema).getVertexSerialiser();
    Object vertex = ((EntitySeed) actualElementId).getVertex();
    assertTrue(vertex instanceof Map);
    assertTrue(actualElementId instanceof EntitySeed);
    assertEquals("uk.gov.gchq.gaffer.operation.data.EntitySeed", actualElementId.getClassName());
    assertTrue(((Map<Object, Object>) vertex).isEmpty());
  }

  /**
   * Test {@link AbstractCoreKeyAccumuloElementConverter#getElementId(Key, boolean)}.
   * <ul>
   *   <li>Then return Vertex empty string longValue is sixty-five.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractCoreKeyAccumuloElementConverter#getElementId(Key, boolean)}
   */
  @Test
  @DisplayName("Test getElementId(Key, boolean); then return Vertex empty string longValue is sixty-five")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ElementId AbstractCoreKeyAccumuloElementConverter.getElementId(Key, boolean)"})
  void testGetElementId_thenReturnVertexEmptyStringLongValueIsSixtyFive() {
    // Arrange
    Schema schema = mock(Schema.class);
    when(schema.getConfig(Mockito.<String>any())).thenReturn("Config");
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.getVertexSerialiser()).thenReturn(new FreqMapSerialiser());
    ByteEntityAccumuloElementConverter byteEntityAccumuloElementConverter = new ByteEntityAccumuloElementConverter(
        schema);
    ArrayByteSequence arrayByteSequence = mock(ArrayByteSequence.class);
    when(arrayByteSequence.getBackingArray())
        .thenReturn(new byte[]{1, 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1});
    Key key = mock(Key.class);
    when(key.getRowData()).thenReturn(arrayByteSequence);

    // Act
    ElementId actualElementId = byteEntityAccumuloElementConverter.getElementId(key, true);

    // Assert
    verify(arrayByteSequence).getBackingArray();
    verify(key).getRowData();
    verify(schema).getAggregatedGroups();
    verify(schema).getConfig(eq("timestampProperty"));
    verify(schema).getVertexSerialiser();
    Object vertex = ((EntitySeed) actualElementId).getVertex();
    assertTrue(vertex instanceof Map);
    assertTrue(actualElementId instanceof EntitySeed);
    assertEquals("uk.gov.gchq.gaffer.operation.data.EntitySeed", actualElementId.getClassName());
    assertEquals(1, ((Map<String, Long>) vertex).size());
    assertEquals(65L, ((Map<String, Long>) vertex).get("").longValue());
  }

  /**
   * Test {@link AbstractCoreKeyAccumuloElementConverter#getElementId(Key, boolean)}.
   * <ul>
   *   <li>Then Vertex return {@link TypeSubTypeValue}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractCoreKeyAccumuloElementConverter#getElementId(Key, boolean)}
   */
  @Test
  @DisplayName("Test getElementId(Key, boolean); then Vertex return TypeSubTypeValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ElementId AbstractCoreKeyAccumuloElementConverter.getElementId(Key, boolean)"})
  void testGetElementId_thenVertexReturnTypeSubTypeValue() {
    // Arrange
    Schema schema = mock(Schema.class);
    when(schema.getConfig(Mockito.<String>any())).thenReturn("Config");
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.getVertexSerialiser()).thenReturn(new TypeSubTypeValueSerialiser());
    ByteEntityAccumuloElementConverter byteEntityAccumuloElementConverter = new ByteEntityAccumuloElementConverter(
        schema);
    ArrayByteSequence arrayByteSequence = mock(ArrayByteSequence.class);
    when(arrayByteSequence.getBackingArray())
        .thenReturn(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1});
    Key key = mock(Key.class);
    when(key.getRowData()).thenReturn(arrayByteSequence);

    // Act
    ElementId actualElementId = byteEntityAccumuloElementConverter.getElementId(key, true);

    // Assert
    verify(arrayByteSequence).getBackingArray();
    verify(key).getRowData();
    verify(schema).getAggregatedGroups();
    verify(schema).getConfig(eq("timestampProperty"));
    verify(schema).getVertexSerialiser();
    assertTrue(actualElementId instanceof EntitySeed);
    Object vertex = ((EntitySeed) actualElementId).getVertex();
    assertTrue(vertex instanceof TypeSubTypeValue);
    assertEquals("AAAAAAA", ((TypeSubTypeValue) vertex).getValue());
    assertNull(((TypeSubTypeValue) vertex).getSubType());
    assertNull(((TypeSubTypeValue) vertex).getType());
  }

  /**
   * Test {@link AbstractCoreKeyAccumuloElementConverter#getKeysFromElement(Element)}.
   * <ul>
   *   <li>Given {@link Schema} {@link Schema#getElement(String)} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractCoreKeyAccumuloElementConverter#getKeysFromElement(Element)}
   */
  @Test
  @DisplayName("Test getKeysFromElement(Element); given Schema getElement(String) return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Pair AbstractCoreKeyAccumuloElementConverter.getKeysFromElement(Element)"})
  void testGetKeysFromElement_givenSchemaGetElementReturnNull()
      throws UnsupportedEncodingException, SerialisationException {
    // Arrange
    AvroSerialiser avroSerialiser = mock(AvroSerialiser.class);
    when(avroSerialiser.serialise(Mockito.<Object>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    Schema schema = mock(Schema.class);
    when(schema.getElement(Mockito.<String>any())).thenReturn(null);
    when(schema.getConfig(Mockito.<String>any())).thenReturn("Config");
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.getVertexSerialiser()).thenReturn(avroSerialiser);
    ByteEntityAccumuloElementConverter byteEntityAccumuloElementConverter = new ByteEntityAccumuloElementConverter(
        schema);
    Entity element = (new Entity.Builder()).group("Group").vertex("Vertex").build();

    // Act and Assert
    assertThrows(AccumuloElementConversionException.class,
        () -> byteEntityAccumuloElementConverter.getKeysFromElement(element));
    verify(avroSerialiser).serialise(isA(Object.class));
    verify(schema).getAggregatedGroups();
    verify(schema).getConfig(eq("timestampProperty"));
    verify(schema).getElement(eq("Group"));
    verify(schema).getVertexSerialiser();
  }

  /**
   * Test {@link AbstractCoreKeyAccumuloElementConverter#getKeysFromElement(Element)}.
   * <ul>
   *   <li>Then calls {@link SchemaElementDefinition#getGroupBy()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractCoreKeyAccumuloElementConverter#getKeysFromElement(Element)}
   */
  @Test
  @DisplayName("Test getKeysFromElement(Element); then calls getGroupBy()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Pair AbstractCoreKeyAccumuloElementConverter.getKeysFromElement(Element)"})
  void testGetKeysFromElement_thenCallsGetGroupBy() throws SerialisationException {
    // Arrange
    AvroSerialiser avroSerialiser = mock(AvroSerialiser.class);
    when(avroSerialiser.serialise(Mockito.<Object>any())).thenReturn(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});
    SchemaElementDefinition schemaElementDefinition = mock(SchemaElementDefinition.class);
    when(schemaElementDefinition.getGroupBy()).thenThrow(new AccumuloElementConversionException("An error occurred"));
    Schema schema = mock(Schema.class);
    when(schema.getElement(Mockito.<String>any())).thenReturn(schemaElementDefinition);
    when(schema.getConfig(Mockito.<String>any())).thenReturn("Config");
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.getVertexSerialiser()).thenReturn(avroSerialiser);
    ByteEntityAccumuloElementConverter byteEntityAccumuloElementConverter = new ByteEntityAccumuloElementConverter(
        schema);
    Entity element = (new Entity.Builder()).group("Group").vertex("Vertex").build();

    // Act and Assert
    assertThrows(AccumuloElementConversionException.class,
        () -> byteEntityAccumuloElementConverter.getKeysFromElement(element));
    verify(avroSerialiser).serialise(isA(Object.class));
    verify(schema).getAggregatedGroups();
    verify(schema).getConfig(eq("timestampProperty"));
    verify(schema).getElement(eq("Group"));
    verify(schema).getVertexSerialiser();
    verify(schemaElementDefinition).getGroupBy();
  }

  /**
   * Test {@link AbstractCoreKeyAccumuloElementConverter#getKeysFromElement(Element)}.
   * <ul>
   *   <li>Then calls {@link Schema#getVisibilityProperty()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractCoreKeyAccumuloElementConverter#getKeysFromElement(Element)}
   */
  @Test
  @DisplayName("Test getKeysFromElement(Element); then calls getVisibilityProperty()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Pair AbstractCoreKeyAccumuloElementConverter.getKeysFromElement(Element)"})
  void testGetKeysFromElement_thenCallsGetVisibilityProperty()
      throws UnsupportedEncodingException, SerialisationException {
    // Arrange
    AvroSerialiser avroSerialiser = mock(AvroSerialiser.class);
    when(avroSerialiser.serialise(Mockito.<Object>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    Schema schema = mock(Schema.class);
    when(schema.getVisibilityProperty()).thenThrow(new AccumuloElementConversionException("An error occurred"));
    when(schema.getElement(Mockito.<String>any())).thenReturn(new SchemaEdgeDefinition());
    when(schema.getConfig(Mockito.<String>any())).thenReturn("Config");
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.getVertexSerialiser()).thenReturn(avroSerialiser);
    ByteEntityAccumuloElementConverter byteEntityAccumuloElementConverter = new ByteEntityAccumuloElementConverter(
        schema);
    Entity element = (new Entity.Builder()).group("Group").vertex("Vertex").build();

    // Act and Assert
    assertThrows(AccumuloElementConversionException.class,
        () -> byteEntityAccumuloElementConverter.getKeysFromElement(element));
    verify(avroSerialiser).serialise(isA(Object.class));
    verify(schema).getAggregatedGroups();
    verify(schema).getConfig(eq("timestampProperty"));
    verify(schema, atLeast(1)).getElement(eq("Group"));
    verify(schema).getVertexSerialiser();
    verify(schema).getVisibilityProperty();
  }

  /**
   * Test {@link AbstractCoreKeyAccumuloElementConverter#getKeysFromEdge(Edge)}.
   * <ul>
   *   <li>Given {@link Schema} {@link Schema#getElement(String)} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractCoreKeyAccumuloElementConverter#getKeysFromEdge(Edge)}
   */
  @Test
  @DisplayName("Test getKeysFromEdge(Edge); given Schema getElement(String) return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Pair AbstractCoreKeyAccumuloElementConverter.getKeysFromEdge(Edge)"})
  void testGetKeysFromEdge_givenSchemaGetElementReturnNull()
      throws UnsupportedEncodingException, SerialisationException {
    // Arrange
    AvroSerialiser avroSerialiser = mock(AvroSerialiser.class);
    when(avroSerialiser.serialise(Mockito.<Object>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    Schema schema = mock(Schema.class);
    when(schema.getElement(Mockito.<String>any())).thenReturn(null);
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

    // Act and Assert
    assertThrows(AccumuloElementConversionException.class,
        () -> byteEntityAccumuloElementConverter.getKeysFromEdge(edge));
    verify(avroSerialiser, atLeast(1)).serialise(Mockito.<Object>any());
    verify(schema).getAggregatedGroups();
    verify(schema).getConfig(eq("timestampProperty"));
    verify(schema).getElement(eq("Group"));
    verify(schema, atLeast(1)).getVertexSerialiser();
  }

  /**
   * Test {@link AbstractCoreKeyAccumuloElementConverter#getKeysFromEdge(Edge)}.
   * <ul>
   *   <li>Then calls {@link SchemaElementDefinition#getGroupBy()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractCoreKeyAccumuloElementConverter#getKeysFromEdge(Edge)}
   */
  @Test
  @DisplayName("Test getKeysFromEdge(Edge); then calls getGroupBy()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Pair AbstractCoreKeyAccumuloElementConverter.getKeysFromEdge(Edge)"})
  void testGetKeysFromEdge_thenCallsGetGroupBy() throws SerialisationException {
    // Arrange
    AvroSerialiser avroSerialiser = mock(AvroSerialiser.class);
    when(avroSerialiser.serialise(Mockito.<Object>any())).thenReturn(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});
    SchemaElementDefinition schemaElementDefinition = mock(SchemaElementDefinition.class);
    when(schemaElementDefinition.getGroupBy()).thenThrow(new AccumuloElementConversionException("An error occurred"));
    Schema schema = mock(Schema.class);
    when(schema.getElement(Mockito.<String>any())).thenReturn(schemaElementDefinition);
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

    // Act and Assert
    assertThrows(AccumuloElementConversionException.class,
        () -> byteEntityAccumuloElementConverter.getKeysFromEdge(edge));
    verify(avroSerialiser, atLeast(1)).serialise(Mockito.<Object>any());
    verify(schema).getAggregatedGroups();
    verify(schema).getConfig(eq("timestampProperty"));
    verify(schema).getElement(eq("Group"));
    verify(schema, atLeast(1)).getVertexSerialiser();
    verify(schemaElementDefinition).getGroupBy();
  }

  /**
   * Test {@link AbstractCoreKeyAccumuloElementConverter#getKeysFromEdge(Edge)}.
   * <ul>
   *   <li>Then calls {@link Schema#getVisibilityProperty()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractCoreKeyAccumuloElementConverter#getKeysFromEdge(Edge)}
   */
  @Test
  @DisplayName("Test getKeysFromEdge(Edge); then calls getVisibilityProperty()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Pair AbstractCoreKeyAccumuloElementConverter.getKeysFromEdge(Edge)"})
  void testGetKeysFromEdge_thenCallsGetVisibilityProperty()
      throws UnsupportedEncodingException, SerialisationException {
    // Arrange
    AvroSerialiser avroSerialiser = mock(AvroSerialiser.class);
    when(avroSerialiser.serialise(Mockito.<Object>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    Schema schema = mock(Schema.class);
    when(schema.getVisibilityProperty()).thenThrow(new AccumuloElementConversionException("An error occurred"));
    when(schema.getElement(Mockito.<String>any())).thenReturn(new SchemaEdgeDefinition());
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

    // Act and Assert
    assertThrows(AccumuloElementConversionException.class,
        () -> byteEntityAccumuloElementConverter.getKeysFromEdge(edge));
    verify(avroSerialiser, atLeast(1)).serialise(Mockito.<Object>any());
    verify(schema).getAggregatedGroups();
    verify(schema).getConfig(eq("timestampProperty"));
    verify(schema, atLeast(1)).getElement(eq("Group"));
    verify(schema, atLeast(1)).getVertexSerialiser();
    verify(schema).getVisibilityProperty();
  }

  /**
   * Test {@link AbstractCoreKeyAccumuloElementConverter#getKeyFromEntity(Entity)}.
   * <ul>
   *   <li>Then throw {@link AccumuloElementConversionException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractCoreKeyAccumuloElementConverter#getKeyFromEntity(Entity)}
   */
  @Test
  @DisplayName("Test getKeyFromEntity(Entity); then throw AccumuloElementConversionException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Key AbstractCoreKeyAccumuloElementConverter.getKeyFromEntity(Entity)"})
  void testGetKeyFromEntity_thenThrowAccumuloElementConversionException() {
    // Arrange
    Schema schema = mock(Schema.class);
    when(schema.getElement(Mockito.<String>any())).thenReturn(null);
    when(schema.getConfig(Mockito.<String>any())).thenReturn("Config");
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.getVertexSerialiser()).thenReturn(new AvroSerialiser());
    ByteEntityAccumuloElementConverter byteEntityAccumuloElementConverter = new ByteEntityAccumuloElementConverter(
        schema);
    ElementValueLoader valueLoader = mock(ElementValueLoader.class);
    doNothing().when(valueLoader).loadIdentifiers(Mockito.<Element>any());
    Entity entity = (new Entity.Builder()).group("Group").vertex("Vertex").build();

    LazyEntity entity2 = new LazyEntity(entity, valueLoader);
    entity2.putProperty("Name", "Value");

    // Act and Assert
    assertThrows(AccumuloElementConversionException.class,
        () -> byteEntityAccumuloElementConverter.getKeyFromEntity(entity2));
    verify(valueLoader).loadIdentifiers(isA(Element.class));
    verify(schema).getAggregatedGroups();
    verify(schema).getConfig(eq("timestampProperty"));
    verify(schema).getElement(eq("Group"));
    verify(schema).getVertexSerialiser();
  }

  /**
   * Test {@link AbstractCoreKeyAccumuloElementConverter#getValueFromProperties(String, Properties)}.
   * <ul>
   *   <li>Then throw {@link AccumuloElementConversionException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractCoreKeyAccumuloElementConverter#getValueFromProperties(String, Properties)}
   */
  @Test
  @DisplayName("Test getValueFromProperties(String, Properties); then throw AccumuloElementConversionException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Value AbstractCoreKeyAccumuloElementConverter.getValueFromProperties(String, Properties)"})
  void testGetValueFromProperties_thenThrowAccumuloElementConversionException() {
    // Arrange
    ByteEntityAccumuloElementConverter byteEntityAccumuloElementConverter = new ByteEntityAccumuloElementConverter(
        new Schema());

    // Act and Assert
    assertThrows(AccumuloElementConversionException.class,
        () -> byteEntityAccumuloElementConverter.getValueFromProperties("Group", new Properties()));
  }

  /**
   * Test {@link AbstractCoreKeyAccumuloElementConverter#getValueFromElement(Element)}.
   * <ul>
   *   <li>Then throw {@link AccumuloElementConversionException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractCoreKeyAccumuloElementConverter#getValueFromElement(Element)}
   */
  @Test
  @DisplayName("Test getValueFromElement(Element); then throw AccumuloElementConversionException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Value AbstractCoreKeyAccumuloElementConverter.getValueFromElement(Element)"})
  void testGetValueFromElement_thenThrowAccumuloElementConversionException() {
    // Arrange
    ByteEntityAccumuloElementConverter byteEntityAccumuloElementConverter = new ByteEntityAccumuloElementConverter(
        new Schema());

    // Act and Assert
    assertThrows(AccumuloElementConversionException.class,
        () -> byteEntityAccumuloElementConverter.getValueFromElement(new Edge("Group")));
  }

  /**
   * Test {@link AbstractCoreKeyAccumuloElementConverter#getPropertiesFromValue(String, Value)}.
   * <ul>
   *   <li>Then throw {@link AccumuloElementConversionException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractCoreKeyAccumuloElementConverter#getPropertiesFromValue(String, Value)}
   */
  @Test
  @DisplayName("Test getPropertiesFromValue(String, Value); then throw AccumuloElementConversionException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Properties AbstractCoreKeyAccumuloElementConverter.getPropertiesFromValue(String, Value)"})
  void testGetPropertiesFromValue_thenThrowAccumuloElementConversionException() {
    // Arrange
    ByteEntityAccumuloElementConverter byteEntityAccumuloElementConverter = new ByteEntityAccumuloElementConverter(
        new Schema());

    // Act and Assert
    assertThrows(AccumuloElementConversionException.class, () -> byteEntityAccumuloElementConverter
        .getPropertiesFromValue("Group", new Value(AccumuloProperties.CLIENT_SIDE_BLOOM_FILTER_SIZE)));
  }

  /**
   * Test {@link AbstractCoreKeyAccumuloElementConverter#getPropertiesFromValue(String, Value)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractCoreKeyAccumuloElementConverter#getPropertiesFromValue(String, Value)}
   */
  @Test
  @DisplayName("Test getPropertiesFromValue(String, Value); when 'null'; then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Properties AbstractCoreKeyAccumuloElementConverter.getPropertiesFromValue(String, Value)"})
  void testGetPropertiesFromValue_whenNull_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue((new ByteEntityAccumuloElementConverter(new Schema())).getPropertiesFromValue("Group", null).isEmpty());
  }

  /**
   * Test {@link AbstractCoreKeyAccumuloElementConverter#getPropertiesFromValue(String, Value)}.
   * <ul>
   *   <li>When {@link Value#Value()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractCoreKeyAccumuloElementConverter#getPropertiesFromValue(String, Value)}
   */
  @Test
  @DisplayName("Test getPropertiesFromValue(String, Value); when Value(); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Properties AbstractCoreKeyAccumuloElementConverter.getPropertiesFromValue(String, Value)"})
  void testGetPropertiesFromValue_whenValue_thenReturnEmpty() {
    // Arrange
    ByteEntityAccumuloElementConverter byteEntityAccumuloElementConverter = new ByteEntityAccumuloElementConverter(
        new Schema());

    // Act and Assert
    assertTrue(byteEntityAccumuloElementConverter.getPropertiesFromValue("Group", new Value()).isEmpty());
  }

  /**
   * Test {@link AbstractCoreKeyAccumuloElementConverter#getRowKeysFromElement(Element)}.
   * <ul>
   *   <li>Then return Second is array of {@code byte} with {@code A} and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractCoreKeyAccumuloElementConverter#getRowKeysFromElement(Element)}
   */
  @Test
  @DisplayName("Test getRowKeysFromElement(Element); then return Second is array of byte with 'A' and 'X'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Pair AbstractCoreKeyAccumuloElementConverter.getRowKeysFromElement(Element)"})
  void testGetRowKeysFromElement_thenReturnSecondIsArrayOfByteWithAAndX()
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
    Edge element = (new Builder()).dest("Dest")
        .directed(true)
        .group("Group")
        .matchedVertex(MatchedVertex.SOURCE)
        .source("Source")
        .build();

    // Act
    Pair<byte[], byte[]> actualRowKeysFromElement = byteEntityAccumuloElementConverter.getRowKeysFromElement(element);

    // Assert
    verify(avroSerialiser, atLeast(1)).serialise(Mockito.<Object>any());
    verify(schema).getAggregatedGroups();
    verify(schema).getConfig(eq("timestampProperty"));
    verify(schema, atLeast(1)).getVertexSerialiser();
    assertArrayEquals(
        new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 2, 0, 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 2},
        actualRowKeysFromElement.getFirst());
    assertArrayEquals(
        new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 3, 0, 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 3},
        actualRowKeysFromElement.getSecond());
  }

  /**
   * Test {@link AbstractCoreKeyAccumuloElementConverter#getRowKeysFromElement(Element)}.
   * <ul>
   *   <li>Then return Second is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractCoreKeyAccumuloElementConverter#getRowKeysFromElement(Element)}
   */
  @Test
  @DisplayName("Test getRowKeysFromElement(Element); then return Second is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Pair AbstractCoreKeyAccumuloElementConverter.getRowKeysFromElement(Element)"})
  void testGetRowKeysFromElement_thenReturnSecondIsNull() throws UnsupportedEncodingException, SerialisationException {
    // Arrange
    AvroSerialiser avroSerialiser = mock(AvroSerialiser.class);
    when(avroSerialiser.serialise(Mockito.<Object>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    Schema schema = mock(Schema.class);
    when(schema.getConfig(Mockito.<String>any())).thenReturn("Config");
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.getVertexSerialiser()).thenReturn(avroSerialiser);
    ByteEntityAccumuloElementConverter byteEntityAccumuloElementConverter = new ByteEntityAccumuloElementConverter(
        schema);
    Entity element = (new Entity.Builder()).group("Group").vertex("Vertex").build();

    // Act
    Pair<byte[], byte[]> actualRowKeysFromElement = byteEntityAccumuloElementConverter.getRowKeysFromElement(element);

    // Assert
    verify(avroSerialiser).serialise(isA(Object.class));
    verify(schema).getAggregatedGroups();
    verify(schema).getConfig(eq("timestampProperty"));
    verify(schema).getVertexSerialiser();
    assertNull(actualRowKeysFromElement.getSecond());
    assertArrayEquals(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 1}, actualRowKeysFromElement.getFirst());
  }

  /**
   * Test {@link AbstractCoreKeyAccumuloElementConverter#buildColumnFamily(String)}.
   * <p>
   * Method under test: {@link AbstractCoreKeyAccumuloElementConverter#buildColumnFamily(String)}
   */
  @Test
  @DisplayName("Test buildColumnFamily(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] AbstractCoreKeyAccumuloElementConverter.buildColumnFamily(String)"})
  void testBuildColumnFamily() throws UnsupportedEncodingException {
    // Arrange and Act
    byte[] actualBuildColumnFamilyResult = (new ByteEntityAccumuloElementConverter(new Schema()))
        .buildColumnFamily("Group");

    // Assert
    assertArrayEquals("Group".getBytes("UTF-8"), actualBuildColumnFamilyResult);
  }

  /**
   * Test {@link AbstractCoreKeyAccumuloElementConverter#getGroupFromColumnFamily(byte[])}.
   * <p>
   * Method under test: {@link AbstractCoreKeyAccumuloElementConverter#getGroupFromColumnFamily(byte[])}
   */
  @Test
  @DisplayName("Test getGroupFromColumnFamily(byte[])")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String AbstractCoreKeyAccumuloElementConverter.getGroupFromColumnFamily(byte[])"})
  void testGetGroupFromColumnFamily() throws UnsupportedEncodingException {
    // Arrange
    ByteEntityAccumuloElementConverter byteEntityAccumuloElementConverter = new ByteEntityAccumuloElementConverter(
        new Schema());

    // Act and Assert
    assertEquals("AXAXAXAX", byteEntityAccumuloElementConverter.getGroupFromColumnFamily("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link AbstractCoreKeyAccumuloElementConverter#buildColumnVisibility(String, Properties)}.
   * <ul>
   *   <li>Then throw {@link AccumuloElementConversionException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractCoreKeyAccumuloElementConverter#buildColumnVisibility(String, Properties)}
   */
  @Test
  @DisplayName("Test buildColumnVisibility(String, Properties); then throw AccumuloElementConversionException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] AbstractCoreKeyAccumuloElementConverter.buildColumnVisibility(String, Properties)"})
  void testBuildColumnVisibility_thenThrowAccumuloElementConversionException() {
    // Arrange
    ByteEntityAccumuloElementConverter byteEntityAccumuloElementConverter = new ByteEntityAccumuloElementConverter(
        new Schema());

    // Act and Assert
    assertThrows(AccumuloElementConversionException.class,
        () -> byteEntityAccumuloElementConverter.buildColumnVisibility("Group", new Properties()));
  }

  /**
   * Test {@link AbstractCoreKeyAccumuloElementConverter#getPropertiesFromColumnVisibility(String, byte[])}.
   * <p>
   * Method under test: {@link AbstractCoreKeyAccumuloElementConverter#getPropertiesFromColumnVisibility(String, byte[])}
   */
  @Test
  @DisplayName("Test getPropertiesFromColumnVisibility(String, byte[])")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "Properties AbstractCoreKeyAccumuloElementConverter.getPropertiesFromColumnVisibility(String, byte[])"})
  void testGetPropertiesFromColumnVisibility() throws UnsupportedEncodingException {
    // Arrange
    ByteEntityAccumuloElementConverter byteEntityAccumuloElementConverter = new ByteEntityAccumuloElementConverter(
        new Schema());

    // Act and Assert
    assertThrows(AccumuloElementConversionException.class, () -> byteEntityAccumuloElementConverter
        .getPropertiesFromColumnVisibility("Group", "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link AbstractCoreKeyAccumuloElementConverter#buildColumnQualifier(String, Properties)}.
   * <ul>
   *   <li>Then throw {@link AccumuloElementConversionException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractCoreKeyAccumuloElementConverter#buildColumnQualifier(String, Properties)}
   */
  @Test
  @DisplayName("Test buildColumnQualifier(String, Properties); then throw AccumuloElementConversionException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] AbstractCoreKeyAccumuloElementConverter.buildColumnQualifier(String, Properties)"})
  void testBuildColumnQualifier_thenThrowAccumuloElementConversionException() {
    // Arrange
    ByteEntityAccumuloElementConverter byteEntityAccumuloElementConverter = new ByteEntityAccumuloElementConverter(
        new Schema());

    // Act and Assert
    assertThrows(AccumuloElementConversionException.class,
        () -> byteEntityAccumuloElementConverter.buildColumnQualifier("Group", new Properties()));
  }

  /**
   * Test {@link AbstractCoreKeyAccumuloElementConverter#serialiseSizeAndPropertyValue(String, SchemaElementDefinition, Properties, ByteArrayOutputStream)}.
   * <p>
   * Method under test: {@link AbstractCoreKeyAccumuloElementConverter#serialiseSizeAndPropertyValue(String, SchemaElementDefinition, Properties, ByteArrayOutputStream)}
   */
  @Test
  @DisplayName("Test serialiseSizeAndPropertyValue(String, SchemaElementDefinition, Properties, ByteArrayOutputStream)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void AbstractCoreKeyAccumuloElementConverter.serialiseSizeAndPropertyValue(String, SchemaElementDefinition, Properties, ByteArrayOutputStream)"})
  void testSerialiseSizeAndPropertyValue() {
    // Arrange
    ByteEntityAccumuloElementConverter byteEntityAccumuloElementConverter = new ByteEntityAccumuloElementConverter(
        new Schema());
    SchemaEdgeDefinition elementDefinition = new SchemaEdgeDefinition();
    Properties properties = new Properties();
    ByteArrayOutputStream stream = new ByteArrayOutputStream(1);

    // Act
    byteEntityAccumuloElementConverter.serialiseSizeAndPropertyValue("Property Name", elementDefinition, properties,
        stream);

    // Assert
    assertArrayEquals(new byte[]{0}, stream.toByteArray());
  }

  /**
   * Test {@link AbstractCoreKeyAccumuloElementConverter#getPropertiesFromColumnQualifier(String, byte[])}.
   * <ul>
   *   <li>Then throw {@link AccumuloElementConversionException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractCoreKeyAccumuloElementConverter#getPropertiesFromColumnQualifier(String, byte[])}
   */
  @Test
  @DisplayName("Test getPropertiesFromColumnQualifier(String, byte[]); then throw AccumuloElementConversionException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "Properties AbstractCoreKeyAccumuloElementConverter.getPropertiesFromColumnQualifier(String, byte[])"})
  void testGetPropertiesFromColumnQualifier_thenThrowAccumuloElementConversionException()
      throws UnsupportedEncodingException {
    // Arrange
    ByteEntityAccumuloElementConverter byteEntityAccumuloElementConverter = new ByteEntityAccumuloElementConverter(
        new Schema());

    // Act and Assert
    assertThrows(AccumuloElementConversionException.class, () -> byteEntityAccumuloElementConverter
        .getPropertiesFromColumnQualifier("Group", "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link AbstractCoreKeyAccumuloElementConverter#getPropertiesFromColumnQualifier(String, byte[])}.
   * <ul>
   *   <li>When empty array of {@code byte}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractCoreKeyAccumuloElementConverter#getPropertiesFromColumnQualifier(String, byte[])}
   */
  @Test
  @DisplayName("Test getPropertiesFromColumnQualifier(String, byte[]); when empty array of byte; then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "Properties AbstractCoreKeyAccumuloElementConverter.getPropertiesFromColumnQualifier(String, byte[])"})
  void testGetPropertiesFromColumnQualifier_whenEmptyArrayOfByte_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(
        (new ByteEntityAccumuloElementConverter(new Schema())).getPropertiesFromColumnQualifier("Group", new byte[]{})
            .isEmpty());
  }

  /**
   * Test {@link AbstractCoreKeyAccumuloElementConverter#getPropertiesAsBytesFromColumnQualifier(String, byte[], int)}.
   * <p>
   * Method under test: {@link AbstractCoreKeyAccumuloElementConverter#getPropertiesAsBytesFromColumnQualifier(String, byte[], int)}
   */
  @Test
  @DisplayName("Test getPropertiesAsBytesFromColumnQualifier(String, byte[], int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "BytesAndRange AbstractCoreKeyAccumuloElementConverter.getPropertiesAsBytesFromColumnQualifier(String, byte[], int)"})
  void testGetPropertiesAsBytesFromColumnQualifier() throws UnsupportedEncodingException {
    // Arrange
    ByteEntityAccumuloElementConverter byteEntityAccumuloElementConverter = new ByteEntityAccumuloElementConverter(
        new Schema());

    // Act and Assert
    assertThrows(AccumuloElementConversionException.class, () -> byteEntityAccumuloElementConverter
        .getPropertiesAsBytesFromColumnQualifier("Group", "AXAXAXAX".getBytes("UTF-8"), 10));
  }

  /**
   * Test {@link AbstractCoreKeyAccumuloElementConverter#getPropertiesAsBytesFromColumnQualifier(String, byte[], int)}.
   * <ul>
   *   <li>Then return Bytes is empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractCoreKeyAccumuloElementConverter#getPropertiesAsBytesFromColumnQualifier(String, byte[], int)}
   */
  @Test
  @DisplayName("Test getPropertiesAsBytesFromColumnQualifier(String, byte[], int); then return Bytes is empty array of byte")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "BytesAndRange AbstractCoreKeyAccumuloElementConverter.getPropertiesAsBytesFromColumnQualifier(String, byte[], int)"})
  void testGetPropertiesAsBytesFromColumnQualifier_thenReturnBytesIsEmptyArrayOfByte() {
    // Arrange and Act
    BytesAndRange actualPropertiesAsBytesFromColumnQualifier = (new ByteEntityAccumuloElementConverter(new Schema()))
        .getPropertiesAsBytesFromColumnQualifier("Group", new byte[]{}, 10);

    // Assert
    assertEquals(0, actualPropertiesAsBytesFromColumnQualifier.getLength());
    assertEquals(0, actualPropertiesAsBytesFromColumnQualifier.getOffSet());
    assertArrayEquals(new byte[]{}, actualPropertiesAsBytesFromColumnQualifier.getBytes());
  }

  /**
   * Test {@link AbstractCoreKeyAccumuloElementConverter#getPropertiesAsBytesFromColumnQualifier(String, byte[], int)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return Bytes is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractCoreKeyAccumuloElementConverter#getPropertiesAsBytesFromColumnQualifier(String, byte[], int)}
   */
  @Test
  @DisplayName("Test getPropertiesAsBytesFromColumnQualifier(String, byte[], int); when one; then return Bytes is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "BytesAndRange AbstractCoreKeyAccumuloElementConverter.getPropertiesAsBytesFromColumnQualifier(String, byte[], int)"})
  void testGetPropertiesAsBytesFromColumnQualifier_whenOne_thenReturnBytesIsNull() {
    // Arrange and Act
    BytesAndRange actualPropertiesAsBytesFromColumnQualifier = (new ByteEntityAccumuloElementConverter(new Schema()))
        .getPropertiesAsBytesFromColumnQualifier("Group", null, 1);

    // Assert
    assertNull(actualPropertiesAsBytesFromColumnQualifier.getBytes());
    assertEquals(0, actualPropertiesAsBytesFromColumnQualifier.getLength());
    assertEquals(0, actualPropertiesAsBytesFromColumnQualifier.getOffSet());
  }

  /**
   * Test {@link AbstractCoreKeyAccumuloElementConverter#getPropertiesAsBytesFromColumnQualifier(String, byte[], int)}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return Bytes is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractCoreKeyAccumuloElementConverter#getPropertiesAsBytesFromColumnQualifier(String, byte[], int)}
   */
  @Test
  @DisplayName("Test getPropertiesAsBytesFromColumnQualifier(String, byte[], int); when zero; then return Bytes is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "BytesAndRange AbstractCoreKeyAccumuloElementConverter.getPropertiesAsBytesFromColumnQualifier(String, byte[], int)"})
  void testGetPropertiesAsBytesFromColumnQualifier_whenZero_thenReturnBytesIsNull() {
    // Arrange and Act
    BytesAndRange actualPropertiesAsBytesFromColumnQualifier = (new ByteEntityAccumuloElementConverter(new Schema()))
        .getPropertiesAsBytesFromColumnQualifier("Group", null, 0);

    // Assert
    assertNull(actualPropertiesAsBytesFromColumnQualifier.getBytes());
    assertEquals(0, actualPropertiesAsBytesFromColumnQualifier.getLength());
    assertEquals(0, actualPropertiesAsBytesFromColumnQualifier.getOffSet());
  }

  /**
   * Test {@link AbstractCoreKeyAccumuloElementConverter#isColumnQualifierBytesValid(byte[], int)}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractCoreKeyAccumuloElementConverter#isColumnQualifierBytesValid(byte[], int)}
   */
  @Test
  @DisplayName("Test isColumnQualifierBytesValid(byte[], int); when 'AXAXAXAX' Bytes is 'UTF-8'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AbstractCoreKeyAccumuloElementConverter.isColumnQualifierBytesValid(byte[], int)"})
  void testIsColumnQualifierBytesValid_whenAxaxaxaxBytesIsUtf8_thenReturnTrue() throws UnsupportedEncodingException {
    // Arrange
    ByteEntityAccumuloElementConverter byteEntityAccumuloElementConverter = new ByteEntityAccumuloElementConverter(
        new Schema());

    // Act and Assert
    assertTrue(byteEntityAccumuloElementConverter.isColumnQualifierBytesValid("AXAXAXAX".getBytes("UTF-8"), 10));
  }

  /**
   * Test {@link AbstractCoreKeyAccumuloElementConverter#isColumnQualifierBytesValid(byte[], int)}.
   * <ul>
   *   <li>When empty array of {@code byte}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractCoreKeyAccumuloElementConverter#isColumnQualifierBytesValid(byte[], int)}
   */
  @Test
  @DisplayName("Test isColumnQualifierBytesValid(byte[], int); when empty array of byte; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AbstractCoreKeyAccumuloElementConverter.isColumnQualifierBytesValid(byte[], int)"})
  void testIsColumnQualifierBytesValid_whenEmptyArrayOfByte_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new ByteEntityAccumuloElementConverter(new Schema())).isColumnQualifierBytesValid(new byte[]{}, 10));
  }

  /**
   * Test {@link AbstractCoreKeyAccumuloElementConverter#isColumnQualifierBytesValid(byte[], int)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractCoreKeyAccumuloElementConverter#isColumnQualifierBytesValid(byte[], int)}
   */
  @Test
  @DisplayName("Test isColumnQualifierBytesValid(byte[], int); when 'null'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AbstractCoreKeyAccumuloElementConverter.isColumnQualifierBytesValid(byte[], int)"})
  void testIsColumnQualifierBytesValid_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new ByteEntityAccumuloElementConverter(new Schema())).isColumnQualifierBytesValid(null, 10));
  }

  /**
   * Test {@link AbstractCoreKeyAccumuloElementConverter#isColumnQualifierBytesValid(byte[], int)}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractCoreKeyAccumuloElementConverter#isColumnQualifierBytesValid(byte[], int)}
   */
  @Test
  @DisplayName("Test isColumnQualifierBytesValid(byte[], int); when zero; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AbstractCoreKeyAccumuloElementConverter.isColumnQualifierBytesValid(byte[], int)"})
  void testIsColumnQualifierBytesValid_whenZero_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new ByteEntityAccumuloElementConverter(new Schema())).isColumnQualifierBytesValid(null, 0));
  }

  /**
   * Test {@link AbstractCoreKeyAccumuloElementConverter#getPropertiesFromTimestamp(String, long)}.
   * <ul>
   *   <li>Then throw {@link AccumuloElementConversionException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractCoreKeyAccumuloElementConverter#getPropertiesFromTimestamp(String, long)}
   */
  @Test
  @DisplayName("Test getPropertiesFromTimestamp(String, long); then throw AccumuloElementConversionException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Properties AbstractCoreKeyAccumuloElementConverter.getPropertiesFromTimestamp(String, long)"})
  void testGetPropertiesFromTimestamp_thenThrowAccumuloElementConversionException() {
    // Arrange, Act and Assert
    assertThrows(AccumuloElementConversionException.class,
        () -> (new ByteEntityAccumuloElementConverter(new Schema())).getPropertiesFromTimestamp("Group", 10L));
  }

  /**
   * Test {@link AbstractCoreKeyAccumuloElementConverter#serialiseVertex(Object)}.
   * <ul>
   *   <li>Then throw {@link AccumuloElementConversionException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractCoreKeyAccumuloElementConverter#serialiseVertex(Object)}
   */
  @Test
  @DisplayName("Test serialiseVertex(Object); then throw AccumuloElementConversionException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] AbstractCoreKeyAccumuloElementConverter.serialiseVertex(Object)"})
  void testSerialiseVertex_thenThrowAccumuloElementConversionException() throws SerialisationException {
    // Arrange
    AvroSerialiser avroSerialiser = mock(AvroSerialiser.class);
    when(avroSerialiser.serialise(Mockito.<Object>any())).thenThrow(new SerialisationException("An error occurred"));
    Schema schema = mock(Schema.class);
    when(schema.getConfig(Mockito.<String>any())).thenReturn("Config");
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.getVertexSerialiser()).thenReturn(avroSerialiser);

    // Act and Assert
    assertThrows(AccumuloElementConversionException.class,
        () -> (new ByteEntityAccumuloElementConverter(schema)).serialiseVertex("Vertex"));
    verify(avroSerialiser).serialise(isA(Object.class));
    verify(schema).getAggregatedGroups();
    verify(schema).getConfig(eq("timestampProperty"));
    verify(schema).getVertexSerialiser();
  }

  /**
   * Test {@link AbstractCoreKeyAccumuloElementConverter#selfEdge(Edge)}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractCoreKeyAccumuloElementConverter#selfEdge(Edge)}
   */
  @Test
  @DisplayName("Test selfEdge(Edge); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AbstractCoreKeyAccumuloElementConverter.selfEdge(Edge)"})
  void testSelfEdge_thenReturnFalse() {
    // Arrange
    ByteEntityAccumuloElementConverter byteEntityAccumuloElementConverter = new ByteEntityAccumuloElementConverter(
        new Schema());
    Edge edge = (new Builder()).dest("Dest")
        .directed(true)
        .group("Group")
        .matchedVertex(MatchedVertex.SOURCE)
        .source("Source")
        .build();

    // Act and Assert
    assertFalse(byteEntityAccumuloElementConverter.selfEdge(edge));
  }

  /**
   * Test {@link AbstractCoreKeyAccumuloElementConverter#selfEdge(Edge)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractCoreKeyAccumuloElementConverter#selfEdge(Edge)}
   */
  @Test
  @DisplayName("Test selfEdge(Edge); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AbstractCoreKeyAccumuloElementConverter.selfEdge(Edge)"})
  void testSelfEdge_thenReturnTrue() {
    // Arrange
    ByteEntityAccumuloElementConverter byteEntityAccumuloElementConverter = new ByteEntityAccumuloElementConverter(
        new Schema());
    Edge edge = (new Builder()).dest("Source")
        .directed(true)
        .group("Group")
        .matchedVertex(MatchedVertex.SOURCE)
        .source("Source")
        .build();

    // Act and Assert
    assertTrue(byteEntityAccumuloElementConverter.selfEdge(edge));
  }

  /**
   * Test {@link AbstractCoreKeyAccumuloElementConverter#addPropertiesToElement(Element, Key)}.
   * <ul>
   *   <li>Then throw {@link AccumuloElementConversionException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractCoreKeyAccumuloElementConverter#addPropertiesToElement(Element, Key)}
   */
  @Test
  @DisplayName("Test addPropertiesToElement(Element, Key); then throw AccumuloElementConversionException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AbstractCoreKeyAccumuloElementConverter.addPropertiesToElement(Element, Key)"})
  void testAddPropertiesToElement_thenThrowAccumuloElementConversionException() {
    // Arrange
    ByteEntityAccumuloElementConverter byteEntityAccumuloElementConverter = new ByteEntityAccumuloElementConverter(
        new Schema());
    Edge element = new Edge("Group");

    // Act and Assert
    assertThrows(AccumuloElementConversionException.class,
        () -> byteEntityAccumuloElementConverter.addPropertiesToElement(element, new Key()));
  }

  /**
   * Test {@link AbstractCoreKeyAccumuloElementConverter#getSerialisedSource(Edge)}.
   * <ul>
   *   <li>Then return array of {@code byte} with one and one.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractCoreKeyAccumuloElementConverter#getSerialisedSource(Edge)}
   */
  @Test
  @DisplayName("Test getSerialisedSource(Edge); then return array of byte with one and one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] AbstractCoreKeyAccumuloElementConverter.getSerialisedSource(Edge)"})
  void testGetSerialisedSource_thenReturnArrayOfByteWithOneAndOne() throws SerialisationException {
    // Arrange
    AvroSerialiser avroSerialiser = mock(AvroSerialiser.class);
    when(avroSerialiser.serialise(Mockito.<Object>any())).thenReturn(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});
    Schema schema = mock(Schema.class);
    when(schema.getConfig(Mockito.<String>any())).thenReturn("Config");
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.getVertexSerialiser()).thenReturn(avroSerialiser);
    ByteEntityAccumuloElementConverter byteEntityAccumuloElementConverter = new ByteEntityAccumuloElementConverter(
        schema);

    // Act
    byte[] actualSerialisedSource = byteEntityAccumuloElementConverter.getSerialisedSource(new Edge("Group"));

    // Assert
    verify(avroSerialiser).serialise(isNull());
    verify(schema).getAggregatedGroups();
    verify(schema).getConfig(eq("timestampProperty"));
    verify(schema).getVertexSerialiser();
    assertArrayEquals(new byte[]{1, 1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, actualSerialisedSource);
  }

  /**
   * Test {@link AbstractCoreKeyAccumuloElementConverter#getSerialisedSource(Edge)}.
   * <ul>
   *   <li>Then return array of {@code byte} with one and two.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractCoreKeyAccumuloElementConverter#getSerialisedSource(Edge)}
   */
  @Test
  @DisplayName("Test getSerialisedSource(Edge); then return array of byte with one and two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] AbstractCoreKeyAccumuloElementConverter.getSerialisedSource(Edge)"})
  void testGetSerialisedSource_thenReturnArrayOfByteWithOneAndTwo() throws SerialisationException {
    // Arrange
    AvroSerialiser avroSerialiser = mock(AvroSerialiser.class);
    when(avroSerialiser.serialise(Mockito.<Object>any())).thenReturn(new byte[]{1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});
    Schema schema = mock(Schema.class);
    when(schema.getConfig(Mockito.<String>any())).thenReturn("Config");
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.getVertexSerialiser()).thenReturn(avroSerialiser);
    ByteEntityAccumuloElementConverter byteEntityAccumuloElementConverter = new ByteEntityAccumuloElementConverter(
        schema);

    // Act
    byte[] actualSerialisedSource = byteEntityAccumuloElementConverter.getSerialisedSource(new Edge("Group"));

    // Assert
    verify(avroSerialiser).serialise(isNull());
    verify(schema).getAggregatedGroups();
    verify(schema).getConfig(eq("timestampProperty"));
    verify(schema).getVertexSerialiser();
    assertArrayEquals(new byte[]{1, 2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, actualSerialisedSource);
  }

  /**
   * Test {@link AbstractCoreKeyAccumuloElementConverter#getSerialisedSource(Edge)}.
   * <ul>
   *   <li>Then return {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractCoreKeyAccumuloElementConverter#getSerialisedSource(Edge)}
   */
  @Test
  @DisplayName("Test getSerialisedSource(Edge); then return 'AXAXAXAX' Bytes is 'UTF-8'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] AbstractCoreKeyAccumuloElementConverter.getSerialisedSource(Edge)"})
  void testGetSerialisedSource_thenReturnAxaxaxaxBytesIsUtf8()
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

    // Act
    byte[] actualSerialisedSource = byteEntityAccumuloElementConverter.getSerialisedSource(new Edge("Group"));

    // Assert
    verify(avroSerialiser).serialise(isNull());
    verify(schema).getAggregatedGroups();
    verify(schema).getConfig(eq("timestampProperty"));
    verify(schema).getVertexSerialiser();
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualSerialisedSource);
  }

  /**
   * Test {@link AbstractCoreKeyAccumuloElementConverter#getSerialisedDestination(Edge)}.
   * <ul>
   *   <li>Then return array of {@code byte} with one and one.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractCoreKeyAccumuloElementConverter#getSerialisedDestination(Edge)}
   */
  @Test
  @DisplayName("Test getSerialisedDestination(Edge); then return array of byte with one and one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] AbstractCoreKeyAccumuloElementConverter.getSerialisedDestination(Edge)"})
  void testGetSerialisedDestination_thenReturnArrayOfByteWithOneAndOne() throws SerialisationException {
    // Arrange
    AvroSerialiser avroSerialiser = mock(AvroSerialiser.class);
    when(avroSerialiser.serialise(Mockito.<Object>any())).thenReturn(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});
    Schema schema = mock(Schema.class);
    when(schema.getConfig(Mockito.<String>any())).thenReturn("Config");
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.getVertexSerialiser()).thenReturn(avroSerialiser);
    ByteEntityAccumuloElementConverter byteEntityAccumuloElementConverter = new ByteEntityAccumuloElementConverter(
        schema);

    // Act
    byte[] actualSerialisedDestination = byteEntityAccumuloElementConverter.getSerialisedDestination(new Edge("Group"));

    // Assert
    verify(avroSerialiser).serialise(isNull());
    verify(schema).getAggregatedGroups();
    verify(schema).getConfig(eq("timestampProperty"));
    verify(schema).getVertexSerialiser();
    assertArrayEquals(new byte[]{1, 1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, actualSerialisedDestination);
  }

  /**
   * Test {@link AbstractCoreKeyAccumuloElementConverter#getSerialisedDestination(Edge)}.
   * <ul>
   *   <li>Then return array of {@code byte} with one and two.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractCoreKeyAccumuloElementConverter#getSerialisedDestination(Edge)}
   */
  @Test
  @DisplayName("Test getSerialisedDestination(Edge); then return array of byte with one and two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] AbstractCoreKeyAccumuloElementConverter.getSerialisedDestination(Edge)"})
  void testGetSerialisedDestination_thenReturnArrayOfByteWithOneAndTwo() throws SerialisationException {
    // Arrange
    AvroSerialiser avroSerialiser = mock(AvroSerialiser.class);
    when(avroSerialiser.serialise(Mockito.<Object>any())).thenReturn(new byte[]{1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});
    Schema schema = mock(Schema.class);
    when(schema.getConfig(Mockito.<String>any())).thenReturn("Config");
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.getVertexSerialiser()).thenReturn(avroSerialiser);
    ByteEntityAccumuloElementConverter byteEntityAccumuloElementConverter = new ByteEntityAccumuloElementConverter(
        schema);

    // Act
    byte[] actualSerialisedDestination = byteEntityAccumuloElementConverter.getSerialisedDestination(new Edge("Group"));

    // Assert
    verify(avroSerialiser).serialise(isNull());
    verify(schema).getAggregatedGroups();
    verify(schema).getConfig(eq("timestampProperty"));
    verify(schema).getVertexSerialiser();
    assertArrayEquals(new byte[]{1, 2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, actualSerialisedDestination);
  }

  /**
   * Test {@link AbstractCoreKeyAccumuloElementConverter#getSerialisedDestination(Edge)}.
   * <ul>
   *   <li>Then return {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractCoreKeyAccumuloElementConverter#getSerialisedDestination(Edge)}
   */
  @Test
  @DisplayName("Test getSerialisedDestination(Edge); then return 'AXAXAXAX' Bytes is 'UTF-8'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] AbstractCoreKeyAccumuloElementConverter.getSerialisedDestination(Edge)"})
  void testGetSerialisedDestination_thenReturnAxaxaxaxBytesIsUtf8()
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

    // Act
    byte[] actualSerialisedDestination = byteEntityAccumuloElementConverter.getSerialisedDestination(new Edge("Group"));

    // Assert
    verify(avroSerialiser).serialise(isNull());
    verify(schema).getAggregatedGroups();
    verify(schema).getConfig(eq("timestampProperty"));
    verify(schema).getVertexSerialiser();
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualSerialisedDestination);
  }

  /**
   * Test {@link AbstractCoreKeyAccumuloElementConverter#getGroupFromKey(Key)}.
   * <ul>
   *   <li>When {@link Key#Key()}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractCoreKeyAccumuloElementConverter#getGroupFromKey(Key)}
   */
  @Test
  @DisplayName("Test getGroupFromKey(Key); when Key(); then return empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String AbstractCoreKeyAccumuloElementConverter.getGroupFromKey(Key)"})
  void testGetGroupFromKey_whenKey_thenReturnEmptyString() {
    // Arrange
    ByteEntityAccumuloElementConverter byteEntityAccumuloElementConverter = new ByteEntityAccumuloElementConverter(
        new Schema());

    // Act and Assert
    assertEquals("", byteEntityAccumuloElementConverter.getGroupFromKey(new Key()));
  }

  /**
   * Test {@link AbstractCoreKeyAccumuloElementConverter#isStoredInValue(String, SchemaElementDefinition)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractCoreKeyAccumuloElementConverter#isStoredInValue(String, SchemaElementDefinition)}
   */
  @Test
  @DisplayName("Test isStoredInValue(String, SchemaElementDefinition); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "boolean AbstractCoreKeyAccumuloElementConverter.isStoredInValue(String, SchemaElementDefinition)"})
  void testIsStoredInValue_thenReturnTrue() {
    // Arrange
    ByteEntityAccumuloElementConverter byteEntityAccumuloElementConverter = new ByteEntityAccumuloElementConverter(
        new Schema());

    // Act and Assert
    assertTrue(byteEntityAccumuloElementConverter.isStoredInValue("Property Name", new SchemaEdgeDefinition()));
  }
}
