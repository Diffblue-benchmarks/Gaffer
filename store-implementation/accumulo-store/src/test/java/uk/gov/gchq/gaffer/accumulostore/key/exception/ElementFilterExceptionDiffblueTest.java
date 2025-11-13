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

package uk.gov.gchq.gaffer.accumulostore.key.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ElementFilterExceptionDiffblueTest {
  /**
   * Test {@link ElementFilterException#ElementFilterException(String)}.
   * <ul>
   *   <li>When {@code An error occurred}.</li>
   *   <li>Then return Cause is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ElementFilterException#ElementFilterException(String)}
   */
  @Test
  @DisplayName("Test new ElementFilterException(String); when 'An error occurred'; then return Cause is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ElementFilterException.<init>(String)",
      "void ElementFilterException.<init>(String, Throwable)"})
  void testNewElementFilterException_whenAnErrorOccurred_thenReturnCauseIsNull() {
    // Arrange and Act
    ElementFilterException actualElementFilterException = new ElementFilterException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualElementFilterException.getMessage());
    assertNull(actualElementFilterException.getCause());
    assertEquals(0, actualElementFilterException.getSuppressed().length);
  }

  /**
   * Test {@link ElementFilterException#ElementFilterException(String, Throwable)}.
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.</li>
   *   <li>Then return Cause is {@link Throwable#Throwable()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ElementFilterException#ElementFilterException(String, Throwable)}
   */
  @Test
  @DisplayName("Test new ElementFilterException(String, Throwable); when Throwable(); then return Cause is Throwable()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ElementFilterException.<init>(String)",
      "void ElementFilterException.<init>(String, Throwable)"})
  void testNewElementFilterException_whenThrowable_thenReturnCauseIsThrowable() {
    // Arrange
    Throwable e = new Throwable();

    // Act
    ElementFilterException actualElementFilterException = new ElementFilterException("An error occurred", e);

    // Assert
    assertEquals("An error occurred", actualElementFilterException.getMessage());
    assertEquals(0, actualElementFilterException.getSuppressed().length);
    assertSame(e, actualElementFilterException.getCause());
  }
}
