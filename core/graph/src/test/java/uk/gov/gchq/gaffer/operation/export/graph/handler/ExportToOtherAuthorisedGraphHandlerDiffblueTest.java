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

package uk.gov.gchq.gaffer.operation.export.graph.handler;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.operation.export.graph.OtherGraphExporter;

class ExportToOtherAuthorisedGraphHandlerDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ExportToOtherAuthorisedGraphHandler}
   *   <li>{@link ExportToOtherAuthorisedGraphHandler#getExporterClass()}
   *   <li>{@link ExportToOtherAuthorisedGraphHandler#getIdAuths()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    ExportToOtherAuthorisedGraphHandler actualExportToOtherAuthorisedGraphHandler = new ExportToOtherAuthorisedGraphHandler();
    Class<OtherGraphExporter> actualExporterClass = actualExportToOtherAuthorisedGraphHandler.getExporterClass();

    // Assert
    assertTrue(actualExportToOtherAuthorisedGraphHandler.getIdAuths().isEmpty());
    Class<OtherGraphExporter> expectedExporterClass = OtherGraphExporter.class;
    assertEquals(expectedExporterClass, actualExporterClass);
  }

  /**
   * Method under test:
   * {@link ExportToOtherAuthorisedGraphHandler#setIdAuths(Map)}
   */
  @Test
  void testSetIdAuths() {
    // Arrange
    ExportToOtherAuthorisedGraphHandler exportToOtherAuthorisedGraphHandler = new ExportToOtherAuthorisedGraphHandler();
    HashMap<String, List<String>> idAuths = new HashMap<>();

    // Act
    exportToOtherAuthorisedGraphHandler.setIdAuths(idAuths);

    // Assert
    assertSame(idAuths, exportToOtherAuthorisedGraphHandler.getIdAuths());
  }

  /**
   * Method under test:
   * {@link ExportToOtherAuthorisedGraphHandler#setIdAuths(Map)}
   */
  @Test
  void testSetIdAuths2() {
    // Arrange
    ExportToOtherAuthorisedGraphHandler exportToOtherAuthorisedGraphHandler = new ExportToOtherAuthorisedGraphHandler();

    // Act
    exportToOtherAuthorisedGraphHandler.setIdAuths(null);

    // Assert
    assertTrue(exportToOtherAuthorisedGraphHandler.getIdAuths().isEmpty());
  }

  /**
   * Method under test:
   * {@link ExportToOtherAuthorisedGraphHandler#setIdAuths(Map)}
   */
  @Test
  void testSetIdAuths3() {
    // Arrange
    ExportToOtherAuthorisedGraphHandler exportToOtherAuthorisedGraphHandler = new ExportToOtherAuthorisedGraphHandler();

    HashMap<String, List<String>> idAuths = new HashMap<>();
    idAuths.computeIfPresent("foo", mock(BiFunction.class));

    // Act
    exportToOtherAuthorisedGraphHandler.setIdAuths(idAuths);

    // Assert
    assertSame(idAuths, exportToOtherAuthorisedGraphHandler.getIdAuths());
  }
}
