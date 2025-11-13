/*
 * Copyright 2025 Crown Copyright
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.gov.gchq.gaffer.store.operation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uk.gov.gchq.gaffer.operation.Operation;
import uk.gov.gchq.gaffer.operation.OperationChain;
import uk.gov.gchq.gaffer.operation.OperationException;
import uk.gov.gchq.gaffer.operation.impl.Count;
import uk.gov.gchq.gaffer.operation.impl.io.GenericInputImpl;
import uk.gov.gchq.gaffer.operation.impl.io.InputImpl;
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
   * Test {@link OperationChainValidator#validate(OperationChain, User, Store)} with {@code operationChain}, {@code user}, {@code store}.
   * <p>
   * Method under test: {@link OperationChainValidator#validate(OperationChain, User, Store)}
   */
  @Test
  @DisplayName("Test validate(OperationChain, User, Store) with 'operationChain', 'user', 'store'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValidationResult OperationChainValidator.validate(OperationChain, User, Store)"})
  void testValidateWithOperationChainUserStore() {
    // Arrange
    OperationChainValidator operationChainValidator = new OperationChainValidator(new ViewValidator());
    OperationChain<?> operationChain = new OperationChain<>();
    User user = new User();

    // Act
    ValidationResult actualValidateResult = operationChainValidator.validate(operationChain, user,
        new TestAddToGraphLibraryImpl());

    // Assert
    assertEquals("Validation errors: \nOperation chain contains no operations", actualValidateResult.getErrorString());
    Set<String> errors = actualValidateResult.getErrors();
    assertEquals(1, errors.size());
    assertFalse(actualValidateResult.isValid());
    assertTrue(errors.contains("Operation chain contains no operations"));
  }

  /**
   * Test {@link OperationChainValidator#validate(Operation, User, Store, ValidationResult, Class)} with {@code operation}, {@code user}, {@code store}, {@code validationResult}, {@code input}.
   * <p>
   * Method under test: {@link OperationChainValidator#validate(Operation, User, Store, ValidationResult, Class)}
   */
  @Test
  @DisplayName("Test validate(Operation, User, Store, ValidationResult, Class) with 'operation', 'user', 'store', 'validationResult', 'input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Class OperationChainValidator.validate(Operation, User, Store, ValidationResult, Class)"})
  void testValidateWithOperationUserStoreValidationResultInput() {
    // Arrange
    OperationChainValidator operationChainValidator = new OperationChainValidator(new ViewValidator());
    InputImpl operation = new InputImpl();
    User user = new User();
    TestAddToGraphLibraryImpl store = new TestAddToGraphLibraryImpl();
    ValidationResult validationResult = new ValidationResult("An error occurred");
    Class<Output> input = Output.class;

    // Act
    operationChainValidator.validate(operation, user, store, validationResult, input);

    // Assert
    assertEquals("Validation errors: \n" + "An error occurred\n" + "requiredField2 is required for: InputImpl\n"
        + "requiredField1 is required for: InputImpl", validationResult.getErrorString());
    Set<String> errors = validationResult.getErrors();
    assertEquals(3, errors.size());
    assertTrue(errors.contains("requiredField1 is required for: InputImpl"));
    assertTrue(errors.contains("requiredField2 is required for: InputImpl"));
  }

  /**
   * Test {@link OperationChainValidator#validate(Operation, User, Store, ValidationResult, Class)} with {@code operation}, {@code user}, {@code store}, {@code validationResult}, {@code input}.
   * <p>
   * Method under test: {@link OperationChainValidator#validate(Operation, User, Store, ValidationResult, Class)}
   */
  @Test
  @DisplayName("Test validate(Operation, User, Store, ValidationResult, Class) with 'operation', 'user', 'store', 'validationResult', 'input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Class OperationChainValidator.validate(Operation, User, Store, ValidationResult, Class)"})
  void testValidateWithOperationUserStoreValidationResultInput2() {
    // Arrange
    OperationChainValidator operationChainValidator = new OperationChainValidator(new ViewValidator());
    OperationChain<Object> operation = new OperationChain<>(new DeleteAllData());
    User user = new User();
    TestAddToGraphLibraryImpl store = new TestAddToGraphLibraryImpl();
    ValidationResult validationResult = new ValidationResult("An error occurred");
    Class<Output> input = Output.class;

    // Act
    Class<? extends Output> actualValidateResult = operationChainValidator.validate(operation, user, store,
        validationResult, input);

    // Assert
    assertEquals(
        "Validation errors: \n" + "An error occurred\n"
            + "Invalid combination of operations: uk.gov.gchq.gaffer.operation.io.Output -> uk.gov.gchq.gaffer.store"
            + ".operation.DeleteAllData. Class has an output but DeleteAllData does not take an input.",
        validationResult.getErrorString());
    Set<String> errors = validationResult.getErrors();
    assertEquals(2, errors.size());
    assertTrue(errors.contains(
        "Invalid combination of operations: uk.gov.gchq.gaffer.operation.io.Output -> uk.gov.gchq.gaffer.store"
            + ".operation.DeleteAllData. Class has an output but DeleteAllData does not take an input."));
    Class<OperationChain> expectedValidateResult = OperationChain.class;
    assertEquals(expectedValidateResult, actualValidateResult);
  }

  /**
   * Test {@link OperationChainValidator#validate(Operation, User, Store, ValidationResult, Class)} with {@code operation}, {@code user}, {@code store}, {@code validationResult}, {@code input}.
   * <ul>
   *   <li>Then return {@link Count}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationChainValidator#validate(Operation, User, Store, ValidationResult, Class)}
   */
  @Test
  @DisplayName("Test validate(Operation, User, Store, ValidationResult, Class) with 'operation', 'user', 'store', 'validationResult', 'input'; then return Count")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Class OperationChainValidator.validate(Operation, User, Store, ValidationResult, Class)"})
  void testValidateWithOperationUserStoreValidationResultInput_thenReturnCount() {
    // Arrange
    OperationChainValidator operationChainValidator = new OperationChainValidator(new ViewValidator());
    Count<Object> operation = new Count<>();
    User user = new User();
    TestAddToGraphLibraryImpl store = new TestAddToGraphLibraryImpl();
    ValidationResult validationResult = new ValidationResult("An error occurred");
    Class<Output> input = Output.class;

    // Act
    Class<? extends Output> actualValidateResult = operationChainValidator.validate(operation, user, store,
        validationResult, input);

    // Assert
    assertEquals("Validation errors: \nAn error occurred", validationResult.getErrorString());
    assertEquals(1, validationResult.getErrors().size());
    Class<Count> expectedValidateResult = Count.class;
    assertEquals(expectedValidateResult, actualValidateResult);
  }

  /**
   * Test {@link OperationChainValidator#validate(Operation, User, Store, ValidationResult, Class)} with {@code operation}, {@code user}, {@code store}, {@code validationResult}, {@code input}.
   * <ul>
   *   <li>When {@link DeleteAllData} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationChainValidator#validate(Operation, User, Store, ValidationResult, Class)}
   */
  @Test
  @DisplayName("Test validate(Operation, User, Store, ValidationResult, Class) with 'operation', 'user', 'store', 'validationResult', 'input'; when DeleteAllData (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Class OperationChainValidator.validate(Operation, User, Store, ValidationResult, Class)"})
  void testValidateWithOperationUserStoreValidationResultInput_whenDeleteAllData() {
    // Arrange
    OperationChainValidator operationChainValidator = new OperationChainValidator(new ViewValidator());
    DeleteAllData operation = new DeleteAllData();
    User user = new User();
    TestAddToGraphLibraryImpl store = new TestAddToGraphLibraryImpl();
    ValidationResult validationResult = new ValidationResult("An error occurred");
    Class<Output> input = Output.class;

    // Act
    Class<? extends Output> actualValidateResult = operationChainValidator.validate(operation, user, store,
        validationResult, input);

    // Assert
    assertEquals(
        "Validation errors: \n" + "An error occurred\n"
            + "Invalid combination of operations: uk.gov.gchq.gaffer.operation.io.Output -> uk.gov.gchq.gaffer.store"
            + ".operation.DeleteAllData. Class has an output but DeleteAllData does not take an input.",
        validationResult.getErrorString());
    assertNull(actualValidateResult);
    Set<String> errors = validationResult.getErrors();
    assertEquals(2, errors.size());
    assertTrue(errors.contains(
        "Invalid combination of operations: uk.gov.gchq.gaffer.operation.io.Output -> uk.gov.gchq.gaffer.store"
            + ".operation.DeleteAllData. Class has an output but DeleteAllData does not take an input."));
  }

  /**
   * Test {@link OperationChainValidator#validate(Operation, User, Store, ValidationResult, Class)} with {@code operation}, {@code user}, {@code store}, {@code validationResult}, {@code input}.
   * <ul>
   *   <li>When {@link GenericInputImpl#GenericInputImpl()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationChainValidator#validate(Operation, User, Store, ValidationResult, Class)}
   */
  @Test
  @DisplayName("Test validate(Operation, User, Store, ValidationResult, Class) with 'operation', 'user', 'store', 'validationResult', 'input'; when GenericInputImpl()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Class OperationChainValidator.validate(Operation, User, Store, ValidationResult, Class)"})
  void testValidateWithOperationUserStoreValidationResultInput_whenGenericInputImpl() {
    // Arrange
    OperationChainValidator operationChainValidator = new OperationChainValidator(new ViewValidator());
    GenericInputImpl operation = new GenericInputImpl();
    User user = new User();
    TestAddToGraphLibraryImpl store = new TestAddToGraphLibraryImpl();
    ValidationResult validationResult = new ValidationResult("An error occurred");
    Class<Output> input = Output.class;

    // Act
    Class<? extends Output> actualValidateResult = operationChainValidator.validate(operation, user, store,
        validationResult, input);

    // Assert
    assertEquals("Validation errors: \nAn error occurred", validationResult.getErrorString());
    assertNull(actualValidateResult);
    assertEquals(1, validationResult.getErrors().size());
  }

  /**
   * Test {@link OperationChainValidator#validate(Operation, User, Store, ValidationResult, Class)} with {@code operation}, {@code user}, {@code store}, {@code validationResult}, {@code input}.
   * <ul>
   *   <li>When {@link OperationChain#OperationChain()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationChainValidator#validate(Operation, User, Store, ValidationResult, Class)}
   */
  @Test
  @DisplayName("Test validate(Operation, User, Store, ValidationResult, Class) with 'operation', 'user', 'store', 'validationResult', 'input'; when OperationChain()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Class OperationChainValidator.validate(Operation, User, Store, ValidationResult, Class)"})
  void testValidateWithOperationUserStoreValidationResultInput_whenOperationChain() {
    // Arrange
    OperationChainValidator operationChainValidator = new OperationChainValidator(new ViewValidator());
    OperationChain<Object> operation = new OperationChain<>();
    User user = new User();
    TestAddToGraphLibraryImpl store = new TestAddToGraphLibraryImpl();
    ValidationResult validationResult = new ValidationResult("An error occurred");
    Class<Output> input = Output.class;

    // Act
    Class<? extends Output> actualValidateResult = operationChainValidator.validate(operation, user, store,
        validationResult, input);

    // Assert
    assertEquals("Validation errors: \n" + "An error occurred\n"
        + "Invalid combination of operations: uk.gov.gchq.gaffer.operation.io.Output -> uk.gov.gchq.gaffer.operation"
        + ".OperationChain. Class has an output but OperationChain does not take an input.",
        validationResult.getErrorString());
    Set<String> errors = validationResult.getErrors();
    assertEquals(2, errors.size());
    assertTrue(errors.contains(
        "Invalid combination of operations: uk.gov.gchq.gaffer.operation.io.Output -> uk.gov.gchq.gaffer.operation"
            + ".OperationChain. Class has an output but OperationChain does not take an input."));
    Class<OperationChain> expectedValidateResult = OperationChain.class;
    assertEquals(expectedValidateResult, actualValidateResult);
  }

  /**
   * Test {@link OperationChainValidator#validateInputOutputTypes(Operation, ValidationResult, Store, Class)}.
   * <ul>
   *   <li>When {@link Count} (default constructor).</li>
   *   <li>Then return {@link Count}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationChainValidator#validateInputOutputTypes(Operation, ValidationResult, Store, Class)}
   */
  @Test
  @DisplayName("Test validateInputOutputTypes(Operation, ValidationResult, Store, Class); when Count (default constructor); then return Count")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "Class OperationChainValidator.validateInputOutputTypes(Operation, ValidationResult, Store, Class)"})
  void testValidateInputOutputTypes_whenCount_thenReturnCount() {
    // Arrange
    OperationChainValidator operationChainValidator = new OperationChainValidator(new ViewValidator());
    Count<Object> operation = new Count<>();
    ValidationResult validationResult = new ValidationResult("An error occurred");
    TestAddToGraphLibraryImpl store = new TestAddToGraphLibraryImpl();
    Class<Output> input = Output.class;

    // Act
    Class<? extends Output> actualValidateInputOutputTypesResult = operationChainValidator
        .validateInputOutputTypes(operation, validationResult, store, input);

    // Assert
    assertEquals("Validation errors: \nAn error occurred", validationResult.getErrorString());
    assertEquals(1, validationResult.getErrors().size());
    Class<Count> expectedValidateInputOutputTypesResult = Count.class;
    assertEquals(expectedValidateInputOutputTypesResult, actualValidateInputOutputTypesResult);
  }

  /**
   * Test {@link OperationChainValidator#validateInputOutputTypes(Operation, ValidationResult, Store, Class)}.
   * <ul>
   *   <li>When {@link DeleteAllData} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationChainValidator#validateInputOutputTypes(Operation, ValidationResult, Store, Class)}
   */
  @Test
  @DisplayName("Test validateInputOutputTypes(Operation, ValidationResult, Store, Class); when DeleteAllData (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "Class OperationChainValidator.validateInputOutputTypes(Operation, ValidationResult, Store, Class)"})
  void testValidateInputOutputTypes_whenDeleteAllData() {
    // Arrange
    OperationChainValidator operationChainValidator = new OperationChainValidator(new ViewValidator());
    DeleteAllData operation = new DeleteAllData();
    ValidationResult validationResult = new ValidationResult("An error occurred");
    TestAddToGraphLibraryImpl store = new TestAddToGraphLibraryImpl();
    Class<Output> input = Output.class;

    // Act
    Class<? extends Output> actualValidateInputOutputTypesResult = operationChainValidator
        .validateInputOutputTypes(operation, validationResult, store, input);

    // Assert
    assertEquals(
        "Validation errors: \n" + "An error occurred\n"
            + "Invalid combination of operations: uk.gov.gchq.gaffer.operation.io.Output -> uk.gov.gchq.gaffer.store"
            + ".operation.DeleteAllData. Class has an output but DeleteAllData does not take an input.",
        validationResult.getErrorString());
    assertNull(actualValidateInputOutputTypesResult);
    Set<String> errors = validationResult.getErrors();
    assertEquals(2, errors.size());
    assertTrue(errors.contains(
        "Invalid combination of operations: uk.gov.gchq.gaffer.operation.io.Output -> uk.gov.gchq.gaffer.store"
            + ".operation.DeleteAllData. Class has an output but DeleteAllData does not take an input."));
  }

  /**
   * Test {@link OperationChainValidator#validateInputOutputTypes(Operation, ValidationResult, Store, Class)}.
   * <ul>
   *   <li>When {@link GenericInputImpl#GenericInputImpl()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationChainValidator#validateInputOutputTypes(Operation, ValidationResult, Store, Class)}
   */
  @Test
  @DisplayName("Test validateInputOutputTypes(Operation, ValidationResult, Store, Class); when GenericInputImpl()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "Class OperationChainValidator.validateInputOutputTypes(Operation, ValidationResult, Store, Class)"})
  void testValidateInputOutputTypes_whenGenericInputImpl() {
    // Arrange
    OperationChainValidator operationChainValidator = new OperationChainValidator(new ViewValidator());
    GenericInputImpl operation = new GenericInputImpl();
    ValidationResult validationResult = new ValidationResult("An error occurred");
    TestAddToGraphLibraryImpl store = new TestAddToGraphLibraryImpl();
    Class<Output> input = Output.class;

    // Act
    Class<? extends Output> actualValidateInputOutputTypesResult = operationChainValidator
        .validateInputOutputTypes(operation, validationResult, store, input);

    // Assert
    assertEquals("Validation errors: \nAn error occurred", validationResult.getErrorString());
    assertNull(actualValidateInputOutputTypesResult);
    assertEquals(1, validationResult.getErrors().size());
  }

  /**
   * Test {@link OperationChainValidator#validateInputOutputTypes(Operation, ValidationResult, Store, Class)}.
   * <ul>
   *   <li>When {@link InputImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationChainValidator#validateInputOutputTypes(Operation, ValidationResult, Store, Class)}
   */
  @Test
  @DisplayName("Test validateInputOutputTypes(Operation, ValidationResult, Store, Class); when InputImpl (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "Class OperationChainValidator.validateInputOutputTypes(Operation, ValidationResult, Store, Class)"})
  void testValidateInputOutputTypes_whenInputImpl() {
    // Arrange
    OperationChainValidator operationChainValidator = new OperationChainValidator(new ViewValidator());
    InputImpl operation = new InputImpl();
    ValidationResult validationResult = new ValidationResult("An error occurred");
    TestAddToGraphLibraryImpl store = new TestAddToGraphLibraryImpl();
    Class<Output> input = Output.class;

    // Act
    Class<? extends Output> actualValidateInputOutputTypesResult = operationChainValidator
        .validateInputOutputTypes(operation, validationResult, store, input);

    // Assert
    assertEquals("Validation errors: \nAn error occurred", validationResult.getErrorString());
    assertNull(actualValidateInputOutputTypesResult);
    assertEquals(1, validationResult.getErrors().size());
  }

  /**
   * Test {@link OperationChainValidator#validateInputOutputTypes(Operation, ValidationResult, Store, Class)}.
   * <ul>
   *   <li>When {@link OperationChain#OperationChain(Operation[])} with operations is {@link DeleteAllData} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationChainValidator#validateInputOutputTypes(Operation, ValidationResult, Store, Class)}
   */
  @Test
  @DisplayName("Test validateInputOutputTypes(Operation, ValidationResult, Store, Class); when OperationChain(Operation[]) with operations is DeleteAllData (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "Class OperationChainValidator.validateInputOutputTypes(Operation, ValidationResult, Store, Class)"})
  void testValidateInputOutputTypes_whenOperationChainWithOperationsIsDeleteAllData() {
    // Arrange
    OperationChainValidator operationChainValidator = new OperationChainValidator(new ViewValidator());
    OperationChain<Object> operation = new OperationChain<>(new DeleteAllData());
    ValidationResult validationResult = new ValidationResult("An error occurred");
    TestAddToGraphLibraryImpl store = new TestAddToGraphLibraryImpl();
    Class<Output> input = Output.class;

    // Act
    Class<? extends Output> actualValidateInputOutputTypesResult = operationChainValidator
        .validateInputOutputTypes(operation, validationResult, store, input);

    // Assert
    assertEquals(
        "Validation errors: \n" + "An error occurred\n"
            + "Invalid combination of operations: uk.gov.gchq.gaffer.operation.io.Output -> uk.gov.gchq.gaffer.store"
            + ".operation.DeleteAllData. Class has an output but DeleteAllData does not take an input.",
        validationResult.getErrorString());
    Set<String> errors = validationResult.getErrors();
    assertEquals(2, errors.size());
    assertTrue(errors.contains(
        "Invalid combination of operations: uk.gov.gchq.gaffer.operation.io.Output -> uk.gov.gchq.gaffer.store"
            + ".operation.DeleteAllData. Class has an output but DeleteAllData does not take an input."));
    Class<OperationChain> expectedValidateInputOutputTypesResult = OperationChain.class;
    assertEquals(expectedValidateInputOutputTypesResult, actualValidateInputOutputTypesResult);
  }

  /**
   * Test {@link OperationChainValidator#validateInputOutputTypes(Operation, ValidationResult, Store, Class)}.
   * <ul>
   *   <li>When {@link OperationChain#OperationChain()}.</li>
   *   <li>Then return {@link OperationChain}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationChainValidator#validateInputOutputTypes(Operation, ValidationResult, Store, Class)}
   */
  @Test
  @DisplayName("Test validateInputOutputTypes(Operation, ValidationResult, Store, Class); when OperationChain(); then return OperationChain")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "Class OperationChainValidator.validateInputOutputTypes(Operation, ValidationResult, Store, Class)"})
  void testValidateInputOutputTypes_whenOperationChain_thenReturnOperationChain() {
    // Arrange
    OperationChainValidator operationChainValidator = new OperationChainValidator(new ViewValidator());
    OperationChain<Object> operation = new OperationChain<>();
    ValidationResult validationResult = new ValidationResult("An error occurred");
    TestAddToGraphLibraryImpl store = new TestAddToGraphLibraryImpl();
    Class<Output> input = Output.class;

    // Act
    Class<? extends Output> actualValidateInputOutputTypesResult = operationChainValidator
        .validateInputOutputTypes(operation, validationResult, store, input);

    // Assert
    assertEquals("Validation errors: \n" + "An error occurred\n"
        + "Invalid combination of operations: uk.gov.gchq.gaffer.operation.io.Output -> uk.gov.gchq.gaffer.operation"
        + ".OperationChain. Class has an output but OperationChain does not take an input.",
        validationResult.getErrorString());
    Set<String> errors = validationResult.getErrors();
    assertEquals(2, errors.size());
    assertTrue(errors.contains(
        "Invalid combination of operations: uk.gov.gchq.gaffer.operation.io.Output -> uk.gov.gchq.gaffer.operation"
            + ".OperationChain. Class has an output but OperationChain does not take an input."));
    Class<OperationChain> expectedValidateInputOutputTypesResult = OperationChain.class;
    assertEquals(expectedValidateInputOutputTypesResult, actualValidateInputOutputTypesResult);
  }

  /**
   * Test {@link OperationChainValidator#getFirstOperation(Operation)}.
   * <ul>
   *   <li>When {@link DeleteAllData} (default constructor).</li>
   *   <li>Then {@link DeleteAllData} (default constructor) Options is {@link DeleteAllData#options}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationChainValidator#getFirstOperation(Operation)}
   */
  @Test
  @DisplayName("Test getFirstOperation(Operation); when DeleteAllData (default constructor); then DeleteAllData (default constructor) Options is options")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Operation OperationChainValidator.getFirstOperation(Operation)"})
  void testGetFirstOperation_whenDeleteAllData_thenDeleteAllDataOptionsIsOptions() {
    // Arrange
    OperationChainValidator operationChainValidator = new OperationChainValidator(new ViewValidator());
    DeleteAllData operation = new DeleteAllData();

    // Act
    Operation actualFirstOperation = operationChainValidator.getFirstOperation(operation);

    // Assert
    assertSame(operation, actualFirstOperation);
    Map<String, String> expectedOptions = ((DeleteAllData) actualFirstOperation).options;
    assertSame(expectedOptions, operation.getOptions());
  }

  /**
   * Test {@link OperationChainValidator#getFirstOperation(Operation)}.
   * <ul>
   *   <li>When {@link OperationChain#OperationChain(Operation[])} with operations is {@link DeleteAllData} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationChainValidator#getFirstOperation(Operation)}
   */
  @Test
  @DisplayName("Test getFirstOperation(Operation); when OperationChain(Operation[]) with operations is DeleteAllData (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Operation OperationChainValidator.getFirstOperation(Operation)"})
  void testGetFirstOperation_whenOperationChainWithOperationsIsDeleteAllData() {
    // Arrange
    OperationChainValidator operationChainValidator = new OperationChainValidator(new ViewValidator());
    DeleteAllData deleteAllData = new DeleteAllData();

    // Act and Assert
    assertSame(deleteAllData, operationChainValidator.getFirstOperation(new OperationChain<>(deleteAllData)));
  }

  /**
   * Test {@link OperationChainValidator#getFirstOperation(Operation)}.
   * <ul>
   *   <li>When {@link OperationChain#OperationChain()}.</li>
   *   <li>Then return {@link OperationChain#OperationChain()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationChainValidator#getFirstOperation(Operation)}
   */
  @Test
  @DisplayName("Test getFirstOperation(Operation); when OperationChain(); then return OperationChain()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Operation OperationChainValidator.getFirstOperation(Operation)"})
  void testGetFirstOperation_whenOperationChain_thenReturnOperationChain() {
    // Arrange
    OperationChainValidator operationChainValidator = new OperationChainValidator(new ViewValidator());
    OperationChain<Object> operation = new OperationChain<>();

    // Act and Assert
    assertSame(operation, operationChainValidator.getFirstOperation(operation));
  }

  /**
   * Test {@link OperationChainValidator#shouldValidate(Operation)}.
   * <p>
   * Method under test: {@link OperationChainValidator#shouldValidate(Operation)}
   */
  @Test
  @DisplayName("Test shouldValidate(Operation)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean OperationChainValidator.shouldValidate(Operation)"})
  void testShouldValidate() {
    // Arrange
    OperationChainValidator operationChainValidator = new OperationChainValidator(new ViewValidator());

    // Act and Assert
    assertFalse(operationChainValidator.shouldValidate(new DeleteAllData()));
  }

  /**
   * Test {@link OperationChainValidator#getSchema(Operation, User, Store)}.
   * <p>
   * Method under test: {@link OperationChainValidator#getSchema(Operation, User, Store)}
   */
  @Test
  @DisplayName("Test getSchema(Operation, User, Store)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "uk.gov.gchq.gaffer.store.schema.Schema OperationChainValidator.getSchema(Operation, User, Store)"})
  void testGetSchema() {
    // Arrange
    OperationChainValidator operationChainValidator = new OperationChainValidator(new ViewValidator());
    DeleteAllData operation = new DeleteAllData();
    User user = new User();

    // Act and Assert
    assertNull(operationChainValidator.getSchema(operation, user, new TestAddToGraphLibraryImpl()));
  }

  /**
   * Test {@link OperationChainValidator#getStoreTraits(Store, Context)}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.</li>
   *   <li>When {@link Store} {@link Store#execute(Output, Context)} return {@link HashSet#HashSet()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationChainValidator#getStoreTraits(Store, Context)}
   */
  @Test
  @DisplayName("Test getStoreTraits(Store, Context); given HashSet(); when Store execute(Output, Context) return HashSet(); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set OperationChainValidator.getStoreTraits(Store, Context)"})
  void testGetStoreTraits_givenHashSet_whenStoreExecuteReturnHashSet_thenReturnEmpty() throws OperationException {
    // Arrange
    OperationChainValidator operationChainValidator = new OperationChainValidator(new ViewValidator());
    Store store = mock(Store.class);
    when(store.execute(Mockito.<Output<Set<StoreTrait>>>any(), Mockito.<Context>any())).thenReturn(new HashSet<>());

    // Act
    Set<StoreTrait> actualStoreTraits = operationChainValidator.getStoreTraits(store, new Context());

    // Assert
    verify(store).execute(isA(Output.class), isA(Context.class));
    assertTrue(actualStoreTraits.isEmpty());
  }
}
