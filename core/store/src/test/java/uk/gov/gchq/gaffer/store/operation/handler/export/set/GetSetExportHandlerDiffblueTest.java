package uk.gov.gchq.gaffer.store.operation.handler.export.set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.Iterator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.operation.OperationException;
import uk.gov.gchq.gaffer.operation.impl.export.set.GetSetExport;
import uk.gov.gchq.gaffer.operation.impl.export.set.SetExporter;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.Store;
import uk.gov.gchq.gaffer.store.operation.handler.TestAddToGraphLibraryImpl;
import uk.gov.gchq.koryphe.iterable.LimitedIterable;
import uk.gov.gchq.koryphe.iterable.LimitedIterator;

class GetSetExportHandlerDiffblueTest {
  /**
   * Test {@link GetSetExportHandler#getExport(GetSetExport, SetExporter)} with {@code
   * GetSetExport}, {@code SetExporter}.
   *
   * <ul>
   *   <li>Given {@code Key}.
   *   <li>When {@link GetSetExport} (default constructor) Key is {@code Key}.
   * </ul>
   *
   * <p>Method under test: {@link GetSetExportHandler#getExport(GetSetExport, SetExporter)}
   */
  @Test
  @DisplayName(
      "Test getExport(GetSetExport, SetExporter) with 'GetSetExport', 'SetExporter'; given 'Key'; when GetSetExport (default constructor) Key is 'Key'")
  @Tag("MaintainedByDiffblue")
  void testGetExportWithGetSetExportSetExporter_givenKey_whenGetSetExportKeyIsKey()
      throws OperationException {
    // Arrange
    GetSetExportHandler getSetExportHandler = new GetSetExportHandler();

    GetSetExport export = new GetSetExport();
    export.setKey("Key");

    SetExporter exporter = new SetExporter();
    exporter.add("Key", new ArrayList<>());

    // Act
    Iterable<?> actualExport = getSetExportHandler.getExport(export, exporter);
    Iterator<?> actualIteratorResult = actualExport.iterator();

    // Assert
    assertTrue(actualExport instanceof LimitedIterable);
    assertTrue(actualIteratorResult instanceof LimitedIterator);
    assertNull(((LimitedIterable<?>) actualExport).getEnd());
    assertEquals(0, ((LimitedIterable<?>) actualExport).getStart());
    assertFalse(actualIteratorResult.hasNext());
  }

  /**
   * Test {@link GetSetExportHandler#getExport(GetSetExport, SetExporter)} with {@code
   * GetSetExport}, {@code SetExporter}.
   *
   * <ul>
   *   <li>Given three.
   *   <li>Then return End intValue is three.
   * </ul>
   *
   * <p>Method under test: {@link GetSetExportHandler#getExport(GetSetExport, SetExporter)}
   */
  @Test
  @DisplayName(
      "Test getExport(GetSetExport, SetExporter) with 'GetSetExport', 'SetExporter'; given three; then return End intValue is three")
  @Tag("MaintainedByDiffblue")
  void testGetExportWithGetSetExportSetExporter_givenThree_thenReturnEndIntValueIsThree()
      throws OperationException {
    // Arrange
    GetSetExportHandler getSetExportHandler = new GetSetExportHandler();

    GetSetExport export = new GetSetExport();
    export.setEnd(3);

    // Act
    Iterable<?> actualExport = getSetExportHandler.getExport(export, new SetExporter());
    Iterator<?> actualIteratorResult = actualExport.iterator();

    // Assert
    assertTrue(actualExport instanceof LimitedIterable);
    assertTrue(actualIteratorResult instanceof LimitedIterator);
    assertEquals(0, ((LimitedIterable<?>) actualExport).getStart());
    assertEquals(3, ((LimitedIterable<?>) actualExport).getEnd().intValue());
    assertFalse(actualIteratorResult.hasNext());
  }

  /**
   * Test {@link GetSetExportHandler#getExport(GetSetExport, SetExporter)} with {@code
   * GetSetExport}, {@code SetExporter}.
   *
   * <ul>
   *   <li>When {@link GetSetExport} (default constructor).
   *   <li>Then return End is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link GetSetExportHandler#getExport(GetSetExport, SetExporter)}
   */
  @Test
  @DisplayName(
      "Test getExport(GetSetExport, SetExporter) with 'GetSetExport', 'SetExporter'; when GetSetExport (default constructor); then return End is 'null'")
  @Tag("MaintainedByDiffblue")
  void testGetExportWithGetSetExportSetExporter_whenGetSetExport_thenReturnEndIsNull()
      throws OperationException {
    // Arrange
    GetSetExportHandler getSetExportHandler = new GetSetExportHandler();
    GetSetExport export = new GetSetExport();

    // Act
    Iterable<?> actualExport = getSetExportHandler.getExport(export, new SetExporter());
    Iterator<?> actualIteratorResult = actualExport.iterator();

    // Assert
    assertTrue(actualExport instanceof LimitedIterable);
    assertTrue(actualIteratorResult instanceof LimitedIterator);
    assertNull(((LimitedIterable<?>) actualExport).getEnd());
    assertEquals(0, ((LimitedIterable<?>) actualExport).getStart());
    assertFalse(actualIteratorResult.hasNext());
  }

  /**
   * Test {@link GetSetExportHandler#createExporter(GetSetExport, Context, Store)} with {@code
   * GetSetExport}, {@code Context}, {@code Store}.
   *
   * <p>Method under test: {@link GetSetExportHandler#createExporter(GetSetExport, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test createExporter(GetSetExport, Context, Store) with 'GetSetExport', 'Context', 'Store'")
  @Tag("MaintainedByDiffblue")
  void testCreateExporterWithGetSetExportContextStore() {
    // Arrange
    GetSetExportHandler getSetExportHandler = new GetSetExportHandler();
    GetSetExport export = new GetSetExport();
    Context context = new Context();

    // Act and Assert
    Iterable<?> getResult =
        getSetExportHandler
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
   *   <li>default or parameterless constructor of {@link GetSetExportHandler}
   *   <li>{@link GetSetExportHandler#getExporterClass()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  void testGettersAndSetters() {
    // Arrange and Act
    Class<SetExporter> actualExporterClass = new GetSetExportHandler().getExporterClass();

    // Assert
    Class<SetExporter> expectedExporterClass = SetExporter.class;
    assertEquals(expectedExporterClass, actualExporterClass);
  }
}
