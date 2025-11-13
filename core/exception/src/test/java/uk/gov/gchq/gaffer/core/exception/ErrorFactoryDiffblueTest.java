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

package uk.gov.gchq.gaffer.core.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.commonutil.exception.UnauthorisedException;
import uk.gov.gchq.gaffer.core.exception.Error.ErrorBuilder;

class ErrorFactoryDiffblueTest {
  /**
   * Test {@link ErrorFactory#from(Exception)} with {@code Exception}.
   * <ul>
   *   <li>When {@link Exception#Exception(String)} with {@code foo}.</li>
   *   <li>Then return SimpleMessage is {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ErrorFactory#from(Exception)}
   */
  @Test
  @DisplayName("Test from(Exception) with 'Exception'; when Exception(String) with 'foo'; then return SimpleMessage is 'foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Error ErrorFactory.from(Exception)"})
  void testFromWithException_whenExceptionWithFoo_thenReturnSimpleMessageIsFoo() {
    // Arrange and Act
    Error actualFromResult = ErrorFactory.from(new Exception("foo"));

    // Assert
    assertEquals("foo", actualFromResult.getSimpleMessage());
    assertNull(actualFromResult.getDetailMessage());
    assertEquals(500, actualFromResult.getStatusCode());
    assertEquals(Status.INTERNAL_SERVER_ERROR, actualFromResult.getStatus());
  }

  /**
   * Test {@link ErrorFactory#from(GafferCheckedException)} with {@code GafferCheckedException}.
   * <ul>
   *   <li>Then return SimpleMessage is {@code An error occurred}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ErrorFactory#from(GafferCheckedException)}
   */
  @Test
  @DisplayName("Test from(GafferCheckedException) with 'GafferCheckedException'; then return SimpleMessage is 'An error occurred'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Error ErrorFactory.from(GafferCheckedException)"})
  void testFromWithGafferCheckedException_thenReturnSimpleMessageIsAnErrorOccurred() {
    // Arrange and Act
    Error actualFromResult = ErrorFactory.from(new GafferCheckedException("An error occurred"));

    // Assert
    assertEquals("An error occurred", actualFromResult.getSimpleMessage());
    assertNull(actualFromResult.getDetailMessage());
    assertEquals(500, actualFromResult.getStatusCode());
    assertEquals(Status.INTERNAL_SERVER_ERROR, actualFromResult.getStatus());
  }

  /**
   * Test {@link ErrorFactory#from(GafferRuntimeException)} with {@code GafferRuntimeException}.
   * <ul>
   *   <li>Then return SimpleMessage is {@code An error occurred}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ErrorFactory#from(GafferRuntimeException)}
   */
  @Test
  @DisplayName("Test from(GafferRuntimeException) with 'GafferRuntimeException'; then return SimpleMessage is 'An error occurred'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Error ErrorFactory.from(GafferRuntimeException)"})
  void testFromWithGafferRuntimeException_thenReturnSimpleMessageIsAnErrorOccurred() {
    // Arrange and Act
    Error actualFromResult = ErrorFactory.from(new GafferRuntimeException("An error occurred"));

    // Assert
    assertEquals("An error occurred", actualFromResult.getSimpleMessage());
    assertNull(actualFromResult.getDetailMessage());
    assertEquals(500, actualFromResult.getStatusCode());
    assertEquals(Status.INTERNAL_SERVER_ERROR, actualFromResult.getStatus());
  }

  /**
   * Test {@link ErrorFactory#from(GafferWrappedErrorRuntimeException)} with {@code GafferWrappedErrorRuntimeException}.
   * <ul>
   *   <li>Then return {@code Simple Message}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ErrorFactory#from(GafferWrappedErrorRuntimeException)}
   */
  @Test
  @DisplayName("Test from(GafferWrappedErrorRuntimeException) with 'GafferWrappedErrorRuntimeException'; then return 'Simple Message'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Error ErrorFactory.from(GafferWrappedErrorRuntimeException)"})
  void testFromWithGafferWrappedErrorRuntimeException_thenReturnSimpleMessage() {
    // Arrange
    Error error = (new ErrorBuilder()).detailMessage("Detail Message").simpleMessage("Simple Message").build();

    // Act
    Error actualFromResult = ErrorFactory.from(new GafferWrappedErrorRuntimeException(error));

    // Assert
    assertEquals("Simple Message", actualFromResult.getSimpleMessage());
    assertNull(actualFromResult.getDetailMessage());
    assertNull(actualFromResult.getStatus());
    assertEquals(0, actualFromResult.getStatusCode());
  }

  /**
   * Test {@link ErrorFactory#from(UnauthorisedException)} with {@code UnauthorisedException}.
   * <ul>
   *   <li>Then return SimpleMessage is {@code An error occurred}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ErrorFactory#from(UnauthorisedException)}
   */
  @Test
  @DisplayName("Test from(UnauthorisedException) with 'UnauthorisedException'; then return SimpleMessage is 'An error occurred'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Error ErrorFactory.from(UnauthorisedException)"})
  void testFromWithUnauthorisedException_thenReturnSimpleMessageIsAnErrorOccurred() {
    // Arrange and Act
    Error actualFromResult = ErrorFactory.from(new UnauthorisedException("An error occurred"));

    // Assert
    assertEquals("An error occurred", actualFromResult.getSimpleMessage());
    assertNull(actualFromResult.getDetailMessage());
    assertEquals(403, actualFromResult.getStatusCode());
    assertEquals(Status.FORBIDDEN, actualFromResult.getStatus());
  }
}
