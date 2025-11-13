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

package uk.gov.gchq.gaffer.store.operation.handler.function;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Iterator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.Element;
import uk.gov.gchq.gaffer.operation.OperationException;
import uk.gov.gchq.gaffer.operation.impl.function.Aggregate;
import uk.gov.gchq.gaffer.store.schema.Schema;
import uk.gov.gchq.koryphe.iterable.ChainedIterable;
import uk.gov.gchq.koryphe.iterable.ChainedIterator;

class AggregateHandlerDiffblueTest {
  /**
   * Test {@link AggregateHandler#doOperation(Aggregate, Schema)} with {@code operation}, {@code schema}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@link ChainedIterable}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AggregateHandler#doOperation(Aggregate, Schema)}
   */
  @Test
  @DisplayName("Test doOperation(Aggregate, Schema) with 'operation', 'schema'; given ArrayList(); then return ChainedIterable")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Iterable AggregateHandler.doOperation(Aggregate, Schema)"})
  void testDoOperationWithOperationSchema_givenArrayList_thenReturnChainedIterable() throws OperationException {
    // Arrange
    AggregateHandler aggregateHandler = new AggregateHandler();

    Aggregate operation = new Aggregate();
    operation.setInput(new ArrayList<>());

    // Act
    Iterable<? extends Element> actualDoOperationResult = aggregateHandler.doOperation(operation, new Schema());
    Iterator<? extends Element> actualIteratorResult = actualDoOperationResult.iterator();

    // Assert
    assertTrue(actualDoOperationResult instanceof ChainedIterable);
    Iterator<? extends Element> iteratorResult = actualDoOperationResult.iterator();
    assertTrue(iteratorResult instanceof ChainedIterator);
    assertTrue(actualIteratorResult instanceof ChainedIterator);
    assertFalse(iteratorResult.hasNext());
    assertFalse(actualIteratorResult.hasNext());
    assertTrue(operation.getEdges().isEmpty());
    assertTrue(operation.getEntities().isEmpty());
  }
}
