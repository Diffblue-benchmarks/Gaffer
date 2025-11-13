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

package uk.gov.gchq.gaffer.store.operation.handler.output;

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
import uk.gov.gchq.gaffer.commonutil.iterable.StreamFlatMapIterable;
import uk.gov.gchq.gaffer.commonutil.iterable.StreamIterator;
import uk.gov.gchq.gaffer.operation.OperationException;
import uk.gov.gchq.gaffer.operation.impl.output.ToVertices;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.Context.Builder;
import uk.gov.gchq.gaffer.store.Store;
import uk.gov.gchq.gaffer.store.operation.handler.TestAddToGraphLibraryImpl;
import uk.gov.gchq.gaffer.user.User;

class ToVerticesHandlerDiffblueTest {
  /**
   * Test {@link ToVerticesHandler#doOperation(ToVertices, Context, Store)} with {@code ToVertices}, {@code Context}, {@code Store}.
   * <ul>
   *   <li>Then return {@link StreamFlatMapIterable}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ToVerticesHandler#doOperation(ToVertices, Context, Store)}
   */
  @Test
  @DisplayName("Test doOperation(ToVertices, Context, Store) with 'ToVertices', 'Context', 'Store'; then return StreamFlatMapIterable")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Iterable ToVerticesHandler.doOperation(ToVertices, Context, Store)"})
  void testDoOperationWithToVerticesContextStore_thenReturnStreamFlatMapIterable() throws OperationException {
    // Arrange
    ToVerticesHandler toVerticesHandler = new ToVerticesHandler();

    ToVertices operation = new ToVertices();
    operation.setInput(new ArrayList<>());
    Context context = new Context();

    // Act
    Iterable<Object> actualDoOperationResult = toVerticesHandler.doOperation(operation, context,
        new TestAddToGraphLibraryImpl());
    Iterator<Object> actualIteratorResult = actualDoOperationResult.iterator();

    // Assert
    assertTrue(actualDoOperationResult instanceof StreamFlatMapIterable);
    Iterator<Object> iteratorResult = actualDoOperationResult.iterator();
    assertTrue(iteratorResult instanceof StreamIterator);
    assertTrue(actualIteratorResult instanceof StreamIterator);
    assertFalse(iteratorResult.hasNext());
    assertFalse(actualIteratorResult.hasNext());
    Stream<Object> stream = ((StreamFlatMapIterable<Object, Object>) actualDoOperationResult).getStream();
    assertTrue(stream.limit(5).collect(Collectors.toList()).isEmpty());
  }

  /**
   * Test {@link ToVerticesHandler#doOperation(ToVertices, Context, Store)} with {@code ToVertices}, {@code Context}, {@code Store}.
   * <ul>
   *   <li>Then return {@link StreamFlatMapIterable}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ToVerticesHandler#doOperation(ToVertices, Context, Store)}
   */
  @Test
  @DisplayName("Test doOperation(ToVertices, Context, Store) with 'ToVertices', 'Context', 'Store'; then return StreamFlatMapIterable")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Iterable ToVerticesHandler.doOperation(ToVertices, Context, Store)"})
  void testDoOperationWithToVerticesContextStore_thenReturnStreamFlatMapIterable2() throws OperationException {
    // Arrange
    ToVerticesHandler toVerticesHandler = new ToVerticesHandler();

    ToVertices operation = new ToVertices();
    operation.setInput(new ArrayList<>());

    Builder builder = new Builder();
    User user = (new User.Builder()).userId("42").build();
    Context context = builder.user(user).build();

    // Act
    Iterable<Object> actualDoOperationResult = toVerticesHandler.doOperation(operation, context,
        new TestAddToGraphLibraryImpl());
    Iterator<Object> actualIteratorResult = actualDoOperationResult.iterator();

    // Assert
    assertTrue(actualDoOperationResult instanceof StreamFlatMapIterable);
    Iterator<Object> iteratorResult = actualDoOperationResult.iterator();
    assertTrue(iteratorResult instanceof StreamIterator);
    assertTrue(actualIteratorResult instanceof StreamIterator);
    assertFalse(iteratorResult.hasNext());
    assertFalse(actualIteratorResult.hasNext());
    Stream<Object> stream = ((StreamFlatMapIterable<Object, Object>) actualDoOperationResult).getStream();
    assertTrue(stream.limit(5).collect(Collectors.toList()).isEmpty());
  }
}
