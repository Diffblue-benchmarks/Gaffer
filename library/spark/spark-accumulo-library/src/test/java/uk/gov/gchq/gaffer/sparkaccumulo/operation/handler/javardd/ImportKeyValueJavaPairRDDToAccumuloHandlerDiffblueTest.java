package uk.gov.gchq.gaffer.sparkaccumulo.operation.handler.javardd;

import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.sparkaccumulo.operation.javardd.ImportKeyValueJavaPairRDDToAccumulo;

class ImportKeyValueJavaPairRDDToAccumuloHandlerDiffblueTest {
  /**
   * Test {@link
   * ImportKeyValueJavaPairRDDToAccumuloHandler#getFailurePath(ImportKeyValueJavaPairRDDToAccumulo)}
   * with {@code ImportKeyValueJavaPairRDDToAccumulo}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImportKeyValueJavaPairRDDToAccumuloHandler#getFailurePath(ImportKeyValueJavaPairRDDToAccumulo)}
   */
  @Test
  @DisplayName(
      "Test getFailurePath(ImportKeyValueJavaPairRDDToAccumulo) with 'ImportKeyValueJavaPairRDDToAccumulo'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.String ImportKeyValueJavaPairRDDToAccumuloHandler.getFailurePath(ImportKeyValueJavaPairRDDToAccumulo)"
  })
  void testGetFailurePathWithImportKeyValueJavaPairRDDToAccumulo_thenReturnNull() {
    // Arrange
    ImportKeyValueJavaPairRDDToAccumuloHandler importKeyValueJavaPairRDDToAccumuloHandler =
        new ImportKeyValueJavaPairRDDToAccumuloHandler();

    // Act and Assert
    assertNull(
        importKeyValueJavaPairRDDToAccumuloHandler.getFailurePath(
            new ImportKeyValueJavaPairRDDToAccumulo()));
  }

  /**
   * Test {@link
   * ImportKeyValueJavaPairRDDToAccumuloHandler#getOutputPath(ImportKeyValueJavaPairRDDToAccumulo)}
   * with {@code ImportKeyValueJavaPairRDDToAccumulo}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImportKeyValueJavaPairRDDToAccumuloHandler#getOutputPath(ImportKeyValueJavaPairRDDToAccumulo)}
   */
  @Test
  @DisplayName(
      "Test getOutputPath(ImportKeyValueJavaPairRDDToAccumulo) with 'ImportKeyValueJavaPairRDDToAccumulo'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.String ImportKeyValueJavaPairRDDToAccumuloHandler.getOutputPath(ImportKeyValueJavaPairRDDToAccumulo)"
  })
  void testGetOutputPathWithImportKeyValueJavaPairRDDToAccumulo_thenReturnNull() {
    // Arrange
    ImportKeyValueJavaPairRDDToAccumuloHandler importKeyValueJavaPairRDDToAccumuloHandler =
        new ImportKeyValueJavaPairRDDToAccumuloHandler();

    // Act and Assert
    assertNull(
        importKeyValueJavaPairRDDToAccumuloHandler.getOutputPath(
            new ImportKeyValueJavaPairRDDToAccumulo()));
  }
}
