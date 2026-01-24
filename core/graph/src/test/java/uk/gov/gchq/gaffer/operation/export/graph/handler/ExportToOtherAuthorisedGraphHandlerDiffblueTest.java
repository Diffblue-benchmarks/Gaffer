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

package uk.gov.gchq.gaffer.operation.export.graph.handler;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.operation.export.graph.OtherGraphExporter;

class ExportToOtherAuthorisedGraphHandlerDiffblueTest {
  /**
   * Test {@link ExportToOtherAuthorisedGraphHandler#setIdAuths(Map)}.
   *
   * <ul>
   *   <li>Then {@link ExportToOtherAuthorisedGraphHandler} (default constructor) IdAuths is {@link
   *       HashMap#HashMap()}.
   * </ul>
   *
   * <p>Method under test: {@link ExportToOtherAuthorisedGraphHandler#setIdAuths(Map)}
   */
  @Test
  @DisplayName(
      "Test setIdAuths(Map); then ExportToOtherAuthorisedGraphHandler (default constructor) IdAuths is HashMap()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ExportToOtherAuthorisedGraphHandler.setIdAuths(Map)"})
  void testSetIdAuths_thenExportToOtherAuthorisedGraphHandlerIdAuthsIsHashMap() {
    // Arrange
    ExportToOtherAuthorisedGraphHandler exportToOtherAuthorisedGraphHandler =
        new ExportToOtherAuthorisedGraphHandler();
    HashMap<String, List<String>> idAuths = new HashMap<>();

    // Act
    exportToOtherAuthorisedGraphHandler.setIdAuths(idAuths);

    // Assert
    assertSame(idAuths, exportToOtherAuthorisedGraphHandler.getIdAuths());
  }

  /**
   * Test {@link ExportToOtherAuthorisedGraphHandler#setIdAuths(Map)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link ExportToOtherAuthorisedGraphHandler} (default constructor) IdAuths Empty.
   * </ul>
   *
   * <p>Method under test: {@link ExportToOtherAuthorisedGraphHandler#setIdAuths(Map)}
   */
  @Test
  @DisplayName(
      "Test setIdAuths(Map); when 'null'; then ExportToOtherAuthorisedGraphHandler (default constructor) IdAuths Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ExportToOtherAuthorisedGraphHandler.setIdAuths(Map)"})
  void testSetIdAuths_whenNull_thenExportToOtherAuthorisedGraphHandlerIdAuthsEmpty() {
    // Arrange
    ExportToOtherAuthorisedGraphHandler exportToOtherAuthorisedGraphHandler =
        new ExportToOtherAuthorisedGraphHandler();

    // Act
    exportToOtherAuthorisedGraphHandler.setIdAuths(null);

    // Assert that nothing has changed
    assertTrue(exportToOtherAuthorisedGraphHandler.getIdAuths().isEmpty());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link ExportToOtherAuthorisedGraphHandler}
   *   <li>{@link ExportToOtherAuthorisedGraphHandler#getExporterClass()}
   *   <li>{@link ExportToOtherAuthorisedGraphHandler#getIdAuths()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ExportToOtherAuthorisedGraphHandler.<init>()",
    "Class ExportToOtherAuthorisedGraphHandler.getExporterClass()",
    "Map ExportToOtherAuthorisedGraphHandler.getIdAuths()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    ExportToOtherAuthorisedGraphHandler actualExportToOtherAuthorisedGraphHandler =
        new ExportToOtherAuthorisedGraphHandler();
    Class<OtherGraphExporter> actualExporterClass =
        actualExportToOtherAuthorisedGraphHandler.getExporterClass();

    // Assert
    assertTrue(actualExportToOtherAuthorisedGraphHandler.getIdAuths().isEmpty());
    Class<OtherGraphExporter> expectedExporterClass = OtherGraphExporter.class;
    assertEquals(expectedExporterClass, actualExporterClass);
  }
}
