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

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.elementdefinition.exception.SchemaException;
import uk.gov.gchq.gaffer.data.elementdefinition.view.NamedView;
import uk.gov.gchq.gaffer.data.elementdefinition.view.View;
import uk.gov.gchq.gaffer.graph.GraphConfig.Builder;
import uk.gov.gchq.gaffer.graph.hook.AddOperationsToChain;
import uk.gov.gchq.gaffer.graph.hook.FunctionAuthoriser;
import uk.gov.gchq.gaffer.graph.hook.GraphHook;
import uk.gov.gchq.gaffer.operation.Operation;
import uk.gov.gchq.gaffer.store.StoreProperties;
import uk.gov.gchq.gaffer.store.library.FileGraphLibrary;
import uk.gov.gchq.gaffer.store.library.GraphLibrary;
import uk.gov.gchq.gaffer.store.library.NoGraphLibrary;
import uk.gov.gchq.gaffer.store.schema.Schema;

class GraphSerialisableDiffblueTest {
  /**
   * Test Builder {@link GraphSerialisable.Builder#config(GraphConfig)}.
   * <p>
   * Method under test: {@link GraphSerialisable.Builder#config(GraphConfig)}
   */
  @Test
  @DisplayName("Test Builder config(GraphConfig)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GraphSerialisable.Builder GraphSerialisable.Builder.config(GraphConfig)"})
  void testBuilderConfig() throws UnsupportedEncodingException {
    // Arrange
    GraphSerialisable.Builder builder = new GraphSerialisable.Builder();

    // Act
    GraphSerialisable.Builder actualConfigResult = builder.config(new GraphConfig("42"));

    // Assert
    GraphSerialisable buildResult = builder.build();
    GraphConfig config = buildResult.getConfig();
    assertTrue(config.getLibrary() instanceof NoGraphLibrary);
    assertEquals("42", config.getGraphId());
    assertEquals("42", buildResult.getGraphId());
    assertNull(buildResult.getSerialisedProperties());
    assertNull(buildResult.getSerialisedSchema());
    assertNull(config.getOtelActive());
    assertNull(config.getDescription());
    assertNull(config.getView());
    assertNull(buildResult.getStoreProperties());
    assertNull(buildResult.getSchema());
    assertTrue(config.getHooks().isEmpty());
    assertSame(builder, actualConfigResult);
    byte[] expectedSerialisedConfig = "{\n  \"graphId\" : \"42\",\n  \"hooks\" : [ ]\n}".getBytes("UTF-8");
    assertArrayEquals(expectedSerialisedConfig, buildResult.getSerialisedConfig());
  }

  /**
   * Test Builder {@link GraphSerialisable.Builder#mergeConfig(GraphConfig)}.
   * <p>
   * Method under test: {@link GraphSerialisable.Builder#mergeConfig(GraphConfig)}
   */
  @Test
  @DisplayName("Test Builder mergeConfig(GraphConfig)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GraphSerialisable.Builder GraphSerialisable.Builder.mergeConfig(GraphConfig)"})
  void testBuilderMergeConfig() {
    // Arrange
    GraphSerialisable.Builder builder = new GraphSerialisable.Builder();
    GraphConfig config = (new Builder()).description("The characteristics of someone or something").build();

    // Act and Assert
    assertSame(builder, builder.mergeConfig(config));
  }

  /**
   * Test Builder {@link GraphSerialisable.Builder#mergeConfig(GraphConfig)}.
   * <ul>
   *   <li>Given {@link FileGraphLibrary#FileGraphLibrary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GraphSerialisable.Builder#mergeConfig(GraphConfig)}
   */
  @Test
  @DisplayName("Test Builder mergeConfig(GraphConfig); given FileGraphLibrary()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GraphSerialisable.Builder GraphSerialisable.Builder.mergeConfig(GraphConfig)"})
  void testBuilderMergeConfig_givenFileGraphLibrary() {
    // Arrange
    GraphConfig config = new GraphConfig("42");
    config.setView(null);
    config.setGraphId(null);
    config.setLibrary(null);
    config.setDescription(null);
    config.setOtelActive(null);

    GraphSerialisable.Builder builder = new GraphSerialisable.Builder();
    builder.config(config);

    GraphConfig config2 = new GraphConfig("42");
    config2.setGraphId(null);
    config2.setLibrary(new FileGraphLibrary());
    config2.setDescription(null);
    config2.setOtelActive(null);
    config2.setView(null);

    // Act and Assert
    assertSame(builder, builder.mergeConfig(config2));
  }

  /**
   * Test Builder {@link GraphSerialisable.Builder#mergeConfig(GraphConfig)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>When {@link GraphConfig#GraphConfig(String)} with graphId is {@code 42} OtelActive is {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GraphSerialisable.Builder#mergeConfig(GraphConfig)}
   */
  @Test
  @DisplayName("Test Builder mergeConfig(GraphConfig); given 'true'; when GraphConfig(String) with graphId is '42' OtelActive is 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GraphSerialisable.Builder GraphSerialisable.Builder.mergeConfig(GraphConfig)"})
  void testBuilderMergeConfig_givenTrue_whenGraphConfigWithGraphIdIs42OtelActiveIsTrue() {
    // Arrange
    GraphConfig config = new GraphConfig("42");
    config.setView(null);
    config.setGraphId(null);
    config.setLibrary(null);
    config.setDescription(null);
    config.setOtelActive(null);

    GraphSerialisable.Builder builder = new GraphSerialisable.Builder();
    builder.config(config);

    GraphConfig config2 = new GraphConfig("42");
    config2.setGraphId(null);
    config2.setLibrary(null);
    config2.setDescription(null);
    config2.setOtelActive(true);
    config2.setView(null);

    // Act and Assert
    assertSame(builder, builder.mergeConfig(config2));
  }

  /**
   * Test Builder {@link GraphSerialisable.Builder#mergeConfig(GraphConfig)}.
   * <ul>
   *   <li>Given {@link View} (default constructor).</li>
   *   <li>When {@link GraphConfig#GraphConfig(String)} with graphId is {@code 42} View is {@link View} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link GraphSerialisable.Builder#mergeConfig(GraphConfig)}
   */
  @Test
  @DisplayName("Test Builder mergeConfig(GraphConfig); given View (default constructor); when GraphConfig(String) with graphId is '42' View is View (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GraphSerialisable.Builder GraphSerialisable.Builder.mergeConfig(GraphConfig)"})
  void testBuilderMergeConfig_givenView_whenGraphConfigWithGraphIdIs42ViewIsView() {
    // Arrange
    GraphConfig config = new GraphConfig("42");
    config.setView(null);
    config.setGraphId(null);
    config.setLibrary(null);
    config.setDescription(null);
    config.setOtelActive(null);

    GraphSerialisable.Builder builder = new GraphSerialisable.Builder();
    builder.config(config);

    GraphConfig config2 = new GraphConfig("42");
    config2.setGraphId(null);
    config2.setLibrary(null);
    config2.setDescription(null);
    config2.setOtelActive(null);
    config2.setView(new View());

    // Act and Assert
    assertSame(builder, builder.mergeConfig(config2));
  }

  /**
   * Test Builder {@link GraphSerialisable.Builder#mergeConfig(GraphConfig)}.
   * <ul>
   *   <li>Then {@link GraphSerialisable.Builder#Builder()} build GraphId is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GraphSerialisable.Builder#mergeConfig(GraphConfig)}
   */
  @Test
  @DisplayName("Test Builder mergeConfig(GraphConfig); then Builder() build GraphId is '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GraphSerialisable.Builder GraphSerialisable.Builder.mergeConfig(GraphConfig)"})
  void testBuilderMergeConfig_thenBuilderBuildGraphIdIs42() {
    // Arrange
    GraphSerialisable.Builder builder = new GraphSerialisable.Builder();

    // Act
    builder.mergeConfig(new GraphConfig("42"));

    // Assert
    GraphSerialisable buildResult = builder.build();
    assertEquals("42", buildResult.getGraphId());
    assertNull(buildResult.getSerialisedProperties());
    assertNull(buildResult.getSerialisedSchema());
    assertNull(buildResult.getStoreProperties());
    assertNull(buildResult.getSchema());
    assertEquals(124, buildResult.getSerialisedConfig().length);
  }

  /**
   * Test Builder {@link GraphSerialisable.Builder#Builder()}.
   * <p>
   * Method under test: {@link GraphSerialisable.Builder#Builder()}
   */
  @Test
  @DisplayName("Test Builder new Builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void GraphSerialisable.Builder.<init>()", "GraphSerialisable GraphSerialisable.Builder.build()"})
  void testBuilderNewBuilder() {
    // Arrange and Act
    GraphSerialisable.Builder actualBuilder = new GraphSerialisable.Builder();
    GraphConfig config = (new Builder()).description("The characteristics of someone or something").build();
    GraphSerialisable.Builder actualConfigResult = actualBuilder.config(config);
    GraphConfig config2 = (new Builder()).description("The characteristics of someone or something").build();
    GraphSerialisable.Builder actualMergeConfigResult = actualConfigResult.mergeConfig(config2);
    GraphSerialisable.Builder actualPropertiesResult = actualMergeConfigResult.properties(new Properties());
    GraphSerialisable.Builder actualPropertiesResult2 = actualPropertiesResult.properties(new StoreProperties());

    // Assert
    assertSame(actualPropertiesResult2, actualPropertiesResult2.schema(new Schema()));
  }

  /**
   * Test Builder {@link GraphSerialisable.Builder#Builder(GraphSerialisable)}.
   * <p>
   * Method under test: {@link GraphSerialisable.Builder#Builder(GraphSerialisable)}
   */
  @Test
  @DisplayName("Test Builder new Builder(GraphSerialisable)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void GraphSerialisable.Builder.<init>(GraphSerialisable)"})
  void testBuilderNewBuilder2() {
    // Arrange
    Builder builder = new Builder();
    builder.graphId("42");
    builder.addHook(new AddOperationsToChain());
    GraphConfig config = builder.description("The characteristics of someone or something").build();
    Schema schema = new Schema();
    GraphSerialisable graphSerialisable = new GraphSerialisable(config, schema, new Properties());

    // Act and Assert
    assertEquals(graphSerialisable, (new GraphSerialisable.Builder(graphSerialisable)).build());
  }

  /**
   * Test Builder {@link GraphSerialisable.Builder#properties(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link GraphSerialisable.Builder#properties(InputStream)}
   */
  @Test
  @DisplayName("Test Builder properties(InputStream) with 'InputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GraphSerialisable.Builder GraphSerialisable.Builder.properties(InputStream)"})
  void testBuilderPropertiesWithInputStream() throws IOException {
    // Arrange
    GraphSerialisable.Builder builder = new GraphSerialisable.Builder();
    ByteArrayInputStream properties = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));

    // Act
    GraphSerialisable.Builder actualPropertiesResult = builder.properties(properties);

    // Assert
    assertEquals(-1, properties.read(new byte[]{}));
    assertSame(builder, actualPropertiesResult);
  }

  /**
   * Test Builder {@link GraphSerialisable.Builder#properties(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GraphSerialisable.Builder#properties(InputStream)}
   */
  @Test
  @DisplayName("Test Builder properties(InputStream) with 'InputStream'; when 'null'; then 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GraphSerialisable.Builder GraphSerialisable.Builder.properties(InputStream)"})
  void testBuilderPropertiesWithInputStream_whenNull_thenNull() {
    // Arrange
    GraphSerialisable.Builder builder = new GraphSerialisable.Builder();

    // Act and Assert
    assertNull(null);
    assertSame(builder, builder.properties((InputStream) null));
  }

  /**
   * Test Builder {@link GraphSerialisable.Builder#properties(Properties)} with {@code Properties}.
   * <p>
   * Method under test: {@link GraphSerialisable.Builder#properties(Properties)}
   */
  @Test
  @DisplayName("Test Builder properties(Properties) with 'Properties'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GraphSerialisable.Builder GraphSerialisable.Builder.properties(Properties)"})
  void testBuilderPropertiesWithProperties() {
    // Arrange
    GraphSerialisable.Builder builder = new GraphSerialisable.Builder();

    // Act and Assert
    assertSame(builder, builder.properties(new Properties()));
  }

  /**
   * Test Builder {@link GraphSerialisable.Builder#properties(StoreProperties)} with {@code StoreProperties}.
   * <p>
   * Method under test: {@link GraphSerialisable.Builder#properties(StoreProperties)}
   */
  @Test
  @DisplayName("Test Builder properties(StoreProperties) with 'StoreProperties'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GraphSerialisable.Builder GraphSerialisable.Builder.properties(StoreProperties)"})
  void testBuilderPropertiesWithStoreProperties() {
    // Arrange
    GraphSerialisable.Builder builder = new GraphSerialisable.Builder();

    // Act and Assert
    assertSame(builder, builder.properties(new StoreProperties()));
  }

  /**
   * Test Builder {@link GraphSerialisable.Builder#schema(Schema)} with {@code Schema}.
   * <p>
   * Method under test: {@link GraphSerialisable.Builder#schema(Schema)}
   */
  @Test
  @DisplayName("Test Builder schema(Schema) with 'Schema'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GraphSerialisable.Builder GraphSerialisable.Builder.schema(Schema)"})
  void testBuilderSchemaWithSchema() {
    // Arrange
    GraphSerialisable.Builder builder = new GraphSerialisable.Builder();

    // Act and Assert
    assertSame(builder, builder.schema(new Schema()));
  }

  /**
   * Test {@link GraphSerialisable#GraphSerialisable(GraphConfig, Schema, StoreProperties)}.
   * <p>
   * Method under test: {@link GraphSerialisable#GraphSerialisable(GraphConfig, Schema, StoreProperties)}
   */
  @Test
  @DisplayName("Test new GraphSerialisable(GraphConfig, Schema, StoreProperties)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void GraphSerialisable.<init>(GraphConfig, Schema, StoreProperties)"})
  void testNewGraphSerialisable() throws UnsupportedEncodingException, SchemaException {
    // Arrange
    GraphConfig config = new GraphConfig("42");
    config.setView(new View());
    Schema schema = new Schema();

    // Act
    GraphSerialisable actualGraphSerialisable = new GraphSerialisable(config, schema, new StoreProperties());

    // Assert
    byte[] expectedToCompactJsonResult = "{\"types\":{}}".getBytes("UTF-8");
    assertArrayEquals(expectedToCompactJsonResult, actualGraphSerialisable.getSchema().toCompactJson());
    byte[] expectedSerialisedConfig = "{\n  \"graphId\" : \"42\",\n  \"hooks\" : [ ],\n  \"view\" : { }\n}"
        .getBytes("UTF-8");
    assertArrayEquals(expectedSerialisedConfig, actualGraphSerialisable.getSerialisedConfig());
    byte[] expectedSerialisedSchema = "{\n  \"types\" : { }\n}".getBytes("UTF-8");
    assertArrayEquals(expectedSerialisedSchema, actualGraphSerialisable.getSerialisedSchema());
    assertArrayEquals(new byte[]{'{', '}'}, actualGraphSerialisable.getConfig().getView().toCompactJson());
  }

  /**
   * Test {@link GraphSerialisable#GraphSerialisable(GraphConfig, Schema, StoreProperties)}.
   * <ul>
   *   <li>Given {@link NamedView} (default constructor) addConfig {@code filterFieldsByName} and {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GraphSerialisable#GraphSerialisable(GraphConfig, Schema, StoreProperties)}
   */
  @Test
  @DisplayName("Test new GraphSerialisable(GraphConfig, Schema, StoreProperties); given NamedView (default constructor) addConfig 'filterFieldsByName' and '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void GraphSerialisable.<init>(GraphConfig, Schema, StoreProperties)"})
  void testNewGraphSerialisable_givenNamedViewAddConfigFilterFieldsByNameAnd42() {
    // Arrange
    NamedView view = new NamedView();
    view.addConfig("filterFieldsByName", "42");

    GraphConfig config = new GraphConfig("42");
    config.setView(view);
    config.addHook(new AddOperationsToChain());
    Schema schema = new Schema();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new GraphSerialisable(config, schema, new StoreProperties()));

  }

  /**
   * Test {@link GraphSerialisable#GraphSerialisable(GraphConfig, Schema, StoreProperties)}.
   * <ul>
   *   <li>Given {@link NamedView} (default constructor).</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GraphSerialisable#GraphSerialisable(GraphConfig, Schema, StoreProperties)}
   */
  @Test
  @DisplayName("Test new GraphSerialisable(GraphConfig, Schema, StoreProperties); given NamedView (default constructor); then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void GraphSerialisable.<init>(GraphConfig, Schema, StoreProperties)"})
  void testNewGraphSerialisable_givenNamedView_thenThrowIllegalArgumentException() {
    // Arrange
    GraphConfig config = new GraphConfig("42");
    config.setView(new NamedView());
    config.addHook(new AddOperationsToChain());
    Schema schema = new Schema();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new GraphSerialisable(config, schema, new StoreProperties()));

  }

  /**
   * Test {@link GraphSerialisable#GraphSerialisable(GraphConfig, Schema, StoreProperties)}.
   * <ul>
   *   <li>Given {@link View} (default constructor).</li>
   *   <li>Then return array length is two hundred thirty.</li>
   * </ul>
   * <p>
   * Method under test: {@link GraphSerialisable#GraphSerialisable(GraphConfig, Schema, StoreProperties)}
   */
  @Test
  @DisplayName("Test new GraphSerialisable(GraphConfig, Schema, StoreProperties); given View (default constructor); then return array length is two hundred thirty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void GraphSerialisable.<init>(GraphConfig, Schema, StoreProperties)"})
  void testNewGraphSerialisable_givenView_thenReturnArrayLengthIsTwoHundredThirty()
      throws UnsupportedEncodingException, SchemaException {
    // Arrange
    GraphConfig config = new GraphConfig("42");
    config.setView(new View());
    config.addHook(new AddOperationsToChain());
    Schema schema = new Schema();

    // Act
    GraphSerialisable actualGraphSerialisable = new GraphSerialisable(config, schema, new StoreProperties());

    // Assert
    byte[] serialisedConfig = actualGraphSerialisable.getSerialisedConfig();
    assertEquals(230, serialisedConfig.length);
    assertEquals(' ', serialisedConfig[214]);
    assertEquals(' ', serialisedConfig[215]);
    assertEquals(' ', serialisedConfig[222]);
    assertEquals(' ', serialisedConfig[224]);
    assertEquals(' ', serialisedConfig[226]);
    assertEquals(',', serialisedConfig[212]);
    assertEquals(':', serialisedConfig[223]);
    assertEquals('"', serialisedConfig[216]);
    assertEquals('"', serialisedConfig[221]);
    assertEquals('\n', serialisedConfig[213]);
    assertEquals('\n', serialisedConfig[228]);
    assertEquals('e', serialisedConfig[219]);
    assertEquals('i', serialisedConfig[218]);
    assertEquals('v', serialisedConfig[217]);
    assertEquals('w', serialisedConfig[220]);
    assertEquals('{', serialisedConfig[225]);
    assertEquals('}', serialisedConfig[227]);
    assertEquals('}', serialisedConfig[229]);
    byte[] expectedToCompactJsonResult = "{\"types\":{}}".getBytes("UTF-8");
    assertArrayEquals(expectedToCompactJsonResult, actualGraphSerialisable.getSchema().toCompactJson());
    byte[] expectedSerialisedSchema = "{\n  \"types\" : { }\n}".getBytes("UTF-8");
    assertArrayEquals(expectedSerialisedSchema, actualGraphSerialisable.getSerialisedSchema());
  }

  /**
   * Test {@link GraphSerialisable#GraphSerialisable(GraphConfig, Schema, Properties)}.
   * <ul>
   *   <li>Then return array length is one hundred sixty-nine.</li>
   * </ul>
   * <p>
   * Method under test: {@link GraphSerialisable#GraphSerialisable(GraphConfig, Schema, Properties)}
   */
  @Test
  @DisplayName("Test new GraphSerialisable(GraphConfig, Schema, Properties); then return array length is one hundred sixty-nine")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void GraphSerialisable.<init>(GraphConfig, Schema, Properties)"})
  void testNewGraphSerialisable_thenReturnArrayLengthIsOneHundredSixtyNine() throws UnsupportedEncodingException {
    // Arrange
    GraphConfig config = (new Builder()).description("The characteristics of someone or something").build();
    Schema schema = new Schema();

    // Act
    GraphSerialisable actualGraphSerialisable = new GraphSerialisable(config, schema, new Properties());

    // Assert
    assertEquals(169, actualGraphSerialisable.getSerialisedConfig().length);
    byte[] expectedSerialisedProperties = "{ }".getBytes("UTF-8");
    assertArrayEquals(expectedSerialisedProperties, actualGraphSerialisable.getSerialisedProperties());
    byte[] expectedSerialisedSchema = "{\n  \"types\" : { }\n}".getBytes("UTF-8");
    assertArrayEquals(expectedSerialisedSchema, actualGraphSerialisable.getSerialisedSchema());
  }

  /**
   * Test {@link GraphSerialisable#GraphSerialisable(GraphConfig, Schema, StoreProperties)}.
   * <ul>
   *   <li>Then return array length is one hundred sixty-nine.</li>
   * </ul>
   * <p>
   * Method under test: {@link GraphSerialisable#GraphSerialisable(GraphConfig, Schema, StoreProperties)}
   */
  @Test
  @DisplayName("Test new GraphSerialisable(GraphConfig, Schema, StoreProperties); then return array length is one hundred sixty-nine")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void GraphSerialisable.<init>(GraphConfig, Schema, StoreProperties)"})
  void testNewGraphSerialisable_thenReturnArrayLengthIsOneHundredSixtyNine2() throws UnsupportedEncodingException {
    // Arrange
    GraphConfig config = (new Builder()).description("The characteristics of someone or something").build();
    Schema schema = new Schema();

    // Act
    GraphSerialisable actualGraphSerialisable = new GraphSerialisable(config, schema, new StoreProperties());

    // Assert
    assertEquals(169, actualGraphSerialisable.getSerialisedConfig().length);
    byte[] expectedSerialisedSchema = "{\n  \"types\" : { }\n}".getBytes("UTF-8");
    assertArrayEquals(expectedSerialisedSchema, actualGraphSerialisable.getSerialisedSchema());
  }

  /**
   * Test {@link GraphSerialisable#GraphSerialisable(GraphConfig, Schema, StoreProperties)}.
   * <ul>
   *   <li>Then return array length is one hundred ten.</li>
   * </ul>
   * <p>
   * Method under test: {@link GraphSerialisable#GraphSerialisable(GraphConfig, Schema, StoreProperties)}
   */
  @Test
  @DisplayName("Test new GraphSerialisable(GraphConfig, Schema, StoreProperties); then return array length is one hundred ten")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void GraphSerialisable.<init>(GraphConfig, Schema, StoreProperties)"})
  void testNewGraphSerialisable_thenReturnArrayLengthIsOneHundredTen() throws UnsupportedEncodingException {
    // Arrange
    GraphConfig config = new GraphConfig("42");
    config.addHook(new FunctionAuthoriser());
    Schema schema = new Schema();

    // Act
    GraphSerialisable actualGraphSerialisable = new GraphSerialisable(config, schema, new StoreProperties());

    // Assert
    assertEquals(110, actualGraphSerialisable.getSerialisedConfig().length);
    byte[] expectedSerialisedSchema = "{\n  \"types\" : { }\n}".getBytes("UTF-8");
    assertArrayEquals(expectedSerialisedSchema, actualGraphSerialisable.getSerialisedSchema());
  }

  /**
   * Test {@link GraphSerialisable#GraphSerialisable(GraphConfig, Schema, StoreProperties)}.
   * <ul>
   *   <li>Then return array length is two hundred eighty-nine.</li>
   * </ul>
   * <p>
   * Method under test: {@link GraphSerialisable#GraphSerialisable(GraphConfig, Schema, StoreProperties)}
   */
  @Test
  @DisplayName("Test new GraphSerialisable(GraphConfig, Schema, StoreProperties); then return array length is two hundred eighty-nine")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void GraphSerialisable.<init>(GraphConfig, Schema, StoreProperties)"})
  void testNewGraphSerialisable_thenReturnArrayLengthIsTwoHundredEightyNine() throws UnsupportedEncodingException {
    // Arrange
    View view = new View();
    view.addConfig("filterFieldsByName", "42");

    GraphConfig config = new GraphConfig("42");
    config.setView(view);
    config.addHook(new AddOperationsToChain());
    Schema schema = new Schema();

    // Act
    GraphSerialisable actualGraphSerialisable = new GraphSerialisable(config, schema, new StoreProperties());

    // Assert
    assertEquals(289, actualGraphSerialisable.getSerialisedConfig().length);
    byte[] expectedSerialisedSchema = "{\n  \"types\" : { }\n}".getBytes("UTF-8");
    assertArrayEquals(expectedSerialisedSchema, actualGraphSerialisable.getSerialisedSchema());
  }

  /**
   * Test {@link GraphSerialisable#GraphSerialisable(GraphConfig, Schema, StoreProperties)}.
   * <ul>
   *   <li>Then return array length is two hundred fourteen.</li>
   * </ul>
   * <p>
   * Method under test: {@link GraphSerialisable#GraphSerialisable(GraphConfig, Schema, StoreProperties)}
   */
  @Test
  @DisplayName("Test new GraphSerialisable(GraphConfig, Schema, StoreProperties); then return array length is two hundred fourteen")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void GraphSerialisable.<init>(GraphConfig, Schema, StoreProperties)"})
  void testNewGraphSerialisable_thenReturnArrayLengthIsTwoHundredFourteen()
      throws UnsupportedEncodingException, SchemaException {
    // Arrange
    GraphConfig config = new GraphConfig("42");
    config.addHook(new AddOperationsToChain());
    Schema schema = new Schema();

    // Act
    GraphSerialisable actualGraphSerialisable = new GraphSerialisable(config, schema, new StoreProperties());

    // Assert
    byte[] serialisedConfig = actualGraphSerialisable.getSerialisedConfig();
    assertEquals(214, serialisedConfig.length);
    assertEquals(' ', serialisedConfig[200]);
    assertEquals(' ', serialisedConfig[202]);
    assertEquals(' ', serialisedConfig[204]);
    assertEquals(':', serialisedConfig[201]);
    assertEquals('O', serialisedConfig[196]);
    assertEquals('"', serialisedConfig[199]);
    assertEquals('\n', serialisedConfig[212]);
    assertEquals('d', serialisedConfig[195]);
    assertEquals('e', serialisedConfig[194]);
    assertEquals('h', serialisedConfig[189]);
    assertEquals('i', serialisedConfig[192]);
    assertEquals('o', serialisedConfig[190]);
    assertEquals('p', serialisedConfig[197]);
    assertEquals('r', serialisedConfig[191]);
    assertEquals('s', serialisedConfig[193]);
    assertEquals('s', serialisedConfig[198]);
    assertEquals('{', serialisedConfig[203]);
    assertEquals('}', serialisedConfig[213]);
    byte[] expectedToCompactJsonResult = "{\"types\":{}}".getBytes("UTF-8");
    assertArrayEquals(expectedToCompactJsonResult, actualGraphSerialisable.getSchema().toCompactJson());
    byte[] expectedSerialisedSchema = "{\n  \"types\" : { }\n}".getBytes("UTF-8");
    assertArrayEquals(expectedSerialisedSchema, actualGraphSerialisable.getSerialisedSchema());
  }

  /**
   * Test {@link GraphSerialisable#GraphSerialisable(GraphConfig, Schema, StoreProperties)}.
   * <ul>
   *   <li>Then return Config Hooks Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link GraphSerialisable#GraphSerialisable(GraphConfig, Schema, StoreProperties)}
   */
  @Test
  @DisplayName("Test new GraphSerialisable(GraphConfig, Schema, StoreProperties); then return Config Hooks Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void GraphSerialisable.<init>(GraphConfig, Schema, StoreProperties)"})
  void testNewGraphSerialisable_thenReturnConfigHooksEmpty() throws UnsupportedEncodingException, SchemaException {
    // Arrange
    GraphConfig config = new GraphConfig("42");
    Schema schema = new Schema();

    // Act
    GraphSerialisable actualGraphSerialisable = new GraphSerialisable(config, schema, new StoreProperties());

    // Assert
    assertTrue(actualGraphSerialisable.getConfig().getHooks().isEmpty());
    byte[] expectedToCompactJsonResult = "{\"types\":{}}".getBytes("UTF-8");
    assertArrayEquals(expectedToCompactJsonResult, actualGraphSerialisable.getSchema().toCompactJson());
    byte[] expectedSerialisedConfig = "{\n  \"graphId\" : \"42\",\n  \"hooks\" : [ ]\n}".getBytes("UTF-8");
    assertArrayEquals(expectedSerialisedConfig, actualGraphSerialisable.getSerialisedConfig());
    byte[] expectedSerialisedSchema = "{\n  \"types\" : { }\n}".getBytes("UTF-8");
    assertArrayEquals(expectedSerialisedSchema, actualGraphSerialisable.getSerialisedSchema());
  }

  /**
   * Test {@link GraphSerialisable#GraphSerialisable(GraphConfig, Schema, Properties)}.
   * <ul>
   *   <li>Then return Schema toCompactJson is {@code {"types":{}}} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GraphSerialisable#GraphSerialisable(GraphConfig, Schema, Properties)}
   */
  @Test
  @DisplayName("Test new GraphSerialisable(GraphConfig, Schema, Properties); then return Schema toCompactJson is '{\"types\":{}}' Bytes is 'UTF-8'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void GraphSerialisable.<init>(GraphConfig, Schema, Properties)"})
  void testNewGraphSerialisable_thenReturnSchemaToCompactJsonIsTypesBytesIsUtf8()
      throws UnsupportedEncodingException, SchemaException {
    // Arrange
    GraphConfig config = new GraphConfig("42");
    Schema schema = new Schema();

    // Act
    GraphSerialisable actualGraphSerialisable = new GraphSerialisable(config, schema, new Properties());

    // Assert
    byte[] expectedSerialisedProperties = "{ }".getBytes("UTF-8");
    assertArrayEquals(expectedSerialisedProperties, actualGraphSerialisable.getSerialisedProperties());
    byte[] expectedToCompactJsonResult = "{\"types\":{}}".getBytes("UTF-8");
    assertArrayEquals(expectedToCompactJsonResult, actualGraphSerialisable.getSchema().toCompactJson());
    byte[] expectedSerialisedConfig = "{\n  \"graphId\" : \"42\",\n  \"hooks\" : [ ]\n}".getBytes("UTF-8");
    assertArrayEquals(expectedSerialisedConfig, actualGraphSerialisable.getSerialisedConfig());
    byte[] expectedSerialisedSchema = "{\n  \"types\" : { }\n}".getBytes("UTF-8");
    assertArrayEquals(expectedSerialisedSchema, actualGraphSerialisable.getSerialisedSchema());
  }

  /**
   * Test {@link GraphSerialisable#GraphSerialisable(GraphConfig, Schema, Properties)}.
   * <ul>
   *   <li>Then return SerialisedSchema is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GraphSerialisable#GraphSerialisable(GraphConfig, Schema, Properties)}
   */
  @Test
  @DisplayName("Test new GraphSerialisable(GraphConfig, Schema, Properties); then return SerialisedSchema is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void GraphSerialisable.<init>(GraphConfig, Schema, Properties)"})
  void testNewGraphSerialisable_thenReturnSerialisedSchemaIsNull() throws UnsupportedEncodingException {
    // Arrange
    GraphConfig config = new GraphConfig("42");

    // Act
    GraphSerialisable actualGraphSerialisable = new GraphSerialisable(config, null, new Properties());

    // Assert
    assertNull(actualGraphSerialisable.getSerialisedSchema());
    assertNull(actualGraphSerialisable.getSchema());
    byte[] expectedSerialisedProperties = "{ }".getBytes("UTF-8");
    assertArrayEquals(expectedSerialisedProperties, actualGraphSerialisable.getSerialisedProperties());
    byte[] expectedSerialisedConfig = "{\n  \"graphId\" : \"42\",\n  \"hooks\" : [ ]\n}".getBytes("UTF-8");
    assertArrayEquals(expectedSerialisedConfig, actualGraphSerialisable.getSerialisedConfig());
  }

  /**
   * Test {@link GraphSerialisable#GraphSerialisable(GraphConfig, Schema, StoreProperties)}.
   * <ul>
   *   <li>Then return SerialisedSchema is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GraphSerialisable#GraphSerialisable(GraphConfig, Schema, StoreProperties)}
   */
  @Test
  @DisplayName("Test new GraphSerialisable(GraphConfig, Schema, StoreProperties); then return SerialisedSchema is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void GraphSerialisable.<init>(GraphConfig, Schema, StoreProperties)"})
  void testNewGraphSerialisable_thenReturnSerialisedSchemaIsNull2() throws UnsupportedEncodingException {
    // Arrange
    GraphConfig config = new GraphConfig("42");

    // Act
    GraphSerialisable actualGraphSerialisable = new GraphSerialisable(config, null, new StoreProperties());

    // Assert
    assertNull(actualGraphSerialisable.getSerialisedSchema());
    assertNull(actualGraphSerialisable.getSchema());
    assertTrue(actualGraphSerialisable.getConfig().getHooks().isEmpty());
    byte[] expectedSerialisedConfig = "{\n  \"graphId\" : \"42\",\n  \"hooks\" : [ ]\n}".getBytes("UTF-8");
    assertArrayEquals(expectedSerialisedConfig, actualGraphSerialisable.getSerialisedConfig());
  }

  /**
   * Test {@link GraphSerialisable#GraphSerialisable(GraphConfig, Schema, Properties)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return SerialisedConfig is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GraphSerialisable#GraphSerialisable(GraphConfig, Schema, Properties)}
   */
  @Test
  @DisplayName("Test new GraphSerialisable(GraphConfig, Schema, Properties); when 'null'; then return SerialisedConfig is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void GraphSerialisable.<init>(GraphConfig, Schema, Properties)"})
  void testNewGraphSerialisable_whenNull_thenReturnSerialisedConfigIsNull()
      throws UnsupportedEncodingException, SchemaException {
    // Arrange
    Schema schema = new Schema();

    // Act
    GraphSerialisable actualGraphSerialisable = new GraphSerialisable(null, schema, new Properties());

    // Assert
    assertNull(actualGraphSerialisable.getSerialisedConfig());
    assertNull(actualGraphSerialisable.getConfig());
    byte[] expectedSerialisedProperties = "{ }".getBytes("UTF-8");
    assertArrayEquals(expectedSerialisedProperties, actualGraphSerialisable.getSerialisedProperties());
    byte[] expectedToCompactJsonResult = "{\"types\":{}}".getBytes("UTF-8");
    assertArrayEquals(expectedToCompactJsonResult, actualGraphSerialisable.getSchema().toCompactJson());
    byte[] expectedSerialisedSchema = "{\n  \"types\" : { }\n}".getBytes("UTF-8");
    assertArrayEquals(expectedSerialisedSchema, actualGraphSerialisable.getSerialisedSchema());
  }

  /**
   * Test {@link GraphSerialisable#GraphSerialisable(GraphConfig, Schema, StoreProperties)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return SerialisedConfig is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GraphSerialisable#GraphSerialisable(GraphConfig, Schema, StoreProperties)}
   */
  @Test
  @DisplayName("Test new GraphSerialisable(GraphConfig, Schema, StoreProperties); when 'null'; then return SerialisedConfig is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void GraphSerialisable.<init>(GraphConfig, Schema, StoreProperties)"})
  void testNewGraphSerialisable_whenNull_thenReturnSerialisedConfigIsNull2()
      throws UnsupportedEncodingException, SchemaException {
    // Arrange
    Schema schema = new Schema();

    // Act
    GraphSerialisable actualGraphSerialisable = new GraphSerialisable(null, schema, new StoreProperties());

    // Assert
    assertNull(actualGraphSerialisable.getSerialisedConfig());
    assertNull(actualGraphSerialisable.getConfig());
    byte[] expectedToCompactJsonResult = "{\"types\":{}}".getBytes("UTF-8");
    assertArrayEquals(expectedToCompactJsonResult, actualGraphSerialisable.getSchema().toCompactJson());
    byte[] expectedSerialisedSchema = "{\n  \"types\" : { }\n}".getBytes("UTF-8");
    assertArrayEquals(expectedSerialisedSchema, actualGraphSerialisable.getSerialisedSchema());
  }

  /**
   * Test {@link GraphSerialisable#getSchema(GraphLibrary)} with {@code GraphLibrary}.
   * <ul>
   *   <li>Then return {@link Schema#Schema()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GraphSerialisable#getSchema(GraphLibrary)}
   */
  @Test
  @DisplayName("Test getSchema(GraphLibrary) with 'GraphLibrary'; then return Schema()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Schema GraphSerialisable.getSchema(GraphLibrary)"})
  void testGetSchemaWithGraphLibrary_thenReturnSchema() {
    // Arrange
    GraphConfig config = (new Builder()).description("The characteristics of someone or something").build();
    Schema schema = new Schema();
    GraphSerialisable graphSerialisable = new GraphSerialisable(config, schema, new Properties());

    // Act and Assert
    assertEquals(schema, graphSerialisable.getSchema(new FileGraphLibrary()));
  }

  /**
   * Test {@link GraphSerialisable#getSchema(GraphLibrary)} with {@code GraphLibrary}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GraphSerialisable#getSchema(GraphLibrary)}
   */
  @Test
  @DisplayName("Test getSchema(GraphLibrary) with 'GraphLibrary'; when 'null'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Schema GraphSerialisable.getSchema(GraphLibrary)"})
  void testGetSchemaWithGraphLibrary_whenNull_thenReturnNull() {
    // Arrange
    GraphConfig config = (new Builder()).description("The characteristics of someone or something").build();

    // Act and Assert
    assertNull((new GraphSerialisable(config, null, new Properties())).getSchema(null));
  }

  /**
   * Test {@link GraphSerialisable#getSchema()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GraphSerialisable#getSchema()}
   */
  @Test
  @DisplayName("Test getSchema(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Schema GraphSerialisable.getSchema()"})
  void testGetSchema_thenReturnNull() {
    // Arrange
    GraphConfig config = (new Builder()).description("The characteristics of someone or something").build();

    // Act and Assert
    assertNull((new GraphSerialisable(config, null, new Properties())).getSchema());
  }

  /**
   * Test {@link GraphSerialisable#getSchema()}.
   * <ul>
   *   <li>Then return {@link Schema#Schema()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GraphSerialisable#getSchema()}
   */
  @Test
  @DisplayName("Test getSchema(); then return Schema()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Schema GraphSerialisable.getSchema()"})
  void testGetSchema_thenReturnSchema() {
    // Arrange
    GraphConfig config = (new Builder()).description("The characteristics of someone or something").build();
    Schema schema = new Schema();

    // Act and Assert
    assertEquals(schema, (new GraphSerialisable(config, schema, new Properties())).getSchema());
  }

  /**
   * Test {@link GraphSerialisable#getGraphId()}.
   * <p>
   * Method under test: {@link GraphSerialisable#getGraphId()}
   */
  @Test
  @DisplayName("Test getGraphId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String GraphSerialisable.getGraphId()"})
  void testGetGraphId() {
    // Arrange
    Builder builder = new Builder();
    builder.addHook(new FunctionAuthoriser(new ArrayList<>()));
    GraphConfig config = builder.description("The characteristics of someone or something").build();
    Schema schema = new Schema();

    // Act and Assert
    assertNull((new GraphSerialisable(config, schema, new Properties())).getGraphId());
  }

  /**
   * Test {@link GraphSerialisable#getGraphId()}.
   * <ul>
   *   <li>Given {@link Builder} (default constructor) addHook {@link AddOperationsToChain} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GraphSerialisable#getGraphId()}
   */
  @Test
  @DisplayName("Test getGraphId(); given Builder (default constructor) addHook AddOperationsToChain (default constructor); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String GraphSerialisable.getGraphId()"})
  void testGetGraphId_givenBuilderAddHookAddOperationsToChain_thenReturnNull() {
    // Arrange
    Builder builder = new Builder();
    builder.addHook(new AddOperationsToChain());
    GraphConfig config = builder.description("The characteristics of someone or something").build();
    Schema schema = new Schema();

    // Act and Assert
    assertNull((new GraphSerialisable(config, schema, new Properties())).getGraphId());
  }

  /**
   * Test {@link GraphSerialisable#getGraphId()}.
   * <ul>
   *   <li>Given {@link Builder} (default constructor) addHook {@link AddOperationsToChain} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GraphSerialisable#getGraphId()}
   */
  @Test
  @DisplayName("Test getGraphId(); given Builder (default constructor) addHook AddOperationsToChain (default constructor); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String GraphSerialisable.getGraphId()"})
  void testGetGraphId_givenBuilderAddHookAddOperationsToChain_thenReturnNull2() {
    // Arrange
    Builder builder = new Builder();
    builder.addHook(new AddOperationsToChain());
    builder.addHook(new AddOperationsToChain());
    GraphConfig config = builder.description("The characteristics of someone or something").build();
    Schema schema = new Schema();

    // Act and Assert
    assertNull((new GraphSerialisable(config, schema, new Properties())).getGraphId());
  }

  /**
   * Test {@link GraphSerialisable#getGraphId()}.
   * <ul>
   *   <li>Given {@link Builder} (default constructor) addHook {@link FunctionAuthoriser#FunctionAuthoriser()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GraphSerialisable#getGraphId()}
   */
  @Test
  @DisplayName("Test getGraphId(); given Builder (default constructor) addHook FunctionAuthoriser(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String GraphSerialisable.getGraphId()"})
  void testGetGraphId_givenBuilderAddHookFunctionAuthoriser_thenReturnNull() {
    // Arrange
    Builder builder = new Builder();
    builder.addHook(new FunctionAuthoriser());
    GraphConfig config = builder.description("The characteristics of someone or something").build();
    Schema schema = new Schema();

    // Act and Assert
    assertNull((new GraphSerialisable(config, schema, new Properties())).getGraphId());
  }

  /**
   * Test {@link GraphSerialisable#getGraphId()}.
   * <ul>
   *   <li>Given {@link Builder} (default constructor) graphId {@code 42}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GraphSerialisable#getGraphId()}
   */
  @Test
  @DisplayName("Test getGraphId(); given Builder (default constructor) graphId '42'; then return '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String GraphSerialisable.getGraphId()"})
  void testGetGraphId_givenBuilderGraphId42_thenReturn42() {
    // Arrange
    Builder builder = new Builder();
    builder.graphId("42");
    builder.addHook(new AddOperationsToChain());
    GraphConfig config = builder.description("The characteristics of someone or something").build();
    Schema schema = new Schema();

    // Act and Assert
    assertEquals("42", (new GraphSerialisable(config, schema, new Properties())).getGraphId());
  }

  /**
   * Test {@link GraphSerialisable#getGraphId()}.
   * <ul>
   *   <li>Given {@link Builder} (default constructor) library {@link FileGraphLibrary#FileGraphLibrary()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GraphSerialisable#getGraphId()}
   */
  @Test
  @DisplayName("Test getGraphId(); given Builder (default constructor) library FileGraphLibrary(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String GraphSerialisable.getGraphId()"})
  void testGetGraphId_givenBuilderLibraryFileGraphLibrary_thenReturnNull() {
    // Arrange
    Builder builder = new Builder();
    builder.library(new FileGraphLibrary());
    builder.addHook(new AddOperationsToChain());
    GraphConfig config = builder.description("The characteristics of someone or something").build();
    Schema schema = new Schema();

    // Act and Assert
    assertNull((new GraphSerialisable(config, schema, new Properties())).getGraphId());
  }

  /**
   * Test {@link GraphSerialisable#getGraphId()}.
   * <ul>
   *   <li>Given {@link Builder} (default constructor) otelActive {@code true}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GraphSerialisable#getGraphId()}
   */
  @Test
  @DisplayName("Test getGraphId(); given Builder (default constructor) otelActive 'true'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String GraphSerialisable.getGraphId()"})
  void testGetGraphId_givenBuilderOtelActiveTrue_thenReturnNull() {
    // Arrange
    Builder builder = new Builder();
    builder.otelActive(true);
    builder.addHook(new AddOperationsToChain());
    GraphConfig config = builder.description("The characteristics of someone or something").build();
    Schema schema = new Schema();

    // Act and Assert
    assertNull((new GraphSerialisable(config, schema, new Properties())).getGraphId());
  }

  /**
   * Test {@link GraphSerialisable#getGraphId()}.
   * <ul>
   *   <li>Given {@link Builder} (default constructor) view {@link View} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GraphSerialisable#getGraphId()}
   */
  @Test
  @DisplayName("Test getGraphId(); given Builder (default constructor) view View (default constructor); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String GraphSerialisable.getGraphId()"})
  void testGetGraphId_givenBuilderViewView_thenReturnNull() {
    // Arrange
    Builder builder = new Builder();
    builder.view(new View());
    builder.addHook(new AddOperationsToChain());
    GraphConfig config = builder.description("The characteristics of someone or something").build();
    Schema schema = new Schema();

    // Act and Assert
    assertNull((new GraphSerialisable(config, schema, new Properties())).getGraphId());
  }

  /**
   * Test {@link GraphSerialisable#getGraphId()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GraphSerialisable#getGraphId()}
   */
  @Test
  @DisplayName("Test getGraphId(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String GraphSerialisable.getGraphId()"})
  void testGetGraphId_thenReturnNull() {
    // Arrange
    GraphConfig config = (new Builder()).description("The characteristics of someone or something").build();
    Schema schema = new Schema();

    // Act and Assert
    assertNull((new GraphSerialisable(config, schema, new Properties())).getGraphId());
  }

  /**
   * Test {@link GraphSerialisable#getStoreProperties(GraphLibrary)} with {@code GraphLibrary}.
   * <p>
   * Method under test: {@link GraphSerialisable#getStoreProperties(GraphLibrary)}
   */
  @Test
  @DisplayName("Test getStoreProperties(GraphLibrary) with 'GraphLibrary'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"StoreProperties GraphSerialisable.getStoreProperties(GraphLibrary)"})
  void testGetStorePropertiesWithGraphLibrary() {
    // Arrange
    GraphConfig config = (new Builder()).description("The characteristics of someone or something").build();
    Schema schema = new Schema();
    GraphSerialisable graphSerialisable = new GraphSerialisable(config, schema, new Properties());

    // Act
    StoreProperties actualStoreProperties = graphSerialisable.getStoreProperties(new FileGraphLibrary());

    // Assert
    assertEquals("", actualStoreProperties.getAdminAuth());
    assertEquals("", actualStoreProperties.getJsonSerialiserModules());
    assertEquals("uk.gov.gchq.gaffer.store.StoreProperties", actualStoreProperties.getStorePropertiesClassName());
    assertEquals("uk.gov.gchq.gaffer.store.schema.Schema", actualStoreProperties.getSchemaClassName());
    assertNull(actualStoreProperties.getStrictJson());
    assertNull(actualStoreProperties.getCacheServiceClass());
    assertNull(actualStoreProperties.getDefaultCacheServiceClass());
    assertNull(actualStoreProperties.getJobTrackerCacheServiceClass());
    assertNull(actualStoreProperties.getJsonSerialiserClass());
    assertNull(actualStoreProperties.getNamedOperationCacheServiceClass());
    assertNull(actualStoreProperties.getNamedViewCacheServiceClass());
    assertNull(actualStoreProperties.getOperationDeclarationPaths());
    assertNull(actualStoreProperties.getReflectionPackages());
    assertNull(actualStoreProperties.getStoreClass());
    assertEquals(50, actualStoreProperties.getJobExecutorThreadCount().intValue());
    assertFalse(actualStoreProperties.getJobTrackerEnabled());
    assertFalse(actualStoreProperties.getRescheduleJobsOnStart());
    assertTrue(actualStoreProperties.getProperties().isEmpty());
    assertTrue(actualStoreProperties.getNamedOperationEnabled());
    assertTrue(actualStoreProperties.getNamedViewEnabled());
    Class<StoreProperties> expectedStorePropertiesClass = StoreProperties.class;
    assertEquals(expectedStorePropertiesClass, actualStoreProperties.getStorePropertiesClass());
    Class<Schema> expectedSchemaClass = Schema.class;
    assertEquals(expectedSchemaClass, actualStoreProperties.getSchemaClass());
  }

  /**
   * Test {@link GraphSerialisable#getStoreProperties(GraphLibrary)} with {@code GraphLibrary}.
   * <ul>
   *   <li>Given {@link Builder} (default constructor) graphId {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GraphSerialisable#getStoreProperties(GraphLibrary)}
   */
  @Test
  @DisplayName("Test getStoreProperties(GraphLibrary) with 'GraphLibrary'; given Builder (default constructor) graphId '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"StoreProperties GraphSerialisable.getStoreProperties(GraphLibrary)"})
  void testGetStorePropertiesWithGraphLibrary_givenBuilderGraphId42() {
    // Arrange
    Builder builder = new Builder();
    builder.graphId("42");
    GraphConfig config = builder.description("The characteristics of someone or something").build();
    GraphSerialisable.Builder configResult = (new GraphSerialisable.Builder()).config(config);
    GraphSerialisable.Builder propertiesResult = configResult.properties(new Properties());
    GraphSerialisable buildResult = propertiesResult.schema(new Schema()).build();

    // Act
    StoreProperties actualStoreProperties = buildResult.getStoreProperties(new FileGraphLibrary());

    // Assert
    assertEquals("", actualStoreProperties.getAdminAuth());
    assertEquals("", actualStoreProperties.getJsonSerialiserModules());
    assertEquals("uk.gov.gchq.gaffer.store.StoreProperties", actualStoreProperties.getStorePropertiesClassName());
    assertEquals("uk.gov.gchq.gaffer.store.schema.Schema", actualStoreProperties.getSchemaClassName());
    assertNull(actualStoreProperties.getStrictJson());
    assertNull(actualStoreProperties.getCacheServiceClass());
    assertNull(actualStoreProperties.getDefaultCacheServiceClass());
    assertNull(actualStoreProperties.getJobTrackerCacheServiceClass());
    assertNull(actualStoreProperties.getJsonSerialiserClass());
    assertNull(actualStoreProperties.getNamedOperationCacheServiceClass());
    assertNull(actualStoreProperties.getNamedViewCacheServiceClass());
    assertNull(actualStoreProperties.getOperationDeclarationPaths());
    assertNull(actualStoreProperties.getReflectionPackages());
    assertNull(actualStoreProperties.getStoreClass());
    assertEquals(50, actualStoreProperties.getJobExecutorThreadCount().intValue());
    assertFalse(actualStoreProperties.getJobTrackerEnabled());
    assertFalse(actualStoreProperties.getRescheduleJobsOnStart());
    assertTrue(actualStoreProperties.getProperties().isEmpty());
    assertTrue(actualStoreProperties.getNamedOperationEnabled());
    assertTrue(actualStoreProperties.getNamedViewEnabled());
    Class<StoreProperties> expectedStorePropertiesClass = StoreProperties.class;
    assertEquals(expectedStorePropertiesClass, actualStoreProperties.getStorePropertiesClass());
    Class<Schema> expectedSchemaClass = Schema.class;
    assertEquals(expectedSchemaClass, actualStoreProperties.getSchemaClass());
  }

  /**
   * Test {@link GraphSerialisable#getStoreProperties(GraphLibrary)} with {@code GraphLibrary}.
   * <ul>
   *   <li>Then return Properties size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link GraphSerialisable#getStoreProperties(GraphLibrary)}
   */
  @Test
  @DisplayName("Test getStoreProperties(GraphLibrary) with 'GraphLibrary'; then return Properties size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"StoreProperties GraphSerialisable.getStoreProperties(GraphLibrary)"})
  void testGetStorePropertiesWithGraphLibrary_thenReturnPropertiesSizeIsOne() {
    // Arrange
    GraphConfig config = (new Builder()).description("The characteristics of someone or something").build();
    Schema schema = new Schema();
    GraphSerialisable graphSerialisable = new GraphSerialisable(config, schema, new StoreProperties());

    // Act and Assert
    Properties properties = graphSerialisable.getStoreProperties(new FileGraphLibrary()).getProperties();
    assertEquals(1, properties.size());
    assertEquals("uk.gov.gchq.gaffer.store.StoreProperties", properties.get("gaffer.store.properties.class"));
  }

  /**
   * Test {@link GraphSerialisable#getStoreProperties()}.
   * <ul>
   *   <li>Then return AdminAuth is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link GraphSerialisable#getStoreProperties()}
   */
  @Test
  @DisplayName("Test getStoreProperties(); then return AdminAuth is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"StoreProperties GraphSerialisable.getStoreProperties()"})
  void testGetStoreProperties_thenReturnAdminAuthIsEmptyString() {
    // Arrange
    GraphConfig config = (new Builder()).description("The characteristics of someone or something").build();
    Schema schema = new Schema();

    // Act
    StoreProperties actualStoreProperties = (new GraphSerialisable(config, schema, new Properties()))
        .getStoreProperties();

    // Assert
    assertEquals("", actualStoreProperties.getAdminAuth());
    assertEquals("", actualStoreProperties.getJsonSerialiserModules());
    assertEquals("uk.gov.gchq.gaffer.store.StoreProperties", actualStoreProperties.getStorePropertiesClassName());
    assertEquals("uk.gov.gchq.gaffer.store.schema.Schema", actualStoreProperties.getSchemaClassName());
    assertNull(actualStoreProperties.getStrictJson());
    assertNull(actualStoreProperties.getCacheServiceClass());
    assertNull(actualStoreProperties.getDefaultCacheServiceClass());
    assertNull(actualStoreProperties.getJobTrackerCacheServiceClass());
    assertNull(actualStoreProperties.getJsonSerialiserClass());
    assertNull(actualStoreProperties.getNamedOperationCacheServiceClass());
    assertNull(actualStoreProperties.getNamedViewCacheServiceClass());
    assertNull(actualStoreProperties.getOperationDeclarationPaths());
    assertNull(actualStoreProperties.getReflectionPackages());
    assertNull(actualStoreProperties.getStoreClass());
    assertEquals(50, actualStoreProperties.getJobExecutorThreadCount().intValue());
    assertFalse(actualStoreProperties.getJobTrackerEnabled());
    assertFalse(actualStoreProperties.getRescheduleJobsOnStart());
    assertTrue(actualStoreProperties.getProperties().isEmpty());
    assertTrue(actualStoreProperties.getNamedOperationEnabled());
    assertTrue(actualStoreProperties.getNamedViewEnabled());
    Class<StoreProperties> expectedStorePropertiesClass = StoreProperties.class;
    assertEquals(expectedStorePropertiesClass, actualStoreProperties.getStorePropertiesClass());
    Class<Schema> expectedSchemaClass = Schema.class;
    assertEquals(expectedSchemaClass, actualStoreProperties.getSchemaClass());
  }

  /**
   * Test {@link GraphSerialisable#getStoreProperties()}.
   * <ul>
   *   <li>Then return Properties size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link GraphSerialisable#getStoreProperties()}
   */
  @Test
  @DisplayName("Test getStoreProperties(); then return Properties size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"StoreProperties GraphSerialisable.getStoreProperties()"})
  void testGetStoreProperties_thenReturnPropertiesSizeIsOne() {
    // Arrange
    GraphConfig config = (new Builder()).description("The characteristics of someone or something").build();
    Schema schema = new Schema();

    // Act and Assert
    Properties properties = (new GraphSerialisable(config, schema, new StoreProperties())).getStoreProperties()
        .getProperties();
    assertEquals(1, properties.size());
    assertEquals("uk.gov.gchq.gaffer.store.StoreProperties", properties.get("gaffer.store.properties.class"));
  }

  /**
   * Test {@link GraphSerialisable#getConfig()}.
   * <ul>
   *   <li>Given {@link Builder} (default constructor) addHook {@link AddOperationsToChain} (default constructor).</li>
   *   <li>Then return Hooks size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link GraphSerialisable#getConfig()}
   */
  @Test
  @DisplayName("Test getConfig(); given Builder (default constructor) addHook AddOperationsToChain (default constructor); then return Hooks size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GraphConfig GraphSerialisable.getConfig()"})
  void testGetConfig_givenBuilderAddHookAddOperationsToChain_thenReturnHooksSizeIsTwo() {
    // Arrange
    Builder builder = new Builder();
    builder.addHook(new AddOperationsToChain());
    builder.addHook(new AddOperationsToChain());
    GraphConfig config = builder.description("The characteristics of someone or something").build();
    Schema schema = new Schema();

    // Act and Assert
    List<GraphHook> hooks = (new GraphSerialisable(config, schema, new Properties())).getConfig().getHooks();
    assertEquals(2, hooks.size());
    GraphHook getResult = hooks.get(1);
    assertTrue(getResult instanceof AddOperationsToChain);
    assertTrue(((AddOperationsToChain) getResult).getAuthorisedOps().isEmpty());
  }

  /**
   * Test {@link GraphSerialisable#getConfig()}.
   * <ul>
   *   <li>Given {@link Builder} (default constructor) graphId {@code 42}.</li>
   *   <li>Then return GraphId is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GraphSerialisable#getConfig()}
   */
  @Test
  @DisplayName("Test getConfig(); given Builder (default constructor) graphId '42'; then return GraphId is '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GraphConfig GraphSerialisable.getConfig()"})
  void testGetConfig_givenBuilderGraphId42_thenReturnGraphIdIs42() {
    // Arrange
    Builder builder = new Builder();
    builder.graphId("42");
    builder.addHook(new AddOperationsToChain());
    GraphConfig config = builder.description("The characteristics of someone or something").build();
    Schema schema = new Schema();

    // Act
    GraphConfig actualConfig = (new GraphSerialisable(config, schema, new Properties())).getConfig();

    // Assert
    List<GraphHook> hooks = actualConfig.getHooks();
    assertEquals(1, hooks.size());
    GraphHook getResult = hooks.get(0);
    assertTrue(getResult instanceof AddOperationsToChain);
    assertEquals("42", actualConfig.getGraphId());
    assertTrue(((AddOperationsToChain) getResult).getAuthorisedOps().isEmpty());
    List<Operation> end = ((AddOperationsToChain) getResult).getEnd();
    assertTrue(end.isEmpty());
    Map<String, List<Operation>> after = ((AddOperationsToChain) getResult).getAfter();
    assertTrue(after.isEmpty());
    assertSame(after, ((AddOperationsToChain) getResult).getBefore());
    assertSame(end, ((AddOperationsToChain) getResult).getStart());
  }

  /**
   * Test {@link GraphSerialisable#getConfig()}.
   * <ul>
   *   <li>Given {@link Builder} (default constructor) otelActive {@code true}.</li>
   *   <li>Then return OtelActive.</li>
   * </ul>
   * <p>
   * Method under test: {@link GraphSerialisable#getConfig()}
   */
  @Test
  @DisplayName("Test getConfig(); given Builder (default constructor) otelActive 'true'; then return OtelActive")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GraphConfig GraphSerialisable.getConfig()"})
  void testGetConfig_givenBuilderOtelActiveTrue_thenReturnOtelActive() {
    // Arrange
    Builder builder = new Builder();
    builder.otelActive(true);
    builder.addHook(new AddOperationsToChain());
    GraphConfig config = builder.description("The characteristics of someone or something").build();
    Schema schema = new Schema();

    // Act
    GraphConfig actualConfig = (new GraphSerialisable(config, schema, new Properties())).getConfig();

    // Assert
    List<GraphHook> hooks = actualConfig.getHooks();
    assertEquals(1, hooks.size());
    GraphHook getResult = hooks.get(0);
    assertTrue(getResult instanceof AddOperationsToChain);
    assertTrue(((AddOperationsToChain) getResult).getAuthorisedOps().isEmpty());
    List<Operation> end = ((AddOperationsToChain) getResult).getEnd();
    assertTrue(end.isEmpty());
    Map<String, List<Operation>> after = ((AddOperationsToChain) getResult).getAfter();
    assertTrue(after.isEmpty());
    assertTrue(actualConfig.getOtelActive());
    assertSame(after, ((AddOperationsToChain) getResult).getBefore());
    assertSame(end, ((AddOperationsToChain) getResult).getStart());
  }

  /**
   * Test {@link GraphSerialisable#getConfig()}.
   * <ul>
   *   <li>Given {@link Builder} (default constructor) view {@link View} (default constructor).</li>
   *   <li>Then return View is {@link View} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link GraphSerialisable#getConfig()}
   */
  @Test
  @DisplayName("Test getConfig(); given Builder (default constructor) view View (default constructor); then return View is View (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GraphConfig GraphSerialisable.getConfig()"})
  void testGetConfig_givenBuilderViewView_thenReturnViewIsView() {
    // Arrange
    Builder builder = new Builder();
    View view = new View();
    builder.view(view);
    builder.addHook(new AddOperationsToChain());
    GraphConfig config = builder.description("The characteristics of someone or something").build();
    Schema schema = new Schema();

    // Act and Assert
    assertEquals(view, (new GraphSerialisable(config, schema, new Properties())).getConfig().getView());
  }

  /**
   * Test {@link GraphSerialisable#getConfig()}.
   * <ul>
   *   <li>Then Hooks first return {@link AddOperationsToChain}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GraphSerialisable#getConfig()}
   */
  @Test
  @DisplayName("Test getConfig(); then Hooks first return AddOperationsToChain")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GraphConfig GraphSerialisable.getConfig()"})
  void testGetConfig_thenHooksFirstReturnAddOperationsToChain() {
    // Arrange
    Builder builder = new Builder();
    builder.addHook(new AddOperationsToChain());
    GraphConfig config = builder.description("The characteristics of someone or something").build();
    Schema schema = new Schema();

    // Act and Assert
    List<GraphHook> hooks = (new GraphSerialisable(config, schema, new Properties())).getConfig().getHooks();
    assertEquals(1, hooks.size());
    GraphHook getResult = hooks.get(0);
    assertTrue(getResult instanceof AddOperationsToChain);
    assertTrue(((AddOperationsToChain) getResult).getAuthorisedOps().isEmpty());
    List<Operation> end = ((AddOperationsToChain) getResult).getEnd();
    assertTrue(end.isEmpty());
    Map<String, List<Operation>> after = ((AddOperationsToChain) getResult).getAfter();
    assertTrue(after.isEmpty());
    assertSame(after, ((AddOperationsToChain) getResult).getBefore());
    assertSame(end, ((AddOperationsToChain) getResult).getStart());
  }

  /**
   * Test {@link GraphSerialisable#getConfig()}.
   * <ul>
   *   <li>Then Library return {@link FileGraphLibrary}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GraphSerialisable#getConfig()}
   */
  @Test
  @DisplayName("Test getConfig(); then Library return FileGraphLibrary")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GraphConfig GraphSerialisable.getConfig()"})
  void testGetConfig_thenLibraryReturnFileGraphLibrary() {
    // Arrange
    Builder builder = new Builder();
    builder.library(new FileGraphLibrary());
    builder.addHook(new AddOperationsToChain());
    GraphConfig config = builder.description("The characteristics of someone or something").build();
    Schema schema = new Schema();

    // Act
    GraphConfig actualConfig = (new GraphSerialisable(config, schema, new Properties())).getConfig();

    // Assert
    List<GraphHook> hooks = actualConfig.getHooks();
    assertEquals(1, hooks.size());
    GraphHook getResult = hooks.get(0);
    assertTrue(getResult instanceof AddOperationsToChain);
    GraphLibrary library = actualConfig.getLibrary();
    assertTrue(library instanceof FileGraphLibrary);
    assertEquals("graphLibrary", ((FileGraphLibrary) library).getPath());
    assertTrue(((AddOperationsToChain) getResult).getAuthorisedOps().isEmpty());
    List<Operation> end = ((AddOperationsToChain) getResult).getEnd();
    assertTrue(end.isEmpty());
    Map<String, List<Operation>> after = ((AddOperationsToChain) getResult).getAfter();
    assertTrue(after.isEmpty());
    assertSame(after, ((AddOperationsToChain) getResult).getBefore());
    assertSame(end, ((AddOperationsToChain) getResult).getStart());
  }

  /**
   * Test {@link GraphSerialisable#getConfig()}.
   * <ul>
   *   <li>Then return Hooks Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link GraphSerialisable#getConfig()}
   */
  @Test
  @DisplayName("Test getConfig(); then return Hooks Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GraphConfig GraphSerialisable.getConfig()"})
  void testGetConfig_thenReturnHooksEmpty() {
    // Arrange
    GraphConfig config = (new Builder()).description("The characteristics of someone or something").build();
    Schema schema = new Schema();

    // Act
    GraphConfig actualConfig = (new GraphSerialisable(config, schema, new Properties())).getConfig();

    // Assert
    assertTrue(actualConfig.getLibrary() instanceof NoGraphLibrary);
    assertNull(actualConfig.getOtelActive());
    assertNull(actualConfig.getGraphId());
    assertNull(actualConfig.getView());
    assertTrue(actualConfig.getHooks().isEmpty());
  }

  /**
   * Test {@link GraphSerialisable#getConfig()}.
   * <ul>
   *   <li>Then return Hooks first UnauthorisedFunctions Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link GraphSerialisable#getConfig()}
   */
  @Test
  @DisplayName("Test getConfig(); then return Hooks first UnauthorisedFunctions Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GraphConfig GraphSerialisable.getConfig()"})
  void testGetConfig_thenReturnHooksFirstUnauthorisedFunctionsEmpty() {
    // Arrange
    Builder builder = new Builder();
    builder.addHook(new FunctionAuthoriser(new ArrayList<>()));
    GraphConfig config = builder.description("The characteristics of someone or something").build();
    Schema schema = new Schema();

    // Act
    GraphConfig actualConfig = (new GraphSerialisable(config, schema, new Properties())).getConfig();

    // Assert
    List<GraphHook> hooks = actualConfig.getHooks();
    assertEquals(1, hooks.size());
    GraphHook getResult = hooks.get(0);
    assertTrue(getResult instanceof FunctionAuthoriser);
    assertTrue(actualConfig.getLibrary() instanceof NoGraphLibrary);
    assertNull(actualConfig.getOtelActive());
    assertNull(actualConfig.getGraphId());
    assertNull(actualConfig.getView());
    assertTrue(((FunctionAuthoriser) getResult).getUnauthorisedFunctions().isEmpty());
  }

  /**
   * Test {@link GraphSerialisable#getConfig()}.
   * <ul>
   *   <li>Then return Hooks first UnauthorisedFunctions is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GraphSerialisable#getConfig()}
   */
  @Test
  @DisplayName("Test getConfig(); then return Hooks first UnauthorisedFunctions is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GraphConfig GraphSerialisable.getConfig()"})
  void testGetConfig_thenReturnHooksFirstUnauthorisedFunctionsIsNull() {
    // Arrange
    Builder builder = new Builder();
    builder.addHook(new FunctionAuthoriser());
    GraphConfig config = builder.description("The characteristics of someone or something").build();
    Schema schema = new Schema();

    // Act
    GraphConfig actualConfig = (new GraphSerialisable(config, schema, new Properties())).getConfig();

    // Assert
    List<GraphHook> hooks = actualConfig.getHooks();
    assertEquals(1, hooks.size());
    GraphHook getResult = hooks.get(0);
    assertTrue(getResult instanceof FunctionAuthoriser);
    assertTrue(actualConfig.getLibrary() instanceof NoGraphLibrary);
    assertNull(actualConfig.getOtelActive());
    assertNull(actualConfig.getGraphId());
    assertNull(((FunctionAuthoriser) getResult).getUnauthorisedFunctions());
    assertNull(actualConfig.getView());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link GraphSerialisable#toString()}
   *   <li>{@link GraphSerialisable#getSerialisedConfig()}
   *   <li>{@link GraphSerialisable#getSerialisedProperties()}
   *   <li>{@link GraphSerialisable#getSerialisedSchema()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] GraphSerialisable.getSerialisedConfig()",
      "byte[] GraphSerialisable.getSerialisedProperties()", "byte[] GraphSerialisable.getSerialisedSchema()",
      "String GraphSerialisable.toString()"})
  void testGettersAndSetters() throws UnsupportedEncodingException {
    // Arrange
    GraphConfig config = (new Builder()).description("The characteristics of someone or something").build();
    Schema schema = new Schema();
    GraphSerialisable graphSerialisable = new GraphSerialisable(config, schema, new Properties());

    // Act
    graphSerialisable.toString();
    byte[] actualSerialisedConfig = graphSerialisable.getSerialisedConfig();
    byte[] actualSerialisedProperties = graphSerialisable.getSerialisedProperties();
    byte[] actualSerialisedSchema = graphSerialisable.getSerialisedSchema();

    // Assert
    assertEquals(169, actualSerialisedConfig.length);
    assertEquals(' ', actualSerialisedConfig[164]);
    assertEquals(' ', actualSerialisedConfig[165]);
    assertEquals(' ', actualSerialisedConfig[17]);
    assertEquals(' ', actualSerialisedConfig[19]);
    assertEquals(' ', actualSerialisedConfig[2]);
    assertEquals(' ', actualSerialisedConfig[24]);
    assertEquals(' ', actualSerialisedConfig[3]);
    assertEquals('.', actualSerialisedConfig[147]);
    assertEquals(':', actualSerialisedConfig[18]);
    assertEquals('G', actualSerialisedConfig[150]);
    assertEquals('L', actualSerialisedConfig[155]);
    assertEquals('N', actualSerialisedConfig[148]);
    assertEquals('T', actualSerialisedConfig[21]);
    assertEquals('"', actualSerialisedConfig[162]);
    assertEquals('"', actualSerialisedConfig[20]);
    assertEquals('"', actualSerialisedConfig[4]);
    assertEquals('"', actualSerialisedConfig[Short.SIZE]);
    assertEquals('\n', actualSerialisedConfig[1]);
    assertEquals('\n', actualSerialisedConfig[163]);
    assertEquals('\n', actualSerialisedConfig[167]);
    assertEquals('a', actualSerialisedConfig[144]);
    assertEquals('a', actualSerialisedConfig[152]);
    assertEquals('a', actualSerialisedConfig[159]);
    assertEquals('b', actualSerialisedConfig[157]);
    assertEquals('c', actualSerialisedConfig[8]);
    assertEquals('d', actualSerialisedConfig[5]);
    assertEquals('e', actualSerialisedConfig[23]);
    assertEquals('e', actualSerialisedConfig[6]);
    assertEquals('h', actualSerialisedConfig[154]);
    assertEquals('h', actualSerialisedConfig[22]);
    assertEquals('i', actualSerialisedConfig[10]);
    assertEquals('i', actualSerialisedConfig[13]);
    assertEquals('i', actualSerialisedConfig[156]);
    assertEquals('n', actualSerialisedConfig[15]);
    assertEquals('o', actualSerialisedConfig[14]);
    assertEquals('o', actualSerialisedConfig[149]);
    assertEquals('p', actualSerialisedConfig[11]);
    assertEquals('p', actualSerialisedConfig[153]);
    assertEquals('r', actualSerialisedConfig[145]);
    assertEquals('r', actualSerialisedConfig[151]);
    assertEquals('r', actualSerialisedConfig[158]);
    assertEquals('r', actualSerialisedConfig[160]);
    assertEquals('r', actualSerialisedConfig[9]);
    assertEquals('s', actualSerialisedConfig[7]);
    assertEquals('t', actualSerialisedConfig[12]);
    assertEquals('y', actualSerialisedConfig[146]);
    assertEquals('y', actualSerialisedConfig[161]);
    assertEquals('{', actualSerialisedConfig[0]);
    assertEquals('}', actualSerialisedConfig[166]);
    assertEquals('}', actualSerialisedConfig[168]);
    assertArrayEquals("{ }".getBytes("UTF-8"), actualSerialisedProperties);
    assertArrayEquals("{\n  \"types\" : { }\n}".getBytes("UTF-8"), actualSerialisedSchema);
  }
}
