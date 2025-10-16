package uk.gov.gchq.gaffer.federatedstore.operation;

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
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import org.apache.commons.lang3.exception.CloneFailedException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.core.exception.GafferRuntimeException;
import uk.gov.gchq.gaffer.federatedstore.operation.FederatedOperation.Builder;
import uk.gov.gchq.gaffer.federatedstore.operation.FederatedOperation.BuilderParent;
import uk.gov.gchq.gaffer.named.operation.NamedOperation;
import uk.gov.gchq.gaffer.operation.Operation;
import uk.gov.gchq.gaffer.operation.OperationChain;
import uk.gov.gchq.gaffer.operation.OperationChainDAO;
import uk.gov.gchq.gaffer.operation.impl.add.AddElements;
import uk.gov.gchq.gaffer.operation.impl.io.GenericInputImpl;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl;

class FederatedOperationDiffblueTest {
  /**
   * Test Builder {@link Builder#op(Operation)} with {@code Operation}.
   *
   * <ul>
   *   <li>Then _getOp PayloadOperation return {@link ChangeGraphAccess}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#op(Operation)}
   */
  @Test
  @DisplayName(
      "Test Builder op(Operation) with 'Operation'; then _getOp PayloadOperation return ChangeGraphAccess")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BuilderParent Builder.op(Operation)"})
  void testBuilderOpWithOperation_then_getOpPayloadOperationReturnChangeGraphAccess() {
    // Arrange
    Builder builder = new Builder();
    ChangeGraphAccess op = new ChangeGraphAccess();

    // Act
    BuilderParent<Object, Object> actualOpResult = builder.op(op);

    // Assert
    FederatedOperation<Object, Object> _getOpResult = actualOpResult._getOp();
    assertTrue(_getOpResult.getPayloadOperation() instanceof ChangeGraphAccess);
    Operation unClonedPayload = _getOpResult.getUnClonedPayload();
    assertTrue(unClonedPayload instanceof ChangeGraphAccess);
    Class<ChangeGraphAccess> expectedPayloadClass = ChangeGraphAccess.class;
    assertEquals(expectedPayloadClass, _getOpResult.getPayloadClass());
    assertSame(op, unClonedPayload);
    FederatedOperation<Object, Object> actualFederatedOperation = actualOpResult.build();
    assertSame(_getOpResult, actualFederatedOperation);
  }

  /**
   * Test Builder {@link Builder#op(Operation)} with {@code Operation}.
   *
   * <ul>
   *   <li>Then _getOp UnClonedPayload return {@link FederatedOperation}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#op(Operation)}
   */
  @Test
  @DisplayName(
      "Test Builder op(Operation) with 'Operation'; then _getOp UnClonedPayload return FederatedOperation")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BuilderParent Builder.op(Operation)"})
  void testBuilderOpWithOperation_then_getOpUnClonedPayloadReturnFederatedOperation() {
    // Arrange
    Builder builder = new Builder();
    FederatedOperation<Object, Object> op = new FederatedOperation<>();

    // Act
    BuilderParent<Object, Object> actualOpResult = builder.op(op);

    // Assert
    FederatedOperation<Object, Object> _getOpResult = actualOpResult._getOp();
    Operation unClonedPayload = _getOpResult.getUnClonedPayload();
    assertTrue(unClonedPayload instanceof FederatedOperation);
    Class<FederatedOperation> expectedPayloadClass = FederatedOperation.class;
    assertEquals(expectedPayloadClass, _getOpResult.getPayloadClass());
    assertSame(op, unClonedPayload);
    FederatedOperation<Object, Object> actualFederatedOperation = actualOpResult.build();
    assertSame(_getOpResult, actualFederatedOperation);
  }

  /**
   * Test Builder {@link Builder#op(Operation)} with {@code Operation}.
   *
   * <ul>
   *   <li>When {@link AddGraph} (default constructor).
   *   <li>Then _getOp PayloadOperation return {@link AddGraph}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#op(Operation)}
   */
  @Test
  @DisplayName(
      "Test Builder op(Operation) with 'Operation'; when AddGraph (default constructor); then _getOp PayloadOperation return AddGraph")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BuilderParent Builder.op(Operation)"})
  void testBuilderOpWithOperation_whenAddGraph_then_getOpPayloadOperationReturnAddGraph() {
    // Arrange
    Builder builder = new Builder();
    AddGraph op = new AddGraph();

    // Act
    BuilderParent<Object, Object> actualOpResult = builder.op(op);

    // Assert
    FederatedOperation<Object, Object> _getOpResult = actualOpResult._getOp();
    assertTrue(_getOpResult.getPayloadOperation() instanceof AddGraph);
    Operation unClonedPayload = _getOpResult.getUnClonedPayload();
    assertTrue(unClonedPayload instanceof AddGraph);
    Class<AddGraph> expectedPayloadClass = AddGraph.class;
    assertEquals(expectedPayloadClass, _getOpResult.getPayloadClass());
    assertSame(op, unClonedPayload);
    FederatedOperation<Object, Object> actualFederatedOperation = actualOpResult.build();
    assertSame(_getOpResult, actualFederatedOperation);
  }

  /**
   * Test Builder {@link Builder#op(Operation)} with {@code Operation}.
   *
   * <ul>
   *   <li>When {@link GenericInputImpl#GenericInputImpl()}.
   *   <li>Then _getOp Operations return {@link List}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#op(Operation)}
   */
  @Test
  @DisplayName(
      "Test Builder op(Operation) with 'Operation'; when GenericInputImpl(); then _getOp Operations return List")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BuilderParent Builder.op(Operation)"})
  void testBuilderOpWithOperation_whenGenericInputImpl_then_getOpOperationsReturnList() {
    // Arrange
    Builder builder = new Builder();
    GenericInputImpl op = new GenericInputImpl();

    // Act
    BuilderParent<Object, Object> actualOpResult = builder.op(op);

    // Assert
    FederatedOperation<Object, Object> _getOpResult = actualOpResult._getOp();
    Collection<Operation> operations = _getOpResult.getOperations();
    assertTrue(operations instanceof List);
    assertTrue(_getOpResult.getOutputTypeReference() instanceof TypeReferenceImpl.Object);
    assertNull(_getOpResult.getPayloadOperation());
    assertTrue(operations.isEmpty());
    Class<GenericInputImpl> expectedPayloadClass = GenericInputImpl.class;
    assertEquals(expectedPayloadClass, _getOpResult.getPayloadClass());
    assertSame(op, _getOpResult.getUnClonedPayload());
    FederatedOperation<Object, Object> actualFederatedOperation = actualOpResult.build();
    assertSame(_getOpResult, actualFederatedOperation);
  }

