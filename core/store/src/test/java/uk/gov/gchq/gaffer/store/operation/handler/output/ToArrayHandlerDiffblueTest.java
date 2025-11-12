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

import static org.junit.jupiter.api.Assertions.assertNull;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.operation.OperationException;
import uk.gov.gchq.gaffer.operation.impl.output.ToArray;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.Store;

class ToArrayHandlerDiffblueTest {
  /**
   * Method under test:
   * {@link ToArrayHandler#doOperation(ToArray, Context, Store)}
   */
  @Test
  void testDoOperation() throws OperationException {
    // Arrange
    ToArrayHandler<Object> toArrayHandler = new ToArrayHandler<>();
    ToArray<Object> operation = new ToArray<>();

    // Act and Assert
    assertNull(toArrayHandler.doOperation(operation, new Context(), null));
  }

  /**
   * Method under test:
   * {@link ToArrayHandler#doOperation(ToArray, Context, Store)}
   */
  @Test
  void testDoOperation2() throws OperationException {
    // Arrange
    ToArrayHandler<Object> toArrayHandler = new ToArrayHandler<>();

    ToArray<Object> operation = new ToArray<>();
    operation.setInput(new ArrayList<>());

    // Act and Assert
    assertNull(toArrayHandler.doOperation(operation, new Context(), null));
  }

  /**
   * Method under test:
   * {@link ToArrayHandler#doOperation(ToArray, Context, Store)}
   */
  @Test
  void testDoOperation3() throws OperationException {
    // Arrange
    ToArrayHandler<Object> toArrayHandler = new ToArrayHandler<>();

    LinkedHashSet<?> input = new LinkedHashSet<>();
    input.add(null);

    ToArray<Object> operation = new ToArray<>();
    operation.setInput(input);

    // Act and Assert
    assertNull(toArrayHandler.doOperation(operation, new Context(), null));
  }
}
