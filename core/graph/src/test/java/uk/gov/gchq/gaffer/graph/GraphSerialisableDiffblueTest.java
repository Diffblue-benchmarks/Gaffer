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
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Properties;
import java.util.function.BiFunction;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.elementdefinition.view.NamedView;
import uk.gov.gchq.gaffer.data.elementdefinition.view.View;
import uk.gov.gchq.gaffer.graph.hook.AddOperationsToChain;
import uk.gov.gchq.gaffer.graph.hook.UpdateViewHook;
import uk.gov.gchq.gaffer.store.StoreProperties;
import uk.gov.gchq.gaffer.store.library.GraphLibrary;
import uk.gov.gchq.gaffer.store.schema.Schema;

class GraphSerialisableDiffblueTest {
  /**
   * Method under test: {@link GraphSerialisable.Builder#config(GraphConfig)}
   */
  @Test
  void testBuilderConfig() throws UnsupportedEncodingException {
    // Arrange
    GraphSerialisable.Builder builder = new GraphSerialisable.Builder();

    // Act
    GraphSerialisable.Builder actualConfigResult = builder.config(new GraphConfig("42"));

    // Assert
    GraphSerialisable buildResult = builder.build();
    assertNull(buildResult.getSerialisedProperties());
    assertNull(buildResult.getSerialisedSchema());
    assertNull(buildResult.getStoreProperties());
    assertNull(buildResult.getSchema());
    assertSame(builder, actualConfigResult);
    byte[] expectedSerialisedConfig = "{\n  \"graphId\" : \"42\",\n  \"hooks\" : [ ]\n}".getBytes("UTF-8");
    assertArrayEquals(expectedSerialisedConfig, buildResult.getSerialisedConfig());
  }

  /**
   * Method under test: {@link GraphSerialisable.Builder#config(GraphConfig)}
   */
  @Test
  void testBuilderConfig2() throws UnsupportedEncodingException {
    // Arrange
    Properties properties = new Properties();
    properties.replaceAll(mock(BiFunction.class));

    GraphSerialisable.Builder builder = new GraphSerialisable.Builder();
    builder.properties(properties);

    // Act
    GraphSerialisable.Builder actualConfigResult = builder.config(new GraphConfig("42"));

    // Assert
    GraphSerialisable buildResult = builder.build();
    StoreProperties storeProperties = buildResult.getStoreProperties();
    assertEquals("", storeProperties.getAdminAuth());
    assertEquals("", storeProperties.getJsonSerialiserModules());
    assertEquals("uk.gov.gchq.gaffer.store.StoreProperties", storeProperties.getStorePropertiesClassName());
    assertEquals("uk.gov.gchq.gaffer.store.schema.Schema", storeProperties.getSchemaClassName());
    assertNull(buildResult.getSerialisedSchema());
    assertNull(storeProperties.getStrictJson());
    assertNull(storeProperties.getCacheServiceClass());
    assertNull(storeProperties.getDefaultCacheServiceClass());
    assertNull(storeProperties.getJobTrackerCacheServiceClass());
    assertNull(storeProperties.getJsonSerialiserClass());
    assertNull(storeProperties.getNamedOperationCacheServiceClass());
    assertNull(storeProperties.getNamedViewCacheServiceClass());
    assertNull(storeProperties.getOperationDeclarationPaths());
    assertNull(storeProperties.getReflectionPackages());
    assertNull(storeProperties.getStoreClass());
    assertNull(buildResult.getSchema());
    assertEquals(50, storeProperties.getJobExecutorThreadCount().intValue());
    assertFalse(storeProperties.getJobTrackerEnabled());
    assertFalse(storeProperties.getRescheduleJobsOnStart());
    assertTrue(storeProperties.getProperties().isEmpty());
    assertTrue(storeProperties.getOperationDeclarations().getOperations().isEmpty());
    assertTrue(storeProperties.getNamedOperationEnabled());
    assertTrue(storeProperties.getNamedViewEnabled());
    assertSame(builder, actualConfigResult);
    byte[] expectedSerialisedProperties = "{ }".getBytes("UTF-8");
    assertArrayEquals(expectedSerialisedProperties, buildResult.getSerialisedProperties());
    byte[] expectedSerialisedConfig = "{\n  \"graphId\" : \"42\",\n  \"hooks\" : [ ]\n}".getBytes("UTF-8");
    assertArrayEquals(expectedSerialisedConfig, buildResult.getSerialisedConfig());
  }

