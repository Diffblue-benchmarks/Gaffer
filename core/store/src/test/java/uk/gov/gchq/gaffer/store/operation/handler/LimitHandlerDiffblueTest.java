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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.operation.OperationException;
import uk.gov.gchq.gaffer.operation.impl.Limit;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.Store;
import uk.gov.gchq.koryphe.iterable.LimitedIterable;
import uk.gov.gchq.koryphe.iterable.LimitedIterator;

class LimitHandlerDiffblueTest {
  /**
   * Test {@link LimitHandler#doOperation(Limit, Context, Store)} with {@code Limit}, {@code Context}, {@code Store}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@link LimitedIterable}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LimitHandler#doOperation(Limit, Context, Store)}
   */
  @Test
  @DisplayName("Test doOperation(Limit, Context, Store) with 'Limit', 'Context', 'Store'; given ArrayList(); then return LimitedIterable")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Iterable LimitHandler.doOperation(Limit, Context, Store)"})
  void testDoOperationWithLimitContextStore_givenArrayList_thenReturnLimitedIterable() throws OperationException {
    // Arrange
    LimitHandler<Object> limitHandler = new LimitHandler<>();

    Limit<Object> operation = new Limit<>();
    operation.setInput(new ArrayList<>());
    operation.setResultLimit(0);
    Context context = new Context();

    // Act
    Iterable<?> actualDoOperationResult = limitHandler.doOperation(operation, context, new TestAddToGraphLibraryImpl());

    // Assert
    assertTrue(actualDoOperationResult instanceof LimitedIterable);
    assertTrue(actualDoOperationResult.iterator() instanceof LimitedIterator);
    assertEquals(0, ((LimitedIterable<?>) actualDoOperationResult).getEnd().intValue());
    assertEquals(0, ((LimitedIterable<?>) actualDoOperationResult).getStart());
  }

  /**
   * Test {@link LimitHandler#doOperation(Limit, Context, Store)} with {@code Limit}, {@code Context}, {@code Store}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@link List}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LimitHandler#doOperation(Limit, Context, Store)}
   */
  @Test
  @DisplayName("Test doOperation(Limit, Context, Store) with 'Limit', 'Context', 'Store'; given ArrayList(); then return List")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Iterable LimitHandler.doOperation(Limit, Context, Store)"})
  void testDoOperationWithLimitContextStore_givenArrayList_thenReturnList() throws OperationException {
    // Arrange
    LimitHandler<Object> limitHandler = new LimitHandler<>();

    Limit<Object> operation = new Limit<>();
    operation.setInput(new ArrayList<>());
    operation.setResultLimit(null);
    Context context = new Context();

    // Act
    Iterable<?> actualDoOperationResult = limitHandler.doOperation(operation, context, new TestAddToGraphLibraryImpl());

    // Assert
    assertTrue(actualDoOperationResult instanceof List);
    assertFalse(actualDoOperationResult.iterator().hasNext());
    assertTrue(((List<?>) actualDoOperationResult).isEmpty());
  }
}
