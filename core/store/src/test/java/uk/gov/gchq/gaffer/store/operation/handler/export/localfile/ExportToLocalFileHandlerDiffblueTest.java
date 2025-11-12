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

package uk.gov.gchq.gaffer.store.operation.handler.export.localfile;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.operation.impl.export.localfile.LocalFileExporter;

class ExportToLocalFileHandlerDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link ExportToLocalFileHandler}
   *   <li>{@link ExportToLocalFileHandler#getExporterClass()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    Class<LocalFileExporter> actualExporterClass = (new ExportToLocalFileHandler()).getExporterClass();

    // Assert
    Class<LocalFileExporter> expectedExporterClass = LocalFileExporter.class;
    assertEquals(expectedExporterClass, actualExporterClass);
  }
}
