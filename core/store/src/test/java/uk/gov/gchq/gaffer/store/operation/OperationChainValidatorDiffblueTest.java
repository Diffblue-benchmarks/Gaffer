package uk.gov.gchq.gaffer.store.operation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uk.gov.gchq.gaffer.core.exception.GafferRuntimeException;
import uk.gov.gchq.gaffer.named.operation.NamedOperation;
import uk.gov.gchq.gaffer.operation.Operation;
import uk.gov.gchq.gaffer.operation.OperationChain;
import uk.gov.gchq.gaffer.operation.OperationException;
import uk.gov.gchq.gaffer.operation.impl.OperationImpl;
import uk.gov.gchq.gaffer.operation.impl.io.GenericInputImpl;
import uk.gov.gchq.gaffer.operation.io.Output;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.Store;
import uk.gov.gchq.gaffer.store.StoreTrait;
import uk.gov.gchq.gaffer.store.operation.handler.TestAddToGraphLibraryImpl;
import uk.gov.gchq.gaffer.store.schema.ViewValidator;
import uk.gov.gchq.gaffer.user.User;
import uk.gov.gchq.koryphe.ValidationResult;

class OperationChainValidatorDiffblueTest {
  /**
   * Test {@link OperationChainValidator#validate(OperationChain, User, Store)} with {@code
   * operationChain}, {@code user}, {@code store}.
   *
   * <p>Method under test: {@link OperationChainValidator#validate(OperationChain, User, Store)}
   */
  @Test
  @DisplayName("Test validate(OperationChain, User, Store) with 'operationChain', 'user', 'store'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ValidationResult OperationChainValidator.validate(OperationChain, User, Store)"
  })
  void testValidateWithOperationChainUserStore() {
    // Arrange
    OperationChainValidator operationChainValidator =
        new OperationChainValidator(new ViewValidator());
    OperationChain<Object> operation = OperationChain.wrap(new NamedOperation<>());
    OperationChain<?> operationChain = OperationChain.wrap(operation);
    User user = new User();

    // Act
    ValidationResult actualValidateResult =
        operationChainValidator.validate(operationChain, user, new TestAddToGraphLibraryImpl());

    // Assert
    assertEquals(
        "Validation errors: \noperationName is required for: NamedOperation",
        actualValidateResult.getErrorString());
    Set<String> errors = actualValidateResult.getErrors();
    assertEquals(1, errors.size());
    assertFalse(actualValidateResult.isValid());
    assertTrue(errors.contains("operationName is required for: NamedOperation"));
  }

  /**
   * Test {@link OperationChainValidator#validate(Operation, User, Store, ValidationResult, Class)}
   * with {@code operation}, {@code user}, {@code store}, {@code validationResult}, {@code input}.
   *
   * <p>Method under test: {@link OperationChainValidator#validate(Operation, User, Store,
   * ValidationResult, Class)}
   */
  @Test
  @DisplayName(
      "Test validate(Operation, User, Store, ValidationResult, Class) with 'operation', 'user', 'store', 'validationResult', 'input'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Class OperationChainValidator.validate(Operation, User, Store, ValidationResult, Class)"
  })
  void testValidateWithOperationUserStoreValidationResultInput() {
    // Arrange
    OperationChainValidator operationChainValidator =
        new OperationChainValidator(new ViewValidator());
    OperationChain<Object> operation = OperationChain.wrap(new NamedOperation<>());
    User user = new User();
    TestAddToGraphLibraryImpl store = new TestAddToGraphLibraryImpl();
    Class<Object> output = Object.class;
    Class<Object> input = Object.class;

    ValidationResult validationResult = OperationUtil.isValid(output, input);
    Class<Output> input2 = Output.class;

    // Act
    Class<? extends Output> actualValidateResult =
        operationChainValidator.validate(operation, user, store, validationResult, input2);

    // Assert
    Class<OperationChain> expectedValidateResult = OperationChain.class;
    assertEquals(expectedValidateResult, actualValidateResult);
  }

  /**
   * Test {@link OperationChainValidator#validateInputOutputTypes(Operation, ValidationResult,
   * Store, Class)}.
   *
   * <ul>
   *   <li>When {@link GenericInputImpl#GenericInputImpl()}.
   * </ul>
   *
   * <p>Method under test: {@link OperationChainValidator#validateInputOutputTypes(Operation,
   * ValidationResult, Store, Class)}
   */
  @Test
  @DisplayName(
      "Test validateInputOutputTypes(Operation, ValidationResult, Store, Class); when GenericInputImpl()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Class OperationChainValidator.validateInputOutputTypes(Operation, ValidationResult, Store, Class)"
  })
  void testValidateInputOutputTypes_whenGenericInputImpl() {
    // Arrange
    OperationChainValidator operationChainValidator =
        new OperationChainValidator(new ViewValidator());
    GenericInputImpl operation = new GenericInputImpl();
    Class<Object> output = Object.class;
    Class<Object> input = Object.class;

    ValidationResult validationResult = OperationUtil.isValid(output, input);
    TestAddToGraphLibraryImpl store = new TestAddToGraphLibraryImpl();
    Class<Output> input2 = Output.class;

    // Act
    Class<? extends Output> actualValidateInputOutputTypesResult =
        operationChainValidator.validateInputOutputTypes(
            operation, validationResult, store, input2);

    // Assert
    assertEquals("Validation errors: \n", validationResult.getErrorString());
    assertNull(actualValidateInputOutputTypesResult);
    assertTrue(validationResult.getErrors().isEmpty());
    assertTrue(validationResult.isValid());
  }

  /**
   * Test {@link OperationChainValidator#validateInputOutputTypes(Operation, ValidationResult,
   * Store, Class)}.
   *
   * <ul>
   *   <li>When {@link OperationChain#OperationChain()}.
   * </ul>
   *
   * <p>Method under test: {@link OperationChainValidator#validateInputOutputTypes(Operation,
   * ValidationResult, Store, Class)}
   */
  @Test
  @DisplayName(
      "Test validateInputOutputTypes(Operation, ValidationResult, Store, Class); when OperationChain()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Class OperationChainValidator.validateInputOutputTypes(Operation, ValidationResult, Store, Class)"
  })
  void testValidateInputOutputTypes_whenOperationChain() {
    // Arrange
    OperationChainValidator operationChainValidator =
        new OperationChainValidator(new ViewValidator());
    OperationChain<Object> operation = new OperationChain<>();
    Class<Object> output = Object.class;
    Class<Object> input = Object.class;

    ValidationResult validationResult = OperationUtil.isValid(output, input);
    TestAddToGraphLibraryImpl store = new TestAddToGraphLibraryImpl();
    Class<Output> input2 = Output.class;

    // Act
    Class<? extends Output> actualValidateInputOutputTypesResult =
        operationChainValidator.validateInputOutputTypes(
            operation, validationResult, store, input2);

    // Assert
    assertEquals(
        "Validation errors: \n"
            + "Invalid combination of operations: uk.gov.gchq.gaffer.operation.io.Output -> uk.gov.gchq.gaffer.operation"
            + ".OperationChain. Class has an output but OperationChain does not take an input.",
        validationResult.getErrorString());
    Set<String> errors = validationResult.getErrors();
    assertEquals(1, errors.size());
    assertFalse(validationResult.isValid());
    assertTrue(
        errors.contains(
            "Invalid combination of operations: uk.gov.gchq.gaffer.operation.io.Output -> uk.gov.gchq.gaffer.operation"
                + ".OperationChain. Class has an output but OperationChain does not take an input."));
    Class<OperationChain> expectedValidateInputOutputTypesResult = OperationChain.class;
    assertEquals(expectedValidateInputOutputTypesResult, actualValidateInputOutputTypesResult);
  }

  /**
   * Test {@link OperationChainValidator#validateInputOutputTypes(Operation, ValidationResult,
   * Store, Class)}.
   *
   * <ul>
   *   <li>When {@link OperationImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link OperationChainValidator#validateInputOutputTypes(Operation,
   * ValidationResult, Store, Class)}
   */
  @Test
  @DisplayName(
      "Test validateInputOutputTypes(Operation, ValidationResult, Store, Class); when OperationImpl (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Class OperationChainValidator.validateInputOutputTypes(Operation, ValidationResult, Store, Class)"
  })
  void testValidateInputOutputTypes_whenOperationImpl() {
    // Arrange
    OperationChainValidator operationChainValidator =
        new OperationChainValidator(new ViewValidator());
    OperationImpl operation = new OperationImpl();
    Class<Object> output = Object.class;
    Class<Object> input = Object.class;

    ValidationResult validationResult = OperationUtil.isValid(output, input);
    TestAddToGraphLibraryImpl store = new TestAddToGraphLibraryImpl();
    Class<Output> input2 = Output.class;

    // Act
    Class<? extends Output> actualValidateInputOutputTypesResult =
        operationChainValidator.validateInputOutputTypes(
            operation, validationResult, store, input2);

    // Assert
    assertEquals(
        "Validation errors: \n"
            + "Invalid combination of operations: uk.gov.gchq.gaffer.operation.io.Output -> uk.gov.gchq.gaffer.operation"
            + ".impl.OperationImpl. Class has an output but OperationImpl does not take an input.",
        validationResult.getErrorString());
    assertNull(actualValidateInputOutputTypesResult);
    Set<String> errors = validationResult.getErrors();
    assertEquals(1, errors.size());
    assertFalse(validationResult.isValid());
    assertTrue(
        errors.contains(
            "Invalid combination of operations: uk.gov.gchq.gaffer.operation.io.Output -> uk.gov.gchq.gaffer.operation"
                + ".impl.OperationImpl. Class has an output but OperationImpl does not take an input."));
  }

  /**
   * Test {@link OperationChainValidator#validateInputOutputTypes(Operation, ValidationResult,
   * Store, Class)}.
   *
   * <ul>
   *   <li>When wrap {@link NamedOperation} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link OperationChainValidator#validateInputOutputTypes(Operation,
   * ValidationResult, Store, Class)}
   */
  @Test
  @DisplayName(
      "Test validateInputOutputTypes(Operation, ValidationResult, Store, Class); when wrap NamedOperation (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Class OperationChainValidator.validateInputOutputTypes(Operation, ValidationResult, Store, Class)"
  })
  void testValidateInputOutputTypes_whenWrapNamedOperation() {
    // Arrange
    OperationChainValidator operationChainValidator =
        new OperationChainValidator(new ViewValidator());
    OperationChain<Object> operation = OperationChain.wrap(new NamedOperation<>());
    Class<Object> output = Object.class;
    Class<Object> input = Object.class;

    ValidationResult validationResult = OperationUtil.isValid(output, input);
    TestAddToGraphLibraryImpl store = new TestAddToGraphLibraryImpl();
    Class<Output> input2 = Output.class;

    // Act
    Class<? extends Output> actualValidateInputOutputTypesResult =
        operationChainValidator.validateInputOutputTypes(
            operation, validationResult, store, input2);

    // Assert
    assertEquals("Validation errors: \n", validationResult.getErrorString());
    assertTrue(validationResult.getErrors().isEmpty());
    assertTrue(validationResult.isValid());
    Class<OperationChain> expectedValidateInputOutputTypesResult = OperationChain.class;
    assertEquals(expectedValidateInputOutputTypesResult, actualValidateInputOutputTypesResult);
  }

  /**
   * Test {@link OperationChainValidator#getFirstOperation(Operation)}.
   *
   * <ul>
   *   <li>When {@link OperationChain#OperationChain()}.
   *   <li>Then return {@link OperationChain#OperationChain()}.
   * </ul>
   *
   * <p>Method under test: {@link OperationChainValidator#getFirstOperation(Operation)}
   */
  @Test
  @DisplayName(
      "Test getFirstOperation(Operation); when OperationChain(); then return OperationChain()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Operation OperationChainValidator.getFirstOperation(Operation)"})
  void testGetFirstOperation_whenOperationChain_thenReturnOperationChain() {
    // Arrange
    OperationChainValidator operationChainValidator =
        new OperationChainValidator(new ViewValidator());
    OperationChain<Object> operation = new OperationChain<>();

    // Act
    Operation actualFirstOperation = operationChainValidator.getFirstOperation(operation);

    // Assert
    assertSame(operation, actualFirstOperation);
  }

  /**
   * Test {@link OperationChainValidator#getFirstOperation(Operation)}.
   *
   * <ul>
   *   <li>When {@link OperationImpl} (default constructor).
   *   <li>Then return {@link OperationImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link OperationChainValidator#getFirstOperation(Operation)}
   */
  @Test
  @DisplayName(
      "Test getFirstOperation(Operation); when OperationImpl (default constructor); then return OperationImpl (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Operation OperationChainValidator.getFirstOperation(Operation)"})
  void testGetFirstOperation_whenOperationImpl_thenReturnOperationImpl() {
    // Arrange
    OperationChainValidator operationChainValidator =
        new OperationChainValidator(new ViewValidator());
    OperationImpl operation = new OperationImpl();

    // Act
    Operation actualFirstOperation = operationChainValidator.getFirstOperation(operation);

    // Assert
    assertSame(operation, actualFirstOperation);
  }

  /**
   * Test {@link OperationChainValidator#getFirstOperation(Operation)}.
   *
   * <ul>
   *   <li>When wrap {@link NamedOperation} (default constructor).
   *   <li>Then return {@link NamedOperation} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link OperationChainValidator#getFirstOperation(Operation)}
   */
  @Test
  @DisplayName(
      "Test getFirstOperation(Operation); when wrap NamedOperation (default constructor); then return NamedOperation (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Operation OperationChainValidator.getFirstOperation(Operation)"})
  void testGetFirstOperation_whenWrapNamedOperation_thenReturnNamedOperation() {
    // Arrange
    OperationChainValidator operationChainValidator =
        new OperationChainValidator(new ViewValidator());
    NamedOperation<Object, Object> operation = new NamedOperation<>();
    OperationChain<Object> operation2 = OperationChain.wrap(operation);

    // Act and Assert
    assertSame(operation, operationChainValidator.getFirstOperation(operation2));
  }

  /**
   * Test {@link OperationChainValidator#shouldValidate(Operation)}.
   *
   * <p>Method under test: {@link OperationChainValidator#shouldValidate(Operation)}
   */
  @Test
  @DisplayName("Test shouldValidate(Operation)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OperationChainValidator.shouldValidate(Operation)"})
  void testShouldValidate() {
    // Arrange
    OperationChainValidator operationChainValidator =
        new OperationChainValidator(new ViewValidator());
    OperationChain<Object> op = OperationChain.wrap(new NamedOperation<>());

    // Act and Assert
    assertFalse(operationChainValidator.shouldValidate(op));
  }

  /**
   * Test {@link OperationChainValidator#getSchema(Operation, User, Store)}.
   *
   * <ul>
   *   <li>When {@link TestAddToGraphLibraryImpl} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link OperationChainValidator#getSchema(Operation, User, Store)}
   */
  @Test
  @DisplayName(
      "Test getSchema(Operation, User, Store); when TestAddToGraphLibraryImpl (default constructor); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "uk.gov.gchq.gaffer.store.schema.Schema OperationChainValidator.getSchema(Operation, User, Store)"
  })
  void testGetSchema_whenTestAddToGraphLibraryImpl_thenReturnNull() {
    // Arrange
    OperationChainValidator operationChainValidator =
        new OperationChainValidator(new ViewValidator());
    OperationChain<Object> operation = OperationChain.wrap(new NamedOperation<>());
    User user = new User();

    // Act and Assert
    assertNull(operationChainValidator.getSchema(operation, user, new TestAddToGraphLibraryImpl()));
  }

  /**
   * Test {@link OperationChainValidator#getStoreTraits(Store, Context)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.
   *   <li>When {@link Store} {@link Store#execute(Output, Context)} return {@link
   *       HashSet#HashSet()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link OperationChainValidator#getStoreTraits(Store, Context)}
   */
  @Test
  @DisplayName(
      "Test getStoreTraits(Store, Context); given HashSet(); when Store execute(Output, Context) return HashSet(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set OperationChainValidator.getStoreTraits(Store, Context)"})
  void testGetStoreTraits_givenHashSet_whenStoreExecuteReturnHashSet_thenReturnEmpty()
      throws OperationException {
    // Arrange
    OperationChainValidator operationChainValidator =
        new OperationChainValidator(new ViewValidator());

    Store store = mock(Store.class);
    when(store.execute(Mockito.<Output<Set<StoreTrait>>>any(), Mockito.<Context>any()))
        .thenReturn(new HashSet<>());

    // Act
    Set<StoreTrait> actualStoreTraits =
        operationChainValidator.getStoreTraits(store, new Context());

    // Assert
    verify(store).execute(isA(Output.class), isA(Context.class));
    assertTrue(actualStoreTraits.isEmpty());
  }

  /**
   * Test {@link OperationChainValidator#getStoreTraits(Store, Context)}.
   *
   * <ul>
   *   <li>Then throw {@link GafferRuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link OperationChainValidator#getStoreTraits(Store, Context)}
   */
  @Test
  @DisplayName("Test getStoreTraits(Store, Context); then throw GafferRuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set OperationChainValidator.getStoreTraits(Store, Context)"})
  void testGetStoreTraits_thenThrowGafferRuntimeException() throws OperationException {
    // Arrange
    OperationChainValidator operationChainValidator =
        new OperationChainValidator(new ViewValidator());

    Store store = mock(Store.class);
    when(store.execute(Mockito.<Output<Set<StoreTrait>>>any(), Mockito.<Context>any()))
        .thenThrow(new OperationException("An error occurred"));

    // Act and Assert
    assertThrows(
        GafferRuntimeException.class,
        () -> operationChainValidator.getStoreTraits(store, new Context()));
    verify(store).execute(isA(Output.class), isA(Context.class));
  }
}
