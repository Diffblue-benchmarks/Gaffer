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
import uk.gov.gchq.gaffer.data.element.Element;
import uk.gov.gchq.gaffer.operation.OperationException;
import uk.gov.gchq.gaffer.operation.impl.Validate;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl.IterableElement;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.Store;
import uk.gov.gchq.gaffer.store.ValidatedElements;

class ValidateHandlerDiffblueTest {
  /**
   * Test {@link ValidateHandler#doOperation(Validate, Context, Store)} with {@code operation},
   * {@code context}, {@code store}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>Then {@link Validate} (default constructor) Input {@link List}.
   * </ul>
   *
   * <p>Method under test: {@link ValidateHandler#doOperation(Validate, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(Validate, Context, Store) with 'operation', 'context', 'store'; given ArrayList(); then Validate (default constructor) Input List")
  @Tag("MaintainedByDiffblue")
  void testDoOperationWithOperationContextStore_givenArrayList_thenValidateInputList()
      throws OperationException {
    // Arrange
    ValidateHandler validateHandler = new ValidateHandler();

    Validate operation = new Validate();
    ArrayList<Element> input = new ArrayList<>();
    operation.setInput(input);
    Context context = new Context();
    TestAddToGraphLibraryImpl store = new TestAddToGraphLibraryImpl();

    // Act
    Iterable<? extends Element> actualDoOperationResult =
        validateHandler.doOperation(operation, context, store);
    Iterator<? extends Element> actualIteratorResult = actualDoOperationResult.iterator();

    // Assert
    Iterable<? extends Element> input2 = operation.getInput();
    assertTrue(input2 instanceof List);
    assertTrue(operation.getOutputTypeReference() instanceof IterableElement);
    assertTrue(actualDoOperationResult instanceof ValidatedElements);
    assertNull(store.getGraphId());
    assertNull(operation.getOptions());
    assertNull(store.getJobTracker());
    assertNull(context.getOriginalOpChain());
    assertNull(store.getProperties());
    assertNull(store.getGraphLibrary());
    assertNull(store.getOriginalSchema());
    assertNull(store.getSchema());
    assertFalse(actualDoOperationResult.iterator().hasNext());
    assertFalse(actualIteratorResult.hasNext());
    assertFalse(operation.isSkipInvalidElements());
    assertTrue(context.getExporters().isEmpty());
    assertTrue(store.getOperationChainOptimisers().isEmpty());
    assertTrue(((List<? extends Element>) input2).isEmpty());
    assertTrue(context.getVariables().isEmpty());
    assertTrue(store.getSupportedOperations().isEmpty());
    assertTrue(operation.isValidate());
    Class<Iterable> expectedOutputClass = Iterable.class;
    assertEquals(expectedOutputClass, operation.getOutputClass());
    assertSame(input, input2);
  }

  /**
   * Test {@link ValidateHandler#doOperation(Validate, Context, Store)} with {@code operation},
   * {@code context}, {@code store}.
   *
   * <ul>
   *   <li>When {@link Validate} (default constructor).
   *   <li>Then {@link Validate} (default constructor) Input is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ValidateHandler#doOperation(Validate, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(Validate, Context, Store) with 'operation', 'context', 'store'; when Validate (default constructor); then Validate (default constructor) Input is 'null'")
  @Tag("MaintainedByDiffblue")
  void testDoOperationWithOperationContextStore_whenValidate_thenValidateInputIsNull()
      throws OperationException {
    // Arrange
    ValidateHandler validateHandler = new ValidateHandler();
    Validate operation = new Validate();
    Context context = new Context();
    TestAddToGraphLibraryImpl store = new TestAddToGraphLibraryImpl();

    // Act
    Iterable<? extends Element> actualDoOperationResult =
        validateHandler.doOperation(operation, context, store);

    // Assert
    assertTrue(operation.getOutputTypeReference() instanceof IterableElement);
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
    assertFalse(operation.isSkipInvalidElements());
    assertTrue(context.getExporters().isEmpty());
    assertTrue(store.getOperationChainOptimisers().isEmpty());
    assertTrue(context.getVariables().isEmpty());
    assertTrue(store.getSupportedOperations().isEmpty());
    assertTrue(operation.isValidate());
    Class<Iterable> expectedOutputClass = Iterable.class;
    assertEquals(expectedOutputClass, operation.getOutputClass());
  }
}
