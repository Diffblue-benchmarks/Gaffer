package uk.gov.gchq.gaffer.store.operation.handler;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.named.operation.NamedOperation;
import uk.gov.gchq.gaffer.operation.OperationChain;
import uk.gov.gchq.gaffer.operation.OperationException;
import uk.gov.gchq.gaffer.operation.impl.ForEach;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.Store;

class ForEachHandlerDiffblueTest {
  /**
   * Test {@link ForEachHandler#doOperation(ForEach, Context, Store)} with {@code ForEach}, {@code
   * Context}, {@code Store}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>Then return {@link List}.
   * </ul>
   *
   * <p>Method under test: {@link ForEachHandler#doOperation(ForEach, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(ForEach, Context, Store) with 'ForEach', 'Context', 'Store'; given ArrayList(); then return List")
  @Tag("MaintainedByDiffblue")
  void testDoOperationWithForEachContextStore_givenArrayList_thenReturnList()
      throws OperationException {
    // Arrange
    ForEachHandler<Object, Object> forEachHandler = new ForEachHandler<>();

    ForEach<Object, Object> forEach = new ForEach<>();
    OperationChain<Object> operation = OperationChain.wrap(new NamedOperation<>());
    forEach.setOperation(operation);
    forEach.setInput(new ArrayList<>());
    Context context = new Context();

    // Act
    Iterable<?> actualDoOperationResult =
        forEachHandler.doOperation(forEach, context, new TestAddToGraphLibraryImpl());
    Iterator<?> actualIteratorResult = actualDoOperationResult.iterator();

    // Assert
    assertTrue(actualDoOperationResult instanceof List);
    assertFalse(actualIteratorResult.hasNext());
    assertTrue(((List<?>) actualDoOperationResult).isEmpty());
  }
}
