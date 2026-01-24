/*
 * Copyright 2026 Crown Copyright
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

package uk.gov.gchq.gaffer.accumulostore;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayInputStream;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.store.StoreProperties;
import uk.gov.gchq.gaffer.store.schema.Schema;

class AccumuloPropertiesDiffblueTest {
  /**
   * Test {@link AccumuloProperties#AccumuloProperties()}.
   *
   * <p>Method under test: {@link AccumuloProperties#AccumuloProperties()}
   */
  @Test
  @DisplayName("Test new AccumuloProperties()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AccumuloProperties.<init>()"})
  void testNewAccumuloProperties() {
    // Arrange and Act
    AccumuloProperties actualAccumuloProperties = new AccumuloProperties();

    // Assert
    assertEquals("", actualAccumuloProperties.getAdminAuth());
    assertEquals(
        "uk.gov.gchq.gaffer.accumulostore.AccumuloProperties",
        actualAccumuloProperties.getStorePropertiesClassName());
    assertEquals(
        "uk.gov.gchq.gaffer.accumulostore.AccumuloStore", actualAccumuloProperties.getStoreClass());
    assertEquals(
        "uk.gov.gchq.gaffer.accumulostore.key.core.impl.byteEntity.ByteEntityKeyPackage",
        actualAccumuloProperties.getKeyPackageClass());
    assertEquals(
        "uk.gov.gchq.gaffer.sketches.serialisation.json.SketchesJsonModules,",
        actualAccumuloProperties.getJsonSerialiserModules());
    assertEquals(
        "uk.gov.gchq.gaffer.store.schema.Schema", actualAccumuloProperties.getSchemaClassName());
    assertNull(actualAccumuloProperties.getStrictJson());
    assertNull(actualAccumuloProperties.getInstance());
    assertNull(actualAccumuloProperties.getKeytabPath());
    assertNull(actualAccumuloProperties.getNamespace());
    assertNull(actualAccumuloProperties.getPassword());
    assertNull(actualAccumuloProperties.getPrincipal());
    assertNull(actualAccumuloProperties.getTableFileReplicationFactor());
    assertNull(actualAccumuloProperties.getUser());
    assertNull(actualAccumuloProperties.getZookeepers());
    assertNull(actualAccumuloProperties.getCacheServiceClass());
    assertNull(actualAccumuloProperties.getDefaultCacheServiceClass());
    assertNull(actualAccumuloProperties.getJobTrackerCacheServiceClass());
    assertNull(actualAccumuloProperties.getJsonSerialiserClass());
    assertNull(actualAccumuloProperties.getNamedOperationCacheServiceClass());
    assertNull(actualAccumuloProperties.getNamedViewCacheServiceClass());
    assertNull(actualAccumuloProperties.getOperationDeclarationPaths());
    assertNull(actualAccumuloProperties.getReflectionPackages());
    assertEquals(10, actualAccumuloProperties.getNumThreadsForBatchWriter());
    assertEquals(10, actualAccumuloProperties.getThreadsForBatchScanner());
    assertEquals(
        100000000L, actualAccumuloProperties.getMaxBufferSizeForBatchWriterInBytes().longValue());
    assertEquals(
        1000L, actualAccumuloProperties.getMaxTimeOutForBatchWriterInMilliseconds().longValue());
    Properties properties = actualAccumuloProperties.getProperties();
    assertEquals(2, properties.size());
    assertEquals(2.0E-4d, actualAccumuloProperties.getFalsePositiveRate());
    assertEquals(50, actualAccumuloProperties.getJobExecutorThreadCount().intValue());
    assertEquals(50000, actualAccumuloProperties.getMaxEntriesForBatchScanner());
    assertEquals(8388608, actualAccumuloProperties.getMaxBloomFilterToPassToAnIterator());
    assertEquals(838860800, actualAccumuloProperties.getClientSideBloomFilterSize());
    assertFalse(actualAccumuloProperties.getEnableKerberos());
    assertFalse(actualAccumuloProperties.getJobTrackerEnabled());
    assertFalse(actualAccumuloProperties.getRescheduleJobsOnStart());
    assertTrue(properties.containsKey("gaffer.store.class"));
    assertTrue(properties.containsKey("gaffer.store.properties.class"));
    assertTrue(actualAccumuloProperties.getEnableValidatorIterator());
    assertTrue(actualAccumuloProperties.getNamedOperationEnabled());
    assertTrue(actualAccumuloProperties.getNamedViewEnabled());
    Class<AccumuloProperties> expectedStorePropertiesClass = AccumuloProperties.class;
    assertEquals(expectedStorePropertiesClass, actualAccumuloProperties.getStorePropertiesClass());
    Class<Schema> expectedSchemaClass = Schema.class;
    assertEquals(expectedSchemaClass, actualAccumuloProperties.getSchemaClass());
  }

  /**
   * Test {@link AccumuloProperties#AccumuloProperties(Path)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return AdminAuth is empty string.
   * </ul>
   *
   * <p>Method under test: {@link AccumuloProperties#AccumuloProperties(Path)}
   */
  @Test
  @DisplayName(
      "Test new AccumuloProperties(Path); when 'null'; then return AdminAuth is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AccumuloProperties.<init>(Path)"})
  void testNewAccumuloProperties_whenNull_thenReturnAdminAuthIsEmptyString() {
    // Arrange and Act
    AccumuloProperties actualAccumuloProperties = new AccumuloProperties(null);

    // Assert
    assertEquals("", actualAccumuloProperties.getAdminAuth());
    assertEquals(
        "uk.gov.gchq.gaffer.accumulostore.AccumuloProperties",
        actualAccumuloProperties.getStorePropertiesClassName());
    assertEquals(
        "uk.gov.gchq.gaffer.accumulostore.AccumuloStore", actualAccumuloProperties.getStoreClass());
    assertEquals(
        "uk.gov.gchq.gaffer.accumulostore.key.core.impl.byteEntity.ByteEntityKeyPackage",
        actualAccumuloProperties.getKeyPackageClass());
    assertEquals(
        "uk.gov.gchq.gaffer.sketches.serialisation.json.SketchesJsonModules,",
        actualAccumuloProperties.getJsonSerialiserModules());
    assertEquals(
        "uk.gov.gchq.gaffer.store.schema.Schema", actualAccumuloProperties.getSchemaClassName());
    assertNull(actualAccumuloProperties.getStrictJson());
    assertNull(actualAccumuloProperties.getInstance());
    assertNull(actualAccumuloProperties.getKeytabPath());
    assertNull(actualAccumuloProperties.getNamespace());
    assertNull(actualAccumuloProperties.getPassword());
    assertNull(actualAccumuloProperties.getPrincipal());
    assertNull(actualAccumuloProperties.getTableFileReplicationFactor());
    assertNull(actualAccumuloProperties.getUser());
    assertNull(actualAccumuloProperties.getZookeepers());
    assertNull(actualAccumuloProperties.getCacheServiceClass());
    assertNull(actualAccumuloProperties.getDefaultCacheServiceClass());
    assertNull(actualAccumuloProperties.getJobTrackerCacheServiceClass());
    assertNull(actualAccumuloProperties.getJsonSerialiserClass());
    assertNull(actualAccumuloProperties.getNamedOperationCacheServiceClass());
    assertNull(actualAccumuloProperties.getNamedViewCacheServiceClass());
    assertNull(actualAccumuloProperties.getOperationDeclarationPaths());
    assertNull(actualAccumuloProperties.getReflectionPackages());
    assertEquals(10, actualAccumuloProperties.getNumThreadsForBatchWriter());
    assertEquals(10, actualAccumuloProperties.getThreadsForBatchScanner());
    assertEquals(
        100000000L, actualAccumuloProperties.getMaxBufferSizeForBatchWriterInBytes().longValue());
    assertEquals(
        1000L, actualAccumuloProperties.getMaxTimeOutForBatchWriterInMilliseconds().longValue());
    Properties properties = actualAccumuloProperties.getProperties();
    assertEquals(2, properties.size());
    assertEquals(2.0E-4d, actualAccumuloProperties.getFalsePositiveRate());
    assertEquals(50, actualAccumuloProperties.getJobExecutorThreadCount().intValue());
    assertEquals(50000, actualAccumuloProperties.getMaxEntriesForBatchScanner());
    assertEquals(8388608, actualAccumuloProperties.getMaxBloomFilterToPassToAnIterator());
    assertEquals(838860800, actualAccumuloProperties.getClientSideBloomFilterSize());
    assertFalse(actualAccumuloProperties.getEnableKerberos());
    assertFalse(actualAccumuloProperties.getJobTrackerEnabled());
    assertFalse(actualAccumuloProperties.getRescheduleJobsOnStart());
    assertTrue(properties.containsKey("gaffer.store.class"));
    assertTrue(properties.containsKey("gaffer.store.properties.class"));
    assertTrue(actualAccumuloProperties.getEnableValidatorIterator());
    assertTrue(actualAccumuloProperties.getNamedOperationEnabled());
    assertTrue(actualAccumuloProperties.getNamedViewEnabled());
    Class<AccumuloProperties> expectedStorePropertiesClass = AccumuloProperties.class;
    assertEquals(expectedStorePropertiesClass, actualAccumuloProperties.getStorePropertiesClass());
    Class<Schema> expectedSchemaClass = Schema.class;
    assertEquals(expectedSchemaClass, actualAccumuloProperties.getSchemaClass());
  }

  /**
   * Test {@link AccumuloProperties#AccumuloProperties(Path)}.
   *
   * <ul>
   *   <li>When Property is {@code java.io.tmpdir} is empty string.
   * </ul>
   *
   * <p>Method under test: {@link AccumuloProperties#AccumuloProperties(Path)}
   */
  @Test
  @DisplayName(
      "Test new AccumuloProperties(Path); when Property is 'java.io.tmpdir' is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AccumuloProperties.<init>(Path)"})
  void testNewAccumuloProperties_whenPropertyIsJavaIoTmpdirIsEmptyString() {
    // Arrange
    Path propFileLocation = Paths.get(System.getProperty("java.io.tmpdir"), "");

    // Act and Assert
    assertThrows(RuntimeException.class, () -> new AccumuloProperties(propFileLocation));
  }

  /**
   * Test {@link AccumuloProperties#AccumuloProperties(Path)}.
   *
   * <ul>
   *   <li>When Property is {@code java.io.tmpdir} is {@code test.txt}.
   * </ul>
   *
   * <p>Method under test: {@link AccumuloProperties#AccumuloProperties(Path)}
   */
  @Test
  @DisplayName("Test new AccumuloProperties(Path); when Property is 'java.io.tmpdir' is 'test.txt'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AccumuloProperties.<init>(Path)"})
  void testNewAccumuloProperties_whenPropertyIsJavaIoTmpdirIsTestTxt() {
    // Arrange
    Path propFileLocation = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");

    // Act and Assert
    assertThrows(RuntimeException.class, () -> new AccumuloProperties(propFileLocation));
  }

  /**
   * Test {@link AccumuloProperties#loadStoreProperties(String)} with {@code pathStr}.
   *
   * <ul>
   *   <li>When {@code /}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link AccumuloProperties#loadStoreProperties(String)}
   */
  @Test
  @DisplayName(
      "Test loadStoreProperties(String) with 'pathStr'; when '/'; then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AccumuloProperties AccumuloProperties.loadStoreProperties(String)"})
  void testLoadStorePropertiesWithPathStr_whenSlash_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> AccumuloProperties.loadStoreProperties("/"));
  }

  /**
   * Test {@link AccumuloProperties#loadStoreProperties(Path)} with {@code storePropertiesPath}.
   *
   * <p>Method under test: {@link AccumuloProperties#loadStoreProperties(Path)}
   */
  @Test
  @DisplayName("Test loadStoreProperties(Path) with 'storePropertiesPath'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AccumuloProperties AccumuloProperties.loadStoreProperties(Path)"})
  void testLoadStorePropertiesWithStorePropertiesPath() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            AccumuloProperties.loadStoreProperties(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt")));
  }

  /**
   * Test {@link AccumuloProperties#loadStoreProperties(Path)} with {@code storePropertiesPath}.
   *
   * <p>Method under test: {@link AccumuloProperties#loadStoreProperties(Path)}
   */
  @Test
  @DisplayName("Test loadStoreProperties(Path) with 'storePropertiesPath'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AccumuloProperties AccumuloProperties.loadStoreProperties(Path)"})
  void testLoadStorePropertiesWithStorePropertiesPath2() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            AccumuloProperties.loadStoreProperties(
                Paths.get(System.getProperty("java.io.tmpdir"), "")));
  }

  /**
   * Test {@link AccumuloProperties#loadStoreProperties(Path)} with {@code storePropertiesPath}.
   *
   * <ul>
   *   <li>Then return AdminAuth is empty string.
   * </ul>
   *
   * <p>Method under test: {@link AccumuloProperties#loadStoreProperties(Path)}
   */
  @Test
  @DisplayName(
      "Test loadStoreProperties(Path) with 'storePropertiesPath'; then return AdminAuth is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AccumuloProperties AccumuloProperties.loadStoreProperties(Path)"})
  void testLoadStorePropertiesWithStorePropertiesPath_thenReturnAdminAuthIsEmptyString() {
    // Arrange and Act
    AccumuloProperties actualLoadStorePropertiesResult =
        AccumuloProperties.loadStoreProperties((Path) null);

    // Assert
    assertEquals("", actualLoadStorePropertiesResult.getAdminAuth());
    assertEquals(
        "uk.gov.gchq.gaffer.accumulostore.AccumuloProperties",
        actualLoadStorePropertiesResult.getStorePropertiesClassName());
    assertEquals(
        "uk.gov.gchq.gaffer.accumulostore.key.core.impl.byteEntity.ByteEntityKeyPackage",
        actualLoadStorePropertiesResult.getKeyPackageClass());
    assertEquals(
        "uk.gov.gchq.gaffer.sketches.serialisation.json.SketchesJsonModules,",
        actualLoadStorePropertiesResult.getJsonSerialiserModules());
    assertEquals(
        "uk.gov.gchq.gaffer.store.schema.Schema",
        actualLoadStorePropertiesResult.getSchemaClassName());
    assertNull(actualLoadStorePropertiesResult.getStrictJson());
    assertNull(actualLoadStorePropertiesResult.getInstance());
    assertNull(actualLoadStorePropertiesResult.getKeytabPath());
    assertNull(actualLoadStorePropertiesResult.getNamespace());
    assertNull(actualLoadStorePropertiesResult.getPassword());
    assertNull(actualLoadStorePropertiesResult.getPrincipal());
    assertNull(actualLoadStorePropertiesResult.getTableFileReplicationFactor());
    assertNull(actualLoadStorePropertiesResult.getUser());
    assertNull(actualLoadStorePropertiesResult.getZookeepers());
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
    assertEquals(10, actualLoadStorePropertiesResult.getNumThreadsForBatchWriter());
    assertEquals(10, actualLoadStorePropertiesResult.getThreadsForBatchScanner());
    assertEquals(
        100000000L,
        actualLoadStorePropertiesResult.getMaxBufferSizeForBatchWriterInBytes().longValue());
    assertEquals(
        1000L,
        actualLoadStorePropertiesResult.getMaxTimeOutForBatchWriterInMilliseconds().longValue());
    assertEquals(2.0E-4d, actualLoadStorePropertiesResult.getFalsePositiveRate());
    assertEquals(50, actualLoadStorePropertiesResult.getJobExecutorThreadCount().intValue());
    assertEquals(50000, actualLoadStorePropertiesResult.getMaxEntriesForBatchScanner());
    assertEquals(8388608, actualLoadStorePropertiesResult.getMaxBloomFilterToPassToAnIterator());
    assertEquals(838860800, actualLoadStorePropertiesResult.getClientSideBloomFilterSize());
    assertFalse(actualLoadStorePropertiesResult.getEnableKerberos());
    assertFalse(actualLoadStorePropertiesResult.getJobTrackerEnabled());
    assertFalse(actualLoadStorePropertiesResult.getRescheduleJobsOnStart());
    assertTrue(properties.containsKey("gaffer.store.properties.class"));
    assertTrue(actualLoadStorePropertiesResult.getEnableValidatorIterator());
    assertTrue(actualLoadStorePropertiesResult.getNamedOperationEnabled());
    assertTrue(actualLoadStorePropertiesResult.getNamedViewEnabled());
    Class<AccumuloProperties> expectedStorePropertiesClass = AccumuloProperties.class;
    assertEquals(
        expectedStorePropertiesClass, actualLoadStorePropertiesResult.getStorePropertiesClass());
    Class<Schema> expectedSchemaClass = Schema.class;
    assertEquals(expectedSchemaClass, actualLoadStorePropertiesResult.getSchemaClass());
  }

  /**
   * Test {@link AccumuloProperties#loadStoreProperties(InputStream)} with {@code
   * storePropertiesStream}.
   *
   * <p>Method under test: {@link AccumuloProperties#loadStoreProperties(InputStream)}
   */
  @Test
  @DisplayName("Test loadStoreProperties(InputStream) with 'storePropertiesStream'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AccumuloProperties AccumuloProperties.loadStoreProperties(InputStream)"})
  void testLoadStorePropertiesWithStorePropertiesStream() {
    // Arrange and Act
    AccumuloProperties actualLoadStorePropertiesResult =
        AccumuloProperties.loadStoreProperties((InputStream) null);

    // Assert
    assertEquals("", actualLoadStorePropertiesResult.getAdminAuth());
    assertEquals(
        "uk.gov.gchq.gaffer.accumulostore.AccumuloProperties",
        actualLoadStorePropertiesResult.getStorePropertiesClassName());
    assertEquals(
        "uk.gov.gchq.gaffer.accumulostore.key.core.impl.byteEntity.ByteEntityKeyPackage",
        actualLoadStorePropertiesResult.getKeyPackageClass());
    assertEquals(
        "uk.gov.gchq.gaffer.sketches.serialisation.json.SketchesJsonModules,",
        actualLoadStorePropertiesResult.getJsonSerialiserModules());
    assertEquals(
        "uk.gov.gchq.gaffer.store.schema.Schema",
        actualLoadStorePropertiesResult.getSchemaClassName());
    assertNull(actualLoadStorePropertiesResult.getStrictJson());
    assertNull(actualLoadStorePropertiesResult.getInstance());
    assertNull(actualLoadStorePropertiesResult.getKeytabPath());
    assertNull(actualLoadStorePropertiesResult.getNamespace());
    assertNull(actualLoadStorePropertiesResult.getPassword());
    assertNull(actualLoadStorePropertiesResult.getPrincipal());
    assertNull(actualLoadStorePropertiesResult.getTableFileReplicationFactor());
    assertNull(actualLoadStorePropertiesResult.getUser());
    assertNull(actualLoadStorePropertiesResult.getZookeepers());
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
    assertEquals(10, actualLoadStorePropertiesResult.getNumThreadsForBatchWriter());
    assertEquals(10, actualLoadStorePropertiesResult.getThreadsForBatchScanner());
    assertEquals(
        100000000L,
        actualLoadStorePropertiesResult.getMaxBufferSizeForBatchWriterInBytes().longValue());
    assertEquals(
        1000L,
        actualLoadStorePropertiesResult.getMaxTimeOutForBatchWriterInMilliseconds().longValue());
    assertEquals(2.0E-4d, actualLoadStorePropertiesResult.getFalsePositiveRate());
    assertEquals(50, actualLoadStorePropertiesResult.getJobExecutorThreadCount().intValue());
    assertEquals(50000, actualLoadStorePropertiesResult.getMaxEntriesForBatchScanner());
    assertEquals(8388608, actualLoadStorePropertiesResult.getMaxBloomFilterToPassToAnIterator());
    assertEquals(838860800, actualLoadStorePropertiesResult.getClientSideBloomFilterSize());
    assertFalse(actualLoadStorePropertiesResult.getEnableKerberos());
    assertFalse(actualLoadStorePropertiesResult.getJobTrackerEnabled());
    assertFalse(actualLoadStorePropertiesResult.getRescheduleJobsOnStart());
    assertTrue(properties.containsKey("gaffer.store.properties.class"));
    assertTrue(actualLoadStorePropertiesResult.getEnableValidatorIterator());
    assertTrue(actualLoadStorePropertiesResult.getNamedOperationEnabled());
    assertTrue(actualLoadStorePropertiesResult.getNamedViewEnabled());
    Class<AccumuloProperties> expectedStorePropertiesClass = AccumuloProperties.class;
    assertEquals(
        expectedStorePropertiesClass, actualLoadStorePropertiesResult.getStorePropertiesClass());
    Class<Schema> expectedSchemaClass = Schema.class;
    assertEquals(expectedSchemaClass, actualLoadStorePropertiesResult.getSchemaClass());
  }

  /**
   * Test {@link AccumuloProperties#loadStoreProperties(InputStream)} with {@code
   * storePropertiesStream}.
   *
   * <ul>
   *   <li>Then return Properties size is two.
   * </ul>
   *
   * <p>Method under test: {@link AccumuloProperties#loadStoreProperties(InputStream)}
   */
  @Test
  @DisplayName(
      "Test loadStoreProperties(InputStream) with 'storePropertiesStream'; then return Properties size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AccumuloProperties AccumuloProperties.loadStoreProperties(InputStream)"})
  void testLoadStorePropertiesWithStorePropertiesStream_thenReturnPropertiesSizeIsTwo()
      throws IOException {
    // Arrange
    ByteArrayInputStream storePropertiesStream =
        new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    Properties properties =
        AccumuloProperties.loadStoreProperties(storePropertiesStream).getProperties();
    assertEquals(2, properties.size());
    assertEquals("", properties.get("AXAXAXAX"));
    int actualReadResult = storePropertiesStream.read(new byte[] {});
    assertEquals(-1, actualReadResult);
    assertTrue(properties.containsKey("gaffer.store.properties.class"));
  }

  /**
   * Test {@link AccumuloProperties#loadStoreProperties(InputStream)} with {@code
   * storePropertiesStream}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link AccumuloProperties#loadStoreProperties(InputStream)}
   */
  @Test
  @DisplayName(
      "Test loadStoreProperties(InputStream) with 'storePropertiesStream'; then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AccumuloProperties AccumuloProperties.loadStoreProperties(InputStream)"})
  void testLoadStorePropertiesWithStorePropertiesStream_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> AccumuloProperties.loadStoreProperties(new FileInputStream(new FileDescriptor())));
  }

  /**
   * Test {@link AccumuloProperties#clone()}.
   *
   * <ul>
   *   <li>Given {@link AccumuloProperties#AccumuloProperties()}.
   *   <li>Then return {@link AccumuloProperties#AccumuloProperties()}.
   * </ul>
   *
   * <p>Method under test: {@link AccumuloProperties#clone()}
   */
  @Test
  @DisplayName("Test clone(); given AccumuloProperties(); then return AccumuloProperties()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AccumuloProperties AccumuloProperties.clone()"})
  void testClone_givenAccumuloProperties_thenReturnAccumuloProperties() {
    // Arrange
    AccumuloProperties accumuloProperties = new AccumuloProperties();

    // Act
    AccumuloProperties actualCloneResult = accumuloProperties.clone();

    // Assert
    assertEquals(accumuloProperties, actualCloneResult);
  }

  /**
   * Test {@link AccumuloProperties#clone()}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link AccumuloProperties#clone()}
   */
  @Test
  @DisplayName("Test clone(); then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AccumuloProperties AccumuloProperties.clone()"})
  void testClone_thenThrowRuntimeException() {
    // Arrange
    AccumuloProperties accumuloProperties = new AccumuloProperties();
    accumuloProperties.set(StoreProperties.STORE_PROPERTIES_CLASS, "42");

    // Act and Assert
    assertThrows(RuntimeException.class, () -> accumuloProperties.clone());
  }

  /**
   * Test {@link AccumuloProperties#setNumThreadsForBatchWriter(String)}.
   *
   * <p>Method under test: {@link AccumuloProperties#setNumThreadsForBatchWriter(String)}
   */
  @Test
  @DisplayName("Test setNumThreadsForBatchWriter(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AccumuloProperties.setNumThreadsForBatchWriter(String)"})
  void testSetNumThreadsForBatchWriter() {
    // Arrange
    AccumuloProperties accumuloProperties = new AccumuloProperties();

    // Act
    accumuloProperties.setNumThreadsForBatchWriter("Num Threads For Batch Writer");

    // Assert
    Properties properties = accumuloProperties.getProperties();
    assertEquals(3, properties.size());
    assertEquals(
        "Num Threads For Batch Writer",
        properties.get(AccumuloProperties.NUM_THREADS_FOR_BATCH_WRITER));
    assertTrue(properties.containsKey("gaffer.store.class"));
    assertTrue(properties.containsKey("gaffer.store.properties.class"));
  }

  /**
   * Test {@link AccumuloProperties#setMaxTimeOutForBatchWriterInMilliseconds(String)}.
   *
   * <p>Method under test: {@link
   * AccumuloProperties#setMaxTimeOutForBatchWriterInMilliseconds(String)}
   */
  @Test
  @DisplayName("Test setMaxTimeOutForBatchWriterInMilliseconds(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AccumuloProperties.setMaxTimeOutForBatchWriterInMilliseconds(String)"})
  void testSetMaxTimeOutForBatchWriterInMilliseconds() {
    // Arrange
    AccumuloProperties accumuloProperties = new AccumuloProperties();

    // Act
    accumuloProperties.setMaxTimeOutForBatchWriterInMilliseconds(
        "Max Time Out For Batch Writer In Milliseconds");

    // Assert
    Properties properties = accumuloProperties.getProperties();
    assertEquals(3, properties.size());
    assertEquals(
        "Max Time Out For Batch Writer In Milliseconds",
        properties.get(AccumuloProperties.MAX_TIME_OUT_FOR_BATCH_WRITER));
    assertTrue(properties.containsKey("gaffer.store.class"));
    assertTrue(properties.containsKey("gaffer.store.properties.class"));
  }

  /**
   * Test {@link AccumuloProperties#setMaxBufferSizeForBatchWriterInBytes(String)}.
   *
   * <p>Method under test: {@link AccumuloProperties#setMaxBufferSizeForBatchWriterInBytes(String)}
   */
  @Test
  @DisplayName("Test setMaxBufferSizeForBatchWriterInBytes(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AccumuloProperties.setMaxBufferSizeForBatchWriterInBytes(String)"})
  void testSetMaxBufferSizeForBatchWriterInBytes() {
    // Arrange
    AccumuloProperties accumuloProperties = new AccumuloProperties();

    // Act
    accumuloProperties.setMaxBufferSizeForBatchWriterInBytes(
        "Max Buffer Size For Batch Writer In Bytes");

    // Assert
    Properties properties = accumuloProperties.getProperties();
    assertEquals(3, properties.size());
    assertEquals(
        "Max Buffer Size For Batch Writer In Bytes",
        properties.get(AccumuloProperties.MAX_BUFFER_SIZE_FOR_BATCH_WRITER));
    assertTrue(properties.containsKey("gaffer.store.class"));
    assertTrue(properties.containsKey("gaffer.store.properties.class"));
  }

  /**
   * Test {@link AccumuloProperties#getNumThreadsForBatchWriter()}.
   *
   * <ul>
   *   <li>Given {@link AccumuloProperties#AccumuloProperties()}.
   *   <li>Then return ten.
   * </ul>
   *
   * <p>Method under test: {@link AccumuloProperties#getNumThreadsForBatchWriter()}
   */
  @Test
  @DisplayName("Test getNumThreadsForBatchWriter(); given AccumuloProperties(); then return ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int AccumuloProperties.getNumThreadsForBatchWriter()"})
  void testGetNumThreadsForBatchWriter_givenAccumuloProperties_thenReturnTen() {
    // Arrange, Act and Assert
    assertEquals(10, new AccumuloProperties().getNumThreadsForBatchWriter());
  }

  /**
   * Test {@link AccumuloProperties#getMaxTimeOutForBatchWriterInMilliseconds()}.
   *
   * <ul>
   *   <li>Then return longValue is one thousand.
   * </ul>
   *
   * <p>Method under test: {@link AccumuloProperties#getMaxTimeOutForBatchWriterInMilliseconds()}
   */
  @Test
  @DisplayName(
      "Test getMaxTimeOutForBatchWriterInMilliseconds(); then return longValue is one thousand")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Long AccumuloProperties.getMaxTimeOutForBatchWriterInMilliseconds()"
  })
  void testGetMaxTimeOutForBatchWriterInMilliseconds_thenReturnLongValueIsOneThousand() {
    // Arrange, Act and Assert
    assertEquals(
        1000L, new AccumuloProperties().getMaxTimeOutForBatchWriterInMilliseconds().longValue());
  }

  /**
   * Test {@link AccumuloProperties#getMaxBufferSizeForBatchWriterInBytes()}.
   *
   * <ul>
   *   <li>Then return longValue is {@code 100000000}.
   * </ul>
   *
   * <p>Method under test: {@link AccumuloProperties#getMaxBufferSizeForBatchWriterInBytes()}
   */
  @Test
  @DisplayName("Test getMaxBufferSizeForBatchWriterInBytes(); then return longValue is '100000000'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Long AccumuloProperties.getMaxBufferSizeForBatchWriterInBytes()"})
  void testGetMaxBufferSizeForBatchWriterInBytes_thenReturnLongValueIs100000000() {
    // Arrange, Act and Assert
    assertEquals(
        100000000L, new AccumuloProperties().getMaxBufferSizeForBatchWriterInBytes().longValue());
  }

  /**
   * Test {@link AccumuloProperties#getZookeepers()}.
   *
   * <p>Method under test: {@link AccumuloProperties#getZookeepers()}
   */
  @Test
  @DisplayName("Test getZookeepers()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String AccumuloProperties.getZookeepers()"})
  void testGetZookeepers() {
    // Arrange, Act and Assert
    assertNull(new AccumuloProperties().getZookeepers());
  }

  /**
   * Test {@link AccumuloProperties#setZookeepers(String)}.
   *
   * <p>Method under test: {@link AccumuloProperties#setZookeepers(String)}
   */
  @Test
  @DisplayName("Test setZookeepers(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AccumuloProperties.setZookeepers(String)"})
  void testSetZookeepers() {
    // Arrange
    AccumuloProperties accumuloProperties = new AccumuloProperties();

    // Act
    accumuloProperties.setZookeepers("Zookeepers");

    // Assert
    assertEquals("Zookeepers", accumuloProperties.getZookeepers());
    Properties properties = accumuloProperties.getProperties();
    assertEquals(3, properties.size());
    assertEquals("Zookeepers", properties.get(AccumuloProperties.ZOOKEEPERS));
    assertTrue(properties.containsKey("gaffer.store.class"));
    assertTrue(properties.containsKey("gaffer.store.properties.class"));
  }

  /**
   * Test {@link AccumuloProperties#getInstance()}.
   *
   * <p>Method under test: {@link AccumuloProperties#getInstance()}
   */
  @Test
  @DisplayName("Test getInstance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String AccumuloProperties.getInstance()"})
  void testGetInstance() {
    // Arrange, Act and Assert
    assertNull(new AccumuloProperties().getInstance());
  }

  /**
   * Test {@link AccumuloProperties#setInstance(String)}.
   *
   * <p>Method under test: {@link AccumuloProperties#setInstance(String)}
   */
  @Test
  @DisplayName("Test setInstance(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AccumuloProperties.setInstance(String)"})
  void testSetInstance() {
    // Arrange
    AccumuloProperties accumuloProperties = new AccumuloProperties();

    // Act
    accumuloProperties.setInstance("Instance");

    // Assert
    assertEquals("Instance", accumuloProperties.getInstance());
    Properties properties = accumuloProperties.getProperties();
    assertEquals(3, properties.size());
    assertEquals("Instance", properties.get(AccumuloProperties.INSTANCE_NAME));
    assertTrue(properties.containsKey("gaffer.store.class"));
    assertTrue(properties.containsKey("gaffer.store.properties.class"));
  }

  /**
   * Test {@link AccumuloProperties#getUser()}.
   *
   * <p>Method under test: {@link AccumuloProperties#getUser()}
   */
  @Test
  @DisplayName("Test getUser()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String AccumuloProperties.getUser()"})
  void testGetUser() {
    // Arrange, Act and Assert
    assertNull(new AccumuloProperties().getUser());
  }

  /**
   * Test {@link AccumuloProperties#setUser(String)}.
   *
   * <p>Method under test: {@link AccumuloProperties#setUser(String)}
   */
  @Test
  @DisplayName("Test setUser(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AccumuloProperties.setUser(String)"})
  void testSetUser() {
    // Arrange
    AccumuloProperties accumuloProperties = new AccumuloProperties();

    // Act
    accumuloProperties.setUser("User");

    // Assert
    assertEquals("User", accumuloProperties.getUser());
    Properties properties = accumuloProperties.getProperties();
    assertEquals(3, properties.size());
    assertEquals("User", properties.get(AccumuloProperties.USER));
    assertTrue(properties.containsKey("gaffer.store.class"));
    assertTrue(properties.containsKey("gaffer.store.properties.class"));
  }

  /**
   * Test {@link AccumuloProperties#getPassword()}.
   *
   * <p>Method under test: {@link AccumuloProperties#getPassword()}
   */
  @Test
  @DisplayName("Test getPassword()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String AccumuloProperties.getPassword()"})
  void testGetPassword() {
    // Arrange, Act and Assert
    assertNull(new AccumuloProperties().getPassword());
  }

  /**
   * Test {@link AccumuloProperties#setPassword(String)}.
   *
   * <p>Method under test: {@link AccumuloProperties#setPassword(String)}
   */
  @Test
  @DisplayName("Test setPassword(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AccumuloProperties.setPassword(String)"})
  void testSetPassword() {
    // Arrange
    AccumuloProperties accumuloProperties = new AccumuloProperties();

    // Act
    accumuloProperties.setPassword("iloveyou");

    // Assert
    assertEquals("iloveyou", accumuloProperties.getPassword());
    Properties properties = accumuloProperties.getProperties();
    assertEquals(3, properties.size());
    assertEquals("iloveyou", properties.get(AccumuloProperties.PASSWORD));
    assertTrue(properties.containsKey("gaffer.store.class"));
    assertTrue(properties.containsKey("gaffer.store.properties.class"));
  }

  /**
   * Test {@link AccumuloProperties#getEnableKerberos()}.
   *
   * <p>Method under test: {@link AccumuloProperties#getEnableKerberos()}
   */
  @Test
  @DisplayName("Test getEnableKerberos()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AccumuloProperties.getEnableKerberos()"})
  void testGetEnableKerberos() {
    // Arrange, Act and Assert
    assertFalse(new AccumuloProperties().getEnableKerberos());
  }

  /**
   * Test {@link AccumuloProperties#setEnableKerberos(boolean)}.
   *
   * <p>Method under test: {@link AccumuloProperties#setEnableKerberos(boolean)}
   */
  @Test
  @DisplayName("Test setEnableKerberos(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AccumuloProperties.setEnableKerberos(boolean)"})
  void testSetEnableKerberos() {
    // Arrange
    AccumuloProperties accumuloProperties = new AccumuloProperties();

    // Act
    accumuloProperties.setEnableKerberos(true);

    // Assert
    Properties properties = accumuloProperties.getProperties();
    assertEquals(3, properties.size());
    assertTrue(properties.containsKey("gaffer.store.class"));
    assertTrue(properties.containsKey("gaffer.store.properties.class"));
    assertTrue(accumuloProperties.getEnableKerberos());
    assertEquals(Boolean.TRUE.toString(), properties.get(AccumuloProperties.ENABLE_KERBEROS));
  }

  /**
   * Test {@link AccumuloProperties#getPrincipal()}.
   *
   * <p>Method under test: {@link AccumuloProperties#getPrincipal()}
   */
  @Test
  @DisplayName("Test getPrincipal()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String AccumuloProperties.getPrincipal()"})
  void testGetPrincipal() {
    // Arrange, Act and Assert
    assertNull(new AccumuloProperties().getPrincipal());
  }

  /**
   * Test {@link AccumuloProperties#setPrincipal(String)}.
   *
   * <p>Method under test: {@link AccumuloProperties#setPrincipal(String)}
   */
  @Test
  @DisplayName("Test setPrincipal(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AccumuloProperties.setPrincipal(String)"})
  void testSetPrincipal() {
    // Arrange
    AccumuloProperties accumuloProperties = new AccumuloProperties();

    // Act
    accumuloProperties.setPrincipal("Principal");

    // Assert
    assertEquals("Principal", accumuloProperties.getPrincipal());
    Properties properties = accumuloProperties.getProperties();
    assertEquals(3, properties.size());
    assertEquals("Principal", properties.get(AccumuloProperties.PRINCIPAL));
    assertTrue(properties.containsKey("gaffer.store.class"));
    assertTrue(properties.containsKey("gaffer.store.properties.class"));
  }

  /**
   * Test {@link AccumuloProperties#getKeytabPath()}.
   *
   * <p>Method under test: {@link AccumuloProperties#getKeytabPath()}
   */
  @Test
  @DisplayName("Test getKeytabPath()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String AccumuloProperties.getKeytabPath()"})
  void testGetKeytabPath() {
    // Arrange, Act and Assert
    assertNull(new AccumuloProperties().getKeytabPath());
  }

  /**
   * Test {@link AccumuloProperties#setKeytabPath(String)}.
   *
   * <p>Method under test: {@link AccumuloProperties#setKeytabPath(String)}
   */
  @Test
  @DisplayName("Test setKeytabPath(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AccumuloProperties.setKeytabPath(String)"})
  void testSetKeytabPath() {
    // Arrange
    AccumuloProperties accumuloProperties = new AccumuloProperties();

    // Act
    accumuloProperties.setKeytabPath("Keytab Path");

    // Assert
    assertEquals("Keytab Path", accumuloProperties.getKeytabPath());
    Properties properties = accumuloProperties.getProperties();
    assertEquals(3, properties.size());
    assertEquals("Keytab Path", properties.get(AccumuloProperties.KEYTAB_PATH));
    assertTrue(properties.containsKey("gaffer.store.class"));
    assertTrue(properties.containsKey("gaffer.store.properties.class"));
  }

  /**
   * Test {@link AccumuloProperties#getNamespace()}.
   *
   * <p>Method under test: {@link AccumuloProperties#getNamespace()}
   */
  @Test
  @DisplayName("Test getNamespace()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String AccumuloProperties.getNamespace()"})
  void testGetNamespace() {
    // Arrange, Act and Assert
    assertNull(new AccumuloProperties().getNamespace());
  }

  /**
   * Test {@link AccumuloProperties#setNamespace(String)}.
   *
   * <p>Method under test: {@link AccumuloProperties#setNamespace(String)}
   */
  @Test
  @DisplayName("Test setNamespace(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AccumuloProperties.setNamespace(String)"})
  void testSetNamespace() {
    // Arrange
    AccumuloProperties accumuloProperties = new AccumuloProperties();

    // Act
    accumuloProperties.setNamespace("Namespace");

    // Assert
    assertEquals("Namespace", accumuloProperties.getNamespace());
    Properties properties = accumuloProperties.getProperties();
    assertEquals(3, properties.size());
    assertEquals("Namespace", properties.get(AccumuloProperties.NAMESPACE));
    assertTrue(properties.containsKey("gaffer.store.class"));
    assertTrue(properties.containsKey("gaffer.store.properties.class"));
  }

  /**
   * Test {@link AccumuloProperties#getThreadsForBatchScanner()}.
   *
   * <ul>
   *   <li>Given {@link AccumuloProperties#AccumuloProperties()}.
   *   <li>Then return ten.
   * </ul>
   *
   * <p>Method under test: {@link AccumuloProperties#getThreadsForBatchScanner()}
   */
  @Test
  @DisplayName("Test getThreadsForBatchScanner(); given AccumuloProperties(); then return ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int AccumuloProperties.getThreadsForBatchScanner()"})
  void testGetThreadsForBatchScanner_givenAccumuloProperties_thenReturnTen() {
    // Arrange, Act and Assert
    assertEquals(10, new AccumuloProperties().getThreadsForBatchScanner());
  }

  /**
   * Test {@link AccumuloProperties#setThreadsForBatchScanner(String)}.
   *
   * <p>Method under test: {@link AccumuloProperties#setThreadsForBatchScanner(String)}
   */
  @Test
  @DisplayName("Test setThreadsForBatchScanner(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AccumuloProperties.setThreadsForBatchScanner(String)"})
  void testSetThreadsForBatchScanner() {
    // Arrange
    AccumuloProperties accumuloProperties = new AccumuloProperties();

    // Act
    accumuloProperties.setThreadsForBatchScanner("Threads For Batch Scanner");

    // Assert
    Properties properties = accumuloProperties.getProperties();
    assertEquals(3, properties.size());
    assertEquals(
        "Threads For Batch Scanner", properties.get(AccumuloProperties.THREADS_FOR_BATCH_SCANNER));
    assertTrue(properties.containsKey("gaffer.store.class"));
    assertTrue(properties.containsKey("gaffer.store.properties.class"));
  }

  /**
   * Test {@link AccumuloProperties#getMaxEntriesForBatchScanner()}.
   *
   * <ul>
   *   <li>Given {@link AccumuloProperties#AccumuloProperties()}.
   *   <li>Then return {@code 50000}.
   * </ul>
   *
   * <p>Method under test: {@link AccumuloProperties#getMaxEntriesForBatchScanner()}
   */
  @Test
  @DisplayName(
      "Test getMaxEntriesForBatchScanner(); given AccumuloProperties(); then return '50000'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int AccumuloProperties.getMaxEntriesForBatchScanner()"})
  void testGetMaxEntriesForBatchScanner_givenAccumuloProperties_thenReturn50000() {
    // Arrange, Act and Assert
    assertEquals(50000, new AccumuloProperties().getMaxEntriesForBatchScanner());
  }

  /**
   * Test {@link AccumuloProperties#setMaxEntriesForBatchScanner(String)}.
   *
   * <p>Method under test: {@link AccumuloProperties#setMaxEntriesForBatchScanner(String)}
   */
  @Test
  @DisplayName("Test setMaxEntriesForBatchScanner(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AccumuloProperties.setMaxEntriesForBatchScanner(String)"})
  void testSetMaxEntriesForBatchScanner() {
    // Arrange
    AccumuloProperties accumuloProperties = new AccumuloProperties();

    // Act
    accumuloProperties.setMaxEntriesForBatchScanner("Max Entries For Batch Scanner");

    // Assert
    Properties properties = accumuloProperties.getProperties();
    assertEquals(3, properties.size());
    assertEquals(
        "Max Entries For Batch Scanner",
        properties.get(AccumuloProperties.MAX_ENTRIES_FOR_BATCH_SCANNER));
    assertTrue(properties.containsKey("gaffer.store.class"));
    assertTrue(properties.containsKey("gaffer.store.properties.class"));
  }

  /**
   * Test {@link AccumuloProperties#getClientSideBloomFilterSize()}.
   *
   * <ul>
   *   <li>Given {@link AccumuloProperties#AccumuloProperties()}.
   *   <li>Then return {@code 838860800}.
   * </ul>
   *
   * <p>Method under test: {@link AccumuloProperties#getClientSideBloomFilterSize()}
   */
  @Test
  @DisplayName(
      "Test getClientSideBloomFilterSize(); given AccumuloProperties(); then return '838860800'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int AccumuloProperties.getClientSideBloomFilterSize()"})
  void testGetClientSideBloomFilterSize_givenAccumuloProperties_thenReturn838860800() {
    // Arrange, Act and Assert
    assertEquals(838860800, new AccumuloProperties().getClientSideBloomFilterSize());
  }

  /**
   * Test {@link AccumuloProperties#setClientSideBloomFilterSize(String)}.
   *
   * <p>Method under test: {@link AccumuloProperties#setClientSideBloomFilterSize(String)}
   */
  @Test
  @DisplayName("Test setClientSideBloomFilterSize(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AccumuloProperties.setClientSideBloomFilterSize(String)"})
  void testSetClientSideBloomFilterSize() {
    // Arrange
    AccumuloProperties accumuloProperties = new AccumuloProperties();

    // Act
    accumuloProperties.setClientSideBloomFilterSize("Client Side Bloom Filter Size");

    // Assert
    Properties properties = accumuloProperties.getProperties();
    assertEquals(3, properties.size());
    assertEquals(
        "Client Side Bloom Filter Size",
        properties.get(AccumuloProperties.CLIENT_SIDE_BLOOM_FILTER_SIZE));
    assertTrue(properties.containsKey("gaffer.store.class"));
    assertTrue(properties.containsKey("gaffer.store.properties.class"));
  }

  /**
   * Test {@link AccumuloProperties#getFalsePositiveRate()}.
   *
   * <ul>
   *   <li>Given {@link AccumuloProperties#AccumuloProperties()}.
   *   <li>Then return {@code 2.0E-4}.
   * </ul>
   *
   * <p>Method under test: {@link AccumuloProperties#getFalsePositiveRate()}
   */
  @Test
  @DisplayName("Test getFalsePositiveRate(); given AccumuloProperties(); then return '2.0E-4'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double AccumuloProperties.getFalsePositiveRate()"})
  void testGetFalsePositiveRate_givenAccumuloProperties_thenReturn20e4() {
    // Arrange, Act and Assert
    assertEquals(2.0E-4d, new AccumuloProperties().getFalsePositiveRate());
  }

  /**
   * Test {@link AccumuloProperties#setFalsePositiveRate(String)}.
   *
   * <p>Method under test: {@link AccumuloProperties#setFalsePositiveRate(String)}
   */
  @Test
  @DisplayName("Test setFalsePositiveRate(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AccumuloProperties.setFalsePositiveRate(String)"})
  void testSetFalsePositiveRate() {
    // Arrange
    AccumuloProperties accumuloProperties = new AccumuloProperties();

    // Act
    accumuloProperties.setFalsePositiveRate("False Positive Rate");

    // Assert
    Properties properties = accumuloProperties.getProperties();
    assertEquals(3, properties.size());
    assertEquals("False Positive Rate", properties.get(AccumuloProperties.FALSE_POSITIVE_RATE));
    assertTrue(properties.containsKey("gaffer.store.class"));
    assertTrue(properties.containsKey("gaffer.store.properties.class"));
  }

  /**
   * Test {@link AccumuloProperties#getMaxBloomFilterToPassToAnIterator()}.
   *
   * <ul>
   *   <li>Then return {@code 8388608}.
   * </ul>
   *
   * <p>Method under test: {@link AccumuloProperties#getMaxBloomFilterToPassToAnIterator()}
   */
  @Test
  @DisplayName("Test getMaxBloomFilterToPassToAnIterator(); then return '8388608'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int AccumuloProperties.getMaxBloomFilterToPassToAnIterator()"})
  void testGetMaxBloomFilterToPassToAnIterator_thenReturn8388608() {
    // Arrange, Act and Assert
    assertEquals(8388608, new AccumuloProperties().getMaxBloomFilterToPassToAnIterator());
  }

  /**
   * Test {@link AccumuloProperties#setMaxBloomFilterToPassToAnIterator(String)}.
   *
   * <p>Method under test: {@link AccumuloProperties#setMaxBloomFilterToPassToAnIterator(String)}
   */
  @Test
  @DisplayName("Test setMaxBloomFilterToPassToAnIterator(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AccumuloProperties.setMaxBloomFilterToPassToAnIterator(String)"})
  void testSetMaxBloomFilterToPassToAnIterator() {
    // Arrange
    AccumuloProperties accumuloProperties = new AccumuloProperties();

    // Act
    accumuloProperties.setMaxBloomFilterToPassToAnIterator(
        "Max Bloom Filter To Pass To An Iterator");

    // Assert
    Properties properties = accumuloProperties.getProperties();
    assertEquals(3, properties.size());
    assertEquals(
        "Max Bloom Filter To Pass To An Iterator",
        properties.get(AccumuloProperties.MAX_BLOOM_FILTER_TO_PASS_TO_AN_ITERATOR));
    assertTrue(properties.containsKey("gaffer.store.class"));
    assertTrue(properties.containsKey("gaffer.store.properties.class"));
  }

  /**
   * Test {@link AccumuloProperties#getKeyPackageClass()}.
   *
   * <p>Method under test: {@link AccumuloProperties#getKeyPackageClass()}
   */
  @Test
  @DisplayName("Test getKeyPackageClass()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String AccumuloProperties.getKeyPackageClass()"})
  void testGetKeyPackageClass() {
    // Arrange, Act and Assert
    assertEquals(
        "uk.gov.gchq.gaffer.accumulostore.key.core.impl.byteEntity.ByteEntityKeyPackage",
        new AccumuloProperties().getKeyPackageClass());
  }

  /**
   * Test {@link AccumuloProperties#setKeyPackageClass(String)}.
   *
   * <p>Method under test: {@link AccumuloProperties#setKeyPackageClass(String)}
   */
  @Test
  @DisplayName("Test setKeyPackageClass(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AccumuloProperties.setKeyPackageClass(String)"})
  void testSetKeyPackageClass() {
    // Arrange
    AccumuloProperties accumuloProperties = new AccumuloProperties();

    // Act
    accumuloProperties.setKeyPackageClass("java.text");

    // Assert
    assertEquals("java.text", accumuloProperties.getKeyPackageClass());
    Properties properties = accumuloProperties.getProperties();
    assertEquals(3, properties.size());
    assertEquals("java.text", properties.get(AccumuloProperties.KEY_PACKAGE_CLASS));
    assertTrue(properties.containsKey("gaffer.store.class"));
    assertTrue(properties.containsKey("gaffer.store.properties.class"));
  }

  /**
   * Test {@link AccumuloProperties#getTableFileReplicationFactor()}.
   *
   * <p>Method under test: {@link AccumuloProperties#getTableFileReplicationFactor()}
   */
  @Test
  @DisplayName("Test getTableFileReplicationFactor()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String AccumuloProperties.getTableFileReplicationFactor()"})
  void testGetTableFileReplicationFactor() {
    // Arrange, Act and Assert
    assertNull(new AccumuloProperties().getTableFileReplicationFactor());
  }

  /**
   * Test {@link AccumuloProperties#setTableFileReplicationFactor(String)}.
   *
   * <p>Method under test: {@link AccumuloProperties#setTableFileReplicationFactor(String)}
   */
  @Test
  @DisplayName("Test setTableFileReplicationFactor(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AccumuloProperties.setTableFileReplicationFactor(String)"})
  void testSetTableFileReplicationFactor() {
    // Arrange
    AccumuloProperties accumuloProperties = new AccumuloProperties();

    // Act
    accumuloProperties.setTableFileReplicationFactor("Replication Factor");

    // Assert
    assertEquals("Replication Factor", accumuloProperties.getTableFileReplicationFactor());
    Properties properties = accumuloProperties.getProperties();
    assertEquals(3, properties.size());
    assertEquals("Replication Factor", properties.get(AccumuloProperties.TABLE_REPLICATION_FACTOR));
    assertTrue(properties.containsKey("gaffer.store.class"));
    assertTrue(properties.containsKey("gaffer.store.properties.class"));
  }

  /**
   * Test {@link AccumuloProperties#getEnableValidatorIterator()}.
   *
   * <ul>
   *   <li>Given {@link AccumuloProperties#AccumuloProperties()}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link AccumuloProperties#getEnableValidatorIterator()}
   */
  @Test
  @DisplayName("Test getEnableValidatorIterator(); given AccumuloProperties(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AccumuloProperties.getEnableValidatorIterator()"})
  void testGetEnableValidatorIterator_givenAccumuloProperties_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new AccumuloProperties().getEnableValidatorIterator());
  }

  /**
   * Test {@link AccumuloProperties#getEnableValidatorIterator()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link AccumuloProperties#getEnableValidatorIterator()}
   */
  @Test
  @DisplayName("Test getEnableValidatorIterator(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AccumuloProperties.getEnableValidatorIterator()"})
  void testGetEnableValidatorIterator_thenReturnFalse() {
    // Arrange
    AccumuloProperties accumuloProperties = new AccumuloProperties();
    accumuloProperties.set(AccumuloProperties.ENABLE_VALIDATOR_ITERATOR, "42");

    // Act and Assert
    assertFalse(accumuloProperties.getEnableValidatorIterator());
  }

  /**
   * Test {@link AccumuloProperties#setEnableValidatorIterator(boolean)}.
   *
   * <p>Method under test: {@link AccumuloProperties#setEnableValidatorIterator(boolean)}
   */
  @Test
  @DisplayName("Test setEnableValidatorIterator(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AccumuloProperties.setEnableValidatorIterator(boolean)"})
  void testSetEnableValidatorIterator() {
    // Arrange
    AccumuloProperties accumuloProperties = new AccumuloProperties();

    // Act
    accumuloProperties.setEnableValidatorIterator(true);

    // Assert
    Properties properties = accumuloProperties.getProperties();
    assertEquals(3, properties.size());
    assertTrue(properties.containsKey("gaffer.store.class"));
    assertTrue(properties.containsKey("gaffer.store.properties.class"));
    assertEquals(
        Boolean.TRUE.toString(), properties.get(AccumuloProperties.ENABLE_VALIDATOR_ITERATOR));
  }

  /**
   * Test {@link AccumuloProperties#getJsonSerialiserModules()}.
   *
   * <p>Method under test: {@link AccumuloProperties#getJsonSerialiserModules()}
   */
  @Test
  @DisplayName("Test getJsonSerialiserModules()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String AccumuloProperties.getJsonSerialiserModules()"})
  void testGetJsonSerialiserModules() {
    // Arrange, Act and Assert
    assertEquals(
        "uk.gov.gchq.gaffer.sketches.serialisation.json.SketchesJsonModules,",
        new AccumuloProperties().getJsonSerialiserModules());
  }
}
