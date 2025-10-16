package uk.gov.gchq.gaffer.store.schema.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.core.exception.Status;

class VisibilityPropertySchemaExceptionDiffblueTest {
  /**
   * Test {@link VisibilityPropertySchemaException#VisibilityPropertySchemaException(String,
   * String)}.
   *
   * <p>Method under test: {@link
   * VisibilityPropertySchemaException#VisibilityPropertySchemaException(String, String)}
   */
  @Test
  @DisplayName("Test new VisibilityPropertySchemaException(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void VisibilityPropertySchemaException.<init>(String, String)"})
  void testNewVisibilityPropertySchemaException() {
    // Arrange and Act
    VisibilityPropertySchemaException actualVisibilityPropertySchemaException =
        new VisibilityPropertySchemaException(
            "This Visibility Property", "That Visibility Property");

    // Assert
    assertEquals(
        "Unable to merge schemas because of conflict with the visibility property, options are: This Visibility"
            + " Property and That Visibility Property",
        actualVisibilityPropertySchemaException.getLocalizedMessage());
    assertEquals(
        "Unable to merge schemas because of conflict with the visibility property, options are: This Visibility"
            + " Property and That Visibility Property",
        actualVisibilityPropertySchemaException.getMessage());
    assertNull(actualVisibilityPropertySchemaException.getCause());
    assertEquals(0, actualVisibilityPropertySchemaException.getSuppressed().length);
    assertEquals(Status.BAD_REQUEST, actualVisibilityPropertySchemaException.getStatus());
  }

  /**
   * Test {@link VisibilityPropertySchemaException#VisibilityPropertySchemaException(String,
   * Throwable)}.
   *
   * <p>Method under test: {@link
   * VisibilityPropertySchemaException#VisibilityPropertySchemaException(String, Throwable)}
   */
  @Test
  @DisplayName("Test new VisibilityPropertySchemaException(String, Throwable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void VisibilityPropertySchemaException.<init>(String, Throwable)"})
  void testNewVisibilityPropertySchemaException2() {
    // Arrange
    Throwable e = new Throwable();

    // Act
    VisibilityPropertySchemaException actualVisibilityPropertySchemaException =
        new VisibilityPropertySchemaException("An error occurred", e);

    // Assert
    assertEquals(
        "An error occurred", actualVisibilityPropertySchemaException.getLocalizedMessage());
    assertEquals("An error occurred", actualVisibilityPropertySchemaException.getMessage());
    assertEquals(0, actualVisibilityPropertySchemaException.getSuppressed().length);
    assertEquals(Status.BAD_REQUEST, actualVisibilityPropertySchemaException.getStatus());
    assertSame(e, actualVisibilityPropertySchemaException.getCause());
  }
}
