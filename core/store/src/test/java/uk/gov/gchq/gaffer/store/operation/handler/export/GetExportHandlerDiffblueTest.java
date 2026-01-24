/*
 * Copyright 2026 Crown Copyright
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

package uk.gov.gchq.gaffer.store.operation.handler.export;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uk.gov.gchq.gaffer.operation.OperationException;
import uk.gov.gchq.gaffer.operation.export.Exporter;
import uk.gov.gchq.gaffer.operation.export.GetExport;
import uk.gov.gchq.gaffer.operation.impl.export.localfile.ImportFromLocalFile;
import uk.gov.gchq.gaffer.operation.impl.export.localfile.LocalFileExporter;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.Store;
import uk.gov.gchq.gaffer.store.operation.handler.TestAddToGraphLibraryImpl;
import uk.gov.gchq.gaffer.store.operation.handler.export.localfile.ImportFromLocalFileHandler;

class GetExportHandlerDiffblueTest {
  /**
   * Test {@link GetExportHandler#doOperation(GetExport, Context, Store, Exporter)} with {@code
   * export}, {@code context}, {@code store}, {@code exporter}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>Then return {@link List}.
   * </ul>
   *
   * <p>Method under test: {@link GetExportHandler#doOperation(GetExport, Context, Store, Exporter)}
   */
  @Test
  @DisplayName(
      "Test doOperation(GetExport, Context, Store, Exporter) with 'export', 'context', 'store', 'exporter'; given ArrayList(); then return List")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable GetExportHandler.doOperation(GetExport, Context, Store, Exporter)"})
  void testDoOperationWithExportContextStoreExporter_givenArrayList_thenReturnList()
      throws OperationException {
    // Arrange
    ImportFromLocalFileHandler importFromLocalFileHandler = new ImportFromLocalFileHandler();
    ImportFromLocalFile importFromLocalFile = new ImportFromLocalFile();
    Context context = new Context();
    TestAddToGraphLibraryImpl store = new TestAddToGraphLibraryImpl();

    LocalFileExporter localFileExporter = mock(LocalFileExporter.class);
    when(localFileExporter.get(Mockito.<String>any())).thenReturn(new ArrayList<>());

    // Act
    Iterable<?> actualDoOperationResult =
        importFromLocalFileHandler.doOperation(
            importFromLocalFile, context, store, localFileExporter);
    Iterator<?> actualIteratorResult = actualDoOperationResult.iterator();

    // Assert
    verify(localFileExporter).get("ALL");
    assertTrue(actualDoOperationResult instanceof List);
    assertFalse(actualIteratorResult.hasNext());
    assertTrue(((List<?>) actualDoOperationResult).isEmpty());
  }
}
