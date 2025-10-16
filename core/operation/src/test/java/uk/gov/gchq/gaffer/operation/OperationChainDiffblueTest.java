package uk.gov.gchq.gaffer.operation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.core.type.TypeReference;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.exception.CloneFailedException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.named.operation.AddNamedOperation;
import uk.gov.gchq.gaffer.named.operation.NamedOperation;
import uk.gov.gchq.gaffer.operation.OperationChain.Builder;
import uk.gov.gchq.gaffer.operation.impl.ForEach;
import uk.gov.gchq.gaffer.operation.impl.io.GenericInputImpl;
import uk.gov.gchq.gaffer.operation.io.Output;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl;

class OperationChainDiffblueTest {
  /**
   * Test Builder {@link Builder#first(Operation)} with {@code Operation}.
   *
   * <p>Method under test: {@link Builder#first(Operation)}
   */
  @Test
  @DisplayName("Test Builder first(Operation) with 'Operation'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"OperationChain.NoOutputBuilder Builder.first(Operation)"})
  void testBuilderFirstWithOperation() {
    // Arrange
    Builder builder = new Builder();
    AddNamedOperation op = new AddNamedOperation();

    // Act and Assert
    OperationChain<Void> operationChain = builder.first(op).build();
    Operation[] operationArray = operationChain.getOperationArray();
    Operation operation = operationArray[0];
    assertTrue(operation instanceof AddNamedOperation);
    TypeReference<Void> outputTypeReference = operationChain.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.Void);
    List<Operation> operations = operationChain.getOperations();
    assertEquals(1, operations.size());
    assertEquals(1, operationArray.length);
    assertTrue(operationChain.getOptions().isEmpty());
    Class<Void> expectedOutputClass = Void.class;
    Class<?> outputClass = operationChain.getOutputClass();
    assertEquals(expectedOutputClass, outputClass);
    Class<Operation> expectedOperationsClass = Operation.class;
    assertEquals(expectedOperationsClass, operationChain.getOperationsClass());
    assertSame(op, operations.get(0));
    assertSame(op, operation);
    assertSame(outputClass, outputTypeReference.getType());
    assertSame(outputClass, operationChain.getOutputType());
  }

  /**
   * Test Builder {@link Builder#first(Output)} with {@code Output}.
   *
   * <p>Method under test: {@link Builder#first(Output)}
   */
  @Test
  @DisplayName("Test Builder first(Output) with 'Output'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"OperationChain.OutputBuilder Builder.first(Output)"})
  void testBuilderFirstWithOutput() {
    // Arrange
    Builder builder = new Builder();
    NamedOperation<Object, Object> op = new NamedOperation<>();

    // Act and Assert
    OperationChain<Object> operationChain = builder.first(op).build();
    Operation[] operationArray = operationChain.getOperationArray();
    Operation operation = operationArray[0];
    assertTrue(operation instanceof NamedOperation);
    TypeReference<Object> outputTypeReference = operationChain.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.Object);
    List<Operation> operations = operationChain.getOperations();
    assertEquals(1, operations.size());
    assertEquals(1, operationArray.length);
    assertTrue(operationChain.getOptions().isEmpty());
    Class<Object> expectedOutputClass = Object.class;
    Class<?> outputClass = operationChain.getOutputClass();
    assertEquals(expectedOutputClass, outputClass);
    Class<Operation> expectedOperationsClass = Operation.class;
    assertEquals(expectedOperationsClass, operationChain.getOperationsClass());
    assertSame(op, operations.get(0));
    assertSame(op, operation);
    assertSame(outputClass, outputTypeReference.getType());
    assertSame(outputClass, operationChain.getOutputType());
  }

