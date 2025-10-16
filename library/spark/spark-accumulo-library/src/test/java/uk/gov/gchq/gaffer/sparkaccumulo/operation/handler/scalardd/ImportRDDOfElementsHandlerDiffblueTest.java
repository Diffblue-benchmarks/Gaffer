package uk.gov.gchq.gaffer.sparkaccumulo.operation.handler.scalardd;

import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.accumulostore.AccumuloStore;
import uk.gov.gchq.gaffer.operation.OperationException;
import uk.gov.gchq.gaffer.spark.operation.scalardd.ImportRDDOfElements;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.Context.Builder;
import uk.gov.gchq.gaffer.user.User;

class ImportRDDOfElementsHandlerDiffblueTest {
  /**
   * Test {@link ImportRDDOfElementsHandler#doOperation(ImportRDDOfElements, Context,
   * AccumuloStore)} with {@code ImportRDDOfElements}, {@code Context}, {@code AccumuloStore}.
   *
   * <p>Method under test: {@link ImportRDDOfElementsHandler#doOperation(ImportRDDOfElements,
   * Context, AccumuloStore)}
   */
  @Test
  @DisplayName(
      "Test doOperation(ImportRDDOfElements, Context, AccumuloStore) with 'ImportRDDOfElements', 'Context', 'AccumuloStore'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ImportRDDOfElementsHandler.doOperation(ImportRDDOfElements, Context, AccumuloStore)"
  })
  void testDoOperationWithImportRDDOfElementsContextAccumuloStore() throws OperationException {
    // Arrange
    ImportRDDOfElementsHandler importRDDOfElementsHandler = new ImportRDDOfElementsHandler();
    ImportRDDOfElements operation = new ImportRDDOfElements();

    Builder builder = new Builder();
    Context context = builder.user(new User.Builder().userId("42").build()).build();

    // Act and Assert
    assertThrows(
        OperationException.class,
        () -> importRDDOfElementsHandler.doOperation(operation, context, new AccumuloStore()));
  }

  /**
   * Test {@link ImportRDDOfElementsHandler#doOperation(ImportRDDOfElements, Context,
   * AccumuloStore)} with {@code ImportRDDOfElements}, {@code Context}, {@code AccumuloStore}.
   *
   * <p>Method under test: {@link ImportRDDOfElementsHandler#doOperation(ImportRDDOfElements,
   * Context, AccumuloStore)}
   */
  @Test
  @DisplayName(
      "Test doOperation(ImportRDDOfElements, Context, AccumuloStore) with 'ImportRDDOfElements', 'Context', 'AccumuloStore'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ImportRDDOfElementsHandler.doOperation(ImportRDDOfElements, Context, AccumuloStore)"
  })
  void testDoOperationWithImportRDDOfElementsContextAccumuloStore2() throws OperationException {
    // Arrange
    ImportRDDOfElementsHandler importRDDOfElementsHandler = new ImportRDDOfElementsHandler();

    ImportRDDOfElements operation = new ImportRDDOfElements();
    operation.addOption("outputPath", "42");

    Builder builder = new Builder();
    Context context = builder.user(new User.Builder().userId("42").build()).build();

    // Act and Assert
    assertThrows(
        OperationException.class,
        () -> importRDDOfElementsHandler.doOperation(operation, context, new AccumuloStore()));
  }

  /**
   * Test {@link ImportRDDOfElementsHandler#doOperation(ImportRDDOfElements, Context,
   * AccumuloStore)} with {@code ImportRDDOfElements}, {@code Context}, {@code AccumuloStore}.
   *
   * <ul>
   *   <li>Given empty string.
   * </ul>
   *
   * <p>Method under test: {@link ImportRDDOfElementsHandler#doOperation(ImportRDDOfElements,
   * Context, AccumuloStore)}
   */
  @Test
  @DisplayName(
      "Test doOperation(ImportRDDOfElements, Context, AccumuloStore) with 'ImportRDDOfElements', 'Context', 'AccumuloStore'; given empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ImportRDDOfElementsHandler.doOperation(ImportRDDOfElements, Context, AccumuloStore)"
  })
  void testDoOperationWithImportRDDOfElementsContextAccumuloStore_givenEmptyString()
      throws OperationException {
    // Arrange
    ImportRDDOfElementsHandler importRDDOfElementsHandler = new ImportRDDOfElementsHandler();

    ImportRDDOfElements operation = new ImportRDDOfElements();
    operation.addOption("outputPath", "");

    Builder builder = new Builder();
    Context context = builder.user(new User.Builder().userId("42").build()).build();

    // Act and Assert
    assertThrows(
        OperationException.class,
        () -> importRDDOfElementsHandler.doOperation(operation, context, new AccumuloStore()));
  }
}
