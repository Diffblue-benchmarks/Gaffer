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
import uk.gov.gchq.gaffer.operation.export.Export;
import uk.gov.gchq.gaffer.operation.impl.export.localfile.ExportToLocalFile;
import uk.gov.gchq.gaffer.operation.impl.export.localfile.LocalFileExporter;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.Store;
import uk.gov.gchq.gaffer.store.operation.handler.export.localfile.ExportToLocalFileHandler;

class ExportOperationHandlerDiffblueTest {
  /**
   * Method under test:
   * {@link ExportOperationHandler#doOperation(Export, Context, Store)}
   */
  @Test
  void testDoOperation() throws OperationException {
    // Arrange
    ExportToLocalFileHandler exportToLocalFileHandler = new ExportToLocalFileHandler();
    ExportToLocalFile exportToLocalFile = mock(ExportToLocalFile.class);
    when(exportToLocalFile.getKeyOrDefault()).thenReturn("Key Or Default");
    LocalFileExporter localFileExporter = mock(LocalFileExporter.class);
    doNothing().when(localFileExporter).add(Mockito.<String>any(), Mockito.<Iterable<Object>>any());
    Context context = mock(Context.class);
    when(context.getExporter(Mockito.<Class<LocalFileExporter>>any())).thenReturn(localFileExporter);

    // Act
    Object actualDoOperationResult = exportToLocalFileHandler.doOperation(exportToLocalFile, context, null);

    // Assert
    verify(exportToLocalFile).getKeyOrDefault();
    verify(localFileExporter).add(eq("Key Or Default"), isA(Iterable.class));
    verify(context).getExporter(isA(Class.class));
    assertNull(actualDoOperationResult);
  }

  /**
   * Method under test:
   * {@link ExportOperationHandler#doOperation(Export, Context, Store)}
   */
  @Test
  void testDoOperation2() throws OperationException {
    // Arrange
    ExportToLocalFileHandler exportToLocalFileHandler = new ExportToLocalFileHandler();
    ExportToLocalFile exportToLocalFile = mock(ExportToLocalFile.class);
    when(exportToLocalFile.getKeyOrDefault()).thenReturn("Key Or Default");
    LocalFileExporter exporter = mock(LocalFileExporter.class);
    doNothing().when(exporter).add(Mockito.<String>any(), Mockito.<Iterable<Object>>any());

    Context context = new Context();
    context.addExporter(exporter);

    // Act
    Object actualDoOperationResult = exportToLocalFileHandler.doOperation(exportToLocalFile, context, null);

    // Assert
    verify(exportToLocalFile).getKeyOrDefault();
    verify(exporter).add(eq("Key Or Default"), isA(Iterable.class));
    assertNull(actualDoOperationResult);
  }
}
