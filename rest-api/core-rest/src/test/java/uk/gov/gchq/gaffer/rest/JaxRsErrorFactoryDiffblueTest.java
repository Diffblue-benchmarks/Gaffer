package uk.gov.gchq.gaffer.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import javax.ws.rs.WebApplicationException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.core.exception.Error;
import uk.gov.gchq.gaffer.core.exception.Status;

class JaxRsErrorFactoryDiffblueTest {
  /**
   * Test {@link JaxRsErrorFactory#from(WebApplicationException)}.
   *
   * <ul>
   *   <li>Then return SimpleMessage is {@code An error occurred}.
   * </ul>
   *
   * <p>Method under test: {@link JaxRsErrorFactory#from(WebApplicationException)}
   */
  @Test
  @DisplayName(
      "Test from(WebApplicationException); then return SimpleMessage is 'An error occurred'")
  @Tag("MaintainedByDiffblue")
  void testFrom_thenReturnSimpleMessageIsAnErrorOccurred() {
    // Arrange and Act
    Error actualFromResult =
        JaxRsErrorFactory.from(new WebApplicationException("An error occurred"));

    // Assert
    assertEquals("An error occurred", actualFromResult.getSimpleMessage());
    assertNull(actualFromResult.getDetailMessage());
    assertEquals(500, actualFromResult.getStatusCode());
    assertEquals(Status.INTERNAL_SERVER_ERROR, actualFromResult.getStatus());
  }

  /**
   * Test {@link JaxRsErrorFactory#from(WebApplicationException)}.
   *
   * <ul>
   *   <li>Then return SimpleMessage is {@code HTTP 500 Internal Server Error}.
   * </ul>
   *
   * <p>Method under test: {@link JaxRsErrorFactory#from(WebApplicationException)}
   */
  @Test
  @DisplayName(
      "Test from(WebApplicationException); then return SimpleMessage is 'HTTP 500 Internal Server Error'")
  @Tag("MaintainedByDiffblue")
  void testFrom_thenReturnSimpleMessageIsHttp500InternalServerError() {
    // Arrange and Act
    Error actualFromResult = JaxRsErrorFactory.from(new WebApplicationException());

    // Assert
    assertEquals("HTTP 500 Internal Server Error", actualFromResult.getSimpleMessage());
    assertNull(actualFromResult.getDetailMessage());
    assertEquals(500, actualFromResult.getStatusCode());
    assertEquals(Status.INTERNAL_SERVER_ERROR, actualFromResult.getStatus());
  }
}
