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

package uk.gov.gchq.gaffer.store.operation.handler.output;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.Element;
import uk.gov.gchq.gaffer.data.generator.MapGenerator;
import uk.gov.gchq.gaffer.operation.OperationException;
import uk.gov.gchq.gaffer.operation.impl.output.ToMap;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl.IterableMap;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.Store;
import uk.gov.gchq.gaffer.store.operation.handler.TestAddToGraphLibraryImpl;

class ToMapHandlerDiffblueTest {
  /**
   * Test {@link ToMapHandler#doOperation(ToMap, Context, Store)} with {@code ToMap}, {@code
   * Context}, {@code Store}.
   *
   * <p>Method under test: {@link ToMapHandler#doOperation(ToMap, Context, Store)}
   */
  @Test
  @DisplayName("Test doOperation(ToMap, Context, Store) with 'ToMap', 'Context', 'Store'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable ToMapHandler.doOperation(ToMap, Context, Store)"})
  void testDoOperationWithToMapContextStore() throws OperationException {
    // Arrange
    ToMapHandler toMapHandler = new ToMapHandler();
    MapGenerator elementGenerator = new MapGenerator();

    ToMap operation = new ToMap(elementGenerator);
    ArrayList<Element> input = new ArrayList<>();
    operation.setInput(input);
    Context context = new Context();
    TestAddToGraphLibraryImpl store = new TestAddToGraphLibraryImpl();

    // Act and Assert
    Iterable<? extends Element> input2 = operation.getInput();
    assertTrue(input2 instanceof List);
    assertTrue(operation.getOutputTypeReference() instanceof IterableMap);
    assertNull(store.getGraphId());
    assertNull(operation.getOptions());
    assertNull(store.getJobTracker());
    assertNull(context.getOriginalOpChain());
    assertNull(store.getProperties());
    assertNull(store.getGraphLibrary());
    assertNull(store.getOriginalSchema());
    assertNull(store.getSchema());
    assertFalse(toMapHandler.doOperation(operation, context, store).iterator().hasNext());
    assertTrue(context.getExporters().isEmpty());
    assertTrue(store.getOperationChainOptimisers().isEmpty());
    assertTrue(((List<? extends Element>) input2).isEmpty());
    assertTrue(context.getVariables().isEmpty());
    assertTrue(store.getSupportedOperations().isEmpty());
    Class<Iterable> expectedOutputClass = Iterable.class;
    assertEquals(expectedOutputClass, operation.getOutputClass());
    assertSame(input, input2);
    assertSame(elementGenerator, operation.getElementGenerator());
  }

  /**
   * Test {@link ToMapHandler#doOperation(ToMap, Context, Store)} with {@code ToMap}, {@code
   * Context}, {@code Store}.
   *
   * <ul>
   *   <li>Then {@link ToMap#ToMap()} OutputTypeReference {@link TypeReferenceImpl.IterableMap}.
   * </ul>
   *
   * <p>Method under test: {@link ToMapHandler#doOperation(ToMap, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(ToMap, Context, Store) with 'ToMap', 'Context', 'Store'; then ToMap() OutputTypeReference IterableMap")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable ToMapHandler.doOperation(ToMap, Context, Store)"})
  void testDoOperationWithToMapContextStore_thenToMapOutputTypeReferenceIterableMap()
      throws OperationException {
    // Arrange
    ToMapHandler toMapHandler = new ToMapHandler();
    ToMap operation = new ToMap();
    Context context = new Context();
    TestAddToGraphLibraryImpl store = new TestAddToGraphLibraryImpl();

    // Act
    Iterable<? extends Map<String, Object>> actualDoOperationResult =
        toMapHandler.doOperation(operation, context, store);

    // Assert
    assertTrue(operation.getOutputTypeReference() instanceof IterableMap);
    assertNull(actualDoOperationResult);
    assertNull(operation.getInput());
    assertNull(store.getGraphId());
    assertNull(operation.getOptions());
    assertNull(operation.getElementGenerator());
    assertNull(store.getJobTracker());
    assertNull(context.getOriginalOpChain());
    assertNull(store.getProperties());
    assertNull(store.getGraphLibrary());
    assertNull(store.getOriginalSchema());
    assertNull(store.getSchema());
    assertTrue(context.getExporters().isEmpty());
    assertTrue(store.getOperationChainOptimisers().isEmpty());
    assertTrue(context.getVariables().isEmpty());
    assertTrue(store.getSupportedOperations().isEmpty());
    Class<Iterable> expectedOutputClass = Iterable.class;
    assertEquals(expectedOutputClass, operation.getOutputClass());
  }
}
