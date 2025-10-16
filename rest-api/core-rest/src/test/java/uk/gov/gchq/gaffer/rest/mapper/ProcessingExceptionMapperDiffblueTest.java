package uk.gov.gchq.gaffer.rest.mapper;

import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import javax.ws.rs.ProcessingException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.core.exception.GafferRuntimeException;

class ProcessingExceptionMapperDiffblueTest {
  /**
   * Test {@link ProcessingExceptionMapper#toResponse(ProcessingException)} with {@code
   * ProcessingException}.
   *
   * <p>Method under test: {@link ProcessingExceptionMapper#toResponse(ProcessingException)}
   */
  @Test
  @DisplayName("Test toResponse(ProcessingException) with 'ProcessingException'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "javax.ws.rs.core.Response ProcessingExceptionMapper.toResponse(ProcessingException)"
  })
  void testToResponseWithProcessingException() {
    // Arrange
    ProcessingExceptionMapper processingExceptionMapper = new ProcessingExceptionMapper();

    // Act and Assert
    assertThrows(
        GafferRuntimeException.class,
        () -> processingExceptionMapper.toResponse(new ProcessingException("An error occurred")));
  }
}
