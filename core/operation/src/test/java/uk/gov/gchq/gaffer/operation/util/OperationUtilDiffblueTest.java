package uk.gov.gchq.gaffer.operation.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.id.ElementId;
import uk.gov.gchq.gaffer.data.element.id.EntityId;
import uk.gov.gchq.gaffer.named.operation.AddNamedOperation;
import uk.gov.gchq.gaffer.named.operation.NamedOperation;
import uk.gov.gchq.gaffer.operation.Operation;
import uk.gov.gchq.gaffer.operation.OperationChain;
import uk.gov.gchq.gaffer.operation.data.EntitySeed;
import uk.gov.gchq.gaffer.operation.impl.OperationImpl;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl;
import uk.gov.gchq.koryphe.iterable.MappedIterable;
import uk.gov.gchq.koryphe.iterable.MappedIterator;

class OperationUtilDiffblueTest {
  /**
   * Test {@link OperationUtil#toElementIds(Iterable)} with {@code Iterable}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return {@link MappedIterable}.
   * </ul>
   *
   * <p>Method under test: {@link OperationUtil#toElementIds(Iterable)}
   */
  @Test
  @DisplayName(
      "Test toElementIds(Iterable) with 'Iterable'; when ArrayList(); then return MappedIterable")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable OperationUtil.toElementIds(Iterable)"})
  void testToElementIdsWithIterable_whenArrayList_thenReturnMappedIterable() {
    // Arrange
    ArrayList<Object> input = new ArrayList<>();

    // Act
    Iterable<? extends ElementId> actualToElementIdsResult = OperationUtil.toElementIds(input);
    Iterator<? extends ElementId> actualIteratorResult = actualToElementIdsResult.iterator();

    // Assert
    assertTrue(actualToElementIdsResult instanceof MappedIterable);
    Iterator<? extends ElementId> iteratorResult = actualToElementIdsResult.iterator();
    assertTrue(iteratorResult instanceof MappedIterator);
    assertTrue(actualIteratorResult instanceof MappedIterator);
    assertFalse(iteratorResult.hasNext());
    assertFalse(actualIteratorResult.hasNext());
    assertTrue(input.isEmpty());
  }

