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

package uk.gov.gchq.gaffer.graph;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.MethodsUnderTest;
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
   * <ul>
   *   <li>Given {@link Builder} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addParentSchemaIds(List)}
   */
  @Test
  @DisplayName("Test Builder addParentSchemaIds(List) with 'List'; given Builder (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addParentSchemaIds(List)"})
  void testBuilderAddParentSchemaIdsWithList_givenBuilder() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertSame(builder, builder.addParentSchemaIds(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addParentSchemaIds(List)} with {@code List}.
   * <ul>
   *   <li>Given {@link Builder} (default constructor) addParentSchemaIds {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addParentSchemaIds(List)}
   */
  @Test
  @DisplayName("Test Builder addParentSchemaIds(List) with 'List'; given Builder (default constructor) addParentSchemaIds ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addParentSchemaIds(List)"})
  void testBuilderAddParentSchemaIdsWithList_givenBuilderAddParentSchemaIdsArrayList() {
    // Arrange
    Builder builder = new Builder();
    builder.addParentSchemaIds(new ArrayList<>());

    // Act and Assert
    assertSame(builder, builder.addParentSchemaIds(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addParentSchemaIds(String[])} with {@code String[]}.
   * <ul>
   *   <li>Given {@link Builder} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addParentSchemaIds(String[])}
   */
  @Test
  @DisplayName("Test Builder addParentSchemaIds(String[]) with 'String[]'; given Builder (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addParentSchemaIds(String[])"})
  void testBuilderAddParentSchemaIdsWithString_givenBuilder() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertSame(builder, builder.addParentSchemaIds("Parent Schema Ids"));
  }

  /**
   * Test Builder {@link Builder#addParentSchemaIds(String[])} with {@code String[]}.
   * <ul>
   *   <li>Given {@link Builder} (default constructor) addParentSchemaIds {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addParentSchemaIds(String[])}
   */
  @Test
  @DisplayName("Test Builder addParentSchemaIds(String[]) with 'String[]'; given Builder (default constructor) addParentSchemaIds ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addParentSchemaIds(String[])"})
  void testBuilderAddParentSchemaIdsWithString_givenBuilderAddParentSchemaIdsArrayList() {
    // Arrange
    Builder builder = new Builder();
    builder.addParentSchemaIds(new ArrayList<>());

    // Act and Assert
    assertSame(builder, builder.addParentSchemaIds("Parent Schema Ids"));
  }

  /**
   * Test Builder {@link Builder#addSchema(byte[])} with {@code schemaBytes}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addSchema(byte[])}
   */
  @Test
  @DisplayName("Test Builder addSchema(byte[]) with 'schemaBytes'; when 'AXAXAXAX' Bytes is 'UTF-8'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addSchema(byte[])"})
  void testBuilderAddSchemaWithSchemaBytes_whenAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertSame(builder, builder.addSchema("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test Builder {@link Builder#addSchema(byte[])} with {@code schemaBytes}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addSchema(byte[])}
   */
  @Test
  @DisplayName("Test Builder addSchema(byte[]) with 'schemaBytes'; when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addSchema(byte[])"})
  void testBuilderAddSchemaWithSchemaBytes_whenNull() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertSame(builder, builder.addSchema((byte[]) null));
  }

  /**
   * Test Builder {@link Builder#addSchema(Schema)} with {@code schemaModule}.
   * <ul>
   *   <li>Given array of {@link Schema} with {@link Schema#Schema()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addSchema(Schema)}
   */
  @Test
  @DisplayName("Test Builder addSchema(Schema) with 'schemaModule'; given array of Schema with Schema()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addSchema(Schema)"})
  void testBuilderAddSchemaWithSchemaModule_givenArrayOfSchemaWithSchema() {
    // Arrange
    Builder builder = new Builder();
    builder.addSchemas(new Schema());

    // Act and Assert
    assertSame(builder, builder.addSchema(new Schema()));
  }

  /**
   * Test Builder {@link Builder#addSchema(Schema)} with {@code schemaModule}.
   * <ul>
   *   <li>Given {@link Builder} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addSchema(Schema)}
   */
  @Test
  @DisplayName("Test Builder addSchema(Schema) with 'schemaModule'; given Builder (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addSchema(Schema)"})
  void testBuilderAddSchemaWithSchemaModule_givenBuilder() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertSame(builder, builder.addSchema(new Schema()));
  }

  /**
   * Test Builder {@link Builder#addSchema(Path)} with {@code schemaPath}.
   * <ul>
   *   <li>When Property is {@code java.io.tmpdir} is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addSchema(Path)}
   */
  @Test
  @DisplayName("Test Builder addSchema(Path) with 'schemaPath'; when Property is 'java.io.tmpdir' is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addSchema(Path)"})
  void testBuilderAddSchemaWithSchemaPath_whenPropertyIsJavaIoTmpdirIsEmptyString() {
    // Arrange, Act and Assert
    assertThrows(SchemaException.class,
        () -> (new Builder()).addSchema(Paths.get(System.getProperty("java.io.tmpdir"), "")));
  }

  /**
   * Test Builder {@link Builder#addSchema(Path)} with {@code schemaPath}.
   * <ul>
   *   <li>When Property is {@code java.io.tmpdir} is {@code test.txt}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addSchema(Path)}
   */
  @Test
  @DisplayName("Test Builder addSchema(Path) with 'schemaPath'; when Property is 'java.io.tmpdir' is 'test.txt'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addSchema(Path)"})
  void testBuilderAddSchemaWithSchemaPath_whenPropertyIsJavaIoTmpdirIsTestTxt() {
    // Arrange, Act and Assert
    assertThrows(SchemaException.class,
        () -> (new Builder()).addSchema(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt")));
  }

  /**
   * Test Builder {@link Builder#addSchema(InputStream)} with {@code schemaStream}.
   * <p>
   * Method under test: {@link Builder#addSchema(InputStream)}
   */
  @Test
  @DisplayName("Test Builder addSchema(InputStream) with 'schemaStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addSchema(InputStream)"})
  void testBuilderAddSchemaWithSchemaStream() throws IOException {
    // Arrange
    Builder builder = new Builder();
    ByteArrayInputStream schemaStream = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Builder actualAddSchemaResult = builder.addSchema(schemaStream);

    // Assert
    assertEquals(-1, schemaStream.read(new byte[]{}));
    assertSame(builder, actualAddSchemaResult);
  }

  /**
   * Test Builder {@link Builder#addSchema(InputStream)} with {@code schemaStream}.
   * <p>
   * Method under test: {@link Builder#addSchema(InputStream)}
   */
  @Test
  @DisplayName("Test Builder addSchema(InputStream) with 'schemaStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addSchema(InputStream)"})
  void testBuilderAddSchemaWithSchemaStream2() throws IOException {
    // Arrange
    Builder builder = new Builder();
    ByteArrayInputStream schemaStream = new ByteArrayInputStream(new byte[]{});

    // Act
    Builder actualAddSchemaResult = builder.addSchema(schemaStream);

    // Assert
    assertEquals(-1, schemaStream.read(new byte[]{}));
    assertSame(builder, actualAddSchemaResult);
  }

  /**
   * Test Builder {@link Builder#addSchema(InputStream)} with {@code schemaStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addSchema(InputStream)}
   */
  @Test
  @DisplayName("Test Builder addSchema(InputStream) with 'schemaStream'; when 'null'; then 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addSchema(InputStream)"})
  void testBuilderAddSchemaWithSchemaStream_whenNull_thenNull() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertNull(null);
    assertSame(builder, builder.addSchema((InputStream) null));
  }

  /**
   * Test Builder {@link Builder#addSchema(URI)} with {@code schemaURI}.
   * <ul>
   *   <li>Then throw {@link SchemaException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addSchema(URI)}
   */
  @Test
  @DisplayName("Test Builder addSchema(URI) with 'schemaURI'; then throw SchemaException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addSchema(URI)"})
  void testBuilderAddSchemaWithSchemaURI_thenThrowSchemaException() {
    // Arrange, Act and Assert
    assertThrows(SchemaException.class,
        () -> (new Builder()).addSchema(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri()));
  }

  /**
   * Test Builder {@link Builder#addSchema(URI)} with {@code schemaURI}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@link Builder} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addSchema(URI)}
   */
  @Test
  @DisplayName("Test Builder addSchema(URI) with 'schemaURI'; when 'null'; then return Builder (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addSchema(URI)"})
  void testBuilderAddSchemaWithSchemaURI_whenNull_thenReturnBuilder() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertSame(builder, builder.addSchema((URI) null));
  }

  /**
   * Test Builder {@link Builder#addSchema(URI)} with {@code schemaURI}.
   * <ul>
   *   <li>When Property is {@code java.io.tmpdir} is empty string toUri.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addSchema(URI)}
   */
  @Test
  @DisplayName("Test Builder addSchema(URI) with 'schemaURI'; when Property is 'java.io.tmpdir' is empty string toUri")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addSchema(URI)"})
  void testBuilderAddSchemaWithSchemaURI_whenPropertyIsJavaIoTmpdirIsEmptyStringToUri() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertSame(builder, builder.addSchema(Paths.get(System.getProperty("java.io.tmpdir"), "").toUri()));
  }

  /**
   * Test Builder {@link Builder#addSchemas(byte[][])} with {@code schemaBytesArray}.
   * <p>
   * Method under test: {@link Builder#addSchemas(byte[][])}
   */
  @Test
  @DisplayName("Test Builder addSchemas(byte[][]) with 'schemaBytesArray'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addSchemas(byte[][])"})
  void testBuilderAddSchemasWithSchemaBytesArray() throws UnsupportedEncodingException {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertSame(builder, builder.addSchemas("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test Builder {@link Builder#addSchemas(Schema[])} with {@code schemaModules}.
   * <ul>
   *   <li>Given array of {@link Schema} with {@link Schema#Schema()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addSchemas(Schema[])}
   */
  @Test
  @DisplayName("Test Builder addSchemas(Schema[]) with 'schemaModules'; given array of Schema with Schema()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addSchemas(Schema[])"})
  void testBuilderAddSchemasWithSchemaModules_givenArrayOfSchemaWithSchema() {
    // Arrange
    Builder builder = new Builder();
    builder.addSchemas(new Schema());

    // Act and Assert
    assertSame(builder, builder.addSchemas(new Schema()));
  }

  /**
   * Test Builder {@link Builder#addSchemas(Schema[])} with {@code schemaModules}.
   * <ul>
   *   <li>Given {@link Builder} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addSchemas(Schema[])}
   */
  @Test
  @DisplayName("Test Builder addSchemas(Schema[]) with 'schemaModules'; given Builder (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addSchemas(Schema[])"})
  void testBuilderAddSchemasWithSchemaModules_givenBuilder() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertSame(builder, builder.addSchemas(new Schema()));
  }

  /**
   * Test Builder {@link Builder#addSchemas(Path[])} with {@code schemaPaths}.
   * <p>
   * Method under test: {@link Builder#addSchemas(Path[])}
   */
  @Test
  @DisplayName("Test Builder addSchemas(Path[]) with 'schemaPaths'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addSchemas(Path[])"})
  void testBuilderAddSchemasWithSchemaPaths() {
    // Arrange
    Builder builder = new Builder();
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");

    // Act and Assert
    assertSame(builder, builder.addSchemas(new Path[]{}));
  }

  /**
   * Test Builder {@link Builder#addSchemas(Path[])} with {@code schemaPaths}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@link Builder} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addSchemas(Path[])}
   */
  @Test
  @DisplayName("Test Builder addSchemas(Path[]) with 'schemaPaths'; when 'null'; then return Builder (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addSchemas(Path[])"})
  void testBuilderAddSchemasWithSchemaPaths_whenNull_thenReturnBuilder() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertSame(builder, builder.addSchemas((Path[]) null));
  }

  /**
   * Test Builder {@link Builder#addSchemas(Path[])} with {@code schemaPaths}.
   * <ul>
   *   <li>When Property is {@code java.io.tmpdir} is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addSchemas(Path[])}
   */
  @Test
  @DisplayName("Test Builder addSchemas(Path[]) with 'schemaPaths'; when Property is 'java.io.tmpdir' is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addSchemas(Path[])"})
  void testBuilderAddSchemasWithSchemaPaths_whenPropertyIsJavaIoTmpdirIsEmptyString() {
    // Arrange, Act and Assert
    assertThrows(SchemaException.class,
        () -> (new Builder()).addSchemas(Paths.get(System.getProperty("java.io.tmpdir"), "")));
  }

  /**
   * Test Builder {@link Builder#addSchemas(Path[])} with {@code schemaPaths}.
   * <ul>
   *   <li>When Property is {@code java.io.tmpdir} is {@code test.txt}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addSchemas(Path[])}
   */
  @Test
  @DisplayName("Test Builder addSchemas(Path[]) with 'schemaPaths'; when Property is 'java.io.tmpdir' is 'test.txt'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addSchemas(Path[])"})
  void testBuilderAddSchemasWithSchemaPaths_whenPropertyIsJavaIoTmpdirIsTestTxt() {
    // Arrange, Act and Assert
    assertThrows(SchemaException.class,
        () -> (new Builder()).addSchemas(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt")));
  }

  /**
   * Test Builder {@link Builder#addSchemas(InputStream[])} with {@code schemaStreams}.
   * <p>
   * Method under test: {@link Builder#addSchemas(InputStream[])}
   */
  @Test
  @DisplayName("Test Builder addSchemas(InputStream[]) with 'schemaStreams'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addSchemas(InputStream[])"})
  void testBuilderAddSchemasWithSchemaStreams() throws IOException {
    // Arrange
    Builder builder = new Builder();
    InputStream[] schemaStreams = new InputStream[]{new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))};

    // Act
    Builder actualAddSchemasResult = builder.addSchemas(schemaStreams);

    // Assert
    assertEquals(-1, (schemaStreams[0]).read(new byte[]{}));
    assertEquals(1, schemaStreams.length);
    assertSame(builder, actualAddSchemasResult);
  }

  /**
   * Test Builder {@link Builder#addSchemas(InputStream[])} with {@code schemaStreams}.
   * <p>
   * Method under test: {@link Builder#addSchemas(InputStream[])}
   */
  @Test
  @DisplayName("Test Builder addSchemas(InputStream[]) with 'schemaStreams'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addSchemas(InputStream[])"})
  void testBuilderAddSchemasWithSchemaStreams2() throws IOException {
    // Arrange
    Builder builder = new Builder();
    InputStream[] schemaStreams = new InputStream[]{new ByteArrayInputStream(new byte[]{})};

    // Act
    Builder actualAddSchemasResult = builder.addSchemas(schemaStreams);

    // Assert
    assertEquals(-1, (schemaStreams[0]).read(new byte[]{}));
    assertEquals(1, schemaStreams.length);
    assertSame(builder, actualAddSchemasResult);
  }

  /**
   * Test Builder {@link Builder#addSchemas(URI[])} with {@code schemaURI}.
   * <ul>
   *   <li>Then throw {@link SchemaException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addSchemas(URI[])}
   */
  @Test
  @DisplayName("Test Builder addSchemas(URI[]) with 'schemaURI'; then throw SchemaException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addSchemas(URI[])"})
  void testBuilderAddSchemasWithSchemaURI_thenThrowSchemaException() {
    // Arrange, Act and Assert
    assertThrows(SchemaException.class,
        () -> (new Builder()).addSchemas(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri()));
  }

  /**
   * Test Builder {@link Builder#addSchemas(URI[])} with {@code schemaURI}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@link Builder} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addSchemas(URI[])}
   */
  @Test
  @DisplayName("Test Builder addSchemas(URI[]) with 'schemaURI'; when 'null'; then return Builder (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addSchemas(URI[])"})
  void testBuilderAddSchemasWithSchemaURI_whenNull_thenReturnBuilder() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertSame(builder, builder.addSchemas((URI[]) null));
  }

  /**
   * Test Builder {@link Builder#addSchemas(URI[])} with {@code schemaURI}.
   * <ul>
   *   <li>When Property is {@code java.io.tmpdir} is toUri.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addSchemas(URI[])}
   */
  @Test
  @DisplayName("Test Builder addSchemas(URI[]) with 'schemaURI'; when Property is 'java.io.tmpdir' is toUri")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addSchemas(URI[])"})
  void testBuilderAddSchemasWithSchemaURI_whenPropertyIsJavaIoTmpdirIsToUri() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertSame(builder, builder.addSchemas(Paths.get(System.getProperty("java.io.tmpdir")).toUri()));
  }

  /**
   * Test Builder {@link Builder#addStoreProperties(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link Builder#addStoreProperties(InputStream)}
   */
  @Test
  @DisplayName("Test Builder addStoreProperties(InputStream) with 'InputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addStoreProperties(InputStream)"})
  void testBuilderAddStorePropertiesWithInputStream() throws IOException {
    // Arrange
    Builder builder = new Builder();
    builder.storeProperties(new StoreProperties());
    ByteArrayInputStream updatePropertiesStream = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Builder actualAddStorePropertiesResult = builder.addStoreProperties(updatePropertiesStream);

    // Assert
    assertEquals(-1, updatePropertiesStream.read(new byte[]{}));
    assertSame(builder, actualAddStorePropertiesResult);
  }

  /**
   * Test Builder {@link Builder#addStoreProperties(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Given {@link Builder} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addStoreProperties(InputStream)}
   */
  @Test
  @DisplayName("Test Builder addStoreProperties(InputStream) with 'InputStream'; given Builder (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addStoreProperties(InputStream)"})
  void testBuilderAddStorePropertiesWithInputStream_givenBuilder() throws IOException {
    // Arrange
    Builder builder = new Builder();
    ByteArrayInputStream updatePropertiesStream = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Builder actualAddStorePropertiesResult = builder.addStoreProperties(updatePropertiesStream);

    // Assert
    assertEquals(-1, updatePropertiesStream.read(new byte[]{}));
    assertSame(builder, actualAddStorePropertiesResult);
  }

  /**
   * Test Builder {@link Builder#addStoreProperties(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addStoreProperties(InputStream)}
   */
  @Test
  @DisplayName("Test Builder addStoreProperties(InputStream) with 'InputStream'; then 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addStoreProperties(InputStream)"})
  void testBuilderAddStorePropertiesWithInputStream_thenNull() {
    // Arrange
    Builder builder = new Builder();
    builder.storeProperties((StoreProperties) null);

    // Act and Assert
    assertNull(null);
    assertSame(builder, builder.addStoreProperties((InputStream) null));
  }

  /**
   * Test Builder {@link Builder#addStoreProperties(Path)} with {@code Path}.
   * <ul>
   *   <li>Then return {@link Builder} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addStoreProperties(Path)}
   */
  @Test
  @DisplayName("Test Builder addStoreProperties(Path) with 'Path'; then return Builder (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addStoreProperties(Path)"})
  void testBuilderAddStorePropertiesWithPath_thenReturnBuilder() {
    // Arrange
    Builder builder = new Builder();
    builder.storeProperties((StoreProperties) null);

    // Act and Assert
    assertSame(builder, builder.addStoreProperties((Path) null));
  }

  /**
   * Test Builder {@link Builder#addStoreProperties(Properties)} with {@code Properties}.
   * <p>
   * Method under test: {@link Builder#addStoreProperties(Properties)}
   */
  @Test
  @DisplayName("Test Builder addStoreProperties(Properties) with 'Properties'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addStoreProperties(Properties)"})
  void testBuilderAddStorePropertiesWithProperties() {
    // Arrange
    Builder builder = new Builder();
    builder.storeProperties(new StoreProperties());

    // Act and Assert
    assertSame(builder, builder.addStoreProperties(new Properties()));
  }

  /**
   * Test Builder {@link Builder#addStoreProperties(Properties)} with {@code Properties}.
   * <ul>
   *   <li>Given {@link Builder} (default constructor) storeProperties {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addStoreProperties(Properties)}
   */
  @Test
  @DisplayName("Test Builder addStoreProperties(Properties) with 'Properties'; given Builder (default constructor) storeProperties 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addStoreProperties(Properties)"})
  void testBuilderAddStorePropertiesWithProperties_givenBuilderStorePropertiesNull() {
    // Arrange
    Builder builder = new Builder();
    builder.storeProperties((StoreProperties) null);

    // Act and Assert
    assertSame(builder, builder.addStoreProperties((Properties) null));
  }

  /**
   * Test Builder {@link Builder#addStoreProperties(Properties)} with {@code Properties}.
   * <ul>
   *   <li>Given {@link Builder} (default constructor).</li>
   *   <li>When {@link Properties#Properties()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addStoreProperties(Properties)}
   */
  @Test
  @DisplayName("Test Builder addStoreProperties(Properties) with 'Properties'; given Builder (default constructor); when Properties()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addStoreProperties(Properties)"})
  void testBuilderAddStorePropertiesWithProperties_givenBuilder_whenProperties() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertSame(builder, builder.addStoreProperties(new Properties()));
  }

  /**
   * Test Builder {@link Builder#addStoreProperties(StoreProperties)} with {@code StoreProperties}.
   * <p>
   * Method under test: {@link Builder#addStoreProperties(StoreProperties)}
   */
  @Test
  @DisplayName("Test Builder addStoreProperties(StoreProperties) with 'StoreProperties'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addStoreProperties(StoreProperties)"})
  void testBuilderAddStorePropertiesWithStoreProperties() {
    // Arrange
    Builder builder = new Builder();
    builder.storeProperties(new StoreProperties());

    // Act and Assert
    assertSame(builder, builder.addStoreProperties(new StoreProperties()));
  }

  /**
   * Test Builder {@link Builder#addStoreProperties(StoreProperties)} with {@code StoreProperties}.
   * <ul>
   *   <li>Given {@link Builder} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addStoreProperties(StoreProperties)}
   */
  @Test
  @DisplayName("Test Builder addStoreProperties(StoreProperties) with 'StoreProperties'; given Builder (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addStoreProperties(StoreProperties)"})
  void testBuilderAddStorePropertiesWithStoreProperties_givenBuilder() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertSame(builder, builder.addStoreProperties(new StoreProperties()));
  }

  /**
   * Test Builder {@link Builder#addStoreProperties(StoreProperties)} with {@code StoreProperties}.
   * <ul>
   *   <li>Given {@link Builder} (default constructor) storeProperties {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addStoreProperties(StoreProperties)}
   */
  @Test
  @DisplayName("Test Builder addStoreProperties(StoreProperties) with 'StoreProperties'; given Builder (default constructor) storeProperties 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addStoreProperties(StoreProperties)"})
  void testBuilderAddStorePropertiesWithStoreProperties_givenBuilderStorePropertiesNull() {
    // Arrange
    Builder builder = new Builder();
    builder.storeProperties((StoreProperties) null);

    // Act and Assert
    assertSame(builder, builder.addStoreProperties((StoreProperties) null));
  }

  /**
   * Test Builder {@link Builder#addStoreProperties(String)} with {@code String}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@link Builder} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addStoreProperties(String)}
   */
  @Test
  @DisplayName("Test Builder addStoreProperties(String) with 'String'; when 'null'; then return Builder (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addStoreProperties(String)"})
  void testBuilderAddStorePropertiesWithString_whenNull_thenReturnBuilder() {
    // Arrange
    Builder builder = new Builder();
    builder.storeProperties((StoreProperties) null);

    // Act and Assert
    assertSame(builder, builder.addStoreProperties((String) null));
  }

  /**
   * Test Builder {@link Builder#addStoreProperties(URI)} with {@code URI}.
   * <ul>
   *   <li>Given {@link Builder} (default constructor).</li>
   *   <li>Then throw {@link SchemaException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addStoreProperties(URI)}
   */
  @Test
  @DisplayName("Test Builder addStoreProperties(URI) with 'URI'; given Builder (default constructor); then throw SchemaException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addStoreProperties(URI)"})
  void testBuilderAddStorePropertiesWithUri_givenBuilder_thenThrowSchemaException() {
    // Arrange, Act and Assert
    assertThrows(SchemaException.class,
        () -> (new Builder()).addStoreProperties(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri()));
  }

  /**
   * Test Builder {@link Builder#addStoreProperties(URI)} with {@code URI}.
   * <ul>
   *   <li>Then return {@link Builder} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addStoreProperties(URI)}
   */
  @Test
  @DisplayName("Test Builder addStoreProperties(URI) with 'URI'; then return Builder (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addStoreProperties(URI)"})
  void testBuilderAddStorePropertiesWithUri_thenReturnBuilder() {
    // Arrange
    Builder builder = new Builder();
    builder.storeProperties((StoreProperties) null);

    // Act and Assert
    assertSame(builder, builder.addStoreProperties((URI) null));
  }

  /**
   * Test Builder {@link Builder#config(byte[])} with {@code bytes}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@link Builder} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#config(byte[])}
   */
  @Test
  @DisplayName("Test Builder config(byte[]) with 'bytes'; when 'null'; then return Builder (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.config(byte[])"})
  void testBuilderConfigWithBytes_whenNull_thenReturnBuilder() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertSame(builder, builder.config((byte[]) null));
  }

  /**
   * Test Builder {@link Builder#config(GraphConfig)} with {@code config}.
   * <p>
   * Method under test: {@link Builder#config(GraphConfig)}
   */
  @Test
  @DisplayName("Test Builder config(GraphConfig) with 'config'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.config(GraphConfig)"})
  void testBuilderConfigWithConfig() {
    // Arrange
    Builder builder = new Builder();
    GraphConfig config = (new GraphConfig.Builder()).description("The characteristics of someone or something").build();

    // Act and Assert
    assertSame(builder, builder.config(config));
  }

  /**
   * Test Builder {@link Builder#config(GraphConfig)} with {@code config}.
   * <ul>
   *   <li>Given {@link FileGraphLibrary#FileGraphLibrary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#config(GraphConfig)}
   */
  @Test
  @DisplayName("Test Builder config(GraphConfig) with 'config'; given FileGraphLibrary()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.config(GraphConfig)"})
  void testBuilderConfigWithConfig_givenFileGraphLibrary() {
    // Arrange
    Builder builder = new Builder();

    GraphConfig config = new GraphConfig("42");
    config.setView(null);
    config.setGraphId(null);
    config.setLibrary(new FileGraphLibrary());
    config.setDescription(null);
    config.setOtelActive(null);

    // Act and Assert
    assertSame(builder, builder.config(config));
  }

  /**
   * Test Builder {@link Builder#config(GraphConfig)} with {@code config}.
   * <ul>
   *   <li>Given {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#config(GraphConfig)}
   */
  @Test
  @DisplayName("Test Builder config(GraphConfig) with 'config'; given 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.config(GraphConfig)"})
  void testBuilderConfigWithConfig_givenTrue() {
    // Arrange
    Builder builder = new Builder();

    GraphConfig config = new GraphConfig("42");
    config.setView(null);
    config.setGraphId(null);
    config.setLibrary(null);
    config.setDescription(null);
    config.setOtelActive(true);

    // Act and Assert
    assertSame(builder, builder.config(config));
  }

  /**
   * Test Builder {@link Builder#config(GraphConfig)} with {@code config}.
   * <ul>
   *   <li>Given {@link View} (default constructor).</li>
   *   <li>When {@link GraphConfig#GraphConfig(String)} with graphId is {@code 42} View is {@link View} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#config(GraphConfig)}
   */
  @Test
  @DisplayName("Test Builder config(GraphConfig) with 'config'; given View (default constructor); when GraphConfig(String) with graphId is '42' View is View (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.config(GraphConfig)"})
  void testBuilderConfigWithConfig_givenView_whenGraphConfigWithGraphIdIs42ViewIsView() {
    // Arrange
    Builder builder = new Builder();

    GraphConfig config = new GraphConfig("42");
    config.setView(new View());
    config.setGraphId(null);
    config.setLibrary(null);
    config.setDescription(null);
    config.setOtelActive(null);

    // Act and Assert
    assertSame(builder, builder.config(config));
  }

  /**
   * Test Builder {@link Builder#config(GraphConfig)} with {@code config}.
   * <ul>
   *   <li>When {@link GraphConfig#GraphConfig(String)} with graphId is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#config(GraphConfig)}
   */
  @Test
  @DisplayName("Test Builder config(GraphConfig) with 'config'; when GraphConfig(String) with graphId is '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.config(GraphConfig)"})
  void testBuilderConfigWithConfig_whenGraphConfigWithGraphIdIs42() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertSame(builder, builder.config(new GraphConfig("42")));
  }

  /**
   * Test Builder {@link Builder#config(GraphConfig)} with {@code config}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#config(GraphConfig)}
   */
  @Test
  @DisplayName("Test Builder config(GraphConfig) with 'config'; when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.config(GraphConfig)"})
  void testBuilderConfigWithConfig_whenNull() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertSame(builder, builder.config((GraphConfig) null));
  }

  /**
   * Test Builder {@link Builder#config(Path)} with {@code path}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@link Builder} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#config(Path)}
   */
  @Test
  @DisplayName("Test Builder config(Path) with 'path'; when 'null'; then return Builder (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.config(Path)"})
  void testBuilderConfigWithPath_whenNull_thenReturnBuilder() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertSame(builder, builder.config((Path) null));
  }

  /**
   * Test Builder {@link Builder#config(InputStream)} with {@code stream}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@link Builder} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#config(InputStream)}
   */
  @Test
  @DisplayName("Test Builder config(InputStream) with 'stream'; when 'null'; then return Builder (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.config(InputStream)"})
  void testBuilderConfigWithStream_whenNull_thenReturnBuilder() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertSame(builder, builder.config((InputStream) null));
  }

  /**
   * Test Builder {@link Builder#config(URI)} with {@code uri}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@link Builder} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#config(URI)}
   */
  @Test
  @DisplayName("Test Builder config(URI) with 'uri'; when 'null'; then return Builder (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.config(URI)"})
  void testBuilderConfigWithUri_whenNull_thenReturnBuilder() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertSame(builder, builder.config((URI) null));
  }

  /**
   * Test Builder {@link Builder#description(String)}.
   * <p>
   * Method under test: {@link Builder#description(String)}
   */
  @Test
  @DisplayName("Test Builder description(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.description(String)"})
  void testBuilderDescription() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertSame(builder, builder.description("The characteristics of someone or something"));
  }

  /**
   * Test Builder {@link Builder#storeProperties(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link Builder#storeProperties(InputStream)}
   */
  @Test
  @DisplayName("Test Builder storeProperties(InputStream) with 'InputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.storeProperties(InputStream)"})
  void testBuilderStorePropertiesWithInputStream() throws IOException {
    // Arrange
    Builder builder = new Builder();
    ByteArrayInputStream propertiesStream = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Builder actualStorePropertiesResult = builder.storeProperties(propertiesStream);

    // Assert
    assertEquals(-1, propertiesStream.read(new byte[]{}));
    assertSame(builder, actualStorePropertiesResult);
  }

  /**
   * Test Builder {@link Builder#storeProperties(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#storeProperties(InputStream)}
   */
  @Test
  @DisplayName("Test Builder storeProperties(InputStream) with 'InputStream'; when 'null'; then 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.storeProperties(InputStream)"})
  void testBuilderStorePropertiesWithInputStream_whenNull_thenNull() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertNull(null);
    assertSame(builder, builder.storeProperties((InputStream) null));
  }

  /**
   * Test Builder {@link Builder#storeProperties(Path)} with {@code Path}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@link Builder} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#storeProperties(Path)}
   */
  @Test
  @DisplayName("Test Builder storeProperties(Path) with 'Path'; when 'null'; then return Builder (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.storeProperties(Path)"})
  void testBuilderStorePropertiesWithPath_whenNull_thenReturnBuilder() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertSame(builder, builder.storeProperties((Path) null));
  }

  /**
   * Test Builder {@link Builder#storeProperties(Properties)} with {@code Properties}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#storeProperties(Properties)}
   */
  @Test
  @DisplayName("Test Builder storeProperties(Properties) with 'Properties'; when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.storeProperties(Properties)"})
  void testBuilderStorePropertiesWithProperties_whenNull() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertSame(builder, builder.storeProperties((Properties) null));
  }

  /**
   * Test Builder {@link Builder#storeProperties(Properties)} with {@code Properties}.
   * <ul>
   *   <li>When {@link Properties#Properties()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#storeProperties(Properties)}
   */
  @Test
  @DisplayName("Test Builder storeProperties(Properties) with 'Properties'; when Properties()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.storeProperties(Properties)"})
  void testBuilderStorePropertiesWithProperties_whenProperties() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertSame(builder, builder.storeProperties(new Properties()));
  }

  /**
   * Test Builder {@link Builder#storeProperties(StoreProperties)} with {@code StoreProperties}.
   * <ul>
   *   <li>Given {@link Builder} (default constructor) addToLibrary {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#storeProperties(StoreProperties)}
   */
  @Test
  @DisplayName("Test Builder storeProperties(StoreProperties) with 'StoreProperties'; given Builder (default constructor) addToLibrary 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.storeProperties(StoreProperties)"})
  void testBuilderStorePropertiesWithStoreProperties_givenBuilderAddToLibraryFalse() {
    // Arrange
    Builder builder = new Builder();
    builder.addToLibrary(false);

    StoreProperties properties = new StoreProperties();
    properties.set(StoreProperties.REFLECTION_PACKAGES, "42");

    // Act and Assert
    assertSame(builder, builder.storeProperties(properties));
  }

  /**
   * Test Builder {@link Builder#storeProperties(StoreProperties)} with {@code StoreProperties}.
   * <ul>
   *   <li>Given {@link Builder} (default constructor).</li>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#storeProperties(StoreProperties)}
   */
  @Test
  @DisplayName("Test Builder storeProperties(StoreProperties) with 'StoreProperties'; given Builder (default constructor); when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.storeProperties(StoreProperties)"})
  void testBuilderStorePropertiesWithStoreProperties_givenBuilder_whenNull() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertSame(builder, builder.storeProperties((StoreProperties) null));
  }

  /**
   * Test Builder {@link Builder#storeProperties(StoreProperties)} with {@code StoreProperties}.
   * <ul>
   *   <li>Given {@link Builder} (default constructor).</li>
   *   <li>When {@link StoreProperties#StoreProperties()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#storeProperties(StoreProperties)}
   */
  @Test
  @DisplayName("Test Builder storeProperties(StoreProperties) with 'StoreProperties'; given Builder (default constructor); when StoreProperties()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.storeProperties(StoreProperties)"})
  void testBuilderStorePropertiesWithStoreProperties_givenBuilder_whenStoreProperties() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertSame(builder, builder.storeProperties(new StoreProperties()));
  }

  /**
   * Test Builder {@link Builder#storeProperties(StoreProperties)} with {@code StoreProperties}.
   * <ul>
   *   <li>Given {@link StoreProperties#REFLECTION_PACKAGES}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#storeProperties(StoreProperties)}
   */
  @Test
  @DisplayName("Test Builder storeProperties(StoreProperties) with 'StoreProperties'; given REFLECTION_PACKAGES")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.storeProperties(StoreProperties)"})
  void testBuilderStorePropertiesWithStoreProperties_givenReflection_packages() {
    // Arrange
    Builder builder = new Builder();

    StoreProperties properties = new StoreProperties();
    properties.set(StoreProperties.REFLECTION_PACKAGES, "42");

    // Act and Assert
    assertSame(builder, builder.storeProperties(properties));
  }

  /**
   * Test Builder {@link Builder#storeProperties(String)} with {@code String}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@link Builder} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#storeProperties(String)}
   */
  @Test
  @DisplayName("Test Builder storeProperties(String) with 'String'; when 'null'; then return Builder (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.storeProperties(String)"})
  void testBuilderStorePropertiesWithString_whenNull_thenReturnBuilder() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertSame(builder, builder.storeProperties((String) null));
  }

  /**
   * Test Builder {@link Builder#storeProperties(URI)} with {@code URI}.
   * <ul>
   *   <li>Then throw {@link SchemaException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#storeProperties(URI)}
   */
  @Test
  @DisplayName("Test Builder storeProperties(URI) with 'URI'; then throw SchemaException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.storeProperties(URI)"})
  void testBuilderStorePropertiesWithUri_thenThrowSchemaException() {
    // Arrange, Act and Assert
    assertThrows(SchemaException.class,
        () -> (new Builder()).storeProperties(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri()));
  }

  /**
   * Test Builder {@link Builder#storeProperties(URI)} with {@code URI}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@link Builder} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#storeProperties(URI)}
   */
  @Test
  @DisplayName("Test Builder storeProperties(URI) with 'URI'; when 'null'; then return Builder (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.storeProperties(URI)"})
  void testBuilderStorePropertiesWithUri_whenNull_thenReturnBuilder() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertSame(builder, builder.storeProperties((URI) null));
  }

  /**
   * Test Builder {@link Builder#storeProperties(URI)} with {@code URI}.
   * <ul>
   *   <li>When Property is {@code java.io.tmpdir} is empty string toUri.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#storeProperties(URI)}
   */
  @Test
  @DisplayName("Test Builder storeProperties(URI) with 'URI'; when Property is 'java.io.tmpdir' is empty string toUri")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.storeProperties(URI)"})
  void testBuilderStorePropertiesWithUri_whenPropertyIsJavaIoTmpdirIsEmptyStringToUri() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertSame(builder, builder.storeProperties(Paths.get(System.getProperty("java.io.tmpdir"), "").toUri()));
  }
}
