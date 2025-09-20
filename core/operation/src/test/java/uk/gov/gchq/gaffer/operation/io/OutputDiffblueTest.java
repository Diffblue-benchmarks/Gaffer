package uk.gov.gchq.gaffer.operation.io;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.named.operation.GetAllNamedOperations;

class OutputDiffblueTest {
  /**
   * Test {@link Output#castToOutputType(Object)}.
   *
   * <ul>
   *   <li>Then return {@code Result}.
   * </ul>
   *
   * <p>Method under test: {@link Output#castToOutputType(Object)}
   */
  @Test
  @DisplayName("Test castToOutputType(Object); then return 'Result'")
  @Tag("MaintainedByDiffblue")
  void testCastToOutputType_thenReturnResult() {
    // Arrange, Act and Assert
    assertEquals("Result", new GetAllNamedOperations().castToOutputType("Result"));
  }

  /**
   * Test {@link Output#getOutputClass()}.
   *
   * <p>Method under test: {@link Output#getOutputClass()}
   */
  @Test
  @DisplayName("Test getOutputClass()")
  @Tag("MaintainedByDiffblue")
  void testGetOutputClass() {
    // Arrange and Act
    Class<?> actualOutputClass = new GetAllNamedOperations().getOutputClass();

    // Assert
    Class<Iterable> expectedOutputClass = Iterable.class;
    assertEquals(expectedOutputClass, actualOutputClass);
  }

  /**
   * Test {@link Output#getOutputType()}.
   *
   * <p>Method under test: {@link Output#getOutputType()}
   */
  @Test
  @DisplayName("Test getOutputType()")
  @Tag("MaintainedByDiffblue")
  void testGetOutputType() {
    // Arrange, Act and Assert
    assertEquals(
        "java.lang.Iterable<uk.gov.gchq.gaffer.named.operation.NamedOperationDetail>",
        new GetAllNamedOperations().getOutputType().getTypeName());
  }
}
