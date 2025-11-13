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
import uk.gov.gchq.gaffer.operation.impl.function.Transform;
import uk.gov.gchq.gaffer.store.operation.util.StreamTransformIterable;
import uk.gov.gchq.gaffer.store.schema.Schema;

class TransformHandlerDiffblueTest {
  /**
   * Test {@link TransformHandler#doOperation(Transform, Schema)} with {@code operation}, {@code schema}.
   * <ul>
   *   <li>Then iterator return {@link StreamIterator}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransformHandler#doOperation(Transform, Schema)}
   */
  @Test
  @DisplayName("Test doOperation(Transform, Schema) with 'operation', 'schema'; then iterator return StreamIterator")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Iterable TransformHandler.doOperation(Transform, Schema)"})
  void testDoOperationWithOperationSchema_thenIteratorReturnStreamIterator() throws OperationException {
    // Arrange
    TransformHandler transformHandler = new TransformHandler();

    Transform operation = new Transform();
    operation.setInput(new ArrayList<>());
    operation.setEntities(null);
    operation.setEdges(null);

    // Act
    Iterable<? extends Element> actualDoOperationResult = transformHandler.doOperation(operation, new Schema());
    Iterator<? extends Element> actualIteratorResult = actualDoOperationResult.iterator();

    // Assert
    Iterator<? extends Element> iteratorResult = actualDoOperationResult.iterator();
    assertTrue(iteratorResult instanceof StreamIterator);
    assertTrue(actualIteratorResult instanceof StreamIterator);
    assertTrue(actualDoOperationResult instanceof StreamTransformIterable);
    assertFalse(iteratorResult.hasNext());
    assertFalse(actualIteratorResult.hasNext());
    Stream<Element> stream = ((StreamTransformIterable) actualDoOperationResult).getStream();
    assertTrue(stream.limit(5).collect(Collectors.toList()).isEmpty());
    assertTrue(operation.getEdges().isEmpty());
    assertTrue(operation.getEntities().isEmpty());
  }
}
