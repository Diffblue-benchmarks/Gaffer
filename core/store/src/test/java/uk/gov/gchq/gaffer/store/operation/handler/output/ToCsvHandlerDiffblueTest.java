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

package uk.gov.gchq.gaffer.store.operation.handler.output;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.operation.OperationException;
import uk.gov.gchq.gaffer.operation.impl.output.ToCsv;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.Store;
import uk.gov.gchq.gaffer.store.operation.handler.TestAddToGraphLibraryImpl;

class ToCsvHandlerDiffblueTest {
  /**
   * Test {@link ToCsvHandler#doOperation(ToCsv, Context, Store)} with {@code ToCsv}, {@code
   * Context}, {@code Store}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ToCsvHandler#doOperation(ToCsv, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(ToCsv, Context, Store) with 'ToCsv', 'Context', 'Store'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Iterable ToCsvHandler.doOperation(ToCsv, Context, Store)"})
  void testDoOperationWithToCsvContextStore_thenThrowIllegalArgumentException()
      throws OperationException {
    // Arrange
    ToCsvHandler toCsvHandler = new ToCsvHandler();

    ToCsv operation = new ToCsv();
    operation.setInput(new ArrayList<>());
    Context context = new Context();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> toCsvHandler.doOperation(operation, context, new TestAddToGraphLibraryImpl()));
  }

  /**
   * Test {@link ToCsvHandler#doOperation(ToCsv, Context, Store)} with {@code ToCsv}, {@code
   * Context}, {@code Store}.
   *
   * <ul>
   *   <li>When {@link ToCsv} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ToCsvHandler#doOperation(ToCsv, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(ToCsv, Context, Store) with 'ToCsv', 'Context', 'Store'; when ToCsv (default constructor); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Iterable ToCsvHandler.doOperation(ToCsv, Context, Store)"})
  void testDoOperationWithToCsvContextStore_whenToCsv_thenReturnNull() throws OperationException {
    // Arrange
    ToCsvHandler toCsvHandler = new ToCsvHandler();
    ToCsv operation = new ToCsv();
    Context context = new Context();

    // Act and Assert
    assertNull(toCsvHandler.doOperation(operation, context, new TestAddToGraphLibraryImpl()));
  }
}
