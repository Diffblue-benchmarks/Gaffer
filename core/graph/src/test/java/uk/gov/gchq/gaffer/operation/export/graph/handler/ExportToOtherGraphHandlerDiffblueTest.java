package uk.gov.gchq.gaffer.operation.export.graph.handler;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.operation.export.graph.OtherGraphExporter;

class ExportToOtherGraphHandlerDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link ExportToOtherGraphHandler}
   *   <li>{@link ExportToOtherGraphHandler#getExporterClass()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  void testGettersAndSetters() {
    // Arrange and Act
    Class<OtherGraphExporter> actualExporterClass =
        new ExportToOtherGraphHandler().getExporterClass();

    // Assert
    Class<OtherGraphExporter> expectedExporterClass = OtherGraphExporter.class;
    assertEquals(expectedExporterClass, actualExporterClass);
  }
}
