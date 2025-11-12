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

package uk.gov.gchq.gaffer.operation.export.graph.handler;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.elementdefinition.exception.SchemaException;
import uk.gov.gchq.gaffer.graph.hook.AddOperationsToChain;
import uk.gov.gchq.gaffer.graph.hook.GraphHook;
import uk.gov.gchq.gaffer.store.StoreProperties;
import uk.gov.gchq.gaffer.store.schema.Schema;

class GraphDelegateDiffblueTest {
  /**
   * Method under test: default or parameterless constructor of
   * {@link GraphDelegate.BaseBuilder}
   */
  @Test
  void testBaseBuilderNewBaseBuilder() {
    // Arrange and Act
    GraphDelegate.BaseBuilder<GraphDelegate.BaseBuilder> actualBaseBuilder = new GraphDelegate.BaseBuilder<>();

    // Assert
    assertNull(actualBaseBuilder.graphId);
    assertNull(actualBaseBuilder.parentStorePropertiesId);
    assertNull(actualBaseBuilder.parentSchemaIds);
    assertNull(actualBaseBuilder.store);
    assertNull(actualBaseBuilder.storeProperties);
    assertNull(actualBaseBuilder.schema);
  }

  /**
   * Method under test: {@link GraphDelegate.BaseBuilder#parentSchemaIds(List)}
   */
  @Test
  void testBaseBuilderParentSchemaIds() {
    // Arrange
    GraphDelegate.BaseBuilder<GraphDelegate.BaseBuilder> baseBuilder = new GraphDelegate.BaseBuilder<>();

    // Act
    GraphDelegate.BaseBuilder actualParentSchemaIdsResult = baseBuilder.parentSchemaIds(new ArrayList<>());

    // Assert
    assertTrue(baseBuilder.parentSchemaIds.isEmpty());
    assertSame(baseBuilder, actualParentSchemaIdsResult);
  }

  /**
   * Method under test: {@link GraphDelegate.BaseBuilder#schema(Schema)}
   */
  @Test
  void testBaseBuilderSchema() throws UnsupportedEncodingException, SchemaException {
    // Arrange
    GraphDelegate.BaseBuilder<GraphDelegate.BaseBuilder> baseBuilder = new GraphDelegate.BaseBuilder<>();

    // Act
    GraphDelegate.BaseBuilder actualSchemaResult = baseBuilder.schema(new Schema());

    // Assert
    Schema schema = baseBuilder.schema;
    assertNull(schema.getVisibilityProperty());
    assertNull(schema.getConfig());
    assertNull(schema.getVertexSerialiser());
    assertFalse(schema.hasEdges());
    assertFalse(schema.hasEntities());
    assertFalse(schema.hasGroups());
    assertFalse(schema.isAggregationEnabled());
    assertTrue(schema.getAggregatedGroups().isEmpty());
    assertTrue(schema.getGroups().isEmpty());
    assertSame(baseBuilder, actualSchemaResult);
    byte[] expectedToCompactJsonResult = "{\"types\":{}}".getBytes("UTF-8");
    assertArrayEquals(expectedToCompactJsonResult, schema.toCompactJson());
  }

  /**
   * Method under test:
   * {@link GraphDelegate.BaseBuilder#storeProperties(StoreProperties)}
   */
  @Test
  void testBaseBuilderStoreProperties() {
    // Arrange
    GraphDelegate.BaseBuilder<GraphDelegate.BaseBuilder> baseBuilder = new GraphDelegate.BaseBuilder<>();

    // Act
    GraphDelegate.BaseBuilder actualStorePropertiesResult = baseBuilder.storeProperties(new StoreProperties());

    // Assert
    StoreProperties storeProperties = baseBuilder.storeProperties;
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
    assertTrue(storeProperties.getOperationDeclarations().getOperations().isEmpty());
    assertTrue(storeProperties.getNamedOperationEnabled());
    assertTrue(storeProperties.getNamedViewEnabled());
    assertSame(baseBuilder, actualStorePropertiesResult);
  }

  /**
   * Method under test: {@link GraphDelegate.BaseBuilder#_self()}
   */
  @Test
  void testBaseBuilder_self() {
    // Arrange
    GraphDelegate.BaseBuilder<GraphDelegate.BaseBuilder> baseBuilder = new GraphDelegate.BaseBuilder<>();

    // Act and Assert
    assertSame(baseBuilder, baseBuilder._self());
  }

  /**
   * Method under test: {@link GraphDelegate.Builder#hooks(GraphHook[])}
   */
  @Test
  void testBuilderHooks() {
    // Arrange
    GraphDelegate.Builder builder = new GraphDelegate.Builder();

    // Act and Assert
    assertSame(builder, builder.hooks(new AddOperationsToChain()));
  }

  /**
   * Method under test: {@link GraphDelegate.Builder#_self()}
   */
  @Test
  void testBuilder_self() {
    // Arrange
    GraphDelegate.Builder builder = new GraphDelegate.Builder();

    // Act and Assert
    assertSame(builder, builder._self());
  }
}
