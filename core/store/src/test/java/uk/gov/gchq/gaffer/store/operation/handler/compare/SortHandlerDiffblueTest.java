package uk.gov.gchq.gaffer.store.operation.handler.compare;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.commonutil.iterable.LimitedInMemorySortedIterable;
import uk.gov.gchq.gaffer.data.element.Element;
import uk.gov.gchq.gaffer.operation.OperationException;
import uk.gov.gchq.gaffer.operation.impl.compare.Sort;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl.IterableElement;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.Store;
import uk.gov.gchq.gaffer.store.operation.handler.TestAddToGraphLibraryImpl;

class SortHandlerDiffblueTest {
  /**
   * Test {@link SortHandler#doOperation(Sort, Context, Store)} with {@code Sort}, {@code Context},
   * {@code Store}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>Then return size is zero.
   * </ul>
   *
   * <p>Method under test: {@link SortHandler#doOperation(Sort, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(Sort, Context, Store) with 'Sort', 'Context', 'Store'; given ArrayList(); then return size is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable SortHandler.doOperation(Sort, Context, Store)"})
  void testDoOperationWithSortContextStore_givenArrayList_thenReturnSizeIsZero()
      throws OperationException {
    // Arrange
    SortHandler sortHandler = new SortHandler();

    ArrayList<Comparator<Element>> comparators = new ArrayList<>();
    comparators.add(mock(Comparator.class));

    Sort operation = new Sort();
    ArrayList<Element> input = new ArrayList<>();
    operation.setInput(input);
    operation.setComparators(comparators);
    operation.setResultLimit(null);
    Context context = new Context();
    TestAddToGraphLibraryImpl store = new TestAddToGraphLibraryImpl();

    // Act
    Iterable<? extends Element> actualDoOperationResult =
        sortHandler.doOperation(operation, context, store);

    // Assert
    Iterable<? extends Element> input2 = operation.getInput();
    assertTrue(input2 instanceof List);
    assertTrue(actualDoOperationResult instanceof LimitedInMemorySortedIterable);
    assertTrue(operation.getOutputTypeReference() instanceof IterableElement);
    assertNull(operation.getResultLimit());
    assertNull(store.getGraphId());
    assertNull(operation.getOptions());
    assertNull(store.getJobTracker());
    assertNull(context.getOriginalOpChain());
    assertNull(store.getProperties());
    assertNull(store.getGraphLibrary());
    assertNull(store.getOriginalSchema());
    assertNull(store.getSchema());
    assertEquals(
        0, ((LimitedInMemorySortedIterable<? extends Element>) actualDoOperationResult).size());
    List<Comparator<Element>> comparators2 = operation.getComparators();
    assertEquals(1, comparators2.size());
    assertTrue(context.getExporters().isEmpty());
    assertTrue(store.getOperationChainOptimisers().isEmpty());
    assertTrue(((List<? extends Element>) input2).isEmpty());
    assertTrue(context.getVariables().isEmpty());
    assertTrue(operation.getComparableGroupPropertyPairs().isEmpty());
    assertTrue(store.getSupportedOperations().isEmpty());
    assertTrue(operation.isDeduplicate());
    Class<Iterable> expectedOutputClass = Iterable.class;
    assertEquals(expectedOutputClass, operation.getOutputClass());
    assertSame(comparators, comparators2);
    assertSame(input, input2);
  }

  /**
   * Test {@link SortHandler#doOperation(Sort, Context, Store)} with {@code Sort}, {@code Context},
   * {@code Store}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>Then return size is zero.
   * </ul>
   *
   * <p>Method under test: {@link SortHandler#doOperation(Sort, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(Sort, Context, Store) with 'Sort', 'Context', 'Store'; given ArrayList(); then return size is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable SortHandler.doOperation(Sort, Context, Store)"})
  void testDoOperationWithSortContextStore_givenArrayList_thenReturnSizeIsZero2()
      throws OperationException {
    // Arrange
    SortHandler sortHandler = new SortHandler();

    ArrayList<Comparator<Element>> comparators = new ArrayList<>();
    comparators.add(mock(Comparator.class));

    Sort operation = new Sort();
    ArrayList<Element> input = new ArrayList<>();
    operation.setInput(input);
    operation.setComparators(comparators);
    operation.setResultLimit(null);
    Context context = new Context();
    TestAddToGraphLibraryImpl store = new TestAddToGraphLibraryImpl();

    // Act
    Iterable<? extends Element> actualDoOperationResult =
        sortHandler.doOperation(operation, context, store);
    Iterator<? extends Element> actualIteratorResult = actualDoOperationResult.iterator();

    // Assert
    Iterable<? extends Element> input2 = operation.getInput();
    assertTrue(input2 instanceof List);
    assertTrue(actualDoOperationResult instanceof LimitedInMemorySortedIterable);
    assertTrue(operation.getOutputTypeReference() instanceof IterableElement);
    assertNull(operation.getResultLimit());
    assertNull(store.getGraphId());
    assertNull(operation.getOptions());
    assertNull(store.getJobTracker());
    assertNull(context.getOriginalOpChain());
    assertNull(store.getProperties());
    assertNull(store.getGraphLibrary());
    assertNull(store.getOriginalSchema());
    assertNull(store.getSchema());
    assertEquals(
        0, ((LimitedInMemorySortedIterable<? extends Element>) actualDoOperationResult).size());
    List<Comparator<Element>> comparators2 = operation.getComparators();
    assertEquals(1, comparators2.size());
    assertFalse(actualIteratorResult.hasNext());
    assertTrue(context.getExporters().isEmpty());
    assertTrue(store.getOperationChainOptimisers().isEmpty());
    assertTrue(((List<? extends Element>) input2).isEmpty());
    assertTrue(context.getVariables().isEmpty());
    assertTrue(operation.getComparableGroupPropertyPairs().isEmpty());
    assertTrue(store.getSupportedOperations().isEmpty());
    assertTrue(operation.isDeduplicate());
    Class<Iterable> expectedOutputClass = Iterable.class;
    assertEquals(expectedOutputClass, operation.getOutputClass());
    assertSame(comparators, comparators2);
    assertSame(input, input2);
  }

  /**
   * Test {@link SortHandler#doOperation(Sort, Context, Store)} with {@code Sort}, {@code Context},
   * {@code Store}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>Then {@link Sort} (default constructor) Comparators Empty.
   * </ul>
   *
   * <p>Method under test: {@link SortHandler#doOperation(Sort, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(Sort, Context, Store) with 'Sort', 'Context', 'Store'; given ArrayList(); then Sort (default constructor) Comparators Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable SortHandler.doOperation(Sort, Context, Store)"})
  void testDoOperationWithSortContextStore_givenArrayList_thenSortComparatorsEmpty()
      throws OperationException {
    // Arrange
    SortHandler sortHandler = new SortHandler();

    Sort operation = new Sort();
    ArrayList<Element> input = new ArrayList<>();
    operation.setInput(input);
    operation.setComparators(new ArrayList<>());
    operation.setResultLimit(null);
    Context context = new Context();
    TestAddToGraphLibraryImpl store = new TestAddToGraphLibraryImpl();

    // Act
    Iterable<? extends Element> actualDoOperationResult =
        sortHandler.doOperation(operation, context, store);

    // Assert
    Iterable<? extends Element> input2 = operation.getInput();
    assertTrue(input2 instanceof List);
    assertTrue(operation.getOutputTypeReference() instanceof IterableElement);
    assertNull(operation.getResultLimit());
    assertNull(actualDoOperationResult);
    assertNull(store.getGraphId());
    assertNull(operation.getCombinedComparator());
    assertNull(operation.getOptions());
    assertNull(store.getJobTracker());
    assertNull(context.getOriginalOpChain());
    assertNull(store.getProperties());
    assertNull(store.getGraphLibrary());
    assertNull(store.getOriginalSchema());
    assertNull(store.getSchema());
    assertTrue(context.getExporters().isEmpty());
    assertTrue(operation.getComparators().isEmpty());
    assertTrue(store.getOperationChainOptimisers().isEmpty());
    assertTrue(((List<? extends Element>) input2).isEmpty());
    assertTrue(context.getVariables().isEmpty());
    assertTrue(operation.getComparableGroupPropertyPairs().isEmpty());
    assertTrue(store.getSupportedOperations().isEmpty());
    assertTrue(operation.isDeduplicate());
    Class<Iterable> expectedOutputClass = Iterable.class;
    assertEquals(expectedOutputClass, operation.getOutputClass());
    assertSame(input, input2);
  }

  /**
   * Test {@link SortHandler#doOperation(Sort, Context, Store)} with {@code Sort}, {@code Context},
   * {@code Store}.
   *
   * <ul>
   *   <li>Then {@link Sort} (default constructor) Comparators is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SortHandler#doOperation(Sort, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(Sort, Context, Store) with 'Sort', 'Context', 'Store'; then Sort (default constructor) Comparators is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable SortHandler.doOperation(Sort, Context, Store)"})
  void testDoOperationWithSortContextStore_thenSortComparatorsIsNull() throws OperationException {
    // Arrange
    SortHandler sortHandler = new SortHandler();

    Sort operation = new Sort();
    ArrayList<Element> input = new ArrayList<>();
    operation.setInput(input);
    operation.setComparators(null);
    operation.setResultLimit(null);
    Context context = new Context();
    TestAddToGraphLibraryImpl store = new TestAddToGraphLibraryImpl();

    // Act
    Iterable<? extends Element> actualDoOperationResult =
        sortHandler.doOperation(operation, context, store);

    // Assert
    Iterable<? extends Element> input2 = operation.getInput();
    assertTrue(input2 instanceof List);
    assertTrue(operation.getOutputTypeReference() instanceof IterableElement);
    assertNull(operation.getResultLimit());
    assertNull(actualDoOperationResult);
    assertNull(store.getGraphId());
    assertNull(operation.getCombinedComparator());
    assertNull(operation.getComparators());
    assertNull(operation.getOptions());
    assertNull(store.getJobTracker());
    assertNull(context.getOriginalOpChain());
    assertNull(store.getProperties());
    assertNull(store.getGraphLibrary());
    assertNull(store.getOriginalSchema());
    assertNull(store.getSchema());
    assertTrue(context.getExporters().isEmpty());
    assertTrue(store.getOperationChainOptimisers().isEmpty());
    assertTrue(((List<? extends Element>) input2).isEmpty());
    assertTrue(context.getVariables().isEmpty());
    assertTrue(operation.getComparableGroupPropertyPairs().isEmpty());
    assertTrue(store.getSupportedOperations().isEmpty());
    assertTrue(operation.isDeduplicate());
    Class<Iterable> expectedOutputClass = Iterable.class;
    assertEquals(expectedOutputClass, operation.getOutputClass());
    assertSame(input, input2);
  }

  /**
   * Test {@link SortHandler#doOperation(Sort, Context, Store)} with {@code Sort}, {@code Context},
   * {@code Store}.
   *
   * <ul>
   *   <li>When {@link Sort} (default constructor).
   *   <li>Then {@link Sort} (default constructor) Input is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SortHandler#doOperation(Sort, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(Sort, Context, Store) with 'Sort', 'Context', 'Store'; when Sort (default constructor); then Sort (default constructor) Input is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable SortHandler.doOperation(Sort, Context, Store)"})
  void testDoOperationWithSortContextStore_whenSort_thenSortInputIsNull()
      throws OperationException {
    // Arrange
    SortHandler sortHandler = new SortHandler();
    Sort operation = new Sort();
    Context context = new Context();
    TestAddToGraphLibraryImpl store = new TestAddToGraphLibraryImpl();

    // Act
    Iterable<? extends Element> actualDoOperationResult =
        sortHandler.doOperation(operation, context, store);

    // Assert
    assertTrue(operation.getOutputTypeReference() instanceof IterableElement);
    assertNull(operation.getResultLimit());
    assertNull(operation.getInput());
    assertNull(actualDoOperationResult);
    assertNull(store.getGraphId());
    assertNull(operation.getCombinedComparator());
    assertNull(operation.getComparators());
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
    assertTrue(operation.getComparableGroupPropertyPairs().isEmpty());
    assertTrue(store.getSupportedOperations().isEmpty());
    assertTrue(operation.isDeduplicate());
    Class<Iterable> expectedOutputClass = Iterable.class;
    assertEquals(expectedOutputClass, operation.getOutputClass());
  }
}
