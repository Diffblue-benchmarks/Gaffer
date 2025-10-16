package uk.gov.gchq.gaffer.accumulostore.operation.hdfs.handler;

import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.accumulostore.AccumuloStore;
import uk.gov.gchq.gaffer.operation.OperationException;
import uk.gov.gchq.gaffer.operation.impl.SplitStoreFromIterable;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.Store;

class SplitStoreFromIterableHandlerDiffblueTest {
  /**
   * Test {@link SplitStoreFromIterableHandler#doOperation(SplitStoreFromIterable, Context, Store)}
   * with {@code operation}, {@code context}, {@code store}.
   *
   * <ul>
   *   <li>Then throw {@link OperationException}.
   * </ul>
   *
   * <p>Method under test: {@link SplitStoreFromIterableHandler#doOperation(SplitStoreFromIterable,
   * Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(SplitStoreFromIterable, Context, Store) with 'operation', 'context', 'store'; then throw OperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Void SplitStoreFromIterableHandler.doOperation(SplitStoreFromIterable, Context, Store)"
  })
  void testDoOperationWithOperationContextStore_thenThrowOperationException()
      throws OperationException {
    // Arrange
    SplitStoreFromIterableHandler splitStoreFromIterableHandler =
        new SplitStoreFromIterableHandler();
    SplitStoreFromIterable<String> operation = new SplitStoreFromIterable<>();
    Context context = new Context();

    // Act and Assert
    assertThrows(
        OperationException.class,
        () -> splitStoreFromIterableHandler.doOperation(operation, context, new AccumuloStore()));
  }
}
