package uk.gov.gchq.gaffer.store.operation.handler;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.operation.OperationException;
import uk.gov.gchq.gaffer.operation.impl.get.GetGraphCreatedTime;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.Store;

class GetGraphCreatedTimeHandlerDiffblueTest {
  /**
   * Test {@link GetGraphCreatedTimeHandler#doOperation(GetGraphCreatedTime, Context, Store)} with
   * {@code GetGraphCreatedTime}, {@code Context}, {@code Store}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link GetGraphCreatedTimeHandler#doOperation(GetGraphCreatedTime,
   * Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(GetGraphCreatedTime, Context, Store) with 'GetGraphCreatedTime', 'Context', 'Store'; then return size is one")
  @Tag("MaintainedByDiffblue")
  void testDoOperationWithGetGraphCreatedTimeContextStore_thenReturnSizeIsOne()
      throws OperationException {
    // Arrange
    GetGraphCreatedTimeHandler getGraphCreatedTimeHandler = new GetGraphCreatedTimeHandler();
    GetGraphCreatedTime operation = new GetGraphCreatedTime();
    Context context = new Context();

    // Act and Assert
    assertEquals(
        1,
        getGraphCreatedTimeHandler
            .doOperation(operation, context, new TestAddToGraphLibraryImpl())
            .size());
  }
}
