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

package uk.gov.gchq.gaffer.store.operation.handler;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.function.Function;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uk.gov.gchq.gaffer.operation.OperationException;
import uk.gov.gchq.gaffer.operation.impl.Map;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.Store;

class MapHandlerDiffblueTest {
  /**
   * Method under test: {@link MapHandler#doOperation(Map, Context, Store)}
   */
  @Test
  void testDoOperation() throws OperationException {
    // Arrange
    MapHandler<Object, Object> mapHandler = new MapHandler<>();
    Map<Object, Object> operation = new Map<>();

    // Act and Assert
    assertThrows(OperationException.class, () -> mapHandler.doOperation(operation, new Context(), null));
  }

  /**
   * Method under test: {@link MapHandler#doOperation(Map, Context, Store)}
   */
  @Test
  void testDoOperation2() throws OperationException {
    // Arrange
    MapHandler<Object, Object> mapHandler = new MapHandler<>();

    // Act and Assert
    assertThrows(OperationException.class, () -> mapHandler.doOperation(null, new Context(), null));
  }

  /**
   * Method under test: {@link MapHandler#doOperation(Map, Context, Store)}
   */
  @Test
  void testDoOperation3() throws OperationException {
    // Arrange
    MapHandler<Object, Object> mapHandler = new MapHandler<>();

    ArrayList<Function> funcs = new ArrayList<>();
    funcs.add(null);

    Map<Object, Object> operation = new Map<>();
    operation.setInput("Operation");
    operation.setFunctions(funcs);

    // Act and Assert
    assertThrows(OperationException.class, () -> mapHandler.doOperation(operation, new Context(), null));
  }

  /**
   * Method under test: {@link MapHandler#doOperation(Map, Context, Store)}
   */
  @Test
  void testDoOperation4() throws OperationException {
    // Arrange
    MapHandler<Object, Object> mapHandler = new MapHandler<>();
    Function function = mock(Function.class);
    when(function.apply(Mockito.<Object>any())).thenReturn("Apply");

    ArrayList<Function> funcs = new ArrayList<>();
    funcs.add(function);

    Map<Object, Object> operation = new Map<>();
    operation.setInput("Operation");
    operation.setFunctions(funcs);

    // Act
    Object actualDoOperationResult = mapHandler.doOperation(operation, new Context(), null);

    // Assert
    verify(function).apply(isA(Object.class));
    assertEquals("Apply", actualDoOperationResult);
  }
}
