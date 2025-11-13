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
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GafferWrappedErrorRuntimeException.<init>(Error)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Error GafferWrappedErrorRuntimeException.getError()"})
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
