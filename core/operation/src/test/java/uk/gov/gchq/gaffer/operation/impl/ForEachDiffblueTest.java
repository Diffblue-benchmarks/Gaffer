package uk.gov.gchq.gaffer.operation.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.fasterxml.jackson.core.type.TypeReference;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.exception.CloneFailedException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.named.operation.AddNamedOperation;
import uk.gov.gchq.gaffer.operation.Operation;
import uk.gov.gchq.gaffer.operation.OperationChain;
import uk.gov.gchq.gaffer.operation.impl.ForEach.Builder;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl.IterableObj;

class ForEachDiffblueTest {
  /**
   * Test Builder new {@link Builder} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link Builder}
   */
  @Test
  @DisplayName("Test Builder new Builder (default constructor)")
  @Tag("MaintainedByDiffblue")
  void testBuilderNewBuilder() {
    // Arrange and Act
    Builder<Object, Object> actualBuilder = new Builder<>();

    // Assert
    ForEach<Object, Object> _getOpResult = actualBuilder._getOp();
    Collection<Operation> operations = _getOpResult.getOperations();
    assertTrue(operations instanceof List);
    TypeReference<Iterable<?>> outputTypeReference = _getOpResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof IterableObj);
    Type outputType = _getOpResult.getOutputType();
    assertEquals("java.lang.Iterable<?>", outputType.getTypeName());
    assertNull(_getOpResult.getInput());
    assertNull(_getOpResult.getOptions());
    assertNull(_getOpResult.getOperation());
    assertTrue(operations.isEmpty());
    Class<Iterable> expectedOutputClass = Iterable.class;
    assertEquals(expectedOutputClass, _getOpResult.getOutputClass());
    Class<Operation> expectedOperationsClass = Operation.class;
    assertEquals(expectedOperationsClass, _getOpResult.getOperationsClass());
    ForEach<Object, Object> actualForEach = actualBuilder.build();
    assertSame(_getOpResult, actualForEach);
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Test Builder {@link Builder#operation(Operation)}.
   *
   * <p>Method under test: {@link Builder#operation(Operation)}
   */
  @Test
  @DisplayName("Test Builder operation(Operation)")
  @Tag("MaintainedByDiffblue")
  void testBuilderOperation() {
    // Arrange
    Builder<Object, Object> builder = new Builder<>();

    // Act
    Builder<Object, Object> actualOperationResult = builder.operation(new AddNamedOperation());

    // Assert
    assertSame(builder, actualOperationResult);
  }

  /**
   * Test {@link ForEach#getInput()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ForEach#getInput()}
   */
  @Test
  @DisplayName("Test getInput(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  void testGetInput_thenReturnNull() {
    // Arrange
    ForEach<Object, Object> forEach = new ForEach<>();

    // Act and Assert
    assertNull(forEach.getInput());
  }

  /**
   * Test {@link ForEach#shallowClone()}.
   *
   * <ul>
   *   <li>Given {@link ForEach} (default constructor) Options is {@link HashMap#HashMap()}.
   *   <li>Then return Options Empty.
   * </ul>
   *
   * <p>Method under test: {@link ForEach#shallowClone()}
   */
  @Test
  @DisplayName(
      "Test shallowClone(); given ForEach (default constructor) Options is HashMap(); then return Options Empty")
  @Tag("MaintainedByDiffblue")
  void testShallowClone_givenForEachOptionsIsHashMap_thenReturnOptionsEmpty()
      throws CloneFailedException {
    // Arrange
    ForEach<Object, Object> forEach = new ForEach<>();
    forEach.setOptions(new HashMap<>());

    // Act
    ForEach<Object, Object> actualShallowCloneResult = forEach.shallowClone();

    // Assert
    Collection<Operation> operations = actualShallowCloneResult.getOperations();
    assertTrue(operations instanceof List);
    TypeReference<Iterable<?>> outputTypeReference =
        actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof IterableObj);
    Type outputType = actualShallowCloneResult.getOutputType();
    assertEquals("java.lang.Iterable<?>", outputType.getTypeName());
    assertNull(actualShallowCloneResult.getInput());
    assertNull(actualShallowCloneResult.getOperation());
    assertTrue(operations.isEmpty());
    assertTrue(actualShallowCloneResult.getOptions().isEmpty());
    Class<Iterable> expectedOutputClass = Iterable.class;
    assertEquals(expectedOutputClass, actualShallowCloneResult.getOutputClass());
    Class<Operation> expectedOperationsClass = Operation.class;
    assertEquals(expectedOperationsClass, actualShallowCloneResult.getOperationsClass());
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Test {@link ForEach#shallowClone()}.
   *
   * <ul>
   *   <li>Given {@link ForEach} (default constructor).
   *   <li>Then return Options is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ForEach#shallowClone()}
   */
  @Test
  @DisplayName(
      "Test shallowClone(); given ForEach (default constructor); then return Options is 'null'")
  @Tag("MaintainedByDiffblue")
  void testShallowClone_givenForEach_thenReturnOptionsIsNull() throws CloneFailedException {
    // Arrange
    ForEach<Object, Object> forEach = new ForEach<>();

    // Act
    ForEach<Object, Object> actualShallowCloneResult = forEach.shallowClone();

    // Assert
    Collection<Operation> operations = actualShallowCloneResult.getOperations();
    assertTrue(operations instanceof List);
    TypeReference<Iterable<?>> outputTypeReference =
        actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof IterableObj);
    Type outputType = actualShallowCloneResult.getOutputType();
    assertEquals("java.lang.Iterable<?>", outputType.getTypeName());
    assertNull(actualShallowCloneResult.getInput());
    assertNull(actualShallowCloneResult.getOptions());
    assertNull(actualShallowCloneResult.getOperation());
    assertTrue(operations.isEmpty());
    Class<Iterable> expectedOutputClass = Iterable.class;
    assertEquals(expectedOutputClass, actualShallowCloneResult.getOutputClass());
    Class<Operation> expectedOperationsClass = Operation.class;
    assertEquals(expectedOperationsClass, actualShallowCloneResult.getOperationsClass());
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Test {@link ForEach#getOutputTypeReference()}.
   *
   * <p>Method under test: {@link ForEach#getOutputTypeReference()}
   */
  @Test
  @DisplayName("Test getOutputTypeReference()")
  @Tag("MaintainedByDiffblue")
  void testGetOutputTypeReference() {
    // Arrange
    ForEach<Object, Object> forEach = new ForEach<>();

    // Act
    TypeReference<Iterable<?>> actualOutputTypeReference = forEach.getOutputTypeReference();

    // Assert
    assertTrue(actualOutputTypeReference instanceof IterableObj);
    assertEquals("java.lang.Iterable<?>", actualOutputTypeReference.getType().getTypeName());
  }

  /**
   * Test {@link ForEach#updateOperations(Collection)}.
   *
   * <ul>
   *   <li>Given {@link AddNamedOperation} (default constructor).
   *   <li>Then {@link ForEach} (default constructor) Operations is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link ForEach#updateOperations(Collection)}
   */
  @Test
  @DisplayName(
      "Test updateOperations(Collection); given AddNamedOperation (default constructor); then ForEach (default constructor) Operations is ArrayList()")
  @Tag("MaintainedByDiffblue")
  void testUpdateOperations_givenAddNamedOperation_thenForEachOperationsIsArrayList() {
    // Arrange
    ForEach<Object, Object> forEach = new ForEach<>();

    ArrayList<Operation> operations = new ArrayList<>();
    operations.add(new AddNamedOperation());
    operations.add(new AddNamedOperation());

    // Act
    forEach.updateOperations(operations);

    // Assert
    assertTrue(forEach.getOperation() instanceof OperationChain);
    assertEquals(operations, forEach.getOperations());
  }

  /**
   * Test {@link ForEach#updateOperations(Collection)}.
   *
   * <ul>
   *   <li>Given {@link AddNamedOperation} (default constructor).
   *   <li>Then {@link ForEach} (default constructor) Operations size is one.
   * </ul>
   *
   * <p>Method under test: {@link ForEach#updateOperations(Collection)}
   */
  @Test
  @DisplayName(
      "Test updateOperations(Collection); given AddNamedOperation (default constructor); then ForEach (default constructor) Operations size is one")
  @Tag("MaintainedByDiffblue")
  void testUpdateOperations_givenAddNamedOperation_thenForEachOperationsSizeIsOne() {
    // Arrange
    ForEach<Object, Object> forEach = new ForEach<>();

    ArrayList<Operation> operations = new ArrayList<>();
    AddNamedOperation addNamedOperation = new AddNamedOperation();
    operations.add(addNamedOperation);

    // Act
    forEach.updateOperations(operations);

    // Assert
    Collection<Operation> operations2 = forEach.getOperations();
    assertEquals(1, operations2.size());
    assertTrue(operations2 instanceof List);
    assertTrue(forEach.getOperation() instanceof OperationChain);
    assertSame(addNamedOperation, ((List<Operation>) operations2).get(0));
  }

  /**
   * Test {@link ForEach#getOperations()}.
   *
   * <ul>
   *   <li>Given {@link AddNamedOperation} (default constructor) Options is {@link
   *       HashMap#HashMap()}.
   * </ul>
   *
   * <p>Method under test: {@link ForEach#getOperations()}
   */
  @Test
  @DisplayName(
      "Test getOperations(); given AddNamedOperation (default constructor) Options is HashMap()")
  @Tag("MaintainedByDiffblue")
  void testGetOperations_givenAddNamedOperationOptionsIsHashMap() {
    // Arrange
    AddNamedOperation operation = new AddNamedOperation();
    operation.setOptions(new HashMap<>());

    ForEach<Object, Object> forEach = new ForEach<>();
    forEach.setOperation(operation);

    // Act
    Collection<Operation> actualOperations = forEach.getOperations();

    // Assert
    assertTrue(actualOperations instanceof List);
    assertEquals(1, actualOperations.size());
    assertSame(operation, ((List<Operation>) actualOperations).get(0));
  }

  /**
   * Test {@link ForEach#getOperations()}.
   *
   * <ul>
   *   <li>Given {@link ForEach} (default constructor) addOption {@code Name} and {@code 42}.
   *   <li>Then return first is {@link ForEach} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link ForEach#getOperations()}
   */
  @Test
  @DisplayName(
      "Test getOperations(); given ForEach (default constructor) addOption 'Name' and '42'; then return first is ForEach (default constructor)")
  @Tag("MaintainedByDiffblue")
  void testGetOperations_givenForEachAddOptionNameAnd42_thenReturnFirstIsForEach() {
    // Arrange
    ForEach<Object, Object> operation = new ForEach<>();
    operation.addOption("Name", "42");

    ForEach<Object, Object> forEach = new ForEach<>();
    forEach.setOperation(operation);

    // Act
    Collection<Operation> actualOperations = forEach.getOperations();

    // Assert
    assertTrue(actualOperations instanceof List);
    assertEquals(1, actualOperations.size());
    assertSame(operation, ((List<Operation>) actualOperations).get(0));
  }

  /**
   * Test {@link ForEach#getOperations()}.
   *
   * <ul>
   *   <li>Given {@link ForEach} (default constructor) updateOperations {@link
   *       ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link ForEach#getOperations()}
   */
  @Test
  @DisplayName(
      "Test getOperations(); given ForEach (default constructor) updateOperations ArrayList(); then return Empty")
  @Tag("MaintainedByDiffblue")
  void testGetOperations_givenForEachUpdateOperationsArrayList_thenReturnEmpty() {
    // Arrange
    ForEach<Object, Object> forEach = new ForEach<>();
    forEach.updateOperations(new ArrayList<>());

    // Act
    Collection<Operation> actualOperations = forEach.getOperations();

    // Assert
    assertTrue(actualOperations instanceof List);
    assertTrue(actualOperations.isEmpty());
  }

  /**
   * Test {@link ForEach#getOperations()}.
   *
   * <ul>
   *   <li>Given {@link ForEach} (default constructor).
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link ForEach#getOperations()}
   */
  @Test
  @DisplayName("Test getOperations(); given ForEach (default constructor); then return Empty")
  @Tag("MaintainedByDiffblue")
  void testGetOperations_givenForEach_thenReturnEmpty() {
    // Arrange
    ForEach<Object, Object> forEach = new ForEach<>();

    // Act
    Collection<Operation> actualOperations = forEach.getOperations();

    // Assert
    assertTrue(actualOperations instanceof List);
    assertTrue(actualOperations.isEmpty());
  }

  /**
   * Test {@link ForEach#getOperations()}.
   *
   * <ul>
   *   <li>Then return first is {@link AddNamedOperation} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link ForEach#getOperations()}
   */
  @Test
  @DisplayName("Test getOperations(); then return first is AddNamedOperation (default constructor)")
  @Tag("MaintainedByDiffblue")
  void testGetOperations_thenReturnFirstIsAddNamedOperation() {
    // Arrange
    ForEach<Object, Object> forEach = new ForEach<>();
    AddNamedOperation operation = new AddNamedOperation();
    forEach.setOperation(operation);

    // Act
    Collection<Operation> actualOperations = forEach.getOperations();

    // Assert
    assertTrue(actualOperations instanceof List);
    assertEquals(1, actualOperations.size());
    assertSame(operation, ((List<Operation>) actualOperations).get(0));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link ForEach}
   *   <li>{@link ForEach#setInput(Iterable)}
   *   <li>{@link ForEach#setOperation(Operation)}
   *   <li>{@link ForEach#setOptions(Map)}
   *   <li>{@link ForEach#getOperation()}
   *   <li>{@link ForEach#getOptions()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  void testGettersAndSetters() {
    // Arrange and Act
    ForEach<Object, Object> actualForEach = new ForEach<>();
    ArrayList<Object> input = new ArrayList<>();
    actualForEach.setInput(input);
    AddNamedOperation operation = new AddNamedOperation();
    actualForEach.setOperation(operation);
    HashMap<String, String> options = new HashMap<>();
    actualForEach.setOptions(options);
    Operation actualOperation = actualForEach.getOperation();
    Map<String, String> actualOptions = actualForEach.getOptions();

    // Assert
    Iterable<?> input2 = actualForEach.getInput();
    assertTrue(input2 instanceof List);
    assertTrue(actualOptions.isEmpty());
    assertSame(input, input2);
    assertSame(options, actualOptions);
    assertSame(operation, actualOperation);
  }
}
