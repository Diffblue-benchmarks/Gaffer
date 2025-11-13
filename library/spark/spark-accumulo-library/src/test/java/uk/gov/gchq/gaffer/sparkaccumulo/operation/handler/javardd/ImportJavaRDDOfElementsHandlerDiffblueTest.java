/*
 * Copyright 2025 Crown Copyright
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.gov.gchq.gaffer.sparkaccumulo.operation.handler.javardd;

import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.accumulostore.AccumuloStore;
import uk.gov.gchq.gaffer.operation.OperationException;
import uk.gov.gchq.gaffer.spark.operation.javardd.ImportJavaRDDOfElements;
import uk.gov.gchq.gaffer.store.Context;

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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ImportJavaRDDOfElementsHandler.doOperation(ImportJavaRDDOfElements, Context, AccumuloStore)"
  })
  void testDoOperationWithImportJavaRDDOfElementsContextAccumuloStore() throws OperationException {
    // Arrange
    ImportJavaRDDOfElementsHandler importJavaRDDOfElementsHandler =
        new ImportJavaRDDOfElementsHandler();
    ImportJavaRDDOfElements operation = new ImportJavaRDDOfElements();
    Context context = new Context();

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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ImportJavaRDDOfElementsHandler.doOperation(ImportJavaRDDOfElements, Context, AccumuloStore)"
  })
  void testDoOperationWithImportJavaRDDOfElementsContextAccumuloStore2() throws OperationException {
    // Arrange
    ImportJavaRDDOfElementsHandler importJavaRDDOfElementsHandler =
        new ImportJavaRDDOfElementsHandler();

    ImportJavaRDDOfElements operation = new ImportJavaRDDOfElements();
    operation.addOption("outputPath", "42");
    Context context = new Context();

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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ImportJavaRDDOfElementsHandler.doOperation(ImportJavaRDDOfElements, Context, AccumuloStore)"
  })
  void testDoOperationWithImportJavaRDDOfElementsContextAccumuloStore_givenEmptyString()
      throws OperationException {
    // Arrange
    ImportJavaRDDOfElementsHandler importJavaRDDOfElementsHandler =
        new ImportJavaRDDOfElementsHandler();

    ImportJavaRDDOfElements operation = new ImportJavaRDDOfElements();
    operation.addOption("outputPath", "");
    Context context = new Context();

    // Act and Assert
    assertThrows(
        OperationException.class,
        () -> importJavaRDDOfElementsHandler.doOperation(operation, context, new AccumuloStore()));
  }
}
