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

package uk.gov.gchq.gaffer.store.operation.handler.named;

import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.named.operation.NamedOperation;
import uk.gov.gchq.gaffer.operation.OperationException;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.Store;
import uk.gov.gchq.gaffer.store.operation.handler.TestAddToGraphLibraryImpl;

class NamedOperationHandlerDiffblueTest {
  /**
   * Test {@link NamedOperationHandler#doOperation(NamedOperation, Context, Store)} with {@code
   * NamedOperation}, {@code Context}, {@code Store}.
   *
   * <p>Method under test: {@link NamedOperationHandler#doOperation(NamedOperation, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(NamedOperation, Context, Store) with 'NamedOperation', 'Context', 'Store'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object NamedOperationHandler.doOperation(NamedOperation, Context, Store)"})
  void testDoOperationWithNamedOperationContextStore() throws OperationException {
    // Arrange
    NamedOperationHandler namedOperationHandler = new NamedOperationHandler();
    NamedOperation<?, Object> operation = new NamedOperation<>();
    Context context = new Context();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            namedOperationHandler.doOperation(operation, context, new TestAddToGraphLibraryImpl()));
  }
}
