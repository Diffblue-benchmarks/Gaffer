package uk.gov.gchq.gaffer.store.operation.handler.named;

import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.named.operation.NamedOperation;
import uk.gov.gchq.gaffer.operation.OperationException;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.Store;
import uk.gov.gchq.gaffer.store.operation.handler.TestAddToGraphLibraryImpl;

class NamedOperationHandlerDiffblueTest {
  /**
   * Test {@link NamedOperationHandler#doOperation(NamedOperation, Context, Store)} with {@code
   * NamedOperation}, {@code Context}, {@code Store}.
   *
   * <p>Method under test: {@link NamedOperationHandler#doOperation(NamedOperation, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(NamedOperation, Context, Store) with 'NamedOperation', 'Context', 'Store'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object NamedOperationHandler.doOperation(NamedOperation, Context, Store)"})
  void testDoOperationWithNamedOperationContextStore() throws OperationException {
    // Arrange
    NamedOperationHandler namedOperationHandler = new NamedOperationHandler();
    NamedOperation<?, Object> operation = new NamedOperation<>();
    Context context = new Context();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            namedOperationHandler.doOperation(operation, context, new TestAddToGraphLibraryImpl()));
  }
}
