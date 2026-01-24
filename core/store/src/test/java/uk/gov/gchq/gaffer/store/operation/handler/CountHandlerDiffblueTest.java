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

package uk.gov.gchq.gaffer.store.operation.handler;

import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.operation.OperationException;
import uk.gov.gchq.gaffer.operation.impl.Count;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.Store;

class CountHandlerDiffblueTest {
  /**
   * Test {@link CountHandler#doOperation(Count, Context, Store)} with {@code Count}, {@code
   * Context}, {@code Store}.
   *
   * <ul>
   *   <li>When {@link Count} (default constructor).
   *   <li>Then throw {@link OperationException}.
   * </ul>
   *
   * <p>Method under test: {@link CountHandler#doOperation(Count, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(Count, Context, Store) with 'Count', 'Context', 'Store'; when Count (default constructor); then throw OperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Long CountHandler.doOperation(Count, Context, Store)"})
  void testDoOperationWithCountContextStore_whenCount_thenThrowOperationException()
      throws OperationException {
    // Arrange
    CountHandler<Object> countHandler = new CountHandler<>();
    Count operation = new Count();
    Context context = new Context();

    // Act and Assert
    assertThrows(
        OperationException.class,
        () -> countHandler.doOperation(operation, context, new TestAddToGraphLibraryImpl()));
  }
}
