package uk.gov.gchq.gaffer.operation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.named.operation.AddNamedOperation;

class OperationsDiffblueTest {
  /**
   * Test {@link Operations#getOperationsClass()}.
   *
   * <p>Method under test: {@link Operations#getOperationsClass()}
   */
  @Test
  @DisplayName("Test getOperationsClass()")
  @Tag("MaintainedByDiffblue")
  void testGetOperationsClass() {
    // Arrange and Act
    Class<Operation> actualOperationsClass = new AddNamedOperation().getOperationsClass();

    // Assert
    Class<Operation> expectedOperationsClass = Operation.class;
    assertEquals(expectedOperationsClass, actualOperationsClass);
  }

  /**
   * Test {@link Operations#flatten()}.
   *
   * <p>Method under test: {@link Operations#flatten()}
   */
  @Test
  @DisplayName("Test flatten()")
  @Tag("MaintainedByDiffblue")
  void testFlatten() {
    // Arrange, Act and Assert
    assertTrue(new AddNamedOperation().flatten().isEmpty());
  }
}
