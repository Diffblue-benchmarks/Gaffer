package uk.gov.gchq.gaffer.accumulostore.key.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.core.exception.Status;

class IteratorSettingExceptionDiffblueTest {
  /**
   * Test {@link IteratorSettingException#IteratorSettingException(String, Throwable)}.
   *
   * <p>Method under test: {@link IteratorSettingException#IteratorSettingException(String,
   * Throwable)}
   */
  @Test
  @DisplayName("Test new IteratorSettingException(String, Throwable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void IteratorSettingException.<init>(String, Throwable)"})
  void testNewIteratorSettingException() {
    // Arrange
    Throwable e = new Throwable();

    // Act
    IteratorSettingException actualIteratorSettingException =
        new IteratorSettingException("An error occurred", e);

    // Assert
    assertEquals("An error occurred", actualIteratorSettingException.getLocalizedMessage());
    assertEquals("An error occurred", actualIteratorSettingException.getMessage());
    assertEquals(0, actualIteratorSettingException.getSuppressed().length);
    assertEquals(Status.INTERNAL_SERVER_ERROR, actualIteratorSettingException.getStatus());
    assertSame(e, actualIteratorSettingException.getCause());
  }
}
