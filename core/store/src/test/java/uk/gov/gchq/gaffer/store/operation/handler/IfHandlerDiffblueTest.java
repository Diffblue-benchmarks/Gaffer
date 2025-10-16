package uk.gov.gchq.gaffer.store.operation.handler;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.isNull;
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
   *   <li>Given {@link Conditional#Conditional()}.
   * </ul>
   *
   * <p>Method under test: {@link IfHandler#doOperation(If, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(If, Context, Store) with 'If', 'Context', 'Store'; given Conditional()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   * Test {@link IfHandler#doOperation(If, Context, Store)} with {@code If}, {@code Context}, {@code
   * Store}.
   *
   * <ul>
   *   <li>Given {@link Predicate} {@link Predicate#test(Object)} return {@code false}.
   *   <li>Then calls {@link Predicate#test(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link IfHandler#doOperation(If, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(If, Context, Store) with 'If', 'Context', 'Store'; given Predicate test(Object) return 'false'; then calls test(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object IfHandler.doOperation(If, Context, Store)"})
  void testDoOperationWithIfContextStore_givenPredicateTestReturnFalse_thenCallsTest()
      throws OperationException {
    // Arrange
    IfHandler ifHandler = new IfHandler();

    Predicate predicate = mock(Predicate.class);
    when(predicate.test(Mockito.<Object>any())).thenReturn(false);
    Conditional conditional = new Conditional(predicate);

    If operation = new If();
    operation.setConditional(conditional);
    Context context = new Context();

    // Act
    Object actualDoOperationResult =
        ifHandler.doOperation(operation, context, new TestAddToGraphLibraryImpl());

    // Assert
    verify(predicate).test(isNull());
    assertNull(actualDoOperationResult);
  }

  /**
   * Test {@link IfHandler#doOperation(If, Context, Store)} with {@code If}, {@code Context}, {@code
   * Store}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link If} (default constructor) Condition is {@code true}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link IfHandler#doOperation(If, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(If, Context, Store) with 'If', 'Context', 'Store'; given 'true'; when If (default constructor) Condition is 'true'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object IfHandler.doOperation(If, Context, Store)"})
  void testDoOperationWithIfContextStore_givenTrue_whenIfConditionIsTrue_thenReturnNull()
      throws OperationException {
    // Arrange
    IfHandler ifHandler = new IfHandler();

    If operation = new If();
    operation.setCondition(true);
    Context context = new Context();

    // Act and Assert
    assertNull(ifHandler.doOperation(operation, context, new TestAddToGraphLibraryImpl()));
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
