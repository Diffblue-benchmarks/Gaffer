package uk.gov.gchq.gaffer.sparkaccumulo.operation.handler.scalardd;

import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.sparkaccumulo.operation.scalardd.ImportKeyValuePairRDDToAccumulo;

class ImportKeyValuePairRDDToAccumuloHandlerDiffblueTest {
  /**
   * Test {@link
   * ImportKeyValuePairRDDToAccumuloHandler#getFailurePath(ImportKeyValuePairRDDToAccumulo)} with
   * {@code ImportKeyValuePairRDDToAccumulo}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImportKeyValuePairRDDToAccumuloHandler#getFailurePath(ImportKeyValuePairRDDToAccumulo)}
   */
  @Test
  @DisplayName(
      "Test getFailurePath(ImportKeyValuePairRDDToAccumulo) with 'ImportKeyValuePairRDDToAccumulo'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  void testGetFailurePathWithImportKeyValuePairRDDToAccumulo_thenReturnNull() {
    // Arrange
    ImportKeyValuePairRDDToAccumuloHandler importKeyValuePairRDDToAccumuloHandler =
        new ImportKeyValuePairRDDToAccumuloHandler();

    // Act and Assert
    assertNull(
        importKeyValuePairRDDToAccumuloHandler.getFailurePath(
            new ImportKeyValuePairRDDToAccumulo()));
  }

  /**
   * Test {@link
   * ImportKeyValuePairRDDToAccumuloHandler#getOutputPath(ImportKeyValuePairRDDToAccumulo)} with
   * {@code ImportKeyValuePairRDDToAccumulo}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImportKeyValuePairRDDToAccumuloHandler#getOutputPath(ImportKeyValuePairRDDToAccumulo)}
   */
  @Test
  @DisplayName(
      "Test getOutputPath(ImportKeyValuePairRDDToAccumulo) with 'ImportKeyValuePairRDDToAccumulo'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  void testGetOutputPathWithImportKeyValuePairRDDToAccumulo_thenReturnNull() {
    // Arrange
    ImportKeyValuePairRDDToAccumuloHandler importKeyValuePairRDDToAccumuloHandler =
        new ImportKeyValuePairRDDToAccumuloHandler();

    // Act and Assert
    assertNull(
        importKeyValuePairRDDToAccumuloHandler.getOutputPath(
            new ImportKeyValuePairRDDToAccumulo()));
  }
}
