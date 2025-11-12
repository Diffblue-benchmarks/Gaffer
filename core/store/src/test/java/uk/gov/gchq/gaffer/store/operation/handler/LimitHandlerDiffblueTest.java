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
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.operation.OperationException;
import uk.gov.gchq.gaffer.operation.impl.Limit;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.Store;
import uk.gov.gchq.koryphe.iterable.LimitedIterable;
import uk.gov.gchq.koryphe.iterable.LimitedIterator;

class LimitHandlerDiffblueTest {
  /**
   * Method under test: {@link LimitHandler#doOperation(Limit, Context, Store)}
   */
  @Test
  void testDoOperation() throws OperationException {
    // Arrange
    LimitHandler<Object> limitHandler = new LimitHandler<>();

    Limit<Object> operation = new Limit<>();
    operation.setInput(new ArrayList<>());
    operation.setResultLimit(null);

    // Act
    Iterable<?> actualDoOperationResult = limitHandler.doOperation(operation, new Context(), null);

    // Assert
    assertTrue(actualDoOperationResult instanceof List);
    assertFalse(actualDoOperationResult.iterator().hasNext());
    assertTrue(((List<?>) actualDoOperationResult).isEmpty());
  }

  /**
   * Method under test: {@link LimitHandler#doOperation(Limit, Context, Store)}
   */
  @Test
  void testDoOperation2() throws OperationException {
    // Arrange
    LimitHandler<Object> limitHandler = new LimitHandler<>();

    Limit<Object> operation = new Limit<>();
    operation.setInput(new ArrayList<>());
    operation.setResultLimit(0);

    // Act
    Iterable<?> actualDoOperationResult = limitHandler.doOperation(operation, new Context(), null);
    Iterator<?> actualIteratorResult = actualDoOperationResult.iterator();

    // Assert
    assertTrue(actualDoOperationResult instanceof LimitedIterable);
    assertTrue(actualIteratorResult instanceof LimitedIterator);
    assertEquals(0, ((LimitedIterable<?>) actualDoOperationResult).getEnd().intValue());
    assertEquals(0, ((LimitedIterable<?>) actualDoOperationResult).getStart());
    assertFalse(actualIteratorResult.hasNext());
  }

  /**
   * Method under test: {@link LimitHandler#doOperation(Limit, Context, Store)}
   */
  @Test
  void testDoOperation3() throws OperationException {
    // Arrange
    LimitHandler<Object> limitHandler = new LimitHandler<>();
    Iterable<Object> input = mock(Iterable.class);

    ArrayList<Object> objectList = new ArrayList<>();
    when(input.iterator()).thenReturn(objectList.iterator());

    Limit<Object> operation = new Limit<>();
    operation.setInput(input);
    operation.setResultLimit(null);

    // Act
    Iterator<?> actualIteratorResult = limitHandler.doOperation(operation, new Context(), null).iterator();

    // Assert
    verify(input).iterator();
    assertFalse(actualIteratorResult.hasNext());
  }
}
