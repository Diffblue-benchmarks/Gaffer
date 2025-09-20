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
import uk.gov.gchq.gaffer.commonutil.iterable.StreamFlatMapIterable;
import uk.gov.gchq.gaffer.commonutil.iterable.StreamIterator;
import uk.gov.gchq.gaffer.data.element.id.ElementId;
import uk.gov.gchq.gaffer.operation.OperationException;
import uk.gov.gchq.gaffer.operation.impl.output.ToVertices;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl.IterableObj;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.Store;
import uk.gov.gchq.gaffer.store.operation.handler.TestAddToGraphLibraryImpl;

class ToVerticesHandlerDiffblueTest {
  /**
   * Test {@link ToVerticesHandler#doOperation(ToVertices, Context, Store)} with {@code ToVertices},
   * {@code Context}, {@code Store}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>Then {@link ToVertices} (default constructor) Input {@link List}.
   * </ul>
   *
   * <p>Method under test: {@link ToVerticesHandler#doOperation(ToVertices, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(ToVertices, Context, Store) with 'ToVertices', 'Context', 'Store'; given ArrayList(); then ToVertices (default constructor) Input List")
  @Tag("MaintainedByDiffblue")
  void testDoOperationWithToVerticesContextStore_givenArrayList_thenToVerticesInputList()
      throws OperationException {
    // Arrange
    ToVerticesHandler toVerticesHandler = new ToVerticesHandler();

    ToVertices operation = new ToVertices();
    ArrayList<ElementId> input = new ArrayList<>();
    operation.setInput(input);
    Context context = new Context();
    TestAddToGraphLibraryImpl store = new TestAddToGraphLibraryImpl();

    // Act
    Iterable<Object> actualDoOperationResult =
        toVerticesHandler.doOperation(operation, context, store);
    Iterator<Object> actualIteratorResult = actualDoOperationResult.iterator();

    // Assert
    Iterable<? extends ElementId> input2 = operation.getInput();
    assertTrue(input2 instanceof List);
    assertTrue(actualDoOperationResult instanceof StreamFlatMapIterable);
    Iterator<Object> iteratorResult = actualDoOperationResult.iterator();
    assertTrue(iteratorResult instanceof StreamIterator);
    assertTrue(actualIteratorResult instanceof StreamIterator);
    assertTrue(operation.getOutputTypeReference() instanceof IterableObj);
    assertNull(store.getGraphId());
    assertNull(operation.getOptions());
    assertNull(store.getJobTracker());
    assertNull(context.getOriginalOpChain());
    assertNull(operation.getEdgeVertices());
    assertNull(operation.getUseMatchedVertex());
    assertNull(store.getProperties());
    assertNull(store.getGraphLibrary());
    assertNull(store.getOriginalSchema());
    assertNull(store.getSchema());
    assertFalse(iteratorResult.hasNext());
    assertFalse(actualIteratorResult.hasNext());
    assertTrue(context.getExporters().isEmpty());
    Stream<Object> stream =
        ((StreamFlatMapIterable<Object, Object>) actualDoOperationResult).getStream();
    assertTrue(stream.limit(5).collect(Collectors.toList()).isEmpty());
    assertTrue(store.getOperationChainOptimisers().isEmpty());
    assertTrue(((List<? extends ElementId>) input2).isEmpty());
    assertTrue(context.getVariables().isEmpty());
    assertTrue(store.getSupportedOperations().isEmpty());
    Class<Iterable> expectedOutputClass = Iterable.class;
    assertEquals(expectedOutputClass, operation.getOutputClass());
    assertSame(input, input2);
  }

  /**
   * Test {@link ToVerticesHandler#doOperation(ToVertices, Context, Store)} with {@code ToVertices},
   * {@code Context}, {@code Store}.
   *
   * <ul>
   *   <li>When {@link ToVertices} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ToVerticesHandler#doOperation(ToVertices, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(ToVertices, Context, Store) with 'ToVertices', 'Context', 'Store'; when ToVertices (default constructor); then return 'null'")
  @Tag("MaintainedByDiffblue")
  void testDoOperationWithToVerticesContextStore_whenToVertices_thenReturnNull()
      throws OperationException {
    // Arrange
    ToVerticesHandler toVerticesHandler = new ToVerticesHandler();
    ToVertices operation = new ToVertices();
    Context context = new Context();
    TestAddToGraphLibraryImpl store = new TestAddToGraphLibraryImpl();

    // Act
    Iterable<Object> actualDoOperationResult =
        toVerticesHandler.doOperation(operation, context, store);

    // Assert
    assertTrue(operation.getOutputTypeReference() instanceof IterableObj);
    assertNull(actualDoOperationResult);
    assertNull(operation.getInput());
    assertNull(store.getGraphId());
    assertNull(operation.getOptions());
    assertNull(store.getJobTracker());
    assertNull(context.getOriginalOpChain());
    assertNull(operation.getEdgeVertices());
    assertNull(operation.getUseMatchedVertex());
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
}
