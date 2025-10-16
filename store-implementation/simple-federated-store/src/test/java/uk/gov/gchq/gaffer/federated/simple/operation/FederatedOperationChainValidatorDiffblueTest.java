package uk.gov.gchq.gaffer.federated.simple.operation;

import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.federated.simple.FederatedStore;
import uk.gov.gchq.gaffer.named.operation.NamedOperation;
import uk.gov.gchq.gaffer.operation.Operation;
import uk.gov.gchq.gaffer.operation.OperationChain;
import uk.gov.gchq.gaffer.store.Store;
import uk.gov.gchq.gaffer.store.schema.ViewValidator;
import uk.gov.gchq.gaffer.user.User;

class FederatedOperationChainValidatorDiffblueTest {
  /**
   * Test {@link FederatedOperationChainValidator#getSchema(Operation, User, Store)}.
   *
   * <ul>
   *   <li>When {@link AddGraph} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedOperationChainValidator#getSchema(Operation, User,
   * Store)}
   */
  @Test
  @DisplayName(
      "Test getSchema(Operation, User, Store); when AddGraph (default constructor); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "uk.gov.gchq.gaffer.store.schema.Schema FederatedOperationChainValidator.getSchema(Operation, User, Store)"
  })
  void testGetSchema_whenAddGraph_thenReturnNull() {
    // Arrange
    FederatedOperationChainValidator federatedOperationChainValidator =
        new FederatedOperationChainValidator(new ViewValidator());
    AddGraph operation = new AddGraph();
    User user = new User();

    // Act and Assert
    assertNull(federatedOperationChainValidator.getSchema(operation, user, new FederatedStore()));
  }

  /**
   * Test {@link FederatedOperationChainValidator#getSchema(Operation, User, Store)}.
   *
   * <ul>
   *   <li>When wrap {@link NamedOperation} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedOperationChainValidator#getSchema(Operation, User,
   * Store)}
   */
  @Test
  @DisplayName(
      "Test getSchema(Operation, User, Store); when wrap NamedOperation (default constructor); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "uk.gov.gchq.gaffer.store.schema.Schema FederatedOperationChainValidator.getSchema(Operation, User, Store)"
  })
  void testGetSchema_whenWrapNamedOperation_thenReturnNull() {
    // Arrange
    FederatedOperationChainValidator federatedOperationChainValidator =
        new FederatedOperationChainValidator(new ViewValidator());
    OperationChain<Object> operation = OperationChain.wrap(new NamedOperation<>());
    User user = new User();

    // Act and Assert
    assertNull(federatedOperationChainValidator.getSchema(operation, user, new FederatedStore()));
  }
}
