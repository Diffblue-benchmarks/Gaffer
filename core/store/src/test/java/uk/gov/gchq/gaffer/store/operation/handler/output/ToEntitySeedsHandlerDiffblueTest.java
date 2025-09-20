package uk.gov.gchq.gaffer.store.operation.handler.output;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.commonutil.iterable.StreamIterator;
import uk.gov.gchq.gaffer.commonutil.iterable.StreamMapIterable;
import uk.gov.gchq.gaffer.operation.OperationException;
import uk.gov.gchq.gaffer.operation.data.EntitySeed;
import uk.gov.gchq.gaffer.operation.impl.output.ToEntitySeeds;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl.IterableEntitySeed;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.Store;
import uk.gov.gchq.gaffer.store.operation.handler.TestAddToGraphLibraryImpl;

class ToEntitySeedsHandlerDiffblueTest {
  /**
   * Test {@link ToEntitySeedsHandler#doOperation(ToEntitySeeds, Context, Store)} with {@code
   * ToEntitySeeds}, {@code Context}, {@code Store}.
   *
   * <ul>
   *   <li>Then {@link ToEntitySeeds} (default constructor) Input is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ToEntitySeedsHandler#doOperation(ToEntitySeeds, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(ToEntitySeeds, Context, Store) with 'ToEntitySeeds', 'Context', 'Store'; then ToEntitySeeds (default constructor) Input is 'null'")
  @Tag("MaintainedByDiffblue")
  void testDoOperationWithToEntitySeedsContextStore_thenToEntitySeedsInputIsNull()
      throws OperationException {
    // Arrange
    ToEntitySeedsHandler toEntitySeedsHandler = new ToEntitySeedsHandler();
    ToEntitySeeds operation = new ToEntitySeeds();
    Context context = new Context();
    TestAddToGraphLibraryImpl store = new TestAddToGraphLibraryImpl();

    // Act
    Iterable<EntitySeed> actualDoOperationResult =
        toEntitySeedsHandler.doOperation(operation, context, store);

    // Assert
    assertTrue(operation.getOutputTypeReference() instanceof IterableEntitySeed);
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
    Class<Iterable> expectedOutputClass = Iterable.class;
    assertEquals(expectedOutputClass, operation.getOutputClass());
  }

  /**
   * Test {@link ToEntitySeedsHandler#doOperation(ToEntitySeeds, Context, Store)} with {@code
   * ToEntitySeeds}, {@code Context}, {@code Store}.
   *
   * <ul>
   *   <li>Then {@link ToEntitySeeds} (default constructor) Input {@link List}.
   * </ul>
   *
   * <p>Method under test: {@link ToEntitySeedsHandler#doOperation(ToEntitySeeds, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(ToEntitySeeds, Context, Store) with 'ToEntitySeeds', 'Context', 'Store'; then ToEntitySeeds (default constructor) Input List")
  @Tag("MaintainedByDiffblue")
  void testDoOperationWithToEntitySeedsContextStore_thenToEntitySeedsInputList()
      throws OperationException {
    // Arrange
    ToEntitySeedsHandler toEntitySeedsHandler = new ToEntitySeedsHandler();

    ToEntitySeeds operation = new ToEntitySeeds();
    ArrayList<Object> input = new ArrayList<>();
    operation.setInput(input);
    Context context = new Context();
    TestAddToGraphLibraryImpl store = new TestAddToGraphLibraryImpl();

    // Act
    Iterable<EntitySeed> actualDoOperationResult =
        toEntitySeedsHandler.doOperation(operation, context, store);
    Iterator<EntitySeed> actualIteratorResult = actualDoOperationResult.iterator();

    // Assert
    Iterable<?> input2 = operation.getInput();
    assertTrue(input2 instanceof List);
    Iterator<EntitySeed> iteratorResult = actualDoOperationResult.iterator();
    assertTrue(iteratorResult instanceof StreamIterator);
    assertTrue(actualIteratorResult instanceof StreamIterator);
    assertTrue(actualDoOperationResult instanceof StreamMapIterable);
    assertTrue(operation.getOutputTypeReference() instanceof IterableEntitySeed);
    assertNull(store.getGraphId());
    assertNull(operation.getOptions());
    assertNull(store.getJobTracker());
    assertNull(context.getOriginalOpChain());
    assertNull(store.getProperties());
    assertNull(store.getGraphLibrary());
    assertNull(store.getOriginalSchema());
    assertNull(store.getSchema());
    assertFalse(iteratorResult.hasNext());
    assertFalse(actualIteratorResult.hasNext());
    assertTrue(context.getExporters().isEmpty());
    Stream<EntitySeed> stream =
        ((StreamMapIterable<Object, EntitySeed>) actualDoOperationResult).getStream();
    assertTrue(stream.limit(5).collect(Collectors.toList()).isEmpty());
    assertTrue(store.getOperationChainOptimisers().isEmpty());
    assertTrue(((List<?>) input2).isEmpty());
    assertTrue(context.getVariables().isEmpty());
    assertTrue(store.getSupportedOperations().isEmpty());
    Class<Iterable> expectedOutputClass = Iterable.class;
    assertEquals(expectedOutputClass, operation.getOutputClass());
    assertSame(input, input2);
  }
}
