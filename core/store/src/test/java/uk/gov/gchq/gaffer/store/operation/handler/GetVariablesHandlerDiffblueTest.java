package uk.gov.gchq.gaffer.store.operation.handler;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.operation.OperationException;
import uk.gov.gchq.gaffer.operation.impl.GetVariables;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.Store;

class GetVariablesHandlerDiffblueTest {
  /**
   * Test {@link GetVariablesHandler#doOperation(GetVariables, Context, Store)} with {@code
   * GetVariables}, {@code Context}, {@code Store}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link GetVariablesHandler#doOperation(GetVariables, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(GetVariables, Context, Store) with 'GetVariables', 'Context', 'Store'; given ArrayList() add 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map GetVariablesHandler.doOperation(GetVariables, Context, Store)"})
  void testDoOperationWithGetVariablesContextStore_givenArrayListAddNull()
      throws OperationException {
    // Arrange
    GetVariablesHandler getVariablesHandler = new GetVariablesHandler();

    ArrayList<String> variableNames = new ArrayList<>();
    variableNames.add(null);

    GetVariables operation = new GetVariables();
    operation.setVariableNames(variableNames);
    Context context = new Context();

    // Act and Assert
    assertTrue(
        getVariablesHandler
            .doOperation(operation, context, new TestAddToGraphLibraryImpl())
            .isEmpty());
  }

  /**
   * Test {@link GetVariablesHandler#doOperation(GetVariables, Context, Store)} with {@code
   * GetVariables}, {@code Context}, {@code Store}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link GetVariablesHandler#doOperation(GetVariables, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(GetVariables, Context, Store) with 'GetVariables', 'Context', 'Store'; given ArrayList(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map GetVariablesHandler.doOperation(GetVariables, Context, Store)"})
  void testDoOperationWithGetVariablesContextStore_givenArrayList_thenReturnEmpty()
      throws OperationException {
    // Arrange
    GetVariablesHandler getVariablesHandler = new GetVariablesHandler();

    GetVariables operation = new GetVariables();
    operation.setVariableNames(new ArrayList<>());
    Context context = new Context();

    // Act and Assert
    assertTrue(
        getVariablesHandler
            .doOperation(operation, context, new TestAddToGraphLibraryImpl())
            .isEmpty());
  }

  /**
   * Test {@link GetVariablesHandler#doOperation(GetVariables, Context, Store)} with {@code
   * GetVariables}, {@code Context}, {@code Store}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link GetVariablesHandler#doOperation(GetVariables, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(GetVariables, Context, Store) with 'GetVariables', 'Context', 'Store'; then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map GetVariablesHandler.doOperation(GetVariables, Context, Store)"})
  void testDoOperationWithGetVariablesContextStore_thenReturnSizeIsOne() throws OperationException {
    // Arrange
    GetVariablesHandler getVariablesHandler = new GetVariablesHandler();

    ArrayList<String> variableNames = new ArrayList<>();
    variableNames.add("Operation");

    GetVariables operation = new GetVariables();
    operation.setVariableNames(variableNames);
    Context context = new Context();

    // Act
    Map<String, Object> actualDoOperationResult =
        getVariablesHandler.doOperation(operation, context, new TestAddToGraphLibraryImpl());

    // Assert
    assertEquals(1, actualDoOperationResult.size());
    assertNull(actualDoOperationResult.get("Operation"));
  }

  /**
   * Test {@link GetVariablesHandler#doOperation(GetVariables, Context, Store)} with {@code
   * GetVariables}, {@code Context}, {@code Store}.
   *
   * <ul>
   *   <li>When {@link GetVariables} (default constructor).
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link GetVariablesHandler#doOperation(GetVariables, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(GetVariables, Context, Store) with 'GetVariables', 'Context', 'Store'; when GetVariables (default constructor); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map GetVariablesHandler.doOperation(GetVariables, Context, Store)"})
  void testDoOperationWithGetVariablesContextStore_whenGetVariables_thenReturnEmpty()
      throws OperationException {
    // Arrange
    GetVariablesHandler getVariablesHandler = new GetVariablesHandler();
    GetVariables operation = new GetVariables();
    Context context = new Context();

    // Act and Assert
    assertTrue(
        getVariablesHandler
            .doOperation(operation, context, new TestAddToGraphLibraryImpl())
            .isEmpty());
  }
}
