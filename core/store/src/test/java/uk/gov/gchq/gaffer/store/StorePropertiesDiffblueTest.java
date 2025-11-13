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

package uk.gov.gchq.gaffer.store;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.elementdefinition.exception.SchemaException;
import uk.gov.gchq.gaffer.jsonserialisation.JSONSerialiser;
import uk.gov.gchq.gaffer.store.schema.Schema;

class StorePropertiesDiffblueTest {
  /**
   * Test {@link StoreProperties#StoreProperties()}.
   * <p>
   * Method under test: {@link StoreProperties#StoreProperties()}
   */
  @Test
  @DisplayName("Test new StoreProperties()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void StoreProperties.<init>()"})
  void testNewStoreProperties() {
    // Arrange and Act
    StoreProperties actualStoreProperties = new StoreProperties();

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
    Properties properties = actualStoreProperties.getProperties();
    assertEquals(1, properties.size());
    assertEquals(50, actualStoreProperties.getJobExecutorThreadCount().intValue());
    assertFalse(actualStoreProperties.getJobTrackerEnabled());
    assertFalse(actualStoreProperties.getRescheduleJobsOnStart());
    assertTrue(properties.containsKey(StoreProperties.STORE_PROPERTIES_CLASS));
    assertTrue(actualStoreProperties.getNamedOperationEnabled());
    assertTrue(actualStoreProperties.getNamedViewEnabled());
    Class<StoreProperties> expectedStorePropertiesClass = StoreProperties.class;
    assertEquals(expectedStorePropertiesClass, actualStoreProperties.getStorePropertiesClass());
    Class<Schema> expectedSchemaClass = Schema.class;
    assertEquals(expectedSchemaClass, actualStoreProperties.getSchemaClass());
  }

  /**
   * Test {@link StoreProperties#StoreProperties(Class)}.
   * <ul>
   *   <li>Then return AdminAuth is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link StoreProperties#StoreProperties(Class)}
   */
  @Test
  @DisplayName("Test new StoreProperties(Class); then return AdminAuth is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void StoreProperties.<init>(Class)"})
  void testNewStoreProperties_thenReturnAdminAuthIsEmptyString() {
    // Arrange
    Class<Store> storeClass = Store.class;

    // Act
    StoreProperties actualStoreProperties = new StoreProperties(storeClass);

    // Assert
    assertEquals("", actualStoreProperties.getAdminAuth());
    assertEquals("", actualStoreProperties.getJsonSerialiserModules());
    assertEquals("uk.gov.gchq.gaffer.store.Store", actualStoreProperties.getStoreClass());
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
    Properties properties = actualStoreProperties.getProperties();
    assertEquals(2, properties.size());
    assertEquals(50, actualStoreProperties.getJobExecutorThreadCount().intValue());
    assertFalse(actualStoreProperties.getJobTrackerEnabled());
    assertFalse(actualStoreProperties.getRescheduleJobsOnStart());
    assertTrue(properties.containsKey(StoreProperties.STORE_CLASS));
    assertTrue(properties.containsKey(StoreProperties.STORE_PROPERTIES_CLASS));
    assertTrue(actualStoreProperties.getNamedOperationEnabled());
    assertTrue(actualStoreProperties.getNamedViewEnabled());
    Class<StoreProperties> expectedStorePropertiesClass = StoreProperties.class;
    assertEquals(expectedStorePropertiesClass, actualStoreProperties.getStorePropertiesClass());
    Class<Schema> expectedSchemaClass = Schema.class;
    assertEquals(expectedSchemaClass, actualStoreProperties.getSchemaClass());
  }

  /**
   * Test {@link StoreProperties#StoreProperties(Path)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return AdminAuth is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link StoreProperties#StoreProperties(Path)}
   */
  @Test
  @DisplayName("Test new StoreProperties(Path); when 'null'; then return AdminAuth is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void StoreProperties.<init>(Path)"})
  void testNewStoreProperties_whenNull_thenReturnAdminAuthIsEmptyString() {
    // Arrange and Act
    StoreProperties actualStoreProperties = new StoreProperties((Path) null);

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
    Properties properties = actualStoreProperties.getProperties();
    assertEquals(1, properties.size());
    assertEquals(50, actualStoreProperties.getJobExecutorThreadCount().intValue());
    assertFalse(actualStoreProperties.getJobTrackerEnabled());
    assertFalse(actualStoreProperties.getRescheduleJobsOnStart());
    assertTrue(properties.containsKey(StoreProperties.STORE_PROPERTIES_CLASS));
    assertTrue(actualStoreProperties.getNamedOperationEnabled());
    assertTrue(actualStoreProperties.getNamedViewEnabled());
    Class<StoreProperties> expectedStorePropertiesClass = StoreProperties.class;
    assertEquals(expectedStorePropertiesClass, actualStoreProperties.getStorePropertiesClass());
    Class<Schema> expectedSchemaClass = Schema.class;
    assertEquals(expectedSchemaClass, actualStoreProperties.getSchemaClass());
  }

  /**
   * Test {@link StoreProperties#StoreProperties(Path, Class)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return AdminAuth is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link StoreProperties#StoreProperties(Path, Class)}
   */
  @Test
  @DisplayName("Test new StoreProperties(Path, Class); when 'null'; then return AdminAuth is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void StoreProperties.<init>(Path, Class)"})
  void testNewStoreProperties_whenNull_thenReturnAdminAuthIsEmptyString2() {
    // Arrange
    Class<Store> storeClass = Store.class;

    // Act
    StoreProperties actualStoreProperties = new StoreProperties((Path) null, storeClass);

    // Assert
    assertEquals("", actualStoreProperties.getAdminAuth());
    assertEquals("", actualStoreProperties.getJsonSerialiserModules());
    assertEquals("uk.gov.gchq.gaffer.store.Store", actualStoreProperties.getStoreClass());
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
    Properties properties = actualStoreProperties.getProperties();
    assertEquals(2, properties.size());
    assertEquals(50, actualStoreProperties.getJobExecutorThreadCount().intValue());
    assertFalse(actualStoreProperties.getJobTrackerEnabled());
    assertFalse(actualStoreProperties.getRescheduleJobsOnStart());
    assertTrue(properties.containsKey(StoreProperties.STORE_CLASS));
    assertTrue(properties.containsKey(StoreProperties.STORE_PROPERTIES_CLASS));
    assertTrue(actualStoreProperties.getNamedOperationEnabled());
    assertTrue(actualStoreProperties.getNamedViewEnabled());
    Class<StoreProperties> expectedStorePropertiesClass = StoreProperties.class;
    assertEquals(expectedStorePropertiesClass, actualStoreProperties.getStorePropertiesClass());
    Class<Schema> expectedSchemaClass = Schema.class;
    assertEquals(expectedSchemaClass, actualStoreProperties.getSchemaClass());
  }

  /**
   * Test {@link StoreProperties#StoreProperties(Properties)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return Properties size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link StoreProperties#StoreProperties(Properties)}
   */
  @Test
  @DisplayName("Test new StoreProperties(Properties); when 'null'; then return Properties size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void StoreProperties.<init>(Properties)"})
  void testNewStoreProperties_whenNull_thenReturnPropertiesSizeIsOne() {
    // Arrange, Act and Assert
    Properties properties = (new StoreProperties((Properties) null)).getProperties();
    assertEquals(1, properties.size());
    assertEquals("uk.gov.gchq.gaffer.store.StoreProperties", properties.get(StoreProperties.STORE_PROPERTIES_CLASS));
    assertNull(null);
  }

  /**
   * Test {@link StoreProperties#StoreProperties(Properties, Class)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return Properties size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link StoreProperties#StoreProperties(Properties, Class)}
   */
  @Test
  @DisplayName("Test new StoreProperties(Properties, Class); when 'null'; then return Properties size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void StoreProperties.<init>(Properties, Class)"})
  void testNewStoreProperties_whenNull_thenReturnPropertiesSizeIsTwo() {
    // Arrange
    Class<Store> storeClass = Store.class;

    // Act and Assert
    Properties properties = (new StoreProperties((Properties) null, storeClass)).getProperties();
    assertEquals(2, properties.size());
    assertEquals("uk.gov.gchq.gaffer.store.Store", properties.get(StoreProperties.STORE_CLASS));
    assertEquals("uk.gov.gchq.gaffer.store.StoreProperties", properties.get(StoreProperties.STORE_PROPERTIES_CLASS));
    assertNull(null);
  }

  /**
   * Test {@link StoreProperties#StoreProperties(Properties)}.
   * <ul>
   *   <li>When {@link Properties#Properties()}.</li>
   *   <li>Then {@link Properties#Properties()} size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link StoreProperties#StoreProperties(Properties)}
   */
  @Test
  @DisplayName("Test new StoreProperties(Properties); when Properties(); then Properties() size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void StoreProperties.<init>(Properties)"})
  void testNewStoreProperties_whenProperties_thenPropertiesSizeIsOne() {
    // Arrange
    Properties props = new Properties();

    // Act
    StoreProperties actualStoreProperties = new StoreProperties(props);

    // Assert
    assertEquals(1, props.size());
    assertEquals("uk.gov.gchq.gaffer.store.StoreProperties", props.get(StoreProperties.STORE_PROPERTIES_CLASS));
    assertSame(props, actualStoreProperties.getProperties());
  }

  /**
   * Test {@link StoreProperties#StoreProperties(Properties, Class)}.
   * <ul>
   *   <li>When {@link Properties#Properties()}.</li>
   *   <li>Then {@link Properties#Properties()} size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link StoreProperties#StoreProperties(Properties, Class)}
   */
  @Test
  @DisplayName("Test new StoreProperties(Properties, Class); when Properties(); then Properties() size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void StoreProperties.<init>(Properties, Class)"})
  void testNewStoreProperties_whenProperties_thenPropertiesSizeIsTwo() {
    // Arrange
    Properties props = new Properties();
    Class<Store> storeClass = Store.class;

    // Act
    StoreProperties actualStoreProperties = new StoreProperties(props, storeClass);

    // Assert
    assertEquals(2, props.size());
    assertEquals("uk.gov.gchq.gaffer.store.Store", props.get(StoreProperties.STORE_CLASS));
    assertEquals("uk.gov.gchq.gaffer.store.StoreProperties", props.get(StoreProperties.STORE_PROPERTIES_CLASS));
    assertSame(props, actualStoreProperties.getProperties());
  }

  /**
   * Test {@link StoreProperties#StoreProperties(Path)}.
   * <ul>
   *   <li>When Property is {@code java.io.tmpdir} is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link StoreProperties#StoreProperties(Path)}
   */
  @Test
  @DisplayName("Test new StoreProperties(Path); when Property is 'java.io.tmpdir' is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void StoreProperties.<init>(Path)"})
  void testNewStoreProperties_whenPropertyIsJavaIoTmpdirIsEmptyString() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class,
        () -> new StoreProperties(Paths.get(System.getProperty("java.io.tmpdir"), "")));
  }

  /**
   * Test {@link StoreProperties#StoreProperties(Path, Class)}.
   * <ul>
   *   <li>When Property is {@code java.io.tmpdir} is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link StoreProperties#StoreProperties(Path, Class)}
   */
  @Test
  @DisplayName("Test new StoreProperties(Path, Class); when Property is 'java.io.tmpdir' is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void StoreProperties.<init>(Path, Class)"})
  void testNewStoreProperties_whenPropertyIsJavaIoTmpdirIsEmptyString2() {
    // Arrange
    Path propFileLocation = Paths.get(System.getProperty("java.io.tmpdir"), "");
    Class<Store> storeClass = Store.class;

    // Act and Assert
    assertThrows(RuntimeException.class, () -> new StoreProperties(propFileLocation, storeClass));

  }

  /**
   * Test {@link StoreProperties#StoreProperties(Path)}.
   * <ul>
   *   <li>When Property is {@code java.io.tmpdir} is {@code test.txt}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StoreProperties#StoreProperties(Path)}
   */
  @Test
  @DisplayName("Test new StoreProperties(Path); when Property is 'java.io.tmpdir' is 'test.txt'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void StoreProperties.<init>(Path)"})
  void testNewStoreProperties_whenPropertyIsJavaIoTmpdirIsTestTxt() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class,
        () -> new StoreProperties(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt")));
  }

  /**
   * Test {@link StoreProperties#StoreProperties(Path, Class)}.
   * <ul>
   *   <li>When Property is {@code java.io.tmpdir} is {@code test.txt}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StoreProperties#StoreProperties(Path, Class)}
   */
  @Test
  @DisplayName("Test new StoreProperties(Path, Class); when Property is 'java.io.tmpdir' is 'test.txt'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void StoreProperties.<init>(Path, Class)"})
  void testNewStoreProperties_whenPropertyIsJavaIoTmpdirIsTestTxt2() {
    // Arrange
    Path propFileLocation = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");
    Class<Store> storeClass = Store.class;

    // Act and Assert
    assertThrows(RuntimeException.class, () -> new StoreProperties(propFileLocation, storeClass));

  }

  /**
   * Test {@link StoreProperties#loadStoreProperties(String, Class)} with {@code pathStr}, {@code requiredClass}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StoreProperties#loadStoreProperties(String, Class)}
   */
  @Test
  @DisplayName("Test loadStoreProperties(String, Class) with 'pathStr', 'requiredClass'; then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"StoreProperties StoreProperties.loadStoreProperties(String, Class)"})
  void testLoadStorePropertiesWithPathStrRequiredClass_thenThrowRuntimeException() {
    // Arrange
    Class<StoreProperties> requiredClass = StoreProperties.class;

    // Act and Assert
    assertThrows(RuntimeException.class, () -> StoreProperties.loadStoreProperties("/", requiredClass));
  }

  /**
   * Test {@link StoreProperties#loadStoreProperties(String)} with {@code pathStr}.
   * <ul>
   *   <li>When {@code /}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StoreProperties#loadStoreProperties(String)}
   */
  @Test
  @DisplayName("Test loadStoreProperties(String) with 'pathStr'; when '/'; then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"StoreProperties StoreProperties.loadStoreProperties(String)"})
  void testLoadStorePropertiesWithPathStr_whenSlash_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> StoreProperties.loadStoreProperties("/"));
  }

  /**
   * Test {@link StoreProperties#loadStoreProperties(Properties, Class)} with {@code props}, {@code requiredClass}.
   * <ul>
   *   <li>Then return AdminAuth is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link StoreProperties#loadStoreProperties(Properties, Class)}
   */
  @Test
  @DisplayName("Test loadStoreProperties(Properties, Class) with 'props', 'requiredClass'; then return AdminAuth is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"StoreProperties StoreProperties.loadStoreProperties(Properties, Class)"})
  void testLoadStorePropertiesWithPropsRequiredClass_thenReturnAdminAuthIsEmptyString() {
    // Arrange
    Properties props = new Properties();
    Class<StoreProperties> requiredClass = StoreProperties.class;

    // Act
    StoreProperties actualLoadStorePropertiesResult = StoreProperties.loadStoreProperties(props, requiredClass);

    // Assert
    assertEquals("", actualLoadStorePropertiesResult.getAdminAuth());
    assertEquals("", actualLoadStorePropertiesResult.getJsonSerialiserModules());
    assertEquals("uk.gov.gchq.gaffer.store.StoreProperties",
        actualLoadStorePropertiesResult.getStorePropertiesClassName());
    assertEquals("uk.gov.gchq.gaffer.store.schema.Schema", actualLoadStorePropertiesResult.getSchemaClassName());
    assertNull(actualLoadStorePropertiesResult.getStrictJson());
    assertNull(actualLoadStorePropertiesResult.getCacheServiceClass());
    assertNull(actualLoadStorePropertiesResult.getDefaultCacheServiceClass());
    assertNull(actualLoadStorePropertiesResult.getJobTrackerCacheServiceClass());
    assertNull(actualLoadStorePropertiesResult.getJsonSerialiserClass());
    assertNull(actualLoadStorePropertiesResult.getNamedOperationCacheServiceClass());
    assertNull(actualLoadStorePropertiesResult.getNamedViewCacheServiceClass());
    assertNull(actualLoadStorePropertiesResult.getOperationDeclarationPaths());
    assertNull(actualLoadStorePropertiesResult.getReflectionPackages());
    assertNull(actualLoadStorePropertiesResult.getStoreClass());
    assertEquals(50, actualLoadStorePropertiesResult.getJobExecutorThreadCount().intValue());
    assertFalse(actualLoadStorePropertiesResult.getJobTrackerEnabled());
    assertFalse(actualLoadStorePropertiesResult.getRescheduleJobsOnStart());
    assertTrue(actualLoadStorePropertiesResult.getNamedOperationEnabled());
    assertTrue(actualLoadStorePropertiesResult.getNamedViewEnabled());
    Class<StoreProperties> expectedStorePropertiesClass = StoreProperties.class;
    assertEquals(expectedStorePropertiesClass, actualLoadStorePropertiesResult.getStorePropertiesClass());
    Class<Schema> expectedSchemaClass = Schema.class;
    assertEquals(expectedSchemaClass, actualLoadStorePropertiesResult.getSchemaClass());
    assertSame(props, actualLoadStorePropertiesResult.getProperties());
  }

  /**
   * Test {@link StoreProperties#loadStoreProperties(Properties)} with {@code props}.
   * <ul>
   *   <li>When {@link Properties#Properties()}.</li>
   *   <li>Then return AdminAuth is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link StoreProperties#loadStoreProperties(Properties)}
   */
  @Test
  @DisplayName("Test loadStoreProperties(Properties) with 'props'; when Properties(); then return AdminAuth is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"StoreProperties StoreProperties.loadStoreProperties(Properties)"})
  void testLoadStorePropertiesWithProps_whenProperties_thenReturnAdminAuthIsEmptyString() {
    // Arrange
    Properties props = new Properties();

    // Act
    StoreProperties actualLoadStorePropertiesResult = StoreProperties.loadStoreProperties(props);

    // Assert
    assertEquals("", actualLoadStorePropertiesResult.getAdminAuth());
    assertEquals("", actualLoadStorePropertiesResult.getJsonSerialiserModules());
    assertEquals("uk.gov.gchq.gaffer.store.StoreProperties",
        actualLoadStorePropertiesResult.getStorePropertiesClassName());
    assertEquals("uk.gov.gchq.gaffer.store.schema.Schema", actualLoadStorePropertiesResult.getSchemaClassName());
    assertNull(actualLoadStorePropertiesResult.getStrictJson());
    assertNull(actualLoadStorePropertiesResult.getCacheServiceClass());
    assertNull(actualLoadStorePropertiesResult.getDefaultCacheServiceClass());
    assertNull(actualLoadStorePropertiesResult.getJobTrackerCacheServiceClass());
    assertNull(actualLoadStorePropertiesResult.getJsonSerialiserClass());
    assertNull(actualLoadStorePropertiesResult.getNamedOperationCacheServiceClass());
    assertNull(actualLoadStorePropertiesResult.getNamedViewCacheServiceClass());
    assertNull(actualLoadStorePropertiesResult.getOperationDeclarationPaths());
    assertNull(actualLoadStorePropertiesResult.getReflectionPackages());
    assertNull(actualLoadStorePropertiesResult.getStoreClass());
    assertEquals(50, actualLoadStorePropertiesResult.getJobExecutorThreadCount().intValue());
    assertFalse(actualLoadStorePropertiesResult.getJobTrackerEnabled());
    assertFalse(actualLoadStorePropertiesResult.getRescheduleJobsOnStart());
    assertTrue(actualLoadStorePropertiesResult.getNamedOperationEnabled());
    assertTrue(actualLoadStorePropertiesResult.getNamedViewEnabled());
    Class<StoreProperties> expectedStorePropertiesClass = StoreProperties.class;
    assertEquals(expectedStorePropertiesClass, actualLoadStorePropertiesResult.getStorePropertiesClass());
    Class<Schema> expectedSchemaClass = Schema.class;
    assertEquals(expectedSchemaClass, actualLoadStorePropertiesResult.getSchemaClass());
    assertSame(props, actualLoadStorePropertiesResult.getProperties());
  }

  /**
   * Test {@link StoreProperties#loadStoreProperties(Path)} with {@code storePropertiesPath}.
   * <p>
   * Method under test: {@link StoreProperties#loadStoreProperties(Path)}
   */
  @Test
  @DisplayName("Test loadStoreProperties(Path) with 'storePropertiesPath'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"StoreProperties StoreProperties.loadStoreProperties(Path)"})
  void testLoadStorePropertiesWithStorePropertiesPath() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class,
        () -> StoreProperties.loadStoreProperties(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt")));
  }

  /**
   * Test {@link StoreProperties#loadStoreProperties(Path)} with {@code storePropertiesPath}.
   * <p>
   * Method under test: {@link StoreProperties#loadStoreProperties(Path)}
   */
  @Test
  @DisplayName("Test loadStoreProperties(Path) with 'storePropertiesPath'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"StoreProperties StoreProperties.loadStoreProperties(Path)"})
  void testLoadStorePropertiesWithStorePropertiesPath2() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class,
        () -> StoreProperties.loadStoreProperties(Paths.get(System.getProperty("java.io.tmpdir"), "")));
  }

  /**
   * Test {@link StoreProperties#loadStoreProperties(Path, Class)} with {@code storePropertiesPath}, {@code requiredClass}.
   * <p>
   * Method under test: {@link StoreProperties#loadStoreProperties(Path, Class)}
   */
  @Test
  @DisplayName("Test loadStoreProperties(Path, Class) with 'storePropertiesPath', 'requiredClass'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"StoreProperties StoreProperties.loadStoreProperties(Path, Class)"})
  void testLoadStorePropertiesWithStorePropertiesPathRequiredClass() {
    // Arrange
    Path storePropertiesPath = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");
    Class<StoreProperties> requiredClass = StoreProperties.class;

    // Act and Assert
    assertThrows(RuntimeException.class, () -> StoreProperties.loadStoreProperties(storePropertiesPath, requiredClass));
  }

  /**
   * Test {@link StoreProperties#loadStoreProperties(Path, Class)} with {@code storePropertiesPath}, {@code requiredClass}.
   * <p>
   * Method under test: {@link StoreProperties#loadStoreProperties(Path, Class)}
   */
  @Test
  @DisplayName("Test loadStoreProperties(Path, Class) with 'storePropertiesPath', 'requiredClass'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"StoreProperties StoreProperties.loadStoreProperties(Path, Class)"})
  void testLoadStorePropertiesWithStorePropertiesPathRequiredClass2() {
    // Arrange
    Class<StoreProperties> requiredClass = StoreProperties.class;

    // Act
    StoreProperties actualLoadStorePropertiesResult = StoreProperties.loadStoreProperties((Path) null, requiredClass);

    // Assert
    assertEquals("", actualLoadStorePropertiesResult.getAdminAuth());
    assertEquals("", actualLoadStorePropertiesResult.getJsonSerialiserModules());
    assertEquals("uk.gov.gchq.gaffer.store.StoreProperties",
        actualLoadStorePropertiesResult.getStorePropertiesClassName());
    assertEquals("uk.gov.gchq.gaffer.store.schema.Schema", actualLoadStorePropertiesResult.getSchemaClassName());
    assertNull(actualLoadStorePropertiesResult.getStrictJson());
    assertNull(actualLoadStorePropertiesResult.getCacheServiceClass());
    assertNull(actualLoadStorePropertiesResult.getDefaultCacheServiceClass());
    assertNull(actualLoadStorePropertiesResult.getJobTrackerCacheServiceClass());
    assertNull(actualLoadStorePropertiesResult.getJsonSerialiserClass());
    assertNull(actualLoadStorePropertiesResult.getNamedOperationCacheServiceClass());
    assertNull(actualLoadStorePropertiesResult.getNamedViewCacheServiceClass());
    assertNull(actualLoadStorePropertiesResult.getOperationDeclarationPaths());
    assertNull(actualLoadStorePropertiesResult.getReflectionPackages());
    assertNull(actualLoadStorePropertiesResult.getStoreClass());
    Properties properties = actualLoadStorePropertiesResult.getProperties();
    assertEquals(1, properties.size());
    assertEquals(50, actualLoadStorePropertiesResult.getJobExecutorThreadCount().intValue());
    assertFalse(actualLoadStorePropertiesResult.getJobTrackerEnabled());
    assertFalse(actualLoadStorePropertiesResult.getRescheduleJobsOnStart());
    assertTrue(properties.containsKey(StoreProperties.STORE_PROPERTIES_CLASS));
    assertTrue(actualLoadStorePropertiesResult.getNamedOperationEnabled());
    assertTrue(actualLoadStorePropertiesResult.getNamedViewEnabled());
    Class<StoreProperties> expectedStorePropertiesClass = StoreProperties.class;
    assertEquals(expectedStorePropertiesClass, actualLoadStorePropertiesResult.getStorePropertiesClass());
    Class<Schema> expectedSchemaClass = Schema.class;
    assertEquals(expectedSchemaClass, actualLoadStorePropertiesResult.getSchemaClass());
  }

  /**
   * Test {@link StoreProperties#loadStoreProperties(Path, Class)} with {@code storePropertiesPath}, {@code requiredClass}.
   * <p>
   * Method under test: {@link StoreProperties#loadStoreProperties(Path, Class)}
   */
  @Test
  @DisplayName("Test loadStoreProperties(Path, Class) with 'storePropertiesPath', 'requiredClass'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"StoreProperties StoreProperties.loadStoreProperties(Path, Class)"})
  void testLoadStorePropertiesWithStorePropertiesPathRequiredClass3() {
    // Arrange
    Path storePropertiesPath = Paths.get(System.getProperty("java.io.tmpdir"), "");
    Class<StoreProperties> requiredClass = StoreProperties.class;

    // Act and Assert
    assertThrows(RuntimeException.class, () -> StoreProperties.loadStoreProperties(storePropertiesPath, requiredClass));
  }

  /**
   * Test {@link StoreProperties#loadStoreProperties(Path)} with {@code storePropertiesPath}.
   * <ul>
   *   <li>Then return AdminAuth is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link StoreProperties#loadStoreProperties(Path)}
   */
  @Test
  @DisplayName("Test loadStoreProperties(Path) with 'storePropertiesPath'; then return AdminAuth is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"StoreProperties StoreProperties.loadStoreProperties(Path)"})
  void testLoadStorePropertiesWithStorePropertiesPath_thenReturnAdminAuthIsEmptyString() {
    // Arrange and Act
    StoreProperties actualLoadStorePropertiesResult = StoreProperties.loadStoreProperties((Path) null);

    // Assert
    assertEquals("", actualLoadStorePropertiesResult.getAdminAuth());
    assertEquals("", actualLoadStorePropertiesResult.getJsonSerialiserModules());
    assertEquals("uk.gov.gchq.gaffer.store.StoreProperties",
        actualLoadStorePropertiesResult.getStorePropertiesClassName());
    assertEquals("uk.gov.gchq.gaffer.store.schema.Schema", actualLoadStorePropertiesResult.getSchemaClassName());
    assertNull(actualLoadStorePropertiesResult.getStrictJson());
    assertNull(actualLoadStorePropertiesResult.getCacheServiceClass());
    assertNull(actualLoadStorePropertiesResult.getDefaultCacheServiceClass());
    assertNull(actualLoadStorePropertiesResult.getJobTrackerCacheServiceClass());
    assertNull(actualLoadStorePropertiesResult.getJsonSerialiserClass());
    assertNull(actualLoadStorePropertiesResult.getNamedOperationCacheServiceClass());
    assertNull(actualLoadStorePropertiesResult.getNamedViewCacheServiceClass());
    assertNull(actualLoadStorePropertiesResult.getOperationDeclarationPaths());
    assertNull(actualLoadStorePropertiesResult.getReflectionPackages());
    assertNull(actualLoadStorePropertiesResult.getStoreClass());
    Properties properties = actualLoadStorePropertiesResult.getProperties();
    assertEquals(1, properties.size());
    assertEquals(50, actualLoadStorePropertiesResult.getJobExecutorThreadCount().intValue());
    assertFalse(actualLoadStorePropertiesResult.getJobTrackerEnabled());
    assertFalse(actualLoadStorePropertiesResult.getRescheduleJobsOnStart());
    assertTrue(properties.containsKey(StoreProperties.STORE_PROPERTIES_CLASS));
    assertTrue(actualLoadStorePropertiesResult.getNamedOperationEnabled());
    assertTrue(actualLoadStorePropertiesResult.getNamedViewEnabled());
    Class<StoreProperties> expectedStorePropertiesClass = StoreProperties.class;
    assertEquals(expectedStorePropertiesClass, actualLoadStorePropertiesResult.getStorePropertiesClass());
    Class<Schema> expectedSchemaClass = Schema.class;
    assertEquals(expectedSchemaClass, actualLoadStorePropertiesResult.getSchemaClass());
  }

  /**
   * Test {@link StoreProperties#loadStoreProperties(InputStream)} with {@code storePropertiesStream}.
   * <p>
   * Method under test: {@link StoreProperties#loadStoreProperties(InputStream)}
   */
  @Test
  @DisplayName("Test loadStoreProperties(InputStream) with 'storePropertiesStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"StoreProperties StoreProperties.loadStoreProperties(InputStream)"})
  void testLoadStorePropertiesWithStorePropertiesStream() throws IOException {
    // Arrange
    ByteArrayInputStream storePropertiesStream = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));

    // Act
    StoreProperties actualLoadStorePropertiesResult = StoreProperties.loadStoreProperties(storePropertiesStream);

    // Assert
    assertEquals("", actualLoadStorePropertiesResult.getAdminAuth());
    assertEquals("", actualLoadStorePropertiesResult.getJsonSerialiserModules());
    assertEquals("uk.gov.gchq.gaffer.store.StoreProperties",
        actualLoadStorePropertiesResult.getStorePropertiesClassName());
    assertEquals("uk.gov.gchq.gaffer.store.schema.Schema", actualLoadStorePropertiesResult.getSchemaClassName());
    assertNull(actualLoadStorePropertiesResult.getStrictJson());
    assertNull(actualLoadStorePropertiesResult.getCacheServiceClass());
    assertNull(actualLoadStorePropertiesResult.getDefaultCacheServiceClass());
    assertNull(actualLoadStorePropertiesResult.getJobTrackerCacheServiceClass());
    assertNull(actualLoadStorePropertiesResult.getJsonSerialiserClass());
    assertNull(actualLoadStorePropertiesResult.getNamedOperationCacheServiceClass());
    assertNull(actualLoadStorePropertiesResult.getNamedViewCacheServiceClass());
    assertNull(actualLoadStorePropertiesResult.getOperationDeclarationPaths());
    assertNull(actualLoadStorePropertiesResult.getReflectionPackages());
    assertNull(actualLoadStorePropertiesResult.getStoreClass());
    assertEquals(-1, storePropertiesStream.read(new byte[]{}));
    Properties properties = actualLoadStorePropertiesResult.getProperties();
    assertEquals(1, properties.size());
    assertEquals(50, actualLoadStorePropertiesResult.getJobExecutorThreadCount().intValue());
    assertFalse(actualLoadStorePropertiesResult.getJobTrackerEnabled());
    assertFalse(actualLoadStorePropertiesResult.getRescheduleJobsOnStart());
    assertTrue(properties.containsKey("AXAXAXAX"));
    assertTrue(actualLoadStorePropertiesResult.getNamedOperationEnabled());
    assertTrue(actualLoadStorePropertiesResult.getNamedViewEnabled());
    Class<StoreProperties> expectedStorePropertiesClass = StoreProperties.class;
    assertEquals(expectedStorePropertiesClass, actualLoadStorePropertiesResult.getStorePropertiesClass());
    Class<Schema> expectedSchemaClass = Schema.class;
    assertEquals(expectedSchemaClass, actualLoadStorePropertiesResult.getSchemaClass());
  }

  /**
   * Test {@link StoreProperties#loadStoreProperties(InputStream, Class)} with {@code storePropertiesStream}, {@code requiredClass}.
   * <p>
   * Method under test: {@link StoreProperties#loadStoreProperties(InputStream, Class)}
   */
  @Test
  @DisplayName("Test loadStoreProperties(InputStream, Class) with 'storePropertiesStream', 'requiredClass'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"StoreProperties StoreProperties.loadStoreProperties(InputStream, Class)"})
  void testLoadStorePropertiesWithStorePropertiesStreamRequiredClass() throws IOException {
    // Arrange
    ByteArrayInputStream storePropertiesStream = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));
    Class<StoreProperties> requiredClass = StoreProperties.class;

    // Act
    StoreProperties actualLoadStorePropertiesResult = StoreProperties.loadStoreProperties(storePropertiesStream,
        requiredClass);

    // Assert
    assertEquals("", actualLoadStorePropertiesResult.getAdminAuth());
    assertEquals("", actualLoadStorePropertiesResult.getJsonSerialiserModules());
    assertEquals("uk.gov.gchq.gaffer.store.StoreProperties",
        actualLoadStorePropertiesResult.getStorePropertiesClassName());
    assertEquals("uk.gov.gchq.gaffer.store.schema.Schema", actualLoadStorePropertiesResult.getSchemaClassName());
    assertNull(actualLoadStorePropertiesResult.getStrictJson());
    assertNull(actualLoadStorePropertiesResult.getCacheServiceClass());
    assertNull(actualLoadStorePropertiesResult.getDefaultCacheServiceClass());
    assertNull(actualLoadStorePropertiesResult.getJobTrackerCacheServiceClass());
    assertNull(actualLoadStorePropertiesResult.getJsonSerialiserClass());
    assertNull(actualLoadStorePropertiesResult.getNamedOperationCacheServiceClass());
    assertNull(actualLoadStorePropertiesResult.getNamedViewCacheServiceClass());
    assertNull(actualLoadStorePropertiesResult.getOperationDeclarationPaths());
    assertNull(actualLoadStorePropertiesResult.getReflectionPackages());
    assertNull(actualLoadStorePropertiesResult.getStoreClass());
    assertEquals(-1, storePropertiesStream.read(new byte[]{}));
    Properties properties = actualLoadStorePropertiesResult.getProperties();
    assertEquals(1, properties.size());
    assertEquals(50, actualLoadStorePropertiesResult.getJobExecutorThreadCount().intValue());
    assertFalse(actualLoadStorePropertiesResult.getJobTrackerEnabled());
    assertFalse(actualLoadStorePropertiesResult.getRescheduleJobsOnStart());
    assertTrue(properties.containsKey("AXAXAXAX"));
    assertTrue(actualLoadStorePropertiesResult.getNamedOperationEnabled());
    assertTrue(actualLoadStorePropertiesResult.getNamedViewEnabled());
    Class<StoreProperties> expectedStorePropertiesClass = StoreProperties.class;
    assertEquals(expectedStorePropertiesClass, actualLoadStorePropertiesResult.getStorePropertiesClass());
    Class<Schema> expectedSchemaClass = Schema.class;
    assertEquals(expectedSchemaClass, actualLoadStorePropertiesResult.getSchemaClass());
  }

  /**
   * Test {@link StoreProperties#loadStoreProperties(InputStream, Class)} with {@code storePropertiesStream}, {@code requiredClass}.
   * <p>
   * Method under test: {@link StoreProperties#loadStoreProperties(InputStream, Class)}
   */
  @Test
  @DisplayName("Test loadStoreProperties(InputStream, Class) with 'storePropertiesStream', 'requiredClass'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"StoreProperties StoreProperties.loadStoreProperties(InputStream, Class)"})
  void testLoadStorePropertiesWithStorePropertiesStreamRequiredClass2() throws IOException {
    // Arrange
    DataInputStream storePropertiesStream = mock(DataInputStream.class);
    doThrow(new RuntimeException("foo")).when(storePropertiesStream).close();
    Class<StoreProperties> requiredClass = StoreProperties.class;

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> StoreProperties.loadStoreProperties(storePropertiesStream, requiredClass));
    verify(storePropertiesStream).close();
  }

  /**
   * Test {@link StoreProperties#loadStoreProperties(InputStream, Class)} with {@code storePropertiesStream}, {@code requiredClass}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StoreProperties#loadStoreProperties(InputStream, Class)}
   */
  @Test
  @DisplayName("Test loadStoreProperties(InputStream, Class) with 'storePropertiesStream', 'requiredClass'; when 'null'; then 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"StoreProperties StoreProperties.loadStoreProperties(InputStream, Class)"})
  void testLoadStorePropertiesWithStorePropertiesStreamRequiredClass_whenNull_thenNull() {
    // Arrange
    Class<StoreProperties> requiredClass = StoreProperties.class;

    // Act
    StoreProperties actualLoadStorePropertiesResult = StoreProperties.loadStoreProperties((InputStream) null,
        requiredClass);

    // Assert
    assertEquals("", actualLoadStorePropertiesResult.getAdminAuth());
    assertEquals("", actualLoadStorePropertiesResult.getJsonSerialiserModules());
    assertEquals("uk.gov.gchq.gaffer.store.StoreProperties",
        actualLoadStorePropertiesResult.getStorePropertiesClassName());
    assertEquals("uk.gov.gchq.gaffer.store.schema.Schema", actualLoadStorePropertiesResult.getSchemaClassName());
    assertNull(null);
    assertNull(actualLoadStorePropertiesResult.getStrictJson());
    assertNull(actualLoadStorePropertiesResult.getCacheServiceClass());
    assertNull(actualLoadStorePropertiesResult.getDefaultCacheServiceClass());
    assertNull(actualLoadStorePropertiesResult.getJobTrackerCacheServiceClass());
    assertNull(actualLoadStorePropertiesResult.getJsonSerialiserClass());
    assertNull(actualLoadStorePropertiesResult.getNamedOperationCacheServiceClass());
    assertNull(actualLoadStorePropertiesResult.getNamedViewCacheServiceClass());
    assertNull(actualLoadStorePropertiesResult.getOperationDeclarationPaths());
    assertNull(actualLoadStorePropertiesResult.getReflectionPackages());
    assertNull(actualLoadStorePropertiesResult.getStoreClass());
    Properties properties = actualLoadStorePropertiesResult.getProperties();
    assertEquals(1, properties.size());
    assertEquals(50, actualLoadStorePropertiesResult.getJobExecutorThreadCount().intValue());
    assertFalse(actualLoadStorePropertiesResult.getJobTrackerEnabled());
    assertFalse(actualLoadStorePropertiesResult.getRescheduleJobsOnStart());
    assertTrue(properties.containsKey(StoreProperties.STORE_PROPERTIES_CLASS));
    assertTrue(actualLoadStorePropertiesResult.getNamedOperationEnabled());
    assertTrue(actualLoadStorePropertiesResult.getNamedViewEnabled());
    Class<StoreProperties> expectedStorePropertiesClass = StoreProperties.class;
    assertEquals(expectedStorePropertiesClass, actualLoadStorePropertiesResult.getStorePropertiesClass());
    Class<Schema> expectedSchemaClass = Schema.class;
    assertEquals(expectedSchemaClass, actualLoadStorePropertiesResult.getSchemaClass());
  }

  /**
   * Test {@link StoreProperties#loadStoreProperties(InputStream)} with {@code storePropertiesStream}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StoreProperties#loadStoreProperties(InputStream)}
   */
  @Test
  @DisplayName("Test loadStoreProperties(InputStream) with 'storePropertiesStream'; then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"StoreProperties StoreProperties.loadStoreProperties(InputStream)"})
  void testLoadStorePropertiesWithStorePropertiesStream_thenThrowRuntimeException() throws IOException {
    // Arrange
    DataInputStream storePropertiesStream = mock(DataInputStream.class);
    doThrow(new RuntimeException("foo")).when(storePropertiesStream).close();

    // Act and Assert
    assertThrows(RuntimeException.class, () -> StoreProperties.loadStoreProperties(storePropertiesStream));
    verify(storePropertiesStream).close();
  }

  /**
   * Test {@link StoreProperties#loadStoreProperties(InputStream)} with {@code storePropertiesStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StoreProperties#loadStoreProperties(InputStream)}
   */
  @Test
  @DisplayName("Test loadStoreProperties(InputStream) with 'storePropertiesStream'; when 'null'; then 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"StoreProperties StoreProperties.loadStoreProperties(InputStream)"})
  void testLoadStorePropertiesWithStorePropertiesStream_whenNull_thenNull() {
    // Arrange and Act
    StoreProperties actualLoadStorePropertiesResult = StoreProperties.loadStoreProperties((InputStream) null);

    // Assert
    assertEquals("", actualLoadStorePropertiesResult.getAdminAuth());
    assertEquals("", actualLoadStorePropertiesResult.getJsonSerialiserModules());
    assertEquals("uk.gov.gchq.gaffer.store.StoreProperties",
        actualLoadStorePropertiesResult.getStorePropertiesClassName());
    assertEquals("uk.gov.gchq.gaffer.store.schema.Schema", actualLoadStorePropertiesResult.getSchemaClassName());
    assertNull(null);
    assertNull(actualLoadStorePropertiesResult.getStrictJson());
    assertNull(actualLoadStorePropertiesResult.getCacheServiceClass());
    assertNull(actualLoadStorePropertiesResult.getDefaultCacheServiceClass());
    assertNull(actualLoadStorePropertiesResult.getJobTrackerCacheServiceClass());
    assertNull(actualLoadStorePropertiesResult.getJsonSerialiserClass());
    assertNull(actualLoadStorePropertiesResult.getNamedOperationCacheServiceClass());
    assertNull(actualLoadStorePropertiesResult.getNamedViewCacheServiceClass());
    assertNull(actualLoadStorePropertiesResult.getOperationDeclarationPaths());
    assertNull(actualLoadStorePropertiesResult.getReflectionPackages());
    assertNull(actualLoadStorePropertiesResult.getStoreClass());
    Properties properties = actualLoadStorePropertiesResult.getProperties();
    assertEquals(1, properties.size());
    assertEquals(50, actualLoadStorePropertiesResult.getJobExecutorThreadCount().intValue());
    assertFalse(actualLoadStorePropertiesResult.getJobTrackerEnabled());
    assertFalse(actualLoadStorePropertiesResult.getRescheduleJobsOnStart());
    assertTrue(properties.containsKey(StoreProperties.STORE_PROPERTIES_CLASS));
    assertTrue(actualLoadStorePropertiesResult.getNamedOperationEnabled());
    assertTrue(actualLoadStorePropertiesResult.getNamedViewEnabled());
    Class<StoreProperties> expectedStorePropertiesClass = StoreProperties.class;
    assertEquals(expectedStorePropertiesClass, actualLoadStorePropertiesResult.getStorePropertiesClass());
    Class<Schema> expectedSchemaClass = Schema.class;
    assertEquals(expectedSchemaClass, actualLoadStorePropertiesResult.getSchemaClass());
  }

  /**
   * Test {@link StoreProperties#get(String)} with {@code key}.
   * <p>
   * Method under test: {@link StoreProperties#get(String)}
   */
  @Test
  @DisplayName("Test get(String) with 'key'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StoreProperties.get(String)"})
  void testGetWithKey() {
    // Arrange, Act and Assert
    assertNull((new StoreProperties()).get("Key"));
  }

  /**
   * Test {@link StoreProperties#get(String, String)} with {@code key}, {@code defaultValue}.
   * <p>
   * Method under test: {@link StoreProperties#get(String, String)}
   */
  @Test
  @DisplayName("Test get(String, String) with 'key', 'defaultValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StoreProperties.get(String, String)"})
  void testGetWithKeyDefaultValue() {
    // Arrange, Act and Assert
    assertEquals("42", (new StoreProperties()).get("Key", "42"));
  }

  /**
   * Test {@link StoreProperties#set(String, String)}.
   * <p>
   * Method under test: {@link StoreProperties#set(String, String)}
   */
  @Test
  @DisplayName("Test set(String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void StoreProperties.set(String, String)"})
  void testSet() {
    // Arrange
    StoreProperties storeProperties = new StoreProperties();

    // Act
    storeProperties.set("Key", "42");

    // Assert
    Properties properties = storeProperties.getProperties();
    assertEquals(2, properties.size());
    assertEquals("42", properties.get("Key"));
    assertTrue(properties.containsKey(StoreProperties.STORE_PROPERTIES_CLASS));
  }

  /**
   * Test {@link StoreProperties#getOperationDeclarations()}.
   * <ul>
   *   <li>Given array of {@link String} with {@code ,}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StoreProperties#getOperationDeclarations()}
   */
  @Test
  @DisplayName("Test getOperationDeclarations(); given array of String with ','")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "uk.gov.gchq.gaffer.store.operation.declaration.OperationDeclarations StoreProperties.getOperationDeclarations()"})
  void testGetOperationDeclarations_givenArrayOfStringWithComma() {
    // Arrange
    StoreProperties storeProperties = new StoreProperties();
    storeProperties.addOperationDeclarationPaths(",");

    // Act and Assert
    assertTrue(storeProperties.getOperationDeclarations().getOperations().isEmpty());
  }

  /**
   * Test {@link StoreProperties#getOperationDeclarations()}.
   * <ul>
   *   <li>Given {@link StoreProperties#StoreProperties()}.</li>
   *   <li>Then return Operations Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link StoreProperties#getOperationDeclarations()}
   */
  @Test
  @DisplayName("Test getOperationDeclarations(); given StoreProperties(); then return Operations Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "uk.gov.gchq.gaffer.store.operation.declaration.OperationDeclarations StoreProperties.getOperationDeclarations()"})
  void testGetOperationDeclarations_givenStoreProperties_thenReturnOperationsEmpty() {
    // Arrange, Act and Assert
    assertTrue((new StoreProperties()).getOperationDeclarations().getOperations().isEmpty());
  }

  /**
   * Test {@link StoreProperties#getStoreClass()}.
   * <p>
   * Method under test: {@link StoreProperties#getStoreClass()}
   */
  @Test
  @DisplayName("Test getStoreClass()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StoreProperties.getStoreClass()"})
  void testGetStoreClass() {
    // Arrange, Act and Assert
    assertNull((new StoreProperties()).getStoreClass());
  }

  /**
   * Test {@link StoreProperties#setStoreClass(Class)} with {@code Class}.
   * <p>
   * Method under test: {@link StoreProperties#setStoreClass(Class)}
   */
  @Test
  @DisplayName("Test setStoreClass(Class) with 'Class'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void StoreProperties.setStoreClass(Class)"})
  void testSetStoreClassWithClass() {
    // Arrange
    StoreProperties storeProperties = new StoreProperties();
    Class<Store> storeClass = Store.class;

    // Act
    storeProperties.setStoreClass(storeClass);

    // Assert
    assertEquals("uk.gov.gchq.gaffer.store.Store", storeProperties.getStoreClass());
    Properties properties = storeProperties.getProperties();
    assertEquals(2, properties.size());
    assertEquals("uk.gov.gchq.gaffer.store.Store", properties.get(StoreProperties.STORE_CLASS));
    assertTrue(properties.containsKey(StoreProperties.STORE_PROPERTIES_CLASS));
  }

  /**
   * Test {@link StoreProperties#setStoreClass(String)} with {@code String}.
   * <p>
   * Method under test: {@link StoreProperties#setStoreClass(String)}
   */
  @Test
  @DisplayName("Test setStoreClass(String) with 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void StoreProperties.setStoreClass(String)"})
  void testSetStoreClassWithString() {
    // Arrange
    StoreProperties storeProperties = new StoreProperties();

    // Act
    storeProperties.setStoreClass("Store Class");

    // Assert
    assertEquals("Store Class", storeProperties.getStoreClass());
    Properties properties = storeProperties.getProperties();
    assertEquals(2, properties.size());
    assertEquals("Store Class", properties.get(StoreProperties.STORE_CLASS));
    assertTrue(properties.containsKey(StoreProperties.STORE_PROPERTIES_CLASS));
  }

  /**
   * Test {@link StoreProperties#getJobTrackerEnabled()}.
   * <p>
   * Method under test: {@link StoreProperties#getJobTrackerEnabled()}
   */
  @Test
  @DisplayName("Test getJobTrackerEnabled()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StoreProperties.getJobTrackerEnabled()"})
  void testGetJobTrackerEnabled() {
    // Arrange, Act and Assert
    assertFalse((new StoreProperties()).getJobTrackerEnabled());
  }

  /**
   * Test {@link StoreProperties#setJobTrackerEnabled(boolean)}.
   * <p>
   * Method under test: {@link StoreProperties#setJobTrackerEnabled(boolean)}
   */
  @Test
  @DisplayName("Test setJobTrackerEnabled(boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void StoreProperties.setJobTrackerEnabled(boolean)"})
  void testSetJobTrackerEnabled() {
    // Arrange
    StoreProperties storeProperties = new StoreProperties();

    // Act
    storeProperties.setJobTrackerEnabled(true);

    // Assert
    Properties properties = storeProperties.getProperties();
    assertEquals(2, properties.size());
    assertTrue(properties.containsKey(StoreProperties.STORE_PROPERTIES_CLASS));
    assertTrue(storeProperties.getJobTrackerEnabled());
    String expectedString = Boolean.TRUE.toString();
    assertEquals(expectedString, properties.get(StoreProperties.JOB_TRACKER_ENABLED));
  }

  /**
   * Test {@link StoreProperties#getNamedViewEnabled()}.
   * <ul>
   *   <li>Given {@link StoreProperties#StoreProperties()}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StoreProperties#getNamedViewEnabled()}
   */
  @Test
  @DisplayName("Test getNamedViewEnabled(); given StoreProperties(); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StoreProperties.getNamedViewEnabled()"})
  void testGetNamedViewEnabled_givenStoreProperties_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new StoreProperties()).getNamedViewEnabled());
  }

  /**
   * Test {@link StoreProperties#getNamedViewEnabled()}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StoreProperties#getNamedViewEnabled()}
   */
  @Test
  @DisplayName("Test getNamedViewEnabled(); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StoreProperties.getNamedViewEnabled()"})
  void testGetNamedViewEnabled_thenReturnFalse() {
    // Arrange
    StoreProperties storeProperties = new StoreProperties();
    storeProperties.set(StoreProperties.NAMED_VIEW_ENABLED, "42");

    // Act and Assert
    assertFalse(storeProperties.getNamedViewEnabled());
  }

  /**
   * Test {@link StoreProperties#setNamedViewEnabled(boolean)}.
   * <p>
   * Method under test: {@link StoreProperties#setNamedViewEnabled(boolean)}
   */
  @Test
  @DisplayName("Test setNamedViewEnabled(boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void StoreProperties.setNamedViewEnabled(boolean)"})
  void testSetNamedViewEnabled() {
    // Arrange
    StoreProperties storeProperties = new StoreProperties();

    // Act
    storeProperties.setNamedViewEnabled(true);

    // Assert
    Properties properties = storeProperties.getProperties();
    assertEquals(2, properties.size());
    assertTrue(properties.containsKey(StoreProperties.STORE_PROPERTIES_CLASS));
    String expectedString = Boolean.TRUE.toString();
    assertEquals(expectedString, properties.get(StoreProperties.NAMED_VIEW_ENABLED));
  }

  /**
   * Test {@link StoreProperties#getNamedOperationEnabled()}.
   * <ul>
   *   <li>Given {@link StoreProperties#StoreProperties()}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StoreProperties#getNamedOperationEnabled()}
   */
  @Test
  @DisplayName("Test getNamedOperationEnabled(); given StoreProperties(); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StoreProperties.getNamedOperationEnabled()"})
  void testGetNamedOperationEnabled_givenStoreProperties_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new StoreProperties()).getNamedOperationEnabled());
  }

  /**
   * Test {@link StoreProperties#getNamedOperationEnabled()}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StoreProperties#getNamedOperationEnabled()}
   */
  @Test
  @DisplayName("Test getNamedOperationEnabled(); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StoreProperties.getNamedOperationEnabled()"})
  void testGetNamedOperationEnabled_thenReturnFalse() {
    // Arrange
    StoreProperties storeProperties = new StoreProperties();
    storeProperties.set(StoreProperties.NAMED_OPERATION_ENABLED, "42");

    // Act and Assert
    assertFalse(storeProperties.getNamedOperationEnabled());
  }

  /**
   * Test {@link StoreProperties#setNamedOperationEnabled(boolean)}.
   * <p>
   * Method under test: {@link StoreProperties#setNamedOperationEnabled(boolean)}
   */
  @Test
  @DisplayName("Test setNamedOperationEnabled(boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void StoreProperties.setNamedOperationEnabled(boolean)"})
  void testSetNamedOperationEnabled() {
    // Arrange
    StoreProperties storeProperties = new StoreProperties();

    // Act
    storeProperties.setNamedOperationEnabled(true);

    // Assert
    Properties properties = storeProperties.getProperties();
    assertEquals(2, properties.size());
    assertTrue(properties.containsKey(StoreProperties.STORE_PROPERTIES_CLASS));
    String expectedString = Boolean.TRUE.toString();
    assertEquals(expectedString, properties.get(StoreProperties.NAMED_OPERATION_ENABLED));
  }

  /**
   * Test {@link StoreProperties#getRescheduleJobsOnStart()}.
   * <p>
   * Method under test: {@link StoreProperties#getRescheduleJobsOnStart()}
   */
  @Test
  @DisplayName("Test getRescheduleJobsOnStart()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StoreProperties.getRescheduleJobsOnStart()"})
  void testGetRescheduleJobsOnStart() {
    // Arrange, Act and Assert
    assertFalse((new StoreProperties()).getRescheduleJobsOnStart());
  }

  /**
   * Test {@link StoreProperties#setRescheduleJobsOnStart(boolean)}.
   * <p>
   * Method under test: {@link StoreProperties#setRescheduleJobsOnStart(boolean)}
   */
  @Test
  @DisplayName("Test setRescheduleJobsOnStart(boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void StoreProperties.setRescheduleJobsOnStart(boolean)"})
  void testSetRescheduleJobsOnStart() {
    // Arrange
    StoreProperties storeProperties = new StoreProperties();

    // Act
    storeProperties.setRescheduleJobsOnStart(true);

    // Assert
    Properties properties = storeProperties.getProperties();
    assertEquals(2, properties.size());
    assertTrue(properties.containsKey(StoreProperties.STORE_PROPERTIES_CLASS));
    assertTrue(storeProperties.getRescheduleJobsOnStart());
    String expectedString = Boolean.TRUE.toString();
    assertEquals(expectedString, properties.get(StoreProperties.RESCHEDULE_JOBS_ON_START));
  }

  /**
   * Test {@link StoreProperties#getSchemaClassName()}.
   * <p>
   * Method under test: {@link StoreProperties#getSchemaClassName()}
   */
  @Test
  @DisplayName("Test getSchemaClassName()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StoreProperties.getSchemaClassName()"})
  void testGetSchemaClassName() {
    // Arrange, Act and Assert
    assertEquals("uk.gov.gchq.gaffer.store.schema.Schema", (new StoreProperties()).getSchemaClassName());
  }

  /**
   * Test {@link StoreProperties#getSchemaClass()}.
   * <ul>
   *   <li>Given {@link StoreProperties#StoreProperties()} {@link StoreProperties#SCHEMA_CLASS} is {@code 42}.</li>
   *   <li>Then throw {@link SchemaException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StoreProperties#getSchemaClass()}
   */
  @Test
  @DisplayName("Test getSchemaClass(); given StoreProperties() SCHEMA_CLASS is '42'; then throw SchemaException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Class StoreProperties.getSchemaClass()"})
  void testGetSchemaClass_givenStorePropertiesSchema_classIs42_thenThrowSchemaException() {
    // Arrange
    StoreProperties storeProperties = new StoreProperties();
    storeProperties.set(StoreProperties.SCHEMA_CLASS, "42");

    // Act and Assert
    assertThrows(SchemaException.class, () -> storeProperties.getSchemaClass());
  }

  /**
   * Test {@link StoreProperties#getSchemaClass()}.
   * <ul>
   *   <li>Given {@link StoreProperties#StoreProperties()}.</li>
   *   <li>Then return {@link Schema}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StoreProperties#getSchemaClass()}
   */
  @Test
  @DisplayName("Test getSchemaClass(); given StoreProperties(); then return Schema")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Class StoreProperties.getSchemaClass()"})
  void testGetSchemaClass_givenStoreProperties_thenReturnSchema() {
    // Arrange and Act
    Class<? extends Schema> actualSchemaClass = (new StoreProperties()).getSchemaClass();

    // Assert
    Class<Schema> expectedSchemaClass = Schema.class;
    assertEquals(expectedSchemaClass, actualSchemaClass);
  }

  /**
   * Test {@link StoreProperties#setSchemaClass(Class)} with {@code Class}.
   * <p>
   * Method under test: {@link StoreProperties#setSchemaClass(Class)}
   */
  @Test
  @DisplayName("Test setSchemaClass(Class) with 'Class'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void StoreProperties.setSchemaClass(Class)"})
  void testSetSchemaClassWithClass() {
    // Arrange
    StoreProperties storeProperties = new StoreProperties();
    Class<Schema> schemaClass = Schema.class;

    // Act
    storeProperties.setSchemaClass(schemaClass);

    // Assert
    Properties properties = storeProperties.getProperties();
    assertEquals(2, properties.size());
    assertEquals("uk.gov.gchq.gaffer.store.schema.Schema", properties.get(StoreProperties.SCHEMA_CLASS));
    assertTrue(properties.containsKey(StoreProperties.STORE_PROPERTIES_CLASS));
    Class<Schema> expectedSchemaClass = Schema.class;
    assertEquals(expectedSchemaClass, storeProperties.getSchemaClass());
  }

  /**
   * Test {@link StoreProperties#setSchemaClass(String)} with {@code String}.
   * <p>
   * Method under test: {@link StoreProperties#setSchemaClass(String)}
   */
  @Test
  @DisplayName("Test setSchemaClass(String) with 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void StoreProperties.setSchemaClass(String)"})
  void testSetSchemaClassWithString() {
    // Arrange
    StoreProperties storeProperties = new StoreProperties();

    // Act
    storeProperties.setSchemaClass("Schema Class");

    // Assert
    assertEquals("Schema Class", storeProperties.getSchemaClassName());
    Properties properties = storeProperties.getProperties();
    assertEquals(2, properties.size());
    assertEquals("Schema Class", properties.get(StoreProperties.SCHEMA_CLASS));
    assertTrue(properties.containsKey(StoreProperties.STORE_PROPERTIES_CLASS));
  }

  /**
   * Test {@link StoreProperties#getStorePropertiesClassName()}.
   * <p>
   * Method under test: {@link StoreProperties#getStorePropertiesClassName()}
   */
  @Test
  @DisplayName("Test getStorePropertiesClassName()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StoreProperties.getStorePropertiesClassName()"})
  void testGetStorePropertiesClassName() {
    // Arrange, Act and Assert
    assertEquals("uk.gov.gchq.gaffer.store.StoreProperties", (new StoreProperties()).getStorePropertiesClassName());
  }

  /**
   * Test {@link StoreProperties#setStorePropertiesClassName(String)}.
   * <p>
   * Method under test: {@link StoreProperties#setStorePropertiesClassName(String)}
   */
  @Test
  @DisplayName("Test setStorePropertiesClassName(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void StoreProperties.setStorePropertiesClassName(String)"})
  void testSetStorePropertiesClassName() {
    // Arrange
    StoreProperties storeProperties = new StoreProperties();

    // Act
    storeProperties.setStorePropertiesClassName("Store Properties Class Name");

    // Assert
    assertEquals("Store Properties Class Name", storeProperties.getStorePropertiesClassName());
    Properties properties = storeProperties.getProperties();
    assertEquals(1, properties.size());
    assertEquals("Store Properties Class Name", properties.get(StoreProperties.STORE_PROPERTIES_CLASS));
  }

  /**
   * Test {@link StoreProperties#getStorePropertiesClass()}.
   * <ul>
   *   <li>Given {@link StoreProperties#StoreProperties()}.</li>
   *   <li>Then return {@link StoreProperties}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StoreProperties#getStorePropertiesClass()}
   */
  @Test
  @DisplayName("Test getStorePropertiesClass(); given StoreProperties(); then return StoreProperties")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Class StoreProperties.getStorePropertiesClass()"})
  void testGetStorePropertiesClass_givenStoreProperties_thenReturnStoreProperties() {
    // Arrange and Act
    Class<? extends StoreProperties> actualStorePropertiesClass = (new StoreProperties()).getStorePropertiesClass();

    // Assert
    Class<StoreProperties> expectedStorePropertiesClass = StoreProperties.class;
    assertEquals(expectedStorePropertiesClass, actualStorePropertiesClass);
  }

  /**
   * Test {@link StoreProperties#getStorePropertiesClass()}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StoreProperties#getStorePropertiesClass()}
   */
  @Test
  @DisplayName("Test getStorePropertiesClass(); then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Class StoreProperties.getStorePropertiesClass()"})
  void testGetStorePropertiesClass_thenThrowRuntimeException() {
    // Arrange
    StoreProperties storeProperties = new StoreProperties();
    storeProperties.set(StoreProperties.STORE_PROPERTIES_CLASS, "42");

    // Act and Assert
    assertThrows(RuntimeException.class, () -> storeProperties.getStorePropertiesClass());
  }

  /**
   * Test {@link StoreProperties#setStorePropertiesClass(Class)}.
   * <p>
   * Method under test: {@link StoreProperties#setStorePropertiesClass(Class)}
   */
  @Test
  @DisplayName("Test setStorePropertiesClass(Class)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void StoreProperties.setStorePropertiesClass(Class)"})
  void testSetStorePropertiesClass() {
    // Arrange
    StoreProperties storeProperties = new StoreProperties();
    Class<StoreProperties> storePropertiesClass = StoreProperties.class;

    // Act
    storeProperties.setStorePropertiesClass(storePropertiesClass);

    // Assert
    Class<StoreProperties> expectedStorePropertiesClass = StoreProperties.class;
    assertEquals(expectedStorePropertiesClass, storeProperties.getStorePropertiesClass());
  }

  /**
   * Test {@link StoreProperties#getOperationDeclarationPaths()}.
   * <p>
   * Method under test: {@link StoreProperties#getOperationDeclarationPaths()}
   */
  @Test
  @DisplayName("Test getOperationDeclarationPaths()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StoreProperties.getOperationDeclarationPaths()"})
  void testGetOperationDeclarationPaths() {
    // Arrange, Act and Assert
    assertNull((new StoreProperties()).getOperationDeclarationPaths());
  }

  /**
   * Test {@link StoreProperties#setOperationDeclarationPaths(String)}.
   * <p>
   * Method under test: {@link StoreProperties#setOperationDeclarationPaths(String)}
   */
  @Test
  @DisplayName("Test setOperationDeclarationPaths(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void StoreProperties.setOperationDeclarationPaths(String)"})
  void testSetOperationDeclarationPaths() {
    // Arrange
    StoreProperties storeProperties = new StoreProperties();

    // Act
    storeProperties.setOperationDeclarationPaths("Paths");

    // Assert
    assertEquals("Paths", storeProperties.getOperationDeclarationPaths());
    Properties properties = storeProperties.getProperties();
    assertEquals(2, properties.size());
    assertEquals("Paths", properties.get(StoreProperties.OPERATION_DECLARATIONS));
    assertTrue(properties.containsKey(StoreProperties.STORE_PROPERTIES_CLASS));
  }

  /**
   * Test {@link StoreProperties#getReflectionPackages()}.
   * <p>
   * Method under test: {@link StoreProperties#getReflectionPackages()}
   */
  @Test
  @DisplayName("Test getReflectionPackages()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StoreProperties.getReflectionPackages()"})
  void testGetReflectionPackages() {
    // Arrange, Act and Assert
    assertNull((new StoreProperties()).getReflectionPackages());
  }

  /**
   * Test {@link StoreProperties#setReflectionPackages(String)}.
   * <p>
   * Method under test: {@link StoreProperties#setReflectionPackages(String)}
   */
  @Test
  @DisplayName("Test setReflectionPackages(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void StoreProperties.setReflectionPackages(String)"})
  void testSetReflectionPackages() {
    // Arrange
    StoreProperties storeProperties = new StoreProperties();

    // Act
    storeProperties.setReflectionPackages("java.text");

    // Assert
    assertEquals("java.text", storeProperties.getReflectionPackages());
    Properties properties = storeProperties.getProperties();
    assertEquals(2, properties.size());
    assertEquals("java.text", properties.get(StoreProperties.REFLECTION_PACKAGES));
    assertTrue(properties.containsKey(StoreProperties.STORE_PROPERTIES_CLASS));
  }

  /**
   * Test {@link StoreProperties#getJobExecutorThreadCount()}.
   * <ul>
   *   <li>Given {@link StoreProperties#StoreProperties()}.</li>
   *   <li>Then return intValue is fifty.</li>
   * </ul>
   * <p>
   * Method under test: {@link StoreProperties#getJobExecutorThreadCount()}
   */
  @Test
  @DisplayName("Test getJobExecutorThreadCount(); given StoreProperties(); then return intValue is fifty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.Integer StoreProperties.getJobExecutorThreadCount()"})
  void testGetJobExecutorThreadCount_givenStoreProperties_thenReturnIntValueIsFifty() {
    // Arrange, Act and Assert
    assertEquals(50, (new StoreProperties()).getJobExecutorThreadCount().intValue());
  }

  /**
   * Test {@link StoreProperties#containsKey(Object)}.
   * <ul>
   *   <li>Given {@link StoreProperties#StoreProperties()} {@code Key} is {@code 42}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StoreProperties#containsKey(Object)}
   */
  @Test
  @DisplayName("Test containsKey(Object); given StoreProperties() 'Key' is '42'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StoreProperties.containsKey(Object)"})
  void testContainsKey_givenStorePropertiesKeyIs42_thenReturnTrue() {
    // Arrange
    StoreProperties storeProperties = new StoreProperties();
    storeProperties.set("Key", "42");

    // Act and Assert
    assertTrue(storeProperties.containsKey("Key"));
  }

  /**
   * Test {@link StoreProperties#containsKey(Object)}.
   * <ul>
   *   <li>Given {@link StoreProperties#StoreProperties()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StoreProperties#containsKey(Object)}
   */
  @Test
  @DisplayName("Test containsKey(Object); given StoreProperties(); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StoreProperties.containsKey(Object)"})
  void testContainsKey_givenStoreProperties_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new StoreProperties()).containsKey("Key"));
  }

  /**
   * Test {@link StoreProperties#addOperationDeclarationPaths(String[])}.
   * <p>
   * Method under test: {@link StoreProperties#addOperationDeclarationPaths(String[])}
   */
  @Test
  @DisplayName("Test addOperationDeclarationPaths(String[])")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void StoreProperties.addOperationDeclarationPaths(String[])"})
  void testAddOperationDeclarationPaths() {
    // Arrange
    StoreProperties storeProperties = new StoreProperties();

    // Act
    storeProperties.addOperationDeclarationPaths("New Paths");

    // Assert
    assertEquals("New Paths", storeProperties.getOperationDeclarationPaths());
    Properties properties = storeProperties.getProperties();
    assertEquals(2, properties.size());
    assertEquals("New Paths", properties.get(StoreProperties.OPERATION_DECLARATIONS));
    assertTrue(properties.containsKey(StoreProperties.STORE_PROPERTIES_CLASS));
  }

  /**
   * Test {@link StoreProperties#addOperationDeclarationPaths(String[])}.
   * <p>
   * Method under test: {@link StoreProperties#addOperationDeclarationPaths(String[])}
   */
  @Test
  @DisplayName("Test addOperationDeclarationPaths(String[])")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void StoreProperties.addOperationDeclarationPaths(String[])"})
  void testAddOperationDeclarationPaths2() {
    // Arrange
    StoreProperties storeProperties = new StoreProperties();
    storeProperties.addOperationDeclarationPaths(",");

    // Act
    storeProperties.addOperationDeclarationPaths("New Paths");

    // Assert
    assertEquals(",,New Paths", storeProperties.getOperationDeclarationPaths());
    Properties properties = storeProperties.getProperties();
    assertEquals(2, properties.size());
    assertEquals(",,New Paths", properties.get(StoreProperties.OPERATION_DECLARATIONS));
    assertTrue(properties.containsKey(StoreProperties.STORE_PROPERTIES_CLASS));
  }

  /**
   * Test {@link StoreProperties#addOperationDeclarationPaths(String[])}.
   * <p>
   * Method under test: {@link StoreProperties#addOperationDeclarationPaths(String[])}
   */
  @Test
  @DisplayName("Test addOperationDeclarationPaths(String[])")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void StoreProperties.addOperationDeclarationPaths(String[])"})
  void testAddOperationDeclarationPaths3() {
    // Arrange
    StoreProperties storeProperties = new StoreProperties();

    // Act
    storeProperties.addOperationDeclarationPaths();

    // Assert
    assertEquals("", storeProperties.getOperationDeclarationPaths());
    Properties properties = storeProperties.getProperties();
    assertEquals(2, properties.size());
    assertEquals("", properties.get(StoreProperties.OPERATION_DECLARATIONS));
    assertTrue(properties.containsKey(StoreProperties.STORE_PROPERTIES_CLASS));
  }

  /**
   * Test {@link StoreProperties#getJsonSerialiserClass()}.
   * <p>
   * Method under test: {@link StoreProperties#getJsonSerialiserClass()}
   */
  @Test
  @DisplayName("Test getJsonSerialiserClass()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StoreProperties.getJsonSerialiserClass()"})
  void testGetJsonSerialiserClass() {
    // Arrange, Act and Assert
    assertNull((new StoreProperties()).getJsonSerialiserClass());
  }

  /**
   * Test {@link StoreProperties#setJsonSerialiserClass(Class)} with {@code Class}.
   * <p>
   * Method under test: {@link StoreProperties#setJsonSerialiserClass(Class)}
   */
  @Test
  @DisplayName("Test setJsonSerialiserClass(Class) with 'Class'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void StoreProperties.setJsonSerialiserClass(Class)"})
  void testSetJsonSerialiserClassWithClass() {
    // Arrange
    StoreProperties storeProperties = new StoreProperties();
    Class<JSONSerialiser> jsonSerialiserClass = JSONSerialiser.class;

    // Act
    storeProperties.setJsonSerialiserClass(jsonSerialiserClass);

    // Assert
    assertEquals("uk.gov.gchq.gaffer.jsonserialisation.JSONSerialiser", storeProperties.getJsonSerialiserClass());
    Properties properties = storeProperties.getProperties();
    assertEquals(2, properties.size());
    assertEquals("uk.gov.gchq.gaffer.jsonserialisation.JSONSerialiser",
        properties.get(StoreProperties.JSON_SERIALISER_CLASS));
    assertTrue(properties.containsKey(StoreProperties.STORE_PROPERTIES_CLASS));
  }

  /**
   * Test {@link StoreProperties#setJsonSerialiserClass(String)} with {@code String}.
   * <p>
   * Method under test: {@link StoreProperties#setJsonSerialiserClass(String)}
   */
  @Test
  @DisplayName("Test setJsonSerialiserClass(String) with 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void StoreProperties.setJsonSerialiserClass(String)"})
  void testSetJsonSerialiserClassWithString() {
    // Arrange
    StoreProperties storeProperties = new StoreProperties();

    // Act
    storeProperties.setJsonSerialiserClass("Json Serialiser Class");

    // Assert
    assertEquals("Json Serialiser Class", storeProperties.getJsonSerialiserClass());
    Properties properties = storeProperties.getProperties();
    assertEquals(2, properties.size());
    assertEquals("Json Serialiser Class", properties.get(StoreProperties.JSON_SERIALISER_CLASS));
    assertTrue(properties.containsKey(StoreProperties.STORE_PROPERTIES_CLASS));
  }

  /**
   * Test {@link StoreProperties#getJsonSerialiserModules()}.
   * <p>
   * Method under test: {@link StoreProperties#getJsonSerialiserModules()}
   */
  @Test
  @DisplayName("Test getJsonSerialiserModules()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StoreProperties.getJsonSerialiserModules()"})
  void testGetJsonSerialiserModules() {
    // Arrange, Act and Assert
    assertEquals("", (new StoreProperties()).getJsonSerialiserModules());
  }

  /**
   * Test {@link StoreProperties#setJsonSerialiserModules(Set)} with {@code Set}.
   * <p>
   * Method under test: {@link StoreProperties#setJsonSerialiserModules(Set)}
   */
  @Test
  @DisplayName("Test setJsonSerialiserModules(Set) with 'Set'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void StoreProperties.setJsonSerialiserModules(Set)"})
  void testSetJsonSerialiserModulesWithSet() {
    // Arrange
    StoreProperties storeProperties = new StoreProperties();

    // Act
    storeProperties.setJsonSerialiserModules(new HashSet<>());

    // Assert
    Properties properties = storeProperties.getProperties();
    assertEquals(2, properties.size());
    assertEquals("", properties.get(StoreProperties.JSON_SERIALISER_MODULES));
    assertTrue(properties.containsKey(StoreProperties.STORE_PROPERTIES_CLASS));
  }

  /**
   * Test {@link StoreProperties#setJsonSerialiserModules(String)} with {@code String}.
   * <p>
   * Method under test: {@link StoreProperties#setJsonSerialiserModules(String)}
   */
  @Test
  @DisplayName("Test setJsonSerialiserModules(String) with 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void StoreProperties.setJsonSerialiserModules(String)"})
  void testSetJsonSerialiserModulesWithString() {
    // Arrange
    StoreProperties storeProperties = new StoreProperties();

    // Act
    storeProperties.setJsonSerialiserModules("Modules");

    // Assert
    assertEquals("Modules", storeProperties.getJsonSerialiserModules());
    Properties properties = storeProperties.getProperties();
    assertEquals(2, properties.size());
    assertEquals("Modules", properties.get(StoreProperties.JSON_SERIALISER_MODULES));
    assertTrue(properties.containsKey(StoreProperties.STORE_PROPERTIES_CLASS));
  }

  /**
   * Test {@link StoreProperties#getStrictJson()}.
   * <ul>
   *   <li>Given {@link StoreProperties#StoreProperties()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StoreProperties#getStrictJson()}
   */
  @Test
  @DisplayName("Test getStrictJson(); given StoreProperties(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Boolean StoreProperties.getStrictJson()"})
  void testGetStrictJson_givenStoreProperties_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new StoreProperties()).getStrictJson());
  }

  /**
   * Test {@link StoreProperties#getAdminAuth()}.
   * <p>
   * Method under test: {@link StoreProperties#getAdminAuth()}
   */
  @Test
  @DisplayName("Test getAdminAuth()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StoreProperties.getAdminAuth()"})
  void testGetAdminAuth() {
    // Arrange, Act and Assert
    assertEquals("", (new StoreProperties()).getAdminAuth());
  }

  /**
   * Test {@link StoreProperties#setAdminAuth(String)}.
   * <p>
   * Method under test: {@link StoreProperties#setAdminAuth(String)}
   */
  @Test
  @DisplayName("Test setAdminAuth(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void StoreProperties.setAdminAuth(String)"})
  void testSetAdminAuth() {
    // Arrange
    StoreProperties storeProperties = new StoreProperties();

    // Act
    storeProperties.setAdminAuth("Admin Auth");

    // Assert
    assertEquals("Admin Auth", storeProperties.getAdminAuth());
    Properties properties = storeProperties.getProperties();
    assertEquals(2, properties.size());
    assertEquals("Admin Auth", properties.get(StoreProperties.ADMIN_AUTH));
    assertTrue(properties.containsKey(StoreProperties.STORE_PROPERTIES_CLASS));
  }

  /**
   * Test {@link StoreProperties#getDefaultCacheServiceClass()}.
   * <ul>
   *   <li>Given {@link StoreProperties#StoreProperties()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StoreProperties#getDefaultCacheServiceClass()}
   */
  @Test
  @DisplayName("Test getDefaultCacheServiceClass(); given StoreProperties(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StoreProperties.getDefaultCacheServiceClass()"})
  void testGetDefaultCacheServiceClass_givenStoreProperties_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new StoreProperties()).getDefaultCacheServiceClass());
  }

  /**
   * Test {@link StoreProperties#getDefaultCacheServiceClass()}.
   * <ul>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StoreProperties#getDefaultCacheServiceClass()}
   */
  @Test
  @DisplayName("Test getDefaultCacheServiceClass(); then return '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StoreProperties.getDefaultCacheServiceClass()"})
  void testGetDefaultCacheServiceClass_thenReturn42() {
    // Arrange
    StoreProperties storeProperties = new StoreProperties();
    storeProperties.set("gaffer.cache.service.default.class", "42");

    // Act and Assert
    assertEquals("42", storeProperties.getDefaultCacheServiceClass());
  }

  /**
   * Test {@link StoreProperties#setDefaultCacheServiceClass(String)}.
   * <p>
   * Method under test: {@link StoreProperties#setDefaultCacheServiceClass(String)}
   */
  @Test
  @DisplayName("Test setDefaultCacheServiceClass(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void StoreProperties.setDefaultCacheServiceClass(String)"})
  void testSetDefaultCacheServiceClass() {
    // Arrange
    StoreProperties storeProperties = new StoreProperties();

    // Act
    storeProperties.setDefaultCacheServiceClass("Cache Service Class String");

    // Assert
    assertEquals("Cache Service Class String", storeProperties.getCacheServiceClass());
    assertEquals("Cache Service Class String", storeProperties.getDefaultCacheServiceClass());
    Properties properties = storeProperties.getProperties();
    assertEquals(2, properties.size());
    assertEquals("Cache Service Class String", properties.get("gaffer.cache.service.default.class"));
    assertTrue(properties.containsKey(StoreProperties.STORE_PROPERTIES_CLASS));
  }

  /**
   * Test {@link StoreProperties#getJobTrackerCacheServiceClass()}.
   * <p>
   * Method under test: {@link StoreProperties#getJobTrackerCacheServiceClass()}
   */
  @Test
  @DisplayName("Test getJobTrackerCacheServiceClass()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StoreProperties.getJobTrackerCacheServiceClass()"})
  void testGetJobTrackerCacheServiceClass() {
    // Arrange, Act and Assert
    assertNull((new StoreProperties()).getJobTrackerCacheServiceClass());
  }

  /**
   * Test {@link StoreProperties#setJobTrackerCacheServiceClass(String)}.
   * <p>
   * Method under test: {@link StoreProperties#setJobTrackerCacheServiceClass(String)}
   */
  @Test
  @DisplayName("Test setJobTrackerCacheServiceClass(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void StoreProperties.setJobTrackerCacheServiceClass(String)"})
  void testSetJobTrackerCacheServiceClass() {
    // Arrange
    StoreProperties storeProperties = new StoreProperties();

    // Act
    storeProperties.setJobTrackerCacheServiceClass("Cache Service Class String");

    // Assert
    assertEquals("Cache Service Class String", storeProperties.getJobTrackerCacheServiceClass());
    Properties properties = storeProperties.getProperties();
    assertEquals(2, properties.size());
    assertEquals("Cache Service Class String", properties.get("gaffer.cache.service.jobtracker.class"));
    assertTrue(properties.containsKey(StoreProperties.STORE_PROPERTIES_CLASS));
  }

  /**
   * Test {@link StoreProperties#getNamedViewCacheServiceClass()}.
   * <p>
   * Method under test: {@link StoreProperties#getNamedViewCacheServiceClass()}
   */
  @Test
  @DisplayName("Test getNamedViewCacheServiceClass()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StoreProperties.getNamedViewCacheServiceClass()"})
  void testGetNamedViewCacheServiceClass() {
    // Arrange, Act and Assert
    assertNull((new StoreProperties()).getNamedViewCacheServiceClass());
  }

  /**
   * Test {@link StoreProperties#setNamedViewCacheServiceClass(String)}.
   * <p>
   * Method under test: {@link StoreProperties#setNamedViewCacheServiceClass(String)}
   */
  @Test
  @DisplayName("Test setNamedViewCacheServiceClass(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void StoreProperties.setNamedViewCacheServiceClass(String)"})
  void testSetNamedViewCacheServiceClass() {
    // Arrange
    StoreProperties storeProperties = new StoreProperties();

    // Act
    storeProperties.setNamedViewCacheServiceClass("Cache Service Class String");

    // Assert
    assertEquals("Cache Service Class String", storeProperties.getNamedViewCacheServiceClass());
    Properties properties = storeProperties.getProperties();
    assertEquals(2, properties.size());
    assertEquals("Cache Service Class String", properties.get("gaffer.cache.service.namedview.class"));
    assertTrue(properties.containsKey(StoreProperties.STORE_PROPERTIES_CLASS));
  }

  /**
   * Test {@link StoreProperties#getNamedOperationCacheServiceClass()}.
   * <p>
   * Method under test: {@link StoreProperties#getNamedOperationCacheServiceClass()}
   */
  @Test
  @DisplayName("Test getNamedOperationCacheServiceClass()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StoreProperties.getNamedOperationCacheServiceClass()"})
  void testGetNamedOperationCacheServiceClass() {
    // Arrange, Act and Assert
    assertNull((new StoreProperties()).getNamedOperationCacheServiceClass());
  }

  /**
   * Test {@link StoreProperties#setNamedOperationCacheServiceClass(String)}.
   * <p>
   * Method under test: {@link StoreProperties#setNamedOperationCacheServiceClass(String)}
   */
  @Test
  @DisplayName("Test setNamedOperationCacheServiceClass(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void StoreProperties.setNamedOperationCacheServiceClass(String)"})
  void testSetNamedOperationCacheServiceClass() {
    // Arrange
    StoreProperties storeProperties = new StoreProperties();

    // Act
    storeProperties.setNamedOperationCacheServiceClass("Cache Service Class String");

    // Assert
    assertEquals("Cache Service Class String", storeProperties.getNamedOperationCacheServiceClass());
    Properties properties = storeProperties.getProperties();
    assertEquals(2, properties.size());
    assertEquals("Cache Service Class String", properties.get("gaffer.cache.service.namedoperation.class"));
    assertTrue(properties.containsKey(StoreProperties.STORE_PROPERTIES_CLASS));
  }

  /**
   * Test {@link StoreProperties#setCacheServiceClass(String)}.
   * <p>
   * Method under test: {@link StoreProperties#setCacheServiceClass(String)}
   */
  @Test
  @DisplayName("Test setCacheServiceClass(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void StoreProperties.setCacheServiceClass(String)"})
  void testSetCacheServiceClass() {
    // Arrange
    StoreProperties storeProperties = new StoreProperties();

    // Act
    storeProperties.setCacheServiceClass("Cache Service Class String");

    // Assert
    assertEquals("Cache Service Class String", storeProperties.getCacheServiceClass());
    assertEquals("Cache Service Class String", storeProperties.getDefaultCacheServiceClass());
    Properties properties = storeProperties.getProperties();
    assertEquals(3, properties.size());
    assertEquals("Cache Service Class String", properties.get("gaffer.cache.service.class"));
    assertEquals("Cache Service Class String", properties.get("gaffer.cache.service.default.class"));
    assertTrue(properties.containsKey(StoreProperties.STORE_PROPERTIES_CLASS));
  }

  /**
   * Test {@link StoreProperties#getCacheServiceClass(String)} with {@code String}.
   * <p>
   * Method under test: {@link StoreProperties#getCacheServiceClass(String)}
   */
  @Test
  @DisplayName("Test getCacheServiceClass(String) with 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StoreProperties.getCacheServiceClass(String)"})
  void testGetCacheServiceClassWithString() {
    // Arrange
    StoreProperties storeProperties = new StoreProperties();
    storeProperties.set("gaffer.cache.service.default.class", "42");

    // Act and Assert
    assertEquals("42", storeProperties.getCacheServiceClass("42"));
  }

  /**
   * Test {@link StoreProperties#getCacheServiceClass(String)} with {@code String}.
   * <ul>
   *   <li>Given {@link StoreProperties#StoreProperties()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StoreProperties#getCacheServiceClass(String)}
   */
  @Test
  @DisplayName("Test getCacheServiceClass(String) with 'String'; given StoreProperties()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StoreProperties.getCacheServiceClass(String)"})
  void testGetCacheServiceClassWithString_givenStoreProperties() {
    // Arrange, Act and Assert
    assertEquals("42", (new StoreProperties()).getCacheServiceClass("42"));
  }

  /**
   * Test {@link StoreProperties#getCacheServiceClass()}.
   * <ul>
   *   <li>Given {@link StoreProperties#StoreProperties()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StoreProperties#getCacheServiceClass()}
   */
  @Test
  @DisplayName("Test getCacheServiceClass(); given StoreProperties(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StoreProperties.getCacheServiceClass()"})
  void testGetCacheServiceClass_givenStoreProperties_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new StoreProperties()).getCacheServiceClass());
  }

  /**
   * Test {@link StoreProperties#getCacheServiceClass()}.
   * <ul>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StoreProperties#getCacheServiceClass()}
   */
  @Test
  @DisplayName("Test getCacheServiceClass(); then return '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StoreProperties.getCacheServiceClass()"})
  void testGetCacheServiceClass_thenReturn42() {
    // Arrange
    StoreProperties storeProperties = new StoreProperties();
    storeProperties.set("gaffer.cache.service.default.class", "42");

    // Act and Assert
    assertEquals("42", storeProperties.getCacheServiceClass());
  }

  /**
   * Test {@link StoreProperties#setCacheServiceNameSuffix(String)}.
   * <p>
   * Method under test: {@link StoreProperties#setCacheServiceNameSuffix(String)}
   */
  @Test
  @DisplayName("Test setCacheServiceNameSuffix(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void StoreProperties.setCacheServiceNameSuffix(String)"})
  void testSetCacheServiceNameSuffix() {
    // Arrange
    StoreProperties storeProperties = new StoreProperties();

    // Act
    storeProperties.setCacheServiceNameSuffix("Suffix");

    // Assert
    Properties properties = storeProperties.getProperties();
    assertEquals(2, properties.size());
    assertEquals("Suffix", properties.get("gaffer.cache.service.default.suffix"));
    assertTrue(properties.containsKey(StoreProperties.STORE_PROPERTIES_CLASS));
  }

  /**
   * Test {@link StoreProperties#getCacheServiceDefaultSuffix(String)}.
   * <p>
   * Method under test: {@link StoreProperties#getCacheServiceDefaultSuffix(String)}
   */
  @Test
  @DisplayName("Test getCacheServiceDefaultSuffix(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StoreProperties.getCacheServiceDefaultSuffix(String)"})
  void testGetCacheServiceDefaultSuffix() {
    // Arrange, Act and Assert
    assertEquals("42", (new StoreProperties()).getCacheServiceDefaultSuffix("42"));
  }

  /**
   * Test {@link StoreProperties#getCacheServiceNamedOperationSuffix(String)}.
   * <p>
   * Method under test: {@link StoreProperties#getCacheServiceNamedOperationSuffix(String)}
   */
  @Test
  @DisplayName("Test getCacheServiceNamedOperationSuffix(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StoreProperties.getCacheServiceNamedOperationSuffix(String)"})
  void testGetCacheServiceNamedOperationSuffix() {
    // Arrange, Act and Assert
    assertEquals("42", (new StoreProperties()).getCacheServiceNamedOperationSuffix("42"));
  }

  /**
   * Test {@link StoreProperties#isNestedNamedOperationAllow()}.
   * <p>
   * Method under test: {@link StoreProperties#isNestedNamedOperationAllow()}
   */
  @Test
  @DisplayName("Test isNestedNamedOperationAllow()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StoreProperties.isNestedNamedOperationAllow()"})
  void testIsNestedNamedOperationAllow() {
    // Arrange
    StoreProperties storeProperties = new StoreProperties();
    storeProperties.set(StoreProperties.GAFFER_NAMED_OPERATION_NESTED, "42");

    // Act and Assert
    assertFalse(storeProperties.isNestedNamedOperationAllow());
  }

  /**
   * Test {@link StoreProperties#isNestedNamedOperationAllow(boolean)} with {@code boolean}.
   * <p>
   * Method under test: {@link StoreProperties#isNestedNamedOperationAllow(boolean)}
   */
  @Test
  @DisplayName("Test isNestedNamedOperationAllow(boolean) with 'boolean'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StoreProperties.isNestedNamedOperationAllow(boolean)"})
  void testIsNestedNamedOperationAllowWithBoolean() {
    // Arrange
    StoreProperties storeProperties = new StoreProperties();
    storeProperties.set(StoreProperties.GAFFER_NAMED_OPERATION_NESTED, "42");

    // Act and Assert
    assertFalse(storeProperties.isNestedNamedOperationAllow(true));
  }

  /**
   * Test {@link StoreProperties#isNestedNamedOperationAllow(boolean)} with {@code boolean}.
   * <ul>
   *   <li>Given {@link StoreProperties#StoreProperties()}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StoreProperties#isNestedNamedOperationAllow(boolean)}
   */
  @Test
  @DisplayName("Test isNestedNamedOperationAllow(boolean) with 'boolean'; given StoreProperties(); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StoreProperties.isNestedNamedOperationAllow(boolean)"})
  void testIsNestedNamedOperationAllowWithBoolean_givenStoreProperties_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new StoreProperties()).isNestedNamedOperationAllow(true));
  }

  /**
   * Test {@link StoreProperties#isNestedNamedOperationAllow(boolean)} with {@code boolean}.
   * <ul>
   *   <li>When {@code false}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StoreProperties#isNestedNamedOperationAllow(boolean)}
   */
  @Test
  @DisplayName("Test isNestedNamedOperationAllow(boolean) with 'boolean'; when 'false'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StoreProperties.isNestedNamedOperationAllow(boolean)"})
  void testIsNestedNamedOperationAllowWithBoolean_whenFalse_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new StoreProperties()).isNestedNamedOperationAllow(false));
  }

  /**
   * Test {@link StoreProperties#isNestedNamedOperationAllow()}.
   * <ul>
   *   <li>Given {@link StoreProperties#StoreProperties()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StoreProperties#isNestedNamedOperationAllow()}
   */
  @Test
  @DisplayName("Test isNestedNamedOperationAllow(); given StoreProperties(); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StoreProperties.isNestedNamedOperationAllow()"})
  void testIsNestedNamedOperationAllow_givenStoreProperties_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new StoreProperties()).isNestedNamedOperationAllow());
  }

  /**
   * Test {@link StoreProperties#isNestedNamedOperationAllow()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StoreProperties#isNestedNamedOperationAllow()}
   */
  @Test
  @DisplayName("Test isNestedNamedOperationAllow(); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StoreProperties.isNestedNamedOperationAllow()"})
  void testIsNestedNamedOperationAllow_thenReturnTrue() {
    // Arrange
    StoreProperties storeProperties = new StoreProperties();
    storeProperties.setNestedNamedOperationAllow(true);

    // Act and Assert
    assertTrue(storeProperties.isNestedNamedOperationAllow());
  }

  /**
   * Test {@link StoreProperties#setNestedNamedOperationAllow(boolean)}.
   * <p>
   * Method under test: {@link StoreProperties#setNestedNamedOperationAllow(boolean)}
   */
  @Test
  @DisplayName("Test setNestedNamedOperationAllow(boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void StoreProperties.setNestedNamedOperationAllow(boolean)"})
  void testSetNestedNamedOperationAllow() {
    // Arrange
    StoreProperties storeProperties = new StoreProperties();

    // Act
    storeProperties.setNestedNamedOperationAllow(true);

    // Assert
    Properties properties = storeProperties.getProperties();
    assertEquals(2, properties.size());
    assertTrue(properties.containsKey(StoreProperties.STORE_PROPERTIES_CLASS));
    String expectedString = Boolean.TRUE.toString();
    assertEquals(expectedString, properties.get(StoreProperties.GAFFER_NAMED_OPERATION_NESTED));
  }

  /**
   * Test {@link StoreProperties#getCacheServiceJobTrackerSuffix(String)}.
   * <p>
   * Method under test: {@link StoreProperties#getCacheServiceJobTrackerSuffix(String)}
   */
  @Test
  @DisplayName("Test getCacheServiceJobTrackerSuffix(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StoreProperties.getCacheServiceJobTrackerSuffix(String)"})
  void testGetCacheServiceJobTrackerSuffix() {
    // Arrange, Act and Assert
    assertEquals("42", (new StoreProperties()).getCacheServiceJobTrackerSuffix("42"));
  }

  /**
   * Test {@link StoreProperties#getCacheServiceNamedViewSuffix(String)}.
   * <p>
   * Method under test: {@link StoreProperties#getCacheServiceNamedViewSuffix(String)}
   */
  @Test
  @DisplayName("Test getCacheServiceNamedViewSuffix(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StoreProperties.getCacheServiceNamedViewSuffix(String)"})
  void testGetCacheServiceNamedViewSuffix() {
    // Arrange, Act and Assert
    assertEquals("42", (new StoreProperties()).getCacheServiceNamedViewSuffix("42"));
  }

  /**
   * Test {@link StoreProperties#getProperties()}.
   * <p>
   * Method under test: {@link StoreProperties#getProperties()}
   */
  @Test
  @DisplayName("Test getProperties()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Properties StoreProperties.getProperties()"})
  void testGetProperties() {
    // Arrange and Act
    Properties actualProperties = (new StoreProperties()).getProperties();

    // Assert
    assertEquals(1, actualProperties.size());
    assertEquals("uk.gov.gchq.gaffer.store.StoreProperties",
        actualProperties.get(StoreProperties.STORE_PROPERTIES_CLASS));
  }

  /**
   * Test {@link StoreProperties#setProperties(Properties)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link StoreProperties#StoreProperties()} Properties Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link StoreProperties#setProperties(Properties)}
   */
  @Test
  @DisplayName("Test setProperties(Properties); when 'null'; then StoreProperties() Properties Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void StoreProperties.setProperties(Properties)"})
  void testSetProperties_whenNull_thenStorePropertiesPropertiesEmpty() {
    // Arrange
    StoreProperties storeProperties = new StoreProperties();

    // Act
    storeProperties.setProperties(null);

    // Assert
    assertTrue(storeProperties.getProperties().isEmpty());
  }

  /**
   * Test {@link StoreProperties#setProperties(Properties)}.
   * <ul>
   *   <li>When {@link Properties#Properties()}.</li>
   *   <li>Then {@link StoreProperties#StoreProperties()} Properties is {@link Properties#Properties()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StoreProperties#setProperties(Properties)}
   */
  @Test
  @DisplayName("Test setProperties(Properties); when Properties(); then StoreProperties() Properties is Properties()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void StoreProperties.setProperties(Properties)"})
  void testSetProperties_whenProperties_thenStorePropertiesPropertiesIsProperties() {
    // Arrange
    StoreProperties storeProperties = new StoreProperties();
    Properties properties = new Properties();

    // Act
    storeProperties.setProperties(properties);

    // Assert
    assertSame(properties, storeProperties.getProperties());
  }

  /**
   * Test {@link StoreProperties#clone()}.
   * <p>
   * Method under test: {@link StoreProperties#clone()}
   */
  @Test
  @DisplayName("Test clone()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"StoreProperties StoreProperties.clone()"})
  void testClone() {
    // Arrange
    StoreProperties loadStorePropertiesResult = StoreProperties
        .loadStoreProperties(new ByteArrayInputStream(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}));

    // Act and Assert
    assertEquals(loadStorePropertiesResult, loadStorePropertiesResult.clone());
  }

  /**
   * Test {@link StoreProperties#clone()}.
   * <ul>
   *   <li>Given {@link StoreProperties#StoreProperties()}.</li>
   *   <li>Then return {@link StoreProperties#StoreProperties()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StoreProperties#clone()}
   */
  @Test
  @DisplayName("Test clone(); given StoreProperties(); then return StoreProperties()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"StoreProperties StoreProperties.clone()"})
  void testClone_givenStoreProperties_thenReturnStoreProperties() {
    // Arrange
    StoreProperties storeProperties = new StoreProperties();

    // Act and Assert
    assertEquals(storeProperties, storeProperties.clone());
  }

  /**
   * Test {@link StoreProperties#clone()}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StoreProperties#clone()}
   */
  @Test
  @DisplayName("Test clone(); then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"StoreProperties StoreProperties.clone()"})
  void testClone_thenThrowRuntimeException() {
    // Arrange
    StoreProperties storeProperties = new StoreProperties();
    storeProperties.set(StoreProperties.STORE_PROPERTIES_CLASS, "42");

    // Act and Assert
    assertThrows(RuntimeException.class, () -> storeProperties.clone());
  }

  /**
   * Test {@link StoreProperties#equals(Object)}, and {@link StoreProperties#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link StoreProperties#equals(Object)}
   *   <li>{@link StoreProperties#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StoreProperties.equals(Object)", "int StoreProperties.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    StoreProperties storeProperties = new StoreProperties();
    StoreProperties storeProperties2 = new StoreProperties();

    // Act and Assert
    assertEquals(storeProperties, storeProperties2);
    int expectedHashCodeResult = storeProperties.hashCode();
    assertEquals(expectedHashCodeResult, storeProperties2.hashCode());
  }

  /**
   * Test {@link StoreProperties#equals(Object)}, and {@link StoreProperties#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link StoreProperties#equals(Object)}
   *   <li>{@link StoreProperties#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StoreProperties.equals(Object)", "int StoreProperties.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    StoreProperties storeProperties = new StoreProperties();

    // Act and Assert
    assertEquals(storeProperties, storeProperties);
    int expectedHashCodeResult = storeProperties.hashCode();
    assertEquals(expectedHashCodeResult, storeProperties.hashCode());
  }

  /**
   * Test {@link StoreProperties#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link StoreProperties#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StoreProperties.equals(Object)", "int StoreProperties.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() throws UnsupportedEncodingException {
    // Arrange
    StoreProperties loadStorePropertiesResult = StoreProperties
        .loadStoreProperties(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));

    // Act and Assert
    assertNotEquals(loadStorePropertiesResult, new StoreProperties());
  }

  /**
   * Test {@link StoreProperties#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link StoreProperties#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StoreProperties.equals(Object)", "int StoreProperties.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new StoreProperties(), null);
  }

  /**
   * Test {@link StoreProperties#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link StoreProperties#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StoreProperties.equals(Object)", "int StoreProperties.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new StoreProperties(), "Different type to StoreProperties");
  }

  /**
   * Test {@link StoreProperties#updateStorePropertiesClass(Class)} with {@code Class}.
   * <p>
   * Method under test: {@link StoreProperties#updateStorePropertiesClass(Class)}
   */
  @Test
  @DisplayName("Test updateStorePropertiesClass(Class) with 'Class'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void StoreProperties.updateStorePropertiesClass(Class)"})
  void testUpdateStorePropertiesClassWithClass() {
    // Arrange
    StoreProperties storeProperties = new StoreProperties();
    Class<StoreProperties> requiredClass = StoreProperties.class;

    // Act
    storeProperties.updateStorePropertiesClass(requiredClass);

    // Assert
    Class<StoreProperties> expectedStorePropertiesClass = StoreProperties.class;
    assertEquals(expectedStorePropertiesClass, storeProperties.getStorePropertiesClass());
  }
}
