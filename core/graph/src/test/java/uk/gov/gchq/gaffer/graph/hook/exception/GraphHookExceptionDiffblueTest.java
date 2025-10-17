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

package uk.gov.gchq.gaffer.graph.hook.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class GraphHookExceptionDiffblueTest {
  /**
   * Test {@link GraphHookException#GraphHookException(String)}.
   *
   * <ul>
   *   <li>When {@code An error occurred}.
   *   <li>Then return Cause is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link GraphHookException#GraphHookException(String)}
   */
  @Test
  @DisplayName(
      "Test new GraphHookException(String); when 'An error occurred'; then return Cause is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GraphHookException.<init>(String)",
    "void GraphHookException.<init>(String, Throwable)"
  })
  void testNewGraphHookException_whenAnErrorOccurred_thenReturnCauseIsNull() {
    // Arrange and Act
    GraphHookException actualGraphHookException = new GraphHookException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualGraphHookException.getMessage());
    assertNull(actualGraphHookException.getCause());
    assertEquals(0, actualGraphHookException.getSuppressed().length);
  }

  /**
   * Test {@link GraphHookException#GraphHookException(String, Throwable)}.
   *
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.
   *   <li>Then return Cause is {@link Throwable#Throwable()}.
   * </ul>
   *
   * <p>Method under test: {@link GraphHookException#GraphHookException(String, Throwable)}
   */
  @Test
  @DisplayName(
      "Test new GraphHookException(String, Throwable); when Throwable(); then return Cause is Throwable()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GraphHookException.<init>(String)",
    "void GraphHookException.<init>(String, Throwable)"
  })
  void testNewGraphHookException_whenThrowable_thenReturnCauseIsThrowable() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    GraphHookException actualGraphHookException =
        new GraphHookException("An error occurred", cause);

    // Assert
    assertEquals("An error occurred", actualGraphHookException.getMessage());
    assertEquals(0, actualGraphHookException.getSuppressed().length);
    assertSame(cause, actualGraphHookException.getCause());
  }
}
