package uk.gov.gchq.gaffer.sparkaccumulo.operation.handler;

import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.accumulostore.AccumuloStore;
import uk.gov.gchq.gaffer.operation.Operation;
import uk.gov.gchq.gaffer.operation.OperationException;
import uk.gov.gchq.gaffer.sparkaccumulo.operation.handler.javardd.ImportKeyValueJavaPairRDDToAccumuloHandler;
import uk.gov.gchq.gaffer.sparkaccumulo.operation.javardd.ImportKeyValueJavaPairRDDToAccumulo;
import uk.gov.gchq.gaffer.store.Context;

class AbstractImportKeyValuePairRDDToAccumuloHandlerDiffblueTest {
  /**
   * Test {@link AbstractImportKeyValuePairRDDToAccumuloHandler#doOperation(Operation, Context,
   * AccumuloStore)} with {@code ImportKeyValueJavaPairRDDToAccumulo}, {@code Context}, {@code
   * AccumuloStore}.
   *
   * <p>Method under test: {@link
   * AbstractImportKeyValuePairRDDToAccumuloHandler#doOperation(Operation, Context, AccumuloStore)}
   */
  @Test
  @DisplayName(
      "Test doOperation(Operation, Context, AccumuloStore) with 'ImportKeyValueJavaPairRDDToAccumulo', 'Context', 'AccumuloStore'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AbstractImportKeyValuePairRDDToAccumuloHandler.doOperation(Operation, Context, AccumuloStore)"
  })
  void testDoOperationWithImportKeyValueJavaPairRDDToAccumuloContextAccumuloStore()
      throws OperationException {
    // Arrange
    ImportKeyValueJavaPairRDDToAccumuloHandler importKeyValueJavaPairRDDToAccumuloHandler =
        new ImportKeyValueJavaPairRDDToAccumuloHandler();
    ImportKeyValueJavaPairRDDToAccumulo importKeyValueJavaPairRDDToAccumulo =
        new ImportKeyValueJavaPairRDDToAccumulo();
    Context context = new Context();

    // Act and Assert
    assertThrows(
        OperationException.class,
        () ->
            importKeyValueJavaPairRDDToAccumuloHandler.doOperation(
                importKeyValueJavaPairRDDToAccumulo, context, new AccumuloStore()));
  }

  /**
   * Test {@link AbstractImportKeyValuePairRDDToAccumuloHandler#doOperation(Operation, Context,
   * AccumuloStore)} with {@code ImportKeyValueJavaPairRDDToAccumulo}, {@code Context}, {@code
   * AccumuloStore}.
   *
   * <p>Method under test: {@link
   * AbstractImportKeyValuePairRDDToAccumuloHandler#doOperation(Operation, Context, AccumuloStore)}
   */
  @Test
  @DisplayName(
      "Test doOperation(Operation, Context, AccumuloStore) with 'ImportKeyValueJavaPairRDDToAccumulo', 'Context', 'AccumuloStore'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AbstractImportKeyValuePairRDDToAccumuloHandler.doOperation(Operation, Context, AccumuloStore)"
  })
  void testDoOperationWithImportKeyValueJavaPairRDDToAccumuloContextAccumuloStore2()
      throws OperationException {
    // Arrange
    ImportKeyValueJavaPairRDDToAccumuloHandler importKeyValueJavaPairRDDToAccumuloHandler =
        new ImportKeyValueJavaPairRDDToAccumuloHandler();

    ImportKeyValueJavaPairRDDToAccumulo importKeyValueJavaPairRDDToAccumulo =
        new ImportKeyValueJavaPairRDDToAccumulo();
    importKeyValueJavaPairRDDToAccumulo.setOutputPath(
        "Option outputPath must be set for this option to be run against the accumulostore");
    Context context = new Context();

    // Act and Assert
    assertThrows(
        OperationException.class,
        () ->
            importKeyValueJavaPairRDDToAccumuloHandler.doOperation(
                importKeyValueJavaPairRDDToAccumulo, context, new AccumuloStore()));
  }

  /**
   * Test {@link AbstractImportKeyValuePairRDDToAccumuloHandler#doOperation(Operation, Context,
   * AccumuloStore)} with {@code ImportKeyValueJavaPairRDDToAccumulo}, {@code Context}, {@code
   * AccumuloStore}.
   *
   * <p>Method under test: {@link
   * AbstractImportKeyValuePairRDDToAccumuloHandler#doOperation(Operation, Context, AccumuloStore)}
   */
  @Test
  @DisplayName(
      "Test doOperation(Operation, Context, AccumuloStore) with 'ImportKeyValueJavaPairRDDToAccumulo', 'Context', 'AccumuloStore'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AbstractImportKeyValuePairRDDToAccumuloHandler.doOperation(Operation, Context, AccumuloStore)"
  })
  void testDoOperationWithImportKeyValueJavaPairRDDToAccumuloContextAccumuloStore3()
      throws OperationException {
    // Arrange
    ImportKeyValueJavaPairRDDToAccumuloHandler importKeyValueJavaPairRDDToAccumuloHandler =
        new ImportKeyValueJavaPairRDDToAccumuloHandler();

    ImportKeyValueJavaPairRDDToAccumulo importKeyValueJavaPairRDDToAccumulo =
        new ImportKeyValueJavaPairRDDToAccumulo();
    importKeyValueJavaPairRDDToAccumulo.setOutputPath("");
    Context context = new Context();

    // Act and Assert
    assertThrows(
        OperationException.class,
        () ->
            importKeyValueJavaPairRDDToAccumuloHandler.doOperation(
                importKeyValueJavaPairRDDToAccumulo, context, new AccumuloStore()));
  }

  /**
   * Test {@link AbstractImportKeyValuePairRDDToAccumuloHandler#getConfiguration(Operation)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractImportKeyValuePairRDDToAccumuloHandler#getConfiguration(Operation)}
   */
  @Test
  @DisplayName("Test getConfiguration(Operation); given '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.apache.hadoop.conf.Configuration AbstractImportKeyValuePairRDDToAccumuloHandler.getConfiguration(Operation)"
  })
  void testGetConfiguration_given42() throws OperationException {
    // Arrange
    ImportKeyValueJavaPairRDDToAccumuloHandler importKeyValueJavaPairRDDToAccumuloHandler =
        new ImportKeyValueJavaPairRDDToAccumuloHandler();

    ImportKeyValueJavaPairRDDToAccumulo importKeyValueJavaPairRDDToAccumulo =
        new ImportKeyValueJavaPairRDDToAccumulo();
    importKeyValueJavaPairRDDToAccumulo.addOption(
        AbstractGetRDDHandler.HADOOP_CONFIGURATION_KEY, "42");

    // Act and Assert
    assertThrows(
        OperationException.class,
        () ->
            importKeyValueJavaPairRDDToAccumuloHandler.getConfiguration(
                importKeyValueJavaPairRDDToAccumulo));
  }

  /**
   * Test {@link AbstractImportKeyValuePairRDDToAccumuloHandler#getConfiguration(Operation)}.
   *
   * <ul>
   *   <li>Given empty string.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractImportKeyValuePairRDDToAccumuloHandler#getConfiguration(Operation)}
   */
  @Test
  @DisplayName("Test getConfiguration(Operation); given empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.apache.hadoop.conf.Configuration AbstractImportKeyValuePairRDDToAccumuloHandler.getConfiguration(Operation)"
  })
  void testGetConfiguration_givenEmptyString() throws OperationException {
    // Arrange
    ImportKeyValueJavaPairRDDToAccumuloHandler importKeyValueJavaPairRDDToAccumuloHandler =
        new ImportKeyValueJavaPairRDDToAccumuloHandler();

    ImportKeyValueJavaPairRDDToAccumulo importKeyValueJavaPairRDDToAccumulo =
        new ImportKeyValueJavaPairRDDToAccumulo();
    importKeyValueJavaPairRDDToAccumulo.addOption(
        AbstractGetRDDHandler.HADOOP_CONFIGURATION_KEY, "");

    // Act and Assert
    assertThrows(
        OperationException.class,
        () ->
            importKeyValueJavaPairRDDToAccumuloHandler.getConfiguration(
                importKeyValueJavaPairRDDToAccumulo));
  }
}
