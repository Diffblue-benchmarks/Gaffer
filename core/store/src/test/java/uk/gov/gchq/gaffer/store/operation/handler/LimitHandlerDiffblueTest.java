package uk.gov.gchq.gaffer.store.operation.handler;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.operation.OperationException;
import uk.gov.gchq.gaffer.operation.impl.Limit;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl.IterableObj;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.Store;
import uk.gov.gchq.koryphe.iterable.LimitedIterable;
import uk.gov.gchq.koryphe.iterable.LimitedIterator;

class LimitHandlerDiffblueTest {
  /**
   * Test {@link LimitHandler#doOperation(Limit, Context, Store)} with {@code Limit}, {@code
   * Context}, {@code Store}.
   *
   * <ul>
   *   <li>Then {@link Limit#Limit()} OutputTypeReference {@link TypeReferenceImpl.IterableObj}.
   * </ul>
   *
   * <p>Method under test: {@link LimitHandler#doOperation(Limit, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(Limit, Context, Store) with 'Limit', 'Context', 'Store'; then Limit() OutputTypeReference IterableObj")
  @Tag("MaintainedByDiffblue")
  void testDoOperationWithLimitContextStore_thenLimitOutputTypeReferenceIterableObj()
      throws OperationException {
    // Arrange
    LimitHandler<Object> limitHandler = new LimitHandler<>();
    Limit<Object> operation = new Limit<>();
    Context context = new Context();
    TestAddToGraphLibraryImpl store = new TestAddToGraphLibraryImpl();

    // Act
    Iterable<?> actualDoOperationResult = limitHandler.doOperation(operation, context, store);

    // Assert
    assertTrue(operation.getOutputTypeReference() instanceof IterableObj);
    assertNull(operation.getResultLimit());
    assertNull(operation.getInput());
    assertNull(actualDoOperationResult);
    assertNull(store.getGraphId());
    assertNull(operation.getOptions());
    assertNull(store.getJobTracker());
    assertNull(context.getOriginalOpChain());
    assertNull(store.getProperties());
    assertNull(store.getGraphLibrary());
    assertNull(store.getOriginalSchema());
    assertNull(store.getSchema());
    assertTrue(context.getExporters().isEmpty());
    assertTrue(store.getOperationChainOptimisers().isEmpty());
    assertTrue(context.getVariables().isEmpty());
    assertTrue(store.getSupportedOperations().isEmpty());
    assertTrue(operation.getTruncate());
    Class<Iterable> expectedOutputClass = Iterable.class;
    assertEquals(expectedOutputClass, operation.getOutputClass());
  }

  /**
   * Test {@link LimitHandler#doOperation(Limit, Context, Store)} with {@code Limit}, {@code
   * Context}, {@code Store}.
   *
   * <ul>
   *   <li>Then {@link Limit#Limit(Integer)} with resultLimit is zero Input {@link List}.
   * </ul>
   *
   * <p>Method under test: {@link LimitHandler#doOperation(Limit, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(Limit, Context, Store) with 'Limit', 'Context', 'Store'; then Limit(Integer) with resultLimit is zero Input List")
  @Tag("MaintainedByDiffblue")
  void testDoOperationWithLimitContextStore_thenLimitWithResultLimitIsZeroInputList()
      throws OperationException {
    // Arrange
    LimitHandler<Object> limitHandler = new LimitHandler<>();

    Limit<Object> operation = new Limit<>(0);
    ArrayList<Object> input = new ArrayList<>();
    operation.setInput(input);
    Context context = new Context();
    TestAddToGraphLibraryImpl store = new TestAddToGraphLibraryImpl();

    // Act
    Iterable<?> actualDoOperationResult = limitHandler.doOperation(operation, context, store);
    Iterator<?> actualIteratorResult = actualDoOperationResult.iterator();

    // Assert
    Iterable<?> input2 = operation.getInput();
    assertTrue(input2 instanceof List);
    assertTrue(operation.getOutputTypeReference() instanceof IterableObj);
    assertTrue(actualDoOperationResult instanceof LimitedIterable);
    assertTrue(actualIteratorResult instanceof LimitedIterator);
    assertNull(store.getGraphId());
    assertNull(operation.getOptions());
    assertNull(store.getJobTracker());
    assertNull(context.getOriginalOpChain());
    assertNull(store.getProperties());
    assertNull(store.getGraphLibrary());
    assertNull(store.getOriginalSchema());
    assertNull(store.getSchema());
    assertEquals(0, operation.getResultLimit().intValue());
    assertEquals(0, ((LimitedIterable<?>) actualDoOperationResult).getEnd().intValue());
    assertEquals(0, ((LimitedIterable<?>) actualDoOperationResult).getStart());
    assertFalse(actualIteratorResult.hasNext());
    assertTrue(context.getExporters().isEmpty());
    assertTrue(store.getOperationChainOptimisers().isEmpty());
    assertTrue(((List<?>) input2).isEmpty());
    assertTrue(context.getVariables().isEmpty());
    assertTrue(store.getSupportedOperations().isEmpty());
    assertTrue(operation.getTruncate());
    Class<Iterable> expectedOutputClass = Iterable.class;
    assertEquals(expectedOutputClass, operation.getOutputClass());
    assertSame(input, input2);
  }

  /**
   * Test {@link LimitHandler#doOperation(Limit, Context, Store)} with {@code Limit}, {@code
   * Context}, {@code Store}.
   *
   * <ul>
   *   <li>Then return {@link List}.
   * </ul>
   *
   * <p>Method under test: {@link LimitHandler#doOperation(Limit, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(Limit, Context, Store) with 'Limit', 'Context', 'Store'; then return List")
  @Tag("MaintainedByDiffblue")
  void testDoOperationWithLimitContextStore_thenReturnList() throws OperationException {
    // Arrange
    LimitHandler<Object> limitHandler = new LimitHandler<>();

    Limit<Object> operation = new Limit<>(null);
    ArrayList<Object> input = new ArrayList<>();
    operation.setInput(input);
    Context context = new Context();
    TestAddToGraphLibraryImpl store = new TestAddToGraphLibraryImpl();

    // Act
    Iterable<?> actualDoOperationResult = limitHandler.doOperation(operation, context, store);
    Iterator<?> actualIteratorResult = actualDoOperationResult.iterator();

    // Assert
    assertTrue(actualDoOperationResult instanceof List);
    assertTrue(operation.getOutputTypeReference() instanceof IterableObj);
    assertNull(operation.getResultLimit());
    assertNull(store.getGraphId());
    assertNull(operation.getOptions());
    assertNull(store.getJobTracker());
    assertNull(context.getOriginalOpChain());
    assertNull(store.getProperties());
    assertNull(store.getGraphLibrary());
    assertNull(store.getOriginalSchema());
    assertNull(store.getSchema());
    assertFalse(actualIteratorResult.hasNext());
    assertTrue(context.getExporters().isEmpty());
    assertTrue(store.getOperationChainOptimisers().isEmpty());
    assertTrue(((List<?>) actualDoOperationResult).isEmpty());
    assertTrue(context.getVariables().isEmpty());
    assertTrue(store.getSupportedOperations().isEmpty());
    assertTrue(operation.getTruncate());
    Class<Iterable> expectedOutputClass = Iterable.class;
    assertEquals(expectedOutputClass, operation.getOutputClass());
    assertSame(input, operation.getInput());
  }
}
