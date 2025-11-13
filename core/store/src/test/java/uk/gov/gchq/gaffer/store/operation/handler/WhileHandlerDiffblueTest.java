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

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.function.Predicate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uk.gov.gchq.gaffer.operation.OperationException;
import uk.gov.gchq.gaffer.operation.impl.While;
import uk.gov.gchq.gaffer.operation.util.Conditional;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.Store;

class WhileHandlerDiffblueTest {
  /**
   * Test {@link WhileHandler#doOperation(While, Context, Store)} with {@code While}, {@code
   * Context}, {@code Store}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link WhileHandler#doOperation(While, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(While, Context, Store) with 'While', 'Context', 'Store'; given 'false'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object WhileHandler.doOperation(While, Context, Store)"})
  void testDoOperationWithWhileContextStore_givenFalse_thenReturnNull() throws OperationException {
    // Arrange
    WhileHandler whileHandler = new WhileHandler();

    While operation = new While();
    operation.setCondition(false);
    Context context = new Context();

    // Act and Assert
    assertNull(whileHandler.doOperation(operation, context, new TestAddToGraphLibraryImpl()));
  }

  /**
   * Test {@link WhileHandler#doOperation(While, Context, Store)} with {@code While}, {@code
   * Context}, {@code Store}.
   *
   * <ul>
   *   <li>Then throw {@link OperationException}.
   * </ul>
   *
   * <p>Method under test: {@link WhileHandler#doOperation(While, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(While, Context, Store) with 'While', 'Context', 'Store'; then throw OperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object WhileHandler.doOperation(While, Context, Store)"})
  void testDoOperationWithWhileContextStore_thenThrowOperationException()
      throws OperationException {
    // Arrange
    WhileHandler whileHandler = new WhileHandler();
    whileHandler.setMaxRepeats(3);
    While operation = new While();
    Context context = new Context();

    // Act and Assert
    assertThrows(
        OperationException.class,
        () -> whileHandler.doOperation(operation, context, new TestAddToGraphLibraryImpl()));
  }

  /**
   * Test {@link WhileHandler#getOperationFromWhile(While)}.
   *
   * <ul>
   *   <li>When {@link While} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link WhileHandler#getOperationFromWhile(While)}
   */
  @Test
  @DisplayName(
      "Test getOperationFromWhile(While); when While (default constructor); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "uk.gov.gchq.gaffer.operation.Operation WhileHandler.getOperationFromWhile(While)"
  })
  void testGetOperationFromWhile_whenWhile_thenReturnNull() {
    // Arrange
    WhileHandler whileHandler = new WhileHandler();

    // Act and Assert
    assertNull(whileHandler.getOperationFromWhile(new While()));
  }

  /**
   * Test {@link WhileHandler#validateMaxRepeats(While)}.
   *
   * <ul>
   *   <li>Given three.
   *   <li>Then calls {@link While#getMaxRepeats()}.
   * </ul>
   *
   * <p>Method under test: {@link WhileHandler#validateMaxRepeats(While)}
   */
  @Test
  @DisplayName("Test validateMaxRepeats(While); given three; then calls getMaxRepeats()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void WhileHandler.validateMaxRepeats(While)"})
  void testValidateMaxRepeats_givenThree_thenCallsGetMaxRepeats() throws OperationException {
    // Arrange
    WhileHandler whileHandler = new WhileHandler();

    While operation = mock(While.class);
    when(operation.getMaxRepeats()).thenReturn(3);

    // Act
    whileHandler.validateMaxRepeats(operation);

    // Assert
    verify(operation).getMaxRepeats();
  }

  /**
   * Test {@link WhileHandler#validateMaxRepeats(While)}.
   *
   * <ul>
   *   <li>Given {@link WhileHandler} (default constructor) MaxRepeats is one.
   * </ul>
   *
   * <p>Method under test: {@link WhileHandler#validateMaxRepeats(While)}
   */
  @Test
  @DisplayName(
      "Test validateMaxRepeats(While); given WhileHandler (default constructor) MaxRepeats is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void WhileHandler.validateMaxRepeats(While)"})
  void testValidateMaxRepeats_givenWhileHandlerMaxRepeatsIsOne() throws OperationException {
    // Arrange
    WhileHandler whileHandler = new WhileHandler();
    whileHandler.setMaxRepeats(1);

    While operation = mock(While.class);
    when(operation.getMaxRepeats()).thenReturn(3);

    // Act and Assert
    assertThrows(OperationException.class, () -> whileHandler.validateMaxRepeats(operation));
    verify(operation, atLeast(1)).getMaxRepeats();
  }

  /**
   * Test {@link WhileHandler#validateMaxRepeats(While)}.
   *
   * <ul>
   *   <li>Given {@link WhileHandler} (default constructor) MaxRepeats is three.
   * </ul>
   *
   * <p>Method under test: {@link WhileHandler#validateMaxRepeats(While)}
   */
  @Test
  @DisplayName(
      "Test validateMaxRepeats(While); given WhileHandler (default constructor) MaxRepeats is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void WhileHandler.validateMaxRepeats(While)"})
  void testValidateMaxRepeats_givenWhileHandlerMaxRepeatsIsThree() throws OperationException {
    // Arrange
    WhileHandler whileHandler = new WhileHandler();
    whileHandler.setMaxRepeats(3);

    // Act and Assert
    assertThrows(OperationException.class, () -> whileHandler.validateMaxRepeats(new While()));
  }

  /**
   * Test {@link WhileHandler#validateMaxRepeats(While)}.
   *
   * <ul>
   *   <li>Given {@link WhileHandler} (default constructor).
   *   <li>When {@link While} (default constructor).
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link WhileHandler#validateMaxRepeats(While)}
   */
  @Test
  @DisplayName(
      "Test validateMaxRepeats(While); given WhileHandler (default constructor); when While (default constructor); then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void WhileHandler.validateMaxRepeats(While)"})
  void testValidateMaxRepeats_givenWhileHandler_whenWhile_thenDoesNotThrow()
      throws OperationException {
    // Arrange
    WhileHandler whileHandler = new WhileHandler();

    // Act and Assert
    assertDoesNotThrow(() -> whileHandler.validateMaxRepeats(new While()));
  }

  /**
   * Test {@link WhileHandler#isSatisfied(Object, While, Context, Store)}.
   *
   * <ul>
   *   <li>Given {@link Conditional#Conditional(Predicate)} with {@link Predicate} Transform is
   *       {@code null}.
   *   <li>Then calls {@link Predicate#test(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link WhileHandler#isSatisfied(Object, While, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test isSatisfied(Object, While, Context, Store); given Conditional(Predicate) with Predicate Transform is 'null'; then calls test(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean WhileHandler.isSatisfied(Object, While, Context, Store)"})
  void testIsSatisfied_givenConditionalWithPredicateTransformIsNull_thenCallsTest()
      throws OperationException {
    // Arrange
    WhileHandler whileHandler = new WhileHandler();

    Predicate predicate = mock(Predicate.class);
    when(predicate.test(Mockito.<Object>any())).thenReturn(true);

    Conditional conditional = new Conditional(predicate);
    conditional.setTransform(null);

    While operation = new While();
    operation.setConditional(conditional);
    operation.setCondition(true);
    Context context = new Context();

    // Act
    boolean actualIsSatisfiedResult =
        whileHandler.isSatisfied("Input", operation, context, new TestAddToGraphLibraryImpl());

    // Assert
    verify(predicate).test(isA(Object.class));
    assertTrue(actualIsSatisfiedResult);
  }

  /**
   * Test {@link WhileHandler#isSatisfied(Object, While, Context, Store)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>When {@link While} (default constructor) Condition is {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link WhileHandler#isSatisfied(Object, While, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test isSatisfied(Object, While, Context, Store); given 'false'; when While (default constructor) Condition is 'false'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean WhileHandler.isSatisfied(Object, While, Context, Store)"})
  void testIsSatisfied_givenFalse_whenWhileConditionIsFalse_thenReturnFalse()
      throws OperationException {
    // Arrange
    WhileHandler whileHandler = new WhileHandler();

    While operation = new While();
    operation.setConditional(null);
    operation.setCondition(false);
    Context context = new Context();

    // Act and Assert
    assertFalse(
        whileHandler.isSatisfied("Input", operation, context, new TestAddToGraphLibraryImpl()));
  }

  /**
   * Test {@link WhileHandler#isSatisfied(Object, While, Context, Store)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link While} (default constructor) Conditional is {@code null}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link WhileHandler#isSatisfied(Object, While, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test isSatisfied(Object, While, Context, Store); given 'null'; when While (default constructor) Conditional is 'null'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean WhileHandler.isSatisfied(Object, While, Context, Store)"})
  void testIsSatisfied_givenNull_whenWhileConditionalIsNull_thenReturnTrue()
      throws OperationException {
    // Arrange
    WhileHandler whileHandler = new WhileHandler();

    While operation = new While();
    operation.setConditional(null);
    operation.setCondition(true);
    Context context = new Context();

    // Act and Assert
    assertTrue(
        whileHandler.isSatisfied("Input", operation, context, new TestAddToGraphLibraryImpl()));
  }

  /**
   * Test {@link WhileHandler#isSatisfied(Object, While, Context, Store)}.
   *
   * <ul>
   *   <li>Given {@link Predicate} {@link Predicate#test(Object)} return {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link WhileHandler#isSatisfied(Object, While, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test isSatisfied(Object, While, Context, Store); given Predicate test(Object) return 'false'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean WhileHandler.isSatisfied(Object, While, Context, Store)"})
  void testIsSatisfied_givenPredicateTestReturnFalse_thenReturnFalse() throws OperationException {
    // Arrange
    WhileHandler whileHandler = new WhileHandler();

    Predicate predicate = mock(Predicate.class);
    when(predicate.test(Mockito.<Object>any())).thenReturn(false);

    Conditional conditional = new Conditional(mock(Predicate.class));
    conditional.setPredicate(predicate);

    While operation = new While();
    operation.setConditional(conditional);
    operation.setCondition(true);
    Context context = new Context();

    // Act
    boolean actualIsSatisfiedResult =
        whileHandler.isSatisfied("Input", operation, context, new TestAddToGraphLibraryImpl());

    // Assert
    verify(predicate).test(isA(Object.class));
    assertFalse(actualIsSatisfiedResult);
  }

  /**
   * Test {@link WhileHandler#isSatisfied(Object, While, Context, Store)}.
   *
   * <ul>
   *   <li>When {@link While} (default constructor).
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link WhileHandler#isSatisfied(Object, While, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test isSatisfied(Object, While, Context, Store); when While (default constructor); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean WhileHandler.isSatisfied(Object, While, Context, Store)"})
  void testIsSatisfied_whenWhile_thenReturnTrue() throws OperationException {
    // Arrange
    WhileHandler whileHandler = new WhileHandler();
    While operation = new While();
    Context context = new Context();

    // Act and Assert
    assertTrue(
        whileHandler.isSatisfied("Input", operation, context, new TestAddToGraphLibraryImpl()));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link WhileHandler}
   *   <li>{@link WhileHandler#setMaxRepeats(int)}
   *   <li>{@link WhileHandler#getMaxRepeats()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void WhileHandler.<init>()",
    "int WhileHandler.getMaxRepeats()",
    "void WhileHandler.setMaxRepeats(int)"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    WhileHandler actualWhileHandler = new WhileHandler();
    actualWhileHandler.setMaxRepeats(3);

    // Assert
    assertEquals(3, actualWhileHandler.getMaxRepeats());
  }
}
