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

package uk.gov.gchq.gaffer.federatedstore;

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
import uk.gov.gchq.gaffer.store.StoreProperties;
import uk.gov.gchq.gaffer.store.schema.Schema;

class FederatedStorePropertiesDiffblueTest {
  /**
   * Test new {@link FederatedStoreProperties} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link FederatedStoreProperties}
   */
  @Test
  @DisplayName("Test new FederatedStoreProperties (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void FederatedStoreProperties.<init>()"})
  void testNewFederatedStoreProperties() {
    // Arrange and Act
    FederatedStoreProperties actualFederatedStoreProperties = new FederatedStoreProperties();

    // Assert
    assertEquals("", actualFederatedStoreProperties.getAdminAuth());
    assertEquals("", actualFederatedStoreProperties.getJsonSerialiserModules());
    assertEquals("uk.gov.gchq.gaffer.federatedstore.FederatedStore", actualFederatedStoreProperties.getStoreClass());
    assertEquals("uk.gov.gchq.gaffer.federatedstore.FederatedStoreProperties",
        actualFederatedStoreProperties.getStorePropertiesClassName());
    assertEquals("uk.gov.gchq.gaffer.store.schema.Schema", actualFederatedStoreProperties.getSchemaClassName());
    assertNull(actualFederatedStoreProperties.getStrictJson());
    assertNull(actualFederatedStoreProperties.getCustomPropsValue());
    assertNull(actualFederatedStoreProperties.getFederatedStoreCacheServiceClass());
    assertNull(actualFederatedStoreProperties.getStoreConfiguredGraphIds());
    assertNull(actualFederatedStoreProperties.getStoreConfiguredMergeFunctions());
    assertNull(actualFederatedStoreProperties.getCacheServiceClass());
    assertNull(actualFederatedStoreProperties.getDefaultCacheServiceClass());
    assertNull(actualFederatedStoreProperties.getJobTrackerCacheServiceClass());
    assertNull(actualFederatedStoreProperties.getJsonSerialiserClass());
    assertNull(actualFederatedStoreProperties.getNamedOperationCacheServiceClass());
    assertNull(actualFederatedStoreProperties.getNamedViewCacheServiceClass());
    assertNull(actualFederatedStoreProperties.getOperationDeclarationPaths());
    assertNull(actualFederatedStoreProperties.getReflectionPackages());
    Properties properties = actualFederatedStoreProperties.getProperties();
    assertEquals(2, properties.size());
    assertEquals(50, actualFederatedStoreProperties.getJobExecutorThreadCount().intValue());
    assertFalse(actualFederatedStoreProperties.getJobTrackerEnabled());
    assertFalse(actualFederatedStoreProperties.getRescheduleJobsOnStart());
    assertTrue(properties.containsKey("gaffer.store.class"));
    assertTrue(properties.containsKey("gaffer.store.properties.class"));
    assertTrue(actualFederatedStoreProperties.getNamedOperationEnabled());
    assertTrue(actualFederatedStoreProperties.getNamedViewEnabled());
    String expectedIsPublicAccessAllowed = Boolean.TRUE.toString();
    assertEquals(expectedIsPublicAccessAllowed, actualFederatedStoreProperties.getIsPublicAccessAllowed());
    Class<FederatedStoreProperties> expectedStorePropertiesClass = FederatedStoreProperties.class;
    assertEquals(expectedStorePropertiesClass, actualFederatedStoreProperties.getStorePropertiesClass());
    Class<Schema> expectedSchemaClass = Schema.class;
    assertEquals(expectedSchemaClass, actualFederatedStoreProperties.getSchemaClass());
  }

  /**
   * Test {@link FederatedStoreProperties#loadStoreProperties(Path)} with {@code storePropertiesPath}.
   * <ul>
   *   <li>Then return AdminAuth is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link FederatedStoreProperties#loadStoreProperties(Path)}
   */
  @Test
  @DisplayName("Test loadStoreProperties(Path) with 'storePropertiesPath'; then return AdminAuth is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"FederatedStoreProperties FederatedStoreProperties.loadStoreProperties(Path)"})
  void testLoadStorePropertiesWithStorePropertiesPath_thenReturnAdminAuthIsEmptyString() {
    // Arrange and Act
    FederatedStoreProperties actualLoadStorePropertiesResult = FederatedStoreProperties
        .loadStoreProperties((Path) null);

    // Assert
    assertEquals("", actualLoadStorePropertiesResult.getAdminAuth());
    assertEquals("", actualLoadStorePropertiesResult.getJsonSerialiserModules());
    assertEquals("uk.gov.gchq.gaffer.federatedstore.FederatedStoreProperties",
        actualLoadStorePropertiesResult.getStorePropertiesClassName());
    assertEquals("uk.gov.gchq.gaffer.store.schema.Schema", actualLoadStorePropertiesResult.getSchemaClassName());
    assertNull(actualLoadStorePropertiesResult.getStrictJson());
    assertNull(actualLoadStorePropertiesResult.getCustomPropsValue());
    assertNull(actualLoadStorePropertiesResult.getFederatedStoreCacheServiceClass());
    assertNull(actualLoadStorePropertiesResult.getStoreConfiguredGraphIds());
    assertNull(actualLoadStorePropertiesResult.getStoreConfiguredMergeFunctions());
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
    assertTrue(properties.containsKey("gaffer.store.properties.class"));
    assertTrue(actualLoadStorePropertiesResult.getNamedOperationEnabled());
    assertTrue(actualLoadStorePropertiesResult.getNamedViewEnabled());
    String expectedIsPublicAccessAllowed = Boolean.TRUE.toString();
    assertEquals(expectedIsPublicAccessAllowed, actualLoadStorePropertiesResult.getIsPublicAccessAllowed());
    Class<FederatedStoreProperties> expectedStorePropertiesClass = FederatedStoreProperties.class;
    assertEquals(expectedStorePropertiesClass, actualLoadStorePropertiesResult.getStorePropertiesClass());
    Class<Schema> expectedSchemaClass = Schema.class;
    assertEquals(expectedSchemaClass, actualLoadStorePropertiesResult.getSchemaClass());
  }

  /**
   * Test {@link FederatedStoreProperties#loadStoreProperties(InputStream)} with {@code storePropertiesStream}.
   * <p>
   * Method under test: {@link FederatedStoreProperties#loadStoreProperties(InputStream)}
   */
  @Test
  @DisplayName("Test loadStoreProperties(InputStream) with 'storePropertiesStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"FederatedStoreProperties FederatedStoreProperties.loadStoreProperties(InputStream)"})
  void testLoadStorePropertiesWithStorePropertiesStream() {
    // Arrange and Act
    FederatedStoreProperties actualLoadStorePropertiesResult = FederatedStoreProperties
        .loadStoreProperties((InputStream) null);

    // Assert
    assertEquals("", actualLoadStorePropertiesResult.getAdminAuth());
    assertEquals("", actualLoadStorePropertiesResult.getJsonSerialiserModules());
    assertEquals("uk.gov.gchq.gaffer.federatedstore.FederatedStoreProperties",
        actualLoadStorePropertiesResult.getStorePropertiesClassName());
    assertEquals("uk.gov.gchq.gaffer.store.schema.Schema", actualLoadStorePropertiesResult.getSchemaClassName());
    assertNull(null);
    assertNull(actualLoadStorePropertiesResult.getStrictJson());
    assertNull(actualLoadStorePropertiesResult.getCustomPropsValue());
    assertNull(actualLoadStorePropertiesResult.getFederatedStoreCacheServiceClass());
    assertNull(actualLoadStorePropertiesResult.getStoreConfiguredGraphIds());
    assertNull(actualLoadStorePropertiesResult.getStoreConfiguredMergeFunctions());
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
    assertTrue(properties.containsKey("gaffer.store.properties.class"));
    assertTrue(actualLoadStorePropertiesResult.getNamedOperationEnabled());
    assertTrue(actualLoadStorePropertiesResult.getNamedViewEnabled());
    String expectedIsPublicAccessAllowed = Boolean.TRUE.toString();
    assertEquals(expectedIsPublicAccessAllowed, actualLoadStorePropertiesResult.getIsPublicAccessAllowed());
    Class<FederatedStoreProperties> expectedStorePropertiesClass = FederatedStoreProperties.class;
    assertEquals(expectedStorePropertiesClass, actualLoadStorePropertiesResult.getStorePropertiesClass());
    Class<Schema> expectedSchemaClass = Schema.class;
    assertEquals(expectedSchemaClass, actualLoadStorePropertiesResult.getSchemaClass());
  }

  /**
   * Test {@link FederatedStoreProperties#loadStoreProperties(InputStream)} with {@code storePropertiesStream}.
   * <ul>
   *   <li>Then return Properties size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link FederatedStoreProperties#loadStoreProperties(InputStream)}
   */
  @Test
  @DisplayName("Test loadStoreProperties(InputStream) with 'storePropertiesStream'; then return Properties size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"FederatedStoreProperties FederatedStoreProperties.loadStoreProperties(InputStream)"})
  void testLoadStorePropertiesWithStorePropertiesStream_thenReturnPropertiesSizeIsTwo() throws IOException {
    // Arrange
    ByteArrayInputStream storePropertiesStream = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    Properties properties = FederatedStoreProperties.loadStoreProperties(storePropertiesStream).getProperties();
    assertEquals(2, properties.size());
    assertEquals("", properties.get("AXAXAXAX"));
    assertEquals(-1, storePropertiesStream.read(new byte[]{}));
    assertTrue(properties.containsKey("gaffer.store.properties.class"));
  }

  /**
   * Test {@link FederatedStoreProperties#setCustomPropertyAuths(String)}.
   * <p>
   * Method under test: {@link FederatedStoreProperties#setCustomPropertyAuths(String)}
   */
  @Test
  @DisplayName("Test setCustomPropertyAuths(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void FederatedStoreProperties.setCustomPropertyAuths(String)"})
  void testSetCustomPropertyAuths() {
    // Arrange
    FederatedStoreProperties federatedStoreProperties = new FederatedStoreProperties();

    // Act
    federatedStoreProperties.setCustomPropertyAuths("Auths");

    // Assert
    assertEquals("Auths", federatedStoreProperties.getCustomPropsValue());
    Properties properties = federatedStoreProperties.getProperties();
    assertEquals(3, properties.size());
    assertEquals("Auths", properties.get(FederatedStoreProperties.CUSTOM_PROPERTIES_AUTHS));
    assertTrue(properties.containsKey("gaffer.store.class"));
    assertTrue(properties.containsKey("gaffer.store.properties.class"));
  }

  /**
   * Test {@link FederatedStoreProperties#getCustomPropsValue()}.
   * <p>
   * Method under test: {@link FederatedStoreProperties#getCustomPropsValue()}
   */
  @Test
  @DisplayName("Test getCustomPropsValue()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String FederatedStoreProperties.getCustomPropsValue()"})
  void testGetCustomPropsValue() {
    // Arrange, Act and Assert
    assertNull((new FederatedStoreProperties()).getCustomPropsValue());
  }

  /**
   * Test {@link FederatedStoreProperties#getIsPublicAccessAllowed()}.
   * <p>
   * Method under test: {@link FederatedStoreProperties#getIsPublicAccessAllowed()}
   */
  @Test
  @DisplayName("Test getIsPublicAccessAllowed()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String FederatedStoreProperties.getIsPublicAccessAllowed()"})
  void testGetIsPublicAccessAllowed() {
    // Arrange and Act
    String actualIsPublicAccessAllowed = (new FederatedStoreProperties()).getIsPublicAccessAllowed();

    // Assert
    assertEquals(Boolean.TRUE.toString(), actualIsPublicAccessAllowed);
  }

  /**
   * Test {@link FederatedStoreProperties#getIsPublicAccessAllowed(String)} with {@code String}.
   * <p>
   * Method under test: {@link FederatedStoreProperties#getIsPublicAccessAllowed(String)}
   */
  @Test
  @DisplayName("Test getIsPublicAccessAllowed(String) with 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String FederatedStoreProperties.getIsPublicAccessAllowed(String)"})
  void testGetIsPublicAccessAllowedWithString() {
    // Arrange, Act and Assert
    assertEquals("42", (new FederatedStoreProperties()).getIsPublicAccessAllowed("42"));
  }

  /**
   * Test {@link FederatedStoreProperties#setFalseGraphsCanHavePublicAccess()}.
   * <p>
   * Method under test: {@link FederatedStoreProperties#setFalseGraphsCanHavePublicAccess()}
   */
  @Test
  @DisplayName("Test setFalseGraphsCanHavePublicAccess()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void FederatedStoreProperties.setFalseGraphsCanHavePublicAccess()"})
  void testSetFalseGraphsCanHavePublicAccess() {
    // Arrange
    FederatedStoreProperties federatedStoreProperties = new FederatedStoreProperties();

    // Act
    federatedStoreProperties.setFalseGraphsCanHavePublicAccess();

    // Assert
    Properties properties = federatedStoreProperties.getProperties();
    assertEquals(3, properties.size());
    assertTrue(properties.containsKey("gaffer.store.class"));
    assertTrue(properties.containsKey("gaffer.store.properties.class"));
    String expectedIsPublicAccessAllowed = Boolean.FALSE.toString();
    assertEquals(expectedIsPublicAccessAllowed, federatedStoreProperties.getIsPublicAccessAllowed());
    String expectedString = Boolean.FALSE.toString();
    assertEquals(expectedString, properties.get(FederatedStoreProperties.IS_PUBLIC_ACCESS_ALLOWED));
  }

  /**
   * Test {@link FederatedStoreProperties#setTrueGraphsCanHavePublicAccess()}.
   * <p>
   * Method under test: {@link FederatedStoreProperties#setTrueGraphsCanHavePublicAccess()}
   */
  @Test
  @DisplayName("Test setTrueGraphsCanHavePublicAccess()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void FederatedStoreProperties.setTrueGraphsCanHavePublicAccess()"})
  void testSetTrueGraphsCanHavePublicAccess() {
    // Arrange
    FederatedStoreProperties federatedStoreProperties = new FederatedStoreProperties();

    // Act
    federatedStoreProperties.setTrueGraphsCanHavePublicAccess();

    // Assert
    Properties properties = federatedStoreProperties.getProperties();
    assertEquals(3, properties.size());
    assertTrue(properties.containsKey("gaffer.store.class"));
    assertTrue(properties.containsKey("gaffer.store.properties.class"));
    String expectedString = Boolean.TRUE.toString();
    assertEquals(expectedString, properties.get(FederatedStoreProperties.IS_PUBLIC_ACCESS_ALLOWED));
  }

  /**
   * Test {@link FederatedStoreProperties#setGraphsCanHavePublicAccess(boolean)}.
   * <p>
   * Method under test: {@link FederatedStoreProperties#setGraphsCanHavePublicAccess(boolean)}
   */
  @Test
  @DisplayName("Test setGraphsCanHavePublicAccess(boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void FederatedStoreProperties.setGraphsCanHavePublicAccess(boolean)"})
  void testSetGraphsCanHavePublicAccess() {
    // Arrange
    FederatedStoreProperties federatedStoreProperties = new FederatedStoreProperties();

    // Act
    federatedStoreProperties.setGraphsCanHavePublicAccess(true);

    // Assert
    Properties properties = federatedStoreProperties.getProperties();
    assertEquals(3, properties.size());
    assertTrue(properties.containsKey("gaffer.store.class"));
    assertTrue(properties.containsKey("gaffer.store.properties.class"));
    String expectedString = Boolean.TRUE.toString();
    assertEquals(expectedString, properties.get(FederatedStoreProperties.IS_PUBLIC_ACCESS_ALLOWED));
  }

  /**
   * Test {@link FederatedStoreProperties#getStoreConfiguredMergeFunctions()}.
   * <p>
   * Method under test: {@link FederatedStoreProperties#getStoreConfiguredMergeFunctions()}
   */
  @Test
  @DisplayName("Test getStoreConfiguredMergeFunctions()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String FederatedStoreProperties.getStoreConfiguredMergeFunctions()"})
  void testGetStoreConfiguredMergeFunctions() {
    // Arrange, Act and Assert
    assertNull((new FederatedStoreProperties()).getStoreConfiguredMergeFunctions());
  }

  /**
   * Test {@link FederatedStoreProperties#setStoreConfiguredMergeFunctions(String)}.
   * <p>
   * Method under test: {@link FederatedStoreProperties#setStoreConfiguredMergeFunctions(String)}
   */
  @Test
  @DisplayName("Test setStoreConfiguredMergeFunctions(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void FederatedStoreProperties.setStoreConfiguredMergeFunctions(String)"})
  void testSetStoreConfiguredMergeFunctions() {
    // Arrange
    FederatedStoreProperties federatedStoreProperties = new FederatedStoreProperties();

    // Act
    federatedStoreProperties.setStoreConfiguredMergeFunctions("Merge Function File");

    // Assert
    assertEquals("Merge Function File", federatedStoreProperties.getStoreConfiguredMergeFunctions());
    Properties properties = federatedStoreProperties.getProperties();
    assertEquals(3, properties.size());
    assertEquals("Merge Function File", properties.get(FederatedStoreProperties.STORE_CONFIGURED_MERGE_FUNCTIONS));
    assertTrue(properties.containsKey("gaffer.store.class"));
    assertTrue(properties.containsKey("gaffer.store.properties.class"));
  }

  /**
   * Test {@link FederatedStoreProperties#getStoreConfiguredGraphIds()}.
   * <p>
   * Method under test: {@link FederatedStoreProperties#getStoreConfiguredGraphIds()}
   */
  @Test
  @DisplayName("Test getStoreConfiguredGraphIds()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String FederatedStoreProperties.getStoreConfiguredGraphIds()"})
  void testGetStoreConfiguredGraphIds() {
    // Arrange, Act and Assert
    assertNull((new FederatedStoreProperties()).getStoreConfiguredGraphIds());
  }

  /**
   * Test {@link FederatedStoreProperties#setStoreConfiguredGraphIds(String)}.
   * <p>
   * Method under test: {@link FederatedStoreProperties#setStoreConfiguredGraphIds(String)}
   */
  @Test
  @DisplayName("Test setStoreConfiguredGraphIds(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void FederatedStoreProperties.setStoreConfiguredGraphIds(String)"})
  void testSetStoreConfiguredGraphIds() {
    // Arrange
    FederatedStoreProperties federatedStoreProperties = new FederatedStoreProperties();

    // Act
    federatedStoreProperties.setStoreConfiguredGraphIds("Merge Function File");

    // Assert
    assertEquals("Merge Function File", federatedStoreProperties.getStoreConfiguredGraphIds());
    Properties properties = federatedStoreProperties.getProperties();
    assertEquals(3, properties.size());
    assertEquals("Merge Function File", properties.get(FederatedStoreProperties.STORE_CONFIGURED_GRAPHIDS));
    assertTrue(properties.containsKey("gaffer.store.class"));
    assertTrue(properties.containsKey("gaffer.store.properties.class"));
  }

  /**
   * Test {@link FederatedStoreProperties#getCacheServiceFederatedStoreSuffix(String)} with {@code defaultValue}.
   * <p>
   * Method under test: {@link FederatedStoreProperties#getCacheServiceFederatedStoreSuffix(String)}
   */
  @Test
  @DisplayName("Test getCacheServiceFederatedStoreSuffix(String) with 'defaultValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String FederatedStoreProperties.getCacheServiceFederatedStoreSuffix(String)"})
  void testGetCacheServiceFederatedStoreSuffixWithDefaultValue() {
    // Arrange, Act and Assert
    assertEquals("42", (new FederatedStoreProperties()).getCacheServiceFederatedStoreSuffix("42"));
  }

  /**
   * Test {@link FederatedStoreProperties#getCacheServiceFederatedStoreSuffix(StoreProperties, String)} with {@code properties}, {@code defaultValue}.
   * <ul>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FederatedStoreProperties#getCacheServiceFederatedStoreSuffix(StoreProperties, String)}
   */
  @Test
  @DisplayName("Test getCacheServiceFederatedStoreSuffix(StoreProperties, String) with 'properties', 'defaultValue'; then return '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String FederatedStoreProperties.getCacheServiceFederatedStoreSuffix(StoreProperties, String)"})
  void testGetCacheServiceFederatedStoreSuffixWithPropertiesDefaultValue_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42", FederatedStoreProperties.getCacheServiceFederatedStoreSuffix(new StoreProperties(), "42"));
  }

  /**
   * Test {@link FederatedStoreProperties#getFederatedStoreCacheServiceClass()}.
   * <p>
   * Method under test: {@link FederatedStoreProperties#getFederatedStoreCacheServiceClass()}
   */
  @Test
  @DisplayName("Test getFederatedStoreCacheServiceClass()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String FederatedStoreProperties.getFederatedStoreCacheServiceClass()"})
  void testGetFederatedStoreCacheServiceClass() {
    // Arrange, Act and Assert
    assertNull((new FederatedStoreProperties()).getFederatedStoreCacheServiceClass());
  }

  /**
   * Test {@link FederatedStoreProperties#setFederatedStoreCacheServiceClass(String)}.
   * <p>
   * Method under test: {@link FederatedStoreProperties#setFederatedStoreCacheServiceClass(String)}
   */
  @Test
  @DisplayName("Test setFederatedStoreCacheServiceClass(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void FederatedStoreProperties.setFederatedStoreCacheServiceClass(String)"})
  void testSetFederatedStoreCacheServiceClass() {
    // Arrange
    FederatedStoreProperties federatedStoreProperties = new FederatedStoreProperties();

    // Act
    federatedStoreProperties.setFederatedStoreCacheServiceClass("Cache Service Class String");

    // Assert
    assertEquals("Cache Service Class String", federatedStoreProperties.getFederatedStoreCacheServiceClass());
    Properties properties = federatedStoreProperties.getProperties();
    assertEquals(3, properties.size());
    assertEquals("Cache Service Class String",
        properties.get(FederatedStoreProperties.CACHE_SERVICE_FEDERATED_STORE_CLASS));
    assertTrue(properties.containsKey("gaffer.store.class"));
    assertTrue(properties.containsKey("gaffer.store.properties.class"));
  }
}
