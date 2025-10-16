package uk.gov.gchq.gaffer.integration.junit.extensions;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.store.StoreProperties;
import uk.gov.gchq.gaffer.store.schema.Schema;

class IntegrationTestSuiteDiffblueTest {
  /**
   * Test {@link IntegrationTestSuite#getSchema()}.
   *
   * <p>Method under test: {@link IntegrationTestSuite#getSchema()}
   */
  @Test
  @DisplayName("Test getSchema()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional IntegrationTestSuite.getSchema()"})
  void testGetSchema() {
    // Arrange, Act and Assert
    assertFalse(new IntegrationTestSuite().getSchema().isPresent());
  }

  /**
   * Test {@link IntegrationTestSuite#getStoreProperties()}.
   *
   * <p>Method under test: {@link IntegrationTestSuite#getStoreProperties()}
   */
  @Test
  @DisplayName("Test getStoreProperties()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional IntegrationTestSuite.getStoreProperties()"})
  void testGetStoreProperties() {
    // Arrange, Act and Assert
    assertFalse(new IntegrationTestSuite().getStoreProperties().isPresent());
  }

  /**
   * Test {@link IntegrationTestSuite#getTestsToSkip()}.
   *
   * <p>Method under test: {@link IntegrationTestSuite#getTestsToSkip()}
   */
  @Test
  @DisplayName("Test getTestsToSkip()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional IntegrationTestSuite.getTestsToSkip()"})
  void testGetTestsToSkip() {
    // Arrange, Act and Assert
    assertFalse(new IntegrationTestSuite().getTestsToSkip().isPresent());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link IntegrationTestSuite}
   *   <li>{@link IntegrationTestSuite#setSchema(Schema)}
   *   <li>{@link IntegrationTestSuite#setStoreProperties(StoreProperties)}
   *   <li>{@link IntegrationTestSuite#setTestsToSkip(Map)}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void IntegrationTestSuite.<init>()",
    "void IntegrationTestSuite.setSchema(Schema)",
    "void IntegrationTestSuite.setStoreProperties(StoreProperties)",
    "void IntegrationTestSuite.setTestsToSkip(Map)"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    IntegrationTestSuite actualIntegrationTestSuite = new IntegrationTestSuite();
    Schema schema = new Schema();
    actualIntegrationTestSuite.setSchema(schema);
    StoreProperties storeProperties = new StoreProperties();
    actualIntegrationTestSuite.setStoreProperties(storeProperties);
    HashMap<String, String> testsToSkip = new HashMap<>();
    actualIntegrationTestSuite.setTestsToSkip(testsToSkip);

    // Assert
    Optional<Map<String, String>> testsToSkip2 = actualIntegrationTestSuite.getTestsToSkip();
    Map<String, String> getResult = testsToSkip2.get();
    assertTrue(getResult.isEmpty());
    Optional<Schema> schema2 = actualIntegrationTestSuite.getSchema();
    assertTrue(schema2.isPresent());
    Optional<StoreProperties> storeProperties2 = actualIntegrationTestSuite.getStoreProperties();
    assertTrue(storeProperties2.isPresent());
    assertTrue(testsToSkip2.isPresent());
    assertSame(testsToSkip, getResult);
    assertSame(storeProperties, storeProperties2.get());
    assertSame(schema, schema2.get());
  }
}
