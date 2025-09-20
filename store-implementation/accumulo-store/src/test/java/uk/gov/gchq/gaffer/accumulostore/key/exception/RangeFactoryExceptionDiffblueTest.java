package uk.gov.gchq.gaffer.accumulostore.key.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.core.exception.Status;

class RangeFactoryExceptionDiffblueTest {
  /**
   * Test {@link RangeFactoryException#RangeFactoryException(String, Throwable)}.
   *
   * <p>Method under test: {@link RangeFactoryException#RangeFactoryException(String, Throwable)}
   */
  @Test
  @DisplayName("Test new RangeFactoryException(String, Throwable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RangeFactoryException.<init>(String, Throwable)"})
  void testNewRangeFactoryException() {
    // Arrange
    Throwable e = new Throwable();

    // Act
    RangeFactoryException actualRangeFactoryException =
        new RangeFactoryException("An error occurred", e);

    // Assert
    assertEquals("An error occurred", actualRangeFactoryException.getLocalizedMessage());
    assertEquals("An error occurred", actualRangeFactoryException.getMessage());
    assertEquals(0, actualRangeFactoryException.getSuppressed().length);
    assertEquals(Status.INTERNAL_SERVER_ERROR, actualRangeFactoryException.getStatus());
    assertSame(e, actualRangeFactoryException.getCause());
  }
}
