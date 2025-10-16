package uk.gov.gchq.gaffer.federatedstore.operation.handler.impl;

import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.accumulostore.AccumuloStore;
import uk.gov.gchq.gaffer.federatedstore.FederatedStore;
import uk.gov.gchq.gaffer.federatedstore.FederatedStoreTestUtil;
import uk.gov.gchq.gaffer.federatedstore.operation.FederatedOperation;
import uk.gov.gchq.gaffer.operation.OperationException;
import uk.gov.gchq.gaffer.operation.io.Output;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.Store;

class FederatedOutputHandlerDiffblueTest {
  /**
   * Test {@link FederatedOutputHandler#doOperation(Output, Context, Store)} with {@code Output},
   * {@code Context}, {@code Store}.
   *
   * <ul>
   *   <li>When {@link AccumuloStore} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link FederatedOutputHandler#doOperation(Output, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(Output, Context, Store) with 'Output', 'Context', 'Store'; when AccumuloStore (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object FederatedOutputHandler.doOperation(Output, Context, Store)"})
  void testDoOperationWithOutputContextStore_whenAccumuloStore() throws OperationException {
    // Arrange
    FederatedOutputHandler<Output<Object>, Object> federatedOutputHandler =
        new FederatedOutputHandler<>();
    FederatedOperation<Object, Object> federatedOperation = new FederatedOperation<>();
    Context context = FederatedStoreTestUtil.contextAuthUser();

    // Act and Assert
    assertThrows(
        OperationException.class,
        () -> federatedOutputHandler.doOperation(federatedOperation, context, new AccumuloStore()));
  }

  /**
   * Test {@link FederatedOutputHandler#doOperation(Output, Context, Store)} with {@code Output},
   * {@code Context}, {@code Store}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link OperationException}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedOutputHandler#doOperation(Output, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(Output, Context, Store) with 'Output', 'Context', 'Store'; when 'null'; then throw OperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object FederatedOutputHandler.doOperation(Output, Context, Store)"})
  void testDoOperationWithOutputContextStore_whenNull_thenThrowOperationException()
      throws OperationException {
    // Arrange
    FederatedOutputHandler<Output<Object>, Object> federatedOutputHandler =
        new FederatedOutputHandler<>();
    Context context = FederatedStoreTestUtil.contextAuthUser();
    HashSet<String> customPropertiesAuths = new HashSet<>();
    ArrayList<String> storeConfiguredGraphIds = new ArrayList<>();

    // Act and Assert
    assertThrows(
        OperationException.class,
        () ->
            federatedOutputHandler.doOperation(
                null,
                context,
                new FederatedStore(
                    customPropertiesAuths, true, storeConfiguredGraphIds, new HashMap<>())));
  }
}
