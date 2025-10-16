package uk.gov.gchq.gaffer.operation.export.resultcache.handler;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.operation.export.resultcache.GafferResultCacheExporter;

class ExportToGafferResultCacheHandlerDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link ExportToGafferResultCacheHandler}
   *   <li>{@link ExportToGafferResultCacheHandler#setGraphId(String)}
   *   <li>{@link ExportToGafferResultCacheHandler#setStorePropertiesPath(String)}
   *   <li>{@link ExportToGafferResultCacheHandler#setTimeToLive(Long)}
   *   <li>{@link ExportToGafferResultCacheHandler#setVisibility(String)}
   *   <li>{@link ExportToGafferResultCacheHandler#getExporterClass()}
   *   <li>{@link ExportToGafferResultCacheHandler#getGraphId()}
   *   <li>{@link ExportToGafferResultCacheHandler#getStorePropertiesPath()}
   *   <li>{@link ExportToGafferResultCacheHandler#getTimeToLive()}
   *   <li>{@link ExportToGafferResultCacheHandler#getVisibility()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ExportToGafferResultCacheHandler.<init>()",
    "Class ExportToGafferResultCacheHandler.getExporterClass()",
    "String ExportToGafferResultCacheHandler.getGraphId()",
    "String ExportToGafferResultCacheHandler.getStorePropertiesPath()",
    "Long ExportToGafferResultCacheHandler.getTimeToLive()",
    "String ExportToGafferResultCacheHandler.getVisibility()",
    "void ExportToGafferResultCacheHandler.setGraphId(String)",
    "void ExportToGafferResultCacheHandler.setStorePropertiesPath(String)",
    "void ExportToGafferResultCacheHandler.setTimeToLive(Long)",
    "void ExportToGafferResultCacheHandler.setVisibility(String)"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    ExportToGafferResultCacheHandler actualExportToGafferResultCacheHandler =
        new ExportToGafferResultCacheHandler();
    actualExportToGafferResultCacheHandler.setGraphId("42");
    actualExportToGafferResultCacheHandler.setStorePropertiesPath("Cache Store Properties Path");
    actualExportToGafferResultCacheHandler.setTimeToLive(10L);
    actualExportToGafferResultCacheHandler.setVisibility("Visibility");
    Class<GafferResultCacheExporter> actualExporterClass =
        actualExportToGafferResultCacheHandler.getExporterClass();
    String actualGraphId = actualExportToGafferResultCacheHandler.getGraphId();
    String actualStorePropertiesPath =
        actualExportToGafferResultCacheHandler.getStorePropertiesPath();
    Long actualTimeToLive = actualExportToGafferResultCacheHandler.getTimeToLive();

    // Assert
    assertEquals("42", actualGraphId);
    assertEquals("Cache Store Properties Path", actualStorePropertiesPath);
    assertEquals("Visibility", actualExportToGafferResultCacheHandler.getVisibility());
    assertEquals(10L, actualTimeToLive.longValue());
    Class<GafferResultCacheExporter> expectedExporterClass = GafferResultCacheExporter.class;
    assertEquals(expectedExporterClass, actualExporterClass);
  }
}
