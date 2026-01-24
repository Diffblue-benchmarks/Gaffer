/*
 * Copyright 2026 Crown Copyright
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.gov.gchq.gaffer.rest.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.Response.StatusType;
import org.glassfish.jersey.message.internal.OutboundJaxrsResponse;
import org.glassfish.jersey.message.internal.OutboundMessageContext;
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
    Object entity = actualToResponseResult.getEntity();
    assertTrue(entity instanceof Error);
    OutboundMessageContext context = ((OutboundJaxrsResponse) actualToResponseResult).getContext();
    assertEquals(1, context.getAcceptableLanguages().size());
    assertEquals(1, actualToResponseResult.getStringHeaders().size());
    MultivaluedMap<String, String> stringHeaders = context.getStringHeaders();
    assertEquals(1, stringHeaders.size());
    assertEquals(100, actualToResponseResult.getStatus());
    assertEquals(100, ((Error) entity).getStatusCode());
    assertEquals(uk.gov.gchq.gaffer.core.exception.Status.CONTINUE, ((Error) entity).getStatus());
    assertTrue(stringHeaders.containsKey("X-Gaffer-Media-Type"));
    assertSame(entity, context.getEntity());
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
