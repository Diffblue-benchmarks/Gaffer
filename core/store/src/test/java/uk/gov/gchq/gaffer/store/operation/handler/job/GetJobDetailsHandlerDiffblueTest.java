package uk.gov.gchq.gaffer.store.operation.handler.job;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.operation.OperationException;
import uk.gov.gchq.gaffer.operation.impl.job.GetJobDetails;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.Store;
import uk.gov.gchq.gaffer.store.operation.handler.TestAddToGraphLibraryImpl;

class GetJobDetailsHandlerDiffblueTest {
  /**
   * Test {@link GetJobDetailsHandler#doOperation(GetJobDetails, Context, Store)} with {@code
   * GetJobDetails}, {@code Context}, {@code Store}.
   *
   * <ul>
   *   <li>Then throw {@link OperationException}.
   * </ul>
   *
   * <p>Method under test: {@link GetJobDetailsHandler#doOperation(GetJobDetails, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(GetJobDetails, Context, Store) with 'GetJobDetails', 'Context', 'Store'; then throw OperationException")
  @Tag("MaintainedByDiffblue")
  void testDoOperationWithGetJobDetailsContextStore_thenThrowOperationException()
      throws OperationException {
    // Arrange
    GetJobDetailsHandler getJobDetailsHandler = new GetJobDetailsHandler();
    GetJobDetails operation = new GetJobDetails();
    Context context = new Context();

    // Act and Assert
    assertThrows(
        OperationException.class,
        () ->
            getJobDetailsHandler.doOperation(operation, context, new TestAddToGraphLibraryImpl()));
  }
}
