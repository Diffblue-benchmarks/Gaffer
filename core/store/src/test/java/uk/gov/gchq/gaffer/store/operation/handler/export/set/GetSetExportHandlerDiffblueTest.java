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
import static org.mockito.Mockito.mock;
import java.util.HashMap;
import java.util.Iterator;
import java.util.function.BiFunction;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.operation.OperationException;
import uk.gov.gchq.gaffer.operation.impl.export.set.GetSetExport;
import uk.gov.gchq.gaffer.operation.impl.export.set.SetExporter;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.Store;
import uk.gov.gchq.koryphe.iterable.LimitedIterable;
import uk.gov.gchq.koryphe.iterable.LimitedIterator;

class GetSetExportHandlerDiffblueTest {
  /**
   * Method under test:
   * {@link GetSetExportHandler#getExport(GetSetExport, SetExporter)}
   */
  @Test
  void testGetExport() throws OperationException {
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
   * Method under test:
   * {@link GetSetExportHandler#getExport(GetSetExport, SetExporter)}
   */
  @Test
  void testGetExport2() throws OperationException {
    // Arrange
    GetSetExportHandler getSetExportHandler = new GetSetExportHandler();

    HashMap<String, String> options = new HashMap<>();
    options.computeIfPresent("foo", mock(BiFunction.class));

    GetSetExport export = new GetSetExport();
    export.setOptions(options);

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
   * Method under test:
   * {@link GetSetExportHandler#createExporter(GetSetExport, Context, Store)}
   */
  @Test
  void testCreateExporter() {
    // Arrange
    GetSetExportHandler getSetExportHandler = new GetSetExportHandler();
    GetSetExport export = new GetSetExport();

    // Act and Assert
    Iterable<?> getResult = getSetExportHandler.createExporter(export, new Context(), null).get("Key");
    assertTrue(getResult instanceof LimitedIterable);
    assertNull(((LimitedIterable<?>) getResult).getEnd());
    assertEquals(0, ((LimitedIterable<?>) getResult).getStart());
  }

  /**
   * Method under test:
   * {@link GetSetExportHandler#createExporter(GetSetExport, Context, Store)}
   */
  @Test
  void testCreateExporter2() {
    // Arrange
    GetSetExportHandler getSetExportHandler = new GetSetExportHandler();
    GetSetExport export = new GetSetExport();

    HashMap<String, Object> variables = new HashMap<>();
    variables.computeIfPresent("foo", mock(BiFunction.class));

    Context context = new Context();
    context.addVariables(variables);

    // Act and Assert
    Iterable<?> getResult = getSetExportHandler.createExporter(export, context, null).get("Key");
    assertTrue(getResult instanceof LimitedIterable);
    assertNull(((LimitedIterable<?>) getResult).getEnd());
    assertEquals(0, ((LimitedIterable<?>) getResult).getStart());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link GetSetExportHandler}
   *   <li>{@link GetSetExportHandler#getExporterClass()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    Class<SetExporter> actualExporterClass = (new GetSetExportHandler()).getExporterClass();

    // Assert
    Class<SetExporter> expectedExporterClass = SetExporter.class;
    assertEquals(expectedExporterClass, actualExporterClass);
  }
}
