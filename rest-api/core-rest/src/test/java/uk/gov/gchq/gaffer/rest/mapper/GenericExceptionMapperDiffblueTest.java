package uk.gov.gchq.gaffer.rest.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Set;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.Response.StatusType;
import org.glassfish.jersey.message.internal.OutboundJaxrsResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.core.exception.Error;

class GenericExceptionMapperDiffblueTest {
  /**
   * Test {@link GenericExceptionMapper#toResponse(Exception)} with {@code Exception}.
   *
   * <ul>
   *   <li>When {@link Exception#Exception()}.
   *   <li>Then StatusInfo return {@link Status}.
   * </ul>
   *
   * <p>Method under test: {@link GenericExceptionMapper#toResponse(Exception)}
   */
  @Test
  @DisplayName(
      "Test toResponse(Exception) with 'Exception'; when Exception(); then StatusInfo return Status")
  @Tag("MaintainedByDiffblue")
  void testToResponseWithException_whenException_thenStatusInfoReturnStatus() {
    // Arrange
    GenericExceptionMapper genericExceptionMapper = new GenericExceptionMapper();

    // Act
    Response actualToResponseResult = genericExceptionMapper.toResponse(new Exception());

    // Assert
    StatusType statusInfo = actualToResponseResult.getStatusInfo();
    assertTrue(statusInfo instanceof Status);
    assertTrue(actualToResponseResult instanceof OutboundJaxrsResponse);
    assertTrue(actualToResponseResult.getEntity() instanceof Error);
    assertNull(actualToResponseResult.getLocation());
    assertNull(actualToResponseResult.getDate());
    assertNull(actualToResponseResult.getLastModified());
    assertNull(actualToResponseResult.getLanguage());
    assertNull(actualToResponseResult.getEntityTag());
    assertNull(actualToResponseResult.getMediaType());
    assertEquals(-1, actualToResponseResult.getLength());
    MultivaluedMap<String, Object> headers = actualToResponseResult.getHeaders();
    assertEquals(1, headers.size());
    MultivaluedMap<String, String> stringHeaders = actualToResponseResult.getStringHeaders();
    assertEquals(1, stringHeaders.size());
    assertEquals(500, actualToResponseResult.getStatus());
    assertEquals(Status.INTERNAL_SERVER_ERROR, statusInfo);
    assertTrue(headers.containsKey("X-Gaffer-Media-Type"));
    assertTrue(stringHeaders.containsKey("X-Gaffer-Media-Type"));
    assertTrue(actualToResponseResult.getCookies().isEmpty());
    Set<String> allowedMethods = actualToResponseResult.getAllowedMethods();
    assertTrue(allowedMethods.isEmpty());
    assertSame(allowedMethods, actualToResponseResult.getLinks());
    assertSame(headers, actualToResponseResult.getMetadata());
  }
}
