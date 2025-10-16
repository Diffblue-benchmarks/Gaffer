package uk.gov.gchq.gaffer.store.operation.handler.export.localfile;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uk.gov.gchq.gaffer.operation.OperationException;
import uk.gov.gchq.gaffer.operation.impl.export.localfile.ImportFromLocalFile;
import uk.gov.gchq.gaffer.operation.impl.export.localfile.LocalFileExporter;

class ImportFromLocalFileHandlerDiffblueTest {
  /**
   * Test {@link ImportFromLocalFileHandler#getExport(ImportFromLocalFile, LocalFileExporter)} with
   * {@code ImportFromLocalFile}, {@code LocalFileExporter}.
   *
   * <ul>
   *   <li>Then return {@link List}.
   * </ul>
   *
   * <p>Method under test: {@link ImportFromLocalFileHandler#getExport(ImportFromLocalFile,
   * LocalFileExporter)}
   */
  @Test
  @DisplayName(
      "Test getExport(ImportFromLocalFile, LocalFileExporter) with 'ImportFromLocalFile', 'LocalFileExporter'; then return List")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Iterable ImportFromLocalFileHandler.getExport(ImportFromLocalFile, LocalFileExporter)"
  })
  void testGetExportWithImportFromLocalFileLocalFileExporter_thenReturnList()
      throws OperationException {
    // Arrange
    ImportFromLocalFileHandler importFromLocalFileHandler = new ImportFromLocalFileHandler();
    ImportFromLocalFile importOp = new ImportFromLocalFile();

    LocalFileExporter exporter = mock(LocalFileExporter.class);
    when(exporter.get(Mockito.<String>any())).thenReturn(new ArrayList<>());

    // Act
    Iterable<?> actualExport = importFromLocalFileHandler.getExport(importOp, exporter);
    Iterator<?> actualIteratorResult = actualExport.iterator();

    // Assert
    verify(exporter).get("ALL");
    assertTrue(actualExport instanceof List);
    assertFalse(actualIteratorResult.hasNext());
    assertTrue(((List<?>) actualExport).isEmpty());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link ImportFromLocalFileHandler}
   *   <li>{@link ImportFromLocalFileHandler#getExporterClass()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ImportFromLocalFileHandler.<init>()",
    "Class ImportFromLocalFileHandler.getExporterClass()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    Class<LocalFileExporter> actualExporterClass =
        new ImportFromLocalFileHandler().getExporterClass();

    // Assert
    Class<LocalFileExporter> expectedExporterClass = LocalFileExporter.class;
    assertEquals(expectedExporterClass, actualExporterClass);
  }
}
