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

package uk.gov.gchq.gaffer.mapstore;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.Properties;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.store.schema.Schema;

class MapStorePropertiesDiffblueTest {
  /**
   * Test {@link MapStoreProperties#MapStoreProperties()}.
   * <p>
   * Method under test: {@link MapStoreProperties#MapStoreProperties()}
   */
  @Test
  @DisplayName("Test new MapStoreProperties()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void MapStoreProperties.<init>()"})
  void testNewMapStoreProperties() {
    // Arrange and Act
    MapStoreProperties actualMapStoreProperties = new MapStoreProperties();

    // Assert
    assertEquals("", actualMapStoreProperties.getAdminAuth());
    assertEquals("uk.gov.gchq.gaffer.mapstore.MapStore", actualMapStoreProperties.getStoreClass());
    assertEquals("uk.gov.gchq.gaffer.mapstore.MapStoreProperties",
        actualMapStoreProperties.getStorePropertiesClassName());
    assertEquals("uk.gov.gchq.gaffer.mapstore.factory.SimpleMapFactory", actualMapStoreProperties.getMapFactory());
    assertEquals("uk.gov.gchq.gaffer.sketches.serialisation.json.SketchesJsonModules,",
        actualMapStoreProperties.getJsonSerialiserModules());
    assertEquals("uk.gov.gchq.gaffer.store.schema.Schema", actualMapStoreProperties.getSchemaClassName());
    assertNull(actualMapStoreProperties.getStrictJson());
    assertNull(actualMapStoreProperties.getMapFactoryConfig());
    assertNull(actualMapStoreProperties.getCacheServiceClass());
    assertNull(actualMapStoreProperties.getDefaultCacheServiceClass());
    assertNull(actualMapStoreProperties.getJobTrackerCacheServiceClass());
    assertNull(actualMapStoreProperties.getJsonSerialiserClass());
    assertNull(actualMapStoreProperties.getNamedOperationCacheServiceClass());
    assertNull(actualMapStoreProperties.getNamedViewCacheServiceClass());
    assertNull(actualMapStoreProperties.getOperationDeclarationPaths());
    assertNull(actualMapStoreProperties.getReflectionPackages());
    assertEquals(0, actualMapStoreProperties.getIngestBufferSize());
    Properties properties = actualMapStoreProperties.getProperties();
    assertEquals(2, properties.size());
    assertEquals(50, actualMapStoreProperties.getJobExecutorThreadCount().intValue());
    assertFalse(actualMapStoreProperties.getJobTrackerEnabled());
    assertFalse(actualMapStoreProperties.getRescheduleJobsOnStart());
    assertTrue(properties.containsKey("gaffer.store.class"));
    assertTrue(properties.containsKey("gaffer.store.properties.class"));
    assertTrue(actualMapStoreProperties.getCreateIndex());
    assertTrue(actualMapStoreProperties.getNamedOperationEnabled());
    assertTrue(actualMapStoreProperties.getNamedViewEnabled());
    Class<MapStoreProperties> expectedStorePropertiesClass = MapStoreProperties.class;
    assertEquals(expectedStorePropertiesClass, actualMapStoreProperties.getStorePropertiesClass());
    Class<Schema> expectedSchemaClass = Schema.class;
    assertEquals(expectedSchemaClass, actualMapStoreProperties.getSchemaClass());
  }

  /**
   * Test {@link MapStoreProperties#MapStoreProperties(Path)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return AdminAuth is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link MapStoreProperties#MapStoreProperties(Path)}
   */
  @Test
  @DisplayName("Test new MapStoreProperties(Path); when 'null'; then return AdminAuth is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void MapStoreProperties.<init>(Path)"})
  void testNewMapStoreProperties_whenNull_thenReturnAdminAuthIsEmptyString() {
    // Arrange and Act
    MapStoreProperties actualMapStoreProperties = new MapStoreProperties(null);

    // Assert
    assertEquals("", actualMapStoreProperties.getAdminAuth());
    assertEquals("uk.gov.gchq.gaffer.mapstore.MapStore", actualMapStoreProperties.getStoreClass());
    assertEquals("uk.gov.gchq.gaffer.mapstore.MapStoreProperties",
        actualMapStoreProperties.getStorePropertiesClassName());
    assertEquals("uk.gov.gchq.gaffer.mapstore.factory.SimpleMapFactory", actualMapStoreProperties.getMapFactory());
    assertEquals("uk.gov.gchq.gaffer.sketches.serialisation.json.SketchesJsonModules,",
        actualMapStoreProperties.getJsonSerialiserModules());
    assertEquals("uk.gov.gchq.gaffer.store.schema.Schema", actualMapStoreProperties.getSchemaClassName());
    assertNull(actualMapStoreProperties.getStrictJson());
    assertNull(actualMapStoreProperties.getMapFactoryConfig());
    assertNull(actualMapStoreProperties.getCacheServiceClass());
    assertNull(actualMapStoreProperties.getDefaultCacheServiceClass());
    assertNull(actualMapStoreProperties.getJobTrackerCacheServiceClass());
    assertNull(actualMapStoreProperties.getJsonSerialiserClass());
    assertNull(actualMapStoreProperties.getNamedOperationCacheServiceClass());
    assertNull(actualMapStoreProperties.getNamedViewCacheServiceClass());
    assertNull(actualMapStoreProperties.getOperationDeclarationPaths());
    assertNull(actualMapStoreProperties.getReflectionPackages());
    assertEquals(0, actualMapStoreProperties.getIngestBufferSize());
    Properties properties = actualMapStoreProperties.getProperties();
    assertEquals(2, properties.size());
    assertEquals(50, actualMapStoreProperties.getJobExecutorThreadCount().intValue());
    assertFalse(actualMapStoreProperties.getJobTrackerEnabled());
    assertFalse(actualMapStoreProperties.getRescheduleJobsOnStart());
    assertTrue(properties.containsKey("gaffer.store.class"));
    assertTrue(properties.containsKey("gaffer.store.properties.class"));
    assertTrue(actualMapStoreProperties.getCreateIndex());
    assertTrue(actualMapStoreProperties.getNamedOperationEnabled());
    assertTrue(actualMapStoreProperties.getNamedViewEnabled());
    Class<MapStoreProperties> expectedStorePropertiesClass = MapStoreProperties.class;
    assertEquals(expectedStorePropertiesClass, actualMapStoreProperties.getStorePropertiesClass());
    Class<Schema> expectedSchemaClass = Schema.class;
    assertEquals(expectedSchemaClass, actualMapStoreProperties.getSchemaClass());
  }

  /**
   * Test {@link MapStoreProperties#loadStoreProperties(Path)} with {@code storePropertiesPath}.
   * <ul>
   *   <li>Then return AdminAuth is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link MapStoreProperties#loadStoreProperties(Path)}
   */
  @Test
  @DisplayName("Test loadStoreProperties(Path) with 'storePropertiesPath'; then return AdminAuth is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MapStoreProperties MapStoreProperties.loadStoreProperties(Path)"})
  void testLoadStorePropertiesWithStorePropertiesPath_thenReturnAdminAuthIsEmptyString() {
    // Arrange and Act
    MapStoreProperties actualLoadStorePropertiesResult = MapStoreProperties.loadStoreProperties((Path) null);

    // Assert
    assertEquals("", actualLoadStorePropertiesResult.getAdminAuth());
    assertEquals("uk.gov.gchq.gaffer.mapstore.MapStoreProperties",
        actualLoadStorePropertiesResult.getStorePropertiesClassName());
    assertEquals("uk.gov.gchq.gaffer.mapstore.factory.SimpleMapFactory",
        actualLoadStorePropertiesResult.getMapFactory());
    assertEquals("uk.gov.gchq.gaffer.sketches.serialisation.json.SketchesJsonModules,",
        actualLoadStorePropertiesResult.getJsonSerialiserModules());
    assertEquals("uk.gov.gchq.gaffer.store.schema.Schema", actualLoadStorePropertiesResult.getSchemaClassName());
    assertNull(actualLoadStorePropertiesResult.getStrictJson());
    assertNull(actualLoadStorePropertiesResult.getMapFactoryConfig());
    assertNull(actualLoadStorePropertiesResult.getCacheServiceClass());
    assertNull(actualLoadStorePropertiesResult.getDefaultCacheServiceClass());
    assertNull(actualLoadStorePropertiesResult.getJobTrackerCacheServiceClass());
    assertNull(actualLoadStorePropertiesResult.getJsonSerialiserClass());
    assertNull(actualLoadStorePropertiesResult.getNamedOperationCacheServiceClass());
    assertNull(actualLoadStorePropertiesResult.getNamedViewCacheServiceClass());
    assertNull(actualLoadStorePropertiesResult.getOperationDeclarationPaths());
    assertNull(actualLoadStorePropertiesResult.getReflectionPackages());
    assertNull(actualLoadStorePropertiesResult.getStoreClass());
    assertEquals(0, actualLoadStorePropertiesResult.getIngestBufferSize());
    Properties properties = actualLoadStorePropertiesResult.getProperties();
    assertEquals(1, properties.size());
    assertEquals(50, actualLoadStorePropertiesResult.getJobExecutorThreadCount().intValue());
    assertFalse(actualLoadStorePropertiesResult.getJobTrackerEnabled());
    assertFalse(actualLoadStorePropertiesResult.getRescheduleJobsOnStart());
    assertTrue(properties.containsKey("gaffer.store.properties.class"));
    assertTrue(actualLoadStorePropertiesResult.getCreateIndex());
    assertTrue(actualLoadStorePropertiesResult.getNamedOperationEnabled());
    assertTrue(actualLoadStorePropertiesResult.getNamedViewEnabled());
    Class<MapStoreProperties> expectedStorePropertiesClass = MapStoreProperties.class;
    assertEquals(expectedStorePropertiesClass, actualLoadStorePropertiesResult.getStorePropertiesClass());
    Class<Schema> expectedSchemaClass = Schema.class;
    assertEquals(expectedSchemaClass, actualLoadStorePropertiesResult.getSchemaClass());
  }

  /**
   * Test {@link MapStoreProperties#loadStoreProperties(InputStream)} with {@code storePropertiesStream}.
   * <p>
   * Method under test: {@link MapStoreProperties#loadStoreProperties(InputStream)}
   */
  @Test
  @DisplayName("Test loadStoreProperties(InputStream) with 'storePropertiesStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MapStoreProperties MapStoreProperties.loadStoreProperties(InputStream)"})
  void testLoadStorePropertiesWithStorePropertiesStream() {
    // Arrange and Act
    MapStoreProperties actualLoadStorePropertiesResult = MapStoreProperties.loadStoreProperties((InputStream) null);

    // Assert
    assertEquals("", actualLoadStorePropertiesResult.getAdminAuth());
    assertEquals("uk.gov.gchq.gaffer.mapstore.MapStoreProperties",
        actualLoadStorePropertiesResult.getStorePropertiesClassName());
    assertEquals("uk.gov.gchq.gaffer.mapstore.factory.SimpleMapFactory",
        actualLoadStorePropertiesResult.getMapFactory());
    assertEquals("uk.gov.gchq.gaffer.sketches.serialisation.json.SketchesJsonModules,",
        actualLoadStorePropertiesResult.getJsonSerialiserModules());
    assertEquals("uk.gov.gchq.gaffer.store.schema.Schema", actualLoadStorePropertiesResult.getSchemaClassName());
    assertNull(null);
    assertNull(actualLoadStorePropertiesResult.getStrictJson());
    assertNull(actualLoadStorePropertiesResult.getMapFactoryConfig());
    assertNull(actualLoadStorePropertiesResult.getCacheServiceClass());
    assertNull(actualLoadStorePropertiesResult.getDefaultCacheServiceClass());
    assertNull(actualLoadStorePropertiesResult.getJobTrackerCacheServiceClass());
    assertNull(actualLoadStorePropertiesResult.getJsonSerialiserClass());
    assertNull(actualLoadStorePropertiesResult.getNamedOperationCacheServiceClass());
    assertNull(actualLoadStorePropertiesResult.getNamedViewCacheServiceClass());
    assertNull(actualLoadStorePropertiesResult.getOperationDeclarationPaths());
    assertNull(actualLoadStorePropertiesResult.getReflectionPackages());
    assertNull(actualLoadStorePropertiesResult.getStoreClass());
    assertEquals(0, actualLoadStorePropertiesResult.getIngestBufferSize());
    Properties properties = actualLoadStorePropertiesResult.getProperties();
    assertEquals(1, properties.size());
    assertEquals(50, actualLoadStorePropertiesResult.getJobExecutorThreadCount().intValue());
    assertFalse(actualLoadStorePropertiesResult.getJobTrackerEnabled());
    assertFalse(actualLoadStorePropertiesResult.getRescheduleJobsOnStart());
    assertTrue(properties.containsKey("gaffer.store.properties.class"));
    assertTrue(actualLoadStorePropertiesResult.getCreateIndex());
    assertTrue(actualLoadStorePropertiesResult.getNamedOperationEnabled());
    assertTrue(actualLoadStorePropertiesResult.getNamedViewEnabled());
    Class<MapStoreProperties> expectedStorePropertiesClass = MapStoreProperties.class;
    assertEquals(expectedStorePropertiesClass, actualLoadStorePropertiesResult.getStorePropertiesClass());
    Class<Schema> expectedSchemaClass = Schema.class;
    assertEquals(expectedSchemaClass, actualLoadStorePropertiesResult.getSchemaClass());
  }

  /**
   * Test {@link MapStoreProperties#loadStoreProperties(InputStream)} with {@code storePropertiesStream}.
   * <ul>
   *   <li>Then return Properties size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link MapStoreProperties#loadStoreProperties(InputStream)}
   */
  @Test
  @DisplayName("Test loadStoreProperties(InputStream) with 'storePropertiesStream'; then return Properties size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MapStoreProperties MapStoreProperties.loadStoreProperties(InputStream)"})
  void testLoadStorePropertiesWithStorePropertiesStream_thenReturnPropertiesSizeIsTwo() throws IOException {
    // Arrange
    ByteArrayInputStream storePropertiesStream = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    Properties properties = MapStoreProperties.loadStoreProperties(storePropertiesStream).getProperties();
    assertEquals(2, properties.size());
    assertEquals("", properties.get("AXAXAXAX"));
    assertEquals(-1, storePropertiesStream.read(new byte[]{}));
    assertTrue(properties.containsKey("gaffer.store.properties.class"));
  }

  /**
   * Test {@link MapStoreProperties#clone()}.
   * <ul>
   *   <li>Given {@link MapStoreProperties#MapStoreProperties()}.</li>
   *   <li>Then return {@link MapStoreProperties#MapStoreProperties()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MapStoreProperties#clone()}
   */
  @Test
  @DisplayName("Test clone(); given MapStoreProperties(); then return MapStoreProperties()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MapStoreProperties MapStoreProperties.clone()"})
  void testClone_givenMapStoreProperties_thenReturnMapStoreProperties() {
    // Arrange
    MapStoreProperties mapStoreProperties = new MapStoreProperties();

    // Act and Assert
    assertEquals(mapStoreProperties, mapStoreProperties.clone());
  }

  /**
   * Test {@link MapStoreProperties#setCreateIndex(boolean)}.
   * <p>
   * Method under test: {@link MapStoreProperties#setCreateIndex(boolean)}
   */
  @Test
  @DisplayName("Test setCreateIndex(boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void MapStoreProperties.setCreateIndex(boolean)"})
  void testSetCreateIndex() {
    // Arrange
    MapStoreProperties mapStoreProperties = new MapStoreProperties();

    // Act
    mapStoreProperties.setCreateIndex(true);

    // Assert
    Properties properties = mapStoreProperties.getProperties();
    assertEquals(3, properties.size());
    assertTrue(properties.containsKey("gaffer.store.class"));
    assertTrue(properties.containsKey("gaffer.store.properties.class"));
    String expectedString = Boolean.TRUE.toString();
    assertEquals(expectedString, properties.get(MapStoreProperties.CREATE_INDEX));
  }

  /**
   * Test {@link MapStoreProperties#getCreateIndex()}.
   * <ul>
   *   <li>Given {@link MapStoreProperties#MapStoreProperties()} {@link MapStoreProperties#CREATE_INDEX} is {@code 42}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MapStoreProperties#getCreateIndex()}
   */
  @Test
  @DisplayName("Test getCreateIndex(); given MapStoreProperties() CREATE_INDEX is '42'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MapStoreProperties.getCreateIndex()"})
  void testGetCreateIndex_givenMapStorePropertiesCreate_indexIs42_thenReturnFalse() {
    // Arrange
    MapStoreProperties mapStoreProperties = new MapStoreProperties();
    mapStoreProperties.set(MapStoreProperties.CREATE_INDEX, "42");

    // Act and Assert
    assertFalse(mapStoreProperties.getCreateIndex());
  }

  /**
   * Test {@link MapStoreProperties#getCreateIndex()}.
   * <ul>
   *   <li>Given {@link MapStoreProperties#MapStoreProperties()}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MapStoreProperties#getCreateIndex()}
   */
  @Test
  @DisplayName("Test getCreateIndex(); given MapStoreProperties(); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MapStoreProperties.getCreateIndex()"})
  void testGetCreateIndex_givenMapStoreProperties_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new MapStoreProperties()).getCreateIndex());
  }

  /**
   * Test {@link MapStoreProperties#getMapFactory()}.
   * <p>
   * Method under test: {@link MapStoreProperties#getMapFactory()}
   */
  @Test
  @DisplayName("Test getMapFactory()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String MapStoreProperties.getMapFactory()"})
  void testGetMapFactory() {
    // Arrange, Act and Assert
    assertEquals("uk.gov.gchq.gaffer.mapstore.factory.SimpleMapFactory", (new MapStoreProperties()).getMapFactory());
  }

  /**
   * Test {@link MapStoreProperties#setMapFactory(Class)} with {@code Class}.
   * <ul>
   *   <li>Then {@link MapStoreProperties#MapStoreProperties()} Properties size is three.</li>
   * </ul>
   * <p>
   * Method under test: {@link MapStoreProperties#setMapFactory(Class)}
   */
  @Test
  @DisplayName("Test setMapFactory(Class) with 'Class'; then MapStoreProperties() Properties size is three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void MapStoreProperties.setMapFactory(Class)"})
  void testSetMapFactoryWithClass_thenMapStorePropertiesPropertiesSizeIsThree() {
    // Arrange
    MapStoreProperties mapStoreProperties = new MapStoreProperties();

    // Act
    mapStoreProperties.setMapFactory(MapStoreProperties.MAP_FACTORY_DEFAULT);

    // Assert
    Properties properties = mapStoreProperties.getProperties();
    assertEquals(3, properties.size());
    assertEquals("uk.gov.gchq.gaffer.mapstore.factory.SimpleMapFactory",
        properties.get(MapStoreProperties.MAP_FACTORY));
    assertTrue(properties.containsKey("gaffer.store.class"));
    assertTrue(properties.containsKey("gaffer.store.properties.class"));
  }

  /**
   * Test {@link MapStoreProperties#setMapFactory(String)} with {@code String}.
   * <p>
   * Method under test: {@link MapStoreProperties#setMapFactory(String)}
   */
  @Test
  @DisplayName("Test setMapFactory(String) with 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void MapStoreProperties.setMapFactory(String)"})
  void testSetMapFactoryWithString() {
    // Arrange
    MapStoreProperties mapStoreProperties = new MapStoreProperties();

    // Act
    mapStoreProperties.setMapFactory("Map Factory");

    // Assert
    assertEquals("Map Factory", mapStoreProperties.getMapFactory());
    Properties properties = mapStoreProperties.getProperties();
    assertEquals(3, properties.size());
    assertEquals("Map Factory", properties.get(MapStoreProperties.MAP_FACTORY));
    assertTrue(properties.containsKey("gaffer.store.class"));
    assertTrue(properties.containsKey("gaffer.store.properties.class"));
  }

  /**
   * Test {@link MapStoreProperties#getMapFactoryConfig()}.
   * <p>
   * Method under test: {@link MapStoreProperties#getMapFactoryConfig()}
   */
  @Test
  @DisplayName("Test getMapFactoryConfig()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String MapStoreProperties.getMapFactoryConfig()"})
  void testGetMapFactoryConfig() {
    // Arrange, Act and Assert
    assertNull((new MapStoreProperties()).getMapFactoryConfig());
  }

  /**
   * Test {@link MapStoreProperties#setMapFactoryConfig(String)}.
   * <p>
   * Method under test: {@link MapStoreProperties#setMapFactoryConfig(String)}
   */
  @Test
  @DisplayName("Test setMapFactoryConfig(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void MapStoreProperties.setMapFactoryConfig(String)"})
  void testSetMapFactoryConfig() {
    // Arrange
    MapStoreProperties mapStoreProperties = new MapStoreProperties();

    // Act
    mapStoreProperties.setMapFactoryConfig("Path");

    // Assert
    assertEquals("Path", mapStoreProperties.getMapFactoryConfig());
    Properties properties = mapStoreProperties.getProperties();
    assertEquals(3, properties.size());
    assertEquals("Path", properties.get(MapStoreProperties.MAP_FACTORY_CONFIG));
    assertTrue(properties.containsKey("gaffer.store.class"));
    assertTrue(properties.containsKey("gaffer.store.properties.class"));
  }

  /**
   * Test {@link MapStoreProperties#getIngestBufferSize()}.
   * <ul>
   *   <li>Given {@link MapStoreProperties#MapStoreProperties()}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link MapStoreProperties#getIngestBufferSize()}
   */
  @Test
  @DisplayName("Test getIngestBufferSize(); given MapStoreProperties(); then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int MapStoreProperties.getIngestBufferSize()"})
  void testGetIngestBufferSize_givenMapStoreProperties_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, (new MapStoreProperties()).getIngestBufferSize());
  }

  /**
   * Test {@link MapStoreProperties#getIngestBufferSize()}.
   * <ul>
   *   <li>Then return forty-two.</li>
   * </ul>
   * <p>
   * Method under test: {@link MapStoreProperties#getIngestBufferSize()}
   */
  @Test
  @DisplayName("Test getIngestBufferSize(); then return forty-two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int MapStoreProperties.getIngestBufferSize()"})
  void testGetIngestBufferSize_thenReturnFortyTwo() {
    // Arrange
    MapStoreProperties mapStoreProperties = new MapStoreProperties();
    mapStoreProperties.set(MapStoreProperties.INGEST_BUFFER_SIZE, "42");

    // Act and Assert
    assertEquals(42, mapStoreProperties.getIngestBufferSize());
  }

  /**
   * Test {@link MapStoreProperties#setIngestBufferSize(int)}.
   * <p>
   * Method under test: {@link MapStoreProperties#setIngestBufferSize(int)}
   */
  @Test
  @DisplayName("Test setIngestBufferSize(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void MapStoreProperties.setIngestBufferSize(int)"})
  void testSetIngestBufferSize() {
    // Arrange
    MapStoreProperties mapStoreProperties = new MapStoreProperties();

    // Act
    mapStoreProperties.setIngestBufferSize(3);

    // Assert
    Properties properties = mapStoreProperties.getProperties();
    assertEquals(3, properties.size());
    assertEquals("3", properties.get(MapStoreProperties.INGEST_BUFFER_SIZE));
    assertEquals(3, mapStoreProperties.getIngestBufferSize());
    assertTrue(properties.containsKey("gaffer.store.class"));
    assertTrue(properties.containsKey("gaffer.store.properties.class"));
  }

  /**
   * Test {@link MapStoreProperties#isStaticMap()}.
   * <p>
   * Method under test: {@link MapStoreProperties#isStaticMap()}
   */
  @Test
  @DisplayName("Test isStaticMap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MapStoreProperties.isStaticMap()"})
  void testIsStaticMap() {
    // Arrange, Act and Assert
    assertFalse((new MapStoreProperties()).isStaticMap());
  }

  /**
   * Test {@link MapStoreProperties#setStaticMap(boolean)}.
   * <p>
   * Method under test: {@link MapStoreProperties#setStaticMap(boolean)}
   */
  @Test
  @DisplayName("Test setStaticMap(boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void MapStoreProperties.setStaticMap(boolean)"})
  void testSetStaticMap() {
    // Arrange
    MapStoreProperties mapStoreProperties = new MapStoreProperties();

    // Act
    mapStoreProperties.setStaticMap(true);

    // Assert
    Properties properties = mapStoreProperties.getProperties();
    assertEquals(3, properties.size());
    assertTrue(properties.containsKey("gaffer.store.class"));
    assertTrue(properties.containsKey("gaffer.store.properties.class"));
    String expectedString = Boolean.TRUE.toString();
    assertEquals(expectedString, properties.get(MapStoreProperties.STATIC_MAP));
  }

  /**
   * Test {@link MapStoreProperties#getJsonSerialiserModules()}.
   * <p>
   * Method under test: {@link MapStoreProperties#getJsonSerialiserModules()}
   */
  @Test
  @DisplayName("Test getJsonSerialiserModules()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String MapStoreProperties.getJsonSerialiserModules()"})
  void testGetJsonSerialiserModules() {
    // Arrange, Act and Assert
    assertEquals("uk.gov.gchq.gaffer.sketches.serialisation.json.SketchesJsonModules,",
        (new MapStoreProperties()).getJsonSerialiserModules());
  }
}
