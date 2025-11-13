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

package uk.gov.gchq.gaffer.sparkaccumulo.operation.handler.scalardd;

import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.accumulostore.AccumuloStore;
import uk.gov.gchq.gaffer.operation.OperationException;
import uk.gov.gchq.gaffer.spark.operation.scalardd.ImportRDDOfElements;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.Store;

class ImportRDDOfElementsHandlerDiffblueTest {
  /**
   * Test {@link ImportRDDOfElementsHandler#doOperation(ImportRDDOfElements, Context, AccumuloStore)} with {@code ImportRDDOfElements}, {@code Context}, {@code AccumuloStore}.
   * <p>
   * Method under test: {@link ImportRDDOfElementsHandler#doOperation(ImportRDDOfElements, Context, AccumuloStore)}
   */
  @Test
  @DisplayName("Test doOperation(ImportRDDOfElements, Context, AccumuloStore) with 'ImportRDDOfElements', 'Context', 'AccumuloStore'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ImportRDDOfElementsHandler.doOperation(ImportRDDOfElements, Context, AccumuloStore)"})
  void testDoOperationWithImportRDDOfElementsContextAccumuloStore() throws OperationException {
    // Arrange
    ImportRDDOfElementsHandler importRDDOfElementsHandler = new ImportRDDOfElementsHandler();
    ImportRDDOfElements operation = new ImportRDDOfElements();
    Context context = new Context();

    // Act and Assert
    assertThrows(OperationException.class,
        () -> importRDDOfElementsHandler.doOperation(operation, context, new AccumuloStore()));
  }

  /**
   * Test {@link ImportRDDOfElementsHandler#doOperation(ImportRDDOfElements, Context, AccumuloStore)} with {@code ImportRDDOfElements}, {@code Context}, {@code AccumuloStore}.
   * <p>
   * Method under test: {@link ImportRDDOfElementsHandler#doOperation(ImportRDDOfElements, Context, AccumuloStore)}
   */
  @Test
  @DisplayName("Test doOperation(ImportRDDOfElements, Context, AccumuloStore) with 'ImportRDDOfElements', 'Context', 'AccumuloStore'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ImportRDDOfElementsHandler.doOperation(ImportRDDOfElements, Context, AccumuloStore)"})
  void testDoOperationWithImportRDDOfElementsContextAccumuloStore2() throws OperationException {
    // Arrange
    ImportRDDOfElementsHandler importRDDOfElementsHandler = new ImportRDDOfElementsHandler();

    ImportRDDOfElements operation = new ImportRDDOfElements();
    operation.addOption("outputPath", "42");
    Context context = new Context();

    // Act and Assert
    assertThrows(OperationException.class,
        () -> importRDDOfElementsHandler.doOperation(operation, context, new AccumuloStore()));
  }

  /**
   * Test {@link ImportRDDOfElementsHandler#doOperation(ImportRDDOfElements, Context, AccumuloStore)} with {@code ImportRDDOfElements}, {@code Context}, {@code AccumuloStore}.
   * <ul>
   *   <li>Given empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImportRDDOfElementsHandler#doOperation(ImportRDDOfElements, Context, AccumuloStore)}
   */
  @Test
  @DisplayName("Test doOperation(ImportRDDOfElements, Context, AccumuloStore) with 'ImportRDDOfElements', 'Context', 'AccumuloStore'; given empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ImportRDDOfElementsHandler.doOperation(ImportRDDOfElements, Context, AccumuloStore)"})
  void testDoOperationWithImportRDDOfElementsContextAccumuloStore_givenEmptyString() throws OperationException {
    // Arrange
    ImportRDDOfElementsHandler importRDDOfElementsHandler = new ImportRDDOfElementsHandler();

    ImportRDDOfElements operation = new ImportRDDOfElements();
    operation.addOption("outputPath", "");
    Context context = new Context();

    // Act and Assert
    assertThrows(OperationException.class,
        () -> importRDDOfElementsHandler.doOperation(operation, context, new AccumuloStore()));
  }

  /**
   * Test {@link ImportRDDOfElementsHandler#doOperation(ImportRDDOfElements, Context, Store)} with {@code ImportRDDOfElements}, {@code Context}, {@code Store}.
   * <ul>
   *   <li>Given empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImportRDDOfElementsHandler#doOperation(ImportRDDOfElements, Context, Store)}
   */
  @Test
  @DisplayName("Test doOperation(ImportRDDOfElements, Context, Store) with 'ImportRDDOfElements', 'Context', 'Store'; given empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.Void ImportRDDOfElementsHandler.doOperation(ImportRDDOfElements, Context, Store)"})
  void testDoOperationWithImportRDDOfElementsContextStore_givenEmptyString() throws OperationException {
    // Arrange
    ImportRDDOfElementsHandler importRDDOfElementsHandler = new ImportRDDOfElementsHandler();

    ImportRDDOfElements operation = new ImportRDDOfElements();
    operation.addOption("outputPath", "");
    Context context = new Context();

    // Act and Assert
    assertThrows(OperationException.class,
        () -> importRDDOfElementsHandler.doOperation(operation, context, (Store) new AccumuloStore()));
  }

  /**
   * Test {@link ImportRDDOfElementsHandler#doOperation(ImportRDDOfElements, Context, Store)} with {@code ImportRDDOfElements}, {@code Context}, {@code Store}.
   * <ul>
   *   <li>Then throw {@link OperationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImportRDDOfElementsHandler#doOperation(ImportRDDOfElements, Context, Store)}
   */
  @Test
  @DisplayName("Test doOperation(ImportRDDOfElements, Context, Store) with 'ImportRDDOfElements', 'Context', 'Store'; then throw OperationException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.Void ImportRDDOfElementsHandler.doOperation(ImportRDDOfElements, Context, Store)"})
  void testDoOperationWithImportRDDOfElementsContextStore_thenThrowOperationException() throws OperationException {
    // Arrange
    ImportRDDOfElementsHandler importRDDOfElementsHandler = new ImportRDDOfElementsHandler();

    ImportRDDOfElements operation = new ImportRDDOfElements();
    operation.addOption("outputPath", "42");
    Context context = new Context();

    // Act and Assert
    assertThrows(OperationException.class,
        () -> importRDDOfElementsHandler.doOperation(operation, context, (Store) new AccumuloStore()));
  }

  /**
   * Test {@link ImportRDDOfElementsHandler#doOperation(ImportRDDOfElements, Context, Store)} with {@code ImportRDDOfElements}, {@code Context}, {@code Store}.
   * <ul>
   *   <li>When {@link ImportRDDOfElements} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link ImportRDDOfElementsHandler#doOperation(ImportRDDOfElements, Context, Store)}
   */
  @Test
  @DisplayName("Test doOperation(ImportRDDOfElements, Context, Store) with 'ImportRDDOfElements', 'Context', 'Store'; when ImportRDDOfElements (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.Void ImportRDDOfElementsHandler.doOperation(ImportRDDOfElements, Context, Store)"})
  void testDoOperationWithImportRDDOfElementsContextStore_whenImportRDDOfElements() throws OperationException {
    // Arrange
    ImportRDDOfElementsHandler importRDDOfElementsHandler = new ImportRDDOfElementsHandler();
    ImportRDDOfElements operation = new ImportRDDOfElements();
    Context context = new Context();

    // Act and Assert
    assertThrows(OperationException.class,
        () -> importRDDOfElementsHandler.doOperation(operation, context, (Store) new AccumuloStore()));
  }
}
