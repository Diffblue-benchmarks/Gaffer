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
import static org.mockito.Mockito.mock;
import java.util.HashMap;
import java.util.function.BiFunction;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.operation.OperationException;
import uk.gov.gchq.gaffer.operation.impl.output.ToList;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.Store;

class ToListHandlerDiffblueTest {
  /**
   * Method under test: {@link ToListHandler#doOperation(ToList, Context, Store)}
   */
  @Test
  void testDoOperation() throws OperationException {
    // Arrange
    ToListHandler<Object> toListHandler = new ToListHandler<>();
    ToList<Object> operation = new ToList<>();

    // Act and Assert
    assertNull(toListHandler.doOperation(operation, new Context(), null));
  }

  /**
   * Method under test: {@link ToListHandler#doOperation(ToList, Context, Store)}
   */
  @Test
  void testDoOperation2() throws OperationException {
    // Arrange
    ToListHandler<Object> toListHandler = new ToListHandler<>();
    ToList<Object> operation = new ToList<>();

    HashMap<String, Object> variables = new HashMap<>();
    variables.computeIfPresent("foo", mock(BiFunction.class));

    Context context = new Context();
    context.addVariables(variables);

    // Act and Assert
    assertNull(toListHandler.doOperation(operation, context, null));
  }
}
