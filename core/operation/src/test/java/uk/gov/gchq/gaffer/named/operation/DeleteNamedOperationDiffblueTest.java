package uk.gov.gchq.gaffer.named.operation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.named.operation.DeleteNamedOperation.Builder;

class DeleteNamedOperationDiffblueTest {
  /**
   * Test Builder {@link Builder#name(String)}.
   *
   * <p>Method under test: {@link Builder#name(String)}
   */
  @Test
  @DisplayName("Test Builder name(String)")
  @Tag("MaintainedByDiffblue")
  void testBuilderName() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualNameResult = builder.name("Name");

    // Assert
    assertSame(builder, actualNameResult);
  }

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
    Builder actualBuilder = new Builder();

    // Assert
    DeleteNamedOperation _getOpResult = actualBuilder._getOp();
    assertNull(_getOpResult.getOperationName());
    assertNull(_getOpResult.getOptions());
    DeleteNamedOperation actualDeleteNamedOperation = actualBuilder.build();
    assertSame(_getOpResult, actualDeleteNamedOperation);
  }

  /**
   * Test {@link DeleteNamedOperation#shallowClone()}.
   *
   * <ul>
   *   <li>Given {@link DeleteNamedOperation} (default constructor).
   *   <li>Then return Options is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DeleteNamedOperation#shallowClone()}
   */
  @Test
  @DisplayName(
      "Test shallowClone(); given DeleteNamedOperation (default constructor); then return Options is 'null'")
  @Tag("MaintainedByDiffblue")
  void testShallowClone_givenDeleteNamedOperation_thenReturnOptionsIsNull() {
    // Arrange and Act
    DeleteNamedOperation actualShallowCloneResult = new DeleteNamedOperation().shallowClone();

    // Assert
    assertNull(actualShallowCloneResult.getOperationName());
    assertNull(actualShallowCloneResult.getOptions());
  }

  /**
   * Test {@link DeleteNamedOperation#shallowClone()}.
   *
   * <ul>
   *   <li>Then return Options Empty.
   * </ul>
   *
   * <p>Method under test: {@link DeleteNamedOperation#shallowClone()}
   */
  @Test
  @DisplayName("Test shallowClone(); then return Options Empty")
  @Tag("MaintainedByDiffblue")
  void testShallowClone_thenReturnOptionsEmpty() {
    // Arrange
    DeleteNamedOperation deleteNamedOperation = new DeleteNamedOperation();
    deleteNamedOperation.setOptions(new HashMap<>());

    // Act
    DeleteNamedOperation actualShallowCloneResult = deleteNamedOperation.shallowClone();

    // Assert
    assertNull(actualShallowCloneResult.getOperationName());
    assertTrue(actualShallowCloneResult.getOptions().isEmpty());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link DeleteNamedOperation}
   *   <li>{@link DeleteNamedOperation#setOperationName(String)}
   *   <li>{@link DeleteNamedOperation#setOptions(Map)}
   *   <li>{@link DeleteNamedOperation#getOperationName()}
   *   <li>{@link DeleteNamedOperation#getOptions()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  void testGettersAndSetters() {
    // Arrange and Act
    DeleteNamedOperation actualDeleteNamedOperation = new DeleteNamedOperation();
    actualDeleteNamedOperation.setOperationName("Operation Name");
    HashMap<String, String> options = new HashMap<>();
    actualDeleteNamedOperation.setOptions(options);
    String actualOperationName = actualDeleteNamedOperation.getOperationName();
    Map<String, String> actualOptions = actualDeleteNamedOperation.getOptions();

    // Assert
    assertEquals("Operation Name", actualOperationName);
    assertTrue(actualOptions.isEmpty());
    assertSame(options, actualOptions);
  }
}
