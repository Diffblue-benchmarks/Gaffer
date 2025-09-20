package uk.gov.gchq.gaffer.accumulostore.key;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.core.exception.Status;

class AccumuloExceptionDiffblueTest {
  /**
   * Test {@link AccumuloException#AccumuloException(String)}.
   *
   * <p>Method under test: {@link AccumuloException#AccumuloException(String)}
   */
  @Test
  @DisplayName("Test new AccumuloException(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AccumuloException.<init>(String)"})
  void testNewAccumuloException() {
    // Arrange and Act
    AccumuloException actualAccumuloException = new AccumuloException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualAccumuloException.getLocalizedMessage());
    assertEquals("An error occurred", actualAccumuloException.getMessage());
    assertNull(actualAccumuloException.getCause());
    assertEquals(0, actualAccumuloException.getSuppressed().length);
    assertEquals(Status.INTERNAL_SERVER_ERROR, actualAccumuloException.getStatus());
  }

  /**
   * Test {@link AccumuloException#AccumuloException(String, Throwable)}.
   *
   * <p>Method under test: {@link AccumuloException#AccumuloException(String, Throwable)}
   */
  @Test
  @DisplayName("Test new AccumuloException(String, Throwable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AccumuloException.<init>(String, Throwable)"})
  void testNewAccumuloException2() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    AccumuloException actualAccumuloException = new AccumuloException("An error occurred", cause);

    // Assert
    assertEquals("An error occurred", actualAccumuloException.getLocalizedMessage());
    assertEquals("An error occurred", actualAccumuloException.getMessage());
    assertEquals(0, actualAccumuloException.getSuppressed().length);
    assertEquals(Status.INTERNAL_SERVER_ERROR, actualAccumuloException.getStatus());
    assertSame(cause, actualAccumuloException.getCause());
  }

  /**
   * Test {@link AccumuloException#AccumuloException(Throwable)}.
   *
   * <p>Method under test: {@link AccumuloException#AccumuloException(Throwable)}
   */
  @Test
  @DisplayName("Test new AccumuloException(Throwable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AccumuloException.<init>(Throwable)"})
  void testNewAccumuloException3() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    AccumuloException actualAccumuloException = new AccumuloException(cause);

    // Assert
    assertEquals("java.lang.Throwable", actualAccumuloException.getLocalizedMessage());
    assertEquals("java.lang.Throwable", actualAccumuloException.getMessage());
    assertEquals(0, actualAccumuloException.getSuppressed().length);
    assertEquals(Status.INTERNAL_SERVER_ERROR, actualAccumuloException.getStatus());
    assertSame(cause, actualAccumuloException.getCause());
  }
}
