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
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.commonutil.iterable.StreamIterator;
import uk.gov.gchq.gaffer.data.element.Element;
import uk.gov.gchq.gaffer.operation.OperationException;
import uk.gov.gchq.gaffer.operation.impl.function.Filter;
import uk.gov.gchq.gaffer.operation.util.StreamFilterIterable;
import uk.gov.gchq.gaffer.store.schema.Schema;

class FilterHandlerDiffblueTest {
  /**
   * Test {@link FilterHandler#doOperation(Filter, Schema)} with {@code operation}, {@code schema}.
   * <ul>
   *   <li>Then iterator return {@link StreamIterator}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FilterHandler#doOperation(Filter, Schema)}
   */
  @Test
  @DisplayName("Test doOperation(Filter, Schema) with 'operation', 'schema'; then iterator return StreamIterator")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Iterable FilterHandler.doOperation(Filter, Schema)"})
  void testDoOperationWithOperationSchema_thenIteratorReturnStreamIterator() throws OperationException {
    // Arrange
    FilterHandler filterHandler = new FilterHandler();

    Filter operation = new Filter();
    operation.setInput(new ArrayList<>());
    operation.setEntities(null);
    operation.setEdges(null);

    // Act
    Iterable<? extends Element> actualDoOperationResult = filterHandler.doOperation(operation, new Schema());
    Iterator<? extends Element> actualIteratorResult = actualDoOperationResult.iterator();

    // Assert
    Iterator<? extends Element> iteratorResult = actualDoOperationResult.iterator();
    assertTrue(iteratorResult instanceof StreamIterator);
    assertTrue(actualIteratorResult instanceof StreamIterator);
    assertTrue(actualDoOperationResult instanceof StreamFilterIterable);
    assertFalse(iteratorResult.hasNext());
    assertFalse(actualIteratorResult.hasNext());
    Stream<Element> stream = ((StreamFilterIterable) actualDoOperationResult).getStream();
    assertTrue(stream.limit(5).collect(Collectors.toList()).isEmpty());
    assertTrue(operation.getEdges().isEmpty());
    assertTrue(operation.getEntities().isEmpty());
  }
}