  /**
   * Test {@link OperationChain#OperationChain(Output)}.
   *
   * <p>Method under test: {@link OperationChain#OperationChain(Output)}
   */
  @Test
  @DisplayName("Test new OperationChain(Output)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void OperationChain.<init>(Output)"})
  void testNewOperationChain() {
    // Arrange
    NamedOperation<Object, Object> operation = new NamedOperation<>();

    // Act
    OperationChain<Object> actualOperationChain = new OperationChain<>((Output<Object>) operation);

    // Assert
    Operation[] operationArray = actualOperationChain.getOperationArray();
    Operation operation2 = operationArray[0];
    assertTrue(operation2 instanceof NamedOperation);
    TypeReference<Object> outputTypeReference = actualOperationChain.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.Object);
    List<Operation> operations = actualOperationChain.getOperations();
    assertEquals(1, operations.size());
    assertEquals(1, operationArray.length);
    assertTrue(actualOperationChain.getOptions().isEmpty());
    Class<Object> expectedOutputClass = Object.class;
    Class<?> outputClass = actualOperationChain.getOutputClass();
    assertEquals(expectedOutputClass, outputClass);
    Class<Operation> expectedOperationsClass = Operation.class;
    assertEquals(expectedOperationsClass, actualOperationChain.getOperationsClass());
    assertSame(operation, operations.get(0));
    assertSame(operation, operation2);
    assertSame(outputClass, outputTypeReference.getType());
    assertSame(outputClass, actualOperationChain.getOutputType());
  }

  /**
   * Test {@link OperationChain#OperationChain(List)}.
   *
   * <ul>
   *   <li>Given {@link AddNamedOperation} (default constructor).
   *   <li>Then return array length is one.
   * </ul>
   *
   * <p>Method under test: {@link OperationChain#OperationChain(List)}
   */
  @Test
  @DisplayName(
      "Test new OperationChain(List); given AddNamedOperation (default constructor); then return array length is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void OperationChain.<init>(List)"})
  void testNewOperationChain_givenAddNamedOperation_thenReturnArrayLengthIsOne() {
    // Arrange
    ArrayList<Operation> operations = new ArrayList<>();
    AddNamedOperation addNamedOperation = new AddNamedOperation();
    operations.add(addNamedOperation);

    // Act
    OperationChain<Object> actualOperationChain = new OperationChain<>(operations);

    // Assert
    Operation[] operationArray = actualOperationChain.getOperationArray();
    assertEquals(1, operationArray.length);
    assertEquals(operations, actualOperationChain.getOperations());
    assertSame(addNamedOperation, operationArray[0]);
  }

  /**
   * Test {@link OperationChain#OperationChain(List)}.
   *
   * <ul>
   *   <li>Given {@link AddNamedOperation} (default constructor).
   *   <li>Then return Operations size is two.
   * </ul>
   *
   * <p>Method under test: {@link OperationChain#OperationChain(List)}
   */
  @Test
  @DisplayName(
      "Test new OperationChain(List); given AddNamedOperation (default constructor); then return Operations size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void OperationChain.<init>(List)"})
  void testNewOperationChain_givenAddNamedOperation_thenReturnOperationsSizeIsTwo() {
    // Arrange
    ArrayList<Operation> operations = new ArrayList<>();
    operations.add(new AddNamedOperation());
    AddNamedOperation addNamedOperation = new AddNamedOperation();
    operations.add(addNamedOperation);

    // Act
    OperationChain<Object> actualOperationChain = new OperationChain<>(operations);

    // Assert
    List<Operation> operations2 = actualOperationChain.getOperations();
    assertEquals(2, operations2.size());
    Operation[] operationArray = actualOperationChain.getOperationArray();
    assertEquals(2, operationArray.length);
    assertSame(addNamedOperation, operations2.get(1));
    assertSame(addNamedOperation, operationArray[1]);
  }

  /**
   * Test {@link OperationChain#OperationChain(List, boolean)}.
   *
   * <ul>
   *   <li>Then return Operations size is one.
   * </ul>
   *
   * <p>Method under test: {@link OperationChain#OperationChain(List, boolean)}
   */
  @Test
  @DisplayName("Test new OperationChain(List, boolean); then return Operations size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void OperationChain.<init>(List, boolean)"})
  void testNewOperationChain_thenReturnOperationsSizeIsOne() {
    // Arrange
    ForEach<Object, Object> forEach = new ForEach<>();
    GenericInputImpl operation = new GenericInputImpl();
    forEach.setOperation(operation);

    ArrayList<Operation> operations = new ArrayList<>();
    operations.add(forEach);

    // Act
    OperationChain<Object> actualOperationChain = new OperationChain<>(operations, true);

    // Assert
    List<Operation> operations2 = actualOperationChain.getOperations();
    assertEquals(1, operations2.size());
    Operation[] operationArray = actualOperationChain.getOperationArray();
    assertEquals(1, operationArray.length);
    assertSame(operation, operations2.get(0));
    assertSame(operation, operationArray[0]);
  }

  /**
   * Test {@link OperationChain#wrap(Operation)} with {@code Operation}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.
   *   <li>Then return first element Options is {@link HashMap#HashMap()}.
   * </ul>
   *
   * <p>Method under test: {@link OperationChain#wrap(Operation)}
   */
  @Test
  @DisplayName(
      "Test wrap(Operation) with 'Operation'; given HashMap(); then return first element Options is HashMap()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"OperationChain OperationChain.wrap(Operation)"})
  void testWrapWithOperation_givenHashMap_thenReturnFirstElementOptionsIsHashMap() {
    // Arrange
    AddNamedOperation operation = new AddNamedOperation();
    HashMap<String, String> options = new HashMap<>();
    operation.setOptions(options);

    // Act
    OperationChain<?> actualWrapResult = OperationChain.wrap(operation);

    // Assert
    Operation[] operationArray = actualWrapResult.getOperationArray();
    Operation operation2 = operationArray[0];
    assertTrue(operation2 instanceof AddNamedOperation);
    assertTrue(actualWrapResult.getOutputTypeReference() instanceof TypeReferenceImpl.Void);
    List<Operation> operations = actualWrapResult.getOperations();
    assertEquals(1, operations.size());
    assertEquals(1, operationArray.length);
    assertSame(options, operation2.getOptions());
    assertSame(operation2, operations.get(0));
  }

  /**
   * Test {@link OperationChain#wrap(Operation)} with {@code Operation}.
   *
   * <ul>
   *   <li>When {@link AddNamedOperation} (default constructor).
   *   <li>Then return first element Options is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link OperationChain#wrap(Operation)}
   */
  @Test
  @DisplayName(
      "Test wrap(Operation) with 'Operation'; when AddNamedOperation (default constructor); then return first element Options is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"OperationChain OperationChain.wrap(Operation)"})
  void testWrapWithOperation_whenAddNamedOperation_thenReturnFirstElementOptionsIsNull() {
    // Arrange and Act
    OperationChain<?> actualWrapResult = OperationChain.wrap(new AddNamedOperation());

    // Assert
    Operation[] operationArray = actualWrapResult.getOperationArray();
    Operation operation = operationArray[0];
    assertTrue(operation instanceof AddNamedOperation);
    assertTrue(actualWrapResult.getOutputTypeReference() instanceof TypeReferenceImpl.Void);
    assertNull(operation.getOptions());
    List<Operation> operations = actualWrapResult.getOperations();
    assertEquals(1, operations.size());
    assertEquals(1, operationArray.length);
    assertSame(operation, operations.get(0));
  }

  /**
   * Test {@link OperationChain#wrap(Operation)} with {@code Operation}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return array length is zero.
   * </ul>
   *
   * <p>Method under test: {@link OperationChain#wrap(Operation)}
   */
  @Test
  @DisplayName(
      "Test wrap(Operation) with 'Operation'; when 'null'; then return array length is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"OperationChain OperationChain.wrap(Operation)"})
  void testWrapWithOperation_whenNull_thenReturnArrayLengthIsZero() {
    // Arrange and Act
    OperationChain<?> actualWrapResult = OperationChain.wrap(null);

    // Assert
    assertTrue(actualWrapResult.getOutputTypeReference() instanceof TypeReferenceImpl.Void);
    assertEquals(0, actualWrapResult.getOperationArray().length);
    assertTrue(actualWrapResult.getOperations().isEmpty());
  }

  /**
   * Test {@link OperationChain#wrap(Operation)} with {@code Operation}.
   *
   * <ul>
   *   <li>When wrap {@link AddNamedOperation} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link OperationChain#wrap(Operation)}
   */
  @Test
  @DisplayName(
      "Test wrap(Operation) with 'Operation'; when wrap AddNamedOperation (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"OperationChain OperationChain.wrap(Operation)"})
  void testWrapWithOperation_whenWrapAddNamedOperation() {
    // Arrange
    OperationChain<?> operation = OperationChain.wrap(new AddNamedOperation());

    // Act
    OperationChain<?> actualWrapResult = OperationChain.wrap(operation);

    // Assert
    Operation[] operationArray = actualWrapResult.getOperationArray();
    Operation operation2 = operationArray[0];
    assertTrue(operation2 instanceof AddNamedOperation);
    assertTrue(actualWrapResult.getOutputTypeReference() instanceof TypeReferenceImpl.Void);
    List<Operation> operations = actualWrapResult.getOperations();
    assertEquals(1, operations.size());
    assertEquals(1, operationArray.length);
    assertSame(operation2, operations.get(0));
  }

  /**
   * Test {@link OperationChain#wrap(Output)} with {@code Output}.
   *
   * <ul>
   *   <li>Given {@code Name}.
   *   <li>Then return Options size is one.
   * </ul>
   *
   * <p>Method under test: {@link OperationChain#wrap(Output)}
   */
  @Test
  @DisplayName("Test wrap(Output) with 'Output'; given 'Name'; then return Options size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"OperationChain OperationChain.wrap(Output)"})
  void testWrapWithOutput_givenName_thenReturnOptionsSizeIsOne() {
    // Arrange
    NamedOperation<Object, Object> operation = new NamedOperation<>();
    operation.addOption("Name", "42");

    // Act
    OperationChain<Object> actualWrapResult = OperationChain.wrap(operation);

    // Assert
    Operation[] operationArray = actualWrapResult.getOperationArray();
    Operation operation2 = operationArray[0];
    assertTrue(operation2 instanceof NamedOperation);
    assertTrue(actualWrapResult.getOutputTypeReference() instanceof TypeReferenceImpl.Object);
    Map<String, String> options = actualWrapResult.getOptions();
    assertEquals(1, options.size());
    assertEquals("42", options.get("Name"));
    List<Operation> operations = actualWrapResult.getOperations();
    assertEquals(1, operations.size());
    assertEquals(1, operationArray.length);
    assertSame(options, operation2.getOptions());
    assertSame(operation2, operations.get(0));
  }

  /**
   * Test {@link OperationChain#wrap(Output)} with {@code Output}.
   *
   * <ul>
   *   <li>Then first element OutputTypeReference return {@link TypeReferenceImpl.Object}.
   * </ul>
   *
   * <p>Method under test: {@link OperationChain#wrap(Output)}
   */
  @Test
  @DisplayName(
      "Test wrap(Output) with 'Output'; then first element OutputTypeReference return Object")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"OperationChain OperationChain.wrap(Output)"})
  void testWrapWithOutput_thenFirstElementOutputTypeReferenceReturnObject() {
    // Arrange
    OperationChain<Object> operation = OperationChain.wrap(new NamedOperation<>());

    // Act
    OperationChain<Object> actualWrapResult = OperationChain.wrap(operation);

    // Assert
    Operation[] operationArray = actualWrapResult.getOperationArray();
    Operation operation2 = operationArray[0];
    assertTrue(operation2 instanceof NamedOperation);
    assertTrue(
        ((NamedOperation<Object, Object>) operation2).getOutputTypeReference()
            instanceof TypeReferenceImpl.Object);
    assertTrue(actualWrapResult.getOutputTypeReference() instanceof TypeReferenceImpl.Object);
    List<Operation> operations = actualWrapResult.getOperations();
    assertEquals(1, operations.size());
    assertEquals(1, operationArray.length);
    assertSame(operation2, operations.get(0));
  }

  /**
   * Test {@link OperationChain#wrap(Output)} with {@code Output}.
   *
   * <ul>
   *   <li>When {@link NamedOperation} (default constructor).
   *   <li>Then return first element Options is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link OperationChain#wrap(Output)}
   */
  @Test
  @DisplayName(
      "Test wrap(Output) with 'Output'; when NamedOperation (default constructor); then return first element Options is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"OperationChain OperationChain.wrap(Output)"})
  void testWrapWithOutput_whenNamedOperation_thenReturnFirstElementOptionsIsNull() {
    // Arrange and Act
    OperationChain<Object> actualWrapResult = OperationChain.wrap(new NamedOperation<>());

    // Assert
    Operation[] operationArray = actualWrapResult.getOperationArray();
    Operation operation = operationArray[0];
    assertTrue(operation instanceof NamedOperation);
    assertTrue(actualWrapResult.getOutputTypeReference() instanceof TypeReferenceImpl.Object);
    assertNull(operation.getOptions());
    List<Operation> operations = actualWrapResult.getOperations();
    assertEquals(1, operations.size());
    assertEquals(1, operationArray.length);
    assertSame(operation, operations.get(0));
  }

  /**
   * Test {@link OperationChain#getOutputTypeReference()}.
   *
   * <ul>
   *   <li>Given array of {@link Operation} with wrap {@link NamedOperation} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link OperationChain#getOutputTypeReference()}
   */
  @Test
  @DisplayName(
      "Test getOutputTypeReference(); given array of Operation with wrap NamedOperation (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TypeReference OperationChain.getOutputTypeReference()"})
  void testGetOutputTypeReference_givenArrayOfOperationWithWrapNamedOperation() {
    // Arrange
    OperationChain<Object> operationChain = new OperationChain<>(new ArrayList<>());
    OperationChain<Object> wrapResult = OperationChain.wrap(new NamedOperation<>());
    operationChain.setOperationArray(wrapResult);

    // Act and Assert
    assertTrue(operationChain.getOutputTypeReference() instanceof TypeReferenceImpl.Object);
  }

  /**
   * Test {@link OperationChain#getOutputTypeReference()}.
   *
   * <ul>
   *   <li>Given wrap {@link NamedOperation} (default constructor).
   *   <li>Then return {@link TypeReferenceImpl.Object}.
   * </ul>
   *
   * <p>Method under test: {@link OperationChain#getOutputTypeReference()}
   */
  @Test
  @DisplayName(
      "Test getOutputTypeReference(); given wrap NamedOperation (default constructor); then return Object")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TypeReference OperationChain.getOutputTypeReference()"})
  void testGetOutputTypeReference_givenWrapNamedOperation_thenReturnObject() {
    // Arrange
    OperationChain<Object> wrapResult = OperationChain.wrap(new NamedOperation<>());

    // Act and Assert
    assertTrue(wrapResult.getOutputTypeReference() instanceof TypeReferenceImpl.Object);
  }

  /**
   * Test {@link OperationChain#getOperations()}.
   *
   * <p>Method under test: {@link OperationChain#getOperations()}
   */
  @Test
  @DisplayName("Test getOperations()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List OperationChain.getOperations()"})
  void testGetOperations() {
    // Arrange
    NamedOperation<Object, Object> operation = new NamedOperation<>();
    OperationChain<Object> wrapResult = OperationChain.wrap(operation);

    // Act
    List<Operation> actualOperations = wrapResult.getOperations();

    // Assert
    assertEquals(1, actualOperations.size());
    assertSame(operation, actualOperations.get(0));
  }

  /**
   * Test {@link OperationChain#getOperationArray()}.
   *
   * <p>Method under test: {@link OperationChain#getOperationArray()}
   */
  @Test
  @DisplayName("Test getOperationArray()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Operation[] OperationChain.getOperationArray()"})
  void testGetOperationArray() {
    // Arrange
    NamedOperation<Object, Object> operation = new NamedOperation<>();
    OperationChain<Object> wrapResult = OperationChain.wrap(operation);

    // Act
    Operation[] actualOperationArray = wrapResult.getOperationArray();

    // Assert
    assertEquals(1, actualOperationArray.length);
    assertSame(operation, actualOperationArray[0]);
  }

  /**
   * Test {@link OperationChain#setOperationArray(Operation[])}.
   *
   * <ul>
   *   <li>Then wrap {@link NamedOperation} (default constructor) Operations size is one.
   * </ul>
   *
   * <p>Method under test: {@link OperationChain#setOperationArray(Operation[])}
   */
  @Test
  @DisplayName(
      "Test setOperationArray(Operation[]); then wrap NamedOperation (default constructor) Operations size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void OperationChain.setOperationArray(Operation[])"})
  void testSetOperationArray_thenWrapNamedOperationOperationsSizeIsOne() {
    // Arrange
    OperationChain<Object> wrapResult = OperationChain.wrap(new NamedOperation<>());
    AddNamedOperation addNamedOperation = new AddNamedOperation();

    // Act
    wrapResult.setOperationArray(addNamedOperation);

    // Assert
    List<Operation> operations = wrapResult.getOperations();
    assertEquals(1, operations.size());
    Operation[] operationArray = wrapResult.getOperationArray();
    assertEquals(1, operationArray.length);
    assertSame(addNamedOperation, operations.get(0));
    assertSame(addNamedOperation, operationArray[0]);
  }

  /**
   * Test {@link OperationChain#shallowClone()}.
   *
   * <ul>
   *   <li>Given wrap {@link NamedOperation} (default constructor).
   *   <li>Then first element return {@link NamedOperation}.
   * </ul>
   *
   * <p>Method under test: {@link OperationChain#shallowClone()}
   */
  @Test
  @DisplayName(
      "Test shallowClone(); given wrap NamedOperation (default constructor); then first element return NamedOperation")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"OperationChain OperationChain.shallowClone()"})
  void testShallowClone_givenWrapNamedOperation_thenFirstElementReturnNamedOperation()
      throws CloneFailedException {
    // Arrange
    OperationChain<Object> wrapResult = OperationChain.wrap(new NamedOperation<>());

    // Act
    OperationChain<Object> actualShallowCloneResult = wrapResult.shallowClone();

    // Assert
    Operation[] operationArray = actualShallowCloneResult.getOperationArray();
    Operation operation = operationArray[0];
    assertTrue(operation instanceof NamedOperation);
    assertTrue(
        ((NamedOperation<Object, Object>) operation).getOutputTypeReference()
            instanceof TypeReferenceImpl.Object);
    assertTrue(
        actualShallowCloneResult.getOutputTypeReference() instanceof TypeReferenceImpl.Object);
    assertNull(((NamedOperation<Object, Object>) operation).getInput());
    assertNull(((NamedOperation<Object, Object>) operation).getOperationName());
    assertNull(((NamedOperation<Object, Object>) operation).getParameters());
    assertNull(operation.getOptions());
    List<Operation> operations = actualShallowCloneResult.getOperations();
    assertEquals(1, operations.size());
    assertEquals(1, operationArray.length);
    assertTrue(((NamedOperation<Object, Object>) operation).getOperations().isEmpty());
    assertSame(operation, operations.get(0));
  }

  /**
   * Test {@link OperationChain#shallowClone()}.
   *
   * <ul>
   *   <li>Then first element return {@link OperationChain}.
   * </ul>
   *
   * <p>Method under test: {@link OperationChain#shallowClone()}
   */
  @Test
  @DisplayName("Test shallowClone(); then first element return OperationChain")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"OperationChain OperationChain.shallowClone()"})
  void testShallowClone_thenFirstElementReturnOperationChain() throws CloneFailedException {
    // Arrange
    OperationChain<Object> operation = OperationChain.wrap(new NamedOperation<>());
    OperationChain<Object> wrapResult =
        OperationChain.wrap(new OperationChainDAO<>((Operation) operation));

    // Act
    OperationChain<Object> actualShallowCloneResult = wrapResult.shallowClone();

    // Assert
    Operation[] operationArray = actualShallowCloneResult.getOperationArray();
    Operation operation2 = operationArray[0];
    assertTrue(operation2 instanceof OperationChain);
    assertTrue(
        actualShallowCloneResult.getOutputTypeReference() instanceof TypeReferenceImpl.Object);
    assertTrue(
        ((OperationChain<Object>) operation2).getOutputTypeReference()
            instanceof TypeReferenceImpl.Object);
    assertEquals(1, actualShallowCloneResult.getOperations().size());
    assertEquals(1, ((OperationChain<Object>) operation2).getOperations().size());
    assertEquals(1, operationArray.length);
    assertEquals(1, ((OperationChain<Object>) operation2).getOperationArray().length);
    assertTrue(operation2.getOptions().isEmpty());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OperationChain#toString()}
   *   <li>{@link OperationChain#getOptions()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map OperationChain.getOptions()", "String OperationChain.toString()"})
  void testGettersAndSetters() {
    // Arrange
    OperationChain<Object> wrapResult = OperationChain.wrap(new NamedOperation<>());

    // Act
    wrapResult.toString();

    // Assert
    assertTrue(wrapResult.getOptions().isEmpty());
  }

  /**
   * Test {@link OperationChain#setOptions(Map)}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.
   *   <li>Then wrap {@link NamedOperation} (default constructor) Options is {@link
   *       HashMap#HashMap()}.
   * </ul>
   *
   * <p>Method under test: {@link OperationChain#setOptions(Map)}
   */
  @Test
  @DisplayName(
      "Test setOptions(Map); when HashMap(); then wrap NamedOperation (default constructor) Options is HashMap()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void OperationChain.setOptions(Map)"})
  void testSetOptions_whenHashMap_thenWrapNamedOperationOptionsIsHashMap() {
    // Arrange
    OperationChain<Object> wrapResult = OperationChain.wrap(new NamedOperation<>());
    HashMap<String, String> options = new HashMap<>();

    // Act
    wrapResult.setOptions(options);

    // Assert
    assertSame(options, wrapResult.getOptions());
  }

  /**
   * Test {@link OperationChain#setOptions(Map)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then wrap {@link NamedOperation} (default constructor) Options Empty.
   * </ul>
   *
   * <p>Method under test: {@link OperationChain#setOptions(Map)}
   */
  @Test
  @DisplayName(
      "Test setOptions(Map); when 'null'; then wrap NamedOperation (default constructor) Options Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void OperationChain.setOptions(Map)"})
  void testSetOptions_whenNull_thenWrapNamedOperationOptionsEmpty() {
    // Arrange
    OperationChain<Object> wrapResult = OperationChain.wrap(new NamedOperation<>());

    // Act
    wrapResult.setOptions(null);

    // Assert that nothing has changed
    assertTrue(wrapResult.getOptions().isEmpty());
  }

  /**
   * Test {@link OperationChain#toOverviewString()}.
   *
   * <ul>
   *   <li>Given {@link OperationChain#OperationChain()}.
   *   <li>Then return {@code OperationChain[]}.
   * </ul>
   *
   * <p>Method under test: {@link OperationChain#toOverviewString()}
   */
  @Test
  @DisplayName("Test toOverviewString(); given OperationChain(); then return 'OperationChain[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String OperationChain.toOverviewString()"})
  void testToOverviewString_givenOperationChain_thenReturnOperationChain() {
    // Arrange
    OperationChain<Object> operationChain = new OperationChain<>();

    // Act and Assert
    assertEquals("OperationChain[]", operationChain.toOverviewString());
  }

  /**
   * Test {@link OperationChain#toOverviewString()}.
   *
   * <ul>
   *   <li>Then return {@code OperationChain[AddNamedOperation]}.
   * </ul>
   *
   * <p>Method under test: {@link OperationChain#toOverviewString()}
   */
  @Test
  @DisplayName("Test toOverviewString(); then return 'OperationChain[AddNamedOperation]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String OperationChain.toOverviewString()"})
  void testToOverviewString_thenReturnOperationChainAddNamedOperation() {
    // Arrange
    OperationChain<Object> wrapResult = OperationChain.wrap(new NamedOperation<>());
    wrapResult.setOperationArray(null, new AddNamedOperation());

    // Act and Assert
    assertEquals("OperationChain[AddNamedOperation]", wrapResult.toOverviewString());
  }

  /**
   * Test {@link OperationChain#toOverviewString()}.
   *
   * <ul>
   *   <li>Then return {@code OperationChain[AddNamedOperation->AddNamedOperation]}.
   * </ul>
   *
   * <p>Method under test: {@link OperationChain#toOverviewString()}
   */
  @Test
  @DisplayName(
      "Test toOverviewString(); then return 'OperationChain[AddNamedOperation->AddNamedOperation]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String OperationChain.toOverviewString()"})
  void testToOverviewString_thenReturnOperationChainAddNamedOperationAddNamedOperation() {
    // Arrange
    OperationChain<Object> wrapResult = OperationChain.wrap(new NamedOperation<>());
    AddNamedOperation addNamedOperation = new AddNamedOperation();
    wrapResult.setOperationArray(addNamedOperation, new AddNamedOperation());

    // Act and Assert
    assertEquals(
        "OperationChain[AddNamedOperation->AddNamedOperation]", wrapResult.toOverviewString());
  }

  /**
   * Test {@link OperationChain#toOverviewString()}.
   *
   * <ul>
   *   <li>Then return {@code OperationChain[NamedOperation]}.
   * </ul>
   *
   * <p>Method under test: {@link OperationChain#toOverviewString()}
   */
  @Test
  @DisplayName("Test toOverviewString(); then return 'OperationChain[NamedOperation]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String OperationChain.toOverviewString()"})
  void testToOverviewString_thenReturnOperationChainNamedOperation() {
    // Arrange
    OperationChain<Object> wrapResult = OperationChain.wrap(new NamedOperation<>());

    // Act and Assert
    assertEquals("OperationChain[NamedOperation]", wrapResult.toOverviewString());
  }

  /**
   * Test {@link OperationChain#close()}.
   *
   * <ul>
   *   <li>Given array of {@link Operation} with {@code null}.
   *   <li>Then calls {@link Output#getOptions()}.
   * </ul>
   *
   * <p>Method under test: {@link OperationChain#close()}
   */
  @Test
  @DisplayName("Test close(); given array of Operation with 'null'; then calls getOptions()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void OperationChain.close()"})
  void testClose_givenArrayOfOperationWithNull_thenCallsGetOptions() throws IOException {
    // Arrange
    Output<Object> operation = mock(Output.class);
    when(operation.getOptions()).thenReturn(new HashMap<>());

    try (OperationChain<Object> wrapResult = OperationChain.wrap(operation)) {
      wrapResult.setOperationArray(null);
    }

    // Act and Assert
    verify(operation).getOptions();
  }

  /**
   * Test {@link OperationChain#close()}.
   *
   * <ul>
   *   <li>Given {@link Output} {@link Output#close()} does nothing.
   *   <li>Then calls {@link Output#close()}.
   * </ul>
   *
   * <p>Method under test: {@link OperationChain#close()}
   */
  @Test
  @DisplayName("Test close(); given Output close() does nothing; then calls close()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void OperationChain.close()"})
  void testClose_givenOutputCloseDoesNothing_thenCallsClose() throws IOException {
    // Arrange
    Output<Object> operation = mock(Output.class);
    when(operation.getOptions()).thenReturn(new HashMap<>());
    doNothing().when(operation).close();
    try (OperationChain<Object> wrapResult = OperationChain.wrap(operation)) {}

    // Act and Assert
    verify(operation).close();
    verify(operation).getOptions();
  }

  /**
   * Test {@link OperationChain#close()}.
   *
   * <ul>
   *   <li>Then calls {@link OperationChainDAO#close()}.
   * </ul>
   *
   * <p>Method under test: {@link OperationChain#close()}
   */
  @Test
  @DisplayName("Test close(); then calls close()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void OperationChain.close()"})
  void testClose_thenCallsClose() throws IOException {
    // Arrange
    Output<Object> operation = mock(Output.class);
    when(operation.getOptions()).thenReturn(new HashMap<>());

    OperationChainDAO<Object> operation2 = mock(OperationChainDAO.class);
    doThrow(new CloneFailedException("An error occurred")).when(operation2).close();
    OperationChain<Object> wrapResult = OperationChain.wrap(operation2);

    try (OperationChain<Object> wrapResult2 = OperationChain.wrap(operation)) {
      wrapResult2.setOperationArray(wrapResult);
    }

    // Act and Assert
    verify(operation).getOptions();
    verify(operation2).close();
  }

  /**
   * Test {@link OperationChain#equals(Object)}, and {@link OperationChain#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OperationChain#equals(Object)}
   *   <li>{@link OperationChain#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OperationChain.equals(Object)", "int OperationChain.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    OperationChain<Object> wrapResult = OperationChain.wrap(new NamedOperation<>());

    // Act and Assert
    assertEquals(wrapResult, wrapResult);
    int expectedHashCodeResult = wrapResult.hashCode();
    assertEquals(expectedHashCodeResult, wrapResult.hashCode());
  }

  /**
   * Test {@link OperationChain#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OperationChain#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OperationChain.equals(Object)", "int OperationChain.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    OperationChain<Object> wrapResult = OperationChain.wrap(new NamedOperation<>());
    OperationChain<Object> wrapResult2 = OperationChain.wrap(new NamedOperation<>());

    // Act and Assert
    assertNotEquals(wrapResult, wrapResult2);
  }

  /**
   * Test {@link OperationChain#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OperationChain#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OperationChain.equals(Object)", "int OperationChain.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    OperationChain<Object> wrapResult = OperationChain.wrap(new NamedOperation<>());

    OperationChainDAO<Object> operationChainDAO = mock(OperationChainDAO.class);
    when(operationChainDAO.getOperations()).thenReturn(new ArrayList<>());

    // Act and Assert
    assertNotEquals(wrapResult, operationChainDAO);
  }

  /**
   * Test {@link OperationChain#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then throw exception.
   * </ul>
   *
   * <p>Method under test: {@link OperationChain#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then throw exception")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OperationChain.equals(Object)", "int OperationChain.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenThrowException() {
    // Arrange
    OperationChain<Object> wrapResult = OperationChain.wrap(new NamedOperation<>());

    OperationChainDAO<Object> operationChainDAO = mock(OperationChainDAO.class);
    when(operationChainDAO.getOperations())
        .thenThrow(new CloneFailedException("An error occurred"));

    // Act and Assert
    assertThrows(CloneFailedException.class, () -> wrapResult.equals(operationChainDAO));
  }

  /**
   * Test {@link OperationChain#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OperationChain#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OperationChain.equals(Object)", "int OperationChain.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    OperationChain<Object> wrapResult = OperationChain.wrap(new NamedOperation<>());

    // Act and Assert
    assertNotEquals(wrapResult, null);
  }

  /**
   * Test {@link OperationChain#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OperationChain#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OperationChain.equals(Object)", "int OperationChain.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    OperationChain<Object> wrapResult = OperationChain.wrap(new NamedOperation<>());

    // Act and Assert
    assertNotEquals(wrapResult, "Different type to OperationChain");
  }
}
