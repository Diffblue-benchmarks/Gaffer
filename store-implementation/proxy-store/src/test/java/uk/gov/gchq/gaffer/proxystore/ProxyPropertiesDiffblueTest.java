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

package uk.gov.gchq.gaffer.proxystore;

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
import java.nio.file.Path;
import java.util.Properties;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.store.schema.Schema;

class ProxyPropertiesDiffblueTest {
  /**
   * Test {@link ProxyProperties#ProxyProperties()}.
   * <p>
   * Method under test: {@link ProxyProperties#ProxyProperties()}
   */
  @Test
  @DisplayName("Test new ProxyProperties()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ProxyProperties.<init>()"})
  void testNewProxyProperties() {
    // Arrange and Act
    ProxyProperties actualProxyProperties = new ProxyProperties();

    // Assert
    assertEquals("", actualProxyProperties.getAdminAuth());
    assertEquals("", actualProxyProperties.getJsonSerialiserModules());
    assertEquals("uk.gov.gchq.gaffer.proxystore.ProxyProperties", actualProxyProperties.getStorePropertiesClassName());
    assertEquals("uk.gov.gchq.gaffer.proxystore.ProxyStore", actualProxyProperties.getStoreClass());
    assertEquals("uk.gov.gchq.gaffer.store.schema.Schema", actualProxyProperties.getSchemaClassName());
    assertNull(actualProxyProperties.getStrictJson());
    assertNull(actualProxyProperties.getCacheServiceClass());
    assertNull(actualProxyProperties.getDefaultCacheServiceClass());
    assertNull(actualProxyProperties.getJobTrackerCacheServiceClass());
    assertNull(actualProxyProperties.getJsonSerialiserClass());
    assertNull(actualProxyProperties.getNamedOperationCacheServiceClass());
    assertNull(actualProxyProperties.getNamedViewCacheServiceClass());
    assertNull(actualProxyProperties.getOperationDeclarationPaths());
    assertNull(actualProxyProperties.getReflectionPackages());
    Properties properties = actualProxyProperties.getProperties();
    assertEquals(2, properties.size());
    assertEquals(50, actualProxyProperties.getJobExecutorThreadCount().intValue());
    assertFalse(actualProxyProperties.getJobTrackerEnabled());
    assertFalse(actualProxyProperties.getRescheduleJobsOnStart());
    assertTrue(properties.containsKey("gaffer.store.class"));
    assertTrue(properties.containsKey("gaffer.store.properties.class"));
    assertTrue(actualProxyProperties.getNamedOperationEnabled());
    assertTrue(actualProxyProperties.getNamedViewEnabled());
    Class<ProxyProperties> expectedStorePropertiesClass = ProxyProperties.class;
    assertEquals(expectedStorePropertiesClass, actualProxyProperties.getStorePropertiesClass());
    Class<Schema> expectedSchemaClass = Schema.class;
    assertEquals(expectedSchemaClass, actualProxyProperties.getSchemaClass());
    assertEquals(ProxyProperties.DEFAULT_CONNECT_TIMEOUT, actualProxyProperties.getConnectTimeout());
    assertEquals(ProxyProperties.DEFAULT_CONNECT_TIMEOUT, actualProxyProperties.getReadTimeout());
    assertEquals(ProxyProperties.DEFAULT_GAFFER_CONTEXT_ROOT, actualProxyProperties.getGafferContextRoot());
    assertEquals(ProxyProperties.DEFAULT_GAFFER_HOST, actualProxyProperties.getGafferHost());
    assertEquals(ProxyProperties.DEFAULT_GAFFER_PORT, actualProxyProperties.getGafferPort());
  }

  /**
   * Test {@link ProxyProperties#ProxyProperties(Path)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return AdminAuth is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProxyProperties#ProxyProperties(Path)}
   */
  @Test
  @DisplayName("Test new ProxyProperties(Path); when 'null'; then return AdminAuth is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ProxyProperties.<init>(Path)"})
  void testNewProxyProperties_whenNull_thenReturnAdminAuthIsEmptyString() {
    // Arrange and Act
    ProxyProperties actualProxyProperties = new ProxyProperties((Path) null);

    // Assert
    assertEquals("", actualProxyProperties.getAdminAuth());
    assertEquals("", actualProxyProperties.getJsonSerialiserModules());
    assertEquals("uk.gov.gchq.gaffer.proxystore.ProxyProperties", actualProxyProperties.getStorePropertiesClassName());
    assertEquals("uk.gov.gchq.gaffer.proxystore.ProxyStore", actualProxyProperties.getStoreClass());
    assertEquals("uk.gov.gchq.gaffer.store.schema.Schema", actualProxyProperties.getSchemaClassName());
    assertNull(actualProxyProperties.getStrictJson());
    assertNull(actualProxyProperties.getCacheServiceClass());
    assertNull(actualProxyProperties.getDefaultCacheServiceClass());
    assertNull(actualProxyProperties.getJobTrackerCacheServiceClass());
    assertNull(actualProxyProperties.getJsonSerialiserClass());
    assertNull(actualProxyProperties.getNamedOperationCacheServiceClass());
    assertNull(actualProxyProperties.getNamedViewCacheServiceClass());
    assertNull(actualProxyProperties.getOperationDeclarationPaths());
    assertNull(actualProxyProperties.getReflectionPackages());
    Properties properties = actualProxyProperties.getProperties();
    assertEquals(2, properties.size());
    assertEquals(50, actualProxyProperties.getJobExecutorThreadCount().intValue());
    assertFalse(actualProxyProperties.getJobTrackerEnabled());
    assertFalse(actualProxyProperties.getRescheduleJobsOnStart());
    assertTrue(properties.containsKey("gaffer.store.class"));
    assertTrue(properties.containsKey("gaffer.store.properties.class"));
    assertTrue(actualProxyProperties.getNamedOperationEnabled());
    assertTrue(actualProxyProperties.getNamedViewEnabled());
    Class<ProxyProperties> expectedStorePropertiesClass = ProxyProperties.class;
    assertEquals(expectedStorePropertiesClass, actualProxyProperties.getStorePropertiesClass());
    Class<Schema> expectedSchemaClass = Schema.class;
    assertEquals(expectedSchemaClass, actualProxyProperties.getSchemaClass());
    assertEquals(ProxyProperties.DEFAULT_CONNECT_TIMEOUT, actualProxyProperties.getConnectTimeout());
    assertEquals(ProxyProperties.DEFAULT_CONNECT_TIMEOUT, actualProxyProperties.getReadTimeout());
    assertEquals(ProxyProperties.DEFAULT_GAFFER_CONTEXT_ROOT, actualProxyProperties.getGafferContextRoot());
    assertEquals(ProxyProperties.DEFAULT_GAFFER_HOST, actualProxyProperties.getGafferHost());
    assertEquals(ProxyProperties.DEFAULT_GAFFER_PORT, actualProxyProperties.getGafferPort());
  }

  /**
   * Test {@link ProxyProperties#ProxyProperties(Properties)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return Properties size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProxyProperties#ProxyProperties(Properties)}
   */
  @Test
  @DisplayName("Test new ProxyProperties(Properties); when 'null'; then return Properties size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ProxyProperties.<init>(Properties)"})
  void testNewProxyProperties_whenNull_thenReturnPropertiesSizeIsTwo() {
    // Arrange, Act and Assert
    Properties properties = (new ProxyProperties((Properties) null)).getProperties();
    assertEquals(2, properties.size());
    assertEquals("uk.gov.gchq.gaffer.proxystore.ProxyProperties", properties.get("gaffer.store.properties.class"));
    assertEquals("uk.gov.gchq.gaffer.proxystore.ProxyStore", properties.get("gaffer.store.class"));
    assertNull(null);
  }

  /**
   * Test {@link ProxyProperties#ProxyProperties(Properties)}.
   * <ul>
   *   <li>When {@link Properties#Properties()}.</li>
   *   <li>Then {@link Properties#Properties()} size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProxyProperties#ProxyProperties(Properties)}
   */
  @Test
  @DisplayName("Test new ProxyProperties(Properties); when Properties(); then Properties() size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ProxyProperties.<init>(Properties)"})
  void testNewProxyProperties_whenProperties_thenPropertiesSizeIsTwo() {
    // Arrange
    Properties props = new Properties();

    // Act
    ProxyProperties actualProxyProperties = new ProxyProperties(props);

    // Assert
    assertEquals(2, props.size());
    assertEquals("uk.gov.gchq.gaffer.proxystore.ProxyProperties", props.get("gaffer.store.properties.class"));
    assertEquals("uk.gov.gchq.gaffer.proxystore.ProxyStore", props.get("gaffer.store.class"));
    assertSame(props, actualProxyProperties.getProperties());
  }

  /**
   * Test {@link ProxyProperties#loadStoreProperties(Path)} with {@code storePropertiesPath}.
   * <ul>
   *   <li>Then return AdminAuth is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProxyProperties#loadStoreProperties(Path)}
   */
  @Test
  @DisplayName("Test loadStoreProperties(Path) with 'storePropertiesPath'; then return AdminAuth is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProxyProperties ProxyProperties.loadStoreProperties(Path)"})
  void testLoadStorePropertiesWithStorePropertiesPath_thenReturnAdminAuthIsEmptyString() {
    // Arrange and Act
    ProxyProperties actualLoadStorePropertiesResult = ProxyProperties.loadStoreProperties((Path) null);

    // Assert
    assertEquals("", actualLoadStorePropertiesResult.getAdminAuth());
    assertEquals("", actualLoadStorePropertiesResult.getJsonSerialiserModules());
    assertEquals("uk.gov.gchq.gaffer.proxystore.ProxyProperties",
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
    assertTrue(properties.containsKey("gaffer.store.properties.class"));
    assertTrue(actualLoadStorePropertiesResult.getNamedOperationEnabled());
    assertTrue(actualLoadStorePropertiesResult.getNamedViewEnabled());
    Class<ProxyProperties> expectedStorePropertiesClass = ProxyProperties.class;
    assertEquals(expectedStorePropertiesClass, actualLoadStorePropertiesResult.getStorePropertiesClass());
    Class<Schema> expectedSchemaClass = Schema.class;
    assertEquals(expectedSchemaClass, actualLoadStorePropertiesResult.getSchemaClass());
    assertEquals(ProxyProperties.DEFAULT_CONNECT_TIMEOUT, actualLoadStorePropertiesResult.getConnectTimeout());
    assertEquals(ProxyProperties.DEFAULT_CONNECT_TIMEOUT, actualLoadStorePropertiesResult.getReadTimeout());
    assertEquals(ProxyProperties.DEFAULT_GAFFER_CONTEXT_ROOT, actualLoadStorePropertiesResult.getGafferContextRoot());
    assertEquals(ProxyProperties.DEFAULT_GAFFER_HOST, actualLoadStorePropertiesResult.getGafferHost());
    assertEquals(ProxyProperties.DEFAULT_GAFFER_PORT, actualLoadStorePropertiesResult.getGafferPort());
  }

  /**
   * Test {@link ProxyProperties#loadStoreProperties(InputStream)} with {@code storePropertiesStream}.
   * <p>
   * Method under test: {@link ProxyProperties#loadStoreProperties(InputStream)}
   */
  @Test
  @DisplayName("Test loadStoreProperties(InputStream) with 'storePropertiesStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProxyProperties ProxyProperties.loadStoreProperties(InputStream)"})
  void testLoadStorePropertiesWithStorePropertiesStream() {
    // Arrange and Act
    ProxyProperties actualLoadStorePropertiesResult = ProxyProperties.loadStoreProperties((InputStream) null);

    // Assert
    assertEquals("", actualLoadStorePropertiesResult.getAdminAuth());
    assertEquals("", actualLoadStorePropertiesResult.getJsonSerialiserModules());
    assertEquals("uk.gov.gchq.gaffer.proxystore.ProxyProperties",
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
    assertTrue(properties.containsKey("gaffer.store.properties.class"));
    assertTrue(actualLoadStorePropertiesResult.getNamedOperationEnabled());
    assertTrue(actualLoadStorePropertiesResult.getNamedViewEnabled());
    Class<ProxyProperties> expectedStorePropertiesClass = ProxyProperties.class;
    assertEquals(expectedStorePropertiesClass, actualLoadStorePropertiesResult.getStorePropertiesClass());
    Class<Schema> expectedSchemaClass = Schema.class;
    assertEquals(expectedSchemaClass, actualLoadStorePropertiesResult.getSchemaClass());
    assertEquals(ProxyProperties.DEFAULT_CONNECT_TIMEOUT, actualLoadStorePropertiesResult.getConnectTimeout());
    assertEquals(ProxyProperties.DEFAULT_CONNECT_TIMEOUT, actualLoadStorePropertiesResult.getReadTimeout());
    assertEquals(ProxyProperties.DEFAULT_GAFFER_CONTEXT_ROOT, actualLoadStorePropertiesResult.getGafferContextRoot());
    assertEquals(ProxyProperties.DEFAULT_GAFFER_HOST, actualLoadStorePropertiesResult.getGafferHost());
    assertEquals(ProxyProperties.DEFAULT_GAFFER_PORT, actualLoadStorePropertiesResult.getGafferPort());
  }

  /**
   * Test {@link ProxyProperties#loadStoreProperties(InputStream)} with {@code storePropertiesStream}.
   * <ul>
   *   <li>Then return Properties size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProxyProperties#loadStoreProperties(InputStream)}
   */
  @Test
  @DisplayName("Test loadStoreProperties(InputStream) with 'storePropertiesStream'; then return Properties size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProxyProperties ProxyProperties.loadStoreProperties(InputStream)"})
  void testLoadStorePropertiesWithStorePropertiesStream_thenReturnPropertiesSizeIsTwo() throws IOException {
    // Arrange
    ByteArrayInputStream storePropertiesStream = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    Properties properties = ProxyProperties.loadStoreProperties(storePropertiesStream).getProperties();
    assertEquals(2, properties.size());
    assertEquals("", properties.get("AXAXAXAX"));
    assertEquals(-1, storePropertiesStream.read(new byte[]{}));
    assertTrue(properties.containsKey("gaffer.store.properties.class"));
  }

  /**
   * Test {@link ProxyProperties#getConnectTimeout()}.
   * <ul>
   *   <li>Given {@link ProxyProperties#ProxyProperties()} {@link ProxyProperties#CONNECT_TIMEOUT} is {@code 42}.</li>
   *   <li>Then return forty-two.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProxyProperties#getConnectTimeout()}
   */
  @Test
  @DisplayName("Test getConnectTimeout(); given ProxyProperties() CONNECT_TIMEOUT is '42'; then return forty-two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int ProxyProperties.getConnectTimeout()"})
  void testGetConnectTimeout_givenProxyPropertiesConnect_timeoutIs42_thenReturnFortyTwo() {
    // Arrange
    ProxyProperties proxyProperties = new ProxyProperties();
    proxyProperties.set(ProxyProperties.CONNECT_TIMEOUT, "42");

    // Act and Assert
    assertEquals(42, proxyProperties.getConnectTimeout());
  }

  /**
   * Test {@link ProxyProperties#getConnectTimeout()}.
   * <ul>
   *   <li>Given {@link ProxyProperties#ProxyProperties()}.</li>
   *   <li>Then return {@link ProxyProperties#DEFAULT_CONNECT_TIMEOUT}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProxyProperties#getConnectTimeout()}
   */
  @Test
  @DisplayName("Test getConnectTimeout(); given ProxyProperties(); then return DEFAULT_CONNECT_TIMEOUT")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int ProxyProperties.getConnectTimeout()"})
  void testGetConnectTimeout_givenProxyProperties_thenReturnDefault_connect_timeout() {
    // Arrange, Act and Assert
    assertEquals(ProxyProperties.DEFAULT_CONNECT_TIMEOUT, (new ProxyProperties()).getConnectTimeout());
  }

  /**
   * Test {@link ProxyProperties#getConnectTimeout()}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProxyProperties#getConnectTimeout()}
   */
  @Test
  @DisplayName("Test getConnectTimeout(); then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int ProxyProperties.getConnectTimeout()"})
  void testGetConnectTimeout_thenThrowIllegalArgumentException() {
    // Arrange
    ProxyProperties proxyProperties = new ProxyProperties();
    proxyProperties.set(ProxyProperties.CONNECT_TIMEOUT, ProxyProperties.CONNECT_TIMEOUT);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> proxyProperties.getConnectTimeout());
  }

  /**
   * Test {@link ProxyProperties#setConnectTimeout(int)}.
   * <p>
   * Method under test: {@link ProxyProperties#setConnectTimeout(int)}
   */
  @Test
  @DisplayName("Test setConnectTimeout(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ProxyProperties.setConnectTimeout(int)"})
  void testSetConnectTimeout() {
    // Arrange
    ProxyProperties proxyProperties = new ProxyProperties();

    // Act
    proxyProperties.setConnectTimeout(10);

    // Assert
    Properties properties = proxyProperties.getProperties();
    assertEquals(3, properties.size());
    assertEquals("10", properties.get(ProxyProperties.CONNECT_TIMEOUT));
    assertEquals(10, proxyProperties.getConnectTimeout());
    assertTrue(properties.containsKey("gaffer.store.class"));
    assertTrue(properties.containsKey("gaffer.store.properties.class"));
  }

  /**
   * Test {@link ProxyProperties#getReadTimeout()}.
   * <ul>
   *   <li>Given {@link ProxyProperties#ProxyProperties()} {@link ProxyProperties#READ_TIMEOUT} is {@code 42}.</li>
   *   <li>Then return forty-two.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProxyProperties#getReadTimeout()}
   */
  @Test
  @DisplayName("Test getReadTimeout(); given ProxyProperties() READ_TIMEOUT is '42'; then return forty-two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int ProxyProperties.getReadTimeout()"})
  void testGetReadTimeout_givenProxyPropertiesRead_timeoutIs42_thenReturnFortyTwo() {
    // Arrange
    ProxyProperties proxyProperties = new ProxyProperties();
    proxyProperties.set(ProxyProperties.READ_TIMEOUT, "42");

    // Act and Assert
    assertEquals(42, proxyProperties.getReadTimeout());
  }

  /**
   * Test {@link ProxyProperties#getReadTimeout()}.
   * <ul>
   *   <li>Given {@link ProxyProperties#ProxyProperties()}.</li>
   *   <li>Then return {@link ProxyProperties#DEFAULT_CONNECT_TIMEOUT}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProxyProperties#getReadTimeout()}
   */
  @Test
  @DisplayName("Test getReadTimeout(); given ProxyProperties(); then return DEFAULT_CONNECT_TIMEOUT")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int ProxyProperties.getReadTimeout()"})
  void testGetReadTimeout_givenProxyProperties_thenReturnDefault_connect_timeout() {
    // Arrange, Act and Assert
    assertEquals(ProxyProperties.DEFAULT_CONNECT_TIMEOUT, (new ProxyProperties()).getReadTimeout());
  }

  /**
   * Test {@link ProxyProperties#getReadTimeout()}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProxyProperties#getReadTimeout()}
   */
  @Test
  @DisplayName("Test getReadTimeout(); then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int ProxyProperties.getReadTimeout()"})
  void testGetReadTimeout_thenThrowIllegalArgumentException() {
    // Arrange
    ProxyProperties proxyProperties = new ProxyProperties();
    proxyProperties.set(ProxyProperties.READ_TIMEOUT, ProxyProperties.READ_TIMEOUT);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> proxyProperties.getReadTimeout());
  }

  /**
   * Test {@link ProxyProperties#setReadTimeout(int)}.
   * <p>
   * Method under test: {@link ProxyProperties#setReadTimeout(int)}
   */
  @Test
  @DisplayName("Test setReadTimeout(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ProxyProperties.setReadTimeout(int)"})
  void testSetReadTimeout() {
    // Arrange
    ProxyProperties proxyProperties = new ProxyProperties();

    // Act
    proxyProperties.setReadTimeout(10);

    // Assert
    Properties properties = proxyProperties.getProperties();
    assertEquals(3, properties.size());
    assertEquals("10", properties.get(ProxyProperties.READ_TIMEOUT));
    assertEquals(10, proxyProperties.getReadTimeout());
    assertTrue(properties.containsKey("gaffer.store.class"));
    assertTrue(properties.containsKey("gaffer.store.properties.class"));
  }

  /**
   * Test {@link ProxyProperties#getGafferHost()}.
   * <p>
   * Method under test: {@link ProxyProperties#getGafferHost()}
   */
  @Test
  @DisplayName("Test getGafferHost()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ProxyProperties.getGafferHost()"})
  void testGetGafferHost() {
    // Arrange, Act and Assert
    assertEquals(ProxyProperties.DEFAULT_GAFFER_HOST, (new ProxyProperties()).getGafferHost());
  }

  /**
   * Test {@link ProxyProperties#setGafferHost(String)}.
   * <p>
   * Method under test: {@link ProxyProperties#setGafferHost(String)}
   */
  @Test
  @DisplayName("Test setGafferHost(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ProxyProperties.setGafferHost(String)"})
  void testSetGafferHost() {
    // Arrange
    ProxyProperties proxyProperties = new ProxyProperties();

    // Act
    proxyProperties.setGafferHost(ProxyProperties.DEFAULT_GAFFER_HOST);

    // Assert
    Properties properties = proxyProperties.getProperties();
    assertEquals(3, properties.size());
    assertTrue(properties.containsKey("gaffer.store.class"));
    assertTrue(properties.containsKey("gaffer.store.properties.class"));
    assertEquals(ProxyProperties.DEFAULT_GAFFER_HOST, properties.get(ProxyProperties.GAFFER_HOST));
  }

  /**
   * Test {@link ProxyProperties#getGafferPort()}.
   * <ul>
   *   <li>Given {@link ProxyProperties#ProxyProperties()} {@link ProxyProperties#GAFFER_PORT} is {@code 42}.</li>
   *   <li>Then return forty-two.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProxyProperties#getGafferPort()}
   */
  @Test
  @DisplayName("Test getGafferPort(); given ProxyProperties() GAFFER_PORT is '42'; then return forty-two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int ProxyProperties.getGafferPort()"})
  void testGetGafferPort_givenProxyPropertiesGaffer_portIs42_thenReturnFortyTwo() {
    // Arrange
    ProxyProperties proxyProperties = new ProxyProperties();
    proxyProperties.set(ProxyProperties.GAFFER_PORT, "42");

    // Act and Assert
    assertEquals(42, proxyProperties.getGafferPort());
  }

  /**
   * Test {@link ProxyProperties#getGafferPort()}.
   * <ul>
   *   <li>Given {@link ProxyProperties#ProxyProperties()}.</li>
   *   <li>Then return {@link ProxyProperties#DEFAULT_GAFFER_PORT}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProxyProperties#getGafferPort()}
   */
  @Test
  @DisplayName("Test getGafferPort(); given ProxyProperties(); then return DEFAULT_GAFFER_PORT")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int ProxyProperties.getGafferPort()"})
  void testGetGafferPort_givenProxyProperties_thenReturnDefault_gaffer_port() {
    // Arrange, Act and Assert
    assertEquals(ProxyProperties.DEFAULT_GAFFER_PORT, (new ProxyProperties()).getGafferPort());
  }

  /**
   * Test {@link ProxyProperties#getGafferPort()}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProxyProperties#getGafferPort()}
   */
  @Test
  @DisplayName("Test getGafferPort(); then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int ProxyProperties.getGafferPort()"})
  void testGetGafferPort_thenThrowIllegalArgumentException() {
    // Arrange
    ProxyProperties proxyProperties = new ProxyProperties();
    proxyProperties.set(ProxyProperties.GAFFER_PORT, ProxyProperties.GAFFER_PORT);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> proxyProperties.getGafferPort());
  }

  /**
   * Test {@link ProxyProperties#setGafferPort(int)}.
   * <p>
   * Method under test: {@link ProxyProperties#setGafferPort(int)}
   */
  @Test
  @DisplayName("Test setGafferPort(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ProxyProperties.setGafferPort(int)"})
  void testSetGafferPort() {
    // Arrange
    ProxyProperties proxyProperties = new ProxyProperties();

    // Act
    proxyProperties.setGafferPort(ProxyProperties.DEFAULT_GAFFER_PORT);

    // Assert
    Properties properties = proxyProperties.getProperties();
    assertEquals(3, properties.size());
    assertEquals("8080", properties.get(ProxyProperties.GAFFER_PORT));
    assertTrue(properties.containsKey("gaffer.store.class"));
    assertTrue(properties.containsKey("gaffer.store.properties.class"));
  }

  /**
   * Test {@link ProxyProperties#getGafferContextRoot()}.
   * <p>
   * Method under test: {@link ProxyProperties#getGafferContextRoot()}
   */
  @Test
  @DisplayName("Test getGafferContextRoot()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ProxyProperties.getGafferContextRoot()"})
  void testGetGafferContextRoot() {
    // Arrange, Act and Assert
    assertEquals(ProxyProperties.DEFAULT_GAFFER_CONTEXT_ROOT, (new ProxyProperties()).getGafferContextRoot());
  }

  /**
   * Test {@link ProxyProperties#setGafferContextRoot(String)}.
   * <ul>
   *   <li>Then {@link ProxyProperties#ProxyProperties()} GafferContextRoot is {@code /Gaffer Context Root}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProxyProperties#setGafferContextRoot(String)}
   */
  @Test
  @DisplayName("Test setGafferContextRoot(String); then ProxyProperties() GafferContextRoot is '/Gaffer Context Root'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ProxyProperties.setGafferContextRoot(String)"})
  void testSetGafferContextRoot_thenProxyPropertiesGafferContextRootIsGafferContextRoot() {
    // Arrange
    ProxyProperties proxyProperties = new ProxyProperties();

    // Act
    proxyProperties.setGafferContextRoot("Gaffer Context Root");

    // Assert
    assertEquals("/Gaffer Context Root", proxyProperties.getGafferContextRoot());
    Properties properties = proxyProperties.getProperties();
    assertEquals(3, properties.size());
    assertEquals("/Gaffer Context Root", properties.get(ProxyProperties.GAFFER_CONTEXT_ROOT));
    assertEquals("http://localhost:8080/Gaffer Context Root", proxyProperties.getGafferUrl().toString());
    assertTrue(properties.containsKey("gaffer.store.class"));
    assertTrue(properties.containsKey("gaffer.store.properties.class"));
  }

  /**
   * Test {@link ProxyProperties#setGafferContextRoot(String)}.
   * <ul>
   *   <li>When empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProxyProperties#setGafferContextRoot(String)}
   */
  @Test
  @DisplayName("Test setGafferContextRoot(String); when empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ProxyProperties.setGafferContextRoot(String)"})
  void testSetGafferContextRoot_whenEmptyString() {
    // Arrange
    ProxyProperties proxyProperties = new ProxyProperties();

    // Act
    proxyProperties.setGafferContextRoot("");

    // Assert
    assertEquals("/", proxyProperties.getGafferContextRoot());
    Properties properties = proxyProperties.getProperties();
    assertEquals(3, properties.size());
    assertEquals("/", properties.get(ProxyProperties.GAFFER_CONTEXT_ROOT));
    assertEquals("http://localhost:8080/", proxyProperties.getGafferUrl().toString());
    assertTrue(properties.containsKey("gaffer.store.class"));
    assertTrue(properties.containsKey("gaffer.store.properties.class"));
  }

  /**
   * Test {@link ProxyProperties#setGafferContextRoot(String)}.
   * <ul>
   *   <li>When {@code /}.</li>
   *   <li>Then {@link ProxyProperties#ProxyProperties()} GafferContextRoot is {@code /}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProxyProperties#setGafferContextRoot(String)}
   */
  @Test
  @DisplayName("Test setGafferContextRoot(String); when '/'; then ProxyProperties() GafferContextRoot is '/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ProxyProperties.setGafferContextRoot(String)"})
  void testSetGafferContextRoot_whenSlash_thenProxyPropertiesGafferContextRootIsSlash() {
    // Arrange
    ProxyProperties proxyProperties = new ProxyProperties();

    // Act
    proxyProperties.setGafferContextRoot("/");

    // Assert
    assertEquals("/", proxyProperties.getGafferContextRoot());
    Properties properties = proxyProperties.getProperties();
    assertEquals(3, properties.size());
    assertEquals("/", properties.get(ProxyProperties.GAFFER_CONTEXT_ROOT));
    assertEquals("http://localhost:8080/", proxyProperties.getGafferUrl().toString());
    assertTrue(properties.containsKey("gaffer.store.class"));
    assertTrue(properties.containsKey("gaffer.store.properties.class"));
  }

  /**
   * Test {@link ProxyProperties#getGafferUrl()}.
   * <p>
   * Method under test: {@link ProxyProperties#getGafferUrl()}
   */
  @Test
  @DisplayName("Test getGafferUrl()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.net.URL ProxyProperties.getGafferUrl()"})
  void testGetGafferUrl() {
    // Arrange, Act and Assert
    assertEquals("http://localhost:8080/rest", (new ProxyProperties()).getGafferUrl().toString());
  }

  /**
   * Test {@link ProxyProperties#getGafferUrl(String, String)} with {@code protocol}, {@code suffix}.
   * <ul>
   *   <li>When empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProxyProperties#getGafferUrl(String, String)}
   */
  @Test
  @DisplayName("Test getGafferUrl(String, String) with 'protocol', 'suffix'; when empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.net.URL ProxyProperties.getGafferUrl(String, String)"})
  void testGetGafferUrlWithProtocolSuffix_whenEmptyString() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new ProxyProperties()).getGafferUrl("https://example.org/example", ""));
  }

  /**
   * Test {@link ProxyProperties#getGafferUrl(String, String)} with {@code protocol}, {@code suffix}.
   * <ul>
   *   <li>When {@code https://example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProxyProperties#getGafferUrl(String, String)}
   */
  @Test
  @DisplayName("Test getGafferUrl(String, String) with 'protocol', 'suffix'; when 'https://example.org/example'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.net.URL ProxyProperties.getGafferUrl(String, String)"})
  void testGetGafferUrlWithProtocolSuffix_whenHttpsExampleOrgExample() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new ProxyProperties()).getGafferUrl("https://example.org/example", "https://example.org/example"));
  }

  /**
   * Test {@link ProxyProperties#getGafferUrl(String, String)} with {@code protocol}, {@code suffix}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProxyProperties#getGafferUrl(String, String)}
   */
  @Test
  @DisplayName("Test getGafferUrl(String, String) with 'protocol', 'suffix'; when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.net.URL ProxyProperties.getGafferUrl(String, String)"})
  void testGetGafferUrlWithProtocolSuffix_whenNull() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new ProxyProperties()).getGafferUrl("https://example.org/example", null));
  }

  /**
   * Test {@link ProxyProperties#getGafferUrl(String)} with {@code suffix}.
   * <p>
   * Method under test: {@link ProxyProperties#getGafferUrl(String)}
   */
  @Test
  @DisplayName("Test getGafferUrl(String) with 'suffix'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.net.URL ProxyProperties.getGafferUrl(String)"})
  void testGetGafferUrlWithSuffix() {
    // Arrange, Act and Assert
    assertEquals("http://localhost:8080/rest/https://example.org/example",
        (new ProxyProperties()).getGafferUrl("https://example.org/example").toString());
  }

  /**
   * Test {@link ProxyProperties#getGafferUrl(String)} with {@code suffix}.
   * <ul>
   *   <li>When empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProxyProperties#getGafferUrl(String)}
   */
  @Test
  @DisplayName("Test getGafferUrl(String) with 'suffix'; when empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.net.URL ProxyProperties.getGafferUrl(String)"})
  void testGetGafferUrlWithSuffix_whenEmptyString() {
    // Arrange, Act and Assert
    assertEquals("http://localhost:8080/rest", (new ProxyProperties()).getGafferUrl("").toString());
  }

  /**
   * Test {@link ProxyProperties#getGafferUrl(String)} with {@code suffix}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return toString is {@code http://localhost:8080/rest}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProxyProperties#getGafferUrl(String)}
   */
  @Test
  @DisplayName("Test getGafferUrl(String) with 'suffix'; when 'null'; then return toString is 'http://localhost:8080/rest'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.net.URL ProxyProperties.getGafferUrl(String)"})
  void testGetGafferUrlWithSuffix_whenNull_thenReturnToStringIsHttpLocalhost8080Rest() {
    // Arrange, Act and Assert
    assertEquals("http://localhost:8080/rest", (new ProxyProperties()).getGafferUrl(null).toString());
  }
}
