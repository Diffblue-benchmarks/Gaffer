package uk.gov.gchq.gaffer.accumulostore.key.core;

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
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.function.BinaryOperator;
import org.apache.accumulo.core.data.ArrayByteSequence;
import org.apache.accumulo.core.data.Key;
import org.apache.accumulo.core.data.Value;
import org.apache.accumulo.core.file.rfile.RFile;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uk.gov.gchq.gaffer.accumulostore.key.core.impl.byteEntity.ByteEntityAccumuloElementConverter;
import uk.gov.gchq.gaffer.accumulostore.key.exception.AccumuloElementConversionException;
import uk.gov.gchq.gaffer.accumulostore.utils.BytesAndRange;
import uk.gov.gchq.gaffer.commonutil.pair.Pair;
import uk.gov.gchq.gaffer.data.element.Edge;
import uk.gov.gchq.gaffer.data.element.Edge.Builder;
import uk.gov.gchq.gaffer.data.element.Element;
import uk.gov.gchq.gaffer.data.element.Entity;
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
import uk.gov.gchq.gaffer.store.schema.TypeDefinition;
import uk.gov.gchq.gaffer.types.TypeSubTypeValue;

class AbstractCoreKeyAccumuloElementConverterDiffblueTest {
  /**
   * Test {@link AbstractCoreKeyAccumuloElementConverter#getElementId(Key, boolean)}.
   *
   * <ul>
   *   <li>Then return Vertex {@code A} longValue is sixty-five.
   * </ul>
   *
   * <p>Method under test: {@link AbstractCoreKeyAccumuloElementConverter#getElementId(Key,
   * boolean)}
   */
  @Test
  @DisplayName("Test getElementId(Key, boolean); then return Vertex 'A' longValue is sixty-five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ElementId AbstractCoreKeyAccumuloElementConverter.getElementId(Key, boolean)"
  })
  void testGetElementId_thenReturnVertexALongValueIsSixtyFive() {
    // Arrange
    Schema schema = mock(Schema.class);
    when(schema.getConfig(Mockito.<String>any())).thenReturn("Config");
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.getVertexSerialiser()).thenReturn(new FreqMapSerialiser());
    ByteEntityAccumuloElementConverter byteEntityAccumuloElementConverter =
        new ByteEntityAccumuloElementConverter(schema);

    ArrayByteSequence arrayByteSequence = mock(ArrayByteSequence.class);
    when(arrayByteSequence.getBackingArray())
        .thenReturn(new byte[] {'A', 0, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1});

    Key key = mock(Key.class);
    when(key.getRowData()).thenReturn(arrayByteSequence);

    // Act
    ElementId actualElementId = byteEntityAccumuloElementConverter.getElementId(key, true);

    // Assert
    verify(arrayByteSequence).getBackingArray();
    verify(key).getRowData();
    verify(schema).getAggregatedGroups();
    verify(schema).getConfig("timestampProperty");
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
   *
   * <ul>
   *   <li>Then return Vertex Empty.
   * </ul>
   *
   * <p>Method under test: {@link AbstractCoreKeyAccumuloElementConverter#getElementId(Key,
   * boolean)}
   */
  @Test
  @DisplayName("Test getElementId(Key, boolean); then return Vertex Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ElementId AbstractCoreKeyAccumuloElementConverter.getElementId(Key, boolean)"
  })
  void testGetElementId_thenReturnVertexEmpty() {
    // Arrange
    Schema schema = mock(Schema.class);
    when(schema.getConfig(Mockito.<String>any())).thenReturn("Config");
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.getVertexSerialiser()).thenReturn(new FreqMapSerialiser());
    ByteEntityAccumuloElementConverter byteEntityAccumuloElementConverter =
        new ByteEntityAccumuloElementConverter(schema);

    ArrayByteSequence arrayByteSequence = mock(ArrayByteSequence.class);
    when(arrayByteSequence.getBackingArray())
        .thenReturn(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1});

    Key key = mock(Key.class);
    when(key.getRowData()).thenReturn(arrayByteSequence);

    // Act
    ElementId actualElementId = byteEntityAccumuloElementConverter.getElementId(key, true);

    // Assert
    verify(arrayByteSequence).getBackingArray();
    verify(key).getRowData();
    verify(schema).getAggregatedGroups();
    verify(schema).getConfig("timestampProperty");
    verify(schema).getVertexSerialiser();
    Object vertex = ((EntitySeed) actualElementId).getVertex();
    assertTrue(vertex instanceof Map);
    assertTrue(actualElementId instanceof EntitySeed);
    assertEquals("uk.gov.gchq.gaffer.operation.data.EntitySeed", actualElementId.getClassName());
    assertTrue(((Map<Object, Object>) vertex).isEmpty());
  }

  /**
   * Test {@link AbstractCoreKeyAccumuloElementConverter#getElementId(Key, boolean)}.
   *
   * <ul>
   *   <li>Then return Vertex Empty.
   * </ul>
   *
   * <p>Method under test: {@link AbstractCoreKeyAccumuloElementConverter#getElementId(Key,
   * boolean)}
   */
  @Test
  @DisplayName("Test getElementId(Key, boolean); then return Vertex Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ElementId AbstractCoreKeyAccumuloElementConverter.getElementId(Key, boolean)"
  })
  void testGetElementId_thenReturnVertexEmpty2() {
    // Arrange
    Schema schema = mock(Schema.class);
    when(schema.getConfig(Mockito.<String>any())).thenReturn("Config");
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.getVertexSerialiser()).thenReturn(new FreqMapSerialiser());
    ByteEntityAccumuloElementConverter byteEntityAccumuloElementConverter =
        new ByteEntityAccumuloElementConverter(schema);

    ArrayByteSequence arrayByteSequence = mock(ArrayByteSequence.class);
    when(arrayByteSequence.getBackingArray())
        .thenReturn(new byte[] {'A', 1, 2, 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1});

    Key key = mock(Key.class);
    when(key.getRowData()).thenReturn(arrayByteSequence);

    // Act
    ElementId actualElementId = byteEntityAccumuloElementConverter.getElementId(key, true);

    // Assert
    verify(arrayByteSequence).getBackingArray();
    verify(key).getRowData();
    verify(schema).getAggregatedGroups();
    verify(schema).getConfig("timestampProperty");
    verify(schema).getVertexSerialiser();
    Object vertex = ((EntitySeed) actualElementId).getVertex();
    assertTrue(vertex instanceof Map);
    assertTrue(actualElementId instanceof EntitySeed);
    assertEquals("uk.gov.gchq.gaffer.operation.data.EntitySeed", actualElementId.getClassName());
    assertTrue(((Map<Object, Object>) vertex).isEmpty());
  }

  /**
   * Test {@link AbstractCoreKeyAccumuloElementConverter#getElementId(Key, boolean)}.
   *
   * <ul>
   *   <li>Then return Vertex empty string longValue is sixty-five.
   * </ul>
   *
   * <p>Method under test: {@link AbstractCoreKeyAccumuloElementConverter#getElementId(Key,
   * boolean)}
   */
  @Test
  @DisplayName(
      "Test getElementId(Key, boolean); then return Vertex empty string longValue is sixty-five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ElementId AbstractCoreKeyAccumuloElementConverter.getElementId(Key, boolean)"
  })
  void testGetElementId_thenReturnVertexEmptyStringLongValueIsSixtyFive() {
    // Arrange
    Schema schema = mock(Schema.class);
    when(schema.getConfig(Mockito.<String>any())).thenReturn("Config");
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.getVertexSerialiser()).thenReturn(new FreqMapSerialiser());
    ByteEntityAccumuloElementConverter byteEntityAccumuloElementConverter =
        new ByteEntityAccumuloElementConverter(schema);

    ArrayByteSequence arrayByteSequence = mock(ArrayByteSequence.class);
    when(arrayByteSequence.getBackingArray())
        .thenReturn(new byte[] {1, 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1});

    Key key = mock(Key.class);
    when(key.getRowData()).thenReturn(arrayByteSequence);

    // Act
    ElementId actualElementId = byteEntityAccumuloElementConverter.getElementId(key, true);

    // Assert
    verify(arrayByteSequence).getBackingArray();
    verify(key).getRowData();
    verify(schema).getAggregatedGroups();
    verify(schema).getConfig("timestampProperty");
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
   *
   * <ul>
   *   <li>Then Vertex return {@link TypeSubTypeValue}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractCoreKeyAccumuloElementConverter#getElementId(Key,
   * boolean)}
   */
  @Test
  @DisplayName("Test getElementId(Key, boolean); then Vertex return TypeSubTypeValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ElementId AbstractCoreKeyAccumuloElementConverter.getElementId(Key, boolean)"
  })
  void testGetElementId_thenVertexReturnTypeSubTypeValue() {
    // Arrange
    Schema schema = mock(Schema.class);
    when(schema.getConfig(Mockito.<String>any())).thenReturn("Config");
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.getVertexSerialiser()).thenReturn(new TypeSubTypeValueSerialiser());
    ByteEntityAccumuloElementConverter byteEntityAccumuloElementConverter =
        new ByteEntityAccumuloElementConverter(schema);

    ArrayByteSequence arrayByteSequence = mock(ArrayByteSequence.class);
    when(arrayByteSequence.getBackingArray())
        .thenReturn(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1});

    Key key = mock(Key.class);
    when(key.getRowData()).thenReturn(arrayByteSequence);

    // Act
    ElementId actualElementId = byteEntityAccumuloElementConverter.getElementId(key, true);

    // Assert
    verify(arrayByteSequence).getBackingArray();
    verify(key).getRowData();
    verify(schema).getAggregatedGroups();
    verify(schema).getConfig("timestampProperty");
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
   *
   * <p>Method under test: {@link
   * AbstractCoreKeyAccumuloElementConverter#getKeysFromElement(Element)}
   */
  @Test
  @DisplayName("Test getKeysFromElement(Element)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Pair AbstractCoreKeyAccumuloElementConverter.getKeysFromElement(Element)"})
  void testGetKeysFromElement() {
    // Arrange
    Schema schema = mock(Schema.class);
    when(schema.getElement(Mockito.<String>any()))
        .thenThrow(new AccumuloElementConversionException("An error occurred"));
    when(schema.getConfig(Mockito.<String>any())).thenReturn("Config");
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.getVertexSerialiser()).thenReturn(new AvroSerialiser());
    ByteEntityAccumuloElementConverter byteEntityAccumuloElementConverter =
        new ByteEntityAccumuloElementConverter(schema);

    // Act and Assert
    assertThrows(
        AccumuloElementConversionException.class,
        () ->
            byteEntityAccumuloElementConverter.getKeysFromElement(
                new Entity.Builder().group("Group").vertex("Vertex").build()));
    verify(schema).getAggregatedGroups();
    verify(schema).getConfig("timestampProperty");
    verify(schema).getElement("Group");
    verify(schema).getVertexSerialiser();
  }

  /**
   * Test {@link AbstractCoreKeyAccumuloElementConverter#getKeysFromElement(Element)}.
   *
   * <ul>
   *   <li>Given {@link Schema} {@link Schema#getElement(String)} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractCoreKeyAccumuloElementConverter#getKeysFromElement(Element)}
   */
  @Test
  @DisplayName("Test getKeysFromElement(Element); given Schema getElement(String) return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Pair AbstractCoreKeyAccumuloElementConverter.getKeysFromElement(Element)"})
  void testGetKeysFromElement_givenSchemaGetElementReturnNull() {
    // Arrange
    Schema schema = mock(Schema.class);
    when(schema.getElement(Mockito.<String>any())).thenReturn(null);
    when(schema.getConfig(Mockito.<String>any())).thenReturn("Config");
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.getVertexSerialiser()).thenReturn(new AvroSerialiser());
    ByteEntityAccumuloElementConverter byteEntityAccumuloElementConverter =
        new ByteEntityAccumuloElementConverter(schema);

    // Act and Assert
    assertThrows(
        AccumuloElementConversionException.class,
        () ->
            byteEntityAccumuloElementConverter.getKeysFromElement(
                new Entity.Builder().group("Group").vertex("Vertex").build()));
    verify(schema).getAggregatedGroups();
    verify(schema).getConfig("timestampProperty");
    verify(schema).getElement("Group");
    verify(schema).getVertexSerialiser();
  }

  /**
   * Test {@link AbstractCoreKeyAccumuloElementConverter#getKeysFromElement(Element)}.
   *
   * <ul>
   *   <li>Then calls {@link Schema#getVisibilityProperty()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractCoreKeyAccumuloElementConverter#getKeysFromElement(Element)}
   */
  @Test
  @DisplayName("Test getKeysFromElement(Element); then calls getVisibilityProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Pair AbstractCoreKeyAccumuloElementConverter.getKeysFromElement(Element)"})
  void testGetKeysFromElement_thenCallsGetVisibilityProperty() {
    // Arrange
    Schema schema = mock(Schema.class);
    when(schema.getVisibilityProperty())
        .thenThrow(new AccumuloElementConversionException("An error occurred"));
    when(schema.getElement(Mockito.<String>any())).thenReturn(new SchemaEdgeDefinition());
    when(schema.getConfig(Mockito.<String>any())).thenReturn("Config");
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.getVertexSerialiser()).thenReturn(new AvroSerialiser());
    ByteEntityAccumuloElementConverter byteEntityAccumuloElementConverter =
        new ByteEntityAccumuloElementConverter(schema);

    // Act and Assert
    assertThrows(
        AccumuloElementConversionException.class,
        () ->
            byteEntityAccumuloElementConverter.getKeysFromElement(
                new Entity.Builder().group("Group").vertex("Vertex").build()));
    verify(schema).getAggregatedGroups();
    verify(schema).getConfig("timestampProperty");
    verify(schema, atLeast(1)).getElement("Group");
    verify(schema).getVertexSerialiser();
    verify(schema).getVisibilityProperty();
  }

  /**
   * Test {@link AbstractCoreKeyAccumuloElementConverter#getKeysFromEdge(Edge)}.
   *
   * <p>Method under test: {@link AbstractCoreKeyAccumuloElementConverter#getKeysFromEdge(Edge)}
   */
  @Test
  @DisplayName("Test getKeysFromEdge(Edge)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Pair AbstractCoreKeyAccumuloElementConverter.getKeysFromEdge(Edge)"})
  void testGetKeysFromEdge() {
    // Arrange
    Schema schema = mock(Schema.class);
    when(schema.getElement(Mockito.<String>any()))
        .thenThrow(new AccumuloElementConversionException("An error occurred"));
    when(schema.getConfig(Mockito.<String>any())).thenReturn("Config");
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.getVertexSerialiser()).thenReturn(new AvroSerialiser());
    ByteEntityAccumuloElementConverter byteEntityAccumuloElementConverter =
        new ByteEntityAccumuloElementConverter(schema);

    // Act and Assert
    assertThrows(
        AccumuloElementConversionException.class,
        () ->
            byteEntityAccumuloElementConverter.getKeysFromEdge(
                new Builder()
                    .dest("Dest")
                    .directed(true)
                    .group("Group")
                    .matchedVertex(MatchedVertex.SOURCE)
                    .source("Source")
                    .build()));
    verify(schema).getAggregatedGroups();
    verify(schema).getConfig("timestampProperty");
    verify(schema).getElement("Group");
    verify(schema, atLeast(1)).getVertexSerialiser();
  }

  /**
   * Test {@link AbstractCoreKeyAccumuloElementConverter#getKeysFromEdge(Edge)}.
   *
   * <ul>
   *   <li>Given {@link Schema} {@link Schema#getElement(String)} return {@code null}.
   *   <li>Then calls {@link Schema#getElement(String)}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractCoreKeyAccumuloElementConverter#getKeysFromEdge(Edge)}
   */
  @Test
  @DisplayName(
      "Test getKeysFromEdge(Edge); given Schema getElement(String) return 'null'; then calls getElement(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Pair AbstractCoreKeyAccumuloElementConverter.getKeysFromEdge(Edge)"})
  void testGetKeysFromEdge_givenSchemaGetElementReturnNull_thenCallsGetElement() {
    // Arrange
    Schema schema = mock(Schema.class);
    when(schema.getElement(Mockito.<String>any())).thenReturn(null);
    when(schema.getConfig(Mockito.<String>any())).thenReturn("Config");
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.getVertexSerialiser()).thenReturn(new AvroSerialiser());
    ByteEntityAccumuloElementConverter byteEntityAccumuloElementConverter =
        new ByteEntityAccumuloElementConverter(schema);

    // Act and Assert
    assertThrows(
        AccumuloElementConversionException.class,
        () ->
            byteEntityAccumuloElementConverter.getKeysFromEdge(
                new Builder()
                    .dest("Dest")
                    .directed(true)
                    .group("Group")
                    .matchedVertex(MatchedVertex.SOURCE)
                    .source("Source")
                    .build()));
    verify(schema).getAggregatedGroups();
    verify(schema).getConfig("timestampProperty");
    verify(schema).getElement("Group");
    verify(schema, atLeast(1)).getVertexSerialiser();
  }

  /**
   * Test {@link AbstractCoreKeyAccumuloElementConverter#getKeysFromEdge(Edge)}.
   *
   * <ul>
   *   <li>Then calls {@link Schema#getVisibilityProperty()}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractCoreKeyAccumuloElementConverter#getKeysFromEdge(Edge)}
   */
  @Test
  @DisplayName("Test getKeysFromEdge(Edge); then calls getVisibilityProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Pair AbstractCoreKeyAccumuloElementConverter.getKeysFromEdge(Edge)"})
  void testGetKeysFromEdge_thenCallsGetVisibilityProperty() {
    // Arrange
    Schema schema = mock(Schema.class);
    when(schema.getVisibilityProperty())
        .thenThrow(new AccumuloElementConversionException("An error occurred"));
    when(schema.getElement(Mockito.<String>any())).thenReturn(new SchemaEdgeDefinition());
    when(schema.getConfig(Mockito.<String>any())).thenReturn("Config");
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.getVertexSerialiser()).thenReturn(new AvroSerialiser());
    ByteEntityAccumuloElementConverter byteEntityAccumuloElementConverter =
        new ByteEntityAccumuloElementConverter(schema);

    // Act and Assert
    assertThrows(
        AccumuloElementConversionException.class,
        () ->
            byteEntityAccumuloElementConverter.getKeysFromEdge(
                new Builder()
                    .dest("Dest")
                    .directed(true)
                    .group("Group")
                    .matchedVertex(MatchedVertex.SOURCE)
                    .source("Source")
                    .build()));
    verify(schema).getAggregatedGroups();
    verify(schema).getConfig("timestampProperty");
    verify(schema, atLeast(1)).getElement("Group");
    verify(schema, atLeast(1)).getVertexSerialiser();
    verify(schema).getVisibilityProperty();
  }

  /**
   * Test {@link AbstractCoreKeyAccumuloElementConverter#getKeysFromEdge(Edge)}.
   *
   * <ul>
   *   <li>Then calls {@link AvroSerialiser#serialise(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractCoreKeyAccumuloElementConverter#getKeysFromEdge(Edge)}
   */
  @Test
  @DisplayName("Test getKeysFromEdge(Edge); then calls serialise(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Pair AbstractCoreKeyAccumuloElementConverter.getKeysFromEdge(Edge)"})
  void testGetKeysFromEdge_thenCallsSerialise() throws SerialisationException {
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

    // Act and Assert
    assertThrows(
        AccumuloElementConversionException.class,
        () ->
            byteEntityAccumuloElementConverter.getKeysFromEdge(
                new Builder()
                    .dest("Dest")
                    .directed(true)
                    .group("Group")
                    .matchedVertex(MatchedVertex.SOURCE)
                    .source("Source")
                    .build()));
    verify(avroSerialiser).serialise(isA(Object.class));
    verify(schema).getAggregatedGroups();
    verify(schema).getConfig("timestampProperty");
    verify(schema).getVertexSerialiser();
  }

  /**
   * Test {@link AbstractCoreKeyAccumuloElementConverter#getKeyFromEntity(Entity)}.
   *
   * <p>Method under test: {@link AbstractCoreKeyAccumuloElementConverter#getKeyFromEntity(Entity)}
   */
  @Test
  @DisplayName("Test getKeyFromEntity(Entity)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Key AbstractCoreKeyAccumuloElementConverter.getKeyFromEntity(Entity)"})
  void testGetKeyFromEntity() {
    // Arrange
    Schema schema = mock(Schema.class);
    when(schema.getElement(Mockito.<String>any()))
        .thenThrow(new AccumuloElementConversionException("An error occurred"));
    when(schema.getConfig(Mockito.<String>any())).thenReturn("Config");
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.getVertexSerialiser()).thenReturn(new AvroSerialiser());
    ByteEntityAccumuloElementConverter byteEntityAccumuloElementConverter =
        new ByteEntityAccumuloElementConverter(schema);

    Entity entity = new Entity.Builder().group("Group").vertex("Vertex").build();
    entity.putProperty("Name", "Value");

    // Act and Assert
    assertThrows(
        AccumuloElementConversionException.class,
        () -> byteEntityAccumuloElementConverter.getKeyFromEntity(entity));
    verify(schema).getAggregatedGroups();
    verify(schema).getConfig("timestampProperty");
    verify(schema).getElement("Group");
    verify(schema).getVertexSerialiser();
  }

  /**
   * Test {@link AbstractCoreKeyAccumuloElementConverter#getKeyFromEntity(Entity)}.
   *
   * <p>Method under test: {@link AbstractCoreKeyAccumuloElementConverter#getKeyFromEntity(Entity)}
   */
  @Test
  @DisplayName("Test getKeyFromEntity(Entity)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Key AbstractCoreKeyAccumuloElementConverter.getKeyFromEntity(Entity)"})
  void testGetKeyFromEntity2() throws SerialisationException {
    // Arrange
    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("");

    AvroSerialiser serialiser = mock(AvroSerialiser.class);
    when(serialiser.serialise(Mockito.<Object>any()))
        .thenThrow(new SerialisationException("An error occurred"));

    TypeDefinition.Builder builder = new TypeDefinition.Builder();
    builder.serialiser(serialiser);
    TypeDefinition typeDefinition = builder.aggregateFunction(mock(BinaryOperator.class)).build();

    SchemaElementDefinition schemaElementDefinition = mock(SchemaElementDefinition.class);
    when(schemaElementDefinition.getGroupBy()).thenReturn(stringSet);
    when(schemaElementDefinition.getPropertyTypeDef(Mockito.<String>any()))
        .thenReturn(typeDefinition);

    Schema schema = mock(Schema.class);
    when(schema.getElement(Mockito.<String>any())).thenReturn(schemaElementDefinition);
    when(schema.getConfig(Mockito.<String>any())).thenReturn("Config");
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.getVertexSerialiser()).thenReturn(new AvroSerialiser());
    ByteEntityAccumuloElementConverter byteEntityAccumuloElementConverter =
        new ByteEntityAccumuloElementConverter(schema);

    Entity entity = new Entity.Builder().group("Group").vertex("Vertex").build();
    entity.putProperty("", "Value");

    // Act and Assert
    assertThrows(
        AccumuloElementConversionException.class,
        () -> byteEntityAccumuloElementConverter.getKeyFromEntity(entity));
    verify(serialiser).serialise(isA(Object.class));
    verify(schema).getAggregatedGroups();
    verify(schema).getConfig("timestampProperty");
    verify(schema).getElement("Group");
    verify(schema).getVertexSerialiser();
    verify(schemaElementDefinition).getGroupBy();
    verify(schemaElementDefinition).getPropertyTypeDef("");
  }

  /**
   * Test {@link AbstractCoreKeyAccumuloElementConverter#getKeyFromEntity(Entity)}.
   *
   * <p>Method under test: {@link AbstractCoreKeyAccumuloElementConverter#getKeyFromEntity(Entity)}
   */
  @Test
  @DisplayName("Test getKeyFromEntity(Entity)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Key AbstractCoreKeyAccumuloElementConverter.getKeyFromEntity(Entity)"})
  void testGetKeyFromEntity3() throws SerialisationException {
    // Arrange
    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("");

    AvroSerialiser serialiser = mock(AvroSerialiser.class);
    when(serialiser.serialise(Mockito.<Object>any()))
        .thenThrow(new AccumuloElementConversionException("An error occurred"));

    TypeDefinition.Builder builder = new TypeDefinition.Builder();
    builder.serialiser(serialiser);
    TypeDefinition typeDefinition = builder.aggregateFunction(mock(BinaryOperator.class)).build();

    SchemaElementDefinition schemaElementDefinition = mock(SchemaElementDefinition.class);
    when(schemaElementDefinition.getGroupBy()).thenReturn(stringSet);
    when(schemaElementDefinition.getPropertyTypeDef(Mockito.<String>any()))
        .thenReturn(typeDefinition);

    Schema schema = mock(Schema.class);
    when(schema.getElement(Mockito.<String>any())).thenReturn(schemaElementDefinition);
    when(schema.getConfig(Mockito.<String>any())).thenReturn("Config");
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.getVertexSerialiser()).thenReturn(new AvroSerialiser());
    ByteEntityAccumuloElementConverter byteEntityAccumuloElementConverter =
        new ByteEntityAccumuloElementConverter(schema);

    Entity entity = new Entity.Builder().group("Group").vertex("Vertex").build();
    entity.putProperty("", "Value");

    // Act and Assert
    assertThrows(
        AccumuloElementConversionException.class,
        () -> byteEntityAccumuloElementConverter.getKeyFromEntity(entity));
    verify(serialiser).serialise(isA(Object.class));
    verify(schema).getAggregatedGroups();
    verify(schema).getConfig("timestampProperty");
    verify(schema).getElement("Group");
    verify(schema).getVertexSerialiser();
    verify(schemaElementDefinition).getGroupBy();
    verify(schemaElementDefinition).getPropertyTypeDef("");
  }

  /**
   * Test {@link AbstractCoreKeyAccumuloElementConverter#getKeyFromEntity(Entity)}.
   *
   * <ul>
   *   <li>Given {@link Schema} {@link Schema#getElement(String)} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractCoreKeyAccumuloElementConverter#getKeyFromEntity(Entity)}
   */
  @Test
  @DisplayName("Test getKeyFromEntity(Entity); given Schema getElement(String) return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Key AbstractCoreKeyAccumuloElementConverter.getKeyFromEntity(Entity)"})
  void testGetKeyFromEntity_givenSchemaGetElementReturnNull() {
    // Arrange
    Schema schema = mock(Schema.class);
    when(schema.getElement(Mockito.<String>any())).thenReturn(null);
    when(schema.getConfig(Mockito.<String>any())).thenReturn("Config");
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.getVertexSerialiser()).thenReturn(new AvroSerialiser());
    ByteEntityAccumuloElementConverter byteEntityAccumuloElementConverter =
        new ByteEntityAccumuloElementConverter(schema);

    Entity entity = new Entity.Builder().group("Group").vertex("Vertex").build();
    entity.putProperty("Name", "Value");

    // Act and Assert
    assertThrows(
        AccumuloElementConversionException.class,
        () -> byteEntityAccumuloElementConverter.getKeyFromEntity(entity));
    verify(schema).getAggregatedGroups();
    verify(schema).getConfig("timestampProperty");
    verify(schema).getElement("Group");
    verify(schema).getVertexSerialiser();
  }

  /**
   * Test {@link AbstractCoreKeyAccumuloElementConverter#getKeyFromEntity(Entity)}.
   *
   * <ul>
   *   <li>Then calls {@link Schema#getVisibilityProperty()}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractCoreKeyAccumuloElementConverter#getKeyFromEntity(Entity)}
   */
  @Test
  @DisplayName("Test getKeyFromEntity(Entity); then calls getVisibilityProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Key AbstractCoreKeyAccumuloElementConverter.getKeyFromEntity(Entity)"})
  void testGetKeyFromEntity_thenCallsGetVisibilityProperty() {
    // Arrange
    Schema schema = mock(Schema.class);
    when(schema.getVisibilityProperty())
        .thenThrow(new AccumuloElementConversionException("An error occurred"));
    when(schema.getElement(Mockito.<String>any())).thenReturn(new SchemaEdgeDefinition());
    when(schema.getConfig(Mockito.<String>any())).thenReturn("Config");
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.getVertexSerialiser()).thenReturn(new AvroSerialiser());
    ByteEntityAccumuloElementConverter byteEntityAccumuloElementConverter =
        new ByteEntityAccumuloElementConverter(schema);

    Entity entity = new Entity.Builder().group("Group").vertex("Vertex").build();
    entity.putProperty("Name", "Value");

    // Act and Assert
    assertThrows(
        AccumuloElementConversionException.class,
        () -> byteEntityAccumuloElementConverter.getKeyFromEntity(entity));
    verify(schema).getAggregatedGroups();
    verify(schema).getConfig("timestampProperty");
    verify(schema, atLeast(1)).getElement("Group");
    verify(schema).getVertexSerialiser();
    verify(schema).getVisibilityProperty();
  }

  /**
   * Test {@link AbstractCoreKeyAccumuloElementConverter#getValueFromProperties(String,
   * Properties)}.
   *
   * <ul>
   *   <li>Then throw {@link AccumuloElementConversionException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractCoreKeyAccumuloElementConverter#getValueFromProperties(String, Properties)}
   */
  @Test
  @DisplayName(
      "Test getValueFromProperties(String, Properties); then throw AccumuloElementConversionException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Value AbstractCoreKeyAccumuloElementConverter.getValueFromProperties(String, Properties)"
  })
  void testGetValueFromProperties_thenThrowAccumuloElementConversionException() {
    // Arrange
    ByteEntityAccumuloElementConverter byteEntityAccumuloElementConverter =
        new ByteEntityAccumuloElementConverter(new Schema());

    // Act and Assert
    assertThrows(
        AccumuloElementConversionException.class,
        () -> byteEntityAccumuloElementConverter.getValueFromProperties("Group", new Properties()));
  }

  /**
   * Test {@link AbstractCoreKeyAccumuloElementConverter#getValueFromElement(Element)}.
   *
   * <ul>
   *   <li>Then throw {@link AccumuloElementConversionException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractCoreKeyAccumuloElementConverter#getValueFromElement(Element)}
   */
  @Test
  @DisplayName("Test getValueFromElement(Element); then throw AccumuloElementConversionException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Value AbstractCoreKeyAccumuloElementConverter.getValueFromElement(Element)"})
  void testGetValueFromElement_thenThrowAccumuloElementConversionException() {
    // Arrange
    ByteEntityAccumuloElementConverter byteEntityAccumuloElementConverter =
        new ByteEntityAccumuloElementConverter(new Schema());

    // Act and Assert
    assertThrows(
        AccumuloElementConversionException.class,
        () -> byteEntityAccumuloElementConverter.getValueFromElement(new Edge("Group")));
  }

  /**
   * Test {@link AbstractCoreKeyAccumuloElementConverter#getPropertiesFromValue(String, Value)}.
   *
   * <ul>
   *   <li>Then throw {@link AccumuloElementConversionException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractCoreKeyAccumuloElementConverter#getPropertiesFromValue(String, Value)}
   */
  @Test
  @DisplayName(
      "Test getPropertiesFromValue(String, Value); then throw AccumuloElementConversionException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Properties AbstractCoreKeyAccumuloElementConverter.getPropertiesFromValue(String, Value)"
  })
  void testGetPropertiesFromValue_thenThrowAccumuloElementConversionException() {
    // Arrange
    ByteEntityAccumuloElementConverter byteEntityAccumuloElementConverter =
        new ByteEntityAccumuloElementConverter(new Schema());

    // Act and Assert
    assertThrows(
        AccumuloElementConversionException.class,
        () ->
            byteEntityAccumuloElementConverter.getPropertiesFromValue(
                "Group", new Value(RFile.EXTENSION)));
  }

  /**
   * Test {@link AbstractCoreKeyAccumuloElementConverter#getPropertiesFromValue(String, Value)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractCoreKeyAccumuloElementConverter#getPropertiesFromValue(String, Value)}
   */
  @Test
  @DisplayName("Test getPropertiesFromValue(String, Value); when 'null'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Properties AbstractCoreKeyAccumuloElementConverter.getPropertiesFromValue(String, Value)"
  })
  void testGetPropertiesFromValue_whenNull_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(
        new ByteEntityAccumuloElementConverter(new Schema())
            .getPropertiesFromValue("Group", null)
            .isEmpty());
  }

  /**
   * Test {@link AbstractCoreKeyAccumuloElementConverter#getPropertiesFromValue(String, Value)}.
   *
   * <ul>
   *   <li>When {@link Value#Value()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractCoreKeyAccumuloElementConverter#getPropertiesFromValue(String, Value)}
   */
  @Test
  @DisplayName("Test getPropertiesFromValue(String, Value); when Value(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Properties AbstractCoreKeyAccumuloElementConverter.getPropertiesFromValue(String, Value)"
  })
  void testGetPropertiesFromValue_whenValue_thenReturnEmpty() {
    // Arrange
    ByteEntityAccumuloElementConverter byteEntityAccumuloElementConverter =
        new ByteEntityAccumuloElementConverter(new Schema());

    // Act and Assert
    assertTrue(
        byteEntityAccumuloElementConverter.getPropertiesFromValue("Group", new Value()).isEmpty());
  }

  /**
   * Test {@link AbstractCoreKeyAccumuloElementConverter#getElementFromKey(Key, boolean)}.
   *
   * <ul>
   *   <li>Then throw {@link AccumuloElementConversionException}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractCoreKeyAccumuloElementConverter#getElementFromKey(Key,
   * boolean)}
   */
  @Test
  @DisplayName(
      "Test getElementFromKey(Key, boolean); then throw AccumuloElementConversionException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Element AbstractCoreKeyAccumuloElementConverter.getElementFromKey(Key, boolean)"
  })
  void testGetElementFromKey_thenThrowAccumuloElementConversionException() {
    // Arrange
    ByteEntityAccumuloElementConverter byteEntityAccumuloElementConverter =
        new ByteEntityAccumuloElementConverter(new Schema());

    Key key = mock(Key.class);
    when(key.getColumnFamilyData())
        .thenThrow(new AccumuloElementConversionException("An error occurred"));
    ByteBuffer buffer = ByteBuffer.wrap(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});
    when(key.getRowData()).thenReturn(new ArrayByteSequence(buffer));

    // Act and Assert
    assertThrows(
        AccumuloElementConversionException.class,
        () -> byteEntityAccumuloElementConverter.getElementFromKey(key, true));
    verify(key).getColumnFamilyData();
    verify(key).getRowData();
  }

  /**
   * Test {@link AbstractCoreKeyAccumuloElementConverter#getRowKeysFromElement(Element)}.
   *
   * <p>Method under test: {@link
   * AbstractCoreKeyAccumuloElementConverter#getRowKeysFromElement(Element)}
   */
  @Test
  @DisplayName("Test getRowKeysFromElement(Element)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Pair AbstractCoreKeyAccumuloElementConverter.getRowKeysFromElement(Element)"})
  void testGetRowKeysFromElement() {
    // Arrange
    Schema schema = mock(Schema.class);
    when(schema.getConfig(Mockito.<String>any())).thenReturn("Config");
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.getVertexSerialiser()).thenReturn(new AvroSerialiser());
    ByteEntityAccumuloElementConverter byteEntityAccumuloElementConverter =
        new ByteEntityAccumuloElementConverter(schema);

    // Act
    byteEntityAccumuloElementConverter.getRowKeysFromElement(
        new Builder()
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
   * Test {@link AbstractCoreKeyAccumuloElementConverter#getRowKeysFromElement(Element)}.
   *
   * <ul>
   *   <li>Then return Second is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractCoreKeyAccumuloElementConverter#getRowKeysFromElement(Element)}
   */
  @Test
  @DisplayName("Test getRowKeysFromElement(Element); then return Second is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Pair AbstractCoreKeyAccumuloElementConverter.getRowKeysFromElement(Element)"})
  void testGetRowKeysFromElement_thenReturnSecondIsNull() {
    // Arrange
    Schema schema = mock(Schema.class);
    when(schema.getConfig(Mockito.<String>any())).thenReturn("Config");
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.getVertexSerialiser()).thenReturn(new AvroSerialiser());
    ByteEntityAccumuloElementConverter byteEntityAccumuloElementConverter =
        new ByteEntityAccumuloElementConverter(schema);

    // Act
    Pair<byte[], byte[]> actualRowKeysFromElement =
        byteEntityAccumuloElementConverter.getRowKeysFromElement(
            new Entity.Builder().group("Group").vertex("Vertex").build());

    // Assert
    verify(schema).getAggregatedGroups();
    verify(schema).getConfig("timestampProperty");
    verify(schema).getVertexSerialiser();
    assertNull(actualRowKeysFromElement.getSecond());
    assertEquals(72, actualRowKeysFromElement.getFirst().length);
  }

  /**
   * Test {@link AbstractCoreKeyAccumuloElementConverter#buildColumnFamily(String)}.
   *
   * <p>Method under test: {@link AbstractCoreKeyAccumuloElementConverter#buildColumnFamily(String)}
   */
  @Test
  @DisplayName("Test buildColumnFamily(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] AbstractCoreKeyAccumuloElementConverter.buildColumnFamily(String)"})
  void testBuildColumnFamily() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertArrayEquals(
        "Group".getBytes("UTF-8"),
        new ByteEntityAccumuloElementConverter(new Schema()).buildColumnFamily("Group"));
  }

  /**
   * Test {@link AbstractCoreKeyAccumuloElementConverter#getGroupFromColumnFamily(byte[])}.
   *
   * <p>Method under test: {@link
   * AbstractCoreKeyAccumuloElementConverter#getGroupFromColumnFamily(byte[])}
   */
  @Test
  @DisplayName("Test getGroupFromColumnFamily(byte[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String AbstractCoreKeyAccumuloElementConverter.getGroupFromColumnFamily(byte[])"
  })
  void testGetGroupFromColumnFamily() throws UnsupportedEncodingException {
    // Arrange and Act
    String actualGroupFromColumnFamily =
        new ByteEntityAccumuloElementConverter(new Schema())
            .getGroupFromColumnFamily("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals("AXAXAXAX", actualGroupFromColumnFamily);
  }

  /**
   * Test {@link AbstractCoreKeyAccumuloElementConverter#buildColumnVisibility(String, Properties)}.
   *
   * <ul>
   *   <li>Then throw {@link AccumuloElementConversionException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractCoreKeyAccumuloElementConverter#buildColumnVisibility(String, Properties)}
   */
  @Test
  @DisplayName(
      "Test buildColumnVisibility(String, Properties); then throw AccumuloElementConversionException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "byte[] AbstractCoreKeyAccumuloElementConverter.buildColumnVisibility(String, Properties)"
  })
  void testBuildColumnVisibility_thenThrowAccumuloElementConversionException() {
    // Arrange
    ByteEntityAccumuloElementConverter byteEntityAccumuloElementConverter =
        new ByteEntityAccumuloElementConverter(new Schema());

    // Act and Assert
    assertThrows(
        AccumuloElementConversionException.class,
        () -> byteEntityAccumuloElementConverter.buildColumnVisibility("Group", new Properties()));
  }

  /**
   * Test {@link AbstractCoreKeyAccumuloElementConverter#getPropertiesFromColumnVisibility(String,
   * byte[])}.
   *
   * <p>Method under test: {@link
   * AbstractCoreKeyAccumuloElementConverter#getPropertiesFromColumnVisibility(String, byte[])}
   */
  @Test
  @DisplayName("Test getPropertiesFromColumnVisibility(String, byte[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Properties AbstractCoreKeyAccumuloElementConverter.getPropertiesFromColumnVisibility(String, byte[])"
  })
  void testGetPropertiesFromColumnVisibility() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertThrows(
        AccumuloElementConversionException.class,
        () ->
            new ByteEntityAccumuloElementConverter(new Schema())
                .getPropertiesFromColumnVisibility("Group", "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link AbstractCoreKeyAccumuloElementConverter#buildColumnQualifier(String, Properties)}.
   *
   * <ul>
   *   <li>Then throw {@link AccumuloElementConversionException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractCoreKeyAccumuloElementConverter#buildColumnQualifier(String, Properties)}
   */
  @Test
  @DisplayName(
      "Test buildColumnQualifier(String, Properties); then throw AccumuloElementConversionException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "byte[] AbstractCoreKeyAccumuloElementConverter.buildColumnQualifier(String, Properties)"
  })
  void testBuildColumnQualifier_thenThrowAccumuloElementConversionException() {
    // Arrange
    ByteEntityAccumuloElementConverter byteEntityAccumuloElementConverter =
        new ByteEntityAccumuloElementConverter(new Schema());

    // Act and Assert
    assertThrows(
        AccumuloElementConversionException.class,
        () -> byteEntityAccumuloElementConverter.buildColumnQualifier("Group", new Properties()));
  }

  /**
   * Test {@link AbstractCoreKeyAccumuloElementConverter#serialiseSizeAndPropertyValue(String,
   * SchemaElementDefinition, Properties, ByteArrayOutputStream)}.
   *
   * <p>Method under test: {@link
   * AbstractCoreKeyAccumuloElementConverter#serialiseSizeAndPropertyValue(String,
   * SchemaElementDefinition, Properties, ByteArrayOutputStream)}
   */
  @Test
  @DisplayName(
      "Test serialiseSizeAndPropertyValue(String, SchemaElementDefinition, Properties, ByteArrayOutputStream)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AbstractCoreKeyAccumuloElementConverter.serialiseSizeAndPropertyValue(String, SchemaElementDefinition, Properties, ByteArrayOutputStream)"
  })
  void testSerialiseSizeAndPropertyValue() {
    // Arrange
    ByteEntityAccumuloElementConverter byteEntityAccumuloElementConverter =
        new ByteEntityAccumuloElementConverter(new Schema());
    SchemaEdgeDefinition elementDefinition = new SchemaEdgeDefinition();
    Properties properties = new Properties();
    ByteArrayOutputStream stream = new ByteArrayOutputStream();

    // Act
    byteEntityAccumuloElementConverter.serialiseSizeAndPropertyValue(
        "Property Name", elementDefinition, properties, stream);

    // Assert
    assertArrayEquals(new byte[] {0}, stream.toByteArray());
  }

  /**
   * Test {@link AbstractCoreKeyAccumuloElementConverter#getPropertiesFromColumnQualifier(String,
   * byte[])}.
   *
   * <ul>
   *   <li>Then throw {@link AccumuloElementConversionException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractCoreKeyAccumuloElementConverter#getPropertiesFromColumnQualifier(String, byte[])}
   */
  @Test
  @DisplayName(
      "Test getPropertiesFromColumnQualifier(String, byte[]); then throw AccumuloElementConversionException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Properties AbstractCoreKeyAccumuloElementConverter.getPropertiesFromColumnQualifier(String, byte[])"
  })
  void testGetPropertiesFromColumnQualifier_thenThrowAccumuloElementConversionException()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertThrows(
        AccumuloElementConversionException.class,
        () ->
            new ByteEntityAccumuloElementConverter(new Schema())
                .getPropertiesFromColumnQualifier("Group", "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link AbstractCoreKeyAccumuloElementConverter#getPropertiesFromColumnQualifier(String,
   * byte[])}.
   *
   * <ul>
   *   <li>When empty array of {@code byte}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractCoreKeyAccumuloElementConverter#getPropertiesFromColumnQualifier(String, byte[])}
   */
  @Test
  @DisplayName(
      "Test getPropertiesFromColumnQualifier(String, byte[]); when empty array of byte; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Properties AbstractCoreKeyAccumuloElementConverter.getPropertiesFromColumnQualifier(String, byte[])"
  })
  void testGetPropertiesFromColumnQualifier_whenEmptyArrayOfByte_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(
        new ByteEntityAccumuloElementConverter(new Schema())
            .getPropertiesFromColumnQualifier("Group", new byte[] {})
            .isEmpty());
  }

  /**
   * Test {@link
   * AbstractCoreKeyAccumuloElementConverter#getPropertiesAsBytesFromColumnQualifier(String, byte[],
   * int)}.
   *
   * <p>Method under test: {@link
   * AbstractCoreKeyAccumuloElementConverter#getPropertiesAsBytesFromColumnQualifier(String, byte[],
   * int)}
   */
  @Test
  @DisplayName("Test getPropertiesAsBytesFromColumnQualifier(String, byte[], int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BytesAndRange AbstractCoreKeyAccumuloElementConverter.getPropertiesAsBytesFromColumnQualifier(String, byte[], int)"
  })
  void testGetPropertiesAsBytesFromColumnQualifier() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertThrows(
        AccumuloElementConversionException.class,
        () ->
            new ByteEntityAccumuloElementConverter(new Schema())
                .getPropertiesAsBytesFromColumnQualifier(
                    "Group", "AXAXAXAX".getBytes("UTF-8"), 10));
  }

  /**
   * Test {@link
   * AbstractCoreKeyAccumuloElementConverter#getPropertiesAsBytesFromColumnQualifier(String, byte[],
   * int)}.
   *
   * <ul>
   *   <li>Then return Bytes is {@code AXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractCoreKeyAccumuloElementConverter#getPropertiesAsBytesFromColumnQualifier(String, byte[],
   * int)}
   */
  @Test
  @DisplayName(
      "Test getPropertiesAsBytesFromColumnQualifier(String, byte[], int); then return Bytes is 'AXAXAXAX' Bytes is 'UTF-8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BytesAndRange AbstractCoreKeyAccumuloElementConverter.getPropertiesAsBytesFromColumnQualifier(String, byte[], int)"
  })
  void testGetPropertiesAsBytesFromColumnQualifier_thenReturnBytesIsAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange and Act
    BytesAndRange actualPropertiesAsBytesFromColumnQualifier =
        new ByteEntityAccumuloElementConverter(new Schema())
            .getPropertiesAsBytesFromColumnQualifier("Group", "AXAXAXAX".getBytes("UTF-8"), 0);

    // Assert
    assertEquals(0, actualPropertiesAsBytesFromColumnQualifier.getLength());
    assertEquals(0, actualPropertiesAsBytesFromColumnQualifier.getOffSet());
    assertArrayEquals(
        "AXAXAXAX".getBytes("UTF-8"), actualPropertiesAsBytesFromColumnQualifier.getBytes());
  }

  /**
   * Test {@link
   * AbstractCoreKeyAccumuloElementConverter#getPropertiesAsBytesFromColumnQualifier(String, byte[],
   * int)}.
   *
   * <ul>
   *   <li>Then return Bytes is empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractCoreKeyAccumuloElementConverter#getPropertiesAsBytesFromColumnQualifier(String, byte[],
   * int)}
   */
  @Test
  @DisplayName(
      "Test getPropertiesAsBytesFromColumnQualifier(String, byte[], int); then return Bytes is empty array of byte")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BytesAndRange AbstractCoreKeyAccumuloElementConverter.getPropertiesAsBytesFromColumnQualifier(String, byte[], int)"
  })
  void testGetPropertiesAsBytesFromColumnQualifier_thenReturnBytesIsEmptyArrayOfByte() {
    // Arrange and Act
    BytesAndRange actualPropertiesAsBytesFromColumnQualifier =
        new ByteEntityAccumuloElementConverter(new Schema())
            .getPropertiesAsBytesFromColumnQualifier("Group", new byte[] {}, 10);

    // Assert
    assertEquals(0, actualPropertiesAsBytesFromColumnQualifier.getLength());
    assertEquals(0, actualPropertiesAsBytesFromColumnQualifier.getOffSet());
    assertArrayEquals(new byte[] {}, actualPropertiesAsBytesFromColumnQualifier.getBytes());
  }

  /**
   * Test {@link AbstractCoreKeyAccumuloElementConverter#isColumnQualifierBytesValid(byte[], int)}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractCoreKeyAccumuloElementConverter#isColumnQualifierBytesValid(byte[], int)}
   */
  @Test
  @DisplayName(
      "Test isColumnQualifierBytesValid(byte[], int); when 'AXAXAXAX' Bytes is 'UTF-8'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AbstractCoreKeyAccumuloElementConverter.isColumnQualifierBytesValid(byte[], int)"
  })
  void testIsColumnQualifierBytesValid_whenAxaxaxaxBytesIsUtf8_thenReturnTrue()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertTrue(
        new ByteEntityAccumuloElementConverter(new Schema())
            .isColumnQualifierBytesValid("AXAXAXAX".getBytes("UTF-8"), 10));
  }

  /**
   * Test {@link AbstractCoreKeyAccumuloElementConverter#isColumnQualifierBytesValid(byte[], int)}.
   *
   * <ul>
   *   <li>When empty array of {@code byte}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractCoreKeyAccumuloElementConverter#isColumnQualifierBytesValid(byte[], int)}
   */
  @Test
  @DisplayName(
      "Test isColumnQualifierBytesValid(byte[], int); when empty array of byte; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AbstractCoreKeyAccumuloElementConverter.isColumnQualifierBytesValid(byte[], int)"
  })
  void testIsColumnQualifierBytesValid_whenEmptyArrayOfByte_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(
        new ByteEntityAccumuloElementConverter(new Schema())
            .isColumnQualifierBytesValid(new byte[] {}, 10));
  }

  /**
   * Test {@link AbstractCoreKeyAccumuloElementConverter#isColumnQualifierBytesValid(byte[], int)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractCoreKeyAccumuloElementConverter#isColumnQualifierBytesValid(byte[], int)}
   */
  @Test
  @DisplayName("Test isColumnQualifierBytesValid(byte[], int); when 'null'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AbstractCoreKeyAccumuloElementConverter.isColumnQualifierBytesValid(byte[], int)"
  })
  void testIsColumnQualifierBytesValid_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(
        new ByteEntityAccumuloElementConverter(new Schema()).isColumnQualifierBytesValid(null, 10));
  }

  /**
   * Test {@link AbstractCoreKeyAccumuloElementConverter#isColumnQualifierBytesValid(byte[], int)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractCoreKeyAccumuloElementConverter#isColumnQualifierBytesValid(byte[], int)}
   */
  @Test
  @DisplayName("Test isColumnQualifierBytesValid(byte[], int); when zero; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AbstractCoreKeyAccumuloElementConverter.isColumnQualifierBytesValid(byte[], int)"
  })
  void testIsColumnQualifierBytesValid_whenZero_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(
        new ByteEntityAccumuloElementConverter(new Schema()).isColumnQualifierBytesValid(null, 0));
  }

  /**
   * Test {@link AbstractCoreKeyAccumuloElementConverter#buildTimestamp(String, Properties)}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link AbstractCoreKeyAccumuloElementConverter#buildTimestamp(String,
   * Properties)}
   */
  @Test
  @DisplayName("Test buildTimestamp(String, Properties); then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long AbstractCoreKeyAccumuloElementConverter.buildTimestamp(String, Properties)"
  })
  void testBuildTimestamp_thenReturnOne() {
    // Arrange
    Schema schema = mock(Schema.class);
    when(schema.getVisibilityProperty()).thenReturn("Visibility Property");
    when(schema.getElement(Mockito.<String>any())).thenReturn(new SchemaEdgeDefinition());
    when(schema.getConfig(Mockito.<String>any())).thenReturn("foo");
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());

    ByteEntityAccumuloElementConverter byteEntityAccumuloElementConverter =
        new ByteEntityAccumuloElementConverter(schema);
    Edge element =
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build();
    byteEntityAccumuloElementConverter.addPropertiesToElement(element, new Key());

    Properties properties = new Properties();
    properties.putIfAbsent("foo", 1L);

    // Act
    long actualBuildTimestampResult =
        byteEntityAccumuloElementConverter.buildTimestamp("Group", properties);

    // Assert
    verify(schema).getAggregatedGroups();
    verify(schema).getConfig("timestampProperty");
    verify(schema, atLeast(1)).getElement("Group");
    verify(schema, atLeast(1)).getVisibilityProperty();
    assertEquals(1L, actualBuildTimestampResult);
  }

  /**
   * Test {@link AbstractCoreKeyAccumuloElementConverter#getPropertiesFromTimestamp(String, long)}.
   *
   * <ul>
   *   <li>Then throw {@link AccumuloElementConversionException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractCoreKeyAccumuloElementConverter#getPropertiesFromTimestamp(String, long)}
   */
  @Test
  @DisplayName(
      "Test getPropertiesFromTimestamp(String, long); then throw AccumuloElementConversionException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Properties AbstractCoreKeyAccumuloElementConverter.getPropertiesFromTimestamp(String, long)"
  })
  void testGetPropertiesFromTimestamp_thenThrowAccumuloElementConversionException() {
    // Arrange, Act and Assert
    assertThrows(
        AccumuloElementConversionException.class,
        () ->
            new ByteEntityAccumuloElementConverter(new Schema())
                .getPropertiesFromTimestamp("Group", 10L));
  }

  /**
   * Test {@link AbstractCoreKeyAccumuloElementConverter#serialiseVertex(Object)}.
   *
   * <ul>
   *   <li>Then return array length is seventy.
   * </ul>
   *
   * <p>Method under test: {@link AbstractCoreKeyAccumuloElementConverter#serialiseVertex(Object)}
   */
  @Test
  @DisplayName("Test serialiseVertex(Object); then return array length is seventy")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] AbstractCoreKeyAccumuloElementConverter.serialiseVertex(Object)"})
  void testSerialiseVertex_thenReturnArrayLengthIsSeventy() {
    // Arrange
    Schema schema = mock(Schema.class);
    when(schema.getConfig(Mockito.<String>any())).thenReturn("Config");
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.getVertexSerialiser()).thenReturn(new AvroSerialiser());

    // Act
    byte[] actualSerialiseVertexResult =
        new ByteEntityAccumuloElementConverter(schema).serialiseVertex("Vertex");

    // Assert
    assertEquals(70, actualSerialiseVertexResult.length);
    assertEquals('O', actualSerialiseVertexResult[0]);
    assertEquals('b', actualSerialiseVertexResult[1]);
    assertEquals('j', actualSerialiseVertexResult[2]);
    assertEquals((byte) 1, actualSerialiseVertexResult[3]);
    assertEquals((byte) 2, actualSerialiseVertexResult[4]);
    assertEquals((byte) 2, actualSerialiseVertexResult[5]);
    assertEquals((byte) 22, actualSerialiseVertexResult[6]);
    assertEquals('a', actualSerialiseVertexResult[7]);
    assertEquals('v', actualSerialiseVertexResult[8]);
    assertEquals('r', actualSerialiseVertexResult[9]);
    assertEquals('o', actualSerialiseVertexResult[10]);
    assertEquals('.', actualSerialiseVertexResult[11]);
    assertEquals('s', actualSerialiseVertexResult[12]);
    assertEquals('c', actualSerialiseVertexResult[13]);
    assertEquals('h', actualSerialiseVertexResult[14]);
    assertEquals('e', actualSerialiseVertexResult[15]);
    assertEquals('m', actualSerialiseVertexResult[Short.SIZE]);
    assertEquals('a', actualSerialiseVertexResult[17]);
    assertEquals((byte) 16, actualSerialiseVertexResult[18]);
    assertEquals('"', actualSerialiseVertexResult[19]);
    assertEquals('s', actualSerialiseVertexResult[20]);
    assertEquals('t', actualSerialiseVertexResult[21]);
    assertEquals('r', actualSerialiseVertexResult[22]);
    assertEquals('i', actualSerialiseVertexResult[23]);
    assertEquals('n', actualSerialiseVertexResult[24]);
    assertEquals((byte) 2, actualSerialiseVertexResult[45]);
    assertEquals((byte) 14, actualSerialiseVertexResult[46]);
    assertEquals('\f', actualSerialiseVertexResult[47]);
    assertEquals('V', actualSerialiseVertexResult[48]);
    assertEquals('e', actualSerialiseVertexResult[49]);
    assertEquals('r', actualSerialiseVertexResult[50]);
    assertEquals('t', actualSerialiseVertexResult[51]);
    assertEquals('e', actualSerialiseVertexResult[52]);
    assertEquals('x', actualSerialiseVertexResult[53]);
    verify(schema).getConfig("timestampProperty");
    verify(schema).getAggregatedGroups();
    verify(schema).getVertexSerialiser();
  }

  /**
   * Test {@link AbstractCoreKeyAccumuloElementConverter#serialiseVertex(Object)}.
   *
   * <ul>
   *   <li>Then throw {@link AccumuloElementConversionException}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractCoreKeyAccumuloElementConverter#serialiseVertex(Object)}
   */
  @Test
  @DisplayName("Test serialiseVertex(Object); then throw AccumuloElementConversionException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] AbstractCoreKeyAccumuloElementConverter.serialiseVertex(Object)"})
  void testSerialiseVertex_thenThrowAccumuloElementConversionException()
      throws SerialisationException {
    // Arrange
    AvroSerialiser avroSerialiser = mock(AvroSerialiser.class);
    when(avroSerialiser.serialise(Mockito.<Object>any()))
        .thenThrow(new SerialisationException("An error occurred"));

    Schema schema = mock(Schema.class);
    when(schema.getConfig(Mockito.<String>any())).thenReturn("Config");
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.getVertexSerialiser()).thenReturn(avroSerialiser);

    // Act and Assert
    assertThrows(
        AccumuloElementConversionException.class,
        () -> new ByteEntityAccumuloElementConverter(schema).serialiseVertex("Vertex"));
    verify(avroSerialiser).serialise(isA(Object.class));
    verify(schema).getAggregatedGroups();
    verify(schema).getConfig("timestampProperty");
    verify(schema).getVertexSerialiser();
  }

  /**
   * Test {@link AbstractCoreKeyAccumuloElementConverter#selfEdge(Edge)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractCoreKeyAccumuloElementConverter#selfEdge(Edge)}
   */
  @Test
  @DisplayName("Test selfEdge(Edge); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AbstractCoreKeyAccumuloElementConverter.selfEdge(Edge)"})
  void testSelfEdge_thenReturnFalse() {
    // Arrange
    ByteEntityAccumuloElementConverter byteEntityAccumuloElementConverter =
        new ByteEntityAccumuloElementConverter(new Schema());

    // Act
    boolean actualSelfEdgeResult =
        byteEntityAccumuloElementConverter.selfEdge(
            new Builder()
                .dest("Dest")
                .directed(true)
                .group("Group")
                .matchedVertex(MatchedVertex.SOURCE)
                .source("Source")
                .build());

    // Assert
    assertFalse(actualSelfEdgeResult);
  }

  /**
   * Test {@link AbstractCoreKeyAccumuloElementConverter#selfEdge(Edge)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractCoreKeyAccumuloElementConverter#selfEdge(Edge)}
   */
  @Test
  @DisplayName("Test selfEdge(Edge); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AbstractCoreKeyAccumuloElementConverter.selfEdge(Edge)"})
  void testSelfEdge_thenReturnTrue() {
    // Arrange
    ByteEntityAccumuloElementConverter byteEntityAccumuloElementConverter =
        new ByteEntityAccumuloElementConverter(new Schema());

    // Act
    boolean actualSelfEdgeResult =
        byteEntityAccumuloElementConverter.selfEdge(
            new Builder()
                .dest("Source")
                .directed(true)
                .group("Group")
                .matchedVertex(MatchedVertex.SOURCE)
                .source("Source")
                .build());

    // Assert
    assertTrue(actualSelfEdgeResult);
  }

  /**
   * Test {@link AbstractCoreKeyAccumuloElementConverter#addPropertiesToElement(Element, Key)}.
   *
   * <ul>
   *   <li>Then throw {@link AccumuloElementConversionException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractCoreKeyAccumuloElementConverter#addPropertiesToElement(Element, Key)}
   */
  @Test
  @DisplayName(
      "Test addPropertiesToElement(Element, Key); then throw AccumuloElementConversionException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AbstractCoreKeyAccumuloElementConverter.addPropertiesToElement(Element, Key)"
  })
  void testAddPropertiesToElement_thenThrowAccumuloElementConversionException() {
    // Arrange
    ByteEntityAccumuloElementConverter byteEntityAccumuloElementConverter =
        new ByteEntityAccumuloElementConverter(new Schema());
    Edge element = new Edge("Group");

    // Act and Assert
    assertThrows(
        AccumuloElementConversionException.class,
        () -> byteEntityAccumuloElementConverter.addPropertiesToElement(element, new Key()));
  }

  /**
   * Test {@link AbstractCoreKeyAccumuloElementConverter#getSerialisedSource(Edge)}.
   *
   * <ul>
   *   <li>Then return forty-seventh element is fourteen.
   * </ul>
   *
   * <p>Method under test: {@link AbstractCoreKeyAccumuloElementConverter#getSerialisedSource(Edge)}
   */
  @Test
  @DisplayName("Test getSerialisedSource(Edge); then return forty-seventh element is fourteen")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] AbstractCoreKeyAccumuloElementConverter.getSerialisedSource(Edge)"})
  void testGetSerialisedSource_thenReturnFortySeventhElementIsFourteen() {
    // Arrange
    Schema schema = mock(Schema.class);
    when(schema.getConfig(Mockito.<String>any())).thenReturn("Config");
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.getVertexSerialiser()).thenReturn(new AvroSerialiser());
    ByteEntityAccumuloElementConverter byteEntityAccumuloElementConverter =
        new ByteEntityAccumuloElementConverter(schema);

    // Act
    byte[] actualSerialisedSource =
        byteEntityAccumuloElementConverter.getSerialisedSource(
            new Builder()
                .dest("Dest")
                .directed(true)
                .group("Group")
                .matchedVertex(MatchedVertex.SOURCE)
                .source("Source")
                .build());

    // Assert
    verify(schema).getAggregatedGroups();
    verify(schema).getConfig("timestampProperty");
    verify(schema).getVertexSerialiser();
    assertEquals((byte) 14, actualSerialisedSource[46]);
    assertEquals((byte) 16, actualSerialisedSource[18]);
    assertEquals((byte) 1, actualSerialisedSource[3]);
    assertEquals((byte) 22, actualSerialisedSource[6]);
    assertEquals((byte) 2, actualSerialisedSource[4]);
    assertEquals((byte) 2, actualSerialisedSource[45]);
    assertEquals((byte) 2, actualSerialisedSource[5]);
    assertEquals(70, actualSerialisedSource.length);
    assertEquals('.', actualSerialisedSource[11]);
    assertEquals('O', actualSerialisedSource[0]);
    assertEquals('S', actualSerialisedSource[48]);
    assertEquals('"', actualSerialisedSource[19]);
    assertEquals('\f', actualSerialisedSource[47]);
    assertEquals('a', actualSerialisedSource[17]);
    assertEquals('a', actualSerialisedSource[7]);
    assertEquals('b', actualSerialisedSource[1]);
    assertEquals('c', actualSerialisedSource[13]);
    assertEquals('c', actualSerialisedSource[52]);
    assertEquals('e', actualSerialisedSource[15]);
    assertEquals('e', actualSerialisedSource[53]);
    assertEquals('h', actualSerialisedSource[14]);
    assertEquals('i', actualSerialisedSource[23]);
    assertEquals('j', actualSerialisedSource[2]);
    assertEquals('m', actualSerialisedSource[Short.SIZE]);
    assertEquals('n', actualSerialisedSource[24]);
    assertEquals('o', actualSerialisedSource[10]);
    assertEquals('o', actualSerialisedSource[49]);
    assertEquals('r', actualSerialisedSource[22]);
    assertEquals('r', actualSerialisedSource[51]);
    assertEquals('r', actualSerialisedSource[9]);
    assertEquals('s', actualSerialisedSource[12]);
    assertEquals('s', actualSerialisedSource[20]);
    assertEquals('t', actualSerialisedSource[21]);
    assertEquals('u', actualSerialisedSource[50]);
    assertEquals('v', actualSerialisedSource[8]);
  }

  /**
   * Test {@link AbstractCoreKeyAccumuloElementConverter#getSerialisedDestination(Edge)}.
   *
   * <ul>
   *   <li>Then return nineteenth element is sixteen.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractCoreKeyAccumuloElementConverter#getSerialisedDestination(Edge)}
   */
  @Test
  @DisplayName("Test getSerialisedDestination(Edge); then return nineteenth element is sixteen")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "byte[] AbstractCoreKeyAccumuloElementConverter.getSerialisedDestination(Edge)"
  })
  void testGetSerialisedDestination_thenReturnNineteenthElementIsSixteen() {
    // Arrange
    Schema schema = mock(Schema.class);
    when(schema.getConfig(Mockito.<String>any())).thenReturn("Config");
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.getVertexSerialiser()).thenReturn(new AvroSerialiser());
    ByteEntityAccumuloElementConverter byteEntityAccumuloElementConverter =
        new ByteEntityAccumuloElementConverter(schema);

    // Act
    byte[] actualSerialisedDestination =
        byteEntityAccumuloElementConverter.getSerialisedDestination(
            new Builder()
                .dest("Dest")
                .directed(true)
                .group("Group")
                .matchedVertex(MatchedVertex.SOURCE)
                .source("Source")
                .build());

    // Assert
    verify(schema).getAggregatedGroups();
    verify(schema).getConfig("timestampProperty");
    verify(schema).getVertexSerialiser();
    assertEquals((byte) 16, actualSerialisedDestination[18]);
    assertEquals((byte) 1, actualSerialisedDestination[3]);
    assertEquals((byte) 22, actualSerialisedDestination[6]);
    assertEquals((byte) 2, actualSerialisedDestination[4]);
    assertEquals((byte) 2, actualSerialisedDestination[45]);
    assertEquals((byte) 2, actualSerialisedDestination[5]);
    assertEquals(68, actualSerialisedDestination.length);
    assertEquals('.', actualSerialisedDestination[11]);
    assertEquals('D', actualSerialisedDestination[48]);
    assertEquals('O', actualSerialisedDestination[0]);
    assertEquals('"', actualSerialisedDestination[19]);
    assertEquals('\b', actualSerialisedDestination[47]);
    assertEquals('\n', actualSerialisedDestination[46]);
    assertEquals('a', actualSerialisedDestination[17]);
    assertEquals('a', actualSerialisedDestination[7]);
    assertEquals('b', actualSerialisedDestination[1]);
    assertEquals('c', actualSerialisedDestination[13]);
    assertEquals('e', actualSerialisedDestination[15]);
    assertEquals('e', actualSerialisedDestination[49]);
    assertEquals('h', actualSerialisedDestination[14]);
    assertEquals('i', actualSerialisedDestination[23]);
    assertEquals('j', actualSerialisedDestination[2]);
    assertEquals('m', actualSerialisedDestination[Short.SIZE]);
    assertEquals('n', actualSerialisedDestination[24]);
    assertEquals('o', actualSerialisedDestination[10]);
    assertEquals('r', actualSerialisedDestination[22]);
    assertEquals('r', actualSerialisedDestination[9]);
    assertEquals('s', actualSerialisedDestination[12]);
    assertEquals('s', actualSerialisedDestination[20]);
    assertEquals('s', actualSerialisedDestination[50]);
    assertEquals('t', actualSerialisedDestination[21]);
    assertEquals('t', actualSerialisedDestination[51]);
    assertEquals('v', actualSerialisedDestination[8]);
  }

  /**
   * Test {@link AbstractCoreKeyAccumuloElementConverter#getGroupFromKey(Key)}.
   *
   * <ul>
   *   <li>When {@link Key#Key()}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link AbstractCoreKeyAccumuloElementConverter#getGroupFromKey(Key)}
   */
  @Test
  @DisplayName("Test getGroupFromKey(Key); when Key(); then return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String AbstractCoreKeyAccumuloElementConverter.getGroupFromKey(Key)"})
  void testGetGroupFromKey_whenKey_thenReturnEmptyString() {
    // Arrange
    ByteEntityAccumuloElementConverter byteEntityAccumuloElementConverter =
        new ByteEntityAccumuloElementConverter(new Schema());

    // Act and Assert
    assertEquals("", byteEntityAccumuloElementConverter.getGroupFromKey(new Key()));
  }

  /**
   * Test {@link AbstractCoreKeyAccumuloElementConverter#isStoredInValue(String,
   * SchemaElementDefinition)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractCoreKeyAccumuloElementConverter#isStoredInValue(String,
   * SchemaElementDefinition)}
   */
  @Test
  @DisplayName("Test isStoredInValue(String, SchemaElementDefinition); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AbstractCoreKeyAccumuloElementConverter.isStoredInValue(String, SchemaElementDefinition)"
  })
  void testIsStoredInValue_thenReturnTrue() {
    // Arrange
    ByteEntityAccumuloElementConverter byteEntityAccumuloElementConverter =
        new ByteEntityAccumuloElementConverter(new Schema());

    // Act and Assert
    assertTrue(
        byteEntityAccumuloElementConverter.isStoredInValue(
            "Property Name", new SchemaEdgeDefinition()));
  }
}
