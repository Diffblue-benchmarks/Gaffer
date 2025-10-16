package uk.gov.gchq.gaffer.federated.simple.operation.handler;

import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.federated.simple.FederatedStore;
import uk.gov.gchq.gaffer.named.operation.NamedOperation;
import uk.gov.gchq.gaffer.operation.OperationChain;
import uk.gov.gchq.gaffer.operation.OperationException;
import uk.gov.gchq.gaffer.operation.io.Output;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.Store;

class SeparateOutputHandlerDiffblueTest {
  /**
   * Test {@link SeparateOutputHandler#doOperation(Output, Context, Store)} with {@code Output},
   * {@code Context}, {@code Store}.
   *
   * <p>Method under test: {@link SeparateOutputHandler#doOperation(Output, Context, Store)}
   */
  @Test
  @DisplayName("Test doOperation(Output, Context, Store) with 'Output', 'Context', 'Store'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Map SeparateOutputHandler.doOperation(Output, Context, Store)"})
  void testDoOperationWithOutputContextStore() throws OperationException {
    // Arrange
    SeparateOutputHandler<Output<Object>, Object> separateOutputHandler =
        new SeparateOutputHandler<>();

    NamedOperation<Object, Object> namedOperation = new NamedOperation<>();
    namedOperation.addOption(FederatedOperationHandler.OPT_FIX_OP_LIMIT, "42");
    Context context = new Context();

    // Act and Assert
    assertTrue(
        separateOutputHandler.doOperation(namedOperation, context, new FederatedStore()).isEmpty());
  }

  /**
   * Test {@link SeparateOutputHandler#doOperation(Output, Context, Store)} with {@code Output},
   * {@code Context}, {@code Store}.
   *
   * <ul>
   *   <li>When {@link NamedOperation} (default constructor).
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link SeparateOutputHandler#doOperation(Output, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(Output, Context, Store) with 'Output', 'Context', 'Store'; when NamedOperation (default constructor); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Map SeparateOutputHandler.doOperation(Output, Context, Store)"})
  void testDoOperationWithOutputContextStore_whenNamedOperation_thenReturnEmpty()
      throws OperationException {
    // Arrange
    SeparateOutputHandler<Output<Object>, Object> separateOutputHandler =
        new SeparateOutputHandler<>();
    NamedOperation<Object, Object> namedOperation = new NamedOperation<>();
    Context context = new Context();

    // Act and Assert
    assertTrue(
        separateOutputHandler.doOperation(namedOperation, context, new FederatedStore()).isEmpty());
  }

  /**
   * Test {@link SeparateOutputHandler#doOperation(Output, Context, Store)} with {@code Output},
   * {@code Context}, {@code Store}.
   *
   * <ul>
   *   <li>When wrap {@link NamedOperation} (default constructor).
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link SeparateOutputHandler#doOperation(Output, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(Output, Context, Store) with 'Output', 'Context', 'Store'; when wrap NamedOperation (default constructor); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Map SeparateOutputHandler.doOperation(Output, Context, Store)"})
  void testDoOperationWithOutputContextStore_whenWrapNamedOperation_thenReturnEmpty()
      throws OperationException {
    // Arrange
    SeparateOutputHandler<Output<Object>, Object> separateOutputHandler =
        new SeparateOutputHandler<>();
    OperationChain<Object> wrapResult = OperationChain.wrap(new NamedOperation<>());
    Context context = new Context();

    // Act and Assert
    assertTrue(
        separateOutputHandler.doOperation(wrapResult, context, new FederatedStore()).isEmpty());
  }
}
