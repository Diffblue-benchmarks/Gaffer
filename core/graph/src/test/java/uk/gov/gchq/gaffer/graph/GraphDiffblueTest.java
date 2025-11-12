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
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.function.BiFunction;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.elementdefinition.exception.SchemaException;
import uk.gov.gchq.gaffer.data.elementdefinition.view.View;
import uk.gov.gchq.gaffer.store.StoreProperties;
import uk.gov.gchq.gaffer.store.schema.Schema;

class GraphDiffblueTest {
  /**
   * Method under test: {@link Graph.Builder#addParentSchemaIds(List)}
   */
  @Test
  void testBuilderAddParentSchemaIds() {
    // Arrange
    Graph.Builder builder = new Graph.Builder();

    // Act and Assert
    assertSame(builder, builder.addParentSchemaIds(new ArrayList<>()));
  }

  /**
   * Method under test: {@link Graph.Builder#addParentSchemaIds(List)}
   */
  @Test
  void testBuilderAddParentSchemaIds2() {
    // Arrange
    Graph.Builder builder = new Graph.Builder();
    builder.addParentSchemaIds(new ArrayList<>());

    // Act and Assert
    assertSame(builder, builder.addParentSchemaIds(new ArrayList<>()));
  }

  /**
   * Method under test: {@link Graph.Builder#addParentSchemaIds(List)}
   */
  @Test
  void testBuilderAddParentSchemaIds3() {
    // Arrange
    Graph.Builder builder = new Graph.Builder();

    ArrayList<String> parentSchemaIds = new ArrayList<>();
    parentSchemaIds.add("foo");

    // Act and Assert
    assertSame(builder, builder.addParentSchemaIds(parentSchemaIds));
  }

  /**
   * Method under test: {@link Graph.Builder#addParentSchemaIds(List)}
   */
  @Test
  void testBuilderAddParentSchemaIds4() {
    // Arrange
    Graph.Builder builder = new Graph.Builder();

    ArrayList<String> parentSchemaIds = new ArrayList<>();
    parentSchemaIds.add("42");
    parentSchemaIds.add("foo");

    // Act and Assert
    assertSame(builder, builder.addParentSchemaIds(parentSchemaIds));
  }

  /**
   * Method under test: {@link Graph.Builder#addParentSchemaIds(String[])}
   */
  @Test
  void testBuilderAddParentSchemaIds5() {
    // Arrange
    Graph.Builder builder = new Graph.Builder();

    // Act and Assert
    assertSame(builder, builder.addParentSchemaIds("Parent Schema Ids"));
  }

  /**
   * Method under test: {@link Graph.Builder#addParentSchemaIds(String[])}
   */
  @Test
  void testBuilderAddParentSchemaIds6() {
    // Arrange
    Graph.Builder builder = new Graph.Builder();
    builder.addParentSchemaIds(new ArrayList<>());

    // Act and Assert
    assertSame(builder, builder.addParentSchemaIds("Parent Schema Ids"));
  }

  /**
   * Method under test: {@link Graph.Builder#addSchema(InputStream)}
   */
  @Test
  void testBuilderAddSchema() {
    // Arrange
    Graph.Builder builder = new Graph.Builder();

    // Act and Assert
    assertSame(builder, builder.addSchema((InputStream) null));
  }

