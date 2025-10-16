package uk.gov.gchq.gaffer.store.operation.handler;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.operation.OperationException;
import uk.gov.gchq.gaffer.operation.impl.SetVariable;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.Store;

class SetVariableHandlerDiffblueTest {
  /**
   * Test {@link SetVariableHandler#doOperation(SetVariable, Context, Store)} with {@code
   * SetVariable}, {@code Context}, {@code Store}.
   *
   * <p>Method under test: {@link SetVariableHandler#doOperation(SetVariable, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(SetVariable, Context, Store) with 'SetVariable', 'Context', 'Store'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Void SetVariableHandler.doOperation(SetVariable, Context, Store)"})
  void testDoOperationWithSetVariableContextStore() throws OperationException {
    // Arrange
    SetVariableHandler setVariableHandler = new SetVariableHandler();

    SetVariable operation = new SetVariable();
    operation.setVariableName("Operation");
    operation.setInput("Operation");

    Context context = new Context(new Context());
    context.setVariables(null);

    // Act
    Void actualDoOperationResult =
        setVariableHandler.doOperation(operation, context, new TestAddToGraphLibraryImpl());

    // Assert
    Map<String, Object> variables = context.getVariables();
    assertEquals(1, variables.size());
    assertEquals("Operation", variables.get("Operation"));
    assertNull(actualDoOperationResult);
  }

  /**
   * Test {@link SetVariableHandler#doOperation(SetVariable, Context, Store)} with {@code
   * SetVariable}, {@code Context}, {@code Store}.
   *
   * <p>Method under test: {@link SetVariableHandler#doOperation(SetVariable, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(SetVariable, Context, Store) with 'SetVariable', 'Context', 'Store'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Void SetVariableHandler.doOperation(SetVariable, Context, Store)"})
  void testDoOperationWithSetVariableContextStore2() throws OperationException {
    // Arrange
    SetVariableHandler setVariableHandler = new SetVariableHandler();

    SetVariable operation = new SetVariable();
    operation.setVariableName("Operation");
    operation.setInput("Operation");

    Context context = new Context(new Context());
    HashMap<String, Object> variables = new HashMap<>();
    context.setVariables(variables);

    // Act
    Void actualDoOperationResult =
        setVariableHandler.doOperation(operation, context, new TestAddToGraphLibraryImpl());

    // Assert
    Map<String, Object> variables2 = context.getVariables();
    assertEquals(1, variables2.size());
    assertEquals("Operation", variables2.get("Operation"));
    assertNull(actualDoOperationResult);
    assertSame(variables, variables2);
  }

  /**
   * Test {@link SetVariableHandler#doOperation(SetVariable, Context, Store)} with {@code
   * SetVariable}, {@code Context}, {@code Store}.
   *
   * <ul>
   *   <li>When {@link SetVariable} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link SetVariableHandler#doOperation(SetVariable, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(SetVariable, Context, Store) with 'SetVariable', 'Context', 'Store'; when SetVariable (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Void SetVariableHandler.doOperation(SetVariable, Context, Store)"})
  void testDoOperationWithSetVariableContextStore_whenSetVariable() throws OperationException {
    // Arrange
    SetVariableHandler setVariableHandler = new SetVariableHandler();
    SetVariable operation = new SetVariable();
    Context context = new Context();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> setVariableHandler.doOperation(operation, context, new TestAddToGraphLibraryImpl()));
  }

  /**
   * Test {@link SetVariableHandler#doOperation(SetVariable, Context, Store)} with {@code
   * SetVariable}, {@code Context}, {@code Store}.
   *
   * <ul>
   *   <li>When {@link SetVariable} (default constructor) Input is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SetVariableHandler#doOperation(SetVariable, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(SetVariable, Context, Store) with 'SetVariable', 'Context', 'Store'; when SetVariable (default constructor) Input is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Void SetVariableHandler.doOperation(SetVariable, Context, Store)"})
  void testDoOperationWithSetVariableContextStore_whenSetVariableInputIsNull()
      throws OperationException {
    // Arrange
    SetVariableHandler setVariableHandler = new SetVariableHandler();

    SetVariable operation = new SetVariable();
    operation.setVariableName("Operation");
    operation.setInput(null);

    Context context = new Context(new Context());
    context.setVariables(null);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> setVariableHandler.doOperation(operation, context, new TestAddToGraphLibraryImpl()));
  }
}
