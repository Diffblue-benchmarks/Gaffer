package uk.gov.gchq.gaffer.graph;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.elementdefinition.exception.SchemaException;
import uk.gov.gchq.gaffer.data.elementdefinition.view.View;
import uk.gov.gchq.gaffer.graph.Graph.Builder;
import uk.gov.gchq.gaffer.store.StoreProperties;
import uk.gov.gchq.gaffer.store.library.FileGraphLibrary;
import uk.gov.gchq.gaffer.store.schema.Schema;

class GraphDiffblueTest {
  /**
   * Test Builder {@link Builder#addParentSchemaIds(List)} with {@code List}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addParentSchemaIds(List)}
   */
  @Test
  @DisplayName(
      "Test Builder addParentSchemaIds(List) with 'List'; given '42'; when ArrayList() add '42'")
  @Tag("MaintainedByDiffblue")
  void testBuilderAddParentSchemaIdsWithList_given42_whenArrayListAdd42() {
    // Arrange
    Builder builder = new Builder();
    builder.addParentSchemaIds(new ArrayList<>());

    ArrayList<String> parentSchemaIds = new ArrayList<>();
    parentSchemaIds.add("42");
    parentSchemaIds.add("foo");

    // Act
    Builder actualAddParentSchemaIdsResult = builder.addParentSchemaIds(parentSchemaIds);

    // Assert
    assertSame(builder, actualAddParentSchemaIdsResult);
  }

  /**
   * Test Builder {@link Builder#addParentSchemaIds(List)} with {@code List}.
   *
   * <ul>
   *   <li>Given {@link Builder} (default constructor).
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addParentSchemaIds(List)}
   */
  @Test
  @DisplayName(
      "Test Builder addParentSchemaIds(List) with 'List'; given Builder (default constructor); when ArrayList()")
  @Tag("MaintainedByDiffblue")
  void testBuilderAddParentSchemaIdsWithList_givenBuilder_whenArrayList() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualAddParentSchemaIdsResult = builder.addParentSchemaIds(new ArrayList<>());

