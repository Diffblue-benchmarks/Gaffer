package uk.gov.gchq.gaffer.store.operation.handler.output;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.operation.OperationException;
import uk.gov.gchq.gaffer.operation.impl.output.ToSet;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.Store;
import uk.gov.gchq.gaffer.store.operation.handler.TestAddToGraphLibraryImpl;

class ToSetHandlerDiffblueTest {
  /**
   * Test {@link ToSetHandler#doOperation(ToSet, Context, Store)} with {@code ToSet}, {@code
   * Context}, {@code Store}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link ToSetHandler#doOperation(ToSet, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(ToSet, Context, Store) with 'ToSet', 'Context', 'Store'; given ArrayList(); then return Empty")
  @Tag("MaintainedByDiffblue")
  void testDoOperationWithToSetContextStore_givenArrayList_thenReturnEmpty()
      throws OperationException {
    // Arrange
    ToSetHandler<Object> toSetHandler = new ToSetHandler<>();

    ToSet<Object> operation = new ToSet<>();
    operation.setInput(new ArrayList<>());
    Context context = new Context();

    // Act and Assert
    assertTrue(
        toSetHandler.doOperation(operation, context, new TestAddToGraphLibraryImpl()).isEmpty());
  }

  /**
   * Test {@link ToSetHandler#doOperation(ToSet, Context, Store)} with {@code ToSet}, {@code
   * Context}, {@code Store}.
   *
   * <ul>
   *   <li>When {@link ToSet} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ToSetHandler#doOperation(ToSet, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(ToSet, Context, Store) with 'ToSet', 'Context', 'Store'; when ToSet (default constructor); then return 'null'")
  @Tag("MaintainedByDiffblue")
  void testDoOperationWithToSetContextStore_whenToSet_thenReturnNull() throws OperationException {
    // Arrange
    ToSetHandler<Object> toSetHandler = new ToSetHandler<>();
    ToSet<Object> operation = new ToSet<>();
    Context context = new Context();

    // Act and Assert
    assertNull(toSetHandler.doOperation(operation, context, new TestAddToGraphLibraryImpl()));
  }
}
