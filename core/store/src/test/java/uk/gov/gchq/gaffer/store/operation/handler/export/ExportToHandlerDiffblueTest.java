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
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uk.gov.gchq.gaffer.operation.OperationException;
import uk.gov.gchq.gaffer.operation.export.ExportTo;
import uk.gov.gchq.gaffer.operation.export.Exporter;
import uk.gov.gchq.gaffer.operation.impl.export.localfile.ExportToLocalFile;
import uk.gov.gchq.gaffer.operation.impl.export.localfile.LocalFileExporter;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.Store;
import uk.gov.gchq.gaffer.store.operation.handler.export.localfile.ExportToLocalFileHandler;

class ExportToHandlerDiffblueTest {
  /**
   * Method under test:
   * {@link ExportToHandler#doOperation(ExportTo, Context, Store, Exporter)}
   */
  @Test
  void testDoOperation() throws OperationException {
    // Arrange
    ExportToLocalFileHandler exportToLocalFileHandler = new ExportToLocalFileHandler();
    ExportToLocalFile exportToLocalFile = mock(ExportToLocalFile.class);
    when(exportToLocalFile.getKeyOrDefault()).thenReturn("Key Or Default");
    Context context = new Context();
    LocalFileExporter localFileExporter = mock(LocalFileExporter.class);
    doNothing().when(localFileExporter).add(Mockito.<String>any(), Mockito.<Iterable<Object>>any());

    // Act
    Object actualDoOperationResult = exportToLocalFileHandler.doOperation(exportToLocalFile, context, null,
        localFileExporter);

    // Assert
    verify(exportToLocalFile).getKeyOrDefault();
    verify(localFileExporter).add(eq("Key Or Default"), isA(Iterable.class));
    assertNull(actualDoOperationResult);
  }
}
