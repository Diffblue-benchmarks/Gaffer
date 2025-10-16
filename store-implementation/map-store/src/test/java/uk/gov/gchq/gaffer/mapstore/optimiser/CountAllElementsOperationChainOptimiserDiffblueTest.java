package uk.gov.gchq.gaffer.mapstore.optimiser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.mapstore.operation.CountAllElementsDefaultView;
import uk.gov.gchq.gaffer.operation.Operation;

class CountAllElementsOperationChainOptimiserDiffblueTest {
  /**
   * Test {@link CountAllElementsOperationChainOptimiser#addPreOperations(Operation, Operation)}.
   *
   * <p>Method under test: {@link
   * CountAllElementsOperationChainOptimiser#addPreOperations(Operation, Operation)}
   */
  @Test
  @DisplayName("Test addPreOperations(Operation, Operation)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List CountAllElementsOperationChainOptimiser.addPreOperations(Operation, Operation)"
  })
  void testAddPreOperations() {
    // Arrange
    CountAllElementsOperationChainOptimiser countAllElementsOperationChainOptimiser =
        new CountAllElementsOperationChainOptimiser();
    CountAllElementsDefaultView previousOp = new CountAllElementsDefaultView();

    // Act and Assert
    assertTrue(
        countAllElementsOperationChainOptimiser
            .addPreOperations(previousOp, new CountAllElementsDefaultView())
            .isEmpty());
  }

  /**
   * Test {@link CountAllElementsOperationChainOptimiser#optimiseCurrentOperation(Operation,
   * Operation, Operation)}.
   *
   * <ul>
   *   <li>Then return first is {@link CountAllElementsDefaultView} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * CountAllElementsOperationChainOptimiser#optimiseCurrentOperation(Operation, Operation,
   * Operation)}
   */
  @Test
  @DisplayName(
      "Test optimiseCurrentOperation(Operation, Operation, Operation); then return first is CountAllElementsDefaultView (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List CountAllElementsOperationChainOptimiser.optimiseCurrentOperation(Operation, Operation, Operation)"
  })
  void testOptimiseCurrentOperation_thenReturnFirstIsCountAllElementsDefaultView() {
    // Arrange
    CountAllElementsOperationChainOptimiser countAllElementsOperationChainOptimiser =
        new CountAllElementsOperationChainOptimiser();
    CountAllElementsDefaultView previousOp = new CountAllElementsDefaultView();
    CountAllElementsDefaultView currentOp = new CountAllElementsDefaultView();

    // Act
    List<Operation> actualOptimiseCurrentOperationResult =
        countAllElementsOperationChainOptimiser.optimiseCurrentOperation(
            previousOp, currentOp, new CountAllElementsDefaultView());

    // Assert
    assertEquals(1, actualOptimiseCurrentOperationResult.size());
    assertSame(currentOp, actualOptimiseCurrentOperationResult.get(0));
  }

  /**
   * Test {@link CountAllElementsOperationChainOptimiser#optimiseCurrentOperation(Operation,
   * Operation, Operation)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return first is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CountAllElementsOperationChainOptimiser#optimiseCurrentOperation(Operation, Operation,
   * Operation)}
   */
  @Test
  @DisplayName(
      "Test optimiseCurrentOperation(Operation, Operation, Operation); when 'null'; then return first is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List CountAllElementsOperationChainOptimiser.optimiseCurrentOperation(Operation, Operation, Operation)"
  })
  void testOptimiseCurrentOperation_whenNull_thenReturnFirstIsNull() {
    // Arrange and Act
    List<Operation> actualOptimiseCurrentOperationResult =
        new CountAllElementsOperationChainOptimiser().optimiseCurrentOperation(null, null, null);

    // Assert
    assertEquals(1, actualOptimiseCurrentOperationResult.size());
    assertNull(actualOptimiseCurrentOperationResult.get(0));
  }

  /**
   * Test {@link CountAllElementsOperationChainOptimiser#addPostOperations(Operation, Operation)}.
   *
   * <p>Method under test: {@link
   * CountAllElementsOperationChainOptimiser#addPostOperations(Operation, Operation)}
   */
  @Test
  @DisplayName("Test addPostOperations(Operation, Operation)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List CountAllElementsOperationChainOptimiser.addPostOperations(Operation, Operation)"
  })
  void testAddPostOperations() {
    // Arrange
    CountAllElementsOperationChainOptimiser countAllElementsOperationChainOptimiser =
        new CountAllElementsOperationChainOptimiser();
    CountAllElementsDefaultView currentOp = new CountAllElementsDefaultView();

    // Act and Assert
    assertTrue(
        countAllElementsOperationChainOptimiser
            .addPostOperations(currentOp, new CountAllElementsDefaultView())
            .isEmpty());
  }

  /**
   * Test {@link CountAllElementsOperationChainOptimiser#optimiseAll(List)}.
   *
   * <ul>
   *   <li>Given {@link CountAllElementsDefaultView} (default constructor).
   *   <li>Then return {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link CountAllElementsOperationChainOptimiser#optimiseAll(List)}
   */
  @Test
  @DisplayName(
      "Test optimiseAll(List); given CountAllElementsDefaultView (default constructor); then return ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List CountAllElementsOperationChainOptimiser.optimiseAll(List)"})
  void testOptimiseAll_givenCountAllElementsDefaultView_thenReturnArrayList() {
    // Arrange
    CountAllElementsOperationChainOptimiser countAllElementsOperationChainOptimiser =
        new CountAllElementsOperationChainOptimiser();

    ArrayList<Operation> ops = new ArrayList<>();
    ops.add(new CountAllElementsDefaultView());

    // Act
    List<Operation> actualOptimiseAllResult =
        countAllElementsOperationChainOptimiser.optimiseAll(ops);

    // Assert
    assertSame(ops, actualOptimiseAllResult);
  }

  /**
   * Test {@link CountAllElementsOperationChainOptimiser#optimiseAll(List)}.
   *
   * <ul>
   *   <li>Given {@link CountAllElementsDefaultView} (default constructor).
   *   <li>Then return size is two.
   * </ul>
   *
   * <p>Method under test: {@link CountAllElementsOperationChainOptimiser#optimiseAll(List)}
   */
  @Test
  @DisplayName(
      "Test optimiseAll(List); given CountAllElementsDefaultView (default constructor); then return size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List CountAllElementsOperationChainOptimiser.optimiseAll(List)"})
  void testOptimiseAll_givenCountAllElementsDefaultView_thenReturnSizeIsTwo() {
    // Arrange
    CountAllElementsOperationChainOptimiser countAllElementsOperationChainOptimiser =
        new CountAllElementsOperationChainOptimiser();

    ArrayList<Operation> ops = new ArrayList<>();
    ops.add(new CountAllElementsDefaultView());
    CountAllElementsDefaultView countAllElementsDefaultView = new CountAllElementsDefaultView();
    ops.add(countAllElementsDefaultView);

    // Act
    List<Operation> actualOptimiseAllResult =
        countAllElementsOperationChainOptimiser.optimiseAll(ops);

    // Assert
    assertEquals(2, actualOptimiseAllResult.size());
    assertSame(countAllElementsDefaultView, actualOptimiseAllResult.get(1));
  }

  /**
   * Test {@link CountAllElementsOperationChainOptimiser#optimiseAll(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link CountAllElementsOperationChainOptimiser#optimiseAll(List)}
   */
  @Test
  @DisplayName("Test optimiseAll(List); when ArrayList(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List CountAllElementsOperationChainOptimiser.optimiseAll(List)"})
  void testOptimiseAll_whenArrayList_thenReturnEmpty() {
    // Arrange
    CountAllElementsOperationChainOptimiser countAllElementsOperationChainOptimiser =
        new CountAllElementsOperationChainOptimiser();

    // Act and Assert
    assertTrue(countAllElementsOperationChainOptimiser.optimiseAll(new ArrayList<>()).isEmpty());
  }

  /**
   * Test {@link CountAllElementsOperationChainOptimiser#equals(Object)}, and {@link
   * CountAllElementsOperationChainOptimiser#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CountAllElementsOperationChainOptimiser#equals(Object)}
   *   <li>{@link CountAllElementsOperationChainOptimiser#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CountAllElementsOperationChainOptimiser.equals(Object)",
    "int CountAllElementsOperationChainOptimiser.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    CountAllElementsOperationChainOptimiser countAllElementsOperationChainOptimiser =
        new CountAllElementsOperationChainOptimiser();
    CountAllElementsOperationChainOptimiser countAllElementsOperationChainOptimiser2 =
        new CountAllElementsOperationChainOptimiser();

    // Act and Assert
    assertEquals(countAllElementsOperationChainOptimiser, countAllElementsOperationChainOptimiser2);
    assertNotEquals(
        countAllElementsOperationChainOptimiser.hashCode(),
        countAllElementsOperationChainOptimiser2.hashCode());
  }

  /**
   * Test {@link CountAllElementsOperationChainOptimiser#equals(Object)}, and {@link
   * CountAllElementsOperationChainOptimiser#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CountAllElementsOperationChainOptimiser#equals(Object)}
   *   <li>{@link CountAllElementsOperationChainOptimiser#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CountAllElementsOperationChainOptimiser.equals(Object)",
    "int CountAllElementsOperationChainOptimiser.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    CountAllElementsOperationChainOptimiser countAllElementsOperationChainOptimiser =
        new CountAllElementsOperationChainOptimiser();

    // Act and Assert
    assertEquals(countAllElementsOperationChainOptimiser, countAllElementsOperationChainOptimiser);
    int expectedHashCodeResult = countAllElementsOperationChainOptimiser.hashCode();
    assertEquals(expectedHashCodeResult, countAllElementsOperationChainOptimiser.hashCode());
  }

  /**
   * Test {@link CountAllElementsOperationChainOptimiser#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CountAllElementsOperationChainOptimiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CountAllElementsOperationChainOptimiser.equals(Object)",
    "int CountAllElementsOperationChainOptimiser.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new CountAllElementsOperationChainOptimiser(), 1);
  }

  /**
   * Test {@link CountAllElementsOperationChainOptimiser#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CountAllElementsOperationChainOptimiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CountAllElementsOperationChainOptimiser.equals(Object)",
    "int CountAllElementsOperationChainOptimiser.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new CountAllElementsOperationChainOptimiser(), null);
  }

  /**
   * Test {@link CountAllElementsOperationChainOptimiser#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CountAllElementsOperationChainOptimiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CountAllElementsOperationChainOptimiser.equals(Object)",
    "int CountAllElementsOperationChainOptimiser.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new CountAllElementsOperationChainOptimiser(),
        "Different type to CountAllElementsOperationChainOptimiser");
  }
}
