package uk.gov.gchq.gaffer.store.operation.handler.export.localfile;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.operation.impl.export.localfile.LocalFileExporter;

class ExportToLocalFileHandlerDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link ExportToLocalFileHandler}
   *   <li>{@link ExportToLocalFileHandler#getExporterClass()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ExportToLocalFileHandler.<init>()",
    "Class ExportToLocalFileHandler.getExporterClass()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    Class<LocalFileExporter> actualExporterClass =
        new ExportToLocalFileHandler().getExporterClass();

    // Assert
    Class<LocalFileExporter> expectedExporterClass = LocalFileExporter.class;
    assertEquals(expectedExporterClass, actualExporterClass);
  }
}
