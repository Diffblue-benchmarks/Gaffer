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

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.function.Predicate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uk.gov.gchq.gaffer.operation.OperationException;
import uk.gov.gchq.gaffer.operation.impl.If;
import uk.gov.gchq.gaffer.operation.util.Conditional;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.Store;

class IfHandlerDiffblueTest {
  /**
   * Test {@link IfHandler#doOperation(If, Context, Store)} with {@code If}, {@code Context}, {@code Store}.
   * <ul>
   *   <li>Given {@link Conditional#Conditional()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IfHandler#doOperation(If, Context, Store)}
   */
  @Test
  @DisplayName("Test doOperation(If, Context, Store) with 'If', 'Context', 'Store'; given Conditional()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object IfHandler.doOperation(If, Context, Store)"})
  void testDoOperationWithIfContextStore_givenConditional() throws OperationException {
    // Arrange
    IfHandler ifHandler = new IfHandler();

    If operation = new If();
    operation.setConditional(new Conditional());
    Context context = new Context();

    // Act and Assert
    assertNull(ifHandler.doOperation(operation, context, new TestAddToGraphLibraryImpl()));
  }

  /**
   * Test {@link IfHandler#doOperation(If, Context, Store)} with {@code If}, {@code Context}, {@code Store}.
   * <ul>
   *   <li>Given {@link Predicate} {@link Predicate#test(Object)} return {@code true}.</li>
   *   <li>Then calls {@link Predicate#test(Object)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IfHandler#doOperation(If, Context, Store)}
   */
  @Test
  @DisplayName("Test doOperation(If, Context, Store) with 'If', 'Context', 'Store'; given Predicate test(Object) return 'true'; then calls test(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object IfHandler.doOperation(If, Context, Store)"})
  void testDoOperationWithIfContextStore_givenPredicateTestReturnTrue_thenCallsTest() throws OperationException {
    // Arrange
    IfHandler ifHandler = new IfHandler();
    Predicate predicate = mock(Predicate.class);
    when(predicate.test(Mockito.<Object>any())).thenReturn(true);
    Conditional conditional = new Conditional(predicate);

    If operation = new If();
    operation.setConditional(conditional);
    Context context = new Context();

    // Act
    Object actualDoOperationResult = ifHandler.doOperation(operation, context, new TestAddToGraphLibraryImpl());

    // Assert
    verify(predicate).test(isNull());
    assertNull(actualDoOperationResult);
  }

  /**
   * Test {@link IfHandler#doOperation(If, Context, Store)} with {@code If}, {@code Context}, {@code Store}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>When {@link If} (default constructor) Condition is {@code true}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IfHandler#doOperation(If, Context, Store)}
   */
  @Test
  @DisplayName("Test doOperation(If, Context, Store) with 'If', 'Context', 'Store'; given 'true'; when If (default constructor) Condition is 'true'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object IfHandler.doOperation(If, Context, Store)"})
  void testDoOperationWithIfContextStore_givenTrue_whenIfConditionIsTrue_thenReturnNull() throws OperationException {
    // Arrange
    IfHandler ifHandler = new IfHandler();

    If operation = new If();
    operation.setCondition(true);
    Context context = new Context();

    // Act and Assert
    assertNull(ifHandler.doOperation(operation, context, new TestAddToGraphLibraryImpl()));
  }

  /**
   * Test {@link IfHandler#doOperation(If, Context, Store)} with {@code If}, {@code Context}, {@code Store}.
   * <ul>
   *   <li>When {@link If} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IfHandler#doOperation(If, Context, Store)}
   */
  @Test
  @DisplayName("Test doOperation(If, Context, Store) with 'If', 'Context', 'Store'; when If (default constructor); then return 'null'")
  @Tag("MaintainedByDiffblue")
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
