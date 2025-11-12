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
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.commonutil.iterable.CachingIterable;

class CloseableUtilDiffblueTest {
  /**
   * Method under test: {@link CloseableUtil#close(AutoCloseable)}
   */
  @Test
  void testClose() throws Exception {
    // Arrange
    AutoCloseable closeable = mock(AutoCloseable.class);
    doNothing().when(closeable).close();

    // Act
    CloseableUtil.close(closeable);

    // Assert that nothing has changed
    verify(closeable).close();
  }

  /**
   * Method under test: {@link CloseableUtil#close(Object)}
   */
  @Test
  void testClose2() {
    // Arrange
    CachingIterable<Object> cachingIterable = mock(CachingIterable.class);
    doNothing().when(cachingIterable).close();

    // Act
    CloseableUtil.close((Object) cachingIterable);

    // Assert
    verify(cachingIterable).close();
  }

  /**
   * Method under test: {@link CloseableUtil#close(AutoCloseable[])}
   */
  @Test
  void testClose3() throws Exception {
    // Arrange
    AutoCloseable autoCloseable = mock(AutoCloseable.class);
    doNothing().when(autoCloseable).close();

    // Act
    CloseableUtil.close(autoCloseable);

    // Assert that nothing has changed
    verify(autoCloseable).close();
  }

  /**
   * Method under test: {@link CloseableUtil#close(Object[])}
   */
  @Test
  void testClose4() {
    // Arrange
    CachingIterable<Object> cachingIterable = mock(CachingIterable.class);
    doNothing().when(cachingIterable).close();

    // Act
    CloseableUtil.close(cachingIterable);

    // Assert
    verify(cachingIterable).close();
  }
}
