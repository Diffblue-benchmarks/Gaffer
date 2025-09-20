package uk.gov.gchq.gaffer.operation.export;

import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.operation.impl.export.localfile.ImportFromLocalFile;
import uk.gov.gchq.gaffer.operation.impl.export.localfile.ImportFromLocalFile.Builder;

class GetExportDiffblueTest {
  /**
   * Test Builder {@link uk.gov.gchq.gaffer.operation.export.GetExport.Builder#jobId(String)}.
   *
   * <p>Method under test: {@link
   * uk.gov.gchq.gaffer.operation.export.GetExport.Builder#jobId(String)}
   */
  @Test
  @DisplayName("Test Builder jobId(String)")
  @Tag("MaintainedByDiffblue")
  void testBuilderJobId() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualJobIdResult = builder.jobId("42");

    // Assert
    assertSame(builder, actualJobIdResult);
  }
}