  /**
   * Test {@link OperationUtil#toElementIds(Iterable)} with {@code Iterable}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link OperationUtil#toElementIds(Iterable)}
   */
  @Test
  @DisplayName("Test toElementIds(Iterable) with 'Iterable'; when 'null'; then 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable OperationUtil.toElementIds(Iterable)"})
  void testToElementIdsWithIterable_whenNull_thenNull() {
    // Arrange and Act
    Iterable<? extends ElementId> actualToElementIdsResult =
        OperationUtil.toElementIds((Iterable<?>) null);

    // Assert
    assertNull(null);
    assertNull(actualToElementIdsResult);
  }

  /**
   * Test {@link OperationUtil#toElementIds(Object[])} with {@code Object[]}.
   *
   * <ul>
   *   <li>When {@code Input}.
   *   <li>Then return {@link List}.
   * </ul>
   *
   * <p>Method under test: {@link OperationUtil#toElementIds(Object[])}
   */
  @Test
  @DisplayName("Test toElementIds(Object[]) with 'Object[]'; when 'Input'; then return List")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable OperationUtil.toElementIds(Object[])"})
  void testToElementIdsWithObject_whenInput_thenReturnList() {
    // Arrange
    Object[] input = new Object[] {"Input"};

    // Act
    Iterable<? extends ElementId> actualToElementIdsResult = OperationUtil.toElementIds(input);
    Iterator<? extends ElementId> actualIteratorResult = actualToElementIdsResult.iterator();

    // Assert
    assertTrue(actualToElementIdsResult instanceof List);
    assertEquals(1, ((List<? extends ElementId>) actualToElementIdsResult).size());
    ElementId getResult = ((List<? extends ElementId>) actualToElementIdsResult).get(0);
    assertTrue(getResult instanceof EntitySeed);
    assertEquals("uk.gov.gchq.gaffer.operation.data.EntitySeed", getResult.getClassName());
    assertEquals("Input", ((EntitySeed) getResult).getVertex());
    assertEquals(1, input.length);
    assertEquals("Input", input[0]);
    ElementId actualNextResult = actualIteratorResult.next();
    assertFalse(actualIteratorResult.hasNext());
    assertSame(getResult, actualNextResult);
  }

  /**
   * Test {@link OperationUtil#toElementIds(Object[])} with {@code Object[]}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link OperationUtil#toElementIds(Object[])}
   */
  @Test
  @DisplayName("Test toElementIds(Object[]) with 'Object[]'; when 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable OperationUtil.toElementIds(Object[])"})
  void testToElementIdsWithObject_whenNull_thenReturnNull() {
    // Arrange and Act
    Iterable<? extends ElementId> actualToElementIdsResult =
        OperationUtil.toElementIds((Object[]) null);

    // Assert
    assertNull(actualToElementIdsResult);
    assertNull(null);
  }

  /**
   * Test {@link OperationUtil#fromElementIds(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return {@link MappedIterable}.
   * </ul>
   *
   * <p>Method under test: {@link OperationUtil#fromElementIds(Iterable)}
   */
  @Test
  @DisplayName("Test fromElementIds(Iterable); when ArrayList(); then return MappedIterable")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable OperationUtil.fromElementIds(Iterable)"})
  void testFromElementIds_whenArrayList_thenReturnMappedIterable() {
    // Arrange
    ArrayList<ElementId> input = new ArrayList<>();

    // Act
    Iterable<?> actualFromElementIdsResult = OperationUtil.fromElementIds(input);
    Iterator<?> actualIteratorResult = actualFromElementIdsResult.iterator();

    // Assert
    assertTrue(actualFromElementIdsResult instanceof MappedIterable);
    Iterator<?> iteratorResult = actualFromElementIdsResult.iterator();
    assertTrue(iteratorResult instanceof MappedIterator);
    assertTrue(actualIteratorResult instanceof MappedIterator);
    assertFalse(iteratorResult.hasNext());
    assertFalse(actualIteratorResult.hasNext());
    assertTrue(input.isEmpty());
  }

  /**
   * Test {@link OperationUtil#fromElementIds(Iterable)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link OperationUtil#fromElementIds(Iterable)}
   */
  @Test
  @DisplayName("Test fromElementIds(Iterable); when 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable OperationUtil.fromElementIds(Iterable)"})
  void testFromElementIds_whenNull_thenReturnNull() {
    // Arrange and Act
    Iterable<?> actualFromElementIdsResult = OperationUtil.fromElementIds(null);

    // Assert
    assertNull(actualFromElementIdsResult);
    assertNull(null);
  }

  /**
   * Test {@link OperationUtil#toEntityIds(Iterable)} with {@code Iterable}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return {@link MappedIterable}.
   * </ul>
   *
   * <p>Method under test: {@link OperationUtil#toEntityIds(Iterable)}
   */
  @Test
  @DisplayName(
      "Test toEntityIds(Iterable) with 'Iterable'; when ArrayList(); then return MappedIterable")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable OperationUtil.toEntityIds(Iterable)"})
  void testToEntityIdsWithIterable_whenArrayList_thenReturnMappedIterable() {
    // Arrange
    ArrayList<Object> input = new ArrayList<>();

    // Act
    Iterable<? extends EntityId> actualToEntityIdsResult = OperationUtil.toEntityIds(input);
    Iterator<? extends EntityId> actualIteratorResult = actualToEntityIdsResult.iterator();

    // Assert
    assertTrue(actualToEntityIdsResult instanceof MappedIterable);
    Iterator<? extends EntityId> iteratorResult = actualToEntityIdsResult.iterator();
    assertTrue(iteratorResult instanceof MappedIterator);
    assertTrue(actualIteratorResult instanceof MappedIterator);
    assertFalse(iteratorResult.hasNext());
    assertFalse(actualIteratorResult.hasNext());
    assertTrue(input.isEmpty());
  }

  /**
   * Test {@link OperationUtil#toEntityIds(Iterable)} with {@code Iterable}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link OperationUtil#toEntityIds(Iterable)}
   */
  @Test
  @DisplayName("Test toEntityIds(Iterable) with 'Iterable'; when 'null'; then 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable OperationUtil.toEntityIds(Iterable)"})
  void testToEntityIdsWithIterable_whenNull_thenNull() {
    // Arrange and Act
    Iterable<? extends EntityId> actualToEntityIdsResult =
        OperationUtil.toEntityIds((Iterable<?>) null);

    // Assert
    assertNull(null);
    assertNull(actualToEntityIdsResult);
  }

  /**
   * Test {@link OperationUtil#toEntityIds(Object[])} with {@code Object[]}.
   *
   * <ul>
   *   <li>When {@code Input}.
   *   <li>Then return {@link List}.
   * </ul>
   *
   * <p>Method under test: {@link OperationUtil#toEntityIds(Object[])}
   */
  @Test
  @DisplayName("Test toEntityIds(Object[]) with 'Object[]'; when 'Input'; then return List")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable OperationUtil.toEntityIds(Object[])"})
  void testToEntityIdsWithObject_whenInput_thenReturnList() {
    // Arrange
    Object[] input = new Object[] {"Input"};

    // Act
    Iterable<? extends EntityId> actualToEntityIdsResult = OperationUtil.toEntityIds(input);
    Iterator<? extends EntityId> actualIteratorResult = actualToEntityIdsResult.iterator();

    // Assert
    assertTrue(actualToEntityIdsResult instanceof List);
    assertEquals(1, ((List<? extends EntityId>) actualToEntityIdsResult).size());
    EntityId getResult = ((List<? extends EntityId>) actualToEntityIdsResult).get(0);
    assertTrue(getResult instanceof EntitySeed);
    assertEquals("uk.gov.gchq.gaffer.operation.data.EntitySeed", getResult.getClassName());
    assertEquals("Input", getResult.getVertex());
    assertEquals(1, input.length);
    assertEquals("Input", input[0]);
    EntityId actualNextResult = actualIteratorResult.next();
    assertFalse(actualIteratorResult.hasNext());
    assertSame(getResult, actualNextResult);
  }

  /**
   * Test {@link OperationUtil#toEntityIds(Object[])} with {@code Object[]}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link OperationUtil#toEntityIds(Object[])}
   */
  @Test
  @DisplayName("Test toEntityIds(Object[]) with 'Object[]'; when 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable OperationUtil.toEntityIds(Object[])"})
  void testToEntityIdsWithObject_whenNull_thenReturnNull() {
    // Arrange and Act
    Iterable<? extends EntityId> actualToEntityIdsResult =
        OperationUtil.toEntityIds((Object[]) null);

    // Assert
    assertNull(actualToEntityIdsResult);
    assertNull(null);
  }

  /**
   * Test {@link OperationUtil#fromEntityIds(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return {@link MappedIterable}.
   * </ul>
   *
   * <p>Method under test: {@link OperationUtil#fromEntityIds(Iterable)}
   */
  @Test
  @DisplayName("Test fromEntityIds(Iterable); when ArrayList(); then return MappedIterable")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable OperationUtil.fromEntityIds(Iterable)"})
  void testFromEntityIds_whenArrayList_thenReturnMappedIterable() {
    // Arrange
    ArrayList<EntityId> input = new ArrayList<>();

    // Act
    Iterable<?> actualFromEntityIdsResult = OperationUtil.fromEntityIds(input);
    Iterator<?> actualIteratorResult = actualFromEntityIdsResult.iterator();

    // Assert
    assertTrue(actualFromEntityIdsResult instanceof MappedIterable);
    Iterator<?> iteratorResult = actualFromEntityIdsResult.iterator();
    assertTrue(iteratorResult instanceof MappedIterator);
    assertTrue(actualIteratorResult instanceof MappedIterator);
    assertFalse(iteratorResult.hasNext());
    assertFalse(actualIteratorResult.hasNext());
    assertTrue(input.isEmpty());
  }

  /**
   * Test {@link OperationUtil#fromEntityIds(Iterable)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link OperationUtil#fromEntityIds(Iterable)}
   */
  @Test
  @DisplayName("Test fromEntityIds(Iterable); when 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable OperationUtil.fromEntityIds(Iterable)"})
  void testFromEntityIds_whenNull_thenReturnNull() {
    // Arrange and Act
    Iterable<?> actualFromEntityIdsResult = OperationUtil.fromEntityIds(null);

    // Assert
    assertNull(actualFromEntityIdsResult);
    assertNull(null);
  }

  /**
   * Test {@link OperationUtil#extractNextOp(Iterator)}.
   *
   * <ul>
   *   <li>Given {@link AddNamedOperation} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link OperationUtil#extractNextOp(Iterator)}
   */
  @Test
  @DisplayName(
      "Test extractNextOp(Iterator); given AddNamedOperation (default constructor); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Operation OperationUtil.extractNextOp(Iterator)"})
  void testExtractNextOp_givenAddNamedOperation_thenReturnNull() {
    // Arrange
    ArrayList<Operation> operationList = new ArrayList<>();
    operationList.add(new AddNamedOperation());
    Iterator<Operation> itr = operationList.iterator();

    // Act and Assert
    assertNull(OperationUtil.extractNextOp(itr));
    assertFalse(itr.hasNext());
  }

  /**
   * Test {@link OperationUtil#extractNextOp(Iterator)}.
   *
   * <ul>
   *   <li>Given {@link OperationImpl} (default constructor).
   *   <li>Then return {@link OperationImpl}.
   * </ul>
   *
   * <p>Method under test: {@link OperationUtil#extractNextOp(Iterator)}
   */
  @Test
  @DisplayName(
      "Test extractNextOp(Iterator); given OperationImpl (default constructor); then return OperationImpl")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Operation OperationUtil.extractNextOp(Iterator)"})
  void testExtractNextOp_givenOperationImpl_thenReturnOperationImpl() {
    // Arrange
    ArrayList<Operation> operationList = new ArrayList<>();
    operationList.add(new OperationImpl());

    // Act
    Operation actualExtractNextOpResult = OperationUtil.extractNextOp(operationList.iterator());

    // Assert
    assertTrue(actualExtractNextOpResult instanceof OperationImpl);
    assertNull(((OperationImpl) actualExtractNextOpResult).getRequiredField1());
    assertNull(((OperationImpl) actualExtractNextOpResult).getOptionalField1());
    assertNull(actualExtractNextOpResult.getOptions());
    assertNull(((OperationImpl) actualExtractNextOpResult).getOptionalField2());
    assertNull(((OperationImpl) actualExtractNextOpResult).getRequiredField2());
  }

  /**
   * Test {@link OperationUtil#extractNextOp(Iterator)}.
   *
   * <ul>
   *   <li>Given wrap {@link NamedOperation} (default constructor).
   *   <li>Then return Operations size is one.
   * </ul>
   *
   * <p>Method under test: {@link OperationUtil#extractNextOp(Iterator)}
   */
  @Test
  @DisplayName(
      "Test extractNextOp(Iterator); given wrap NamedOperation (default constructor); then return Operations size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Operation OperationUtil.extractNextOp(Iterator)"})
  void testExtractNextOp_givenWrapNamedOperation_thenReturnOperationsSizeIsOne() {
    // Arrange
    ArrayList<Operation> operationList = new ArrayList<>();
    NamedOperation<Object, Object> operation = new NamedOperation<>();
    OperationChain<Object> wrapResult = OperationChain.wrap(operation);
    operationList.add(wrapResult);

    // Act
    Operation actualExtractNextOpResult = OperationUtil.extractNextOp(operationList.iterator());

    // Assert
    List<Operation> operations =
        ((OperationChain<Object>) actualExtractNextOpResult).getOperations();
    assertEquals(1, operations.size());
    Operation getResult = operations.get(0);
    assertTrue(getResult instanceof NamedOperation);
    assertTrue(actualExtractNextOpResult instanceof OperationChain);
    TypeReference<Object> outputTypeReference =
        ((OperationChain<Object>) actualExtractNextOpResult).getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.Object);
    assertTrue(actualExtractNextOpResult.getOptions().isEmpty());
    Class<Object> expectedOutputClass = Object.class;
    Class<?> outputClass = ((OperationChain<Object>) actualExtractNextOpResult).getOutputClass();
    assertEquals(expectedOutputClass, outputClass);
    Class<Operation> expectedOperationsClass = Operation.class;
    assertEquals(
        expectedOperationsClass,
        ((OperationChain<Object>) actualExtractNextOpResult).getOperationsClass());
    assertSame(operation, getResult);
    assertSame(outputClass, outputTypeReference.getType());
    assertSame(outputClass, ((OperationChain<Object>) actualExtractNextOpResult).getOutputType());
  }
}
