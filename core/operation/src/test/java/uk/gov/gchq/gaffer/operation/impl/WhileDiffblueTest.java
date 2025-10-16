package uk.gov.gchq.gaffer.operation.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.named.operation.AddNamedOperation;
import uk.gov.gchq.gaffer.operation.Operation;
import uk.gov.gchq.gaffer.operation.OperationChain;
import uk.gov.gchq.gaffer.operation.impl.While.Builder;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl;
import uk.gov.gchq.gaffer.operation.util.Conditional;
import uk.gov.gchq.koryphe.ValidationResult;

class WhileDiffblueTest {
  /**
   * Test Builder {@link Builder#condition(Boolean)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return _getOp Condition is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#condition(Boolean)}
   */
  @Test
  @DisplayName(
      "Test Builder condition(Boolean); when 'null'; then return _getOp Condition is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.condition(Boolean)"})
  void testBuilderCondition_whenNull_thenReturn_getOpConditionIsNull() {
    // Arrange
    Builder<Object, Object> builder = new Builder<>();

    // Act
    Builder<Object, Object> actualConditionResult = builder.condition(null);

    // Assert
    While<Object, Object> _getOpResult = actualConditionResult._getOp();
    Collection<Operation> operations = _getOpResult.getOperations();
    assertEquals(2, operations.size());
    assertTrue(operations instanceof List);
    assertTrue(((List<Operation>) operations).get(0) instanceof OperationChain);
    assertTrue(((List<Operation>) operations).get(1) instanceof OperationChain);
    assertTrue(_getOpResult.getOutputTypeReference() instanceof TypeReferenceImpl.Object);
    assertNull(_getOpResult.isCondition());
    While<Object, Object> actualResultWhile = actualConditionResult.build();
    assertSame(_getOpResult, actualResultWhile);
  }

  /**
   * Test Builder {@link Builder#condition(Boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then return _getOp Condition.
   * </ul>
   *
   * <p>Method under test: {@link Builder#condition(Boolean)}
   */
  @Test
  @DisplayName("Test Builder condition(Boolean); when 'true'; then return _getOp Condition")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.condition(Boolean)"})
  void testBuilderCondition_whenTrue_thenReturn_getOpCondition() {
    // Arrange
    Builder<Object, Object> builder = new Builder<>();

    // Act
    Builder<Object, Object> actualConditionResult = builder.condition(true);

    // Assert
    While<Object, Object> _getOpResult = actualConditionResult._getOp();
    Collection<Operation> operations = _getOpResult.getOperations();
    assertEquals(2, operations.size());
    assertTrue(operations instanceof List);
    assertTrue(((List<Operation>) operations).get(0) instanceof OperationChain);
    assertTrue(((List<Operation>) operations).get(1) instanceof OperationChain);
    assertTrue(_getOpResult.getOutputTypeReference() instanceof TypeReferenceImpl.Object);
    assertTrue(_getOpResult.isCondition());
    While<Object, Object> actualResultWhile = actualConditionResult.build();
    assertSame(_getOpResult, actualResultWhile);
  }

  /**
   * Test Builder {@link Builder#conditional(Conditional)} with {@code conditional}.
   *
   * <ul>
   *   <li>Then return _getOp Conditional is {@link Conditional#Conditional()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#conditional(Conditional)}
   */
  @Test
  @DisplayName(
      "Test Builder conditional(Conditional) with 'conditional'; then return _getOp Conditional is Conditional()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.conditional(Conditional)"})
  void testBuilderConditionalWithConditional_thenReturn_getOpConditionalIsConditional() {
    // Arrange
    Builder<Object, Object> builder = new Builder<>();
    Conditional conditional = new Conditional();

    // Act
    Builder<Object, Object> actualConditionalResult = builder.conditional(conditional);

    // Assert
    While<Object, Object> _getOpResult = actualConditionalResult._getOp();
    Collection<Operation> operations = _getOpResult.getOperations();
    assertEquals(2, operations.size());
    assertTrue(operations instanceof List);
    assertTrue(((List<Operation>) operations).get(0) instanceof OperationChain);
    assertTrue(((List<Operation>) operations).get(1) instanceof OperationChain);
    assertTrue(_getOpResult.getOutputTypeReference() instanceof TypeReferenceImpl.Object);
    assertSame(conditional, _getOpResult.getConditional());
    While<Object, Object> actualResultWhile = actualConditionalResult.build();
    assertSame(_getOpResult, actualResultWhile);
  }

  /**
   * Test Builder {@link Builder#conditional(Conditional)} with {@code conditional}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return _getOp Conditional is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#conditional(Conditional)}
   */
  @Test
  @DisplayName(
      "Test Builder conditional(Conditional) with 'conditional'; when 'null'; then return _getOp Conditional is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.conditional(Conditional)"})
  void testBuilderConditionalWithConditional_whenNull_thenReturn_getOpConditionalIsNull() {
    // Arrange
    Builder<Object, Object> builder = new Builder<>();

    // Act
    Builder<Object, Object> actualConditionalResult = builder.conditional((Conditional) null);

    // Assert
    While<Object, Object> _getOpResult = actualConditionalResult._getOp();
    Collection<Operation> operations = _getOpResult.getOperations();
    assertEquals(2, operations.size());
    assertTrue(operations instanceof List);
    assertTrue(((List<Operation>) operations).get(0) instanceof OperationChain);
    assertTrue(((List<Operation>) operations).get(1) instanceof OperationChain);
    assertTrue(_getOpResult.getOutputTypeReference() instanceof TypeReferenceImpl.Object);
    assertNull(_getOpResult.getConditional());
    While<Object, Object> actualResultWhile = actualConditionalResult.build();
    assertSame(_getOpResult, actualResultWhile);
  }

  /**
   * Test Builder {@link Builder#conditional(Predicate)} with {@code predicate}.
   *
   * <p>Method under test: {@link Builder#conditional(Predicate)}
   */
  @Test
  @DisplayName("Test Builder conditional(Predicate) with 'predicate'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.conditional(Predicate)"})
  void testBuilderConditionalWithPredicate() {
    // Arrange
    Builder<Object, Object> builder = new Builder<>();
    Predicate predicate = mock(Predicate.class);

    // Act
    Builder<Object, Object> actualConditionalResult = builder.conditional(predicate);

    // Assert
    While<Object, Object> _getOpResult = actualConditionalResult._getOp();
    Collection<Operation> operations = _getOpResult.getOperations();
    assertEquals(2, operations.size());
    assertTrue(operations instanceof List);
    assertTrue(((List<Operation>) operations).get(0) instanceof OperationChain);
    assertTrue(((List<Operation>) operations).get(1) instanceof OperationChain);
    assertTrue(_getOpResult.getOutputTypeReference() instanceof TypeReferenceImpl.Object);
    While<Object, Object> actualResultWhile = actualConditionalResult.build();
    assertSame(_getOpResult, actualResultWhile);
    assertSame(predicate, _getOpResult.getConditional().getPredicate());
  }

  /**
   * Test Builder {@link Builder#conditional(Predicate, Operation)} with {@code predicate}, {@code
   * transform}.
   *
   * <p>Method under test: {@link Builder#conditional(Predicate, Operation)}
   */
  @Test
  @DisplayName("Test Builder conditional(Predicate, Operation) with 'predicate', 'transform'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.conditional(Predicate, Operation)"})
  void testBuilderConditionalWithPredicateTransform() {
    // Arrange
    Builder<Object, Object> builder = new Builder<>();
    Predicate predicate = mock(Predicate.class);

    // Act
    Builder<Object, Object> actualConditionalResult =
        builder.conditional(predicate, new AddNamedOperation());

    // Assert
    While<Object, Object> _getOpResult = actualConditionalResult._getOp();
    assertTrue(_getOpResult.getOutputTypeReference() instanceof TypeReferenceImpl.Object);
    While<Object, Object> actualResultWhile = actualConditionalResult.build();
    assertSame(_getOpResult, actualResultWhile);
    assertSame(predicate, _getOpResult.getConditional().getPredicate());
  }

  /**
   * Test Builder {@link Builder#conditional(Predicate, Operation)} with {@code predicate}, {@code
   * transform}.
   *
   * <p>Method under test: {@link Builder#conditional(Predicate, Operation)}
   */
  @Test
  @DisplayName("Test Builder conditional(Predicate, Operation) with 'predicate', 'transform'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.conditional(Predicate, Operation)"})
  void testBuilderConditionalWithPredicateTransform2() {
    // Arrange
    Builder<Object, Object> builder = new Builder<>();

    // Act
    Builder<Object, Object> actualConditionalResult =
        builder.conditional(null, new AddNamedOperation());

    // Assert
    While<Object, Object> _getOpResult = actualConditionalResult._getOp();
    assertTrue(_getOpResult.getConditional().getTransform() instanceof AddNamedOperation);
    assertTrue(_getOpResult.getOutputTypeReference() instanceof TypeReferenceImpl.Object);
    While<Object, Object> actualResultWhile = actualConditionalResult.build();
    assertSame(_getOpResult, actualResultWhile);
  }

  /**
   * Test Builder {@link Builder#conditional(Predicate)} with {@code predicate}.
   *
   * <ul>
   *   <li>Then return _getOp Conditional Predicate is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#conditional(Predicate)}
   */
  @Test
  @DisplayName(
      "Test Builder conditional(Predicate) with 'predicate'; then return _getOp Conditional Predicate is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.conditional(Predicate)"})
  void testBuilderConditionalWithPredicate_thenReturn_getOpConditionalPredicateIsNull() {
    // Arrange
    Builder<Object, Object> builder = new Builder<>();

    // Act
    Builder<Object, Object> actualConditionalResult = builder.conditional((Predicate) null);

    // Assert
    While<Object, Object> _getOpResult = actualConditionalResult._getOp();
    Collection<Operation> operations = _getOpResult.getOperations();
    assertEquals(2, operations.size());
    assertTrue(operations instanceof List);
    assertTrue(((List<Operation>) operations).get(0) instanceof OperationChain);
    assertTrue(((List<Operation>) operations).get(1) instanceof OperationChain);
    assertTrue(_getOpResult.getOutputTypeReference() instanceof TypeReferenceImpl.Object);
    assertNull(_getOpResult.getConditional().getPredicate());
    While<Object, Object> actualResultWhile = actualConditionalResult.build();
    assertSame(_getOpResult, actualResultWhile);
  }

  /**
   * Test Builder {@link Builder#maxRepeats(Integer)}.
   *
   * <p>Method under test: {@link Builder#maxRepeats(Integer)}
   */
  @Test
  @DisplayName("Test Builder maxRepeats(Integer)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.maxRepeats(Integer)"})
  void testBuilderMaxRepeats() {
    // Arrange
    Builder<Object, Object> builder = new Builder<>();

    // Act
    Builder<Object, Object> actualMaxRepeatsResult = builder.maxRepeats(1);

    // Assert
    assertSame(builder, actualMaxRepeatsResult);
  }

  /**
   * Test Builder new {@link Builder} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link Builder}
   */
  @Test
  @DisplayName("Test Builder new Builder (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Builder.<init>()"})
  void testBuilderNewBuilder() {
    // Arrange and Act
    Builder<Object, Object> actualBuilder = new Builder<>();

    // Assert
    While<Object, Object> _getOpResult = actualBuilder._getOp();
    Collection<Operation> operations = _getOpResult.getOperations();
    assertEquals(2, operations.size());
    assertTrue(operations instanceof List);
    assertTrue(_getOpResult.getOutputTypeReference() instanceof TypeReferenceImpl.Object);
    assertNull(_getOpResult.isCondition());
    assertNull(_getOpResult.getInput());
    assertNull(_getOpResult.getOptions());
    assertNull(_getOpResult.getOperation());
    assertNull(_getOpResult.getConditional());
    Class<Object> expectedOutputClass = Object.class;
    Class<?> outputClass = _getOpResult.getOutputClass();
    assertEquals(expectedOutputClass, outputClass);
    Class<Operation> expectedOperationsClass = Operation.class;
    assertEquals(expectedOperationsClass, _getOpResult.getOperationsClass());
    assertEquals(While.MAX_REPEATS, _getOpResult.getMaxRepeats());
    While<Object, Object> actualResultWhile = actualBuilder.build();
    assertSame(_getOpResult, actualResultWhile);
    assertSame(outputClass, _getOpResult.getOutputType());
  }

  /**
   * Test Builder {@link Builder#operation(Operation)}.
   *
   * <p>Method under test: {@link Builder#operation(Operation)}
   */
  @Test
  @DisplayName("Test Builder operation(Operation)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.operation(Operation)"})
  void testBuilderOperation() {
    // Arrange
    Builder<Object, Object> builder = new Builder<>();

    // Act
    Builder<Object, Object> actualOperationResult = builder.operation(new AddNamedOperation());

    // Assert
    assertSame(builder, actualOperationResult);
  }

  /**
   * Test {@link While#getOutputTypeReference()}.
   *
   * <p>Method under test: {@link While#getOutputTypeReference()}
   */
  @Test
  @DisplayName("Test getOutputTypeReference()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "com.fasterxml.jackson.core.type.TypeReference While.getOutputTypeReference()"
  })
  void testGetOutputTypeReference() {
    // Arrange
    While<Object, Object> resultWhile = new While<>();

    // Act and Assert
    assertTrue(resultWhile.getOutputTypeReference() instanceof TypeReferenceImpl.Object);
  }

  /**
   * Test {@link While#shallowClone()}.
   *
   * <ul>
   *   <li>Given {@link While} (default constructor) Conditional is {@code null}.
   *   <li>Then return {@link While} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link While#shallowClone()}
   */
  @Test
  @DisplayName(
      "Test shallowClone(); given While (default constructor) Conditional is 'null'; then return While (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"While While.shallowClone()"})
  void testShallowClone_givenWhileConditionalIsNull_thenReturnWhile() {
    // Arrange
    While<Object, Object> resultWhile = new While<>();
    resultWhile.setConditional(null);
    resultWhile.setOperation(null);
    resultWhile.setCondition(true);

    // Act
    While<Object, Object> actualShallowCloneResult = resultWhile.shallowClone();

    // Assert
    assertEquals(resultWhile, actualShallowCloneResult);
  }

  /**
   * Test {@link While#shallowClone()}.
   *
   * <ul>
   *   <li>Given {@link While} (default constructor) Options is {@link HashMap#HashMap()}.
   *   <li>Then return {@link While} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link While#shallowClone()}
   */
  @Test
  @DisplayName(
      "Test shallowClone(); given While (default constructor) Options is HashMap(); then return While (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"While While.shallowClone()"})
  void testShallowClone_givenWhileOptionsIsHashMap_thenReturnWhile() {
    // Arrange
    While<Object, Object> resultWhile = new While<>();
    resultWhile.setOptions(new HashMap<>());

    // Act
    While<Object, Object> actualShallowCloneResult = resultWhile.shallowClone();

    // Assert
    assertEquals(resultWhile, actualShallowCloneResult);
  }

  /**
   * Test {@link While#shallowClone()}.
   *
   * <ul>
   *   <li>Given {@link While} (default constructor).
   *   <li>Then return {@link While} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link While#shallowClone()}
   */
  @Test
  @DisplayName(
      "Test shallowClone(); given While (default constructor); then return While (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"While While.shallowClone()"})
  void testShallowClone_givenWhile_thenReturnWhile() {
    // Arrange
    While<Object, Object> resultWhile = new While<>();

    // Act
    While<Object, Object> actualShallowCloneResult = resultWhile.shallowClone();

    // Assert
    assertEquals(resultWhile, actualShallowCloneResult);
  }

  /**
   * Test {@link While#shallowClone()}.
   *
   * <ul>
   *   <li>Then Conditional Transform Operations return {@link List}.
   * </ul>
   *
   * <p>Method under test: {@link While#shallowClone()}
   */
  @Test
  @DisplayName("Test shallowClone(); then Conditional Transform Operations return List")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"While While.shallowClone()"})
  void testShallowClone_thenConditionalTransformOperationsReturnList() {
    // Arrange
    Conditional conditional = new Conditional(mock(Predicate.class));
    conditional.setTransform(new AddNamedOperation());

    While<Object, Object> resultWhile = new While<>();
    resultWhile.setConditional(conditional);
    resultWhile.setOperation(null);
    resultWhile.setCondition(null);

    // Act
    While<Object, Object> actualShallowCloneResult = resultWhile.shallowClone();

    // Assert
    Operation transform = actualShallowCloneResult.getConditional().getTransform();
    Collection<Operation> operations = ((AddNamedOperation) transform).getOperations();
    assertTrue(operations instanceof List);
    Collection<Operation> operations2 = actualShallowCloneResult.getOperations();
    assertEquals(2, operations2.size());
    assertTrue(operations2 instanceof List);
    assertTrue(transform instanceof AddNamedOperation);
    Operation getResult = ((List<Operation>) operations2).get(0);
    assertTrue(getResult instanceof OperationChain);
    assertNull(((AddNamedOperation) transform).getScore());
    assertNull(((AddNamedOperation) transform).getDescription());
    assertNull(((AddNamedOperation) transform).getOperationChainAsString());
    assertNull(((AddNamedOperation) transform).getOperationName());
    assertNull(((AddNamedOperation) transform).getLabels());
    assertNull(((AddNamedOperation) transform).getReadAccessRoles());
    assertNull(((AddNamedOperation) transform).getWriteAccessRoles());
    assertNull(transform.getOptions());
    assertNull(((AddNamedOperation) transform).getParameters());
    assertNull(((AddNamedOperation) transform).getReadAccessPredicate());
    assertNull(((AddNamedOperation) transform).getWriteAccessPredicate());
    assertEquals(1, ((OperationChain<Object>) getResult).getOperations().size());
    assertFalse(((AddNamedOperation) transform).isOverwriteFlag());
    assertTrue(operations.isEmpty());
  }

  /**
   * Test {@link While#shallowClone()}.
   *
   * <ul>
   *   <li>Then Operation Operations return {@link List}.
   * </ul>
   *
   * <p>Method under test: {@link While#shallowClone()}
   */
  @Test
  @DisplayName("Test shallowClone(); then Operation Operations return List")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"While While.shallowClone()"})
  void testShallowClone_thenOperationOperationsReturnList() {
    // Arrange
    While<Object, Object> resultWhile = new While<>();
    resultWhile.setConditional(null);
    resultWhile.setOperation(new AddNamedOperation());
    resultWhile.setCondition(null);

    // Act and Assert
    Operation operation = resultWhile.shallowClone().getOperation();
    Collection<Operation> operations = ((AddNamedOperation) operation).getOperations();
    assertTrue(operations instanceof List);
    assertTrue(operation instanceof AddNamedOperation);
    assertNull(((AddNamedOperation) operation).getScore());
    assertNull(((AddNamedOperation) operation).getDescription());
    assertNull(((AddNamedOperation) operation).getOperationChainAsString());
    assertNull(((AddNamedOperation) operation).getOperationName());
    assertNull(((AddNamedOperation) operation).getLabels());
    assertNull(((AddNamedOperation) operation).getReadAccessRoles());
    assertNull(((AddNamedOperation) operation).getWriteAccessRoles());
    assertNull(operation.getOptions());
    assertNull(((AddNamedOperation) operation).getParameters());
    assertNull(((AddNamedOperation) operation).getReadAccessPredicate());
    assertNull(((AddNamedOperation) operation).getWriteAccessPredicate());
    assertFalse(((AddNamedOperation) operation).isOverwriteFlag());
    assertTrue(operations.isEmpty());
  }

  /**
   * Test {@link While#shallowClone()}.
   *
   * <ul>
   *   <li>Then Operation return {@link OperationChain}.
   * </ul>
   *
   * <p>Method under test: {@link While#shallowClone()}
   */
  @Test
  @DisplayName("Test shallowClone(); then Operation return OperationChain")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"While While.shallowClone()"})
  void testShallowClone_thenOperationReturnOperationChain() {
    // Arrange
    While<Object, Object> resultWhile = new While<>();
    resultWhile.setConditional(null);
    OperationChain<Object> op = new OperationChain<>();
    resultWhile.setOperation(op);
    resultWhile.setCondition(true);

    // Act
    While<Object, Object> actualShallowCloneResult = resultWhile.shallowClone();

    // Assert
    Collection<Operation> operations = actualShallowCloneResult.getOperations();
    assertEquals(2, operations.size());
    assertTrue(operations instanceof List);
    Operation getResult = ((List<Operation>) operations).get(0);
    assertTrue(getResult instanceof OperationChain);
    Operation operation = actualShallowCloneResult.getOperation();
    assertTrue(operation instanceof OperationChain);
    assertEquals(op, getResult);
    assertEquals(op, operation);
    assertSame(operation, ((List<Operation>) operations).get(1));
  }

  /**
   * Test {@link While#shallowClone()}.
   *
   * <ul>
   *   <li>Then Operations second return {@link OperationChain}.
   * </ul>
   *
   * <p>Method under test: {@link While#shallowClone()}
   */
  @Test
  @DisplayName("Test shallowClone(); then Operations second return OperationChain")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"While While.shallowClone()"})
  void testShallowClone_thenOperationsSecondReturnOperationChain() {
    // Arrange
    While<Object, Object> resultWhile = new While<>();
    Conditional conditional = new Conditional();
    resultWhile.setConditional(conditional);
    resultWhile.setOperation(null);
    resultWhile.setCondition(null);

    // Act
    While<Object, Object> actualShallowCloneResult = resultWhile.shallowClone();

    // Assert
    Collection<Operation> operations = actualShallowCloneResult.getOperations();
    assertEquals(2, operations.size());
    assertTrue(operations instanceof List);
    Operation getResult = ((List<Operation>) operations).get(1);
    assertTrue(getResult instanceof OperationChain);
    assertEquals(conditional, actualShallowCloneResult.getConditional());
    assertEquals(((List<Operation>) operations).get(0), getResult);
  }

  /**
   * Test {@link While#getOperations()}.
   *
   * <ul>
   *   <li>Given {@link AddNamedOperation} (default constructor) Options is {@link
   *       HashMap#HashMap()}.
   * </ul>
   *
   * <p>Method under test: {@link While#getOperations()}
   */
  @Test
  @DisplayName(
      "Test getOperations(); given AddNamedOperation (default constructor) Options is HashMap()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection While.getOperations()"})
  void testGetOperations_givenAddNamedOperationOptionsIsHashMap() {
    // Arrange
    AddNamedOperation op = new AddNamedOperation();
    op.setOptions(new HashMap<>());

    While<Object, Object> resultWhile = new While<>();
    resultWhile.setConditional(null);
    resultWhile.setOperation(op);

    // Act
    Collection<Operation> actualOperations = resultWhile.getOperations();

    // Assert
    assertTrue(actualOperations instanceof List);
    assertEquals(2, actualOperations.size());
    Operation getResult = ((List<Operation>) actualOperations).get(1);
    assertTrue(getResult instanceof OperationChain);
    List<Operation> operations = ((OperationChain<Object>) getResult).getOperations();
    assertEquals(1, operations.size());
    assertSame(op, operations.get(0));
  }

  /**
   * Test {@link While#getOperations()}.
   *
   * <ul>
   *   <li>Then return second is {@link OperationChain#OperationChain()}.
   * </ul>
   *
   * <p>Method under test: {@link While#getOperations()}
   */
  @Test
  @DisplayName("Test getOperations(); then return second is OperationChain()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection While.getOperations()"})
  void testGetOperations_thenReturnSecondIsOperationChain() {
    // Arrange
    While<Object, Object> resultWhile = new While<>();
    resultWhile.setConditional(new Conditional());
    OperationChain<Object> op = new OperationChain<>();
    resultWhile.setOperation(op);

    // Act
    Collection<Operation> actualOperations = resultWhile.getOperations();

    // Assert
    assertTrue(actualOperations instanceof List);
    assertEquals(2, actualOperations.size());
    assertTrue(((List<Operation>) actualOperations).get(0) instanceof OperationChain);
    assertSame(op, ((List<Operation>) actualOperations).get(1));
  }

  /**
   * Test {@link While#getOperations()}.
   *
   * <ul>
   *   <li>Then return second Operations size is one.
   * </ul>
   *
   * <p>Method under test: {@link While#getOperations()}
   */
  @Test
  @DisplayName("Test getOperations(); then return second Operations size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection While.getOperations()"})
  void testGetOperations_thenReturnSecondOperationsSizeIsOne() {
    // Arrange
    While<Object, Object> resultWhile = new While<>();
    resultWhile.setConditional(null);
    AddNamedOperation op = new AddNamedOperation();
    resultWhile.setOperation(op);

    // Act
    Collection<Operation> actualOperations = resultWhile.getOperations();

    // Assert
    assertTrue(actualOperations instanceof List);
    assertEquals(2, actualOperations.size());
    Operation getResult = ((List<Operation>) actualOperations).get(1);
    assertTrue(getResult instanceof OperationChain);
    List<Operation> operations = ((OperationChain<Object>) getResult).getOperations();
    assertEquals(1, operations.size());
    assertSame(op, operations.get(0));
  }

  /**
   * Test {@link While#updateOperations(Collection)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link While#updateOperations(Collection)}
   */
  @Test
  @DisplayName("Test updateOperations(Collection); given 'null'; when LinkedHashSet() add 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void While.updateOperations(Collection)"})
  void testUpdateOperations_givenNull_whenLinkedHashSetAddNull() {
    // Arrange
    While<Object, Object> resultWhile = new While<>();
    resultWhile.setConditional(null);

    LinkedHashSet<Operation> operations = new LinkedHashSet<>();
    operations.add(null);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> resultWhile.updateOperations(operations));
  }

  /**
   * Test {@link While#updateOperations(Collection)}.
   *
   * <ul>
   *   <li>Given {@link While} (default constructor) Conditional is {@code null}.
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link While#updateOperations(Collection)}
   */
  @Test
  @DisplayName(
      "Test updateOperations(Collection); given While (default constructor) Conditional is 'null'; when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void While.updateOperations(Collection)"})
  void testUpdateOperations_givenWhileConditionalIsNull_whenNull() {
    // Arrange
    While<Object, Object> resultWhile = new While<>();
    resultWhile.setConditional(null);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> resultWhile.updateOperations(null));
  }

  /**
   * Test {@link While#updateOperations(Collection)}.
   *
   * <ul>
   *   <li>Given {@link While} (default constructor).
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link While#updateOperations(Collection)}
   */
  @Test
  @DisplayName(
      "Test updateOperations(Collection); given While (default constructor); when ArrayList(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void While.updateOperations(Collection)"})
  void testUpdateOperations_givenWhile_whenArrayList_thenThrowIllegalArgumentException() {
    // Arrange
    While<Object, Object> resultWhile = new While<>();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> resultWhile.updateOperations(new ArrayList<>()));
  }

  /**
   * Test {@link While#updateOperations(Collection)}.
   *
   * <ul>
   *   <li>Then {@link While} (default constructor) Operations first Operations size is one.
   * </ul>
   *
   * <p>Method under test: {@link While#updateOperations(Collection)}
   */
  @Test
  @DisplayName(
      "Test updateOperations(Collection); then While (default constructor) Operations first Operations size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void While.updateOperations(Collection)"})
  void testUpdateOperations_thenWhileOperationsFirstOperationsSizeIsOne() {
    // Arrange
    While<Object, Object> resultWhile = new While<>();

    ArrayList<Operation> operations = new ArrayList<>();
    OperationImpl operationImpl = new OperationImpl();
    operations.add(operationImpl);
    operations.add(new AddNamedOperation());

    // Act
    resultWhile.updateOperations(operations);

    // Assert
    Collection<Operation> operations2 = resultWhile.getOperations();
    assertEquals(2, operations2.size());
    assertTrue(operations2 instanceof List);
    Operation getResult = ((List<Operation>) operations2).get(0);
    assertTrue(getResult instanceof OperationChain);
    assertTrue(((List<Operation>) operations2).get(1) instanceof OperationChain);
    List<Operation> operations3 = ((OperationChain<Object>) getResult).getOperations();
    assertEquals(1, operations3.size());
    assertSame(operationImpl, operations3.get(0));
    assertSame(operationImpl, resultWhile.getConditional().getTransform());
  }

  /**
   * Test {@link While#validate()}.
   *
   * <ul>
   *   <li>Given {@link While} (default constructor) Conditional is {@link
   *       Conditional#Conditional()}.
   *   <li>Then return ErrorString is a string.
   * </ul>
   *
   * <p>Method under test: {@link While#validate()}
   */
  @Test
  @DisplayName(
      "Test validate(); given While (default constructor) Conditional is Conditional(); then return ErrorString is a string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationResult While.validate()"})
  void testValidate_givenWhileConditionalIsConditional_thenReturnErrorStringIsAString() {
    // Arrange
    While<Object, Object> resultWhile = new While<>();
    resultWhile.setCondition(true);
    resultWhile.setConditional(new Conditional());

    // Act
    ValidationResult actualValidateResult = resultWhile.validate();

    // Assert
    assertEquals(
        "Validation errors: \n"
            + "Both a condition and a conditional have been provided - only one should be configured.",
        actualValidateResult.getErrorString());
    Set<String> errors = actualValidateResult.getErrors();
    assertEquals(1, errors.size());
    assertFalse(actualValidateResult.isValid());
    assertTrue(
        errors.contains(
            "Both a condition and a conditional have been provided - only one should be configured."));
  }

  /**
   * Test {@link While#validate()}.
   *
   * <ul>
   *   <li>Given {@link While} (default constructor) Conditional is {@code null}.
   *   <li>Then return ErrorString is {@code Validation errors:}.
   * </ul>
   *
   * <p>Method under test: {@link While#validate()}
   */
  @Test
  @DisplayName(
      "Test validate(); given While (default constructor) Conditional is 'null'; then return ErrorString is 'Validation errors:'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationResult While.validate()"})
  void testValidate_givenWhileConditionalIsNull_thenReturnErrorStringIsValidationErrors() {
    // Arrange
    While<Object, Object> resultWhile = new While<>();
    resultWhile.setCondition(true);
    resultWhile.setConditional(null);

    // Act
    ValidationResult actualValidateResult = resultWhile.validate();

    // Assert
    assertEquals("Validation errors: \n", actualValidateResult.getErrorString());
    assertTrue(actualValidateResult.getErrors().isEmpty());
    assertTrue(actualValidateResult.isValid());
  }

  /**
   * Test {@link While#validate()}.
   *
   * <ul>
   *   <li>Given {@link While} (default constructor).
   *   <li>Then return ErrorString is {@code Validation errors:}.
   * </ul>
   *
   * <p>Method under test: {@link While#validate()}
   */
  @Test
  @DisplayName(
      "Test validate(); given While (default constructor); then return ErrorString is 'Validation errors:'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationResult While.validate()"})
  void testValidate_givenWhile_thenReturnErrorStringIsValidationErrors() {
    // Arrange
    While<Object, Object> resultWhile = new While<>();

    // Act
    ValidationResult actualValidateResult = resultWhile.validate();

    // Assert
    assertEquals("Validation errors: \n", actualValidateResult.getErrorString());
    assertTrue(actualValidateResult.getErrors().isEmpty());
    assertTrue(actualValidateResult.isValid());
  }

  /**
   * Test {@link While#equals(Object)}, and {@link While#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link While#equals(Object)}
   *   <li>{@link While#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean While.equals(Object)", "int While.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    While<Object, Object> resultWhile = new While<>();
    While<Object, Object> resultWhile2 = new While<>();

    // Act and Assert
    assertEquals(resultWhile, resultWhile2);
    assertEquals(resultWhile.hashCode(), resultWhile2.hashCode());
  }

  /**
   * Test {@link While#equals(Object)}, and {@link While#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link While#equals(Object)}
   *   <li>{@link While#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean While.equals(Object)", "int While.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    While<Object, Object> resultWhile = new While<>();

    // Act and Assert
    assertEquals(resultWhile, resultWhile);
    int expectedHashCodeResult = resultWhile.hashCode();
    assertEquals(expectedHashCodeResult, resultWhile.hashCode());
  }

  /**
   * Test {@link While#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link While#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean While.equals(Object)", "int While.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    While<Object, Object> resultWhile = new While<>();
    resultWhile.setOptions(new HashMap<>());

    // Act and Assert
    assertNotEquals(resultWhile, new While<>());
  }

  /**
   * Test {@link While#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link While#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean While.equals(Object)", "int While.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    While<Object, Object> resultWhile = new While<>();

    // Act and Assert
    assertNotEquals(resultWhile, null);
  }

  /**
   * Test {@link While#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link While#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean While.equals(Object)", "int While.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    While<Object, Object> resultWhile = new While<>();

    // Act and Assert
    assertNotEquals(resultWhile, "Different type to While");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link While}
   *   <li>{@link While#setCondition(Boolean)}
   *   <li>{@link While#setConditional(Conditional)}
   *   <li>{@link While#setMaxRepeats(int)}
   *   <li>{@link While#setOperation(Operation)}
   *   <li>{@link While#setOptions(Map)}
   *   <li>{@link While#toString()}
   *   <li>{@link While#getConditional()}
   *   <li>{@link While#getMaxRepeats()}
   *   <li>{@link While#getOperation()}
   *   <li>{@link While#getOptions()}
   *   <li>{@link While#isCondition()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void While.<init>()",
    "Conditional While.getConditional()",
    "int While.getMaxRepeats()",
    "Operation While.getOperation()",
    "Map While.getOptions()",
    "Boolean While.isCondition()",
    "void While.setCondition(Boolean)",
    "void While.setConditional(Conditional)",
    "void While.setMaxRepeats(int)",
    "void While.setOperation(Operation)",
    "void While.setOptions(Map)",
    "String While.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    While<Object, Object> actualResultWhile = new While<>();
    actualResultWhile.setCondition(true);
    Conditional conditional = new Conditional();
    actualResultWhile.setConditional(conditional);
    actualResultWhile.setMaxRepeats(3);
    AddNamedOperation op = new AddNamedOperation();
    actualResultWhile.setOperation(op);
    HashMap<String, String> options = new HashMap<>();
    actualResultWhile.setOptions(options);
    actualResultWhile.toString();
    Conditional actualConditional = actualResultWhile.getConditional();
    int actualMaxRepeats = actualResultWhile.getMaxRepeats();
    Operation actualOperation = actualResultWhile.getOperation();
    Map<String, String> actualOptions = actualResultWhile.getOptions();
    Boolean actualIsConditionResult = actualResultWhile.isCondition();

    // Assert
    assertNull(actualResultWhile.getInput());
    assertEquals(3, actualMaxRepeats);
    assertTrue(actualOptions.isEmpty());
    assertTrue(actualIsConditionResult);
    assertSame(options, actualOptions);
    assertSame(op, actualOperation);
    assertSame(conditional, actualConditional);
  }
}
