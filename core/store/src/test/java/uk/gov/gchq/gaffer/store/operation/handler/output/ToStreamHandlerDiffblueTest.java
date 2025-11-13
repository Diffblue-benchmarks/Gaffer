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

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.operation.OperationException;
import uk.gov.gchq.gaffer.operation.impl.output.ToStream;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.Store;
import uk.gov.gchq.gaffer.store.operation.handler.TestAddToGraphLibraryImpl;

class ToStreamHandlerDiffblueTest {
  /**
   * Test {@link ToStreamHandler#doOperation(ToStream, Context, Store)} with {@code ToStream}, {@code Context}, {@code Store}.
   * <ul>
   *   <li>Then return limit five collect toList Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link ToStreamHandler#doOperation(ToStream, Context, Store)}
   */
  @Test
  @DisplayName("Test doOperation(ToStream, Context, Store) with 'ToStream', 'Context', 'Store'; then return limit five collect toList Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Stream ToStreamHandler.doOperation(ToStream, Context, Store)"})
  void testDoOperationWithToStreamContextStore_thenReturnLimitFiveCollectToListEmpty() throws OperationException {
    // Arrange
    ToStreamHandler<Object> toStreamHandler = new ToStreamHandler<>();

    ToStream<Object> operation = new ToStream<>();
    operation.setInput(new ArrayList<>());
    Context context = new Context();

    // Act
    Stream<?> actualDoOperationResult = toStreamHandler.doOperation(operation, context,
        new TestAddToGraphLibraryImpl());

    // Assert
    assertTrue(actualDoOperationResult.limit(5).collect(Collectors.toList()).isEmpty());
  }

  /**
   * Test {@link ToStreamHandler#doOperation(ToStream, Context, Store)} with {@code ToStream}, {@code Context}, {@code Store}.
   * <ul>
   *   <li>When {@link ToStream} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ToStreamHandler#doOperation(ToStream, Context, Store)}
   */
  @Test
  @DisplayName("Test doOperation(ToStream, Context, Store) with 'ToStream', 'Context', 'Store'; when ToStream (default constructor); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Stream ToStreamHandler.doOperation(ToStream, Context, Store)"})
  void testDoOperationWithToStreamContextStore_whenToStream_thenReturnNull() throws OperationException {
    // Arrange
    ToStreamHandler<Object> toStreamHandler = new ToStreamHandler<>();
    ToStream<Object> operation = new ToStream<>();
    Context context = new Context();

    // Act
    Stream<?> actualDoOperationResult = toStreamHandler.doOperation(operation, context,
        new TestAddToGraphLibraryImpl());

    // Assert
    assertNull(actualDoOperationResult);
  }
}
