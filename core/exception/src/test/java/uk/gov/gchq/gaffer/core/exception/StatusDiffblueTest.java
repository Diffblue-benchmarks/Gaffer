package uk.gov.gchq.gaffer.core.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class StatusDiffblueTest {
  /**
   * Test {@link Status#fromStatusCode(int)}.
   *
   * <ul>
   *   <li>When one hundred.
   *   <li>Then return {@code CONTINUE}.
   * </ul>
   *
   * <p>Method under test: {@link Status#fromStatusCode(int)}
   */
  @Test
  @DisplayName("Test fromStatusCode(int); when one hundred; then return 'CONTINUE'")
  @Tag("MaintainedByDiffblue")
  void testFromStatusCode_whenOneHundred_thenReturnContinue() {
    // Arrange, Act and Assert
    assertEquals(Status.CONTINUE, Status.fromStatusCode(100));
  }

  /**
   * Test {@link Status#fromStatusCode(int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then throw {@link GafferRuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link Status#fromStatusCode(int)}
   */
  @Test
  @DisplayName("Test fromStatusCode(int); when one; then throw GafferRuntimeException")
  @Tag("MaintainedByDiffblue")
  void testFromStatusCode_whenOne_thenThrowGafferRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(GafferRuntimeException.class, () -> Status.fromStatusCode(1));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Status#toString()}
   *   <li>{@link Status#getReason()}
   *   <li>{@link Status#getStatusCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  void testGettersAndSetters() {
    // Arrange
    Status valueOfResult = Status.valueOf("CONTINUE");

    // Act
    String actualToStringResult = valueOfResult.toString();
    String actualReason = valueOfResult.getReason();

    // Assert
    assertEquals("Continue", actualReason);
    assertEquals("Status[Continue]", actualToStringResult);
    assertEquals(100, valueOfResult.getStatusCode());
  }
}