  /**
   * Method under test: {@link GraphSerialisable.Builder#properties(InputStream)}
   */
  @Test
  void testBuilderProperties() throws IOException {
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
   * Method under test: {@link GraphSerialisable.Builder#properties(InputStream)}
   */
  @Test
  void testBuilderProperties2() {
    // Arrange
    GraphSerialisable.Builder builder = new GraphSerialisable.Builder();

    // Act and Assert
    assertSame(builder, builder.properties((InputStream) null));
  }

  /**
   * Method under test: {@link GraphSerialisable.Builder#properties(Properties)}
   */
  @Test
  void testBuilderProperties3() {
    // Arrange
    GraphSerialisable.Builder builder = new GraphSerialisable.Builder();

    // Act and Assert
    assertSame(builder, builder.properties(new Properties()));
  }

  /**
   * Method under test:
   * {@link GraphSerialisable.Builder#properties(StoreProperties)}
   */
  @Test
  void testBuilderProperties4() {
    // Arrange
    GraphSerialisable.Builder builder = new GraphSerialisable.Builder();

    // Act and Assert
    assertSame(builder, builder.properties(new StoreProperties()));
  }

  /**
   * Method under test: {@link GraphSerialisable.Builder#schema(Schema)}
   */
  @Test
  void testBuilderSchema() {
    // Arrange
    GraphSerialisable.Builder builder = new GraphSerialisable.Builder();

    // Act and Assert
    assertSame(builder, builder.schema(new Schema()));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link GraphSerialisable#equals(Object)}
   *   <li>{@link GraphSerialisable#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    GraphConfig config = new GraphConfig("42");
    Schema schema = new Schema();
    GraphSerialisable graphSerialisable = new GraphSerialisable(config, schema, new Properties());
    GraphConfig config2 = new GraphConfig("42");
    Schema schema2 = new Schema();
    GraphSerialisable graphSerialisable2 = new GraphSerialisable(config2, schema2, new Properties());

    // Act and Assert
    assertEquals(graphSerialisable, graphSerialisable2);
    int expectedHashCodeResult = graphSerialisable.hashCode();
    assertEquals(expectedHashCodeResult, graphSerialisable2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link GraphSerialisable#equals(Object)}
   *   <li>{@link GraphSerialisable#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    GraphConfig config = new GraphConfig("42");
    Schema schema = new Schema();
    GraphSerialisable graphSerialisable = new GraphSerialisable(config, schema, new Properties());

    // Act and Assert
    assertEquals(graphSerialisable, graphSerialisable);
    int expectedHashCodeResult = graphSerialisable.hashCode();
    assertEquals(expectedHashCodeResult, graphSerialisable.hashCode());
  }

  /**
   * Method under test: {@link GraphSerialisable#getStoreProperties()}
   */
  @Test
  void testGetStoreProperties() {
    // Arrange
    GraphConfig config = new GraphConfig("42");
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
    assertTrue(actualStoreProperties.getOperationDeclarations().getOperations().isEmpty());
    assertTrue(actualStoreProperties.getNamedOperationEnabled());
    assertTrue(actualStoreProperties.getNamedViewEnabled());
    Class<StoreProperties> expectedStorePropertiesClass = StoreProperties.class;
    assertEquals(expectedStorePropertiesClass, actualStoreProperties.getStorePropertiesClass());
    Class<Schema> expectedSchemaClass = Schema.class;
    assertEquals(expectedSchemaClass, actualStoreProperties.getSchemaClass());
  }

  /**
   * Method under test: {@link GraphSerialisable#getStoreProperties()}
   */
  @Test
  void testGetStoreProperties2() {
    // Arrange
    GraphConfig config = new GraphConfig("42");
    Schema schema = new Schema();
    StoreProperties storeProperties = new StoreProperties();

    // Act and Assert
    assertEquals(storeProperties, (new GraphSerialisable(config, schema, storeProperties)).getStoreProperties());
  }

  /**
   * Method under test: {@link GraphSerialisable#getStoreProperties()}
   */
  @Test
  void testGetStoreProperties3() {
    // Arrange
    Properties properties = new Properties();
    properties.replaceAll(mock(BiFunction.class));
    GraphConfig config = new GraphConfig("42");

    // Act
    StoreProperties actualStoreProperties = (new GraphSerialisable(config, new Schema(), properties))
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
    assertTrue(actualStoreProperties.getOperationDeclarations().getOperations().isEmpty());
    assertTrue(actualStoreProperties.getNamedOperationEnabled());
    assertTrue(actualStoreProperties.getNamedViewEnabled());
    Class<StoreProperties> expectedStorePropertiesClass = StoreProperties.class;
    assertEquals(expectedStorePropertiesClass, actualStoreProperties.getStorePropertiesClass());
    Class<Schema> expectedSchemaClass = Schema.class;
    assertEquals(expectedSchemaClass, actualStoreProperties.getSchemaClass());
  }

  /**
   * Method under test: {@link GraphSerialisable#getStoreProperties(GraphLibrary)}
   */
  @Test
  void testGetStoreProperties4() {
    // Arrange
    GraphConfig config = new GraphConfig("42");
    Schema schema = new Schema();

    // Act
    StoreProperties actualStoreProperties = (new GraphSerialisable(config, schema, new Properties()))
        .getStoreProperties(null);

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
    assertTrue(actualStoreProperties.getOperationDeclarations().getOperations().isEmpty());
    assertTrue(actualStoreProperties.getNamedOperationEnabled());
    assertTrue(actualStoreProperties.getNamedViewEnabled());
    Class<StoreProperties> expectedStorePropertiesClass = StoreProperties.class;
    assertEquals(expectedStorePropertiesClass, actualStoreProperties.getStorePropertiesClass());
    Class<Schema> expectedSchemaClass = Schema.class;
    assertEquals(expectedSchemaClass, actualStoreProperties.getSchemaClass());
  }

  /**
   * Method under test: {@link GraphSerialisable#getStoreProperties(GraphLibrary)}
   */
  @Test
  void testGetStoreProperties5() {
    // Arrange
    GraphConfig config = new GraphConfig("42");
    Schema schema = new Schema();
    StoreProperties storeProperties = new StoreProperties();

    // Act and Assert
    assertEquals(storeProperties, (new GraphSerialisable(config, schema, storeProperties)).getStoreProperties(null));
  }

  /**
   * Method under test: {@link GraphSerialisable#getStoreProperties(GraphLibrary)}
   */
  @Test
  void testGetStoreProperties6() {
    // Arrange
    Properties properties = new Properties();
    properties.replaceAll(mock(BiFunction.class));
    GraphConfig config = new GraphConfig("42");

    // Act
    StoreProperties actualStoreProperties = (new GraphSerialisable(config, new Schema(), properties))
        .getStoreProperties(null);

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
    assertTrue(actualStoreProperties.getOperationDeclarations().getOperations().isEmpty());
    assertTrue(actualStoreProperties.getNamedOperationEnabled());
    assertTrue(actualStoreProperties.getNamedViewEnabled());
    Class<StoreProperties> expectedStorePropertiesClass = StoreProperties.class;
    assertEquals(expectedStorePropertiesClass, actualStoreProperties.getStorePropertiesClass());
    Class<Schema> expectedSchemaClass = Schema.class;
    assertEquals(expectedSchemaClass, actualStoreProperties.getSchemaClass());
  }

  /**
   * Method under test: {@link GraphSerialisable#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    GraphConfig config = new GraphConfig("Graph Id");
    Schema schema = new Schema();
    GraphSerialisable graphSerialisable = new GraphSerialisable(config, schema, new Properties());
    GraphConfig config2 = new GraphConfig("42");
    Schema schema2 = new Schema();

    // Act and Assert
    assertNotEquals(graphSerialisable, new GraphSerialisable(config2, schema2, new Properties()));
  }

  /**
   * Method under test: {@link GraphSerialisable#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    GraphConfig config = new GraphConfig("42");
    Schema schema = new Schema();

    // Act and Assert
    assertNotEquals(new GraphSerialisable(config, schema, new Properties()), null);
  }

  /**
   * Method under test: {@link GraphSerialisable#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    GraphConfig config = new GraphConfig("42");
    Schema schema = new Schema();

    // Act and Assert
    assertNotEquals(new GraphSerialisable(config, schema, new Properties()), "Different type to GraphSerialisable");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link GraphSerialisable#getSerialisedConfig()}
   *   <li>{@link GraphSerialisable#getSerialisedProperties()}
   *   <li>{@link GraphSerialisable#getSerialisedSchema()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() throws UnsupportedEncodingException {
    // Arrange
    GraphConfig config = new GraphConfig("42");
    Schema schema = new Schema();
    GraphSerialisable graphSerialisable = new GraphSerialisable(config, schema, new Properties());

    // Act
    byte[] actualSerialisedConfig = graphSerialisable.getSerialisedConfig();
    byte[] actualSerialisedProperties = graphSerialisable.getSerialisedProperties();
    byte[] actualSerialisedSchema = graphSerialisable.getSerialisedSchema();

    // Assert
    assertArrayEquals("{ }".getBytes("UTF-8"), actualSerialisedProperties);
    assertArrayEquals("{\n  \"graphId\" : \"42\",\n  \"hooks\" : [ ]\n}".getBytes("UTF-8"), actualSerialisedConfig);
    assertArrayEquals("{\n  \"types\" : { }\n}".getBytes("UTF-8"), actualSerialisedSchema);
  }

  /**
   * Method under test:
   * {@link GraphSerialisable#GraphSerialisable(GraphConfig, Schema, Properties)}
   */
  @Test
  void testNewGraphSerialisable() throws UnsupportedEncodingException {
    // Arrange
    GraphConfig config = new GraphConfig("42");
    Schema schema = new Schema();

    // Act
    GraphSerialisable actualGraphSerialisable = new GraphSerialisable(config, schema, new Properties());

    // Assert
    StoreProperties storeProperties = actualGraphSerialisable.getStoreProperties();
    assertEquals("", storeProperties.getAdminAuth());
    assertEquals("", storeProperties.getJsonSerialiserModules());
    assertEquals("uk.gov.gchq.gaffer.store.StoreProperties", storeProperties.getStorePropertiesClassName());
    assertEquals("uk.gov.gchq.gaffer.store.schema.Schema", storeProperties.getSchemaClassName());
    assertNull(storeProperties.getStrictJson());
    assertNull(storeProperties.getCacheServiceClass());
    assertNull(storeProperties.getDefaultCacheServiceClass());
    assertNull(storeProperties.getJobTrackerCacheServiceClass());
    assertNull(storeProperties.getJsonSerialiserClass());
    assertNull(storeProperties.getNamedOperationCacheServiceClass());
    assertNull(storeProperties.getNamedViewCacheServiceClass());
    assertNull(storeProperties.getOperationDeclarationPaths());
    assertNull(storeProperties.getReflectionPackages());
    assertNull(storeProperties.getStoreClass());
    assertEquals(50, storeProperties.getJobExecutorThreadCount().intValue());
    assertFalse(storeProperties.getJobTrackerEnabled());
    assertFalse(storeProperties.getRescheduleJobsOnStart());
    assertTrue(storeProperties.getProperties().isEmpty());
    assertTrue(storeProperties.getOperationDeclarations().getOperations().isEmpty());
    assertTrue(storeProperties.getNamedOperationEnabled());
    assertTrue(storeProperties.getNamedViewEnabled());
    Class<StoreProperties> expectedStorePropertiesClass = StoreProperties.class;
    assertEquals(expectedStorePropertiesClass, storeProperties.getStorePropertiesClass());
    Class<Schema> expectedSchemaClass = Schema.class;
    assertEquals(expectedSchemaClass, storeProperties.getSchemaClass());
    byte[] expectedSerialisedProperties = "{ }".getBytes("UTF-8");
    assertArrayEquals(expectedSerialisedProperties, actualGraphSerialisable.getSerialisedProperties());
    byte[] expectedSerialisedConfig = "{\n  \"graphId\" : \"42\",\n  \"hooks\" : [ ]\n}".getBytes("UTF-8");
    assertArrayEquals(expectedSerialisedConfig, actualGraphSerialisable.getSerialisedConfig());
    byte[] expectedSerialisedSchema = "{\n  \"types\" : { }\n}".getBytes("UTF-8");
    assertArrayEquals(expectedSerialisedSchema, actualGraphSerialisable.getSerialisedSchema());
  }

  /**
   * Method under test:
   * {@link GraphSerialisable#GraphSerialisable(GraphConfig, Schema, Properties)}
   */
  @Test
  void testNewGraphSerialisable2() throws UnsupportedEncodingException {
    // Arrange
    Schema schema = new Schema();

    // Act
    GraphSerialisable actualGraphSerialisable = new GraphSerialisable(null, schema, new Properties());

    // Assert
    StoreProperties storeProperties = actualGraphSerialisable.getStoreProperties();
    assertEquals("", storeProperties.getAdminAuth());
    assertEquals("", storeProperties.getJsonSerialiserModules());
    assertEquals("uk.gov.gchq.gaffer.store.StoreProperties", storeProperties.getStorePropertiesClassName());
    assertEquals("uk.gov.gchq.gaffer.store.schema.Schema", storeProperties.getSchemaClassName());
    assertNull(actualGraphSerialisable.getSerialisedConfig());
    assertNull(storeProperties.getStrictJson());
    assertNull(actualGraphSerialisable.getGraphId());
    assertNull(storeProperties.getCacheServiceClass());
    assertNull(storeProperties.getDefaultCacheServiceClass());
    assertNull(storeProperties.getJobTrackerCacheServiceClass());
    assertNull(storeProperties.getJsonSerialiserClass());
    assertNull(storeProperties.getNamedOperationCacheServiceClass());
    assertNull(storeProperties.getNamedViewCacheServiceClass());
    assertNull(storeProperties.getOperationDeclarationPaths());
    assertNull(storeProperties.getReflectionPackages());
    assertNull(storeProperties.getStoreClass());
    assertNull(actualGraphSerialisable.getConfig());
    assertEquals(50, storeProperties.getJobExecutorThreadCount().intValue());
    assertFalse(storeProperties.getJobTrackerEnabled());
    assertFalse(storeProperties.getRescheduleJobsOnStart());
    assertTrue(storeProperties.getProperties().isEmpty());
    assertTrue(storeProperties.getOperationDeclarations().getOperations().isEmpty());
    assertTrue(storeProperties.getNamedOperationEnabled());
    assertTrue(storeProperties.getNamedViewEnabled());
    Class<StoreProperties> expectedStorePropertiesClass = StoreProperties.class;
    assertEquals(expectedStorePropertiesClass, storeProperties.getStorePropertiesClass());
    Class<Schema> expectedSchemaClass = Schema.class;
    assertEquals(expectedSchemaClass, storeProperties.getSchemaClass());
    byte[] expectedSerialisedProperties = "{ }".getBytes("UTF-8");
    assertArrayEquals(expectedSerialisedProperties, actualGraphSerialisable.getSerialisedProperties());
    byte[] expectedSerialisedSchema = "{\n  \"types\" : { }\n}".getBytes("UTF-8");
    assertArrayEquals(expectedSerialisedSchema, actualGraphSerialisable.getSerialisedSchema());
  }

  /**
   * Method under test:
   * {@link GraphSerialisable#GraphSerialisable(GraphConfig, Schema, Properties)}
   */
  @Test
  void testNewGraphSerialisable3() throws UnsupportedEncodingException {
    // Arrange
    GraphConfig config = new GraphConfig("42");
    config.addHook(new AddOperationsToChain());
    Schema schema = new Schema();

    // Act
    GraphSerialisable actualGraphSerialisable = new GraphSerialisable(config, schema, new Properties());

    // Assert
    StoreProperties storeProperties = actualGraphSerialisable.getStoreProperties();
    assertEquals("", storeProperties.getAdminAuth());
    assertEquals("", storeProperties.getJsonSerialiserModules());
    assertEquals("uk.gov.gchq.gaffer.store.StoreProperties", storeProperties.getStorePropertiesClassName());
    assertEquals("uk.gov.gchq.gaffer.store.schema.Schema", storeProperties.getSchemaClassName());
    assertNull(storeProperties.getStrictJson());
    assertNull(storeProperties.getCacheServiceClass());
    assertNull(storeProperties.getDefaultCacheServiceClass());
    assertNull(storeProperties.getJobTrackerCacheServiceClass());
    assertNull(storeProperties.getJsonSerialiserClass());
    assertNull(storeProperties.getNamedOperationCacheServiceClass());
    assertNull(storeProperties.getNamedViewCacheServiceClass());
    assertNull(storeProperties.getOperationDeclarationPaths());
    assertNull(storeProperties.getReflectionPackages());
    assertNull(storeProperties.getStoreClass());
    byte[] serialisedConfig = actualGraphSerialisable.getSerialisedConfig();
    assertEquals(214, serialisedConfig.length);
    assertEquals(50, storeProperties.getJobExecutorThreadCount().intValue());
    assertFalse(storeProperties.getJobTrackerEnabled());
    assertFalse(storeProperties.getRescheduleJobsOnStart());
    assertTrue(storeProperties.getProperties().isEmpty());
    assertTrue(storeProperties.getOperationDeclarations().getOperations().isEmpty());
    assertTrue(storeProperties.getNamedOperationEnabled());
    assertTrue(storeProperties.getNamedViewEnabled());
    Class<StoreProperties> expectedStorePropertiesClass = StoreProperties.class;
    assertEquals(expectedStorePropertiesClass, storeProperties.getStorePropertiesClass());
    Class<Schema> expectedSchemaClass = Schema.class;
    assertEquals(expectedSchemaClass, storeProperties.getSchemaClass());
    assertEquals(' ', serialisedConfig[13]);
    assertEquals(' ', serialisedConfig[15]);
    assertEquals(' ', serialisedConfig[2]);
    assertEquals(' ', serialisedConfig[200]);
    assertEquals(' ', serialisedConfig[202]);
    assertEquals(' ', serialisedConfig[204]);
    assertEquals(' ', serialisedConfig[207]);
    assertEquals(' ', serialisedConfig[208]);
    assertEquals(' ', serialisedConfig[210]);
    assertEquals(' ', serialisedConfig[22]);
    assertEquals(' ', serialisedConfig[23]);
    assertEquals(' ', serialisedConfig[3]);
    assertEquals(',', serialisedConfig[20]);
    assertEquals('2', serialisedConfig[18]);
    assertEquals('4', serialisedConfig[17]);
    assertEquals(':', serialisedConfig[14]);
    assertEquals(':', serialisedConfig[201]);
    assertEquals('I', serialisedConfig[10]);
    assertEquals('O', serialisedConfig[196]);
    assertEquals('"', serialisedConfig[12]);
    assertEquals('"', serialisedConfig[19]);
    assertEquals('"', serialisedConfig[199]);
    assertEquals('"', serialisedConfig[24]);
    assertEquals('"', serialisedConfig[4]);
    assertEquals('"', serialisedConfig[Short.SIZE]);
    assertEquals('\n', serialisedConfig[1]);
    assertEquals('\n', serialisedConfig[206]);
    assertEquals('\n', serialisedConfig[21]);
    assertEquals('\n', serialisedConfig[212]);
    assertEquals(']', serialisedConfig[211]);
    assertEquals('a', serialisedConfig[7]);
    assertEquals('d', serialisedConfig[11]);
    assertEquals('d', serialisedConfig[195]);
    assertEquals('e', serialisedConfig[194]);
    assertEquals('g', serialisedConfig[5]);
    assertEquals('h', serialisedConfig[189]);
    assertEquals('h', serialisedConfig[9]);
    assertEquals('i', serialisedConfig[192]);
    assertEquals('o', serialisedConfig[190]);
    assertEquals('p', serialisedConfig[197]);
    assertEquals('p', serialisedConfig[8]);
    assertEquals('r', serialisedConfig[191]);
    assertEquals('r', serialisedConfig[6]);
    assertEquals('s', serialisedConfig[193]);
    assertEquals('s', serialisedConfig[198]);
    assertEquals('{', serialisedConfig[0]);
    assertEquals('{', serialisedConfig[203]);
    assertEquals('}', serialisedConfig[205]);
    assertEquals('}', serialisedConfig[209]);
    assertEquals('}', serialisedConfig[213]);
    byte[] expectedSerialisedProperties = "{ }".getBytes("UTF-8");
    assertArrayEquals(expectedSerialisedProperties, actualGraphSerialisable.getSerialisedProperties());
    byte[] expectedSerialisedSchema = "{\n  \"types\" : { }\n}".getBytes("UTF-8");
    assertArrayEquals(expectedSerialisedSchema, actualGraphSerialisable.getSerialisedSchema());
  }

  /**
   * Method under test:
   * {@link GraphSerialisable#GraphSerialisable(GraphConfig, Schema, Properties)}
   */
  @Test
  void testNewGraphSerialisable4() throws UnsupportedEncodingException {
    // Arrange
    GraphConfig config = new GraphConfig("42");
    config.setView(new View());
    config.addHook(new AddOperationsToChain());
    Schema schema = new Schema();

    // Act
    GraphSerialisable actualGraphSerialisable = new GraphSerialisable(config, schema, new Properties());

    // Assert
    StoreProperties storeProperties = actualGraphSerialisable.getStoreProperties();
    assertEquals("", storeProperties.getAdminAuth());
    assertEquals("", storeProperties.getJsonSerialiserModules());
    assertEquals("uk.gov.gchq.gaffer.store.StoreProperties", storeProperties.getStorePropertiesClassName());
    assertEquals("uk.gov.gchq.gaffer.store.schema.Schema", storeProperties.getSchemaClassName());
    assertNull(storeProperties.getStrictJson());
    assertNull(storeProperties.getCacheServiceClass());
    assertNull(storeProperties.getDefaultCacheServiceClass());
    assertNull(storeProperties.getJobTrackerCacheServiceClass());
    assertNull(storeProperties.getJsonSerialiserClass());
    assertNull(storeProperties.getNamedOperationCacheServiceClass());
    assertNull(storeProperties.getNamedViewCacheServiceClass());
    assertNull(storeProperties.getOperationDeclarationPaths());
    assertNull(storeProperties.getReflectionPackages());
    assertNull(storeProperties.getStoreClass());
    byte[] serialisedConfig = actualGraphSerialisable.getSerialisedConfig();
    assertEquals(230, serialisedConfig.length);
    assertEquals(50, storeProperties.getJobExecutorThreadCount().intValue());
    assertFalse(storeProperties.getJobTrackerEnabled());
    assertFalse(storeProperties.getRescheduleJobsOnStart());
    assertTrue(storeProperties.getProperties().isEmpty());
    assertTrue(storeProperties.getOperationDeclarations().getOperations().isEmpty());
    assertTrue(storeProperties.getNamedOperationEnabled());
    assertTrue(storeProperties.getNamedViewEnabled());
    Class<StoreProperties> expectedStorePropertiesClass = StoreProperties.class;
    assertEquals(expectedStorePropertiesClass, storeProperties.getStorePropertiesClass());
    Class<Schema> expectedSchemaClass = Schema.class;
    assertEquals(expectedSchemaClass, storeProperties.getSchemaClass());
    assertEquals(' ', serialisedConfig[13]);
    assertEquals(' ', serialisedConfig[15]);
    assertEquals(' ', serialisedConfig[2]);
    assertEquals(' ', serialisedConfig[207]);
    assertEquals(' ', serialisedConfig[208]);
    assertEquals(' ', serialisedConfig[210]);
    assertEquals(' ', serialisedConfig[214]);
    assertEquals(' ', serialisedConfig[215]);
    assertEquals(' ', serialisedConfig[22]);
    assertEquals(' ', serialisedConfig[222]);
    assertEquals(' ', serialisedConfig[224]);
    assertEquals(' ', serialisedConfig[226]);
    assertEquals(' ', serialisedConfig[23]);
    assertEquals(' ', serialisedConfig[3]);
    assertEquals(',', serialisedConfig[20]);
    assertEquals(',', serialisedConfig[212]);
    assertEquals('2', serialisedConfig[18]);
    assertEquals('4', serialisedConfig[17]);
    assertEquals(':', serialisedConfig[14]);
    assertEquals(':', serialisedConfig[223]);
    assertEquals('I', serialisedConfig[10]);
    assertEquals('"', serialisedConfig[12]);
    assertEquals('"', serialisedConfig[19]);
    assertEquals('"', serialisedConfig[216]);
    assertEquals('"', serialisedConfig[221]);
    assertEquals('"', serialisedConfig[24]);
    assertEquals('"', serialisedConfig[4]);
    assertEquals('"', serialisedConfig[Short.SIZE]);
    assertEquals('\n', serialisedConfig[1]);
    assertEquals('\n', serialisedConfig[206]);
    assertEquals('\n', serialisedConfig[21]);
    assertEquals('\n', serialisedConfig[213]);
    assertEquals('\n', serialisedConfig[228]);
    assertEquals(']', serialisedConfig[211]);
    assertEquals('a', serialisedConfig[7]);
    assertEquals('d', serialisedConfig[11]);
    assertEquals('e', serialisedConfig[219]);
    assertEquals('g', serialisedConfig[5]);
    assertEquals('h', serialisedConfig[9]);
    assertEquals('i', serialisedConfig[218]);
    assertEquals('p', serialisedConfig[8]);
    assertEquals('r', serialisedConfig[6]);
    assertEquals('v', serialisedConfig[217]);
    assertEquals('w', serialisedConfig[220]);
    assertEquals('{', serialisedConfig[0]);
    assertEquals('{', serialisedConfig[225]);
    assertEquals('}', serialisedConfig[205]);
    assertEquals('}', serialisedConfig[209]);
    assertEquals('}', serialisedConfig[227]);
    assertEquals('}', serialisedConfig[229]);
    byte[] expectedSerialisedProperties = "{ }".getBytes("UTF-8");
    assertArrayEquals(expectedSerialisedProperties, actualGraphSerialisable.getSerialisedProperties());
    byte[] expectedSerialisedSchema = "{\n  \"types\" : { }\n}".getBytes("UTF-8");
    assertArrayEquals(expectedSerialisedSchema, actualGraphSerialisable.getSerialisedSchema());
  }

  /**
   * Method under test:
   * {@link GraphSerialisable#GraphSerialisable(GraphConfig, Schema, Properties)}
   */
  @Test
  void testNewGraphSerialisable5() throws UnsupportedEncodingException {
    // Arrange
    GraphConfig config = new GraphConfig("42");

    // Act
    GraphSerialisable actualGraphSerialisable = new GraphSerialisable(config, null, new Properties());

    // Assert
    StoreProperties storeProperties = actualGraphSerialisable.getStoreProperties();
    assertEquals("", storeProperties.getAdminAuth());
    assertEquals("", storeProperties.getJsonSerialiserModules());
    assertEquals("uk.gov.gchq.gaffer.store.StoreProperties", storeProperties.getStorePropertiesClassName());
    assertEquals("uk.gov.gchq.gaffer.store.schema.Schema", storeProperties.getSchemaClassName());
    assertNull(actualGraphSerialisable.getSerialisedSchema());
    assertNull(storeProperties.getStrictJson());
    assertNull(storeProperties.getCacheServiceClass());
    assertNull(storeProperties.getDefaultCacheServiceClass());
    assertNull(storeProperties.getJobTrackerCacheServiceClass());
    assertNull(storeProperties.getJsonSerialiserClass());
    assertNull(storeProperties.getNamedOperationCacheServiceClass());
    assertNull(storeProperties.getNamedViewCacheServiceClass());
    assertNull(storeProperties.getOperationDeclarationPaths());
    assertNull(storeProperties.getReflectionPackages());
    assertNull(storeProperties.getStoreClass());
    assertNull(actualGraphSerialisable.getSchema());
    assertEquals(50, storeProperties.getJobExecutorThreadCount().intValue());
    assertFalse(storeProperties.getJobTrackerEnabled());
    assertFalse(storeProperties.getRescheduleJobsOnStart());
    assertTrue(storeProperties.getProperties().isEmpty());
    assertTrue(storeProperties.getOperationDeclarations().getOperations().isEmpty());
    assertTrue(storeProperties.getNamedOperationEnabled());
    assertTrue(storeProperties.getNamedViewEnabled());
    Class<StoreProperties> expectedStorePropertiesClass = StoreProperties.class;
    assertEquals(expectedStorePropertiesClass, storeProperties.getStorePropertiesClass());
    Class<Schema> expectedSchemaClass = Schema.class;
    assertEquals(expectedSchemaClass, storeProperties.getSchemaClass());
    byte[] expectedSerialisedProperties = "{ }".getBytes("UTF-8");
    assertArrayEquals(expectedSerialisedProperties, actualGraphSerialisable.getSerialisedProperties());
    byte[] expectedSerialisedConfig = "{\n  \"graphId\" : \"42\",\n  \"hooks\" : [ ]\n}".getBytes("UTF-8");
    assertArrayEquals(expectedSerialisedConfig, actualGraphSerialisable.getSerialisedConfig());
  }

  /**
   * Method under test:
   * {@link GraphSerialisable#GraphSerialisable(GraphConfig, Schema, StoreProperties)}
   */
  @Test
  void testNewGraphSerialisable6() throws UnsupportedEncodingException {
    // Arrange
    GraphConfig config = new GraphConfig("42");
    Schema schema = new Schema();
    StoreProperties storeProperties = new StoreProperties();

    // Act
    GraphSerialisable actualGraphSerialisable = new GraphSerialisable(config, schema, storeProperties);

    // Assert
    byte[] serialisedProperties = actualGraphSerialisable.getSerialisedProperties();
    assertEquals(82, serialisedProperties.length);
    assertEquals(storeProperties, actualGraphSerialisable.getStoreProperties());
    assertEquals(' ', serialisedProperties[2]);
    assertEquals(' ', serialisedProperties[3]);
    assertEquals('.', serialisedProperties[11]);
    assertEquals('.', serialisedProperties[17]);
    assertEquals('.', serialisedProperties[57]);
    assertEquals('.', serialisedProperties[63]);
    assertEquals('P', serialisedProperties[69]);
    assertEquals('S', serialisedProperties[Double.SIZE]);
    assertEquals('"', serialisedProperties[4]);
    assertEquals('"', serialisedProperties[79]);
    assertEquals('\n', serialisedProperties[1]);
    assertEquals('\n', serialisedProperties[80]);
    assertEquals('a', serialisedProperties[6]);
    assertEquals('e', serialisedProperties[22]);
    assertEquals('e', serialisedProperties[62]);
    assertEquals('e', serialisedProperties[68]);
    assertEquals('e', serialisedProperties[73]);
    assertEquals('e', serialisedProperties[77]);
    assertEquals('e', serialisedProperties[9]);
    assertEquals('e', serialisedProperties[Short.SIZE]);
    assertEquals('f', serialisedProperties[7]);
    assertEquals('f', serialisedProperties[8]);
    assertEquals('g', serialisedProperties[5]);
    assertEquals('i', serialisedProperties[76]);
    assertEquals('o', serialisedProperties[14]);
    assertEquals('o', serialisedProperties[20]);
    assertEquals('o', serialisedProperties[60]);
    assertEquals('o', serialisedProperties[66]);
    assertEquals('o', serialisedProperties[71]);
    assertEquals('p', serialisedProperties[18]);
    assertEquals('p', serialisedProperties[21]);
    assertEquals('p', serialisedProperties[72]);
    assertEquals('r', serialisedProperties[10]);
    assertEquals('r', serialisedProperties[15]);
    assertEquals('r', serialisedProperties[19]);
    assertEquals('r', serialisedProperties[23]);
    assertEquals('r', serialisedProperties[61]);
    assertEquals('r', serialisedProperties[67]);
    assertEquals('r', serialisedProperties[70]);
    assertEquals('r', serialisedProperties[74]);
    assertEquals('s', serialisedProperties[12]);
    assertEquals('s', serialisedProperties[58]);
    assertEquals('s', serialisedProperties[78]);
    assertEquals('t', serialisedProperties[13]);
    assertEquals('t', serialisedProperties[24]);
    assertEquals('t', serialisedProperties[59]);
    assertEquals('t', serialisedProperties[65]);
    assertEquals('t', serialisedProperties[75]);
    assertEquals('{', serialisedProperties[0]);
    assertEquals('}', serialisedProperties[81]);
    byte[] expectedSerialisedConfig = "{\n  \"graphId\" : \"42\",\n  \"hooks\" : [ ]\n}".getBytes("UTF-8");
    assertArrayEquals(expectedSerialisedConfig, actualGraphSerialisable.getSerialisedConfig());
    byte[] expectedSerialisedSchema = "{\n  \"types\" : { }\n}".getBytes("UTF-8");
    assertArrayEquals(expectedSerialisedSchema, actualGraphSerialisable.getSerialisedSchema());
  }

  /**
   * Method under test:
   * {@link GraphSerialisable#GraphSerialisable(GraphConfig, Schema, StoreProperties)}
   */
  @Test
  void testNewGraphSerialisable7() throws UnsupportedEncodingException {
    // Arrange
    Schema schema = new Schema();
    StoreProperties storeProperties = new StoreProperties();

    // Act
    GraphSerialisable actualGraphSerialisable = new GraphSerialisable(null, schema, storeProperties);

    // Assert
    assertNull(actualGraphSerialisable.getSerialisedConfig());
    assertNull(actualGraphSerialisable.getGraphId());
    assertNull(actualGraphSerialisable.getConfig());
    byte[] serialisedProperties = actualGraphSerialisable.getSerialisedProperties();
    assertEquals(82, serialisedProperties.length);
    assertEquals(storeProperties, actualGraphSerialisable.getStoreProperties());
    assertEquals(' ', serialisedProperties[2]);
    assertEquals(' ', serialisedProperties[3]);
    assertEquals('.', serialisedProperties[11]);
    assertEquals('.', serialisedProperties[17]);
    assertEquals('.', serialisedProperties[57]);
    assertEquals('.', serialisedProperties[63]);
    assertEquals('P', serialisedProperties[69]);
    assertEquals('S', serialisedProperties[Double.SIZE]);
    assertEquals('"', serialisedProperties[4]);
    assertEquals('"', serialisedProperties[79]);
    assertEquals('\n', serialisedProperties[1]);
    assertEquals('\n', serialisedProperties[80]);
    assertEquals('a', serialisedProperties[6]);
    assertEquals('e', serialisedProperties[22]);
    assertEquals('e', serialisedProperties[62]);
    assertEquals('e', serialisedProperties[68]);
    assertEquals('e', serialisedProperties[73]);
    assertEquals('e', serialisedProperties[77]);
    assertEquals('e', serialisedProperties[9]);
    assertEquals('e', serialisedProperties[Short.SIZE]);
    assertEquals('f', serialisedProperties[7]);
    assertEquals('f', serialisedProperties[8]);
    assertEquals('g', serialisedProperties[5]);
    assertEquals('i', serialisedProperties[76]);
    assertEquals('o', serialisedProperties[14]);
    assertEquals('o', serialisedProperties[20]);
    assertEquals('o', serialisedProperties[60]);
    assertEquals('o', serialisedProperties[66]);
    assertEquals('o', serialisedProperties[71]);
    assertEquals('p', serialisedProperties[18]);
    assertEquals('p', serialisedProperties[21]);
    assertEquals('p', serialisedProperties[72]);
    assertEquals('r', serialisedProperties[10]);
    assertEquals('r', serialisedProperties[15]);
    assertEquals('r', serialisedProperties[19]);
    assertEquals('r', serialisedProperties[23]);
    assertEquals('r', serialisedProperties[61]);
    assertEquals('r', serialisedProperties[67]);
    assertEquals('r', serialisedProperties[70]);
    assertEquals('r', serialisedProperties[74]);
    assertEquals('s', serialisedProperties[12]);
    assertEquals('s', serialisedProperties[58]);
    assertEquals('s', serialisedProperties[78]);
    assertEquals('t', serialisedProperties[13]);
    assertEquals('t', serialisedProperties[24]);
    assertEquals('t', serialisedProperties[59]);
    assertEquals('t', serialisedProperties[65]);
    assertEquals('t', serialisedProperties[75]);
    assertEquals('{', serialisedProperties[0]);
    assertEquals('}', serialisedProperties[81]);
    byte[] expectedSerialisedSchema = "{\n  \"types\" : { }\n}".getBytes("UTF-8");
    assertArrayEquals(expectedSerialisedSchema, actualGraphSerialisable.getSerialisedSchema());
  }

  /**
   * Method under test:
   * {@link GraphSerialisable#GraphSerialisable(GraphConfig, Schema, StoreProperties)}
   */
  @Test
  void testNewGraphSerialisable8() throws UnsupportedEncodingException {
    // Arrange
    GraphConfig config = new GraphConfig("42");
    config.addHook(new AddOperationsToChain());
    Schema schema = new Schema();
    StoreProperties storeProperties = new StoreProperties();

    // Act
    GraphSerialisable actualGraphSerialisable = new GraphSerialisable(config, schema, storeProperties);

    // Assert
    byte[] serialisedConfig = actualGraphSerialisable.getSerialisedConfig();
    assertEquals(214, serialisedConfig.length);
    byte[] serialisedProperties = actualGraphSerialisable.getSerialisedProperties();
    assertEquals(82, serialisedProperties.length);
    assertEquals(storeProperties, actualGraphSerialisable.getStoreProperties());
    assertEquals(' ', serialisedConfig[13]);
    assertEquals(' ', serialisedConfig[15]);
    assertEquals(' ', serialisedConfig[2]);
    assertEquals(' ', serialisedConfig[200]);
    assertEquals(' ', serialisedConfig[202]);
    assertEquals(' ', serialisedConfig[204]);
    assertEquals(' ', serialisedConfig[207]);
    assertEquals(' ', serialisedConfig[208]);
    assertEquals(' ', serialisedConfig[210]);
    assertEquals(' ', serialisedConfig[22]);
    assertEquals(' ', serialisedConfig[23]);
    assertEquals(' ', serialisedConfig[3]);
    assertEquals(' ', serialisedProperties[2]);
    assertEquals(' ', serialisedProperties[3]);
    assertEquals(',', serialisedConfig[20]);
    assertEquals('.', serialisedProperties[11]);
    assertEquals('.', serialisedProperties[17]);
    assertEquals('.', serialisedProperties[57]);
    assertEquals('.', serialisedProperties[63]);
    assertEquals('2', serialisedConfig[18]);
    assertEquals('4', serialisedConfig[17]);
    assertEquals(':', serialisedConfig[14]);
    assertEquals(':', serialisedConfig[201]);
    assertEquals('I', serialisedConfig[10]);
    assertEquals('O', serialisedConfig[196]);
    assertEquals('P', serialisedProperties[69]);
    assertEquals('S', serialisedProperties[Double.SIZE]);
    assertEquals('"', serialisedConfig[12]);
    assertEquals('"', serialisedConfig[19]);
    assertEquals('"', serialisedConfig[199]);
    assertEquals('"', serialisedConfig[24]);
    assertEquals('"', serialisedConfig[4]);
    assertEquals('"', serialisedConfig[Short.SIZE]);
    assertEquals('"', serialisedProperties[4]);
    assertEquals('"', serialisedProperties[79]);
    assertEquals('\n', serialisedConfig[1]);
    assertEquals('\n', serialisedConfig[206]);
    assertEquals('\n', serialisedConfig[21]);
    assertEquals('\n', serialisedConfig[212]);
    assertEquals('\n', serialisedProperties[1]);
    assertEquals('\n', serialisedProperties[80]);
    assertEquals(']', serialisedConfig[211]);
    assertEquals('a', serialisedConfig[7]);
    assertEquals('a', serialisedProperties[6]);
    assertEquals('d', serialisedConfig[11]);
    assertEquals('d', serialisedConfig[195]);
    assertEquals('e', serialisedConfig[194]);
    assertEquals('e', serialisedProperties[22]);
    assertEquals('e', serialisedProperties[62]);
    assertEquals('e', serialisedProperties[68]);
    assertEquals('e', serialisedProperties[73]);
    assertEquals('e', serialisedProperties[77]);
    assertEquals('e', serialisedProperties[9]);
    assertEquals('e', serialisedProperties[Short.SIZE]);
    assertEquals('f', serialisedProperties[7]);
    assertEquals('f', serialisedProperties[8]);
    assertEquals('g', serialisedConfig[5]);
    assertEquals('g', serialisedProperties[5]);
    assertEquals('h', serialisedConfig[189]);
    assertEquals('h', serialisedConfig[9]);
    assertEquals('i', serialisedConfig[192]);
    assertEquals('i', serialisedProperties[76]);
    assertEquals('o', serialisedConfig[190]);
    assertEquals('o', serialisedProperties[14]);
    assertEquals('o', serialisedProperties[20]);
    assertEquals('o', serialisedProperties[60]);
    assertEquals('o', serialisedProperties[66]);
    assertEquals('o', serialisedProperties[71]);
    assertEquals('p', serialisedConfig[197]);
    assertEquals('p', serialisedConfig[8]);
    assertEquals('p', serialisedProperties[18]);
    assertEquals('p', serialisedProperties[21]);
    assertEquals('p', serialisedProperties[72]);
    assertEquals('r', serialisedConfig[191]);
    assertEquals('r', serialisedConfig[6]);
    assertEquals('r', serialisedProperties[10]);
    assertEquals('r', serialisedProperties[15]);
    assertEquals('r', serialisedProperties[19]);
    assertEquals('r', serialisedProperties[23]);
    assertEquals('r', serialisedProperties[61]);
    assertEquals('r', serialisedProperties[67]);
    assertEquals('r', serialisedProperties[70]);
    assertEquals('r', serialisedProperties[74]);
    assertEquals('s', serialisedConfig[193]);
    assertEquals('s', serialisedConfig[198]);
    assertEquals('s', serialisedProperties[12]);
    assertEquals('s', serialisedProperties[58]);
    assertEquals('s', serialisedProperties[78]);
    assertEquals('t', serialisedProperties[13]);
    assertEquals('t', serialisedProperties[24]);
    assertEquals('t', serialisedProperties[59]);
    assertEquals('t', serialisedProperties[65]);
    assertEquals('t', serialisedProperties[75]);
    assertEquals('{', serialisedConfig[0]);
    assertEquals('{', serialisedConfig[203]);
    assertEquals('{', serialisedProperties[0]);
    assertEquals('}', serialisedConfig[205]);
    assertEquals('}', serialisedConfig[209]);
    assertEquals('}', serialisedConfig[213]);
    assertEquals('}', serialisedProperties[81]);
    byte[] expectedSerialisedSchema = "{\n  \"types\" : { }\n}".getBytes("UTF-8");
    assertArrayEquals(expectedSerialisedSchema, actualGraphSerialisable.getSerialisedSchema());
  }

  /**
   * Method under test:
   * {@link GraphSerialisable#GraphSerialisable(GraphConfig, Schema, StoreProperties)}
   */
  @Test
  void testNewGraphSerialisable9() throws UnsupportedEncodingException {
    // Arrange
    GraphConfig config = new GraphConfig("42");
    config.setView(new View());
    config.addHook(new AddOperationsToChain());
    Schema schema = new Schema();
    StoreProperties storeProperties = new StoreProperties();

    // Act
    GraphSerialisable actualGraphSerialisable = new GraphSerialisable(config, schema, storeProperties);

    // Assert
    byte[] serialisedConfig = actualGraphSerialisable.getSerialisedConfig();
    assertEquals(230, serialisedConfig.length);
    byte[] serialisedProperties = actualGraphSerialisable.getSerialisedProperties();
    assertEquals(82, serialisedProperties.length);
    assertEquals(storeProperties, actualGraphSerialisable.getStoreProperties());
    assertEquals(' ', serialisedConfig[13]);
    assertEquals(' ', serialisedConfig[15]);
    assertEquals(' ', serialisedConfig[2]);
    assertEquals(' ', serialisedConfig[207]);
    assertEquals(' ', serialisedConfig[208]);
    assertEquals(' ', serialisedConfig[210]);
    assertEquals(' ', serialisedConfig[214]);
    assertEquals(' ', serialisedConfig[215]);
    assertEquals(' ', serialisedConfig[22]);
    assertEquals(' ', serialisedConfig[222]);
    assertEquals(' ', serialisedConfig[224]);
    assertEquals(' ', serialisedConfig[226]);
    assertEquals(' ', serialisedConfig[23]);
    assertEquals(' ', serialisedConfig[3]);
    assertEquals(' ', serialisedProperties[2]);
    assertEquals(' ', serialisedProperties[3]);
    assertEquals(',', serialisedConfig[20]);
    assertEquals(',', serialisedConfig[212]);
    assertEquals('.', serialisedProperties[11]);
    assertEquals('.', serialisedProperties[17]);
    assertEquals('.', serialisedProperties[57]);
    assertEquals('.', serialisedProperties[63]);
    assertEquals('2', serialisedConfig[18]);
    assertEquals('4', serialisedConfig[17]);
    assertEquals(':', serialisedConfig[14]);
    assertEquals(':', serialisedConfig[223]);
    assertEquals('I', serialisedConfig[10]);
    assertEquals('P', serialisedProperties[69]);
    assertEquals('S', serialisedProperties[Double.SIZE]);
    assertEquals('"', serialisedConfig[12]);
    assertEquals('"', serialisedConfig[19]);
    assertEquals('"', serialisedConfig[216]);
    assertEquals('"', serialisedConfig[221]);
    assertEquals('"', serialisedConfig[24]);
    assertEquals('"', serialisedConfig[4]);
    assertEquals('"', serialisedConfig[Short.SIZE]);
    assertEquals('"', serialisedProperties[4]);
    assertEquals('"', serialisedProperties[79]);
    assertEquals('\n', serialisedConfig[1]);
    assertEquals('\n', serialisedConfig[206]);
    assertEquals('\n', serialisedConfig[21]);
    assertEquals('\n', serialisedConfig[213]);
    assertEquals('\n', serialisedConfig[228]);
    assertEquals('\n', serialisedProperties[1]);
    assertEquals('\n', serialisedProperties[80]);
    assertEquals(']', serialisedConfig[211]);
    assertEquals('a', serialisedConfig[7]);
    assertEquals('a', serialisedProperties[6]);
    assertEquals('d', serialisedConfig[11]);
    assertEquals('e', serialisedConfig[219]);
    assertEquals('e', serialisedProperties[22]);
    assertEquals('e', serialisedProperties[62]);
    assertEquals('e', serialisedProperties[68]);
    assertEquals('e', serialisedProperties[73]);
    assertEquals('e', serialisedProperties[77]);
    assertEquals('e', serialisedProperties[9]);
    assertEquals('e', serialisedProperties[Short.SIZE]);
    assertEquals('f', serialisedProperties[7]);
    assertEquals('f', serialisedProperties[8]);
    assertEquals('g', serialisedConfig[5]);
    assertEquals('g', serialisedProperties[5]);
    assertEquals('h', serialisedConfig[9]);
    assertEquals('i', serialisedConfig[218]);
    assertEquals('i', serialisedProperties[76]);
    assertEquals('o', serialisedProperties[14]);
    assertEquals('o', serialisedProperties[20]);
    assertEquals('o', serialisedProperties[60]);
    assertEquals('o', serialisedProperties[66]);
    assertEquals('o', serialisedProperties[71]);
    assertEquals('p', serialisedConfig[8]);
    assertEquals('p', serialisedProperties[18]);
    assertEquals('p', serialisedProperties[21]);
    assertEquals('p', serialisedProperties[72]);
    assertEquals('r', serialisedConfig[6]);
    assertEquals('r', serialisedProperties[10]);
    assertEquals('r', serialisedProperties[15]);
    assertEquals('r', serialisedProperties[19]);
    assertEquals('r', serialisedProperties[23]);
    assertEquals('r', serialisedProperties[61]);
    assertEquals('r', serialisedProperties[67]);
    assertEquals('r', serialisedProperties[70]);
    assertEquals('r', serialisedProperties[74]);
    assertEquals('s', serialisedProperties[12]);
    assertEquals('s', serialisedProperties[58]);
    assertEquals('s', serialisedProperties[78]);
    assertEquals('t', serialisedProperties[13]);
    assertEquals('t', serialisedProperties[24]);
    assertEquals('t', serialisedProperties[59]);
    assertEquals('t', serialisedProperties[65]);
    assertEquals('t', serialisedProperties[75]);
    assertEquals('v', serialisedConfig[217]);
    assertEquals('w', serialisedConfig[220]);
    assertEquals('{', serialisedConfig[0]);
    assertEquals('{', serialisedConfig[225]);
    assertEquals('{', serialisedProperties[0]);
    assertEquals('}', serialisedConfig[205]);
    assertEquals('}', serialisedConfig[209]);
    assertEquals('}', serialisedConfig[227]);
    assertEquals('}', serialisedConfig[229]);
    assertEquals('}', serialisedProperties[81]);
    byte[] expectedSerialisedSchema = "{\n  \"types\" : { }\n}".getBytes("UTF-8");
    assertArrayEquals(expectedSerialisedSchema, actualGraphSerialisable.getSerialisedSchema());
  }

  /**
   * Method under test:
   * {@link GraphSerialisable#GraphSerialisable(GraphConfig, Schema, StoreProperties)}
   */
  @Test
  void testNewGraphSerialisable10() throws UnsupportedEncodingException {
    // Arrange
    GraphConfig config = new GraphConfig("42");
    StoreProperties storeProperties = new StoreProperties();

    // Act
    GraphSerialisable actualGraphSerialisable = new GraphSerialisable(config, null, storeProperties);

    // Assert
    assertNull(actualGraphSerialisable.getSerialisedSchema());
    assertNull(actualGraphSerialisable.getSchema());
    byte[] serialisedProperties = actualGraphSerialisable.getSerialisedProperties();
    assertEquals(82, serialisedProperties.length);
    assertEquals(storeProperties, actualGraphSerialisable.getStoreProperties());
    assertEquals(' ', serialisedProperties[2]);
    assertEquals(' ', serialisedProperties[3]);
    assertEquals('.', serialisedProperties[11]);
    assertEquals('.', serialisedProperties[17]);
    assertEquals('.', serialisedProperties[57]);
    assertEquals('.', serialisedProperties[63]);
    assertEquals('P', serialisedProperties[69]);
    assertEquals('S', serialisedProperties[Double.SIZE]);
    assertEquals('"', serialisedProperties[4]);
    assertEquals('"', serialisedProperties[79]);
    assertEquals('\n', serialisedProperties[1]);
    assertEquals('\n', serialisedProperties[80]);
    assertEquals('a', serialisedProperties[6]);
    assertEquals('e', serialisedProperties[22]);
    assertEquals('e', serialisedProperties[62]);
    assertEquals('e', serialisedProperties[68]);
    assertEquals('e', serialisedProperties[73]);
    assertEquals('e', serialisedProperties[77]);
    assertEquals('e', serialisedProperties[9]);
    assertEquals('e', serialisedProperties[Short.SIZE]);
    assertEquals('f', serialisedProperties[7]);
    assertEquals('f', serialisedProperties[8]);
    assertEquals('g', serialisedProperties[5]);
    assertEquals('i', serialisedProperties[76]);
    assertEquals('o', serialisedProperties[14]);
    assertEquals('o', serialisedProperties[20]);
    assertEquals('o', serialisedProperties[60]);
    assertEquals('o', serialisedProperties[66]);
    assertEquals('o', serialisedProperties[71]);
    assertEquals('p', serialisedProperties[18]);
    assertEquals('p', serialisedProperties[21]);
    assertEquals('p', serialisedProperties[72]);
    assertEquals('r', serialisedProperties[10]);
    assertEquals('r', serialisedProperties[15]);
    assertEquals('r', serialisedProperties[19]);
    assertEquals('r', serialisedProperties[23]);
    assertEquals('r', serialisedProperties[61]);
    assertEquals('r', serialisedProperties[67]);
    assertEquals('r', serialisedProperties[70]);
    assertEquals('r', serialisedProperties[74]);
    assertEquals('s', serialisedProperties[12]);
    assertEquals('s', serialisedProperties[58]);
    assertEquals('s', serialisedProperties[78]);
    assertEquals('t', serialisedProperties[13]);
    assertEquals('t', serialisedProperties[24]);
    assertEquals('t', serialisedProperties[59]);
    assertEquals('t', serialisedProperties[65]);
    assertEquals('t', serialisedProperties[75]);
    assertEquals('{', serialisedProperties[0]);
    assertEquals('}', serialisedProperties[81]);
    byte[] expectedSerialisedConfig = "{\n  \"graphId\" : \"42\",\n  \"hooks\" : [ ]\n}".getBytes("UTF-8");
    assertArrayEquals(expectedSerialisedConfig, actualGraphSerialisable.getSerialisedConfig());
  }

  /**
   * Method under test:
   * {@link GraphSerialisable#GraphSerialisable(GraphConfig, Schema, StoreProperties)}
   */
  @Test
  void testNewGraphSerialisable11() {
    // Arrange
    GraphConfig config = new GraphConfig("42");
    config.setView(new NamedView());
    config.addHook(new AddOperationsToChain());
    Schema schema = new Schema();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new GraphSerialisable(config, schema, new StoreProperties()));

  }

  /**
   * Method under test:
   * {@link GraphSerialisable#GraphSerialisable(GraphConfig, Schema, StoreProperties)}
   */
  @Test
  void testNewGraphSerialisable12() throws UnsupportedEncodingException {
    // Arrange
    View view = new View();
    view.addConfig("filterFieldsByName", "42");

    GraphConfig config = new GraphConfig("42");
    config.setView(view);
    config.addHook(new AddOperationsToChain());
    Schema schema = new Schema();
    StoreProperties storeProperties = new StoreProperties();

    // Act
    GraphSerialisable actualGraphSerialisable = new GraphSerialisable(config, schema, storeProperties);

    // Assert
    byte[] serialisedConfig = actualGraphSerialisable.getSerialisedConfig();
    assertEquals(289, serialisedConfig.length);
    byte[] serialisedProperties = actualGraphSerialisable.getSerialisedProperties();
    assertEquals(82, serialisedProperties.length);
    assertEquals(storeProperties, actualGraphSerialisable.getStoreProperties());
    assertEquals(' ', serialisedConfig[13]);
    assertEquals(' ', serialisedConfig[15]);
    assertEquals(' ', serialisedConfig[2]);
    assertEquals(' ', serialisedConfig[22]);
    assertEquals(' ', serialisedConfig[23]);
    assertEquals(' ', serialisedConfig[270]);
    assertEquals(' ', serialisedConfig[272]);
    assertEquals(' ', serialisedConfig[278]);
    assertEquals(' ', serialisedConfig[279]);
    assertEquals(' ', serialisedConfig[280]);
    assertEquals(' ', serialisedConfig[281]);
    assertEquals(' ', serialisedConfig[284]);
    assertEquals(' ', serialisedConfig[285]);
    assertEquals(' ', serialisedConfig[3]);
    assertEquals(' ', serialisedProperties[2]);
    assertEquals(' ', serialisedProperties[3]);
    assertEquals(',', serialisedConfig[20]);
    assertEquals('.', serialisedProperties[11]);
    assertEquals('.', serialisedProperties[17]);
    assertEquals('.', serialisedProperties[57]);
    assertEquals('.', serialisedProperties[63]);
    assertEquals('2', serialisedConfig[18]);
    assertEquals('2', serialisedConfig[275]);
    assertEquals('4', serialisedConfig[17]);
    assertEquals('4', serialisedConfig[274]);
    assertEquals(':', serialisedConfig[14]);
    assertEquals(':', serialisedConfig[271]);
    assertEquals('I', serialisedConfig[10]);
    assertEquals('N', serialisedConfig[265]);
    assertEquals('P', serialisedProperties[69]);
    assertEquals('S', serialisedProperties[Double.SIZE]);
    assertEquals('"', serialisedConfig[12]);
    assertEquals('"', serialisedConfig[19]);
    assertEquals('"', serialisedConfig[24]);
    assertEquals('"', serialisedConfig[269]);
    assertEquals('"', serialisedConfig[273]);
    assertEquals('"', serialisedConfig[276]);
    assertEquals('"', serialisedConfig[4]);
    assertEquals('"', serialisedConfig[Short.SIZE]);
    assertEquals('"', serialisedProperties[4]);
    assertEquals('"', serialisedProperties[79]);
    assertEquals('\n', serialisedConfig[1]);
    assertEquals('\n', serialisedConfig[21]);
    assertEquals('\n', serialisedConfig[277]);
    assertEquals('\n', serialisedConfig[283]);
    assertEquals('\n', serialisedConfig[287]);
    assertEquals('\n', serialisedProperties[1]);
    assertEquals('\n', serialisedProperties[80]);
    assertEquals('a', serialisedConfig[266]);
    assertEquals('a', serialisedConfig[7]);
    assertEquals('a', serialisedProperties[6]);
    assertEquals('d', serialisedConfig[11]);
    assertEquals('e', serialisedConfig[268]);
    assertEquals('e', serialisedProperties[22]);
    assertEquals('e', serialisedProperties[62]);
    assertEquals('e', serialisedProperties[68]);
    assertEquals('e', serialisedProperties[73]);
    assertEquals('e', serialisedProperties[77]);
    assertEquals('e', serialisedProperties[9]);
    assertEquals('e', serialisedProperties[Short.SIZE]);
    assertEquals('f', serialisedProperties[7]);
    assertEquals('f', serialisedProperties[8]);
    assertEquals('g', serialisedConfig[5]);
    assertEquals('g', serialisedProperties[5]);
    assertEquals('h', serialisedConfig[9]);
    assertEquals('i', serialisedProperties[76]);
    assertEquals('m', serialisedConfig[267]);
    assertEquals('o', serialisedProperties[14]);
    assertEquals('o', serialisedProperties[20]);
    assertEquals('o', serialisedProperties[60]);
    assertEquals('o', serialisedProperties[66]);
    assertEquals('o', serialisedProperties[71]);
    assertEquals('p', serialisedConfig[8]);
    assertEquals('p', serialisedProperties[18]);
    assertEquals('p', serialisedProperties[21]);
    assertEquals('p', serialisedProperties[72]);
    assertEquals('r', serialisedConfig[6]);
    assertEquals('r', serialisedProperties[10]);
    assertEquals('r', serialisedProperties[15]);
    assertEquals('r', serialisedProperties[19]);
    assertEquals('r', serialisedProperties[23]);
    assertEquals('r', serialisedProperties[61]);
    assertEquals('r', serialisedProperties[67]);
    assertEquals('r', serialisedProperties[70]);
    assertEquals('r', serialisedProperties[74]);
    assertEquals('s', serialisedProperties[12]);
    assertEquals('s', serialisedProperties[58]);
    assertEquals('s', serialisedProperties[78]);
    assertEquals('t', serialisedProperties[13]);
    assertEquals('t', serialisedProperties[24]);
    assertEquals('t', serialisedProperties[59]);
    assertEquals('t', serialisedProperties[65]);
    assertEquals('t', serialisedProperties[75]);
    assertEquals('y', serialisedConfig[264]);
    assertEquals('{', serialisedConfig[0]);
    assertEquals('{', serialisedProperties[0]);
    assertEquals('}', serialisedConfig[282]);
    assertEquals('}', serialisedConfig[286]);
    assertEquals('}', serialisedConfig[288]);
    assertEquals('}', serialisedProperties[81]);
    byte[] expectedSerialisedSchema = "{\n  \"types\" : { }\n}".getBytes("UTF-8");
    assertArrayEquals(expectedSerialisedSchema, actualGraphSerialisable.getSerialisedSchema());
  }

  /**
   * Method under test:
   * {@link GraphSerialisable#GraphSerialisable(GraphConfig, Schema, StoreProperties)}
   */
  @Test
  void testNewGraphSerialisable13() throws UnsupportedEncodingException {
    // Arrange
    GraphConfig config = new GraphConfig("42");
    config.addHook(new UpdateViewHook());
    Schema schema = new Schema();
    StoreProperties storeProperties = new StoreProperties();

    // Act
    GraphSerialisable actualGraphSerialisable = new GraphSerialisable(config, schema, storeProperties);

    // Assert
    byte[] serialisedConfig = actualGraphSerialisable.getSerialisedConfig();
    assertEquals(136, serialisedConfig.length);
    byte[] serialisedProperties = actualGraphSerialisable.getSerialisedProperties();
    assertEquals(82, serialisedProperties.length);
    assertEquals(storeProperties, actualGraphSerialisable.getStoreProperties());
    assertEquals(' ', serialisedConfig[120]);
    assertEquals(' ', serialisedConfig[122]);
    assertEquals(' ', serialisedConfig[129]);
    assertEquals(' ', serialisedConfig[13]);
    assertEquals(' ', serialisedConfig[130]);
    assertEquals(' ', serialisedConfig[132]);
    assertEquals(' ', serialisedConfig[15]);
    assertEquals(' ', serialisedConfig[2]);
    assertEquals(' ', serialisedConfig[22]);
    assertEquals(' ', serialisedConfig[23]);
    assertEquals(' ', serialisedConfig[3]);
    assertEquals(' ', serialisedProperties[2]);
    assertEquals(' ', serialisedProperties[3]);
    assertEquals(',', serialisedConfig[20]);
    assertEquals('.', serialisedProperties[11]);
    assertEquals('.', serialisedProperties[17]);
    assertEquals('.', serialisedProperties[57]);
    assertEquals('.', serialisedProperties[63]);
    assertEquals('2', serialisedConfig[18]);
    assertEquals('4', serialisedConfig[17]);
    assertEquals(':', serialisedConfig[121]);
    assertEquals(':', serialisedConfig[14]);
    assertEquals('G', serialisedConfig[113]);
    assertEquals('I', serialisedConfig[10]);
    assertEquals('P', serialisedProperties[69]);
    assertEquals('S', serialisedProperties[Double.SIZE]);
    assertEquals('"', serialisedConfig[119]);
    assertEquals('"', serialisedConfig[12]);
    assertEquals('"', serialisedConfig[19]);
    assertEquals('"', serialisedConfig[24]);
    assertEquals('"', serialisedConfig[4]);
    assertEquals('"', serialisedConfig[Short.SIZE]);
    assertEquals('"', serialisedProperties[4]);
    assertEquals('"', serialisedProperties[79]);
    assertEquals('\n', serialisedConfig[1]);
    assertEquals('\n', serialisedConfig[128]);
    assertEquals('\n', serialisedConfig[134]);
    assertEquals('\n', serialisedConfig[21]);
    assertEquals('\n', serialisedProperties[1]);
    assertEquals('\n', serialisedProperties[80]);
    assertEquals(']', serialisedConfig[133]);
    assertEquals('a', serialisedConfig[112]);
    assertEquals('a', serialisedConfig[124]);
    assertEquals('a', serialisedConfig[7]);
    assertEquals('a', serialisedProperties[6]);
    assertEquals('d', serialisedConfig[11]);
    assertEquals('e', serialisedConfig[Float.MAX_EXPONENT]);
    assertEquals('e', serialisedProperties[22]);
    assertEquals('e', serialisedProperties[62]);
    assertEquals('e', serialisedProperties[68]);
    assertEquals('e', serialisedProperties[73]);
    assertEquals('e', serialisedProperties[77]);
    assertEquals('e', serialisedProperties[9]);
    assertEquals('e', serialisedProperties[Short.SIZE]);
    assertEquals('f', serialisedConfig[123]);
    assertEquals('f', serialisedProperties[7]);
    assertEquals('f', serialisedProperties[8]);
    assertEquals('g', serialisedConfig[5]);
    assertEquals('g', serialisedProperties[5]);
    assertEquals('h', serialisedConfig[9]);
    assertEquals('i', serialisedProperties[76]);
    assertEquals('l', serialisedConfig[125]);
    assertEquals('o', serialisedConfig[115]);
    assertEquals('o', serialisedProperties[14]);
    assertEquals('o', serialisedProperties[20]);
    assertEquals('o', serialisedProperties[60]);
    assertEquals('o', serialisedProperties[66]);
    assertEquals('o', serialisedProperties[71]);
    assertEquals('p', serialisedConfig[117]);
    assertEquals('p', serialisedConfig[8]);
    assertEquals('p', serialisedProperties[18]);
    assertEquals('p', serialisedProperties[21]);
    assertEquals('p', serialisedProperties[72]);
    assertEquals('r', serialisedConfig[111]);
    assertEquals('r', serialisedConfig[114]);
    assertEquals('r', serialisedConfig[6]);
    assertEquals('r', serialisedProperties[10]);
    assertEquals('r', serialisedProperties[15]);
    assertEquals('r', serialisedProperties[19]);
    assertEquals('r', serialisedProperties[23]);
    assertEquals('r', serialisedProperties[61]);
    assertEquals('r', serialisedProperties[67]);
    assertEquals('r', serialisedProperties[70]);
    assertEquals('r', serialisedProperties[74]);
    assertEquals('s', serialisedConfig[118]);
    assertEquals('s', serialisedConfig[126]);
    assertEquals('s', serialisedProperties[12]);
    assertEquals('s', serialisedProperties[58]);
    assertEquals('s', serialisedProperties[78]);
    assertEquals('t', serialisedProperties[13]);
    assertEquals('t', serialisedProperties[24]);
    assertEquals('t', serialisedProperties[59]);
    assertEquals('t', serialisedProperties[65]);
    assertEquals('t', serialisedProperties[75]);
    assertEquals('u', serialisedConfig[116]);
    assertEquals('{', serialisedConfig[0]);
    assertEquals('{', serialisedProperties[0]);
    assertEquals('}', serialisedConfig[131]);
    assertEquals('}', serialisedConfig[135]);
    assertEquals('}', serialisedProperties[81]);
    byte[] expectedSerialisedSchema = "{\n  \"types\" : { }\n}".getBytes("UTF-8");
    assertArrayEquals(expectedSerialisedSchema, actualGraphSerialisable.getSerialisedSchema());
  }

  /**
   * Method under test:
   * {@link GraphSerialisable#GraphSerialisable(GraphConfig, Schema, StoreProperties)}
   */
  @Test
  void testNewGraphSerialisable14() throws UnsupportedEncodingException {
    // Arrange
    GraphConfig config = new GraphConfig("42");
    config.addHook(new AddOperationsToChain());
    config.addHook(new AddOperationsToChain());
    config.addHook(new AddOperationsToChain());
    Schema schema = new Schema();
    StoreProperties storeProperties = new StoreProperties();

    // Act
    GraphSerialisable actualGraphSerialisable = new GraphSerialisable(config, schema, storeProperties);

    // Assert
    byte[] serialisedConfig = actualGraphSerialisable.getSerialisedConfig();
    assertEquals(566, serialisedConfig.length);
    byte[] serialisedProperties = actualGraphSerialisable.getSerialisedProperties();
    assertEquals(82, serialisedProperties.length);
    assertEquals(storeProperties, actualGraphSerialisable.getStoreProperties());
    assertEquals(' ', serialisedConfig[13]);
    assertEquals(' ', serialisedConfig[15]);
    assertEquals(' ', serialisedConfig[2]);
    assertEquals(' ', serialisedConfig[22]);
    assertEquals(' ', serialisedConfig[23]);
    assertEquals(' ', serialisedConfig[3]);
    assertEquals(' ', serialisedConfig[552]);
    assertEquals(' ', serialisedConfig[554]);
    assertEquals(' ', serialisedConfig[556]);
    assertEquals(' ', serialisedConfig[559]);
    assertEquals(' ', serialisedConfig[560]);
    assertEquals(' ', serialisedConfig[562]);
    assertEquals(' ', serialisedProperties[2]);
    assertEquals(' ', serialisedProperties[3]);
    assertEquals(',', serialisedConfig[20]);
    assertEquals('.', serialisedProperties[11]);
    assertEquals('.', serialisedProperties[17]);
    assertEquals('.', serialisedProperties[57]);
    assertEquals('.', serialisedProperties[63]);
    assertEquals('2', serialisedConfig[18]);
    assertEquals('4', serialisedConfig[17]);
    assertEquals(':', serialisedConfig[14]);
    assertEquals(':', serialisedConfig[553]);
    assertEquals('I', serialisedConfig[10]);
    assertEquals('O', serialisedConfig[548]);
    assertEquals('P', serialisedProperties[69]);
    assertEquals('S', serialisedProperties[Double.SIZE]);
    assertEquals('"', serialisedConfig[12]);
    assertEquals('"', serialisedConfig[19]);
    assertEquals('"', serialisedConfig[24]);
    assertEquals('"', serialisedConfig[4]);
    assertEquals('"', serialisedConfig[551]);
    assertEquals('"', serialisedConfig[Short.SIZE]);
    assertEquals('"', serialisedProperties[4]);
    assertEquals('"', serialisedProperties[79]);
    assertEquals('\n', serialisedConfig[1]);
    assertEquals('\n', serialisedConfig[21]);
    assertEquals('\n', serialisedConfig[558]);
    assertEquals('\n', serialisedConfig[564]);
    assertEquals('\n', serialisedProperties[1]);
    assertEquals('\n', serialisedProperties[80]);
    assertEquals(']', serialisedConfig[563]);
    assertEquals('a', serialisedConfig[7]);
    assertEquals('a', serialisedProperties[6]);
    assertEquals('d', serialisedConfig[11]);
    assertEquals('d', serialisedConfig[547]);
    assertEquals('e', serialisedConfig[546]);
    assertEquals('e', serialisedProperties[22]);
    assertEquals('e', serialisedProperties[62]);
    assertEquals('e', serialisedProperties[68]);
    assertEquals('e', serialisedProperties[73]);
    assertEquals('e', serialisedProperties[77]);
    assertEquals('e', serialisedProperties[9]);
    assertEquals('e', serialisedProperties[Short.SIZE]);
    assertEquals('f', serialisedProperties[7]);
    assertEquals('f', serialisedProperties[8]);
    assertEquals('g', serialisedConfig[5]);
    assertEquals('g', serialisedProperties[5]);
    assertEquals('h', serialisedConfig[541]);
    assertEquals('h', serialisedConfig[9]);
    assertEquals('i', serialisedConfig[544]);
    assertEquals('i', serialisedProperties[76]);
    assertEquals('o', serialisedConfig[542]);
    assertEquals('o', serialisedProperties[14]);
    assertEquals('o', serialisedProperties[20]);
    assertEquals('o', serialisedProperties[60]);
    assertEquals('o', serialisedProperties[66]);
    assertEquals('o', serialisedProperties[71]);
    assertEquals('p', serialisedConfig[549]);
    assertEquals('p', serialisedConfig[8]);
    assertEquals('p', serialisedProperties[18]);
    assertEquals('p', serialisedProperties[21]);
    assertEquals('p', serialisedProperties[72]);
    assertEquals('r', serialisedConfig[543]);
    assertEquals('r', serialisedConfig[6]);
    assertEquals('r', serialisedProperties[10]);
    assertEquals('r', serialisedProperties[15]);
    assertEquals('r', serialisedProperties[19]);
    assertEquals('r', serialisedProperties[23]);
    assertEquals('r', serialisedProperties[61]);
    assertEquals('r', serialisedProperties[67]);
    assertEquals('r', serialisedProperties[70]);
    assertEquals('r', serialisedProperties[74]);
    assertEquals('s', serialisedConfig[545]);
    assertEquals('s', serialisedConfig[550]);
    assertEquals('s', serialisedProperties[12]);
    assertEquals('s', serialisedProperties[58]);
    assertEquals('s', serialisedProperties[78]);
    assertEquals('t', serialisedProperties[13]);
    assertEquals('t', serialisedProperties[24]);
    assertEquals('t', serialisedProperties[59]);
    assertEquals('t', serialisedProperties[65]);
    assertEquals('t', serialisedProperties[75]);
    assertEquals('{', serialisedConfig[0]);
    assertEquals('{', serialisedConfig[555]);
    assertEquals('{', serialisedProperties[0]);
    assertEquals('}', serialisedConfig[557]);
    assertEquals('}', serialisedConfig[561]);
    assertEquals('}', serialisedConfig[565]);
    assertEquals('}', serialisedProperties[81]);
    byte[] expectedSerialisedSchema = "{\n  \"types\" : { }\n}".getBytes("UTF-8");
    assertArrayEquals(expectedSerialisedSchema, actualGraphSerialisable.getSerialisedSchema());
  }
}
