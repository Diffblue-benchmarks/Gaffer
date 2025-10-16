package uk.gov.gchq.gaffer.accumulostore.operation.handler;

import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.accumulostore.AccumuloStore;
import uk.gov.gchq.gaffer.operation.OperationException;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.Context.Builder;
import uk.gov.gchq.gaffer.store.Store;
import uk.gov.gchq.gaffer.store.operation.DeleteAllData;
import uk.gov.gchq.gaffer.user.User;

class DeleteAllDataHandlerDiffblueTest {
  /**
   * Test {@link DeleteAllDataHandler#doOperation(DeleteAllData, Context, Store)} with {@code
   * DeleteAllData}, {@code Context}, {@code Store}.
   *
   * <p>Method under test: {@link DeleteAllDataHandler#doOperation(DeleteAllData, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(DeleteAllData, Context, Store) with 'DeleteAllData', 'Context', 'Store'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Object DeleteAllDataHandler.doOperation(DeleteAllData, Context, Store)"
  })
  void testDoOperationWithDeleteAllDataContextStore() throws OperationException {
    // Arrange
    DeleteAllDataHandler deleteAllDataHandler = new DeleteAllDataHandler();
    DeleteAllData operation = new DeleteAllData();

    Builder builder = new Builder();
    Context context = builder.user(new User.Builder().userId("42").build()).build();

    // Act and Assert
    assertThrows(
        OperationException.class,
        () -> deleteAllDataHandler.doOperation(operation, context, new AccumuloStore()));
  }

  /**
   * Test {@link DeleteAllDataHandler#doOperation(DeleteAllData, Context, Store)} with {@code
   * DeleteAllData}, {@code Context}, {@code Store}.
   *
   * <ul>
   *   <li>Then throw {@link OperationException}.
   * </ul>
   *
   * <p>Method under test: {@link DeleteAllDataHandler#doOperation(DeleteAllData, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(DeleteAllData, Context, Store) with 'DeleteAllData', 'Context', 'Store'; then throw OperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Object DeleteAllDataHandler.doOperation(DeleteAllData, Context, Store)"
  })
  void testDoOperationWithDeleteAllDataContextStore_thenThrowOperationException()
      throws OperationException {
    // Arrange
    DeleteAllDataHandler deleteAllDataHandler = new DeleteAllDataHandler();
    DeleteAllData operation = new DeleteAllData();
    Context context = new Context();

    // Act and Assert
    assertThrows(
        OperationException.class,
        () -> deleteAllDataHandler.doOperation(operation, context, new AccumuloStore()));
  }
}
