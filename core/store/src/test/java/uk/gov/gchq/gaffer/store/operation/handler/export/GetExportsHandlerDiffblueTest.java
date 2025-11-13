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

package uk.gov.gchq.gaffer.store.operation.handler.export;

import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.operation.OperationException;
import uk.gov.gchq.gaffer.operation.impl.export.GetExports;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.Store;
import uk.gov.gchq.gaffer.store.operation.handler.TestAddToGraphLibraryImpl;

class GetExportsHandlerDiffblueTest {
  /**
   * Test {@link GetExportsHandler#doOperation(GetExports, Context, Store)} with {@code GetExports},
   * {@code Context}, {@code Store}.
   *
   * <ul>
   *   <li>When {@link GetExports} (default constructor).
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link GetExportsHandler#doOperation(GetExports, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(GetExports, Context, Store) with 'GetExports', 'Context', 'Store'; when GetExports (default constructor); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Map GetExportsHandler.doOperation(GetExports, Context, Store)"})
  void testDoOperationWithGetExportsContextStore_whenGetExports_thenReturnEmpty()
      throws OperationException {
    // Arrange
    GetExportsHandler getExportsHandler = new GetExportsHandler();
    GetExports getExports = new GetExports();
    Context context = new Context();

    // Act and Assert
    assertTrue(
        getExportsHandler
            .doOperation(getExports, context, new TestAddToGraphLibraryImpl())
            .isEmpty());
  }
}
