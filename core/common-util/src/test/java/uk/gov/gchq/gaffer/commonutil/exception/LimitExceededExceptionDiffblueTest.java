package uk.gov.gchq.gaffer.commonutil.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class LimitExceededExceptionDiffblueTest {
  /**
   * Test {@link LimitExceededException#LimitExceededException(String)}.
   *
   * <p>Method under test: {@link LimitExceededException#LimitExceededException(String)}
   */
  @Test
  @DisplayName("Test new LimitExceededException(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LimitExceededException.<init>(String)"})
  void testNewLimitExceededException() {
    // Arrange and Act
    LimitExceededException actualLimitExceededException =
        new LimitExceededException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualLimitExceededException.getMessage());
    assertNull(actualLimitExceededException.getCause());
    assertEquals(0, actualLimitExceededException.getSuppressed().length);
  }
}
