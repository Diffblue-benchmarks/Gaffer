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

package uk.gov.gchq.gaffer.store.operation.handler.export;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uk.gov.gchq.gaffer.operation.OperationException;
import uk.gov.gchq.gaffer.operation.export.ExportTo;
import uk.gov.gchq.gaffer.operation.export.Exporter;
import uk.gov.gchq.gaffer.operation.impl.export.localfile.ExportToLocalFile;
import uk.gov.gchq.gaffer.operation.impl.export.localfile.LocalFileExporter;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.Store;
import uk.gov.gchq.gaffer.store.operation.handler.TestAddToGraphLibraryImpl;
import uk.gov.gchq.gaffer.store.operation.handler.export.localfile.ExportToLocalFileHandler;

class ExportToHandlerDiffblueTest {
  /**
   * Test {@link ExportToHandler#doOperation(ExportTo, Context, Store, Exporter)} with {@code export}, {@code context}, {@code store}, {@code exporter}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExportToHandler#doOperation(ExportTo, Context, Store, Exporter)}
   */
  @Test
  @DisplayName("Test doOperation(ExportTo, Context, Store, Exporter) with 'export', 'context', 'store', 'exporter'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object ExportToHandler.doOperation(ExportTo, Context, Store, Exporter)"})
  void testDoOperationWithExportContextStoreExporter_thenReturnNull() throws OperationException {
    // Arrange
    ExportToLocalFileHandler exportToLocalFileHandler = new ExportToLocalFileHandler();
    ExportToLocalFile exportToLocalFile = new ExportToLocalFile();
    Context context = new Context();
    TestAddToGraphLibraryImpl store = new TestAddToGraphLibraryImpl();
    LocalFileExporter localFileExporter = mock(LocalFileExporter.class);
    doNothing().when(localFileExporter).add(Mockito.<String>any(), Mockito.<Iterable<Object>>any());

    // Act
    Object actualDoOperationResult = exportToLocalFileHandler.doOperation(exportToLocalFile, context, store,
        localFileExporter);

    // Assert
    verify(localFileExporter).add(eq("ALL"), isA(Iterable.class));
    assertNull(actualDoOperationResult);
  }
}
