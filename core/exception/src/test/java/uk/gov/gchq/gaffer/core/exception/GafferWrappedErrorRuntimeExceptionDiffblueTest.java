package uk.gov.gchq.gaffer.core.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.core.exception.Error.ErrorBuilder;

class GafferWrappedErrorRuntimeExceptionDiffblueTest {
  /**
   * Test {@link GafferWrappedErrorRuntimeException#GafferWrappedErrorRuntimeException(Error)}.
   *
   * <p>Method under test: {@link
   * GafferWrappedErrorRuntimeException#GafferWrappedErrorRuntimeException(Error)}
   */
  @Test
  @DisplayName("Test new GafferWrappedErrorRuntimeException(Error)")
  @Tag("MaintainedByDiffblue")
  void testNewGafferWrappedErrorRuntimeException() {
    // Arrange
    Error error =
        new ErrorBuilder().detailMessage("Detail Message").simpleMessage("Simple Message").build();

    // Act
    GafferWrappedErrorRuntimeException actualGafferWrappedErrorRuntimeException =
        new GafferWrappedErrorRuntimeException(error);

    // Assert
    assertEquals("Simple Message", actualGafferWrappedErrorRuntimeException.getLocalizedMessage());
    assertEquals("Simple Message", actualGafferWrappedErrorRuntimeException.getMessage());
    assertNull(actualGafferWrappedErrorRuntimeException.getCause());
    assertEquals(0, actualGafferWrappedErrorRuntimeException.getSuppressed().length);
    assertSame(error, actualGafferWrappedErrorRuntimeException.getError());
  }

  /**
   * Test {@link GafferWrappedErrorRuntimeException#getError()}.
   *
   * <p>Method under test: {@link GafferWrappedErrorRuntimeException#getError()}
   */
  @Test
  @DisplayName("Test getError()")
  @Tag("MaintainedByDiffblue")
  void testGetError() {
    // Arrange
    Error error =
        new ErrorBuilder().detailMessage("Detail Message").simpleMessage("Simple Message").build();

    // Act
    Error actualError = new GafferWrappedErrorRuntimeException(error).getError();

    // Assert
    assertEquals("Simple Message", actualError.getSimpleMessage());
    assertNull(actualError.getDetailMessage());
    assertNull(actualError.getStatus());
    assertEquals(0, actualError.getStatusCode());
  }
}