    // Assert
    assertSame(builder, actualAddParentSchemaIdsResult);
  }

  /**
   * Test Builder {@link Builder#addParentSchemaIds(List)} with {@code List}.
   *
   * <ul>
   *   <li>Given {@link Builder} (default constructor).
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addParentSchemaIds(List)}
   */
  @Test
  @DisplayName(
      "Test Builder addParentSchemaIds(List) with 'List'; given Builder (default constructor); when 'null'")
  @Tag("MaintainedByDiffblue")
  void testBuilderAddParentSchemaIdsWithList_givenBuilder_whenNull() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualAddParentSchemaIdsResult = builder.addParentSchemaIds((List<String>) null);

    // Assert
    assertSame(builder, actualAddParentSchemaIdsResult);
  }

  /**
   * Test Builder {@link Builder#addParentSchemaIds(List)} with {@code List}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addParentSchemaIds(List)}
   */
  @Test
  @DisplayName(
      "Test Builder addParentSchemaIds(List) with 'List'; given 'foo'; when ArrayList() add 'foo'")
  @Tag("MaintainedByDiffblue")
  void testBuilderAddParentSchemaIdsWithList_givenFoo_whenArrayListAddFoo() {
    // Arrange
    Builder builder = new Builder();
    builder.addParentSchemaIds(new ArrayList<>());

    ArrayList<String> parentSchemaIds = new ArrayList<>();
    parentSchemaIds.add("foo");

    // Act
    Builder actualAddParentSchemaIdsResult = builder.addParentSchemaIds(parentSchemaIds);

    // Assert
    assertSame(builder, actualAddParentSchemaIdsResult);
  }

  /**
   * Test Builder {@link Builder#addParentSchemaIds(List)} with {@code List}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addParentSchemaIds(List)}
   */
  @Test
  @DisplayName("Test Builder addParentSchemaIds(List) with 'List'; when ArrayList()")
  @Tag("MaintainedByDiffblue")
  void testBuilderAddParentSchemaIdsWithList_whenArrayList() {
    // Arrange
    Builder builder = new Builder();
    builder.addParentSchemaIds(new ArrayList<>());

    // Act
    Builder actualAddParentSchemaIdsResult = builder.addParentSchemaIds(new ArrayList<>());

    // Assert
    assertSame(builder, actualAddParentSchemaIdsResult);
  }

  /**
   * Test Builder {@link Builder#addParentSchemaIds(String[])} with {@code String[]}.
   *
   * <ul>
   *   <li>Given {@link Builder} (default constructor) addParentSchemaIds {@link
   *       ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addParentSchemaIds(String[])}
   */
  @Test
  @DisplayName(
      "Test Builder addParentSchemaIds(String[]) with 'String[]'; given Builder (default constructor) addParentSchemaIds ArrayList()")
  @Tag("MaintainedByDiffblue")
  void testBuilderAddParentSchemaIdsWithString_givenBuilderAddParentSchemaIdsArrayList() {
    // Arrange
    Builder builder = new Builder();
    builder.addParentSchemaIds(new ArrayList<>());

    // Act
    Builder actualAddParentSchemaIdsResult = builder.addParentSchemaIds("Parent Schema Ids");

    // Assert
    assertSame(builder, actualAddParentSchemaIdsResult);
  }

  /**
   * Test Builder {@link Builder#addParentSchemaIds(String[])} with {@code String[]}.
   *
   * <ul>
   *   <li>Given {@link Builder} (default constructor).
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addParentSchemaIds(String[])}
   */
  @Test
  @DisplayName(
      "Test Builder addParentSchemaIds(String[]) with 'String[]'; given Builder (default constructor); when 'null'")
  @Tag("MaintainedByDiffblue")
  void testBuilderAddParentSchemaIdsWithString_givenBuilder_whenNull() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualAddParentSchemaIdsResult = builder.addParentSchemaIds((String[]) null);

    // Assert
    assertSame(builder, actualAddParentSchemaIdsResult);
  }

  /**
   * Test Builder {@link Builder#addParentSchemaIds(String[])} with {@code String[]}.
   *
   * <ul>
   *   <li>Given {@link Builder} (default constructor).
   *   <li>When {@code Parent Schema Ids}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addParentSchemaIds(String[])}
   */
  @Test
  @DisplayName(
      "Test Builder addParentSchemaIds(String[]) with 'String[]'; given Builder (default constructor); when 'Parent Schema Ids'")
  @Tag("MaintainedByDiffblue")
  void testBuilderAddParentSchemaIdsWithString_givenBuilder_whenParentSchemaIds() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualAddParentSchemaIdsResult = builder.addParentSchemaIds("Parent Schema Ids");

    // Assert
    assertSame(builder, actualAddParentSchemaIdsResult);
  }

  /**
   * Test Builder {@link Builder#addSchema(byte[])} with {@code schemaBytes}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addSchema(byte[])}
   */
  @Test
  @DisplayName(
      "Test Builder addSchema(byte[]) with 'schemaBytes'; when 'AXAXAXAX' Bytes is 'UTF-8'")
  @Tag("MaintainedByDiffblue")
  void testBuilderAddSchemaWithSchemaBytes_whenAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualAddSchemaResult = builder.addSchema("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertSame(builder, actualAddSchemaResult);
  }

  /**
   * Test Builder {@link Builder#addSchema(byte[])} with {@code schemaBytes}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addSchema(byte[])}
   */
  @Test
  @DisplayName("Test Builder addSchema(byte[]) with 'schemaBytes'; when 'null'")
  @Tag("MaintainedByDiffblue")
  void testBuilderAddSchemaWithSchemaBytes_whenNull() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualAddSchemaResult = builder.addSchema((byte[]) null);

    // Assert
    assertSame(builder, actualAddSchemaResult);
  }

  /**
   * Test Builder {@link Builder#addSchema(Schema)} with {@code schemaModule}.
   *
   * <ul>
   *   <li>Given array of {@link Schema} with {@link Schema#Schema()}.
   *   <li>When {@link Schema#Schema()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addSchema(Schema)}
   */
  @Test
  @DisplayName(
      "Test Builder addSchema(Schema) with 'schemaModule'; given array of Schema with Schema(); when Schema()")
  @Tag("MaintainedByDiffblue")
  void testBuilderAddSchemaWithSchemaModule_givenArrayOfSchemaWithSchema_whenSchema() {
    // Arrange
    Builder builder = new Builder();
    builder.addSchemas(new Schema());

    // Act
    Builder actualAddSchemaResult = builder.addSchema(new Schema());

    // Assert
    assertSame(builder, actualAddSchemaResult);
  }

  /**
   * Test Builder {@link Builder#addSchema(Schema)} with {@code schemaModule}.
   *
   * <ul>
   *   <li>Given {@link Builder} (default constructor).
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addSchema(Schema)}
   */
  @Test
  @DisplayName(
      "Test Builder addSchema(Schema) with 'schemaModule'; given Builder (default constructor); when 'null'")
  @Tag("MaintainedByDiffblue")
  void testBuilderAddSchemaWithSchemaModule_givenBuilder_whenNull() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualAddSchemaResult = builder.addSchema((Schema) null);

    // Assert
    assertSame(builder, actualAddSchemaResult);
  }

  /**
   * Test Builder {@link Builder#addSchema(Schema)} with {@code schemaModule}.
   *
   * <ul>
   *   <li>Given {@link Builder} (default constructor).
   *   <li>When {@link Schema#Schema()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addSchema(Schema)}
   */
  @Test
  @DisplayName(
      "Test Builder addSchema(Schema) with 'schemaModule'; given Builder (default constructor); when Schema()")
  @Tag("MaintainedByDiffblue")
  void testBuilderAddSchemaWithSchemaModule_givenBuilder_whenSchema() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualAddSchemaResult = builder.addSchema(new Schema());

    // Assert
    assertSame(builder, actualAddSchemaResult);
  }

  /**
   * Test Builder {@link Builder#addSchema(Schema)} with {@code schemaModule}.
   *
   * <ul>
   *   <li>Given {@code Key}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addSchema(Schema)}
   */
  @Test
  @DisplayName("Test Builder addSchema(Schema) with 'schemaModule'; given 'Key'")
  @Tag("MaintainedByDiffblue")
  void testBuilderAddSchemaWithSchemaModule_givenKey() {
    // Arrange
    Schema schema = new Schema();
    schema.addConfig("filterFieldsByName", "42");

    Builder builder = new Builder();
    builder.addSchemas(schema);

    Schema schemaModule = new Schema();
    schemaModule.addConfig("Key", "filterFieldsByName");

    // Act
    Builder actualAddSchemaResult = builder.addSchema(schemaModule);

    // Assert
    assertSame(builder, actualAddSchemaResult);
  }

  /**
   * Test Builder {@link Builder#addSchema(Schema)} with {@code schemaModule}.
   *
   * <ul>
   *   <li>Given {@link Schema#Schema()} addConfig {@code filterFieldsByName} and {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addSchema(Schema)}
   */
  @Test
  @DisplayName(
      "Test Builder addSchema(Schema) with 'schemaModule'; given Schema() addConfig 'filterFieldsByName' and '42'")
  @Tag("MaintainedByDiffblue")
  void testBuilderAddSchemaWithSchemaModule_givenSchemaAddConfigFilterFieldsByNameAnd42() {
    // Arrange
    Schema schema = new Schema();
    schema.addConfig("filterFieldsByName", "42");

    Builder builder = new Builder();
    builder.addSchemas(schema);

    // Act
    Builder actualAddSchemaResult = builder.addSchema(new Schema());

    // Assert
    assertSame(builder, actualAddSchemaResult);
  }

  /**
   * Test Builder {@link Builder#addSchema(Path)} with {@code schemaPath}.
   *
   * <ul>
   *   <li>When Property is {@code java.io.tmpdir} is empty string.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addSchema(Path)}
   */
  @Test
  @DisplayName(
      "Test Builder addSchema(Path) with 'schemaPath'; when Property is 'java.io.tmpdir' is empty string")
  @Tag("MaintainedByDiffblue")
  void testBuilderAddSchemaWithSchemaPath_whenPropertyIsJavaIoTmpdirIsEmptyString() {
    // Arrange, Act and Assert
    assertThrows(
        SchemaException.class,
        () -> new Builder().addSchema(Paths.get(System.getProperty("java.io.tmpdir"), "")));
  }

  /**
   * Test Builder {@link Builder#addSchema(Path)} with {@code schemaPath}.
   *
   * <ul>
   *   <li>When Property is {@code java.io.tmpdir} is {@code test.txt}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addSchema(Path)}
   */
  @Test
  @DisplayName(
      "Test Builder addSchema(Path) with 'schemaPath'; when Property is 'java.io.tmpdir' is 'test.txt'")
  @Tag("MaintainedByDiffblue")
  void testBuilderAddSchemaWithSchemaPath_whenPropertyIsJavaIoTmpdirIsTestTxt() {
    // Arrange, Act and Assert
    assertThrows(
        SchemaException.class,
        () -> new Builder().addSchema(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt")));
  }

  /**
   * Test Builder {@link Builder#addSchema(InputStream)} with {@code schemaStream}.
   *
   * <p>Method under test: {@link Builder#addSchema(InputStream)}
   */
  @Test
  @DisplayName("Test Builder addSchema(InputStream) with 'schemaStream'")
  @Tag("MaintainedByDiffblue")
  void testBuilderAddSchemaWithSchemaStream() throws IOException {
    // Arrange
    Builder builder = new Builder();
    ByteArrayInputStream schemaStream = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Builder actualAddSchemaResult = builder.addSchema(schemaStream);

    // Assert
    int actualReadResult = schemaStream.read(new byte[] {});
    assertEquals(-1, actualReadResult);
    assertSame(builder, actualAddSchemaResult);
  }

  /**
   * Test Builder {@link Builder#addSchema(InputStream)} with {@code schemaStream}.
   *
   * <p>Method under test: {@link Builder#addSchema(InputStream)}
   */
  @Test
  @DisplayName("Test Builder addSchema(InputStream) with 'schemaStream'")
  @Tag("MaintainedByDiffblue")
  void testBuilderAddSchemaWithSchemaStream2() throws IOException {
    // Arrange
    Builder builder = new Builder();
    ByteArrayInputStream schemaStream = new ByteArrayInputStream(new byte[] {});

    // Act
    Builder actualAddSchemaResult = builder.addSchema(schemaStream);

    // Assert
    int actualReadResult = schemaStream.read(new byte[] {});
    assertEquals(-1, actualReadResult);
    assertSame(builder, actualAddSchemaResult);
  }

  /**
   * Test Builder {@link Builder#addSchema(InputStream)} with {@code schemaStream}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addSchema(InputStream)}
   */
  @Test
  @DisplayName("Test Builder addSchema(InputStream) with 'schemaStream'; when 'null'; then 'null'")
  @Tag("MaintainedByDiffblue")
  void testBuilderAddSchemaWithSchemaStream_whenNull_thenNull() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualAddSchemaResult = builder.addSchema((InputStream) null);

    // Assert
    assertNull(null);
    assertSame(builder, actualAddSchemaResult);
  }

  /**
   * Test Builder {@link Builder#addSchema(URI)} with {@code schemaURI}.
   *
   * <ul>
   *   <li>Then throw {@link SchemaException}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addSchema(URI)}
   */
  @Test
  @DisplayName("Test Builder addSchema(URI) with 'schemaURI'; then throw SchemaException")
  @Tag("MaintainedByDiffblue")
  void testBuilderAddSchemaWithSchemaURI_thenThrowSchemaException() {
    // Arrange, Act and Assert
    assertThrows(
        SchemaException.class,
        () ->
            new Builder()
                .addSchema(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri()));
  }

  /**
   * Test Builder {@link Builder#addSchema(URI)} with {@code schemaURI}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@link Builder} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link Builder#addSchema(URI)}
   */
  @Test
  @DisplayName(
      "Test Builder addSchema(URI) with 'schemaURI'; when 'null'; then return Builder (default constructor)")
  @Tag("MaintainedByDiffblue")
  void testBuilderAddSchemaWithSchemaURI_whenNull_thenReturnBuilder() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualAddSchemaResult = builder.addSchema((URI) null);

    // Assert
    assertSame(builder, actualAddSchemaResult);
  }

  /**
   * Test Builder {@link Builder#addSchema(URI)} with {@code schemaURI}.
   *
   * <ul>
   *   <li>When Property is {@code java.io.tmpdir} is empty string toUri.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addSchema(URI)}
   */
  @Test
  @DisplayName(
      "Test Builder addSchema(URI) with 'schemaURI'; when Property is 'java.io.tmpdir' is empty string toUri")
  @Tag("MaintainedByDiffblue")
  void testBuilderAddSchemaWithSchemaURI_whenPropertyIsJavaIoTmpdirIsEmptyStringToUri() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualAddSchemaResult =
        builder.addSchema(Paths.get(System.getProperty("java.io.tmpdir"), "").toUri());

    // Assert
    assertSame(builder, actualAddSchemaResult);
  }

  /**
   * Test Builder {@link Builder#addSchemas(byte[][])} with {@code schemaBytesArray}.
   *
   * <p>Method under test: {@link Builder#addSchemas(byte[][])}
   */
  @Test
  @DisplayName("Test Builder addSchemas(byte[][]) with 'schemaBytesArray'")
  @Tag("MaintainedByDiffblue")
  void testBuilderAddSchemasWithSchemaBytesArray() throws UnsupportedEncodingException {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualAddSchemasResult = builder.addSchemas("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertSame(builder, actualAddSchemasResult);
  }

  /**
   * Test Builder {@link Builder#addSchemas(Schema[])} with {@code schemaModules}.
   *
   * <p>Method under test: {@link Builder#addSchemas(Schema[])}
   */
  @Test
  @DisplayName("Test Builder addSchemas(Schema[]) with 'schemaModules'")
  @Tag("MaintainedByDiffblue")
  void testBuilderAddSchemasWithSchemaModules() {
    // Arrange
    Schema schema = new Schema();
    schema.addConfig("filterFieldsByName", "42");

    Builder builder = new Builder();
    builder.addSchemas(schema);

    // Act
    Builder actualAddSchemasResult = builder.addSchemas(new Schema());

    // Assert
    assertSame(builder, actualAddSchemasResult);
  }

  /**
   * Test Builder {@link Builder#addSchemas(Schema[])} with {@code schemaModules}.
   *
   * <ul>
   *   <li>Given array of {@link Schema} with {@link Schema#Schema()}.
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addSchemas(Schema[])}
   */
  @Test
  @DisplayName(
      "Test Builder addSchemas(Schema[]) with 'schemaModules'; given array of Schema with Schema(); when 'null'")
  @Tag("MaintainedByDiffblue")
  void testBuilderAddSchemasWithSchemaModules_givenArrayOfSchemaWithSchema_whenNull() {
    // Arrange
    Builder builder = new Builder();
    builder.addSchemas(new Schema());

    // Act
    Builder actualAddSchemasResult = builder.addSchemas((Schema) null);

    // Assert
    assertSame(builder, actualAddSchemasResult);
  }

  /**
   * Test Builder {@link Builder#addSchemas(Schema[])} with {@code schemaModules}.
   *
   * <ul>
   *   <li>Given array of {@link Schema} with {@link Schema#Schema()}.
   *   <li>When {@link Schema#Schema()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addSchemas(Schema[])}
   */
  @Test
  @DisplayName(
      "Test Builder addSchemas(Schema[]) with 'schemaModules'; given array of Schema with Schema(); when Schema()")
  @Tag("MaintainedByDiffblue")
  void testBuilderAddSchemasWithSchemaModules_givenArrayOfSchemaWithSchema_whenSchema() {
    // Arrange
    Builder builder = new Builder();
    builder.addSchemas(new Schema());

    // Act
    Builder actualAddSchemasResult = builder.addSchemas(new Schema());

    // Assert
    assertSame(builder, actualAddSchemasResult);
  }

  /**
   * Test Builder {@link Builder#addSchemas(Schema[])} with {@code schemaModules}.
   *
   * <ul>
   *   <li>Given {@link Builder} (default constructor).
   *   <li>When {@link Schema#Schema()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addSchemas(Schema[])}
   */
  @Test
  @DisplayName(
      "Test Builder addSchemas(Schema[]) with 'schemaModules'; given Builder (default constructor); when Schema()")
  @Tag("MaintainedByDiffblue")
  void testBuilderAddSchemasWithSchemaModules_givenBuilder_whenSchema() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualAddSchemasResult = builder.addSchemas(new Schema());

    // Assert
    assertSame(builder, actualAddSchemasResult);
  }

  /**
   * Test Builder {@link Builder#addSchemas(Schema[])} with {@code schemaModules}.
   *
   * <ul>
   *   <li>Given {@code Key}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addSchemas(Schema[])}
   */
  @Test
  @DisplayName("Test Builder addSchemas(Schema[]) with 'schemaModules'; given 'Key'")
  @Tag("MaintainedByDiffblue")
  void testBuilderAddSchemasWithSchemaModules_givenKey() {
    // Arrange
    Schema schema = new Schema();
    schema.addConfig("filterFieldsByName", "42");

    Builder builder = new Builder();
    builder.addSchemas(schema);

    Schema schema2 = new Schema();
    schema2.addConfig("Key", "filterFieldsByName");

    // Act
    Builder actualAddSchemasResult = builder.addSchemas(schema2);

    // Assert
    assertSame(builder, actualAddSchemasResult);
  }

  /**
   * Test Builder {@link Builder#addSchemas(Path[])} with {@code schemaPaths}.
   *
   * <p>Method under test: {@link Builder#addSchemas(Path[])}
   */
  @Test
  @DisplayName("Test Builder addSchemas(Path[]) with 'schemaPaths'")
  @Tag("MaintainedByDiffblue")
  void testBuilderAddSchemasWithSchemaPaths() {
    // Arrange
    Builder builder = new Builder();
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");

    // Act
    Builder actualAddSchemasResult = builder.addSchemas(new Path[] {});

    // Assert
    assertSame(builder, actualAddSchemasResult);
  }

  /**
   * Test Builder {@link Builder#addSchemas(Path[])} with {@code schemaPaths}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@link Builder} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link Builder#addSchemas(Path[])}
   */
  @Test
  @DisplayName(
      "Test Builder addSchemas(Path[]) with 'schemaPaths'; when 'null'; then return Builder (default constructor)")
  @Tag("MaintainedByDiffblue")
  void testBuilderAddSchemasWithSchemaPaths_whenNull_thenReturnBuilder() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualAddSchemasResult = builder.addSchemas((Path[]) null);

    // Assert
    assertSame(builder, actualAddSchemasResult);
  }

  /**
   * Test Builder {@link Builder#addSchemas(Path[])} with {@code schemaPaths}.
   *
   * <ul>
   *   <li>When Property is {@code java.io.tmpdir} is empty string.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addSchemas(Path[])}
   */
  @Test
  @DisplayName(
      "Test Builder addSchemas(Path[]) with 'schemaPaths'; when Property is 'java.io.tmpdir' is empty string")
  @Tag("MaintainedByDiffblue")
  void testBuilderAddSchemasWithSchemaPaths_whenPropertyIsJavaIoTmpdirIsEmptyString() {
    // Arrange, Act and Assert
    assertThrows(
        SchemaException.class,
        () -> new Builder().addSchemas(Paths.get(System.getProperty("java.io.tmpdir"), "")));
  }

  /**
   * Test Builder {@link Builder#addSchemas(Path[])} with {@code schemaPaths}.
   *
   * <ul>
   *   <li>When Property is {@code java.io.tmpdir} is {@code test.txt}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addSchemas(Path[])}
   */
  @Test
  @DisplayName(
      "Test Builder addSchemas(Path[]) with 'schemaPaths'; when Property is 'java.io.tmpdir' is 'test.txt'")
  @Tag("MaintainedByDiffblue")
  void testBuilderAddSchemasWithSchemaPaths_whenPropertyIsJavaIoTmpdirIsTestTxt() {
    // Arrange, Act and Assert
    assertThrows(
        SchemaException.class,
        () ->
            new Builder().addSchemas(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt")));
  }

  /**
   * Test Builder {@link Builder#addSchemas(InputStream[])} with {@code schemaStreams}.
   *
   * <p>Method under test: {@link Builder#addSchemas(InputStream[])}
   */
  @Test
  @DisplayName("Test Builder addSchemas(InputStream[]) with 'schemaStreams'")
  @Tag("MaintainedByDiffblue")
  void testBuilderAddSchemasWithSchemaStreams() throws IOException {
    // Arrange
    Builder builder = new Builder();
    InputStream[] schemaStreams =
        new InputStream[] {new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))};

    // Act
    Builder actualAddSchemasResult = builder.addSchemas(schemaStreams);

    // Assert
    int actualReadResult = schemaStreams[0].read(new byte[] {});
    assertEquals(-1, actualReadResult);
    assertEquals(1, schemaStreams.length);
    assertSame(builder, actualAddSchemasResult);
  }

  /**
   * Test Builder {@link Builder#addSchemas(InputStream[])} with {@code schemaStreams}.
   *
   * <p>Method under test: {@link Builder#addSchemas(InputStream[])}
   */
  @Test
  @DisplayName("Test Builder addSchemas(InputStream[]) with 'schemaStreams'")
  @Tag("MaintainedByDiffblue")
  void testBuilderAddSchemasWithSchemaStreams2() throws IOException {
    // Arrange
    Builder builder = new Builder();
    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(new byte[] {});
    InputStream[] schemaStreams = new InputStream[] {byteArrayInputStream};

    // Act
    Builder actualAddSchemasResult = builder.addSchemas(schemaStreams);

    // Assert
    int actualReadResult = schemaStreams[0].read(new byte[] {});
    assertEquals(-1, actualReadResult);
    assertEquals(1, schemaStreams.length);
    assertSame(builder, actualAddSchemasResult);
  }

  /**
   * Test Builder {@link Builder#addSchemas(URI[])} with {@code schemaURI}.
   *
   * <p>Method under test: {@link Builder#addSchemas(URI[])}
   */
  @Test
  @DisplayName("Test Builder addSchemas(URI[]) with 'schemaURI'")
  @Tag("MaintainedByDiffblue")
  void testBuilderAddSchemasWithSchemaURI() {
    // Arrange
    Builder builder = new Builder();
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri();

    // Act
    Builder actualAddSchemasResult = builder.addSchemas(new URI[] {});

    // Assert
    assertSame(builder, actualAddSchemasResult);
  }

  /**
   * Test Builder {@link Builder#addSchemas(URI[])} with {@code schemaURI}.
   *
   * <ul>
   *   <li>Then throw {@link SchemaException}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addSchemas(URI[])}
   */
  @Test
  @DisplayName("Test Builder addSchemas(URI[]) with 'schemaURI'; then throw SchemaException")
  @Tag("MaintainedByDiffblue")
  void testBuilderAddSchemasWithSchemaURI_thenThrowSchemaException() {
    // Arrange, Act and Assert
    assertThrows(
        SchemaException.class,
        () ->
            new Builder()
                .addSchemas(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri()));
  }

  /**
   * Test Builder {@link Builder#addSchemas(URI[])} with {@code schemaURI}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@link Builder} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link Builder#addSchemas(URI[])}
   */
  @Test
  @DisplayName(
      "Test Builder addSchemas(URI[]) with 'schemaURI'; when 'null'; then return Builder (default constructor)")
  @Tag("MaintainedByDiffblue")
  void testBuilderAddSchemasWithSchemaURI_whenNull_thenReturnBuilder() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualAddSchemasResult = builder.addSchemas((URI[]) null);

    // Assert
    assertSame(builder, actualAddSchemasResult);
  }

  /**
   * Test Builder {@link Builder#addSchemas(URI[])} with {@code schemaURI}.
   *
   * <ul>
   *   <li>When Property is {@code java.io.tmpdir} is toUri.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addSchemas(URI[])}
   */
  @Test
  @DisplayName(
      "Test Builder addSchemas(URI[]) with 'schemaURI'; when Property is 'java.io.tmpdir' is toUri")
  @Tag("MaintainedByDiffblue")
  void testBuilderAddSchemasWithSchemaURI_whenPropertyIsJavaIoTmpdirIsToUri() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualAddSchemasResult =
        builder.addSchemas(Paths.get(System.getProperty("java.io.tmpdir")).toUri());

    // Assert
    assertSame(builder, actualAddSchemasResult);
  }

  /**
   * Test Builder {@link Builder#addStoreProperties(InputStream)} with {@code InputStream}.
   *
   * <p>Method under test: {@link Builder#addStoreProperties(InputStream)}
   */
  @Test
  @DisplayName("Test Builder addStoreProperties(InputStream) with 'InputStream'")
  @Tag("MaintainedByDiffblue")
  void testBuilderAddStorePropertiesWithInputStream() throws IOException {
    // Arrange
    Builder builder = new Builder();
    builder.storeProperties(new StoreProperties());
    ByteArrayInputStream updatePropertiesStream =
        new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Builder actualAddStorePropertiesResult = builder.addStoreProperties(updatePropertiesStream);

    // Assert
    int actualReadResult = updatePropertiesStream.read(new byte[] {});
    assertEquals(-1, actualReadResult);
    assertSame(builder, actualAddStorePropertiesResult);
  }

  /**
   * Test Builder {@link Builder#addStoreProperties(InputStream)} with {@code InputStream}.
   *
   * <ul>
   *   <li>Given {@link Builder} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link Builder#addStoreProperties(InputStream)}
   */
  @Test
  @DisplayName(
      "Test Builder addStoreProperties(InputStream) with 'InputStream'; given Builder (default constructor)")
  @Tag("MaintainedByDiffblue")
  void testBuilderAddStorePropertiesWithInputStream_givenBuilder() throws IOException {
    // Arrange
    Builder builder = new Builder();
    ByteArrayInputStream updatePropertiesStream =
        new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Builder actualAddStorePropertiesResult = builder.addStoreProperties(updatePropertiesStream);

    // Assert
    int actualReadResult = updatePropertiesStream.read(new byte[] {});
    assertEquals(-1, actualReadResult);
    assertSame(builder, actualAddStorePropertiesResult);
  }

  /**
   * Test Builder {@link Builder#addStoreProperties(InputStream)} with {@code InputStream}.
   *
   * <ul>
   *   <li>Then {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addStoreProperties(InputStream)}
   */
  @Test
  @DisplayName("Test Builder addStoreProperties(InputStream) with 'InputStream'; then 'null'")
  @Tag("MaintainedByDiffblue")
  void testBuilderAddStorePropertiesWithInputStream_thenNull() {
    // Arrange
    Builder builder = new Builder();
    builder.storeProperties((StoreProperties) null);

    // Act
    Builder actualAddStorePropertiesResult = builder.addStoreProperties((InputStream) null);

    // Assert
    assertNull(null);
    assertSame(builder, actualAddStorePropertiesResult);
  }

  /**
   * Test Builder {@link Builder#addStoreProperties(Path)} with {@code Path}.
   *
   * <ul>
   *   <li>Then return {@link Builder} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link Builder#addStoreProperties(Path)}
   */
  @Test
  @DisplayName(
      "Test Builder addStoreProperties(Path) with 'Path'; then return Builder (default constructor)")
  @Tag("MaintainedByDiffblue")
  void testBuilderAddStorePropertiesWithPath_thenReturnBuilder() {
    // Arrange
    Builder builder = new Builder();
    builder.storeProperties((StoreProperties) null);

    // Act
    Builder actualAddStorePropertiesResult = builder.addStoreProperties((Path) null);

    // Assert
    assertSame(builder, actualAddStorePropertiesResult);
  }

  /**
   * Test Builder {@link Builder#addStoreProperties(Properties)} with {@code Properties}.
   *
   * <p>Method under test: {@link Builder#addStoreProperties(Properties)}
   */
  @Test
  @DisplayName("Test Builder addStoreProperties(Properties) with 'Properties'")
  @Tag("MaintainedByDiffblue")
  void testBuilderAddStorePropertiesWithProperties() {
    // Arrange
    Builder builder = new Builder();
    builder.storeProperties(new StoreProperties());

    // Act
    Builder actualAddStorePropertiesResult = builder.addStoreProperties(new Properties());

    // Assert
    assertSame(builder, actualAddStorePropertiesResult);
  }

  /**
   * Test Builder {@link Builder#addStoreProperties(Properties)} with {@code Properties}.
   *
   * <ul>
   *   <li>Given {@link Builder} (default constructor) storeProperties {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addStoreProperties(Properties)}
   */
  @Test
  @DisplayName(
      "Test Builder addStoreProperties(Properties) with 'Properties'; given Builder (default constructor) storeProperties 'null'")
  @Tag("MaintainedByDiffblue")
  void testBuilderAddStorePropertiesWithProperties_givenBuilderStorePropertiesNull() {
    // Arrange
    Builder builder = new Builder();
    builder.storeProperties((StoreProperties) null);

    // Act
    Builder actualAddStorePropertiesResult = builder.addStoreProperties((Properties) null);

    // Assert
    assertSame(builder, actualAddStorePropertiesResult);
  }

  /**
   * Test Builder {@link Builder#addStoreProperties(Properties)} with {@code Properties}.
   *
   * <ul>
   *   <li>Given {@link Builder} (default constructor).
   *   <li>When {@link Properties#Properties()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addStoreProperties(Properties)}
   */
  @Test
  @DisplayName(
      "Test Builder addStoreProperties(Properties) with 'Properties'; given Builder (default constructor); when Properties()")
  @Tag("MaintainedByDiffblue")
  void testBuilderAddStorePropertiesWithProperties_givenBuilder_whenProperties() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualAddStorePropertiesResult = builder.addStoreProperties(new Properties());

    // Assert
    assertSame(builder, actualAddStorePropertiesResult);
  }

  /**
   * Test Builder {@link Builder#addStoreProperties(StoreProperties)} with {@code StoreProperties}.
   *
   * <p>Method under test: {@link Builder#addStoreProperties(StoreProperties)}
   */
  @Test
  @DisplayName("Test Builder addStoreProperties(StoreProperties) with 'StoreProperties'")
  @Tag("MaintainedByDiffblue")
  void testBuilderAddStorePropertiesWithStoreProperties() {
    // Arrange
    Builder builder = new Builder();
    builder.storeProperties(new StoreProperties());

    // Act
    Builder actualAddStorePropertiesResult = builder.addStoreProperties(new StoreProperties());

    // Assert
    assertSame(builder, actualAddStorePropertiesResult);
  }

  /**
   * Test Builder {@link Builder#addStoreProperties(StoreProperties)} with {@code StoreProperties}.
   *
   * <ul>
   *   <li>Given {@link Builder} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link Builder#addStoreProperties(StoreProperties)}
   */
  @Test
  @DisplayName(
      "Test Builder addStoreProperties(StoreProperties) with 'StoreProperties'; given Builder (default constructor)")
  @Tag("MaintainedByDiffblue")
  void testBuilderAddStorePropertiesWithStoreProperties_givenBuilder() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualAddStorePropertiesResult = builder.addStoreProperties(new StoreProperties());

    // Assert
    assertSame(builder, actualAddStorePropertiesResult);
  }

  /**
   * Test Builder {@link Builder#addStoreProperties(StoreProperties)} with {@code StoreProperties}.
   *
   * <ul>
   *   <li>Given {@link Builder} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link Builder#addStoreProperties(StoreProperties)}
   */
  @Test
  @DisplayName(
      "Test Builder addStoreProperties(StoreProperties) with 'StoreProperties'; given Builder (default constructor)")
  @Tag("MaintainedByDiffblue")
  void testBuilderAddStorePropertiesWithStoreProperties_givenBuilder2() {
    // Arrange
    Builder builder = new Builder();

    StoreProperties updateProperties = new StoreProperties();
    updateProperties.set(StoreProperties.REFLECTION_PACKAGES, "42");

    // Act
    Builder actualAddStorePropertiesResult = builder.addStoreProperties(updateProperties);

    // Assert
    assertSame(builder, actualAddStorePropertiesResult);
  }

  /**
   * Test Builder {@link Builder#addStoreProperties(StoreProperties)} with {@code StoreProperties}.
   *
   * <ul>
   *   <li>Given {@link Builder} (default constructor) addToLibrary {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addStoreProperties(StoreProperties)}
   */
  @Test
  @DisplayName(
      "Test Builder addStoreProperties(StoreProperties) with 'StoreProperties'; given Builder (default constructor) addToLibrary 'false'")
  @Tag("MaintainedByDiffblue")
  void testBuilderAddStorePropertiesWithStoreProperties_givenBuilderAddToLibraryFalse() {
    // Arrange
    Builder builder = new Builder();
    builder.addToLibrary(false);

    StoreProperties updateProperties = new StoreProperties();
    updateProperties.set(StoreProperties.REFLECTION_PACKAGES, "42");

    // Act
    Builder actualAddStorePropertiesResult = builder.addStoreProperties(updateProperties);

    // Assert
    assertSame(builder, actualAddStorePropertiesResult);
  }

  /**
   * Test Builder {@link Builder#addStoreProperties(StoreProperties)} with {@code StoreProperties}.
   *
   * <ul>
   *   <li>Given {@link Builder} (default constructor) storeProperties {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addStoreProperties(StoreProperties)}
   */
  @Test
  @DisplayName(
      "Test Builder addStoreProperties(StoreProperties) with 'StoreProperties'; given Builder (default constructor) storeProperties 'null'")
  @Tag("MaintainedByDiffblue")
  void testBuilderAddStorePropertiesWithStoreProperties_givenBuilderStorePropertiesNull() {
    // Arrange
    Builder builder = new Builder();
    builder.storeProperties((StoreProperties) null);

    // Act
    Builder actualAddStorePropertiesResult = builder.addStoreProperties((StoreProperties) null);

    // Assert
    assertSame(builder, actualAddStorePropertiesResult);
  }

  /**
   * Test Builder {@link Builder#addStoreProperties(String)} with {@code String}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@link Builder} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link Builder#addStoreProperties(String)}
   */
  @Test
  @DisplayName(
      "Test Builder addStoreProperties(String) with 'String'; when 'null'; then return Builder (default constructor)")
  @Tag("MaintainedByDiffblue")
  void testBuilderAddStorePropertiesWithString_whenNull_thenReturnBuilder() {
    // Arrange
    Builder builder = new Builder();
    builder.storeProperties((StoreProperties) null);

    // Act
    Builder actualAddStorePropertiesResult = builder.addStoreProperties((String) null);

    // Assert
    assertSame(builder, actualAddStorePropertiesResult);
  }

  /**
   * Test Builder {@link Builder#addStoreProperties(URI)} with {@code URI}.
   *
   * <ul>
   *   <li>Given {@link Builder} (default constructor).
   *   <li>Then throw {@link SchemaException}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addStoreProperties(URI)}
   */
  @Test
  @DisplayName(
      "Test Builder addStoreProperties(URI) with 'URI'; given Builder (default constructor); then throw SchemaException")
  @Tag("MaintainedByDiffblue")
  void testBuilderAddStorePropertiesWithUri_givenBuilder_thenThrowSchemaException() {
    // Arrange, Act and Assert
    assertThrows(
        SchemaException.class,
        () ->
            new Builder()
                .addStoreProperties(
                    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri()));
  }

  /**
   * Test Builder {@link Builder#addStoreProperties(URI)} with {@code URI}.
   *
   * <ul>
   *   <li>Then return {@link Builder} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link Builder#addStoreProperties(URI)}
   */
  @Test
  @DisplayName(
      "Test Builder addStoreProperties(URI) with 'URI'; then return Builder (default constructor)")
  @Tag("MaintainedByDiffblue")
  void testBuilderAddStorePropertiesWithUri_thenReturnBuilder() {
    // Arrange
    Builder builder = new Builder();
    builder.storeProperties((StoreProperties) null);

    // Act
    Builder actualAddStorePropertiesResult = builder.addStoreProperties((URI) null);

    // Assert
    assertSame(builder, actualAddStorePropertiesResult);
  }

  /**
   * Test Builder {@link Builder#config(byte[])} with {@code bytes}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@link Builder} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link Builder#config(byte[])}
   */
  @Test
  @DisplayName(
      "Test Builder config(byte[]) with 'bytes'; when 'null'; then return Builder (default constructor)")
  @Tag("MaintainedByDiffblue")
  void testBuilderConfigWithBytes_whenNull_thenReturnBuilder() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualConfigResult = builder.config((byte[]) null);

    // Assert
    assertSame(builder, actualConfigResult);
  }

  /**
   * Test Builder {@link Builder#config(GraphConfig)} with {@code config}.
   *
   * <p>Method under test: {@link Builder#config(GraphConfig)}
   */
  @Test
  @DisplayName("Test Builder config(GraphConfig) with 'config'")
  @Tag("MaintainedByDiffblue")
  void testBuilderConfigWithConfig() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualConfigResult =
        builder.config(
            new GraphConfig.Builder()
                .description("The characteristics of someone or something")
                .build());

    // Assert
    assertSame(builder, actualConfigResult);
  }

  /**
   * Test Builder {@link Builder#config(GraphConfig)} with {@code config}.
   *
   * <ul>
   *   <li>Given {@link FileGraphLibrary#FileGraphLibrary()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#config(GraphConfig)}
   */
  @Test
  @DisplayName("Test Builder config(GraphConfig) with 'config'; given FileGraphLibrary()")
  @Tag("MaintainedByDiffblue")
  void testBuilderConfigWithConfig_givenFileGraphLibrary() {
    // Arrange
    Builder builder = new Builder();

    GraphConfig config = new GraphConfig(null);
    config.setLibrary(new FileGraphLibrary());
    config.setDescription(null);
    config.setOtelActive(null);
    config.setView(null);

    // Act
    Builder actualConfigResult = builder.config(config);

    // Assert
    assertSame(builder, actualConfigResult);
  }

  /**
   * Test Builder {@link Builder#config(GraphConfig)} with {@code config}.
   *
   * <ul>
   *   <li>Given {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#config(GraphConfig)}
   */
  @Test
  @DisplayName("Test Builder config(GraphConfig) with 'config'; given 'true'")
  @Tag("MaintainedByDiffblue")
  void testBuilderConfigWithConfig_givenTrue() {
    // Arrange
    Builder builder = new Builder();

    GraphConfig config = new GraphConfig(null);
    config.setLibrary(null);
    config.setDescription(null);
    config.setOtelActive(true);
    config.setView(null);

    // Act
    Builder actualConfigResult = builder.config(config);

    // Assert
    assertSame(builder, actualConfigResult);
  }

  /**
   * Test Builder {@link Builder#config(GraphConfig)} with {@code config}.
   *
   * <ul>
   *   <li>Given {@link View} (default constructor) addConfig {@code filterFieldsByName} and {@code
   *       42}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#config(GraphConfig)}
   */
  @Test
  @DisplayName(
      "Test Builder config(GraphConfig) with 'config'; given View (default constructor) addConfig 'filterFieldsByName' and '42'")
  @Tag("MaintainedByDiffblue")
  void testBuilderConfigWithConfig_givenViewAddConfigFilterFieldsByNameAnd42() {
    // Arrange
    Builder builder = new Builder();

    View view = new View();
    view.addConfig("filterFieldsByName", "42");

    GraphConfig config = new GraphConfig(null);
    config.setLibrary(null);
    config.setDescription(null);
    config.setOtelActive(null);
    config.setView(view);

    // Act
    Builder actualConfigResult = builder.config(config);

    // Assert
    assertSame(builder, actualConfigResult);
  }

  /**
   * Test Builder {@link Builder#config(GraphConfig)} with {@code config}.
   *
   * <ul>
   *   <li>Given {@link View} (default constructor) AllEdges is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#config(GraphConfig)}
   */
  @Test
  @DisplayName(
      "Test Builder config(GraphConfig) with 'config'; given View (default constructor) AllEdges is 'true'")
  @Tag("MaintainedByDiffblue")
  void testBuilderConfigWithConfig_givenViewAllEdgesIsTrue() {
    // Arrange
    Builder builder = new Builder();

    View view = new View();
    view.setAllEdges(true);
    view.addConfig("filterFieldsByName", "42");

    GraphConfig config = new GraphConfig(null);
    config.setLibrary(null);
    config.setDescription(null);
    config.setOtelActive(null);
    config.setView(view);

    // Act
    Builder actualConfigResult = builder.config(config);

    // Assert
    assertSame(builder, actualConfigResult);
  }

  /**
   * Test Builder {@link Builder#config(GraphConfig)} with {@code config}.
   *
   * <ul>
   *   <li>Given {@link View} (default constructor) AllEntities is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#config(GraphConfig)}
   */
  @Test
  @DisplayName(
      "Test Builder config(GraphConfig) with 'config'; given View (default constructor) AllEntities is 'true'")
  @Tag("MaintainedByDiffblue")
  void testBuilderConfigWithConfig_givenViewAllEntitiesIsTrue() {
    // Arrange
    Builder builder = new Builder();

    View view = new View();
    view.setAllEntities(true);
    view.addConfig("filterFieldsByName", "42");

    GraphConfig config = new GraphConfig(null);
    config.setLibrary(null);
    config.setDescription(null);
    config.setOtelActive(null);
    config.setView(view);

    // Act
    Builder actualConfigResult = builder.config(config);

    // Assert
    assertSame(builder, actualConfigResult);
  }

  /**
   * Test Builder {@link Builder#config(GraphConfig)} with {@code config}.
   *
   * <ul>
   *   <li>Given {@link View} (default constructor).
   *   <li>When {@link GraphConfig#GraphConfig(String)} with graphId is {@code null} View is {@link
   *       View} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link Builder#config(GraphConfig)}
   */
  @Test
  @DisplayName(
      "Test Builder config(GraphConfig) with 'config'; given View (default constructor); when GraphConfig(String) with graphId is 'null' View is View (default constructor)")
  @Tag("MaintainedByDiffblue")
  void testBuilderConfigWithConfig_givenView_whenGraphConfigWithGraphIdIsNullViewIsView() {
    // Arrange
    Builder builder = new Builder();

    GraphConfig config = new GraphConfig(null);
    config.setLibrary(null);
    config.setDescription(null);
    config.setOtelActive(null);
    config.setView(new View());

    // Act
    Builder actualConfigResult = builder.config(config);

    // Assert
    assertSame(builder, actualConfigResult);
  }

  /**
   * Test Builder {@link Builder#config(GraphConfig)} with {@code config}.
   *
   * <ul>
   *   <li>When {@link GraphConfig#GraphConfig(String)} with graphId is {@code 42}.
   *   <li>Then return {@link Builder} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link Builder#config(GraphConfig)}
   */
  @Test
  @DisplayName(
      "Test Builder config(GraphConfig) with 'config'; when GraphConfig(String) with graphId is '42'; then return Builder (default constructor)")
  @Tag("MaintainedByDiffblue")
  void testBuilderConfigWithConfig_whenGraphConfigWithGraphIdIs42_thenReturnBuilder() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualConfigResult = builder.config(new GraphConfig("42"));

    // Assert
    assertSame(builder, actualConfigResult);
  }

  /**
   * Test Builder {@link Builder#config(GraphConfig)} with {@code config}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@link Builder} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link Builder#config(GraphConfig)}
   */
  @Test
  @DisplayName(
      "Test Builder config(GraphConfig) with 'config'; when 'null'; then return Builder (default constructor)")
  @Tag("MaintainedByDiffblue")
  void testBuilderConfigWithConfig_whenNull_thenReturnBuilder() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualConfigResult = builder.config((GraphConfig) null);

    // Assert
    assertSame(builder, actualConfigResult);
  }

  /**
   * Test Builder {@link Builder#config(Path)} with {@code path}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@link Builder} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link Builder#config(Path)}
   */
  @Test
  @DisplayName(
      "Test Builder config(Path) with 'path'; when 'null'; then return Builder (default constructor)")
  @Tag("MaintainedByDiffblue")
  void testBuilderConfigWithPath_whenNull_thenReturnBuilder() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualConfigResult = builder.config((Path) null);

    // Assert
    assertSame(builder, actualConfigResult);
  }

  /**
   * Test Builder {@link Builder#config(InputStream)} with {@code stream}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@link Builder} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link Builder#config(InputStream)}
   */
  @Test
  @DisplayName(
      "Test Builder config(InputStream) with 'stream'; when 'null'; then return Builder (default constructor)")
  @Tag("MaintainedByDiffblue")
  void testBuilderConfigWithStream_whenNull_thenReturnBuilder() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualConfigResult = builder.config((InputStream) null);

    // Assert
    assertSame(builder, actualConfigResult);
  }

  /**
   * Test Builder {@link Builder#config(URI)} with {@code uri}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@link Builder} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link Builder#config(URI)}
   */
  @Test
  @DisplayName(
      "Test Builder config(URI) with 'uri'; when 'null'; then return Builder (default constructor)")
  @Tag("MaintainedByDiffblue")
  void testBuilderConfigWithUri_whenNull_thenReturnBuilder() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualConfigResult = builder.config((URI) null);

    // Assert
    assertSame(builder, actualConfigResult);
  }

  /**
   * Test Builder {@link Builder#description(String)}.
   *
   * <p>Method under test: {@link Builder#description(String)}
   */
  @Test
  @DisplayName("Test Builder description(String)")
  @Tag("MaintainedByDiffblue")
  void testBuilderDescription() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualDescriptionResult =
        builder.description("The characteristics of someone or something");

    // Assert
    assertSame(builder, actualDescriptionResult);
  }

  /**
   * Test Builder {@link Builder#storeProperties(InputStream)} with {@code InputStream}.
   *
   * <p>Method under test: {@link Builder#storeProperties(InputStream)}
   */
  @Test
  @DisplayName("Test Builder storeProperties(InputStream) with 'InputStream'")
  @Tag("MaintainedByDiffblue")
  void testBuilderStorePropertiesWithInputStream() throws IOException {
    // Arrange
    Builder builder = new Builder();
    ByteArrayInputStream propertiesStream = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Builder actualStorePropertiesResult = builder.storeProperties(propertiesStream);

    // Assert
    int actualReadResult = propertiesStream.read(new byte[] {});
    assertEquals(-1, actualReadResult);
    assertSame(builder, actualStorePropertiesResult);
  }

  /**
   * Test Builder {@link Builder#storeProperties(InputStream)} with {@code InputStream}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#storeProperties(InputStream)}
   */
  @Test
  @DisplayName(
      "Test Builder storeProperties(InputStream) with 'InputStream'; when 'null'; then 'null'")
  @Tag("MaintainedByDiffblue")
  void testBuilderStorePropertiesWithInputStream_whenNull_thenNull() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualStorePropertiesResult = builder.storeProperties((InputStream) null);

    // Assert
    assertNull(null);
    assertSame(builder, actualStorePropertiesResult);
  }

  /**
   * Test Builder {@link Builder#storeProperties(Path)} with {@code Path}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@link Builder} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link Builder#storeProperties(Path)}
   */
  @Test
  @DisplayName(
      "Test Builder storeProperties(Path) with 'Path'; when 'null'; then return Builder (default constructor)")
  @Tag("MaintainedByDiffblue")
  void testBuilderStorePropertiesWithPath_whenNull_thenReturnBuilder() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualStorePropertiesResult = builder.storeProperties((Path) null);

    // Assert
    assertSame(builder, actualStorePropertiesResult);
  }

  /**
   * Test Builder {@link Builder#storeProperties(Properties)} with {@code Properties}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#storeProperties(Properties)}
   */
  @Test
  @DisplayName("Test Builder storeProperties(Properties) with 'Properties'; when 'null'")
  @Tag("MaintainedByDiffblue")
  void testBuilderStorePropertiesWithProperties_whenNull() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualStorePropertiesResult = builder.storeProperties((Properties) null);

    // Assert
    assertSame(builder, actualStorePropertiesResult);
  }

  /**
   * Test Builder {@link Builder#storeProperties(Properties)} with {@code Properties}.
   *
   * <ul>
   *   <li>When {@link Properties#Properties()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#storeProperties(Properties)}
   */
  @Test
  @DisplayName("Test Builder storeProperties(Properties) with 'Properties'; when Properties()")
  @Tag("MaintainedByDiffblue")
  void testBuilderStorePropertiesWithProperties_whenProperties() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualStorePropertiesResult = builder.storeProperties(new Properties());

    // Assert
    assertSame(builder, actualStorePropertiesResult);
  }

  /**
   * Test Builder {@link Builder#storeProperties(StoreProperties)} with {@code StoreProperties}.
   *
   * <ul>
   *   <li>Given {@link StoreProperties#REFLECTION_PACKAGES}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#storeProperties(StoreProperties)}
   */
  @Test
  @DisplayName(
      "Test Builder storeProperties(StoreProperties) with 'StoreProperties'; given REFLECTION_PACKAGES")
  @Tag("MaintainedByDiffblue")
  void testBuilderStorePropertiesWithStoreProperties_givenReflection_packages() {
    // Arrange
    Builder builder = new Builder();

    StoreProperties properties = new StoreProperties();
    properties.set(StoreProperties.REFLECTION_PACKAGES, "42");

    // Act
    Builder actualStorePropertiesResult = builder.storeProperties(properties);

    // Assert
    assertSame(builder, actualStorePropertiesResult);
  }

  /**
   * Test Builder {@link Builder#storeProperties(StoreProperties)} with {@code StoreProperties}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#storeProperties(StoreProperties)}
   */
  @Test
  @DisplayName("Test Builder storeProperties(StoreProperties) with 'StoreProperties'; when 'null'")
  @Tag("MaintainedByDiffblue")
  void testBuilderStorePropertiesWithStoreProperties_whenNull() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualStorePropertiesResult = builder.storeProperties((StoreProperties) null);

    // Assert
    assertSame(builder, actualStorePropertiesResult);
  }

  /**
   * Test Builder {@link Builder#storeProperties(StoreProperties)} with {@code StoreProperties}.
   *
   * <ul>
   *   <li>When {@link StoreProperties#StoreProperties()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#storeProperties(StoreProperties)}
   */
  @Test
  @DisplayName(
      "Test Builder storeProperties(StoreProperties) with 'StoreProperties'; when StoreProperties()")
  @Tag("MaintainedByDiffblue")
  void testBuilderStorePropertiesWithStoreProperties_whenStoreProperties() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualStorePropertiesResult = builder.storeProperties(new StoreProperties());

    // Assert
    assertSame(builder, actualStorePropertiesResult);
  }

  /**
   * Test Builder {@link Builder#storeProperties(String)} with {@code String}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@link Builder} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link Builder#storeProperties(String)}
   */
  @Test
  @DisplayName(
      "Test Builder storeProperties(String) with 'String'; when 'null'; then return Builder (default constructor)")
  @Tag("MaintainedByDiffblue")
  void testBuilderStorePropertiesWithString_whenNull_thenReturnBuilder() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualStorePropertiesResult = builder.storeProperties((String) null);

    // Assert
    assertSame(builder, actualStorePropertiesResult);
  }

  /**
   * Test Builder {@link Builder#storeProperties(URI)} with {@code URI}.
   *
   * <ul>
   *   <li>Then throw {@link SchemaException}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#storeProperties(URI)}
   */
  @Test
  @DisplayName("Test Builder storeProperties(URI) with 'URI'; then throw SchemaException")
  @Tag("MaintainedByDiffblue")
  void testBuilderStorePropertiesWithUri_thenThrowSchemaException() {
    // Arrange, Act and Assert
    assertThrows(
        SchemaException.class,
        () ->
            new Builder()
                .storeProperties(
                    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri()));
  }

  /**
   * Test Builder {@link Builder#storeProperties(URI)} with {@code URI}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@link Builder} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link Builder#storeProperties(URI)}
   */
  @Test
  @DisplayName(
      "Test Builder storeProperties(URI) with 'URI'; when 'null'; then return Builder (default constructor)")
  @Tag("MaintainedByDiffblue")
  void testBuilderStorePropertiesWithUri_whenNull_thenReturnBuilder() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualStorePropertiesResult = builder.storeProperties((URI) null);

    // Assert
    assertSame(builder, actualStorePropertiesResult);
  }

  /**
   * Test Builder {@link Builder#storeProperties(URI)} with {@code URI}.
   *
   * <ul>
   *   <li>When Property is {@code java.io.tmpdir} is empty string toUri.
   * </ul>
   *
   * <p>Method under test: {@link Builder#storeProperties(URI)}
   */
  @Test
  @DisplayName(
      "Test Builder storeProperties(URI) with 'URI'; when Property is 'java.io.tmpdir' is empty string toUri")
  @Tag("MaintainedByDiffblue")
  void testBuilderStorePropertiesWithUri_whenPropertyIsJavaIoTmpdirIsEmptyStringToUri() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualStorePropertiesResult =
        builder.storeProperties(Paths.get(System.getProperty("java.io.tmpdir"), "").toUri());

    // Assert
    assertSame(builder, actualStorePropertiesResult);
  }
}
