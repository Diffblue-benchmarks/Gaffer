package uk.gov.gchq.gaffer.federated.simple.operation.handler;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uk.gov.gchq.gaffer.federated.simple.FederatedStore;
import uk.gov.gchq.gaffer.federated.simple.operation.AddGraph;
import uk.gov.gchq.gaffer.named.operation.NamedOperation;
import uk.gov.gchq.gaffer.operation.Operation;
import uk.gov.gchq.gaffer.operation.OperationChain;
import uk.gov.gchq.gaffer.operation.OperationChainDAO;
import uk.gov.gchq.gaffer.operation.OperationException;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.Store;
import uk.gov.gchq.gaffer.store.operation.handler.OperationHandler;

class EitherOperationHandlerDiffblueTest {
  /**
   * Test {@link EitherOperationHandler#doOperation(Operation, Context, Store)}.
   *
   * <p>Method under test: {@link EitherOperationHandler#doOperation(Operation, Context, Store)}
   */
  @Test
  @DisplayName("Test doOperation(Operation, Context, Store)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object EitherOperationHandler.doOperation(Operation, Context, Store)"})
  void testDoOperation() throws OperationException {
    // Arrange
    OperationHandler<Operation> standardHandler = mock(OperationHandler.class);
    when(standardHandler.doOperation(
            Mockito.<Operation>any(), Mockito.<Context>any(), Mockito.<Store>any()))
        .thenReturn("Do Operation");
    EitherOperationHandler<Operation> eitherOperationHandler =
        new EitherOperationHandler<>(standardHandler);

    AddGraph addGraph = new AddGraph();
    addGraph.addOption(
        "Checking if Operation should be handled locally or on sub graphs: {}", "42");
    Context context = new Context();

    // Act
    Object actualDoOperationResult =
        eitherOperationHandler.doOperation(addGraph, context, new FederatedStore());

    // Assert
    verify(standardHandler).doOperation(isA(Operation.class), isA(Context.class), isA(Store.class));
    assertEquals("Do Operation", actualDoOperationResult);
    assertTrue(context.getVariables().isEmpty());
  }

  /**
   * Test {@link EitherOperationHandler#doOperation(Operation, Context, Store)}.
   *
   * <ul>
   *   <li>Then {@link Context#Context()} Variables size is one.
   * </ul>
   *
   * <p>Method under test: {@link EitherOperationHandler#doOperation(Operation, Context, Store)}
   */
  @Test
  @DisplayName("Test doOperation(Operation, Context, Store); then Context() Variables size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object EitherOperationHandler.doOperation(Operation, Context, Store)"})
  void testDoOperation_thenContextVariablesSizeIsOne() throws OperationException {
    // Arrange
    OperationHandler<Operation> standardHandler = mock(OperationHandler.class);
    when(standardHandler.doOperation(
            Mockito.<Operation>any(), Mockito.<Context>any(), Mockito.<Store>any()))
        .thenReturn("Do Operation");
    EitherOperationHandler<Operation> eitherOperationHandler =
        new EitherOperationHandler<>(standardHandler);
    OperationChainDAO<Object> operationChainDAO = new OperationChainDAO<>(new AddGraph());
    Context context = new Context();

    // Act
    Object actualDoOperationResult =
        eitherOperationHandler.doOperation(operationChainDAO, context, new FederatedStore());

    // Assert
    verify(standardHandler).doOperation(isA(Operation.class), isA(Context.class), isA(Store.class));
    assertEquals("Do Operation", actualDoOperationResult);
    Map<String, Object> variables = context.getVariables();
    assertEquals(1, variables.size());
    assertTrue((Boolean) variables.get("applyChainOptionsToAll"));
  }

  /**
   * Test {@link EitherOperationHandler#doOperation(Operation, Context, Store)}.
   *
   * <ul>
   *   <li>Then throw {@link OperationException}.
   * </ul>
   *
   * <p>Method under test: {@link EitherOperationHandler#doOperation(Operation, Context, Store)}
   */
  @Test
  @DisplayName("Test doOperation(Operation, Context, Store); then throw OperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object EitherOperationHandler.doOperation(Operation, Context, Store)"})
  void testDoOperation_thenThrowOperationException() throws OperationException {
    // Arrange
    OperationHandler<Operation> standardHandler = mock(OperationHandler.class);
    when(standardHandler.doOperation(
            Mockito.<Operation>any(), Mockito.<Context>any(), Mockito.<Store>any()))
        .thenThrow(new OperationException("An error occurred"));
    EitherOperationHandler<Operation> eitherOperationHandler =
        new EitherOperationHandler<>(standardHandler);
    OperationChainDAO<Object> operationChainDAO = new OperationChainDAO<>(new AddGraph());
    Context context = new Context();

    // Act and Assert
    assertThrows(
        OperationException.class,
        () -> eitherOperationHandler.doOperation(operationChainDAO, context, new FederatedStore()));
    verify(standardHandler).doOperation(isA(Operation.class), isA(Context.class), isA(Store.class));
  }

  /**
   * Test {@link EitherOperationHandler#doOperation(Operation, Context, Store)}.
   *
   * <ul>
   *   <li>When {@link AddGraph} (default constructor).
   *   <li>Then {@link Context#Context()} Variables Empty.
   * </ul>
   *
   * <p>Method under test: {@link EitherOperationHandler#doOperation(Operation, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(Operation, Context, Store); when AddGraph (default constructor); then Context() Variables Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object EitherOperationHandler.doOperation(Operation, Context, Store)"})
  void testDoOperation_whenAddGraph_thenContextVariablesEmpty() throws OperationException {
    // Arrange
    OperationHandler<Operation> standardHandler = mock(OperationHandler.class);
    when(standardHandler.doOperation(
            Mockito.<Operation>any(), Mockito.<Context>any(), Mockito.<Store>any()))
        .thenReturn("Do Operation");
    EitherOperationHandler<Operation> eitherOperationHandler =
        new EitherOperationHandler<>(standardHandler);
    AddGraph addGraph = new AddGraph();
    Context context = new Context();

    // Act
    Object actualDoOperationResult =
        eitherOperationHandler.doOperation(addGraph, context, new FederatedStore());

    // Assert
    verify(standardHandler).doOperation(isA(Operation.class), isA(Context.class), isA(Store.class));
    assertEquals("Do Operation", actualDoOperationResult);
    assertTrue(context.getVariables().isEmpty());
  }

  /**
   * Test {@link EitherOperationHandler#doOperation(Operation, Context, Store)}.
   *
   * <ul>
   *   <li>When {@link AddGraph} (default constructor).
   *   <li>Then throw {@link OperationException}.
   * </ul>
   *
   * <p>Method under test: {@link EitherOperationHandler#doOperation(Operation, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(Operation, Context, Store); when AddGraph (default constructor); then throw OperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object EitherOperationHandler.doOperation(Operation, Context, Store)"})
  void testDoOperation_whenAddGraph_thenThrowOperationException() throws OperationException {
    // Arrange
    OperationHandler<Operation> standardHandler = mock(OperationHandler.class);
    when(standardHandler.doOperation(
            Mockito.<Operation>any(), Mockito.<Context>any(), Mockito.<Store>any()))
        .thenThrow(new OperationException("An error occurred"));
    EitherOperationHandler<Operation> eitherOperationHandler =
        new EitherOperationHandler<>(standardHandler);
    AddGraph addGraph = new AddGraph();
    Context context = new Context();

    // Act and Assert
    assertThrows(
        OperationException.class,
        () -> eitherOperationHandler.doOperation(addGraph, context, new FederatedStore()));
    verify(standardHandler).doOperation(isA(Operation.class), isA(Context.class), isA(Store.class));
  }

  /**
   * Test {@link EitherOperationHandler#doOperation(Operation, Context, Store)}.
   *
   * <ul>
   *   <li>When wrap {@link NamedOperation} (default constructor).
   *   <li>Then {@link Context#Context()} Variables Empty.
   * </ul>
   *
   * <p>Method under test: {@link EitherOperationHandler#doOperation(Operation, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(Operation, Context, Store); when wrap NamedOperation (default constructor); then Context() Variables Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object EitherOperationHandler.doOperation(Operation, Context, Store)"})
  void testDoOperation_whenWrapNamedOperation_thenContextVariablesEmpty()
      throws OperationException {
    // Arrange
    OperationHandler<Operation> standardHandler = mock(OperationHandler.class);
    when(standardHandler.doOperation(
            Mockito.<Operation>any(), Mockito.<Context>any(), Mockito.<Store>any()))
        .thenReturn("Do Operation");
    EitherOperationHandler<Operation> eitherOperationHandler =
        new EitherOperationHandler<>(standardHandler);
    OperationChain<Object> wrapResult = OperationChain.wrap(new NamedOperation<>());
    Context context = new Context();

    // Act
    Object actualDoOperationResult =
        eitherOperationHandler.doOperation(wrapResult, context, new FederatedStore());

    // Assert
    verify(standardHandler).doOperation(isA(Operation.class), isA(Context.class), isA(Store.class));
    assertEquals("Do Operation", actualDoOperationResult);
    assertTrue(context.getVariables().isEmpty());
  }
}
