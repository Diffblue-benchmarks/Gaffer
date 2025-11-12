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

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.operation.OperationException;
import uk.gov.gchq.gaffer.operation.impl.Count;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.Store;

class CountHandlerDiffblueTest {
  /**
   * Method under test: {@link CountHandler#doOperation(Count, Context, Store)}
   */
  @Test
  void testDoOperation() throws OperationException {
    // Arrange
    CountHandler<Object> countHandler = new CountHandler<>();
    Count operation = new Count();

    // Act and Assert
    assertThrows(OperationException.class, () -> countHandler.doOperation(operation, new Context(), null));
  }
}
