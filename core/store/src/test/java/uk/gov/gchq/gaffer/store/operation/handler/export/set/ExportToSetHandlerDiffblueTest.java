package uk.gov.gchq.gaffer.store.operation.handler.export.set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.operation.impl.export.set.ExportToSet;
import uk.gov.gchq.gaffer.operation.impl.export.set.SetExporter;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.Store;
import uk.gov.gchq.gaffer.store.operation.handler.TestAddToGraphLibraryImpl;
import uk.gov.gchq.koryphe.iterable.LimitedIterable;

class ExportToSetHandlerDiffblueTest {
  /**
   * Test {@link ExportToSetHandler#createExporter(ExportToSet, Context, Store)} with {@code
   * ExportToSet}, {@code Context}, {@code Store}.
   *
   * <p>Method under test: {@link ExportToSetHandler#createExporter(ExportToSet, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test createExporter(ExportToSet, Context, Store) with 'ExportToSet', 'Context', 'Store'")
  @Tag("MaintainedByDiffblue")
  void testCreateExporterWithExportToSetContextStore() {
    // Arrange
    ExportToSetHandler exportToSetHandler = new ExportToSetHandler();
    ExportToSet export = new ExportToSet();
    Context context = new Context();

    // Act and Assert
    Iterable<?> getResult =
        exportToSetHandler
            .createExporter(export, context, new TestAddToGraphLibraryImpl())
            .get("Key");
    assertTrue(getResult instanceof LimitedIterable);
    assertNull(((LimitedIterable<?>) getResult).getEnd());
    assertEquals(0, ((LimitedIterable<?>) getResult).getStart());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link ExportToSetHandler}
   *   <li>{@link ExportToSetHandler#getExporterClass()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  void testGettersAndSetters() {
    // Arrange and Act
    Class<SetExporter> actualExporterClass = new ExportToSetHandler().getExporterClass();

    // Assert
    Class<SetExporter> expectedExporterClass = SetExporter.class;
    assertEquals(expectedExporterClass, actualExporterClass);
  }
}
