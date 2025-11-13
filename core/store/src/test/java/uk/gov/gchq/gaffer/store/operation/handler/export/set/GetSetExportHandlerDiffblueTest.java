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

package uk.gov.gchq.gaffer.store.operation.handler.export.set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Iterator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.operation.OperationException;
import uk.gov.gchq.gaffer.operation.impl.export.set.GetSetExport;
import uk.gov.gchq.gaffer.operation.impl.export.set.SetExporter;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.Store;
import uk.gov.gchq.gaffer.store.operation.handler.TestAddToGraphLibraryImpl;
import uk.gov.gchq.koryphe.iterable.LimitedIterable;
import uk.gov.gchq.koryphe.iterable.LimitedIterator;

class GetSetExportHandlerDiffblueTest {
  /**
   * Test {@link GetSetExportHandler#getExport(GetSetExport, SetExporter)} with {@code GetSetExport}, {@code SetExporter}.
   * <p>
   * Method under test: {@link GetSetExportHandler#getExport(GetSetExport, SetExporter)}
   */
  @Test
  @DisplayName("Test getExport(GetSetExport, SetExporter) with 'GetSetExport', 'SetExporter'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Iterable GetSetExportHandler.getExport(GetSetExport, SetExporter)"})
  void testGetExportWithGetSetExportSetExporter() throws OperationException {
    // Arrange
    GetSetExportHandler getSetExportHandler = new GetSetExportHandler();
    GetSetExport export = new GetSetExport();

    // Act
    Iterable<?> actualExport = getSetExportHandler.getExport(export, new SetExporter());
    Iterator<?> actualIteratorResult = actualExport.iterator();

    // Assert
    assertTrue(actualExport instanceof LimitedIterable);
    assertTrue(actualIteratorResult instanceof LimitedIterator);
    assertNull(((LimitedIterable<?>) actualExport).getEnd());
    assertEquals(0, ((LimitedIterable<?>) actualExport).getStart());
    assertFalse(actualIteratorResult.hasNext());
  }

  /**
   * Test {@link GetSetExportHandler#createExporter(GetSetExport, Context, Store)} with {@code GetSetExport}, {@code Context}, {@code Store}.
   * <p>
   * Method under test: {@link GetSetExportHandler#createExporter(GetSetExport, Context, Store)}
   */
  @Test
  @DisplayName("Test createExporter(GetSetExport, Context, Store) with 'GetSetExport', 'Context', 'Store'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SetExporter GetSetExportHandler.createExporter(GetSetExport, Context, Store)"})
  void testCreateExporterWithGetSetExportContextStore() {
    // Arrange
    GetSetExportHandler getSetExportHandler = new GetSetExportHandler();
    GetSetExport export = new GetSetExport();
    Context context = new Context();

    // Act and Assert
    Iterable<?> getResult = getSetExportHandler.createExporter(export, context, new TestAddToGraphLibraryImpl())
        .get("Key");
    assertTrue(getResult instanceof LimitedIterable);
    assertNull(((LimitedIterable<?>) getResult).getEnd());
    assertEquals(0, ((LimitedIterable<?>) getResult).getStart());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link GetSetExportHandler}
   *   <li>{@link GetSetExportHandler#getExporterClass()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void GetSetExportHandler.<init>()", "Class GetSetExportHandler.getExporterClass()"})
  void testGettersAndSetters() {
    // Arrange and Act
    Class<SetExporter> actualExporterClass = (new GetSetExportHandler()).getExporterClass();

    // Assert
    Class<SetExporter> expectedExporterClass = SetExporter.class;
    assertEquals(expectedExporterClass, actualExporterClass);
  }
}
