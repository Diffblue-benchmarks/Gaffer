package uk.gov.gchq.gaffer.operation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.named.operation.AddNamedOperation;

class OperationChainDAODiffblueTest {
  /**
   * Test {@link OperationChainDAO#OperationChainDAO(OperationChain)}.
   *
   * <p>Method under test: {@link OperationChainDAO#OperationChainDAO(OperationChain)}
   */
  @Test
  @DisplayName("Test new OperationChainDAO(OperationChain)")
  @Tag("MaintainedByDiffblue")
  void testNewOperationChainDAO() {
    // Arrange
    OperationChain<?> operationChain = OperationChain.wrap(new AddNamedOperation());

    // Act
    OperationChainDAO<Object> actualOperationChainDAO = new OperationChainDAO<>(operationChain);

    // Assert
    assertEquals(operationChain, actualOperationChainDAO);
  }

  /**
   * Test {@link OperationChainDAO#OperationChainDAO(List)}.
   *
   * <ul>
   *   <li>Given {@link AddNamedOperation} (default constructor).
   *   <li>Then return array length is one.
   * </ul>
   *
   * <p>Method under test: {@link OperationChainDAO#OperationChainDAO(List)}
   */
  @Test
  @DisplayName(
      "Test new OperationChainDAO(List); given AddNamedOperation (default constructor); then return array length is one")
  @Tag("MaintainedByDiffblue")
  void testNewOperationChainDAO_givenAddNamedOperation_thenReturnArrayLengthIsOne() {
    // Arrange
    ArrayList<Operation> operations = new ArrayList<>();
    AddNamedOperation addNamedOperation = new AddNamedOperation();
    operations.add(addNamedOperation);

    // Act
    OperationChainDAO<Object> actualOperationChainDAO = new OperationChainDAO<>(operations);

    // Assert
    Operation[] operationArray = actualOperationChainDAO.getOperationArray();
    assertEquals(1, operationArray.length);
    assertEquals(operations, actualOperationChainDAO.getOperations());
    assertSame(addNamedOperation, operationArray[0]);
  }

  /**
   * Test {@link OperationChainDAO#OperationChainDAO(List)}.
   *
   * <ul>
   *   <li>Given {@link AddNamedOperation} (default constructor).
   *   <li>Then return Operations size is two.
   * </ul>
   *
   * <p>Method under test: {@link OperationChainDAO#OperationChainDAO(List)}
   */
  @Test
  @DisplayName(
      "Test new OperationChainDAO(List); given AddNamedOperation (default constructor); then return Operations size is two")
  @Tag("MaintainedByDiffblue")
  void testNewOperationChainDAO_givenAddNamedOperation_thenReturnOperationsSizeIsTwo() {
    // Arrange
    ArrayList<Operation> operations = new ArrayList<>();
    operations.add(new AddNamedOperation());
    AddNamedOperation addNamedOperation = new AddNamedOperation();
    operations.add(addNamedOperation);

    // Act
    OperationChainDAO<Object> actualOperationChainDAO = new OperationChainDAO<>(operations);

    // Assert
    List<Operation> operations2 = actualOperationChainDAO.getOperations();
    assertEquals(2, operations2.size());
    Operation[] operationArray = actualOperationChainDAO.getOperationArray();
    assertEquals(2, operationArray.length);
    assertSame(addNamedOperation, operations2.get(1));
    assertSame(addNamedOperation, operationArray[1]);
  }

  /**
   * Test {@link OperationChainDAO#getClassName()}.
   *
   * <p>Method under test: {@link OperationChainDAO#getClassName()}
   */
  @Test
  @DisplayName("Test getClassName()")
  @Tag("MaintainedByDiffblue")
  void testGetClassName() {
    // Arrange
    OperationChainDAO<Object> operationChainDAO = new OperationChainDAO<>();

    // Act and Assert
    assertNull(operationChainDAO.getClassName());
  }

  /**
   * Test {@link OperationChainDAO#setClassName(String)}.
   *
   * <ul>
   *   <li>When {@code Class Name}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link OperationChainDAO#setClassName(String)}
   */
  @Test
  @DisplayName("Test setClassName(String); when 'Class Name'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  void testSetClassName_whenClassName_thenThrowIllegalArgumentException() {
    // Arrange
    OperationChainDAO<Object> operationChainDAO = new OperationChainDAO<>();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> operationChainDAO.setClassName("Class Name"));
  }
}
