package uk.gov.gchq.gaffer.data.elementdefinition.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.core.exception.Status;

class SchemaExceptionDiffblueTest {
  /**
   * Test {@link SchemaException#SchemaException(String)}.
   *
   * <p>Method under test: {@link SchemaException#SchemaException(String)}
   */
  @Test
  @DisplayName("Test new SchemaException(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SchemaException.<init>(String)"})
  void testNewSchemaException() {
    // Arrange and Act
    SchemaException actualSchemaException = new SchemaException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualSchemaException.getLocalizedMessage());
    assertEquals("An error occurred", actualSchemaException.getMessage());
    assertNull(actualSchemaException.getCause());
    assertEquals(0, actualSchemaException.getSuppressed().length);
    assertEquals(Status.BAD_REQUEST, actualSchemaException.getStatus());
  }

  /**
   * Test {@link SchemaException#SchemaException(String, Throwable)}.
   *
   * <p>Method under test: {@link SchemaException#SchemaException(String, Throwable)}
   */
  @Test
  @DisplayName("Test new SchemaException(String, Throwable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SchemaException.<init>(String, Throwable)"})
  void testNewSchemaException2() {
    // Arrange
    Throwable e = new Throwable();

    // Act
    SchemaException actualSchemaException = new SchemaException("An error occurred", e);

    // Assert
    assertEquals("An error occurred", actualSchemaException.getLocalizedMessage());
    assertEquals("An error occurred", actualSchemaException.getMessage());
    assertEquals(0, actualSchemaException.getSuppressed().length);
    assertEquals(Status.BAD_REQUEST, actualSchemaException.getStatus());
    assertSame(e, actualSchemaException.getCause());
  }

  /**
   * Test {@link SchemaException#getMessage()}.
   *
   * <p>Method under test: {@link SchemaException#getMessage()}
   */
  @Test
  @DisplayName("Test getMessage()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String SchemaException.getMessage()"})
  void testGetMessage() {
    // Arrange
    SchemaException schemaException = new SchemaException("An error occurred");

    // Act
    String actualMessage = schemaException.getMessage();

    // Assert
    assertEquals("An error occurred", schemaException.getLocalizedMessage());
    assertEquals("An error occurred", actualMessage);
  }
}
