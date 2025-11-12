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
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.List;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.operation.OperationException;
import uk.gov.gchq.gaffer.operation.impl.output.ToSingletonList;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.Store;

class ToSingletonListHandlerDiffblueTest {
  /**
   * Method under test:
   * {@link ToSingletonListHandler#doOperation(ToSingletonList, Context, Store)}
   */
  @Test
  void testDoOperation() throws OperationException {
    // Arrange
    ToSingletonListHandler<Object> toSingletonListHandler = new ToSingletonListHandler<>();
    ToSingletonList<Object> operation = new ToSingletonList<>();

    // Act and Assert
    assertThrows(OperationException.class, () -> toSingletonListHandler.doOperation(operation, new Context(), null));
  }

  /**
   * Method under test:
   * {@link ToSingletonListHandler#doOperation(ToSingletonList, Context, Store)}
   */
  @Test
  void testDoOperation2() throws OperationException {
    // Arrange
    ToSingletonListHandler<Object> toSingletonListHandler = new ToSingletonListHandler<>();

    ToSingletonList<Object> operation = new ToSingletonList<>();
    operation.setInput("Operation");

    // Act
    List<?> actualDoOperationResult = toSingletonListHandler.doOperation(operation, new Context(), null);

    // Assert
    assertEquals(1, actualDoOperationResult.size());
    assertEquals("Operation", actualDoOperationResult.get(0));
  }
}
