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

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.named.operation.NamedOperation;
import uk.gov.gchq.gaffer.operation.OperationChain;
import uk.gov.gchq.gaffer.operation.OperationException;
import uk.gov.gchq.gaffer.operation.impl.ForEach;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.Store;

class ForEachHandlerDiffblueTest {
  /**
   * Test {@link ForEachHandler#doOperation(ForEach, Context, Store)} with {@code ForEach}, {@code
   * Context}, {@code Store}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>Then return {@link List}.
   * </ul>
   *
   * <p>Method under test: {@link ForEachHandler#doOperation(ForEach, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(ForEach, Context, Store) with 'ForEach', 'Context', 'Store'; given ArrayList(); then return List")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable ForEachHandler.doOperation(ForEach, Context, Store)"})
  void testDoOperationWithForEachContextStore_givenArrayList_thenReturnList()
      throws OperationException {
    // Arrange
    ForEachHandler<Object, Object> forEachHandler = new ForEachHandler<>();

    ForEach<Object, Object> forEach = new ForEach<>();
    OperationChain<Object> operation = OperationChain.wrap(new NamedOperation<>());
    forEach.setOperation(operation);
    forEach.setInput(new ArrayList<>());
    Context context = new Context();

    // Act
    Iterable<?> actualDoOperationResult =
        forEachHandler.doOperation(forEach, context, new TestAddToGraphLibraryImpl());
    Iterator<?> actualIteratorResult = actualDoOperationResult.iterator();

    // Assert
    assertTrue(actualDoOperationResult instanceof List);
    assertFalse(actualIteratorResult.hasNext());
    assertTrue(((List<?>) actualDoOperationResult).isEmpty());
  }
}
