package uk.gov.gchq.gaffer.sparkaccumulo.operation.handler.javardd;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.accumulostore.AccumuloStore;
import uk.gov.gchq.gaffer.operation.OperationException;
import uk.gov.gchq.gaffer.spark.operation.javardd.ImportJavaRDDOfElements;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.Context.Builder;
import uk.gov.gchq.gaffer.user.User;

class ImportJavaRDDOfElementsHandlerDiffblueTest {
  /**
   * Test {@link ImportJavaRDDOfElementsHandler#doOperation(ImportJavaRDDOfElements, Context,
   * AccumuloStore)} with {@code ImportJavaRDDOfElements}, {@code Context}, {@code AccumuloStore}.
   *
   * <p>Method under test: {@link
   * ImportJavaRDDOfElementsHandler#doOperation(ImportJavaRDDOfElements, Context, AccumuloStore)}
   */
  @Test
  @DisplayName(
      "Test doOperation(ImportJavaRDDOfElements, Context, AccumuloStore) with 'ImportJavaRDDOfElements', 'Context', 'AccumuloStore'")
  @Tag("MaintainedByDiffblue")
  void testDoOperationWithImportJavaRDDOfElementsContextAccumuloStore() throws OperationException {
    // Arrange
    ImportJavaRDDOfElementsHandler importJavaRDDOfElementsHandler =
        new ImportJavaRDDOfElementsHandler();
    ImportJavaRDDOfElements operation = new ImportJavaRDDOfElements();

    Builder builder = new Builder();
    Context context = builder.user(new User.Builder().userId("42").build()).build();

    // Act and Assert
    assertThrows(
        OperationException.class,
        () -> importJavaRDDOfElementsHandler.doOperation(operation, context, new AccumuloStore()));
  }

  /**
   * Test {@link ImportJavaRDDOfElementsHandler#doOperation(ImportJavaRDDOfElements, Context,
   * AccumuloStore)} with {@code ImportJavaRDDOfElements}, {@code Context}, {@code AccumuloStore}.
   *
   * <p>Method under test: {@link
   * ImportJavaRDDOfElementsHandler#doOperation(ImportJavaRDDOfElements, Context, AccumuloStore)}
   */
  @Test
  @DisplayName(
      "Test doOperation(ImportJavaRDDOfElements, Context, AccumuloStore) with 'ImportJavaRDDOfElements', 'Context', 'AccumuloStore'")
  @Tag("MaintainedByDiffblue")
  void testDoOperationWithImportJavaRDDOfElementsContextAccumuloStore2() throws OperationException {
    // Arrange
    ImportJavaRDDOfElementsHandler importJavaRDDOfElementsHandler =
        new ImportJavaRDDOfElementsHandler();

    ImportJavaRDDOfElements operation = new ImportJavaRDDOfElements();
    operation.addOption("outputPath", "42");

    Builder builder = new Builder();
    Context context = builder.user(new User.Builder().userId("42").build()).build();

    // Act and Assert
    assertThrows(
        OperationException.class,
        () -> importJavaRDDOfElementsHandler.doOperation(operation, context, new AccumuloStore()));
  }

  /**
   * Test {@link ImportJavaRDDOfElementsHandler#doOperation(ImportJavaRDDOfElements, Context,
   * AccumuloStore)} with {@code ImportJavaRDDOfElements}, {@code Context}, {@code AccumuloStore}.
   *
   * <ul>
   *   <li>Given empty string.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImportJavaRDDOfElementsHandler#doOperation(ImportJavaRDDOfElements, Context, AccumuloStore)}
   */
  @Test
  @DisplayName(
      "Test doOperation(ImportJavaRDDOfElements, Context, AccumuloStore) with 'ImportJavaRDDOfElements', 'Context', 'AccumuloStore'; given empty string")
  @Tag("MaintainedByDiffblue")
  void testDoOperationWithImportJavaRDDOfElementsContextAccumuloStore_givenEmptyString()
      throws OperationException {
    // Arrange
    ImportJavaRDDOfElementsHandler importJavaRDDOfElementsHandler =
        new ImportJavaRDDOfElementsHandler();

    ImportJavaRDDOfElements operation = new ImportJavaRDDOfElements();
    operation.addOption("outputPath", "");

    Builder builder = new Builder();
    Context context = builder.user(new User.Builder().userId("42").build()).build();

    // Act and Assert
    assertThrows(
        OperationException.class,
        () -> importJavaRDDOfElementsHandler.doOperation(operation, context, new AccumuloStore()));
  }
}
