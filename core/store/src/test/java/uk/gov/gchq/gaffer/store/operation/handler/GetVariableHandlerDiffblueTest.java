package uk.gov.gchq.gaffer.store.operation.handler;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.operation.OperationException;
import uk.gov.gchq.gaffer.operation.impl.GetVariable;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.Store;

class GetVariableHandlerDiffblueTest {
  /**
   * Test {@link GetVariableHandler#doOperation(GetVariable, Context, Store)} with {@code
   * GetVariable}, {@code Context}, {@code Store}.
   *
   * <ul>
   *   <li>Given {@code Operation}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link GetVariableHandler#doOperation(GetVariable, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(GetVariable, Context, Store) with 'GetVariable', 'Context', 'Store'; given 'Operation'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Object GetVariableHandler.doOperation(GetVariable, Context, Store)"
  })
  void testDoOperationWithGetVariableContextStore_givenOperation_thenReturnNull()
      throws OperationException {
    // Arrange
    GetVariableHandler getVariableHandler = new GetVariableHandler();

    GetVariable operation = new GetVariable();
    operation.setVariableName("Operation");
    Context context = new Context();

    // Act and Assert
    assertNull(getVariableHandler.doOperation(operation, context, new TestAddToGraphLibraryImpl()));
  }

  /**
   * Test {@link GetVariableHandler#doOperation(GetVariable, Context, Store)} with {@code
   * GetVariable}, {@code Context}, {@code Store}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link GetVariableHandler#doOperation(GetVariable, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(GetVariable, Context, Store) with 'GetVariable', 'Context', 'Store'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Object GetVariableHandler.doOperation(GetVariable, Context, Store)"
  })
  void testDoOperationWithGetVariableContextStore_thenThrowIllegalArgumentException()
      throws OperationException {
    // Arrange
    GetVariableHandler getVariableHandler = new GetVariableHandler();
    GetVariable operation = new GetVariable();
    Context context = new Context();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> getVariableHandler.doOperation(operation, context, new TestAddToGraphLibraryImpl()));
  }
}
