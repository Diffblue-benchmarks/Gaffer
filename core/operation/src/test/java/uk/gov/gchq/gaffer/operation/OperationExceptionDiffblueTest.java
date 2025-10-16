package uk.gov.gchq.gaffer.operation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.core.exception.Status;

class OperationExceptionDiffblueTest {
  /**
   * Test {@link OperationException#OperationException(String)}.
   *
   * <p>Method under test: {@link OperationException#OperationException(String)}
   */
  @Test
  @DisplayName("Test new OperationException(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void OperationException.<init>(String)"})
  void testNewOperationException() {
    // Arrange and Act
    OperationException actualOperationException = new OperationException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualOperationException.getLocalizedMessage());
    assertEquals("An error occurred", actualOperationException.getMessage());
    assertNull(actualOperationException.getCause());
    assertEquals(0, actualOperationException.getSuppressed().length);
    assertEquals(Status.INTERNAL_SERVER_ERROR, actualOperationException.getStatus());
  }

  /**
   * Test {@link OperationException#OperationException(String, Throwable)}.
   *
   * <p>Method under test: {@link OperationException#OperationException(String, Throwable)}
   */
  @Test
  @DisplayName("Test new OperationException(String, Throwable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void OperationException.<init>(String, Throwable)"})
  void testNewOperationException2() {
    // Arrange
    Throwable e = new Throwable();

    // Act
    OperationException actualOperationException = new OperationException("An error occurred", e);

    // Assert
    assertEquals("An error occurred", actualOperationException.getLocalizedMessage());
    assertEquals("An error occurred", actualOperationException.getMessage());
    assertEquals(0, actualOperationException.getSuppressed().length);
    assertEquals(Status.INTERNAL_SERVER_ERROR, actualOperationException.getStatus());
    assertSame(e, actualOperationException.getCause());
  }

  /**
   * Test {@link OperationException#OperationException(String, Throwable, Status)}.
   *
   * <p>Method under test: {@link OperationException#OperationException(String, Throwable, Status)}
   */
  @Test
  @DisplayName("Test new OperationException(String, Throwable, Status)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void OperationException.<init>(String, Throwable, Status)"})
  void testNewOperationException3() {
    // Arrange
    Throwable e = new Throwable();

    // Act
    OperationException actualOperationException =
        new OperationException("An error occurred", e, Status.CONTINUE);

    // Assert
    assertEquals("An error occurred", actualOperationException.getLocalizedMessage());
    assertEquals("An error occurred", actualOperationException.getMessage());
    assertEquals(0, actualOperationException.getSuppressed().length);
    assertEquals(Status.CONTINUE, actualOperationException.getStatus());
    assertSame(e, actualOperationException.getCause());
  }

  /**
   * Test {@link OperationException#OperationException(String, Status)}.
   *
   * <p>Method under test: {@link OperationException#OperationException(String, Status)}
   */
  @Test
  @DisplayName("Test new OperationException(String, Status)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void OperationException.<init>(String, Status)"})
  void testNewOperationException4() {
    // Arrange and Act
    OperationException actualOperationException =
        new OperationException("An error occurred", Status.CONTINUE);

    // Assert
    assertEquals("An error occurred", actualOperationException.getLocalizedMessage());
    assertEquals("An error occurred", actualOperationException.getMessage());
    assertNull(actualOperationException.getCause());
    assertEquals(0, actualOperationException.getSuppressed().length);
    assertEquals(Status.CONTINUE, actualOperationException.getStatus());
  }

  /**
   * Test {@link OperationException#OperationException(Throwable)}.
   *
   * <p>Method under test: {@link OperationException#OperationException(Throwable)}
   */
  @Test
  @DisplayName("Test new OperationException(Throwable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void OperationException.<init>(Throwable)"})
  void testNewOperationException5() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    OperationException actualOperationException = new OperationException(cause);

    // Assert
    assertEquals("java.lang.Throwable", actualOperationException.getLocalizedMessage());
    assertEquals("java.lang.Throwable", actualOperationException.getMessage());
    assertEquals(0, actualOperationException.getSuppressed().length);
    assertEquals(Status.INTERNAL_SERVER_ERROR, actualOperationException.getStatus());
    assertSame(cause, actualOperationException.getCause());
  }
}
