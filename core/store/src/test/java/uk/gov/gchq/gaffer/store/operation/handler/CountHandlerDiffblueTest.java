package uk.gov.gchq.gaffer.store.operation.handler;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.operation.OperationException;
import uk.gov.gchq.gaffer.operation.impl.Count;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.Store;

class CountHandlerDiffblueTest {
  /**
   * Test {@link CountHandler#doOperation(Count, Context, Store)} with {@code Count}, {@code
   * Context}, {@code Store}.
   *
   * <ul>
   *   <li>When {@link Count} (default constructor).
   *   <li>Then throw {@link OperationException}.
   * </ul>
   *
   * <p>Method under test: {@link CountHandler#doOperation(Count, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(Count, Context, Store) with 'Count', 'Context', 'Store'; when Count (default constructor); then throw OperationException")
  @Tag("MaintainedByDiffblue")
  void testDoOperationWithCountContextStore_whenCount_thenThrowOperationException()
      throws OperationException {
    // Arrange
    CountHandler<Object> countHandler = new CountHandler<>();
    Count operation = new Count();
    Context context = new Context();

    // Act and Assert
    assertThrows(
        OperationException.class,
        () -> countHandler.doOperation(operation, context, new TestAddToGraphLibraryImpl()));
  }
}
