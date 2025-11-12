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

package uk.gov.gchq.gaffer.operation.export.graph;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.fasterxml.jackson.core.type.TypeReference;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.function.BiFunction;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.Element;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl;
import uk.gov.gchq.gaffer.store.StoreProperties;
import uk.gov.gchq.gaffer.store.schema.Schema;

class ExportToOtherGraphDiffblueTest {
  /**
   * Method under test: {@link ExportToOtherGraph.Builder#graphId(String)}
   */
  @Test
  void testBuilderGraphId() {
    // Arrange
    ExportToOtherGraph.Builder builder = new ExportToOtherGraph.Builder();

    // Act and Assert
    assertSame(builder, builder.graphId("42"));
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ExportToOtherGraph.Builder}
   */
  @Test
  void testBuilderNewBuilder() {
    // Arrange and Act
    ExportToOtherGraph.Builder actualBuilder = new ExportToOtherGraph.Builder();

    // Assert
    ExportToOtherGraph _getOpResult = actualBuilder._getOp();
    TypeReference<Iterable<? extends Element>> outputTypeReference = _getOpResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.IterableElement);
    assertEquals("ALL", _getOpResult.getKeyOrDefault());
    Type outputType = _getOpResult.getOutputType();
    assertEquals("java.lang.Iterable<? extends uk.gov.gchq.gaffer.data.element.Element>", outputType.getTypeName());
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
    assertSame(_getOpResult, actualBuilder.build());
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Method under test:
   * {@link ExportToOtherGraph.Builder#parentSchemaIds(String[])}
   */
  @Test
  void testBuilderParentSchemaIds() {
    // Arrange
    ExportToOtherGraph.Builder builder = new ExportToOtherGraph.Builder();

    // Act and Assert
    assertSame(builder, builder.parentSchemaIds("Parent Schema Ids"));
  }

  /**
   * Method under test:
   * {@link ExportToOtherGraph.Builder#parentStorePropertiesId(String)}
   */
  @Test
  void testBuilderParentStorePropertiesId() {
    // Arrange
    ExportToOtherGraph.Builder builder = new ExportToOtherGraph.Builder();

    // Act and Assert
    assertSame(builder, builder.parentStorePropertiesId("42"));
  }

  /**
   * Method under test: {@link ExportToOtherGraph.Builder#schema(Schema)}
   */
  @Test
  void testBuilderSchema() {
    // Arrange
    ExportToOtherGraph.Builder builder = new ExportToOtherGraph.Builder();

    // Act and Assert
    assertSame(builder, builder.schema(new Schema()));
  }

  /**
   * Method under test:
   * {@link ExportToOtherGraph.Builder#storeProperties(StoreProperties)}
   */
  @Test
  void testBuilderStoreProperties() {
    // Arrange
    ExportToOtherGraph.Builder builder = new ExportToOtherGraph.Builder();

    // Act and Assert
    assertSame(builder, builder.storeProperties(new StoreProperties()));
  }

  /**
   * Method under test: {@link ExportToOtherGraph#getProperties()}
   */
  @Test
  void testGetProperties() {
    // Arrange, Act and Assert
    assertNull((new ExportToOtherGraph()).getProperties());
  }

  /**
   * Method under test: {@link ExportToOtherGraph#getProperties()}
   */
  @Test
  void testGetProperties2() {
    // Arrange
    ExportToOtherGraph exportToOtherGraph = new ExportToOtherGraph();
    exportToOtherGraph.setStoreProperties(new StoreProperties());

    // Act
    Properties actualProperties = exportToOtherGraph.getProperties();

    // Assert
    assertEquals(1, actualProperties.size());
    assertEquals("uk.gov.gchq.gaffer.store.StoreProperties", actualProperties.get("gaffer.store.properties.class"));
  }

  /**
   * Method under test: {@link ExportToOtherGraph#getProperties()}
   */
  @Test
  void testGetProperties3() {
    // Arrange
    Properties properties = new Properties();
    properties.replaceAll(mock(BiFunction.class));

    ExportToOtherGraph exportToOtherGraph = new ExportToOtherGraph();
    exportToOtherGraph.setProperties(properties);

    // Act
    Properties actualProperties = exportToOtherGraph.getProperties();

    // Assert
    assertTrue(actualProperties.isEmpty());
    assertSame(properties, actualProperties);
  }

  /**
   * Method under test: {@link ExportToOtherGraph#setProperties(Properties)}
   */
  @Test
  void testSetProperties() {
    // Arrange
    ExportToOtherGraph exportToOtherGraph = new ExportToOtherGraph();
    Properties properties = new Properties();

    // Act
    exportToOtherGraph.setProperties(properties);

    // Assert
    StoreProperties storeProperties = exportToOtherGraph.getStoreProperties();
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
    Class<StoreProperties> expectedStorePropertiesClass = StoreProperties.class;
    assertEquals(expectedStorePropertiesClass, storeProperties.getStorePropertiesClass());
    Class<Schema> expectedSchemaClass = Schema.class;
    assertEquals(expectedSchemaClass, storeProperties.getSchemaClass());
    assertSame(properties, exportToOtherGraph.getProperties());
    assertSame(properties, storeProperties.getProperties());
  }

  /**
   * Method under test: {@link ExportToOtherGraph#setProperties(Properties)}
   */
  @Test
  void testSetProperties2() {
    // Arrange
    ExportToOtherGraph exportToOtherGraph = new ExportToOtherGraph();

    // Act
    exportToOtherGraph.setProperties(null);

    // Assert
    assertNull(exportToOtherGraph.getProperties());
    assertNull(exportToOtherGraph.getStoreProperties());
  }

  /**
   * Method under test: {@link ExportToOtherGraph#setProperties(Properties)}
   */
  @Test
  void testSetProperties3() {
    // Arrange
    ExportToOtherGraph exportToOtherGraph = new ExportToOtherGraph();

    Properties properties = new Properties();
    properties.replaceAll(mock(BiFunction.class));

    // Act
    exportToOtherGraph.setProperties(properties);

    // Assert
    StoreProperties storeProperties = exportToOtherGraph.getStoreProperties();
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
    Class<StoreProperties> expectedStorePropertiesClass = StoreProperties.class;
    assertEquals(expectedStorePropertiesClass, storeProperties.getStorePropertiesClass());
    Class<Schema> expectedSchemaClass = Schema.class;
    assertEquals(expectedSchemaClass, storeProperties.getSchemaClass());
    assertSame(properties, exportToOtherGraph.getProperties());
    assertSame(properties, storeProperties.getProperties());
  }

  /**
   * Method under test: {@link ExportToOtherGraph#shallowClone()}
   */
  @Test
  void testShallowClone() {
    // Arrange
    ExportToOtherGraph exportToOtherGraph = new ExportToOtherGraph();
    exportToOtherGraph.setParentSchemaIds(new ArrayList<>());

    // Act
    ExportToOtherGraph actualShallowCloneResult = exportToOtherGraph.shallowClone();

    // Assert
    TypeReference<Iterable<? extends Element>> outputTypeReference = actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.IterableElement);
    assertEquals("ALL", actualShallowCloneResult.getKeyOrDefault());
    Type outputType = actualShallowCloneResult.getOutputType();
    assertEquals("java.lang.Iterable<? extends uk.gov.gchq.gaffer.data.element.Element>", outputType.getTypeName());
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
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Method under test: {@link ExportToOtherGraph#shallowClone()}
   */
  @Test
  void testShallowClone2() {
    // Arrange
    ExportToOtherGraph exportToOtherGraph = new ExportToOtherGraph();
    exportToOtherGraph.setOptions(new HashMap<>());
    exportToOtherGraph.setParentSchemaIds(new ArrayList<>());

    // Act
    ExportToOtherGraph actualShallowCloneResult = exportToOtherGraph.shallowClone();

    // Assert
    TypeReference<Iterable<? extends Element>> outputTypeReference = actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.IterableElement);
    assertEquals("ALL", actualShallowCloneResult.getKeyOrDefault());
    Type outputType = actualShallowCloneResult.getOutputType();
    assertEquals("java.lang.Iterable<? extends uk.gov.gchq.gaffer.data.element.Element>", outputType.getTypeName());
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
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Method under test: {@link ExportToOtherGraph#shallowClone()}
   */
  @Test
  void testShallowClone3() {
    // Arrange
    HashMap<String, String> options = new HashMap<>();
    options.computeIfPresent("foo", mock(BiFunction.class));

    ExportToOtherGraph exportToOtherGraph = new ExportToOtherGraph();
    exportToOtherGraph.setOptions(options);
    exportToOtherGraph.setParentSchemaIds(new ArrayList<>());

    // Act
    ExportToOtherGraph actualShallowCloneResult = exportToOtherGraph.shallowClone();

    // Assert
    TypeReference<Iterable<? extends Element>> outputTypeReference = actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.IterableElement);
    assertEquals("ALL", actualShallowCloneResult.getKeyOrDefault());
    Type outputType = actualShallowCloneResult.getOutputType();
    assertEquals("java.lang.Iterable<? extends uk.gov.gchq.gaffer.data.element.Element>", outputType.getTypeName());
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
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Method under test: {@link ExportToOtherGraph#getOutputTypeReference()}
   */
  @Test
  void testGetOutputTypeReference() {
    // Arrange and Act
    TypeReference<Iterable<? extends Element>> actualOutputTypeReference = (new ExportToOtherGraph())
        .getOutputTypeReference();

    // Assert
    assertTrue(actualOutputTypeReference instanceof TypeReferenceImpl.IterableElement);
    assertEquals("java.lang.Iterable<? extends uk.gov.gchq.gaffer.data.element.Element>",
        actualOutputTypeReference.getType().getTypeName());
  }

  /**
   * Methods under test:
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
    actualExportToOtherGraph.getKey();
    Map<String, String> actualOptions = actualExportToOtherGraph.getOptions();
    List<String> actualParentSchemaIds = actualExportToOtherGraph.getParentSchemaIds();
    String actualParentStorePropertiesId = actualExportToOtherGraph.getParentStorePropertiesId();
    Schema actualSchema = actualExportToOtherGraph.getSchema();
    StoreProperties actualStoreProperties = actualExportToOtherGraph.getStoreProperties();

    // Assert that nothing has changed
    Iterable<? extends Element> input2 = actualExportToOtherGraph.getInput();
    assertTrue(input2 instanceof List);
    assertEquals("42", actualGraphId);
    assertEquals("42", actualParentStorePropertiesId);
    assertTrue(actualParentSchemaIds.isEmpty());
    assertTrue(actualOptions.isEmpty());
    assertSame(input, input2);
    assertSame(parentSchemaIds, actualParentSchemaIds);
    assertSame(options, actualOptions);
    assertSame(storeProperties, actualStoreProperties);
    assertSame(schema, actualSchema);
  }
}
