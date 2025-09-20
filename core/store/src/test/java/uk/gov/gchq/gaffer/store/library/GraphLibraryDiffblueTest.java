package uk.gov.gchq.gaffer.store.library;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.commonutil.exception.OverwritingException;
import uk.gov.gchq.gaffer.store.StoreProperties;
import uk.gov.gchq.gaffer.store.schema.Schema;

class GraphLibraryDiffblueTest {
  /**
   * Test {@link GraphLibrary#add(String, String, Schema, String, StoreProperties)} with {@code
   * graphId}, {@code schemaId}, {@code schema}, {@code propertiesId}, {@code properties}.
   *
   * <p>Method under test: {@link GraphLibrary#add(String, String, Schema, String, StoreProperties)}
   */
  @Test
  @DisplayName(
      "Test add(String, String, Schema, String, StoreProperties) with 'graphId', 'schemaId', 'schema', 'propertiesId', 'properties'")
  @Tag("MaintainedByDiffblue")
  void testAddWithGraphIdSchemaIdSchemaPropertiesIdProperties() throws OverwritingException {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new FileGraphLibrary().add(null, null, null, null, null));
  }

  /**
   * Test {@link GraphLibrary#add(String, String, Schema, String, StoreProperties)} with {@code
   * graphId}, {@code schemaId}, {@code schema}, {@code propertiesId}, {@code properties}.
   *
   * <p>Method under test: {@link GraphLibrary#add(String, String, Schema, String, StoreProperties)}
   */
  @Test
  @DisplayName(
      "Test add(String, String, Schema, String, StoreProperties) with 'graphId', 'schemaId', 'schema', 'propertiesId', 'properties'")
  @Tag("MaintainedByDiffblue")
  void testAddWithGraphIdSchemaIdSchemaPropertiesIdProperties2() throws OverwritingException {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new FileGraphLibrary().add("42", null, null, null, null));
  }

  /**
   * Test {@link GraphLibrary#add(String, String, Schema, String, StoreProperties)} with {@code
   * graphId}, {@code schemaId}, {@code schema}, {@code propertiesId}, {@code properties}.
   *
   * <ul>
   *   <li>When {@link Schema#Schema()}.
   * </ul>
   *
   * <p>Method under test: {@link GraphLibrary#add(String, String, Schema, String, StoreProperties)}
   */
  @Test
  @DisplayName(
      "Test add(String, String, Schema, String, StoreProperties) with 'graphId', 'schemaId', 'schema', 'propertiesId', 'properties'; when Schema()")
  @Tag("MaintainedByDiffblue")
  void testAddWithGraphIdSchemaIdSchemaPropertiesIdProperties_whenSchema()
      throws OverwritingException {
    // Arrange
    FileGraphLibrary fileGraphLibrary = new FileGraphLibrary();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> fileGraphLibrary.add("42", null, new Schema(), null, null));
  }

  /**
   * Test {@link GraphLibrary#add(String, String, Schema, String, StoreProperties)} with {@code
   * graphId}, {@code schemaId}, {@code schema}, {@code propertiesId}, {@code properties}.
   *
   * <ul>
   *   <li>When {@link StoreProperties#StoreProperties()}.
   * </ul>
   *
   * <p>Method under test: {@link GraphLibrary#add(String, String, Schema, String, StoreProperties)}
   */
  @Test
  @DisplayName(
      "Test add(String, String, Schema, String, StoreProperties) with 'graphId', 'schemaId', 'schema', 'propertiesId', 'properties'; when StoreProperties()")
  @Tag("MaintainedByDiffblue")
  void testAddWithGraphIdSchemaIdSchemaPropertiesIdProperties_whenStoreProperties()
      throws OverwritingException {
    // Arrange
    FileGraphLibrary fileGraphLibrary = new FileGraphLibrary();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> fileGraphLibrary.add("42", null, null, null, new StoreProperties()));
  }

  /**
   * Test {@link GraphLibrary#add(String, Schema, StoreProperties)} with {@code graphId}, {@code
   * schema}, {@code properties}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link GraphLibrary#add(String, Schema, StoreProperties)}
   */
  @Test
  @DisplayName(
      "Test add(String, Schema, StoreProperties) with 'graphId', 'schema', 'properties'; when '42'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  void testAddWithGraphIdSchemaProperties_when42_thenThrowIllegalArgumentException()
      throws OverwritingException {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> new FileGraphLibrary().add("42", null, null));
  }

  /**
   * Test {@link GraphLibrary#add(String, Schema, StoreProperties)} with {@code graphId}, {@code
   * schema}, {@code properties}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link GraphLibrary#add(String, Schema, StoreProperties)}
   */
  @Test
  @DisplayName(
      "Test add(String, Schema, StoreProperties) with 'graphId', 'schema', 'properties'; when 'null'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  void testAddWithGraphIdSchemaProperties_whenNull_thenThrowIllegalArgumentException()
      throws OverwritingException {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> new FileGraphLibrary().add(null, null, null));
  }

  /**
   * Test {@link GraphLibrary#add(String, Schema, StoreProperties)} with {@code graphId}, {@code
   * schema}, {@code properties}.
   *
   * <ul>
   *   <li>When {@link Schema#Schema()}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link GraphLibrary#add(String, Schema, StoreProperties)}
   */
  @Test
  @DisplayName(
      "Test add(String, Schema, StoreProperties) with 'graphId', 'schema', 'properties'; when Schema(); then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  void testAddWithGraphIdSchemaProperties_whenSchema_thenThrowIllegalArgumentException()
      throws OverwritingException {
    // Arrange
    FileGraphLibrary fileGraphLibrary = new FileGraphLibrary();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> fileGraphLibrary.add("42", new Schema(), null));
  }

  /**
   * Test {@link GraphLibrary#add(String, Schema, StoreProperties)} with {@code graphId}, {@code
   * schema}, {@code properties}.
   *
   * <ul>
   *   <li>When {@link StoreProperties#StoreProperties()}.
   * </ul>
   *
   * <p>Method under test: {@link GraphLibrary#add(String, Schema, StoreProperties)}
   */
  @Test
  @DisplayName(
      "Test add(String, Schema, StoreProperties) with 'graphId', 'schema', 'properties'; when StoreProperties()")
  @Tag("MaintainedByDiffblue")
  void testAddWithGraphIdSchemaProperties_whenStoreProperties() throws OverwritingException {
    // Arrange
    FileGraphLibrary fileGraphLibrary = new FileGraphLibrary();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> fileGraphLibrary.add("42", null, new StoreProperties()));
  }

  /**
   * Test {@link GraphLibrary#addOrUpdate(String, String, Schema, String, StoreProperties)} with
   * {@code graphId}, {@code schemaId}, {@code schema}, {@code propertiesId}, {@code properties}.
   *
   * <p>Method under test: {@link GraphLibrary#addOrUpdate(String, String, Schema, String,
   * StoreProperties)}
   */
  @Test
  @DisplayName(
      "Test addOrUpdate(String, String, Schema, String, StoreProperties) with 'graphId', 'schemaId', 'schema', 'propertiesId', 'properties'")
  @Tag("MaintainedByDiffblue")
  void testAddOrUpdateWithGraphIdSchemaIdSchemaPropertiesIdProperties() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new FileGraphLibrary().addOrUpdate(null, null, null, null, null));
  }

  /**
   * Test {@link GraphLibrary#addOrUpdate(String, String, Schema, String, StoreProperties)} with
   * {@code graphId}, {@code schemaId}, {@code schema}, {@code propertiesId}, {@code properties}.
   *
   * <p>Method under test: {@link GraphLibrary#addOrUpdate(String, String, Schema, String,
   * StoreProperties)}
   */
  @Test
  @DisplayName(
      "Test addOrUpdate(String, String, Schema, String, StoreProperties) with 'graphId', 'schemaId', 'schema', 'propertiesId', 'properties'")
  @Tag("MaintainedByDiffblue")
  void testAddOrUpdateWithGraphIdSchemaIdSchemaPropertiesIdProperties2() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new FileGraphLibrary().addOrUpdate("42", null, null, null, null));
  }

  /**
   * Test {@link GraphLibrary#addOrUpdate(String, String, Schema, String, StoreProperties)} with
   * {@code graphId}, {@code schemaId}, {@code schema}, {@code propertiesId}, {@code properties}.
   *
   * <p>Method under test: {@link GraphLibrary#addOrUpdate(String, String, Schema, String,
   * StoreProperties)}
   */
  @Test
  @DisplayName(
      "Test addOrUpdate(String, String, Schema, String, StoreProperties) with 'graphId', 'schemaId', 'schema', 'propertiesId', 'properties'")
  @Tag("MaintainedByDiffblue")
  void testAddOrUpdateWithGraphIdSchemaIdSchemaPropertiesIdProperties3() {
    // Arrange
    FileGraphLibrary fileGraphLibrary = new FileGraphLibrary();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> fileGraphLibrary.addOrUpdate("42", null, null, null, new StoreProperties()));
  }

  /**
   * Test {@link GraphLibrary#addOrUpdate(String, String, Schema, String, StoreProperties)} with
   * {@code graphId}, {@code schemaId}, {@code schema}, {@code propertiesId}, {@code properties}.
   *
   * <ul>
   *   <li>When {@link Schema#Schema()}.
   * </ul>
   *
   * <p>Method under test: {@link GraphLibrary#addOrUpdate(String, String, Schema, String,
   * StoreProperties)}
   */
  @Test
  @DisplayName(
      "Test addOrUpdate(String, String, Schema, String, StoreProperties) with 'graphId', 'schemaId', 'schema', 'propertiesId', 'properties'; when Schema()")
  @Tag("MaintainedByDiffblue")
  void testAddOrUpdateWithGraphIdSchemaIdSchemaPropertiesIdProperties_whenSchema() {
    // Arrange
    FileGraphLibrary fileGraphLibrary = new FileGraphLibrary();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> fileGraphLibrary.addOrUpdate("42", null, new Schema(), null, null));
  }

  /**
   * Test {@link GraphLibrary#addOrUpdate(String, Schema, StoreProperties)} with {@code graphId},
   * {@code schema}, {@code properties}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link GraphLibrary#addOrUpdate(String, Schema, StoreProperties)}
   */
  @Test
  @DisplayName(
      "Test addOrUpdate(String, Schema, StoreProperties) with 'graphId', 'schema', 'properties'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  void testAddOrUpdateWithGraphIdSchemaProperties_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> new FileGraphLibrary().addOrUpdate(null, null, null));
  }

  /**
   * Test {@link GraphLibrary#addOrUpdate(String, Schema, StoreProperties)} with {@code graphId},
   * {@code schema}, {@code properties}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link GraphLibrary#addOrUpdate(String, Schema, StoreProperties)}
   */
  @Test
  @DisplayName(
      "Test addOrUpdate(String, Schema, StoreProperties) with 'graphId', 'schema', 'properties'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  void testAddOrUpdateWithGraphIdSchemaProperties_thenThrowIllegalArgumentException2() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> new FileGraphLibrary().addOrUpdate("42", null, null));
  }

  /**
   * Test {@link GraphLibrary#addOrUpdate(String, Schema, StoreProperties)} with {@code graphId},
   * {@code schema}, {@code properties}.
   *
   * <ul>
   *   <li>When {@link Schema#Schema()}.
   * </ul>
   *
   * <p>Method under test: {@link GraphLibrary#addOrUpdate(String, Schema, StoreProperties)}
   */
  @Test
  @DisplayName(
      "Test addOrUpdate(String, Schema, StoreProperties) with 'graphId', 'schema', 'properties'; when Schema()")
  @Tag("MaintainedByDiffblue")
  void testAddOrUpdateWithGraphIdSchemaProperties_whenSchema() {
    // Arrange
    FileGraphLibrary fileGraphLibrary = new FileGraphLibrary();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> fileGraphLibrary.addOrUpdate("42", new Schema(), null));
  }

  /**
   * Test {@link GraphLibrary#addOrUpdate(String, Schema, StoreProperties)} with {@code graphId},
   * {@code schema}, {@code properties}.
   *
   * <ul>
   *   <li>When {@link StoreProperties#StoreProperties()}.
   * </ul>
   *
   * <p>Method under test: {@link GraphLibrary#addOrUpdate(String, Schema, StoreProperties)}
   */
  @Test
  @DisplayName(
      "Test addOrUpdate(String, Schema, StoreProperties) with 'graphId', 'schema', 'properties'; when StoreProperties()")
  @Tag("MaintainedByDiffblue")
  void testAddOrUpdateWithGraphIdSchemaProperties_whenStoreProperties() {
    // Arrange
    FileGraphLibrary fileGraphLibrary = new FileGraphLibrary();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> fileGraphLibrary.addOrUpdate("42", null, new StoreProperties()));
  }

  /**
   * Test {@link GraphLibrary#get(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link GraphLibrary#get(String)}
   */
  @Test
  @DisplayName("Test get(String); when '42'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  void testGet_when42_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new FileGraphLibrary().get("42"));
  }

  /**
   * Test {@link GraphLibrary#get(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link GraphLibrary#get(String)}
   */
  @Test
  @DisplayName("Test get(String); when 'null'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  void testGet_whenNull_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new FileGraphLibrary().get(null));
  }

  /**
   * Test {@link GraphLibrary#getSchema(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link GraphLibrary#getSchema(String)}
   */
  @Test
  @DisplayName("Test getSchema(String); when '42'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  void testGetSchema_when42_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new FileGraphLibrary().getSchema("42"));
  }

  /**
   * Test {@link GraphLibrary#getSchema(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link GraphLibrary#getSchema(String)}
   */
  @Test
  @DisplayName("Test getSchema(String); when 'null'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  void testGetSchema_whenNull_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new FileGraphLibrary().getSchema(null));
  }

  /**
   * Test {@link GraphLibrary#getProperties(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link GraphLibrary#getProperties(String)}
   */
  @Test
  @DisplayName("Test getProperties(String); when '42'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  void testGetProperties_when42_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new FileGraphLibrary().getProperties("42"));
  }

  /**
   * Test {@link GraphLibrary#getProperties(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link GraphLibrary#getProperties(String)}
   */
  @Test
  @DisplayName("Test getProperties(String); when 'null'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  void testGetProperties_whenNull_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new FileGraphLibrary().getProperties(null));
  }

  /**
   * Test {@link GraphLibrary#exists(String)}.
   *
   * <p>Method under test: {@link GraphLibrary#exists(String)}
   */
  @Test
  @DisplayName("Test exists(String)")
  @Tag("MaintainedByDiffblue")
  void testExists() {
    // Arrange, Act and Assert
    assertFalse(new FileGraphLibrary().exists("42"));
  }

  /**
   * Test {@link GraphLibrary#addSchema(String, Schema)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link GraphLibrary#addSchema(String, Schema)}
   */
  @Test
  @DisplayName("Test addSchema(String, Schema); when 'null'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  void testAddSchema_whenNull_thenThrowIllegalArgumentException() throws OverwritingException {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> new FileGraphLibrary().addSchema(null, null));
  }

  /**
   * Test {@link GraphLibrary#addSchema(String, Schema)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link GraphLibrary#addSchema(String, Schema)}
   */
  @Test
  @DisplayName("Test addSchema(String, Schema); when 'null'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  void testAddSchema_whenNull_thenThrowIllegalArgumentException2() throws OverwritingException {
    // Arrange
    FileGraphLibrary fileGraphLibrary = new FileGraphLibrary();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> fileGraphLibrary.addSchema(null, new Schema()));
  }

  /**
   * Test {@link GraphLibrary#addOrUpdateSchema(String, Schema)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link GraphLibrary#addOrUpdateSchema(String, Schema)}
   */
  @Test
  @DisplayName(
      "Test addOrUpdateSchema(String, Schema); when 'null'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  void testAddOrUpdateSchema_whenNull_thenThrowIllegalArgumentException() {
    // Arrange
    FileGraphLibrary fileGraphLibrary = new FileGraphLibrary();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> fileGraphLibrary.addOrUpdateSchema(null, new Schema()));
  }

  /**
   * Test {@link GraphLibrary#addProperties(String, StoreProperties)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link GraphLibrary#addProperties(String, StoreProperties)}
   */
  @Test
  @DisplayName(
      "Test addProperties(String, StoreProperties); when 'null'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  void testAddProperties_whenNull_thenThrowIllegalArgumentException() throws OverwritingException {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> new FileGraphLibrary().addProperties(null, null));
  }

  /**
   * Test {@link GraphLibrary#addProperties(String, StoreProperties)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link GraphLibrary#addProperties(String, StoreProperties)}
   */
  @Test
  @DisplayName(
      "Test addProperties(String, StoreProperties); when 'null'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  void testAddProperties_whenNull_thenThrowIllegalArgumentException2() throws OverwritingException {
    // Arrange
    FileGraphLibrary fileGraphLibrary = new FileGraphLibrary();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> fileGraphLibrary.addProperties(null, new StoreProperties()));
  }

  /**
   * Test {@link GraphLibrary#addOrUpdateProperties(String, StoreProperties)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link GraphLibrary#addOrUpdateProperties(String, StoreProperties)}
   */
  @Test
  @DisplayName(
      "Test addOrUpdateProperties(String, StoreProperties); when 'null'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  void testAddOrUpdateProperties_whenNull_thenThrowIllegalArgumentException() {
    // Arrange
    FileGraphLibrary fileGraphLibrary = new FileGraphLibrary();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> fileGraphLibrary.addOrUpdateProperties(null, new StoreProperties()));
  }

  /**
   * Test {@link GraphLibrary#checkExisting(String, Schema, StoreProperties)} with {@code String},
   * {@code Schema}, {@code StoreProperties}.
   *
   * <p>Method under test: {@link GraphLibrary#checkExisting(String, Schema, StoreProperties)}
   */
  @Test
  @DisplayName(
      "Test checkExisting(String, Schema, StoreProperties) with 'String', 'Schema', 'StoreProperties'")
  @Tag("MaintainedByDiffblue")
  void testCheckExistingWithStringSchemaStoreProperties() {
    // Arrange
    FileGraphLibrary fileGraphLibrary = new FileGraphLibrary();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> fileGraphLibrary.checkExisting(null, null, new StoreProperties()));
  }

  /**
   * Test {@link GraphLibrary#resolveSchema(Schema, List)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link GraphLibrary#resolveSchema(Schema, List)}
   */
  @Test
  @DisplayName("Test resolveSchema(Schema, List); given 'null'; when ArrayList() add 'null'")
  @Tag("MaintainedByDiffblue")
  void testResolveSchema_givenNull_whenArrayListAddNull() {
    // Arrange
    FileGraphLibrary fileGraphLibrary = new FileGraphLibrary();
    Schema schema = new Schema();

    ArrayList<String> parentSchemaIds = new ArrayList<>();
    parentSchemaIds.add(null);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> fileGraphLibrary.resolveSchema(schema, parentSchemaIds));
  }

  /**
   * Test {@link GraphLibrary#resolveSchema(Schema, List)}.
   *
   * <ul>
   *   <li>Given {@code Parent Schema Ids}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code Parent Schema Ids}.
   * </ul>
   *
   * <p>Method under test: {@link GraphLibrary#resolveSchema(Schema, List)}
   */
  @Test
  @DisplayName(
      "Test resolveSchema(Schema, List); given 'Parent Schema Ids'; when ArrayList() add 'Parent Schema Ids'")
  @Tag("MaintainedByDiffblue")
  void testResolveSchema_givenParentSchemaIds_whenArrayListAddParentSchemaIds() {
    // Arrange
    FileGraphLibrary fileGraphLibrary = new FileGraphLibrary();
    Schema schema = new Schema();

    ArrayList<String> parentSchemaIds = new ArrayList<>();
    parentSchemaIds.add("Parent Schema Ids");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> fileGraphLibrary.resolveSchema(schema, parentSchemaIds));
  }

  /**
   * Test {@link GraphLibrary#resolveStoreProperties(StoreProperties, String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return AdminAuth is empty string.
   * </ul>
   *
   * <p>Method under test: {@link GraphLibrary#resolveStoreProperties(StoreProperties, String)}
   */
  @Test
  @DisplayName(
      "Test resolveStoreProperties(StoreProperties, String); when 'null'; then return AdminAuth is empty string")
  @Tag("MaintainedByDiffblue")
  void testResolveStoreProperties_whenNull_thenReturnAdminAuthIsEmptyString() {
    // Arrange and Act
    StoreProperties actualResolveStorePropertiesResult =
        new FileGraphLibrary().resolveStoreProperties(null, null);

    // Assert
    assertEquals("", actualResolveStorePropertiesResult.getAdminAuth());
    assertEquals("", actualResolveStorePropertiesResult.getJsonSerialiserModules());
    assertEquals(
        "uk.gov.gchq.gaffer.store.StoreProperties",
        actualResolveStorePropertiesResult.getStorePropertiesClassName());
    assertEquals(
        "uk.gov.gchq.gaffer.store.schema.Schema",
        actualResolveStorePropertiesResult.getSchemaClassName());
    assertNull(actualResolveStorePropertiesResult.getStrictJson());
    assertNull(actualResolveStorePropertiesResult.getCacheServiceClass());
    assertNull(actualResolveStorePropertiesResult.getDefaultCacheServiceClass());
    assertNull(actualResolveStorePropertiesResult.getJobTrackerCacheServiceClass());
    assertNull(actualResolveStorePropertiesResult.getJsonSerialiserClass());
    assertNull(actualResolveStorePropertiesResult.getNamedOperationCacheServiceClass());
    assertNull(actualResolveStorePropertiesResult.getNamedViewCacheServiceClass());
    assertNull(actualResolveStorePropertiesResult.getOperationDeclarationPaths());
    assertNull(actualResolveStorePropertiesResult.getReflectionPackages());
    assertNull(actualResolveStorePropertiesResult.getStoreClass());
    Properties properties = actualResolveStorePropertiesResult.getProperties();
    assertEquals(1, properties.size());
    assertEquals(50, actualResolveStorePropertiesResult.getJobExecutorThreadCount().intValue());
    assertFalse(actualResolveStorePropertiesResult.getJobTrackerEnabled());
    assertFalse(actualResolveStorePropertiesResult.getRescheduleJobsOnStart());
    assertTrue(properties.containsKey("gaffer.store.properties.class"));
    assertTrue(actualResolveStorePropertiesResult.getNamedOperationEnabled());
    assertTrue(actualResolveStorePropertiesResult.getNamedViewEnabled());
    Class<StoreProperties> expectedStorePropertiesClass = StoreProperties.class;
    assertEquals(
        expectedStorePropertiesClass, actualResolveStorePropertiesResult.getStorePropertiesClass());
    Class<Schema> expectedSchemaClass = Schema.class;
    assertEquals(expectedSchemaClass, actualResolveStorePropertiesResult.getSchemaClass());
  }

  /**
   * Test {@link GraphLibrary#resolveStoreProperties(StoreProperties, String)}.
   *
   * <ul>
   *   <li>When {@link StoreProperties#StoreProperties()}.
   *   <li>Then return {@link StoreProperties#StoreProperties()}.
   * </ul>
   *
   * <p>Method under test: {@link GraphLibrary#resolveStoreProperties(StoreProperties, String)}
   */
  @Test
  @DisplayName(
      "Test resolveStoreProperties(StoreProperties, String); when StoreProperties(); then return StoreProperties()")
  @Tag("MaintainedByDiffblue")
  void testResolveStoreProperties_whenStoreProperties_thenReturnStoreProperties() {
    // Arrange
    FileGraphLibrary fileGraphLibrary = new FileGraphLibrary();
    StoreProperties properties = new StoreProperties();

    // Act
    StoreProperties actualResolveStorePropertiesResult =
        fileGraphLibrary.resolveStoreProperties(properties, "42");

    // Assert
    assertEquals(properties, actualResolveStorePropertiesResult);
  }
}
