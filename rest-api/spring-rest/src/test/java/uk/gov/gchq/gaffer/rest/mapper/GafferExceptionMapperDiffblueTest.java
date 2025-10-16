package uk.gov.gchq.gaffer.rest.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import uk.gov.gchq.gaffer.commonutil.exception.UnauthorisedException;
import uk.gov.gchq.gaffer.core.exception.Error;
import uk.gov.gchq.gaffer.core.exception.Error.ErrorBuilder;
import uk.gov.gchq.gaffer.core.exception.GafferRuntimeException;
import uk.gov.gchq.gaffer.core.exception.GafferWrappedErrorRuntimeException;
import uk.gov.gchq.gaffer.core.exception.Status;

@ContextConfiguration(classes = {GafferExceptionMapper.class})
@ExtendWith(SpringExtension.class)
class GafferExceptionMapperDiffblueTest {
  @Autowired private GafferExceptionMapper gafferExceptionMapper;

  /**
   * Test {@link GafferExceptionMapper#handleGafferRuntimeException(HttpServletRequest,
   * GafferRuntimeException)}.
   *
   * <p>Method under test: {@link
   * GafferExceptionMapper#handleGafferRuntimeException(HttpServletRequest, GafferRuntimeException)}
   */
  @Test
  @DisplayName("Test handleGafferRuntimeException(HttpServletRequest, GafferRuntimeException)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ResponseEntity GafferExceptionMapper.handleGafferRuntimeException(HttpServletRequest, GafferRuntimeException)"
  })
  void testHandleGafferRuntimeException() {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();

    GafferRuntimeException gre = mock(GafferRuntimeException.class);
    doNothing().when(gre).printStackTrace(Mockito.<PrintWriter>any());
    when(gre.getMessage()).thenReturn("Not all who wander are lost");
    when(gre.getStatus()).thenReturn(Status.CONTINUE);

    // Act
    ResponseEntity<?> actualHandleGafferRuntimeExceptionResult =
        gafferExceptionMapper.handleGafferRuntimeException(request, gre);

    // Assert
    verify(gre, atLeast(1)).getMessage();
    verify(gre).printStackTrace(isA(PrintWriter.class));
    verify(gre).getStatus();
    Object body = actualHandleGafferRuntimeExceptionResult.getBody();
    assertTrue(body instanceof Error);
    assertEquals("Not all who wander are lost", ((Error) body).getSimpleMessage());
    assertEquals(100, actualHandleGafferRuntimeExceptionResult.getStatusCodeValue());
    assertEquals(100, ((Error) body).getStatusCode());
    assertEquals(HttpStatus.CONTINUE, actualHandleGafferRuntimeExceptionResult.getStatusCode());
    assertEquals(Status.CONTINUE, ((Error) body).getStatus());
  }

  /**
   * Test {@link GafferExceptionMapper#handleGafferRuntimeException(HttpServletRequest,
   * GafferRuntimeException)}.
   *
   * <ul>
   *   <li>Then return Body SimpleMessage is {@code An error occurred}.
   * </ul>
   *
   * <p>Method under test: {@link
   * GafferExceptionMapper#handleGafferRuntimeException(HttpServletRequest, GafferRuntimeException)}
   */
  @Test
  @DisplayName(
      "Test handleGafferRuntimeException(HttpServletRequest, GafferRuntimeException); then return Body SimpleMessage is 'An error occurred'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ResponseEntity GafferExceptionMapper.handleGafferRuntimeException(HttpServletRequest, GafferRuntimeException)"
  })
  void testHandleGafferRuntimeException_thenReturnBodySimpleMessageIsAnErrorOccurred() {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();

    // Act
    ResponseEntity<?> actualHandleGafferRuntimeExceptionResult =
        gafferExceptionMapper.handleGafferRuntimeException(
            request, new GafferRuntimeException("An error occurred"));

    // Assert
    Object body = actualHandleGafferRuntimeExceptionResult.getBody();
    assertTrue(body instanceof Error);
    assertEquals("An error occurred", ((Error) body).getSimpleMessage());
    assertEquals(500, actualHandleGafferRuntimeExceptionResult.getStatusCodeValue());
    assertEquals(500, ((Error) body).getStatusCode());
    assertEquals(
        HttpStatus.INTERNAL_SERVER_ERROR, actualHandleGafferRuntimeExceptionResult.getStatusCode());
    assertEquals(Status.INTERNAL_SERVER_ERROR, ((Error) body).getStatus());
  }

  /**
   * Test {@link GafferExceptionMapper#handleUnauthorisedException(HttpServletRequest,
   * UnauthorisedException)}.
   *
   * <ul>
   *   <li>Then Body return {@link Error}.
   * </ul>
   *
   * <p>Method under test: {@link
   * GafferExceptionMapper#handleUnauthorisedException(HttpServletRequest, UnauthorisedException)}
   */
  @Test
  @DisplayName(
      "Test handleUnauthorisedException(HttpServletRequest, UnauthorisedException); then Body return Error")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ResponseEntity GafferExceptionMapper.handleUnauthorisedException(HttpServletRequest, UnauthorisedException)"
  })
  void testHandleUnauthorisedException_thenBodyReturnError() {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();

    // Act
    ResponseEntity<?> actualHandleUnauthorisedExceptionResult =
        gafferExceptionMapper.handleUnauthorisedException(
            request, new UnauthorisedException("An error occurred"));

    // Assert
    Object body = actualHandleUnauthorisedExceptionResult.getBody();
    assertTrue(body instanceof Error);
    assertEquals("An error occurred", ((Error) body).getSimpleMessage());
    assertNull(((Error) body).getDetailMessage());
    assertEquals(403, actualHandleUnauthorisedExceptionResult.getStatusCodeValue());
    assertEquals(403, ((Error) body).getStatusCode());
    assertEquals(HttpStatus.FORBIDDEN, actualHandleUnauthorisedExceptionResult.getStatusCode());
    assertEquals(Status.FORBIDDEN, ((Error) body).getStatus());
    assertTrue(actualHandleUnauthorisedExceptionResult.hasBody());
    assertTrue(actualHandleUnauthorisedExceptionResult.getHeaders().isEmpty());
  }

  /**
   * Test {@link GafferExceptionMapper#handleGafferWrappedErrorRuntimeException(HttpServletRequest,
   * GafferWrappedErrorRuntimeException)}.
   *
   * <ul>
   *   <li>Then Body return {@link Error}.
   * </ul>
   *
   * <p>Method under test: {@link
   * GafferExceptionMapper#handleGafferWrappedErrorRuntimeException(HttpServletRequest,
   * GafferWrappedErrorRuntimeException)}
   */
  @Test
  @DisplayName(
      "Test handleGafferWrappedErrorRuntimeException(HttpServletRequest, GafferWrappedErrorRuntimeException); then Body return Error")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ResponseEntity GafferExceptionMapper.handleGafferWrappedErrorRuntimeException(HttpServletRequest, GafferWrappedErrorRuntimeException)"
  })
  void testHandleGafferWrappedErrorRuntimeException_thenBodyReturnError() {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();
    Error error =
        new ErrorBuilder().detailMessage("Detail Message").simpleMessage("Simple Message").build();

    // Act
    ResponseEntity<?> actualHandleGafferWrappedErrorRuntimeExceptionResult =
        gafferExceptionMapper.handleGafferWrappedErrorRuntimeException(
            request, new GafferWrappedErrorRuntimeException(error));

    // Assert
    Object body = actualHandleGafferWrappedErrorRuntimeExceptionResult.getBody();
    assertTrue(body instanceof Error);
    assertEquals("Simple Message", ((Error) body).getSimpleMessage());
    assertNull(((Error) body).getDetailMessage());
    assertNull(((Error) body).getStatus());
    assertEquals(0, actualHandleGafferWrappedErrorRuntimeExceptionResult.getStatusCodeValue());
    assertEquals(0, ((Error) body).getStatusCode());
    assertTrue(actualHandleGafferWrappedErrorRuntimeExceptionResult.hasBody());
    assertTrue(actualHandleGafferWrappedErrorRuntimeExceptionResult.getHeaders().isEmpty());
  }

  /**
   * Test {@link GafferExceptionMapper#handleHttpMessageNotReadable(HttpMessageNotReadableException,
   * HttpHeaders, HttpStatus, WebRequest)}.
   *
   * <ul>
   *   <li>Then Body return {@link Error}.
   * </ul>
   *
   * <p>Method under test: {@link
   * GafferExceptionMapper#handleHttpMessageNotReadable(HttpMessageNotReadableException,
   * HttpHeaders, HttpStatus, WebRequest)}
   */
  @Test
  @DisplayName(
      "Test handleHttpMessageNotReadable(HttpMessageNotReadableException, HttpHeaders, HttpStatus, WebRequest); then Body return Error")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ResponseEntity GafferExceptionMapper.handleHttpMessageNotReadable(HttpMessageNotReadableException, HttpHeaders, HttpStatus, WebRequest)"
  })
  void testHandleHttpMessageNotReadable_thenBodyReturnError() {
    // Arrange
    HttpMessageNotReadableException ex =
        new HttpMessageNotReadableException("https://example.org/example");
    HttpHeaders headers = new HttpHeaders();

    // Act
    ResponseEntity<Object> actualHandleHttpMessageNotReadableResult =
        gafferExceptionMapper.handleHttpMessageNotReadable(
            ex, headers, HttpStatus.OK, new ServletWebRequest(new MockHttpServletRequest()));

    // Assert
    Object body = actualHandleHttpMessageNotReadableResult.getBody();
    assertTrue(body instanceof Error);
    assertEquals("https://example.org/example", ((Error) body).getSimpleMessage());
    assertNull(((Error) body).getDetailMessage());
    assertEquals(400, actualHandleHttpMessageNotReadableResult.getStatusCodeValue());
    assertEquals(400, ((Error) body).getStatusCode());
    assertEquals(HttpStatus.BAD_REQUEST, actualHandleHttpMessageNotReadableResult.getStatusCode());
    assertEquals(Status.BAD_REQUEST, ((Error) body).getStatus());
    assertTrue(actualHandleHttpMessageNotReadableResult.hasBody());
    assertEquals(headers, actualHandleHttpMessageNotReadableResult.getHeaders());
  }

  /**
   * Test {@link GafferExceptionMapper#handleAllOtherTypesOfException(HttpServletRequest,
   * Exception)}.
   *
   * <ul>
   *   <li>When {@link Exception#Exception()}.
   *   <li>Then Body return {@link Error}.
   * </ul>
   *
   * <p>Method under test: {@link
   * GafferExceptionMapper#handleAllOtherTypesOfException(HttpServletRequest, Exception)}
   */
  @Test
  @DisplayName(
      "Test handleAllOtherTypesOfException(HttpServletRequest, Exception); when Exception(); then Body return Error")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ResponseEntity GafferExceptionMapper.handleAllOtherTypesOfException(HttpServletRequest, Exception)"
  })
  void testHandleAllOtherTypesOfException_whenException_thenBodyReturnError() {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();

    // Act
    ResponseEntity<?> actualHandleAllOtherTypesOfExceptionResult =
        gafferExceptionMapper.handleAllOtherTypesOfException(request, new Exception());

    // Assert
    Object body = actualHandleAllOtherTypesOfExceptionResult.getBody();
    assertTrue(body instanceof Error);
    assertNull(((Error) body).getDetailMessage());
    assertNull(((Error) body).getSimpleMessage());
    assertEquals(500, actualHandleAllOtherTypesOfExceptionResult.getStatusCodeValue());
    assertEquals(500, ((Error) body).getStatusCode());
    assertEquals(
        HttpStatus.INTERNAL_SERVER_ERROR,
        actualHandleAllOtherTypesOfExceptionResult.getStatusCode());
    assertEquals(Status.INTERNAL_SERVER_ERROR, ((Error) body).getStatus());
    assertTrue(actualHandleAllOtherTypesOfExceptionResult.hasBody());
    assertTrue(actualHandleAllOtherTypesOfExceptionResult.getHeaders().isEmpty());
  }
}
