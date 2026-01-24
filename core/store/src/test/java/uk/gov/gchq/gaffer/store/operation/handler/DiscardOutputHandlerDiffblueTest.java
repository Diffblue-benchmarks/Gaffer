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

import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.operation.OperationException;
import uk.gov.gchq.gaffer.operation.impl.DiscardOutput;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.Store;

class DiscardOutputHandlerDiffblueTest {
  /**
   * Test {@link DiscardOutputHandler#doOperation(DiscardOutput, Context, Store)} with {@code
   * DiscardOutput}, {@code Context}, {@code Store}.
   *
   * <p>Method under test: {@link DiscardOutputHandler#doOperation(DiscardOutput, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(DiscardOutput, Context, Store) with 'DiscardOutput', 'Context', 'Store'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Void DiscardOutputHandler.doOperation(DiscardOutput, Context, Store)"
  })
  void testDoOperationWithDiscardOutputContextStore() throws OperationException {
    // Arrange
    DiscardOutputHandler discardOutputHandler = new DiscardOutputHandler();
    DiscardOutput operation = new DiscardOutput();
    Context context = new Context();

    // Act and Assert
    assertNull(
        discardOutputHandler.doOperation(operation, context, new TestAddToGraphLibraryImpl()));
  }
}
