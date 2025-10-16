package uk.gov.gchq.gaffer.federated.simple.operation.handler;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.accumulostore.operation.impl.GetElementsBetweenSets;
import uk.gov.gchq.gaffer.federated.simple.FederatedStore;
import uk.gov.gchq.gaffer.federated.simple.operation.AddGraph;
import uk.gov.gchq.gaffer.named.operation.NamedOperation;
import uk.gov.gchq.gaffer.operation.Operation;
import uk.gov.gchq.gaffer.operation.OperationChain;
import uk.gov.gchq.gaffer.operation.OperationException;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.Context.Builder;
import uk.gov.gchq.gaffer.store.Store;
import uk.gov.gchq.gaffer.user.User;

class FederatedOperationHandlerDiffblueTest {
  /**
   * Test {@link FederatedOperationHandler#doOperation(Operation, Context, Store)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.
   *   <li>When {@link GetElementsBetweenSets} (default constructor) Options is {@link
   *       HashMap#HashMap()}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedOperationHandler#doOperation(Operation, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(Operation, Context, Store); given HashMap(); when GetElementsBetweenSets (default constructor) Options is HashMap()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object FederatedOperationHandler.doOperation(Operation, Context, Store)"})
  void testDoOperation_givenHashMap_whenGetElementsBetweenSetsOptionsIsHashMap()
      throws OperationException {
    // Arrange
    FederatedOperationHandler<Operation> federatedOperationHandler =
        new FederatedOperationHandler<>();

    GetElementsBetweenSets getElementsBetweenSets = new GetElementsBetweenSets();
    getElementsBetweenSets.setOptions(new HashMap<>());
    getElementsBetweenSets.setView(null);
    Context context = new Context();

    // Act and Assert
    assertNull(
        federatedOperationHandler.doOperation(
            getElementsBetweenSets, context, new FederatedStore()));
  }

  /**
   * Test {@link FederatedOperationHandler#doOperation(Operation, Context, Store)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link GetElementsBetweenSets} (default constructor) Options is {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedOperationHandler#doOperation(Operation, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(Operation, Context, Store); given 'null'; when GetElementsBetweenSets (default constructor) Options is 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object FederatedOperationHandler.doOperation(Operation, Context, Store)"})
  void testDoOperation_givenNull_whenGetElementsBetweenSetsOptionsIsNull_thenReturnNull()
      throws OperationException {
    // Arrange
    FederatedOperationHandler<Operation> federatedOperationHandler =
        new FederatedOperationHandler<>();

    GetElementsBetweenSets getElementsBetweenSets = new GetElementsBetweenSets();
    getElementsBetweenSets.setOptions(null);
    getElementsBetweenSets.setView(null);
    Context context = new Context();

    // Act and Assert
    assertNull(
        federatedOperationHandler.doOperation(
            getElementsBetweenSets, context, new FederatedStore()));
  }

  /**
   * Test {@link FederatedOperationHandler#doOperation(Operation, Context, Store)}.
   *
   * <ul>
   *   <li>When {@link AddGraph} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedOperationHandler#doOperation(Operation, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(Operation, Context, Store); when AddGraph (default constructor); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object FederatedOperationHandler.doOperation(Operation, Context, Store)"})
  void testDoOperation_whenAddGraph_thenReturnNull() throws OperationException {
    // Arrange
    FederatedOperationHandler<Operation> federatedOperationHandler =
        new FederatedOperationHandler<>();
    AddGraph addGraph = new AddGraph();
    Context context = new Context();

    // Act and Assert
    assertNull(federatedOperationHandler.doOperation(addGraph, context, new FederatedStore()));
  }

  /**
   * Test {@link FederatedOperationHandler#doOperation(Operation, Context, Store)}.
   *
   * <ul>
   *   <li>When wrap {@link NamedOperation} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedOperationHandler#doOperation(Operation, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(Operation, Context, Store); when wrap NamedOperation (default constructor); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object FederatedOperationHandler.doOperation(Operation, Context, Store)"})
  void testDoOperation_whenWrapNamedOperation_thenReturnNull() throws OperationException {
    // Arrange
    FederatedOperationHandler<Operation> federatedOperationHandler =
        new FederatedOperationHandler<>();
    OperationChain<Object> wrapResult = OperationChain.wrap(new NamedOperation<>());

    Builder builder = new Builder();
    Context context = builder.user(new User.Builder().userId("42").build()).build();

    // Act and Assert
    assertNull(federatedOperationHandler.doOperation(wrapResult, context, new FederatedStore()));
  }

  /**
   * Test {@link FederatedOperationHandler#getGraphsToExecuteOn(Operation, Context,
   * FederatedStore)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.
   *   <li>When {@link AddGraph} (default constructor) Options is {@link HashMap#HashMap()}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedOperationHandler#getGraphsToExecuteOn(Operation, Context,
   * FederatedStore)}
   */
  @Test
  @DisplayName(
      "Test getGraphsToExecuteOn(Operation, Context, FederatedStore); given HashMap(); when AddGraph (default constructor) Options is HashMap()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.util.List FederatedOperationHandler.getGraphsToExecuteOn(Operation, Context, FederatedStore)"
  })
  void testGetGraphsToExecuteOn_givenHashMap_whenAddGraphOptionsIsHashMap()
      throws OperationException {
    // Arrange
    FederatedOperationHandler<Operation> federatedOperationHandler =
        new FederatedOperationHandler<>();

    AddGraph operation = new AddGraph();
    operation.setOptions(new HashMap<>());
    Context context = new Context();

    // Act and Assert
    assertTrue(
        federatedOperationHandler
            .getGraphsToExecuteOn(operation, context, new FederatedStore())
            .isEmpty());
  }

  /**
   * Test {@link FederatedOperationHandler#getGraphsToExecuteOn(Operation, Context,
   * FederatedStore)}.
   *
   * <ul>
   *   <li>When {@link AddGraph} (default constructor).
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link FederatedOperationHandler#getGraphsToExecuteOn(Operation, Context,
   * FederatedStore)}
   */
  @Test
  @DisplayName(
      "Test getGraphsToExecuteOn(Operation, Context, FederatedStore); when AddGraph (default constructor); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.util.List FederatedOperationHandler.getGraphsToExecuteOn(Operation, Context, FederatedStore)"
  })
  void testGetGraphsToExecuteOn_whenAddGraph_thenReturnEmpty() throws OperationException {
    // Arrange
    FederatedOperationHandler<Operation> federatedOperationHandler =
        new FederatedOperationHandler<>();
    AddGraph operation = new AddGraph();
    Context context = new Context();

    // Act and Assert
    assertTrue(
        federatedOperationHandler
            .getGraphsToExecuteOn(operation, context, new FederatedStore())
            .isEmpty());
  }
}
