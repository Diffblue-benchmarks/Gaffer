package uk.gov.gchq.gaffer.rest.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.Response.StatusType;
import org.glassfish.jersey.message.internal.OutboundJaxrsResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.core.exception.Error;
import uk.gov.gchq.gaffer.core.exception.GafferCheckedException;

class GafferCheckedExceptionMapperDiffblueTest {
  /**
   * Test {@link GafferCheckedExceptionMapper#toResponse(GafferCheckedException)} with {@code
   * GafferCheckedException}.
   *
   * <ul>
   *   <li>Then Entity return {@link Error}.
   * </ul>
   *
   * <p>Method under test: {@link GafferCheckedExceptionMapper#toResponse(GafferCheckedException)}
   */
  @Test
  @DisplayName(
      "Test toResponse(GafferCheckedException) with 'GafferCheckedException'; then Entity return Error")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Response GafferCheckedExceptionMapper.toResponse(GafferCheckedException)"})
  void testToResponseWithGafferCheckedException_thenEntityReturnError() {
    // Arrange
    GafferCheckedExceptionMapper gafferCheckedExceptionMapper = new GafferCheckedExceptionMapper();

    // Act
    Response actualToResponseResult =
        gafferCheckedExceptionMapper.toResponse(
            new GafferCheckedException(
                "An error occurred", uk.gov.gchq.gaffer.core.exception.Status.CONTINUE));

    // Assert
    assertTrue(actualToResponseResult instanceof OutboundJaxrsResponse);
    assertTrue(actualToResponseResult.getEntity() instanceof Error);
    MultivaluedMap<String, String> stringHeaders = actualToResponseResult.getStringHeaders();
    assertEquals(1, stringHeaders.size());
    assertEquals(100, actualToResponseResult.getStatus());
    assertTrue(stringHeaders.containsKey("X-Gaffer-Media-Type"));
  }

  /**
   * Test {@link GafferCheckedExceptionMapper#toResponse(GafferCheckedException)} with {@code
   * GafferCheckedException}.
   *
   * <ul>
   *   <li>Then StatusInfo return {@link Status}.
   * </ul>
   *
   * <p>Method under test: {@link GafferCheckedExceptionMapper#toResponse(GafferCheckedException)}
   */
  @Test
  @DisplayName(
      "Test toResponse(GafferCheckedException) with 'GafferCheckedException'; then StatusInfo return Status")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Response GafferCheckedExceptionMapper.toResponse(GafferCheckedException)"})
  void testToResponseWithGafferCheckedException_thenStatusInfoReturnStatus() {
    // Arrange
    GafferCheckedExceptionMapper gafferCheckedExceptionMapper = new GafferCheckedExceptionMapper();

    // Act
    Response actualToResponseResult =
        gafferCheckedExceptionMapper.toResponse(new GafferCheckedException("An error occurred"));

    // Assert
    StatusType statusInfo = actualToResponseResult.getStatusInfo();
    assertTrue(statusInfo instanceof Status);
    assertTrue(actualToResponseResult instanceof OutboundJaxrsResponse);
    assertEquals(500, actualToResponseResult.getStatus());
    assertEquals(Status.INTERNAL_SERVER_ERROR, statusInfo);
  }
}
