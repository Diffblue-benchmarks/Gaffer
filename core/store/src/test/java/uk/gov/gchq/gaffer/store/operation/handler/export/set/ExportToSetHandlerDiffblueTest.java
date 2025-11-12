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
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.HashMap;
import java.util.function.BiFunction;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.operation.impl.export.set.ExportToSet;
import uk.gov.gchq.gaffer.operation.impl.export.set.SetExporter;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.Store;
import uk.gov.gchq.koryphe.iterable.LimitedIterable;

class ExportToSetHandlerDiffblueTest {
  /**
   * Method under test:
   * {@link ExportToSetHandler#createExporter(ExportToSet, Context, Store)}
   */
  @Test
  void testCreateExporter() {
    // Arrange
    ExportToSetHandler exportToSetHandler = new ExportToSetHandler();
    ExportToSet export = new ExportToSet();

    // Act and Assert
    Iterable<?> getResult = exportToSetHandler.createExporter(export, new Context(), null).get("Key");
    assertTrue(getResult instanceof LimitedIterable);
    assertNull(((LimitedIterable<?>) getResult).getEnd());
    assertEquals(0, ((LimitedIterable<?>) getResult).getStart());
  }

  /**
   * Method under test:
   * {@link ExportToSetHandler#createExporter(ExportToSet, Context, Store)}
   */
  @Test
  void testCreateExporter2() {
    // Arrange
    ExportToSetHandler exportToSetHandler = new ExportToSetHandler();
    ExportToSet export = new ExportToSet();

    HashMap<String, Object> variables = new HashMap<>();
    variables.computeIfPresent("foo", mock(BiFunction.class));

    Context context = new Context();
    context.addVariables(variables);

    // Act and Assert
    Iterable<?> getResult = exportToSetHandler.createExporter(export, context, null).get("Key");
    assertTrue(getResult instanceof LimitedIterable);
    assertNull(((LimitedIterable<?>) getResult).getEnd());
    assertEquals(0, ((LimitedIterable<?>) getResult).getStart());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link ExportToSetHandler}
   *   <li>{@link ExportToSetHandler#getExporterClass()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    Class<SetExporter> actualExporterClass = (new ExportToSetHandler()).getExporterClass();

    // Assert
    Class<SetExporter> expectedExporterClass = SetExporter.class;
    assertEquals(expectedExporterClass, actualExporterClass);
  }
}
