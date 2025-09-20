package uk.gov.gchq.gaffer.operation.export.graph;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.Element;
import uk.gov.gchq.gaffer.operation.export.graph.ExportToOtherGraph.Builder;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl.IterableElement;
import uk.gov.gchq.gaffer.store.StoreProperties;
import uk.gov.gchq.gaffer.store.schema.Schema;

class ExportToOtherGraphDiffblueTest {
  /**
   * Test Builder {@link Builder#graphId(String)}.
   *
   * <p>Method under test: {@link Builder#graphId(String)}
   */
  @Test
  @DisplayName("Test Builder graphId(String)")
  @Tag("MaintainedByDiffblue")
  void testBuilderGraphId() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualGraphIdResult = builder.graphId("42");

    // Assert
    assertSame(builder, actualGraphIdResult);
  }

  /**
   * Test Builder new {@link Builder} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link Builder}
   */
  @Test
  @DisplayName("Test Builder new Builder (default constructor)")
  @Tag("MaintainedByDiffblue")
  void testBuilderNewBuilder() {
    // Arrange and Act
    Builder actualBuilder = new Builder();

    // Assert
    ExportToOtherGraph _getOpResult = actualBuilder._getOp();
    assertTrue(_getOpResult.getOutputTypeReference() instanceof IterableElement);
    assertEquals("ALL", _getOpResult.getKeyOrDefault());
    assertNull(_getOpResult.getInput());
    assertNull(_getOpResult.getGraphId());
    assertNull(_getOpResult.getKey());
    assertNull(_getOpResult.getParentStorePropertiesId());
    assertNull(_getOpResult.getParentSchemaIds());
    assertNull(_getOpResult.getOptions());
    assertNull(_getOpResult.getProperties());
    assertNull(_getOpResult.getStoreProperties());
    assertNull(_getOpResult.getSchema());
    Class<Iterable> expectedOutputClass = Iterable.class;
    assertEquals(expectedOutputClass, _getOpResult.getOutputClass());
    ExportToOtherGraph actualExportToOtherGraph = actualBuilder.build();
    assertSame(_getOpResult, actualExportToOtherGraph);
  }

  /**
   * Test Builder {@link Builder#parentSchemaIds(String[])}.
   *
   * <ul>
   *   <li>When {@code Parent Schema Ids}.
   *   <li>Then return {@link Builder} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link Builder#parentSchemaIds(String[])}
   */
  @Test
  @DisplayName(
      "Test Builder parentSchemaIds(String[]); when 'Parent Schema Ids'; then return Builder (default constructor)")
  @Tag("MaintainedByDiffblue")
  void testBuilderParentSchemaIds_whenParentSchemaIds_thenReturnBuilder() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualParentSchemaIdsResult = builder.parentSchemaIds("Parent Schema Ids");

    // Assert
    assertSame(builder, actualParentSchemaIdsResult);
  }

  /**
   * Test Builder {@link Builder#parentStorePropertiesId(String)}.
   *
   * <p>Method under test: {@link Builder#parentStorePropertiesId(String)}
   */
  @Test
  @DisplayName("Test Builder parentStorePropertiesId(String)")
  @Tag("MaintainedByDiffblue")
  void testBuilderParentStorePropertiesId() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualParentStorePropertiesIdResult = builder.parentStorePropertiesId("42");

    // Assert
    assertSame(builder, actualParentStorePropertiesIdResult);
  }

  /**
   * Test Builder {@link Builder#schema(Schema)}.
   *
   * <p>Method under test: {@link Builder#schema(Schema)}
   */
  @Test
  @DisplayName("Test Builder schema(Schema)")
  @Tag("MaintainedByDiffblue")
  void testBuilderSchema() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualSchemaResult = builder.schema(new Schema());

    // Assert
    assertSame(builder, actualSchemaResult);
  }

  /**
   * Test Builder {@link Builder#storeProperties(StoreProperties)}.
   *
   * <p>Method under test: {@link Builder#storeProperties(StoreProperties)}
   */
  @Test
  @DisplayName("Test Builder storeProperties(StoreProperties)")
  @Tag("MaintainedByDiffblue")
  void testBuilderStoreProperties() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualStorePropertiesResult = builder.storeProperties(new StoreProperties());

    // Assert
    assertSame(builder, actualStorePropertiesResult);
  }

  /**
   * Test {@link ExportToOtherGraph#getInput()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ExportToOtherGraph#getInput()}
   */
  @Test
  @DisplayName("Test getInput(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  void testGetInput_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new ExportToOtherGraph().getInput());
  }

  /**
   * Test {@link ExportToOtherGraph#getProperties()}.
   *
   * <ul>
   *   <li>Given {@link ExportToOtherGraph} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ExportToOtherGraph#getProperties()}
   */
  @Test
  @DisplayName(
      "Test getProperties(); given ExportToOtherGraph (default constructor); then return 'null'")
  @Tag("MaintainedByDiffblue")
  void testGetProperties_givenExportToOtherGraph_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new ExportToOtherGraph().getProperties());
  }

  /**
   * Test {@link ExportToOtherGraph#getProperties()}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link ExportToOtherGraph#getProperties()}
   */
  @Test
  @DisplayName("Test getProperties(); then return size is one")
  @Tag("MaintainedByDiffblue")
  void testGetProperties_thenReturnSizeIsOne() {
    // Arrange
    ExportToOtherGraph exportToOtherGraph = new ExportToOtherGraph();
    exportToOtherGraph.setStoreProperties(new StoreProperties());

    // Act
    Properties actualProperties = exportToOtherGraph.getProperties();

    // Assert
    assertEquals(1, actualProperties.size());
    assertEquals(
        "uk.gov.gchq.gaffer.store.StoreProperties",
        actualProperties.get("gaffer.store.properties.class"));
  }

  /**
   * Test {@link ExportToOtherGraph#setProperties(Properties)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link ExportToOtherGraph} (default constructor) Properties is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ExportToOtherGraph#setProperties(Properties)}
   */
  @Test
  @DisplayName(
      "Test setProperties(Properties); when 'null'; then ExportToOtherGraph (default constructor) Properties is 'null'")
  @Tag("MaintainedByDiffblue")
  void testSetProperties_whenNull_thenExportToOtherGraphPropertiesIsNull() {
    // Arrange
    ExportToOtherGraph exportToOtherGraph = new ExportToOtherGraph();

    // Act
    exportToOtherGraph.setProperties(null);

    // Assert that nothing has changed
    assertNull(exportToOtherGraph.getProperties());
  }

  /**
   * Test {@link ExportToOtherGraph#setProperties(Properties)}.
   *
   * <ul>
   *   <li>When {@link Properties#Properties()}.
   *   <li>Then {@link ExportToOtherGraph} (default constructor) Properties is {@link
   *       Properties#Properties()}.
   * </ul>
   *
   * <p>Method under test: {@link ExportToOtherGraph#setProperties(Properties)}
   */
  @Test
  @DisplayName(
      "Test setProperties(Properties); when Properties(); then ExportToOtherGraph (default constructor) Properties is Properties()")
  @Tag("MaintainedByDiffblue")
  void testSetProperties_whenProperties_thenExportToOtherGraphPropertiesIsProperties() {
    // Arrange
    ExportToOtherGraph exportToOtherGraph = new ExportToOtherGraph();
    Properties properties = new Properties();

    // Act
    exportToOtherGraph.setProperties(properties);

    // Assert
    assertSame(properties, exportToOtherGraph.getProperties());
  }

  /**
   * Test {@link ExportToOtherGraph#shallowClone()}.
   *
   * <ul>
   *   <li>Given {@link ExportToOtherGraph} (default constructor) Options is {@link
   *       HashMap#HashMap()}.
   *   <li>Then return Options Empty.
   * </ul>
   *
   * <p>Method under test: {@link ExportToOtherGraph#shallowClone()}
   */
  @Test
  @DisplayName(
      "Test shallowClone(); given ExportToOtherGraph (default constructor) Options is HashMap(); then return Options Empty")
  @Tag("MaintainedByDiffblue")
  void testShallowClone_givenExportToOtherGraphOptionsIsHashMap_thenReturnOptionsEmpty() {
    // Arrange
    ExportToOtherGraph exportToOtherGraph = new ExportToOtherGraph();
    exportToOtherGraph.setOptions(new HashMap<>());
    exportToOtherGraph.setParentSchemaIds(new ArrayList<>());

    // Act
    ExportToOtherGraph actualShallowCloneResult = exportToOtherGraph.shallowClone();

    // Assert
    assertTrue(actualShallowCloneResult.getOutputTypeReference() instanceof IterableElement);
    assertEquals("ALL", actualShallowCloneResult.getKeyOrDefault());
    assertNull(actualShallowCloneResult.getInput());
    assertNull(actualShallowCloneResult.getGraphId());
    assertNull(actualShallowCloneResult.getKey());
    assertNull(actualShallowCloneResult.getParentStorePropertiesId());
    assertNull(actualShallowCloneResult.getProperties());
    assertNull(actualShallowCloneResult.getStoreProperties());
    assertNull(actualShallowCloneResult.getSchema());
    assertTrue(actualShallowCloneResult.getParentSchemaIds().isEmpty());
    assertTrue(actualShallowCloneResult.getOptions().isEmpty());
    Class<Iterable> expectedOutputClass = Iterable.class;
    assertEquals(expectedOutputClass, actualShallowCloneResult.getOutputClass());
  }

  /**
   * Test {@link ExportToOtherGraph#shallowClone()}.
   *
   * <ul>
   *   <li>Then return Options is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ExportToOtherGraph#shallowClone()}
   */
  @Test
  @DisplayName("Test shallowClone(); then return Options is 'null'")
  @Tag("MaintainedByDiffblue")
  void testShallowClone_thenReturnOptionsIsNull() {
    // Arrange
    ExportToOtherGraph exportToOtherGraph = new ExportToOtherGraph();
    exportToOtherGraph.setParentSchemaIds(new ArrayList<>());

    // Act
    ExportToOtherGraph actualShallowCloneResult = exportToOtherGraph.shallowClone();

    // Assert
    assertTrue(actualShallowCloneResult.getOutputTypeReference() instanceof IterableElement);
    assertEquals("ALL", actualShallowCloneResult.getKeyOrDefault());
    assertNull(actualShallowCloneResult.getInput());
    assertNull(actualShallowCloneResult.getGraphId());
    assertNull(actualShallowCloneResult.getKey());
    assertNull(actualShallowCloneResult.getParentStorePropertiesId());
    assertNull(actualShallowCloneResult.getOptions());
    assertNull(actualShallowCloneResult.getProperties());
    assertNull(actualShallowCloneResult.getStoreProperties());
    assertNull(actualShallowCloneResult.getSchema());
    assertTrue(actualShallowCloneResult.getParentSchemaIds().isEmpty());
    Class<Iterable> expectedOutputClass = Iterable.class;
    assertEquals(expectedOutputClass, actualShallowCloneResult.getOutputClass());
  }

  /**
   * Test {@link ExportToOtherGraph#getOutputTypeReference()}.
   *
   * <p>Method under test: {@link ExportToOtherGraph#getOutputTypeReference()}
   */
  @Test
  @DisplayName("Test getOutputTypeReference()")
  @Tag("MaintainedByDiffblue")
  void testGetOutputTypeReference() {
    // Arrange and Act
    TypeReference<Iterable<? extends Element>> actualOutputTypeReference =
        new ExportToOtherGraph().getOutputTypeReference();

    // Assert
    assertTrue(actualOutputTypeReference instanceof IterableElement);
    assertEquals(
        "java.lang.Iterable<? extends uk.gov.gchq.gaffer.data.element.Element>",
        actualOutputTypeReference.getType().getTypeName());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link ExportToOtherGraph}
   *   <li>{@link ExportToOtherGraph#setGraphId(String)}
   *   <li>{@link ExportToOtherGraph#setInput(Iterable)}
   *   <li>{@link ExportToOtherGraph#setOptions(Map)}
   *   <li>{@link ExportToOtherGraph#setParentSchemaIds(List)}
   *   <li>{@link ExportToOtherGraph#setParentStorePropertiesId(String)}
   *   <li>{@link ExportToOtherGraph#setSchema(Schema)}
   *   <li>{@link ExportToOtherGraph#setStoreProperties(StoreProperties)}
   *   <li>{@link ExportToOtherGraph#setKey(String)}
   *   <li>{@link ExportToOtherGraph#getGraphId()}
   *   <li>{@link ExportToOtherGraph#getKey()}
   *   <li>{@link ExportToOtherGraph#getOptions()}
   *   <li>{@link ExportToOtherGraph#getParentSchemaIds()}
   *   <li>{@link ExportToOtherGraph#getParentStorePropertiesId()}
   *   <li>{@link ExportToOtherGraph#getSchema()}
   *   <li>{@link ExportToOtherGraph#getStoreProperties()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  void testGettersAndSetters() {
    // Arrange and Act
    ExportToOtherGraph actualExportToOtherGraph = new ExportToOtherGraph();
    actualExportToOtherGraph.setGraphId("42");
    ArrayList<Element> input = new ArrayList<>();
    actualExportToOtherGraph.setInput(input);
    HashMap<String, String> options = new HashMap<>();
    actualExportToOtherGraph.setOptions(options);
    ArrayList<String> parentSchemaIds = new ArrayList<>();
    actualExportToOtherGraph.setParentSchemaIds(parentSchemaIds);
    actualExportToOtherGraph.setParentStorePropertiesId("42");
    Schema schema = new Schema();
    actualExportToOtherGraph.setSchema(schema);
    StoreProperties storeProperties = new StoreProperties();
    actualExportToOtherGraph.setStoreProperties(storeProperties);
    actualExportToOtherGraph.setKey("Key");
    String actualGraphId = actualExportToOtherGraph.getGraphId();
    String actualKey = actualExportToOtherGraph.getKey();
    Map<String, String> actualOptions = actualExportToOtherGraph.getOptions();
    List<String> actualParentSchemaIds = actualExportToOtherGraph.getParentSchemaIds();
    String actualParentStorePropertiesId = actualExportToOtherGraph.getParentStorePropertiesId();
    Schema actualSchema = actualExportToOtherGraph.getSchema();
    StoreProperties actualStoreProperties = actualExportToOtherGraph.getStoreProperties();

    // Assert
    Iterable<? extends Element> input2 = actualExportToOtherGraph.getInput();
    assertTrue(input2 instanceof List);
    assertEquals("42", actualGraphId);
    assertEquals("42", actualParentStorePropertiesId);
    assertNull(actualKey);
    assertTrue(actualParentSchemaIds.isEmpty());
    assertTrue(actualOptions.isEmpty());
    assertSame(input, input2);
    assertSame(parentSchemaIds, actualParentSchemaIds);
    assertSame(options, actualOptions);
    assertSame(storeProperties, actualStoreProperties);
    assertSame(schema, actualSchema);
  }
}