  /**
   * Method under test: {@link Graph.Builder#addSchema(Path)}
   */
  @Test
  void testBuilderAddSchema2() {
    // Arrange, Act and Assert
    assertThrows(SchemaException.class,
        () -> (new Graph.Builder()).addSchema(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt")));
  }

  /**
   * Method under test: {@link Graph.Builder#addSchema(Path)}
   */
  @Test
  void testBuilderAddSchema3() {
    // Arrange, Act and Assert
    assertThrows(SchemaException.class,
        () -> (new Graph.Builder()).addSchema(Paths.get(System.getProperty("java.io.tmpdir"), "")));
  }

  /**
   * Method under test: {@link Graph.Builder#addSchema(Schema)}
   */
  @Test
  void testBuilderAddSchema4() {
    // Arrange
    Graph.Builder builder = new Graph.Builder();

    // Act and Assert
    assertSame(builder, builder.addSchema(new Schema()));
  }

  /**
   * Method under test: {@link Graph.Builder#addSchema(byte[])}
   */
  @Test
  void testBuilderAddSchema5() throws UnsupportedEncodingException {
    // Arrange
    Graph.Builder builder = new Graph.Builder();

    // Act and Assert
    assertSame(builder, builder.addSchema("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: {@link Graph.Builder#addSchema(byte[])}
   */
  @Test
  void testBuilderAddSchema6() {
    // Arrange
    Graph.Builder builder = new Graph.Builder();

    // Act and Assert
    assertSame(builder, builder.addSchema((byte[]) null));
  }

  /**
   * Method under test: {@link Graph.Builder#addSchemas(Path[])}
   */
  @Test
  void testBuilderAddSchemas() {
    // Arrange, Act and Assert
    assertThrows(SchemaException.class,
        () -> (new Graph.Builder()).addSchemas(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt")));
    assertThrows(SchemaException.class,
        () -> (new Graph.Builder()).addSchemas(Paths.get(System.getProperty("java.io.tmpdir"), "")));
  }

  /**
   * Method under test: {@link Graph.Builder#addSchemas(Path[])}
   */
  @Test
  void testBuilderAddSchemas2() {
    // Arrange
    Graph.Builder builder = new Graph.Builder();

    // Act and Assert
    assertSame(builder, builder.addSchemas((Path[]) null));
  }

  /**
   * Method under test: {@link Graph.Builder#addSchemas(Schema[])}
   */
  @Test
  void testBuilderAddSchemas3() {
    // Arrange
    Graph.Builder builder = new Graph.Builder();

    // Act and Assert
    assertSame(builder, builder.addSchemas(new Schema()));
  }

  /**
   * Method under test: {@link Graph.Builder#addSchemas(byte[][])}
   */
  @Test
  void testBuilderAddSchemas4() throws UnsupportedEncodingException {
    // Arrange
    Graph.Builder builder = new Graph.Builder();

    // Act and Assert
    assertSame(builder, builder.addSchemas("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: {@link Graph.Builder#addStoreProperties(InputStream)}
   */
  @Test
  void testBuilderAddStoreProperties() throws IOException {
    // Arrange
    Graph.Builder builder = new Graph.Builder();
    ByteArrayInputStream updatePropertiesStream = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Graph.Builder actualAddStorePropertiesResult = builder.addStoreProperties(updatePropertiesStream);

    // Assert
    assertEquals(-1, updatePropertiesStream.read(new byte[]{}));
    assertSame(builder, actualAddStorePropertiesResult);
  }

  /**
   * Method under test: {@link Graph.Builder#addStoreProperties(InputStream)}
   */
  @Test
  void testBuilderAddStoreProperties2() {
    // Arrange
    Graph.Builder builder = new Graph.Builder();
    builder.storeProperties((StoreProperties) null);

    // Act and Assert
    assertSame(builder, builder.addStoreProperties((InputStream) null));
  }

  /**
   * Method under test: {@link Graph.Builder#addStoreProperties(InputStream)}
   */
  @Test
  void testBuilderAddStoreProperties3() throws IOException {
    // Arrange
    Graph.Builder builder = new Graph.Builder();
    builder.storeProperties(new StoreProperties());
    ByteArrayInputStream updatePropertiesStream = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Graph.Builder actualAddStorePropertiesResult = builder.addStoreProperties(updatePropertiesStream);

    // Assert
    assertEquals(-1, updatePropertiesStream.read(new byte[]{}));
    assertSame(builder, actualAddStorePropertiesResult);
  }

  /**
   * Method under test: {@link Graph.Builder#addStoreProperties(Path)}
   */
  @Test
  void testBuilderAddStoreProperties4() {
    // Arrange
    Graph.Builder builder = new Graph.Builder();
    builder.storeProperties((StoreProperties) null);

    // Act and Assert
    assertSame(builder, builder.addStoreProperties((Path) null));
  }

  /**
   * Method under test: {@link Graph.Builder#addStoreProperties(Properties)}
   */
  @Test
  void testBuilderAddStoreProperties5() {
    // Arrange
    Graph.Builder builder = new Graph.Builder();

    // Act and Assert
    assertSame(builder, builder.addStoreProperties(new Properties()));
  }

  /**
   * Method under test: {@link Graph.Builder#addStoreProperties(Properties)}
   */
  @Test
  void testBuilderAddStoreProperties6() {
    // Arrange
    Graph.Builder builder = new Graph.Builder();
    builder.storeProperties((StoreProperties) null);

    // Act and Assert
    assertSame(builder, builder.addStoreProperties((Properties) null));
  }

  /**
   * Method under test: {@link Graph.Builder#addStoreProperties(Properties)}
   */
  @Test
  void testBuilderAddStoreProperties7() {
    // Arrange
    Graph.Builder builder = new Graph.Builder();
    builder.storeProperties(new StoreProperties());

    // Act and Assert
    assertSame(builder, builder.addStoreProperties(new Properties()));
  }

  /**
   * Method under test: {@link Graph.Builder#addStoreProperties(StoreProperties)}
   */
  @Test
  void testBuilderAddStoreProperties8() {
    // Arrange
    Graph.Builder builder = new Graph.Builder();

    // Act and Assert
    assertSame(builder, builder.addStoreProperties(new StoreProperties()));
  }

  /**
   * Method under test: {@link Graph.Builder#addStoreProperties(StoreProperties)}
   */
  @Test
  void testBuilderAddStoreProperties9() {
    // Arrange
    Graph.Builder builder = new Graph.Builder();
    builder.storeProperties((StoreProperties) null);

    // Act and Assert
    assertSame(builder, builder.addStoreProperties((StoreProperties) null));
  }

  /**
   * Method under test: {@link Graph.Builder#addStoreProperties(StoreProperties)}
   */
  @Test
  void testBuilderAddStoreProperties10() {
    // Arrange
    Graph.Builder builder = new Graph.Builder();
    builder.storeProperties(new StoreProperties());

    // Act and Assert
    assertSame(builder, builder.addStoreProperties(new StoreProperties()));
  }

  /**
   * Method under test: {@link Graph.Builder#addStoreProperties(StoreProperties)}
   */
  @Test
  void testBuilderAddStoreProperties11() {
    // Arrange
    Graph.Builder builder = new Graph.Builder();

    StoreProperties updateProperties = new StoreProperties();
    updateProperties.set(StoreProperties.REFLECTION_PACKAGES, "42");

    // Act and Assert
    assertSame(builder, builder.addStoreProperties(updateProperties));
  }

  /**
   * Method under test: {@link Graph.Builder#addStoreProperties(StoreProperties)}
   */
  @Test
  void testBuilderAddStoreProperties12() {
    // Arrange
    Graph.Builder builder = new Graph.Builder();
    builder.addToLibrary(false);

    StoreProperties updateProperties = new StoreProperties();
    updateProperties.set(StoreProperties.REFLECTION_PACKAGES, "42");

    // Act and Assert
    assertSame(builder, builder.addStoreProperties(updateProperties));
  }

  /**
   * Method under test: {@link Graph.Builder#config(InputStream)}
   */
  @Test
  void testBuilderConfig() {
    // Arrange
    Graph.Builder builder = new Graph.Builder();

    // Act and Assert
    assertSame(builder, builder.config((InputStream) null));
  }

  /**
   * Method under test: {@link Graph.Builder#config(Path)}
   */
  @Test
  void testBuilderConfig2() {
    // Arrange
    Graph.Builder builder = new Graph.Builder();

    // Act and Assert
    assertSame(builder, builder.config((Path) null));
  }

  /**
   * Method under test: {@link Graph.Builder#config(GraphConfig)}
   */
  @Test
  void testBuilderConfig3() {
    // Arrange
    Graph.Builder builder = new Graph.Builder();

    // Act and Assert
    assertSame(builder, builder.config(new GraphConfig("42")));
  }

  /**
   * Method under test: {@link Graph.Builder#config(GraphConfig)}
   */
  @Test
  void testBuilderConfig4() {
    // Arrange
    Graph.Builder builder = new Graph.Builder();

    GraphConfig config = new GraphConfig("42");
    config.setView(null);
    config.setGraphId(null);
    config.setLibrary(null);
    config.setDescription(null);
    config.setOtelActive(null);

    // Act and Assert
    assertSame(builder, builder.config(config));
  }

  /**
   * Method under test: {@link Graph.Builder#config(GraphConfig)}
   */
  @Test
  void testBuilderConfig5() {
    // Arrange
    Graph.Builder builder = new Graph.Builder();

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
   * Method under test: {@link Graph.Builder#config(GraphConfig)}
   */
  @Test
  void testBuilderConfig6() {
    // Arrange
    Graph.Builder builder = new Graph.Builder();

    GraphConfig config = new GraphConfig("42");
    config.setView(null);
    config.setGraphId(null);
    config.setLibrary(null);
    config.setDescription("Config");
    config.setOtelActive(null);

    // Act and Assert
    assertSame(builder, builder.config(config));
  }

  /**
   * Method under test: {@link Graph.Builder#config(GraphConfig)}
   */
  @Test
  void testBuilderConfig7() {
    // Arrange
    Graph.Builder builder = new Graph.Builder();

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
   * Method under test: {@link Graph.Builder#config(GraphConfig)}
   */
  @Test
  void testBuilderConfig8() {
    // Arrange
    Graph.Builder builder = new Graph.Builder();

    // Act and Assert
    assertSame(builder, builder.config((GraphConfig) null));
  }

  /**
   * Method under test: {@link Graph.Builder#config(byte[])}
   */
  @Test
  void testBuilderConfig9() {
    // Arrange
    Graph.Builder builder = new Graph.Builder();

    // Act and Assert
    assertSame(builder, builder.config((byte[]) null));
  }

  /**
   * Method under test: {@link Graph.Builder#description(String)}
   */
  @Test
  void testBuilderDescription() {
    // Arrange
    Graph.Builder builder = new Graph.Builder();

    // Act and Assert
    assertSame(builder, builder.description("The characteristics of someone or something"));
  }

  /**
   * Method under test: {@link Graph.Builder#storeProperties(InputStream)}
   */
  @Test
  void testBuilderStoreProperties() throws IOException {
    // Arrange
    Graph.Builder builder = new Graph.Builder();
    ByteArrayInputStream propertiesStream = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Graph.Builder actualStorePropertiesResult = builder.storeProperties(propertiesStream);

    // Assert
    assertEquals(-1, propertiesStream.read(new byte[]{}));
    assertSame(builder, actualStorePropertiesResult);
  }

  /**
   * Method under test: {@link Graph.Builder#storeProperties(InputStream)}
   */
  @Test
  void testBuilderStoreProperties2() {
    // Arrange
    Graph.Builder builder = new Graph.Builder();

    // Act and Assert
    assertSame(builder, builder.storeProperties((InputStream) null));
  }

  /**
   * Method under test: {@link Graph.Builder#storeProperties(Path)}
   */
  @Test
  void testBuilderStoreProperties3() {
    // Arrange
    Graph.Builder builder = new Graph.Builder();

    // Act and Assert
    assertSame(builder, builder.storeProperties((Path) null));
  }

  /**
   * Method under test: {@link Graph.Builder#storeProperties(Properties)}
   */
  @Test
  void testBuilderStoreProperties4() {
    // Arrange
    Graph.Builder builder = new Graph.Builder();

    // Act and Assert
    assertSame(builder, builder.storeProperties(new Properties()));
  }

  /**
   * Method under test: {@link Graph.Builder#storeProperties(Properties)}
   */
  @Test
  void testBuilderStoreProperties5() {
    // Arrange
    Graph.Builder builder = new Graph.Builder();

    // Act and Assert
    assertSame(builder, builder.storeProperties((Properties) null));
  }

  /**
   * Method under test: {@link Graph.Builder#storeProperties(Properties)}
   */
  @Test
  void testBuilderStoreProperties6() {
    // Arrange
    Graph.Builder builder = new Graph.Builder();

    Properties properties = new Properties();
    properties.replaceAll(mock(BiFunction.class));

    // Act and Assert
    assertSame(builder, builder.storeProperties(properties));
  }

  /**
   * Method under test: {@link Graph.Builder#storeProperties(StoreProperties)}
   */
  @Test
  void testBuilderStoreProperties7() {
    // Arrange
    Graph.Builder builder = new Graph.Builder();

    // Act and Assert
    assertSame(builder, builder.storeProperties((StoreProperties) null));
  }
}
