package uk.gov.gchq.gaffer.federated.simple;

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
import uk.gov.gchq.gaffer.store.schema.Schema;

class FederatedStorePropertiesDiffblueTest {
  /**
   * Test {@link FederatedStoreProperties#FederatedStoreProperties()}.
   *
   * <p>Method under test: {@link FederatedStoreProperties#FederatedStoreProperties()}
   */
  @Test
  @DisplayName("Test new FederatedStoreProperties()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FederatedStoreProperties.<init>()"})
  void testNewFederatedStoreProperties() {
    // Arrange and Act
    FederatedStoreProperties actualFederatedStoreProperties = new FederatedStoreProperties();

    // Assert
    assertEquals("", actualFederatedStoreProperties.getAdminAuth());
    assertEquals("", actualFederatedStoreProperties.getJsonSerialiserModules());
    assertEquals(
        "uk.gov.gchq.gaffer.federated.simple.FederatedStore",
        actualFederatedStoreProperties.getStoreClass());
    assertEquals(
        "uk.gov.gchq.gaffer.federated.simple.FederatedStoreProperties",
        actualFederatedStoreProperties.getStorePropertiesClassName());
    assertEquals(
        "uk.gov.gchq.gaffer.store.schema.Schema",
        actualFederatedStoreProperties.getSchemaClassName());
    assertNull(actualFederatedStoreProperties.getStrictJson());
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
    Class<FederatedStoreProperties> expectedStorePropertiesClass = FederatedStoreProperties.class;
    assertEquals(
        expectedStorePropertiesClass, actualFederatedStoreProperties.getStorePropertiesClass());
    Class<Schema> expectedSchemaClass = Schema.class;
    assertEquals(expectedSchemaClass, actualFederatedStoreProperties.getSchemaClass());
  }

  /**
   * Test {@link FederatedStoreProperties#FederatedStoreProperties(Path)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return AdminAuth is empty string.
   * </ul>
   *
   * <p>Method under test: {@link FederatedStoreProperties#FederatedStoreProperties(Path)}
   */
  @Test
  @DisplayName(
      "Test new FederatedStoreProperties(Path); when 'null'; then return AdminAuth is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FederatedStoreProperties.<init>(Path)"})
  void testNewFederatedStoreProperties_whenNull_thenReturnAdminAuthIsEmptyString() {
    // Arrange and Act
    FederatedStoreProperties actualFederatedStoreProperties = new FederatedStoreProperties(null);

    // Assert
    assertEquals("", actualFederatedStoreProperties.getAdminAuth());
    assertEquals("", actualFederatedStoreProperties.getJsonSerialiserModules());
    assertEquals(
        "uk.gov.gchq.gaffer.federated.simple.FederatedStore",
        actualFederatedStoreProperties.getStoreClass());
    assertEquals(
        "uk.gov.gchq.gaffer.federated.simple.FederatedStoreProperties",
        actualFederatedStoreProperties.getStorePropertiesClassName());
    assertEquals(
        "uk.gov.gchq.gaffer.store.schema.Schema",
        actualFederatedStoreProperties.getSchemaClassName());
    assertNull(actualFederatedStoreProperties.getStrictJson());
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
    Class<FederatedStoreProperties> expectedStorePropertiesClass = FederatedStoreProperties.class;
    assertEquals(
        expectedStorePropertiesClass, actualFederatedStoreProperties.getStorePropertiesClass());
    Class<Schema> expectedSchemaClass = Schema.class;
    assertEquals(expectedSchemaClass, actualFederatedStoreProperties.getSchemaClass());
  }

  /**
   * Test {@link FederatedStoreProperties#FederatedStoreProperties(Path)}.
   *
   * <ul>
   *   <li>When Property is {@code java.io.tmpdir} is empty string.
   * </ul>
   *
   * <p>Method under test: {@link FederatedStoreProperties#FederatedStoreProperties(Path)}
   */
  @Test
  @DisplayName(
      "Test new FederatedStoreProperties(Path); when Property is 'java.io.tmpdir' is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FederatedStoreProperties.<init>(Path)"})
  void testNewFederatedStoreProperties_whenPropertyIsJavaIoTmpdirIsEmptyString() {
    // Arrange
    Path propFileLocation = Paths.get(System.getProperty("java.io.tmpdir"), "");

    // Act and Assert
    assertThrows(RuntimeException.class, () -> new FederatedStoreProperties(propFileLocation));
  }

  /**
   * Test {@link FederatedStoreProperties#FederatedStoreProperties(Path)}.
   *
   * <ul>
   *   <li>When Property is {@code java.io.tmpdir} is {@code test.txt}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedStoreProperties#FederatedStoreProperties(Path)}
   */
  @Test
  @DisplayName(
      "Test new FederatedStoreProperties(Path); when Property is 'java.io.tmpdir' is 'test.txt'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FederatedStoreProperties.<init>(Path)"})
  void testNewFederatedStoreProperties_whenPropertyIsJavaIoTmpdirIsTestTxt() {
    // Arrange
    Path propFileLocation = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");

    // Act and Assert
    assertThrows(RuntimeException.class, () -> new FederatedStoreProperties(propFileLocation));
  }

  /**
   * Test {@link FederatedStoreProperties#loadStoreProperties(String)} with {@code pathStr}.
   *
   * <ul>
   *   <li>When {@code /}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedStoreProperties#loadStoreProperties(String)}
   */
  @Test
  @DisplayName(
      "Test loadStoreProperties(String) with 'pathStr'; when '/'; then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FederatedStoreProperties FederatedStoreProperties.loadStoreProperties(String)"
  })
  void testLoadStorePropertiesWithPathStr_whenSlash_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> FederatedStoreProperties.loadStoreProperties("/"));
  }

  /**
   * Test {@link FederatedStoreProperties#loadStoreProperties(Path)} with {@code
   * storePropertiesPath}.
   *
   * <p>Method under test: {@link FederatedStoreProperties#loadStoreProperties(Path)}
   */
  @Test
  @DisplayName("Test loadStoreProperties(Path) with 'storePropertiesPath'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FederatedStoreProperties FederatedStoreProperties.loadStoreProperties(Path)"})
  void testLoadStorePropertiesWithStorePropertiesPath() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            FederatedStoreProperties.loadStoreProperties(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt")));
  }

  /**
   * Test {@link FederatedStoreProperties#loadStoreProperties(Path)} with {@code
   * storePropertiesPath}.
   *
   * <p>Method under test: {@link FederatedStoreProperties#loadStoreProperties(Path)}
   */
  @Test
  @DisplayName("Test loadStoreProperties(Path) with 'storePropertiesPath'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FederatedStoreProperties FederatedStoreProperties.loadStoreProperties(Path)"})
  void testLoadStorePropertiesWithStorePropertiesPath2() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            FederatedStoreProperties.loadStoreProperties(
                Paths.get(System.getProperty("java.io.tmpdir"), "")));
  }

  /**
   * Test {@link FederatedStoreProperties#loadStoreProperties(Path)} with {@code
   * storePropertiesPath}.
   *
   * <ul>
   *   <li>Then return AdminAuth is empty string.
   * </ul>
   *
   * <p>Method under test: {@link FederatedStoreProperties#loadStoreProperties(Path)}
   */
  @Test
  @DisplayName(
      "Test loadStoreProperties(Path) with 'storePropertiesPath'; then return AdminAuth is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FederatedStoreProperties FederatedStoreProperties.loadStoreProperties(Path)"})
  void testLoadStorePropertiesWithStorePropertiesPath_thenReturnAdminAuthIsEmptyString() {
    // Arrange and Act
    FederatedStoreProperties actualLoadStorePropertiesResult =
        FederatedStoreProperties.loadStoreProperties((Path) null);

    // Assert
    assertEquals("", actualLoadStorePropertiesResult.getAdminAuth());
    assertEquals("", actualLoadStorePropertiesResult.getJsonSerialiserModules());
    assertEquals(
        "uk.gov.gchq.gaffer.federated.simple.FederatedStoreProperties",
        actualLoadStorePropertiesResult.getStorePropertiesClassName());
    assertEquals(
        "uk.gov.gchq.gaffer.store.schema.Schema",
        actualLoadStorePropertiesResult.getSchemaClassName());
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
    Class<FederatedStoreProperties> expectedStorePropertiesClass = FederatedStoreProperties.class;
    assertEquals(
        expectedStorePropertiesClass, actualLoadStorePropertiesResult.getStorePropertiesClass());
    Class<Schema> expectedSchemaClass = Schema.class;
    assertEquals(expectedSchemaClass, actualLoadStorePropertiesResult.getSchemaClass());
  }

  /**
   * Test {@link FederatedStoreProperties#loadStoreProperties(InputStream)} with {@code
   * storePropertiesStream}.
   *
   * <p>Method under test: {@link FederatedStoreProperties#loadStoreProperties(InputStream)}
   */
  @Test
  @DisplayName("Test loadStoreProperties(InputStream) with 'storePropertiesStream'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FederatedStoreProperties FederatedStoreProperties.loadStoreProperties(InputStream)"
  })
  void testLoadStorePropertiesWithStorePropertiesStream() {
    // Arrange and Act
    FederatedStoreProperties actualLoadStorePropertiesResult =
        FederatedStoreProperties.loadStoreProperties((InputStream) null);

    // Assert
    assertEquals("", actualLoadStorePropertiesResult.getAdminAuth());
    assertEquals("", actualLoadStorePropertiesResult.getJsonSerialiserModules());
    assertEquals(
        "uk.gov.gchq.gaffer.federated.simple.FederatedStoreProperties",
        actualLoadStorePropertiesResult.getStorePropertiesClassName());
    assertEquals(
        "uk.gov.gchq.gaffer.store.schema.Schema",
        actualLoadStorePropertiesResult.getSchemaClassName());
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
    Class<FederatedStoreProperties> expectedStorePropertiesClass = FederatedStoreProperties.class;
    assertEquals(
        expectedStorePropertiesClass, actualLoadStorePropertiesResult.getStorePropertiesClass());
    Class<Schema> expectedSchemaClass = Schema.class;
    assertEquals(expectedSchemaClass, actualLoadStorePropertiesResult.getSchemaClass());
  }

  /**
   * Test {@link FederatedStoreProperties#loadStoreProperties(InputStream)} with {@code
   * storePropertiesStream}.
   *
   * <ul>
   *   <li>Then return Properties size is two.
   * </ul>
   *
   * <p>Method under test: {@link FederatedStoreProperties#loadStoreProperties(InputStream)}
   */
  @Test
  @DisplayName(
      "Test loadStoreProperties(InputStream) with 'storePropertiesStream'; then return Properties size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FederatedStoreProperties FederatedStoreProperties.loadStoreProperties(InputStream)"
  })
  void testLoadStorePropertiesWithStorePropertiesStream_thenReturnPropertiesSizeIsTwo()
      throws IOException {
    // Arrange
    ByteArrayInputStream storePropertiesStream =
        new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    Properties properties =
        FederatedStoreProperties.loadStoreProperties(storePropertiesStream).getProperties();
    assertEquals(2, properties.size());
    assertEquals("", properties.get("AXAXAXAX"));
    int actualReadResult = storePropertiesStream.read(new byte[] {});
    assertEquals(-1, actualReadResult);
    assertTrue(properties.containsKey("gaffer.store.properties.class"));
  }

  /**
   * Test {@link FederatedStoreProperties#loadStoreProperties(InputStream)} with {@code
   * storePropertiesStream}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedStoreProperties#loadStoreProperties(InputStream)}
   */
  @Test
  @DisplayName(
      "Test loadStoreProperties(InputStream) with 'storePropertiesStream'; then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FederatedStoreProperties FederatedStoreProperties.loadStoreProperties(InputStream)"
  })
  void testLoadStorePropertiesWithStorePropertiesStream_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            FederatedStoreProperties.loadStoreProperties(
                new FileInputStream(new FileDescriptor())));
  }
}