  /**
   * Test {@link FederatedOperation#graphIds(List)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedOperation#graphIds(List)}
   */
  @Test
  @DisplayName("Test graphIds(List); given '42'; when ArrayList() add '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FederatedOperation FederatedOperation.graphIds(List)"})
  void testGraphIds_given42_whenArrayListAdd42() {
    // Arrange
    FederatedOperation<Object, Object> federatedOperation = new FederatedOperation<>();

    ArrayList<String> graphIds = new ArrayList<>();
    graphIds.add("42");
    graphIds.add("foo");

    // Act
    FederatedOperation<Object, Object> actualGraphIdsResult = federatedOperation.graphIds(graphIds);

    // Assert
    assertTrue(actualGraphIdsResult.getOutputTypeReference() instanceof TypeReferenceImpl.Object);
    assertEquals(graphIds, federatedOperation.getGraphIds());
    assertEquals(graphIds, actualGraphIdsResult.getGraphIds());
  }

  /**
   * Test {@link FederatedOperation#graphIds(List)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>Then {@link FederatedOperation} (default constructor) GraphIds is {@link
   *       ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedOperation#graphIds(List)}
   */
  @Test
  @DisplayName(
      "Test graphIds(List); given 'foo'; then FederatedOperation (default constructor) GraphIds is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FederatedOperation FederatedOperation.graphIds(List)"})
  void testGraphIds_givenFoo_thenFederatedOperationGraphIdsIsArrayList() {
    // Arrange
    FederatedOperation<Object, Object> federatedOperation = new FederatedOperation<>();

    ArrayList<String> graphIds = new ArrayList<>();
    graphIds.add("foo");

    // Act
    FederatedOperation<Object, Object> actualGraphIdsResult = federatedOperation.graphIds(graphIds);

    // Assert
    assertTrue(actualGraphIdsResult.getOutputTypeReference() instanceof TypeReferenceImpl.Object);
    assertEquals(graphIds, federatedOperation.getGraphIds());
    assertEquals(graphIds, actualGraphIdsResult.getGraphIds());
  }

  /**
   * Test {@link FederatedOperation#graphIds(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then {@link FederatedOperation} (default constructor) GraphIds Empty.
   * </ul>
   *
   * <p>Method under test: {@link FederatedOperation#graphIds(List)}
   */
  @Test
  @DisplayName(
      "Test graphIds(List); when ArrayList(); then FederatedOperation (default constructor) GraphIds Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FederatedOperation FederatedOperation.graphIds(List)"})
  void testGraphIds_whenArrayList_thenFederatedOperationGraphIdsEmpty() {
    // Arrange
    FederatedOperation<Object, Object> federatedOperation = new FederatedOperation<>();
    ArrayList<String> graphIds = new ArrayList<>();

    // Act
    FederatedOperation<Object, Object> actualGraphIdsResult = federatedOperation.graphIds(graphIds);

    // Assert
    assertTrue(actualGraphIdsResult.getOutputTypeReference() instanceof TypeReferenceImpl.Object);
    assertTrue(federatedOperation.getGraphIds().isEmpty());
    assertTrue(actualGraphIdsResult.getGraphIds().isEmpty());
    assertEquals(graphIds, actualGraphIdsResult.getOperations());
  }

  /**
   * Test {@link FederatedOperation#graphIds(List)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link FederatedOperation} (default constructor) GraphIds is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedOperation#graphIds(List)}
   */
  @Test
  @DisplayName(
      "Test graphIds(List); when 'null'; then FederatedOperation (default constructor) GraphIds is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FederatedOperation FederatedOperation.graphIds(List)"})
  void testGraphIds_whenNull_thenFederatedOperationGraphIdsIsNull() {
    // Arrange
    FederatedOperation<Object, Object> federatedOperation = new FederatedOperation<>();

    // Act
    FederatedOperation<Object, Object> actualGraphIdsResult = federatedOperation.graphIds(null);

    // Assert
    assertTrue(actualGraphIdsResult.getOutputTypeReference() instanceof TypeReferenceImpl.Object);
    assertNull(federatedOperation.getGraphIds());
    assertNull(actualGraphIdsResult.getGraphIds());
  }

  /**
   * Test {@link FederatedOperation#graphIdsCSV(String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then {@link FederatedOperation} (default constructor) GraphIds Empty.
   * </ul>
   *
   * <p>Method under test: {@link FederatedOperation#graphIdsCSV(String)}
   */
  @Test
  @DisplayName(
      "Test graphIdsCSV(String); when empty string; then FederatedOperation (default constructor) GraphIds Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FederatedOperation FederatedOperation.graphIdsCSV(String)"})
  void testGraphIdsCSV_whenEmptyString_thenFederatedOperationGraphIdsEmpty() {
    // Arrange
    FederatedOperation<Object, Object> federatedOperation = new FederatedOperation<>();

    // Act
    FederatedOperation<Object, Object> actualGraphIdsCSVResult = federatedOperation.graphIdsCSV("");

    // Assert
    assertTrue(
        actualGraphIdsCSVResult.getOutputTypeReference() instanceof TypeReferenceImpl.Object);
    assertTrue(federatedOperation.getGraphIds().isEmpty());
    List<String> graphIds = actualGraphIdsCSVResult.getGraphIds();
    assertTrue(graphIds.isEmpty());
    assertEquals(graphIds, actualGraphIdsCSVResult.getOperations());
  }

  /**
   * Test {@link FederatedOperation#graphIdsCSV(String)}.
   *
   * <ul>
   *   <li>When {@code Graph Ids}.
   *   <li>Then {@link FederatedOperation} (default constructor) GraphIds size is one.
   * </ul>
   *
   * <p>Method under test: {@link FederatedOperation#graphIdsCSV(String)}
   */
  @Test
  @DisplayName(
      "Test graphIdsCSV(String); when 'Graph Ids'; then FederatedOperation (default constructor) GraphIds size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FederatedOperation FederatedOperation.graphIdsCSV(String)"})
  void testGraphIdsCSV_whenGraphIds_thenFederatedOperationGraphIdsSizeIsOne() {
    // Arrange
    FederatedOperation<Object, Object> federatedOperation = new FederatedOperation<>();

    // Act
    FederatedOperation<Object, Object> actualGraphIdsCSVResult =
        federatedOperation.graphIdsCSV("Graph Ids");

    // Assert
    assertTrue(
        actualGraphIdsCSVResult.getOutputTypeReference() instanceof TypeReferenceImpl.Object);
    List<String> graphIds = federatedOperation.getGraphIds();
    assertEquals(1, graphIds.size());
    assertEquals("Graph Ids", graphIds.get(0));
    List<String> graphIds2 = actualGraphIdsCSVResult.getGraphIds();
    assertEquals(1, graphIds2.size());
    assertEquals("Graph Ids", graphIds2.get(0));
  }

  /**
   * Test {@link FederatedOperation#graphIdsCSV(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link FederatedOperation} (default constructor) GraphIds is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedOperation#graphIdsCSV(String)}
   */
  @Test
  @DisplayName(
      "Test graphIdsCSV(String); when 'null'; then FederatedOperation (default constructor) GraphIds is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FederatedOperation FederatedOperation.graphIdsCSV(String)"})
  void testGraphIdsCSV_whenNull_thenFederatedOperationGraphIdsIsNull() {
    // Arrange
    FederatedOperation<Object, Object> federatedOperation = new FederatedOperation<>();

    // Act
    FederatedOperation<Object, Object> actualGraphIdsCSVResult =
        federatedOperation.graphIdsCSV(null);

    // Assert
    assertTrue(
        actualGraphIdsCSVResult.getOutputTypeReference() instanceof TypeReferenceImpl.Object);
    assertNull(federatedOperation.getGraphIds());
    assertNull(actualGraphIdsCSVResult.getGraphIds());
  }

  /**
   * Test {@link FederatedOperation#payloadOperation(Operation)}.
   *
   * <ul>
   *   <li>Then {@link FederatedOperation} (default constructor) PayloadOperation {@link
   *       AddElements}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedOperation#payloadOperation(Operation)}
   */
  @Test
  @DisplayName(
      "Test payloadOperation(Operation); then FederatedOperation (default constructor) PayloadOperation AddElements")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FederatedOperation FederatedOperation.payloadOperation(Operation)"})
  void testPayloadOperation_thenFederatedOperationPayloadOperationAddElements() {
    // Arrange
    FederatedOperation<Object, Object> federatedOperation = new FederatedOperation<>();
    AddElements op = new AddElements();

    // Act
    FederatedOperation<Object, Object> actualPayloadOperationResult =
        federatedOperation.payloadOperation(op);

    // Assert
    Operation payloadOperation = federatedOperation.getPayloadOperation();
    assertTrue(payloadOperation instanceof AddElements);
    assertTrue(actualPayloadOperationResult.getPayloadOperation() instanceof AddElements);
    Operation unClonedPayload = actualPayloadOperationResult.getUnClonedPayload();
    assertTrue(unClonedPayload instanceof AddElements);
    assertEquals(op, payloadOperation);
    Class<AddElements> expectedPayloadClass = AddElements.class;
    assertEquals(expectedPayloadClass, actualPayloadOperationResult.getPayloadClass());
    assertSame(op, federatedOperation.getUnClonedPayload());
    assertSame(op, unClonedPayload);
  }

  /**
   * Test {@link FederatedOperation#payloadOperation(Operation)}.
   *
   * <ul>
   *   <li>Then return Options size is one.
   * </ul>
   *
   * <p>Method under test: {@link FederatedOperation#payloadOperation(Operation)}
   */
  @Test
  @DisplayName("Test payloadOperation(Operation); then return Options size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FederatedOperation FederatedOperation.payloadOperation(Operation)"})
  void testPayloadOperation_thenReturnOptionsSizeIsOne() {
    // Arrange
    FederatedOperation<Object, Object> federatedOperation = new FederatedOperation<>();
    federatedOperation.addOption("Name", "42");
    GenericInputImpl op = new GenericInputImpl();

    // Act
    FederatedOperation<Object, Object> actualPayloadOperationResult =
        federatedOperation.payloadOperation(op);

    // Assert
    Collection<Operation> operations = actualPayloadOperationResult.getOperations();
    assertTrue(operations instanceof List);
    assertTrue(
        actualPayloadOperationResult.getOutputTypeReference() instanceof TypeReferenceImpl.Object);
    Map<String, String> options = actualPayloadOperationResult.getOptions();
    assertEquals(1, options.size());
    assertEquals("42", options.get("Name"));
    assertNull(actualPayloadOperationResult.getPayloadOperation());
    assertTrue(operations.isEmpty());
    Class<GenericInputImpl> expectedPayloadClass = GenericInputImpl.class;
    assertEquals(expectedPayloadClass, actualPayloadOperationResult.getPayloadClass());
    assertSame(op, federatedOperation.getUnClonedPayload());
    assertSame(op, actualPayloadOperationResult.getUnClonedPayload());
  }

  /**
   * Test {@link FederatedOperation#payloadOperation(Operation)}.
   *
   * <ul>
   *   <li>Then return PayloadClass is {@link OperationChain}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedOperation#payloadOperation(Operation)}
   */
  @Test
  @DisplayName("Test payloadOperation(Operation); then return PayloadClass is OperationChain")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FederatedOperation FederatedOperation.payloadOperation(Operation)"})
  void testPayloadOperation_thenReturnPayloadClassIsOperationChain() {
    // Arrange
    FederatedOperation<Object, Object> federatedOperation = new FederatedOperation<>();
    OperationChain<Object> op = OperationChain.wrap(new FederatedOperation<>());

    // Act
    FederatedOperation<Object, Object> actualPayloadOperationResult =
        federatedOperation.payloadOperation(op);

    // Assert
    assertTrue(
        actualPayloadOperationResult.getOutputTypeReference() instanceof TypeReferenceImpl.Object);
    Class<OperationChain> expectedPayloadClass = OperationChain.class;
    assertEquals(expectedPayloadClass, actualPayloadOperationResult.getPayloadClass());
    assertSame(op, federatedOperation.getUnClonedPayload());
    assertSame(op, actualPayloadOperationResult.getUnClonedPayload());
  }

  /**
   * Test {@link FederatedOperation#payloadOperation(Operation)}.
   *
   * <ul>
   *   <li>Then UnClonedPayload return {@link FederatedOperation}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedOperation#payloadOperation(Operation)}
   */
  @Test
  @DisplayName("Test payloadOperation(Operation); then UnClonedPayload return FederatedOperation")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FederatedOperation FederatedOperation.payloadOperation(Operation)"})
  void testPayloadOperation_thenUnClonedPayloadReturnFederatedOperation() {
    // Arrange
    FederatedOperation<Object, Object> federatedOperation = new FederatedOperation<>();
    FederatedOperation<Object, Object> op = new FederatedOperation<>();

    // Act
    FederatedOperation<Object, Object> actualPayloadOperationResult =
        federatedOperation.payloadOperation(op);

    // Assert
    Operation unClonedPayload = actualPayloadOperationResult.getUnClonedPayload();
    assertTrue(unClonedPayload instanceof FederatedOperation);
    assertNull(op.getUnClonedPayload());
    Class<FederatedOperation> expectedPayloadClass = FederatedOperation.class;
    assertEquals(expectedPayloadClass, actualPayloadOperationResult.getPayloadClass());
    assertSame(op, unClonedPayload);
  }

  /**
   * Test {@link FederatedOperation#payloadOperation(Operation)}.
   *
   * <ul>
   *   <li>When {@link AddGraph} (default constructor).
   *   <li>Then {@link FederatedOperation} (default constructor) PayloadOperation {@link AddGraph}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedOperation#payloadOperation(Operation)}
   */
  @Test
  @DisplayName(
      "Test payloadOperation(Operation); when AddGraph (default constructor); then FederatedOperation (default constructor) PayloadOperation AddGraph")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FederatedOperation FederatedOperation.payloadOperation(Operation)"})
  void testPayloadOperation_whenAddGraph_thenFederatedOperationPayloadOperationAddGraph() {
    // Arrange
    FederatedOperation<Object, Object> federatedOperation = new FederatedOperation<>();
    AddGraph op = new AddGraph();

    // Act
    FederatedOperation<Object, Object> actualPayloadOperationResult =
        federatedOperation.payloadOperation(op);

    // Assert
    assertTrue(federatedOperation.getPayloadOperation() instanceof AddGraph);
    assertTrue(actualPayloadOperationResult.getPayloadOperation() instanceof AddGraph);
    Operation unClonedPayload = actualPayloadOperationResult.getUnClonedPayload();
    assertTrue(unClonedPayload instanceof AddGraph);
    Class<AddGraph> expectedPayloadClass = AddGraph.class;
    assertEquals(expectedPayloadClass, actualPayloadOperationResult.getPayloadClass());
    assertSame(op, federatedOperation.getUnClonedPayload());
    assertSame(op, unClonedPayload);
  }

  /**
   * Test {@link FederatedOperation#payloadOperation(Operation)}.
   *
   * <ul>
   *   <li>When {@link GenericInputImpl#GenericInputImpl()}.
   *   <li>Then Operations return {@link List}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedOperation#payloadOperation(Operation)}
   */
  @Test
  @DisplayName(
      "Test payloadOperation(Operation); when GenericInputImpl(); then Operations return List")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FederatedOperation FederatedOperation.payloadOperation(Operation)"})
  void testPayloadOperation_whenGenericInputImpl_thenOperationsReturnList() {
    // Arrange
    FederatedOperation<Object, Object> federatedOperation = new FederatedOperation<>();
    GenericInputImpl op = new GenericInputImpl();

    // Act
    FederatedOperation<Object, Object> actualPayloadOperationResult =
        federatedOperation.payloadOperation(op);

    // Assert
    Collection<Operation> operations = actualPayloadOperationResult.getOperations();
    assertTrue(operations instanceof List);
    assertTrue(
        actualPayloadOperationResult.getOutputTypeReference() instanceof TypeReferenceImpl.Object);
    assertNull(actualPayloadOperationResult.getPayloadOperation());
    assertTrue(operations.isEmpty());
    Class<GenericInputImpl> expectedPayloadClass = GenericInputImpl.class;
    assertEquals(expectedPayloadClass, actualPayloadOperationResult.getPayloadClass());
    assertSame(op, federatedOperation.getUnClonedPayload());
    assertSame(op, actualPayloadOperationResult.getUnClonedPayload());
  }

  /**
   * Test {@link FederatedOperation#getOperations()}.
   *
   * <p>Method under test: {@link FederatedOperation#getOperations()}
   */
  @Test
  @DisplayName("Test getOperations()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection FederatedOperation.getOperations()"})
  void testGetOperations() {
    // Arrange
    FederatedOperation<Object, Object> federatedOperation = new FederatedOperation<>();
    federatedOperation.payloadOperation(new OperationChainDAO<>(new AddGraph()));

    // Act
    Collection<Operation> actualOperations = federatedOperation.getOperations();

    // Assert
    assertTrue(actualOperations instanceof List);
    assertEquals(1, actualOperations.size());
    Operation getResult = ((List<Operation>) actualOperations).get(0);
    assertTrue(getResult instanceof AddGraph);
    assertNull(((AddGraph) getResult).getGraphId());
    assertNull(((AddGraph) getResult).getParentPropertiesId());
    assertNull(((AddGraph) getResult).getParentSchemaIds());
    assertNull(getResult.getOptions());
    assertNull(((AddGraph) getResult).getProperties());
    assertNull(((AddGraph) getResult).getGraphAuths());
    assertNull(((AddGraph) getResult).getReadAccessPredicate());
    assertNull(((AddGraph) getResult).getWriteAccessPredicate());
    assertNull(((AddGraph) getResult).getStoreProperties());
    assertNull(((AddGraph) getResult).getSchema());
    assertFalse(((AddGraph) getResult).getIsPublic());
    assertFalse(((AddGraph) getResult).isUserRequestingAdminUsage());
  }

  /**
   * Test {@link FederatedOperation#getOperations()}.
   *
   * <ul>
   *   <li>Given {@link AddGraph} (default constructor) Options is {@link HashMap#HashMap()}.
   *   <li>Then return first Options Empty.
   * </ul>
   *
   * <p>Method under test: {@link FederatedOperation#getOperations()}
   */
  @Test
  @DisplayName(
      "Test getOperations(); given AddGraph (default constructor) Options is HashMap(); then return first Options Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection FederatedOperation.getOperations()"})
  void testGetOperations_givenAddGraphOptionsIsHashMap_thenReturnFirstOptionsEmpty() {
    // Arrange
    AddGraph op = new AddGraph();
    op.setOptions(new HashMap<>());

    FederatedOperation<Object, Object> federatedOperation = new FederatedOperation<>();
    federatedOperation.payloadOperation(op);

    // Act
    Collection<Operation> actualOperations = federatedOperation.getOperations();

    // Assert
    assertTrue(actualOperations instanceof List);
    assertEquals(1, actualOperations.size());
    Operation getResult = ((List<Operation>) actualOperations).get(0);
    assertTrue(getResult instanceof AddGraph);
    assertNull(((AddGraph) getResult).getGraphId());
    assertNull(((AddGraph) getResult).getParentPropertiesId());
    assertNull(((AddGraph) getResult).getParentSchemaIds());
    assertNull(((AddGraph) getResult).getProperties());
    assertNull(((AddGraph) getResult).getGraphAuths());
    assertNull(((AddGraph) getResult).getReadAccessPredicate());
    assertNull(((AddGraph) getResult).getWriteAccessPredicate());
    assertNull(((AddGraph) getResult).getStoreProperties());
    assertNull(((AddGraph) getResult).getSchema());
    assertFalse(((AddGraph) getResult).getIsPublic());
    assertFalse(((AddGraph) getResult).isUserRequestingAdminUsage());
    assertTrue(getResult.getOptions().isEmpty());
  }

  /**
   * Test {@link FederatedOperation#getOperations()}.
   *
   * <ul>
   *   <li>Given {@link FederatedOperation} (default constructor) payloadOperation {@link
   *       OperationChain#OperationChain()}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedOperation#getOperations()}
   */
  @Test
  @DisplayName(
      "Test getOperations(); given FederatedOperation (default constructor) payloadOperation OperationChain()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection FederatedOperation.getOperations()"})
  void testGetOperations_givenFederatedOperationPayloadOperationOperationChain() {
    // Arrange
    FederatedOperation<Object, Object> federatedOperation = new FederatedOperation<>();
    federatedOperation.payloadOperation(new OperationChain<>());

    // Act
    Collection<Operation> actualOperations = federatedOperation.getOperations();

    // Assert
    assertTrue(actualOperations instanceof List);
    assertTrue(actualOperations.isEmpty());
  }

  /**
   * Test {@link FederatedOperation#getOperations()}.
   *
   * <ul>
   *   <li>Given {@link FederatedOperation} (default constructor).
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link FederatedOperation#getOperations()}
   */
  @Test
  @DisplayName(
      "Test getOperations(); given FederatedOperation (default constructor); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection FederatedOperation.getOperations()"})
  void testGetOperations_givenFederatedOperation_thenReturnEmpty() {
    // Arrange
    FederatedOperation<Object, Object> federatedOperation = new FederatedOperation<>();

    // Act
    Collection<Operation> actualOperations = federatedOperation.getOperations();

    // Assert
    assertTrue(actualOperations instanceof List);
    assertTrue(actualOperations.isEmpty());
  }

  /**
   * Test {@link FederatedOperation#getOperations()}.
   *
   * <ul>
   *   <li>Then first PayloadOperation return {@link AddGraph}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedOperation#getOperations()}
   */
  @Test
  @DisplayName("Test getOperations(); then first PayloadOperation return AddGraph")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection FederatedOperation.getOperations()"})
  void testGetOperations_thenFirstPayloadOperationReturnAddGraph() {
    // Arrange
    FederatedOperation<Object, Object> operation = new FederatedOperation<>();
    AddGraph op = new AddGraph();
    operation.payloadOperation(op);
    OperationChain<Object> op2 = OperationChain.wrap(operation);

    FederatedOperation<Object, Object> federatedOperation = new FederatedOperation<>();
    federatedOperation.payloadOperation(op2);

    // Act
    Collection<Operation> actualOperations = federatedOperation.getOperations();

    // Assert
    assertTrue(actualOperations instanceof List);
    assertEquals(1, actualOperations.size());
    Operation getResult = ((List<Operation>) actualOperations).get(0);
    assertTrue(
        ((FederatedOperation<Object, Object>) getResult).getPayloadOperation() instanceof AddGraph);
    Operation unClonedPayload =
        ((FederatedOperation<Object, Object>) getResult).getUnClonedPayload();
    assertTrue(unClonedPayload instanceof AddGraph);
    assertTrue(getResult instanceof FederatedOperation);
    Class<AddGraph> expectedPayloadClass = AddGraph.class;
    assertEquals(
        expectedPayloadClass, ((FederatedOperation<Object, Object>) getResult).getPayloadClass());
    assertSame(op, unClonedPayload);
  }

  /**
   * Test {@link FederatedOperation#getOperations()}.
   *
   * <ul>
   *   <li>Then first PayloadOperation return {@link AddGraph}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedOperation#getOperations()}
   */
  @Test
  @DisplayName("Test getOperations(); then first PayloadOperation return AddGraph")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection FederatedOperation.getOperations()"})
  void testGetOperations_thenFirstPayloadOperationReturnAddGraph2() {
    // Arrange
    FederatedOperation<Object, Object> op = new FederatedOperation<>();
    AddGraph op2 = new AddGraph();
    op.payloadOperation(op2);

    FederatedOperation<Object, Object> federatedOperation = new FederatedOperation<>();
    federatedOperation.payloadOperation(op);

    // Act
    Collection<Operation> actualOperations = federatedOperation.getOperations();

    // Assert
    assertTrue(actualOperations instanceof List);
    assertEquals(1, actualOperations.size());
    Operation getResult = ((List<Operation>) actualOperations).get(0);
    assertTrue(
        ((FederatedOperation<Object, Object>) getResult).getPayloadOperation() instanceof AddGraph);
    Operation unClonedPayload =
        ((FederatedOperation<Object, Object>) getResult).getUnClonedPayload();
    assertTrue(unClonedPayload instanceof AddGraph);
    assertTrue(getResult instanceof FederatedOperation);
    Class<AddGraph> expectedPayloadClass = AddGraph.class;
    assertEquals(
        expectedPayloadClass, ((FederatedOperation<Object, Object>) getResult).getPayloadClass());
    assertSame(op2, unClonedPayload);
  }

  /**
   * Test {@link FederatedOperation#getOperations()}.
   *
   * <ul>
   *   <li>Then first return {@link OperationChain}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedOperation#getOperations()}
   */
  @Test
  @DisplayName("Test getOperations(); then first return OperationChain")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection FederatedOperation.getOperations()"})
  void testGetOperations_thenFirstReturnOperationChain() {
    // Arrange
    FederatedOperation<Object, Object> federatedOperation = new FederatedOperation<>();
    OperationChain<Object> operation = new OperationChain<>();
    federatedOperation.payloadOperation(new OperationChainDAO<>((Operation) operation));

    // Act
    Collection<Operation> actualOperations = federatedOperation.getOperations();

    // Assert
    assertTrue(actualOperations instanceof List);
    assertEquals(1, actualOperations.size());
    Operation getResult = ((List<Operation>) actualOperations).get(0);
    assertTrue(getResult instanceof OperationChain);
    assertEquals(operation, getResult);
  }

  /**
   * Test {@link FederatedOperation#getOperations()}.
   *
   * <ul>
   *   <li>Then return first GraphIds Empty.
   * </ul>
   *
   * <p>Method under test: {@link FederatedOperation#getOperations()}
   */
  @Test
  @DisplayName("Test getOperations(); then return first GraphIds Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection FederatedOperation.getOperations()"})
  void testGetOperations_thenReturnFirstGraphIdsEmpty() {
    // Arrange
    FederatedOperation<Object, Object> operation = new FederatedOperation<>();
    operation.graphIds(new ArrayList<>());
    OperationChain<Object> op = OperationChain.wrap(new FederatedOperation<>());
    operation.payloadOperation(op);
    OperationChain<Object> op2 = OperationChain.wrap(operation);

    FederatedOperation<Object, Object> federatedOperation = new FederatedOperation<>();
    federatedOperation.payloadOperation(op2);

    // Act
    Collection<Operation> actualOperations = federatedOperation.getOperations();

    // Assert
    assertTrue(actualOperations instanceof List);
    assertEquals(1, actualOperations.size());
    Operation getResult = ((List<Operation>) actualOperations).get(0);
    assertTrue(getResult instanceof FederatedOperation);
    assertTrue(((FederatedOperation<Object, Object>) getResult).getGraphIds().isEmpty());
    Class<OperationChain> expectedPayloadClass = OperationChain.class;
    assertEquals(
        expectedPayloadClass, ((FederatedOperation<Object, Object>) getResult).getPayloadClass());
    assertSame(op, ((FederatedOperation<Object, Object>) getResult).getUnClonedPayload());
  }

  /**
   * Test {@link FederatedOperation#getOperations()}.
   *
   * <ul>
   *   <li>Then return first Options is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedOperation#getOperations()}
   */
  @Test
  @DisplayName("Test getOperations(); then return first Options is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection FederatedOperation.getOperations()"})
  void testGetOperations_thenReturnFirstOptionsIsNull() {
    // Arrange
    FederatedOperation<Object, Object> federatedOperation = new FederatedOperation<>();
    federatedOperation.payloadOperation(new AddGraph());

    // Act
    Collection<Operation> actualOperations = federatedOperation.getOperations();

    // Assert
    assertTrue(actualOperations instanceof List);
    assertEquals(1, actualOperations.size());
    Operation getResult = ((List<Operation>) actualOperations).get(0);
    assertTrue(getResult instanceof AddGraph);
    assertNull(((AddGraph) getResult).getGraphId());
    assertNull(((AddGraph) getResult).getParentPropertiesId());
    assertNull(((AddGraph) getResult).getParentSchemaIds());
    assertNull(getResult.getOptions());
    assertNull(((AddGraph) getResult).getProperties());
    assertNull(((AddGraph) getResult).getGraphAuths());
    assertNull(((AddGraph) getResult).getReadAccessPredicate());
    assertNull(((AddGraph) getResult).getWriteAccessPredicate());
    assertNull(((AddGraph) getResult).getStoreProperties());
    assertNull(((AddGraph) getResult).getSchema());
    assertFalse(((AddGraph) getResult).getIsPublic());
    assertFalse(((AddGraph) getResult).isUserRequestingAdminUsage());
  }

  /**
   * Test {@link FederatedOperation#getOperations()}.
   *
   * <ul>
   *   <li>Then return first PayloadClass is {@link FederatedOperation}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedOperation#getOperations()}
   */
  @Test
  @DisplayName("Test getOperations(); then return first PayloadClass is FederatedOperation")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection FederatedOperation.getOperations()"})
  void testGetOperations_thenReturnFirstPayloadClassIsFederatedOperation() {
    // Arrange
    FederatedOperation<Object, Object> operation = new FederatedOperation<>();
    FederatedOperation<Object, Object> op = new FederatedOperation<>();
    operation.payloadOperation(op);
    OperationChain<Object> op2 = OperationChain.wrap(operation);

    FederatedOperation<Object, Object> federatedOperation = new FederatedOperation<>();
    federatedOperation.payloadOperation(op2);

    // Act
    Collection<Operation> actualOperations = federatedOperation.getOperations();

    // Assert
    assertTrue(actualOperations instanceof List);
    assertEquals(1, actualOperations.size());
    Operation getResult = ((List<Operation>) actualOperations).get(0);
    assertTrue(getResult instanceof FederatedOperation);
    Class<FederatedOperation> expectedPayloadClass = FederatedOperation.class;
    assertEquals(
        expectedPayloadClass, ((FederatedOperation<Object, Object>) getResult).getPayloadClass());
    assertSame(op, ((FederatedOperation<Object, Object>) getResult).getUnClonedPayload());
  }

  /**
   * Test {@link FederatedOperation#getOperations()}.
   *
   * <ul>
   *   <li>Then return first PayloadClass is {@link OperationChain}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedOperation#getOperations()}
   */
  @Test
  @DisplayName("Test getOperations(); then return first PayloadClass is OperationChain")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection FederatedOperation.getOperations()"})
  void testGetOperations_thenReturnFirstPayloadClassIsOperationChain() {
    // Arrange
    FederatedOperation<Object, Object> operation = new FederatedOperation<>();
    OperationChain<Object> op = OperationChain.wrap(new FederatedOperation<>());
    operation.payloadOperation(op);
    OperationChain<Object> op2 = OperationChain.wrap(operation);

    FederatedOperation<Object, Object> federatedOperation = new FederatedOperation<>();
    federatedOperation.payloadOperation(op2);

    // Act
    Collection<Operation> actualOperations = federatedOperation.getOperations();

    // Assert
    assertTrue(actualOperations instanceof List);
    assertEquals(1, actualOperations.size());
    Operation getResult = ((List<Operation>) actualOperations).get(0);
    assertTrue(getResult instanceof FederatedOperation);
    Class<OperationChain> expectedPayloadClass = OperationChain.class;
    assertEquals(
        expectedPayloadClass, ((FederatedOperation<Object, Object>) getResult).getPayloadClass());
    assertSame(op, ((FederatedOperation<Object, Object>) getResult).getUnClonedPayload());
  }

  /**
   * Test {@link FederatedOperation#setUserRequestingAdminUsage(boolean)}.
   *
   * <p>Method under test: {@link FederatedOperation#setUserRequestingAdminUsage(boolean)}
   */
  @Test
  @DisplayName("Test setUserRequestingAdminUsage(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FederatedOperation FederatedOperation.setUserRequestingAdminUsage(boolean)"})
  void testSetUserRequestingAdminUsage() {
    // Arrange
    FederatedOperation<Object, Object> federatedOperation = new FederatedOperation<>();

    // Act
    FederatedOperation<Object, Object> actualSetUserRequestingAdminUsageResult =
        federatedOperation.setUserRequestingAdminUsage(true);

    // Assert
    assertTrue(federatedOperation.isUserRequestingAdminUsage());
    assertSame(federatedOperation, actualSetUserRequestingAdminUsageResult);
  }

  /**
   * Test {@link FederatedOperation#options(Map)}.
   *
   * <p>Method under test: {@link FederatedOperation#options(Map)}
   */
  @Test
  @DisplayName("Test options(Map)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FederatedOperation FederatedOperation.options(Map)"})
  void testOptions() {
    // Arrange
    FederatedOperation<Object, Object> federatedOperation = new FederatedOperation<>();
    HashMap<String, String> options = new HashMap<>();

    // Act
    FederatedOperation<Object, Object> actualOptionsResult = federatedOperation.options(options);

    // Assert
    assertSame(options, federatedOperation.getOptions());
    assertSame(federatedOperation, actualOptionsResult);
  }

  /**
   * Test {@link FederatedOperation#getGraphIds()}.
   *
   * <ul>
   *   <li>Given {@link FederatedOperation} (default constructor) graphIds {@link
   *       ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link FederatedOperation#getGraphIds()}
   */
  @Test
  @DisplayName(
      "Test getGraphIds(); given FederatedOperation (default constructor) graphIds ArrayList(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List FederatedOperation.getGraphIds()"})
  void testGetGraphIds_givenFederatedOperationGraphIdsArrayList_thenReturnEmpty() {
    // Arrange
    FederatedOperation<Object, Object> federatedOperation = new FederatedOperation<>();
    federatedOperation.graphIds(new ArrayList<>());

    // Act and Assert
    assertTrue(federatedOperation.getGraphIds().isEmpty());
  }

  /**
   * Test {@link FederatedOperation#getGraphIds()}.
   *
   * <ul>
   *   <li>Given {@link FederatedOperation} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedOperation#getGraphIds()}
   */
  @Test
  @DisplayName(
      "Test getGraphIds(); given FederatedOperation (default constructor); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List FederatedOperation.getGraphIds()"})
  void testGetGraphIds_givenFederatedOperation_thenReturnNull() {
    // Arrange
    FederatedOperation<Object, Object> federatedOperation = new FederatedOperation<>();

    // Act and Assert
    assertNull(federatedOperation.getGraphIds());
  }

  /**
   * Test {@link FederatedOperation#getPayloadOperation()}.
   *
   * <ul>
   *   <li>Given {@link FederatedOperation} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedOperation#getPayloadOperation()}
   */
  @Test
  @DisplayName(
      "Test getPayloadOperation(); given FederatedOperation (default constructor); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Operation FederatedOperation.getPayloadOperation()"})
  void testGetPayloadOperation_givenFederatedOperation_thenReturnNull() {
    // Arrange
    FederatedOperation<Object, Object> federatedOperation = new FederatedOperation<>();

    // Act and Assert
    assertNull(federatedOperation.getPayloadOperation());
  }

  /**
   * Test {@link FederatedOperation#getPayloadOperation()}.
   *
   * <ul>
   *   <li>Then Operations first return {@link AddGraph}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedOperation#getPayloadOperation()}
   */
  @Test
  @DisplayName("Test getPayloadOperation(); then Operations first return AddGraph")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Operation FederatedOperation.getPayloadOperation()"})
  void testGetPayloadOperation_thenOperationsFirstReturnAddGraph() {
    // Arrange
    FederatedOperation<Object, Object> op = new FederatedOperation<>();
    AddGraph op2 = new AddGraph();
    op.payloadOperation(op2);

    FederatedOperation<Object, Object> federatedOperation = new FederatedOperation<>();
    federatedOperation.payloadOperation(op);

    // Act
    Operation actualPayloadOperation = federatedOperation.getPayloadOperation();

    // Assert
    Collection<Operation> operations =
        ((FederatedOperation<Object, Object>) actualPayloadOperation).getOperations();
    assertEquals(1, operations.size());
    assertTrue(operations instanceof List);
    assertTrue(((List<Operation>) operations).get(0) instanceof AddGraph);
    assertTrue(actualPayloadOperation instanceof FederatedOperation);
    Class<AddGraph> expectedPayloadClass = AddGraph.class;
    assertEquals(
        expectedPayloadClass,
        ((FederatedOperation<Object, Object>) actualPayloadOperation).getPayloadClass());
    assertSame(
        op2, ((FederatedOperation<Object, Object>) actualPayloadOperation).getUnClonedPayload());
  }

  /**
   * Test {@link FederatedOperation#getPayloadOperation()}.
   *
   * <ul>
   *   <li>Then Operations first return {@link NamedOperation}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedOperation#getPayloadOperation()}
   */
  @Test
  @DisplayName("Test getPayloadOperation(); then Operations first return NamedOperation")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Operation FederatedOperation.getPayloadOperation()"})
  void testGetPayloadOperation_thenOperationsFirstReturnNamedOperation() {
    // Arrange
    OperationChain<Object> op = OperationChain.wrap(new NamedOperation<>());
    op.addOption("Name", "42");

    FederatedOperation<Object, Object> federatedOperation = new FederatedOperation<>();
    federatedOperation.payloadOperation(op);

    // Act
    Operation actualPayloadOperation = federatedOperation.getPayloadOperation();

    // Assert
    List<Operation> operations = ((OperationChain<Object>) actualPayloadOperation).getOperations();
    assertEquals(1, operations.size());
    Operation getResult = operations.get(0);
    assertTrue(getResult instanceof NamedOperation);
    assertTrue(actualPayloadOperation instanceof OperationChain);
    assertTrue(
        ((NamedOperation<Object, Object>) getResult).getOutputTypeReference()
            instanceof TypeReferenceImpl.Object);
    assertNull(((NamedOperation<Object, Object>) getResult).getInput());
    assertNull(((NamedOperation<Object, Object>) getResult).getOperationName());
    assertNull(((NamedOperation<Object, Object>) getResult).getParameters());
    assertNull(getResult.getOptions());
    assertTrue(((NamedOperation<Object, Object>) getResult).getOperations().isEmpty());
  }

  /**
   * Test {@link FederatedOperation#getPayloadOperation()}.
   *
   * <ul>
   *   <li>Then return {@link AddGraph}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedOperation#getPayloadOperation()}
   */
  @Test
  @DisplayName("Test getPayloadOperation(); then return AddGraph")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Operation FederatedOperation.getPayloadOperation()"})
  void testGetPayloadOperation_thenReturnAddGraph() {
    // Arrange
    FederatedOperation<Object, Object> federatedOperation = new FederatedOperation<>();
    federatedOperation.payloadOperation(new AddGraph());

    // Act
    Operation actualPayloadOperation = federatedOperation.getPayloadOperation();

    // Assert
    assertTrue(actualPayloadOperation instanceof AddGraph);
    assertNull(((AddGraph) actualPayloadOperation).getGraphId());
    assertNull(((AddGraph) actualPayloadOperation).getParentPropertiesId());
    assertNull(((AddGraph) actualPayloadOperation).getParentSchemaIds());
    assertNull(actualPayloadOperation.getOptions());
    assertNull(((AddGraph) actualPayloadOperation).getProperties());
    assertNull(((AddGraph) actualPayloadOperation).getGraphAuths());
    assertNull(((AddGraph) actualPayloadOperation).getReadAccessPredicate());
    assertNull(((AddGraph) actualPayloadOperation).getWriteAccessPredicate());
    assertNull(((AddGraph) actualPayloadOperation).getStoreProperties());
    assertNull(((AddGraph) actualPayloadOperation).getSchema());
    assertFalse(((AddGraph) actualPayloadOperation).getIsPublic());
    assertFalse(((AddGraph) actualPayloadOperation).isUserRequestingAdminUsage());
  }

  /**
   * Test {@link FederatedOperation#getPayloadOperation()}.
   *
   * <ul>
   *   <li>Then return GraphIds Empty.
   * </ul>
   *
   * <p>Method under test: {@link FederatedOperation#getPayloadOperation()}
   */
  @Test
  @DisplayName("Test getPayloadOperation(); then return GraphIds Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Operation FederatedOperation.getPayloadOperation()"})
  void testGetPayloadOperation_thenReturnGraphIdsEmpty() {
    // Arrange
    FederatedOperation<Object, Object> op = new FederatedOperation<>();
    op.graphIds(new ArrayList<>());
    GenericInputImpl op2 = new GenericInputImpl();
    op.payloadOperation(op2);

    FederatedOperation<Object, Object> federatedOperation = new FederatedOperation<>();
    federatedOperation.payloadOperation(op);

    // Act
    Operation actualPayloadOperation = federatedOperation.getPayloadOperation();

    // Assert
    Collection<Operation> operations =
        ((FederatedOperation<Object, Object>) actualPayloadOperation).getOperations();
    assertTrue(operations instanceof List);
    assertTrue(actualPayloadOperation instanceof FederatedOperation);
    assertTrue(operations.isEmpty());
    assertTrue(
        ((FederatedOperation<Object, Object>) actualPayloadOperation).getGraphIds().isEmpty());
    Class<GenericInputImpl> expectedPayloadClass = GenericInputImpl.class;
    assertEquals(
        expectedPayloadClass,
        ((FederatedOperation<Object, Object>) actualPayloadOperation).getPayloadClass());
    assertSame(
        op2, ((FederatedOperation<Object, Object>) actualPayloadOperation).getUnClonedPayload());
  }

  /**
   * Test {@link FederatedOperation#getPayloadOperation()}.
   *
   * <ul>
   *   <li>Then return {@link OperationChain#OperationChain()}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedOperation#getPayloadOperation()}
   */
  @Test
  @DisplayName("Test getPayloadOperation(); then return OperationChain()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Operation FederatedOperation.getPayloadOperation()"})
  void testGetPayloadOperation_thenReturnOperationChain() {
    // Arrange
    OperationChain<Object> op = new OperationChain<>();
    op.addOption("Name", "42");

    FederatedOperation<Object, Object> federatedOperation = new FederatedOperation<>();
    federatedOperation.payloadOperation(op);

    // Act
    Operation actualPayloadOperation = federatedOperation.getPayloadOperation();

    // Assert
    assertTrue(actualPayloadOperation instanceof OperationChain);
    assertEquals(op, actualPayloadOperation);
  }

  /**
   * Test {@link FederatedOperation#getPayloadOperation()}.
   *
   * <ul>
   *   <li>Then return Operations Empty.
   * </ul>
   *
   * <p>Method under test: {@link FederatedOperation#getPayloadOperation()}
   */
  @Test
  @DisplayName("Test getPayloadOperation(); then return Operations Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Operation FederatedOperation.getPayloadOperation()"})
  void testGetPayloadOperation_thenReturnOperationsEmpty() {
    // Arrange
    FederatedOperation<Object, Object> op = new FederatedOperation<>();
    GenericInputImpl op2 = new GenericInputImpl();
    op.payloadOperation(op2);

    FederatedOperation<Object, Object> federatedOperation = new FederatedOperation<>();
    federatedOperation.payloadOperation(op);

    // Act
    Operation actualPayloadOperation = federatedOperation.getPayloadOperation();

    // Assert
    Collection<Operation> operations =
        ((FederatedOperation<Object, Object>) actualPayloadOperation).getOperations();
    assertTrue(operations instanceof List);
    assertTrue(actualPayloadOperation instanceof FederatedOperation);
    assertTrue(operations.isEmpty());
    Class<GenericInputImpl> expectedPayloadClass = GenericInputImpl.class;
    assertEquals(
        expectedPayloadClass,
        ((FederatedOperation<Object, Object>) actualPayloadOperation).getPayloadClass());
    assertSame(
        op2, ((FederatedOperation<Object, Object>) actualPayloadOperation).getUnClonedPayload());
  }

  /**
   * Test {@link FederatedOperation#getPayloadOperation()}.
   *
   * <ul>
   *   <li>Then return PayloadClass is {@link FederatedOperation}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedOperation#getPayloadOperation()}
   */
  @Test
  @DisplayName("Test getPayloadOperation(); then return PayloadClass is FederatedOperation")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Operation FederatedOperation.getPayloadOperation()"})
  void testGetPayloadOperation_thenReturnPayloadClassIsFederatedOperation() {
    // Arrange
    FederatedOperation<Object, Object> op = new FederatedOperation<>();
    FederatedOperation<Object, Object> op2 = new FederatedOperation<>();
    op.payloadOperation(op2);

    FederatedOperation<Object, Object> federatedOperation = new FederatedOperation<>();
    federatedOperation.payloadOperation(op);

    // Act
    Operation actualPayloadOperation = federatedOperation.getPayloadOperation();

    // Assert
    assertTrue(actualPayloadOperation instanceof FederatedOperation);
    Class<FederatedOperation> expectedPayloadClass = FederatedOperation.class;
    assertEquals(
        expectedPayloadClass,
        ((FederatedOperation<Object, Object>) actualPayloadOperation).getPayloadClass());
    assertSame(
        op2, ((FederatedOperation<Object, Object>) actualPayloadOperation).getUnClonedPayload());
  }

  /**
   * Test {@link FederatedOperation#getPayloadOperation()}.
   *
   * <ul>
   *   <li>Then return PayloadClass is {@link OperationChain}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedOperation#getPayloadOperation()}
   */
  @Test
  @DisplayName("Test getPayloadOperation(); then return PayloadClass is OperationChain")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Operation FederatedOperation.getPayloadOperation()"})
  void testGetPayloadOperation_thenReturnPayloadClassIsOperationChain() {
    // Arrange
    FederatedOperation<Object, Object> op = new FederatedOperation<>();
    OperationChain<Object> op2 = OperationChain.wrap(new FederatedOperation<>());
    op.payloadOperation(op2);

    FederatedOperation<Object, Object> federatedOperation = new FederatedOperation<>();
    federatedOperation.payloadOperation(op);

    // Act
    Operation actualPayloadOperation = federatedOperation.getPayloadOperation();

    // Assert
    assertTrue(actualPayloadOperation instanceof FederatedOperation);
    Class<OperationChain> expectedPayloadClass = OperationChain.class;
    assertEquals(
        expectedPayloadClass,
        ((FederatedOperation<Object, Object>) actualPayloadOperation).getPayloadClass());
    assertSame(
        op2, ((FederatedOperation<Object, Object>) actualPayloadOperation).getUnClonedPayload());
  }

  /**
   * Test {@link FederatedOperation#getPayloadOperation()}.
   *
   * <ul>
   *   <li>Then return wrap {@link FederatedOperation} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link FederatedOperation#getPayloadOperation()}
   */
  @Test
  @DisplayName(
      "Test getPayloadOperation(); then return wrap FederatedOperation (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Operation FederatedOperation.getPayloadOperation()"})
  void testGetPayloadOperation_thenReturnWrapFederatedOperation() {
    // Arrange
    FederatedOperation<Object, Object> operation = new FederatedOperation<>();
    operation.payloadOperation(new AddGraph());

    OperationChain<Object> op = OperationChain.wrap(operation);
    op.addOption("Name", "42");

    FederatedOperation<Object, Object> federatedOperation = new FederatedOperation<>();
    federatedOperation.payloadOperation(op);

    // Act
    Operation actualPayloadOperation = federatedOperation.getPayloadOperation();

    // Assert
    assertTrue(actualPayloadOperation instanceof OperationChain);
    assertEquals(op, actualPayloadOperation);
  }

  /**
   * Test {@link FederatedOperation#hasPayloadOperation()}.
   *
   * <ul>
   *   <li>Given {@link FederatedOperation} (default constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedOperation#hasPayloadOperation()}
   */
  @Test
  @DisplayName(
      "Test hasPayloadOperation(); given FederatedOperation (default constructor); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FederatedOperation.hasPayloadOperation()"})
  void testHasPayloadOperation_givenFederatedOperation_thenReturnFalse() {
    // Arrange
    FederatedOperation<Object, Object> federatedOperation = new FederatedOperation<>();

    // Act and Assert
    assertFalse(federatedOperation.hasPayloadOperation());
  }

  /**
   * Test {@link FederatedOperation#hasPayloadOperation()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedOperation#hasPayloadOperation()}
   */
  @Test
  @DisplayName("Test hasPayloadOperation(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FederatedOperation.hasPayloadOperation()"})
  void testHasPayloadOperation_thenReturnTrue() {
    // Arrange
    FederatedOperation<Object, Object> federatedOperation = new FederatedOperation<>();
    federatedOperation.payloadOperation(new AddGraph());

    // Act and Assert
    assertTrue(federatedOperation.hasPayloadOperation());
  }

  /**
   * Test {@link FederatedOperation#getPayloadClass()}.
   *
   * <ul>
   *   <li>Given {@link FederatedOperation} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedOperation#getPayloadClass()}
   */
  @Test
  @DisplayName(
      "Test getPayloadClass(); given FederatedOperation (default constructor); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Class FederatedOperation.getPayloadClass()"})
  void testGetPayloadClass_givenFederatedOperation_thenReturnNull() {
    // Arrange
    FederatedOperation<Object, Object> federatedOperation = new FederatedOperation<>();

    // Act and Assert
    assertNull(federatedOperation.getPayloadClass());
  }

  /**
   * Test {@link FederatedOperation#getPayloadClass()}.
   *
   * <ul>
   *   <li>Then return {@link AddGraph}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedOperation#getPayloadClass()}
   */
  @Test
  @DisplayName("Test getPayloadClass(); then return AddGraph")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Class FederatedOperation.getPayloadClass()"})
  void testGetPayloadClass_thenReturnAddGraph() {
    // Arrange
    FederatedOperation<Object, Object> federatedOperation = new FederatedOperation<>();
    federatedOperation.payloadOperation(new AddGraph());

    // Act
    Class<? extends Operation> actualPayloadClass = federatedOperation.getPayloadClass();

    // Assert
    Class<AddGraph> expectedPayloadClass = AddGraph.class;
    assertEquals(expectedPayloadClass, actualPayloadClass);
  }

  /**
   * Test {@link FederatedOperation#payloadInstanceOf(Class)}.
   *
   * <p>Method under test: {@link FederatedOperation#payloadInstanceOf(Class)}
   */
  @Test
  @DisplayName("Test payloadInstanceOf(Class)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FederatedOperation.payloadInstanceOf(Class)"})
  void testPayloadInstanceOf() {
    // Arrange
    FederatedOperation<Object, Object> federatedOperation = new FederatedOperation<>();
    federatedOperation.payloadOperation(new AddGraph());
    Class<FederatedOperation> c = FederatedOperation.class;

    // Act
    boolean actualPayloadInstanceOfResult = federatedOperation.payloadInstanceOf(c);

    // Assert
    TypeReference outputTypeReference = federatedOperation.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.Object);
    assertFalse(actualPayloadInstanceOfResult);
    Class<Object> expectedOutputClass = Object.class;
    Class<?> outputClass = federatedOperation.getOutputClass();
    assertEquals(expectedOutputClass, outputClass);
    assertSame(outputClass, outputTypeReference.getType());
    assertSame(outputClass, federatedOperation.getOutputType());
  }

  /**
   * Test {@link FederatedOperation#payloadInstanceOf(Class)}.
   *
   * <ul>
   *   <li>Given {@link FederatedOperation} (default constructor).
   *   <li>When {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedOperation#payloadInstanceOf(Class)}
   */
  @Test
  @DisplayName(
      "Test payloadInstanceOf(Class); given FederatedOperation (default constructor); when 'null'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FederatedOperation.payloadInstanceOf(Class)"})
  void testPayloadInstanceOf_givenFederatedOperation_whenNull_thenReturnFalse() {
    // Arrange
    FederatedOperation<Object, Object> federatedOperation = new FederatedOperation<>();

    // Act
    boolean actualPayloadInstanceOfResult = federatedOperation.payloadInstanceOf(null);

    // Assert
    TypeReference outputTypeReference = federatedOperation.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.Object);
    assertFalse(actualPayloadInstanceOfResult);
    Class<Object> expectedOutputClass = Object.class;
    Class<?> outputClass = federatedOperation.getOutputClass();
    assertEquals(expectedOutputClass, outputClass);
    assertSame(outputClass, outputTypeReference.getType());
    assertSame(outputClass, federatedOperation.getOutputType());
  }

  /**
   * Test {@link FederatedOperation#payloadInstanceOf(Class)}.
   *
   * <ul>
   *   <li>Then {@link FederatedOperation} (default constructor) OutputTypeReference Type is {@link
   *       Object}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedOperation#payloadInstanceOf(Class)}
   */
  @Test
  @DisplayName(
      "Test payloadInstanceOf(Class); then FederatedOperation (default constructor) OutputTypeReference Type is Object")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FederatedOperation.payloadInstanceOf(Class)"})
  void testPayloadInstanceOf_thenFederatedOperationOutputTypeReferenceTypeIsObject() {
    // Arrange
    FederatedOperation<Object, Object> federatedOperation = new FederatedOperation<>();
    Class<Object> c = Object.class;

    // Act
    federatedOperation.payloadInstanceOf(c);

    // Assert
    TypeReference outputTypeReference = federatedOperation.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.Object);
    Class<Object> expectedOutputClass = Object.class;
    assertEquals(expectedOutputClass, federatedOperation.getOutputClass());
    assertSame(c, outputTypeReference.getType());
    assertSame(c, federatedOperation.getOutputType());
  }

  /**
   * Test {@link FederatedOperation#payloadInstanceOf(Class)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedOperation#payloadInstanceOf(Class)}
   */
  @Test
  @DisplayName("Test payloadInstanceOf(Class); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FederatedOperation.payloadInstanceOf(Class)"})
  void testPayloadInstanceOf_thenReturnTrue() {
    // Arrange
    FederatedOperation<Object, Object> federatedOperation = new FederatedOperation<>();
    federatedOperation.payloadOperation(new AddGraph());
    Class<Object> c = Object.class;

    // Act
    boolean actualPayloadInstanceOfResult = federatedOperation.payloadInstanceOf(c);

    // Assert
    TypeReference outputTypeReference = federatedOperation.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.Object);
    assertTrue(actualPayloadInstanceOfResult);
    Class<Object> expectedOutputClass = Object.class;
    assertEquals(expectedOutputClass, federatedOperation.getOutputClass());
    assertSame(c, outputTypeReference.getType());
    assertSame(c, federatedOperation.getOutputType());
  }

  /**
   * Test {@link FederatedOperation#shallowClone()}.
   *
   * <ul>
   *   <li>Then PayloadOperation return {@link AddGraph}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedOperation#shallowClone()}
   */
  @Test
  @DisplayName("Test shallowClone(); then PayloadOperation return AddGraph")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FederatedOperation FederatedOperation.shallowClone()"})
  void testShallowClone_thenPayloadOperationReturnAddGraph() throws CloneFailedException {
    // Arrange
    FederatedOperation<Object, Object> federatedOperation = new FederatedOperation<>();
    AddGraph op = new AddGraph();
    federatedOperation.payloadOperation(op);

    // Act
    FederatedOperation<Object, Object> actualShallowCloneResult = federatedOperation.shallowClone();

    // Assert
    assertTrue(actualShallowCloneResult.getPayloadOperation() instanceof AddGraph);
    Operation unClonedPayload = actualShallowCloneResult.getUnClonedPayload();
    assertTrue(unClonedPayload instanceof AddGraph);
    Class<AddGraph> expectedPayloadClass = AddGraph.class;
    assertEquals(expectedPayloadClass, actualShallowCloneResult.getPayloadClass());
    assertSame(op, unClonedPayload);
  }

  /**
   * Test {@link FederatedOperation#shallowClone()}.
   *
   * <ul>
   *   <li>Then return GraphIds Empty.
   * </ul>
   *
   * <p>Method under test: {@link FederatedOperation#shallowClone()}
   */
  @Test
  @DisplayName("Test shallowClone(); then return GraphIds Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FederatedOperation FederatedOperation.shallowClone()"})
  void testShallowClone_thenReturnGraphIdsEmpty() throws CloneFailedException {
    // Arrange
    FederatedOperation<Object, Object> federatedOperation = new FederatedOperation<>();
    federatedOperation.graphIds(new ArrayList<>());
    GenericInputImpl op = new GenericInputImpl();
    federatedOperation.payloadOperation(op);

    // Act
    FederatedOperation<Object, Object> actualShallowCloneResult = federatedOperation.shallowClone();

    // Assert
    Collection<Operation> operations = actualShallowCloneResult.getOperations();
    assertTrue(operations instanceof List);
    assertNull(actualShallowCloneResult.getPayloadOperation());
    assertTrue(operations.isEmpty());
    assertTrue(actualShallowCloneResult.getGraphIds().isEmpty());
    Class<GenericInputImpl> expectedPayloadClass = GenericInputImpl.class;
    assertEquals(expectedPayloadClass, actualShallowCloneResult.getPayloadClass());
    assertSame(op, actualShallowCloneResult.getUnClonedPayload());
  }

  /**
   * Test {@link FederatedOperation#shallowClone()}.
   *
   * <ul>
   *   <li>Then return Operations size is one.
   * </ul>
   *
   * <p>Method under test: {@link FederatedOperation#shallowClone()}
   */
  @Test
  @DisplayName("Test shallowClone(); then return Operations size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FederatedOperation FederatedOperation.shallowClone()"})
  void testShallowClone_thenReturnOperationsSizeIsOne() throws CloneFailedException {
    // Arrange
    FederatedOperation<Object, Object> federatedOperation = new FederatedOperation<>();
    AddElements op = new AddElements();
    federatedOperation.payloadOperation(op);

    // Act
    FederatedOperation<Object, Object> actualShallowCloneResult = federatedOperation.shallowClone();

    // Assert
    Collection<Operation> operations = actualShallowCloneResult.getOperations();
    assertEquals(1, operations.size());
    assertTrue(operations instanceof List);
    assertTrue(((List<Operation>) operations).get(0) instanceof AddElements);
    assertTrue(actualShallowCloneResult.getPayloadOperation() instanceof AddElements);
    Class<AddElements> expectedPayloadClass = AddElements.class;
    assertEquals(expectedPayloadClass, actualShallowCloneResult.getPayloadClass());
    assertSame(op, actualShallowCloneResult.getUnClonedPayload());
  }

  /**
   * Test {@link FederatedOperation#shallowClone()}.
   *
   * <ul>
   *   <li>Then return PayloadClass is {@link FederatedOperation}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedOperation#shallowClone()}
   */
  @Test
  @DisplayName("Test shallowClone(); then return PayloadClass is FederatedOperation")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FederatedOperation FederatedOperation.shallowClone()"})
  void testShallowClone_thenReturnPayloadClassIsFederatedOperation() throws CloneFailedException {
    // Arrange
    FederatedOperation<Object, Object> federatedOperation = new FederatedOperation<>();
    FederatedOperation<Object, Object> op = new FederatedOperation<>();
    federatedOperation.payloadOperation(op);

    // Act
    FederatedOperation<Object, Object> actualShallowCloneResult = federatedOperation.shallowClone();

    // Assert
    Class<FederatedOperation> expectedPayloadClass = FederatedOperation.class;
    assertEquals(expectedPayloadClass, actualShallowCloneResult.getPayloadClass());
    assertSame(op, actualShallowCloneResult.getUnClonedPayload());
  }

  /**
   * Test {@link FederatedOperation#shallowClone()}.
   *
   * <ul>
   *   <li>Then return PayloadClass is {@link OperationChain}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedOperation#shallowClone()}
   */
  @Test
  @DisplayName("Test shallowClone(); then return PayloadClass is OperationChain")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FederatedOperation FederatedOperation.shallowClone()"})
  void testShallowClone_thenReturnPayloadClassIsOperationChain() throws CloneFailedException {
    // Arrange
    FederatedOperation<Object, Object> federatedOperation = new FederatedOperation<>();
    OperationChain<Object> op = OperationChain.wrap(new FederatedOperation<>());
    federatedOperation.payloadOperation(op);

    // Act
    FederatedOperation<Object, Object> actualShallowCloneResult = federatedOperation.shallowClone();

    // Assert
    Class<OperationChain> expectedPayloadClass = OperationChain.class;
    assertEquals(expectedPayloadClass, actualShallowCloneResult.getPayloadClass());
    assertSame(op, actualShallowCloneResult.getUnClonedPayload());
  }

  /**
   * Test {@link FederatedOperation#shallowClone()}.
   *
   * <ul>
   *   <li>Then return PayloadOperation is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedOperation#shallowClone()}
   */
  @Test
  @DisplayName("Test shallowClone(); then return PayloadOperation is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FederatedOperation FederatedOperation.shallowClone()"})
  void testShallowClone_thenReturnPayloadOperationIsNull() throws CloneFailedException {
    // Arrange
    FederatedOperation<Object, Object> federatedOperation = new FederatedOperation<>();
    GenericInputImpl op = new GenericInputImpl();
    federatedOperation.payloadOperation(op);

    // Act
    FederatedOperation<Object, Object> actualShallowCloneResult = federatedOperation.shallowClone();

    // Assert
    Collection<Operation> operations = actualShallowCloneResult.getOperations();
    assertTrue(operations instanceof List);
    assertNull(actualShallowCloneResult.getPayloadOperation());
    assertTrue(operations.isEmpty());
    Class<GenericInputImpl> expectedPayloadClass = GenericInputImpl.class;
    assertEquals(expectedPayloadClass, actualShallowCloneResult.getPayloadClass());
    assertSame(op, actualShallowCloneResult.getUnClonedPayload());
  }

  /**
   * Test {@link FederatedOperation#equals(Object)}, and {@link FederatedOperation#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link FederatedOperation#equals(Object)}
   *   <li>{@link FederatedOperation#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FederatedOperation.equals(Object)",
    "int FederatedOperation.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    FederatedOperation<Object, Object> federatedOperation = new FederatedOperation<>();

    // Act and Assert
    assertEquals(federatedOperation, federatedOperation);
    int expectedHashCodeResult = federatedOperation.hashCode();
    assertEquals(expectedHashCodeResult, federatedOperation.hashCode());
  }

  /**
   * Test {@link FederatedOperation#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link FederatedOperation#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FederatedOperation.equals(Object)",
    "int FederatedOperation.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    FederatedOperation<Object, Object> federatedOperation = new FederatedOperation<>();
    federatedOperation.graphIds(new ArrayList<>());

    // Act and Assert
    assertNotEquals(federatedOperation, new FederatedOperation<>());
  }

  /**
   * Test {@link FederatedOperation#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link FederatedOperation#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FederatedOperation.equals(Object)",
    "int FederatedOperation.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    FederatedOperation<Object, Object> federatedOperation = new FederatedOperation<>();

    // Act and Assert
    assertNotEquals(federatedOperation, null);
  }

  /**
   * Test {@link FederatedOperation#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link FederatedOperation#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FederatedOperation.equals(Object)",
    "int FederatedOperation.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    FederatedOperation<Object, Object> federatedOperation = new FederatedOperation<>();

    // Act and Assert
    assertNotEquals(federatedOperation, "Different type to FederatedOperation");
  }

  /**
   * Test {@link FederatedOperation#getOutputTypeReference()}.
   *
   * <p>Method under test: {@link FederatedOperation#getOutputTypeReference()}
   */
  @Test
  @DisplayName("Test getOutputTypeReference()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TypeReference FederatedOperation.getOutputTypeReference()"})
  void testGetOutputTypeReference() {
    // Arrange
    FederatedOperation<Object, Object> federatedOperation = new FederatedOperation<>();

    // Act and Assert
    assertTrue(federatedOperation.getOutputTypeReference() instanceof TypeReferenceImpl.Object);
  }

  /**
   * Test {@link FederatedOperation#setInput(Object)}.
   *
   * <p>Method under test: {@link FederatedOperation#setInput(Object)}
   */
  @Test
  @DisplayName("Test setInput(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FederatedOperation.setInput(Object)"})
  void testSetInput() {
    // Arrange
    FederatedOperation<Object, Object> op = new FederatedOperation<>();
    op.addOption("Name", "Error passing FederatedOperation input into payload operation");

    FederatedOperation<Object, Object> federatedOperation = new FederatedOperation<>();
    federatedOperation.payloadOperation(op);

    // Act and Assert
    assertThrows(GafferRuntimeException.class, () -> federatedOperation.setInput("Input"));
  }

  /**
   * Test {@link FederatedOperation#setInput(Object)}.
   *
   * <ul>
   *   <li>Given {@link FederatedOperation} (default constructor) payloadOperation {@link AddGraph}
   *       (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link FederatedOperation#setInput(Object)}
   */
  @Test
  @DisplayName(
      "Test setInput(Object); given FederatedOperation (default constructor) payloadOperation AddGraph (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FederatedOperation.setInput(Object)"})
  void testSetInput_givenFederatedOperationPayloadOperationAddGraph() {
    // Arrange
    FederatedOperation<Object, Object> federatedOperation = new FederatedOperation<>();
    federatedOperation.payloadOperation(new AddGraph());

    // Act and Assert
    assertThrows(GafferRuntimeException.class, () -> federatedOperation.setInput("Input"));
  }

  /**
   * Test {@link FederatedOperation#setInput(Object)}.
   *
   * <ul>
   *   <li>Given {@link FederatedOperation} (default constructor).
   *   <li>When {@code Input}.
   *   <li>Then throw {@link GafferRuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedOperation#setInput(Object)}
   */
  @Test
  @DisplayName(
      "Test setInput(Object); given FederatedOperation (default constructor); when 'Input'; then throw GafferRuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FederatedOperation.setInput(Object)"})
  void testSetInput_givenFederatedOperation_whenInput_thenThrowGafferRuntimeException() {
    // Arrange
    FederatedOperation<Object, Object> federatedOperation = new FederatedOperation<>();

    // Act and Assert
    assertThrows(GafferRuntimeException.class, () -> federatedOperation.setInput("Input"));
  }

  /**
   * Test {@link FederatedOperation#setInput(Object)}.
   *
   * <ul>
   *   <li>Then {@link FederatedOperation} (default constructor) UnClonedPayload {@link
   *       GenericInputImpl}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedOperation#setInput(Object)}
   */
  @Test
  @DisplayName(
      "Test setInput(Object); then FederatedOperation (default constructor) UnClonedPayload GenericInputImpl")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FederatedOperation.setInput(Object)"})
  void testSetInput_thenFederatedOperationUnClonedPayloadGenericInputImpl() {
    // Arrange
    FederatedOperation<Object, Object> federatedOperation = new FederatedOperation<>();
    federatedOperation.payloadOperation(new GenericInputImpl());

    // Act
    federatedOperation.setInput("Input");

    // Assert
    Operation unClonedPayload = federatedOperation.getUnClonedPayload();
    assertTrue(unClonedPayload instanceof GenericInputImpl);
    assertEquals("Input", ((GenericInputImpl) unClonedPayload).getInput());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link FederatedOperation}
   *   <li>{@link FederatedOperation#mergeFunction(BiFunction)}
   *   <li>{@link FederatedOperation#setOptions(Map)}
   *   <li>{@link FederatedOperation#skipFailedFederatedExecution(boolean)}
   *   <li>{@link FederatedOperation#getInput()}
   *   <li>{@link FederatedOperation#getMergeFunction()}
   *   <li>{@link FederatedOperation#getOptions()}
   *   <li>{@link FederatedOperation#getUnClonedPayload()}
   *   <li>{@link FederatedOperation#isSkipFailedFederatedExecution()}
   *   <li>{@link FederatedOperation#isUserRequestingAdminUsage()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FederatedOperation.<init>()",
    "Object FederatedOperation.getInput()",
    "BiFunction FederatedOperation.getMergeFunction()",
    "Map FederatedOperation.getOptions()",
    "Operation FederatedOperation.getUnClonedPayload()",
    "boolean FederatedOperation.isSkipFailedFederatedExecution()",
    "boolean FederatedOperation.isUserRequestingAdminUsage()",
    "FederatedOperation FederatedOperation.mergeFunction(BiFunction)",
    "void FederatedOperation.setOptions(Map)",
    "FederatedOperation FederatedOperation.skipFailedFederatedExecution(boolean)"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    FederatedOperation<Object, Object> actualFederatedOperation = new FederatedOperation<>();
    BiFunction mergeFunction = mock(BiFunction.class);
    FederatedOperation<Object, Object> actualMergeFunctionResult =
        actualFederatedOperation.mergeFunction(mergeFunction);
    HashMap<String, String> options = new HashMap<>();
    actualFederatedOperation.setOptions(options);
    FederatedOperation<Object, Object> actualSkipFailedFederatedExecutionResult =
        actualFederatedOperation.skipFailedFederatedExecution(true);
    Object actualInput = actualFederatedOperation.getInput();
    BiFunction actualMergeFunction = actualFederatedOperation.getMergeFunction();
    Map<String, String> actualOptions = actualFederatedOperation.getOptions();
    Operation actualUnClonedPayload = actualFederatedOperation.getUnClonedPayload();
    boolean actualIsSkipFailedFederatedExecutionResult =
        actualFederatedOperation.isSkipFailedFederatedExecution();

    // Assert
    assertNull(actualInput);
    assertNull(actualUnClonedPayload);
    assertFalse(actualFederatedOperation.isUserRequestingAdminUsage());
    assertTrue(actualOptions.isEmpty());
    assertTrue(actualIsSkipFailedFederatedExecutionResult);
    assertSame(options, actualOptions);
    assertSame(actualFederatedOperation, actualMergeFunctionResult);
    assertSame(actualFederatedOperation, actualSkipFailedFederatedExecutionResult);
    assertSame(mergeFunction, actualMergeFunction);
  }
}
