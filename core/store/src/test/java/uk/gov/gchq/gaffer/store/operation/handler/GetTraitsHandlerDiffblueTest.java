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

import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashSet;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.operation.OperationException;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.Store;
import uk.gov.gchq.gaffer.store.operation.GetTraits;

class GetTraitsHandlerDiffblueTest {
  /**
   * Test {@link GetTraitsHandler#doOperation(GetTraits, Context, Store)} with {@code GetTraits}, {@code Context}, {@code Store}.
   * <ul>
   *   <li>Given {@code false}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link GetTraitsHandler#doOperation(GetTraits, Context, Store)}
   */
  @Test
  @DisplayName("Test doOperation(GetTraits, Context, Store) with 'GetTraits', 'Context', 'Store'; given 'false'; then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Set GetTraitsHandler.doOperation(GetTraits, Context, Store)"})
  void testDoOperationWithGetTraitsContextStore_givenFalse_thenReturnEmpty() throws OperationException {
    // Arrange
    GetTraitsHandler getTraitsHandler = new GetTraitsHandler(new HashSet<>());

    GetTraits operation = new GetTraits();
    operation.setCurrentTraits(false);
    Context context = new Context();

    // Act and Assert
    assertTrue(getTraitsHandler.doOperation(operation, context, new TestAddToGraphLibraryImpl()).isEmpty());
  }
}
