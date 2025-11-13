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

package uk.gov.gchq.gaffer.accumulostore.key;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class AccumuloRuntimeExceptionDiffblueTest {
  /**
   * Test {@link AccumuloRuntimeException#AccumuloRuntimeException(String, Throwable)}.
   * <ul>
   *   <li>Then return Message is {@code An error occurred}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccumuloRuntimeException#AccumuloRuntimeException(String, Throwable)}
   */
  @Test
  @DisplayName("Test new AccumuloRuntimeException(String, Throwable); then return Message is 'An error occurred'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AccumuloRuntimeException.<init>(String)",
      "void AccumuloRuntimeException.<init>(String, Throwable)", "void AccumuloRuntimeException.<init>(Throwable)"})
  void testNewAccumuloRuntimeException_thenReturnMessageIsAnErrorOccurred() {
    // Arrange
    Throwable e = new Throwable();

    // Act
    AccumuloRuntimeException actualAccumuloRuntimeException = new AccumuloRuntimeException("An error occurred", e);

    // Assert
    assertEquals("An error occurred", actualAccumuloRuntimeException.getMessage());
    assertEquals(0, actualAccumuloRuntimeException.getSuppressed().length);
    assertSame(e, actualAccumuloRuntimeException.getCause());
  }

  /**
   * Test {@link AccumuloRuntimeException#AccumuloRuntimeException(Throwable)}.
   * <ul>
   *   <li>Then return Message is {@code Throwable}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccumuloRuntimeException#AccumuloRuntimeException(Throwable)}
   */
  @Test
  @DisplayName("Test new AccumuloRuntimeException(Throwable); then return Message is 'java.lang.Throwable'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AccumuloRuntimeException.<init>(String)",
      "void AccumuloRuntimeException.<init>(String, Throwable)", "void AccumuloRuntimeException.<init>(Throwable)"})
  void testNewAccumuloRuntimeException_thenReturnMessageIsJavaLangThrowable() {
    // Arrange
    Throwable e = new Throwable();

    // Act
    AccumuloRuntimeException actualAccumuloRuntimeException = new AccumuloRuntimeException(e);

    // Assert
    assertEquals("java.lang.Throwable", actualAccumuloRuntimeException.getMessage());
    assertEquals(0, actualAccumuloRuntimeException.getSuppressed().length);
    assertSame(e, actualAccumuloRuntimeException.getCause());
  }

  /**
   * Test {@link AccumuloRuntimeException#AccumuloRuntimeException(String)}.
   * <ul>
   *   <li>When {@code An error occurred}.</li>
   *   <li>Then return Cause is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccumuloRuntimeException#AccumuloRuntimeException(String)}
   */
  @Test
  @DisplayName("Test new AccumuloRuntimeException(String); when 'An error occurred'; then return Cause is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AccumuloRuntimeException.<init>(String)",
      "void AccumuloRuntimeException.<init>(String, Throwable)", "void AccumuloRuntimeException.<init>(Throwable)"})
  void testNewAccumuloRuntimeException_whenAnErrorOccurred_thenReturnCauseIsNull() {
    // Arrange and Act
    AccumuloRuntimeException actualAccumuloRuntimeException = new AccumuloRuntimeException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualAccumuloRuntimeException.getMessage());
    assertNull(actualAccumuloRuntimeException.getCause());
    assertEquals(0, actualAccumuloRuntimeException.getSuppressed().length);
  }
}
