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

package uk.gov.gchq.gaffer.commonutil;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class CloseableUtilDiffblueTest {
  /**
   * Test {@link CloseableUtil#close(AutoCloseable)} with {@code AutoCloseable}.
   *
   * <ul>
   *   <li>When {@link AutoCloseable} {@link AutoCloseable#close()} does nothing.
   *   <li>Then calls {@link AutoCloseable#close()}.
   * </ul>
   *
   * <p>Method under test: {@link CloseableUtil#close(AutoCloseable)}
   */
  @Test
  @DisplayName(
      "Test close(AutoCloseable) with 'AutoCloseable'; when AutoCloseable close() does nothing; then calls close()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CloseableUtil.close(AutoCloseable)"})
  void testCloseWithAutoCloseable_whenAutoCloseableCloseDoesNothing_thenCallsClose()
      throws Exception {
    // Arrange
    AutoCloseable closeable = mock(AutoCloseable.class);
    doNothing().when(closeable).close();

    // Act
    CloseableUtil.close(closeable);

    // Assert
    verify(closeable).close();
  }

  /**
   * Test {@link CloseableUtil#close(AutoCloseable[])} with {@code AutoCloseable[]}.
   *
   * <ul>
   *   <li>When {@link AutoCloseable} {@link AutoCloseable#close()} does nothing.
   *   <li>Then calls {@link AutoCloseable#close()}.
   * </ul>
   *
   * <p>Method under test: {@link CloseableUtil#close(AutoCloseable[])}
   */
  @Test
  @DisplayName(
      "Test close(AutoCloseable[]) with 'AutoCloseable[]'; when AutoCloseable close() does nothing; then calls close()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CloseableUtil.close(AutoCloseable[])"})
  void testCloseWithAutoCloseable_whenAutoCloseableCloseDoesNothing_thenCallsClose2()
      throws Exception {
    // Arrange
    AutoCloseable autoCloseable = mock(AutoCloseable.class);
    doNothing().when(autoCloseable).close();

    // Act
    CloseableUtil.close(autoCloseable);

    // Assert
    verify(autoCloseable).close();
  }
}
