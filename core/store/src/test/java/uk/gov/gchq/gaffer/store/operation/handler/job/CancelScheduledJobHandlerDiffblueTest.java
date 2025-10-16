package uk.gov.gchq.gaffer.store.operation.handler.job;

import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.operation.OperationException;
import uk.gov.gchq.gaffer.operation.impl.job.CancelScheduledJob;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.Store;
import uk.gov.gchq.gaffer.store.operation.handler.TestAddToGraphLibraryImpl;

class CancelScheduledJobHandlerDiffblueTest {
  /**
   * Test {@link CancelScheduledJobHandler#doOperation(CancelScheduledJob, Context, Store)} with
   * {@code CancelScheduledJob}, {@code Context}, {@code Store}.
   *
   * <ul>
   *   <li>Then throw {@link OperationException}.
   * </ul>
   *
   * <p>Method under test: {@link CancelScheduledJobHandler#doOperation(CancelScheduledJob, Context,
   * Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(CancelScheduledJob, Context, Store) with 'CancelScheduledJob', 'Context', 'Store'; then throw OperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Void CancelScheduledJobHandler.doOperation(CancelScheduledJob, Context, Store)"
  })
  void testDoOperationWithCancelScheduledJobContextStore_thenThrowOperationException()
      throws OperationException {
    // Arrange
    CancelScheduledJobHandler cancelScheduledJobHandler = new CancelScheduledJobHandler();
    CancelScheduledJob operation = new CancelScheduledJob();
    Context context = new Context();

    // Act and Assert
    assertThrows(
        OperationException.class,
        () ->
            cancelScheduledJobHandler.doOperation(
                operation, context, new TestAddToGraphLibraryImpl()));
  }
}
