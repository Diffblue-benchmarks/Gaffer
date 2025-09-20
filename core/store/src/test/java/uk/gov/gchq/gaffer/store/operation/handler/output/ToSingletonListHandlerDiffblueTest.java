package uk.gov.gchq.gaffer.store.operation.handler.output;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.operation.OperationException;
import uk.gov.gchq.gaffer.operation.impl.output.ToSingletonList;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.Store;
import uk.gov.gchq.gaffer.store.operation.handler.TestAddToGraphLibraryImpl;

class ToSingletonListHandlerDiffblueTest {
  /**
   * Test {@link ToSingletonListHandler#doOperation(ToSingletonList, Context, Store)} with {@code
   * ToSingletonList}, {@code Context}, {@code Store}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link ToSingletonListHandler#doOperation(ToSingletonList, Context,
   * Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(ToSingletonList, Context, Store) with 'ToSingletonList', 'Context', 'Store'; then return size is one")
  @Tag("MaintainedByDiffblue")
  void testDoOperationWithToSingletonListContextStore_thenReturnSizeIsOne()
      throws OperationException {
    // Arrange
    ToSingletonListHandler<Object> toSingletonListHandler = new ToSingletonListHandler<>();

    ToSingletonList<Object> operation = new ToSingletonList<>();
    operation.setInput("Operation");
    Context context = new Context();

    // Act
    List<?> actualDoOperationResult =
        toSingletonListHandler.doOperation(operation, context, new TestAddToGraphLibraryImpl());

    // Assert
    assertEquals(1, actualDoOperationResult.size());
    assertEquals("Operation", actualDoOperationResult.get(0));
  }

  /**
   * Test {@link ToSingletonListHandler#doOperation(ToSingletonList, Context, Store)} with {@code
   * ToSingletonList}, {@code Context}, {@code Store}.
   *
   * <ul>
   *   <li>Then throw {@link OperationException}.
   * </ul>
   *
   * <p>Method under test: {@link ToSingletonListHandler#doOperation(ToSingletonList, Context,
   * Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(ToSingletonList, Context, Store) with 'ToSingletonList', 'Context', 'Store'; then throw OperationException")
  @Tag("MaintainedByDiffblue")
  void testDoOperationWithToSingletonListContextStore_thenThrowOperationException()
      throws OperationException {
    // Arrange
    ToSingletonListHandler<Object> toSingletonListHandler = new ToSingletonListHandler<>();
    ToSingletonList<Object> operation = new ToSingletonList<>();
    Context context = new Context();

    // Act and Assert
    assertThrows(
        OperationException.class,
        () ->
            toSingletonListHandler.doOperation(
                operation, context, new TestAddToGraphLibraryImpl()));
  }
}
