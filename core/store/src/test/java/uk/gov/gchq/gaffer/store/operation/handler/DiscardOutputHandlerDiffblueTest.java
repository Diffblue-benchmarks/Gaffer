package uk.gov.gchq.gaffer.store.operation.handler;

import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.operation.OperationException;
import uk.gov.gchq.gaffer.operation.impl.DiscardOutput;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.Store;

class DiscardOutputHandlerDiffblueTest {
  /**
   * Test {@link DiscardOutputHandler#doOperation(DiscardOutput, Context, Store)} with {@code
   * DiscardOutput}, {@code Context}, {@code Store}.
   *
   * <p>Method under test: {@link DiscardOutputHandler#doOperation(DiscardOutput, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(DiscardOutput, Context, Store) with 'DiscardOutput', 'Context', 'Store'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Void DiscardOutputHandler.doOperation(DiscardOutput, Context, Store)"
  })
  void testDoOperationWithDiscardOutputContextStore() throws OperationException {
    // Arrange
    DiscardOutputHandler discardOutputHandler = new DiscardOutputHandler();
    DiscardOutput operation = new DiscardOutput();
    Context context = new Context();

    // Act and Assert
    assertNull(
        discardOutputHandler.doOperation(operation, context, new TestAddToGraphLibraryImpl()));
  }
}
