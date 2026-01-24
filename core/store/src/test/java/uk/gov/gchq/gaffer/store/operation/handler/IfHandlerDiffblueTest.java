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

package uk.gov.gchq.gaffer.store.operation.handler;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.function.Predicate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.named.operation.NamedOperation;
import uk.gov.gchq.gaffer.operation.OperationException;
import uk.gov.gchq.gaffer.operation.impl.If;
import uk.gov.gchq.gaffer.operation.util.Conditional;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.Store;

class IfHandlerDiffblueTest {
  /**
   * Test {@link IfHandler#doOperation(If, Context, Store)} with {@code If}, {@code Context}, {@code
   * Store}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link If} (default constructor) Then is {@code null}.
   *   <li>Then return {@code Operation}.
   * </ul>
   *
   * <p>Method under test: {@link IfHandler#doOperation(If, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(If, Context, Store) with 'If', 'Context', 'Store'; given 'null'; when If (default constructor) Then is 'null'; then return 'Operation'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object IfHandler.doOperation(If, Context, Store)"})
  void testDoOperationWithIfContextStore_givenNull_whenIfThenIsNull_thenReturnOperation()
      throws OperationException {
    // Arrange
    IfHandler ifHandler = new IfHandler();

    NamedOperation<Object, Object> transform = new NamedOperation<>();
    transform.setInput(new ArrayList<>());

    Conditional conditional = new Conditional(mock(Predicate.class));
    conditional.setTransform(transform);

    NamedOperation<Object, Object> otherwise = new NamedOperation<>();
    otherwise.setInput(new ArrayList<>());

    If operation = new If();
    operation.setCondition(true);
    operation.setConditional(conditional);
    operation.setInput("Operation");
    operation.setOtherwise(otherwise);
    operation.setThen(null);
    Context context = new Context();

    // Act and Assert
    assertEquals(
        "Operation", ifHandler.doOperation(operation, context, new TestAddToGraphLibraryImpl()));
  }

  /**
   * Test {@link IfHandler#doOperation(If, Context, Store)} with {@code If}, {@code Context}, {@code
   * Store}.
   *
   * <ul>
   *   <li>When {@link If} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link IfHandler#doOperation(If, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(If, Context, Store) with 'If', 'Context', 'Store'; when If (default constructor); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object IfHandler.doOperation(If, Context, Store)"})
  void testDoOperationWithIfContextStore_whenIf_thenReturnNull() throws OperationException {
    // Arrange
    IfHandler ifHandler = new IfHandler();
    If operation = new If();
    Context context = new Context();

    // Act and Assert
    assertNull(ifHandler.doOperation(operation, context, new TestAddToGraphLibraryImpl()));
  }
}
