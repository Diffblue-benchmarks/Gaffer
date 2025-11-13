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

class IteratorExceptionDiffblueTest {
  /**
   * Test {@link IteratorException#IteratorException(String)}.
   * <ul>
   *   <li>When {@code An error occurred}.</li>
   *   <li>Then return Cause is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IteratorException#IteratorException(String)}
   */
  @Test
  @DisplayName("Test new IteratorException(String); when 'An error occurred'; then return Cause is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void IteratorException.<init>(String)", "void IteratorException.<init>(String, Throwable)",
      "void IteratorException.<init>(Throwable)"})
  void testNewIteratorException_whenAnErrorOccurred_thenReturnCauseIsNull() {
    // Arrange and Act
    IteratorException actualIteratorException = new IteratorException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualIteratorException.getMessage());
    assertNull(actualIteratorException.getCause());
    assertEquals(0, actualIteratorException.getSuppressed().length);
  }

  /**
   * Test {@link IteratorException#IteratorException(String, Throwable)}.
   * <ul>
   *   <li>When {@code An error occurred}.</li>
   *   <li>Then return Message is {@code An error occurred}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IteratorException#IteratorException(String, Throwable)}
   */
  @Test
  @DisplayName("Test new IteratorException(String, Throwable); when 'An error occurred'; then return Message is 'An error occurred'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void IteratorException.<init>(String)", "void IteratorException.<init>(String, Throwable)",
      "void IteratorException.<init>(Throwable)"})
  void testNewIteratorException_whenAnErrorOccurred_thenReturnMessageIsAnErrorOccurred() {
    // Arrange
    Throwable e = new Throwable();

    // Act
    IteratorException actualIteratorException = new IteratorException("An error occurred", e);

    // Assert
    assertEquals("An error occurred", actualIteratorException.getMessage());
    assertEquals(0, actualIteratorException.getSuppressed().length);
    assertSame(e, actualIteratorException.getCause());
  }

  /**
   * Test {@link IteratorException#IteratorException(Throwable)}.
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.</li>
   *   <li>Then return Message is {@code Throwable}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IteratorException#IteratorException(Throwable)}
   */
  @Test
  @DisplayName("Test new IteratorException(Throwable); when Throwable(); then return Message is 'java.lang.Throwable'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void IteratorException.<init>(String)", "void IteratorException.<init>(String, Throwable)",
      "void IteratorException.<init>(Throwable)"})
  void testNewIteratorException_whenThrowable_thenReturnMessageIsJavaLangThrowable() {
    // Arrange
    Throwable e = new Throwable();

    // Act
    IteratorException actualIteratorException = new IteratorException(e);

    // Assert
    assertEquals("java.lang.Throwable", actualIteratorException.getMessage());
    assertEquals(0, actualIteratorException.getSuppressed().length);
    assertSame(e, actualIteratorException.getCause());
  }
}
