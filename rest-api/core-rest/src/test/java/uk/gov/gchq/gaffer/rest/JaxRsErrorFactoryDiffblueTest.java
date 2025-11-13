/*
 * Copyright 2025 Crown Copyright
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

package uk.gov.gchq.gaffer.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Error JaxRsErrorFactory.from(WebApplicationException)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Error JaxRsErrorFactory.from(WebApplicationException)"})
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
