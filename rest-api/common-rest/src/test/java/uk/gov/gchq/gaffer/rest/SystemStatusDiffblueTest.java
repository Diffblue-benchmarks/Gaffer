package uk.gov.gchq.gaffer.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.rest.SystemStatus.Status;

class SystemStatusDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SystemStatus#SystemStatus(Status)}
   *   <li>{@link SystemStatus#toString()}
   *   <li>{@link SystemStatus#getStatus()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SystemStatus.<init>(Status)",
    "Status SystemStatus.getStatus()",
    "String SystemStatus.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    SystemStatus actualSystemStatus = new SystemStatus(Status.UP);
    actualSystemStatus.toString();

    // Assert
    assertEquals(Status.UP, actualSystemStatus.getStatus());
  }

  /**
   * Test {@link SystemStatus#equals(Object)}, and {@link SystemStatus#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SystemStatus#equals(Object)}
   *   <li>{@link SystemStatus#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SystemStatus.equals(Object)", "int SystemStatus.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    SystemStatus systemStatus = SystemStatus.DOWN;
    SystemStatus systemStatus2 = SystemStatus.DOWN;

    // Act and Assert
    assertEquals(systemStatus, systemStatus2);
    assertEquals(systemStatus.hashCode(), systemStatus2.hashCode());
  }

  /**
   * Test {@link SystemStatus#equals(Object)}, and {@link SystemStatus#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SystemStatus#equals(Object)}
   *   <li>{@link SystemStatus#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SystemStatus.equals(Object)", "int SystemStatus.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    SystemStatus systemStatus = SystemStatus.DOWN;

    // Act and Assert
    assertEquals(systemStatus, systemStatus);
    int expectedHashCodeResult = systemStatus.hashCode();
    assertEquals(expectedHashCodeResult, systemStatus.hashCode());
  }

  /**
   * Test {@link SystemStatus#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SystemStatus#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SystemStatus.equals(Object)", "int SystemStatus.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(SystemStatus.OUT_OF_SERVICE, SystemStatus.DOWN);
  }

  /**
   * Test {@link SystemStatus#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SystemStatus#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SystemStatus.equals(Object)", "int SystemStatus.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(SystemStatus.DOWN, null);
  }

  /**
   * Test {@link SystemStatus#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SystemStatus#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SystemStatus.equals(Object)", "int SystemStatus.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(SystemStatus.DOWN, "Different type to SystemStatus");
  }

  /**
   * Test Status getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Status#toString()}
   *   <li>{@link Status#getCode()}
   *   <li>{@link Status#getDescription()}
   * </ul>
   */
  @Test
  @DisplayName("Test Status getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String Status.getCode()",
    "String Status.getDescription()",
    "String Status.toString()"
  })
  void testStatusGettersAndSetters() {
    // Arrange
    Status valueOfResult = Status.valueOf("UP");

    // Act
    valueOfResult.toString();
    String actualCode = valueOfResult.getCode();

    // Assert
    assertEquals("The system is working normally.", valueOfResult.getDescription());
    assertEquals("UP", actualCode);
  }
}
