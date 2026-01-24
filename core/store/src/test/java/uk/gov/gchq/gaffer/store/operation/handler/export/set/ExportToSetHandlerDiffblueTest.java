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

package uk.gov.gchq.gaffer.store.operation.handler.export.set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.operation.impl.export.set.ExportToSet;
import uk.gov.gchq.gaffer.operation.impl.export.set.SetExporter;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.Store;
import uk.gov.gchq.gaffer.store.operation.handler.TestAddToGraphLibraryImpl;
import uk.gov.gchq.koryphe.iterable.LimitedIterable;

class ExportToSetHandlerDiffblueTest {
  /**
   * Test {@link ExportToSetHandler#createExporter(ExportToSet, Context, Store)} with {@code
   * ExportToSet}, {@code Context}, {@code Store}.
   *
   * <p>Method under test: {@link ExportToSetHandler#createExporter(ExportToSet, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test createExporter(ExportToSet, Context, Store) with 'ExportToSet', 'Context', 'Store'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SetExporter ExportToSetHandler.createExporter(ExportToSet, Context, Store)"})
  void testCreateExporterWithExportToSetContextStore() {
    // Arrange
    ExportToSetHandler exportToSetHandler = new ExportToSetHandler();
    ExportToSet export = new ExportToSet();
    Context context = new Context();

    // Act and Assert
    Iterable<?> getResult =
        exportToSetHandler
            .createExporter(export, context, new TestAddToGraphLibraryImpl())
            .get("Key");
    assertTrue(getResult instanceof LimitedIterable);
    assertNull(((LimitedIterable<?>) getResult).getEnd());
    assertEquals(0, ((LimitedIterable<?>) getResult).getStart());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link ExportToSetHandler}
   *   <li>{@link ExportToSetHandler#getExporterClass()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ExportToSetHandler.<init>()",
    "Class ExportToSetHandler.getExporterClass()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    Class<SetExporter> actualExporterClass = new ExportToSetHandler().getExporterClass();

    // Assert
    Class<SetExporter> expectedExporterClass = SetExporter.class;
    assertEquals(expectedExporterClass, actualExporterClass);
  }
}
